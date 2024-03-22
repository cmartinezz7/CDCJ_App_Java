package com.tealium.internal.b;

import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tealium.internal.a;
import com.tealium.internal.b;
import com.tealium.internal.c.i;
import com.tealium.internal.c.o;
import com.tealium.internal.c.p;
import com.tealium.internal.d;
import com.tealium.internal.data.Dispatch;
import com.tealium.internal.data.PublishSettings;
import com.tealium.internal.e;
import com.tealium.internal.listeners.DispatchReadyListener;
import com.tealium.internal.listeners.DispatchSendListener;
import com.tealium.internal.listeners.EvalJavaScriptListener;
import com.tealium.internal.listeners.PublishSettingsUpdateListener;
import com.tealium.internal.tagbridge.d;
import com.tealium.library.DataSources;
import com.tealium.library.R;
import com.tealium.library.Tealium;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.Typography;

public final class c implements DispatchReadyListener, DispatchSendListener, EvalJavaScriptListener, PublishSettingsUpdateListener {
    private final a a;
    /* access modifiers changed from: private */
    public final AtomicInteger b;
    private final SimpleDateFormat c;
    /* access modifiers changed from: private */
    public final com.tealium.internal.c d;
    /* access modifiers changed from: private */
    public final b e;
    /* access modifiers changed from: private */
    public final Tealium.Config f;
    private final String g;
    /* access modifiers changed from: private */
    public final d h;
    private boolean i;
    private long j;
    /* access modifiers changed from: private */
    public volatile long k;
    private String l;
    /* access modifiers changed from: private */
    public volatile WebView m;

