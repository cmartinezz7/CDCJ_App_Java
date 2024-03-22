package com.google.android.libraries.places.widget.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public enum AutocompleteActivityMode implements Parcelable {
    FULLSCREEN,
    OVERLAY;
    
    public static final Parcelable.Creator<AutocompleteActivityMode> CREATOR = null;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }

    static {
        CREATOR = new zza();
    }
}
