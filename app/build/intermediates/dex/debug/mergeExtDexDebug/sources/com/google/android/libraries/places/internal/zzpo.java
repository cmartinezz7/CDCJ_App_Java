package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzpo {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0028zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzj;
        private static volatile zzsw<zza> zzk;
        private int zzc;
        private boolean zzd;
        private boolean zze;
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzpo$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0028zza extends zzrb.zzb<zza, C0028zza> implements zzso {
            private C0028zza() {
                super(zza.zzj);
            }

            /* synthetic */ C0028zza(zzpp zzpp) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzpo$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zzpp.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0028zza((zzpp) null);
                case 3:
                    return zza((zzsm) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzsw<zza> zzsw2 = zzk;
                    zzsw<zza> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zza.class) {
                            zzsw<zza> zzsw4 = zzk;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza = new zzrb.zza(zzj);
                                zzk = zza;
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
            zzj = zza;
            zzrb.zza(zza.class, zza);
        }
    }
}
