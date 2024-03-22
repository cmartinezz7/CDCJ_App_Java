package com.google.android.libraries.places.internal;

import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public enum zzne implements zzrg {
    TYPE_UNSPECIFIED(0),
    ENTER(1),
    EXIT(2),
    DWELL_DEPRECATED(3),
    DWELL(4);
    
    private static final zzrf<zzne> zzf = null;
    private final int zzg;

    public final int zza() {
        return this.zzg;
    }

    public static zzri zzb() {
        return zznf.zza;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzg);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    private zzne(int i) {
        this.zzg = i;
    }

    static {
        zzf = new zzng();
    }
}
