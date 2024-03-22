package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.Transmitter;

public final class RealInterceptorChain implements Interceptor.Chain {
    private final Call call;
    private int calls;
    private final int connectTimeout;
    @Nullable
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeout;
    private final Request request;
    private final Transmitter transmitter;
    private final int writeTimeout;

    public RealInterceptorChain(List<Interceptor> interceptors2, Transmitter transmitter2, @Nullable Exchange exchange2, int index2, Request request2, Call call2, int connectTimeout2, int readTimeout2, int writeTimeout2) {
        this.interceptors = interceptors2;
        this.transmitter = transmitter2;
        this.exchange = exchange2;
        this.index = index2;
        this.request = request2;
        this.call = call2;
        this.connectTimeout = connectTimeout2;
        this.readTimeout = readTimeout2;
        this.writeTimeout = writeTimeout2;
    }

    @Nullable
    public Connection connection() {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2.connection();
        }
        return null;
    }

    public int connectTimeoutMillis() {
        return this.connectTimeout;
    }

    public Interceptor.Chain withConnectTimeout(int timeout, TimeUnit unit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, Util.checkDuration("timeout", (long) timeout, unit), this.readTimeout, this.writeTimeout);
    }

    public int readTimeoutMillis() {
        return this.readTimeout;
    }

    public Interceptor.Chain withReadTimeout(int timeout, TimeUnit unit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, Util.checkDuration("timeout", (long) timeout, unit), this.writeTimeout);
    }

    public int writeTimeoutMillis() {
        return this.writeTimeout;
    }

    public Interceptor.Chain withWriteTimeout(int timeout, TimeUnit unit) {
        return new RealInterceptorChain(this.interceptors, this.transmitter, this.exchange, this.index, this.request, this.call, this.connectTimeout, this.readTimeout, Util.checkDuration("timeout", (long) timeout, unit));
    }

    public Transmitter transmitter() {
        return this.transmitter;
    }

    public Exchange exchange() {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2;
        }
        throw new IllegalStateException();
    }

    public Call call() {
        return this.call;
    }

    public Request request() {
        return this.request;
    }

    public Response proceed(Request request2) throws IOException {
        return proceed(request2, this.transmitter, this.exchange);
    }

    public Response proceed(Request request2, Transmitter transmitter2, @Nullable Exchange exchange2) throws IOException {
        if (this.index < this.interceptors.size()) {
            this.calls++;
            Exchange exchange3 = this.exchange;
            if (exchange3 != null && !exchange3.connection().supportsUrl(request2.url())) {
                throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
            } else if (this.exchange == null || this.calls <= 1) {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, transmitter2, exchange2, this.index + 1, request2, this.call, this.connectTimeout, this.readTimeout, this.writeTimeout);
                Interceptor interceptor = this.interceptors.get(this.index);
                Response response = interceptor.intercept(realInterceptorChain);
                if (exchange2 != null && this.index + 1 < this.interceptors.size() && realInterceptorChain.calls != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (response == null) {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                } else if (response.body() != null) {
                    return response;
                } else {
                    throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }
}
