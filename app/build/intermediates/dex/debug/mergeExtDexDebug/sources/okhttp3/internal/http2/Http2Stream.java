package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final Http2Connection connection;
    @Nullable
    ErrorCode errorCode;
    @Nullable
    IOException errorException;
    private boolean hasResponseHeaders;
    private final Deque<Headers> headersQueue;
    final int id;
    final StreamTimeout readTimeout;
    final FramingSink sink;
    private final FramingSource source;
    long unacknowledgedBytesRead = 0;
    final StreamTimeout writeTimeout;

    Http2Stream(int id2, Http2Connection connection2, boolean outFinished, boolean inFinished, @Nullable Headers headers) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.readTimeout = new StreamTimeout();
        this.writeTimeout = new StreamTimeout();
        if (connection2 != null) {
            this.id = id2;
            this.connection = connection2;
            this.bytesLeftInWriteWindow = (long) connection2.peerSettings.getInitialWindowSize();
            FramingSource framingSource = new FramingSource((long) connection2.okHttpSettings.getInitialWindowSize());
            this.source = framingSource;
            FramingSink framingSink = new FramingSink();
            this.sink = framingSink;
            framingSource.finished = inFinished;
            framingSink.finished = outFinished;
            if (headers != null) {
                arrayDeque.add(headers);
            }
            if (isLocallyInitiated() && headers != null) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            } else if (!isLocallyInitiated() && headers == null) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            throw new NullPointerException("connection == null");
        }
    }

    public int getId() {
        return this.id;
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.finished || this.source.closed) && ((this.sink.finished || this.sink.closed) && this.hasResponseHeaders)) {
            return false;
        }
        return true;
    }

    public boolean isLocallyInitiated() {
        if (this.connection.client == ((this.id & 1) == 1)) {
            return true;
        }
        return false;
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.Headers takeHeaders() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch:{ all -> 0x0044 }
            r0.enter()     // Catch:{ all -> 0x0044 }
        L_0x0006:
            java.util.Deque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x003d }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0018
            okhttp3.internal.http2.ErrorCode r0 = r2.errorCode     // Catch:{ all -> 0x0016 }
            if (r0 != 0) goto L_0x0018
            r2.waitForIo()     // Catch:{ all -> 0x0016 }
            goto L_0x0006
        L_0x0016:
            r0 = move-exception
            goto L_0x003e
        L_0x0018:
            okhttp3.internal.http2.Http2Stream$StreamTimeout r0 = r2.readTimeout     // Catch:{ all -> 0x0044 }
            r0.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x0044 }
            java.util.Deque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0030
            java.util.Deque<okhttp3.Headers> r0 = r2.headersQueue     // Catch:{ all -> 0x0044 }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x0044 }
            okhttp3.Headers r0 = (okhttp3.Headers) r0     // Catch:{ all -> 0x0044 }
            monitor-exit(r2)
            return r0
        L_0x0030:
            java.io.IOException r0 = r2.errorException     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0035
            goto L_0x003c
        L_0x0035:
            okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x0044 }
            okhttp3.internal.http2.ErrorCode r1 = r2.errorCode     // Catch:{ all -> 0x0044 }
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
        L_0x003c:
            throw r0     // Catch:{ all -> 0x0044 }
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            okhttp3.internal.http2.Http2Stream$StreamTimeout r1 = r2.readTimeout     // Catch:{ all -> 0x0044 }
            r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x0044 }
            throw r0     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.takeHeaders():okhttp3.Headers");
    }

    public synchronized Headers trailers() throws IOException {
        if (this.errorCode != null) {
            Throwable th = this.errorException;
            if (th == null) {
                th = new StreamResetException(this.errorCode);
            }
            throw th;
        } else if (!this.source.finished || !this.source.receiveBuffer.exhausted() || !this.source.readBuffer.exhausted()) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return this.source.trailers != null ? this.source.trailers : Util.EMPTY_HEADERS;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public void writeHeaders(List<Header> responseHeaders, boolean outFinished, boolean flushHeaders) throws IOException {
        boolean z;
        if (Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (responseHeaders != null) {
            synchronized (this) {
                z = true;
                this.hasResponseHeaders = true;
                if (outFinished) {
                    this.sink.finished = true;
                }
            }
            if (!flushHeaders) {
                synchronized (this.connection) {
                    if (this.connection.bytesLeftInWriteWindow != 0) {
                        z = false;
                    }
                    flushHeaders = z;
                }
            }
            this.connection.writeHeaders(this.id, outFinished, responseHeaders);
            if (flushHeaders) {
                this.connection.flush();
            }
        } else {
            throw new NullPointerException("headers == null");
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public void enqueueTrailers(Headers trailers) {
        synchronized (this) {
            if (this.sink.finished) {
                throw new IllegalStateException("already finished");
            } else if (trailers.size() != 0) {
                Headers unused = this.sink.trailers = trailers;
            } else {
                throw new IllegalArgumentException("trailers.size() == 0");
            }
        }
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public Source getSource() {
        return this.source;
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public Sink getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders) {
                if (!isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.sink;
    }

    public void close(ErrorCode rstStatusCode, @Nullable IOException errorException2) throws IOException {
        if (closeInternal(rstStatusCode, errorException2)) {
            this.connection.writeSynReset(this.id, rstStatusCode);
        }
    }

    public void closeLater(ErrorCode errorCode2) {
        if (closeInternal(errorCode2, (IOException) null)) {
            this.connection.writeSynResetLater(this.id, errorCode2);
        }
    }

    private boolean closeInternal(ErrorCode errorCode2, @Nullable IOException errorException2) {
        if (!Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.errorCode != null) {
                    return false;
                }
                if (this.source.finished && this.sink.finished) {
                    return false;
                }
                this.errorCode = errorCode2;
                this.errorException = errorException2;
                notifyAll();
                this.connection.removeStream(this.id);
                return true;
            }
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void receiveData(BufferedSource in, int length) throws IOException {
        if (!Thread.holdsLock(this)) {
            this.source.receive(in, (long) length);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveHeaders(okhttp3.Headers r4, boolean r5) {
        /*
            r3 = this;
            boolean r0 = java.lang.Thread.holdsLock(r3)
            if (r0 != 0) goto L_0x0037
            monitor-enter(r3)
            boolean r0 = r3.hasResponseHeaders     // Catch:{ all -> 0x0034 }
            r1 = 1
            if (r0 == 0) goto L_0x0015
            if (r5 != 0) goto L_0x000f
            goto L_0x0015
        L_0x000f:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r3.source     // Catch:{ all -> 0x0034 }
            okhttp3.Headers unused = r0.trailers = r4     // Catch:{ all -> 0x0034 }
            goto L_0x001c
        L_0x0015:
            r3.hasResponseHeaders = r1     // Catch:{ all -> 0x0034 }
            java.util.Deque<okhttp3.Headers> r0 = r3.headersQueue     // Catch:{ all -> 0x0034 }
            r0.add(r4)     // Catch:{ all -> 0x0034 }
        L_0x001c:
            if (r5 == 0) goto L_0x0022
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r3.source     // Catch:{ all -> 0x0034 }
            r0.finished = r1     // Catch:{ all -> 0x0034 }
        L_0x0022:
            boolean r0 = r3.isOpen()     // Catch:{ all -> 0x0034 }
            r3.notifyAll()     // Catch:{ all -> 0x0034 }
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x0033
            okhttp3.internal.http2.Http2Connection r1 = r3.connection
            int r2 = r3.id
            r1.removeStream(r2)
        L_0x0033:
            return
        L_0x0034:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r0
        L_0x0037:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.receiveHeaders(okhttp3.Headers, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void receiveRstStream(ErrorCode errorCode2) {
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            notifyAll();
        }
    }

    private final class FramingSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        /* access modifiers changed from: private */
        public final Buffer readBuffer = new Buffer();
        /* access modifiers changed from: private */
        public final Buffer receiveBuffer = new Buffer();
        /* access modifiers changed from: private */
        public Headers trailers;

        static {
            Class<Http2Stream> cls = Http2Stream.class;
        }

        FramingSource(long maxByteCount2) {
            this.maxByteCount = maxByteCount2;
        }

        /* Debug info: failed to restart local var, previous not found, register: 10 */
        public long read(Buffer sink, long byteCount) throws IOException {
            long readBytesDelivered;
            IOException errorExceptionToDeliver;
            IOException iOException;
            if (byteCount >= 0) {
                while (true) {
                    readBytesDelivered = -1;
                    errorExceptionToDeliver = null;
                    synchronized (Http2Stream.this) {
                        Http2Stream.this.readTimeout.enter();
                        try {
                            if (Http2Stream.this.errorCode != null) {
                                if (Http2Stream.this.errorException != null) {
                                    iOException = Http2Stream.this.errorException;
                                } else {
                                    iOException = new StreamResetException(Http2Stream.this.errorCode);
                                }
                                errorExceptionToDeliver = iOException;
                            }
                            if (!this.closed) {
                                if (this.readBuffer.size() <= 0) {
                                    if (this.finished || errorExceptionToDeliver != null) {
                                        break;
                                    }
                                    Http2Stream.this.waitForIo();
                                } else {
                                    Buffer buffer = this.readBuffer;
                                    readBytesDelivered = buffer.read(sink, Math.min(byteCount, buffer.size()));
                                    Http2Stream.this.unacknowledgedBytesRead += readBytesDelivered;
                                    if (errorExceptionToDeliver == null && Http2Stream.this.unacknowledgedBytesRead >= ((long) (Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2))) {
                                        Http2Stream.this.connection.writeWindowUpdateLater(Http2Stream.this.id, Http2Stream.this.unacknowledgedBytesRead);
                                        Http2Stream.this.unacknowledgedBytesRead = 0;
                                    }
                                }
                            } else {
                                throw new IOException("stream closed");
                            }
                        } finally {
                            Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                        }
                    }
                }
                Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                if (readBytesDelivered != -1) {
                    updateConnectionFlowControl(readBytesDelivered);
                    return readBytesDelivered;
                } else if (errorExceptionToDeliver == null) {
                    return -1;
                } else {
                    throw errorExceptionToDeliver;
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: " + byteCount);
            }
        }

        private void updateConnectionFlowControl(long read) {
            if (!Thread.holdsLock(Http2Stream.this)) {
                Http2Stream.this.connection.updateConnectionFlowControl(read);
                return;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void receive(BufferedSource in, long byteCount) throws IOException {
            boolean finished2;
            boolean z;
            boolean flowControlError;
            BufferedSource bufferedSource = in;
            if (!Thread.holdsLock(Http2Stream.this)) {
                long bytesDiscarded = byteCount;
                while (bytesDiscarded > 0) {
                    synchronized (Http2Stream.this) {
                        finished2 = this.finished;
                        z = true;
                        flowControlError = this.readBuffer.size() + bytesDiscarded > this.maxByteCount;
                    }
                    if (flowControlError) {
                        bufferedSource.skip(bytesDiscarded);
                        Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (finished2) {
                        bufferedSource.skip(bytesDiscarded);
                        return;
                    } else {
                        long read = bufferedSource.read(this.receiveBuffer, bytesDiscarded);
                        if (read != -1) {
                            long byteCount2 = bytesDiscarded - read;
                            long bytesDiscarded2 = 0;
                            synchronized (Http2Stream.this) {
                                if (this.closed) {
                                    bytesDiscarded2 = this.receiveBuffer.size();
                                    this.receiveBuffer.clear();
                                } else {
                                    if (this.readBuffer.size() != 0) {
                                        z = false;
                                    }
                                    boolean wasEmpty = z;
                                    this.readBuffer.writeAll(this.receiveBuffer);
                                    if (wasEmpty) {
                                        Http2Stream.this.notifyAll();
                                    }
                                }
                            }
                            if (bytesDiscarded2 > 0) {
                                updateConnectionFlowControl(bytesDiscarded2);
                            }
                            bytesDiscarded = byteCount2;
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }

        public void close() throws IOException {
            long bytesDiscarded;
            synchronized (Http2Stream.this) {
                this.closed = true;
                bytesDiscarded = this.readBuffer.size();
                this.readBuffer.clear();
                Http2Stream.this.notifyAll();
            }
            if (bytesDiscarded > 0) {
                updateConnectionFlowControl(bytesDiscarded);
            }
            Http2Stream.this.cancelStreamIfNecessary();
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelStreamIfNecessary() throws IOException {
        boolean cancel;
        boolean open;
        if (!Thread.holdsLock(this)) {
            synchronized (this) {
                cancel = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
                open = isOpen();
            }
            if (cancel) {
                close(ErrorCode.CANCEL, (IOException) null);
            } else if (!open) {
                this.connection.removeStream(this.id);
            }
        } else {
            throw new AssertionError();
        }
    }

    final class FramingSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final Buffer sendBuffer = new Buffer();
        /* access modifiers changed from: private */
        public Headers trailers;

        static {
            Class<Http2Stream> cls = Http2Stream.class;
        }

        FramingSink() {
        }

        public void write(Buffer source, long byteCount) throws IOException {
            if (!Thread.holdsLock(Http2Stream.this)) {
                this.sendBuffer.write(source, byteCount);
                while (this.sendBuffer.size() >= EMIT_BUFFER_SIZE) {
                    emitFrame(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* Debug info: failed to restart local var, previous not found, register: 9 */
        /* JADX INFO: finally extract failed */
        private void emitFrame(boolean outFinishedOnLastFrame) throws IOException {
            long toWrite;
            boolean outFinished;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (Http2Stream.this.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && Http2Stream.this.errorCode == null) {
                    try {
                        Http2Stream.this.waitForIo();
                    } catch (Throwable th) {
                        Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed();
                toWrite = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                Http2Stream.this.bytesLeftInWriteWindow -= toWrite;
            }
            Http2Stream.this.writeTimeout.enter();
            if (outFinishedOnLastFrame) {
                try {
                    if (toWrite == this.sendBuffer.size()) {
                        outFinished = true;
                        Http2Stream.this.connection.writeData(Http2Stream.this.id, outFinished, this.sendBuffer, toWrite);
                        Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                    }
                } catch (Throwable th2) {
                    Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                    throw th2;
                }
            }
            outFinished = false;
            Http2Stream.this.connection.writeData(Http2Stream.this.id, outFinished, this.sendBuffer, toWrite);
            Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
        }

        public void flush() throws IOException {
            if (!Thread.holdsLock(Http2Stream.this)) {
                synchronized (Http2Stream.this) {
                    Http2Stream.this.checkOutNotClosed();
                }
                while (this.sendBuffer.size() > 0) {
                    emitFrame(false);
                    Http2Stream.this.connection.flush();
                }
                return;
            }
            throw new AssertionError();
        }

        public Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r10.this$0.sink.finished != false) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
            if (r10.sendBuffer.size() <= 0) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
            if (r10.trailers == null) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
            if (r3 == false) goto L_0x0054;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
            if (r10.sendBuffer.size() <= 0) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
            emitFrame(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
            r10.this$0.connection.writeHeaders(r10.this$0.id, true, okhttp3.internal.Util.toHeaderBlock(r10.trailers));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
            if (r0 == false) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
            if (r10.sendBuffer.size() <= 0) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
            emitFrame(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
            r10.this$0.connection.writeData(r10.this$0.id, true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
            r2 = r10.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0075, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            r10.closed = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0078, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0079, code lost:
            r10.this$0.connection.flush();
            r10.this$0.cancelStreamIfNecessary();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0085, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r10 = this;
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                boolean r0 = java.lang.Thread.holdsLock(r0)
                if (r0 != 0) goto L_0x008c
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r0)
                boolean r1 = r10.closed     // Catch:{ all -> 0x0089 }
                if (r1 == 0) goto L_0x0011
                monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                return
            L_0x0011:
                monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Stream$FramingSink r0 = r0.sink
                boolean r0 = r0.finished
                r1 = 1
                if (r0 != 0) goto L_0x0073
                okio.Buffer r0 = r10.sendBuffer
                long r2 = r0.size()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                r2 = 0
                if (r0 <= 0) goto L_0x002a
                r0 = r1
                goto L_0x002b
            L_0x002a:
                r0 = r2
            L_0x002b:
                okhttp3.Headers r3 = r10.trailers
                if (r3 == 0) goto L_0x0031
                r3 = r1
                goto L_0x0032
            L_0x0031:
                r3 = r2
            L_0x0032:
                if (r3 == 0) goto L_0x0054
            L_0x0034:
                okio.Buffer r6 = r10.sendBuffer
                long r6 = r6.size()
                int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x0042
                r10.emitFrame(r2)
                goto L_0x0034
            L_0x0042:
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r2 = r2.connection
                okhttp3.internal.http2.Http2Stream r4 = okhttp3.internal.http2.Http2Stream.this
                int r4 = r4.id
                okhttp3.Headers r5 = r10.trailers
                java.util.List r5 = okhttp3.internal.Util.toHeaderBlock(r5)
                r2.writeHeaders(r4, r1, r5)
                goto L_0x0073
            L_0x0054:
                if (r0 == 0) goto L_0x0064
            L_0x0056:
                okio.Buffer r2 = r10.sendBuffer
                long r6 = r2.size()
                int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r2 <= 0) goto L_0x0073
                r10.emitFrame(r1)
                goto L_0x0056
            L_0x0064:
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r4 = r2.connection
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this
                int r5 = r2.id
                r6 = 1
                r7 = 0
                r8 = 0
                r4.writeData(r5, r6, r7, r8)
            L_0x0073:
                okhttp3.internal.http2.Http2Stream r2 = okhttp3.internal.http2.Http2Stream.this
                monitor-enter(r2)
                r10.closed = r1     // Catch:{ all -> 0x0086 }
                monitor-exit(r2)     // Catch:{ all -> 0x0086 }
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                okhttp3.internal.http2.Http2Connection r0 = r0.connection
                r0.flush()
                okhttp3.internal.http2.Http2Stream r0 = okhttp3.internal.http2.Http2Stream.this
                r0.cancelStreamIfNecessary()
                return
            L_0x0086:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0086 }
                throw r0
            L_0x0089:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0089 }
                throw r1
            L_0x008c:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSink.close():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void addBytesToWriteWindow(long delta) {
        this.bytesLeftInWriteWindow += delta;
        if (delta > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void checkOutNotClosed() throws IOException {
        if (this.sink.closed) {
            throw new IOException("stream closed");
        } else if (this.sink.finished) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            Throwable th = this.errorException;
            if (th == null) {
                th = new StreamResetException(this.errorCode);
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
            Http2Stream.this.connection.sendDegradedPingLater();
        }

        /* access modifiers changed from: protected */
        public IOException newTimeoutException(IOException cause) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (cause != null) {
                socketTimeoutException.initCause(cause);
            }
            return socketTimeoutException;
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }
    }
}
