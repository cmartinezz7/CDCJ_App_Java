package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzbr implements Continuation {
    static final Continuation zza = new zzbr();

    private zzbr() {
    }

    public final Object then(Task task) {
        return ((zzbg) task.getResult()).zza();
    }
}
