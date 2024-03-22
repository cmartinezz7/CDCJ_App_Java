package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzrr<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zza;

    public zzrr(Iterator<Map.Entry<K, Object>> it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        this.zza.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zza.next();
        if (next.getValue() instanceof zzrq) {
            return new zzrs(next);
        }
        return next;
    }
}
