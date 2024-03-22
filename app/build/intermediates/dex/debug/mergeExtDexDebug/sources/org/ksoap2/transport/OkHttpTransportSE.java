package org.ksoap2.transport;

import java.io.IOException;
import java.net.Proxy;
import okhttp3.OkHttpClient;

public class OkHttpTransportSE extends HttpTransportSE {
    protected final OkHttpClient client;

    public OkHttpTransportSE(Proxy proxy, String url) {
        super(proxy, url);
        this.client = null;
    }

    public OkHttpTransportSE(Proxy proxy, String url, int timeout) {
        super(proxy, url, timeout);
        this.client = null;
    }

    public OkHttpTransportSE(Proxy proxy, String url, int timeout, int contentLength) {
        super(proxy, url, timeout, contentLength);
        this.client = null;
    }

    public OkHttpTransportSE(OkHttpClient client2, Proxy proxy, String url, int timeout, int contentLength) {
        super(proxy, url, timeout, contentLength);
        this.client = client2;
    }

    public OkHttpTransportSE(String url) {
        super(url);
        this.client = null;
    }

    public OkHttpTransportSE(String url, int timeout) {
        super(url, timeout);
        this.client = null;
    }

    public OkHttpTransportSE(String url, int timeout, int contentLength) {
        super(url, timeout, contentLength);
        this.client = null;
    }

    public ServiceConnection getServiceConnection() throws IOException {
        if (this.client == null) {
            return new OkHttpServiceConnectionSE(this.proxy, this.url, this.timeout);
        }
        return new OkHttpServiceConnectionSE(this.client, this.proxy, this.url, this.timeout);
    }
}
