package com.google.android.libraries.places.internal;

import java.io.IOException;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public abstract class zzho {
    private static final zzho zza = new zzhp("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzho zzb = new zzhp("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final zzho zzc = new zzhs("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final zzho zzd = new zzhs("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final zzho zze = new zzhq("base16()", "0123456789ABCDEF");

    zzho() {
    }

    /* access modifiers changed from: package-private */
    public abstract int zza(int i);

    /* access modifiers changed from: package-private */
    public abstract void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    public final String zza(byte[] bArr, int i, int i2) {
        zzgg.zza(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(zza(i2));
        try {
            zza(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public static zzho zza() {
        return zze;
    }
}
