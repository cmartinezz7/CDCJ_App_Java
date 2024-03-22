package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzqi {
    private final zzqn zza;
    private final byte[] zzb;

    private zzqi(int i) {
        byte[] bArr = new byte[i];
        this.zzb = bArr;
        this.zza = zzqn.zza(bArr);
    }

    public final zzqa zza() {
        this.zza.zzb();
        return new zzqk(this.zzb);
    }

    public final zzqn zzb() {
        return this.zza;
    }

    /* synthetic */ zzqi(int i, zzpz zzpz) {
        this(i);
    }
}
