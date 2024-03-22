package com.tealium.internal.c;

import com.tealium.internal.data.Dispatch;
import com.tealium.internal.listeners.DispatchQueuedListener;

public class f extends j<DispatchQueuedListener> {
    private final Dispatch a;

    public f(Dispatch dispatch) {
        super(DispatchQueuedListener.class);
        this.a = dispatch;
        if (dispatch == null) {
            throw new IllegalArgumentException();
        }
    }

    public void a(DispatchQueuedListener dispatchQueuedListener) {
        dispatchQueuedListener.onDispatchQueued(this.a);
    }
}
