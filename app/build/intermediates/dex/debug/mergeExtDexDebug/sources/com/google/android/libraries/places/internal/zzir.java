package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;
import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzir {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0007zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzf;
        private static volatile zzsw<zza> zzg;
        private int zzc;
        private int zzd;
        private zzc zze;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNSPECIFIED(0),
            LOWD(1);
            
            private static final zzrf<zzb> zzc = null;
            private final int zzd;

            public final int zza() {
                return this.zzd;
            }

            public static zzri zzb() {
                return zzit.zza;
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
                zzc = new zzis();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzc extends zzrb<zzc, zzb> implements zzso {
            /* access modifiers changed from: private */
            public static final zzc zzg;
            private static volatile zzsw<zzc> zzh;
            private int zzc;
            private int zzd;
            private long zze;
            private long zzf;

            /* renamed from: com.google.android.libraries.places.internal.zzir$zza$zzc$zza  reason: collision with other inner class name */
            /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
            public enum C0008zza implements zzrg {
                UNSPECIFIED(0),
                BACKOFF(1),
                ACCEPT(2),
                REJECT(3);
                
                private static final zzrf<C0008zza> zze = null;
                private final int zzf;

                public final int zza() {
                    return this.zzf;
                }

                public static zzri zzb() {
                    return zziu.zza;
                }

                public final String toString() {
                    StringBuilder sb = new StringBuilder("<");
                    sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                    sb.append(" number=").append(this.zzf);
                    return sb.append(" name=").append(name()).append(Typography.greater).toString();
                }

                private C0008zza(int i) {
                    this.zzf = i;
                }

                static {
                    zze = new zziv();
                }
            }

            private zzc() {
            }

            /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
            public static final class zzb extends zzrb.zzb<zzc, zzb> implements zzso {
                private zzb() {
                    super(zzc.zzg);
                }

                /* synthetic */ zzb(zziq zziq) {
                    this();
                }
            }

            /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzir$zza$zzc>] */
            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                zzsw<zzc> zzsw;
                switch (zziq.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zzb((zziq) null);
                    case 3:
                        return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0003\u0001\u0003\u0003\u0002", new Object[]{"zzc", "zzd", C0008zza.zzb(), "zze", "zzf"});
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
                zzc zzc2 = new zzc();
                zzg = zzc2;
                zzrb.zza(zzc.class, zzc2);
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzir$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0007zza extends zzrb.zzb<zza, C0007zza> implements zzso {
            private C0007zza() {
                super(zza.zzf);
            }

            /* synthetic */ C0007zza(zziq zziq) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzir$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zziq.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0007zza((zziq) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzc", "zzd", zzb.zzb(), "zze"});
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
