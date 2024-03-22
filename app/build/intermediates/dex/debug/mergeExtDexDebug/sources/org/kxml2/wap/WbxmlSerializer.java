package org.kxml2.wap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Hashtable;
import java.util.Vector;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.xmlpull.v1.XmlSerializer;

public class WbxmlSerializer implements XmlSerializer {
    private int attrPage;
    Hashtable attrStartTable = new Hashtable();
    Hashtable attrValueTable = new Hashtable();
    Vector attributes = new Vector();
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    int depth;
    private String encoding;
    private boolean headerSent = false;
    String name;
    String namespace;
    OutputStream out;
    String pending;
    Hashtable stringTable = new Hashtable();
    ByteArrayOutputStream stringTableBuf = new ByteArrayOutputStream();
    private int tagPage;
    Hashtable tagTable = new Hashtable();

    public XmlSerializer attribute(String namespace2, String name2, String value) {
        this.attributes.addElement(name2);
        this.attributes.addElement(value);
        return this;
    }

    public void cdsect(String cdsect) throws IOException {
        text(cdsect);
    }

    public void comment(String comment) {
    }

    public void docdecl(String docdecl) {
        throw new RuntimeException("Cannot write docdecl for WBXML");
    }

    public void entityRef(String er) {
        throw new RuntimeException("EntityReference not supported for WBXML");
    }

    public int getDepth() {
        return this.depth;
    }

    public boolean getFeature(String name2) {
        return false;
    }

    public String getNamespace() {
        return null;
    }

    public String getName() {
        return this.pending;
    }

    public String getPrefix(String nsp, boolean create) {
        throw new RuntimeException("NYI");
    }

    public Object getProperty(String name2) {
        return null;
    }

    public void ignorableWhitespace(String sp) {
    }

    public void endDocument() throws IOException {
        flush();
    }

    public void flush() throws IOException {
        checkPending(false);
        if (!this.headerSent) {
            writeInt(this.out, this.stringTableBuf.size());
            this.out.write(this.stringTableBuf.toByteArray());
            this.headerSent = true;
        }
        this.out.write(this.buf.toByteArray());
        this.buf.reset();
    }

    public void checkPending(boolean degenerated) throws IOException {
        if (this.pending != null) {
            int len = this.attributes.size();
            int[] idx = (int[]) this.tagTable.get(this.pending);
            if (idx == null) {
                this.buf.write(len == 0 ? degenerated ? 4 : 68 : degenerated ? Wbxml.LITERAL_A : Wbxml.LITERAL_AC);
                writeStrT(this.pending, false);
            } else {
                if (idx[0] != this.tagPage) {
                    this.tagPage = idx[0];
                    this.buf.write(0);
                    this.buf.write(this.tagPage);
                }
                this.buf.write(len == 0 ? degenerated ? idx[1] : idx[1] | 64 : degenerated ? idx[1] | 128 : idx[1] | Wbxml.EXT_0);
            }
            int i = 0;
            while (i < len) {
                int[] idx2 = (int[]) this.attrStartTable.get(this.attributes.elementAt(i));
                if (idx2 == null) {
                    this.buf.write(4);
                    writeStrT((String) this.attributes.elementAt(i), false);
                } else {
                    if (idx2[0] != this.attrPage) {
                        this.attrPage = idx2[0];
                        this.buf.write(0);
                        this.buf.write(this.attrPage);
                    }
                    this.buf.write(idx2[1]);
                }
                int i2 = i + 1;
                int[] idx3 = (int[]) this.attrValueTable.get(this.attributes.elementAt(i2));
                if (idx3 == null) {
                    writeStr((String) this.attributes.elementAt(i2));
                } else {
                    if (idx3[0] != this.attrPage) {
                        this.attrPage = idx3[0];
                        this.buf.write(0);
                        this.buf.write(this.attrPage);
                    }
                    this.buf.write(idx3[1]);
                }
                i = i2 + 1;
            }
            if (len > 0) {
                this.buf.write(1);
            }
            this.pending = null;
            this.attributes.removeAllElements();
        }
    }

    public void processingInstruction(String pi) {
        throw new RuntimeException("PI NYI");
    }

    public void setFeature(String name2, boolean value) {
        throw new IllegalArgumentException("unknown feature " + name2);
    }

    public void setOutput(Writer writer) {
        throw new RuntimeException("Wbxml requires an OutputStream!");
    }

    public void setOutput(OutputStream out2, String encoding2) throws IOException {
        this.encoding = encoding2 == null ? "UTF-8" : encoding2;
        this.out = out2;
        this.buf = new ByteArrayOutputStream();
        this.stringTableBuf = new ByteArrayOutputStream();
        this.headerSent = false;
    }

    public void setPrefix(String prefix, String nsp) {
        throw new RuntimeException("NYI");
    }

    public void setProperty(String property, Object value) {
        throw new IllegalArgumentException("unknown property " + property);
    }

    public void startDocument(String encoding2, Boolean standalone) throws IOException {
        this.out.write(3);
        this.out.write(1);
        if (encoding2 != null) {
            this.encoding = encoding2;
        }
        if (this.encoding.toUpperCase().equals("UTF-8")) {
            this.out.write(106);
        } else if (this.encoding.toUpperCase().equals("ISO-8859-1")) {
            this.out.write(4);
        } else {
            throw new UnsupportedEncodingException(encoding2);
        }
    }

    public XmlSerializer startTag(String namespace2, String name2) throws IOException {
        if (namespace2 == null || "".equals(namespace2)) {
            checkPending(false);
            this.pending = name2;
            this.depth++;
            return this;
        }
        throw new RuntimeException("NSP NYI");
    }

