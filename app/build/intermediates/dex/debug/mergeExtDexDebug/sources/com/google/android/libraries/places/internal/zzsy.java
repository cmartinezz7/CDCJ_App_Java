package com.google.android.libraries.places.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzsy {
    private static final zzsy zza = new zzsy();
    private final zztc zzb = new zzsc();
    private final ConcurrentMap<Class<?>, zzsz<?>> zzc = new ConcurrentHashMap();

    public static zzsy zza() {
        return zza;
    }

    public final <T> zzsz<T> zza(Class<T> cls) {
        zzrd.zza(cls, "messageType");
        zzsz<T> zzsz = (zzsz) this.zzc.get(cls);
        if (zzsz != null) {
            return zzsz;
        }
        zzsz<T> zza2 = this.zzb.zza(cls);
        zzrd.zza(cls, "messageType");
        zzrd.zza(zza2, "schema");
        zzsz<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return zza2;
    }

    public final <T> zzsz<T> zza(T t) {
        return zza(t.getClass());
    }

    private zzsy() {
    }
}
