package okhttp3.internal.huc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.JavaNetHeaders;
import okhttp3.internal.URLFilter;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;

public final class OkHttpURLConnection extends HttpURLConnection implements Callback {
    private static final Set<String> METHODS = new LinkedHashSet(Arrays.asList(new String[]{"OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH"}));
    public static final String RESPONSE_SOURCE = (Platform.get().getPrefix() + "-Response-Source");
    public static final String SELECTED_PROTOCOL = (Platform.get().getPrefix() + "-Selected-Protocol");
    Call call;
    private Throwable callFailure;
    OkHttpClient client;
    boolean connectPending;
    private boolean executed;
    private long fixedContentLength;
    Handshake handshake;
    /* access modifiers changed from: private */
    public final Object lock;
    private final NetworkInterceptor networkInterceptor;
    Response networkResponse;
    Proxy proxy;
    private Headers.Builder requestHeaders;
    private Response response;
    private Headers responseHeaders;
    URLFilter urlFilter;

    public OkHttpURLConnection(URL url, OkHttpClient client2) {
        super(url);
        this.networkInterceptor = new NetworkInterceptor();
        this.requestHeaders = new Headers.Builder();
        this.fixedContentLength = -1;
        this.lock = new Object();
        this.connectPending = true;
        this.client = client2;
    }

