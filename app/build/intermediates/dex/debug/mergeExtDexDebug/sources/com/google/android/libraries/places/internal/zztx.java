package com.google.android.libraries.places.internal;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.KotlinVersion;
import sun.misc.Unsafe;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zztx {
    static final boolean zza = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    private static final Logger zzb = Logger.getLogger(zztx.class.getName());
    private static final Unsafe zzc;
    private static final Class<?> zzd = zzpy.zzb();
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzd zzg;
    private static final boolean zzh = zze();
    private static final boolean zzi = zzd();
    private static final long zzj;
    private static final long zzk;
    private static final long zzl;
    private static final long zzm;
    private static final long zzn;
    private static final long zzo;
    private static final long zzp;
    private static final long zzq;
    private static final long zzr;
    private static final long zzs;
    private static final long zzt;
    private static final long zzu = ((long) zzb(Object[].class));
    private static final long zzv = ((long) zzc(Object[].class));
    private static final long zzw;
    private static final int zzx;

    private zztx() {
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zza(Object obj, long j) {
            if (zztx.zza) {
                return zztx.zzk(obj, j);
            }
            return zztx.zzl(obj, j);
        }

        public final void zza(Object obj, long j, byte b) {
            if (zztx.zza) {
                zztx.zzc(obj, j, b);
            } else {
                zztx.zzd(obj, j, b);
            }
        }

        public final boolean zzb(Object obj, long j) {
            if (zztx.zza) {
                return zztx.zzm(obj, j);
            }
            return zztx.zzn(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zztx.zza) {
                zztx.zzd(obj, j, z);
            } else {
                zztx.zze(obj, j, z);
            }
        }

        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zza(Object obj, long j) {
            return this.zza.getByte(obj, j);
        }

        public final void zza(Object obj, long j, byte b) {
            this.zza.putByte(obj, j, b);
        }

        public final boolean zzb(Object obj, long j) {
            return this.zza.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zza.putBoolean(obj, j, z);
        }

        public final float zzc(Object obj, long j) {
            return this.zza.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zza.putFloat(obj, j, f);
        }

        public final double zzd(Object obj, long j) {
            return this.zza.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zza.putDouble(obj, j, d);
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zza(Object obj, long j) {
            if (zztx.zza) {
                return zztx.zzk(obj, j);
            }
            return zztx.zzl(obj, j);
        }

        public final void zza(Object obj, long j, byte b) {
            if (zztx.zza) {
                zztx.zzc(obj, j, b);
            } else {
                zztx.zzd(obj, j, b);
            }
        }

        public final boolean zzb(Object obj, long j) {
            if (zztx.zza) {
                return zztx.zzm(obj, j);
            }
            return zztx.zzn(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zztx.zza) {
                zztx.zzd(obj, j, z);
            } else {
                zztx.zze(obj, j, z);
            }
        }

        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static boolean zza() {
        return zzi;
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    static abstract class zzd {
        Unsafe zza;

        zzd(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public abstract byte zza(Object obj, long j);

        public abstract void zza(Object obj, long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract boolean zzb(Object obj, long j);

        public abstract float zzc(Object obj, long j);

        public abstract double zzd(Object obj, long j);

        public final int zze(Object obj, long j) {
            return this.zza.getInt(obj, j);
        }

        public final void zza(Object obj, long j, int i) {
            this.zza.putInt(obj, j, i);
        }

        public final long zzf(Object obj, long j) {
            return this.zza.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zza.putLong(obj, j, j2);
        }
    }

    static boolean zzb() {
        return zzh;
    }

    static <T> T zza(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzb(Class<?> cls) {
        if (zzi) {
            return zzg.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzc(Class<?> cls) {
        if (zzi) {
            return zzg.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zza(Object obj, long j) {
        return zzg.zze(obj, j);
    }

    static void zza(Object obj, long j, int i) {
        zzg.zza(obj, j, i);
    }

    static long zzb(Object obj, long j) {
        return zzg.zzf(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzg.zza(obj, j, j2);
    }

    static boolean zzc(Object obj, long j) {
        return zzg.zzb(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzg.zza(obj, j, z);
    }

    static float zzd(Object obj, long j) {
        return zzg.zzc(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzg.zza(obj, j, f);
    }

    static double zze(Object obj, long j) {
        return zzg.zzd(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzg.zza(obj, j, d);
    }

    static Object zzf(Object obj, long j) {
        return zzg.zza.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzg.zza.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzg.zza(bArr, zzj + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzg.zza((Object) bArr, zzj + j, b);
    }

    static Unsafe zzc() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zztz());
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean zzd() {
        Unsafe unsafe = zzc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzpy.zza()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = zzb;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    private static boolean zze() {
        Unsafe unsafe = zzc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzf() == null) {
                return false;
            }
            if (zzpy.zza()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = zzb;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    private static boolean zzd(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzpy.zza()) {
            return false;
        }
        try {
            Class<?> cls3 = zzd;
            cls3.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls3.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls3.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static Field zzf() {
        Field zza2;
        if (zzpy.zza() && (zza2 = zza((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return zza2;
        }
        Field zza3 = zza((Class<?>) Buffer.class, "address");
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzk(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzl(Object obj, long j) {
        return (byte) (zza(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zza2 = zza(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza2 & (~(KotlinVersion.MAX_COMPONENT_VALUE << i))));
    }

    /* access modifiers changed from: private */
    public static void zzd(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zza(obj, j2) & (~(KotlinVersion.MAX_COMPONENT_VALUE << i))));
    }

    /* access modifiers changed from: private */
    public static boolean zzm(Object obj, long j) {
        return zzk(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzn(Object obj, long j) {
        return zzl(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzd(Object obj, long j, boolean z) {
        zzc(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zze(Object obj, long j, boolean z) {
        zzd(obj, j, z ? (byte) 1 : 0);
    }

    static {
        long j;
        Class<double[]> cls = double[].class;
        Class<float[]> cls2 = float[].class;
        Class<long[]> cls3 = long[].class;
        Class<int[]> cls4 = int[].class;
        Class<boolean[]> cls5 = boolean[].class;
        Unsafe zzc2 = zzc();
        zzc = zzc2;
        boolean zzd2 = zzd(Long.TYPE);
        zze = zzd2;
        boolean zzd3 = zzd(Integer.TYPE);
        zzf = zzd3;
        zzd zzd4 = null;
        if (zzc2 != null) {
            if (!zzpy.zza()) {
                zzd4 = new zzb(zzc2);
            } else if (zzd2) {
                zzd4 = new zzc(zzc2);
            } else if (zzd3) {
                zzd4 = new zza(zzc2);
            }
        }
        zzg = zzd4;
        long zzb2 = (long) zzb(byte[].class);
        zzj = zzb2;
        zzk = (long) zzb(cls5);
        zzl = (long) zzc(cls5);
        zzm = (long) zzb(cls4);
        zzn = (long) zzc(cls4);
        zzo = (long) zzb(cls3);
        zzp = (long) zzc(cls3);
        zzq = (long) zzb(cls2);
        zzr = (long) zzc(cls2);
        zzs = (long) zzb(cls);
        zzt = (long) zzc(cls);
        Field zzf2 = zzf();
        if (zzf2 == null || zzd4 == null) {
            j = -1;
        } else {
            j = zzd4.zza.objectFieldOffset(zzf2);
        }
        zzw = j;
        zzx = (int) (7 & zzb2);
    }
}
