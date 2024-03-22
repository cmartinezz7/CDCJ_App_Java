package com.tealium.internal.b;

import android.text.TextUtils;
import com.tealium.internal.c;
import com.tealium.internal.d;
import com.tealium.internal.data.Dispatch;
import com.tealium.internal.listeners.DispatchSendListener;
import com.tealium.library.DataSources;
import com.tealium.library.R;
import com.tealium.library.Tealium;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public final class b implements DispatchSendListener {
    private final com.tealium.internal.b a;
    private final c b;
    private final String c;
    private String d;

    public b(Tealium.Config config, c cVar, com.tealium.internal.b bVar, String str) {
        String format;
        if (config == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.a = bVar;
        this.b = cVar;
        if (config.getOverrideCollectDispatchUrl() == null) {
            format = String.format(Locale.ROOT, "https://collect.tealiumiq.com/vdata/i.gif?tealium_vid=%s&tealium_account=%s&tealium_profile=main", new Object[]{str, config.getAccountName()});
        } else if (config.getOverrideCollectDispatchUrl().contains("?")) {
            String overrideCollectDispatchUrl = config.getOverrideCollectDispatchUrl();
            overrideCollectDispatchUrl = !config.getOverrideCollectDispatchUrl().contains("tealium_vid") ? overrideCollectDispatchUrl + "&tealium_vid=" + str : overrideCollectDispatchUrl;
            overrideCollectDispatchUrl = !config.getOverrideCollectDispatchUrl().contains(DataSources.Key.TEALIUM_ACCOUNT) ? overrideCollectDispatchUrl + "&tealium_account=" + config.getAccountName() : overrideCollectDispatchUrl;
            this.c = !config.getOverrideCollectDispatchUrl().contains(DataSources.Key.TEALIUM_PROFILE) ? overrideCollectDispatchUrl + "&tealium_profile=main" : overrideCollectDispatchUrl;
            return;
        } else {
            format = String.format(Locale.ROOT, "%s?tealium_vid=%s&tealium_account=%s&tealium_profile=main", new Object[]{config.getOverrideCollectDispatchUrl(), str, config.getAccountName()});
        }
        this.c = format;
    }

    private String a(Dispatch dispatch) throws UnsupportedEncodingException {
        String str;
        String str2 = this.c;
        if (this.d != null) {
            str2 = str2 + "&tealium_trace_id=" + this.d;
        }
        String[] keys = dispatch.keys();
        for (String str3 : keys) {
            Object obj = dispatch.get(str3);
            str = str + "&" + URLEncoder.encode(str3, "UTF-8") + "=";
            if (obj instanceof String[]) {
                String[] strArr = (String[]) obj;
                int length = strArr.length - 1;
                for (int i = 0; i <= length; i++) {
                    str = str + URLEncoder.encode(strArr[i], "UTF-8");
                    if (i != length) {
                        str = str + ',';
                    }
                }
            } else {
                str = str + URLEncoder.encode(obj.toString(), "UTF-8");
            }
        }
        return str;
    }

    public void a(String str) {
        this.d = str;
    }

    public void onDispatchSend(Dispatch dispatch) {
        try {
            String a2 = a(dispatch);
            if (this.a.a()) {
                this.a.a(R.string.vdata_dispatcher_sending, a2);
            }
            this.b.c(d.b(a2).a());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
