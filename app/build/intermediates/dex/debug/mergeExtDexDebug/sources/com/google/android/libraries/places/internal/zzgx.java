package com.google.android.libraries.places.internal;

import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzgx extends zzgv<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzgv zzc;

    zzgx(zzgv zzgv, int i, int i2) {
        this.zzc = zzgv;
        this.zza = i;
        this.zzb = i2;
    }

    public final int size() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzd() {
        return this.zzc.zzd();
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return this.zzc.zze() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzf() {
        return this.zzc.zze() + this.zza + this.zzb;
    }

    public final E get(int i) {
        zzgg.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    public final zzgv<E> zza(int i, int i2) {
        zzgg.zza(i, i2, this.zzb);
        zzgv zzgv = this.zzc;
        int i3 = this.zza;
        return (zzgv) zzgv.subList(i + i3, i2 + i3);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
