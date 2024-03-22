package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzbp implements Continuation {
    static final Continuation zza = new zzbp();

    private zzbp() {
    }

    public final Object then(Task task) {
        return ((zzbc) task.getResult()).zza();
    }
}
