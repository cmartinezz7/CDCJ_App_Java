package com.tealium.internal.listeners;

public interface BatteryUpdateListener extends BackgroundListener {
    void onBatteryUpdate(boolean z);
}
