package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzhf<K, V> extends zzhc<Map.Entry<K, V>> {
    private final transient zzha<K, V> zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    private final transient int zzc = 0;
    /* access modifiers changed from: private */
    public final transient int zzd;

    zzhf(zzha<K, V> zzha, Object[] objArr, int i, int i2) {
        this.zza = zzha;
        this.zzb = objArr;
        this.zzd = i2;
    }

    public final zzhm<Map.Entry<K, V>> zzb() {
        return (zzhm) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public final zzgv<Map.Entry<K, V>> zza() {
        return new zzhi(this);
    }

    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object value = entry.getValue();
        if (value == null || !value.equals(this.zza.get(key))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    public final int size() {
        return this.zzd;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
