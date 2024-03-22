package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int AWAIT_PING = 3;
    static final int DEGRADED_PING = 2;
    static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    static final int INTERVAL_PING = 1;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    /* access modifiers changed from: private */
    public static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    private long awaitPingsSent = 0;
    private long awaitPongsReceived = 0;
    long bytesLeftInWriteWindow;
    final boolean client;
    final String connectionName;
    final Set<Integer> currentPushRequests;
    private long degradedPingsSent = 0;
    private long degradedPongDeadlineNs = 0;
    private long degradedPongsReceived = 0;
    /* access modifiers changed from: private */
    public long intervalPingsSent = 0;
    /* access modifiers changed from: private */
    public long intervalPongsReceived = 0;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    Settings okHttpSettings = new Settings();
    final Settings peerSettings;
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final ReaderRunnable readerRunnable;
    /* access modifiers changed from: private */
    public boolean shutdown;
    final Socket socket;
    final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    long unacknowledgedBytesRead = 0;
    final Http2Writer writer;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService writerExecutor;

    static /* synthetic */ long access$108(Http2Connection x0) {
        long j = x0.intervalPongsReceived;
        x0.intervalPongsReceived = 1 + j;
        return j;
    }

    static /* synthetic */ long access$208(Http2Connection x0) {
        long j = x0.intervalPingsSent;
        x0.intervalPingsSent = 1 + j;
        return j;
    }

    static /* synthetic */ long access$608(Http2Connection x0) {
        long j = x0.degradedPongsReceived;
        x0.degradedPongsReceived = 1 + j;
        return j;
    }

    static /* synthetic */ long access$708(Http2Connection x0) {
        long j = x0.awaitPongsReceived;
        x0.awaitPongsReceived = 1 + j;
        return j;
    }

    Http2Connection(Builder builder) {
        Builder builder2 = builder;
        Settings settings = new Settings();
        this.peerSettings = settings;
        this.currentPushRequests = new LinkedHashSet();
        this.pushObserver = builder2.pushObserver;
        boolean z = builder2.client;
        this.client = z;
        this.listener = builder2.listener;
        this.nextStreamId = builder2.client ? 1 : 2;
        if (builder2.client) {
            this.nextStreamId += 2;
        }
        if (builder2.client) {
            this.okHttpSettings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        String str = builder2.connectionName;
        this.connectionName = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", str), false));
        this.writerExecutor = scheduledThreadPoolExecutor;
        if (builder2.pingIntervalMillis != 0) {
            scheduledThreadPoolExecutor.scheduleAtFixedRate(new IntervalPingRunnable(), (long) builder2.pingIntervalMillis, (long) builder2.pingIntervalMillis, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", str), true));
        settings.set(7, 65535);
        settings.set(5, 16384);
        this.bytesLeftInWriteWindow = (long) settings.getInitialWindowSize();
        this.socket = builder2.socket;
        this.writer = new Http2Writer(builder2.sink, z);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder2.source, z));
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream getStream(int id) {
        return this.streams.get(Integer.valueOf(id));
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream removeStream(int streamId) {
        Http2Stream stream;
        stream = this.streams.remove(Integer.valueOf(streamId));
        notifyAll();
        return stream;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateConnectionFlowControl(long read) {
        long j = this.unacknowledgedBytesRead + read;
        this.unacknowledgedBytesRead = j;
        if (j >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0;
        }
    }

    public Http2Stream pushStream(int associatedStreamId, List<Header> requestHeaders, boolean out) throws IOException {
        if (!this.client) {
            return newStream(associatedStreamId, requestHeaders, out);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    public Http2Stream newStream(List<Header> requestHeaders, boolean out) throws IOException {
        return newStream(0, requestHeaders, out);
    }

    /* Debug info: failed to restart local var, previous not found, register: 11 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.http2.Http2Stream newStream(int r12, java.util.List<okhttp3.internal.http2.Header> r13, boolean r14) throws java.io.IOException {
        /*
            r11 = this;
            r0 = r14 ^ 1
            r7 = 0
            okhttp3.internal.http2.Http2Writer r8 = r11.writer
            monitor-enter(r8)
            monitor-enter(r11)     // Catch:{ all -> 0x0079 }
            int r1 = r11.nextStreamId     // Catch:{ all -> 0x0076 }
            r2 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 <= r2) goto L_0x0013
            okhttp3.internal.http2.ErrorCode r1 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0076 }
            r11.shutdown(r1)     // Catch:{ all -> 0x0076 }
        L_0x0013:
            boolean r1 = r11.shutdown     // Catch:{ all -> 0x0076 }
            if (r1 != 0) goto L_0x0070
            int r1 = r11.nextStreamId     // Catch:{ all -> 0x0076 }
            r9 = r1
            int r1 = r1 + 2
            r11.nextStreamId = r1     // Catch:{ all -> 0x0076 }
            okhttp3.internal.http2.Http2Stream r10 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0076 }
            r6 = 0
            r1 = r10
            r2 = r9
            r3 = r11
            r4 = r0
            r5 = r7
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0076 }
            r1 = r10
            if (r14 == 0) goto L_0x003d
            long r2 = r11.bytesLeftInWriteWindow     // Catch:{ all -> 0x0076 }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x003d
            long r2 = r1.bytesLeftInWriteWindow     // Catch:{ all -> 0x0076 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r2 = 0
            goto L_0x003e
        L_0x003d:
            r2 = 1
        L_0x003e:
            boolean r3 = r1.isOpen()     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x004d
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r3 = r11.streams     // Catch:{ all -> 0x0076 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0076 }
            r3.put(r4, r1)     // Catch:{ all -> 0x0076 }
        L_0x004d:
            monitor-exit(r11)     // Catch:{ all -> 0x0076 }
            if (r12 != 0) goto L_0x0056
            okhttp3.internal.http2.Http2Writer r3 = r11.writer     // Catch:{ all -> 0x0079 }
            r3.headers(r0, r9, r13)     // Catch:{ all -> 0x0079 }
            goto L_0x005f
        L_0x0056:
            boolean r3 = r11.client     // Catch:{ all -> 0x0079 }
            if (r3 != 0) goto L_0x0068
            okhttp3.internal.http2.Http2Writer r3 = r11.writer     // Catch:{ all -> 0x0079 }
            r3.pushPromise(r12, r9, r13)     // Catch:{ all -> 0x0079 }
        L_0x005f:
            monitor-exit(r8)     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x0067
            okhttp3.internal.http2.Http2Writer r3 = r11.writer
            r3.flush()
        L_0x0067:
            return r1
        L_0x0068:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0079 }
            java.lang.String r4 = "client streams shouldn't have associated stream IDs"
            r3.<init>(r4)     // Catch:{ all -> 0x0079 }
            throw r3     // Catch:{ all -> 0x0079 }
        L_0x0070:
            okhttp3.internal.http2.ConnectionShutdownException r1 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0076 }
            r1.<init>()     // Catch:{ all -> 0x0076 }
            throw r1     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r1 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0076 }
            throw r1     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r1 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0079 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    /* access modifiers changed from: package-private */
    public void writeHeaders(int streamId, boolean outFinished, List<Header> alternating) throws IOException {
        this.writer.headers(outFinished, streamId, alternating);
    }

    /* Debug info: failed to restart local var, previous not found, register: 8 */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.writer.maxDataLength());
        r8.bytesLeftInWriteWindow -= (long) r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeData(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L_0x000d
            okhttp3.internal.http2.Http2Writer r0 = r8.writer
            r0.data(r10, r9, r11, r3)
            return
        L_0x000d:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x006b
            monitor-enter(r8)
        L_0x0012:
            long r4 = r8.bytesLeftInWriteWindow     // Catch:{ InterruptedException -> 0x005b }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r2 = r8.streams     // Catch:{ InterruptedException -> 0x005b }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005b }
            boolean r2 = r2.containsKey(r4)     // Catch:{ InterruptedException -> 0x005b }
            if (r2 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x005b }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005b }
            java.lang.String r1 = "stream closed"
            r0.<init>(r1)     // Catch:{ InterruptedException -> 0x005b }
            throw r0     // Catch:{ InterruptedException -> 0x005b }
        L_0x0030:
            long r4 = java.lang.Math.min(r12, r4)     // Catch:{ all -> 0x0059 }
            int r2 = (int) r4     // Catch:{ all -> 0x0059 }
            okhttp3.internal.http2.Http2Writer r4 = r8.writer     // Catch:{ all -> 0x0059 }
            int r4 = r4.maxDataLength()     // Catch:{ all -> 0x0059 }
            int r4 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x0059 }
            r2 = r4
            long r4 = r8.bytesLeftInWriteWindow     // Catch:{ all -> 0x0059 }
            long r6 = (long) r2     // Catch:{ all -> 0x0059 }
            long r4 = r4 - r6
            r8.bytesLeftInWriteWindow = r4     // Catch:{ all -> 0x0059 }
            monitor-exit(r8)     // Catch:{ all -> 0x0059 }
            long r4 = (long) r2
            long r12 = r12 - r4
            okhttp3.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L_0x0054
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x0054
            r5 = 1
            goto L_0x0055
        L_0x0054:
            r5 = r3
        L_0x0055:
            r4.data(r5, r9, r11, r2)
            goto L_0x000d
        L_0x0059:
            r0 = move-exception
            goto L_0x0069
        L_0x005b:
            r0 = move-exception
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0059 }
            r1.interrupt()     // Catch:{ all -> 0x0059 }
            java.io.InterruptedIOException r1 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0059 }
            r1.<init>()     // Catch:{ all -> 0x0059 }
            throw r1     // Catch:{ all -> 0x0059 }
        L_0x0069:
            monitor-exit(r8)     // Catch:{ all -> 0x0059 }
            throw r0
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    /* access modifiers changed from: package-private */
    public void writeSynResetLater(int streamId, ErrorCode errorCode) {
        try {
            final int i = streamId;
            final ErrorCode errorCode2 = errorCode;
            this.writerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.connectionName, Integer.valueOf(streamId)}) {
                public void execute() {
                    try {
                        Http2Connection.this.writeSynReset(i, errorCode2);
                    } catch (IOException e) {
                        Http2Connection.this.failConnection(e);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
        }
    }

    /* access modifiers changed from: package-private */
    public void writeSynReset(int streamId, ErrorCode statusCode) throws IOException {
        this.writer.rstStream(streamId, statusCode);
    }

    /* access modifiers changed from: package-private */
    public void writeWindowUpdateLater(int streamId, long unacknowledgedBytesRead2) {
        try {
            final int i = streamId;
            final long j = unacknowledgedBytesRead2;
            this.writerExecutor.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.connectionName, Integer.valueOf(streamId)}) {
                public void execute() {
                    try {
                        Http2Connection.this.writer.windowUpdate(i, j);
                    } catch (IOException e) {
                        Http2Connection.this.failConnection(e);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
        }
    }

    final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        PingRunnable(boolean reply2, int payload12, int payload22) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.connectionName, Integer.valueOf(payload12), Integer.valueOf(payload22));
            this.reply = reply2;
            this.payload1 = payload12;
            this.payload2 = payload22;
        }

        public void execute() {
            Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    final class IntervalPingRunnable extends NamedRunnable {
        IntervalPingRunnable() {
            super("OkHttp %s ping", Http2Connection.this.connectionName);
        }

        public void execute() {
            boolean failDueToMissingPong;
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.intervalPongsReceived < Http2Connection.this.intervalPingsSent) {
                    failDueToMissingPong = true;
                } else {
                    Http2Connection.access$208(Http2Connection.this);
                    failDueToMissingPong = false;
                }
            }
            if (failDueToMissingPong) {
                Http2Connection.this.failConnection((IOException) null);
            } else {
                Http2Connection.this.writePing(false, 1, 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void writePing(boolean reply, int payload1, int payload2) {
        try {
            this.writer.ping(reply, payload1, payload2);
        } catch (IOException e) {
            failConnection(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    /* access modifiers changed from: package-private */
    public void writePing() {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }

    /* access modifiers changed from: package-private */
    public synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public void shutdown(ErrorCode statusCode) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    int lastGoodStreamId2 = this.lastGoodStreamId;
                    this.writer.goAway(lastGoodStreamId2, statusCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void close() {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL, (IOException) null);
    }

    /* access modifiers changed from: package-private */
    public void close(ErrorCode connectionCode, ErrorCode streamCode, @Nullable IOException cause) {
        if (!Thread.holdsLock(this)) {
            try {
                shutdown(connectionCode);
            } catch (IOException e) {
            }
            Http2Stream[] streamsToClose = null;
            synchronized (this) {
                if (!this.streams.isEmpty()) {
                    streamsToClose = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                    this.streams.clear();
                }
            }
            if (streamsToClose != null) {
                for (Http2Stream stream : streamsToClose) {
                    try {
                        stream.close(streamCode, cause);
                    } catch (IOException e2) {
                    }
                }
            }
            try {
                this.writer.close();
            } catch (IOException e3) {
            }
            try {
                this.socket.close();
            } catch (IOException e4) {
            }
            this.writerExecutor.shutdown();
            this.pushExecutor.shutdown();
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public void failConnection(@Nullable IOException e) {
        close(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, e);
    }

    public void start() throws IOException {
        start(true);
    }

    /* access modifiers changed from: package-private */
    public void start(boolean sendConnectionPreface) throws IOException {
        if (sendConnectionPreface) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int windowSize = this.okHttpSettings.getInitialWindowSize();
            if (windowSize != 65535) {
                this.writer.windowUpdate(0, (long) (windowSize - 65535));
            }
        }
        new Thread(this.readerRunnable).start();
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public void setSettings(Settings settings) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.okHttpSettings.merge(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.settings(settings);
        }
    }

    public synchronized boolean isHealthy(long nowNs) {
        if (this.shutdown) {
            return false;
        }
        if (this.degradedPongsReceived >= this.degradedPingsSent || nowNs < this.degradedPongDeadlineNs) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void sendDegradedPingLater() {
        synchronized (this) {
            long j = this.degradedPongsReceived;
            long j2 = this.degradedPingsSent;
            if (j >= j2) {
                this.degradedPingsSent = j2 + 1;
                this.degradedPongDeadlineNs = System.nanoTime() + DEGRADED_PONG_TIMEOUT_NS;
                try {
                    this.writerExecutor.execute(new NamedRunnable("OkHttp %s ping", this.connectionName) {
                        public void execute() {
                            Http2Connection.this.writePing(false, 2, 0);
                        }
                    });
                } catch (RejectedExecutionException e) {
                }
            }
        }
    }

    public static class Builder {
        boolean client;
        String connectionName;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        int pingIntervalMillis;
        PushObserver pushObserver = PushObserver.CANCEL;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;

        public Builder(boolean client2) {
            this.client = client2;
        }

        public Builder socket(Socket socket2) throws IOException {
            String connectionName2;
            SocketAddress remoteSocketAddress = socket2.getRemoteSocketAddress();
            if (remoteSocketAddress instanceof InetSocketAddress) {
                connectionName2 = ((InetSocketAddress) remoteSocketAddress).getHostName();
            } else {
                connectionName2 = remoteSocketAddress.toString();
            }
            return socket(socket2, connectionName2, Okio.buffer(Okio.source(socket2)), Okio.buffer(Okio.sink(socket2)));
        }

        public Builder socket(Socket socket2, String connectionName2, BufferedSource source2, BufferedSink sink2) {
            this.socket = socket2;
            this.connectionName = connectionName2;
            this.source = source2;
            this.sink = sink2;
            return this;
        }

        public Builder listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public Builder pingIntervalMillis(int pingIntervalMillis2) {
            this.pingIntervalMillis = pingIntervalMillis2;
            return this;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;

        ReaderRunnable(Http2Reader reader2) {
            super("OkHttp %s", Http2Connection.this.connectionName);
            this.reader = reader2;
        }

        /* access modifiers changed from: protected */
        public void execute() {
            ErrorCode streamErrorCode;
            ErrorCode connectionErrorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode streamErrorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException errorException = null;
            try {
                this.reader.readConnectionPreface(this);
                while (this.reader.nextFrame(false, this)) {
                }
                connectionErrorCode = ErrorCode.NO_ERROR;
                streamErrorCode = ErrorCode.CANCEL;
            } catch (IOException e) {
                errorException = e;
                connectionErrorCode = ErrorCode.PROTOCOL_ERROR;
                streamErrorCode = ErrorCode.PROTOCOL_ERROR;
            } catch (Throwable th) {
                Http2Connection.this.close(connectionErrorCode, streamErrorCode2, errorException);
                Util.closeQuietly((Closeable) this.reader);
                throw th;
            }
            Http2Connection.this.close(connectionErrorCode, streamErrorCode, errorException);
            Util.closeQuietly((Closeable) this.reader);
        }

        public void data(boolean inFinished, int streamId, BufferedSource source, int length) throws IOException {
            if (Http2Connection.this.pushedStream(streamId)) {
                Http2Connection.this.pushDataLater(streamId, source, length, inFinished);
                return;
            }
            Http2Stream dataStream = Http2Connection.this.getStream(streamId);
            if (dataStream == null) {
                Http2Connection.this.writeSynResetLater(streamId, ErrorCode.PROTOCOL_ERROR);
                Http2Connection.this.updateConnectionFlowControl((long) length);
                source.skip((long) length);
                return;
            }
            dataStream.receiveData(source, length);
            if (inFinished) {
                dataStream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        public void headers(boolean inFinished, int streamId, int associatedStreamId, List<Header> headerBlock) {
            if (Http2Connection.this.pushedStream(streamId)) {
                Http2Connection.this.pushHeadersLater(streamId, headerBlock, inFinished);
                return;
            }
            synchronized (Http2Connection.this) {
                Http2Stream stream = Http2Connection.this.getStream(streamId);
                if (stream != null) {
                    stream.receiveHeaders(Util.toHeaders(headerBlock), inFinished);
                } else if (!Http2Connection.this.shutdown) {
                    if (streamId > Http2Connection.this.lastGoodStreamId) {
                        if (streamId % 2 != Http2Connection.this.nextStreamId % 2) {
                            int i = streamId;
                            final Http2Stream http2Stream = new Http2Stream(i, Http2Connection.this, false, inFinished, Util.toHeaders(headerBlock));
                            Http2Connection.this.lastGoodStreamId = streamId;
                            Http2Connection.this.streams.put(Integer.valueOf(streamId), http2Stream);
                            Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.connectionName, Integer.valueOf(streamId)}) {
                                public void execute() {
                                    try {
                                        Http2Connection.this.listener.onStream(http2Stream);
                                    } catch (IOException e) {
                                        Platform.get().log(4, "Http2Connection.Listener failure for " + Http2Connection.this.connectionName, e);
                                        try {
                                            http2Stream.close(ErrorCode.PROTOCOL_ERROR, e);
                                        } catch (IOException e2) {
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }

        public void rstStream(int streamId, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream(streamId)) {
                Http2Connection.this.pushResetLater(streamId, errorCode);
                return;
            }
            Http2Stream rstStream = Http2Connection.this.removeStream(streamId);
            if (rstStream != null) {
                rstStream.receiveRstStream(errorCode);
            }
        }

        public void settings(boolean clearPrevious, Settings settings) {
            try {
                final boolean z = clearPrevious;
                final Settings settings2 = settings;
                Http2Connection.this.writerExecutor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.connectionName}) {
                    public void execute() {
                        ReaderRunnable.this.applyAndAckSettings(z, settings2);
                    }
                });
            } catch (RejectedExecutionException e) {
            }
        }

        /* Debug info: failed to restart local var, previous not found, register: 9 */
        /* access modifiers changed from: package-private */
        public void applyAndAckSettings(boolean clearPrevious, Settings settings) {
            Http2Stream[] http2StreamArr;
            long delta = 0;
            Http2Stream[] streamsToNotify = null;
            synchronized (Http2Connection.this.writer) {
                synchronized (Http2Connection.this) {
                    int priorWriteWindowSize = Http2Connection.this.peerSettings.getInitialWindowSize();
                    if (clearPrevious) {
                        Http2Connection.this.peerSettings.clear();
                    }
                    Http2Connection.this.peerSettings.merge(settings);
                    int peerInitialWindowSize = Http2Connection.this.peerSettings.getInitialWindowSize();
                    if (!(peerInitialWindowSize == -1 || peerInitialWindowSize == priorWriteWindowSize)) {
                        delta = (long) (peerInitialWindowSize - priorWriteWindowSize);
                        if (!Http2Connection.this.streams.isEmpty()) {
                            http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                        } else {
                            http2StreamArr = null;
                        }
                        streamsToNotify = http2StreamArr;
                    }
                }
                try {
                    Http2Connection.this.writer.applyAndAckSettings(Http2Connection.this.peerSettings);
                } catch (IOException e) {
                    Http2Connection.this.failConnection(e);
                }
            }
            if (streamsToNotify != null) {
                for (Http2Stream stream : streamsToNotify) {
                    synchronized (stream) {
                        stream.addBytesToWriteWindow(delta);
                    }
                }
            }
            Http2Connection.listenerExecutor.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.connectionName) {
                public void execute() {
                    Http2Connection.this.listener.onSettings(Http2Connection.this);
                }
            });
        }

        public void ackSettings() {
        }

        public void ping(boolean reply, int payload1, int payload2) {
            if (reply) {
                synchronized (Http2Connection.this) {
                    if (payload1 == 1) {
                        try {
                            Http2Connection.access$108(Http2Connection.this);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else if (payload1 == 2) {
                        Http2Connection.access$608(Http2Connection.this);
                    } else if (payload1 == 3) {
                        Http2Connection.access$708(Http2Connection.this);
                        Http2Connection.this.notifyAll();
                    }
                }
                return;
            }
            try {
                Http2Connection.this.writerExecutor.execute(new PingRunnable(true, payload1, payload2));
            } catch (RejectedExecutionException e) {
            }
        }

        public void goAway(int lastGoodStreamId, ErrorCode errorCode, ByteString debugData) {
            Http2Stream[] streamsCopy;
            debugData.size();
            synchronized (Http2Connection.this) {
                streamsCopy = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                boolean unused = Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : streamsCopy) {
                if (http2Stream.getId() > lastGoodStreamId && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        public void windowUpdate(int streamId, long windowSizeIncrement) {
            if (streamId == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.bytesLeftInWriteWindow += windowSizeIncrement;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(streamId);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(windowSizeIncrement);
                }
            }
        }

        public void priority(int streamId, int streamDependency, int weight, boolean exclusive) {
        }

        public void pushPromise(int streamId, int promisedStreamId, List<Header> requestHeaders) {
            Http2Connection.this.pushRequestLater(promisedStreamId, requestHeaders);
        }

        public void alternateService(int streamId, String origin, ByteString protocol, String host, int port, long maxAge) {
        }
    }

    /* access modifiers changed from: package-private */
    public boolean pushedStream(int streamId) {
        return streamId != 0 && (streamId & 1) == 0;
    }

    /* access modifiers changed from: package-private */
    public void pushRequestLater(int streamId, List<Header> requestHeaders) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(streamId))) {
                writeSynResetLater(streamId, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(streamId));
            try {
                final int i = streamId;
                final List<Header> list = requestHeaders;
                pushExecutorExecute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.connectionName, Integer.valueOf(streamId)}) {
                    /* Debug info: failed to restart local var, previous not found, register: 4 */
                    public void execute() {
                        if (Http2Connection.this.pushObserver.onRequest(i, list)) {
                            try {
                                Http2Connection.this.writer.rstStream(i, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i));
                                }
                            } catch (IOException e) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException e) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void pushHeadersLater(int streamId, List<Header> requestHeaders, boolean inFinished) {
        try {
            final int i = streamId;
            final List<Header> list = requestHeaders;
            final boolean z = inFinished;
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.connectionName, Integer.valueOf(streamId)}) {
                /* Debug info: failed to restart local var, previous not found, register: 4 */
                public void execute() {
                    boolean cancel = Http2Connection.this.pushObserver.onHeaders(i, list, z);
                    if (cancel) {
                        try {
                            Http2Connection.this.writer.rstStream(i, ErrorCode.CANCEL);
                        } catch (IOException e) {
                            return;
                        }
                    }
                    if (cancel || z) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException e) {
        }
    }

    /* access modifiers changed from: package-private */
    public void pushDataLater(int streamId, BufferedSource source, int byteCount, boolean inFinished) throws IOException {
        Buffer buffer = new Buffer();
        source.require((long) byteCount);
        source.read(buffer, (long) byteCount);
        if (buffer.size() == ((long) byteCount)) {
            final int i = streamId;
            final Buffer buffer2 = buffer;
            final int i2 = byteCount;
            final boolean z = inFinished;
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.connectionName, Integer.valueOf(streamId)}) {
                /* Debug info: failed to restart local var, previous not found, register: 5 */
                public void execute() {
                    try {
                        boolean cancel = Http2Connection.this.pushObserver.onData(i, buffer2, i2, z);
                        if (cancel) {
                            Http2Connection.this.writer.rstStream(i, ErrorCode.CANCEL);
                        }
                        if (cancel || z) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (IOException e) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + byteCount);
    }

    /* access modifiers changed from: package-private */
    public void pushResetLater(int streamId, ErrorCode errorCode) {
        final int i = streamId;
        final ErrorCode errorCode2 = errorCode;
        pushExecutorExecute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.connectionName, Integer.valueOf(streamId)}) {
            public void execute() {
                Http2Connection.this.pushObserver.onReset(i, errorCode2);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i));
                }
            }
        });
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        if (!this.shutdown) {
            this.pushExecutor.execute(namedRunnable);
        }
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            public void onStream(Http2Stream stream) throws IOException {
                stream.close(ErrorCode.REFUSED_STREAM, (IOException) null);
            }
        };

        public abstract void onStream(Http2Stream http2Stream) throws IOException;

        public void onSettings(Http2Connection connection) {
        }
    }
}
