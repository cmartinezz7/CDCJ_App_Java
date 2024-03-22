package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzse implements zzsj {
    private zzsj[] zza;

    zzse(zzsj... zzsjArr) {
        this.zza = zzsjArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzsj zza2 : this.zza) {
            if (zza2.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzsk zzb(Class<?> cls) {
        for (zzsj zzsj : this.zza) {
            if (zzsj.zza(cls)) {
                return zzsj.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
