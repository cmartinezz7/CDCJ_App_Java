package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzhr;
import com.google.android.libraries.places.internal.zzhx;
import com.google.android.libraries.places.internal.zzmm;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzda {
    public static zzmm.zzs.zza zza(zzdb zzdb) {
        zzmm.zzs.zze zze;
        int i = zzcz.zza[zzdb.zzc().ordinal()];
        if (i == 1) {
            zze = zzmm.zzs.zze.AUTOCOMPLETE_WIDGET;
        } else if (i != 2) {
            zze = zzmm.zzs.zze.UNKNOWN_SOURCE;
        } else {
            zze = zzmm.zzs.zze.PROGRAMMATIC_API;
        }
        return zzmm.zzs.zza().zza((zzhx.zza) ((zzrb) zzhx.zza.zza().zza(zzdb.zza()).zza(zzdb.zzb()).zzf())).zza(true).zza(zze).zzb("2.0.0");
    }

    public static zzhr.zza zza(zzmm.zzs zzs) {
        return (zzhr.zza) ((zzrb) zzhr.zza.zza().zza(zzhr.zza.C0001zza.PLACES).zza(zzs).zzf());
    }
}
