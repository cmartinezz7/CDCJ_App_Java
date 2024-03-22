package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zztf extends zztl {
    private final /* synthetic */ zzte zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zztf(zzte zzte) {
        super(zzte, (zztd) null);
        this.zza = zzte;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zztg(this.zza, (zztd) null);
    }

    /* synthetic */ zztf(zzte zzte, zztd zztd) {
        this(zzte);
    }
}
