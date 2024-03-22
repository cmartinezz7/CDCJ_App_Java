package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzhd<E> extends zzgv<E> {
    static final zzgv<Object> zza = new zzhd(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    zzhd(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzd() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzf() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    public final E get(int i) {
        zzgg.zza(i, this.zzc);
        return this.zzb[i];
    }
}
