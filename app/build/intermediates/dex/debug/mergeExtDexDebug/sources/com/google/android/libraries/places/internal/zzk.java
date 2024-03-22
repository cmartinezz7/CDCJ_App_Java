package com.google.android.libraries.places.internal;

import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzk {
    private static final long zza = TimeUnit.SECONDS.toMillis(10);
    private static final long zzb = TimeUnit.SECONDS.toNanos(24);
    private static final long zzc = TimeUnit.SECONDS.toMillis(59);
    private final FusedLocationProviderClient zzd;
    private final zzce zze;

    zzk(FusedLocationProviderClient fusedLocationProviderClient, zzce zzce) {
        this.zzd = fusedLocationProviderClient;
        this.zze = zzce;
    }

    public final Task<Location> zza(CancellationToken cancellationToken) {
        return this.zze.zza(this.zzd.getLastLocation(), cancellationToken, zza, "Location timeout.").continueWithTask(new zzj(this, cancellationToken));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(LocationCallback locationCallback, TaskCompletionSource taskCompletionSource, Task task) {
        this.zzd.removeLocationUpdates(locationCallback);
        this.zze.zza(taskCompletionSource);
    }

    static /* synthetic */ Task zza(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isComplete()) {
            if (task.isCanceled()) {
                taskCompletionSource.trySetException(new ApiException(new Status(16, "Location request was cancelled. Please try again.")));
            } else if (!task.isSuccessful()) {
                taskCompletionSource.trySetException(new ApiException(new Status(8, task.getException().getMessage())));
            }
        }
        return task;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(CancellationToken cancellationToken, Task task) throws Exception {
        TaskCompletionSource taskCompletionSource;
        if (task.isSuccessful()) {
            Location location = (Location) task.getResult();
            boolean z = false;
            if (location != null && (Build.VERSION.SDK_INT < 17 || SystemClock.elapsedRealtimeNanos() - location.getElapsedRealtimeNanos() <= zzb)) {
                z = true;
            }
            if (z) {
                return task;
            }
        }
        if (cancellationToken != null) {
            taskCompletionSource = new TaskCompletionSource(cancellationToken);
        } else {
            taskCompletionSource = new TaskCompletionSource();
        }
        LocationRequest priority = LocationRequest.create().setPriority(100);
        long j = zza;
        LocationRequest numUpdates = priority.setExpirationDuration(j).setInterval(zzc).setFastestInterval(10).setNumUpdates(1);
        zzo zzo = new zzo(this, taskCompletionSource);
        this.zzd.requestLocationUpdates(numUpdates, zzo, Looper.getMainLooper()).continueWithTask(new zzm(this, taskCompletionSource));
        this.zze.zza(taskCompletionSource, j, "Location timeout.");
        taskCompletionSource.getTask().addOnCompleteListener(new zzl(this, zzo, taskCompletionSource));
        return taskCompletionSource.getTask();
    }
}
