package com.tealium.library;

import android.app.Application;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tealium.collect.listeners.CollectUpdateListener;
import com.tealium.collect.listeners.VisitorProfileUpdateListener;
import com.tealium.collect.visitor.VisitorProfile;
import com.tealium.internal.a.h;
import com.tealium.internal.b;
import com.tealium.internal.c;
import com.tealium.internal.c.g;
import com.tealium.internal.c.k;
import com.tealium.internal.c.m;
import com.tealium.internal.c.n;
import com.tealium.internal.data.Dispatch;
import com.tealium.internal.data.PublishSettings;
import com.tealium.internal.e;
import com.tealium.internal.tagbridge.RemoteCommand;
import com.tealium.library.DataSources;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Tealium {
    private static final Map<String, Tealium> a = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final c b;
    /* access modifiers changed from: private */
    public final DataSources c;
    private final String d;
    private final String e;
    private final String f;
    /* access modifiers changed from: private */
    public volatile VisitorProfile g;

    public static abstract class Config {
        protected static final boolean DEFAULT_IS_REMOTE_COMMAND_ENABLED = true;
        protected static final String DEFAULT_OVERRIDE_COLLECT_DISPATCH_URL = null;
        protected static final String DEFAULT_OVERRIDE_PUBLISH_SETTINGS_URL = null;
        protected static final String DEFAULT_OVERRIDE_TAG_MANAGEMENT_URL = null;
        private final Application a;
        private final String b;
        private final String c;
        private final String d;
        private final PublishSettings e;
        private final List<DispatchValidator> f;
        private final List<EventListener> g;
        private final File h;
        private final b i;
        private final String j;
        private boolean k;
        private String l;
        private String m;
        private String n;
        private String o;

        private Config(Application application, String str, String str2, String str3) {
            this.a = application;
            if (application != null) {
                this.b = str;
                if (!TextUtils.isEmpty(str)) {
                    this.c = str2;
                    if (!TextUtils.isEmpty(str2)) {
                        this.d = str3;
                        if (!TextUtils.isEmpty(str3)) {
                            this.j = new Uri.Builder().scheme("https").authority("tags.tiqcdn.com").appendPath("utag").appendPath(str).appendPath(str2).appendPath(str3).appendPath("mobile.html").appendQueryParameter(DataSources.Key.PLATFORM, "android").appendQueryParameter(DataSources.Key.DEVICE_OS_VERSION, Build.VERSION.RELEASE).appendQueryParameter(DataSources.Key.LIBRARY_VERSION, BuildConfig.VERSION_NAME).build().toString();
                            File file = new File(String.format(Locale.ROOT, "%s%ctealium%c%s%c%s%c%s", new Object[]{application.getFilesDir(), Character.valueOf(File.separatorChar), Character.valueOf(File.separatorChar), str, Character.valueOf(File.separatorChar), str2, Character.valueOf(File.separatorChar), str3}));
                            this.h = file;
                            file.mkdirs();
                            this.g = new LinkedList();
                            this.k = DEFAULT_IS_REMOTE_COMMAND_ENABLED;
                            this.n = DEFAULT_OVERRIDE_COLLECT_DISPATCH_URL;
                            this.l = DEFAULT_OVERRIDE_TAG_MANAGEMENT_URL;
                            this.m = DEFAULT_OVERRIDE_PUBLISH_SETTINGS_URL;
                            this.f = new LinkedList();
                            this.e = d.a(file);
                            this.i = new b(application, str3);
                            return;
                        }
                    }
                }
            }
            throw new IllegalArgumentException("All parameters must non-null; and account, profile, environment must be provided.");
        }

        private Config(Config config) {
            this.b = config.b;
            this.a = config.a;
            this.g = b(config.getEventListeners());
            this.j = config.j;
            this.f = b(config.f);
            this.d = config.d;
            this.n = config.n;
            this.m = config.m;
            this.l = config.l;
            this.o = config.o;
            this.c = config.c;
            this.e = config.e;
            this.k = config.k;
            this.h = config.h;
            this.i = config.i;
        }

        static Config a(Config config) {
            return new Config(config) {
                public Config setOverrideCollectDispatchUrl(String str) {
                    throw new UnsupportedOperationException();
                }

                public Config setOverridePublishSettingsUrl(String str) {
                    throw new UnsupportedOperationException();
                }

                public Config setOverrideS2SLegacyDispatchUrl(String str) {
                    throw new UnsupportedOperationException();
                }

                public Config setOverrideTagManagementUrl(String str) {
                    throw new UnsupportedOperationException();
                }

                public Config setRemoteCommandEnabled(boolean z) {
                    throw new UnsupportedOperationException();
                }
            };
        }

        private static String a(List<?> list) {
            int size = list.size() - 1;
            String str = "[";
            int i2 = 0;
            while (i2 <= size) {
                str = str + list.get(i2) + (i2 == size ? "" : ", ");
                i2++;
            }
            return str + "]";
        }

        private static <T> List<T> b(List<T> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (T next : list) {
                if (next != null) {
                    arrayList.add(next);
                }
            }
            return Collections.unmodifiableList(arrayList);
        }

        public static Config create(Application application, String str, String str2, String str3) {
            return new Config(application, str, str2, str3) {
            };
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            if (!this.b.equals(config.b) || !this.c.equals(config.c) || !this.d.equals(config.d) || !this.f.equals(config.f) || !this.g.equals(config.g) || this.k != config.k || !TextUtils.equals(this.l, config.l) || !TextUtils.equals(this.m, config.m) || !TextUtils.equals(this.n, config.n)) {
                return false;
            }
            return DEFAULT_IS_REMOTE_COMMAND_ENABLED;
        }

        public final String getAccountName() {
            return this.b;
        }

        public final Application getApplication() {
            return this.a;
        }

        public final VisitorProfile getCachedVisitorProfile() {
            return d.b(this.h);
        }

        public final String getDefaultTagManagementUrl() {
            return this.j;
        }

        public final List<DispatchValidator> getDispatchValidators() {
            return this.f;
        }

        public final String getEnvironmentName() {
            return this.d;
        }

        public final List<EventListener> getEventListeners() {
            return this.g;
        }

        public final b getLogger() {
            return this.i;
        }

        public final String getOverrideCollectDispatchUrl() {
            return this.n;
        }

        public final String getOverridePublishSettingsUrl() {
            return this.m;
        }

        public final String getOverrideS2SLegacyDispatchUrl() {
            return this.o;
        }

        public final String getOverrideTagManagementUrl() {
            return this.l;
        }

        public final String getProfileName() {
            return this.c;
        }

        public final PublishSettings getPublishSettings() {
            return this.e;
        }

        public final File getTealiumDir() {
            return this.h;
        }

        public final boolean isRemoteCommandEnabled() {
            return this.k;
        }

        public Config setOverrideCollectDispatchUrl(String str) {
            this.n = TextUtils.isEmpty(str) ? null : str;
            return this;
        }

        public Config setOverridePublishSettingsUrl(String str) {
            this.m = TextUtils.isEmpty(str) ? null : str;
            return this;
        }

        public Config setOverrideS2SLegacyDispatchUrl(String str) {
            this.o = TextUtils.isEmpty(str) ? null : str;
            return this;
        }

        public Config setOverrideTagManagementUrl(String str) {
            this.l = TextUtils.isEmpty(str) ? null : str;
            return this;
        }

        public Config setRemoteCommandEnabled(boolean z) {
            this.k = z;
            return this;
        }

        public String toString() {
            String property = System.getProperty("line.separator");
            String string = this.a.getString(R.string.enabled);
            String string2 = this.a.getString(R.string.disabled);
            String string3 = this.a.getString(R.string.config_account_name);
            String string4 = this.a.getString(R.string.config_profile_name);
            String string5 = this.a.getString(R.string.config_environment_name);
            String string6 = this.a.getString(R.string.config_override_dispatch_url);
            String string7 = this.a.getString(R.string.config_override_publish_settings_url);
            String string8 = this.a.getString(R.string.config_override_publish_url);
            String string9 = this.a.getString(R.string.config_override_s2s_legacy_url);
            String string10 = this.a.getString(R.string.config_dispatch_validators);
            String string11 = this.a.getString(R.string.config_event_listeners);
            String string12 = this.a.getString(R.string.config_remote_commands);
            String str = string;
            String str2 = this.a.getString(R.string.config_publish_settings) + (this.e.getSource() == null ? "(default)" : "(cached)");
            String str3 = string2;
            String str4 = "{" + property + "    " + string3 + ": " + this.b + property + "    " + string4 + ": " + this.c + property + "    " + string5 + ": " + this.d + property;
            if (this.n != null) {
                str4 = str4 + "    " + string6 + ": " + this.n + property;
            }
            if (this.m != null) {
                str4 = str4 + "    " + string7 + ": " + this.m + property;
            }
            if (this.l != null) {
                str4 = str4 + "    " + string8 + ": " + this.l + property;
            }
            if (this.o != null) {
                str4 = str4 + "    " + string9 + ": " + this.o + property;
            }
            return str4 + "    " + string10 + ": " + a((List<?>) this.f) + property + "    " + string11 + ": " + a((List<?>) this.g) + property + "    " + string12 + ": " + (this.k ? str : str3) + property + "    " + str2 + ": " + this.e.toString("    ") + property + "}";
        }
    }

    private Tealium(Config config, c cVar) {
        this.d = config.getAccountName();
        this.e = config.getProfileName();
        this.f = config.getEnvironmentName();
        DataSources dataSources = new DataSources(config);
        this.c = dataSources;
        this.b = cVar;
        cVar.a((EventListener) dataSources.a());
        cVar.a((EventListener) a());
    }

    private VisitorProfileUpdateListener a() {
        return new VisitorProfileUpdateListener() {
            public void onVisitorProfileUpdated(VisitorProfile visitorProfile, VisitorProfile visitorProfile2) {
                if (visitorProfile2 != null) {
                    VisitorProfile unused = Tealium.this.g = visitorProfile2;
                }
            }
        };
    }

    private Runnable a(final String str, final Config config) {
        return new Runnable() {
            public void run() {
                try {
                    Tealium.this.b.a((EventListener) config.getLogger());
                    Tealium.this.b.a((EventListener) new d(config, Tealium.this.b));
                    Tealium.this.b.a((EventListener) new g(str, config, Tealium.this.b));
                    if (!e.b(config.getApplication())) {
                        Tealium.this.b.a((EventListener) new b(config.getApplication(), Tealium.this.b));
                    }
                    Iterator<EventListener> it = config.getEventListeners().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next() instanceof CollectUpdateListener) {
                                Tealium.this.b.a((EventListener) new h(config, Tealium.this.b, Tealium.this.c.getVisitorId()));
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (config.getLogger().c()) {
                        config.getLogger().c(R.string.tealium_init_with, str, config.toString());
                    }
                } catch (Throwable th) {
                    config.getLogger().a(R.string.tealium_error_init, th);
                    Tealium.destroyInstance(str);
                }
            }
        };
    }

    private void a(Dispatch dispatch) {
        if (dispatch != null) {
            this.b.b(new k(dispatch));
            this.b.b(new g(dispatch));
            return;
        }
        throw new IllegalArgumentException();
    }

    public static Tealium createInstance(String str, Config config) {
        if (str == null || config == null) {
            throw new IllegalArgumentException("key and config must be non-null");
        }
        Config a2 = Config.a(config);
        c a3 = e.a(a2.getLogger());
        for (EventListener a4 : a2.getEventListeners()) {
            a3.a(a4);
        }
        Tealium tealium = new Tealium(a2, a3);
        a.put(str, tealium);
        tealium.b.a((EventListener) new a(a2, tealium.b));
        tealium.b.a((EventListener) new c(a2, tealium.b, tealium.c));
        tealium.b.b(tealium.a(str, a2));
        return tealium;
    }

    public static void destroyInstance(String str) {
        Tealium remove;
        if (str != null && (remove = a.remove(str)) != null) {
            remove.b.b(new com.tealium.internal.c.e(remove));
        }
    }

    public static Tealium getInstance(String str) {
        if (str == null) {
            return null;
        }
        return a.get(str);
    }

    public void addRemoteCommand(RemoteCommand remoteCommand) {
        if (remoteCommand != null) {
            this.b.a(new com.tealium.internal.c.c(remoteCommand));
            return;
        }
        throw new IllegalArgumentException();
    }

    public String getAccountName() {
        return this.d;
    }

    public VisitorProfile getCachedVisitorProfile() {
        return this.g;
    }

    public DataSources getDataSources() {
        return this.c;
    }

    public String getEnvironmentName() {
        return this.f;
    }

    public String getProfileName() {
        return this.e;
    }

    public void joinTrace(String str) {
        this.b.b(new n(str, false));
    }

    public void leaveTrace() {
        this.b.b(new n((String) null, false));
    }

    public void removeRemoteCommand(RemoteCommand remoteCommand) {
        if (remoteCommand != null) {
            this.b.a(new m(remoteCommand));
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void track(java.util.Map<java.lang.String, ?> r7) {
        /*
            r6 = this;
            r0 = -9223372036854775808
            if (r7 == 0) goto L_0x001b
            java.lang.String r2 = "timestamp_unix"
            java.lang.Object r2 = r7.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x001b
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ NumberFormatException -> 0x001a }
            long r2 = r2.longValue()     // Catch:{ NumberFormatException -> 0x001a }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            goto L_0x001c
        L_0x001a:
            r2 = move-exception
        L_0x001b:
            r2 = r0
        L_0x001c:
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0026
            com.tealium.internal.data.Dispatch r0 = new com.tealium.internal.data.Dispatch
            r0.<init>((java.util.Map<java.lang.String, ?>) r7)
            goto L_0x002e
        L_0x0026:
            com.tealium.internal.data.Dispatch r0 = new com.tealium.internal.data.Dispatch
            r0.<init>((long) r2)
            r0.putAll(r7)
        L_0x002e:
            r6.a((com.tealium.internal.data.Dispatch) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tealium.library.Tealium.track(java.util.Map):void");
    }

    public void trackEvent(String str, Map<String, ?> map) {
        Dispatch dispatch = new Dispatch(map);
        if (!TextUtils.isEmpty(str)) {
            dispatch.put(DataSources.Key.LINK_ID, str);
            dispatch.putIfAbsent(DataSources.Key.EVENT_NAME, str);
        }
        dispatch.putIfAbsent(DataSources.Key.CALL_TYPE, "link");
        a(dispatch);
    }

    public void trackView(String str, Map<String, ?> map) {
        Dispatch dispatch = new Dispatch(map);
        if (!TextUtils.isEmpty(str)) {
            dispatch.put(DataSources.Key.SCREEN_TITLE, str);
        }
        dispatch.putIfAbsent(DataSources.Key.PAGE_TYPE, "mobile_view");
        dispatch.putIfAbsent(DataSources.Key.CALL_TYPE, "view");
        a(dispatch);
    }
}
