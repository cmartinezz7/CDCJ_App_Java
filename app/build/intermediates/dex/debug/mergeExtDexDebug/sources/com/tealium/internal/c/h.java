package com.tealium.internal.c;

import com.tealium.internal.data.Dispatch;
import com.tealium.internal.listeners.DispatchSendListener;

public class h extends j<DispatchSendListener> {
    private final Dispatch a;

    public h(Dispatch dispatch) {
        super(DispatchSendListener.class);
        this.a = dispatch;
        if (dispatch == null) {
            throw new IllegalArgumentException();
        }
    }

    public void a(DispatchSendListener dispatchSendListener) {
        dispatchSendListener.onDispatchSend(this.a);
    }
}
