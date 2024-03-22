package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;
import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzhx {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0002zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzl;
        private static volatile zzsw<zza> zzm;
        private int zzc;
        private String zzd = "";
        private int zze;
        private int zzf;
        private String zzg = "";
        private int zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            STATUS_UNKNOWN(0),
            STATUS_TRUE(1),
            STATUS_FALSE(2);
            
            private static final zzrf<zzb> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzhz.zza;
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
                zzd = new zzhy();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzc implements zzrg {
            GRANULARITY_UNKNOWN(0),
            NONE(1),
            COARSE(2),
            FINE(3);
            
            private static final zzrf<zzc> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzia.zza;
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
                zze = new zzib();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzd implements zzrg {
            PERMISSION_UNKNOWN(0),
            ALWAYS(1),
            WHILE_IN_USE(2),
            DENY(3);
            
            private static final zzrf<zzd> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzie.zza;
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
                zze = new zzic();
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzhx$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0002zza extends zzrb.zzb<zza, C0002zza> implements zzso {
            private C0002zza() {
                super(zza.zzl);
            }

            public final C0002zza zza(String str) {
                zzb();
                ((zza) this.zza).zza(str);
                return this;
            }

            public final C0002zza zza(int i) {
                zzb();
                ((zza) this.zza).zzb(i);
                return this;
            }

            /* synthetic */ C0002zza(zzhw zzhw) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        public static C0002zza zza() {
            return (C0002zza) zzl.zzf();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzhx$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zzhw.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0002zza((zzhw) null);
                case 3:
                    return zza((zzsm) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\b\u0003\u0005\u0004\u0004\u0006\f\u0005\u0007\f\u0006\b\f\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzb.zzb(), "zzj", zzd.zzb(), "zzk", zzc.zzb()});
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
}
