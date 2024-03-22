package com.google.android.libraries.places.internal;

import java.math.RoundingMode;
import kotlin.time.DurationKt;
import org.ksoap2.SoapEnvelope;
import org.kxml2.wap.Wbxml;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzpq {
    private static final byte[] zza = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    private static final int[] zzb = {1, 10, 100, 1000, 10000, 100000, DurationKt.NANOS_IN_MILLIS, 10000000, 100000000, 1000000000};
    private static final int[] zzc = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    private static final int[] zzd = {1, 1, 2, 6, 24, SoapEnvelope.VER12, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    private static int[] zze = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, Wbxml.EXT_1, SoapEnvelope.VER11, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static int zza(int i, RoundingMode roundingMode) {
        if (i > 0) {
            boolean z = true;
            switch (zzps.zza[roundingMode.ordinal()]) {
                case 1:
                    boolean z2 = i > 0;
                    if (((i - 1) & i) != 0) {
                        z = false;
                    }
                    zzpr.zza(z2 & z);
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                case 5:
                    return 32 - Integer.numberOfLeadingZeros(i - 1);
                case 6:
                case 7:
                case 8:
                    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                    return (31 - numberOfLeadingZeros) + ((~(~((-1257966797 >>> numberOfLeadingZeros) - i))) >>> 31);
                default:
                    throw new AssertionError();
            }
            return 31 - Integer.numberOfLeadingZeros(i);
        }
        throw new IllegalArgumentException(new StringBuilder(String.valueOf("x").length() + 26).append("x").append(" (").append(i).append(") must be > 0").toString());
    }

    public static int zza(int i, int i2, RoundingMode roundingMode) {
        zzgg.zza(roundingMode);
        if (i2 != 0) {
            int i3 = i / i2;
            int i4 = i - (i2 * i3);
            if (i4 == 0) {
                return i3;
            }
            boolean z = true;
            int i5 = ((i ^ i2) >> 31) | 1;
            switch (zzps.zza[roundingMode.ordinal()]) {
                case 1:
                    if (i4 != 0) {
                        z = false;
                    }
                    zzpr.zza(z);
                    break;
                case 2:
                    break;
                case 3:
                    if (i5 >= 0) {
                        z = false;
                        break;
                    }
                    break;
                case 4:
                    break;
                case 5:
                    if (i5 <= 0) {
                        z = false;
                        break;
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    int abs = Math.abs(i4);
                    int abs2 = abs - (Math.abs(i2) - abs);
                    if (abs2 != 0) {
                        if (abs2 <= 0) {
                            z = false;
                            break;
                        }
                    } else if (roundingMode != RoundingMode.HALF_UP) {
                        if (!(roundingMode == RoundingMode.HALF_EVEN) || !((i3 & 1) != 0)) {
                            z = false;
                            break;
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            z = false;
            return z ? i3 + i5 : i3;
        }
        throw new ArithmeticException("/ by zero");
    }
}
