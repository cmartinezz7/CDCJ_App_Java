package com.google.android.libraries.places.internal;

import java.io.Serializable;
import java.lang.Comparable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
abstract class zzgq<C extends Comparable> implements Serializable, Comparable<zzgq<C>> {
    @NullableDecl
    final C zza;

    zzgq(@NullableDecl C c) {
        this.zza = c;
    }

    public abstract int hashCode();

    /* access modifiers changed from: package-private */
    public abstract void zza(StringBuilder sb);

    /* access modifiers changed from: package-private */
    public abstract boolean zza(C c);

    /* access modifiers changed from: package-private */
    public abstract void zzb(StringBuilder sb);

    /* renamed from: zza */
    public int compareTo(zzgq<C> zzgq) {
        if (zzgq == zzgr.zzb) {
            return 1;
        }
        if (zzgq == zzgp.zzb) {
            return -1;
        }
        int zzc = zzhb.zzc(this.zza, zzgq.zza);
        if (zzc != 0) {
            return zzc;
        }
        boolean z = this instanceof zzgs;
        if (z == (zzgq instanceof zzgs)) {
            return 0;
        }
        if (z) {
            return 1;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof zzgq) {
            try {
                if (compareTo((zzgq) obj) == 0) {
                    return true;
                }
                return false;
            } catch (ClassCastException e) {
            }
        }
        return false;
    }

    static <C extends Comparable> zzgq<C> zzb(C c) {
        return new zzgu(c);
    }
}
