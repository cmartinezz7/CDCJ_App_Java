package com.google.android.libraries.places.internal;

import android.database.DataSetObserver;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzeu extends DataSetObserver {
    private final /* synthetic */ RecyclerView.AdapterDataObserver zza;

    zzeu(zzes zzes, RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.zza = adapterDataObserver;
    }

    public final void onChanged() {
        try {
            this.zza.onChanged();
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final void onInvalidated() {
        try {
            this.zza.onChanged();
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }
}
