package com.google.android.libraries.places.internal;

import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.libraries.places.internal.zzmm;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzez implements zzfn {
    private final ClearcutLogger zza;
    private final zzdb zzb;

    zzez(ClearcutLogger clearcutLogger, zzdb zzdb) {
        this.zza = clearcutLogger;
        this.zzb = zzdb;
    }

    public final void zza(zzfm zzfm) {
        zzmm.zzp.zzc zzh = zzmm.zzp.zza().zza(zzfm.zzc()).zzb(zzfm.zzd()).zzc(zzfm.zze()).zza(zzfm.zzf()).zzb(zzfm.zzg()).zzc(zzfm.zzh()).zzd(zzfm.zzi()).zze(zzfm.zzj().length()).zzf(zzfm.zzk()).zzg(zzfm.zzl()).zzd(zzfm.zzm()).zzh(zzfm.zzn());
        if (zzfm.zza() == zzdf.FRAGMENT) {
            zzh.zza(zzmm.zzp.zzd.ANDROID_AUTOCOMPLETE_FRAGMENT);
        } else if (zzfm.zza() == zzdf.INTENT) {
            zzh.zza(zzmm.zzp.zzd.ANDROID_AUTOCOMPLETE_MANUAL_LAUNCHER);
        } else {
            zzh.zza(zzmm.zzp.zzd.UNKNOWN_ORIGIN);
        }
        if (zzfm.zzb() == AutocompleteActivityMode.FULLSCREEN) {
            zzh.zza(zzmm.zzp.zza.FULLSCREEN);
        } else if (zzfm.zzb() == AutocompleteActivityMode.OVERLAY) {
            zzh.zza(zzmm.zzp.zza.OVERLAY);
        }
        this.zza.newEvent(zzda.zza((zzmm.zzs) ((zzrb) zzda.zza(this.zzb).zza(zzmm.zzs.zzc.AUTOCOMPLETE_WIDGET_SESSION).zza((zzmm.zzp) ((zzrb) zzh.zzf())).zzf())).zzd()).log();
    }
}
