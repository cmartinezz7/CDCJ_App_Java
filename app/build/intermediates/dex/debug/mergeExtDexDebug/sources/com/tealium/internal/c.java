package com.tealium.internal;

import com.tealium.internal.c.j;
import com.tealium.internal.listeners.BackgroundListener;
import com.tealium.internal.listeners.MainListener;
import java.util.EventListener;

public interface c {
    <T extends MainListener> void a(j<T> jVar);

    void a(Runnable runnable);

    void a(Runnable runnable, long j);

    void a(EventListener eventListener);

    <T extends BackgroundListener> void b(j<T> jVar);

    void b(Runnable runnable);

    void b(EventListener eventListener);

    void c(Runnable runnable);
}
