package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzaq implements Continuation {
    private final zzan zza;
    private final FindAutocompletePredictionsRequest zzb;

    zzaq(zzan zzan, FindAutocompletePredictionsRequest findAutocompletePredictionsRequest) {
        this.zza = zzan;
        this.zzb = findAutocompletePredictionsRequest;
    }

    public final Object then(Task task) {
        return this.zza.zza(this.zzb, task);
    }
}
