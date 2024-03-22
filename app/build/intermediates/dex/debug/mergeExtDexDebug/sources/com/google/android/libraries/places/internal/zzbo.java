package com.google.android.libraries.places.internal;

import android.location.Location;
import android.text.TextUtils;
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

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzbo implements zzv {
    private final zzcr zza;
    private final zzcu zzb;
    private final zzy zzc;
    private final zzae zzd;
    private final zzcp zze;
    private final zzb zzf;

    zzbo(zzcr zzcr, zzcu zzcu, zzy zzy, zzae zzae, zzcp zzcp, zzb zzb2) {
        this.zza = zzcr;
        this.zzb = zzcu;
        this.zzc = zzy;
        this.zzd = zzae;
        this.zze = zzcp;
        this.zzf = zzb2;
    }

    public final Task<FindAutocompletePredictionsResponse> zza(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest) {
        String query = findAutocompletePredictionsRequest.getQuery();
        if (query == null || TextUtils.isEmpty(query.trim())) {
            return Tasks.forResult(FindAutocompletePredictionsResponse.newInstance(zzgv.zza()));
        }
        return this.zzc.zza(new zzbf(findAutocompletePredictionsRequest, this.zza.zzc(), this.zza.zzb(), this.zza.zzd(), this.zzb), zzbi.class).continueWith(zzbn.zza).continueWith(new zzbq(this, this.zzf.zza()));
    }

    public final Task<FetchPhotoResponse> zza(FetchPhotoRequest fetchPhotoRequest) {
        Integer maxWidth = fetchPhotoRequest.getMaxWidth();
        Integer maxHeight = fetchPhotoRequest.getMaxHeight();
        if (maxWidth == null && maxHeight == null) {
            return Tasks.forException(new ApiException(new Status(9012, "Must include max width or max height in request.")));
        }
        if (maxWidth != null && maxWidth.intValue() <= 0) {
            return Tasks.forException(new ApiException(new Status(9012, String.format("Max Width must not be < 1, but was: %d.", new Object[]{maxWidth}))));
        } else if (maxHeight == null || maxHeight.intValue() > 0) {
            return this.zzd.zza(new zzba(fetchPhotoRequest, this.zza.zzb(), this.zza.zzd(), this.zzb), new zzbe()).continueWith(zzbp.zza).continueWith(new zzbs(this, this.zzf.zza()));
        } else {
            return Tasks.forException(new ApiException(new Status(9012, String.format("Max Height must not be < 1, but was: %d.", new Object[]{maxHeight}))));
        }
    }

    public final Task<FetchPlaceResponse> zza(FetchPlaceRequest fetchPlaceRequest) {
        if (TextUtils.isEmpty(fetchPlaceRequest.getPlaceId())) {
            return Tasks.forException(new ApiException(new Status(9012, "Place ID must not be empty.")));
        }
        if (fetchPlaceRequest.getPlaceFields().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Place Fields must not be empty.")));
        }
        return this.zzc.zza(new zzbd(fetchPlaceRequest, this.zza.zzc(), this.zza.zzb(), this.zza.zzd(), this.zzb), zzbg.class).continueWith(zzbr.zza).continueWith(new zzbu(this, this.zzf.zza()));
    }

    public final Task<FindCurrentPlaceResponse> zza(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, zzgv<zzq> zzgv) {
        if (findCurrentPlaceRequest.getPlaceFields().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Place Fields must not be empty.")));
        }
        return this.zzc.zza(new zzbh(findCurrentPlaceRequest, location, zzgv, this.zza.zzc(), this.zza.zzb(), this.zza.zzd(), this.zzb), zzbk.class).continueWith(zzbt.zza).continueWith(new zzbw(this, this.zzf.zza()));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ FindCurrentPlaceResponse zza(long j, Task task) throws Exception {
        this.zze.zzc(task, j, this.zzf.zza());
        return (FindCurrentPlaceResponse) task.getResult();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ FetchPlaceResponse zzb(long j, Task task) throws Exception {
        this.zze.zzb(task, j, this.zzf.zza());
        return (FetchPlaceResponse) task.getResult();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ FetchPhotoResponse zzc(long j, Task task) throws Exception {
        this.zze.zzd(task, j, this.zzf.zza());
        return (FetchPhotoResponse) task.getResult();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ FindAutocompletePredictionsResponse zzd(long j, Task task) throws Exception {
        this.zze.zza(task, j, this.zzf.zza());
        return (FindAutocompletePredictionsResponse) task.getResult();
    }
}
