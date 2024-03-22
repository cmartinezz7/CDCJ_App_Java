package com.tealium.internal.tagbridge;

import com.tealium.internal.e;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONObject;

public abstract class RemoteCommand {
    private final String a;
    private final String b;

    public static class Response {
        public static final int STATUS_BAD_REQUEST = 400;
        public static final int STATUS_OK = 200;
        private final String a;
        private final String b;
        private final JSONObject c;
        private int d;
        private String e;
        private boolean f;

        public Response(String str, String str2, JSONObject jSONObject) {
            if (str != null) {
                this.a = str;
                this.b = str2;
                this.c = jSONObject == null ? new JSONObject() : jSONObject;
                this.d = STATUS_OK;
                this.e = null;
                this.f = false;
                return;
            }
            throw new IllegalArgumentException("mCommandId must not be null.");
        }

        public final String getBody() {
            return this.e;
        }

        public final String getCommandId() {
            return this.a;
        }

        public final String getId() {
            return this.b;
        }

        public final JSONObject getRequestPayload() {
            return this.c;
        }

        public final int getStatus() {
            return this.d;
        }

        public final boolean isSent() {
            return this.f;
        }

        public void send() {
            if (!this.f) {
                this.f = true;
                return;
            }
            throw new IllegalStateException("Response already sent.");
        }

        public final Response setBody(String str) {
            if (!this.f) {
                this.e = str;
                return this;
            }
            throw new IllegalStateException("Response already sent.");
        }

        public final Response setStatus(int i) {
            if (!this.f) {
                this.d = i;
                return this;
            }
            throw new IllegalStateException("Response already sent.");
        }
    }

    public RemoteCommand(String str, String str2) {
        if (str == null || !a(str)) {
            throw new IllegalArgumentException("Invalid remote command name.");
        }
        this.a = str.toLowerCase(Locale.ROOT);
        this.b = str2 == null ? "" : str2;
    }

    static boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return Pattern.matches("^[\\w-]*$", str);
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public final void a(c cVar) {
        if (cVar != null) {
            try {
                onInvoke(cVar.b());
            } catch (Throwable th) {
                cVar.b().setStatus(555).setBody(e.c.a(th)).send();
            }
        } else {
            throw new IllegalArgumentException("request must not be null.");
        }
    }

    /* access modifiers changed from: protected */
    public abstract void onInvoke(Response response) throws Exception;
}