    public XmlSerializer text(char[] chars, int start, int len) throws IOException {
        checkPending(false);
        writeStr(new String(chars, start, len));
        return this;
    }

    public XmlSerializer text(String text) throws IOException {
        checkPending(false);
        writeStr(text);
        return this;
    }

    private void writeStr(String text) throws IOException {
        int p0 = 0;
        int lastCut = 0;
        int len = text.length();
        if (this.headerSent) {
            writeStrI(this.buf, text);
            return;
        }
        while (p0 < len) {
            while (p0 < len && text.charAt(p0) < 'A') {
                p0++;
            }
            int p1 = p0;
            while (p1 < len && text.charAt(p1) >= 'A') {
                p1++;
            }
            if (p1 - p0 > 10) {
                if (p0 > lastCut && text.charAt(p0 - 1) == ' ' && this.stringTable.get(text.substring(p0, p1)) == null) {
                    this.buf.write(Wbxml.STR_T);
                    writeStrT(text.substring(lastCut, p1), false);
                } else {
                    if (p0 > lastCut && text.charAt(p0 - 1) == ' ') {
                        p0--;
                    }
                    if (p0 > lastCut) {
                        this.buf.write(Wbxml.STR_T);
                        writeStrT(text.substring(lastCut, p0), false);
                    }
                    this.buf.write(Wbxml.STR_T);
                    writeStrT(text.substring(p0, p1), true);
                }
                lastCut = p1;
            }
            p0 = p1;
        }
        if (lastCut < len) {
            this.buf.write(Wbxml.STR_T);
            writeStrT(text.substring(lastCut, len), false);
        }
    }

    public XmlSerializer endTag(String namespace2, String name2) throws IOException {
        if (this.pending != null) {
            checkPending(true);
        } else {
            this.buf.write(1);
        }
        this.depth--;
        return this;
    }

    public void writeWapExtension(int type, Object data) throws IOException {
        checkPending(false);
        this.buf.write(type);
        switch (type) {
            case 64:
            case 65:
            case Wbxml.EXT_I_2:
                writeStrI(this.buf, (String) data);
                return;
            default:
                switch (type) {
                    case 128:
                    case Wbxml.EXT_T_1:
                    case Wbxml.EXT_T_2:
                        writeStrT((String) data, false);
                        return;
                    default:
                        switch (type) {
                            case Wbxml.EXT_0:
                            case Wbxml.EXT_1:
                            case Wbxml.EXT_2:
                                return;
                            case Wbxml.OPAQUE:
                                byte[] bytes = (byte[]) data;
                                writeInt(this.buf, bytes.length);
                                this.buf.write(bytes);
                                return;
                            default:
                                throw new IllegalArgumentException();
                        }
                }
        }
    }

    static void writeInt(OutputStream out2, int i) throws IOException {
        int idx;
        byte[] buf2 = new byte[5];
        int idx2 = 0;
        while (true) {
            idx = idx2 + 1;
            buf2[idx2] = (byte) (i & WorkQueueKt.MASK);
            i >>= 7;
            if (i == 0) {
                break;
            }
            idx2 = idx;
        }
        while (idx > 1) {
            idx--;
            out2.write(buf2[idx] | ByteCompanionObject.MIN_VALUE);
        }
        out2.write(buf2[0]);
    }

    /* access modifiers changed from: package-private */
    public void writeStrI(OutputStream out2, String s) throws IOException {
        out2.write(s.getBytes(this.encoding));
        out2.write(0);
    }

    private final void writeStrT(String s, boolean mayPrependSpace) throws IOException {
        Integer idx = (Integer) this.stringTable.get(s);
        writeInt(this.buf, idx == null ? addToStringTable(s, mayPrependSpace) : idx.intValue());
    }

    public int addToStringTable(String s, boolean mayPrependSpace) throws IOException {
        if (!this.headerSent) {
            int i = this.stringTableBuf.size();
            int offset = i;
            if (s.charAt(0) >= '0' && mayPrependSpace) {
                s = ' ' + s;
                offset++;
            }
            this.stringTable.put(s, new Integer(i));
            if (s.charAt(0) == ' ') {
                this.stringTable.put(s.substring(1), new Integer(i + 1));
            }
            int j = s.lastIndexOf(32);
            if (j > 1) {
                this.stringTable.put(s.substring(j), new Integer(i + j));
                this.stringTable.put(s.substring(j + 1), new Integer(i + j + 1));
            }
            writeStrI(this.stringTableBuf, s);
            this.stringTableBuf.flush();
            return offset;
        }
        throw new IOException("stringtable sent");
    }

    public void setTagTable(int page, String[] tagTable2) {
        for (int i = 0; i < tagTable2.length; i++) {
            if (tagTable2[i] != null) {
                this.tagTable.put(tagTable2[i], new int[]{page, i + 5});
            }
        }
    }

    public void setAttrStartTable(int page, String[] attrStartTable2) {
        for (int i = 0; i < attrStartTable2.length; i++) {
            if (attrStartTable2[i] != null) {
                this.attrStartTable.put(attrStartTable2[i], new int[]{page, i + 5});
            }
        }
    }

    public void setAttrValueTable(int page, String[] attrValueTable2) {
        for (int i = 0; i < attrValueTable2.length; i++) {
            if (attrValueTable2[i] != null) {
                this.attrValueTable.put(attrValueTable2[i], new int[]{page, i + 133});
            }
        }
    }
}
