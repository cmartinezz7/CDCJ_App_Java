package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import com.android.volley.Response;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzad implements Response.Listener {
    private final zzao zza;
    private final TaskCompletionSource zzb;

    zzad(zzao zzao, TaskCompletionSource taskCompletionSource) {
        this.zza = zzao;
        this.zzb = taskCompletionSource;
    }

    public final void onResponse(Object obj) {
        zzao zzao = this.zza;
        TaskCompletionSource taskCompletionSource = this.zzb;
        try {
            zzao.zza((Bitmap) obj);
            taskCompletionSource.trySetResult(zzao.zza());
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }
}
