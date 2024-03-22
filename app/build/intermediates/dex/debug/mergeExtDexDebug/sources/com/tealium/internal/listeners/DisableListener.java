package com.tealium.internal.listeners;

import com.tealium.library.Tealium;

public interface DisableListener extends BackgroundListener {
    void onDisable(Tealium tealium);
}
