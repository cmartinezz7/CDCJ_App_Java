package com.google.android.libraries.places.internal;

import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.internal.zzmm;
import java.util.Locale;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzu implements zzcp {
    private final ClearcutLogger zza;
    private final zzdb zzb;
    private final zzdd zzc;

    zzu(ClearcutLogger clearcutLogger, zzdb zzdb, zzdd zzdd) {
        this.zza = clearcutLogger;
        this.zzb = zzdb;
        this.zzc = zzdd;
    }

    public final void zza(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest) {
        zzmm.zzk.zza zza2 = zzmm.zzk.zza();
        if (findAutocompletePredictionsRequest.getTypeFilter() != null) {
            zza2.zza(zzcc.zza(findAutocompletePredictionsRequest.getTypeFilter()));
        }
        zzmm.zzk zzk = (zzmm.zzk) ((zzrb) zza2.zzf());
        zzmm.zzo.zza zza3 = zzmm.zzo.zza();
        if (zzk != null) {
            zza3.zza(zzk);
        }
        zzmm.zzah.zzb zza4 = zza().zza(zzmm.zzah.zza.AUTOCOMPLETE);
        zzmm.zzs.zza zza5 = zzda.zza(this.zzb).zza(zzmm.zzs.zzc.PLACES_QUERY).zza((zzmm.zzah) ((zzrb) zza4.zza((zzmm.zzo) ((zzrb) zza3.zzf())).zzf()));
        if (findAutocompletePredictionsRequest.getSessionToken() != null) {
            zza5.zza(findAutocompletePredictionsRequest.getSessionToken().toString());
        }
        zza((zzmm.zzs) ((zzrb) zza5.zzf()));
    }

    public final void zza(Task<FindAutocompletePredictionsResponse> task, long j, long j2) {
        int i;
        if (task.isSuccessful()) {
            i = ((FindAutocompletePredictionsResponse) task.getResult()).getAutocompletePredictions().size();
        } else {
            i = 0;
        }
        zza((zzmm.zzi) ((zzrb) zzmm.zzi.zza().zza(zzmm.zzi.zzd.GET_AUTOCOMPLETE_PREDICTIONS).zza((zzmm.zzd) ((zzrb) zzmm.zzd.zza().zza(i).zzf())).zza(zza(task)).zza((int) (j2 - j)).zzf()));
    }

    public final void zza(FetchPlaceRequest fetchPlaceRequest) {
        zzmm.zzah.zzb zza2 = zza().zza(zzmm.zzah.zza.BY_ID);
        zzmm.zzs.zza zza3 = zzda.zza(this.zzb).zza(zzmm.zzs.zzc.PLACES_QUERY).zza((zzmm.zzah) ((zzrb) zza2.zza((zzmm.zzv) ((zzrb) zzmm.zzv.zza().zza(1).zza((zzmm.zzaf) ((zzrb) zzmm.zzaf.zza().zza(zzcd.zza(fetchPlaceRequest.getPlaceFields())).zzf())).zzf())).zzf()));
        if (fetchPlaceRequest.getSessionToken() != null) {
            zza3.zza(fetchPlaceRequest.getSessionToken().toString());
        }
        zza((zzmm.zzs) ((zzrb) zza3.zzf()));
    }

    public final void zzb(Task<FetchPlaceResponse> task, long j, long j2) {
        boolean isSuccessful = task.isSuccessful();
        zza((zzmm.zzi) ((zzrb) zzmm.zzi.zza().zza(zzmm.zzi.zzd.GET_PLACE_BY_ID).zza((zzmm.zzf) ((zzrb) zzmm.zzf.zza().zza(1).zzb(isSuccessful ? 1 : 0).zzf())).zza(zza(task)).zza((int) (j2 - j)).zzf()));
    }

    public final void zza(FindCurrentPlaceRequest findCurrentPlaceRequest, Task<FindCurrentPlaceResponse> task, long j, long j2) {
        zzmm.zzy.zza zza2;
        if (task.isSuccessful()) {
            zza2 = zzmm.zzy.zza.NEARBY_SEARCH;
        } else {
            zza2 = zzmm.zzy.zza.NO_RESULT;
        }
        zza((zzmm.zzs) ((zzrb) zzda.zza(this.zzb).zza(zzmm.zzs.zzc.GET_CURRENT_PLACE).zza((zzmm.zzy) ((zzrb) zzmm.zzy.zza().zza((zzmm.zzaf) ((zzrb) zzmm.zzaf.zza().zza(zzcd.zza(findCurrentPlaceRequest.getPlaceFields())).zzf())).zza((int) (j2 - j)).zza(zza2).zzf())).zzf()));
    }

    public final void zzc(Task<FindCurrentPlaceResponse> task, long j, long j2) {
        int i;
        if (task.isSuccessful()) {
            i = ((FindCurrentPlaceResponse) task.getResult()).getPlaceLikelihoods().size();
        } else {
            i = 0;
        }
        zza((zzmm.zzi) ((zzrb) zzmm.zzi.zza().zza(zzmm.zzi.zzd.ESTIMATE_PLACES_BY_LOCATION).zza((zzmm.zzb) ((zzrb) zzmm.zzb.zza().zza(i).zzf())).zza(zza(task)).zza((int) (j2 - j)).zzf()));
    }

    public final void zza(FetchPhotoRequest fetchPhotoRequest) {
        zza((zzmm.zzs) ((zzrb) zzda.zza(this.zzb).zza(zzmm.zzs.zzc.PLACE_PHOTO_QUERY).zza((zzmm.zzae) ((zzrb) zzmm.zzae.zza().zza(zzmm.zzae.zza.PHOTO_IMAGE).zzf())).zzf()));
    }

    public final void zzd(Task<FetchPhotoResponse> task, long j, long j2) {
        zza((zzmm.zzi) ((zzrb) zzmm.zzi.zza().zza(zzmm.zzi.zzd.GET_PHOTO).zza(zza(task)).zza((int) (j2 - j)).zzf()));
    }

    private final zzmm.zzah.zzb zza() {
        Locale zzc2 = this.zzc.zzc();
        Locale locale = Locale.getDefault();
        zzmm.zzah.zzb zza2 = zzmm.zzah.zza().zza(zzc2.toString());
        if (!zzc2.equals(locale)) {
            zza2.zzb(locale.toString());
        }
        return zza2;
    }

    private final void zza(zzmm.zzi zzi) {
        zza((zzmm.zzs) ((zzrb) zzda.zza(this.zzb).zza(zzmm.zzs.zzc.NETWORK_REQUEST_EVENT).zza(zzi).zzf()));
    }

    private final void zza(zzmm.zzs zzs) {
        this.zza.newEvent(zzda.zza(zzs).zzd()).log();
    }

    private static <ResponseT> zzmm.zzi.zzf zza(Task<ResponseT> task) {
        ApiException apiException;
        if (task.isSuccessful()) {
            return zzmm.zzi.zzf.SUCCESS;
        }
        ApiException exception = task.getException();
        if (exception instanceof ApiException) {
            apiException = exception;
        } else {
            apiException = new ApiException(new Status(13, exception.getMessage()));
        }
        int statusCode = apiException.getStatusCode();
        if (statusCode == 7) {
            return zzmm.zzi.zzf.NETWORK_ERROR;
        }
        if (statusCode != 15) {
            return zzmm.zzi.zzf.INVALID;
        }
        return zzmm.zzi.zzf.TIMEOUT;
    }
}
