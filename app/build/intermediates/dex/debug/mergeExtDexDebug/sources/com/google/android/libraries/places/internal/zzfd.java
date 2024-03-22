package com.google.android.libraries.places.internal;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzfd {
    public static void zza(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
