package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzdb;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzcx extends zzdb.zza {
    private String zza;
    private Integer zzb;
    private zzdb.zzb zzc;

    zzcx() {
    }

    /* access modifiers changed from: package-private */
    public final zzdb.zza zza(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null packageName");
    }

    /* access modifiers changed from: package-private */
    public final zzdb.zza zza(int i) {
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzdb.zza zza(zzdb.zzb zzb2) {
        if (zzb2 != null) {
            this.zzc = zzb2;
            return this;
        }
        throw new NullPointerException("Null requestSource");
    }

    /* access modifiers changed from: package-private */
    public final zzdb zza() {
        String str = "";
        if (this.zza == null) {
            str = String.valueOf(str).concat(" packageName");
        }
        if (this.zzb == null) {
            str = String.valueOf(str).concat(" versionCode");
        }
        if (this.zzc == null) {
            str = String.valueOf(str).concat(" requestSource");
        }
        if (str.isEmpty()) {
            return new zzcv(this.zza, this.zzb.intValue(), this.zzc);
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }
}
