package com.tealium.internal.data;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class Dispatch {
    private final long a;
    private Map<String, String> b;
    private Map<String, String[]> c;
    private String d;
    private String e;

    public Dispatch() {
        this.a = System.currentTimeMillis();
    }

    public Dispatch(long j) {
        this.a = j;
    }

    public Dispatch(long j, JSONObject jSONObject) {
        this.a = j;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (!TextUtils.isEmpty(next) && opt != null && !JSONObject.NULL.equals(opt)) {
                    String[] a2 = a(opt);
                    if (a2 != null) {
                        b().put(next, a2);
                    } else {
                        a().put(next, opt.toString());
                    }
                }
            }
        }
    }

    public Dispatch(Map<String, ?> map) {
        this.a = System.currentTimeMillis();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) next.getKey()) && next.getValue() != null) {
                    String[] a2 = a(next.getValue());
                    if (a2 != null) {
                        b().put(next.getKey(), a2);
                    } else {
                        a().put(next.getKey(), next.getValue().toString());
                    }
                }
            }
        }
    }

    private static String a(Map<String, ?> map) {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.object();
            for (Map.Entry next : map.entrySet()) {
                if (next.getValue() instanceof String) {
                    a(jSONStringer, (String) next.getKey(), (String) next.getValue());
                } else if (next.getValue() instanceof String[]) {
                    a(jSONStringer, (String) next.getKey(), (String[]) next.getValue());
                }
            }
            jSONStringer.endObject();
            return jSONStringer.toString();
        } catch (JSONException e2) {
            return null;
        }
    }

    private Map<String, String> a() {
        if (this.b == null) {
            this.b = new HashMap();
        }
        return this.b;
    }

    private static JSONArray a(String[] strArr) throws JSONException {
        if (Build.VERSION.SDK_INT >= 19) {
            return new JSONArray(strArr);
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : strArr) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    private static void a(JSONStringer jSONStringer, String str, String str2) throws JSONException {
        jSONStringer.key(str);
        jSONStringer.value(str2);
    }

    private static void a(JSONStringer jSONStringer, String str, String[] strArr) throws JSONException {
        jSONStringer.key(str);
        jSONStringer.array();
        for (String value : strArr) {
            jSONStringer.value(value);
        }
        jSONStringer.endArray();
    }

    private static String[] a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass().isArray()) {
            return b(obj);
        }
        if (obj instanceof Collection) {
            return b(((Collection) obj).toArray());
        }
        if (obj instanceof JSONArray) {
            return a((JSONArray) obj);
        }
        return null;
    }

    private static String[] a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray.opt(i2) != null) {
                i++;
            }
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            Object opt = jSONArray.opt(i4);
            if (opt != null) {
                strArr[i3] = opt.toString();
                i3++;
            }
        }
        return strArr;
    }

    private Map<String, String[]> b() {
        if (this.c == null) {
            this.c = new HashMap();
        }
        return this.c;
    }

    private static String[] b(Object obj) {
        if (obj == null) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < Array.getLength(obj); i2++) {
            if (Array.get(obj, i2) != null) {
                i++;
            }
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < Array.getLength(obj); i4++) {
            Object obj2 = Array.get(obj, i4);
            if (obj2 != null) {
                strArr[i3] = obj2.toString();
                i3++;
            }
        }
        return strArr;
    }

    private void c() {
        this.d = null;
        this.e = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsKey(java.lang.String r2) {
        /*
            r1 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.b
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.containsKey(r2)
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            java.util.Map<java.lang.String, java.lang.String[]> r0 = r1.c
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tealium.internal.data.Dispatch.containsKey(java.lang.String):boolean");
    }

    public Object get(String str) {
        String str2;
        Map<String, String> map = this.b;
        if (map != null && (str2 = map.get(str)) != null) {
            return str2;
        }
        Map<String, String[]> map2 = this.c;
        if (map2 == null) {
            return null;
        }
        return map2.get(str);
    }

    public String[] getArray(String str) {
        Map<String, String[]> map = this.c;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public long getCreationTime() {
        return this.a;
    }

    public String getString(String str) {
        Map<String, String> map = this.b;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public String[] keys() {
        Object[] array;
        Map<String, String> map = this.b;
        Set<String> set = null;
        Set<String> keySet = map == null ? null : map.keySet();
        Map<String, String[]> map2 = this.c;
        if (map2 != null) {
            set = map2.keySet();
        }
        int i = 0;
        if (keySet == null || set == null) {
            if (keySet != null) {
                array = keySet.toArray(new String[keySet.size()]);
            } else if (set == null) {
                return new String[0];
            } else {
                array = set.toArray(new String[set.size()]);
            }
            return (String[]) array;
        }
        String[] strArr = new String[(keySet.size() + set.size())];
        for (String str : keySet) {
            strArr[i] = str;
            i++;
        }
        for (String str2 : set) {
            strArr[i] = str2;
            i++;
        }
        return strArr;
    }

    public void put(String str, String str2) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        } else if (str2 == null && (map = this.b) != null) {
            map.remove(str);
            c();
        } else if (str2 != null) {
            a().put(str, str2);
            c();
        }
    }

    public void put(String str, String[] strArr) {
        Map<String, String[]> map;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        } else if (strArr == null && (map = this.c) != null) {
            map.remove(str);
            c();
        } else if (strArr != null) {
            b().put(str, b(strArr));
            c();
        }
    }

    public void putAll(Map<String, ?> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) next.getKey()) && next.getValue() != null) {
                    String[] a2 = a(next.getValue());
                    if (a2 != null) {
                        b().put(next.getKey(), a2);
                    } else {
                        a().put(next.getKey(), next.getValue().toString());
                    }
                }
            }
            c();
        }
    }

    public void putAllIfAbsent(Map<String, ?> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) next.getKey()) && next.getValue() != null) {
                    String[] a2 = a(next.getValue());
                    if (a2 != null) {
                        putIfAbsent((String) next.getKey(), a2);
                    } else {
                        putIfAbsent((String) next.getKey(), next.getValue().toString());
                    }
                }
            }
            c();
        }
    }

    public void putIfAbsent(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        } else if (str2 != null) {
            Map<String, String> map = this.b;
            if (map == null) {
                a().put(str, str2);
                c();
            } else if (!map.containsKey(str)) {
                this.b.put(str, str2);
                c();
            }
        }
    }

    public void putIfAbsent(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        } else if (strArr != null) {
            Map<String, String[]> map = this.c;
            if (map == null) {
                b().put(str, b(strArr));
                c();
            } else if (!map.containsKey(str)) {
                this.c.put(str, b(strArr));
                c();
            }
        }
    }

    public int size() {
        Map<String, String> map = this.b;
        int i = 0;
        int size = map == null ? 0 : map.size();
        Map<String, String[]> map2 = this.c;
        if (map2 != null) {
            i = map2.size();
        }
        return size + i;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = this.b == null ? new JSONObject() : new JSONObject(this.b);
        Map<String, String[]> map = this.c;
        if (map != null) {
            try {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), a((String[]) next.getValue()));
                }
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
        return jSONObject;
    }

    public String toJsonString() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        try {
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.object();
            Map<String, String> map = this.b;
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    a(jSONStringer, (String) next.getKey(), (String) next.getValue());
                }
            }
            Map<String, String[]> map2 = this.c;
            if (map2 != null) {
                for (Map.Entry next2 : map2.entrySet()) {
                    a(jSONStringer, (String) next2.getKey(), (String[]) next2.getValue());
                }
            }
            jSONStringer.endObject();
            String jSONStringer2 = jSONStringer.toString();
            this.d = jSONStringer2;
            return jSONStringer2;
        } catch (JSONException e2) {
            return null;
        }
    }

    public String toSortedJsonString() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        TreeMap treeMap = this.b == null ? new TreeMap() : new TreeMap(this.b);
        Map<String, String[]> map = this.c;
        if (map != null) {
            treeMap.putAll(map);
        }
        String a2 = a((Map<String, ?>) treeMap);
        this.e = a2;
        this.d = a2;
        return a2;
    }

    public String toString() {
        return toSortedJsonString();
    }
}
