package com.tealium.internal.listeners;

import com.tealium.internal.data.Dispatch;

public interface DispatchQueuedListener extends BackgroundListener {
    void onDispatchQueued(Dispatch dispatch);
}
