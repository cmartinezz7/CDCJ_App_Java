package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.volley.RequestQueue;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzae {
    private final RequestQueue zza;

    zzae(RequestQueue requestQueue) {
        this.zza = requestQueue;
    }

    public final <HttpPhotoResponseT extends zzaj<Object, ? extends Object>> Task<HttpPhotoResponseT> zza(zzak<Object, ?> zzak, zzao<HttpPhotoResponseT> zzao) {
        TaskCompletionSource taskCompletionSource;
        String zzd = zzak.zzd();
        Map<String, String> zzc = zzak.zzc();
        CancellationToken zzb = zzak.zzb();
        if (zzb != null) {
            taskCompletionSource = new TaskCompletionSource(zzb);
        } else {
            taskCompletionSource = new TaskCompletionSource();
        }
        zzai zzai = new zzai(this, zzd, new zzad(zzao, taskCompletionSource), 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888, new zzag(taskCompletionSource), zzc);
        if (zzb != null) {
            zzai.getClass();
            zzb.onCanceledRequested(zzaf.zza(zzai));
        }
        this.zza.add(zzai);
        return taskCompletionSource.getTask();
    }
}
