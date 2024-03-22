package com.google.android.libraries.places.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public abstract class zzgv<E> extends zzgw<E> implements List<E>, RandomAccess {
    private static final zzhl<Object> zza = new zzgy(zzhd.zza, 0);

    public static <E> zzgv<E> zza() {
        return zzhd.zza;
    }

    public static <E> zzgv<E> zza(Collection<? extends E> collection) {
        if (collection instanceof zzgw) {
            zzgv<E> zzc = ((zzgw) collection).zzc();
            if (!zzc.zzg()) {
                return zzc;
            }
            Object[] array = zzc.toArray();
            int length = array.length;
            if (length == 0) {
                return zzhd.zza;
            }
            return new zzhd(array, length);
        }
        Object[] array2 = collection.toArray();
        int length2 = array2.length;
        int i = 0;
        while (i < length2) {
            if (array2[i] != null) {
                i++;
            } else {
                throw new NullPointerException(new StringBuilder(20).append("at index ").append(i).toString());
            }
        }
        int length3 = array2.length;
        if (length3 == 0) {
            return zzhd.zza;
        }
        return new zzhd(array2, length3);
    }

    public static <E> zzgv<E> zza(E[] eArr) {
        if (eArr.length == 0) {
            return zzhd.zza;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            if (objArr[i] != null) {
                i++;
            } else {
                throw new NullPointerException(new StringBuilder(20).append("at index ").append(i).toString());
            }
        }
        int length2 = objArr.length;
        if (length2 == 0) {
            return zzhd.zza;
        }
        return new zzhd(objArr, length2);
    }

    static <E> zzgv<E> zzb(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return zzhd.zza;
        }
        return new zzhd(objArr, length);
    }

    zzgv() {
    }

    public final zzhm<E> zzb() {
        return (zzhl) listIterator();
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        ListIterator listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zzgd.zza(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            if (obj == null) {
                for (int size = size() - 1; size >= 0; size--) {
                    if (get(size) == null) {
                        return size;
                    }
                }
            } else {
                for (int size2 = size() - 1; size2 >= 0; size2--) {
                    if (obj.equals(get(size2))) {
                        return size2;
                    }
                }
            }
            return -1;
        }
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (zzgd.zza(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    /* renamed from: zza */
    public zzgv<E> subList(int i, int i2) {
        zzgg.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzhd.zza;
        }
        return new zzgx(this, i, i3);
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public final zzgv<E> zzc() {
        return this;
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzgg.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (!(this instanceof RandomAccess) || !(list instanceof RandomAccess)) {
                    zzgv zzgv = this;
                    int size2 = zzgv.size();
                    Iterator it = list.iterator();
                    int i = 0;
                    while (true) {
                        if (i < size2) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object obj2 = zzgv.get(i);
                            i++;
                            if (!zzgd.zza(obj2, it.next())) {
                                break;
                            }
                        } else if (!it.hasNext()) {
                            return true;
                        }
                    }
                } else {
                    int i2 = 0;
                    while (i2 < size) {
                        if (zzgd.zza(get(i2), list.get(i2))) {
                            i2++;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        zzgg.zzb(i, size());
        if (isEmpty()) {
            return zza;
        }
        return new zzgy(this, i);
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzhl) listIterator(0);
    }
}
