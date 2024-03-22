package com.google.android.libraries.places.internal;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzhh<K> extends zzhc<K> {
    private final transient zzha<K, ?> zza;
    private final transient zzgv<K> zzb;

    zzhh(zzha<K, ?> zzha, zzgv<K> zzgv) {
        this.zza = zzha;
        this.zzb = zzgv;
    }

    public final zzhm<K> zzb() {
        return (zzhm) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    public final zzgv<K> zzc() {
        return this.zzb;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    public final int size() {
        return this.zza.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
