package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;
import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzix {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, zzc> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzl;
        private static volatile zzsw<zza> zzm;
        private int zzc;
        private int zzd;
        private String zze = "";
        private long zzf;
        private int zzg;
        private String zzh = "";
        private long zzi;
        private long zzj;
        private int zzk;

        /* renamed from: com.google.android.libraries.places.internal.zzix$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum C0009zza implements zzrg {
            UNKNOWN(0),
            DELIVERY(1),
            INTERACTION(2);
            
            private static final zzrf<C0009zza> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zziy.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zze);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private C0009zza(int i) {
                this.zze = i;
            }

            static {
                zzd = new zziz();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNKNOWN_CONNECTIVITY_TYPE(0),
            CELL(1),
            WIFI(2);
            
            private static final zzrf<zzb> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzja.zza;
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
                zzd = new zzjb();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzd implements zzrg {
            UNKNOWN_TIMESTAMP_TYPE(0),
            NATIVE(1),
            SUPPLIED(2);
            
            private static final zzrf<zzd> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzjd.zza;
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
                zzd = new zzjc();
            }
        }

        private zza() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzc extends zzrb.zzb<zza, zzc> implements zzso {
            private zzc() {
                super(zza.zzl);
            }

            /* synthetic */ zzc(zziw zziw) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzix$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zziw.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzc((zziw) null);
                case 3:
                    return zza((zzsm) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\f\u0003\u0005\b\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\f\u0007", new Object[]{"zzc", "zzd", C0009zza.zzb(), "zze", "zzf", "zzg", zzb.zzb(), "zzh", "zzi", "zzj", "zzk", zzd.zzb()});
                case 4:
                    return zzl;
                case 5:
                    zzsw<zza> zzsw2 = zzm;
                    zzsw<zza> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zza.class) {
                            zzsw<zza> zzsw4 = zzm;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza = new zzrb.zza(zzl);
                                zzm = zza;
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
            zzl = zza;
            zzrb.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzb extends zzrb<zzb, C0010zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzb zzf;
        private static volatile zzsw<zzb> zzg;
        private int zzc;
        private int zzd;
        private zza zze;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            UNKNOWN(0),
            LIFECYCLE(1);
            
            private static final zzrf<zza> zzc = null;
            private final int zzd;

            public final int zza() {
                return this.zzd;
            }

            public static zzri zzb() {
                return zzje.zza;
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
                zzc = new zzjf();
            }
        }

        private zzb() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzix$zzb$zzb  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0010zzb extends zzrb.zzb<zzb, C0010zzb> implements zzso {
            private C0010zzb() {
                super(zzb.zzf);
            }

            /* synthetic */ C0010zzb(zziw zziw) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzix$zzb>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzb> zzsw;
            switch (zziw.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0010zzb((zziw) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzc", "zzd", zza.zzb(), "zze"});
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
}
