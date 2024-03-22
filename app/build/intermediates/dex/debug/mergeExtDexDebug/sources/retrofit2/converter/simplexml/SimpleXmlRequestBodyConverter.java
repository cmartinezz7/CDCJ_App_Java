package retrofit2.converter.simplexml;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import org.simpleframework.xml.Serializer;
import retrofit2.Converter;

final class SimpleXmlRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final String CHARSET = "UTF-8";
    private static final MediaType MEDIA_TYPE = MediaType.get("application/xml; charset=UTF-8");
    private final Serializer serializer;

    SimpleXmlRequestBodyConverter(Serializer serializer2) {
        this.serializer = serializer2;
    }

    public RequestBody convert(T value) throws IOException {
        Buffer buffer = new Buffer();
        try {
            OutputStreamWriter osw = new OutputStreamWriter(buffer.outputStream(), CHARSET);
            this.serializer.write((Object) value, (Writer) osw);
            osw.flush();
            return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
        } catch (IOException | RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
