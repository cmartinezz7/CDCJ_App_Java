package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public abstract class ResponseBody implements Closeable {
    @Nullable
    private Reader reader;

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final InputStream byteStream() {
        return source().inputStream();
    }

    /* Debug info: failed to restart local var, previous not found, register: 6 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        if (r2 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        $closeResource(r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] bytes() throws java.io.IOException {
        /*
            r6 = this;
            long r0 = r6.contentLength()
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x005a
            okio.BufferedSource r2 = r6.source()
            r3 = 0
            byte[] r4 = r2.readByteArray()     // Catch:{ all -> 0x0051 }
            if (r2 == 0) goto L_0x0019
            $closeResource(r3, r2)
        L_0x0019:
            r2 = -1
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0050
            int r2 = r4.length
            long r2 = (long) r2
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0026
            goto L_0x0050
        L_0x0026:
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Content-Length ("
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r5 = ") and stream length ("
            java.lang.StringBuilder r3 = r3.append(r5)
            int r5 = r4.length
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r5 = ") disagree"
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x0050:
            return r4
        L_0x0051:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r4 = move-exception
            if (r2 == 0) goto L_0x0059
            $closeResource(r3, r2)
        L_0x0059:
            throw r4
        L_0x005a:
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cannot buffer entire body for content length: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.ResponseBody.bytes():byte[]");
    }

    private static /* synthetic */ void $closeResource(Throwable x0, AutoCloseable x1) {
        if (x0 != null) {
            try {
                x1.close();
            } catch (Throwable th) {
                x0.addSuppressed(th);
            }
        } else {
            x1.close();
        }
    }

    public final Reader charStream() {
        Reader r = this.reader;
        if (r != null) {
            return r;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r0 != null) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        $closeResource(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        r2 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String string() throws java.io.IOException {
        /*
            r4 = this;
            okio.BufferedSource r0 = r4.source()
            java.nio.charset.Charset r1 = r4.charset()     // Catch:{ all -> 0x0017 }
            java.nio.charset.Charset r1 = okhttp3.internal.Util.bomAwareCharset(r0, r1)     // Catch:{ all -> 0x0017 }
            java.lang.String r2 = r0.readString(r1)     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0016
            r3 = 0
            $closeResource(r3, r0)
        L_0x0016:
            return r2
        L_0x0017:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r2 = move-exception
            if (r0 == 0) goto L_0x001f
            $closeResource(r1, r0)
        L_0x001f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.ResponseBody.string():java.lang.String");
    }

    private Charset charset() {
        MediaType contentType = contentType();
        Charset charset = StandardCharsets.UTF_8;
        return contentType != null ? contentType.charset(charset) : charset;
    }

    public void close() {
        Util.closeQuietly((Closeable) source());
    }

    public static ResponseBody create(@Nullable MediaType contentType, String content) {
        Charset charset = StandardCharsets.UTF_8;
        if (contentType != null && (charset = contentType.charset()) == null) {
            charset = StandardCharsets.UTF_8;
            contentType = MediaType.parse(contentType + "; charset=utf-8");
        }
        Buffer buffer = new Buffer().writeString(content, charset);
        return create(contentType, buffer.size(), buffer);
    }

    public static ResponseBody create(@Nullable MediaType contentType, byte[] content) {
        return create(contentType, (long) content.length, new Buffer().write(content));
    }

    public static ResponseBody create(@Nullable MediaType contentType, ByteString content) {
        return create(contentType, (long) content.size(), new Buffer().write(content));
    }

    public static ResponseBody create(@Nullable final MediaType contentType, final long contentLength, final BufferedSource content) {
        if (content != null) {
            return new ResponseBody() {
                @Nullable
                public MediaType contentType() {
                    return MediaType.this;
                }

                public long contentLength() {
                    return contentLength;
                }

                public BufferedSource source() {
                    return content;
                }
            };
        }
        throw new NullPointerException("source == null");
    }

    static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        @Nullable
        private Reader delegate;
        private final BufferedSource source;

        BomAwareReader(BufferedSource source2, Charset charset2) {
            this.source = source2;
            this.charset = charset2;
        }

        public int read(char[] cbuf, int off, int len) throws IOException {
            if (!this.closed) {
                Reader delegate2 = this.delegate;
                if (delegate2 == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.source.inputStream(), Util.bomAwareCharset(this.source, this.charset));
                    this.delegate = inputStreamReader;
                    delegate2 = inputStreamReader;
                }
                return delegate2.read(cbuf, off, len);
            }
            throw new IOException("Stream closed");
        }

        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }
    }
}
