package org.kobjects.xml;

import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import kotlin.io.ConstantsKt;
import kotlin.text.Typography;

public class XmlReader {
    static final int CDSECT = 5;
    public static final int END_DOCUMENT = 1;
    public static final int END_TAG = 3;
    static final int ENTITY_REF = 6;
    private static final int LEGACY = 999;
    public static final int START_DOCUMENT = 0;
    public static final int START_TAG = 2;
    public static final int TEXT = 4;
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    private String[] TYPES;
    private int attributeCount;
    private String[] attributes;
    private int column;
    private boolean degenerated;
    private int depth;
    private String[] elementStack = new String[4];
    private Hashtable entityMap;
    private boolean eof;
    private boolean isWhitespace;
    private int line;
    private String name;
    private int peek0;
    private int peek1;
    private Reader reader;
    public boolean relaxed;
    private char[] srcBuf;
    private int srcCount;
    private int srcPos;
    private String text;
    private char[] txtBuf;
    private int txtPos;
    private int type;

    private final int read() throws IOException {
        int r = this.peek0;
        int i = this.peek1;
        this.peek0 = i;
        if (i == -1) {
            this.eof = true;
            return r;
        }
        if (r == 10 || r == 13) {
            this.line++;
            this.column = 0;
            if (r == 13 && i == 10) {
                this.peek0 = 0;
            }
        }
        this.column++;
        if (this.srcPos >= this.srcCount) {
            Reader reader2 = this.reader;
            char[] cArr = this.srcBuf;
            int read = reader2.read(cArr, 0, cArr.length);
            this.srcCount = read;
            if (read <= 0) {
                this.peek1 = -1;
                return r;
            }
            this.srcPos = 0;
        }
        char[] cArr2 = this.srcBuf;
        int i2 = this.srcPos;
        this.srcPos = i2 + 1;
        this.peek1 = cArr2[i2];
        return r;
    }

    private final void exception(String desc) throws IOException {
        throw new IOException(desc + " pos: " + getPositionDescription());
    }

