package com.tealium.internal.listeners;

public interface TraceUpdateListener extends BackgroundListener {
    void onTraceUpdate(String str, boolean z);
}
