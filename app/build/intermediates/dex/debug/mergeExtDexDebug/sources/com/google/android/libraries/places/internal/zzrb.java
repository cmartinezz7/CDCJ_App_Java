package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;
import com.google.android.libraries.places.internal.zzrb.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public abstract class zzrb<MessageType extends zzrb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzpu<MessageType, BuilderType> {
    private static Map<Object, zzrb<?, ?>> zzd = new ConcurrentHashMap();
    protected zztu zzb = zztu.zza();
    private int zzc = -1;

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static class zza<T extends zzrb<T, ?>> extends zzpw<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* 'enum' modifier removed */
    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static final class zzc {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzm = {1, 2};
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzrb<MessageType, BuilderType> implements zzso {
        protected zzqw<Object> zzc = zzqw.zza();
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzsn.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzsy.zza().zza(this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static abstract class zzb<MessageType extends zzrb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzpt<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;
        private boolean zzc = false;

        protected zzb(MessageType messagetype) {
            this.zzb = messagetype;
            this.zza = (zzrb) messagetype.zza(zzc.zzd, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzb() {
            if (this.zzc) {
                MessageType messagetype = (zzrb) this.zza.zza(zzc.zzd, (Object) null, (Object) null);
                zza(messagetype, this.zza);
                this.zza = messagetype;
                this.zzc = false;
            }
        }

        public final boolean zzg() {
            return zzrb.zza(this.zza, false);
        }

        /* renamed from: zzc */
        public MessageType zze() {
            if (this.zzc) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzsy.zza().zza(messagetype).zzb(messagetype);
            this.zzc = true;
            return this.zza;
        }

        /* renamed from: zzd */
        public final MessageType zzf() {
            MessageType messagetype = (zzrb) zze();
            if (messagetype.zzg()) {
                return messagetype;
            }
            throw new zzts(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzb();
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzsy.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        public final /* synthetic */ zzpt zza() {
            return (zzb) clone();
        }

        public final /* synthetic */ zzsm zzm() {
            return this.zzb;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb2 = (zzb) ((zzrb) this.zzb).zza(zzc.zze, (Object) null, (Object) null);
            zzb2.zza((zzrb) zze());
            return zzb2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzrb) zza(zzc.zzf, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzsy.zza().zza(this).zza(this, (zzrb) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzrb<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzf() {
        return (zzb) zza(zzc.zze, (Object) null, (Object) null);
    }

    public final boolean zzg() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i) {
        this.zzc = i;
    }

    public final void zza(zzqn zzqn) throws IOException {
        zzsy.zza().zza(this).zza(this, (zzul) zzqq.zza(zzqn));
    }

    public final int zzh() {
        if (this.zzc == -1) {
            this.zzc = zzsy.zza().zza(this).zzd(this);
        }
        return this.zzc;
    }

    static <T extends zzrb<?, ?>> T zza(Class<T> cls) {
        T t = (zzrb) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzrb) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzrb) ((zzrb) zztx.zza(cls)).zza(zzc.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzrb<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzsm zzsm, String str, Object[] objArr) {
        return new zzta(zzsm, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzrb<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzc.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzc2 = zzsy.zza().zza(t).zzc(t);
        if (z) {
            t.zza(zzc.zzb, (Object) zzc2 ? t : null, (Object) null);
        }
        return zzc2;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.libraries.places.internal.zzrh, com.google.android.libraries.places.internal.zzre] */
    protected static zzrh zzi() {
        return zzre.zzd();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.libraries.places.internal.zzrz, com.google.android.libraries.places.internal.zzrj] */
    protected static zzrj zzj() {
        return zzrz.zzd();
    }

    protected static <E> zzrm<E> zzk() {
        return zzsx.zzd();
    }

    protected static <E> zzrm<E> zza(zzrm<E> zzrm) {
        int size = zzrm.size();
        return zzrm.zzb(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ zzsl zzl() {
        zzb zzb2 = (zzb) zza(zzc.zze, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    public final /* synthetic */ zzsm zzm() {
        return (zzrb) zza(zzc.zzf, (Object) null, (Object) null);
    }
}
