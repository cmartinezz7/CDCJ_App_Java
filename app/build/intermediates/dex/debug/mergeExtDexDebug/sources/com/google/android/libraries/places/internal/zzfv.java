package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzfv extends zzfs {
    private final char zza;

    zzfv(char c) {
        this.zza = c;
    }

    public final boolean zzb(char c) {
        return c == this.zza;
    }

    public final String toString() {
        String zzc = zzft.zzd(this.zza);
        return new StringBuilder(String.valueOf(zzc).length() + 18).append("CharMatcher.is('").append(zzc).append("')").toString();
    }
}
