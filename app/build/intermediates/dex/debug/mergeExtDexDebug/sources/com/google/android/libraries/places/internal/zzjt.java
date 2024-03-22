package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzjt {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0016zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzg;
        private static volatile zzsw<zza> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private byte zzf = 2;

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzjt$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0016zza extends zzrb.zzb<zza, C0016zza> implements zzso {
            private C0016zza() {
                super(zza.zzg);
            }

            /* synthetic */ C0016zza(zzjs zzjs) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzjt$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            int i2 = 1;
            switch (zzjs.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0016zza((zzjs) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԇ\u0000\u0002Ԇ\u0001", new Object[]{"zzc", "zzd", "zze"});
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
                    return Byte.valueOf(this.zzf);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzf = (byte) i2;
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

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzb extends zzrb<zzb, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzb zzg;
        private static volatile zzsw<zzb> zzh;
        private int zzc;
        private zza zzd;
        private zza zze;
        private byte zzf = 2;

        private zzb() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzb, zza> implements zzso {
            private zza() {
                super(zzb.zzg);
            }

            /* synthetic */ zza(zzjs zzjs) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzjt$zzb>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzb> zzsw;
            int i2 = 1;
            switch (zzjs.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzjs) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Љ\u0000\u0002Љ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzb> zzsw2 = zzh;
                    zzsw<zzb> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzb.class) {
                            zzsw<zzb> zzsw4 = zzh;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzg);
                                zzh = zza2;
                                zzsw = zza2;
                            }
                        }
                        zzsw3 = zzsw;
                    }
                    return zzsw3;
                case 6:
                    return Byte.valueOf(this.zzf);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzf = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzb = new zzb();
            zzg = zzb;
            zzrb.zza(zzb.class, zzb);
        }
    }
}
