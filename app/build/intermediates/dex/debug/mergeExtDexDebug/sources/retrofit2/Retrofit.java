package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.BuiltInConverters;
import retrofit2.CallAdapter;
import retrofit2.Converter;

public final class Retrofit {
    final HttpUrl baseUrl;
    final List<CallAdapter.Factory> callAdapterFactories;
    final Call.Factory callFactory;
    @Nullable
    final Executor callbackExecutor;
    final List<Converter.Factory> converterFactories;
    private final Map<Method, ServiceMethod<?>> serviceMethodCache = new ConcurrentHashMap();
    final boolean validateEagerly;

    Retrofit(Call.Factory callFactory2, HttpUrl baseUrl2, List<Converter.Factory> converterFactories2, List<CallAdapter.Factory> callAdapterFactories2, @Nullable Executor callbackExecutor2, boolean validateEagerly2) {
        this.callFactory = callFactory2;
        this.baseUrl = baseUrl2;
        this.converterFactories = converterFactories2;
        this.callAdapterFactories = callAdapterFactories2;
        this.callbackExecutor = callbackExecutor2;
        this.validateEagerly = validateEagerly2;
    }

    public <T> T create(final Class<T> service) {
        validateServiceInterface(service);
        return Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new InvocationHandler() {
            private final Object[] emptyArgs = new Object[0];
            private final Platform platform = Platform.get();

            @Nullable
            public Object invoke(Object proxy, Method method, @Nullable Object[] args) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, args);
                }
                if (this.platform.isDefaultMethod(method)) {
                    return this.platform.invokeDefaultMethod(method, service, proxy, args);
                }
                return Retrofit.this.loadServiceMethod(method).invoke(args != null ? args : this.emptyArgs);
            }
        });
    }

    private void validateServiceInterface(Class<?> service) {
        if (service.isInterface()) {
            Deque<Class<?>> check = new ArrayDeque<>(1);
            check.add(service);
            while (!check.isEmpty()) {
                Class<?> candidate = check.removeFirst();
                if (candidate.getTypeParameters().length != 0) {
                    StringBuilder message = new StringBuilder("Type parameters are unsupported on ").append(candidate.getName());
                    if (candidate != service) {
                        message.append(" which is an interface of ").append(service.getName());
                    }
                    throw new IllegalArgumentException(message.toString());
                }
                Collections.addAll(check, candidate.getInterfaces());
            }
            if (this.validateEagerly) {
                Platform platform = Platform.get();
                for (Method method : service.getDeclaredMethods()) {
                    if (!platform.isDefaultMethod(method) && !Modifier.isStatic(method.getModifiers())) {
                        loadServiceMethod(method);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    /* access modifiers changed from: package-private */
    public ServiceMethod<?> loadServiceMethod(Method method) {
        ServiceMethod<?> result;
        ServiceMethod<?> result2 = this.serviceMethodCache.get(method);
        if (result2 != null) {
            return result2;
        }
        synchronized (this.serviceMethodCache) {
            result = this.serviceMethodCache.get(method);
            if (result == null) {
                result = ServiceMethod.parseAnnotations(this, method);
                this.serviceMethodCache.put(method, result);
            }
        }
        return result;
    }

    public Call.Factory callFactory() {
        return this.callFactory;
    }

    public HttpUrl baseUrl() {
        return this.baseUrl;
    }

    public List<CallAdapter.Factory> callAdapterFactories() {
        return this.callAdapterFactories;
    }

    public CallAdapter<?, ?> callAdapter(Type returnType, Annotation[] annotations) {
        return nextCallAdapter((CallAdapter.Factory) null, returnType, annotations);
    }

    public CallAdapter<?, ?> nextCallAdapter(@Nullable CallAdapter.Factory skipPast, Type returnType, Annotation[] annotations) {
        Objects.requireNonNull(returnType, "returnType == null");
        Objects.requireNonNull(annotations, "annotations == null");
        int start = this.callAdapterFactories.indexOf(skipPast) + 1;
        int count = this.callAdapterFactories.size();
        for (int i = start; i < count; i++) {
            CallAdapter<?, ?> adapter = this.callAdapterFactories.get(i).get(returnType, annotations, this);
            if (adapter != null) {
                return adapter;
            }
        }
        StringBuilder builder = new StringBuilder("Could not locate call adapter for ").append(returnType).append(".\n");
        if (skipPast != null) {
            builder.append("  Skipped:");
            for (int i2 = 0; i2 < start; i2++) {
                builder.append("\n   * ").append(this.callAdapterFactories.get(i2).getClass().getName());
            }
            builder.append(10);
        }
        builder.append("  Tried:");
        int count2 = this.callAdapterFactories.size();
        for (int i3 = start; i3 < count2; i3++) {
            builder.append("\n   * ").append(this.callAdapterFactories.get(i3).getClass().getName());
        }
        throw new IllegalArgumentException(builder.toString());
    }

    public List<Converter.Factory> converterFactories() {
        return this.converterFactories;
    }

    public <T> Converter<T, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations) {
        return nextRequestBodyConverter((Converter.Factory) null, type, parameterAnnotations, methodAnnotations);
    }

    public <T> Converter<T, RequestBody> nextRequestBodyConverter(@Nullable Converter.Factory skipPast, Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(parameterAnnotations, "parameterAnnotations == null");
        Objects.requireNonNull(methodAnnotations, "methodAnnotations == null");
        int start = this.converterFactories.indexOf(skipPast) + 1;
        int count = this.converterFactories.size();
        for (int i = start; i < count; i++) {
            Converter<?, RequestBody> converter = this.converterFactories.get(i).requestBodyConverter(type, parameterAnnotations, methodAnnotations, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder builder = new StringBuilder("Could not locate RequestBody converter for ").append(type).append(".\n");
        if (skipPast != null) {
            builder.append("  Skipped:");
            for (int i2 = 0; i2 < start; i2++) {
                builder.append("\n   * ").append(this.converterFactories.get(i2).getClass().getName());
            }
            builder.append(10);
        }
        builder.append("  Tried:");
        int count2 = this.converterFactories.size();
        for (int i3 = start; i3 < count2; i3++) {
            builder.append("\n   * ").append(this.converterFactories.get(i3).getClass().getName());
        }
        throw new IllegalArgumentException(builder.toString());
    }

    public <T> Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotations) {
        return nextResponseBodyConverter((Converter.Factory) null, type, annotations);
    }

    public <T> Converter<ResponseBody, T> nextResponseBodyConverter(@Nullable Converter.Factory skipPast, Type type, Annotation[] annotations) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotations, "annotations == null");
        int start = this.converterFactories.indexOf(skipPast) + 1;
        int count = this.converterFactories.size();
        for (int i = start; i < count; i++) {
            Converter<ResponseBody, ?> converter = this.converterFactories.get(i).responseBodyConverter(type, annotations, this);
            if (converter != null) {
                return converter;
            }
        }
        StringBuilder builder = new StringBuilder("Could not locate ResponseBody converter for ").append(type).append(".\n");
        if (skipPast != null) {
            builder.append("  Skipped:");
            for (int i2 = 0; i2 < start; i2++) {
                builder.append("\n   * ").append(this.converterFactories.get(i2).getClass().getName());
            }
            builder.append(10);
        }
        builder.append("  Tried:");
        int count2 = this.converterFactories.size();
        for (int i3 = start; i3 < count2; i3++) {
            builder.append("\n   * ").append(this.converterFactories.get(i3).getClass().getName());
        }
        throw new IllegalArgumentException(builder.toString());
    }

    public <T> Converter<T, String> stringConverter(Type type, Annotation[] annotations) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotations, "annotations == null");
        int count = this.converterFactories.size();
        for (int i = 0; i < count; i++) {
            Converter<?, String> converter = this.converterFactories.get(i).stringConverter(type, annotations, this);
            if (converter != null) {
                return converter;
            }
        }
        return BuiltInConverters.ToStringConverter.INSTANCE;
    }

    @Nullable
    public Executor callbackExecutor() {
        return this.callbackExecutor;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {
        @Nullable
        private HttpUrl baseUrl;
        private final List<CallAdapter.Factory> callAdapterFactories;
        @Nullable
        private Call.Factory callFactory;
        @Nullable
        private Executor callbackExecutor;
        private final List<Converter.Factory> converterFactories;
        private final Platform platform;
        private boolean validateEagerly;

        Builder(Platform platform2) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            this.platform = platform2;
        }

        public Builder() {
            this(Platform.get());
        }

        Builder(Retrofit retrofit) {
            this.converterFactories = new ArrayList();
            this.callAdapterFactories = new ArrayList();
            Platform platform2 = Platform.get();
            this.platform = platform2;
            this.callFactory = retrofit.callFactory;
            this.baseUrl = retrofit.baseUrl;
            int size = retrofit.converterFactories.size() - platform2.defaultConverterFactoriesSize();
            for (int i = 1; i < size; i++) {
                this.converterFactories.add(retrofit.converterFactories.get(i));
            }
            int size2 = retrofit.callAdapterFactories.size() - this.platform.defaultCallAdapterFactoriesSize();
            for (int i2 = 0; i2 < size2; i2++) {
                this.callAdapterFactories.add(retrofit.callAdapterFactories.get(i2));
            }
            this.callbackExecutor = retrofit.callbackExecutor;
            this.validateEagerly = retrofit.validateEagerly;
        }

        public Builder client(OkHttpClient client) {
            return callFactory((Call.Factory) Objects.requireNonNull(client, "client == null"));
        }

        public Builder callFactory(Call.Factory factory) {
            this.callFactory = (Call.Factory) Objects.requireNonNull(factory, "factory == null");
            return this;
        }

        public Builder baseUrl(URL baseUrl2) {
            Objects.requireNonNull(baseUrl2, "baseUrl == null");
            return baseUrl(HttpUrl.get(baseUrl2.toString()));
        }

        public Builder baseUrl(String baseUrl2) {
            Objects.requireNonNull(baseUrl2, "baseUrl == null");
            return baseUrl(HttpUrl.get(baseUrl2));
        }

        public Builder baseUrl(HttpUrl baseUrl2) {
            Objects.requireNonNull(baseUrl2, "baseUrl == null");
            List<String> pathSegments = baseUrl2.pathSegments();
            if ("".equals(pathSegments.get(pathSegments.size() - 1))) {
                this.baseUrl = baseUrl2;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + baseUrl2);
        }

        public Builder addConverterFactory(Converter.Factory factory) {
            this.converterFactories.add((Converter.Factory) Objects.requireNonNull(factory, "factory == null"));
            return this;
        }

        public Builder addCallAdapterFactory(CallAdapter.Factory factory) {
            this.callAdapterFactories.add((CallAdapter.Factory) Objects.requireNonNull(factory, "factory == null"));
            return this;
        }

        public Builder callbackExecutor(Executor executor) {
            this.callbackExecutor = (Executor) Objects.requireNonNull(executor, "executor == null");
            return this;
        }

        public List<CallAdapter.Factory> callAdapterFactories() {
            return this.callAdapterFactories;
        }

        public List<Converter.Factory> converterFactories() {
            return this.converterFactories;
        }

        public Builder validateEagerly(boolean validateEagerly2) {
            this.validateEagerly = validateEagerly2;
            return this;
        }

        public Retrofit build() {
            Executor callbackExecutor2;
            if (this.baseUrl != null) {
                Call.Factory callFactory2 = this.callFactory;
                if (callFactory2 == null) {
                    callFactory2 = new OkHttpClient();
                }
                Executor callbackExecutor3 = this.callbackExecutor;
                if (callbackExecutor3 == null) {
                    callbackExecutor2 = this.platform.defaultCallbackExecutor();
                } else {
                    callbackExecutor2 = callbackExecutor3;
                }
                List<CallAdapter.Factory> callAdapterFactories2 = new ArrayList<>(this.callAdapterFactories);
                callAdapterFactories2.addAll(this.platform.defaultCallAdapterFactories(callbackExecutor2));
                List<Converter.Factory> converterFactories2 = new ArrayList<>(this.converterFactories.size() + 1 + this.platform.defaultConverterFactoriesSize());
                converterFactories2.add(new BuiltInConverters());
                converterFactories2.addAll(this.converterFactories);
                converterFactories2.addAll(this.platform.defaultConverterFactories());
                return new Retrofit(callFactory2, this.baseUrl, Collections.unmodifiableList(converterFactories2), Collections.unmodifiableList(callAdapterFactories2), callbackExecutor2, this.validateEagerly);
            }
            throw new IllegalStateException("Base URL required.");
        }
    }
}
