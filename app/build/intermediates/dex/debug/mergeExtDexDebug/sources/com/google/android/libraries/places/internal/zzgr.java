package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzgr extends zzgq<Comparable<?>> {
    /* access modifiers changed from: private */
    public static final zzgr zzb = new zzgr();

    private zzgr() {
        super(null);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(Comparable<?> comparable) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb) {
        sb.append("(-∞");
    }

    /* access modifiers changed from: package-private */
    public final void zzb(StringBuilder sb) {
        throw new AssertionError();
    }

    public final int zza(zzgq<Comparable<?>> zzgq) {
        return zzgq == this ? 0 : -1;
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "-∞";
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return compareTo((zzgq) obj);
    }
}
