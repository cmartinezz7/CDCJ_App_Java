package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzdi extends zzeq {
    private final zzgv<Place.Field> zza;
    private final LocationBias zzb;
    private final LocationRestriction zzc;
    private final String zzd;
    private final TypeFilter zze;

    private zzdi(zzgv<Place.Field> zzgv, LocationBias locationBias, LocationRestriction locationRestriction, String str, TypeFilter typeFilter) {
        this.zza = zzgv;
        this.zzb = locationBias;
        this.zzc = locationRestriction;
        this.zzd = str;
        this.zze = typeFilter;
    }

    public final zzgv<Place.Field> zza() {
        return this.zza;
    }

    public final LocationBias zzb() {
        return this.zzb;
    }

    public final LocationRestriction zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final TypeFilter zze() {
        return this.zze;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        String valueOf3 = String.valueOf(this.zzc);
        String str = this.zzd;
        String valueOf4 = String.valueOf(this.zze);
        return new StringBuilder(String.valueOf(valueOf).length() + 93 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(str).length() + String.valueOf(valueOf4).length()).append("AutocompleteOptions{placeFields=").append(valueOf).append(", locationBias=").append(valueOf2).append(", locationRestriction=").append(valueOf3).append(", country=").append(str).append(", typeFilter=").append(valueOf4).append("}").toString();
    }

    public final boolean equals(Object obj) {
        LocationBias locationBias;
        LocationRestriction locationRestriction;
        String str;
        TypeFilter typeFilter;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeq)) {
            return false;
        }
        zzeq zzeq = (zzeq) obj;
        if (!this.zza.equals(zzeq.zza()) || ((locationBias = this.zzb) != null ? !locationBias.equals(zzeq.zzb()) : zzeq.zzb() != null) || ((locationRestriction = this.zzc) != null ? !locationRestriction.equals(zzeq.zzc()) : zzeq.zzc() != null) || ((str = this.zzd) != null ? !str.equals(zzeq.zzd()) : zzeq.zzd() != null) || ((typeFilter = this.zze) != null ? !typeFilter.equals(zzeq.zze()) : zzeq.zze() != null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        LocationBias locationBias = this.zzb;
        int i = 0;
        int hashCode2 = (hashCode ^ (locationBias == null ? 0 : locationBias.hashCode())) * 1000003;
        LocationRestriction locationRestriction = this.zzc;
        int hashCode3 = (hashCode2 ^ (locationRestriction == null ? 0 : locationRestriction.hashCode())) * 1000003;
        String str = this.zzd;
        int hashCode4 = (hashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        TypeFilter typeFilter = this.zze;
        if (typeFilter != null) {
            i = typeFilter.hashCode();
        }
        return hashCode4 ^ i;
    }
}