    /* renamed from: com.tealium.internal.b.c$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public c(Tealium.Config config, com.tealium.internal.c cVar) {
        this.f = config;
        this.g = config.getOverrideTagManagementUrl() == null ? config.getDefaultTagManagementUrl() : config.getOverrideTagManagementUrl();
        this.a = a.a(config.getApplication());
        this.b = new AtomicInteger(0);
        this.e = config.getLogger();
        this.d = cVar;
        this.h = new d(config, cVar);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
        this.c = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.k = Long.MIN_VALUE;
        onPublishSettingsUpdate(config.getPublishSettings());
        cVar.a(b());
    }

    private d.a a(final int i2) {
        return new d.a() {
            public void a(String str, String str2, int i, String str3, byte[] bArr) {
                c.this.b.set(i2);
                if (i == 200) {
                    boolean unused = c.this.c();
                }
            }

            public void a(String str, Throwable th) {
                c.this.b.set(i2);
            }
        };
    }

    private Runnable a(final boolean z, final String str) {
        return new Runnable() {
            public void run() {
                int andSet = c.this.b.getAndSet(1);
                if (andSet != 2) {
                    c.this.b.set(andSet);
                    return;
                }
                try {
                    if (z) {
                        c.this.m.loadUrl("javascript:utag.track('kill_visitor_session', { event: 'kill_visitor_session', 'cp.trace_id' : utag.data['cp.trace_id'] });");
                        c.this.m.loadUrl("javascript:document.cookie = 'trace_id=; expires=Thu, 01 Jan 1970 00:00:01 GMT; path=/'");
                    }
                    if (!TextUtils.isEmpty(str)) {
                        c.this.m.loadUrl(String.format(Locale.ROOT, "javascript:document.cookie = 'trace_id=%s; expires=0; path=/';", new Object[]{str}));
                    }
                    c.this.m.reload();
                } catch (Throwable th) {
                    c.this.e.a(th);
                }
            }
        };
    }

    private void a(Dispatch dispatch) {
        this.d.a(new i(String.format(Locale.ROOT, "utag.track(\"%s\", %s)", new Object[]{"remote_api", dispatch.toJsonString()})));
    }

    /* access modifiers changed from: private */
    public static WebChromeClient b(final b bVar) {
        return new WebChromeClient() {
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0059, code lost:
                if (r1.a() != false) goto L_0x005b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0044, code lost:
                if (r1.a() != false) goto L_0x005b;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean onConsoleMessage(android.webkit.ConsoleMessage r7) {
                /*
                    r6 = this;
                    java.util.Locale r0 = java.util.Locale.ROOT
                    r1 = 3
                    java.lang.Object[] r2 = new java.lang.Object[r1]
                    java.lang.String r3 = r7.sourceId()
                    r4 = 0
                    r2[r4] = r3
                    int r3 = r7.lineNumber()
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                    r4 = 1
                    r2[r4] = r3
                    java.lang.String r3 = r7.message()
                    r5 = 2
                    r2[r5] = r3
                    java.lang.String r3 = "Src: %s; Line: %d; %s"
                    java.lang.String r0 = java.lang.String.format(r0, r3, r2)
                    int[] r2 = com.tealium.internal.b.c.AnonymousClass7.a
                    android.webkit.ConsoleMessage$MessageLevel r3 = r7.messageLevel()
                    int r3 = r3.ordinal()
                    r2 = r2[r3]
                    java.lang.String r3 = "Tealium-WebView"
                    if (r2 == r4) goto L_0x0077
                    if (r2 == r5) goto L_0x006b
                    if (r2 == r1) goto L_0x005f
                    r1 = 4
                    if (r2 == r1) goto L_0x0053
                    r1 = 5
                    if (r2 == r1) goto L_0x0047
                    com.tealium.internal.b r1 = r1
                    boolean r1 = r1.a()
                    if (r1 == 0) goto L_0x0082
                    goto L_0x005b
                L_0x0047:
                    com.tealium.internal.b r1 = r1
                    boolean r1 = r1.d()
                    if (r1 == 0) goto L_0x0082
                    android.util.Log.w(r3, r0)
                    goto L_0x0082
                L_0x0053:
                    com.tealium.internal.b r1 = r1
                    boolean r1 = r1.a()
                    if (r1 == 0) goto L_0x0082
                L_0x005b:
                    android.util.Log.v(r3, r0)
                    goto L_0x0082
                L_0x005f:
                    com.tealium.internal.b r1 = r1
                    boolean r1 = r1.c()
                    if (r1 == 0) goto L_0x0082
                    android.util.Log.i(r3, r0)
                    goto L_0x0082
                L_0x006b:
                    com.tealium.internal.b r1 = r1
                    boolean r1 = r1.e()
                    if (r1 == 0) goto L_0x0082
                    android.util.Log.e(r3, r0)
                    goto L_0x0082
                L_0x0077:
                    com.tealium.internal.b r1 = r1
                    boolean r1 = r1.b()
                    if (r1 == 0) goto L_0x0082
                    android.util.Log.d(r3, r0)
                L_0x0082:
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tealium.internal.b.c.AnonymousClass6.onConsoleMessage(android.webkit.ConsoleMessage):boolean");
            }
        };
    }

    private Runnable b() {
        return new Runnable() {
            public void run() {
                try {
                    if (c.this.m == null) {
                        WebView unused = c.this.m = new WebView(c.this.f.getApplication().getApplicationContext());
                        String absolutePath = c.this.f.getTealiumDir().getAbsolutePath();
                        WebSettings settings = c.this.m.getSettings();
                        settings.setAppCacheEnabled(true);
                        settings.setDatabaseEnabled(true);
                        settings.setJavaScriptEnabled(true);
                        settings.setDomStorageEnabled(true);
                        settings.setAppCachePath(absolutePath);
                        if (Build.VERSION.SDK_INT < 19) {
                            settings.setDatabasePath(absolutePath);
                        }
                        c.this.m.setWebChromeClient(c.b(c.this.e));
                        c.this.m.setWebViewClient(c.this.f());
                        c.this.d.a(new o(c.this.m));
                        boolean unused2 = c.this.c();
                    }
                } catch (Throwable th) {
                    if (c.this.e.e()) {
                        c.this.e.a(R.string.webview_dispatcher_error_creating_webview, th, new Object[0]);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public boolean c() {
        boolean z = this.i && !this.a.a();
        if (this.m == null || z || !this.a.b() || 1 == this.b.getAndSet(1)) {
            return false;
        }
        final String str = this.g + ((this.g.contains("?") ? Typography.amp : '?') + "timestamp_unix=" + (System.currentTimeMillis() / 1000));
        if (e.a()) {
            try {
                this.m.loadUrl(str);
            } catch (Throwable th) {
                this.e.d(R.string.webview_dispatcher_error_loading_url, str, this.m);
            }
        } else {
            this.d.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        c.this.m.loadUrl(str);
                    } catch (Throwable th) {
                        c.this.e.d(R.string.webview_dispatcher_error_loading_url, str, c.this.m);
                    }
                }
            });
        }
        return true;
    }

    private void d() {
        int andSet;
        if (!(this.i && !this.a.a()) && this.a.b() && 1 != (andSet = this.b.getAndSet(1))) {
            this.d.c(com.tealium.internal.d.a(this.g).a("Accept-Encoding", "*").a("If-Modified-Since", this.c.format(new Date(this.k))).a(a(andSet)).a());
        }
    }

    private boolean e() {
        return SystemClock.elapsedRealtime() - this.k >= this.j;
    }

    /* access modifiers changed from: private */
    public WebViewClient f() {
        return new WebViewClient() {
            public void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
            }

            public void onPageFinished(final WebView webView, String str) {
                super.onPageFinished(webView, str);
                long unused = c.this.k = SystemClock.elapsedRealtime();
                if (3 == c.this.b.getAndSet(2)) {
                    c.this.b.set(3);
                    c.this.e.d(R.string.webview_dispatcher_error_loading_url, str, webView);
                    return;
                }
                c.this.d.a((Runnable) new Runnable() {
                    public void run() {
                        webView.loadUrl("javascript:(function(){\n    var payload = {};\n    try {\n        var ts = new RegExp(\"ut[0-9]+\\.[0-9]+\\.[0-9]{12}\").exec(document.childNodes[0].textContent)[0];\n        ts = ts.substring(ts.length - 12, ts.length);\n        var y = ts.substring(0, 4);\n        var mo = ts.substring(4, 6);\n        var d = ts.substring(6, 8);\n        var h = ts.substring(8, 10);\n        var mi = ts.substring(10, 12);\n        var t = Date.from(y+'/'+mo+'/'+d+' '+h+':'+mi+' UTC');\n        if(!isNaN(t)){\n            payload.published = t;\n        }\n    } catch(e) {    }\n    var f=document.cookie.indexOf('trace_id=');\n    if(f>=0){\n        payload.trace_id = document.cookie.substring(f+9).split(';')[0];\n    }\n    window.open('tealium://_config?request=' + encodeURIComponent(JSON.stringify({\n        payload : payload\n    })), '_self');\n})()");
                    }
                });
                c.this.d.a(new p(c.this.m, true));
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (3 != c.this.b.getAndSet(3)) {
                    long unused = c.this.k = SystemClock.uptimeMillis();
                    c.this.d.a(new p(c.this.m, false));
                }
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                c.this.b.set(3);
                if (c.this.e.e()) {
                    c.this.e.d(R.string.webview_dispatcher_rcvd_error, webResourceError);
                }
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                c.this.e.d(R.string.webview_dispatcher_rcvd_http_error, webResourceRequest.getUrl(), Integer.valueOf(webResourceResponse.getStatusCode()), webResourceResponse.getReasonPhrase());
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                c.this.b.set(3);
                c.this.e.d(R.string.webview_dispatcher_rcvd_ssl_error, webView, webView.getUrl(), sslError);
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (com.tealium.internal.tagbridge.d.a(str)) {
                    try {
                        if (!c.this.f.isRemoteCommandEnabled()) {
                            if (!com.tealium.internal.tagbridge.d.b(str)) {
                                c.this.e.a(R.string.webview_dispatcher_error_remote_command_not_allowed, (Throwable) null, str);
                            }
                        }
                        c.this.h.c(str);
                    } catch (Throwable th) {
                        c.this.e.a(th);
                    }
                } else {
                    c.this.e.e(R.string.webview_dispatcher_warn_override_url_loading, str);
                }
                return true;
            }
        };
    }

    public com.tealium.internal.tagbridge.d a() {
        return this.h;
    }

    public void a(String str, boolean z) {
        String str2 = this.l;
        this.l = str;
        if (z && !TextUtils.equals(str2, str)) {
            this.d.a(a(!TextUtils.isEmpty(str2), str));
        }
    }

    public void onDispatchReady(Dispatch dispatch) {
        int i2 = this.b.get();
        if (i2 == 0) {
            this.d.a(b());
        } else if (i2 == 1) {
        } else {
            if (i2 == 2) {
                a(dispatch);
                if (e()) {
                    d();
                }
            } else if (i2 != 3 || e()) {
                c();
            }
        }
    }

    public void onDispatchSend(Dispatch dispatch) {
        if (this.b.get() == 2) {
            String string = dispatch.getString(DataSources.Key.CALL_TYPE);
            Locale locale = Locale.ROOT;
            Object[] objArr = new Object[2];
            if (string == null) {
                string = "link";
            }
            objArr[0] = string;
            objArr[1] = dispatch.toJsonString();
            this.d.a(new i(String.format(locale, "utag.track(\"%s\", %s)", objArr)));
        }
    }

    public void onEvalJavaScript(String str) {
        if (this.b.get() == 2) {
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    this.m.evaluateJavascript(str.startsWith("javascript:") ? str.substring("javascript:".length()) : str, (ValueCallback) null);
                } else {
                    this.m.loadUrl(str.startsWith("javascript:") ? str : "javascript:" + str);
                }
            } catch (Throwable th) {
                this.e.b(th);
            }
        }
    }

    public void onPublishSettingsUpdate(PublishSettings publishSettings) {
        this.i = publishSettings.isWifiOnlySending();
        this.j = ((long) publishSettings.getMinutesBetweenRefresh()) * 60000;
    }
}
