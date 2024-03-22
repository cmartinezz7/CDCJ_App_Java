package okhttp3.logging;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public final class LoggingEventListener extends EventListener {
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger2) {
        this.logger = logger2;
    }

    public void callStart(Call call) {
        this.startNs = System.nanoTime();
        logWithTime("callStart: " + call.request());
    }

    public void dnsStart(Call call, String domainName) {
        logWithTime("dnsStart: " + domainName);
    }

    public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        logWithTime("dnsEnd: " + inetAddressList);
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        logWithTime("connectStart: " + inetSocketAddress + " " + proxy);
    }

    public void secureConnectStart(Call call) {
        logWithTime("secureConnectStart");
    }

    public void secureConnectEnd(Call call, @Nullable Handshake handshake) {
        logWithTime("secureConnectEnd");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
        logWithTime("connectEnd: " + protocol);
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException ioe) {
        logWithTime("connectFailed: " + protocol + " " + ioe);
    }

    public void connectionAcquired(Call call, Connection connection) {
        logWithTime("connectionAcquired: " + connection);
    }

    public void connectionReleased(Call call, Connection connection) {
        logWithTime("connectionReleased");
    }

    public void requestHeadersStart(Call call) {
        logWithTime("requestHeadersStart");
    }

    public void requestHeadersEnd(Call call, Request request) {
        logWithTime("requestHeadersEnd");
    }

    public void requestBodyStart(Call call) {
        logWithTime("requestBodyStart");
    }

    public void requestBodyEnd(Call call, long byteCount) {
        logWithTime("requestBodyEnd: byteCount=" + byteCount);
    }

    public void responseHeadersStart(Call call) {
        logWithTime("responseHeadersStart");
    }

    public void responseHeadersEnd(Call call, Response response) {
        logWithTime("responseHeadersEnd: " + response);
    }

    public void responseBodyStart(Call call) {
        logWithTime("responseBodyStart");
    }

    public void responseBodyEnd(Call call, long byteCount) {
        logWithTime("responseBodyEnd: byteCount=" + byteCount);
    }

    public void callEnd(Call call) {
        logWithTime("callEnd");
    }

    public void callFailed(Call call, IOException ioe) {
        logWithTime("callFailed: " + ioe);
    }

    private void logWithTime(String message) {
        this.logger.log("[" + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs) + " ms] " + message);
    }

    public static class Factory implements EventListener.Factory {
        private final HttpLoggingInterceptor.Logger logger;

        public Factory() {
            this(HttpLoggingInterceptor.Logger.DEFAULT);
        }

        public Factory(HttpLoggingInterceptor.Logger logger2) {
            this.logger = logger2;
        }

        public EventListener create(Call call) {
            return new LoggingEventListener(this.logger);
        }
    }
}
