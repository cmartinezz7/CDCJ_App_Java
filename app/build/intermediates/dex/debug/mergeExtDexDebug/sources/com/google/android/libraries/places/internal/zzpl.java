package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzpl {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0027zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzf;
        private static volatile zzsw<zza> zzg;
        private int zzc;
        private long zzd;
        private int zze;

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzpl$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0027zza extends zzrb.zzb<zza, C0027zza> implements zzso {
            private C0027zza() {
                super(zza.zzf);
            }

            /* synthetic */ C0027zza(zzpn zzpn) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzpl$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zzpn.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0027zza((zzpn) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u000f\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zza> zzsw2 = zzg;
                    zzsw<zza> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zza.class) {
                            zzsw<zza> zzsw4 = zzg;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza = new zzrb.zza(zzf);
                                zzg = zza;
                                zzsw = zza;
                            }
                        }
                        zzsw3 = zzsw;
                    }
                    return zzsw3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzf = zza;
            zzrb.zza(zza.class, zza);
        }
    }
}
