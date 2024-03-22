package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzhx;
import com.google.android.libraries.places.internal.zzjt;
import com.google.android.libraries.places.internal.zzpl;
import com.google.android.libraries.places.internal.zzrb;
import kotlin.io.ConstantsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.ksoap2.SoapEnvelope;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzmm {

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zza extends zzrb<zza, C0026zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zza zzf;
        private static volatile zzsw<zza> zzg;
        private int zzc;
        private String zzd = "";
        private int zze;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNKNOWN(0),
            CHAIN(1),
            TYPE(2);
            
            private static final zzrf<zzb> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzmu.zza;
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
                zzd = new zzmt();
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.libraries.places.internal.zzmm$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class C0026zza extends zzrb.zzb<zza, C0026zza> implements zzso {
            private C0026zza() {
                super(zza.zzf);
            }

            /* synthetic */ C0026zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zza>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zza> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0026zza((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001", new Object[]{"zzc", "zzd", "zze", zzb.zzb()});
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
    public static final class zzaa extends zzrb<zzaa, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzaa zzk;
        private static volatile zzsw<zzaa> zzl;
        private int zzc;
        private int zzd;
        private zzrm<String> zze = zzrb.zzk();
        private int zzf;
        private int zzg;
        private long zzh;
        private String zzi = "";
        private boolean zzj;

        private zzaa() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzaa, zza> implements zzso {
            private zza() {
                super(zzaa.zzk);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzaa>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzaa> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzaa();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\f\u0000\u0002\u001a\u0003\u0004\u0001\u0004\f\u0002\u0005\u0002\u0003\u0006\b\u0004\u0007\u0007\u0005", new Object[]{"zzc", "zzd", zzne.zzb(), "zze", "zzf", "zzg", zzab.zzc.zzb(), "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzsw<zzaa> zzsw2 = zzl;
                    zzsw<zzaa> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzaa.class) {
                            zzsw<zzaa> zzsw4 = zzl;
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
            zzaa zzaa = new zzaa();
            zzk = zzaa;
            zzrb.zza(zzaa.class, zzaa);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzab extends zzrb<zzab, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzab zzl;
        private static volatile zzsw<zzab> zzm;
        private int zzc;
        private zzh zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private long zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            TYPE_UNSPECIFIED(0),
            INVALID(-1),
            NO_POWER(100),
            HIGH_POWER(SoapEnvelope.VER11);
            
            private static final zzrf<zza> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzov.zza;
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
                zze = new zzow();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzc implements zzrg {
            ADAPTIVE(0),
            FIXED_DEPRECATED(1),
            FIXED_MEDIUM(2),
            FIXED_LARGE(4);
            
            private static final zzrf<zzc> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzoy.zza;
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
                zze = new zzox();
            }
        }

        private zzab() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzab, zzb> implements zzso {
            private zzb() {
                super(zzab.zzl);
            }

            /* synthetic */ zzb(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzab>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzab> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzab();
                case 2:
                    return new zzb((zzml) null);
                case 3:
                    return zza((zzsm) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\t\u0000\u0002\f\u0001\u0003\f\u0002\u0004\u0007\u0003\u0005\u0002\u0004\u0006\f\u0005\u0007\u0004\u0006\b\f\u0007", new Object[]{"zzc", "zzd", "zze", zzne.zzb(), "zzf", zzc.zzb(), "zzg", "zzh", "zzi", zza.zzb(), "zzj", "zzk", zzmo.zzb()});
                case 4:
                    return zzl;
                case 5:
                    zzsw<zzab> zzsw2 = zzm;
                    zzsw<zzab> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzab.class) {
                            zzsw<zzab> zzsw4 = zzm;
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
            zzab zzab = new zzab();
            zzl = zzab;
            zzrb.zza(zzab.class, zzab);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzac extends zzrb<zzac, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzac zzh;
        private static volatile zzsw<zzac> zzi;
        private int zzc;
        private zzrm<String> zzd = zzrb.zzk();
        private int zze;
        private String zzf = "";
        private boolean zzg;

        private zzac() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzac, zza> implements zzso {
            private zza() {
                super(zzac.zzh);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzac>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzac> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzac();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001a\u0002\f\u0000\u0003\b\u0001\u0004\u0007\u0002", new Object[]{"zzc", "zzd", "zze", zzab.zzc.zzb(), "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzsw<zzac> zzsw2 = zzi;
                    zzsw<zzac> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzac.class) {
                            zzsw<zzac> zzsw4 = zzi;
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
            zzac zzac = new zzac();
            zzh = zzac;
            zzrb.zza(zzac.class, zzac);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzad extends zzrb<zzad, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzad zze;
        private static volatile zzsw<zzad> zzf;
        private int zzc;
        private int zzd;

        private zzad() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzad, zza> implements zzso {
            private zza() {
                super(zzad.zze);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzad>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzad> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzad();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzad> zzsw2 = zzf;
                    zzsw<zzad> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzad.class) {
                            zzsw<zzad> zzsw4 = zzf;
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
            zzad zzad = new zzad();
            zze = zzad;
            zzrb.zza(zzad.class, zzad);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzae extends zzrb<zzae, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzae zzg;
        private static volatile zzsw<zzae> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private boolean zzf;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            PHOTO_METADATA(0),
            PHOTO_IMAGE(1);
            
            private static final zzrf<zza> zzc = null;
            private final int zzd;

            public final int zza() {
                return this.zzd;
            }

            public static zzri zzb() {
                return zzoz.zza;
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
                zzc = new zzpa();
            }
        }

        private zzae() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzae, zzb> implements zzso {
            private zzb() {
                super(zzae.zzg);
            }

            public final zzb zza(zza zza) {
                zzb();
                ((zzae) this.zza).zza(zza);
                return this;
            }

            /* synthetic */ zzb(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            if (zza2 != null) {
                this.zzc |= 1;
                this.zzd = zza2.zza();
                return;
            }
            throw new NullPointerException();
        }

        public static zzb zza() {
            return (zzb) zzg.zzf();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzae>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzae> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzae();
                case 2:
                    return new zzb((zzml) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0004\u0001\u0003\u0007\u0002", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzae> zzsw2 = zzh;
                    zzsw<zzae> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzae.class) {
                            zzsw<zzae> zzsw4 = zzh;
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
            zzae zzae = new zzae();
            zzg = zzae;
            zzrb.zza(zzae.class, zzae);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzaf extends zzrb<zzaf, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzaf zzd;
        private static volatile zzsw<zzaf> zze;
        private zzrm<String> zzc = zzrb.zzk();

        private zzaf() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzaf, zza> implements zzso {
            private zza() {
                super(zzaf.zzd);
            }

            public final zza zza(Iterable<String> iterable) {
                zzb();
                ((zzaf) this.zza).zza(iterable);
                return this;
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<String> iterable) {
            if (!this.zzc.zza()) {
                this.zzc = zzrb.zza(this.zzc);
            }
            zzpu.zza(iterable, this.zzc);
        }

        public static zza zza() {
            return (zza) zzd.zzf();
        }

        /* JADX WARNING: type inference failed for: r1v13, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzaf>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzaf> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzaf();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzc"});
                case 4:
                    return zzd;
                case 5:
                    zzsw<zzaf> zzsw2 = zze;
                    zzsw<zzaf> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzaf.class) {
                            zzsw<zzaf> zzsw4 = zze;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzd);
                                zze = zza2;
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
            zzaf zzaf = new zzaf();
            zzd = zzaf;
            zzrb.zza(zzaf.class, zzaf);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzag extends zzrb<zzag, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzag zzg;
        private static volatile zzsw<zzag> zzh;
        private int zzc;
        private int zzd;
        private long zze;
        private int zzf;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            INVALID(0),
            HIGH_POWER(1),
            BALANCED_POWER(2),
            LOW_POWER(3),
            NO_POWER(4);
            
            private static final zzrf<zzb> zzf = null;
            private final int zzg;

            public final int zza() {
                return this.zzg;
            }

            public static zzri zzb() {
                return zzpc.zza;
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
                zzf = new zzpb();
            }
        }

        private zzag() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzag, zza> implements zzso {
            private zza() {
                super(zzag.zzg);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzag>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzag> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzag();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\b\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0002\u0001\b\f\u0002", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", zzmo.zzb()});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzag> zzsw2 = zzh;
                    zzsw<zzag> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzag.class) {
                            zzsw<zzag> zzsw4 = zzh;
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
            zzag zzag = new zzag();
            zzg = zzag;
            zzrb.zza(zzag.class, zzag);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzah extends zzrb<zzah, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzah zzx;
        private static volatile zzsw<zzah> zzy;
        private int zzc;
        private int zzd;
        private String zze = "";
        private String zzf = "";
        private zzk zzg;
        private zzal zzh;
        private zzw zzi;
        private zzn zzj;
        private zzv zzk;
        private zzo zzl;
        private zzu zzm;
        private zzam zzn;
        private zzam zzo;
        private zzx zzp;
        private zzr zzq;
        private zzai zzr;
        private zzaj zzs;
        private zzad zzt;
        private zzz zzu;
        private zzak zzv;
        private byte zzw = 2;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            UNKNOWN(0),
            SEARCH(1),
            BY_LATLNG(2),
            ADD_A_PLACE(3),
            BY_ID(4),
            AUTOCOMPLETE(5),
            GET_ALIASES(6),
            SET_ALIAS(7),
            GET_BY_LOCATION(8),
            DELETE_ALIAS(9),
            SEARCH_BY_BEACON(10),
            SEARCH_BY_CHAIN(11),
            NEARBY_ALERTS_RADIUS_REQUEST(12),
            GET_USER_PLACES(13),
            SEARCH_BY_CLIENT(14);
            
            private static final zzrf<zza> zzp = null;
            private final int zzq;

            public final int zza() {
                return this.zzq;
            }

            public static zzri zzb() {
                return zzpd.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzq);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zza(int i) {
                this.zzq = i;
            }

            static {
                zzp = new zzpe();
            }
        }

        private zzah() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzah, zzb> implements zzso {
            private zzb() {
                super(zzah.zzx);
            }

            public final zzb zza(zza zza) {
                zzb();
                ((zzah) this.zza).zza(zza);
                return this;
            }

            public final zzb zza(String str) {
                zzb();
                ((zzah) this.zza).zza(str);
                return this;
            }

            public final zzb zzb(String str) {
                zzb();
                ((zzah) this.zza).zzb(str);
                return this;
            }

            public final zzb zza(zzv zzv) {
                zzb();
                ((zzah) this.zza).zza(zzv);
                return this;
            }

            public final zzb zza(zzo zzo) {
                zzb();
                ((zzah) this.zza).zza(zzo);
                return this;
            }

            /* synthetic */ zzb(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            if (zza2 != null) {
                this.zzc |= 1;
                this.zzd = zza2.zza();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 2;
                this.zze = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 4;
                this.zzf = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzv zzv2) {
            if (zzv2 != null) {
                this.zzk = zzv2;
                this.zzc |= 128;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzo zzo2) {
            if (zzo2 != null) {
                this.zzl = zzo2;
                this.zzc |= 256;
                return;
            }
            throw new NullPointerException();
        }

        public static zzb zza() {
            return (zzb) zzx.zzf();
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzah>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzah> zzsw;
            int i2 = 1;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzah();
                case 2:
                    return new zzb((zzml) null);
                case 3:
                    return zza((zzsm) zzx, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0000\u0004\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\t\u0003\u0005Љ\u0004\u0006Љ\u0005\u0007Љ\u0006\b\t\u0007\tЉ\b\n\t\t\u000b\t\u000b\f\t\n\r\t\f\u000e\t\r\u000f\t\u000e\u0010\t\u000f\u0011\t\u0010\u0012\t\u0011\u0013\t\u0012", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzo", "zzn", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv"});
                case 4:
                    return zzx;
                case 5:
                    zzsw<zzah> zzsw2 = zzy;
                    zzsw<zzah> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzah.class) {
                            zzsw<zzah> zzsw4 = zzy;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzx);
                                zzy = zza2;
                                zzsw = zza2;
                            }
                        }
                        zzsw3 = zzsw;
                    }
                    return zzsw3;
                case 6:
                    return Byte.valueOf(this.zzw);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzw = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzah zzah = new zzah();
            zzx = zzah;
            zzrb.zza(zzah.class, zzah);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzai extends zzrb<zzai, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzai zze;
        private static volatile zzsw<zzai> zzf;
        private int zzc;
        private int zzd;

        private zzai() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzai, zza> implements zzso {
            private zza() {
                super(zzai.zze);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzai>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzai> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzai();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzai> zzsw2 = zzf;
                    zzsw<zzai> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzai.class) {
                            zzsw<zzai> zzsw4 = zzf;
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
            zzai zzai = new zzai();
            zze = zzai;
            zzrb.zza(zzai.class, zzai);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzaj extends zzrb<zzaj, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzaj zzd;
        private static volatile zzsw<zzaj> zze;
        private zzrm<String> zzc = zzrb.zzk();

        private zzaj() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzaj, zza> implements zzso {
            private zza() {
                super(zzaj.zzd);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r1v13, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzaj>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzaj> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzaj();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzc"});
                case 4:
                    return zzd;
                case 5:
                    zzsw<zzaj> zzsw2 = zze;
                    zzsw<zzaj> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzaj.class) {
                            zzsw<zzaj> zzsw4 = zze;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzd);
                                zze = zza2;
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
            zzaj zzaj = new zzaj();
            zzd = zzaj;
            zzrb.zza(zzaj.class, zzaj);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzak extends zzrb<zzak, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzak zze;
        private static volatile zzsw<zzak> zzf;
        private zzrm<String> zzc = zzrb.zzk();
        private zzrm<zza> zzd = zzk();

        private zzak() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzak, zza> implements zzso {
            private zza() {
                super(zzak.zze);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzak>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzak> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzak();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001a\u0002\u001b", new Object[]{"zzc", "zzd", zza.class});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzak> zzsw2 = zzf;
                    zzsw<zzak> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzak.class) {
                            zzsw<zzak> zzsw4 = zzf;
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
            zzak zzak = new zzak();
            zze = zzak;
            zzrb.zza(zzak.class, zzak);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzal extends zzrb<zzal, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzal zzj;
        private static volatile zzsw<zzal> zzk;
        private int zzc;
        private zzjt.zzb zzd;
        private int zze;
        private int zzf;
        private String zzg = "";
        private int zzh;
        private byte zzi = 2;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNKNOWN(0),
            NEARBY_ALERTS(1),
            GEO_DATA_API(2);
            
            private static final zzrf<zzb> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzpg.zza;
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
                zzd = new zzpf();
            }
        }

        private zzal() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzal, zza> implements zzso {
            private zza() {
                super(zzal.zzj);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzal>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzal> zzsw;
            int i2 = 1;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzal();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001Љ\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\b\u0003\u0005\f\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzb.zzb()});
                case 4:
                    return zzj;
                case 5:
                    zzsw<zzal> zzsw2 = zzk;
                    zzsw<zzal> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzal.class) {
                            zzsw<zzal> zzsw4 = zzk;
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
                    return Byte.valueOf(this.zzi);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzi = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzal zzal = new zzal();
            zzj = zzal;
            zzrb.zza(zzal.class, zzal);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzam extends zzrb<zzam, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzam zzg;
        private static volatile zzsw<zzam> zzh;
        private int zzc;
        private int zzd;
        private String zze = "";
        private String zzf = "";

        private zzam() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzam, zza> implements zzso {
            private zza() {
                super(zzam.zzg);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzam>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzam> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzam();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"zzc", "zzd", zzmp.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzam> zzsw2 = zzh;
                    zzsw<zzam> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzam.class) {
                            zzsw<zzam> zzsw4 = zzh;
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
            zzam zzam = new zzam();
            zzg = zzam;
            zzrb.zza(zzam.class, zzam);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzan extends zzrb<zzan, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzan zzf;
        private static volatile zzsw<zzan> zzg;
        private int zzc;
        private boolean zzd;
        private int zze;

        private zzan() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzan, zza> implements zzso {
            private zza() {
                super(zzan.zzf);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzan>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzan> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzan();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0004\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzan> zzsw2 = zzg;
                    zzsw<zzan> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzan.class) {
                            zzsw<zzan> zzsw4 = zzg;
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
            zzan zzan = new zzan();
            zzf = zzan;
            zzrb.zza(zzan.class, zzan);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzao extends zzrb<zzao, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzao zzf;
        private static volatile zzsw<zzao> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        private zzao() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzao, zza> implements zzso {
            private zza() {
                super(zzao.zzf);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzao>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzao> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzao();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzao> zzsw2 = zzg;
                    zzsw<zzao> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzao.class) {
                            zzsw<zzao> zzsw4 = zzg;
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
            zzao zzao = new zzao();
            zzf = zzao;
            zzrb.zza(zzao.class, zzao);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzap extends zzrb<zzap, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzap zzg;
        private static volatile zzsw<zzap> zzh;
        private int zzc;
        private int zzd;
        private zzrm<String> zze = zzrb.zzk();
        private zzrm<zzaq> zzf = zzk();

        private zzap() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzap, zza> implements zzso {
            private zza() {
                super(zzap.zzg);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzap>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzap> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzap();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u0004\u0000\u0002\u001a\u0003\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", zzaq.class});
                case 4:
                    return zzg;
                case 5:
                    zzsw<zzap> zzsw2 = zzh;
                    zzsw<zzap> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzap.class) {
                            zzsw<zzap> zzsw4 = zzh;
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
            zzap zzap = new zzap();
            zzg = zzap;
            zzrb.zza(zzap.class, zzap);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzaq extends zzrb<zzaq, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzaq zzf;
        private static volatile zzsw<zzaq> zzg;
        private int zzc;
        private String zzd = "";
        private int zze;

        private zzaq() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzaq, zza> implements zzso {
            private zza() {
                super(zzaq.zzf);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzaq>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzaq> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzaq();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzaq> zzsw2 = zzg;
                    zzsw<zzaq> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzaq.class) {
                            zzsw<zzaq> zzsw4 = zzg;
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
            zzaq zzaq = new zzaq();
            zzf = zzaq;
            zzrb.zza(zzaq.class, zzaq);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzar extends zzrb<zzar, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzar zzh;
        private static volatile zzsw<zzar> zzi;
        private int zzc;
        private int zzd;
        private zzrm<String> zze = zzrb.zzk();
        private zzrm<zzas> zzf = zzk();
        private zzrm<zza> zzg = zzk();

        private zzar() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzar, zza> implements zzso {
            private zza() {
                super(zzar.zzh);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzar>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzar> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzar();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001\u0004\u0000\u0002\u001a\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", zzas.class, "zzg", zza.class});
                case 4:
                    return zzh;
                case 5:
                    zzsw<zzar> zzsw2 = zzi;
                    zzsw<zzar> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzar.class) {
                            zzsw<zzar> zzsw4 = zzi;
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
            zzar zzar = new zzar();
            zzh = zzar;
            zzrb.zza(zzar.class, zzar);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzas extends zzrb<zzas, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzas zzf;
        private static volatile zzsw<zzas> zzg;
        private int zzc;
        private String zzd = "";
        private int zze;

        private zzas() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzas, zza> implements zzso {
            private zza() {
                super(zzas.zzf);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzas>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzas> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzas();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzas> zzsw2 = zzg;
                    zzsw<zzas> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzas.class) {
                            zzsw<zzas> zzsw4 = zzg;
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
            zzas zzas = new zzas();
            zzf = zzas;
            zzrb.zza(zzas.class, zzas);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzat extends zzrb<zzat, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzat zzf;
        private static volatile zzsw<zzat> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        private zzat() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzat, zza> implements zzso {
            private zza() {
                super(zzat.zzf);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzat>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzat> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzat();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzat> zzsw2 = zzg;
                    zzsw<zzat> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzat.class) {
                            zzsw<zzat> zzsw4 = zzg;
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
            zzat zzat = new zzat();
            zzf = zzat;
            zzrb.zza(zzat.class, zzat);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzau extends zzrb<zzau, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzau zzf;
        private static volatile zzsw<zzau> zzg;
        private int zzc;
        private int zzd;
        private zzan zze;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            UNKNOWN(0),
            SEMANTIC_LOCATION_EVENTS_REGISTER(1),
            SEMANTIC_LOCATION_EVENTS_UNREGISTER(2),
            SEMANTIC_LOCATION_UPDATES_REGISTER(3),
            SEMANTIC_LOCATION_UPDATES_UNREGISTER(4),
            LAST_KNOWN_SEMANTIC_LOCATION(5),
            REPORT_CHECKIN(6);
            
            private static final zzrf<zza> zzh = null;
            private final int zzi;

            public final int zza() {
                return this.zzi;
            }

            public static zzri zzb() {
                return zzph.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzi);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zza(int i) {
                this.zzi = i;
            }

            static {
                zzh = new zzpi();
            }
        }

        private zzau() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzau, zzb> implements zzso {
            private zzb() {
                super(zzau.zzf);
            }

            /* synthetic */ zzb(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzau>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzau> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzau();
                case 2:
                    return new zzb((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzc", "zzd", zza.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzau> zzsw2 = zzg;
                    zzsw<zzau> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzau.class) {
                            zzsw<zzau> zzsw4 = zzg;
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
            zzau zzau = new zzau();
            zzf = zzau;
            zzrb.zza(zzau.class, zzau);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzb extends zzrb<zzb, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzb zze;
        private static volatile zzsw<zzb> zzf;
        private int zzc;
        private int zzd;

        private zzb() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzb, zza> implements zzso {
            private zza() {
                super(zzb.zze);
            }

            public final zza zza(int i) {
                zzb();
                ((zzb) this.zza).zzb(i);
                return this;
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public static zza zza() {
            return (zza) zze.zzf();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzb>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzb> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzb> zzsw2 = zzf;
                    zzsw<zzb> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzb.class) {
                            zzsw<zzb> zzsw4 = zzf;
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
            zzb zzb = new zzb();
            zze = zzb;
            zzrb.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzc extends zzrb<zzc, zzb> implements zzso {
        private static final zzrk<Integer, zza> zze = new zzmy();
        /* access modifiers changed from: private */
        public static final zzc zzg;
        private static volatile zzsw<zzc> zzh;
        private int zzc;
        private zzrh zzd = zzi();
        private int zzf;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            UNKNOWN(0),
            HOME(1),
            WORK(2),
            NICKNAME(3),
            INFERRED_HOME(4),
            INFERRED_WORK(5);
            
            private static final zzrf<zza> zzg = null;
            private final int zzh;

            public final int zza() {
                return this.zzh;
            }

            public static zzri zzb() {
                return zzna.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzh);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zza(int i) {
                this.zzh = i;
            }

            static {
                zzg = new zzmz();
            }
        }

        private zzc() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzc, zzb> implements zzso {
            private zzb() {
                super(zzc.zzg);
            }

            /* synthetic */ zzb(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzc>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzc> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zzb((zzml) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001e\u0002\u0004\u0000", new Object[]{"zzc", "zzd", zza.zzb(), "zzf"});
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

        /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.libraries.places.internal.zzmy, com.google.android.libraries.places.internal.zzrk<java.lang.Integer, com.google.android.libraries.places.internal.zzmm$zzc$zza>] */
        static {
            zzc zzc2 = new zzc();
            zzg = zzc2;
            zzrb.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzd extends zzrb<zzd, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzd zze;
        private static volatile zzsw<zzd> zzf;
        private int zzc;
        private int zzd;

        private zzd() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzd, zza> implements zzso {
            private zza() {
                super(zzd.zze);
            }

            public final zza zza(int i) {
                zzb();
                ((zzd) this.zza).zzb(i);
                return this;
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public static zza zza() {
            return (zza) zze.zzf();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzd>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzd> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzd> zzsw2 = zzf;
                    zzsw<zzd> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzd.class) {
                            zzsw<zzd> zzsw4 = zzf;
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
            zzd zzd2 = new zzd();
            zze = zzd2;
            zzrb.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zze extends zzrb<zze, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zze zzf;
        private static volatile zzsw<zze> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        private zze() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zze, zza> implements zzso {
            private zza() {
                super(zze.zzf);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zze>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zze> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zze> zzsw2 = zzg;
                    zzsw<zze> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zze.class) {
                            zzsw<zze> zzsw4 = zzg;
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
            zze zze2 = new zze();
            zzf = zze2;
            zzrb.zza(zze.class, zze2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzf extends zzrb<zzf, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzf zzf;
        private static volatile zzsw<zzf> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        private zzf() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzf, zza> implements zzso {
            private zza() {
                super(zzf.zzf);
            }

            public final zza zza(int i) {
                zzb();
                ((zzf) this.zza).zzb(1);
                return this;
            }

            public final zza zzb(int i) {
                zzb();
                ((zzf) this.zza).zzc(i);
                return this;
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* access modifiers changed from: private */
        public final void zzc(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        public static zza zza() {
            return (zza) zzf.zzf();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzf>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzf> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzf> zzsw2 = zzg;
                    zzsw<zzf> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzf.class) {
                            zzsw<zzf> zzsw4 = zzg;
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
            zzf zzf2 = new zzf();
            zzf = zzf2;
            zzrb.zza(zzf.class, zzf2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzg extends zzrb<zzg, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzg zzf;
        private static volatile zzsw<zzg> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        private zzg() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzg, zza> implements zzso {
            private zza() {
                super(zzg.zzf);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzg>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzg> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzc", "zzd", "zze"});
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
        public static final zzh zzi;
        private static volatile zzsw<zzh> zzj;
        private int zzc;
        private zzrh zzd = zzi();
        private zzrm<String> zze = zzrb.zzk();
        private String zzf = "";
        private boolean zzg;
        private int zzh;

        private zzh() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzh, zza> implements zzso {
            private zza() {
                super(zzh.zzi);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzh>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzh> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u0016\u0002\u001a\u0003\b\u0000\u0004\u0007\u0001\u0005\u000b\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzsw<zzh> zzsw2 = zzj;
                    zzsw<zzh> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzh.class) {
                            zzsw<zzh> zzsw4 = zzj;
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
            zzh zzh2 = new zzh();
            zzi = zzh2;
            zzrb.zza(zzh.class, zzh2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzi extends zzrb<zzi, zzc> implements zzso {
        /* access modifiers changed from: private */
        public static final zzi zzs;
        private static volatile zzsw<zzi> zzt;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private zzf zzi;
        private zzc zzj;
        private zzb zzk;
        private zzao zzl;
        private zzd zzm;
        private zze zzn;
        private zzap zzo;
        private zzat zzp;
        private zzar zzq;
        private int zzr;

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
                return zznh.zza;
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
                zze = new zzni();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNKNOWN(0),
            WLAN(1),
            MOBILE(2),
            OTHER(3);
            
            private static final zzrf<zzb> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zznj.zza;
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
                zze = new zznk();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzd implements zzrg {
            UNDEFINED(0),
            ADD_PLACE(1),
            DELETE_ALIAS(2),
            ESTIMATE_PLACES_BY_LOCATION(3),
            GET_ALIASES(4),
            GET_AUTOCOMPLETE_PREDICTIONS(5),
            GET_NEARBY_ALERT_DATA_BY_ID(6),
            GET_PLACE_BY_ID(7),
            GET_PLACE_PHOTO_METADATA(8),
            SEARCH(9),
            SEARCH_BY_BEACON(10),
            SEARCH_BY_CHAIN(11),
            WRITE_ALIAS(12),
            SEARCH_BY_CLIENT(13),
            GET_PHOTO(14),
            SNAP_TO_PLACE(15);
            
            private static final zzrf<zzd> zzq = null;
            private final int zzr;

            public final int zza() {
                return this.zzr;
            }

            public static zzri zzb() {
                return zznm.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzr);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzd(int i) {
                this.zzr = i;
            }

            static {
                zzq = new zznl();
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
                return zznn.zza;
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
                zzd = new zzno();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzf implements zzrg {
            INVALID(0),
            SUCCESS(1),
            TIMEOUT(2),
            NETWORK_ERROR(3);
            
            private static final zzrf<zzf> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zznq.zza;
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
                zze = new zznp();
            }
        }

        private zzi() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzc extends zzrb.zzb<zzi, zzc> implements zzso {
            private zzc() {
                super(zzi.zzs);
            }

            public final zzc zza(zzd zzd) {
                zzb();
                ((zzi) this.zza).zza(zzd);
                return this;
            }

            public final zzc zza(zzf zzf) {
                zzb();
                ((zzi) this.zza).zza(zzf);
                return this;
            }

            public final zzc zza(int i) {
                zzb();
                ((zzi) this.zza).zzb(i);
                return this;
            }

            public final zzc zza(zzf zzf) {
                zzb();
                ((zzi) this.zza).zza(zzf);
                return this;
            }

            public final zzc zza(zzb zzb) {
                zzb();
                ((zzi) this.zza).zza(zzb);
                return this;
            }

            public final zzc zza(zzd zzd) {
                zzb();
                ((zzi) this.zza).zza(zzd);
                return this;
            }

            /* synthetic */ zzc(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd2) {
            if (zzd2 != null) {
                this.zzc |= 1;
                this.zzd = zzd2.zza();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzf zzf2) {
            if (zzf2 != null) {
                this.zzc |= 2;
                this.zze = zzf2.zza();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 4;
            this.zzf = i;
        }

        /* access modifiers changed from: private */
        public final void zza(zzf zzf2) {
            if (zzf2 != null) {
                this.zzi = zzf2;
                this.zzc |= 32;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzb zzb2) {
            if (zzb2 != null) {
                this.zzk = zzb2;
                this.zzc |= 128;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd2) {
            if (zzd2 != null) {
                this.zzm = zzd2;
                this.zzc |= ConstantsKt.MINIMUM_BLOCK_SIZE;
                return;
            }
            throw new NullPointerException();
        }

        public static zzc zza() {
            return (zzc) zzs.zzf();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzi>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzi> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zzc((zzml) null);
                case 3:
                    return zza((zzsm) zzs, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\f\u0003\u0005\f\u0004\u0006\t\u0005\u0007\t\u0006\b\t\u0007\t\t\b\n\t\t\u000b\t\n\f\t\u000b\r\t\f\u000e\t\r\u000f\f\u000e", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzf.zzb(), "zzf", "zzg", zzb.zzb(), "zzh", zza.zzb(), "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", zze.zzb()});
                case 4:
                    return zzs;
                case 5:
                    zzsw<zzi> zzsw2 = zzt;
                    zzsw<zzi> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzi.class) {
                            zzsw<zzi> zzsw4 = zzt;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzs);
                                zzt = zza2;
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
            zzs = zzi2;
            zzrb.zza(zzi.class, zzi2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzj extends zzrb<zzj, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzj zzg;
        private static volatile zzsw<zzj> zzh;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private int zzf;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            UNKNOWN(0),
            USER_REPORTED(1),
            INFERRED(2),
            INFERRED_GEOFENCING(33),
            INFERRED_RADIO_SIGNALS(34),
            INFERRED_REVERSE_GEOCODING(35),
            INFERRED_SNAPPED_TO_ROAD(36);
            
            private static final zzrf<zza> zzh = null;
            private final int zzi;

            public final int zza() {
                return this.zzi;
            }

            public static zzri zzb() {
                return zznr.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzi);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zza(int i) {
                this.zzi = i;
            }

            static {
                zzh = new zzns();
            }
        }

        private zzj() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzj, zzb> implements zzso {
            private zzb() {
                super(zzj.zzg);
            }

            /* synthetic */ zzb(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzj>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzj> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zzb((zzml) null);
                case 3:
                    return zza((zzsm) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\f\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zza.zzb()});
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
        public static final zzk zzj;
        private static volatile zzsw<zzk> zzk;
        private int zzc;
        private int zzd;
        private zzrm<String> zze = zzrb.zzk();
        private String zzf = "";
        private String zzg = "";
        private boolean zzh;
        private zzrm<String> zzi = zzrb.zzk();

        private zzk() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzk, zza> implements zzso {
            private zza() {
                super(zzk.zzj);
            }

            public final zza zza(String str) {
                zzb();
                ((zzk) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                if (!this.zze.zza()) {
                    this.zze = zzrb.zza(this.zze);
                }
                this.zze.add(str);
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzj.zzf();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzk>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzk> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0004\u0000\u0002\u001a\u0003\b\u0001\u0004\b\u0002\u0005\u0007\u0003\u0006\u001a", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzsw<zzk> zzsw2 = zzk;
                    zzsw<zzk> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzk.class) {
                            zzsw<zzk> zzsw4 = zzk;
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
            zzk zzk2 = new zzk();
            zzj = zzk2;
            zzrb.zza(zzk.class, zzk2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzl extends zzrb<zzl, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzl zzo;
        private static volatile zzsw<zzl> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private zzk zzf;
        private zzjt.zzb zzg;
        private int zzh = 1;
        private String zzi = "";
        private int zzj;
        private int zzk;
        private String zzl = "";
        private int zzm;
        private byte zzn = 2;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            MODE_EXPLORATION(1),
            MODE_CHECK_IN(2);
            
            private static final zzrf<zzb> zzc = null;
            private final int zzd;

            public final int zza() {
                return this.zzd;
            }

            public static zzri zzb() {
                return zznu.zza;
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
                zzc = new zznt();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzc implements zzrg {
            SEARCH(0),
            GET_CURRENT_PLACE_DEPRECATED(1),
            GET_CURRENT_PLACE_FROM_SERVER(2),
            GET_CURRENT_PLACE_FROM_DEVICE(3);
            
            private static final zzrf<zzc> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zznv.zza;
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
                zze = new zznw();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzd implements zzrg {
            PLACE_SELECTION_NONE(0),
            PLACE_SELECTION_SELECT_THIS_LOCATION(1),
            PLACE_SELECTION_FROM_NEARBY_LIST(2),
            PLACE_SELECTION_FROM_SEARCH_RESULTS(3),
            PLACE_SELECTION_ADD_A_PLACE(4);
            
            private static final zzrf<zzd> zzf = null;
            private final int zzg;

            public final int zza() {
                return this.zzg;
            }

            public static zzri zzb() {
                return zzny.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzg);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzd(int i) {
                this.zzg = i;
            }

            static {
                zzf = new zznx();
            }
        }

        private zzl() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzl, zza> implements zzso {
            private zza() {
                super(zzl.zzo);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzl>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzl> zzsw;
            int i2 = 1;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzo, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001\b\u0000\u0002\b\u0001\u0003\t\u0002\u0004Љ\u0003\u0005\f\u0004\u0006\b\u0005\u0007\f\u0006\b\u0004\u0007\t\b\b\n\f\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzb.zzb(), "zzi", "zzj", zzd.zzb(), "zzk", "zzl", "zzm", zzc.zzb()});
                case 4:
                    return zzo;
                case 5:
                    zzsw<zzl> zzsw2 = zzp;
                    zzsw<zzl> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzl.class) {
                            zzsw<zzl> zzsw4 = zzp;
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
                    return Byte.valueOf(this.zzn);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzn = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzl zzl2 = new zzl();
            zzo = zzl2;
            zzrb.zza(zzl.class, zzl2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzm extends zzrb<zzm, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzm zze;
        private static volatile zzsw<zzm> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            SOURCE_UNKNOWN(0),
            BY_GEOFENCE_EVENT(1),
            BY_LOCATION_UPDATE_PREV_LOCATION_UNKONWN(2),
            BY_LOCATION_UPDATE_MISS_GEOFENCE_UPDATE(3),
            BY_LOCATION_UPDATE_WHEN_NO_POWER(4);
            
            private static final zzrf<zza> zzf = null;
            private final int zzg;

            public final int zza() {
                return this.zzg;
            }

            public static zzri zzb() {
                return zznz.zza;
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
                zzf = new zzoa();
            }
        }

        private zzm() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzm, zzb> implements zzso {
            private zzb() {
                super(zzm.zze);
            }

            /* synthetic */ zzb(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzm>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzm> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zzb((zzml) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzc", "zzd", zza.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzm> zzsw2 = zzf;
                    zzsw<zzm> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzm.class) {
                            zzsw<zzm> zzsw4 = zzf;
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
            zzm zzm = new zzm();
            zze = zzm;
            zzrb.zza(zzm.class, zzm);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzn extends zzrb<zzn, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzn zzk;
        private static volatile zzsw<zzn> zzl;
        private int zzc;
        private String zzd = "";
        private zzjt.zza zze;
        private String zzf = "";
        private zzrm<String> zzg = zzrb.zzk();
        private String zzh = "";
        private String zzi = "";
        private byte zzj = 2;

        private zzn() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzn, zza> implements zzso {
            private zza() {
                super(zzn.zzk);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzn>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzn> zzsw;
            int i2 = 1;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\b\u0000\u0002Љ\u0001\u0003\b\u0002\u0004\u001a\u0005\b\u0003\u0006\b\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzk;
                case 5:
                    zzsw<zzn> zzsw2 = zzl;
                    zzsw<zzn> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzn.class) {
                            zzsw<zzn> zzsw4 = zzl;
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
                    return Byte.valueOf(this.zzj);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzj = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzn zzn = new zzn();
            zzk = zzn;
            zzrb.zza(zzn.class, zzn);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzo extends zzrb<zzo, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzo zzh;
        private static volatile zzsw<zzo> zzi;
        private int zzc;
        private String zzd = "";
        private zzjt.zzb zze;
        private zzk zzf;
        private byte zzg = 2;

        private zzo() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzo, zza> implements zzso {
            private zza() {
                super(zzo.zzh);
            }

            public final zza zza(zzk zzk) {
                zzb();
                ((zzo) this.zza).zza(zzk);
                return this;
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzk zzk) {
            if (zzk != null) {
                this.zzf = zzk;
                this.zzc |= 4;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzh.zzf();
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzo>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzo> zzsw;
            int i2 = 1;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001\b\u0000\u0002Љ\u0001\u0003\t\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzh;
                case 5:
                    zzsw<zzo> zzsw2 = zzi;
                    zzsw<zzo> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzo.class) {
                            zzsw<zzo> zzsw4 = zzi;
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
                    return Byte.valueOf(this.zzg);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzg = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzo zzo = new zzo();
            zzh = zzo;
            zzrb.zza(zzo.class, zzo);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzp extends zzrb<zzp, zzc> implements zzso {
        /* access modifiers changed from: private */
        public static final zzp zzt;
        private static volatile zzsw<zzp> zzu;
        private int zzc;
        private int zzd;
        private int zze = 1;
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;
        private int zzi;
        private int zzj;
        private int zzk;
        private int zzl;
        private int zzm;
        private int zzn;
        private int zzo;
        private boolean zzp;
        private int zzq;
        private int zzr;
        private int zzs;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            OVERLAY(1),
            FULLSCREEN(2);
            
            private static final zzrf<zza> zzc = null;
            private final int zzd;

            public final int zza() {
                return this.zzd;
            }

            public static zzri zzb() {
                return zzob.zza;
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
                zzc = new zzoc();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNKNOWN(0),
            YES(1),
            NO(2);
            
            private static final zzrf<zzb> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzod.zza;
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
                zzd = new zzoe();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzd implements zzrg {
            UNKNOWN_ORIGIN(0),
            ANDROID_AUTOCOMPLETE_FRAGMENT(1),
            ANDROID_AUTOCOMPLETE_MANUAL_LAUNCHER(2),
            ANDROID_PLACE_PICKER(3),
            ANDROID_ADAPTER(4),
            IOS_AUTOCOMPLETE_VIEW_CONTROLLER(5),
            IOS_AUTOCOMPLETE_SEARCH_CONTROLLER(6),
            IOS_AUTOCOMPLETE_DATA_SOURCE(7),
            IOS_PLACE_PICKER(8);
            
            private static final zzrf<zzd> zzj = null;
            private final int zzk;

            public final int zza() {
                return this.zzk;
            }

            public static zzri zzb() {
                return zzog.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzk);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzd(int i) {
                this.zzk = i;
            }

            static {
                zzj = new zzof();
            }
        }

        private zzp() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzc extends zzrb.zzb<zzp, zzc> implements zzso {
            private zzc() {
                super(zzp.zzt);
            }

            public final zzc zza(zzd zzd) {
                zzb();
                ((zzp) this.zza).zza(zzd);
                return this;
            }

            public final zzc zza(zza zza) {
                zzb();
                ((zzp) this.zza).zza(zza);
                return this;
            }

            public final zzc zza(boolean z) {
                zzb();
                ((zzp) this.zza).zza(z);
                return this;
            }

            public final zzc zzb(boolean z) {
                zzb();
                ((zzp) this.zza).zzb(z);
                return this;
            }

            public final zzc zzc(boolean z) {
                zzb();
                ((zzp) this.zza).zzc(z);
                return this;
            }

            public final zzc zza(int i) {
                zzb();
                ((zzp) this.zza).zzb(i);
                return this;
            }

            public final zzc zzb(int i) {
                zzb();
                ((zzp) this.zza).zzc(i);
                return this;
            }

            public final zzc zzc(int i) {
                zzb();
                ((zzp) this.zza).zzd(i);
                return this;
            }

            public final zzc zzd(int i) {
                zzb();
                ((zzp) this.zza).zze(i);
                return this;
            }

            public final zzc zze(int i) {
                zzb();
                ((zzp) this.zza).zzf(i);
                return this;
            }

            public final zzc zzf(int i) {
                zzb();
                ((zzp) this.zza).zzg(i);
                return this;
            }

            public final zzc zzg(int i) {
                zzb();
                ((zzp) this.zza).zzh(i);
                return this;
            }

            public final zzc zzd(boolean z) {
                zzb();
                ((zzp) this.zza).zzd(z);
                return this;
            }

            public final zzc zzh(int i) {
                zzb();
                ((zzp) this.zza).zzi(i);
                return this;
            }

            /* synthetic */ zzc(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd2) {
            if (zzd2 != null) {
                this.zzc |= 1;
                this.zzd = zzd2.zza();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            if (zza2 != null) {
                this.zzc |= 2;
                this.zze = zza2.zza();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 4;
            this.zzf = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        /* access modifiers changed from: private */
        public final void zzc(boolean z) {
            this.zzc |= 16;
            this.zzh = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 32;
            this.zzi = i;
        }

        /* access modifiers changed from: private */
        public final void zzc(int i) {
            this.zzc |= 64;
            this.zzj = i;
        }

        /* access modifiers changed from: private */
        public final void zzd(int i) {
            this.zzc |= 128;
            this.zzk = i;
        }

        /* access modifiers changed from: private */
        public final void zze(int i) {
            this.zzc |= 256;
            this.zzl = i;
        }

        /* access modifiers changed from: private */
        public final void zzf(int i) {
            this.zzc |= ConstantsKt.MINIMUM_BLOCK_SIZE;
            this.zzm = i;
        }

        /* access modifiers changed from: private */
        public final void zzg(int i) {
            this.zzc |= LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY;
            this.zzn = i;
        }

        /* access modifiers changed from: private */
        public final void zzh(int i) {
            this.zzc |= 2048;
            this.zzo = i;
        }

        /* access modifiers changed from: private */
        public final void zzd(boolean z) {
            this.zzc |= ConstantsKt.DEFAULT_BLOCK_SIZE;
            this.zzp = z;
        }

        /* access modifiers changed from: private */
        public final void zzi(int i) {
            this.zzc |= ConstantsKt.DEFAULT_BUFFER_SIZE;
            this.zzq = i;
        }

        public static zzc zza() {
            return (zzc) zzt.zzf();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzp>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzp> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zzc((zzml) null);
                case 3:
                    return zza((zzsm) zzt, "\u0001\u0010\u0000\u0001\u0001\u0011\u0010\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0007\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u000b\u0005\u0007\u000b\u0006\b\u000b\u0007\n\u000b\t\u000b\u000b\n\f\u000b\u000b\r\u0007\f\u000e\u000b\r\u000f\u000b\b\u0010\u000b\u000e\u0011\f\u000f", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zza.zzb(), "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzm", "zzn", "zzo", "zzp", "zzq", "zzl", "zzr", "zzs", zzb.zzb()});
                case 4:
                    return zzt;
                case 5:
                    zzsw<zzp> zzsw2 = zzu;
                    zzsw<zzp> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzp.class) {
                            zzsw<zzp> zzsw4 = zzu;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzt);
                                zzu = zza2;
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
            zzp zzp2 = new zzp();
            zzt = zzp2;
            zzrb.zza(zzp.class, zzp2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzq extends zzrb<zzq, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzq zzf;
        private static volatile zzsw<zzq> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            METHOD_UNKNOWN(0),
            METHOD_PHOTO_IMAGE(1),
            METHOD_PLACE_PICKER(2);
            
            private static final zzrf<zza> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzoh.zza;
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
                zzd = new zzoi();
            }
        }

        private zzq() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzq, zzb> implements zzso {
            private zzb() {
                super(zzq.zzf);
            }

            /* synthetic */ zzb(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzq>, com.google.android.libraries.places.internal.zzrb$zza] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzq> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zzb((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\u000b\u0001", new Object[]{"zzc", "zzd", zza.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzq> zzsw2 = zzg;
                    zzsw<zzq> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzq.class) {
                            zzsw<zzq> zzsw4 = zzg;
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
            zzq zzq = new zzq();
            zzf = zzq;
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

        private zzr() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzr, zza> implements zzso {
            private zza() {
                super(zzr.zze);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzr>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzr> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzc", "zzd", zzmp.zzb()});
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
    public static final class zzs extends zzrb<zzs, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzs zzak;
        private static volatile zzsw<zzs> zzal;
        private boolean zzaa;
        private String zzab = "";
        private zzi zzac;
        private boolean zzad;
        private String zzae = "";
        private int zzaf;
        private String zzag = "";
        private String zzah = "";
        private int zzai;
        private byte zzaj = 2;
        private int zzc;
        private int zzd;
        private int zze = 1;
        private zzhx.zza zzf;
        private zzjt.zza zzg;
        private int zzh;
        private float zzi;
        private zzrm<zzpl.zza> zzj = zzk();
        private zzah zzk;
        private zzrm<zzj> zzl = zzk();
        private zzj zzm;
        private zzl zzn;
        private zzae zzo;
        private zzy zzp;
        private zzab zzq;
        private zzaa zzr;
        private zzag zzs;
        private zzp zzt;
        private zzt zzu;
        private zzac zzv;
        private zzq zzw;
        private zzm zzx;
        private zzg zzy;
        private zzau zzz;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzb implements zzrg {
            UNKNOWN(0),
            GPS(1),
            WIFI(2),
            CELL(3);
            
            private static final zzrf<zzb> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzok.zza;
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
                zze = new zzoj();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzc implements zzrg {
            PLACES_QUERY(1),
            PLACE_OBJECT_ACCESS(2),
            PLACE_REPORT(3),
            PLACE_PICKER_RESULT(4),
            PLACE_PHOTO_QUERY(5),
            GET_CURRENT_PLACE(6),
            NEARBY_ALERT_REQUEST(7),
            NEARBY_ALERT(8),
            PLACE_UPDATE_REQUEST(9),
            AUTOCOMPLETE_WIDGET_SESSION(10),
            GEOFENCE_STATUS(11),
            SERVER_RESPONSE(12),
            COUNT_OPERATION(13),
            PLACES_BOUNDS_REFRESH(14),
            HAS_PERSONALIZED_DATA_ACCESS(15),
            NETWORK_REQUEST_EVENT(16),
            SEMANTIC_LOCATION_PROVIDER_EVENT(17);
            
            private static final zzrf<zzc> zzr = null;
            private final int zzs;

            public final int zza() {
                return this.zzs;
            }

            public static zzri zzb() {
                return zzol.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzs);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zzc(int i) {
                this.zzs = i;
            }

            static {
                zzr = new zzom();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zzd implements zzrg {
            UNKNOWN_PLATFORM(0),
            ANDROID(1),
            IOS(2);
            
            private static final zzrf<zzd> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzoo.zza;
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
                zzd = new zzon();
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zze implements zzrg {
            UNKNOWN_SOURCE(0),
            PROGRAMMATIC_API(1),
            PLACE_PICKER(2),
            AUTOCOMPLETE_WIDGET(3);
            
            private static final zzrf<zze> zze = null;
            private final int zzf;

            public final int zza() {
                return this.zzf;
            }

            public static zzri zzb() {
                return zzop.zza;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("<");
                sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" number=").append(this.zzf);
                return sb.append(" name=").append(name()).append(Typography.greater).toString();
            }

            private zze(int i) {
                this.zzf = i;
            }

            static {
                zze = new zzoq();
            }
        }

        private zzs() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzs, zza> implements zzso {
            private zza() {
                super(zzs.zzak);
            }

            public final zza zza(zzc zzc) {
                zzb();
                ((zzs) this.zza).zza(zzc);
                return this;
            }

            public final zza zza(zzhx.zza zza) {
                zzb();
                ((zzs) this.zza).zza(zza);
                return this;
            }

            public final zza zza(zzah zzah) {
                zzb();
                ((zzs) this.zza).zza(zzah);
                return this;
            }

            public final zza zza(zzae zzae) {
                zzb();
                ((zzs) this.zza).zza(zzae);
                return this;
            }

            public final zza zza(zzy zzy) {
                zzb();
                ((zzs) this.zza).zza(zzy);
                return this;
            }

            public final zza zza(zzp zzp) {
                zzb();
                ((zzs) this.zza).zza(zzp);
                return this;
            }

            public final zza zza(zzi zzi) {
                zzb();
                ((zzs) this.zza).zza(zzi);
                return this;
            }

            public final zza zza(boolean z) {
                zzb();
                ((zzs) this.zza).zza(true);
                return this;
            }

            public final zza zza(String str) {
                zzb();
                ((zzs) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzb();
                ((zzs) this.zza).zzb(str);
                return this;
            }

            public final zza zza(zze zze) {
                zzb();
                ((zzs) this.zza).zza(zze);
                return this;
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            if (zzc2 != null) {
                this.zzc |= 2;
                this.zze = zzc2.zza();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzhx.zza zza2) {
            if (zza2 != null) {
                this.zzf = zza2;
                this.zzc |= 4;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzah zzah2) {
            if (zzah2 != null) {
                this.zzk = zzah2;
                this.zzc |= 64;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzae zzae2) {
            if (zzae2 != null) {
                this.zzo = zzae2;
                this.zzc |= ConstantsKt.MINIMUM_BLOCK_SIZE;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzy zzy2) {
            if (zzy2 != null) {
                this.zzp = zzy2;
                this.zzc |= LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzp zzp2) {
            if (zzp2 != null) {
                this.zzt = zzp2;
                this.zzc |= 16384;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi2) {
            if (zzi2 != null) {
                this.zzac = zzi2;
                this.zzc |= 8388608;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 16777216;
            this.zzad = z;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 33554432;
                this.zzae = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 134217728;
                this.zzag = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zze zze2) {
            if (zze2 != null) {
                this.zzc |= 536870912;
                this.zzai = zze2.zza();
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzak.zzf();
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzs>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzs> zzsw;
            int i2 = 1;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzak, "\u0001 \u0000\u0001\u0001  \u0000\u0002\u0003\u0001\f\u0001\u0002\t\u0002\u0003Љ\u0003\u0004\u001b\u0005Љ\u0006\u0006\u001b\u0007\t\u0007\bЉ\b\t\f\u0004\n\u0001\u0005\u000b\u0007\u0015\f\t\t\r\b\u0016\u000e\t\n\u000f\t\u000b\u0010\t\f\u0011\t\r\u0012\t\u000e\u0013\t\u000f\u0014\t\u0010\u0015\t\u0011\u0016\t\u0012\u0017\t\u0013\u0018\t\u0017\u0019\u0004\u0000\u001a\t\u0014\u001b\u0007\u0018\u001c\b\u0019\u001d\f\u001a\u001e\b\u001b\u001f\b\u001c \f\u001d", new Object[]{"zzc", "zze", zzc.zzb(), "zzf", "zzg", "zzj", zzpl.zza.class, "zzk", "zzl", zzj.class, "zzm", "zzn", "zzh", zzb.zzb(), "zzi", "zzaa", "zzo", "zzab", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzac", "zzd", "zzz", "zzad", "zzae", "zzaf", zzd.zzb(), "zzag", "zzah", "zzai", zze.zzb()});
                case 4:
                    return zzak;
                case 5:
                    zzsw<zzs> zzsw2 = zzal;
                    zzsw<zzs> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzs.class) {
                            zzsw<zzs> zzsw4 = zzal;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzak);
                                zzal = zza2;
                                zzsw = zza2;
                            }
                        }
                        zzsw3 = zzsw;
                    }
                    return zzsw3;
                case 6:
                    return Byte.valueOf(this.zzaj);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzaj = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzs zzs2 = new zzs();
            zzak = zzs2;
            zzrb.zza(zzs.class, zzs2);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzt extends zzrb<zzt, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzt zzi;
        private static volatile zzsw<zzt> zzj;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;

        private zzt() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzt, zza> implements zzso {
            private zza() {
                super(zzt.zzi);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzt>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzt> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u000b\u0000\u0002\u000b\u0001\u0003\u000b\u0002\u0004\u000b\u0003\u0005\f\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzmv.zzb()});
                case 4:
                    return zzi;
                case 5:
                    zzsw<zzt> zzsw2 = zzj;
                    zzsw<zzt> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzt.class) {
                            zzsw<zzt> zzsw4 = zzj;
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
            zzt zzt = new zzt();
            zzi = zzt;
            zzrb.zza(zzt.class, zzt);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzu extends zzrb<zzu, zza> implements zzso {
        private static final zzrk<Integer, zzmp> zzd = new zzor();
        /* access modifiers changed from: private */
        public static final zzu zze;
        private static volatile zzsw<zzu> zzf;
        private zzrh zzc = zzi();

        private zzu() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzu, zza> implements zzso {
            private zza() {
                super(zzu.zze);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzu>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzu> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzc", zzmp.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzu> zzsw2 = zzf;
                    zzsw<zzu> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzu.class) {
                            zzsw<zzu> zzsw4 = zzf;
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

        /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.libraries.places.internal.zzrk<java.lang.Integer, com.google.android.libraries.places.internal.zzmp>, com.google.android.libraries.places.internal.zzor] */
        static {
            zzu zzu = new zzu();
            zze = zzu;
            zzrb.zza(zzu.class, zzu);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzv extends zzrb<zzv, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzv zzh;
        private static volatile zzsw<zzv> zzi;
        private int zzc;
        private zzrm<String> zzd = zzrb.zzk();
        private int zze;
        private int zzf;
        private zzaf zzg;

        private zzv() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzv, zza> implements zzso {
            private zza() {
                super(zzv.zzh);
            }

            public final zza zza(int i) {
                zzb();
                ((zzv) this.zza).zzb(1);
                return this;
            }

            public final zza zza(zzaf zzaf) {
                zzb();
                ((zzv) this.zza).zza(zzaf);
                return this;
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 2;
            this.zzf = i;
        }

        /* access modifiers changed from: private */
        public final void zza(zzaf zzaf) {
            if (zzaf != null) {
                this.zzg = zzaf;
                this.zzc |= 4;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzh.zzf();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzv>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzv> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001a\u0002\f\u0000\u0003\u000b\u0001\u0004\t\u0002", new Object[]{"zzc", "zzd", "zze", zznc.zzb(), "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzsw<zzv> zzsw2 = zzi;
                    zzsw<zzv> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzv.class) {
                            zzsw<zzv> zzsw4 = zzi;
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
            zzv zzv = new zzv();
            zzh = zzv;
            zzrb.zza(zzv.class, zzv);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzw extends zzrb<zzw, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzw zzf;
        private static volatile zzsw<zzw> zzg;
        private int zzc;
        private zzjt.zza zzd;
        private byte zze = 2;

        private zzw() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzw, zza> implements zzso {
            private zza() {
                super(zzw.zzf);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzw>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzw> zzsw;
            int i2 = 1;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001Љ\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zzf;
                case 5:
                    zzsw<zzw> zzsw2 = zzg;
                    zzsw<zzw> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzw.class) {
                            zzsw<zzw> zzsw4 = zzg;
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
                    return Byte.valueOf(this.zze);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zze = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzw zzw = new zzw();
            zzf = zzw;
            zzrb.zza(zzw.class, zzw);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzx extends zzrb<zzx, zza> implements zzso {
        /* access modifiers changed from: private */
        public static final zzx zzc;
        private static volatile zzsw<zzx> zzd;

        private zzx() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzx, zza> implements zzso {
            private zza() {
                super(zzx.zzc);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r1v13, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzx>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzx> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzx();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zzc, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzc;
                case 5:
                    zzsw<zzx> zzsw2 = zzd;
                    zzsw<zzx> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzx.class) {
                            zzsw<zzx> zzsw4 = zzd;
                            zzsw = zzsw4;
                            if (zzsw4 == null) {
                                ? zza2 = new zzrb.zza(zzc);
                                zzd = zza2;
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
            zzx zzx = new zzx();
            zzc = zzx;
            zzrb.zza(zzx.class, zzx);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzy extends zzrb<zzy, zzb> implements zzso {
        /* access modifiers changed from: private */
        public static final zzy zzh;
        private static volatile zzsw<zzy> zzi;
        private int zzc;
        private zzk zzd;
        private int zze;
        private int zzf;
        private zzaf zzg;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public enum zza implements zzrg {
            NO_RESULT(0),
            NEARBY_SEARCH(1),
            ON_DEVICE_INFERENCE(2);
            
            private static final zzrf<zza> zzd = null;
            private final int zze;

            public final int zza() {
                return this.zze;
            }

            public static zzri zzb() {
                return zzos.zza;
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
                zzd = new zzot();
            }
        }

        private zzy() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zzb extends zzrb.zzb<zzy, zzb> implements zzso {
            private zzb() {
                super(zzy.zzh);
            }

            public final zzb zza(zza zza) {
                zzb();
                ((zzy) this.zza).zza(zza);
                return this;
            }

            public final zzb zza(int i) {
                zzb();
                ((zzy) this.zza).zzb(i);
                return this;
            }

            public final zzb zza(zzaf zzaf) {
                zzb();
                ((zzy) this.zza).zza(zzaf);
                return this;
            }

            /* synthetic */ zzb(zzml zzml) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            if (zza2 != null) {
                this.zzc |= 2;
                this.zze = zza2.zza();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 4;
            this.zzf = i;
        }

        /* access modifiers changed from: private */
        public final void zza(zzaf zzaf) {
            if (zzaf != null) {
                this.zzg = zzaf;
                this.zzc |= 8;
                return;
            }
            throw new NullPointerException();
        }

        public static zzb zza() {
            return (zzb) zzh.zzf();
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzy>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzy> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzy();
                case 2:
                    return new zzb((zzml) null);
                case 3:
                    return zza((zzsm) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\t\u0003", new Object[]{"zzc", "zzd", "zze", zza.zzb(), "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzsw<zzy> zzsw2 = zzi;
                    zzsw<zzy> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzy.class) {
                            zzsw<zzy> zzsw4 = zzi;
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
            zzy zzy = new zzy();
            zzh = zzy;
            zzrb.zza(zzy.class, zzy);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzz extends zzrb<zzz, zza> implements zzso {
        private static final zzrk<Integer, zzpk> zzd = new zzou();
        /* access modifiers changed from: private */
        public static final zzz zze;
        private static volatile zzsw<zzz> zzf;
        private zzrh zzc = zzi();

        private zzz() {
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        public static final class zza extends zzrb.zzb<zzz, zza> implements zzso {
            private zza() {
                super(zzz.zze);
            }

            /* synthetic */ zza(zzml zzml) {
                this();
            }
        }

        /* JADX WARNING: type inference failed for: r2v14, types: [com.google.android.libraries.places.internal.zzrb$zza, com.google.android.libraries.places.internal.zzsw<com.google.android.libraries.places.internal.zzmm$zzz>] */
        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            zzsw<zzz> zzsw;
            switch (zzml.zza[i - 1]) {
                case 1:
                    return new zzz();
                case 2:
                    return new zza((zzml) null);
                case 3:
                    return zza((zzsm) zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzc", zzpk.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzsw<zzz> zzsw2 = zzf;
                    zzsw<zzz> zzsw3 = zzsw2;
                    if (zzsw2 == null) {
                        synchronized (zzz.class) {
                            zzsw<zzz> zzsw4 = zzf;
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

        /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.libraries.places.internal.zzou, com.google.android.libraries.places.internal.zzrk<java.lang.Integer, com.google.android.libraries.places.internal.zzpk>] */
        static {
            zzz zzz = new zzz();
            zze = zzz;
            zzrb.zza(zzz.class, zzz);
        }
    }
}
