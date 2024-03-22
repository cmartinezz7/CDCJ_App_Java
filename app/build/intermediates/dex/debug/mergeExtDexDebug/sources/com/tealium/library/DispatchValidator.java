package com.tealium.library;

import com.tealium.internal.data.Dispatch;

public abstract class DispatchValidator {
    /* access modifiers changed from: protected */
    public boolean shouldDrop(Dispatch dispatch) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean shouldQueue(Dispatch dispatch, boolean z) {
        return z;
    }
}
