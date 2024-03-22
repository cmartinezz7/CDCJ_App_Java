package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzgb extends zzfz {
    private final /* synthetic */ zzfz zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzgb(zzfz zzfz, zzfz zzfz2) {
        super(zzfz2, (zzfy) null);
        this.zza = zzfz;
    }

    public final <A extends Appendable> A zza(A a, Iterator<?> it) throws IOException {
        zzgg.zza(a, (Object) "appendable");
        zzgg.zza(it, (Object) "parts");
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (next != null) {
                    a.append(this.zza.zza((Object) next));
                    break;
                }
            } else {
                break;
            }
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            if (next2 != null) {
                a.append(this.zza.zza);
                a.append(this.zza.zza((Object) next2));
            }
        }
        return a;
    }

    public final zzga zzb(String str) {
        throw new UnsupportedOperationException("can't use .skipNulls() with maps");
    }
}
