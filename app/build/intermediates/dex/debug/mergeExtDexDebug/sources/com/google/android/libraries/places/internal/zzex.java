package com.google.android.libraries.places.internal;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzex extends RecyclerView.ViewHolder {
    private int zza = -1;
    private boolean zzb = false;

    public zzex(View view) {
        super(view);
    }

    public final void zza(zzed zzed, int i, boolean z) {
        this.zza = i;
        this.zzb = z;
        zzed.zza(this.itemView, i);
        this.itemView.setOnClickListener(new zzfa(this, zzed, i));
    }

    public final int zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzb;
    }
}
