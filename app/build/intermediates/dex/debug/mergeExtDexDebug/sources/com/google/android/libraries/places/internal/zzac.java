package com.google.android.libraries.places.internal;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzac extends JsonObjectRequest {
    private final /* synthetic */ Map zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzac(zzy zzy, int i, String str, JSONObject jSONObject, Response.Listener listener, Response.ErrorListener errorListener, Map map) {
        super(0, str, (JSONObject) null, listener, errorListener);
        this.zza = map;
    }

    public final Map<String, String> getHeaders() {
        return this.zza;
    }
}
