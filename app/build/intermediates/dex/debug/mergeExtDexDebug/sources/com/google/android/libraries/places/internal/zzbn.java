package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzbn implements Continuation {
    static final Continuation zza = new zzbn();

    private zzbn() {
    }

    public final Object then(Task task) {
        return ((zzbi) task.getResult()).zza();
    }
}
