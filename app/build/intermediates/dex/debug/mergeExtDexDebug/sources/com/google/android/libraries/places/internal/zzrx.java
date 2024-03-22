package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzrx extends zzrv {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzrx() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zztx.zzf(obj, j);
        if (list instanceof zzrw) {
            obj2 = ((zzrw) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzsv) || !(list instanceof zzrm)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzrm zzrm = (zzrm) list;
                if (zzrm.zza()) {
                    zzrm.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zztx.zza(obj, j, obj2);
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzb = zzb(obj2, j);
        int size = zzb.size();
        List zzb2 = zzb(obj, j);
        if (zzb2.isEmpty()) {
            if (zzb2 instanceof zzrw) {
                zzb2 = new zzrt(size);
            } else if (!(zzb2 instanceof zzsv) || !(zzb2 instanceof zzrm)) {
                zzb2 = new ArrayList(size);
            } else {
                zzb2 = ((zzrm) zzb2).zzb(size);
            }
            zztx.zza(obj, j, (Object) zzb2);
        } else if (zza.isAssignableFrom(zzb2.getClass())) {
            ArrayList arrayList = new ArrayList(zzb2.size() + size);
            arrayList.addAll(zzb2);
            zztx.zza(obj, j, (Object) arrayList);
            zzb2 = arrayList;
        } else if (zzb2 instanceof zztw) {
            zzrt zzrt = new zzrt(zzb2.size() + size);
            zzrt.addAll((zztw) zzb2);
            zztx.zza(obj, j, (Object) zzrt);
            zzb2 = zzrt;
        } else if ((zzb2 instanceof zzsv) && (zzb2 instanceof zzrm)) {
            zzrm zzrm = (zzrm) zzb2;
            if (!zzrm.zza()) {
                zzb2 = zzrm.zzb(zzb2.size() + size);
                zztx.zza(obj, j, (Object) zzb2);
            }
        }
        int size2 = zzb2.size();
        int size3 = zzb.size();
        if (size2 > 0 && size3 > 0) {
            zzb2.addAll(zzb);
        }
        if (size2 > 0) {
            zzb = zzb2;
        }
        zztx.zza(obj, j, (Object) zzb);
    }

    private static <E> List<E> zzb(Object obj, long j) {
        return (List) zztx.zzf(obj, j);
    }
}
