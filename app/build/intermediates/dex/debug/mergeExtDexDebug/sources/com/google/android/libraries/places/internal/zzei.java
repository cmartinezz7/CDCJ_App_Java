package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.widget.Filter;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzei extends Filter {
    final /* synthetic */ zzed zza;
    private Runnable zzb;

    public zzei(zzed zzed) {
        this.zza = zzed;
    }

    /* access modifiers changed from: protected */
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        this.zzb = null;
        if (TextUtils.isEmpty(charSequence)) {
            return zza(zzel.zzg);
        }
        this.zzb = new zzeh(this, charSequence);
        return zza(new zzel(2, (Status) null, this.zza.zzh.zzc, -1, (Place) null));
    }

    /* access modifiers changed from: protected */
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        this.zza.zza((zzel) filterResults.values);
        Runnable runnable = this.zzb;
        if (runnable != null) {
            runnable.run();
            this.zzb = null;
        }
    }

    public final CharSequence convertResultToString(Object obj) {
        if (!(obj instanceof AutocompletePrediction)) {
            return super.convertResultToString(obj);
        }
        return ((AutocompletePrediction) obj).getPrimaryText((CharacterStyle) null);
    }

    private static Filter.FilterResults zza(zzel zzel) {
        Filter.FilterResults filterResults = new Filter.FilterResults();
        filterResults.values = zzel;
        filterResults.count = zzel.zzc.size();
        return filterResults;
    }
}