    public OkHttpURLConnection(URL url, OkHttpClient client2, URLFilter urlFilter2) {
        this(url, client2);
        this.urlFilter = urlFilter2;
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public void connect() throws IOException {
        if (!this.executed) {
            Call call2 = buildCall();
            this.executed = true;
            call2.enqueue(this);
            synchronized (this.lock) {
                while (this.connectPending && this.response == null && this.callFailure == null) {
                    try {
                        this.lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                Throwable th = this.callFailure;
                if (th != null) {
                    throw propagate(th);
                }
            }
        }
    }

    public void disconnect() {
        if (this.call != null) {
            this.networkInterceptor.proceed();
            this.call.cancel();
        }
    }

    public InputStream getErrorStream() {
        try {
            Response response2 = getResponse(true);
            if (!HttpHeaders.hasBody(response2) || response2.code() < 400) {
                return null;
            }
            return response2.body().byteStream();
        } catch (IOException e) {
            return null;
        }
    }

    private Headers getHeaders() throws IOException {
        if (this.responseHeaders == null) {
            Response response2 = getResponse(true);
            this.responseHeaders = response2.headers().newBuilder().add(SELECTED_PROTOCOL, response2.protocol().toString()).add(RESPONSE_SOURCE, responseSourceHeader(response2)).build();
        }
        return this.responseHeaders;
    }

    private static String responseSourceHeader(Response response2) {
        if (response2.networkResponse() == null) {
            if (response2.cacheResponse() == null) {
                return "NONE";
            }
            return "CACHE " + response2.code();
        } else if (response2.cacheResponse() == null) {
            return "NETWORK " + response2.code();
        } else {
            return "CONDITIONAL_CACHE " + response2.networkResponse().code();
        }
    }

    public String getHeaderField(int position) {
        try {
            Headers headers = getHeaders();
            if (position >= 0) {
                if (position < headers.size()) {
                    return headers.value(position);
                }
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public String getHeaderField(String fieldName) {
        if (fieldName != null) {
            return getHeaders().get(fieldName);
        }
        try {
            return StatusLine.get(getResponse(true)).toString();
        } catch (IOException e) {
            return null;
        }
    }

    public String getHeaderFieldKey(int position) {
        try {
            Headers headers = getHeaders();
            if (position >= 0) {
                if (position < headers.size()) {
                    return headers.name(position);
                }
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public Map<String, List<String>> getHeaderFields() {
        try {
            return JavaNetHeaders.toMultimap(getHeaders(), StatusLine.get(getResponse(true)).toString());
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    public Map<String, List<String>> getRequestProperties() {
        if (!this.connected) {
            return JavaNetHeaders.toMultimap(this.requestHeaders.build(), (String) null);
        }
        throw new IllegalStateException("Cannot access request header fields after connection is set");
    }

    public InputStream getInputStream() throws IOException {
        if (this.doInput) {
            Response response2 = getResponse(false);
            if (response2.code() < 400) {
                return response2.body().byteStream();
            }
            throw new FileNotFoundException(this.url.toString());
        }
        throw new ProtocolException("This protocol does not support input");
    }

    public OutputStream getOutputStream() throws IOException {
        OutputStreamRequestBody requestBody = (OutputStreamRequestBody) buildCall().request().body();
        if (requestBody != null) {
            if (requestBody instanceof StreamedRequestBody) {
                connect();
                this.networkInterceptor.proceed();
            }
            if (!requestBody.isClosed()) {
                return requestBody.outputStream();
            }
            throw new ProtocolException("cannot write request body after response has been read");
        }
        throw new ProtocolException("method does not support a request body: " + this.method);
    }

    public Permission getPermission() throws IOException {
        int hostPort;
        URL url = getURL();
        String hostname = url.getHost();
        if (url.getPort() != -1) {
            hostPort = url.getPort();
        } else {
            hostPort = HttpUrl.defaultPort(url.getProtocol());
        }
        if (usingProxy()) {
            InetSocketAddress proxyAddress = (InetSocketAddress) this.client.proxy().address();
            hostname = proxyAddress.getHostName();
            hostPort = proxyAddress.getPort();
        }
        return new SocketPermission(hostname + ":" + hostPort, "connect, resolve");
    }

    public String getRequestProperty(String field) {
        if (field == null) {
            return null;
        }
        return this.requestHeaders.get(field);
    }

    public void setConnectTimeout(int timeoutMillis) {
        this.client = this.client.newBuilder().connectTimeout((long) timeoutMillis, TimeUnit.MILLISECONDS).build();
    }

    public void setInstanceFollowRedirects(boolean followRedirects) {
        this.client = this.client.newBuilder().followRedirects(followRedirects).build();
    }

    public boolean getInstanceFollowRedirects() {
        return this.client.followRedirects();
    }

    public int getConnectTimeout() {
        return this.client.connectTimeoutMillis();
    }

    public void setReadTimeout(int timeoutMillis) {
        this.client = this.client.newBuilder().readTimeout((long) timeoutMillis, TimeUnit.MILLISECONDS).build();
    }

    public int getReadTimeout() {
        return this.client.readTimeoutMillis();
    }

    private Call buildCall() throws IOException {
        OutputStreamRequestBody outputStreamRequestBody;
        Call call2 = this.call;
        if (call2 != null) {
            return call2;
        }
        boolean stream = true;
        this.connected = true;
        if (this.doOutput) {
            if (this.method.equals("GET")) {
                this.method = "POST";
            } else if (!HttpMethod.permitsRequestBody(this.method)) {
                throw new ProtocolException(this.method + " does not support writing");
            }
        }
        if (this.requestHeaders.get("User-Agent") == null) {
            this.requestHeaders.add("User-Agent", defaultUserAgent());
        }
        OutputStreamRequestBody requestBody = null;
        if (HttpMethod.permitsRequestBody(this.method)) {
            if (this.requestHeaders.get("Content-Type") == null) {
                this.requestHeaders.add("Content-Type", "application/x-www-form-urlencoded");
            }
            if (this.fixedContentLength == -1 && this.chunkLength <= 0) {
                stream = false;
            }
            long contentLength = -1;
            String contentLengthString = this.requestHeaders.get("Content-Length");
            if (this.fixedContentLength != -1) {
                contentLength = this.fixedContentLength;
            } else if (contentLengthString != null) {
                contentLength = Long.parseLong(contentLengthString);
            }
            if (stream) {
                outputStreamRequestBody = new StreamedRequestBody(contentLength);
            } else {
                outputStreamRequestBody = new BufferedRequestBody(contentLength);
            }
            requestBody = outputStreamRequestBody;
            requestBody.timeout().timeout((long) this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
        try {
            Request request = new Request.Builder().url(HttpUrl.get(getURL().toString())).headers(this.requestHeaders.build()).method(this.method, requestBody).build();
            URLFilter uRLFilter = this.urlFilter;
            if (uRLFilter != null) {
                uRLFilter.checkURLPermitted(request.url().url());
            }
            OkHttpClient.Builder clientBuilder = this.client.newBuilder();
            clientBuilder.interceptors().clear();
            clientBuilder.interceptors().add(UnexpectedException.INTERCEPTOR);
            clientBuilder.networkInterceptors().clear();
            clientBuilder.networkInterceptors().add(this.networkInterceptor);
            clientBuilder.dispatcher(new Dispatcher(this.client.dispatcher().executorService()));
            if (!getUseCaches()) {
                clientBuilder.cache((Cache) null);
            }
            Call newCall = clientBuilder.build().newCall(request);
            this.call = newCall;
            return newCall;
        } catch (IllegalArgumentException e) {
            if (Internal.instance.isInvalidHttpUrlHost(e)) {
                UnknownHostException unknownHost = new UnknownHostException();
                unknownHost.initCause(e);
                throw unknownHost;
            }
            MalformedURLException malformedUrl = new MalformedURLException();
            malformedUrl.initCause(e);
            throw malformedUrl;
        }
    }

    private String defaultUserAgent() {
        String agent = System.getProperty("http.agent");
        return agent != null ? toHumanReadableAscii(agent) : Version.userAgent();
    }

    private static String toHumanReadableAscii(String s) {
        int i = 0;
        int length = s.length();
        while (i < length) {
            int c = s.codePointAt(i);
            if (c <= 31 || c >= 127) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(s, 0, i);
                buffer.writeUtf8CodePoint(63);
                int j = Character.charCount(c) + i;
                while (j < length) {
                    int c2 = s.codePointAt(j);
                    buffer.writeUtf8CodePoint((c2 <= 31 || c2 >= 127) ? 63 : c2);
                    j += Character.charCount(c2);
                }
                return buffer.readUtf8();
            }
            i += Character.charCount(c);
        }
        return s;
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001b, code lost:
        r1 = buildCall();
        r5.networkInterceptor.proceed();
        r2 = (okhttp3.internal.huc.OutputStreamRequestBody) r1.request().body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        if (r2 == null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        r2.outputStream().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r5.executed == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        r0 = r5.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003e, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        if (r5.response != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0045, code lost:
        if (r5.callFailure != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        r5.lock.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0050, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0053, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005f, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0061, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0062, code lost:
        r5.executed = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        onResponse(r1, r1.execute());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006e, code lost:
        onFailure(r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.Response getResponse(boolean r6) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            okhttp3.Response r1 = r5.response     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return r1
        L_0x0009:
            java.lang.Throwable r1 = r5.callFailure     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x001a
            if (r6 == 0) goto L_0x0015
            okhttp3.Response r2 = r5.networkResponse     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0015
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return r2
        L_0x0015:
            java.io.IOException r1 = propagate(r1)     // Catch:{ all -> 0x008d }
            throw r1     // Catch:{ all -> 0x008d }
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            okhttp3.Call r1 = r5.buildCall()
            okhttp3.internal.huc.OkHttpURLConnection$NetworkInterceptor r0 = r5.networkInterceptor
            r0.proceed()
            okhttp3.Request r0 = r1.request()
            okhttp3.RequestBody r0 = r0.body()
            r2 = r0
            okhttp3.internal.huc.OutputStreamRequestBody r2 = (okhttp3.internal.huc.OutputStreamRequestBody) r2
            if (r2 == 0) goto L_0x0038
            java.io.OutputStream r0 = r2.outputStream()
            r0.close()
        L_0x0038:
            boolean r0 = r5.executed
            if (r0 == 0) goto L_0x0062
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
        L_0x003f:
            okhttp3.Response r3 = r5.response     // Catch:{ InterruptedException -> 0x0052 }
            if (r3 != 0) goto L_0x004d
            java.lang.Throwable r3 = r5.callFailure     // Catch:{ InterruptedException -> 0x0052 }
            if (r3 != 0) goto L_0x004d
            java.lang.Object r3 = r5.lock     // Catch:{ InterruptedException -> 0x0052 }
            r3.wait()     // Catch:{ InterruptedException -> 0x0052 }
            goto L_0x003f
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            goto L_0x0071
        L_0x0050:
            r3 = move-exception
            goto L_0x0060
        L_0x0052:
            r3 = move-exception
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0050 }
            r4.interrupt()     // Catch:{ all -> 0x0050 }
            java.io.InterruptedIOException r4 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0050 }
            r4.<init>()     // Catch:{ all -> 0x0050 }
            throw r4     // Catch:{ all -> 0x0050 }
        L_0x0060:
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            throw r3
        L_0x0062:
            r0 = 1
            r5.executed = r0
            okhttp3.Response r0 = r1.execute()     // Catch:{ IOException -> 0x006d }
            r5.onResponse(r1, r0)     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r0 = move-exception
            r5.onFailure(r1, r0)
        L_0x0071:
            java.lang.Object r3 = r5.lock
            monitor-enter(r3)
            java.lang.Throwable r0 = r5.callFailure     // Catch:{ all -> 0x008a }
            if (r0 != 0) goto L_0x0085
            okhttp3.Response r0 = r5.response     // Catch:{ all -> 0x008a }
            if (r0 == 0) goto L_0x007e
            monitor-exit(r3)     // Catch:{ all -> 0x008a }
            return r0
        L_0x007e:
            monitor-exit(r3)     // Catch:{ all -> 0x008a }
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0085:
            java.io.IOException r0 = propagate(r0)     // Catch:{ all -> 0x008a }
            throw r0     // Catch:{ all -> 0x008a }
        L_0x008a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x008a }
            throw r0
        L_0x008d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.huc.OkHttpURLConnection.getResponse(boolean):okhttp3.Response");
    }

    public boolean usingProxy() {
        if (this.proxy != null) {
            return true;
        }
        Proxy clientProxy = this.client.proxy();
        if (clientProxy == null || clientProxy.type() == Proxy.Type.DIRECT) {
            return false;
        }
        return true;
    }

    public String getResponseMessage() throws IOException {
        return getResponse(true).message();
    }

    public int getResponseCode() throws IOException {
        return getResponse(true).code();
    }

    public void setRequestProperty(String field, String newValue) {
        if (this.connected) {
            throw new IllegalStateException("Cannot set request property after connection is made");
        } else if (field == null) {
            throw new NullPointerException("field == null");
        } else if (newValue == null) {
            Platform.get().log(5, "Ignoring header " + field + " because its value was null.", (Throwable) null);
        } else {
            this.requestHeaders.set(field, newValue);
        }
    }

    public void setIfModifiedSince(long newValue) {
        super.setIfModifiedSince(newValue);
        if (this.ifModifiedSince != 0) {
            this.requestHeaders.set("If-Modified-Since", HttpDate.format(new Date(this.ifModifiedSince)));
        } else {
            this.requestHeaders.removeAll("If-Modified-Since");
        }
    }

    public void addRequestProperty(String field, String value) {
        if (this.connected) {
            throw new IllegalStateException("Cannot add request property after connection is made");
        } else if (field == null) {
            throw new NullPointerException("field == null");
        } else if (value == null) {
            Platform.get().log(5, "Ignoring header " + field + " because its value was null.", (Throwable) null);
        } else {
            this.requestHeaders.add(field, value);
        }
    }

    public void setRequestMethod(String method) throws ProtocolException {
        Set<String> set = METHODS;
        if (set.contains(method)) {
            this.method = method;
            return;
        }
        throw new ProtocolException("Expected one of " + set + " but was " + method);
    }

    public void setFixedLengthStreamingMode(int contentLength) {
        setFixedLengthStreamingMode((long) contentLength);
    }

    public void setFixedLengthStreamingMode(long contentLength) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        } else if (this.chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        } else if (contentLength >= 0) {
            this.fixedContentLength = contentLength;
            this.fixedContentLength = (int) Math.min(contentLength, 2147483647L);
        } else {
            throw new IllegalArgumentException("contentLength < 0");
        }
    }

    public void onFailure(Call call2, IOException e) {
        synchronized (this.lock) {
            this.callFailure = e instanceof UnexpectedException ? e.getCause() : e;
            this.lock.notifyAll();
        }
    }

    public void onResponse(Call call2, Response response2) {
        synchronized (this.lock) {
            this.response = response2;
            this.handshake = response2.handshake();
            this.url = response2.request().url().url();
            this.lock.notifyAll();
        }
    }

    static final class UnexpectedException extends IOException {
        static final Interceptor INTERCEPTOR = new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                try {
                    return chain.proceed(chain.request());
                } catch (Error | RuntimeException e) {
                    throw new UnexpectedException(e);
                }
            }
        };

        UnexpectedException(Throwable cause) {
            super(cause);
        }
    }

    private static IOException propagate(Throwable throwable) throws IOException {
        if (throwable instanceof IOException) {
            throw ((IOException) throwable);
        } else if (throwable instanceof Error) {
            throw ((Error) throwable);
        } else if (throwable instanceof RuntimeException) {
            throw ((RuntimeException) throwable);
        } else {
            throw new AssertionError();
        }
    }

    final class NetworkInterceptor implements Interceptor {
        private boolean proceed;

        NetworkInterceptor() {
        }

        public void proceed() {
            synchronized (OkHttpURLConnection.this.lock) {
                this.proceed = true;
                OkHttpURLConnection.this.lock.notifyAll();
            }
        }

        /* Debug info: failed to restart local var, previous not found, register: 5 */
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request;
            Request request2 = chain.request();
            if (OkHttpURLConnection.this.urlFilter != null) {
                OkHttpURLConnection.this.urlFilter.checkURLPermitted(request2.url().url());
            }
            synchronized (OkHttpURLConnection.this.lock) {
                OkHttpURLConnection.this.connectPending = false;
                OkHttpURLConnection.this.proxy = chain.connection().route().proxy();
                OkHttpURLConnection.this.handshake = chain.connection().handshake();
                OkHttpURLConnection.this.lock.notifyAll();
                while (!this.proceed) {
                    try {
                        OkHttpURLConnection.this.lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
            }
            if (request2.body() instanceof OutputStreamRequestBody) {
                request = ((OutputStreamRequestBody) request2.body()).prepareToSendRequest(request2);
            } else {
                request = request2;
            }
            Response response = chain.proceed(request);
            synchronized (OkHttpURLConnection.this.lock) {
                OkHttpURLConnection.this.networkResponse = response;
                URL unused = OkHttpURLConnection.this.url = response.request().url().url();
            }
            return response;
        }
    }
}
