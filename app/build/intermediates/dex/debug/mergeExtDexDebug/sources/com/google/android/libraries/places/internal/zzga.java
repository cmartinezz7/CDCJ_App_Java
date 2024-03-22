package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzga {
    private final zzfz zza;
    private final String zzb;

    private zzga(zzfz zzfz, String str) {
        this.zza = zzfz;
        this.zzb = (String) zzgg.zza(str);
    }

    public final StringBuilder zza(StringBuilder sb, Iterator<? extends Map.Entry<?, ?>> it) {
        try {
            zzgg.zza(sb);
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                sb.append(this.zza.zza(entry.getKey()));
                sb.append(this.zzb);
                sb.append(this.zza.zza(entry.getValue()));
                while (it.hasNext()) {
                    sb.append(this.zza.zza);
                    Map.Entry entry2 = (Map.Entry) it.next();
                    sb.append(this.zza.zza(entry2.getKey()));
                    sb.append(this.zzb);
                    sb.append(this.zza.zza(entry2.getValue()));
                }
            }
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /* synthetic */ zzga(zzfz zzfz, String str, zzfy zzfy) {
        this(zzfz, str);
    }
}
