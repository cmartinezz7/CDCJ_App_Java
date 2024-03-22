package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zztg implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private Iterator<Map.Entry<K, V>> zzb;
    private final /* synthetic */ zzte zzc;

    private zztg(zzte zzte) {
        this.zzc = zzte;
        this.zza = zzte.zzb.size();
    }

    public final boolean hasNext() {
        int i = this.zza;
        return (i > 0 && i <= this.zzc.zzb.size()) || zza().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        if (this.zzb == null) {
            this.zzb = this.zzc.zzf.entrySet().iterator();
        }
        return this.zzb;
    }

    public final /* synthetic */ Object next() {
        if (zza().hasNext()) {
            return (Map.Entry) zza().next();
        }
        List zzb2 = this.zzc.zzb;
        int i = this.zza - 1;
        this.zza = i;
        return (Map.Entry) zzb2.get(i);
    }

    /* synthetic */ zztg(zzte zzte, zztd zztd) {
        this(zzte);
    }
}
