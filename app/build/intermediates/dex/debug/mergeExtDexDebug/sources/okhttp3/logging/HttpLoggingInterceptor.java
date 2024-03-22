package okhttp3.logging;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.internal.platform.Platform;
import okio.Buffer;

public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            public void log(String message) {
                Platform.get().log(4, message, (Throwable) null);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        this.headersToRedact = Collections.emptySet();
        this.level = Level.NONE;
        this.logger = logger2;
    }

    public void redactHeader(String name) {
        Set<String> newHeadersToRedact = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        newHeadersToRedact.addAll(this.headersToRedact);
        newHeadersToRedact.add(name);
        this.headersToRedact = newHeadersToRedact;
    }

    public HttpLoggingInterceptor setLevel(Level level2) {
        if (level2 != null) {
            this.level = level2;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public Level getLevel() {
        return this.level;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x037d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r31) throws java.io.IOException {
        /*
            r30 = this;
            r1 = r30
            r2 = r31
            okhttp3.logging.HttpLoggingInterceptor$Level r3 = r1.level
            okhttp3.Request r4 = r31.request()
            okhttp3.logging.HttpLoggingInterceptor$Level r0 = okhttp3.logging.HttpLoggingInterceptor.Level.NONE
            if (r3 != r0) goto L_0x0013
            okhttp3.Response r0 = r2.proceed(r4)
            return r0
        L_0x0013:
            okhttp3.logging.HttpLoggingInterceptor$Level r0 = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
            r5 = 0
            r6 = 1
            if (r3 != r0) goto L_0x001b
            r0 = r6
            goto L_0x001c
        L_0x001b:
            r0 = r5
        L_0x001c:
            r7 = r0
            if (r7 != 0) goto L_0x0026
            okhttp3.logging.HttpLoggingInterceptor$Level r0 = okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS
            if (r3 != r0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r0 = r5
            goto L_0x0027
        L_0x0026:
            r0 = r6
        L_0x0027:
            r8 = r0
            okhttp3.RequestBody r9 = r4.body()
            if (r9 == 0) goto L_0x002f
            r5 = r6
        L_0x002f:
            okhttp3.Connection r6 = r31.connection()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = "--> "
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r10 = r4.method()
            java.lang.StringBuilder r0 = r0.append(r10)
            r10 = 32
            java.lang.StringBuilder r0 = r0.append(r10)
            okhttp3.HttpUrl r11 = r4.url()
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.String r11 = ""
            if (r6 == 0) goto L_0x0070
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = " "
            java.lang.StringBuilder r12 = r12.append(r13)
            okhttp3.Protocol r13 = r6.protocol()
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            goto L_0x0071
        L_0x0070:
            r12 = r11
        L_0x0071:
            java.lang.StringBuilder r0 = r0.append(r12)
            java.lang.String r0 = r0.toString()
            java.lang.String r12 = "-byte body)"
            java.lang.String r13 = " ("
            if (r8 != 0) goto L_0x00a2
            if (r5 == 0) goto L_0x00a2
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.StringBuilder r14 = r14.append(r0)
            java.lang.StringBuilder r14 = r14.append(r13)
            r16 = r11
            long r10 = r9.contentLength()
            java.lang.StringBuilder r10 = r14.append(r10)
            java.lang.StringBuilder r10 = r10.append(r12)
            java.lang.String r0 = r10.toString()
            r10 = r0
            goto L_0x00a5
        L_0x00a2:
            r16 = r11
            r10 = r0
        L_0x00a5:
            okhttp3.logging.HttpLoggingInterceptor$Logger r0 = r1.logger
            r0.log(r10)
            java.lang.String r0 = "-byte body omitted)"
            r17 = -1
            if (r8 == 0) goto L_0x0220
            if (r5 == 0) goto L_0x00fc
            okhttp3.MediaType r11 = r9.contentType()
            if (r11 == 0) goto L_0x00d4
            okhttp3.logging.HttpLoggingInterceptor$Logger r11 = r1.logger
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Content-Type: "
            java.lang.StringBuilder r14 = r14.append(r15)
            okhttp3.MediaType r15 = r9.contentType()
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r14 = r14.toString()
            r11.log(r14)
        L_0x00d4:
            long r14 = r9.contentLength()
            int r11 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r11 == 0) goto L_0x00fa
            okhttp3.logging.HttpLoggingInterceptor$Logger r11 = r1.logger
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Content-Length: "
            java.lang.StringBuilder r14 = r14.append(r15)
            r15 = r3
            long r2 = r9.contentLength()
            java.lang.StringBuilder r2 = r14.append(r2)
            java.lang.String r2 = r2.toString()
            r11.log(r2)
            goto L_0x00fd
        L_0x00fa:
            r15 = r3
            goto L_0x00fd
        L_0x00fc:
            r15 = r3
        L_0x00fd:
            okhttp3.Headers r2 = r4.headers()
            r3 = 0
            int r11 = r2.size()
        L_0x0106:
            if (r3 >= r11) goto L_0x0126
            java.lang.String r14 = r2.name(r3)
            r20 = r6
            java.lang.String r6 = "Content-Type"
            boolean r6 = r6.equalsIgnoreCase(r14)
            if (r6 != 0) goto L_0x0121
            java.lang.String r6 = "Content-Length"
            boolean r6 = r6.equalsIgnoreCase(r14)
            if (r6 != 0) goto L_0x0121
            r1.logHeader(r2, r3)
        L_0x0121:
            int r3 = r3 + 1
            r6 = r20
            goto L_0x0106
        L_0x0126:
            r20 = r6
            java.lang.String r3 = "--> END "
            if (r7 == 0) goto L_0x01fd
            if (r5 != 0) goto L_0x0138
            r21 = r2
            r22 = r5
            r5 = r16
            r16 = r10
            goto L_0x0205
        L_0x0138:
            okhttp3.Headers r6 = r4.headers()
            boolean r6 = bodyHasUnknownEncoding(r6)
            if (r6 == 0) goto L_0x016a
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.StringBuilder r3 = r11.append(r3)
            java.lang.String r11 = r4.method()
            java.lang.StringBuilder r3 = r3.append(r11)
            java.lang.String r11 = " (encoded body omitted)"
            java.lang.StringBuilder r3 = r3.append(r11)
            java.lang.String r3 = r3.toString()
            r6.log(r3)
            r22 = r5
            r5 = r16
            r16 = r10
            goto L_0x0229
        L_0x016a:
            okio.Buffer r6 = new okio.Buffer
            r6.<init>()
            r9.writeTo(r6)
            java.nio.charset.Charset r11 = UTF8
            okhttp3.MediaType r14 = r9.contentType()
            if (r14 == 0) goto L_0x0183
            r21 = r2
            java.nio.charset.Charset r2 = UTF8
            java.nio.charset.Charset r11 = r14.charset(r2)
            goto L_0x0185
        L_0x0183:
            r21 = r2
        L_0x0185:
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            r22 = r5
            r5 = r16
            r2.log(r5)
            boolean r2 = isPlaintext(r6)
            if (r2 == 0) goto L_0x01cc
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            r16 = r10
            java.lang.String r10 = r6.readString(r11)
            r2.log(r10)
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.StringBuilder r3 = r10.append(r3)
            java.lang.String r10 = r4.method()
            java.lang.StringBuilder r3 = r3.append(r10)
            java.lang.StringBuilder r3 = r3.append(r13)
            r23 = r11
            long r10 = r9.contentLength()
            java.lang.StringBuilder r3 = r3.append(r10)
            java.lang.StringBuilder r3 = r3.append(r12)
            java.lang.String r3 = r3.toString()
            r2.log(r3)
            goto L_0x0229
        L_0x01cc:
            r16 = r10
            r23 = r11
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.StringBuilder r3 = r10.append(r3)
            java.lang.String r10 = r4.method()
            java.lang.StringBuilder r3 = r3.append(r10)
            java.lang.String r10 = " (binary "
            java.lang.StringBuilder r3 = r3.append(r10)
            long r10 = r9.contentLength()
            java.lang.StringBuilder r3 = r3.append(r10)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2.log(r3)
            goto L_0x0229
        L_0x01fd:
            r21 = r2
            r22 = r5
            r5 = r16
            r16 = r10
        L_0x0205:
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r3 = r6.append(r3)
            java.lang.String r6 = r4.method()
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.String r3 = r3.toString()
            r2.log(r3)
            goto L_0x0229
        L_0x0220:
            r15 = r3
            r22 = r5
            r20 = r6
            r5 = r16
            r16 = r10
        L_0x0229:
            long r2 = java.lang.System.nanoTime()
            r6 = r31
            okhttp3.Response r10 = r6.proceed(r4)     // Catch:{ Exception -> 0x0440 }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r23 = java.lang.System.nanoTime()
            r21 = r15
            long r14 = r23 - r2
            long r14 = r11.toMillis(r14)
            okhttp3.ResponseBody r11 = r10.body()
            r23 = r2
            long r2 = r11.contentLength()
            int r17 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r17 == 0) goto L_0x0266
            r17 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.String r6 = "-byte"
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r4 = r4.toString()
            goto L_0x026a
        L_0x0266:
            r17 = r4
            java.lang.String r4 = "unknown-length"
        L_0x026a:
            okhttp3.logging.HttpLoggingInterceptor$Logger r6 = r1.logger
            r18 = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r25 = r12
            java.lang.String r12 = "<-- "
            java.lang.StringBuilder r9 = r9.append(r12)
            int r12 = r10.code()
            java.lang.StringBuilder r9 = r9.append(r12)
            java.lang.String r12 = r10.message()
            boolean r12 = r12.isEmpty()
            if (r12 == 0) goto L_0x0293
            r26 = r2
            r3 = r5
            r2 = 32
            goto L_0x02ac
        L_0x0293:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r26 = r2
            r2 = 32
            java.lang.StringBuilder r3 = r12.append(r2)
            java.lang.String r12 = r10.message()
            java.lang.StringBuilder r3 = r3.append(r12)
            java.lang.String r3 = r3.toString()
        L_0x02ac:
            java.lang.StringBuilder r3 = r9.append(r3)
            java.lang.StringBuilder r2 = r3.append(r2)
            okhttp3.Request r3 = r10.request()
            okhttp3.HttpUrl r3 = r3.url()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r13)
            java.lang.StringBuilder r2 = r2.append(r14)
            java.lang.String r3 = "ms"
            java.lang.StringBuilder r2 = r2.append(r3)
            if (r8 != 0) goto L_0x02ea
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r9 = ", "
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r9 = " body"
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            goto L_0x02eb
        L_0x02ea:
            r3 = r5
        L_0x02eb:
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = 41
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r6.log(r2)
            if (r8 == 0) goto L_0x043c
            okhttp3.Headers r2 = r10.headers()
            r3 = 0
            int r6 = r2.size()
        L_0x0307:
            if (r3 >= r6) goto L_0x030f
            r1.logHeader(r2, r3)
            int r3 = r3 + 1
            goto L_0x0307
        L_0x030f:
            if (r7 == 0) goto L_0x042f
            boolean r3 = okhttp3.internal.http.HttpHeaders.hasBody(r10)
            if (r3 != 0) goto L_0x031e
            r19 = r2
            r13 = r7
            r29 = r8
            goto L_0x0434
        L_0x031e:
            okhttp3.Headers r3 = r10.headers()
            boolean r3 = bodyHasUnknownEncoding(r3)
            if (r3 == 0) goto L_0x0334
            okhttp3.logging.HttpLoggingInterceptor$Logger r0 = r1.logger
            java.lang.String r3 = "<-- END HTTP (encoded body omitted)"
            r0.log(r3)
            r13 = r7
            r29 = r8
            goto L_0x043f
        L_0x0334:
            okio.BufferedSource r3 = r11.source()
            r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3.request(r12)
            okio.Buffer r6 = r3.buffer()
            r9 = 0
            java.lang.String r12 = "Content-Encoding"
            java.lang.String r12 = r2.get(r12)
            java.lang.String r13 = "gzip"
            boolean r12 = r13.equalsIgnoreCase(r12)
            if (r12 == 0) goto L_0x0381
            long r12 = r6.size()
            java.lang.Long r9 = java.lang.Long.valueOf(r12)
            r12 = 0
            okio.GzipSource r13 = new okio.GzipSource     // Catch:{ all -> 0x0378 }
            r19 = r2
            okio.Buffer r2 = r6.clone()     // Catch:{ all -> 0x0376 }
            r13.<init>(r2)     // Catch:{ all -> 0x0376 }
            r12 = r13
            okio.Buffer r2 = new okio.Buffer     // Catch:{ all -> 0x0376 }
            r2.<init>()     // Catch:{ all -> 0x0376 }
            r6 = r2
            r6.writeAll(r12)     // Catch:{ all -> 0x0376 }
            r12.close()
            goto L_0x0383
        L_0x0376:
            r0 = move-exception
            goto L_0x037b
        L_0x0378:
            r0 = move-exception
            r19 = r2
        L_0x037b:
            if (r12 == 0) goto L_0x0380
            r12.close()
        L_0x0380:
            throw r0
        L_0x0381:
            r19 = r2
        L_0x0383:
            java.nio.charset.Charset r2 = UTF8
            okhttp3.MediaType r12 = r11.contentType()
            if (r12 == 0) goto L_0x0391
            java.nio.charset.Charset r13 = UTF8
            java.nio.charset.Charset r2 = r12.charset(r13)
        L_0x0391:
            boolean r13 = isPlaintext(r6)
            if (r13 != 0) goto L_0x03c2
            okhttp3.logging.HttpLoggingInterceptor$Logger r13 = r1.logger
            r13.log(r5)
            okhttp3.logging.HttpLoggingInterceptor$Logger r5 = r1.logger
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r28 = r3
            java.lang.String r3 = "<-- END HTTP (binary "
            java.lang.StringBuilder r3 = r13.append(r3)
            r13 = r7
            r29 = r8
            long r7 = r6.size()
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            r5.log(r0)
            return r10
        L_0x03c2:
            r28 = r3
            r13 = r7
            r29 = r8
            r7 = 0
            int r0 = (r26 > r7 ? 1 : (r26 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x03df
            okhttp3.logging.HttpLoggingInterceptor$Logger r0 = r1.logger
            r0.log(r5)
            okhttp3.logging.HttpLoggingInterceptor$Logger r0 = r1.logger
            okio.Buffer r3 = r6.clone()
            java.lang.String r3 = r3.readString(r2)
            r0.log(r3)
        L_0x03df:
            java.lang.String r0 = "<-- END HTTP ("
            if (r9 == 0) goto L_0x040e
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r0 = r5.append(r0)
            long r7 = r6.size()
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r5 = "-byte, "
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r5 = "-gzipped-byte body)"
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            r3.log(r0)
            goto L_0x043f
        L_0x040e:
            okhttp3.logging.HttpLoggingInterceptor$Logger r3 = r1.logger
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r0 = r5.append(r0)
            long r7 = r6.size()
            java.lang.StringBuilder r0 = r0.append(r7)
            r5 = r25
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            r3.log(r0)
            goto L_0x043f
        L_0x042f:
            r19 = r2
            r13 = r7
            r29 = r8
        L_0x0434:
            okhttp3.logging.HttpLoggingInterceptor$Logger r0 = r1.logger
            java.lang.String r2 = "<-- END HTTP"
            r0.log(r2)
            goto L_0x043f
        L_0x043c:
            r13 = r7
            r29 = r8
        L_0x043f:
            return r10
        L_0x0440:
            r0 = move-exception
            r23 = r2
            r17 = r4
            r13 = r7
            r29 = r8
            r18 = r9
            r21 = r15
            r2 = r0
            r0 = r2
            okhttp3.logging.HttpLoggingInterceptor$Logger r2 = r1.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<-- HTTP FAILED: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2.log(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private void logHeader(Headers headers, int i) {
        this.logger.log(headers.name(i) + ": " + (this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i)));
    }

    static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer prefix = new Buffer();
            long byteCount = 64;
            if (buffer.size() < 64) {
                byteCount = buffer.size();
            }
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    return true;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false;
        }
    }

    private static boolean bodyHasUnknownEncoding(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity") && !contentEncoding.equalsIgnoreCase("gzip");
    }
}
