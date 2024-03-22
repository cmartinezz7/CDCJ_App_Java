package com.google.android.libraries.places.internal;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzhi extends zzgv<Map.Entry<K, V>> {
    private final /* synthetic */ zzhf zza;

    zzhi(zzhf zzhf) {
        this.zza = zzhf;
    }

    public final int size() {
        return this.zza.zzd;
    }

    public final boolean zzg() {
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzgg.zza(i, this.zza.zzd);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zza.zzb[i2], this.zza.zzb[i2 + 1]);
    }
}
