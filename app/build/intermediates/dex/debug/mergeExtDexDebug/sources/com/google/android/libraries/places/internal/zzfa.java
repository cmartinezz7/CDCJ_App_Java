package com.google.android.libraries.places.internal;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzfa implements View.OnClickListener {
    private final zzex zza;
    private final zzed zzb;
    private final int zzc;

    zzfa(zzex zzex, zzed zzed, int i) {
        this.zza = zzex;
        this.zzb = zzed;
        this.zzc = i;
    }

    public final void onClick(View view) {
        zzex zzex = this.zza;
        zzed zzed = this.zzb;
        int i = this.zzc;
        try {
            zzed.onItemClick((AdapterView<?>) null, zzex.itemView, i, (long) i);
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }
}
