package com.tealium.internal.c;

import com.tealium.internal.data.Dispatch;
import com.tealium.internal.listeners.DispatchReadyListener;

public final class g extends j<DispatchReadyListener> {
    private final Dispatch a;

    public g(Dispatch dispatch) {
        super(DispatchReadyListener.class);
        this.a = dispatch;
        if (dispatch == null) {
            throw new IllegalArgumentException();
        }
    }

    public void a(DispatchReadyListener dispatchReadyListener) {
        dispatchReadyListener.onDispatchReady(this.a);
    }
}
