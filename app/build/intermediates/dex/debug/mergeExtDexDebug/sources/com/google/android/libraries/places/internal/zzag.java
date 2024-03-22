package com.google.android.libraries.places.internal;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzag implements Response.ErrorListener {
    private final TaskCompletionSource zza;

    zzag(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        ApiException apiException;
        TaskCompletionSource taskCompletionSource = this.zza;
        try {
            if (volleyError.networkResponse != null) {
                int i = volleyError.networkResponse.statusCode;
                if (i == 400) {
                    apiException = new ApiException(new Status(9012, "The provided parameters are invalid (did you include a max width or height?)."));
                } else if (i == 403) {
                    apiException = new ApiException(new Status(9011, "The provided API key is invalid."));
                }
                taskCompletionSource.trySetException(apiException);
            }
            apiException = zzw.zza(volleyError);
            taskCompletionSource.trySetException(apiException);
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }
}
