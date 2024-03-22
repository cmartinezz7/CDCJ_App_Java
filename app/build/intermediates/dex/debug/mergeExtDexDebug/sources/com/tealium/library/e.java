package com.tealium.library;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tealium.internal.b;
import com.tealium.internal.c;
import com.tealium.internal.c.j;
import com.tealium.internal.listeners.BackgroundListener;
import com.tealium.internal.listeners.MainListener;
import java.util.Collection;
import java.util.EventListener;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;

final class e {
    /* access modifiers changed from: private */
    public static ScheduledExecutorService a;

    static synchronized c a(final b bVar) {
        AnonymousClass1 r1;
        synchronized (e.class) {
            if (a == null) {
                a = Executors.newSingleThreadScheduledExecutor();
            }
            r1 = new c() {
                private final Handler b = new Handler(Looper.getMainLooper());
                /* access modifiers changed from: private */
                public final Collection<BackgroundListener> c = new ConcurrentLinkedQueue();
                private final Collection<MainListener> d = new ConcurrentLinkedQueue();
                private final ScheduledExecutorService e = e.a;

                /* access modifiers changed from: private */
                public <T extends MainListener> void c(j<T> jVar) {
                    Class<T> f = jVar.f();
                    for (MainListener next : this.d) {
                        if (f.isInstance(next)) {
                            jVar.a((EventListener) f.cast(next));
                        }
                    }
                }

                public <T extends MainListener> void a(final j<T> jVar) {
                    if (jVar == null) {
                        throw new IllegalArgumentException();
                    } else if (com.tealium.internal.e.a()) {
                        c(jVar);
                    } else {
                        this.b.post(new Runnable() {
                            public void run() {
                                AnonymousClass1.this.c(jVar);
                            }
                        });
                    }
                }

                public void a(Runnable runnable) {
                    this.b.post(runnable);
                }

                public void a(final Runnable runnable, long j) {
                    this.b.postDelayed(new Runnable() {
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 11) {
                                try {
                                    AsyncTask.THREAD_POOL_EXECUTOR.execute(runnable);
                                } catch (RejectedExecutionException e) {
                                    AsyncTask.SERIAL_EXECUTOR.execute(runnable);
                                }
                            } else {
                                new Thread(runnable).start();
                            }
                        }
                    }, j);
                }

                public void a(EventListener eventListener) {
                    boolean z;
                    boolean z2 = true;
                    if (eventListener instanceof MainListener) {
                        this.d.add((MainListener) eventListener);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (eventListener instanceof BackgroundListener) {
                        this.c.add((BackgroundListener) eventListener);
                    } else {
                        z2 = z;
                    }
                    if (!z2) {
                        throw new IllegalArgumentException();
                    }
                }

                public <T extends BackgroundListener> void b(final j<T> jVar) {
                    if (jVar != null) {
                        this.e.submit(new Runnable() {
                            public void run() {
                                try {
                                    Class f = jVar.f();
                                    for (BackgroundListener backgroundListener : AnonymousClass1.this.c) {
                                        if (f.isInstance(backgroundListener)) {
                                            jVar.a((EventListener) f.cast(backgroundListener));
                                        }
                                    }
                                } catch (Throwable th) {
                                    bVar.a(th);
                                }
                            }
                        });
                        return;
                    }
                    throw new IllegalArgumentException();
                }

                public void b(Runnable runnable) {
                    this.e.submit(runnable);
                }

                public void b(EventListener eventListener) {
                    this.d.remove(eventListener);
                    this.c.remove(eventListener);
                }

                public void c(Runnable runnable) {
                    a(runnable, 0);
                }
            };
        }
        return r1;
    }
}
