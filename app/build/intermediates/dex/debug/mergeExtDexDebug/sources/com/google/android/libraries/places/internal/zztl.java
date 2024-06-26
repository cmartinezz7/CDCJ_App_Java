package com.google.android.libraries.places.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
class zztl extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzte zza;

    private zztl(zzte zzte) {
        this.zza = zzte;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zztm(this.zza, (zztd) null);
    }

    public int size() {
        return this.zza.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zza.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zza.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zza.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zza.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zztl(zzte zzte, zztd zztd) {
        this(zzte);
    }
}
