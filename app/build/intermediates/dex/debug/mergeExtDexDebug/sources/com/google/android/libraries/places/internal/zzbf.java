package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzbf extends zzbm<Object, FindAutocompletePredictionsRequest> {
    zzbf(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, Locale locale, String str, boolean z, zzcu zzcu) {
        super(findAutocompletePredictionsRequest, locale, str, z, zzcu);
    }

    public final Map<String, String> zze() {
        String str;
        FindAutocompletePredictionsRequest zza = zza();
        HashMap hashMap = new HashMap();
        String query = zza.getQuery();
        if (query == null) {
            str = null;
        } else {
            str = query.replaceFirst("^\\s+", "").replaceFirst("\\s+$", " ");
        }
        zza(hashMap, "input", str, (Object) null);
        zza(hashMap, "types", zzcc.zza(zza.getTypeFilter()), (Object) null);
        zza(hashMap, "sessiontoken", zza.getSessionToken(), (Object) null);
        zza(hashMap, "locationbias", zzca.zza(zza.getLocationBias()), (Object) null);
        zza(hashMap, "locationrestriction", zzca.zza(zza.getLocationRestriction()), (Object) null);
        zza(hashMap, "components", zzca.zza(zza.getCountry()), (Object) null);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final String zzf() {
        return "autocomplete/json";
    }
}
