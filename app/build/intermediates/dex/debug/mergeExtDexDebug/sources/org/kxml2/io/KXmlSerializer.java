package org.kxml2.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlSerializer;

public class KXmlSerializer implements XmlSerializer {
    private int auto;
    private int depth;
    private String[] elementStack = new String[12];
    private String encoding;
    private boolean[] indent = new boolean[4];
    private int[] nspCounts = new int[4];
    private String[] nspStack = new String[8];
    private boolean pending;
    private boolean unicode;
    private Writer writer;

    private final void check(boolean close) throws IOException {
        if (this.pending) {
            int i = this.depth + 1;
            this.depth = i;
            this.pending = false;
            boolean[] zArr = this.indent;
            if (zArr.length <= i) {
                boolean[] hlp = new boolean[(i + 4)];
                System.arraycopy(zArr, 0, hlp, 0, i);
                this.indent = hlp;
            }
            boolean[] zArr2 = this.indent;
            int i2 = this.depth;
            zArr2[i2] = zArr2[i2 - 1];
            int i3 = this.nspCounts[i2 - 1];
            while (true) {
                int[] iArr = this.nspCounts;
                int i4 = this.depth;
                if (i3 < iArr[i4]) {
                    this.writer.write(32);
                    this.writer.write("xmlns");
                    if (!"".equals(this.nspStack[i3 * 2])) {
                        this.writer.write(58);
                        this.writer.write(this.nspStack[i3 * 2]);
                    } else if ("".equals(getNamespace()) && !"".equals(this.nspStack[(i3 * 2) + 1])) {
                        throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                    }
                    this.writer.write("=\"");
                    writeEscaped(this.nspStack[(i3 * 2) + 1], 34);
                    this.writer.write(34);
                    i3++;
                } else {
                    if (iArr.length <= i4 + 1) {
                        int[] hlp2 = new int[(i4 + 8)];
                        System.arraycopy(iArr, 0, hlp2, 0, i4 + 1);
                        this.nspCounts = hlp2;
                    }
                    int[] hlp3 = this.nspCounts;
                    int i5 = this.depth;
                    hlp3[i5 + 1] = hlp3[i5];
                    this.writer.write(close ? " />" : ">");
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        if (r1 != '\'') goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void writeEscaped(java.lang.String r6, int r7) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            int r1 = r6.length()
            if (r0 >= r1) goto L_0x00b4
            char r1 = r6.charAt(r0)
            r2 = 9
            java.lang.String r3 = "&#"
            if (r1 == r2) goto L_0x008a
            r2 = 10
            if (r1 == r2) goto L_0x008a
            r2 = 13
            if (r1 == r2) goto L_0x008a
            r2 = 34
            if (r1 == r2) goto L_0x0048
            r4 = 60
            if (r1 == r4) goto L_0x0040
            r4 = 62
            if (r1 == r4) goto L_0x0037
            r4 = 38
            if (r1 == r4) goto L_0x002e
            r4 = 39
            if (r1 == r4) goto L_0x0048
            goto L_0x0057
        L_0x002e:
            java.io.Writer r2 = r5.writer
            java.lang.String r3 = "&amp;"
            r2.write(r3)
            goto L_0x00b0
        L_0x0037:
            java.io.Writer r2 = r5.writer
            java.lang.String r3 = "&gt;"
            r2.write(r3)
            goto L_0x00b0
        L_0x0040:
            java.io.Writer r2 = r5.writer
            java.lang.String r3 = "&lt;"
            r2.write(r3)
            goto L_0x00b0
        L_0x0048:
            if (r1 != r7) goto L_0x0057
            java.io.Writer r3 = r5.writer
            if (r1 != r2) goto L_0x0051
            java.lang.String r2 = "&quot;"
            goto L_0x0053
        L_0x0051:
            java.lang.String r2 = "&apos;"
        L_0x0053:
            r3.write(r2)
            goto L_0x00b0
        L_0x0057:
            r2 = 32
            if (r1 < r2) goto L_0x006d
            r2 = 64
            if (r1 == r2) goto L_0x006d
            r2 = 127(0x7f, float:1.78E-43)
            if (r1 < r2) goto L_0x0067
            boolean r2 = r5.unicode
            if (r2 == 0) goto L_0x006d
        L_0x0067:
            java.io.Writer r2 = r5.writer
            r2.write(r1)
            goto L_0x00b0
        L_0x006d:
            java.io.Writer r2 = r5.writer
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.StringBuilder r3 = r3.append(r1)
            java.lang.String r4 = ";"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.write(r3)
            goto L_0x00b0
        L_0x008a:
            r2 = -1
            if (r7 != r2) goto L_0x0093
            java.io.Writer r2 = r5.writer
            r2.write(r1)
            goto L_0x00b0
        L_0x0093:
            java.io.Writer r2 = r5.writer
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.StringBuilder r3 = r3.append(r1)
            r4 = 59
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.write(r3)
        L_0x00b0:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x00b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.io.KXmlSerializer.writeEscaped(java.lang.String, int):void");
    }

    public void docdecl(String dd) throws IOException {
        this.writer.write("<!DOCTYPE");
        this.writer.write(dd);
        this.writer.write(">");
    }

    public void endDocument() throws IOException {
        while (true) {
            int i = this.depth;
            if (i > 0) {
                String[] strArr = this.elementStack;
                endTag(strArr[(i * 3) - 3], strArr[(i * 3) - 1]);
            } else {
                flush();
                return;
            }
        }
    }

    public void entityRef(String name) throws IOException {
        check(false);
        this.writer.write(38);
        this.writer.write(name);
        this.writer.write(59);
    }

    public boolean getFeature(String name) {
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(name)) {
            return this.indent[this.depth];
        }
        return false;
    }

    public String getPrefix(String namespace, boolean create) {
        try {
            return getPrefix(namespace, false, create);
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    private final String getPrefix(String namespace, boolean includeDefault, boolean create) throws IOException {
        String prefix;
        int i = this.nspCounts[this.depth + 1] * 2;
        while (true) {
            i -= 2;
            if (i >= 0) {
                if (this.nspStack[i + 1].equals(namespace) && (includeDefault || !this.nspStack[i].equals(""))) {
                    String cand = this.nspStack[i];
                    int j = i + 2;
                    while (true) {
                        if (j >= this.nspCounts[this.depth + 1] * 2) {
                            break;
                        } else if (this.nspStack[j].equals(cand)) {
                            cand = null;
                            break;
                        } else {
                            j++;
                        }
                    }
                    if (cand != null) {
                        return cand;
                    }
                }
            } else if (!create) {
                return null;
            } else {
                if ("".equals(namespace)) {
                    prefix = "";
                } else {
                    do {
                        StringBuilder append = new StringBuilder().append("n");
                        int i2 = this.auto;
                        this.auto = i2 + 1;
                        prefix = append.append(i2).toString();
                        int i3 = (this.nspCounts[this.depth + 1] * 2) - 2;
                        while (true) {
                            if (i3 < 0) {
                                break;
                            } else if (prefix.equals(this.nspStack[i3])) {
                                prefix = null;
                                continue;
                                break;
                            } else {
                                i3 -= 2;
                            }
                        }
                    } while (prefix == null);
                }
                boolean p = this.pending;
                this.pending = false;
                setPrefix(prefix, namespace);
                this.pending = p;
                return prefix;
            }
        }
    }

    public Object getProperty(String name) {
        throw new RuntimeException("Unsupported property");
    }

    public void ignorableWhitespace(String s) throws IOException {
        text(s);
    }

    public void setFeature(String name, boolean value) {
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(name)) {
            this.indent[this.depth] = value;
            return;
        }
        throw new RuntimeException("Unsupported Feature");
    }

    public void setProperty(String name, Object value) {
        throw new RuntimeException("Unsupported Property:" + value);
    }

    public void setPrefix(String prefix, String namespace) throws IOException {
        check(false);
        if (prefix == null) {
            prefix = "";
        }
        if (namespace == null) {
            namespace = "";
        }
        if (!prefix.equals(getPrefix(namespace, true, false))) {
            int[] iArr = this.nspCounts;
            int i = this.depth + 1;
            int i2 = iArr[i];
            iArr[i] = i2 + 1;
            int pos = i2 << 1;
            String[] strArr = this.nspStack;
            if (strArr.length < pos + 1) {
                String[] hlp = new String[(strArr.length + 16)];
                System.arraycopy(strArr, 0, hlp, 0, pos);
                this.nspStack = hlp;
            }
            String[] strArr2 = this.nspStack;
            strArr2[pos] = prefix;
            strArr2[pos + 1] = namespace;
        }
    }

    public void setOutput(Writer writer2) {
        this.writer = writer2;
        int[] iArr = this.nspCounts;
        iArr[0] = 2;
        iArr[1] = 2;
        String[] strArr = this.nspStack;
        strArr[0] = "";
        strArr[1] = "";
        strArr[2] = "xml";
        strArr[3] = "http://www.w3.org/XML/1998/namespace";
        this.pending = false;
        this.auto = 0;
        this.depth = 0;
        this.unicode = false;
    }

    public void setOutput(OutputStream os, String encoding2) throws IOException {
        OutputStreamWriter outputStreamWriter;
        if (os != null) {
            if (encoding2 != null) {
                outputStreamWriter = new OutputStreamWriter(os, encoding2);
            }
            setOutput(outputStreamWriter);
            this.encoding = encoding2;
            if (encoding2 != null && encoding2.toLowerCase().startsWith("utf")) {
                this.unicode = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void startDocument(String encoding2, Boolean standalone) throws IOException {
        this.writer.write("<?xml version='1.0' ");
        if (encoding2 != null) {
            this.encoding = encoding2;
            if (encoding2.toLowerCase().startsWith("utf")) {
                this.unicode = true;
            }
        }
        if (this.encoding != null) {
            this.writer.write("encoding='");
            this.writer.write(this.encoding);
            this.writer.write("' ");
        }
        if (standalone != null) {
            this.writer.write("standalone='");
            this.writer.write(standalone.booleanValue() ? "yes" : "no");
            this.writer.write("' ");
        }
        this.writer.write("?>");
    }

    public XmlSerializer startTag(String namespace, String name) throws IOException {
        check(false);
        if (this.indent[this.depth]) {
            this.writer.write("\r\n");
            for (int i = 0; i < this.depth; i++) {
                this.writer.write("  ");
            }
        }
        int esp = this.depth * 3;
        String[] strArr = this.elementStack;
        if (strArr.length < esp + 3) {
            String[] hlp = new String[(strArr.length + 12)];
            System.arraycopy(strArr, 0, hlp, 0, esp);
            this.elementStack = hlp;
        }
        String prefix = namespace == null ? "" : getPrefix(namespace, true, true);
        if ("".equals(namespace)) {
            int i2 = this.nspCounts[this.depth];
            while (i2 < this.nspCounts[this.depth + 1]) {
                if (!"".equals(this.nspStack[i2 * 2]) || "".equals(this.nspStack[(i2 * 2) + 1])) {
                    i2++;
                } else {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
            }
        }
        String[] strArr2 = this.elementStack;
        int esp2 = esp + 1;
        strArr2[esp] = namespace;
        strArr2[esp2] = prefix;
        strArr2[esp2 + 1] = name;
        this.writer.write(60);
        if (!"".equals(prefix)) {
            this.writer.write(prefix);
            this.writer.write(58);
        }
        this.writer.write(name);
        this.pending = true;
        return this;
    }

    public XmlSerializer attribute(String namespace, String name, String value) throws IOException {
        String prefix;
        if (this.pending) {
            if (namespace == null) {
                namespace = "";
            }
            if ("".equals(namespace)) {
                prefix = "";
            } else {
                prefix = getPrefix(namespace, false, true);
            }
            this.writer.write(32);
            if (!"".equals(prefix)) {
                this.writer.write(prefix);
                this.writer.write(58);
            }
            this.writer.write(name);
            this.writer.write(61);
            char q = Typography.quote;
            if (value.indexOf(34) != -1) {
                q = '\'';
            }
            this.writer.write(q);
            writeEscaped(value, q);
            this.writer.write(q);
            return this;
        }
        throw new IllegalStateException("illegal position for attribute");
    }

    public void flush() throws IOException {
        check(false);
        this.writer.flush();
    }

    public XmlSerializer endTag(String namespace, String name) throws IOException {
        if (!this.pending) {
            this.depth--;
        }
        if ((namespace != null || this.elementStack[this.depth * 3] == null) && ((namespace == null || namespace.equals(this.elementStack[this.depth * 3])) && this.elementStack[(this.depth * 3) + 2].equals(name))) {
            if (this.pending) {
                check(true);
                this.depth--;
            } else {
                if (this.indent[this.depth + 1]) {
                    this.writer.write("\r\n");
                    for (int i = 0; i < this.depth; i++) {
                        this.writer.write("  ");
                    }
                }
                this.writer.write("</");
                String prefix = this.elementStack[(this.depth * 3) + 1];
                if (!"".equals(prefix)) {
                    this.writer.write(prefix);
                    this.writer.write(58);
                }
                this.writer.write(name);
                this.writer.write(62);
            }
            int[] iArr = this.nspCounts;
            int i2 = this.depth;
            iArr[i2 + 1] = iArr[i2];
            return this;
        }
        throw new IllegalArgumentException("</{" + namespace + "}" + name + "> does not match start");
    }

    public String getNamespace() {
        if (getDepth() == 0) {
            return null;
        }
        return this.elementStack[(getDepth() * 3) - 3];
    }

    public String getName() {
        if (getDepth() == 0) {
            return null;
        }
        return this.elementStack[(getDepth() * 3) - 1];
    }

    public int getDepth() {
        return this.pending ? this.depth + 1 : this.depth;
    }

    public XmlSerializer text(String text) throws IOException {
        check(false);
        this.indent[this.depth] = false;
        writeEscaped(text, -1);
        return this;
    }

    public XmlSerializer text(char[] text, int start, int len) throws IOException {
        text(new String(text, start, len));
        return this;
    }

    public void cdsect(String data) throws IOException {
        check(false);
        this.writer.write("<![CDATA[");
        this.writer.write(data);
        this.writer.write("]]>");
    }

    public void comment(String comment) throws IOException {
        check(false);
        this.writer.write("<!--");
        this.writer.write(comment);
        this.writer.write("-->");
    }

    public void processingInstruction(String pi) throws IOException {
        check(false);
        this.writer.write("<?");
        this.writer.write(pi);
        this.writer.write("?>");
    }
}
