package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzhk extends zzgv<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzhk(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzgg.zza(i, this.zzc);
        return this.zza[(i * 2) + this.zzb];
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    public final int size() {
        return this.zzc;
    }
}
