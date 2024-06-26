package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

public interface Authenticator {
    public static final Authenticator NONE = $$Lambda$Authenticator$esJoevooYalsFzydukZpZJT5arU.INSTANCE;

    @Nullable
    Request authenticate(@Nullable Route route, Response response) throws IOException;

    static /* synthetic */ Request lambda$static$0(Route route, Response response) throws IOException {
        return null;
    }
}
