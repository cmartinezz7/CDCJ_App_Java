package com.google.android.libraries.places.widget;

import android.view.View;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzd implements View.OnClickListener {
    private final AutocompleteSupportFragment zza;

    zzd(AutocompleteSupportFragment autocompleteSupportFragment) {
        this.zza = autocompleteSupportFragment;
    }

    public final void onClick(View view) {
        this.zza.setText("");
    }
}
