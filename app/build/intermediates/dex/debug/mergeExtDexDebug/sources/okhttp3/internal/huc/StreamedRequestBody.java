package okhttp3.internal.huc;

import java.io.IOException;
import okhttp3.internal.http.UnrepeatableRequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;

final class StreamedRequestBody extends OutputStreamRequestBody implements UnrepeatableRequestBody {
    private final Pipe pipe;

    StreamedRequestBody(long expectedContentLength) {
        Pipe pipe2 = new Pipe(8192);
        this.pipe = pipe2;
        initOutputStream(Okio.buffer(pipe2.sink()), expectedContentLength);
    }

    public void writeTo(BufferedSink sink) throws IOException {
        Buffer buffer = new Buffer();
        while (this.pipe.source().read(buffer, 8192) != -1) {
            sink.write(buffer, buffer.size());
        }
    }
}
