package com.google.android.libraries.places.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public abstract class zzgw<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zza = new Object[0];

    zzgw() {
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: zzb */
    public abstract zzhm<E> iterator();

    /* access modifiers changed from: package-private */
    public abstract boolean zzg();

    public final Object[] toArray() {
        return toArray(zza);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzgg.zza(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzd = zzd();
            if (zzd != null) {
                return Arrays.copyOfRange(zzd, zze(), zzf(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public Object[] zzd() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int zze() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzf() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public zzgv<E> zzc() {
        return isEmpty() ? zzgv.zza() : zzgv.zzb(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        zzhm zzhm = (zzhm) iterator();
        while (zzhm.hasNext()) {
            objArr[i] = zzhm.next();
            i++;
        }
        return i;
    }
}
