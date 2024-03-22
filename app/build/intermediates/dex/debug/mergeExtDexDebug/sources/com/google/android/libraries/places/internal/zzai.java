package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzai extends ImageRequest {
    private final /* synthetic */ Map zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzai(zzae zzae, String str, Response.Listener listener, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, Response.ErrorListener errorListener, Map map) {
        super(str, listener, 0, 0, scaleType, config, errorListener);
        this.zza = map;
    }

    public final Map<String, String> getHeaders() {
        return this.zza;
    }
}
