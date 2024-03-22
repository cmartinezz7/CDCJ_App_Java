package com.google.android.libraries.places.internal;

import android.text.TextUtils;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzcb {
    public static int zza(String str) {
        if (str == null) {
            return 13;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1698126997:
                if (str.equals("REQUEST_DENIED")) {
                    c = 3;
                    break;
                }
                break;
            case -1125000185:
                if (str.equals("INVALID_REQUEST")) {
                    c = 4;
                    break;
                }
                break;
            case -813482689:
                if (str.equals("ZERO_RESULTS")) {
                    c = 1;
                    break;
                }
                break;
            case 2524:
                if (str.equals("OK")) {
                    c = 0;
                    break;
                }
                break;
            case 1023286998:
                if (str.equals("NOT_FOUND")) {
                    c = 5;
                    break;
                }
                break;
            case 1776037267:
                if (str.equals("UNKNOWN_ERROR")) {
                    c = 6;
                    break;
                }
                break;
            case 1831775833:
                if (str.equals("OVER_QUERY_LIMIT")) {
                    c = 2;
                    break;
                }
                break;
        }
        if (c == 0 || c == 1) {
            return 0;
        }
        if (c == 2) {
            return 9010;
        }
        if (c == 3) {
            return 9011;
        }
        if (c == 4) {
            return 9012;
        }
        if (c != 5) {
            return 13;
        }
        return 9013;
    }

    public static String zza(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str2;
    }
}
