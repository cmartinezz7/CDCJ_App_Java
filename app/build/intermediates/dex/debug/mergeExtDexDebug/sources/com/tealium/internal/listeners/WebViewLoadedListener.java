package com.tealium.internal.listeners;

import android.webkit.WebView;

public interface WebViewLoadedListener extends MainListener {
    void onWebViewLoad(WebView webView, boolean z);
}
