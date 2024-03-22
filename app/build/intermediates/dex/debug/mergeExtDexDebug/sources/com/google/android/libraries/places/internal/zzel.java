package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzel implements Parcelable {
    public static final Parcelable.Creator<zzel> CREATOR = new zzeo();
    static final zzel zzf = new zzel(-1, new Status(9012, "Place Fields must not be empty."), zzgv.zza(), -1, (Place) null);
    public static final zzel zzg = new zzel(1, (Status) null, zzgv.zza(), -1, (Place) null);
    public final int zza;
    final Status zzb;
    public final List<AutocompletePrediction> zzc;
    public final int zzd;
    final Place zze;

    public static zzel zza(List<AutocompletePrediction> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (AutocompletePrediction next : list) {
            if (!TextUtils.isEmpty(next.getPlaceId())) {
                arrayList.add(next);
            }
        }
        return new zzel(4, new Status(0), arrayList, -1, (Place) null);
    }

    public static zzel zza(zzel zzel, Place place) {
        if (zzel.zza != 5) {
            return zzel;
        }
        return new zzel(7, new Status(0), zzel.zzc, zzel.zzd, place);
    }

    public static zzel zza(zzel zzel, Status status) {
        if (zzel.zza != 5) {
            return zzel;
        }
        return new zzel(6, status, zzel.zzc, zzel.zzd, (Place) null);
    }

    zzel(int i, Status status, List<AutocompletePrediction> list, int i2, Place place) {
        this.zza = i;
        this.zzb = status;
        this.zzc = list;
        this.zzd = i2;
        this.zze = place;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        int i = this.zza;
        if (i == 5 || i == 6 || i == 7) {
            return true;
        }
        return false;
    }

    public static zzel zza(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, AutocompletePrediction.class.getClassLoader());
        return new zzel(parcel.readInt(), parcel.readParcelable(Status.class.getClassLoader()), arrayList, parcel.readInt(), parcel.readParcelable(Place.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeParcelable(this.zzb, i);
        parcel.writeList(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeParcelable(this.zze, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzel)) {
            return false;
        }
        zzel zzel = (zzel) obj;
        if (!zzgd.zza(Integer.valueOf(this.zza), Integer.valueOf(zzel.zza)) || !zzgd.zza(this.zzb, zzel.zzb) || !zzgd.zza(this.zzc, zzel.zzc) || !zzgd.zza(Integer.valueOf(this.zzd), Integer.valueOf(zzel.zzd)) || !zzgd.zza(this.zze, zzel.zze)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzb, this.zzc, Integer.valueOf(this.zzd), this.zze});
    }
}
