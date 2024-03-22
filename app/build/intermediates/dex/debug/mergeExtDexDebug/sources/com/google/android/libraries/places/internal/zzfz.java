package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public class zzfz {
    /* access modifiers changed from: private */
    public final String zza;

    public static zzfz zza(String str) {
        return new zzfz(str);
    }

    private zzfz(String str) {
        this.zza = (String) zzgg.zza(str);
    }

    private zzfz(zzfz zzfz) {
        this.zza = zzfz.zza;
    }

    public <A extends Appendable> A zza(A a, Iterator<?> it) throws IOException {
        zzgg.zza(a);
        if (it.hasNext()) {
            a.append(zza((Object) it.next()));
            while (it.hasNext()) {
                a.append(this.zza);
                a.append(zza((Object) it.next()));
            }
        }
        return a;
    }

    private final StringBuilder zza(StringBuilder sb, Iterator<?> it) {
        try {
            zza(sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final String zza(Iterable<?> iterable) {
        return zza(new StringBuilder(), iterable.iterator()).toString();
    }

    public zzfz zza() {
        return new zzgb(this, this);
    }

    public zzga zzb(String str) {
        return new zzga(this, str, (zzfy) null);
    }

    /* access modifiers changed from: package-private */
    public CharSequence zza(Object obj) {
        zzgg.zza(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    /* synthetic */ zzfz(zzfz zzfz, zzfy zzfy) {
        this(zzfz);
    }
}
