package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzas implements Continuation {
    private final zzan zza;
    private final FetchPhotoRequest zzb;

    zzas(zzan zzan, FetchPhotoRequest fetchPhotoRequest) {
        this.zza = zzan;
        this.zzb = fetchPhotoRequest;
    }

    public final Object then(Task task) {
        return this.zza.zza(this.zzb, task);
    }
}
