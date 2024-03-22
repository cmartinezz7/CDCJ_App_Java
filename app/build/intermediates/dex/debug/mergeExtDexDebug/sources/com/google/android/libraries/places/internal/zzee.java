package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzea;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzee implements Parcelable.Creator<zzea.zza> {
    zzee() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzea.zza[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzea.zza.valueOf(parcel.readString());
    }
}
