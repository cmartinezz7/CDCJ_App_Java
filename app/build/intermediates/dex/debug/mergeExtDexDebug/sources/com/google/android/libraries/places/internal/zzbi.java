package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.internal.zzaz;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzbi extends zzbl<Object, FindAutocompletePredictionsResponse> {
    private String errorMessage;
    private zzaz[] predictions;
    private String status;

    zzbi() {
    }

    public final FindAutocompletePredictionsResponse zza() throws ApiException {
        int zza = zzcb.zza(this.status);
        if (!PlacesStatusCodes.isError(zza)) {
            ArrayList arrayList = new ArrayList();
            zzaz[] zzazArr = this.predictions;
            if (zzazArr != null) {
                for (zzaz zzaz : zzazArr) {
                    if (zzaz == null || TextUtils.isEmpty(zzaz.zzb())) {
                        throw new ApiException(new Status(8, "Unexpected server error: Place ID not provided for an autocomplete prediction result"));
                    }
                    AutocompletePrediction.Builder zza2 = AutocompletePrediction.builder(zzaz.zzb()).setPlaceTypes(zzbz.zzb(zzbz.zza((List<String>) zzaz.zzd()))).setFullText(zzgl.zza(zzaz.zza())).zza(zza(zzaz.zze()));
                    zzaz.zza zzc = zzaz.zzc();
                    if (zzc != null) {
                        zza2.setPrimaryText(zzgl.zza(zzc.zza())).zzb(zza(zzc.zzc())).setSecondaryText(zzgl.zza(zzc.zzb())).zzc(zza(zzc.zzd()));
                    }
                    arrayList.add(zza2.build());
                }
            }
            return FindAutocompletePredictionsResponse.newInstance(arrayList);
        }
        throw new ApiException(new Status(zza, zzcb.zza(this.status, this.errorMessage)));
    }

    private static List<AutocompletePrediction.zza> zza(List<zzaz.zzb> list) throws ApiException {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (zzaz.zzb next : list) {
            if (next == null || next.offset == null || next.length == null) {
                throw new ApiException(new Status(8, "Unexpected server error: Place ID not provided for an autocomplete prediction result"));
            }
            arrayList.add(AutocompletePrediction.zza.zzc().zza(next.offset.intValue()).zzb(next.length.intValue()).zza());
        }
        return arrayList;
    }
}
