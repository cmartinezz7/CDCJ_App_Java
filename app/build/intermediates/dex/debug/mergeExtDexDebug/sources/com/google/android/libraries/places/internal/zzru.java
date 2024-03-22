package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public class zzru {
    private static final zzqs zza = zzqs.zza();
    private zzqa zzb;
    private volatile zzsm zzc;
    private volatile zzqa zzd;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzru)) {
            return false;
        }
        zzru zzru = (zzru) obj;
        zzsm zzsm = this.zzc;
        zzsm zzsm2 = zzru.zzc;
        if (zzsm == null && zzsm2 == null) {
            return zzc().equals(zzru.zzc());
        }
        if (zzsm != null && zzsm2 != null) {
            return zzsm.equals(zzsm2);
        }
        if (zzsm != null) {
            return zzsm.equals(zzru.zzb(zzsm.zzm()));
        }
        return zzb(zzsm2.zzm()).equals(zzsm2);
    }

    public int hashCode() {
        return 1;
    }

    private final zzsm zzb(zzsm zzsm) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzsm;
                        this.zzd = zzqa.zza;
                    } catch (zzrl e) {
                        this.zzc = zzsm;
                        this.zzd = zzqa.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    public final zzsm zza(zzsm zzsm) {
        zzsm zzsm2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzsm;
        return zzsm2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzh();
        }
        return 0;
    }

    public final zzqa zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzqa zzqa = this.zzd;
                return zzqa;
            }
            if (this.zzc == null) {
                this.zzd = zzqa.zza;
            } else {
                this.zzd = this.zzc.zzc();
            }
            zzqa zzqa2 = this.zzd;
            return zzqa2;
        }
    }
}
