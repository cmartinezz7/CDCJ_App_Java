package com.tealium.internal.listeners;

import com.tealium.internal.data.Dispatch;

public interface DispatchPopulatedListener extends BackgroundListener {
    void onDispatchPopulated(Dispatch dispatch);
}
