package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzsc implements zztc {
    private static final zzsj zzb = new zzsb();
    private final zzsj zza;

    public zzsc() {
        this(new zzse(zzrc.zza(), zza()));
    }

    private zzsc(zzsj zzsj) {
        this.zza = (zzsj) zzrd.zza(zzsj, "messageInfoFactory");
    }

    public final <T> zzsz<T> zza(Class<T> cls) {
        zztb.zza((Class<?>) cls);
        zzsk zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (zzrb.class.isAssignableFrom(cls)) {
                return zzsp.zza(zztb.zzc(), zzqt.zza(), zzb2.zzc());
            }
            return zzsp.zza(zztb.zza(), zzqt.zzb(), zzb2.zzc());
        } else if (zzrb.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzsq.zza(cls, zzb2, zzst.zzb(), zzrv.zzb(), zztb.zzc(), zzqt.zza(), zzsh.zzb());
            }
            return zzsq.zza(cls, zzb2, zzst.zzb(), zzrv.zzb(), zztb.zzc(), (zzqr<?>) null, zzsh.zzb());
        } else if (zza(zzb2)) {
            return zzsq.zza(cls, zzb2, zzst.zza(), zzrv.zza(), zztb.zza(), zzqt.zzb(), zzsh.zza());
        } else {
            return zzsq.zza(cls, zzb2, zzst.zza(), zzrv.zza(), zztb.zzb(), (zzqr<?>) null, zzsh.zza());
        }
    }

    private static boolean zza(zzsk zzsk) {
        return zzsk.zza() == zzrb.zzc.zzh;
    }

    private static zzsj zza() {
        try {
            return (zzsj) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e) {
            return zzb;
        }
    }
}
