package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzcg implements Continuation {
    private final zzce zza;
    private final TaskCompletionSource zzb;

    zzcg(zzce zzce, TaskCompletionSource taskCompletionSource) {
        this.zza = zzce;
        this.zzb = taskCompletionSource;
    }

    public final Object then(Task task) {
        TaskCompletionSource taskCompletionSource = this.zzb;
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(task.getResult());
        } else if (!task.isCanceled() && task.getException() != null) {
            taskCompletionSource.setException(task.getException());
        }
        return taskCompletionSource.getTask();
    }
}
