package com.google.android.libraries.places.internal;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzl implements OnCompleteListener {
    private final zzk zza;
    private final LocationCallback zzb;
    private final TaskCompletionSource zzc;

    zzl(zzk zzk, LocationCallback locationCallback, TaskCompletionSource taskCompletionSource) {
        this.zza = zzk;
        this.zzb = locationCallback;
        this.zzc = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.zza.zza(this.zzb, this.zzc, task);
    }
}
