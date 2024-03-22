package com.google.android.libraries.places.internal;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzdo implements View.OnTouchListener {
    private final zzdn zza;

    zzdo(zzdn zzdn) {
        this.zza = zzdn;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.zza.zza(view, motionEvent);
    }
}
