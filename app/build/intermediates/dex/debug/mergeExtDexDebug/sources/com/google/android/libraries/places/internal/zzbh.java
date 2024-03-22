package com.google.android.libraries.places.internal;

import android.location.Location;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.tealium.library.DataSources;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzbh extends zzbm<Object, FindCurrentPlaceRequest> {
    private final Location zza;
    private final zzgv<zzq> zzb;

    zzbh(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, zzgv<zzq> zzgv, Locale locale, String str, boolean z, zzcu zzcu) {
        super(findCurrentPlaceRequest, locale, str, z, zzcu);
        this.zza = location;
        this.zzb = zzgv;
    }

    public final Map<String, String> zze() {
        HashMap hashMap = new HashMap();
        zza(hashMap, "location", zzca.zzb(this.zza), (Object) null);
        zza(hashMap, "wifiaccesspoints", zzca.zza(this.zzb), (Object) null);
        zza(hashMap, "precision", zzca.zza(this.zza), (Object) null);
        zza(hashMap, DataSources.Key.TIMESTAMP, Long.valueOf(this.zza.getTime()), (Object) null);
        zza(hashMap, "fields", zzcd.zzb(zza().getPlaceFields()), (Object) null);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final String zzf() {
        return "findplacefromuserlocation/json";
    }
}
