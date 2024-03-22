package com.tealium.internal.listeners;

import com.tealium.internal.data.Dispatch;

public interface DispatchReadyListener extends BackgroundListener {
    void onDispatchReady(Dispatch dispatch);
}
