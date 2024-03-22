package org.simpleframework.xml.util;

import java.util.LinkedHashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

public class LimitedCache<T> extends LinkedHashMap<Object, T> implements Cache<T> {
    private final int capacity;

    public LimitedCache() {
        this(SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
    }

    public LimitedCache(int capacity2) {
        this.capacity = capacity2;
    }

    public void cache(Object key, T value) {
        put(key, value);
    }

    public T take(Object key) {
        return remove(key);
    }

    public T fetch(Object key) {
        return get(key);
    }

    public boolean contains(Object key) {
        return containsKey(key);
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<Object, T> entry) {
        return size() > this.capacity;
    }
}
