package com.tealium.internal.c;

import com.tealium.internal.listeners.DisableListener;
import com.tealium.library.Tealium;

public class e extends j<DisableListener> {
    private final Tealium a;

    public e(Tealium tealium) {
        super(DisableListener.class);
        this.a = tealium;
        if (tealium == null) {
            throw new IllegalArgumentException();
        }
    }

    public void a(DisableListener disableListener) {
        disableListener.onDisable(this.a);
    }
}
