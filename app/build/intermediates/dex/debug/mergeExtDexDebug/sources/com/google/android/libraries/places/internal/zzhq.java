package com.google.android.libraries.places.internal;

import java.io.IOException;
import kotlin.UByte;
import kotlin.io.ConstantsKt;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzhq extends zzhs {
    private final char[] zzb;

    zzhq(String str, String str2) {
        this(new zzhn(str, str2.toCharArray()));
    }

    private zzhq(zzhn zzhn) {
        super(zzhn, (Character) null);
        this.zzb = new char[ConstantsKt.MINIMUM_BLOCK_SIZE];
        zzgg.zza(zzhn.zzf.length == 16);
        for (int i = 0; i < 256; i++) {
            this.zzb[i] = zzhn.zza(i >>> 4);
            this.zzb[i | 256] = zzhn.zza(i & 15);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzgg.zza(appendable);
        zzgg.zza(0, i2 + 0, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            byte b = bArr[i3 + 0] & UByte.MAX_VALUE;
            appendable.append(this.zzb[b]);
            appendable.append(this.zzb[b | UByte.MIN_VALUE]);
        }
    }
}
