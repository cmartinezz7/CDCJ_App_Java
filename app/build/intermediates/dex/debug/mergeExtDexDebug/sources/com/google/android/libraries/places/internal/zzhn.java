package com.google.android.libraries.places.internal;

import java.math.RoundingMode;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzhn {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    /* access modifiers changed from: private */
    public final char[] zzf;
    private final byte[] zzg;
    private final boolean[] zzh;

    zzhn(String str, char[] cArr) {
        this.zze = (String) zzgg.zza(str);
        this.zzf = (char[]) zzgg.zza(cArr);
        try {
            int zza2 = zzpq.zza(cArr.length, RoundingMode.UNNECESSARY);
            this.zzb = zza2;
            int min = Math.min(8, Integer.lowestOneBit(zza2));
            try {
                this.zzc = 8 / min;
                this.zzd = zza2 / min;
                this.zza = cArr.length - 1;
                byte[] bArr = new byte[128];
                Arrays.fill(bArr, (byte) -1);
                for (int i = 0; i < cArr.length; i++) {
                    char c = cArr[i];
                    zzgg.zza(c < 128, "Non-ASCII character: %s", c);
                    zzgg.zza(bArr[c] == -1, "Duplicate character: %s", c);
                    bArr[c] = (byte) i;
                }
                this.zzg = bArr;
                boolean[] zArr = new boolean[this.zzc];
                for (int i2 = 0; i2 < this.zzd; i2++) {
                    zArr[zzpq.zza(i2 << 3, this.zzb, RoundingMode.CEILING)] = true;
                }
                this.zzh = zArr;
            } catch (ArithmeticException e) {
                String valueOf = String.valueOf(new String(cArr));
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Illegal alphabet ".concat(valueOf) : new String("Illegal alphabet "), e);
            }
        } catch (ArithmeticException e2) {
            throw new IllegalArgumentException(new StringBuilder(35).append("Illegal alphabet length ").append(cArr.length).toString(), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final char zza(int i) {
        return this.zzf[i];
    }

    public final boolean zza(char c) {
        byte[] bArr = this.zzg;
        return c < bArr.length && bArr[c] != -1;
    }

    public final String toString() {
        return this.zze;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzhn) {
            return Arrays.equals(this.zzf, ((zzhn) obj).zzf);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf);
    }
}
