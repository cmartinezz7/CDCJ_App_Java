package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;
import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzig {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0004zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzf;
        private static volatile zzsw<zza> zzg;
        private int zzc;
        private long zzd;
        private int zze;

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzig$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0004zza extends zzrb.zzb<zza, C0004zza> implements zzso {
            private C0004zza() {
                super(zza.zzf);
            }

            /* synthetic */ C0004zza(zzih zzih) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzig$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zzih.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0004zza((zzih) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0004\u0001", new Object[]{"zzc", "zzd", "zze"});
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

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzb extends zzrb<zzb, C0005zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzb zzi;
        private static volatile zzsw<zzb> zzj;
        private int zzc;
        private int zzd;
        private zzc zze;
        private zzf zzf;
        private zzd zzg;
        private zze zzh;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            UNKNOWN_CHRE_EVENT(0),
            CURRENT_STATE(1),
            REBOOT(2),
            ERROR(3),
            MESSAGE(4);
            
            private static final zzrf<zza> zzf = null;
            private final int zzg;

            public final int zza() {
                return this.zzg;
            }

            public static zzri zzb() {
                return zzii.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzg);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zza(int i) {
                this.zzg = i;
            }

            static {
                zzf = new zzij();
            }
        }

        private zzb() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzig$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0005zzb extends zzrb.zzb<zzb, C0005zzb> implements zzso {
            private C0005zzb() {
                super(zzb.zzi);
            }

            /* synthetic */ C0005zzb(zzih zzih) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzig$zzb>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzb> zzsw;
            switch (zzih.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0005zzb((zzih) null);
                case 3:
                    return zza((zzsm) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\t\u0004", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzsw<zzb> zzsw2 = zzj;
                    zzsw<zzb> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzb.class) {
                            zzsw<zzb> zzsw4 = zzj;
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
            zzb zzb = new zzb();
            zzi = zzb;
            zzrb.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzc extends zzrb<zzc, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzc zzf;
        private static volatile zzsw<zzc> zzg;
        private int zzc;
        private zzrm<zza> zzd = zzk();
        private int zze;

        private zzc() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzc, zza> implements zzso {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(zzih zzih) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzig$zzc>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzc> zzsw;
            switch (zzih.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzih) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0004\u0000", new Object[]{"zzc", "zzd", zza.class, "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzc> zzsw2 = zzg;
                    zzsw<zzc> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzc.class) {
                            zzsw<zzc> zzsw4 = zzg;
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
            zzc zzc2 = new zzc();
            zzf = zzc2;
            zzrb.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzd extends zzrb<zzd, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzd zzf;
        private static volatile zzsw<zzd> zzg;
        private int zzc;
        private int zzd;
        private String zze = "";

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNKNOWN_ERROR(0),
            LOAD(1),
            UNLOAD(2);
            
            private static final zzrf<zzb> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzil.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zze);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzb(int i) {
                this.zze = i;
            }

            static {
                zzd = new zzik();
            }
        }

        private zzd() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzd, zza> implements zzso {
            private zza() {
                super(zzd.zzf);
            }

            /* synthetic */ zza(zzih zzih) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzig$zzd>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzd> zzsw;
            switch (zzih.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzih) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001", new Object[]{"zzc", "zzd", zzb.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzd> zzsw2 = zzg;
                    zzsw<zzd> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzd.class) {
                            zzsw<zzd> zzsw4 = zzg;
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
            zzd zzd2 = new zzd();
            zzf = zzd2;
            zzrb.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zze extends zzrb<zze, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zze zzg;
        private static volatile zzsw<zze> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private int zzf;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            UNKNOWN_DIRECTION(0),
            AP_TO_CHRE(1),
            CHRE_TO_AP(2);
            
            private static final zzrf<zza> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzim.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zze);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zza(int i) {
                this.zze = i;
            }

            static {
                zzd = new zzin();
            }
        }

        private zze() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zze, zzb> implements zzso {
            private zzb() {
                super(zze.zzg);
            }

            /* synthetic */ zzb(zzih zzih) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzig$zze>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zze> zzsw;
            switch (zzih.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zzb((zzih) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\f\u0001\u0003\u0004\u0002", new Object[]{"zzc", "zzd", "zze", zza.zzb(), "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zze> zzsw2 = zzh;
                    zzsw<zze> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zze.class) {
                            zzsw<zze> zzsw4 = zzh;
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
            zze zze2 = new zze();
            zzg = zze2;
            zzrb.zza(zze.class, zze2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzf extends zzrb<zzf, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzf zze;
        private static volatile zzsw<zzf> zzf;
        private int zzc;
        private long zzd;

        private zzf() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzf, zza> implements zzso {
            private zza() {
                super(zzf.zze);
            }

            /* synthetic */ zza(zzih zzih) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzig$zzf>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzf> zzsw;
            switch (zzih.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzih) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0002\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzf> zzsw2 = zzf;
                    zzsw<zzf> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzf.class) {
                            zzsw<zzf> zzsw4 = zzf;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zze);
                                zzf = zza2;
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
            zze = zzf2;
            zzrb.zza(zzf.class, zzf2);
        }
    }
}
