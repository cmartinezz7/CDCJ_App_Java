package org.xmlpull.v1;

public class XmlPullParserException extends Exception {
    protected int column;
    protected Throwable detail;
    protected int row;

    public XmlPullParserException(String s) {
        super(s);
        this.row = -1;
        this.column = -1;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public XmlPullParserException(java.lang.String r5, org.xmlpull.v1.XmlPullParser r6, java.lang.Throwable r7) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            if (r5 != 0) goto L_0x000b
            r2 = r1
            goto L_0x001e
        L_0x000b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r3 = " "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
        L_0x001e:
            java.lang.StringBuilder r0 = r0.append(r2)
            if (r6 != 0) goto L_0x0026
            r2 = r1
            goto L_0x0043
        L_0x0026:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "(position:"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r6.getPositionDescription()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
        L_0x0043:
            java.lang.StringBuilder r0 = r0.append(r2)
            if (r7 != 0) goto L_0x004a
            goto L_0x005d
        L_0x004a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "caused by: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r1 = r1.toString()
        L_0x005d:
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            r0 = -1
            r4.row = r0
            r4.column = r0
            if (r6 == 0) goto L_0x007b
            int r0 = r6.getLineNumber()
            r4.row = r0
            int r0 = r6.getColumnNumber()
            r4.column = r0
        L_0x007b:
            r4.detail = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xmlpull.v1.XmlPullParserException.<init>(java.lang.String, org.xmlpull.v1.XmlPullParser, java.lang.Throwable):void");
    }

    public Throwable getDetail() {
        return this.detail;
    }

    public int getLineNumber() {
        return this.row;
    }

    public int getColumnNumber() {
        return this.column;
    }

    public void printStackTrace() {
        if (this.detail == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            this.detail.printStackTrace();
        }
    }
}
