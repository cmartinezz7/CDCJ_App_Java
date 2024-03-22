package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzbd extends zzbm<Object, FetchPlaceRequest> {
    zzbd(FetchPlaceRequest fetchPlaceRequest, Locale locale, String str, boolean z, zzcu zzcu) {
        super(fetchPlaceRequest, locale, str, z, zzcu);
    }

    public final Map<String, String> zze() {
        FetchPlaceRequest zza = zza();
        HashMap hashMap = new HashMap();
        zza(hashMap, "placeid", zza.getPlaceId(), (Object) null);
        zza(hashMap, "sessiontoken", zza.getSessionToken(), (Object) null);
        zza(hashMap, "fields", zzcd.zzb(zza.getPlaceFields()), (Object) null);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final String zzf() {
        return "details/json";
    }
}
