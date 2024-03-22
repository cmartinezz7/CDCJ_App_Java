package com.google.android.libraries.places.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.TypedValue;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.zzdc;
import com.google.android.libraries.places.internal.zzdf;
import com.google.android.libraries.places.internal.zzdg;
import com.google.android.libraries.places.internal.zzgg;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.tealium.library.DataSources;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class Autocomplete {
    private Autocomplete() {
    }

    public static Place getPlaceFromIntent(Intent intent) {
        try {
            zzgg.zza(intent, (Object) "Intent must not be null.");
            Place parcelableExtra = intent.getParcelableExtra("selected_place");
            zzgg.zza(parcelableExtra != null, (Object) "Intent expected to contain a Place, but doesn't.");
            return parcelableExtra;
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public static class IntentBuilder extends zzdg {
        private final AutocompleteActivityMode zza;
        private final List<Place.Field> zzb;
        private zzdf zzc = zzdf.INTENT;
        private String zzd;
        private String zze;
        private LocationBias zzf;
        private LocationRestriction zzg;
        private String zzh;
        private TypeFilter zzi;

        public IntentBuilder(AutocompleteActivityMode autocompleteActivityMode, List<Place.Field> list) {
            this.zza = autocompleteActivityMode;
            this.zzb = list;
        }

        public final IntentBuilder zza(zzdf zzdf) {
            this.zzc = zzdf;
            return this;
        }

        public IntentBuilder setInitialQuery(String str) {
            this.zzd = str;
            return this;
        }

        public IntentBuilder setHint(String str) {
            this.zze = str;
            return this;
        }

        public IntentBuilder setLocationBias(LocationBias locationBias) {
            this.zzf = locationBias;
            return this;
        }

        public IntentBuilder setLocationRestriction(LocationRestriction locationRestriction) {
            this.zzg = locationRestriction;
            return this;
        }

        public IntentBuilder setCountry(String str) {
            this.zzh = str;
            return this;
        }

        public IntentBuilder setTypeFilter(TypeFilter typeFilter) {
            this.zzi = typeFilter;
            return this;
        }

        public Intent build(Context context) {
            Class<AutocompleteActivity> cls = AutocompleteActivity.class;
            try {
                Intent intent = new Intent();
                intent.setClass(context, cls);
                Resources.Theme theme = context.getTheme();
                TypedValue typedValue = new TypedValue();
                TypedValue typedValue2 = new TypedValue();
                if (theme.resolveAttribute(16843827, typedValue, true) && !intent.hasExtra("primary_color")) {
                    intent.putExtra("primary_color", typedValue.data);
                }
                if (theme.resolveAttribute(16843828, typedValue2, true) && !intent.hasExtra("primary_color_dark")) {
                    intent.putExtra("primary_color_dark", typedValue2.data);
                }
                zza(intent, "mode", (Parcelable) this.zza);
                intent.putExtra("place_fields", new ArrayList(this.zzb));
                zza(intent, DataSources.Key.ORIGIN, (Parcelable) this.zzc);
                zza(intent, "initial_query", this.zzd);
                zza(intent, "hint", this.zze);
                zza(intent, "location_bias", (Parcelable) this.zzf);
                zza(intent, "location_restriction", (Parcelable) this.zzg);
                zza(intent, "country", this.zzh);
                TypeFilter typeFilter = this.zzi;
                if (typeFilter != null) {
                    intent.putExtra("types", typeFilter);
                } else {
                    intent.removeExtra("types");
                }
                return intent;
            } catch (Error | RuntimeException e) {
                zzdc.zza(e);
                throw e;
            }
        }
    }

    public static Status getStatusFromIntent(Intent intent) {
        try {
            zzgg.zza(intent, (Object) "Intent must not be null.");
            Status parcelableExtra = intent.getParcelableExtra("status");
            zzgg.zza(parcelableExtra != null, (Object) "Intent expected to contain a Status, but doesn't.");
            return parcelableExtra;
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }
}
