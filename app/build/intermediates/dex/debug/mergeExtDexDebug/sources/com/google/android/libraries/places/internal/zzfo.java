package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
abstract class zzfo<T> implements Iterator<T> {
    private int zza = zzfq.zzb;
    @NullableDecl
    private T zzb;

    protected zzfo() {
    }

    /* access modifiers changed from: protected */
    public abstract T zza();

    /* access modifiers changed from: protected */
    @NullableDecl
    public final T zzb() {
        this.zza = zzfq.zzc;
        return null;
    }

    public final boolean hasNext() {
        if (this.zza != zzfq.zzd) {
            int i = zzfr.zza[this.zza - 1];
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
            this.zza = zzfq.zzd;
            this.zzb = zza();
            if (this.zza == zzfq.zzc) {
                return false;
            }
            this.zza = zzfq.zza;
            return true;
        }
        throw new IllegalStateException();
    }

    public final T next() {
        if (hasNext()) {
            this.zza = zzfq.zzb;
            T t = this.zzb;
            this.zzb = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
