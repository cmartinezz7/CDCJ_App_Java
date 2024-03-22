package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzqy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sqlcipher.IBulkCursor;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzqw<T extends zzqy<T>> {
    private static final zzqw zzd = new zzqw(true);
    final zzte<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzqw() {
        this.zza = zzte.zza(16);
    }

    private zzqw(boolean z) {
        this(zzte.zza(0));
        zzb();
    }

    private zzqw(zzte<T, Object> zzte) {
        this.zza = zzte;
        zzb();
    }

    public static <T extends zzqy<T>> zzqw<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzqw)) {
            return false;
        }
        return this.zza.equals(((zzqw) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzrr(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzrr(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (obj instanceof zzrq) {
            return zzrq.zza();
        }
        return obj;
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzrq) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    private static void zza(zzuf zzuf, Object obj) {
        zzrd.zza(obj);
        boolean z = true;
        switch (zzqv.zza[zzuf.zza().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzqa) && !(obj instanceof byte[])) {
                    z = false;
                    break;
                }
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzrg)) {
                    z = false;
                    break;
                }
            case 9:
                if (!(obj instanceof zzsm) && !(obj instanceof zzrq)) {
                    z = false;
                    break;
                }
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza(this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zza2 : this.zza.zzd()) {
            if (!zza(zza2)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzqy<T>> boolean zza(Map.Entry<T, Object> entry) {
        zzqy zzqy = (zzqy) entry.getKey();
        if (zzqy.zzc() == zzum.MESSAGE) {
            if (zzqy.zzd()) {
                for (zzsm zzg : (List) entry.getValue()) {
                    if (!zzg.zzg()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzsm) {
                    if (!((zzsm) value).zzg()) {
                        return false;
                    }
                } else if (value instanceof zzrq) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzqw<T> zzqw) {
        for (int i = 0; i < zzqw.zza.zzc(); i++) {
            zzb(zzqw.zza.zzb(i));
        }
        for (Map.Entry<T, Object> zzb2 : zzqw.zza.zzd()) {
            zzb(zzb2);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzss) {
            return ((zzss) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        Object obj;
        zzqy zzqy = (zzqy) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzrq) {
            value = zzrq.zza();
        }
        if (zzqy.zzd()) {
            Object zza2 = zza(zzqy);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object zza3 : (List) value) {
                ((List) zza2).add(zza(zza3));
            }
            this.zza.put(zzqy, zza2);
        } else if (zzqy.zzc() == zzum.MESSAGE) {
            Object zza4 = zza(zzqy);
            if (zza4 == null) {
                this.zza.put(zzqy, zza(value));
                return;
            }
            if (zza4 instanceof zzss) {
                obj = zzqy.zza((zzss) zza4, (zzss) value);
            } else {
                obj = zzqy.zza(((zzsm) zza4).zzl(), (zzsm) value).zzf();
            }
            this.zza.put(zzqy, obj);
        } else {
            this.zza.put(zzqy, zza(value));
        }
    }

    static void zza(zzqn zzqn, zzuf zzuf, int i, Object obj) throws IOException {
        if (zzuf == zzuf.GROUP) {
            zzsm zzsm = (zzsm) obj;
            zzrd.zza(zzsm);
            zzqn.zza(i, 3);
            zzsm.zza(zzqn);
            zzqn.zza(i, 4);
            return;
        }
        zzqn.zza(i, zzuf.zzb());
        switch (zzqv.zzb[zzuf.ordinal()]) {
            case 1:
                zzqn.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzqn.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzqn.zza(((Long) obj).longValue());
                return;
            case 4:
                zzqn.zza(((Long) obj).longValue());
                return;
            case 5:
                zzqn.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzqn.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzqn.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzqn.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzsm) obj).zza(zzqn);
                return;
            case 10:
                zzqn.zza((zzsm) obj);
                return;
            case IBulkCursor.RESPOND_TRANSACTION /*11*/:
                if (obj instanceof zzqa) {
                    zzqn.zza((zzqa) obj);
                    return;
                } else {
                    zzqn.zza((String) obj);
                    return;
                }
            case IBulkCursor.CLOSE_TRANSACTION /*12*/:
                if (obj instanceof zzqa) {
                    zzqn.zza((zzqa) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzqn.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzqn.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzqn.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzqn.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzqn.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzqn.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzrg) {
                    zzqn.zza(((zzrg) obj).zza());
                    return;
                } else {
                    zzqn.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> zzc2 : this.zza.zzd()) {
            i += zzc(zzc2);
        }
        return i;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        zzqy zzqy = (zzqy) entry.getKey();
        Object value = entry.getValue();
        if (zzqy.zzc() != zzum.MESSAGE || zzqy.zzd() || zzqy.zze()) {
            return zza((zzqy<?>) zzqy, value);
        }
        if (value instanceof zzrq) {
            return zzqn.zzb(((zzqy) entry.getKey()).zza(), (zzru) (zzrq) value);
        }
        return zzqn.zzb(((zzqy) entry.getKey()).zza(), (zzsm) value);
    }

    static int zza(zzuf zzuf, int i, Object obj) {
        int zze = zzqn.zze(i);
        if (zzuf == zzuf.GROUP) {
            zzrd.zza((zzsm) obj);
            zze <<= 1;
        }
        return zze + zzb(zzuf, obj);
    }

    private static int zzb(zzuf zzuf, Object obj) {
        switch (zzqv.zzb[zzuf.ordinal()]) {
            case 1:
                return zzqn.zzb(((Double) obj).doubleValue());
            case 2:
                return zzqn.zzb(((Float) obj).floatValue());
            case 3:
                return zzqn.zzd(((Long) obj).longValue());
            case 4:
                return zzqn.zze(((Long) obj).longValue());
            case 5:
                return zzqn.zzf(((Integer) obj).intValue());
            case 6:
                return zzqn.zzg(((Long) obj).longValue());
            case 7:
                return zzqn.zzi(((Integer) obj).intValue());
            case 8:
                return zzqn.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzqn.zzc((zzsm) obj);
            case 10:
                if (obj instanceof zzrq) {
                    return zzqn.zza((zzru) (zzrq) obj);
                }
                return zzqn.zzb((zzsm) obj);
            case IBulkCursor.RESPOND_TRANSACTION /*11*/:
                if (obj instanceof zzqa) {
                    return zzqn.zzb((zzqa) obj);
                }
                return zzqn.zzb((String) obj);
            case IBulkCursor.CLOSE_TRANSACTION /*12*/:
                if (obj instanceof zzqa) {
                    return zzqn.zzb((zzqa) obj);
                }
                return zzqn.zzb((byte[]) obj);
            case 13:
                return zzqn.zzg(((Integer) obj).intValue());
            case 14:
                return zzqn.zzj(((Integer) obj).intValue());
            case 15:
                return zzqn.zzh(((Long) obj).longValue());
            case 16:
                return zzqn.zzh(((Integer) obj).intValue());
            case 17:
                return zzqn.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzrg) {
                    return zzqn.zzk(((zzrg) obj).zza());
                }
                return zzqn.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzqy<?> zzqy, Object obj) {
        zzuf zzb2 = zzqy.zzb();
        int zza2 = zzqy.zza();
        if (!zzqy.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzqy.zze()) {
            for (Object zzb3 : (List) obj) {
                i += zzb(zzb2, zzb3);
            }
            return zzqn.zze(zza2) + i + zzqn.zzl(i);
        }
        for (Object zza3 : (List) obj) {
            i += zza(zzb2, zza2, zza3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzqw zzqw = new zzqw();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzqw.zzb((zzqy) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry next : this.zza.zzd()) {
            zzqw.zzb((zzqy) next.getKey(), next.getValue());
        }
        zzqw.zzc = this.zzc;
        return zzqw;
    }
}
