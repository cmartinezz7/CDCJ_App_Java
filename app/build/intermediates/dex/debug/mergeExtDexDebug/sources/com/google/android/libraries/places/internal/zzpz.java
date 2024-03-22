package com.google.android.libraries.places.internal;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzpz extends zzqb {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzqa zzc;

    zzpz(zzqa zzqa) {
        this.zzc = zzqa;
        this.zzb = zzqa.zza();
    }

    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
