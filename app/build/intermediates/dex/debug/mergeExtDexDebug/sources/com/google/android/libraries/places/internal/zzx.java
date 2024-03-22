package com.google.android.libraries.places.internal;

import com.android.volley.Response;
import com.google.android.gms.tasks.TaskCompletionSource;
import org.json.JSONObject;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzx implements Response.Listener {
    private final zzy zza;
    private final Class zzb;
    private final TaskCompletionSource zzc;

    zzx(zzy zzy, Class cls, TaskCompletionSource taskCompletionSource) {
        this.zza = zzy;
        this.zzb = cls;
        this.zzc = taskCompletionSource;
    }

    public final void onResponse(Object obj) {
        this.zza.zza(this.zzb, this.zzc, (JSONObject) obj);
    }
}
