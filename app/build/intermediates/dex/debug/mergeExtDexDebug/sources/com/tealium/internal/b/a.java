package com.tealium.internal.b;

import com.tealium.internal.b;
import com.tealium.internal.c;
import com.tealium.internal.d;
import com.tealium.internal.data.Dispatch;
import com.tealium.internal.listeners.DispatchSendListener;
import com.tealium.library.Tealium;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements DispatchSendListener {
    private final c a;
    private final String b;
    private final b c;
    private final String d;

    public a(Tealium.Config config, c cVar, String str) {
        String str2;
        this.a = cVar;
        this.c = config.getLogger();
        this.d = str;
        if (config.getOverrideS2SLegacyDispatchUrl() == null) {
            str2 = String.format(Locale.ROOT, "https://datacloud.tealiumiq.com/%s/%s/8/i.gif?data=", new Object[]{config.getAccountName(), config.getProfileName()});
        } else if (config.getOverrideS2SLegacyDispatchUrl().endsWith("data=")) {
            str2 = config.getOverrideS2SLegacyDispatchUrl();
        } else {
            str2 = config.getOverrideS2SLegacyDispatchUrl() + (config.getOverrideS2SLegacyDispatchUrl().contains("?") ? Typography.amp : '?') + "data=";
        }
        this.b = str2;
    }

    private String a(Dispatch dispatch) throws JSONException, UnsupportedEncodingException {
        return this.b + URLEncoder.encode(new JSONObject().put("data", dispatch.toJsonObject().put("cp.utag_main_v_id", this.d)).toString(), "UTF-8");
    }

    public void onDispatchSend(Dispatch dispatch) {
        try {
            this.a.c(d.b(a(dispatch)).a());
        } catch (UnsupportedEncodingException | JSONException e) {
            this.c.b(e);
        }
    }
}
