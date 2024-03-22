package com.google.android.libraries.places.internal;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzes extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
    /* access modifiers changed from: private */
    public final zzed zza;
    private final Map<RecyclerView.AdapterDataObserver, DataSetObserver> zzb = new HashMap();
    /* access modifiers changed from: private */
    public int zzc;
    /* access modifiers changed from: private */
    public int zzd;

    zzes(zzed zzed) {
        this.zza = zzed;
        setHasStableIds(true);
        zzed.registerDataSetObserver(new zzer(this));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        try {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            if (i == 0) {
                return new zzey(from.inflate(R.layout.places_autocomplete_item_powered_by_google, viewGroup, false));
            }
            if (i == 1) {
                return new zzex(from.inflate(R.layout.places_autocomplete_item_prediction, viewGroup, false));
            }
            throw new IllegalStateException();
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final int getItemViewType(int i) {
        try {
            return this.zza.getItemViewType(i);
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        try {
            int itemViewType = this.zza.getItemViewType(i);
            if (itemViewType != 0) {
                boolean z = true;
                if (itemViewType == 1) {
                    if (this.zzc != 0 || this.zzd <= 0) {
                        z = false;
                    }
                    ((zzex) viewHolder).zza(this.zza, i, z);
                    return;
                }
                return;
            }
            this.zza.zza(((zzey) viewHolder).itemView);
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        try {
            zzes.super.registerAdapterDataObserver(adapterDataObserver);
            zzeu zzeu = new zzeu(this, adapterDataObserver);
            this.zza.registerDataSetObserver(zzeu);
            this.zzb.put(adapterDataObserver, zzeu);
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        try {
            zzes.super.unregisterAdapterDataObserver(adapterDataObserver);
            if (this.zzb.containsKey(adapterDataObserver)) {
                this.zza.unregisterDataSetObserver(this.zzb.get(adapterDataObserver));
                this.zzb.remove(adapterDataObserver);
            }
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final int getItemCount() {
        try {
            return this.zza.getCount();
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final long getItemId(int i) {
        try {
            if (this.zza.getItemViewType(i) != 1) {
                return -1;
            }
            return (long) ((AutocompletePrediction) this.zza.getItem(i)).getPlaceId().hashCode();
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzei getFilter() {
        try {
            return (zzei) this.zza.getFilter();
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zza.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        this.zza.zzc();
    }

    public final void zza(zzel zzel) {
        this.zza.zza(zzel);
    }

    public final zzel zzc() {
        return this.zza.zzb();
    }

    public final void zza(zzem zzem) {
        this.zza.zza(zzem);
    }

    public final void zza(PlaceSelectionListener placeSelectionListener) {
        this.zza.zza(placeSelectionListener);
    }

    public final void zza(AutocompleteSessionToken autocompleteSessionToken) {
        this.zza.zza(autocompleteSessionToken);
    }
}
