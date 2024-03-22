package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzba extends zzbm<Object, FetchPhotoRequest> {
    zzba(FetchPhotoRequest fetchPhotoRequest, String str, boolean z, zzcu zzcu) {
        super(fetchPhotoRequest, (Locale) null, str, z, zzcu);
    }

    public final Map<String, String> zze() {
        FetchPhotoRequest zza = zza();
        PhotoMetadata photoMetadata = zza.getPhotoMetadata();
        HashMap hashMap = new HashMap();
        zza(hashMap, "maxheight", zza.getMaxHeight(), (Object) null);
        zza(hashMap, "maxwidth", zza.getMaxWidth(), (Object) null);
        hashMap.put("photoreference", photoMetadata.zza());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final String zzf() {
        return "photo";
    }
}
