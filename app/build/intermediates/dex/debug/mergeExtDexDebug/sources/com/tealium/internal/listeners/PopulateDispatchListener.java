package com.tealium.internal.listeners;

import com.tealium.internal.data.Dispatch;

public interface PopulateDispatchListener extends BackgroundListener {
    void onPopulateDispatch(Dispatch dispatch);
}
