package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzsi implements zzsf {
    zzsi() {
    }

    public final zzsd<?, ?> zzc(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zza(Object obj) {
        return (zzsg) obj;
    }

    public final Object zzb(Object obj) {
        ((zzsg) obj).zzb();
        return obj;
    }

    public final Object zza(Object obj, Object obj2) {
        zzsg zzsg = (zzsg) obj;
        zzsg zzsg2 = (zzsg) obj2;
        if (!zzsg2.isEmpty()) {
            if (!zzsg.zzc()) {
                zzsg = zzsg.zza();
            }
            zzsg.zza(zzsg2);
        }
        return zzsg;
    }

    public final int zza(int i, Object obj, Object obj2) {
        zzsg zzsg = (zzsg) obj;
        if (zzsg.isEmpty()) {
            return 0;
        }
        Iterator it = zzsg.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
