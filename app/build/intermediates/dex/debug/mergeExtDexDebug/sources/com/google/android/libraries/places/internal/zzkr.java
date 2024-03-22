package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;
import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzkr {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0022zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zze;
        private static volatile zzsw<zza> zzf;
        private int zzc;
        private int zzd;

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzkr$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0022zza extends zzrb.zzb<zza, C0022zza> implements zzso {
            private C0022zza() {
                super(zza.zze);
            }

            /* synthetic */ C0022zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zza>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0022zza((zzkq) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004\u0000", new Object[]{"zzc", "zzd"});
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
        public static final zzb zzj;
        private static volatile zzsw<zzb> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private boolean zzh;
        private int zzi;

        /* renamed from: com.google.android.libraries.places.internal.zzkr$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum C0023zzb implements zzrg {
            NOT_REQUIRED(0),
            ISSUED(1),
            REQUIRED_BUT_GPS_SPEED_TOO_HIGH(2),
            REQUIRED_BUT_RECENTLY_MADE(3),
            REQUIRED_BUT_USER_ON_THE_GO(4),
            REQUIRED_BUT_USER_IN_TRANSIT(5);
            
            private static final zzrf<C0023zzb> zzg = null;
            private final int zzh;

            public final int zza() {
                return this.zzh;
            }

            public static zzri zzb() {
                return zzkt.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzh);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private C0023zzb(int i) {
                this.zzh = i;
            }

            static {
                zzg = new zzks();
            }
        }

        private zzb() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzb, zza> implements zzso {
            private zza() {
                super(zzb.zzj);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzb>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzb> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0007\u0004\u0006\f\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", C0023zzb.zzb()});
                case 4:
                    return zzj;
                case 5:
                    zzsw<zzb> zzsw2 = zzk;
                    zzsw<zzb> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzb.class) {
                            zzsw<zzb> zzsw4 = zzk;
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
            zzb zzb = new zzb();
            zzj = zzb;
            zzrb.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzc extends zzrb<zzc, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzc zzg;
        private static volatile zzsw<zzc> zzh;
        private int zzc;
        private int zzd;
        private zze zze;
        private zza zzf;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            UNKNOWN(0),
            LOCATION_WITH_WIFI(1),
            BLE_BEACON(2);
            
            private static final zzrf<zza> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzku.zza;
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
                zzd = new zzkv();
            }
        }

        private zzc() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzc, zzb> implements zzso {
            private zzb() {
                super(zzc.zzg);
            }

            /* synthetic */ zzb(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzc>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzc> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zzb((zzkq) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzc> zzsw2 = zzh;
                    zzsw<zzc> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzc.class) {
                            zzsw<zzc> zzsw4 = zzh;
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
            zzc zzc2 = new zzc();
            zzg = zzc2;
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

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNKNOWN_COMPONENT(0),
            CENTRAL_ENGINE(1),
            ANONYMOUS_ENGINE(2),
            PERSONALIZED_ENGINE(3);
            
            private static final zzrf<zzb> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzkx.zza;
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
                zze = new zzkw();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzc implements zzrg {
            UNKNOWN_MODE(0),
            ZERO_POWER(1),
            STATE_ONLY(2),
            FULL_INFERENCE(3);
            
            private static final zzrf<zzc> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzky.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzf);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzc(int i) {
                this.zzf = i;
            }

            static {
                zze = new zzkz();
            }
        }

        /* renamed from: com.google.android.libraries.places.internal.zzkr$zzd$zzd  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum C0024zzd implements zzrg {
            UNKNOWN_STATE_CHANGE(0),
            STARTED(1),
            STOPPED(2);
            
            private static final zzrf<C0024zzd> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzlb.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zze);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private C0024zzd(int i) {
                this.zze = i;
            }

            static {
                zzd = new zzla();
            }
        }

        private zzd() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzd, zza> implements zzso {
            private zza() {
                super(zzd.zzg);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzd>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzd> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\f\u0002", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", C0024zzd.zzb(), "zzf", zzc.zzb()});
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
        public static final zze zzi;
        private static volatile zzsw<zze> zzj;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;

        private zze() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zze, zza> implements zzso {
            private zza() {
                super(zze.zzi);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zze>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zze> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u000f\u0001\u0003\u000f\u0002\u0004\u0004\u0003\u0005\u000f\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzsw<zze> zzsw2 = zzj;
                    zzsw<zze> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zze.class) {
                            zzsw<zze> zzsw4 = zzj;
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
            zze zze2 = new zze();
            zzi = zze2;
            zzrb.zza(zze.class, zze2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzf extends zzrb<zzf, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzf zzg;
        private static volatile zzsw<zzf> zzh;
        private int zzc;
        private int zzd;
        private boolean zze;
        private long zzf;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            UNKNOWN_TYPE(0),
            IO_EXCEPTION(1),
            FILE_NOT_FOUND(2);
            
            private static final zzrf<zza> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzlc.zza;
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
                zzd = new zzld();
            }
        }

        private zzf() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzf, zzb> implements zzso {
            private zzb() {
                super(zzf.zzg);
            }

            /* synthetic */ zzb(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzf>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzf> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zzb((zzkq) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\u0002\u0002", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzf> zzsw2 = zzh;
                    zzsw<zzf> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzf.class) {
                            zzsw<zzf> zzsw4 = zzh;
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
            zzf zzf2 = new zzf();
            zzg = zzf2;
            zzrb.zza(zzf.class, zzf2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzg extends zzrb<zzg, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzg zzh;
        private static volatile zzsw<zzg> zzi;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNDEFINED_SOURCE(0),
            INTERNAL_STORAGE(1),
            MOBILE_DATA_DOWNLOAD(2),
            APK(3),
            SERVER_DOWNLOAD(4);
            
            private static final zzrf<zzb> zzf = null;
            private final int zzg;

            public final int zza() {
                return this.zzg;
            }

            public static zzri zzb() {
                return zzlf.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzg);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzb(int i) {
                this.zzg = i;
            }

            static {
                zzf = new zzle();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzc implements zzrg {
            UNDEFINED_STATUS(0),
            SUCCESS(1),
            NO_FILE_AVAILABLE(2),
            PARSING_FAILED(3),
            SERVER_REQUEST_FAILED(4),
            MDD_CONNECTION_FAILED(5),
            FILE_READ_FAILED(6);
            
            private static final zzrf<zzc> zzh = null;
            private final int zzi;

            public final int zza() {
                return this.zzi;
            }

            public static zzri zzb() {
                return zzlg.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzi);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzc(int i) {
                this.zzi = i;
            }

            static {
                zzh = new zzlh();
            }
        }

        private zzg() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzg, zza> implements zzso {
            private zza() {
                super(zzg.zzh);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzg>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzg> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\f\u0002\u0004\u0004\u0003", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", zzc.zzb(), "zzf", zzlj.zzb(), "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzsw<zzg> zzsw2 = zzi;
                    zzsw<zzg> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzg.class) {
                            zzsw<zzg> zzsw4 = zzi;
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
            zzg zzg2 = new zzg();
            zzh = zzg2;
            zzrb.zza(zzg.class, zzg2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzh extends zzrb<zzh, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzh zzm;
        private static volatile zzsw<zzh> zzn;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private zzq zzh;
        private zzk zzi;
        private zzp zzj;
        private int zzk;
        private int zzl;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            UNKNOWN_STATUS(0),
            LOW_BATTERY(1),
            NORMAL_BATTERY(2),
            CHARGING(3);
            
            private static final zzrf<zza> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzlm.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzf);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zza(int i) {
                this.zzf = i;
            }

            static {
                zze = new zzll();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzc implements zzrg {
            UNKNOWN(0),
            WLAN(1),
            MOBILE(2),
            OTHER(3);
            
            private static final zzrf<zzc> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzlo.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzf);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzc(int i) {
                this.zzf = i;
            }

            static {
                zze = new zzln();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzd implements zzrg {
            UNKNOWN_NETWORK_REQUEST(0),
            PLACE_INFO_REQUEST(1),
            PERSONALIZED_PLACE_INFO_REQUEST(2),
            PLACE_INFERENCE_MODEL_WEIGHTS_REQUEST(3);
            
            private static final zzrf<zzd> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzlp.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzf);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzd(int i) {
                this.zzf = i;
            }

            static {
                zze = new zzlq();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zze implements zzrg {
            UNKNOWN_SERVER_TYPE(0),
            PLACES_SERVER(1),
            SEMANTIC_LOCATION_SERVER(2);
            
            private static final zzrf<zze> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzls.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zze);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zze(int i) {
                this.zze = i;
            }

            static {
                zzd = new zzlr();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzf implements zzrg {
            UNKNOWN_REQUEST_STATUS(0),
            SUCCESS(1),
            TIMEOUT(2),
            NETWORK_ERROR(3);
            
            private static final zzrf<zzf> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzlt.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzf);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzf(int i) {
                this.zzf = i;
            }

            static {
                zze = new zzlu();
            }
        }

        private zzh() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzh, zzb> implements zzso {
            private zzb() {
                super(zzh.zzm);
            }

            /* synthetic */ zzb(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzh>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzh> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb((zzkq) null);
                case 3:
                    return zza((zzsm) zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\f\u0003\u0005\t\u0004\u0006\t\u0005\u0007\t\u0006\b\f\u0007\t\f\b", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzf.zzb(), "zzf", "zzg", zzc.zzb(), "zzh", "zzi", "zzj", "zzk", zza.zzb(), "zzl", zze.zzb()});
                case 4:
                    return zzm;
                case 5:
                    zzsw<zzh> zzsw2 = zzn;
                    zzsw<zzh> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzh.class) {
                            zzsw<zzh> zzsw4 = zzn;
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
            zzh zzh2 = new zzh();
            zzm = zzh2;
            zzrb.zza(zzh.class, zzh2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzi extends zzrb<zzi, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzi zze;
        private static volatile zzsw<zzi> zzf;
        private int zzc;
        private int zzd;

        private zzi() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzi, zza> implements zzso {
            private zza() {
                super(zzi.zze);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzi>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzi> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzi> zzsw2 = zzf;
                    zzsw<zzi> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzi.class) {
                            zzsw<zzi> zzsw4 = zzf;
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
            zzi zzi = new zzi();
            zze = zzi;
            zzrb.zza(zzi.class, zzi);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzj extends zzrb<zzj, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzj zzl;
        private static volatile zzsw<zzj> zzm;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private boolean zzi;
        private int zzj;
        private int zzk;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            CONTEXT_MANAGER(0),
            MDH(1);
            
            private static final zzrf<zzb> zzc = null;
            private final int zzd;

            public final int zza() {
                return this.zzd;
            }

            public static zzri zzb() {
                return zzlw.zza;
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
                zzc = new zzlv();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzc implements zzrg {
            SUCCESS(0),
            PROTO_PARSING_ERROR(1),
            REQUEST_FAILED(2);
            
            private static final zzrf<zzc> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzlx.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zze);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzc(int i) {
                this.zze = i;
            }

            static {
                zzd = new zzly();
            }
        }

        private zzj() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzj, zza> implements zzso {
            private zza() {
                super(zzj.zzl);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzj>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzj> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0007\u0005\u0007\f\u0006\b\f\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzc.zzb(), "zzk", zzb.zzb()});
                case 4:
                    return zzl;
                case 5:
                    zzsw<zzj> zzsw2 = zzm;
                    zzsw<zzj> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzj.class) {
                            zzsw<zzj> zzsw4 = zzm;
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
            zzj zzj2 = new zzj();
            zzl = zzj2;
            zzrb.zza(zzj.class, zzj2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzk extends zzrb<zzk, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzk zzg;
        private static volatile zzsw<zzk> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        private zzk() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzk, zza> implements zzso {
            private zza() {
                super(zzk.zzg);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzk>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzk> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzk> zzsw2 = zzh;
                    zzsw<zzk> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzk.class) {
                            zzsw<zzk> zzsw4 = zzh;
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
            zzk zzk = new zzk();
            zzg = zzk;
            zzrb.zza(zzk.class, zzk);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzl extends zzrb<zzl, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzl zzj;
        private static volatile zzsw<zzl> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;

        private zzl() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzl, zza> implements zzso {
            private zza() {
                super(zzl.zzj);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzl>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzl> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzsw<zzl> zzsw2 = zzk;
                    zzsw<zzl> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzl.class) {
                            zzsw<zzl> zzsw4 = zzk;
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
            zzl zzl = new zzl();
            zzj = zzl;
            zzrb.zza(zzl.class, zzl);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzm extends zzrb<zzm, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzm zzk;
        private static volatile zzsw<zzm> zzl;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;

        private zzm() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzm, zza> implements zzso {
            private zza() {
                super(zzm.zzk);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzm>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzm> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\u0004\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzsw<zzm> zzsw2 = zzl;
                    zzsw<zzm> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzm.class) {
                            zzsw<zzm> zzsw4 = zzl;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzk);
                                zzl = zza2;
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
            zzk = zzm;
            zzrb.zza(zzm.class, zzm);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzn extends zzrb<zzn, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzn zzp;
        private static volatile zzsw<zzn> zzq;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private boolean zzh;
        private int zzi;
        private int zzj;
        private int zzk;
        private zzrm<zzb> zzl = zzk();
        private int zzm;
        private int zzn;
        private int zzo;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb<zzb, zza> implements zzso {
            /* access modifiers changed from: private */
            public static final zzb zzg;
            private static volatile zzsw<zzb> zzh;
            private int zzc;
            private int zzd;
            private int zze;
            private int zzf;

            private zzb() {
            }

            /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
            public static final class zza extends zzrb.zzb<zzb, zza> implements zzso {
                private zza() {
                    super(zzb.zzg);
                }

                /* synthetic */ zza(zzkq zzkq) {
                    this();
                }
            }

            /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzn$zzb>, com.google.android.libraries.places.internal.zzrb$zza] */
            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                zzsw<zzb> zzsw;
                switch (zzkq.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza((zzkq) null);
                    case 3:
                        return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
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

        private zzn() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzn, zza> implements zzso {
            private zza() {
                super(zzn.zzp);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzn>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzn> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzp, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0004\u0005\u0007\u0004\u0006\b\u0004\u0007\t\u001b\n\u0004\b\u000b\f\t\f\u0004\n", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzb.class, "zzm", "zzn", zzlj.zzb(), "zzo"});
                case 4:
                    return zzp;
                case 5:
                    zzsw<zzn> zzsw2 = zzq;
                    zzsw<zzn> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzn.class) {
                            zzsw<zzn> zzsw4 = zzq;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzp);
                                zzq = zza2;
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
            zzn zzn2 = new zzn();
            zzp = zzn2;
            zzrb.zza(zzn.class, zzn2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzo extends zzrb<zzo, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzo zzw;
        private static volatile zzsw<zzo> zzx;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private boolean zzh;
        private zzrh zzi = zzi();
        private int zzj;
        private zzh zzk;
        private zzn zzl;
        private zzb zzm;
        private zzl zzn;
        private zzj zzo;
        private zzm zzp;
        private zzc zzq;
        private zzd zzr;
        private zzr zzs;
        private zzs zzt;
        private zzg zzu;
        private zzf zzv;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNKNOWN_EVENT_TYPE(0),
            NETWORK_REQUEST(1),
            PLACE_INFERENCE_COMPUTATION(2),
            CANDIDATE_SELECTION(3),
            PLACE_INDEX(4),
            PERSONAL_PLACES_UPDATE(5),
            PLACE_INDEX_FREE_SPACE(6),
            INCOMING_SIGNAL(7),
            LIFECYCLE(8),
            PREFETCH(9),
            SEGMENTER(10),
            MODEL_LOAD(11),
            MAPPED_BYTE_BUFFER_ERROR(12);
            
            private static final zzrf<zzb> zzn = null;
            private final int zzo;

            public final int zza() {
                return this.zzo;
            }

            public static zzri zzb() {
                return zzma.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzo);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzb(int i) {
                this.zzo = i;
            }

            static {
                zzn = new zzlz();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzc implements zzrg {
            UNKWNOWN_POWER_MODE(0),
            HIGH_POWER(1),
            BALANCED_POWER(2),
            LOW_POWER(3),
            NO_POWER(4);
            
            private static final zzrf<zzc> zzf = null;
            private final int zzg;

            public final int zza() {
                return this.zzg;
            }

            public static zzri zzb() {
                return zzmb.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzg);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzc(int i) {
                this.zzg = i;
            }

            static {
                zzf = new zzmc();
            }
        }

        private zzo() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzo, zza> implements zzso {
            private zza() {
                super(zzo.zzw);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzo>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzo> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzw, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0001\u0000\u0001\f\u0001\u0002\f\u0002\u0003\u0004\u0003\u0004\t\u0006\u0005\t\u0007\u0006\t\b\u0007\t\t\b\u0007\u0004\t\t\n\n\t\u000b\u000b\u0016\f\u0004\u0005\r\t\f\u000e\t\r\u000f\t\u000e\u0010\t\u000f\u0011\u0004\u0000\u0012\t\u0010\u0013\t\u0011", new Object[]{"zzc", "zze", zzb.zzb(), "zzf", zzc.zzb(), "zzg", "zzk", "zzl", "zzm", "zzn", "zzh", "zzo", "zzp", "zzi", "zzj", "zzq", "zzr", "zzs", "zzt", "zzd", "zzu", "zzv"});
                case 4:
                    return zzw;
                case 5:
                    zzsw<zzo> zzsw2 = zzx;
                    zzsw<zzo> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzo.class) {
                            zzsw<zzo> zzsw4 = zzx;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzw);
                                zzx = zza2;
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
            zzo zzo2 = new zzo();
            zzw = zzo2;
            zzrb.zza(zzo.class, zzo2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzp extends zzrb<zzp, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzp zze;
        private static volatile zzsw<zzp> zzf;
        private int zzc;
        private int zzd;

        private zzp() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzp, zza> implements zzso {
            private zza() {
                super(zzp.zze);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzp>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzp> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzp> zzsw2 = zzf;
                    zzsw<zzp> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzp.class) {
                            zzsw<zzp> zzsw4 = zzf;
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
            zzp zzp = new zzp();
            zze = zzp;
            zzrb.zza(zzp.class, zzp);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzq extends zzrb<zzq, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzq zzh;
        private static volatile zzsw<zzq> zzi;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private boolean zzg;

        private zzq() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzq, zza> implements zzso {
            private zza() {
                super(zzq.zzh);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzq>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzq> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0007\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzsw<zzq> zzsw2 = zzi;
                    zzsw<zzq> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzq.class) {
                            zzsw<zzq> zzsw4 = zzi;
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
            zzq zzq = new zzq();
            zzh = zzq;
            zzrb.zza(zzq.class, zzq);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzr extends zzrb<zzr, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzr zze;
        private static volatile zzsw<zzr> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNKNOWN(0),
            SCHEDULE(1),
            TRIGGERED(2),
            CANCEL(3);
            
            private static final zzrf<zzb> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzme.zza;
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
                zze = new zzmd();
            }
        }

        private zzr() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzr, zza> implements zzso {
            private zza() {
                super(zzr.zze);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzr>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzr> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzc", "zzd", zzb.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzr> zzsw2 = zzf;
                    zzsw<zzr> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzr.class) {
                            zzsw<zzr> zzsw4 = zzf;
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
            zzr zzr = new zzr();
            zze = zzr;
            zzrb.zza(zzr.class, zzr);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzs extends zzrb<zzs, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzs zzj;
        private static volatile zzsw<zzs> zzk;
        private int zzc;
        private int zzd;
        private zza zze;
        private zza zzf;
        private int zzg;
        private zzt zzh;
        private zzi zzi;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb<zza, zzb> implements zzso {
            /* access modifiers changed from: private */
            public static final zza zzf;
            private static volatile zzsw<zza> zzg;
            private int zzc;
            private int zzd;
            private long zze;

            /* renamed from: com.google.android.libraries.places.internal.zzkr$zzs$zza$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
            public enum C0025zza implements zzrg {
                UNKNOWN(0),
                AT_PLACE(1),
                IN_TRANSIT(2);
                
                private static final zzrf<C0025zza> zzd = null;
                private final int zze;

                public final int zza() {
                    return this.zze;
                }

                public static zzri zzb() {
                    return zzmf.zza;
                }

                public final String toString() {
                    StringBuilder sb = new StringBuilder("<");
                    sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                    sb.append(" number=").append(this.zze);
                    return sb.append(" name=").append(name()).append(Typography.greater).toString();
                }

                private C0025zza(int i) {
                    this.zze = i;
                }

                static {
                    zzd = new zzmg();
                }
            }

            private zza() {
            }

            /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
            public static final class zzb extends zzrb.zzb<zza, zzb> implements zzso {
                private zzb() {
                    super(zza.zzf);
                }

                /* synthetic */ zzb(zzkq zzkq) {
                    this();
                }
            }

            /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzs$zza>] */
            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                zzsw<zza> zzsw;
                switch (zzkq.zza[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new zzb((zzkq) null);
                    case 3:
                        return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\u0003\u0001", new Object[]{"zzc", "zzd", C0025zza.zzb(), "zze"});
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
        public enum zzc implements zzrg {
            UNKNOWN_EVENT_TYPE(0),
            NEW_SEGMENT(1),
            EXTEND_SEGMENT(2);
            
            private static final zzrf<zzc> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzmi.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zze);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzc(int i) {
                this.zze = i;
            }

            static {
                zzd = new zzmh();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzd implements zzrg {
            UNKNOWN(0),
            SIMPLE_SEGMENTER(1),
            ON_THE_GO_SEGMENTER(2);
            
            private static final zzrf<zzd> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzmj.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zze);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzd(int i) {
                this.zze = i;
            }

            static {
                zzd = new zzmk();
            }
        }

        private zzs() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzs, zzb> implements zzso {
            private zzb() {
                super(zzs.zzj);
            }

            /* synthetic */ zzb(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzs>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzs> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zzb((zzkq) null);
                case 3:
                    return zza((zzsm) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002\u0004\f\u0003\u0005\t\u0004\u0006\t\u0005", new Object[]{"zzc", "zzd", zzc.zzb(), "zze", "zzf", "zzg", zzd.zzb(), "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzsw<zzs> zzsw2 = zzk;
                    zzsw<zzs> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzs.class) {
                            zzsw<zzs> zzsw4 = zzk;
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
            zzs zzs = new zzs();
            zzj = zzs;
            zzrb.zza(zzs.class, zzs);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzt extends zzrb<zzt, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzt zzh;
        private static volatile zzsw<zzt> zzi;
        private int zzc;
        private int zzd;
        private boolean zze;
        private boolean zzf;
        private boolean zzg;

        private zzt() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzt, zza> implements zzso {
            private zza() {
                super(zzt.zzh);
            }

            /* synthetic */ zza(zzkq zzkq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkr$zzt>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzt> zzsw;
            switch (zzkq.zza[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza((zzkq) null);
                case 3:
                    return zza((zzsm) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\u0007\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzsw<zzt> zzsw2 = zzi;
                    zzsw<zzt> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzt.class) {
                            zzsw<zzt> zzsw4 = zzi;
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
            zzt zzt = new zzt();
            zzh = zzt;
            zzrb.zza(zzt.class, zzt);
        }
    }
}
