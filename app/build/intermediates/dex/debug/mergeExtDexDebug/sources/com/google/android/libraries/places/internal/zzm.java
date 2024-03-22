package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzm implements Continuation {
    private final zzk zza;
    private final TaskCompletionSource zzb;

    zzm(zzk zzk, TaskCompletionSource taskCompletionSource) {
        this.zza = zzk;
        this.zzb = taskCompletionSource;
    }

    public final Object then(Task task) {
        return zzk.zza(this.zzb, task);
    }
}
