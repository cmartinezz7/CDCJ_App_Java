package com.google.android.libraries.places.internal;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzdb;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzfi implements zzfg {
    private final AppCompatActivity zza;
    private final Bundle zzb;

    private zzfi(AppCompatActivity appCompatActivity, Bundle bundle) {
        this.zza = appCompatActivity;
        this.zzb = bundle;
    }

    private final zzdb zzb() {
        return (zzdb) zzun.zza(zzdb.zza(this.zza).zza(zzdb.zzb.AUTOCOMPLETE_WIDGET).zzb(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final zzdj zza() {
        AppCompatActivity appCompatActivity = this.zza;
        return new zzdn(appCompatActivity, this.zzb, zzet.zza(zzen.zza(appCompatActivity, (PlacesClient) zzun.zza(Places.zza(appCompatActivity, zzb()), "Cannot return null from a non-@Nullable @Provides method"), (zzeq) zzun.zza(zzeq.zza(this.zza.getIntent()), "Cannot return null from a non-@Nullable @Provides method"))), zzfc.zza(zzct.zza(zzcw.zza(this.zza)), zzb()), zza.zza());
    }
}
