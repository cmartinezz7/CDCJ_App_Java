package com.google.android.libraries.places.internal;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzde extends LinkedHashMap<Long, Integer> {
    zzde(int i, float f, boolean z) {
        super(16, 0.75f, true);
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Map.Entry<Long, Integer> entry) {
        return size() > 10;
    }
}
