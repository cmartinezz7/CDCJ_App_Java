package com.tealium.internal.c;

import java.util.EventListener;

public abstract class j<T extends EventListener> {
    private final Class<T> a;

    protected j(Class<T> cls) {
        this.a = cls;
        if (cls == null) {
            throw new IllegalArgumentException();
        }
    }

    public abstract void a(T t);

    public final Class<T> f() {
        return this.a;
    }
}
