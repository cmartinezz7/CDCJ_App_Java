package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okio.ByteString;

public final class Credentials {
    private Credentials() {
    }

    public static String basic(String username, String password) {
        return basic(username, password, StandardCharsets.ISO_8859_1);
    }

    public static String basic(String username, String password, Charset charset) {
        return "Basic " + ByteString.encodeString(username + ":" + password, charset).base64();
    }
}
