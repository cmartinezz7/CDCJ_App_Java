package com.google.android.libraries.places.internal;

import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzrs<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzrq> zza;

    private zzrs(Map.Entry<K, zzrq> entry) {
        this.zza = entry;
    }

    public final K getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzrq.zza();
    }

    public final zzrq zza() {
        return this.zza.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzsm) {
            return this.zza.getValue().zza((zzsm) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
