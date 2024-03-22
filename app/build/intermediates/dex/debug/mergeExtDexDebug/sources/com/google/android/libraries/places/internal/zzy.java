package com.google.android.libraries.places.internal;

import com.android.volley.RequestQueue;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzy {
    private final RequestQueue zza;
    private final zzam zzb;

    zzy(RequestQueue requestQueue, zzam zzam) {
        this.zza = requestQueue;
        this.zzb = zzam;
    }

    public final <HttpJsonResponseT extends zzaj<Object, ? extends Object>> Task<HttpJsonResponseT> zza(zzak<Object, ? extends zzcq> zzak, Class<HttpJsonResponseT> cls) {
        TaskCompletionSource taskCompletionSource;
        String zzd = zzak.zzd();
        Map<String, String> zzc = zzak.zzc();
        CancellationToken zzb2 = zzak.zzb();
        if (zzb2 != null) {
            taskCompletionSource = new TaskCompletionSource(zzb2);
        } else {
            taskCompletionSource = new TaskCompletionSource();
        }
        zzac zzac = new zzac(this, 0, zzd, (JSONObject) null, new zzx(this, cls, taskCompletionSource), new zzaa(taskCompletionSource), zzc);
        if (zzb2 != null) {
            zzac.getClass();
            zzb2.onCanceledRequested(zzz.zza(zzac));
        }
        this.zza.add(zzac);
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        com.google.android.libraries.places.internal.zzdc.zza(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        throw r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010 A[ExcHandler: Error | RuntimeException (r3v3 'e' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:5:0x0015] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.lang.Class r3, com.google.android.gms.tasks.TaskCompletionSource r4, org.json.JSONObject r5) {
        /*
            r2 = this;
            com.google.android.libraries.places.internal.zzam r0 = r2.zzb     // Catch:{ zzal -> 0x0012 }
            java.lang.String r5 = r5.toString()     // Catch:{ zzal -> 0x0012 }
            java.lang.Object r3 = r0.zza(r5, r3)     // Catch:{ zzal -> 0x0012 }
            com.google.android.libraries.places.internal.zzaj r3 = (com.google.android.libraries.places.internal.zzaj) r3     // Catch:{ zzal -> 0x0012 }
            r4.trySetResult(r3)     // Catch:{ zzal -> 0x0012 }
            return
        L_0x0010:
            r3 = move-exception
            goto L_0x0029
        L_0x0012:
            r3 = move-exception
            com.google.android.gms.common.api.ApiException r5 = new com.google.android.gms.common.api.ApiException     // Catch:{ Error | RuntimeException -> 0x0010, Error | RuntimeException -> 0x0010 }
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ Error | RuntimeException -> 0x0010, Error | RuntimeException -> 0x0010 }
            r1 = 8
            java.lang.String r3 = r3.getMessage()     // Catch:{ Error | RuntimeException -> 0x0010, Error | RuntimeException -> 0x0010 }
            r0.<init>(r1, r3)     // Catch:{ Error | RuntimeException -> 0x0010, Error | RuntimeException -> 0x0010 }
            r5.<init>(r0)     // Catch:{ Error | RuntimeException -> 0x0010, Error | RuntimeException -> 0x0010 }
            r4.trySetException(r5)     // Catch:{ Error | RuntimeException -> 0x0010, Error | RuntimeException -> 0x0010 }
            return
        L_0x0029:
            com.google.android.libraries.places.internal.zzdc.zza((java.lang.Throwable) r3)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzy.zza(java.lang.Class, com.google.android.gms.tasks.TaskCompletionSource, org.json.JSONObject):void");
    }
}
