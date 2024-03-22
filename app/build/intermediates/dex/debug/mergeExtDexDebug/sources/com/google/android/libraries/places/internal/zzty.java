package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzty implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zztw zzb;

    zzty(zztw zztw) {
        this.zzb = zztw;
        this.zza = zztw.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }
}
