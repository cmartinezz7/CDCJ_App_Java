package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final /* synthetic */ class zzeh implements Runnable {
    private final zzei zza;
    private final CharSequence zzb;

    zzeh(zzei zzei, CharSequence charSequence) {
        this.zza = zzei;
        this.zzb = charSequence;
    }

    public final void run() {
        zzei zzei = this.zza;
        CharSequence charSequence = this.zzb;
        try {
            if (!zzei.zza.zzd()) {
                zzei.zza.zza = new CancellationTokenSource();
                zzei.zza.zzc.findAutocompletePredictions(FindAutocompletePredictionsRequest.builder().setQuery(charSequence.toString()).setLocationBias(zzei.zza.zzd.zzb()).setLocationRestriction(zzei.zza.zzd.zzc()).setCountry(zzei.zza.zzd.zzd()).setTypeFilter(zzei.zza.zzd.zze()).setSessionToken(zzei.zza.zzk).setCancellationToken(zzei.zza.zza.getToken()).build()).addOnSuccessListener(new zzek(zzei)).addOnFailureListener(new zzej(zzei));
            }
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }
}
