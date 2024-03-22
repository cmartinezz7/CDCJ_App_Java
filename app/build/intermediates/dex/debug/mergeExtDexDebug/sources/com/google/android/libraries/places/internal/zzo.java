package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzo extends LocationCallback {
    private final /* synthetic */ TaskCompletionSource zza;

    zzo(zzk zzk, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void onLocationResult(LocationResult locationResult) {
        try {
            zzo.super.onLocationResult(locationResult);
            this.zza.trySetResult(locationResult.getLastLocation());
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final void onLocationAvailability(LocationAvailability locationAvailability) {
        try {
            zzo.super.onLocationAvailability(locationAvailability);
            if (!locationAvailability.isLocationAvailable()) {
                this.zza.trySetException(new ApiException(new Status(8, "Location unavailable.")));
            }
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }
}
