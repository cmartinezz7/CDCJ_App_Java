package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzea implements Parcelable {
    public static final Parcelable.Creator<zzea> CREATOR = new zzec();
    private zza zza;
    private String zzb;
    private String zzc;
    private boolean zzd;

    public zzea(zza zza2, String str, String str2, boolean z) {
        this.zza = zza2;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    public enum zza implements Parcelable {
        NO_ERROR,
        SHOW_ERROR_CAN_RETRY_NOT_LOADING,
        SHOW_ERROR_CANNOT_RETRY_NOT_LOADING,
        SHOW_ERROR_WHILE_LOADING;
        
        public static final Parcelable.Creator<zza> CREATOR = null;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(name());
        }

        static {
            CREATOR = new zzee();
        }
    }

    public final zza zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zza != zza.NO_ERROR;
    }

    public final void zza(zza zza2) {
        this.zza = zza2;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final void zza(CharSequence charSequence) {
        this.zzb = charSequence == null ? null : charSequence.toString();
    }

    public final String zzd() {
        return this.zzc;
    }

    public final void zza(String str) {
        this.zzc = str;
    }

    public final boolean zze() {
        return this.zzd;
    }

    public final void zza(boolean z) {
        this.zzd = z;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.zza, i);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd ? 1 : 0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzea)) {
            return false;
        }
        zzea zzea = (zzea) obj;
        if (!zzgd.zza(this.zza, zzea.zza) || !zzgd.zza(this.zzb, zzea.zzb) || !zzgd.zza(this.zzc, zzea.zzc) || !zzgd.zza(Boolean.valueOf(this.zzd), Boolean.valueOf(zzea.zzd))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, Boolean.valueOf(this.zzd)});
    }
}
