package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzpt;
import com.google.android.libraries.places.internal.zzpu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public abstract class zzpu<MessageType extends zzpu<MessageType, BuilderType>, BuilderType extends zzpt<MessageType, BuilderType>> implements zzsm {
    protected int zza = 0;

    public final zzqa zzc() {
        try {
            zzqi zzc = zzqa.zzc(zzh());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length()).append("Serializing ").append(name).append(" to a ").append("ByteString").append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    public final byte[] zzd() {
        try {
            byte[] bArr = new byte[zzh()];
            zzqn zza2 = zzqn.zza(bArr);
            zza(zza2);
            zza2.zzb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("byte array").length()).append("Serializing ").append(name).append(" to a ").append("byte array").append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zze() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zza(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzrd.zza(iterable);
        if (iterable instanceof zzrw) {
            List<?> zzd = ((zzrw) iterable).zzd();
            zzrw zzrw = (zzrw) list;
            int size = list.size();
            for (Object next : zzd) {
                if (next == null) {
                    String sb = new StringBuilder(37).append("Element at index ").append(zzrw.size() - size).append(" is null.").toString();
                    for (int size2 = zzrw.size() - 1; size2 >= size; size2--) {
                        zzrw.remove(size2);
                    }
                    throw new NullPointerException(sb);
                } else if (next instanceof zzqa) {
                    zzrw.zza((zzqa) next);
                } else {
                    zzrw.add((String) next);
                }
            }
        } else if (iterable instanceof zzsv) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    String sb2 = new StringBuilder(37).append("Element at index ").append(list.size() - size3).append(" is null.").toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb2);
                }
                list.add(next2);
            }
        }
    }
}
