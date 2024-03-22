package com.google.android.libraries.places.internal;

import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.tasks.OnTokenCanceledListener;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzz implements OnTokenCanceledListener {
    private final JsonObjectRequest zza;

    private zzz(JsonObjectRequest jsonObjectRequest) {
        this.zza = jsonObjectRequest;
    }

    static OnTokenCanceledListener zza(JsonObjectRequest jsonObjectRequest) {
        return new zzz(jsonObjectRequest);
    }

    public final void onCanceled() {
        this.zza.cancel();
    }
}
