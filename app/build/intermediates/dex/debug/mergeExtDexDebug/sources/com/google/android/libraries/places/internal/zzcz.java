package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzdb;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzcz {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[zzdb.zzb.values().length];
        zza = iArr;
        try {
            iArr[zzdb.zzb.AUTOCOMPLETE_WIDGET.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zza[zzdb.zzb.PROGRAMMATIC_API.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
