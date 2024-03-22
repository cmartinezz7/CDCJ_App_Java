package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.LongCompanionObject;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public final class RealConnection extends Http2Connection.Listener implements Connection {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit = 1;
    public final RealConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    long idleAtNanos = LongCompanionObject.MAX_VALUE;
    boolean noNewExchanges;
    private Protocol protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    int routeFailureCount;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    int successCount;
    final List<Reference<Transmitter>> transmitters = new ArrayList();

    public RealConnection(RealConnectionPool connectionPool2, Route route2) {
        this.connectionPool = connectionPool2;
        this.route = route2;
    }

    public void noNewExchanges() {
        if (!Thread.holdsLock(this.connectionPool)) {
            synchronized (this.connectionPool) {
                this.noNewExchanges = true;
            }
            return;
        }
        throw new AssertionError();
    }

    static RealConnection testConnection(RealConnectionPool connectionPool2, Route route2, Socket socket2, long idleAtNanos2) {
        RealConnection result = new RealConnection(connectionPool2, route2);
        result.socket = socket2;
        result.idleAtNanos = idleAtNanos2;
        return result;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0094 A[Catch:{ IOException -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0142  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            okhttp3.Protocol r0 = r7.protocol
            if (r0 != 0) goto L_0x0163
            r0 = 0
            okhttp3.Route r1 = r7.route
            okhttp3.Address r1 = r1.address()
            java.util.List r10 = r1.connectionSpecs()
            okhttp3.internal.connection.ConnectionSpecSelector r1 = new okhttp3.internal.connection.ConnectionSpecSelector
            r1.<init>(r10)
            r11 = r1
            okhttp3.Route r1 = r7.route
            okhttp3.Address r1 = r1.address()
            javax.net.ssl.SSLSocketFactory r1 = r1.sslSocketFactory()
            if (r1 != 0) goto L_0x0079
            okhttp3.ConnectionSpec r1 = okhttp3.ConnectionSpec.CLEARTEXT
            boolean r1 = r10.contains(r1)
            if (r1 == 0) goto L_0x006c
            okhttp3.Route r1 = r7.route
            okhttp3.Address r1 = r1.address()
            okhttp3.HttpUrl r1 = r1.url()
            java.lang.String r1 = r1.host()
            okhttp3.internal.platform.Platform r2 = okhttp3.internal.platform.Platform.get()
            boolean r2 = r2.isCleartextTrafficPermitted(r1)
            if (r2 == 0) goto L_0x0048
            goto L_0x008b
        L_0x0048:
            okhttp3.internal.connection.RouteException r2 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r3 = new java.net.UnknownServiceException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "CLEARTEXT communication to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r1)
            java.lang.String r5 = " not permitted by network security policy"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            r2.<init>(r3)
            throw r2
        L_0x006c:
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.String r3 = "CLEARTEXT communication not enabled for client"
            r2.<init>(r3)
            r1.<init>(r2)
            throw r1
        L_0x0079:
            okhttp3.Route r1 = r7.route
            okhttp3.Address r1 = r1.address()
            java.util.List r1 = r1.protocols()
            okhttp3.Protocol r2 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x0150
        L_0x008b:
            r12 = r0
        L_0x008c:
            okhttp3.Route r0 = r7.route     // Catch:{ IOException -> 0x0104 }
            boolean r0 = r0.requiresTunnel()     // Catch:{ IOException -> 0x0104 }
            if (r0 == 0) goto L_0x00b3
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.connectTunnel(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x0104 }
            java.net.Socket r0 = r7.rawSocket     // Catch:{ IOException -> 0x0104 }
            if (r0 != 0) goto L_0x00ae
            r13 = r17
            r14 = r18
            r15 = r20
            goto L_0x00d1
        L_0x00ae:
            r13 = r17
            r14 = r18
            goto L_0x00ba
        L_0x00b3:
            r13 = r17
            r14 = r18
            r7.connectSocket(r13, r14, r8, r9)     // Catch:{ IOException -> 0x0102 }
        L_0x00ba:
            r15 = r20
            r7.establishProtocol(r11, r15, r8, r9)     // Catch:{ IOException -> 0x0100 }
            okhttp3.Route r0 = r7.route     // Catch:{ IOException -> 0x0100 }
            java.net.InetSocketAddress r0 = r0.socketAddress()     // Catch:{ IOException -> 0x0100 }
            okhttp3.Route r1 = r7.route     // Catch:{ IOException -> 0x0100 }
            java.net.Proxy r1 = r1.proxy()     // Catch:{ IOException -> 0x0100 }
            okhttp3.Protocol r2 = r7.protocol     // Catch:{ IOException -> 0x0100 }
            r9.connectEnd(r8, r0, r1, r2)     // Catch:{ IOException -> 0x0100 }
        L_0x00d1:
            okhttp3.Route r0 = r7.route
            boolean r0 = r0.requiresTunnel()
            if (r0 == 0) goto L_0x00eb
            java.net.Socket r0 = r7.rawSocket
            if (r0 == 0) goto L_0x00de
            goto L_0x00eb
        L_0x00de:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            r1.<init>(r0)
            throw r1
        L_0x00eb:
            okhttp3.internal.http2.Http2Connection r0 = r7.http2Connection
            if (r0 == 0) goto L_0x00ff
            okhttp3.internal.connection.RealConnectionPool r1 = r7.connectionPool
            monitor-enter(r1)
            okhttp3.internal.http2.Http2Connection r0 = r7.http2Connection     // Catch:{ all -> 0x00fc }
            int r0 = r0.maxConcurrentStreams()     // Catch:{ all -> 0x00fc }
            r7.allocationLimit = r0     // Catch:{ all -> 0x00fc }
            monitor-exit(r1)     // Catch:{ all -> 0x00fc }
            goto L_0x00ff
        L_0x00fc:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00fc }
            throw r0
        L_0x00ff:
            return
        L_0x0100:
            r0 = move-exception
            goto L_0x010b
        L_0x0102:
            r0 = move-exception
            goto L_0x0109
        L_0x0104:
            r0 = move-exception
            r13 = r17
            r14 = r18
        L_0x0109:
            r15 = r20
        L_0x010b:
            java.net.Socket r1 = r7.socket
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r1)
            java.net.Socket r1 = r7.rawSocket
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r1)
            r1 = 0
            r7.socket = r1
            r7.rawSocket = r1
            r7.source = r1
            r7.sink = r1
            r7.handshake = r1
            r7.protocol = r1
            r7.http2Connection = r1
            okhttp3.Route r1 = r7.route
            java.net.InetSocketAddress r3 = r1.socketAddress()
            okhttp3.Route r1 = r7.route
            java.net.Proxy r4 = r1.proxy()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.connectFailed(r2, r3, r4, r5, r6)
            if (r12 != 0) goto L_0x0142
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            r1.<init>(r0)
            r12 = r1
            goto L_0x0145
        L_0x0142:
            r12.addConnectException(r0)
        L_0x0145:
            if (r21 == 0) goto L_0x014f
            boolean r1 = r11.connectionFailed(r0)
            if (r1 == 0) goto L_0x014f
            goto L_0x008c
        L_0x014f:
            throw r12
        L_0x0150:
            r13 = r17
            r14 = r18
            r15 = r20
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.String r3 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r2.<init>(r3)
            r1.<init>(r2)
            throw r1
        L_0x0163:
            r13 = r17
            r14 = r18
            r15 = r20
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    private void connectTunnel(int connectTimeout, int readTimeout, int writeTimeout, Call call, EventListener eventListener) throws IOException {
        Request tunnelRequest = createTunnelRequest();
        HttpUrl url = tunnelRequest.url();
        int i = 0;
        while (i < MAX_TUNNEL_ATTEMPTS) {
            connectSocket(connectTimeout, readTimeout, call, eventListener);
            tunnelRequest = createTunnel(readTimeout, writeTimeout, tunnelRequest, url);
            if (tunnelRequest != null) {
                Util.closeQuietly(this.rawSocket);
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), (Protocol) null);
                i++;
            } else {
                return;
            }
        }
    }

    private void connectSocket(int connectTimeout, int readTimeout, Call call, EventListener eventListener) throws IOException {
        Socket socket2;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) {
            socket2 = address.socketFactory().createSocket();
        } else {
            socket2 = new Socket(proxy);
        }
        this.rawSocket = socket2;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        this.rawSocket.setSoTimeout(readTimeout);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), connectTimeout);
            try {
                this.source = Okio.buffer(Okio.source(this.rawSocket));
                this.sink = Okio.buffer(Okio.sink(this.rawSocket));
            } catch (NullPointerException npe) {
                if (NPE_THROW_WITH_NULL.equals(npe.getMessage())) {
                    throw new IOException(npe);
                }
            }
        } catch (ConnectException e) {
            ConnectException ce = new ConnectException("Failed to connect to " + this.route.socketAddress());
            ce.initCause(e);
            throw ce;
        }
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int pingIntervalMillis, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol == Protocol.HTTP_2) {
                startHttp2(pingIntervalMillis);
            }
        } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.socket = this.rawSocket;
            this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            startHttp2(pingIntervalMillis);
        } else {
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
        }
    }

    private void startHttp2(int pingIntervalMillis) throws IOException {
        this.socket.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(pingIntervalMillis).build();
        this.http2Connection = build;
        build.start();
    }

    /* Debug info: failed to restart local var, previous not found, register: 12 */
    private void connectTls(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        String maybeProtocol;
        Protocol protocol2;
        Address address = this.route.address();
        SSLSocket sslSocket = null;
        try {
            sslSocket = (SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            ConnectionSpec connectionSpec = connectionSpecSelector.configureSecureSocket(sslSocket);
            if (connectionSpec.supportsTlsExtensions()) {
                Platform.get().configureTlsExtensions(sslSocket, address.url().host(), address.protocols());
            }
            sslSocket.startHandshake();
            SSLSession sslSocketSession = sslSocket.getSession();
            Handshake unverifiedHandshake = Handshake.get(sslSocketSession);
            if (!address.hostnameVerifier().verify(address.url().host(), sslSocketSession)) {
                List<Certificate> peerCertificates = unverifiedHandshake.peerCertificates();
                if (!peerCertificates.isEmpty()) {
                    X509Certificate cert = (X509Certificate) peerCertificates.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(cert) + "\n    DN: " + cert.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(cert));
                }
                throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
            }
            address.certificatePinner().check(address.url().host(), unverifiedHandshake.peerCertificates());
            if (connectionSpec.supportsTlsExtensions()) {
                maybeProtocol = Platform.get().getSelectedProtocol(sslSocket);
            } else {
                maybeProtocol = null;
            }
            this.socket = sslSocket;
            this.source = Okio.buffer(Okio.source((Socket) sslSocket));
            this.sink = Okio.buffer(Okio.sink(this.socket));
            this.handshake = unverifiedHandshake;
            if (maybeProtocol != null) {
                protocol2 = Protocol.get(maybeProtocol);
            } else {
                protocol2 = Protocol.HTTP_1_1;
            }
            this.protocol = protocol2;
            if (sslSocket != null) {
                Platform.get().afterHandshake(sslSocket);
            }
            if (1 == 0) {
                Util.closeQuietly((Socket) sslSocket);
            }
        } catch (AssertionError e) {
            if (Util.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (Throwable th) {
            if (sslSocket != null) {
                Platform.get().afterHandshake(sslSocket);
            }
            if (0 == 0) {
                Util.closeQuietly((Socket) sslSocket);
            }
            throw th;
        }
    }

    private Request createTunnel(int readTimeout, int writeTimeout, Request tunnelRequest, HttpUrl url) throws IOException {
        Response response;
        String requestLine = "CONNECT " + Util.hostHeader(url, true) + " HTTP/1.1";
        do {
            Http1ExchangeCodec tunnelCodec = new Http1ExchangeCodec((OkHttpClient) null, (RealConnection) null, this.source, this.sink);
            this.source.timeout().timeout((long) readTimeout, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout((long) writeTimeout, TimeUnit.MILLISECONDS);
            tunnelCodec.writeRequest(tunnelRequest.headers(), requestLine);
            tunnelCodec.finishRequest();
            response = tunnelCodec.readResponseHeaders(false).request(tunnelRequest).build();
            tunnelCodec.skipConnectBody(response);
            int code = response.code();
            if (code != 200) {
                if (code == 407) {
                    tunnelRequest = this.route.address().proxyAuthenticator().authenticate(this.route, response);
                    if (tunnelRequest == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + response.code());
                }
            } else if (this.source.getBuffer().exhausted() && this.sink.buffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        } while (!"close".equalsIgnoreCase(response.header("Connection")));
        return tunnelRequest;
    }

    private Request createTunnelRequest() throws IOException {
        Request proxyConnectRequest = new Request.Builder().url(this.route.address().url()).method("CONNECT", (RequestBody) null).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
        Request authenticatedRequest = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(proxyConnectRequest).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        if (authenticatedRequest != null) {
            return authenticatedRequest;
        }
        return proxyConnectRequest;
    }

    /* access modifiers changed from: package-private */
    public boolean isEligible(Address address, @Nullable List<Route> routes) {
        if (this.transmitters.size() >= this.allocationLimit || this.noNewExchanges || !Internal.instance.equalsNonHost(this.route.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || routes == null || !routeMatchesAny(routes) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException e) {
            return false;
        }
    }

    private boolean routeMatchesAny(List<Route> candidates) {
        int size = candidates.size();
        for (int i = 0; i < size; i++) {
            Route candidate = candidates.get(i);
            if (candidate.proxy().type() == Proxy.Type.DIRECT && this.route.proxy().type() == Proxy.Type.DIRECT && this.route.socketAddress().equals(candidate.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    public boolean supportsUrl(HttpUrl url) {
        if (url.port() != this.route.address().url().port()) {
            return false;
        }
        if (url.host().equals(this.route.address().url().host())) {
            return true;
        }
        if (this.handshake == null || !OkHostnameVerifier.INSTANCE.verify(url.host(), (X509Certificate) this.handshake.peerCertificates().get(0))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public ExchangeCodec newCodec(OkHttpClient client, Interceptor.Chain chain) throws SocketException {
        if (this.http2Connection != null) {
            return new Http2ExchangeCodec(client, this, chain, this.http2Connection);
        }
        this.socket.setSoTimeout(chain.readTimeoutMillis());
        this.source.timeout().timeout((long) chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.sink.timeout().timeout((long) chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new Http1ExchangeCodec(client, this, this.source, this.sink);
    }

    /* access modifiers changed from: package-private */
    public RealWebSocket.Streams newWebSocketStreams(Exchange exchange) throws SocketException {
        this.socket.setSoTimeout(0);
        noNewExchanges();
        final Exchange exchange2 = exchange;
        return new RealWebSocket.Streams(true, this.source, this.sink) {
            public void close() throws IOException {
                exchange2.bodyComplete(-1, true, true, (IOException) null);
            }
        };
    }

    public Route route() {
        return this.route;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    public Socket socket() {
        return this.socket;
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    public boolean isHealthy(boolean doExtensiveChecks) {
        int readTimeout;
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 != null) {
            return http2Connection2.isHealthy(System.nanoTime());
        }
        if (doExtensiveChecks) {
            try {
                readTimeout = this.socket.getSoTimeout();
                this.socket.setSoTimeout(1);
                if (this.source.exhausted()) {
                    this.socket.setSoTimeout(readTimeout);
                    return false;
                }
                this.socket.setSoTimeout(readTimeout);
                return true;
            } catch (SocketTimeoutException e) {
            } catch (IOException e2) {
                return false;
            } catch (Throwable th) {
                this.socket.setSoTimeout(readTimeout);
                throw th;
            }
        }
        return true;
    }

    public void onStream(Http2Stream stream) throws IOException {
        stream.close(ErrorCode.REFUSED_STREAM, (IOException) null);
    }

    public void onSettings(Http2Connection connection) {
        synchronized (this.connectionPool) {
            this.allocationLimit = connection.maxConcurrentStreams();
        }
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    /* access modifiers changed from: package-private */
    public void trackFailure(@Nullable IOException e) {
        if (!Thread.holdsLock(this.connectionPool)) {
            synchronized (this.connectionPool) {
                if (e instanceof StreamResetException) {
                    ErrorCode errorCode = ((StreamResetException) e).errorCode;
                    if (errorCode == ErrorCode.REFUSED_STREAM) {
                        int i = this.refusedStreamCount + 1;
                        this.refusedStreamCount = i;
                        if (i > 1) {
                            this.noNewExchanges = true;
                            this.routeFailureCount++;
                        }
                    } else if (errorCode != ErrorCode.CANCEL) {
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                    }
                } else {
                    if (isMultiplexed()) {
                        if (e instanceof ConnectionShutdownException) {
                        }
                    }
                    this.noNewExchanges = true;
                    if (this.successCount == 0) {
                        if (e != null) {
                            this.connectionPool.connectFailed(this.route, e);
                        }
                        this.routeFailureCount++;
                    }
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("Connection{").append(this.route.address().url().host()).append(":").append(this.route.address().url().port()).append(", proxy=").append(this.route.proxy()).append(" hostAddress=").append(this.route.socketAddress()).append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        return append.append(handshake2 != null ? handshake2.cipherSuite() : "none").append(" protocol=").append(this.protocol).append('}').toString();
    }
}
