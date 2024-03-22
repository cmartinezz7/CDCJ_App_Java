package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzdb;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzcv extends zzdb {
    private final String zza;
    private final int zzb;
    private final zzdb.zzb zzc;

    private zzcv(String str, int i, zzdb.zzb zzb2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = zzb2;
    }

    public final String zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzdb.zzb zzc() {
        return this.zzc;
    }

    public final String toString() {
        String str = this.zza;
        int i = this.zzb;
        String valueOf = String.valueOf(this.zzc);
        return new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(valueOf).length()).append("ClientProfile{packageName=").append(str).append(", versionCode=").append(i).append(", requestSource=").append(valueOf).append("}").toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdb)) {
            return false;
        }
        zzdb zzdb = (zzdb) obj;
        if (!this.zza.equals(zzdb.zza()) || this.zzb != zzdb.zzb() || !this.zzc.equals(zzdb.zzc())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb) * 1000003) ^ this.zzc.hashCode();
    }
}
