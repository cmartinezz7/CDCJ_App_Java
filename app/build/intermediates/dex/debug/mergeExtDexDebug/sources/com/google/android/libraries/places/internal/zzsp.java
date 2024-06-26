package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzsp<T> implements zzsz<T> {
    private final zzsm zza;
    private final zztr<?, ?> zzb;
    private final boolean zzc;
    private final zzqr<?> zzd;

    private zzsp(zztr<?, ?> zztr, zzqr<?> zzqr, zzsm zzsm) {
        this.zzb = zztr;
        this.zzc = zzqr.zza(zzsm);
        this.zzd = zzqr;
        this.zza = zzsm;
    }

    static <T> zzsp<T> zza(zztr<?, ?> zztr, zzqr<?> zzqr, zzsm zzsm) {
        return new zzsp<>(zztr, zzqr, zzsm);
    }

    public final boolean zza(T t, T t2) {
        if (!this.zzb.zza(t).equals(this.zzb.zza(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final int zza(T t) {
        int hashCode = this.zzb.zza(t).hashCode();
        if (this.zzc) {
            return (hashCode * 53) + this.zzd.zza((Object) t).hashCode();
        }
        return hashCode;
    }

    public final void zzb(T t, T t2) {
        zztb.zza(this.zzb, t, t2);
        if (this.zzc) {
            zztb.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzul zzul) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzqy zzqy = (zzqy) next.getKey();
            if (zzqy.zzc() != zzum.MESSAGE || zzqy.zzd() || zzqy.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzrs) {
                zzul.zza(zzqy.zza(), (Object) ((zzrs) next).zza().zzc());
            } else {
                zzul.zza(zzqy.zza(), next.getValue());
            }
        }
        zztr<?, ?> zztr = this.zzb;
        zztr.zzb(zztr.zza(t), zzul);
    }

    public final void zzb(T t) {
        this.zzb.zzb(t);
        this.zzd.zzc(t);
    }

    public final boolean zzc(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    public final int zzd(T t) {
        zztr<?, ?> zztr = this.zzb;
        int zzc2 = zztr.zzc(zztr.zza(t)) + 0;
        if (this.zzc) {
            return zzc2 + this.zzd.zza((Object) t).zzg();
        }
        return zzc2;
    }
}
