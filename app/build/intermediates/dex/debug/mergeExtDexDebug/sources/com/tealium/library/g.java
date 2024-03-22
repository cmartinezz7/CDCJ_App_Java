package com.tealium.library;

import android.os.SystemClock;
import com.tealium.internal.a;
import com.tealium.internal.b;
import com.tealium.internal.c;
import com.tealium.internal.c.l;
import com.tealium.internal.d;
import com.tealium.internal.data.Dispatch;
import com.tealium.internal.data.PublishSettings;
import com.tealium.internal.listeners.DispatchReadyListener;
import com.tealium.library.Tealium;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

final class g implements d.a, DispatchReadyListener {
    private final String a;
    private final String b;
    private final c c;
    private final a d;
    /* access modifiers changed from: private */
    public final AtomicInteger e;
    private final SimpleDateFormat f;
    /* access modifiers changed from: private */
    public final b g;
    private volatile PublishSettings h;
    /* access modifiers changed from: private */
    public volatile long i;
    /* access modifiers changed from: private */
    public volatile long j;

    g(String str, Tealium.Config config, c cVar) {
        this(str, config, cVar, a.a(config.getApplication().getApplicationContext()));
    }

    private g(String str, Tealium.Config config, c cVar, a aVar) {
        this.b = config.getOverridePublishSettingsUrl() == null ? config.getDefaultTagManagementUrl() : config.getOverridePublishSettingsUrl();
        this.a = str;
        this.h = config.getPublishSettings();
        this.c = cVar;
        this.d = aVar;
        this.g = config.getLogger();
        this.e = new AtomicInteger(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
        this.f = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        if (this.h.getSource() == null) {
            a(false);
        }
    }

    private void a() {
        if (!(this.h.isWifiOnlySending() && !this.d.a()) && this.d.b() && 1 != this.e.getAndSet(1)) {
            this.c.c(d.a(this.b).a((d.a) this).a("If-Modified-Since", this.f.format(new Date(this.j))).a());
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        if (i2 == 200) {
            a(true);
        } else {
            this.e.set(0);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (JSONException e2) {
            this.g.d(R.string.publish_settings_retriever_malformed_json, str);
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            PublishSettings from = PublishSettings.from(jSONObject.optJSONObject(BuildConfig.PUBLISH_SETTINGS_VERSION));
            if (!this.h.equals(from)) {
                this.h = from;
                this.c.b(new l(this.h));
            } else if (this.g.a()) {
                this.g.a(R.string.publish_settings_retriever_no_change, new Object[0]);
            }
        } catch (PublishSettings.DisabledLibraryException e2) {
            if (this.g.c()) {
                this.g.c(R.string.publish_settings_retriever_disabled, this.a);
            }
            Tealium.destroyInstance(this.a);
        } catch (JSONException e3) {
            throw new RuntimeException(e3);
        }
    }

    private void a(boolean z) {
        if (!(this.h.isWifiOnlySending() && !this.d.a()) && this.d.b()) {
            if (z || 1 != this.e.getAndSet(1)) {
                if (this.g.a()) {
                    this.g.a(R.string.publish_settings_retriever_fetching, this.b);
                }
                this.c.c(d.b(this.b).a((d.a) this).a());
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (str != null) {
            try {
                String a2 = f.a(str);
                if (a2 != null) {
                    a(new JSONObject(a2));
                } else {
                    this.g.a(R.string.publish_settings_retriever_no_mps);
                }
            } catch (JSONException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private boolean b() {
        return SystemClock.elapsedRealtime() - this.i > ((long) this.h.getMinutesBetweenRefresh()) * 60000;
    }

    public void a(String str, String str2, int i2, String str3, byte[] bArr) {
        final boolean contains = str3 != null ? str3.toLowerCase(Locale.ROOT).contains("html") : false;
        final String str4 = str2;
        final byte[] bArr2 = bArr;
        final int i3 = i2;
        this.c.b((Runnable) new Runnable() {
            public void run() {
                try {
                    if ("GET".equals(str4)) {
                        long unused = g.this.i = SystemClock.elapsedRealtime();
                        long unused2 = g.this.j = System.currentTimeMillis();
                        g.this.e.set(0);
                        String str = new String(bArr2, "UTF-8");
                        if (contains) {
                            g.this.b(str);
                        } else {
                            g.this.a(str);
                        }
                    } else if ("HEAD".equals(str4)) {
                        g.this.a(i3);
                    }
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException(e2);
                } catch (Throwable th) {
                    g.this.g.b(th);
                }
            }
        });
    }

    public void a(String str, Throwable th) {
        this.e.set(0);
    }

    public void onDispatchReady(Dispatch dispatch) {
        boolean z = this.h.getSource() == null;
        if (!b() && !z) {
            return;
        }
        if (z) {
            a(false);
        } else {
            a();
        }
    }
}
