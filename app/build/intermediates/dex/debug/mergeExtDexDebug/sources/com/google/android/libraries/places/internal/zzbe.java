package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzbe implements zzao<zzbc> {
    private Bitmap zza;

    public final zzao<zzbc> zza(Bitmap bitmap) {
        this.zza = bitmap;
        return this;
    }

    public final /* synthetic */ zzaj zza() {
        zzgg.zzb(this.zza != null, (Object) "Photo must be set to non-null value.");
        return new zzbc(this.zza);
    }
}
