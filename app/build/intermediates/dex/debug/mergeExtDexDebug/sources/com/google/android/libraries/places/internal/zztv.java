package com.google.android.libraries.places.internal;

import java.util.ListIterator;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zztv implements ListIterator<String> {
    private ListIterator<String> zza;
    private final /* synthetic */ int zzb;
    private final /* synthetic */ zztw zzc;

    zztv(zztw zztw, int i) {
        this.zzc = zztw;
        this.zzb = i;
        this.zza = zztw.zza.listIterator(i);
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return this.zza.previous();
    }

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }
}
