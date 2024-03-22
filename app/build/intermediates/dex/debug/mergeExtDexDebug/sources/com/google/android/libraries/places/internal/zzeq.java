package com.google.android.libraries.places.internal;

import android.content.Intent;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public abstract class zzeq {
    public abstract zzgv<Place.Field> zza();

    public abstract LocationBias zzb();

    public abstract LocationRestriction zzc();

    public abstract String zzd();

    public abstract TypeFilter zze();

    public static zzeq zza(Intent intent) {
        return new zzdk().zza((List<Place.Field>) intent.getParcelableArrayListExtra("place_fields")).zza(intent.getParcelableExtra("location_bias")).zza(intent.getParcelableExtra("location_restriction")).zza(intent.getStringExtra("country")).zza(intent.getSerializableExtra("types")).zza();
    }
}
