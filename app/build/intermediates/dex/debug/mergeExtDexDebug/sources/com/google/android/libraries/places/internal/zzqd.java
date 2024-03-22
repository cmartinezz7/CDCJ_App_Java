package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzqd extends zzqk {
    private final int zzc;
    private final int zzd;

    zzqd(byte[] bArr, int i, int i2) {
        super(bArr);
        zzb(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    public final byte zza(int i) {
        int zza = zza();
        if (((zza - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(i).toString());
        }
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(i).append(", ").append(zza).toString());
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    public final int zza() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final int zze() {
        return this.zzc;
    }
}
