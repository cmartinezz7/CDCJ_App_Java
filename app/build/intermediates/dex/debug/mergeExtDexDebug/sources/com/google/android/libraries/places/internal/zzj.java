package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzj implements Continuation {
    private final zzk zza;
    private final CancellationToken zzb;

    zzj(zzk zzk, CancellationToken cancellationToken) {
        this.zza = zzk;
        this.zzb = cancellationToken;
    }

    public final Object then(Task task) {
        return this.zza.zza(this.zzb, task);
    }
}
