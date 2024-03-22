package com.tealium.internal.tagbridge;

import com.tealium.internal.c.i;
import com.tealium.internal.tagbridge.RemoteCommand;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

final class c {
    private final String a;
    private final RemoteCommand.Response b;

    c(com.tealium.internal.c cVar, String str) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (d.a(str)) {
            int indexOf = str.indexOf("?request=");
            String str2 = null;
            if (indexOf == -1) {
                this.a = str.substring("tealium://".length()).toLowerCase(Locale.ROOT);
                jSONObject = null;
            } else {
                this.a = str.substring("tealium://".length(), indexOf).toLowerCase(Locale.ROOT);
                try {
                    String decode = URLDecoder.decode(str.substring(indexOf + "?request=".length()), "UTF-8");
                    jSONObject = decode.length() == 0 ? new JSONObject() : new JSONObject(decode);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
            if (RemoteCommand.a(this.a)) {
                if (jSONObject == null) {
                    jSONObject2 = null;
                } else {
                    JSONObject optJSONObject = jSONObject.optJSONObject("config");
                    str2 = optJSONObject != null ? optJSONObject.optString("response_id", (String) null) : str2;
                    jSONObject2 = jSONObject.optJSONObject("payload");
                }
                this.b = a(cVar, this.a, str2, jSONObject2);
                return;
            }
            throw new IllegalArgumentException("The command id provided by the request is not a valid command id.");
        }
        throw new IllegalArgumentException("Given url must not be null.");
    }

    static RemoteCommand.Response a(final com.tealium.internal.c cVar, String str, String str2, JSONObject jSONObject) {
        return new RemoteCommand.Response(str, str2, jSONObject) {
            public void send() {
                String str;
                super.send();
                if (getId() != null) {
                    if (getBody() == null) {
                        str = String.format(Locale.ROOT, "try {\tutag.mobile.remote_api.response[\"%s\"][\"%s\"](%d);} catch(err) {\tconsole.error(err);};", new Object[]{getCommandId(), getId(), Integer.valueOf(getStatus())});
                    } else {
                        str = String.format(Locale.ROOT, "try {\tutag.mobile.remote_api.response[\"%s\"][\"%s\"](%d, %s);} catch(err) {\tconsole.error(err);};", new Object[]{getCommandId(), getId(), Integer.valueOf(getStatus()), JSONObject.quote(getBody())});
                    }
                    cVar.a(new i(str));
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public RemoteCommand.Response b() {
        return this.b;
    }
}
