package com.google.android.libraries.places.internal;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzdt implements TextView.OnEditorActionListener {
    private final zzdn zza;

    zzdt(zzdn zzdn) {
        this.zza = zzdn;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return this.zza.zza(textView, i, keyEvent);
    }
}
