package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzid;
import com.google.android.libraries.places.internal.zzig;
import com.google.android.libraries.places.internal.zzir;
import com.google.android.libraries.places.internal.zzix;
import com.google.android.libraries.places.internal.zzjh;
import com.google.android.libraries.places.internal.zzjk;
import com.google.android.libraries.places.internal.zzjm;
import com.google.android.libraries.places.internal.zzjv;
import com.google.android.libraries.places.internal.zzkb;
import com.google.android.libraries.places.internal.zzkk;
import com.google.android.libraries.places.internal.zzkp;
import com.google.android.libraries.places.internal.zzkr;
import com.google.android.libraries.places.internal.zzmm;
import com.google.android.libraries.places.internal.zzpo;
import com.google.android.libraries.places.internal.zzrb;
import kotlin.text.Typography;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzhr {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzt;
        private static volatile zzsw<zza> zzu;
        private int zzc;
        private int zzd = 1;
        private zzmm.zzs zze;
        private zzjh.zza zzf;
        private zzpo.zza zzg;
        private zzkr.zzo zzh;
        private zzjv.zzi zzi;
        private zzjm.zzb zzj;
        private zzir.zza zzk;
        private zzig.zzb zzl;
        private zzjk.zzc zzm;
        private zzkb.zzi zzn;
        private zzkk.zza zzo;
        private zzkp.zza zzp;
        private zzix.zzb zzq;
        private zzid.zzb zzr;
        private byte zzs = 2;

        /* renamed from: com.google.android.libraries.places.internal.zzhr$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum C0001zza implements zzrg {
            PLACES(1),
            ENGINE_STATS(2),
            USER_CONFIG(3),
            PLACE_INFERENCE(4),
            FLP(5),
            GEOCODER_STATS(6),
            DIALOGS(7),
            CHRE(8),
            FOP(9),
            GEOFENCER(10),
            RE_UP(11),
            NANOAPP(12),
            EMERGENCY_ALERT(13),
            BLUEPIXEL(14);
            
            private static final zzrf<C0001zza> zzo = null;
            private final int zzp;

            public final int zza() {
                return this.zzp;
            }

            public static zzri zzb() {
                return zzhu.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzp);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private C0001zza(int i) {
                this.zzp = i;
            }

            static {
                zzo = new zzhv();
            }
        }

        private zza() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zza, zzb> implements zzso {
            private zzb() {
                super(zza.zzt);
            }

            public final zzb zza(C0001zza zza) {
                zzb();
                ((zza) this.zza).zza(zza);
                return this;
            }

            public final zzb zza(zzmm.zzs zzs) {
                zzb();
                ((zza) this.zza).zza(zzs);
                return this;
            }

            /* synthetic */ zzb(zzht zzht) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(C0001zza zza) {
            if (zza != null) {
                this.zzc |= 1;
                this.zzd = zza.zza();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzmm.zzs zzs2) {
            if (zzs2 != null) {
                this.zze = zzs2;
                this.zzc |= 2;
                return;
            }
            throw new NullPointerException();
        }

        public static zzb zza() {
            return (zzb) zzt.zzf();
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzhr$zza>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            int i2 = 1;
            switch (zzht.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb((zzht) null);
                case 3:
                    return zza((zzsm) zzt, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0001\u0001\f\u0000\u0002Љ\u0001\u0003\t\u0002\u0004\t\u0003\u0005\t\u0004\u0006\t\u0005\u0007\t\u0006\b\t\u0007\t\t\b\n\t\t\u000b\t\n\f\t\u000b\r\t\f\u000e\t\r\u000f\t\u000e", new Object[]{"zzc", "zzd", C0001zza.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
                case 4:
                    return zzt;
                case 5:
                    zzsw<zza> zzsw2 = zzu;
                    zzsw<zza> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zza.class) {
                            zzsw<zza> zzsw4 = zzu;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza = new zzrb.zza(zzt);
                                zzu = zza;
                                zzsw = zza;
                            }
                        }
                        zzsw3 = zzsw;
                    }
                    return zzsw3;
                case 6:
                    return Byte.valueOf(this.zzs);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzs = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzt = zza;
            zzrb.zza(zza.class, zza);
        }
    }
}
