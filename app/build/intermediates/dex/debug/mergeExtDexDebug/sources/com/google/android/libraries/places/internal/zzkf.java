package com.google.android.libraries.places.internal;

import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public enum zzkf implements zzrg {
    INVALID_MOVEMENT(0),
    UNKNOWN_MOVEMENT(1),
    STILL_MOVEMENT(2),
    WALKING_MOVEMENT(3),
    FAST_MOVING_MOVEMENT(4);
    
    private static final zzrf<zzkf> zzf = null;
    private final int zzg;

    public final int zza() {
        return this.zzg;
    }

    public static zzri zzb() {
        return zzkg.zza;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzg);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    private zzkf(int i) {
        this.zzg = i;
    }

    static {
        zzf = new zzkh();
    }
}
