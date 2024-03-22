package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public abstract class zzhc<E> extends zzgw<E> implements Set<E> {
    @NullableDecl
    private transient zzgv<E> zza;

    zzhc() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return zzhj.zza(this, obj);
    }

    public int hashCode() {
        return zzhj.zza(this);
    }

    public zzgv<E> zzc() {
        zzgv<E> zzgv = this.zza;
        if (zzgv != null) {
            return zzgv;
        }
        zzgv<E> zza2 = zza();
        this.zza = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public zzgv<E> zza() {
        return zzgv.zzb(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
