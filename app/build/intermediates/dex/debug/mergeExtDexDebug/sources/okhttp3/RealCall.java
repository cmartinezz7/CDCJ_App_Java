package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.Transmitter;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.Timeout;

final class RealCall implements Call {
    final OkHttpClient client;
    private boolean executed;
    final boolean forWebSocket;
    final Request originalRequest;
    /* access modifiers changed from: private */
    public Transmitter transmitter;

    private RealCall(OkHttpClient client2, Request originalRequest2, boolean forWebSocket2) {
        this.client = client2;
        this.originalRequest = originalRequest2;
        this.forWebSocket = forWebSocket2;
    }

    static RealCall newRealCall(OkHttpClient client2, Request originalRequest2, boolean forWebSocket2) {
        RealCall call = new RealCall(client2, originalRequest2, forWebSocket2);
        call.transmitter = new Transmitter(client2, call);
        return call;
    }

    public Request request() {
        return this.originalRequest;
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public Response execute() throws IOException {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.transmitter.timeoutEnter();
        this.transmitter.callStart();
        try {
            this.client.dispatcher().executed(this);
            return getResponseWithInterceptorChain();
        } finally {
            this.client.dispatcher().finished(this);
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public void enqueue(Callback responseCallback) {
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.transmitter.callStart();
        this.client.dispatcher().enqueue(new AsyncCall(responseCallback));
    }

    public void cancel() {
        this.transmitter.cancel();
    }

    public Timeout timeout() {
        return this.transmitter.timeout();
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    public boolean isCanceled() {
        return this.transmitter.isCanceled();
    }

    public RealCall clone() {
        return newRealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    final class AsyncCall extends NamedRunnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        private final Callback responseCallback;

        static {
            Class<RealCall> cls = RealCall.class;
        }

        AsyncCall(Callback responseCallback2) {
            super("OkHttp %s", RealCall.this.redactedUrl());
            this.responseCallback = responseCallback2;
        }

        /* access modifiers changed from: package-private */
        public AtomicInteger callsPerHost() {
            return this.callsPerHost;
        }

        /* access modifiers changed from: package-private */
        public void reuseCallsPerHostFrom(AsyncCall other) {
            this.callsPerHost = other.callsPerHost;
        }

        /* access modifiers changed from: package-private */
        public String host() {
            return RealCall.this.originalRequest.url().host();
        }

        /* access modifiers changed from: package-private */
        public Request request() {
            return RealCall.this.originalRequest;
        }

        /* access modifiers changed from: package-private */
        public RealCall get() {
            return RealCall.this;
        }

        /* access modifiers changed from: package-private */
        public void executeOn(ExecutorService executorService) {
            if (!Thread.holdsLock(RealCall.this.client.dispatcher())) {
                try {
                    executorService.execute(this);
                    if (1 != 0) {
                        return;
                    }
                } catch (RejectedExecutionException e) {
                    InterruptedIOException ioException = new InterruptedIOException("executor rejected");
                    ioException.initCause(e);
                    RealCall.this.transmitter.noMoreExchanges(ioException);
                    this.responseCallback.onFailure(RealCall.this, ioException);
                    if (0 != 0) {
                        return;
                    }
                } catch (Throwable th) {
                    if (0 == 0) {
                        RealCall.this.client.dispatcher().finished(this);
                    }
                    throw th;
                }
                RealCall.this.client.dispatcher().finished(this);
                return;
            }
            throw new AssertionError();
        }

        /* Debug info: failed to restart local var, previous not found, register: 6 */
        /* access modifiers changed from: protected */
        public void execute() {
            boolean signalledCallback = false;
            RealCall.this.transmitter.timeoutEnter();
            try {
                signalledCallback = true;
                this.responseCallback.onResponse(RealCall.this, RealCall.this.getResponseWithInterceptorChain());
            } catch (IOException e) {
                if (signalledCallback) {
                    Platform.get().log(4, "Callback failure for " + RealCall.this.toLoggableString(), e);
                } else {
                    this.responseCallback.onFailure(RealCall.this, e);
                }
            } catch (Throwable t) {
                RealCall.this.client.dispatcher().finished(this);
                throw t;
            }
            RealCall.this.client.dispatcher().finished(this);
        }
    }

    /* access modifiers changed from: package-private */
    public String toLoggableString() {
        return (isCanceled() ? "canceled " : "") + (this.forWebSocket ? "web socket" : "call") + " to " + redactedUrl();
    }

    /* access modifiers changed from: package-private */
    public String redactedUrl() {
        return this.originalRequest.url().redact();
    }

    /* Debug info: failed to restart local var, previous not found, register: 12 */
    /* access modifiers changed from: package-private */
    public Response getResponseWithInterceptorChain() throws IOException {
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.addAll(this.client.interceptors());
        interceptors.add(new RetryAndFollowUpInterceptor(this.client));
        interceptors.add(new BridgeInterceptor(this.client.cookieJar()));
        interceptors.add(new CacheInterceptor(this.client.internalCache()));
        interceptors.add(new ConnectInterceptor(this.client));
        if (!this.forWebSocket) {
            interceptors.addAll(this.client.networkInterceptors());
        }
        interceptors.add(new CallServerInterceptor(this.forWebSocket));
        try {
            Response response = new RealInterceptorChain(interceptors, this.transmitter, (Exchange) null, 0, this.originalRequest, this, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis()).proceed(this.originalRequest);
            if (!this.transmitter.isCanceled()) {
                if (0 == 0) {
                    this.transmitter.noMoreExchanges((IOException) null);
                }
                return response;
            }
            Util.closeQuietly((Closeable) response);
            throw new IOException("Canceled");
        } catch (IOException e) {
            throw this.transmitter.noMoreExchanges(e);
        } catch (Throwable th) {
            if (1 == 0) {
                this.transmitter.noMoreExchanges((IOException) null);
            }
            throw th;
        }
    }
}
