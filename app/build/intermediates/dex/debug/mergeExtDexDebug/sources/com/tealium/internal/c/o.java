package com.tealium.internal.c;

import android.webkit.WebView;
import com.tealium.internal.listeners.WebViewCreatedListener;

public class o extends j<WebViewCreatedListener> {
    private final WebView a;

    public o(WebView webView) {
        super(WebViewCreatedListener.class);
        this.a = webView;
        if (webView == null) {
            throw new IllegalArgumentException();
        }
    }

    public void a(WebViewCreatedListener webViewCreatedListener) {
        webViewCreatedListener.onWebViewCreated(this.a);
    }
}
