package com.google.android.libraries.places.internal;

import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public enum zzpk implements zzrg {
    UNDEFINED(0),
    INFERRED_HOME(1),
    INFERRED_WORK(2);
    
    private static final zzrf<zzpk> zzd = null;
    private final int zze;

    public final int zza() {
        return this.zze;
    }

    public static zzri zzb() {
        return zzpm.zza;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zze);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    private zzpk(int i) {
        this.zze = i;
    }

    static {
        zzd = new zzpj();
    }
}
