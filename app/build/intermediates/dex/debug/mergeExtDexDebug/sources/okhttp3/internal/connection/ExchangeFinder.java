package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;

final class ExchangeFinder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Address address;
    private final Call call;
    private RealConnection connectingConnection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private boolean hasStreamFailure;
    private Route nextRouteToTry;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;
    private final Transmitter transmitter;

    ExchangeFinder(Transmitter transmitter2, RealConnectionPool connectionPool2, Address address2, Call call2, EventListener eventListener2) {
        this.transmitter = transmitter2;
        this.connectionPool = connectionPool2;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.routeSelector = new RouteSelector(address2, connectionPool2.routeDatabase, call2, eventListener2);
    }

    public ExchangeCodec find(OkHttpClient client, Interceptor.Chain chain, boolean doExtensiveHealthChecks) {
        try {
            return findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), client.pingIntervalMillis(), client.retryOnConnectionFailure(), doExtensiveHealthChecks).newCodec(client, chain);
        } catch (RouteException e) {
            trackFailure();
            throw e;
        } catch (IOException e2) {
            trackFailure();
            throw new RouteException(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r0.isHealthy(r9) != false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.RealConnection findHealthyConnection(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.RealConnection r0 = r3.findConnection(r4, r5, r6, r7, r8)
            okhttp3.internal.connection.RealConnectionPool r1 = r3.connectionPool
            monitor-enter(r1)
            int r2 = r0.successCount     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0013
            boolean r2 = r0.isMultiplexed()     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0013
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            return r0
        L_0x0013:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            boolean r1 = r0.isHealthy(r9)
            if (r1 != 0) goto L_0x001e
            r0.noNewExchanges()
            goto L_0x0000
        L_0x001e:
            return r0
        L_0x001f:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findHealthyConnection(int, int, int, int, boolean, boolean):okhttp3.internal.connection.RealConnection");
    }

    /* Debug info: failed to restart local var, previous not found, register: 19 */
    private RealConnection findConnection(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled) throws IOException {
        RealConnection releasedConnection;
        Socket toClose;
        boolean newRouteSelection;
        RouteSelector.Selection selection;
        boolean foundPooledConnection = false;
        RealConnection result = null;
        Route selectedRoute = null;
        synchronized (this.connectionPool) {
            if (!this.transmitter.isCanceled()) {
                this.hasStreamFailure = false;
                releasedConnection = this.transmitter.connection;
                if (this.transmitter.connection == null || !this.transmitter.connection.noNewExchanges) {
                    toClose = null;
                } else {
                    toClose = this.transmitter.releaseConnectionNoEvents();
                }
                if (this.transmitter.connection != null) {
                    result = this.transmitter.connection;
                    releasedConnection = null;
                }
                if (result == null) {
                    if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, (List<Route>) null, false)) {
                        foundPooledConnection = true;
                        result = this.transmitter.connection;
                    } else {
                        Route route = this.nextRouteToTry;
                        if (route != null) {
                            selectedRoute = route;
                            this.nextRouteToTry = null;
                        } else if (retryCurrentRoute()) {
                            selectedRoute = this.transmitter.connection.route();
                        }
                    }
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        Util.closeQuietly(toClose);
        if (releasedConnection != null) {
            this.eventListener.connectionReleased(this.call, releasedConnection);
        }
        if (foundPooledConnection) {
            this.eventListener.connectionAcquired(this.call, result);
        }
        if (result != null) {
            return result;
        }
        if (selectedRoute != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            newRouteSelection = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            newRouteSelection = true;
        }
        List<Route> routes = null;
        synchronized (this.connectionPool) {
            if (!this.transmitter.isCanceled()) {
                if (newRouteSelection) {
                    routes = this.routeSelection.getAll();
                    if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, routes, false)) {
                        foundPooledConnection = true;
                        result = this.transmitter.connection;
                    }
                }
                if (!foundPooledConnection) {
                    if (selectedRoute == null) {
                        selectedRoute = this.routeSelection.next();
                    }
                    result = new RealConnection(this.connectionPool, selectedRoute);
                    this.connectingConnection = result;
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (foundPooledConnection) {
            this.eventListener.connectionAcquired(this.call, result);
            return result;
        }
        result.connect(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled, this.call, this.eventListener);
        this.connectionPool.routeDatabase.connected(result.route());
        Socket socket = null;
        synchronized (this.connectionPool) {
            this.connectingConnection = null;
            if (this.connectionPool.transmitterAcquirePooledConnection(this.address, this.transmitter, routes, true)) {
                result.noNewExchanges = true;
                socket = result.socket();
                result = this.transmitter.connection;
                this.nextRouteToTry = selectedRoute;
            } else {
                this.connectionPool.put(result);
                this.transmitter.acquireConnectionNoEvents(result);
            }
        }
        Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, result);
        return result;
    }

    /* access modifiers changed from: package-private */
    public RealConnection connectingConnection() {
        if (Thread.holdsLock(this.connectionPool)) {
            return this.connectingConnection;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void trackFailure() {
        if (!Thread.holdsLock(this.connectionPool)) {
            synchronized (this.connectionPool) {
                this.hasStreamFailure = true;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public boolean hasStreamFailure() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.hasStreamFailure;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean hasRouteToTry() {
        synchronized (this.connectionPool) {
            boolean z = true;
            if (this.nextRouteToTry != null) {
                return true;
            }
            if (retryCurrentRoute()) {
                this.nextRouteToTry = this.transmitter.connection.route();
                return true;
            }
            RouteSelector.Selection selection = this.routeSelection;
            if ((selection == null || !selection.hasNext()) && !this.routeSelector.hasNext()) {
                z = false;
            }
            return z;
        }
    }

    private boolean retryCurrentRoute() {
        return this.transmitter.connection != null && this.transmitter.connection.routeFailureCount == 0 && Util.sameConnection(this.transmitter.connection.route().address().url(), this.address.url());
    }
}
