package com.tealium.collect.listeners;

import com.tealium.collect.attribute.FlagAttribute;

public interface FlagUpdateListener extends CollectUpdateListener {
    void onFlagUpdate(FlagAttribute flagAttribute, FlagAttribute flagAttribute2);
}
