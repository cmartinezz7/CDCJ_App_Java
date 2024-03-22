package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;
import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzkb {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0018zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zze;
        private static volatile zzsw<zza> zzf;
        private int zzc;
        private int zzd;

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzkb$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0018zza extends zzrb.zzb<zza, C0018zza> implements zzso {
            private C0018zza() {
                super(zza.zze);
            }

            /* synthetic */ C0018zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0018zza((zzka) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzc", "zzd", zzkf.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzsw<zza> zzsw2 = zzf;
                    zzsw<zza> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zza.class) {
                            zzsw<zza> zzsw4 = zzf;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza = new zzrb.zza(zze);
                                zzf = zza;
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
            zze = zza;
            zzrb.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzb extends zzrb<zzb, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzb zzg;
        private static volatile zzsw<zzb> zzh;
        private int zzc;
        private String zzd = "";
        private int zze;
        private zzrm<C0019zzb> zzf = zzk();

        /* renamed from: com.google.android.libraries.places.internal.zzkb$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0019zzb extends zzrb<C0019zzb, zza> implements zzso {
            /* access modifiers changed from: private */
            public static final C0019zzb zzm;
            private static volatile zzsw<C0019zzb> zzn;
            private int zzc;
            private float zzd;
            private float zze;
            private float zzf;
            private int zzg;
            private long zzh;
            private long zzi;
            private long zzj;
            private long zzk;
            private long zzl;

            private C0019zzb() {
            }

            /* renamed from: com.google.android.libraries.places.internal.zzkb$zzb$zzb$zza */
            /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
            public static final class zza extends zzrb.zzb<C0019zzb, zza> implements zzso {
                private zza() {
                    super(C0019zzb.zzm);
                }

                /* synthetic */ zza(zzka zzka) {
                    this();
                }
            }

            /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzb$zzb>, com.google.android.libraries.places.internal.zzrb$zza] */
            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                zzsw<C0019zzb> zzsw;
                switch (zzka.zza[i - 1]) {
                    case 1:
                        return new C0019zzb();
                    case 2:
                        return new zza((zzka) null);
                    case 3:
                        return zza((zzsm) zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001\u0001\u0000\u0002\u0001\u0001\u0003\u0001\u0002\u0004\u0004\u0003\u0005\u0002\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\u0002\u0007\t\u0002\b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
                    case 4:
                        return zzm;
                    case 5:
                        zzsw<C0019zzb> zzsw2 = zzn;
                        zzsw<C0019zzb> zzsw3 = zzsw2;
                        if (zzsw2 == null) {
                            synchronized (C0019zzb.class) {
                                zzsw<C0019zzb> zzsw4 = zzn;
                                zzsw = zzsw4;
                                if (zzsw4 == null) {
                                    ? zza2 = new zzrb.zza(zzm);
                                    zzn = zza2;
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
                C0019zzb zzb = new C0019zzb();
                zzm = zzb;
                zzrb.zza(C0019zzb.class, zzb);
            }
        }

        private zzb() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzb, zza> implements zzso {
            private zza() {
                super(zzb.zzg);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzb>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzb> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\b\u0000\u0002\u0004\u0001\u0003\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", C0019zzb.class});
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
        public static final zzc zzj;
        private static volatile zzsw<zzc> zzk;
        private int zzc;
        private String zzd = "";
        private int zze;
        private int zzf;
        private float zzg;
        private float zzh;
        private float zzi;

        private zzc() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzc, zza> implements zzso {
            private zza() {
                super(zzc.zzj);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzc>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzc> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\u0001\u0003\u0005\u0001\u0004\u0006\u0001\u0005", new Object[]{"zzc", "zzd", "zze", zzkd.zzb(), "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzsw<zzc> zzsw2 = zzk;
                    zzsw<zzc> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzc.class) {
                            zzsw<zzc> zzsw4 = zzk;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzj);
                                zzk = zza2;
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
            zzj = zzc2;
            zzrb.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzd extends zzrb<zzd, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzd zzg;
        private static volatile zzsw<zzd> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        private zzd() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzd, zza> implements zzso {
            private zza() {
                super(zzd.zzg);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzd>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzd> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzd> zzsw2 = zzh;
                    zzsw<zzd> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzd.class) {
                            zzsw<zzd> zzsw4 = zzh;
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
            zzd zzd2 = new zzd();
            zzg = zzd2;
            zzrb.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zze extends zzrb<zze, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zze zzj;
        private static volatile zzsw<zze> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private zzrm<zzb> zzi = zzk();

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb<zzb, zza> implements zzso {
            /* access modifiers changed from: private */
            public static final zzb zzl;
            private static volatile zzsw<zzb> zzm;
            private int zzc;
            private String zzd = "";
            private int zze;
            private int zzf;
            private int zzg;
            private int zzh;
            private int zzi;
            private zzrm<zzd> zzj = zzk();
            private int zzk;

            private zzb() {
            }

            /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
            public static final class zza extends zzrb.zzb<zzb, zza> implements zzso {
                private zza() {
                    super(zzb.zzl);
                }

                /* synthetic */ zza(zzka zzka) {
                    this();
                }
            }

            /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zze$zzb>] */
            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                zzsw<zzb> zzsw;
                switch (zzka.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza((zzka) null);
                    case 3:
                        return zza((zzsm) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\b\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\u001b\b\u0004\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzd.class, "zzk"});
                    case 4:
                        return zzl;
                    case 5:
                        zzsw<zzb> zzsw2 = zzm;
                        zzsw<zzb> zzsw3 = zzsw2;
                        if (zzsw2 == null) {
                            synchronized (zzb.class) {
                                zzsw<zzb> zzsw4 = zzm;
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
                zzb zzb = new zzb();
                zzl = zzb;
                zzrb.zza(zzb.class, zzb);
            }
        }

        private zze() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zze, zza> implements zzso {
            private zza() {
                super(zze.zzj);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zze>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zze> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzb.class});
                case 4:
                    return zzj;
                case 5:
                    zzsw<zze> zzsw2 = zzk;
                    zzsw<zze> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zze.class) {
                            zzsw<zze> zzsw4 = zzk;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzj);
                                zzk = zza2;
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
            zze zze2 = new zze();
            zzj = zze2;
            zzrb.zza(zze.class, zze2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzf extends zzrb<zzf, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzf zzi;
        private static volatile zzsw<zzf> zzj;
        private int zzc;
        private boolean zzd;
        private boolean zze;
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;

        private zzf() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzf, zza> implements zzso {
            private zza() {
                super(zzf.zzi);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzf>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzf> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\u0007\u0003\u0005\u0007\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzsw<zzf> zzsw2 = zzj;
                    zzsw<zzf> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzf.class) {
                            zzsw<zzf> zzsw4 = zzj;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzi);
                                zzj = zza2;
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
            zzf zzf2 = new zzf();
            zzi = zzf2;
            zzrb.zza(zzf.class, zzf2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzg extends zzrb<zzg, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzg zzf;
        private static volatile zzsw<zzg> zzg;
        private int zzc;
        private zzrm<zzb> zzd = zzk();
        private long zze;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb<zzb, zza> implements zzso {
            /* access modifiers changed from: private */
            public static final zzb zzf;
            private static volatile zzsw<zzb> zzg;
            private int zzc;
            private int zzd;
            private long zze;

            private zzb() {
            }

            /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
            public static final class zza extends zzrb.zzb<zzb, zza> implements zzso {
                private zza() {
                    super(zzb.zzf);
                }

                /* synthetic */ zza(zzka zzka) {
                    this();
                }
            }

            /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzg$zzb>] */
            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                zzsw<zzb> zzsw;
                switch (zzka.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza((zzka) null);
                    case 3:
                        return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\u0002\u0001", new Object[]{"zzc", "zzd", zzkd.zzb(), "zze"});
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

        private zzg() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzg, zza> implements zzso {
            private zza() {
                super(zzg.zzf);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzg>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzg> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0002\u0000", new Object[]{"zzc", "zzd", zzb.class, "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzg> zzsw2 = zzg;
                    zzsw<zzg> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzg.class) {
                            zzsw<zzg> zzsw4 = zzg;
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
            zzg zzg2 = new zzg();
            zzf = zzg2;
            zzrb.zza(zzg.class, zzg2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzh extends zzrb<zzh, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzh zzf;
        private static volatile zzsw<zzh> zzg;
        private int zzc;
        private zzg zzd;
        private zze zze;

        private zzh() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzh, zza> implements zzso {
            private zza() {
                super(zzh.zzf);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzh>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzh> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzh> zzsw2 = zzg;
                    zzsw<zzh> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzh.class) {
                            zzsw<zzh> zzsw4 = zzg;
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
            zzh zzh = new zzh();
            zzf = zzh;
            zzrb.zza(zzh.class, zzh);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzi extends zzrb<zzi, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzi zzo;
        private static volatile zzsw<zzi> zzp;
        private int zzc;
        private long zzd;
        private zzf zze;
        private zzf zzf;
        private zzk zzg;
        private zzh zzh;
        private zzb zzi;
        private zzl zzj;
        private zzm zzk;
        private zzj zzl;
        private zza zzm;
        private zzc zzn;

        private zzi() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzi, zza> implements zzso {
            private zza() {
                super(zzi.zzo);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzi>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzi> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzo, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\u0002\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\t\u0004\u0006\t\u0005\u0007\t\u0006\b\t\u0007\t\t\b\n\t\t\u000b\t\n", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
                case 4:
                    return zzo;
                case 5:
                    zzsw<zzi> zzsw2 = zzp;
                    zzsw<zzi> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzi.class) {
                            zzsw<zzi> zzsw4 = zzp;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzo);
                                zzp = zza2;
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
            zzi zzi2 = new zzi();
            zzo = zzi2;
            zzrb.zza(zzi.class, zzi2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzj extends zzrb<zzj, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzj zzg;
        private static volatile zzsw<zzj> zzh;
        private int zzc;
        private int zzd;
        private float zze;
        private float zzf;

        private zzj() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzj, zza> implements zzso {
            private zza() {
                super(zzj.zzg);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzj>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzj> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0001\u0001\u0003\u0001\u0002", new Object[]{"zzc", "zzd", zzkd.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzj> zzsw2 = zzh;
                    zzsw<zzj> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzj.class) {
                            zzsw<zzj> zzsw4 = zzh;
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
            zzj zzj = new zzj();
            zzg = zzj;
            zzrb.zza(zzj.class, zzj);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzk extends zzrb<zzk, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzk zzf;
        private static volatile zzsw<zzk> zzg;
        private int zzc;
        private boolean zzd;
        private boolean zze;

        private zzk() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzk, zza> implements zzso {
            private zza() {
                super(zzk.zzf);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzk>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzk> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0007\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzk> zzsw2 = zzg;
                    zzsw<zzk> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzk.class) {
                            zzsw<zzk> zzsw4 = zzg;
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
            zzk zzk = new zzk();
            zzf = zzk;
            zzrb.zza(zzk.class, zzk);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzl extends zzrb<zzl, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzl zzg;
        private static volatile zzsw<zzl> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private String zzf = "";

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            INVALID_TYPE(0),
            REMOVE_ALL(1),
            REMOVE_BY_PENDING_INTENT(2),
            REMOVE_BY_REQUEST_IDS(3);
            
            private static final zzrf<zzb> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzkj.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzf);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzb(int i) {
                this.zzf = i;
            }

            static {
                zze = new zzki();
            }
        }

        private zzl() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzl, zza> implements zzso {
            private zza() {
                super(zzl.zzg);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzl>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzl> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0004\u0001\u0003\b\u0002", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzl> zzsw2 = zzh;
                    zzsw<zzl> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzl.class) {
                            zzsw<zzl> zzsw4 = zzh;
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
            zzl zzl = new zzl();
            zzg = zzl;
            zzrb.zza(zzl.class, zzl);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzm extends zzrb<zzm, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzm zzg;
        private static volatile zzsw<zzm> zzh;
        private int zzc;
        private int zzd;
        private long zze;
        private long zzf;

        private zzm() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzm, zza> implements zzso {
            private zza() {
                super(zzm.zzg);
            }

            /* synthetic */ zza(zzka zzka) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkb$zzm>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzm> zzsw;
            switch (zzka.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza((zzka) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0002\u0001\u0003\u0002\u0002", new Object[]{"zzc", "zzd", zzkd.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzm> zzsw2 = zzh;
                    zzsw<zzm> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzm.class) {
                            zzsw<zzm> zzsw4 = zzh;
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
            zzm zzm = new zzm();
            zzg = zzm;
            zzrb.zza(zzm.class, zzm);
        }
    }
}
