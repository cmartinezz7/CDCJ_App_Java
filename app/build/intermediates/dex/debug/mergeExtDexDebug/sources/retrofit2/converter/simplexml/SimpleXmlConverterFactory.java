package retrofit2.converter.simplexml;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Deprecated
public final class SimpleXmlConverterFactory extends Converter.Factory {
    private final Serializer serializer;
    private final boolean strict;

    public static SimpleXmlConverterFactory create() {
        return create(new Persister());
    }

    public static SimpleXmlConverterFactory create(Serializer serializer2) {
        return new SimpleXmlConverterFactory(serializer2, true);
    }

    public static SimpleXmlConverterFactory createNonStrict() {
        return createNonStrict(new Persister());
    }

    public static SimpleXmlConverterFactory createNonStrict(Serializer serializer2) {
        if (serializer2 != null) {
            return new SimpleXmlConverterFactory(serializer2, false);
        }
        throw new NullPointerException("serializer == null");
    }

    private SimpleXmlConverterFactory(Serializer serializer2, boolean strict2) {
        this.serializer = serializer2;
        this.strict = strict2;
    }

    public boolean isStrict() {
        return this.strict;
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (!(type instanceof Class)) {
            return null;
        }
        return new SimpleXmlResponseBodyConverter((Class) type, this.serializer, this.strict);
    }

    @Nullable
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        if (!(type instanceof Class)) {
            return null;
        }
        return new SimpleXmlRequestBodyConverter(this.serializer);
    }
}
