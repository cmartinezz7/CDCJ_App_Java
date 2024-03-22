package com.google.android.libraries.places.widget;

import android.view.View;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zza implements View.OnClickListener {
    private final AutocompleteFragment zza;

    zza(AutocompleteFragment autocompleteFragment) {
        this.zza = autocompleteFragment;
    }

    public final void onClick(View view) {
        this.zza.setText("");
    }
}
