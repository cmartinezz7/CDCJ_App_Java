package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzdh implements Parcelable.Creator<zzdf> {
    zzdh() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdf[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdf.valueOf(parcel.readString());
    }
}
