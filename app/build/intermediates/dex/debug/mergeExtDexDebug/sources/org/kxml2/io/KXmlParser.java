package org.kxml2.io;

import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import kotlin.io.ConstantsKt;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KXmlParser implements XmlPullParser {
    private static final String ILLEGAL_TYPE = "Wrong event type";
    private static final int LEGACY = 999;
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    private static final int XML_DECL = 998;
    private int attributeCount;
    private String[] attributes;
    private int column;
    private boolean degenerated;
    private int depth;
    private String[] elementStack = new String[16];
    private String encoding;
    private Hashtable entityMap;
    private String error;
    private boolean isWhitespace;
    private int line;
    private Object location;
    private String name;
    private String namespace;
    private int[] nspCounts = new int[4];
    private String[] nspStack = new String[8];
    private int[] peek;
    private int peekCount;
    private String prefix;
    private boolean processNsp;
    private Reader reader;
    private boolean relaxed;
    private char[] srcBuf;
    private int srcCount;
    private int srcPos;
    private Boolean standalone;
    private boolean token;
    private char[] txtBuf;
    private int txtPos;
    private int type;
    private boolean unresolved;
    private String version;
    private boolean wasCR;

    public KXmlParser() {
        int i = 128;
        this.txtBuf = new char[128];
        this.attributes = new String[16];
        this.peek = new int[2];
        this.srcBuf = new char[(Runtime.getRuntime().freeMemory() >= 1048576 ? ConstantsKt.DEFAULT_BUFFER_SIZE : i)];
    }

    private final boolean isProp(String n1, boolean prop, String n2) {
        if (!n1.startsWith("http://xmlpull.org/v1/doc/")) {
            return false;
        }
        if (prop) {
            return n1.substring(42).equals(n2);
        }
        return n1.substring(40).equals(n2);
    }

    private final boolean adjustNsp() throws XmlPullParserException {
        int i;
        String prefix2;
        String attrName;
        boolean any = false;
        int i2 = 0;
        while (true) {
            i = this.attributeCount;
            if (i2 >= (i << 2)) {
                break;
            }
            String attrName2 = this.attributes[i2 + 2];
            int cut = attrName2.indexOf(58);
            if (cut != -1) {
                prefix2 = attrName2.substring(0, cut);
                attrName = attrName2.substring(cut + 1);
            } else if (attrName2.equals("xmlns")) {
                prefix2 = attrName2;
                attrName = null;
            } else {
                i2 += 4;
            }
            if (!prefix2.equals("xmlns")) {
                any = true;
            } else {
                int[] iArr = this.nspCounts;
                int i3 = this.depth;
                int i4 = iArr[i3];
                iArr[i3] = i4 + 1;
                int j = i4 << 1;
                String[] ensureCapacity = ensureCapacity(this.nspStack, j + 2);
                this.nspStack = ensureCapacity;
                ensureCapacity[j] = attrName;
                String[] strArr = this.attributes;
                ensureCapacity[j + 1] = strArr[i2 + 3];
                if (attrName != null && strArr[i2 + 3].equals("")) {
                    error("illegal empty namespace");
                }
                String[] strArr2 = this.attributes;
                int i5 = this.attributeCount - 1;
                this.attributeCount = i5;
                System.arraycopy(strArr2, i2 + 4, strArr2, i2, (i5 << 2) - i2);
                i2 -= 4;
            }
            i2 += 4;
        }
        if (any) {
            int i6 = (i << 2) - 4;
            while (i6 >= 0) {
                String attrName3 = this.attributes[i6 + 2];
                int cut2 = attrName3.indexOf(58);
                if (cut2 != 0 || this.relaxed) {
                    if (cut2 != -1) {
                        String attrPrefix = attrName3.substring(0, cut2);
                        String attrName4 = attrName3.substring(cut2 + 1);
                        String attrNs = getNamespace(attrPrefix);
                        if (attrNs != null || this.relaxed) {
                            String[] strArr3 = this.attributes;
                            strArr3[i6] = attrNs;
                            strArr3[i6 + 1] = attrPrefix;
                            strArr3[i6 + 2] = attrName4;
                        } else {
                            throw new RuntimeException("Undefined Prefix: " + attrPrefix + " in " + this);
                        }
                    }
                    i6 -= 4;
                } else {
                    throw new RuntimeException("illegal attribute name: " + attrName3 + " at " + this);
                }
            }
        }
        int cut3 = this.name.indexOf(58);
        if (cut3 == 0) {
            error("illegal tag name: " + this.name);
        }
        if (cut3 != -1) {
            this.prefix = this.name.substring(0, cut3);
            this.name = this.name.substring(cut3 + 1);
        }
        String namespace2 = getNamespace(this.prefix);
        this.namespace = namespace2;
        if (namespace2 == null) {
            if (this.prefix != null) {
                error("undefined prefix: " + this.prefix);
            }
            this.namespace = "";
        }
        return any;
    }

    private final String[] ensureCapacity(String[] arr, int required) {
        if (arr.length >= required) {
            return arr;
        }
        String[] bigger = new String[(required + 16)];
        System.arraycopy(arr, 0, bigger, 0, arr.length);
        return bigger;
    }

    private final void error(String desc) throws XmlPullParserException {
        if (!this.relaxed) {
            exception(desc);
        } else if (this.error == null) {
            this.error = "ERR: " + desc;
        }
    }

    private final void exception(String desc) throws XmlPullParserException {
        throw new XmlPullParserException(desc.length() < 100 ? desc : desc.substring(0, 100) + "\n", this, (Throwable) null);
    }

    private final void nextImpl() throws IOException, XmlPullParserException {
        int parseLegacy;
        if (this.reader == null) {
            exception("No Input specified");
        }
        if (this.type == 3) {
            this.depth--;
        }
        do {
            this.attributeCount = -1;
            if (this.degenerated) {
                this.degenerated = false;
                this.type = 3;
                return;
            } else if (this.error != null) {
                for (int i = 0; i < this.error.length(); i++) {
                    push(this.error.charAt(i));
                }
                this.error = null;
                this.type = 9;
                return;
            } else {
                this.prefix = null;
                this.name = null;
                this.namespace = null;
                int peekType = peekType();
                this.type = peekType;
                if (peekType == 1) {
                    return;
                }
                if (peekType == 2) {
                    parseStartTag(false);
                    return;
                } else if (peekType == 3) {
                    parseEndTag();
                    return;
                } else if (peekType == 4) {
                    pushText(60, !this.token);
                    if (this.depth == 0 && this.isWhitespace) {
                        this.type = 7;
                        return;
                    }
                    return;
                } else if (peekType != 6) {
                    parseLegacy = parseLegacy(this.token);
                    this.type = parseLegacy;
                } else {
                    pushEntity();
                    return;
                }
            }
        } while (parseLegacy == XML_DECL);
    }

    private final int parseLegacy(boolean push) throws IOException, XmlPullParserException {
        int result;
        int term;
        String req;
        boolean push2;
        int prev = 0;
        read();
        int c = read();
        if (c == 63) {
            if ((peek(0) == 120 || peek(0) == 88) && (peek(1) == 109 || peek(1) == 77)) {
                if (push) {
                    push(peek(0));
                    push(peek(1));
                }
                read();
                read();
                if ((peek(0) == 108 || peek(0) == 76) && peek(1) <= 32) {
                    if (this.line != 1 || this.column > 4) {
                        error("PI must not start with xml");
                    }
                    parseStartTag(true);
                    if (this.attributeCount < 1 || !"version".equals(this.attributes[2])) {
                        error("version expected");
                    }
                    String[] strArr = this.attributes;
                    this.version = strArr[3];
                    int pos = 1;
                    if (1 < this.attributeCount && "encoding".equals(strArr[6])) {
                        this.encoding = this.attributes[7];
                        pos = 1 + 1;
                    }
                    if (pos < this.attributeCount && "standalone".equals(this.attributes[(pos * 4) + 2])) {
                        String st = this.attributes[(pos * 4) + 3];
                        if ("yes".equals(st)) {
                            this.standalone = new Boolean(true);
                        } else if ("no".equals(st)) {
                            this.standalone = new Boolean(false);
                        } else {
                            error("illegal standalone value: " + st);
                        }
                        pos++;
                    }
                    if (pos != this.attributeCount) {
                        error("illegal xmldecl");
                    }
                    this.isWhitespace = true;
                    this.txtPos = 0;
                    return XML_DECL;
                }
            }
            term = 63;
            result = 8;
            push2 = push;
            req = "";
        } else if (c != 33) {
            error("illegal: <" + c);
            return 9;
        } else if (peek(0) == 45) {
            term = 45;
            result = 9;
            push2 = push;
            req = "--";
        } else if (peek(0) == 91) {
            term = 93;
            result = 5;
            push2 = true;
            req = "[CDATA[";
        } else {
            term = -1;
            result = 10;
            push2 = push;
            req = "DOCTYPE";
        }
        for (int i = 0; i < req.length(); i++) {
            read(req.charAt(i));
        }
        if (result == 10) {
            parseDoctype(push2);
        } else {
            while (true) {
                int c2 = read();
                if (c2 == -1) {
                    error(UNEXPECTED_EOF);
                    return 9;
                }
                if (push2) {
                    push(c2);
                }
                if ((term == 63 || c2 == term) && peek(0) == term && peek(1) == 62) {
                    if (term == 45 && prev == 45 && !this.relaxed) {
                        error("illegal comment delimiter: --->");
                    }
                    read();
                    read();
                    if (push2 && term != 63) {
                        this.txtPos--;
                    }
                } else {
                    prev = c2;
                }
            }
        }
        return result;
    }

    private final void parseDoctype(boolean push) throws IOException, XmlPullParserException {
        int nesting = 1;
        boolean quoted = false;
        while (true) {
            int i = read();
            if (i != -1) {
                if (i == 39) {
                    quoted = !quoted;
                } else if (i != 60) {
                    if (i == 62 && !quoted && nesting - 1 == 0) {
                        return;
                    }
                } else if (!quoted) {
                    nesting++;
                }
                if (push) {
                    push(i);
                }
            } else {
                error(UNEXPECTED_EOF);
                return;
            }
        }
    }

    private final void parseEndTag() throws IOException, XmlPullParserException {
        read();
        read();
        this.name = readName();
        skip();
        read(Typography.greater);
        int i = this.depth;
        int sp = (i - 1) << 2;
        if (i == 0) {
            error("element stack empty");
            this.type = 9;
        } else if (!this.relaxed) {
            if (!this.name.equals(this.elementStack[sp + 3])) {
                error("expected: /" + this.elementStack[sp + 3] + " read: " + this.name);
            }
            String[] strArr = this.elementStack;
            this.namespace = strArr[sp];
            this.prefix = strArr[sp + 1];
            this.name = strArr[sp + 2];
        }
    }

    private final int peekType() throws IOException {
        int peek2 = peek(0);
        if (peek2 == -1) {
            return 1;
        }
        if (peek2 == 38) {
            return 6;
        }
        if (peek2 != 60) {
            return 4;
        }
        int peek3 = peek(1);
        if (peek3 == 33) {
            return LEGACY;
        }
        if (peek3 == 47) {
            return 3;
        }
        if (peek3 != 63) {
            return 2;
        }
        return LEGACY;
    }

    private final String get(int pos) {
        return new String(this.txtBuf, pos, this.txtPos - pos);
    }

    private final void push(int c) {
        this.isWhitespace &= c <= 32;
        int i = this.txtPos;
        char[] cArr = this.txtBuf;
        if (i == cArr.length) {
            char[] bigger = new char[(((i * 4) / 3) + 4)];
            System.arraycopy(cArr, 0, bigger, 0, i);
            this.txtBuf = bigger;
        }
        char[] cArr2 = this.txtBuf;
        int i2 = this.txtPos;
        this.txtPos = i2 + 1;
        cArr2[i2] = (char) c;
    }

    private final void parseStartTag(boolean xmldecl) throws IOException, XmlPullParserException {
        if (!xmldecl) {
            read();
        }
        this.name = readName();
        this.attributeCount = 0;
        while (true) {
            skip();
            int c = peek(0);
            if (!xmldecl) {
                if (c != 47) {
                    if (c == 62 && !xmldecl) {
                        read();
                        break;
                    }
                } else {
                    this.degenerated = true;
                    read();
                    skip();
                    read(Typography.greater);
                    break;
                }
            } else if (c == 63) {
                read();
                read(Typography.greater);
                return;
            }
            if (c == -1) {
                error(UNEXPECTED_EOF);
                return;
            }
            String attrName = readName();
            if (attrName.length() == 0) {
                error("attr name expected");
                break;
            }
            int i = this.attributeCount;
            this.attributeCount = i + 1;
            int i2 = i << 2;
            String[] ensureCapacity = ensureCapacity(this.attributes, i2 + 4);
            this.attributes = ensureCapacity;
            int i3 = i2 + 1;
            ensureCapacity[i2] = "";
            int i4 = i3 + 1;
            ensureCapacity[i3] = null;
            int i5 = i4 + 1;
            ensureCapacity[i4] = attrName;
            skip();
            if (peek(0) != 61) {
                if (!this.relaxed) {
                    error("Attr.value missing f. " + attrName);
                }
                this.attributes[i5] = attrName;
            } else {
                read('=');
                skip();
                int delimiter = peek(0);
                if (delimiter == 39 || delimiter == 34) {
                    read();
                } else {
                    if (!this.relaxed) {
                        error("attr value delimiter missing!");
                    }
                    delimiter = 32;
                }
                int p = this.txtPos;
                pushText(delimiter, true);
                this.attributes[i5] = get(p);
                this.txtPos = p;
                if (delimiter != 32) {
                    read();
                }
            }
        }
        int c2 = this.depth;
        this.depth = c2 + 1;
        int sp = c2 << 2;
        String[] ensureCapacity2 = ensureCapacity(this.elementStack, sp + 4);
        this.elementStack = ensureCapacity2;
        ensureCapacity2[sp + 3] = this.name;
        int i6 = this.depth;
        int[] iArr = this.nspCounts;
        if (i6 >= iArr.length) {
            int[] bigger = new int[(i6 + 4)];
            System.arraycopy(iArr, 0, bigger, 0, iArr.length);
            this.nspCounts = bigger;
        }
        int[] iArr2 = this.nspCounts;
        int i7 = this.depth;
        iArr2[i7] = iArr2[i7 - 1];
        if (this.processNsp) {
            adjustNsp();
        } else {
            this.namespace = "";
        }
        String[] strArr = this.elementStack;
        strArr[sp] = this.namespace;
        strArr[sp + 1] = this.prefix;
        strArr[sp + 2] = this.name;
    }

    private final void pushEntity() throws IOException, XmlPullParserException {
        push(read());
        int pos = this.txtPos;
        while (true) {
            boolean z = false;
            int c = peek(0);
            if (c == 59) {
                read();
                String code = get(pos);
                this.txtPos = pos - 1;
                if (this.token && this.type == 6) {
                    this.name = code;
                }
                if (code.charAt(0) == '#') {
                    push(code.charAt(1) == 'x' ? Integer.parseInt(code.substring(2), 16) : Integer.parseInt(code.substring(1)));
                    return;
                }
                String result = (String) this.entityMap.get(code);
                if (result == null) {
                    z = true;
                }
                this.unresolved = z;
                if (!z) {
                    for (int i = 0; i < result.length(); i++) {
                        push(result.charAt(i));
                    }
                    return;
                } else if (!this.token) {
                    error("unresolved: &" + code + ";");
                    return;
                } else {
                    return;
                }
            } else if (c >= 128 || ((c >= 48 && c <= 57) || ((c >= 97 && c <= 122) || ((c >= 65 && c <= 90) || c == 95 || c == 45 || c == 35)))) {
                push(read());
            } else {
                if (!this.relaxed) {
                    error("unterminated entity ref");
                }
                System.out.println("broken entitiy: " + get(pos - 1));
                return;
            }
        }
    }

    private final void pushText(int delimiter, boolean resolveEntities) throws IOException, XmlPullParserException {
        int next = peek(0);
        int cbrCount = 0;
        while (next != -1 && next != delimiter) {
            if (delimiter != 32 || (next > 32 && next != 62)) {
                if (next == 38) {
                    if (resolveEntities) {
                        pushEntity();
                    } else {
                        return;
                    }
                } else if (next == 10 && this.type == 2) {
                    read();
                    push(32);
                } else {
                    push(read());
                }
                if (next == 62 && cbrCount >= 2 && delimiter != 93) {
                    error("Illegal: ]]>");
                }
                if (next == 93) {
                    cbrCount++;
                } else {
                    cbrCount = 0;
                }
                next = peek(0);
            } else {
                return;
            }
        }
    }

    private final void read(char c) throws IOException, XmlPullParserException {
        int a = read();
        if (a != c) {
            error("expected: '" + c + "' actual: '" + ((char) a) + "'");
        }
    }

    private final int read() throws IOException {
        int result;
        if (this.peekCount == 0) {
            result = peek(0);
        } else {
            int[] iArr = this.peek;
            int result2 = iArr[0];
            iArr[0] = iArr[1];
            result = result2;
        }
        this.peekCount--;
        this.column++;
        if (result == 10) {
            this.line++;
            this.column = 1;
        }
        return result;
    }

    private final int peek(int pos) throws IOException {
        int nw;
        int nw2;
        while (pos >= this.peekCount) {
            char[] cArr = this.srcBuf;
            if (cArr.length <= 1) {
                nw = this.reader.read();
            } else {
                int i = this.srcPos;
                if (i < this.srcCount) {
                    this.srcPos = i + 1;
                    nw = cArr[i];
                } else {
                    int read = this.reader.read(cArr, 0, cArr.length);
                    this.srcCount = read;
                    if (read <= 0) {
                        nw2 = -1;
                    } else {
                        nw2 = this.srcBuf[0];
                    }
                    this.srcPos = 1;
                    nw = nw2;
                }
            }
            if (nw == 13) {
                this.wasCR = true;
                int[] iArr = this.peek;
                int i2 = this.peekCount;
                this.peekCount = i2 + 1;
                iArr[i2] = 10;
            } else {
                if (nw != 10) {
                    int[] iArr2 = this.peek;
                    int i3 = this.peekCount;
                    this.peekCount = i3 + 1;
                    iArr2[i3] = nw;
                } else if (!this.wasCR) {
                    int[] iArr3 = this.peek;
                    int i4 = this.peekCount;
                    this.peekCount = i4 + 1;
                    iArr3[i4] = 10;
                }
                this.wasCR = false;
            }
        }
        return this.peek[pos];
    }

    private final String readName() throws IOException, XmlPullParserException {
        int pos = this.txtPos;
        int c = peek(0);
        if ((c < 97 || c > 122) && ((c < 65 || c > 90) && c != 95 && c != 58 && c < 192 && !this.relaxed)) {
            error("name expected");
        }
        while (true) {
            push(read());
            int c2 = peek(0);
            if ((c2 < 97 || c2 > 122) && ((c2 < 65 || c2 > 90) && !((c2 >= 48 && c2 <= 57) || c2 == 95 || c2 == 45 || c2 == 58 || c2 == 46 || c2 >= 183))) {
                String result = get(pos);
                this.txtPos = pos;
                return result;
            }
        }
    }

    private final void skip() throws IOException {
        while (true) {
            int c = peek(0);
            if (c <= 32 && c != -1) {
                read();
            } else {
                return;
            }
        }
    }

    public void setInput(Reader reader2) throws XmlPullParserException {
        this.reader = reader2;
        this.line = 1;
        this.column = 0;
        this.type = 0;
        this.name = null;
        this.namespace = null;
        this.degenerated = false;
        this.attributeCount = -1;
        this.encoding = null;
        this.version = null;
        this.standalone = null;
        if (reader2 != null) {
            this.srcPos = 0;
            this.srcCount = 0;
            this.peekCount = 0;
            this.depth = 0;
            Hashtable hashtable = new Hashtable();
            this.entityMap = hashtable;
            hashtable.put("amp", "&");
            this.entityMap.put("apos", "'");
            this.entityMap.put("gt", ">");
            this.entityMap.put("lt", "<");
            this.entityMap.put("quot", "\"");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r6 = r17.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        if (r6 != -1) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r10 = r1.srcBuf;
        r11 = r1.srcCount;
        r1.srcCount = r11 + 1;
        r10[r11] = (char) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005b, code lost:
        if (r6 != 62) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        r10 = new java.lang.String(r1.srcBuf, 0, r1.srcCount);
        r11 = r10.indexOf("encoding");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
        if (r11 == -1) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0074, code lost:
        if (r10.charAt(r11) == '\"') goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        if (r10.charAt(r11) == '\'') goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007e, code lost:
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0081, code lost:
        r8 = r11 + 1;
        r3 = r10.substring(r8, r10.indexOf(r10.charAt(r11), r8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c6, code lost:
        if ((r5 & -65536) != -16842752) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c8, code lost:
        r3 = "UTF-16BE";
        r6 = r1.srcBuf;
        r6[0] = (char) ((r6[2] << 8) | r6[3]);
        r1.srcCount = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00db, code lost:
        if ((-65536 & r5) != -131072) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00dd, code lost:
        r3 = "UTF-16LE";
        r6 = r1.srcBuf;
        r6[0] = (char) ((r6[3] << 8) | r6[2]);
        r1.srcCount = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f2, code lost:
        if ((r5 & -256) != -272908544) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f4, code lost:
        r3 = "UTF-8";
        r6 = r1.srcBuf;
        r6[0] = r6[3];
        r1.srcCount = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setInput(java.io.InputStream r17, java.lang.String r18) throws org.xmlpull.v1.XmlPullParserException {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r0 = 0
            r1.srcPos = r0
            r1.srcCount = r0
            r3 = r18
            if (r2 == 0) goto L_0x0135
            java.lang.String r4 = "UTF-8"
            if (r3 != 0) goto L_0x00fd
            r5 = 0
        L_0x0012:
            int r6 = r1.srcCount     // Catch:{ Exception -> 0x0115 }
            r7 = 4
            r8 = -1
            if (r6 >= r7) goto L_0x002f
            int r6 = r17.read()     // Catch:{ Exception -> 0x0115 }
            if (r6 != r8) goto L_0x001f
            goto L_0x002f
        L_0x001f:
            int r7 = r5 << 8
            r5 = r7 | r6
            char[] r7 = r1.srcBuf     // Catch:{ Exception -> 0x0115 }
            int r8 = r1.srcCount     // Catch:{ Exception -> 0x0115 }
            int r9 = r8 + 1
            r1.srcCount = r9     // Catch:{ Exception -> 0x0115 }
            char r9 = (char) r6     // Catch:{ Exception -> 0x0115 }
            r7[r8] = r9     // Catch:{ Exception -> 0x0115 }
            goto L_0x0012
        L_0x002f:
            int r6 = r1.srcCount     // Catch:{ Exception -> 0x0115 }
            if (r6 != r7) goto L_0x00fd
            r6 = 63
            java.lang.String r7 = "UTF-16LE"
            java.lang.String r9 = "UTF-16BE"
            java.lang.String r10 = "UTF-32BE"
            java.lang.String r11 = "UTF-32LE"
            r12 = 2
            r13 = 60
            r14 = 1
            switch(r5) {
                case -131072: goto L_0x00bb;
                case 60: goto L_0x00b3;
                case 65279: goto L_0x00af;
                case 3932223: goto L_0x00a5;
                case 1006632960: goto L_0x009d;
                case 1006649088: goto L_0x0092;
                case 1010792557: goto L_0x0046;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x00bf
        L_0x0046:
            int r6 = r17.read()     // Catch:{ Exception -> 0x0115 }
            if (r6 != r8) goto L_0x004e
            goto L_0x00bf
        L_0x004e:
            char[] r10 = r1.srcBuf     // Catch:{ Exception -> 0x0115 }
            int r11 = r1.srcCount     // Catch:{ Exception -> 0x0115 }
            int r13 = r11 + 1
            r1.srcCount = r13     // Catch:{ Exception -> 0x0115 }
            char r13 = (char) r6     // Catch:{ Exception -> 0x0115 }
            r10[r11] = r13     // Catch:{ Exception -> 0x0115 }
            r10 = 62
            if (r6 != r10) goto L_0x0091
            java.lang.String r10 = new java.lang.String     // Catch:{ Exception -> 0x0115 }
            char[] r11 = r1.srcBuf     // Catch:{ Exception -> 0x0115 }
            int r13 = r1.srcCount     // Catch:{ Exception -> 0x0115 }
            r10.<init>(r11, r0, r13)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r11 = "encoding"
            int r11 = r10.indexOf(r11)     // Catch:{ Exception -> 0x0115 }
            if (r11 == r8) goto L_0x00bf
        L_0x006e:
            char r8 = r10.charAt(r11)     // Catch:{ Exception -> 0x0115 }
            r13 = 34
            if (r8 == r13) goto L_0x0081
            char r8 = r10.charAt(r11)     // Catch:{ Exception -> 0x0115 }
            r13 = 39
            if (r8 == r13) goto L_0x0081
            int r11 = r11 + 1
            goto L_0x006e
        L_0x0081:
            int r8 = r11 + 1
            char r11 = r10.charAt(r11)     // Catch:{ Exception -> 0x0115 }
            int r13 = r10.indexOf(r11, r8)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r15 = r10.substring(r8, r13)     // Catch:{ Exception -> 0x0115 }
            r3 = r15
            goto L_0x00bf
        L_0x0091:
            goto L_0x0046
        L_0x0092:
            r3 = r7
            char[] r7 = r1.srcBuf     // Catch:{ Exception -> 0x0115 }
            r7[r0] = r13     // Catch:{ Exception -> 0x0115 }
            r7[r14] = r6     // Catch:{ Exception -> 0x0115 }
            r1.srcCount = r12     // Catch:{ Exception -> 0x0115 }
            goto L_0x00fd
        L_0x009d:
            r3 = r11
            char[] r6 = r1.srcBuf     // Catch:{ Exception -> 0x0115 }
            r6[r0] = r13     // Catch:{ Exception -> 0x0115 }
            r1.srcCount = r14     // Catch:{ Exception -> 0x0115 }
            goto L_0x00fd
        L_0x00a5:
            r3 = r9
            char[] r7 = r1.srcBuf     // Catch:{ Exception -> 0x0115 }
            r7[r0] = r13     // Catch:{ Exception -> 0x0115 }
            r7[r14] = r6     // Catch:{ Exception -> 0x0115 }
            r1.srcCount = r12     // Catch:{ Exception -> 0x0115 }
            goto L_0x00fd
        L_0x00af:
            r3 = r10
            r1.srcCount = r0     // Catch:{ Exception -> 0x0115 }
            goto L_0x00fd
        L_0x00b3:
            r3 = r10
            char[] r6 = r1.srcBuf     // Catch:{ Exception -> 0x0115 }
            r6[r0] = r13     // Catch:{ Exception -> 0x0115 }
            r1.srcCount = r14     // Catch:{ Exception -> 0x0115 }
            goto L_0x00fd
        L_0x00bb:
            r3 = r11
            r1.srcCount = r0     // Catch:{ Exception -> 0x0115 }
            goto L_0x00fd
        L_0x00bf:
            r6 = -65536(0xffffffffffff0000, float:NaN)
            r8 = r5 & r6
            r10 = -16842752(0xfffffffffeff0000, float:-1.6947657E38)
            r11 = 3
            if (r8 != r10) goto L_0x00d8
            r3 = r9
            char[] r6 = r1.srcBuf     // Catch:{ Exception -> 0x0115 }
            char r7 = r6[r12]     // Catch:{ Exception -> 0x0115 }
            int r7 = r7 << 8
            char r8 = r6[r11]     // Catch:{ Exception -> 0x0115 }
            r7 = r7 | r8
            char r7 = (char) r7     // Catch:{ Exception -> 0x0115 }
            r6[r0] = r7     // Catch:{ Exception -> 0x0115 }
            r1.srcCount = r14     // Catch:{ Exception -> 0x0115 }
            goto L_0x00fd
        L_0x00d8:
            r6 = r6 & r5
            r8 = -131072(0xfffffffffffe0000, float:NaN)
            if (r6 != r8) goto L_0x00ed
            r3 = r7
            char[] r6 = r1.srcBuf     // Catch:{ Exception -> 0x0115 }
            char r7 = r6[r11]     // Catch:{ Exception -> 0x0115 }
            int r7 = r7 << 8
            char r8 = r6[r12]     // Catch:{ Exception -> 0x0115 }
            r7 = r7 | r8
            char r7 = (char) r7     // Catch:{ Exception -> 0x0115 }
            r6[r0] = r7     // Catch:{ Exception -> 0x0115 }
            r1.srcCount = r14     // Catch:{ Exception -> 0x0115 }
            goto L_0x00fd
        L_0x00ed:
            r6 = r5 & -256(0xffffffffffffff00, float:NaN)
            r7 = -272908544(0xffffffffefbbbf00, float:-1.162092E29)
            if (r6 != r7) goto L_0x00fd
            r3 = r4
            char[] r6 = r1.srcBuf     // Catch:{ Exception -> 0x0115 }
            char r7 = r6[r11]     // Catch:{ Exception -> 0x0115 }
            r6[r0] = r7     // Catch:{ Exception -> 0x0115 }
            r1.srcCount = r14     // Catch:{ Exception -> 0x0115 }
        L_0x00fd:
            if (r3 != 0) goto L_0x0101
            r0 = r4
            r3 = r0
        L_0x0101:
            int r0 = r1.srcCount     // Catch:{ Exception -> 0x0115 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0115 }
            r4.<init>(r2, r3)     // Catch:{ Exception -> 0x0115 }
            r1.setInput(r4)     // Catch:{ Exception -> 0x0115 }
            r4 = r18
            r1.encoding = r4     // Catch:{ Exception -> 0x0113 }
            r1.srcCount = r0     // Catch:{ Exception -> 0x0113 }
            return
        L_0x0113:
            r0 = move-exception
            goto L_0x0118
        L_0x0115:
            r0 = move-exception
            r4 = r18
        L_0x0118:
            org.xmlpull.v1.XmlPullParserException r5 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Invalid stream or encoding: "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6, r1, r0)
            throw r5
        L_0x0135:
            r4 = r18
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.io.KXmlParser.setInput(java.io.InputStream, java.lang.String):void");
    }

    public boolean getFeature(String feature) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature)) {
            return this.processNsp;
        }
        if (isProp(feature, false, "relaxed")) {
            return this.relaxed;
        }
        return false;
    }

    public String getInputEncoding() {
        return this.encoding;
    }

    public void defineEntityReplacementText(String entity, String value) throws XmlPullParserException {
        Hashtable hashtable = this.entityMap;
        if (hashtable != null) {
            hashtable.put(entity, value);
            return;
        }
        throw new RuntimeException("entity replacement text must be defined after setInput!");
    }

    public Object getProperty(String property) {
        if (isProp(property, true, "xmldecl-version")) {
            return this.version;
        }
        if (isProp(property, true, "xmldecl-standalone")) {
            return this.standalone;
        }
        if (!isProp(property, true, "location")) {
            return null;
        }
        Object obj = this.location;
        return obj != null ? obj : this.reader.toString();
    }

    public int getNamespaceCount(int depth2) {
        if (depth2 <= this.depth) {
            return this.nspCounts[depth2];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getNamespacePrefix(int pos) {
        return this.nspStack[pos << 1];
    }

    public String getNamespaceUri(int pos) {
        return this.nspStack[(pos << 1) + 1];
    }

    public String getNamespace(String prefix2) {
        if ("xml".equals(prefix2)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if ("xmlns".equals(prefix2)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (int i = (getNamespaceCount(this.depth) << 1) - 2; i >= 0; i -= 2) {
            if (prefix2 == null) {
                String[] strArr = this.nspStack;
                if (strArr[i] == null) {
                    return strArr[i + 1];
                }
            } else if (prefix2.equals(this.nspStack[i])) {
                return this.nspStack[i + 1];
            }
        }
        return null;
    }

    public int getDepth() {
        return this.depth;
    }

    public String getPositionDescription() {
        StringBuffer buf = new StringBuffer(this.type < TYPES.length ? TYPES[this.type] : "unknown");
        buf.append(' ');
        int i = this.type;
        if (i == 2 || i == 3) {
            if (this.degenerated) {
                buf.append("(empty) ");
            }
            buf.append(Typography.less);
            if (this.type == 3) {
                buf.append('/');
            }
            if (this.prefix != null) {
                buf.append("{" + this.namespace + "}" + this.prefix + ":");
            }
            buf.append(this.name);
            int cnt = this.attributeCount << 2;
            for (int i2 = 0; i2 < cnt; i2 += 4) {
                buf.append(' ');
                if (this.attributes[i2 + 1] != null) {
                    buf.append("{" + this.attributes[i2] + "}" + this.attributes[i2 + 1] + ":");
                }
                buf.append(this.attributes[i2 + 2] + "='" + this.attributes[i2 + 3] + "'");
            }
            buf.append(Typography.greater);
        } else if (i != 7) {
            if (i != 4) {
                buf.append(getText());
            } else if (this.isWhitespace) {
                buf.append("(whitespace)");
            } else {
                String text = getText();
                if (text.length() > 16) {
                    text = text.substring(0, 16) + "...";
                }
                buf.append(text);
            }
        }
        buf.append("@" + this.line + ":" + this.column);
        if (this.location != null) {
            buf.append(" in ");
            buf.append(this.location);
        } else if (this.reader != null) {
            buf.append(" in ");
            buf.append(this.reader.toString());
        }
        return buf.toString();
    }

    public int getLineNumber() {
        return this.line;
    }

    public int getColumnNumber() {
        return this.column;
    }

    public boolean isWhitespace() throws XmlPullParserException {
        int i = this.type;
        if (!(i == 4 || i == 7 || i == 5)) {
            exception(ILLEGAL_TYPE);
        }
        return this.isWhitespace;
    }

    public String getText() {
        int i = this.type;
        if (i < 4 || (i == 6 && this.unresolved)) {
            return null;
        }
        return get(0);
    }

    public char[] getTextCharacters(int[] poslen) {
        int i = this.type;
        if (i < 4) {
            poslen[0] = -1;
            poslen[1] = -1;
            return null;
        } else if (i == 6) {
            poslen[0] = 0;
            poslen[1] = this.name.length();
            return this.name.toCharArray();
        } else {
            poslen[0] = 0;
            poslen[1] = this.txtPos;
            return this.txtBuf;
        }
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getName() {
        return this.name;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean isEmptyElementTag() throws XmlPullParserException {
        if (this.type != 2) {
            exception(ILLEGAL_TYPE);
        }
        return this.degenerated;
    }

    public int getAttributeCount() {
        return this.attributeCount;
    }

    public String getAttributeType(int index) {
        return "CDATA";
    }

    public boolean isAttributeDefault(int index) {
        return false;
    }

    public String getAttributeNamespace(int index) {
        if (index < this.attributeCount) {
            return this.attributes[index << 2];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeName(int index) {
        if (index < this.attributeCount) {
            return this.attributes[(index << 2) + 2];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributePrefix(int index) {
        if (index < this.attributeCount) {
            return this.attributes[(index << 2) + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeValue(int index) {
        if (index < this.attributeCount) {
            return this.attributes[(index << 2) + 3];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeValue(String namespace2, String name2) {
        for (int i = (this.attributeCount << 2) - 4; i >= 0; i -= 4) {
            if (this.attributes[i + 2].equals(name2) && (namespace2 == null || this.attributes[i].equals(namespace2))) {
                return this.attributes[i + 3];
            }
        }
        return null;
    }

    public int getEventType() throws XmlPullParserException {
        return this.type;
    }

    public int next() throws XmlPullParserException, IOException {
        this.txtPos = 0;
        this.isWhitespace = true;
        int minType = 9999;
        this.token = false;
        while (true) {
            nextImpl();
            if (this.type < minType) {
                minType = this.type;
            }
            if (minType > 6 || (minType >= 4 && peekType() >= 4)) {
            }
        }
        this.type = minType;
        if (minType > 4) {
            this.type = 4;
        }
        return this.type;
    }

    public int nextToken() throws XmlPullParserException, IOException {
        this.isWhitespace = true;
        this.txtPos = 0;
        this.token = true;
        nextImpl();
        return this.type;
    }

    public int nextTag() throws XmlPullParserException, IOException {
        next();
        if (this.type == 4 && this.isWhitespace) {
            next();
        }
        int i = this.type;
        if (!(i == 3 || i == 2)) {
            exception("unexpected type");
        }
        return this.type;
    }

    public void require(int type2, String namespace2, String name2) throws XmlPullParserException, IOException {
        if (type2 != this.type || ((namespace2 != null && !namespace2.equals(getNamespace())) || (name2 != null && !name2.equals(getName())))) {
            exception("expected: " + TYPES[type2] + " {" + namespace2 + "}" + name2);
        }
    }

    public String nextText() throws XmlPullParserException, IOException {
        String result;
        if (this.type != 2) {
            exception("precondition: START_TAG");
        }
        next();
        if (this.type == 4) {
            result = getText();
            next();
        } else {
            result = "";
        }
        if (this.type != 3) {
            exception("END_TAG expected");
        }
        return result;
    }

    public void setFeature(String feature, boolean value) throws XmlPullParserException {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature)) {
            this.processNsp = value;
        } else if (isProp(feature, false, "relaxed")) {
            this.relaxed = value;
        } else {
            exception("unsupported feature: " + feature);
        }
    }

    public void setProperty(String property, Object value) throws XmlPullParserException {
        if (isProp(property, true, "location")) {
            this.location = value;
            return;
        }
        throw new XmlPullParserException("unsupported property: " + property);
    }

    public void skipSubTree() throws XmlPullParserException, IOException {
        require(2, (String) null, (String) null);
        int level = 1;
        while (level > 0) {
            int eventType = next();
            if (eventType == 3) {
                level--;
            } else if (eventType == 2) {
                level++;
            }
        }
    }
}
