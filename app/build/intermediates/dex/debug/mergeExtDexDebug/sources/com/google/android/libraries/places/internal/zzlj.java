package com.google.android.libraries.places.internal;

import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public enum zzlj implements zzrg {
    UNKNOWN_MODEL_VERSION(0),
    SIMPLE_TENSOR_FLOW_TWO_PASS_V1(1),
    DEFAULT_MODEL_V1(2),
    SIMPLE_TENSOR_FLOW_TWO_PASS_V2(3);
    
    private static final zzrf<zzlj> zze = null;
    private final int zzf;

    public final int zza() {
        return this.zzf;
    }

    public static zzri zzb() {
        return zzlk.zza;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzf);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    private zzlj(int i) {
        this.zzf = i;
    }

    static {
        zze = new zzli();
    }
}
