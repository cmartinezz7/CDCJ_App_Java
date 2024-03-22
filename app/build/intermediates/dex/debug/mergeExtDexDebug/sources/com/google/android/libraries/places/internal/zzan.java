package com.google.android.libraries.places.internal;

import android.location.Location;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzan implements PlacesClient {
    private final zzv zza;
    private final zzk zzb;
    private final zzs zzc;
    private final zzcp zzd;
    private final zzb zze;

    zzan(zzv zzv, zzk zzk, zzs zzs, zzcp zzcp, zzb zzb2) {
        this.zza = zzv;
        this.zzb = zzk;
        this.zzc = zzs;
        this.zzd = zzcp;
        this.zze = zzb2;
    }

    public final Task<FindAutocompletePredictionsResponse> findAutocompletePredictions(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest) {
        try {
            zzgg.zza(findAutocompletePredictionsRequest, (Object) "Request must not be null.");
            return this.zza.zza(findAutocompletePredictionsRequest).continueWith(new zzaq(this, findAutocompletePredictionsRequest)).continueWithTask(new zzap(this));
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final Task<FetchPhotoResponse> fetchPhoto(FetchPhotoRequest fetchPhotoRequest) {
        try {
            zzgg.zza(fetchPhotoRequest, (Object) "Request must not be null.");
            return this.zza.zza(fetchPhotoRequest).continueWith(new zzas(this, fetchPhotoRequest)).continueWithTask(new zzar(this));
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final Task<FetchPlaceResponse> fetchPlace(FetchPlaceRequest fetchPlaceRequest) {
        try {
            zzgg.zza(fetchPlaceRequest, (Object) "Request must not be null.");
            return this.zza.zza(fetchPlaceRequest).continueWith(new zzau(this, fetchPlaceRequest)).continueWithTask(new zzat(this));
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final Task<FindCurrentPlaceResponse> findCurrentPlace(FindCurrentPlaceRequest findCurrentPlaceRequest) {
        try {
            zzgg.zza(findCurrentPlaceRequest, (Object) "Request must not be null.");
            return this.zzb.zza(findCurrentPlaceRequest.getCancellationToken()).onSuccessTask(new zzaw(this, findCurrentPlaceRequest)).continueWith(new zzav(this, findCurrentPlaceRequest, this.zze.zza(), zzf.zza().zzb())).continueWithTask(new zzay(this));
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    /* access modifiers changed from: private */
    public static <ResponseT> Task<ResponseT> zzc(Task<ResponseT> task) {
        Exception exc;
        Exception exception = task.getException();
        if (exception == null) {
            return task;
        }
        if (exception instanceof ApiException) {
            exc = (ApiException) exception;
        } else {
            exc = new ApiException(new Status(13, exception.toString()));
        }
        return Tasks.forException(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ FindCurrentPlaceResponse zza(FindCurrentPlaceRequest findCurrentPlaceRequest, long j, zzg zzg, Task task) throws Exception {
        this.zzd.zza(findCurrentPlaceRequest, task, j, this.zze.zza());
        zzf.zza().zza(zzg, zzh.zza("FindCurrentPlace", "Duration"));
        zzf.zza().zza(zzh.zza("FindCurrentPlace"));
        zzf.zza().zzb(zzh.zza("FindCurrentPlace", "Battery"));
        return (FindCurrentPlaceResponse) task.getResult();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location) throws Exception {
        return this.zza.zza(findCurrentPlaceRequest, location, this.zzc.zza());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ FetchPlaceResponse zza(FetchPlaceRequest fetchPlaceRequest, Task task) throws Exception {
        this.zzd.zza(fetchPlaceRequest);
        return (FetchPlaceResponse) task.getResult();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ FetchPhotoResponse zza(FetchPhotoRequest fetchPhotoRequest, Task task) throws Exception {
        this.zzd.zza(fetchPhotoRequest);
        return (FetchPhotoResponse) task.getResult();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ FindAutocompletePredictionsResponse zza(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, Task task) throws Exception {
        this.zzd.zza(findAutocompletePredictionsRequest);
        return (FindAutocompletePredictionsResponse) task.getResult();
    }
}
