package com.tealium.internal;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

public final class d {
    /* access modifiers changed from: private */
    public final String a;
    /* access modifiers changed from: private */
    public final String b;
    /* access modifiers changed from: private */
    public Map<String, String> c;
    /* access modifiers changed from: private */
    public a d;
    /* access modifiers changed from: private */
    public String e;

    public interface a {
        void a(String str, String str2, int i, String str3, byte[] bArr);

        void a(String str, Throwable th);
    }

    private d(String str, String str2) {
        this.a = str;
        if (!TextUtils.isEmpty(str)) {
            this.b = str2;
            if (!TextUtils.isEmpty(str2)) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public static d a(String str) {
        return new d(str, "HEAD");
    }

    public static d b(String str) {
        return new d(str, "GET");
    }

    /* access modifiers changed from: private */
    public static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArray;
            }
        }
    }

    public d a(a aVar) {
        this.d = aVar;
        return this;
    }

    public d a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException();
        }
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, str2);
        return this;
    }

    public Runnable a() {
        return new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:34:0x00e0 A[Catch:{ all -> 0x00f5 }] */
            /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r9 = this;
                    r0 = 0
                    java.net.URL r1 = new java.net.URL     // Catch:{ all -> 0x00d4 }
                    com.tealium.internal.d r2 = com.tealium.internal.d.this     // Catch:{ all -> 0x00d4 }
                    java.lang.String r2 = r2.a     // Catch:{ all -> 0x00d4 }
                    r1.<init>(r2)     // Catch:{ all -> 0x00d4 }
                    java.net.URLConnection r1 = r1.openConnection()     // Catch:{ all -> 0x00d4 }
                    java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ all -> 0x00d4 }
                    com.tealium.internal.d r2 = com.tealium.internal.d.this     // Catch:{ all -> 0x00d2 }
                    java.lang.String r2 = r2.b     // Catch:{ all -> 0x00d2 }
                    r1.setRequestMethod(r2)     // Catch:{ all -> 0x00d2 }
                    java.lang.String r2 = "Accept-Encoding"
                    java.lang.String r3 = "*"
                    r1.setRequestProperty(r2, r3)     // Catch:{ all -> 0x00d2 }
                    com.tealium.internal.d r2 = com.tealium.internal.d.this     // Catch:{ all -> 0x00d2 }
                    java.util.Map r2 = r2.c     // Catch:{ all -> 0x00d2 }
                    if (r2 == 0) goto L_0x0054
                    com.tealium.internal.d r2 = com.tealium.internal.d.this     // Catch:{ all -> 0x00d2 }
                    java.util.Map r2 = r2.c     // Catch:{ all -> 0x00d2 }
                    java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x00d2 }
                    java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00d2 }
                L_0x0038:
                    boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00d2 }
                    if (r3 == 0) goto L_0x0054
                    java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00d2 }
                    java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x00d2 }
                    java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x00d2 }
                    java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00d2 }
                    java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x00d2 }
                    java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00d2 }
                    r1.setRequestProperty(r4, r3)     // Catch:{ all -> 0x00d2 }
                    goto L_0x0038
                L_0x0054:
                    java.lang.String r2 = "HEAD"
                    com.tealium.internal.d r3 = com.tealium.internal.d.this     // Catch:{ all -> 0x00d2 }
                    java.lang.String r3 = r3.b     // Catch:{ all -> 0x00d2 }
                    boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x00d2 }
                    r3 = 1
                    r4 = 0
                    if (r2 != 0) goto L_0x0066
                    r2 = r3
                    goto L_0x0067
                L_0x0066:
                    r2 = r4
                L_0x0067:
                    r1.setDoInput(r2)     // Catch:{ all -> 0x00d2 }
                    com.tealium.internal.d r5 = com.tealium.internal.d.this     // Catch:{ all -> 0x00d2 }
                    java.lang.String r5 = r5.e     // Catch:{ all -> 0x00d2 }
                    if (r5 == 0) goto L_0x0091
                    r1.setDoOutput(r3)     // Catch:{ all -> 0x00d2 }
                    java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ all -> 0x00d2 }
                    java.io.OutputStream r4 = r1.getOutputStream()     // Catch:{ all -> 0x00d2 }
                    r3.<init>(r4)     // Catch:{ all -> 0x00d2 }
                    com.tealium.internal.d r4 = com.tealium.internal.d.this     // Catch:{ all -> 0x00d2 }
                    java.lang.String r4 = r4.e     // Catch:{ all -> 0x00d2 }
                    java.lang.String r5 = "UTF-8"
                    byte[] r4 = r4.getBytes(r5)     // Catch:{ all -> 0x00d2 }
                    r3.write(r4)     // Catch:{ all -> 0x00d2 }
                    r3.close()     // Catch:{ all -> 0x00d2 }
                    goto L_0x0094
                L_0x0091:
                    r1.setDoOutput(r4)     // Catch:{ all -> 0x00d2 }
                L_0x0094:
                    r1.connect()     // Catch:{ all -> 0x00d2 }
                    if (r2 == 0) goto L_0x00a1
                    java.io.InputStream r0 = r1.getInputStream()     // Catch:{ all -> 0x00d2 }
                    byte[] r0 = com.tealium.internal.d.b((java.io.InputStream) r0)     // Catch:{ all -> 0x00d2 }
                L_0x00a1:
                    r7 = r0
                    com.tealium.internal.d r0 = com.tealium.internal.d.this     // Catch:{ all -> 0x00d2 }
                    com.tealium.internal.d$a r0 = r0.d     // Catch:{ all -> 0x00d2 }
                    if (r0 != 0) goto L_0x00b0
                    if (r1 == 0) goto L_0x00af
                    r1.disconnect()
                L_0x00af:
                    return
                L_0x00b0:
                    com.tealium.internal.d r0 = com.tealium.internal.d.this     // Catch:{ all -> 0x00d2 }
                    com.tealium.internal.d$a r2 = r0.d     // Catch:{ all -> 0x00d2 }
                    com.tealium.internal.d r0 = com.tealium.internal.d.this     // Catch:{ all -> 0x00d2 }
                    java.lang.String r3 = r0.a     // Catch:{ all -> 0x00d2 }
                    com.tealium.internal.d r0 = com.tealium.internal.d.this     // Catch:{ all -> 0x00d2 }
                    java.lang.String r4 = r0.b     // Catch:{ all -> 0x00d2 }
                    int r5 = r1.getResponseCode()     // Catch:{ all -> 0x00d2 }
                    java.lang.String r0 = "Content-Type"
                    java.lang.String r6 = r1.getHeaderField(r0)     // Catch:{ all -> 0x00d2 }
                    r2.a(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00d2 }
                    if (r1 == 0) goto L_0x00f4
                    goto L_0x00f1
                L_0x00d2:
                    r0 = move-exception
                    goto L_0x00d8
                L_0x00d4:
                    r1 = move-exception
                    r8 = r1
                    r1 = r0
                    r0 = r8
                L_0x00d8:
                    com.tealium.internal.d r2 = com.tealium.internal.d.this     // Catch:{ all -> 0x00f5 }
                    com.tealium.internal.d$a r2 = r2.d     // Catch:{ all -> 0x00f5 }
                    if (r2 == 0) goto L_0x00ef
                    com.tealium.internal.d r2 = com.tealium.internal.d.this     // Catch:{ all -> 0x00f5 }
                    com.tealium.internal.d$a r2 = r2.d     // Catch:{ all -> 0x00f5 }
                    com.tealium.internal.d r3 = com.tealium.internal.d.this     // Catch:{ all -> 0x00f5 }
                    java.lang.String r3 = r3.a     // Catch:{ all -> 0x00f5 }
                    r2.a(r3, r0)     // Catch:{ all -> 0x00f5 }
                L_0x00ef:
                    if (r1 == 0) goto L_0x00f4
                L_0x00f1:
                    r1.disconnect()
                L_0x00f4:
                    return
                L_0x00f5:
                    r0 = move-exception
                    if (r1 == 0) goto L_0x00fb
                    r1.disconnect()
                L_0x00fb:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tealium.internal.d.AnonymousClass1.run():void");
            }
        };
    }
}
