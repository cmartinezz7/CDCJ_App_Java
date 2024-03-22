package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzf {
    private static zzf zza = null;
    private final zze zzb;

    public static zzf zza() {
        zzf zzf = zza;
        if (!(zzf != null && !(zzf.zzb instanceof zzc))) {
            zza = new zzf(new zzc());
        }
        return zza;
    }

    private zzf(zze zze) {
        this.zzb = zze;
    }

    public final zzg zzb() {
        return this.zzb.zza();
    }

    public final void zza(zzg zzg, zzh zzh) {
        this.zzb.zza(zzg, zzh);
    }

    public final void zza(zzh zzh) {
        this.zzb.zza(zzh);
    }

    public final void zzb(zzh zzh) {
        this.zzb.zzb(zzh);
    }
}
