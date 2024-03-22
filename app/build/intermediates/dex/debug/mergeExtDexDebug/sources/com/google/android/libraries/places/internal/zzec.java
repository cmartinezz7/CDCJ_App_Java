package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzea;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzec implements Parcelable.Creator<zzea> {
    zzec() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzea[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzea((zzea.zza) parcel.readParcelable(zzea.zza.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
    }
}
