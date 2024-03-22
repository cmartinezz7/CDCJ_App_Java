package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzdk extends zzep {
    private zzgv<Place.Field> zza;
    private LocationBias zzb;
    private LocationRestriction zzc;
    private String zzd;
    private TypeFilter zze;

    zzdk() {
    }

    /* access modifiers changed from: package-private */
    public final zzep zza(List<Place.Field> list) {
        this.zza = zzgv.zza(list);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzep zza(LocationBias locationBias) {
        this.zzb = locationBias;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzep zza(LocationRestriction locationRestriction) {
        this.zzc = locationRestriction;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzep zza(String str) {
        this.zzd = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzep zza(TypeFilter typeFilter) {
        this.zze = typeFilter;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzeq zza() {
        String str = "";
        if (this.zza == null) {
            str = String.valueOf(str).concat(" placeFields");
        }
        if (str.isEmpty()) {
            return new zzdi(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
