package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzip {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0006zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzg;
        private static volatile zzsw<zza> zzh;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private boolean zzf;

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzip$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0006zza extends zzrb.zzb<zza, C0006zza> implements zzso {
            private C0006zza() {
                super(zza.zzg);
            }

            /* synthetic */ C0006zza(zzio zzio) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzip$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zzio.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0006zza((zzio) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0007\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zza> zzsw2 = zzh;
                    zzsw<zza> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zza.class) {
                            zzsw<zza> zzsw4 = zzh;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza = new zzrb.zza(zzg);
                                zzh = zza;
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
            zzg = zza;
            zzrb.zza(zza.class, zza);
        }
    }
}
