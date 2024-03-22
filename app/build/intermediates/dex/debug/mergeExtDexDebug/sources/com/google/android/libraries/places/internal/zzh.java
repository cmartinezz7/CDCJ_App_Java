package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzh {
    private final String zza;

    public static zzh zza(String str) {
        return new zzh((String) zzfp.zza(str));
    }

    public static zzh zza(String str, String str2) {
        String valueOf = String.valueOf((String) zzfp.zza(str));
        String valueOf2 = String.valueOf((String) zzfp.zza(str2));
        return new zzh(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    private zzh(String str) {
        this.zza = str;
    }

    public final String toString() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzh) {
            return this.zza.equals(((zzh) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }
}
