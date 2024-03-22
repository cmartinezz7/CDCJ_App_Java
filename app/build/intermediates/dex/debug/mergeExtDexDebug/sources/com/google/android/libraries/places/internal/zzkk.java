package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;
import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzkk {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzg;
        private static volatile zzsw<zza> zzh;
        private int zzc;
        private String zzd = "";
        private int zze;
        private long zzf;

        /* renamed from: com.google.android.libraries.places.internal.zzkk$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum C0020zza implements zzrg {
            INVALID(0),
            SHOW_NOTIFICATION(1),
            USER_DISMISSED(2),
            USER_VIEW_DASHBOARD(3);
            
            private static final zzrf<C0020zza> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzkm.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzf);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private C0020zza(int i) {
                this.zzf = i;
            }

            static {
                zze = new zzkn();
            }
        }

        private zza() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zza, zzb> implements zzso {
            private zzb() {
                super(zza.zzg);
            }

            /* synthetic */ zzb(zzkl zzkl) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzkk$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zzkl.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb((zzkl) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0002\u0002", new Object[]{"zzc", "zzd", "zze", C0020zza.zzb(), "zzf"});
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
}
