package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.libraries.places.api.model.Place;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzej implements OnFailureListener {
    private final zzei zza;

    zzej(zzei zzei) {
        this.zza = zzei;
    }

    public final void onFailure(Exception exc) {
        zzei zzei = this.zza;
        zzei.zza.zza = null;
        zzei.zza.zza(new zzel(3, zzed.zzb(exc), zzgv.zza(), -1, (Place) null));
    }
}
