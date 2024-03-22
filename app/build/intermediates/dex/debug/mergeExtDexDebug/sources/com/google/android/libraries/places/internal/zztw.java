package com.google.android.libraries.places.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zztw extends AbstractList<String> implements zzrw, RandomAccess {
    /* access modifiers changed from: private */
    public final zzrw zza;

    public zztw(zzrw zzrw) {
        this.zza = zzrw;
    }

    public final Object zza(int i) {
        return this.zza.zza(i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zza(zzqa zzqa) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zztv(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzty(this);
    }

    public final List<?> zzd() {
        return this.zza.zzd();
    }

    public final zzrw zze() {
        return this;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}
