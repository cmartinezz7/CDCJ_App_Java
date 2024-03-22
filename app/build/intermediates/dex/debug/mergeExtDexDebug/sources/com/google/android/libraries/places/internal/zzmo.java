package com.google.android.libraries.places.internal;

import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public enum zzmo implements zzrg {
    UNKNOWN(0),
    TYPE_ADD(1),
    TYPE_REMOVE(2);
    
    private static final zzrf<zzmo> zzd = null;
    private final int zze;

    public final int zza() {
        return this.zze;
    }

    public static zzri zzb() {
        return zzmq.zza;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zze);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    private zzmo(int i) {
        this.zze = i;
    }

    static {
        zzd = new zzmn();
    }
}
