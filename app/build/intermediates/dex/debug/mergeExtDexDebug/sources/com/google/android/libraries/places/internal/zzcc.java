package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.TypeFilter;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzcc {
    private static final zzha<TypeFilter, String> zza = new zzgz().zza(TypeFilter.ADDRESS, "address").zza(TypeFilter.CITIES, "(cities)").zza(TypeFilter.ESTABLISHMENT, "establishment").zza(TypeFilter.GEOCODE, "geocode").zza(TypeFilter.REGIONS, "(regions)").zza();

    public static String zza(TypeFilter typeFilter) {
        return zza.get(typeFilter);
    }
}
