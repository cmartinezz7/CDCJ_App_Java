package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzch implements Runnable {
    private final TaskCompletionSource zza;
    private final String zzb;

    zzch(TaskCompletionSource taskCompletionSource, String str) {
        this.zza = taskCompletionSource;
        this.zzb = str;
    }

    public final void run() {
        this.zza.trySetException(new ApiException(new Status(15, this.zzb)));
    }
}
