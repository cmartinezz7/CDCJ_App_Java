package com.tealium.internal.c;

import android.webkit.WebView;
import com.tealium.internal.listeners.WebViewLoadedListener;

public final class p extends j<WebViewLoadedListener> {
    private final WebView a;
    private final boolean b;

    public p(WebView webView, boolean z) {
        super(WebViewLoadedListener.class);
        this.a = webView;
        this.b = z;
    }

    public void a(WebViewLoadedListener webViewLoadedListener) {
        webViewLoadedListener.onWebViewLoad(this.a, this.b);
    }
}
