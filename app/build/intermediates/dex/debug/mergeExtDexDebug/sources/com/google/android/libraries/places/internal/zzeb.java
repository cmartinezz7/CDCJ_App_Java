package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzeb {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[AutocompleteActivityMode.values().length];
        zza = iArr;
        try {
            iArr[AutocompleteActivityMode.OVERLAY.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zza[AutocompleteActivityMode.FULLSCREEN.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
