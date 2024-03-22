package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzrb;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzqu extends zzqr<Object> {
    zzqu() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzsm zzsm) {
        return zzsm instanceof zzrb.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzqw<Object> zza(Object obj) {
        return ((zzrb.zzd) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzqw<Object> zzb(Object obj) {
        zzrb.zzd zzd = (zzrb.zzd) obj;
        if (zzd.zzc.zzc()) {
            zzd.zzc = (zzqw) zzd.zzc.clone();
        }
        return zzd.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj) {
        zza(obj).zzb();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzul zzul, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }
}
