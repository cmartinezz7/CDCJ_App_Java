package com.google.android.libraries.places.internal;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzaa implements Response.ErrorListener {
    private final TaskCompletionSource zza;

    zzaa(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        try {
            this.zza.trySetException(zzw.zza(volleyError));
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }
}
