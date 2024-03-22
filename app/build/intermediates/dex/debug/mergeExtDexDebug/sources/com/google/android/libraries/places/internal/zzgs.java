package com.google.android.libraries.places.internal;

import java.lang.Comparable;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzgs<C extends Comparable> extends zzgq<C> {
    zzgs(C c) {
        super((Comparable) zzgg.zza(c));
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(C c) {
        return zzhb.zzc(this.zza, c) < 0;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb) {
        sb.append('(').append(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(StringBuilder sb) {
        sb.append(this.zza).append(']');
    }

    public final int hashCode() {
        return ~this.zza.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return new StringBuilder(String.valueOf(valueOf).length() + 2).append("/").append(valueOf).append("\\").toString();
    }
}
