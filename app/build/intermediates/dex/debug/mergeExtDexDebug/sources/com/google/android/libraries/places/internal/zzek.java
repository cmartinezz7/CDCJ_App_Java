package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzek implements OnSuccessListener {
    private final zzei zza;

    zzek(zzei zzei) {
        this.zza = zzei;
    }

    public final void onSuccess(Object obj) {
        zzei zzei = this.zza;
        zzei.zza.zza = null;
        zzei.zza.zza(zzel.zza((List<AutocompletePrediction>) ((FindAutocompletePredictionsResponse) obj).getAutocompletePredictions()));
    }
}
