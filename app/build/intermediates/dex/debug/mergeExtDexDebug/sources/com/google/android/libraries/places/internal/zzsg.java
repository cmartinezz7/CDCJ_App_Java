package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzsg<K, V> extends LinkedHashMap<K, V> {
    private static final zzsg zzb;
    private boolean zza = true;

    private zzsg() {
    }

    private zzsg(Map<K, V> map) {
        super(map);
    }

    public final void zza(zzsg<K, V> zzsg) {
        zzd();
        if (!zzsg.isEmpty()) {
            putAll(zzsg);
        }
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        zzd();
        super.clear();
    }

    public final V put(K k, V v) {
        zzd();
        zzrd.zza(k);
        zzrd.zza(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzd();
        for (Object next : map.keySet()) {
            zzrd.zza(next);
            zzrd.zza(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzd();
        return super.remove(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x0060
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L_0x005c
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L_0x0016
            r7 = r1
            goto L_0x005d
        L_0x0016:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x001e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x005c
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L_0x0036
            r7 = r1
            goto L_0x005d
        L_0x0036:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L_0x0053
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L_0x0053
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x0057
        L_0x0053:
            boolean r3 = r4.equals(r3)
        L_0x0057:
            if (r3 != 0) goto L_0x005b
            r7 = r1
            goto L_0x005d
        L_0x005b:
            goto L_0x001e
        L_0x005c:
            r7 = r0
        L_0x005d:
            if (r7 == 0) goto L_0x0060
            return r0
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzsg.equals(java.lang.Object):boolean");
    }

    private static int zza(Object obj) {
        if (obj instanceof byte[]) {
            return zzrd.zzc((byte[]) obj);
        }
        if (!(obj instanceof zzrg)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += zza(entry.getValue()) ^ zza(entry.getKey());
        }
        return i;
    }

    public final zzsg<K, V> zza() {
        return isEmpty() ? new zzsg<>() : new zzsg<>(this);
    }

    public final void zzb() {
        this.zza = false;
    }

    public final boolean zzc() {
        return this.zza;
    }

    private final void zzd() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzsg zzsg = new zzsg();
        zzb = zzsg;
        zzsg.zza = false;
    }
}
