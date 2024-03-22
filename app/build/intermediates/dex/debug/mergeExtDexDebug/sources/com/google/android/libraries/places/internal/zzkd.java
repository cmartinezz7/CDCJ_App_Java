package com.google.android.libraries.places.internal;

import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public enum zzkd implements zzrg {
    INVALID_STATE(0),
    NOT_INITIALIZED(1),
    NO_GEOFENCE(2),
    DISABLED(3),
    HAS_GEOFENCE(4),
    UNAVAILABLE_ACTIVITY(5),
    UNKNOWN_ACTIVITY(6),
    STILL_ACTIVITY(7),
    WALKING_ACTIVITY(8),
    FAST_MOVING_ACTIVITY(9),
    BACKGROUND_USER(10),
    CHRE_GEOFENCING(11);
    
    private static final zzrf<zzkd> zzm = null;
    private final int zzn;

    public final int zza() {
        return this.zzn;
    }

    public static zzri zzb() {
        return zzke.zza;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzn);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    private zzkd(int i) {
        this.zzn = i;
    }

    static {
        zzm = new zzkc();
    }
}
