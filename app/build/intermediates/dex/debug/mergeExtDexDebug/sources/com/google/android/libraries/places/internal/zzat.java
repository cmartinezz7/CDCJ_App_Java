package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzat implements Continuation {
    private final zzan zza;

    zzat(zzan zzan) {
        this.zza = zzan;
    }

    public final Object then(Task task) {
        return zzan.zzc(task);
    }
}
