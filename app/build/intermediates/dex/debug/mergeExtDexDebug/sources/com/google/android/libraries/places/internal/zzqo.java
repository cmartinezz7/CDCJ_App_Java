package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzqo extends zzqm {
    private final byte[] zza;
    private final boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    private zzqo(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzg = Integer.MAX_VALUE;
        this.zza = bArr;
        this.zzc = i2 + i;
        this.zze = i;
        this.zzf = i;
        this.zzb = z;
    }

    public final int zza(int i) throws zzrl {
        if (i >= 0) {
            int zza2 = i + zza();
            int i2 = this.zzg;
            if (zza2 <= i2) {
                this.zzg = zza2;
                int i3 = this.zzc + this.zzd;
                this.zzc = i3;
                int i4 = i3 - this.zzf;
                if (i4 > zza2) {
                    int i5 = i4 - zza2;
                    this.zzd = i5;
                    this.zzc = i3 - i5;
                } else {
                    this.zzd = 0;
                }
                return i2;
            }
            throw new zzrl("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzrl("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final int zza() {
        return this.zze - this.zzf;
    }
}
