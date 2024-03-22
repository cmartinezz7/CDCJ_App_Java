package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "()V", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* compiled from: MainDispatchers.kt */
public final class MainDispatcherLoader {
    public static final MainDispatcherLoader INSTANCE;
    public static final MainCoroutineDispatcher dispatcher;

    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        INSTANCE = mainDispatcherLoader;
        dispatcher = mainDispatcherLoader.loadMainDispatcher();
    }

    private MainDispatcherLoader() {
    }

    private final MainCoroutineDispatcher loadMainDispatcher() {
        Object maxElem$iv;
        MainCoroutineDispatcher tryCreateDispatcher;
        Class clz = MainDispatcherFactory.class;
        try {
            ServiceLoader<S> load = ServiceLoader.load(clz, clz.getClassLoader());
            Intrinsics.checkExpressionValueIsNotNull(load, "ServiceLoader.load(clz, clz.classLoader)");
            List factories = CollectionsKt.toList(load);
            Iterator iterator$iv = factories.iterator();
            if (!iterator$iv.hasNext()) {
                maxElem$iv = null;
            } else {
                maxElem$iv = iterator$iv.next();
                int maxValue$iv = ((MainDispatcherFactory) maxElem$iv).getLoadPriority();
                while (iterator$iv.hasNext()) {
                    Object e$iv = iterator$iv.next();
                    int v$iv = ((MainDispatcherFactory) e$iv).getLoadPriority();
                    if (maxValue$iv < v$iv) {
                        maxElem$iv = e$iv;
                        maxValue$iv = v$iv;
                    }
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) maxElem$iv;
            if (mainDispatcherFactory == null || (tryCreateDispatcher = MainDispatchersKt.tryCreateDispatcher(mainDispatcherFactory, factories)) == null) {
                return new MissingMainCoroutineDispatcher((Throwable) null, (String) null, 2, (DefaultConstructorMarker) null);
            }
            return tryCreateDispatcher;
        } catch (Throwable e) {
            return new MissingMainCoroutineDispatcher(e, (String) null, 2, (DefaultConstructorMarker) null);
        }
    }
}
