package com.tealium.internal.a;

import android.net.Uri;
import android.os.SystemClock;
import com.tealium.collect.attribute.AttributeGroup;
import com.tealium.collect.attribute.PropertyAttribute;
import com.tealium.collect.visitor.VisitorProfile;
import com.tealium.internal.b;
import com.tealium.internal.c;
import com.tealium.internal.d;
import com.tealium.internal.data.Dispatch;
import com.tealium.internal.listeners.DispatchSendListener;
import com.tealium.library.R;
import com.tealium.library.Tealium;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;

public final class h implements DispatchSendListener {
    private final String a;
    /* access modifiers changed from: private */
    public final AtomicLong b = new AtomicLong(0);
    /* access modifiers changed from: private */
    public final AtomicBoolean c = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final b d;
    private final c e;
    private final d.a f;
    /* access modifiers changed from: private */
    public VisitorProfile g;

    public h(Tealium.Config config, c cVar, String str) {
        this.e = cVar;
        this.d = config.getLogger();
        this.f = a();
        this.g = config.getCachedVisitorProfile();
        this.a = config.getOverrideCollectDispatchUrl() == null ? new Uri.Builder().scheme("https").authority("visitor-service.tealiumiq.com").appendPath(config.getAccountName()).appendPath("main").appendPath(str).build().toString() : config.getOverrideCollectDispatchUrl();
    }

    private d.a a() {
        return new d.a() {
            public void a(String str, String str2, int i, String str3, byte[] bArr) {
                String str4;
                if (bArr == null) {
                    str4 = "";
                } else {
                    try {
                        str4 = new String(bArr, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                }
                boolean z = false;
                h.this.c.set(false);
                VisitorProfile visitorProfile = null;
                if (str4.length() <= 2) {
                    h.this.d.a(R.string.profile_retriever_error_bad_profile, (Throwable) null, str4);
                    return;
                }
                h.this.b.set(SystemClock.uptimeMillis());
                try {
                    visitorProfile = VisitorProfile.fromJSON(str4);
                } catch (JSONException e2) {
                    h.this.d.a((Throwable) e2);
                }
                if (h.this.g == null || !h.this.g.equals(visitorProfile)) {
                    z = true;
                }
                if (z && visitorProfile != null) {
                    h hVar = h.this;
                    hVar.a(hVar.g, visitorProfile);
                    VisitorProfile unused = h.this.g = visitorProfile;
                }
            }

            public void a(String str, Throwable th) {
                h.this.d.a(R.string.profile_retriever_error_http, th, str);
                h.this.c.set(false);
            }
        };
    }

    /* access modifiers changed from: private */
    public void a(VisitorProfile visitorProfile, VisitorProfile visitorProfile2) {
        boolean z = true;
        boolean z2 = visitorProfile == null;
        if (visitorProfile2 != null) {
            z = false;
        }
        if (z2 && z) {
            return;
        }
        if (z2 || !visitorProfile.equals(visitorProfile2)) {
            this.e.a(new i(visitorProfile, visitorProfile2));
            AttributeGroup<PropertyAttribute> attributeGroup = null;
            a((a<?, ?>) new b(z2 ? null : visitorProfile.getAudiences(), z ? null : visitorProfile2.getAudiences()));
            a((a<?, ?>) new c(z2 ? null : visitorProfile.getBadges(), z ? null : visitorProfile2.getBadges()));
            a((a<?, ?>) new d(z2 ? null : visitorProfile.getDates(), z ? null : visitorProfile2.getDates()));
            a((a<?, ?>) new e(z2 ? null : visitorProfile.getFlags(), z ? null : visitorProfile2.getFlags()));
            a((a<?, ?>) new f(z2 ? null : visitorProfile.getMetrics(), z ? null : visitorProfile2.getMetrics()));
            AttributeGroup<PropertyAttribute> properties = z2 ? null : visitorProfile.getProperties();
            if (!z) {
                attributeGroup = visitorProfile2.getProperties();
            }
            a((a<?, ?>) new g(properties, attributeGroup));
        }
    }

    private void a(a<?, ?> aVar) {
        if (aVar.a()) {
            this.e.a(aVar);
        }
    }

    public void onDispatchSend(Dispatch dispatch) {
        if (this.c.compareAndSet(false, true)) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.b.get();
            if (uptimeMillis > 10000) {
                this.e.a(d.b(this.a).a(), 0);
                uptimeMillis = 0;
            }
            this.e.a(d.b(this.a).a(this.f).a(), uptimeMillis + 10000);
            if (this.d.a()) {
                this.d.a(R.string.visitor_profile_retriever_fetching, this.a);
            }
        }
    }
}
