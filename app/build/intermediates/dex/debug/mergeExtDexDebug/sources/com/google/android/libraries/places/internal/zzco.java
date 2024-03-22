package com.google.android.libraries.places.internal;

import java.util.Locale;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzco implements zzcr, zzdd {
    private volatile String zza;
    private volatile Locale zzb;
    private volatile boolean zzc;

    public final synchronized void zza(String str, Locale locale, boolean z) {
        zzgg.zza(str, (Object) "API Key must not be null.");
        zzgg.zza(!str.isEmpty(), (Object) "API Key must not be empty.");
        this.zza = str;
        this.zzb = locale;
        this.zzc = false;
    }

    public final synchronized boolean zza() {
        return this.zza != null;
    }

    public final synchronized String zzb() {
        zzgg.zzb(zza(), (Object) "ApiConfig must be initialized.");
        return this.zza;
    }

    public final synchronized Locale zzc() {
        zzgg.zzb(zza(), (Object) "ApiConfig must be initialized.");
        return this.zzb == null ? Locale.getDefault() : this.zzb;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
