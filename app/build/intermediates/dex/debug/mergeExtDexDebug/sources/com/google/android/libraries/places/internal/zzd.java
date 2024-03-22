package com.google.android.libraries.places.internal;

import android.os.Build;
import android.os.SystemClock;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzd implements zzb {
    private static final boolean zza = zzb();

    private static boolean zzb() {
        try {
            if (Build.VERSION.SDK_INT < 17) {
                return false;
            }
            SystemClock.elapsedRealtimeNanos();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public final long zza() {
        return SystemClock.elapsedRealtime();
    }
}
