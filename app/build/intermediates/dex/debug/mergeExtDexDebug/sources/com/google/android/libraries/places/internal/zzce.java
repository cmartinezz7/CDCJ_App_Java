package com.google.android.libraries.places.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzce {
    private final zzcf zza;
    private final Map<TaskCompletionSource<?>, HandlerThread> zzb = new HashMap();

    public zzce(zzcf zzcf) {
        this.zza = zzcf;
    }

    public final <T> boolean zza(TaskCompletionSource<T> taskCompletionSource, long j, String str) {
        if (this.zzb.containsKey(taskCompletionSource)) {
            return false;
        }
        HandlerThread handlerThread = new HandlerThread("timeoutHandlerThread");
        handlerThread.start();
        this.zzb.put(taskCompletionSource, handlerThread);
        return new Handler(handlerThread.getLooper()).postDelayed(new zzch(taskCompletionSource, str), j);
    }

    public final <T> Task<T> zza(Task<T> task, CancellationToken cancellationToken, long j, String str) {
        TaskCompletionSource taskCompletionSource;
        if (cancellationToken == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(cancellationToken);
        }
        zza(taskCompletionSource, j, str);
        task.continueWithTask(new zzcg(this, taskCompletionSource));
        taskCompletionSource.getTask().addOnCompleteListener(new zzcj(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final boolean zza(TaskCompletionSource<?> taskCompletionSource) {
        HandlerThread remove = this.zzb.remove(taskCompletionSource);
        if (remove == null) {
            return false;
        }
        return remove.quit();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(TaskCompletionSource taskCompletionSource, Task task) {
        zza(taskCompletionSource);
    }
}
