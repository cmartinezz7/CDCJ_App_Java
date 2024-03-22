package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public enum zzdf implements Parcelable {
    FRAGMENT,
    INTENT;
    
    public static final Parcelable.Creator<zzdf> CREATOR = null;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }

    static {
        CREATOR = new zzdh();
    }
}
