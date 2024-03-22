package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzhx;
import com.google.android.libraries.places.internal.zzrb;
import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzjh {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0011zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzg;
        private static volatile zzsw<zza> zzh;
        private int zzc;
        private int zzd = 1;
        private zzb zze;
        private zzc zzf;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            NLP_CLIENT(1),
            NLP_LATENCY(2);
            
            private static final zzrf<zzb> zzc = null;
            private final int zzd;

            public final int zza() {
                return this.zzd;
            }

            public static zzri zzb() {
                return zzjj.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzd);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzb(int i) {
                this.zzd = i;
            }

            static {
                zzc = new zzji();
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzjh$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0011zza extends zzrb.zzb<zza, C0011zza> implements zzso {
            private C0011zza() {
                super(zza.zzg);
            }

            /* synthetic */ C0011zza(zzjg zzjg) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzjh$zza>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zzjg.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0011zza((zzjg) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf"});
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

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzb extends zzrb<zzb, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzb zzf;
        private static volatile zzsw<zzb> zzg;
        private int zzc;
        private int zzd;
        private zzhx.zza zze;

        private zzb() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzb, zza> implements zzso {
            private zza() {
                super(zzb.zzf);
            }

            /* synthetic */ zza(zzjg zzjg) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzjh$zzb>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzb> zzsw;
            switch (zzjg.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzjg) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\t\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzb> zzsw2 = zzg;
                    zzsw<zzb> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzb.class) {
                            zzsw<zzb> zzsw4 = zzg;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzf);
                                zzg = zza2;
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
            zzf = zzb;
            zzrb.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzc extends zzrb<zzc, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzc zzl;
        private static volatile zzsw<zzc> zzm;
        private int zzc;
        private int zzd;
        private long zze;
        private long zzf;
        private boolean zzg;
        private boolean zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        private zzc() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzc, zza> implements zzso {
            private zza() {
                super(zzc.zzl);
            }

            /* synthetic */ zza(zzjg zzjg) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzjh$zzc>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzc> zzsw;
            switch (zzjg.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzjg) null);
                case 3:
                    return zza((zzsm) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0004\u0005\u0007\u0004\u0006\b\u0004\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzsw<zzc> zzsw2 = zzm;
                    zzsw<zzc> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzc.class) {
                            zzsw<zzc> zzsw4 = zzm;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzl);
                                zzm = zza2;
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
            zzl = zzc2;
            zzrb.zza(zzc.class, zzc2);
        }
    }
}
