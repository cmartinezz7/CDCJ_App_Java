package com.google.android.libraries.places.internal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public abstract class zzha<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zza = new Map.Entry[0];
    private transient zzhc<Map.Entry<K, V>> zzb;
    private transient zzhc<K> zzc;
    private transient zzgw<V> zzd;

    zzha() {
    }

    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract zzhc<Map.Entry<K, V>> zza();

    /* access modifiers changed from: package-private */
    public abstract zzhc<K> zzb();

    /* access modifiers changed from: package-private */
    public abstract zzgw<V> zzc();

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzgw) values()).contains(obj);
    }

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int hashCode() {
        return zzhj.zza((zzhc) entrySet());
    }

    public String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder append = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824)).append('{');
            boolean z = true;
            for (Map.Entry entry : entrySet()) {
                if (!z) {
                    append.append(", ");
                }
                z = false;
                append.append(entry.getKey()).append('=').append(entry.getValue());
            }
            return append.append('}').toString();
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf("size").length() + 40).append("size").append(" cannot be negative but was: ").append(size).toString());
    }

    public /* synthetic */ Set entrySet() {
        zzhc<Map.Entry<K, V>> zzhc = this.zzb;
        if (zzhc != null) {
            return zzhc;
        }
        zzhc<Map.Entry<K, V>> zza2 = zza();
        this.zzb = zza2;
        return zza2;
    }

    public /* synthetic */ Collection values() {
        zzgw<V> zzgw = this.zzd;
        if (zzgw != null) {
            return zzgw;
        }
        zzgw<V> zzc2 = zzc();
        this.zzd = zzc2;
        return zzc2;
    }

    public /* synthetic */ Set keySet() {
        zzhc<K> zzhc = this.zzc;
        if (zzhc != null) {
            return zzhc;
        }
        zzhc<K> zzb2 = zzb();
        this.zzc = zzb2;
        return zzb2;
    }
}
