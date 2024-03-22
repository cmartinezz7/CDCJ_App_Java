package com.google.android.libraries.places.internal;

import android.os.SystemClock;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzg {
    private static final zzg zzd = new zzg();
    private final long zza;
    private long zzb;
    private int zzc;
    private boolean zze;

    public static zzg zza() {
        return new zzg();
    }

    zzg() {
        this(SystemClock.elapsedRealtime());
    }

    private zzg(long j) {
        this.zzb = -1;
        this.zzc = zzi.zza;
        this.zze = false;
        this.zza = j;
    }
}
