package com.tealium.internal.c;

import com.tealium.internal.listeners.EvalJavaScriptListener;

public final class i extends j<EvalJavaScriptListener> {
    private final String a;

    public i(String str) {
        super(EvalJavaScriptListener.class);
        this.a = str;
    }

    public void a(EvalJavaScriptListener evalJavaScriptListener) {
        evalJavaScriptListener.onEvalJavaScript(this.a);
    }
}
