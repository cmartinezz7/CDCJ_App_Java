package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzbw implements Continuation {
    private final zzbo zza;
    private final long zzb;

    zzbw(zzbo zzbo, long j) {
        this.zza = zzbo;
        this.zzb = j;
    }

    public final Object then(Task task) {
        return this.zza.zza(this.zzb, task);
    }
}
