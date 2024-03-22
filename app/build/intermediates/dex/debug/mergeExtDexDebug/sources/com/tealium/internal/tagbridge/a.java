package com.tealium.internal.tagbridge;

import android.text.TextUtils;
import com.tealium.internal.c;
import com.tealium.internal.c.n;
import com.tealium.internal.tagbridge.RemoteCommand;

final class a extends RemoteCommand {
    private final c a;

    a(c cVar) {
        super("_config", "Java callback for mobile.html information.");
        this.a = cVar;
        if (cVar == null) {
            throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: protected */
    public void onInvoke(RemoteCommand.Response response) throws Exception {
        String optString = response.getRequestPayload().optString("trace_id", (String) null);
        if (!TextUtils.isEmpty(optString)) {
            this.a.b(new n(optString, true));
        }
        response.send();
    }
}