    private final void push(int c) {
        if (c != 0) {
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
    }

    private final void read(char c) throws IOException {
        if (read() == c) {
            return;
        }
        if (!this.relaxed) {
            exception("expected: '" + c + "'");
        } else if (c <= ' ') {
            skip();
            read();
        }
    }

    private final void skip() throws IOException {
        while (!this.eof && this.peek0 <= 32) {
            read();
        }
    }

    private final String pop(int pos) {
        String result = new String(this.txtBuf, pos, this.txtPos - pos);
        this.txtPos = pos;
        return result;
    }

    private final String readName() throws IOException {
        int pos = this.txtPos;
        int c = this.peek0;
        if ((c < 97 || c > 122) && ((c < 65 || c > 90) && c != 95 && c != 58 && !this.relaxed)) {
            exception("name expected");
        }
        while (true) {
            push(read());
            int c2 = this.peek0;
            if ((c2 < 97 || c2 > 122) && ((c2 < 65 || c2 > 90) && !((c2 >= 48 && c2 <= 57) || c2 == 95 || c2 == 45 || c2 == 58 || c2 == 46))) {
                return pop(pos);
            }
        }
    }

    private final void parseLegacy(boolean push) throws IOException {
        int term;
        String req = "";
        read();
        int c = read();
        if (c == 63) {
            term = 63;
        } else if (c != 33) {
            if (c != 91) {
                exception("cantreachme: " + c);
            }
            req = "CDATA[";
            term = 93;
        } else if (this.peek0 == 45) {
            req = "--";
            term = 45;
        } else {
            req = "DOCTYPE";
            term = -1;
        }
        for (int i = 0; i < req.length(); i++) {
            read(req.charAt(i));
        }
        if (term == -1) {
            parseDoctype();
            return;
        }
        while (true) {
            if (this.eof) {
                exception(UNEXPECTED_EOF);
            }
            int c2 = read();
            if (push) {
                push(c2);
            }
            if ((term == 63 || c2 == term) && this.peek0 == term && this.peek1 == 62) {
                break;
            }
        }
        read();
        read();
        if (push && term != 63) {
            pop(this.txtPos - 1);
        }
    }

    private final void parseDoctype() throws IOException {
        int nesting = 1;
        while (true) {
            int i = read();
            if (i == -1) {
                exception(UNEXPECTED_EOF);
            } else if (i != 60) {
                if (i == 62 && nesting - 1 == 0) {
                    return;
                }
            }
            nesting++;
        }
    }

    private final void parseEndTag() throws IOException {
        read();
        read();
        this.name = readName();
        if (this.depth == 0 && !this.relaxed) {
            exception("element stack empty");
        }
        if (this.name.equals(this.elementStack[this.depth - 1])) {
            this.depth--;
        } else if (!this.relaxed) {
            exception("expected: " + this.elementStack[this.depth]);
        }
        skip();
        read(Typography.greater);
    }

    private final int peekType() {
        int i = this.peek0;
        if (i == -1) {
            return 1;
        }
        if (i == 38) {
            return 6;
        }
        if (i != 60) {
            return 4;
        }
        int i2 = this.peek1;
        if (i2 == 33) {
            return LEGACY;
        }
        if (i2 == 47) {
            return 3;
        }
        if (i2 == 63) {
            return LEGACY;
        }
        if (i2 != 91) {
            return 2;
        }
        return 5;
    }

    private static final String[] ensureCapacity(String[] arr, int required) {
        if (arr.length >= required) {
            return arr;
        }
        String[] bigger = new String[(required + 16)];
        System.arraycopy(arr, 0, bigger, 0, arr.length);
        return bigger;
    }

    private final void parseStartTag() throws IOException {
        read();
        this.name = readName();
        String[] ensureCapacity = ensureCapacity(this.elementStack, this.depth + 1);
        this.elementStack = ensureCapacity;
        int i = this.depth;
        this.depth = i + 1;
        ensureCapacity[i] = this.name;
        while (true) {
            skip();
            int c = this.peek0;
            if (c == 47) {
                this.degenerated = true;
                read();
                skip();
                read(Typography.greater);
                return;
            } else if (c == 62) {
                read();
                return;
            } else {
                if (c == -1) {
                    exception(UNEXPECTED_EOF);
                }
                String attrName = readName();
                if (attrName.length() == 0) {
                    exception("attr name expected");
                }
                skip();
                read('=');
                skip();
                int delimiter = read();
                if (!(delimiter == 39 || delimiter == 34)) {
                    if (!this.relaxed) {
                        exception("<" + this.name + ">: invalid delimiter: " + ((char) delimiter));
                    }
                    delimiter = 32;
                }
                int i2 = this.attributeCount;
                this.attributeCount = i2 + 1;
                int i3 = i2 << 1;
                String[] ensureCapacity2 = ensureCapacity(this.attributes, i3 + 4);
                this.attributes = ensureCapacity2;
                int i4 = i3 + 1;
                ensureCapacity2[i3] = attrName;
                int p = this.txtPos;
                pushText(delimiter);
                this.attributes[i4] = pop(p);
                if (delimiter != 32) {
                    read();
                }
            }
        }
    }

    public final boolean pushEntity() throws IOException {
        read();
        int pos = this.txtPos;
        while (!this.eof && this.peek0 != 59) {
            push(read());
        }
        String code = pop(pos);
        read();
        if (code.length() <= 0 || code.charAt(0) != '#') {
            String result = (String) this.entityMap.get(code);
            boolean whitespace = true;
            if (result == null) {
                result = "&" + code + ";";
            }
            for (int i = 0; i < result.length(); i++) {
                char c = result.charAt(i);
                if (c > ' ') {
                    whitespace = false;
                }
                push(c);
            }
            return whitespace;
        }
        int c2 = code.charAt(1) == 'x' ? Integer.parseInt(code.substring(2), 16) : Integer.parseInt(code.substring(1));
        push(c2);
        if (c2 <= 32) {
            return true;
        }
        return false;
    }

    private final boolean pushText(int delimiter) throws IOException {
        boolean whitespace = true;
        int next = this.peek0;
        while (!this.eof && next != delimiter && (delimiter != 32 || (next > 32 && next != 62))) {
            if (next != 38) {
                if (next > 32) {
                    whitespace = false;
                }
                push(read());
            } else if (!pushEntity()) {
                whitespace = false;
            }
            next = this.peek0;
        }
        return whitespace;
    }

    public XmlReader(Reader reader2) throws IOException {
        this.srcBuf = new char[(Runtime.getRuntime().freeMemory() >= 1048576 ? ConstantsKt.DEFAULT_BUFFER_SIZE : 128)];
        this.txtBuf = new char[128];
        this.attributes = new String[16];
        this.TYPES = new String[]{"Start Document", "End Document", "Start Tag", "End Tag", "Text"};
        this.reader = reader2;
        this.peek0 = reader2.read();
        this.peek1 = reader2.read();
        this.eof = this.peek0 == -1;
        Hashtable hashtable = new Hashtable();
        this.entityMap = hashtable;
        hashtable.put("amp", "&");
        this.entityMap.put("apos", "'");
        this.entityMap.put("gt", ">");
        this.entityMap.put("lt", "<");
        this.entityMap.put("quot", "\"");
        this.line = 1;
        this.column = 1;
    }

    public void defineCharacterEntity(String entity, String value) {
        this.entityMap.put(entity, value);
    }

    public int getDepth() {
        return this.depth;
    }

    public String getPositionDescription() {
        int i = this.type;
        String[] strArr = this.TYPES;
        StringBuffer buf = new StringBuffer(i < strArr.length ? strArr[i] : "Other");
        buf.append(" @" + this.line + ":" + this.column + ": ");
        int i2 = this.type;
        if (i2 == 2 || i2 == 3) {
            buf.append(Typography.less);
            if (this.type == 3) {
                buf.append('/');
            }
            buf.append(this.name);
            buf.append(Typography.greater);
        } else if (this.isWhitespace) {
            buf.append("[whitespace]");
        } else {
            buf.append(getText());
        }
        return buf.toString();
    }

    public int getLineNumber() {
        return this.line;
    }

    public int getColumnNumber() {
        return this.column;
    }

    public boolean isWhitespace() {
        return this.isWhitespace;
    }

    public String getText() {
        if (this.text == null) {
            this.text = pop(0);
        }
        return this.text;
    }

    public String getName() {
        return this.name;
    }

    public boolean isEmptyElementTag() {
        return this.degenerated;
    }

    public int getAttributeCount() {
        return this.attributeCount;
    }

    public String getAttributeName(int index) {
        if (index < this.attributeCount) {
            return this.attributes[index << 1];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeValue(int index) {
        if (index < this.attributeCount) {
            return this.attributes[(index << 1) + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeValue(String name2) {
        for (int i = (this.attributeCount << 1) - 2; i >= 0; i -= 2) {
            if (this.attributes[i].equals(name2)) {
                return this.attributes[i + 1];
            }
        }
        return null;
    }

    public int getType() {
        return this.type;
    }

    public int next() throws IOException {
        boolean z = true;
        if (this.degenerated) {
            this.type = 3;
            this.degenerated = false;
            this.depth--;
            return 3;
        }
        this.txtPos = 0;
        this.isWhitespace = true;
        while (true) {
            this.attributeCount = 0;
            this.name = null;
            this.text = null;
            int peekType = peekType();
            this.type = peekType;
            switch (peekType) {
                case 1:
                    break;
                case 2:
                    parseStartTag();
                    break;
                case 3:
                    parseEndTag();
                    break;
                case 4:
                    this.isWhitespace &= pushText(60);
                    break;
                case 5:
                    parseLegacy(true);
                    this.isWhitespace = false;
                    this.type = 4;
                    break;
                case 6:
                    this.isWhitespace &= pushEntity();
                    this.type = 4;
                    break;
                default:
                    parseLegacy(false);
                    break;
            }
            int i = this.type;
            if (i > 4 || (i == 4 && peekType() >= 4)) {
            }
        }
        boolean z2 = this.isWhitespace;
        int i2 = this.type;
        if (i2 != 4) {
            z = false;
        }
        this.isWhitespace = z2 & z;
        return i2;
    }

    public void require(int type2, String name2) throws IOException {
        if (this.type == 4 && type2 != 4 && isWhitespace()) {
            next();
        }
        if (type2 != this.type || (name2 != null && !name2.equals(getName()))) {
            exception("expected: " + this.TYPES[type2] + "/" + name2);
        }
    }

    public String readText() throws IOException {
        if (this.type != 4) {
            return "";
        }
        String result = getText();
        next();
        return result;
    }
}
