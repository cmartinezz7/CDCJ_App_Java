package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;
import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzjm {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0013zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzh;
        private static volatile zzsw<zza> zzi;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzjm$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0013zza extends zzrb.zzb<zza, C0013zza> implements zzso {
            private C0013zza() {
                super(zza.zzh);
            }

            /* synthetic */ C0013zza(zzjn zzjn) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzjm$zza>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zzjn.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0013zza((zzjn) null);
                case 3:
                    return zza((zzsm) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0004\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzsw<zza> zzsw2 = zzi;
                    zzsw<zza> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zza.class) {
                            zzsw<zza> zzsw4 = zzi;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza = new zzrb.zza(zzh);
                                zzi = zza;
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
            zzh = zza;
            zzrb.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzb extends zzrb<zzb, C0014zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzb zzg;
        private static volatile zzsw<zzb> zzh;
        private int zzc;
        private int zzd = 1;
        private zzc zze;
        private zza zzf;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            REVERSE_CACHE_STATS(1),
            ERROR_STATS(2);
            
            private static final zzrf<zza> zzc = null;
            private final int zzd;

            public final int zza() {
                return this.zzd;
            }

            public static zzri zzb() {
                return zzjo.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzd);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zza(int i) {
                this.zzd = i;
            }

            static {
                zzc = new zzjp();
            }
        }

        private zzb() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzjm$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0014zzb extends zzrb.zzb<zzb, C0014zzb> implements zzso {
            private C0014zzb() {
                super(zzb.zzg);
            }

            /* synthetic */ C0014zzb(zzjn zzjn) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzjm$zzb>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzb> zzsw;
            switch (zzjn.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0014zzb((zzjn) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf"});
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
                    return (byte) 1;
                case 7:
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

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzc extends zzrb<zzc, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzc zzh;
        private static volatile zzsw<zzc> zzi;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;

        private zzc() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzc, zza> implements zzso {
            private zza() {
                super(zzc.zzh);
            }

            /* synthetic */ zza(zzjn zzjn) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzjm$zzc>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzc> zzsw;
            switch (zzjn.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzjn) null);
                case 3:
                    return zza((zzsm) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0004\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzsw<zzc> zzsw2 = zzi;
                    zzsw<zzc> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzc.class) {
                            zzsw<zzc> zzsw4 = zzi;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzh);
                                zzi = zza2;
                                zzsw = zza2;
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
            zzc zzc2 = new zzc();
            zzh = zzc2;
            zzrb.zza(zzc.class, zzc2);
        }
    }
}
