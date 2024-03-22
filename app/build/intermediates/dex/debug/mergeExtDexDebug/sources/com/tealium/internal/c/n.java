package com.tealium.internal.c;

import android.text.TextUtils;
import com.tealium.internal.listeners.TraceUpdateListener;

public class n extends j<TraceUpdateListener> {
    private final String a;
    private final boolean b;

    public n(String str, boolean z) {
        super(TraceUpdateListener.class);
        this.a = TextUtils.isEmpty(str) ? null : str;
        this.b = z;
    }

    public void a(TraceUpdateListener traceUpdateListener) {
        traceUpdateListener.onTraceUpdate(this.a, this.b);
    }
}
