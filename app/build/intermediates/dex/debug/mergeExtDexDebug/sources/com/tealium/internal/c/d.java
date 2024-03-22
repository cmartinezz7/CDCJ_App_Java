package com.tealium.internal.c;

import com.tealium.internal.listeners.BatteryUpdateListener;

public final class d extends j<BatteryUpdateListener> {
    private final boolean a;

    public d(boolean z) {
        super(BatteryUpdateListener.class);
        this.a = z;
    }

    public void a(BatteryUpdateListener batteryUpdateListener) {
        batteryUpdateListener.onBatteryUpdate(this.a);
    }
}
