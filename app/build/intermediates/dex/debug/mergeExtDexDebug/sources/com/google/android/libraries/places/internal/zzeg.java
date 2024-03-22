package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzeg implements OnSuccessListener {
    private final zzed zza;

    zzeg(zzed zzed) {
        this.zza = zzed;
    }

    public final void onSuccess(Object obj) {
        this.zza.zza((FetchPlaceResponse) obj);
    }
}
