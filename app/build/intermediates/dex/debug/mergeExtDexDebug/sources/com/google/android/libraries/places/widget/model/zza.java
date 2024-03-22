package com.google.android.libraries.places.widget.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zza implements Parcelable.Creator<AutocompleteActivityMode> {
    zza() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AutocompleteActivityMode[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return AutocompleteActivityMode.valueOf(parcel.readString());
    }
}
