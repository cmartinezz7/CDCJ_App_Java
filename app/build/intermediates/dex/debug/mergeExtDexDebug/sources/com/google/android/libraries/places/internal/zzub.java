package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzub extends zzuc {
    zzub() {
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i, byte[] bArr, int i2, int i3) {
        while (r9 < i3 && bArr[r9] >= 0) {
            i2 = r9 + 1;
        }
        if (r9 >= i3) {
            return 0;
        }
        while (r9 < i3) {
            int i4 = r9 + 1;
            byte b = bArr[r9];
            if (b >= 0) {
                r9 = i4;
            } else if (b < -32) {
                if (i4 >= i3) {
                    return b;
                }
                if (b >= -62) {
                    r9 = i4 + 1;
                    if (bArr[i4] > -65) {
                    }
                }
                return -1;
            } else if (b < -16) {
                if (i4 >= i3 - 1) {
                    return zzua.zzc(bArr, i4, i3);
                }
                int i5 = i4 + 1;
                byte b2 = bArr[i4];
                if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                    r9 = i5 + 1;
                    if (bArr[i5] > -65) {
                    }
                }
                return -1;
            } else if (i4 >= i3 - 2) {
                return zzua.zzc(bArr, i4, i3);
            } else {
                int i6 = i4 + 1;
                byte b3 = bArr[i4];
                if (b3 <= -65 && (((b << 28) + (b3 + 112)) >> 30) == 0) {
                    int i7 = i6 + 1;
                    if (bArr[i6] <= -65) {
                        int i8 = i7 + 1;
                        if (bArr[i7] <= -65) {
                            r9 = i8;
                        }
                    }
                }
                return -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        char charAt;
        int length = charSequence.length();
        int i5 = i2 + i;
        int i6 = 0;
        while (i6 < length && (i4 = i6 + i) < i5 && (charAt = charSequence.charAt(i6)) < 128) {
            bArr[i4] = (byte) charAt;
            i6++;
        }
        if (i6 == length) {
            return i + length;
        }
        int i7 = i + i6;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 < 128 && i7 < i5) {
                bArr[i7] = (byte) charAt2;
                i7++;
            } else if (charAt2 < 2048 && i7 <= i5 - 2) {
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 >>> 6) | 960);
                i7 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i7 <= i5 - 3) {
                int i9 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 >>> 12) | 480);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                bArr[i10] = (byte) ((charAt2 & '?') | 128);
                i7 = i10 + 1;
            } else if (i7 <= i5 - 4) {
                int i11 = i6 + 1;
                if (i11 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i11);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i12 = i7 + 1;
                        bArr[i7] = (byte) ((codePoint >>> 18) | 240);
                        int i13 = i12 + 1;
                        bArr[i12] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i7 = i14 + 1;
                        bArr[i14] = (byte) ((codePoint & 63) | 128);
                        i6 = i11;
                    } else {
                        i6 = i11;
                    }
                }
                throw new zzue(i6 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i6 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charAt2).append(" at index ").append(i7).toString());
            } else {
                throw new zzue(i6, length);
            }
            i6++;
        }
        return i7;
    }
}
