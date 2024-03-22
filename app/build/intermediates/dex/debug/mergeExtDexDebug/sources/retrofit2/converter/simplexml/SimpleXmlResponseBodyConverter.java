package retrofit2.converter.simplexml;

import java.io.IOException;
import okhttp3.ResponseBody;
import org.simpleframework.xml.Serializer;
import retrofit2.Converter;

final class SimpleXmlResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Class<T> cls;
    private final Serializer serializer;
    private final boolean strict;

    SimpleXmlResponseBodyConverter(Class<T> cls2, Serializer serializer2, boolean strict2) {
        this.cls = cls2;
        this.serializer = serializer2;
        this.strict = strict2;
    }

    public T convert(ResponseBody value) throws IOException {
        try {
            T read = this.serializer.read(this.cls, value.charStream(), this.strict);
            if (read != null) {
                value.close();
                return read;
            }
            throw new IllegalStateException("Could not deserialize body as " + this.cls);
        } catch (IOException | RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        } catch (Throwable read2) {
            value.close();
            throw read2;
        }
    }
}
