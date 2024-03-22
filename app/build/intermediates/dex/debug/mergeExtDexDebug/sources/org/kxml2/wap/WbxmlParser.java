package org.kxml2.wap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import kotlin.text.Typography;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class WbxmlParser implements XmlPullParser {
    static final String HEX_DIGITS = "0123456789abcdef";
    private static final String ILLEGAL_TYPE = "Wrong event type";
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    public static final int WAP_EXTENSION = 64;
    private int ATTR_START_TABLE = 1;
    private int ATTR_VALUE_TABLE = 2;
    private int TAG_TABLE = 0;
    private String[] attrStartTable;
    private String[] attrValueTable;
    private int attributeCount;
    private String[] attributes = new String[16];
    private Hashtable cacheStringTable = null;
    private boolean degenerated;
    private int depth;
    private String[] elementStack = new String[16];
    private String encoding;
    private InputStream in;
    private boolean isWhitespace;
    private String name;
    private String namespace;
    private int nextId = -2;
    private int[] nspCounts = new int[4];
    private String[] nspStack = new String[8];
    private String prefix;
    private boolean processNsp;
    private int publicIdentifierId;
    private byte[] stringTable;
    private Vector tables = new Vector();
    private String[] tagTable;
    private String text;
    private int type;
    private int version;
    private int wapCode;
    private Object wapExtensionData;

    public boolean getFeature(String feature) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature)) {
            return this.processNsp;
        }
        return false;
    }

    public String getInputEncoding() {
        return this.encoding;
    }

    public void defineEntityReplacementText(String entity, String value) throws XmlPullParserException {
    }

    public Object getProperty(String property) {
        return null;
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
                String text2 = getText();
                if (text2.length() > 16) {
                    text2 = text2.substring(0, 16) + "...";
                }
                buf.append(text2);
            }
        }
        return buf.toString();
    }

    public int getLineNumber() {
        return -1;
    }

    public int getColumnNumber() {
        return -1;
    }

    public boolean isWhitespace() throws XmlPullParserException {
        int i = this.type;
        if (!(i == 4 || i == 7 || i == 5)) {
            exception(ILLEGAL_TYPE);
        }
        return this.isWhitespace;
    }

    public String getText() {
        return this.text;
    }

    public char[] getTextCharacters(int[] poslen) {
        if (this.type >= 4) {
            poslen[0] = 0;
            poslen[1] = this.text.length();
            char[] buf = new char[this.text.length()];
            String str = this.text;
            str.getChars(0, str.length(), buf, 0);
            return buf;
        }
        poslen[0] = -1;
        poslen[1] = -1;
        return null;
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
        this.isWhitespace = true;
        int minType = 9999;
        while (true) {
            String save = this.text;
            nextImpl();
            if (this.type < minType) {
                minType = this.type;
            }
            if (minType <= 5) {
                if (minType >= 4) {
                    if (save != null) {
                        this.text = this.text == null ? save : save + this.text;
                    }
                    int peekId = peekId();
                    if (!(peekId == 2 || peekId == 3 || peekId == 4 || peekId == 68 || peekId == 196 || peekId == 131 || peekId == 132)) {
                        break;
                    }
                } else {
                    break;
                }
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

    public void require(int type2, String namespace2, String name2) throws XmlPullParserException, IOException {
        if (type2 != this.type || ((namespace2 != null && !namespace2.equals(getNamespace())) || (name2 != null && !name2.equals(getName())))) {
            exception("expected: " + (type2 == 64 ? "WAP Ext." : TYPES[type2] + " {" + namespace2 + "}" + name2));
        }
    }

    public void setInput(Reader reader) throws XmlPullParserException {
        exception("InputStream required");
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    public void setInput(InputStream in2, String enc) throws XmlPullParserException {
        this.in = in2;
        try {
            this.version = readByte();
            int readInt = readInt();
            this.publicIdentifierId = readInt;
            if (readInt == 0) {
                readInt();
            }
            int charset = readInt();
            if (enc != null) {
                this.encoding = enc;
            } else if (charset == 4) {
                this.encoding = "ISO-8859-1";
            } else if (charset == 106) {
                this.encoding = "UTF-8";
            } else {
                throw new UnsupportedEncodingException("" + charset);
            }
            int strTabSize = readInt();
            this.stringTable = new byte[strTabSize];
            int ok = 0;
            while (true) {
                if (ok >= strTabSize) {
                    break;
                }
                int cnt = in2.read(this.stringTable, ok, strTabSize - ok);
                if (cnt <= 0) {
                    break;
                }
                ok += cnt;
            }
            selectPage(0, true);
            selectPage(0, false);
        } catch (IOException e) {
            exception("Illegal input format");
        }
    }

    public void setFeature(String feature, boolean value) throws XmlPullParserException {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(feature)) {
            this.processNsp = value;
        } else {
            exception("unsupported feature: " + feature);
        }
    }

    public void setProperty(String property, Object value) throws XmlPullParserException {
        throw new XmlPullParserException("unsupported property: " + property);
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
                    exception("illegal empty namespace");
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
                if (cut2 != 0) {
                    if (cut2 != -1) {
                        String attrPrefix = attrName3.substring(0, cut2);
                        String attrName4 = attrName3.substring(cut2 + 1);
                        String attrNs = getNamespace(attrPrefix);
                        if (attrNs != null) {
                            String[] strArr3 = this.attributes;
                            strArr3[i6] = attrNs;
                            strArr3[i6 + 1] = attrPrefix;
                            strArr3[i6 + 2] = attrName4;
                            for (int j2 = (this.attributeCount << 2) - 4; j2 > i6; j2 -= 4) {
                                if (attrName4.equals(this.attributes[j2 + 2]) && attrNs.equals(this.attributes[j2])) {
                                    exception("Duplicate Attribute: {" + attrNs + "}" + attrName4);
                                }
                            }
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
            exception("illegal tag name: " + this.name);
        } else if (cut3 != -1) {
            this.prefix = this.name.substring(0, cut3);
            this.name = this.name.substring(cut3 + 1);
        }
        String namespace2 = getNamespace(this.prefix);
        this.namespace = namespace2;
        if (namespace2 == null) {
            if (this.prefix != null) {
                exception("undefined prefix: " + this.prefix);
            }
            this.namespace = "";
        }
        return any;
    }

    private final void setTable(int page, int type2, String[] table) {
        if (this.stringTable == null) {
            while (this.tables.size() < (page * 3) + 3) {
                this.tables.addElement((Object) null);
            }
            this.tables.setElementAt(table, (page * 3) + type2);
            return;
        }
        throw new RuntimeException("setXxxTable must be called before setInput!");
    }

    private final void exception(String desc) throws XmlPullParserException {
        throw new XmlPullParserException(desc, this, (Throwable) null);
    }

    private void selectPage(int nr, boolean tags) throws XmlPullParserException {
        if (this.tables.size() != 0 || nr != 0) {
            if (nr * 3 > this.tables.size()) {
                exception("Code Page " + nr + " undefined!");
            }
            if (tags) {
                this.tagTable = (String[]) this.tables.elementAt((nr * 3) + this.TAG_TABLE);
                return;
            }
            this.attrStartTable = (String[]) this.tables.elementAt((nr * 3) + this.ATTR_START_TABLE);
            this.attrValueTable = (String[]) this.tables.elementAt((nr * 3) + this.ATTR_VALUE_TABLE);
        }
    }

    private final void nextImpl() throws IOException, XmlPullParserException {
        if (this.type == 3) {
            this.depth--;
        }
        if (this.degenerated) {
            this.type = 3;
            this.degenerated = false;
            return;
        }
        this.text = null;
        this.prefix = null;
        this.name = null;
        int id = peekId();
        while (id == 0) {
            this.nextId = -2;
            selectPage(readByte(), true);
            id = peekId();
        }
        this.nextId = -2;
        if (id == -1) {
            this.type = 1;
        } else if (id == 1) {
            int sp = (this.depth - 1) << 2;
            this.type = 3;
            String[] strArr = this.elementStack;
            this.namespace = strArr[sp];
            this.prefix = strArr[sp + 1];
            this.name = strArr[sp + 2];
        } else if (id == 2) {
            this.type = 6;
            char c = (char) readInt();
            this.text = "" + c;
            this.name = "#" + c;
        } else if (id != 3) {
            switch (id) {
                case 64:
                case 65:
                case Wbxml.EXT_I_2:
                    break;
                case Wbxml.PI:
                    throw new RuntimeException("PI curr. not supp.");
                default:
                    switch (id) {
                        case 128:
                        case Wbxml.EXT_T_1:
                        case Wbxml.EXT_T_2:
                            break;
                        case Wbxml.STR_T:
                            this.type = 4;
                            this.text = readStrT();
                            return;
                        default:
                            switch (id) {
                                case Wbxml.EXT_0:
                                case Wbxml.EXT_1:
                                case Wbxml.EXT_2:
                                case Wbxml.OPAQUE:
                                    break;
                                default:
                                    parseElement(id);
                                    return;
                            }
                    }
            }
            this.type = 64;
            this.wapCode = id;
            this.wapExtensionData = parseWapExtension(id);
        } else {
            this.type = 4;
            this.text = readStrI();
        }
    }

    public Object parseWapExtension(int id) throws IOException, XmlPullParserException {
        switch (id) {
            case 64:
            case 65:
            case Wbxml.EXT_I_2:
                return readStrI();
            default:
                switch (id) {
                    case 128:
                    case Wbxml.EXT_T_1:
                    case Wbxml.EXT_T_2:
                        return new Integer(readInt());
                    default:
                        switch (id) {
                            case Wbxml.EXT_0:
                            case Wbxml.EXT_1:
                            case Wbxml.EXT_2:
                                return null;
                            case Wbxml.OPAQUE:
                                int count = readInt();
                                byte[] buf = new byte[count];
                                while (count > 0) {
                                    count -= this.in.read(buf, buf.length - count, count);
                                }
                                return buf;
                            default:
                                exception("illegal id: " + id);
                                return null;
                        }
                }
        }
    }

    public void readAttr() throws IOException, XmlPullParserException {
        StringBuffer value;
        int id = readByte();
        int i = 0;
        while (id != 1) {
            while (id == 0) {
                selectPage(readByte(), false);
                id = readByte();
            }
            String name2 = resolveId(this.attrStartTable, id);
            int cut = name2.indexOf(61);
            if (cut == -1) {
                value = new StringBuffer();
            } else {
                value = new StringBuffer(name2.substring(cut + 1));
                name2 = name2.substring(0, cut);
            }
            id = readByte();
            while (true) {
                if (id > 128 || id == 0 || id == 2 || id == 3 || id == 131 || ((id >= 64 && id <= 66) || (id >= 128 && id <= 130))) {
                    if (id == 0) {
                        selectPage(readByte(), false);
                    } else if (id == 2) {
                        value.append((char) readInt());
                    } else if (id != 3) {
                        switch (id) {
                            case 64:
                            case 65:
                            case Wbxml.EXT_I_2:
                                value.append(resolveWapExtension(id, parseWapExtension(id)));
                                break;
                            default:
                                switch (id) {
                                    case 128:
                                    case Wbxml.EXT_T_1:
                                    case Wbxml.EXT_T_2:
                                        break;
                                    case Wbxml.STR_T:
                                        value.append(readStrT());
                                        break;
                                    default:
                                        switch (id) {
                                            case Wbxml.EXT_0:
                                            case Wbxml.EXT_1:
                                            case Wbxml.EXT_2:
                                            case Wbxml.OPAQUE:
                                                break;
                                            default:
                                                value.append(resolveId(this.attrValueTable, id));
                                                break;
                                        }
                                }
                                value.append(resolveWapExtension(id, parseWapExtension(id)));
                                break;
                        }
                    } else {
                        value.append(readStrI());
                    }
                    id = readByte();
                }
            }
            String[] ensureCapacity = ensureCapacity(this.attributes, i + 4);
            this.attributes = ensureCapacity;
            int i2 = i + 1;
            ensureCapacity[i] = "";
            int i3 = i2 + 1;
            ensureCapacity[i2] = null;
            int i4 = i3 + 1;
            ensureCapacity[i3] = name2;
            i = i4 + 1;
            ensureCapacity[i4] = value.toString();
            this.attributeCount++;
        }
    }

    private int peekId() throws IOException {
        if (this.nextId == -2) {
            this.nextId = this.in.read();
        }
        return this.nextId;
    }

    /* access modifiers changed from: protected */
    public String resolveWapExtension(int id, Object data) {
        if (!(data instanceof byte[])) {
            return "$(" + data + ")";
        }
        StringBuffer sb = new StringBuffer();
        byte[] b = (byte[]) data;
        for (int i = 0; i < b.length; i++) {
            sb.append(HEX_DIGITS.charAt((b[i] >> 4) & 15));
            sb.append(HEX_DIGITS.charAt(b[i] & 15));
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public String resolveId(String[] tab, int id) throws IOException {
        int idx = (id & WorkQueueKt.MASK) - 5;
        if (idx == -1) {
            this.wapCode = -1;
            return readStrT();
        } else if (idx < 0 || tab == null || idx >= tab.length || tab[idx] == null) {
            throw new IOException("id " + id + " undef.");
        } else {
            this.wapCode = idx + 5;
            return tab[idx];
        }
    }

    /* access modifiers changed from: package-private */
    public void parseElement(int id) throws IOException, XmlPullParserException {
        this.type = 2;
        this.name = resolveId(this.tagTable, id & 63);
        this.attributeCount = 0;
        if ((id & 128) != 0) {
            readAttr();
        }
        this.degenerated = (id & 64) == 0;
        int i = this.depth;
        this.depth = i + 1;
        int sp = i << 2;
        String[] ensureCapacity = ensureCapacity(this.elementStack, sp + 4);
        this.elementStack = ensureCapacity;
        ensureCapacity[sp + 3] = this.name;
        int i2 = this.depth;
        int[] iArr = this.nspCounts;
        if (i2 >= iArr.length) {
            int[] bigger = new int[(i2 + 4)];
            System.arraycopy(iArr, 0, bigger, 0, iArr.length);
            this.nspCounts = bigger;
        }
        int[] iArr2 = this.nspCounts;
        int i3 = this.depth;
        iArr2[i3] = iArr2[i3 - 1];
        for (int i4 = this.attributeCount - 1; i4 > 0; i4--) {
            for (int j = 0; j < i4; j++) {
                if (getAttributeName(i4).equals(getAttributeName(j))) {
                    exception("Duplicate Attribute: " + getAttributeName(i4));
                }
            }
        }
        if (this.processNsp != 0) {
            adjustNsp();
        } else {
            this.namespace = "";
        }
        String[] strArr = this.elementStack;
        strArr[sp] = this.namespace;
        strArr[sp + 1] = this.prefix;
        strArr[sp + 2] = this.name;
    }

    private final String[] ensureCapacity(String[] arr, int required) {
        if (arr.length >= required) {
            return arr;
        }
        String[] bigger = new String[(required + 16)];
        System.arraycopy(arr, 0, bigger, 0, arr.length);
        return bigger;
    }

    /* access modifiers changed from: package-private */
    public int readByte() throws IOException {
        int i = this.in.read();
        if (i != -1) {
            return i;
        }
        throw new IOException(UNEXPECTED_EOF);
    }

    /* access modifiers changed from: package-private */
    public int readInt() throws IOException {
        int i;
        int result = 0;
        do {
            i = readByte();
            result = (result << 7) | (i & WorkQueueKt.MASK);
        } while ((i & 128) != 0);
        return result;
    }

    /* access modifiers changed from: package-private */
    public String readStrI() throws IOException {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        boolean wsp = true;
        while (true) {
            int i = this.in.read();
            if (i == 0) {
                this.isWhitespace = wsp;
                String result = new String(buf.toByteArray(), this.encoding);
                buf.close();
                return result;
            } else if (i != -1) {
                if (i > 32) {
                    wsp = false;
                }
                buf.write(i);
            } else {
                throw new IOException(UNEXPECTED_EOF);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String readStrT() throws IOException {
        int pos = readInt();
        if (this.cacheStringTable == null) {
            this.cacheStringTable = new Hashtable();
        }
        String forReturn = (String) this.cacheStringTable.get(new Integer(pos));
        if (forReturn != null) {
            return forReturn;
        }
        int end = pos;
        while (true) {
            byte[] bArr = this.stringTable;
            if (end >= bArr.length || bArr[end] == 0) {
                String forReturn2 = new String(this.stringTable, pos, end - pos, this.encoding);
                this.cacheStringTable.put(new Integer(pos), forReturn2);
            } else {
                end++;
            }
        }
        String forReturn22 = new String(this.stringTable, pos, end - pos, this.encoding);
        this.cacheStringTable.put(new Integer(pos), forReturn22);
        return forReturn22;
    }

    public void setTagTable(int page, String[] table) {
        setTable(page, this.TAG_TABLE, table);
    }

    public void setAttrStartTable(int page, String[] table) {
        setTable(page, this.ATTR_START_TABLE, table);
    }

    public void setAttrValueTable(int page, String[] table) {
        setTable(page, this.ATTR_VALUE_TABLE, table);
    }

    public int getWapCode() {
        return this.wapCode;
    }

    public Object getWapExtensionData() {
        return this.wapExtensionData;
    }
}
