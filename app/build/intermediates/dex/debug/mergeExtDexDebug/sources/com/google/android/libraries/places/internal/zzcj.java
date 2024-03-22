package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzcj implements OnCompleteListener {
    private final zzce zza;
    private final TaskCompletionSource zzb;

    zzcj(zzce zzce, TaskCompletionSource taskCompletionSource) {
        this.zza = zzce;
        this.zzb = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.zza.zza(this.zzb, task);
    }
}
