package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Exchange {
    final Call call;
    final ExchangeCodec codec;
    private boolean duplex;
    final EventListener eventListener;
    final ExchangeFinder finder;
    final Transmitter transmitter;

    public Exchange(Transmitter transmitter2, Call call2, EventListener eventListener2, ExchangeFinder finder2, ExchangeCodec codec2) {
        this.transmitter = transmitter2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.finder = finder2;
        this.codec = codec2;
    }

    public RealConnection connection() {
        return this.codec.connection();
    }

    public boolean isDuplex() {
        return this.duplex;
    }

    public void writeRequestHeaders(Request request) throws IOException {
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public Sink createRequestBody(Request request, boolean duplex2) throws IOException {
        this.duplex = duplex2;
        long contentLength = request.body().contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this.codec.createRequestBody(request, contentLength), contentLength);
    }

    public void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e) {
            this.eventListener.requestFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    @Nullable
    public Response.Builder readResponseHeaders(boolean expectContinue) throws IOException {
        try {
            Response.Builder result = this.codec.readResponseHeaders(expectContinue);
            if (result != null) {
                Internal.instance.initExchange(result, this);
            }
            return result;
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public void responseHeadersEnd(Response response) {
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        try {
            this.eventListener.responseBodyStart(this.call);
            String contentType = response.header("Content-Type");
            long contentLength = this.codec.reportedContentLength(response);
            return new RealResponseBody(contentType, contentLength, Okio.buffer((Source) new ResponseBodySource(this.codec.openResponseBodySource(response), contentLength)));
        } catch (IOException e) {
            this.eventListener.responseFailed(this.call, e);
            trackFailure(e);
            throw e;
        }
    }

    public Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    public void timeoutEarlyExit() {
        this.transmitter.timeoutEarlyExit();
    }

    public RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.transmitter.timeoutEarlyExit();
        return this.codec.connection().newWebSocketStreams(this);
    }

    public void webSocketUpgradeFailed() {
        bodyComplete(-1, true, true, (IOException) null);
    }

    public void noNewExchangesOnConnection() {
        this.codec.connection().noNewExchanges();
    }

    public void cancel() {
        this.codec.cancel();
    }

    public void detachWithViolence() {
        this.codec.cancel();
        this.transmitter.exchangeMessageDone(this, true, true, (IOException) null);
    }

    /* access modifiers changed from: package-private */
    public void trackFailure(IOException e) {
        this.finder.trackFailure();
        this.codec.connection().trackFailure(e);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public IOException bodyComplete(long bytesRead, boolean responseDone, boolean requestDone, @Nullable IOException e) {
        if (e != null) {
            trackFailure(e);
        }
        if (requestDone) {
            if (e != null) {
                this.eventListener.requestFailed(this.call, e);
            } else {
                this.eventListener.requestBodyEnd(this.call, bytesRead);
            }
        }
        if (responseDone) {
            if (e != null) {
                this.eventListener.responseFailed(this.call, e);
            } else {
                this.eventListener.responseBodyEnd(this.call, bytesRead);
            }
        }
        return this.transmitter.exchangeMessageDone(this, requestDone, responseDone, e);
    }

    public void noRequestBody() {
        this.transmitter.exchangeMessageDone(this, true, false, (IOException) null);
    }

    private final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private long contentLength;

        RequestBodySink(Sink delegate, long contentLength2) {
            super(delegate);
            this.contentLength = contentLength2;
        }

        public void write(Buffer source, long byteCount) throws IOException {
            if (!this.closed) {
                long j = this.contentLength;
                if (j == -1 || this.bytesReceived + byteCount <= j) {
                    try {
                        super.write(source, byteCount);
                        this.bytesReceived += byteCount;
                    } catch (IOException e) {
                        throw complete(e);
                    }
                } else {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + byteCount));
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw complete(e);
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                long j = this.contentLength;
                if (j == -1 || this.bytesReceived == j) {
                    try {
                        super.close();
                        complete((IOException) null);
                    } catch (IOException e) {
                        throw complete(e);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        @Nullable
        private IOException complete(@Nullable IOException e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(this.bytesReceived, false, true, e);
        }
    }

    final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;

        ResponseBodySource(Source delegate, long contentLength2) {
            super(delegate);
            this.contentLength = contentLength2;
            if (contentLength2 == 0) {
                complete((IOException) null);
            }
        }

        /* Debug info: failed to restart local var, previous not found, register: 10 */
        public long read(Buffer sink, long byteCount) throws IOException {
            if (!this.closed) {
                try {
                    long read = delegate().read(sink, byteCount);
                    if (read == -1) {
                        complete((IOException) null);
                        return -1;
                    }
                    long newBytesReceived = this.bytesReceived + read;
                    long j = this.contentLength;
                    if (j != -1) {
                        if (newBytesReceived > j) {
                            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + newBytesReceived);
                        }
                    }
                    this.bytesReceived = newBytesReceived;
                    if (newBytesReceived == j) {
                        complete((IOException) null);
                    }
                    return read;
                } catch (IOException e) {
                    throw complete(e);
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                try {
                    super.close();
                    complete((IOException) null);
                } catch (IOException e) {
                    throw complete(e);
                }
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public IOException complete(@Nullable IOException e) {
            if (this.completed) {
                return e;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(this.bytesReceived, true, false, e);
        }
    }
}
