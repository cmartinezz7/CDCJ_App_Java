package com.google.android.libraries.places.internal;

import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.tasks.OnTokenCanceledListener;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzaf implements OnTokenCanceledListener {
    private final ImageRequest zza;

    private zzaf(ImageRequest imageRequest) {
        this.zza = imageRequest;
    }

    static OnTokenCanceledListener zza(ImageRequest imageRequest) {
        return new zzaf(imageRequest);
    }

    public final void onCanceled() {
        this.zza.cancel();
    }
}
