package com.tealium.internal.listeners;

import com.tealium.internal.data.Dispatch;

public interface DispatchSendListener extends BackgroundListener {
    void onDispatchSend(Dispatch dispatch);
}
