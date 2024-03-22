package com.tealium.internal.c;

import com.tealium.internal.data.Dispatch;
import com.tealium.internal.listeners.PopulateDispatchListener;

public class k extends j<PopulateDispatchListener> {
    private final Dispatch a;

    public k(Dispatch dispatch) {
        super(PopulateDispatchListener.class);
        this.a = dispatch;
        if (dispatch == null) {
            throw new IllegalArgumentException();
        }
    }

    public void a(PopulateDispatchListener populateDispatchListener) {
        populateDispatchListener.onPopulateDispatch(this.a);
    }
}
