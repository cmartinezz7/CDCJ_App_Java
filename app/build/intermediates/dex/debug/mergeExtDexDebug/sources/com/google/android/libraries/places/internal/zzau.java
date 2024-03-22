package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzau implements Continuation {
    private final zzan zza;
    private final FetchPlaceRequest zzb;

    zzau(zzan zzan, FetchPlaceRequest fetchPlaceRequest) {
        this.zza = zzan;
        this.zzb = fetchPlaceRequest;
    }

    public final Object then(Task task) {
        return this.zza.zza(this.zzb, task);
    }
}
