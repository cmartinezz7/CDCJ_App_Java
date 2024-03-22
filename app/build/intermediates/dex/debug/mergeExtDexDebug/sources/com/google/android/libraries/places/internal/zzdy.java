package com.google.android.libraries.places.internal;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzdy extends RecyclerView.OnScrollListener {
    private final /* synthetic */ zzdn zza;

    zzdy(zzdn zzdn) {
        this.zza = zzdn;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 1) {
            try {
                this.zza.zzh();
            } catch (Error | RuntimeException e) {
                zzdc.zza(e);
                throw e;
            }
        }
    }
}
