package com.google.android.libraries.places.internal;

import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public enum zzmv implements zzrg {
    SUCCESS(0),
    GEOFENCE_NOT_AVAILABLE(1000),
    GEOFENCE_TOO_MANY_GEOFENCES(1001),
    GEOFENCE_TOO_MANY_PENDING_INTENTS(1002),
    GEOFENCE_CURRENT_LOCATION_UNKNOWN(1003);
    
    private static final zzrf<zzmv> zzf = null;
    private final int zzg;

    public final int zza() {
        return this.zzg;
    }

    public static zzri zzb() {
        return zzmw.zza;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzg);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    private zzmv(int i) {
        this.zzg = i;
    }

    static {
        zzf = new zzmx();
    }
}
