package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Converter;

class Platform {
    private static final Platform PLATFORM = findPlatform();
    private final boolean hasJava8Types;

    static Platform get() {
        return PLATFORM;
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new Android();
            }
        } catch (ClassNotFoundException e) {
        }
        return new Platform(true);
    }

    Platform(boolean hasJava8Types2) {
        this.hasJava8Types = hasJava8Types2;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Executor defaultCallbackExecutor() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor callbackExecutor) {
        DefaultCallAdapterFactory executorFactory = new DefaultCallAdapterFactory(callbackExecutor);
        if (!this.hasJava8Types) {
            return Collections.singletonList(executorFactory);
        }
        return Arrays.asList(new CallAdapter.Factory[]{CompletableFutureCallAdapterFactory.INSTANCE, executorFactory});
    }

    /* access modifiers changed from: package-private */
    public int defaultCallAdapterFactoriesSize() {
        return this.hasJava8Types ? 2 : 1;
    }

    /* access modifiers changed from: package-private */
    public List<? extends Converter.Factory> defaultConverterFactories() {
        if (this.hasJava8Types) {
            return Collections.singletonList(OptionalConverterFactory.INSTANCE);
        }
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public int defaultConverterFactoriesSize() {
        return this.hasJava8Types ? 1 : 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isDefaultMethod(Method method) {
        return this.hasJava8Types && method.isDefault();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Object invokeDefaultMethod(Method method, Class<?> declaringClass, Object object, @Nullable Object... args) throws Throwable {
        Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
        constructor.setAccessible(true);
        return constructor.newInstance(new Object[]{declaringClass, -1}).unreflectSpecial(method, declaringClass).bindTo(object).invokeWithArguments(args);
    }

    static final class Android extends Platform {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Android() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            public void execute(Runnable r) {
                this.handler.post(r);
            }
        }
    }
}
