package com.google.android.libraries.places.internal;

import android.database.DataSetObserver;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzer extends DataSetObserver {
    private final /* synthetic */ zzes zza;

    zzer(zzes zzes) {
        this.zza = zzes;
    }

    public final void onChanged() {
        try {
            zzes zzes = this.zza;
            int unused = zzes.zzc = zzes.zzd;
            zzes zzes2 = this.zza;
            int unused2 = zzes2.zzd = zzes2.zza.getCount();
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final void onInvalidated() {
        zzes zzes = this.zza;
        int unused = zzes.zzc = zzes.zzd = 0;
    }
}
