package com.google.android.libraries.places.internal;

import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public enum zznc implements zzrg {
    OTHERS(0),
    NEARBY_ALERT(1),
    GET_CURRENT_PLACE(2),
    GEO_DATA_API(3);
    
    private static final zzrf<zznc> zze = null;
    private final int zzf;

    public final int zza() {
        return this.zzf;
    }

    public static zzri zzb() {
        return zznd.zza;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzf);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    private zznc(int i) {
        this.zzf = i;
    }

    static {
        zze = new zznb();
    }
}
