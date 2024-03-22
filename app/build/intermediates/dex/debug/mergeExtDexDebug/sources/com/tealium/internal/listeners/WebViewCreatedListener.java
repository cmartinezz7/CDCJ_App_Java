package com.tealium.internal.listeners;

import android.webkit.WebView;

public interface WebViewCreatedListener extends MainListener {
    void onWebViewCreated(WebView webView);
}
