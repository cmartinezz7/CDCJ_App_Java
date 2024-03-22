package com.google.android.libraries.places.internal;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzed implements AdapterView.OnItemClickListener, Filterable, ListAdapter {
    CancellationTokenSource zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final PlacesClient zzc;
    /* access modifiers changed from: private */
    public final zzeq zzd;
    private final Set<DataSetObserver> zze = new HashSet();
    private final zzei zzf = new zzei(this);
    private boolean zzg;
    /* access modifiers changed from: private */
    public zzel zzh;
    private PlaceSelectionListener zzi;
    private zzem zzj;
    /* access modifiers changed from: private */
    public AutocompleteSessionToken zzk;

    zzed(Context context, PlacesClient placesClient, zzeq zzeq) {
        this.zzb = context;
        this.zzc = placesClient;
        this.zzd = zzeq;
        if (zzeq.zza().isEmpty()) {
            this.zzh = zzel.zzf;
        } else {
            this.zzh = zzel.zzg;
        }
    }

    public final void zza(AutocompleteSessionToken autocompleteSessionToken) {
        this.zzk = autocompleteSessionToken;
    }

    public final void zza(PlaceSelectionListener placeSelectionListener) {
        this.zzi = placeSelectionListener;
    }

    public final void zza(zzem zzem) {
        this.zzj = zzem;
    }

    public final int getCount() {
        int i = this.zzh.zza;
        if (i == 2) {
            return this.zzh.zzc.size() + 1;
        }
        if (i != 4) {
            return 1;
        }
        return this.zzh.zzc.size() + 1;
    }

    public final boolean isEmpty() {
        return getCount() == 0;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final int getItemViewType(int i) {
        int i2 = this.zzh.zza;
        if ((i2 == 2 || i2 == 4) && i < this.zzh.zzc.size()) {
            return 1;
        }
        return 0;
    }

    public final boolean isEnabled(int i) {
        return getItemViewType(i) == 1;
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        LayoutInflater from = LayoutInflater.from(this.zzb);
        if (itemViewType == 0) {
            if (view == null) {
                view = from.inflate(R.layout.places_autocomplete_item_powered_by_google, viewGroup, false);
            }
            zza(view);
        } else if (itemViewType == 1) {
            if (view == null) {
                view = from.inflate(R.layout.places_autocomplete_item_prediction, viewGroup, false);
            }
            zza(view, i);
        } else if (Log.isLoggable("Places", 6)) {
            Log.e("Places", "Unknown view type.");
        }
        return view;
    }

    public final void zza(View view) {
        int i = 4;
        boolean z = true;
        int i2 = 0;
        boolean z2 = (this.zzh.zza == 2 && this.zzh.zzc.isEmpty()) || (this.zzh.zza == 4 && this.zzh.zzc.isEmpty()) || this.zzh.zza == 3 || this.zzh.zza == 6 || this.zzh.zza == 5;
        if (getCount() <= 1) {
            z = false;
        }
        View findViewById = view.findViewById(R.id.places_autocomplete_progress);
        if (z2) {
            i = 0;
        }
        findViewById.setVisibility(i);
        View findViewById2 = view.findViewById(R.id.places_autocomplete_separator);
        if (!z) {
            i2 = 8;
        }
        findViewById2.setVisibility(i2);
    }

    public final void zza(View view, int i) {
        AutocompletePrediction autocompletePrediction = (AutocompletePrediction) getItem(i);
        TextView textView = (TextView) view.findViewById(R.id.places_autocomplete_prediction_secondary_text);
        SpannableString primaryText = autocompletePrediction.getPrimaryText(new ForegroundColorSpan(view.getContext().getResources().getColor(R.color.places_autocomplete_prediction_primary_text_highlight)));
        SpannableString secondaryText = autocompletePrediction.getSecondaryText((CharacterStyle) null);
        ((TextView) view.findViewById(R.id.places_autocomplete_prediction_primary_text)).setText(primaryText);
        textView.setText(secondaryText);
        View findViewById = view.findViewById(R.id.places_autocomplete_separator);
        if (TextUtils.isEmpty(secondaryText)) {
            textView.setVisibility(8);
            findViewById.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        findViewById.setVisibility(0);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.zzh.zza()) {
            zza(i, (AutocompletePrediction) getItem(i));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        if (this.zzh.zza() && this.zzh.zzd >= 0 && this.zzh.zzd < this.zzh.zzc.size()) {
            zza(this.zzh.zzd, this.zzh.zzc.get(this.zzh.zzd));
        }
    }

    private final void zza(int i, AutocompletePrediction autocompletePrediction) {
        if (!zzd()) {
            this.zza = new CancellationTokenSource();
            zza(new zzel(5, (Status) null, this.zzh.zzc, i, (Place) null));
            this.zzc.fetchPlace(FetchPlaceRequest.builder(autocompletePrediction.getPlaceId(), this.zzd.zza()).setSessionToken(this.zzk).setCancellationToken(this.zza.getToken()).build()).addOnSuccessListener(new zzeg(this)).addOnFailureListener(new zzef(this));
        }
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.zze.add(dataSetObserver);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.zze.remove(dataSetObserver);
    }

    public final Filter getFilter() {
        return this.zzf;
    }

    public final zzel zzb() {
        return this.zzh;
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzg = true;
        zzd();
    }

    /* access modifiers changed from: private */
    public final boolean zzd() {
        CancellationTokenSource cancellationTokenSource = this.zza;
        if (cancellationTokenSource != null) {
            cancellationTokenSource.cancel();
        }
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzel zzel) {
        int statusCode;
        PlaceSelectionListener placeSelectionListener;
        String str;
        if (this.zzh != zzel.zzf) {
            this.zzh = zzel;
            if (zzel.zza == 3 || zzel.zza == 6) {
                if (Log.isLoggable("Places", 6)) {
                    if (zzel.zzb != null) {
                        str = PlacesStatusCodes.getStatusCodeString(zzel.zzb.getStatusCode());
                    } else {
                        str = "Unknown";
                    }
                    String valueOf = String.valueOf(str);
                    Log.e("Places", valueOf.length() != 0 ? "Error while autocompleting: ".concat(valueOf) : new String("Error while autocompleting: "));
                }
                if (zzel.zzb != null && (((statusCode = zzel.zzb.getStatusCode()) == 9011 || statusCode == 9012) && (placeSelectionListener = this.zzi) != null)) {
                    placeSelectionListener.onError(zzel.zzb);
                }
            }
            for (DataSetObserver next : this.zze) {
                if (!this.zzh.zzc.isEmpty()) {
                    next.onChanged();
                } else {
                    next.onInvalidated();
                }
            }
            zzem zzem = this.zzj;
            if (zzem != null) {
                zzem.zza(this.zzh);
            }
        }
    }

    /* access modifiers changed from: private */
    public static Status zzb(Exception exc) {
        if (!(exc instanceof ApiException)) {
            return new Status(13, exc.getMessage());
        }
        ApiException apiException = (ApiException) exc;
        return new Status(apiException.getStatusCode(), apiException.getStatusMessage());
    }

    public final /* synthetic */ Object getItem(int i) {
        int i2 = this.zzh.zza;
        if ((i2 == 2 || i2 == 4) && i < this.zzh.zzc.size()) {
            return this.zzh.zzc.get(i);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Exception exc) {
        this.zza = null;
        zza(zzel.zza(this.zzh, zzb(exc)));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(FetchPlaceResponse fetchPlaceResponse) {
        this.zza = null;
        zza(zzel.zza(this.zzh, fetchPlaceResponse.getPlace()));
        PlaceSelectionListener placeSelectionListener = this.zzi;
        if (placeSelectionListener != null) {
            placeSelectionListener.onPlaceSelected(this.zzh.zze);
        }
    }
}
