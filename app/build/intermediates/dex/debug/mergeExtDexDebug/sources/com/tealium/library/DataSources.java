package com.tealium.library;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tealium.internal.data.Dispatch;
import com.tealium.internal.e;
import com.tealium.internal.listeners.PopulateDispatchListener;
import com.tealium.library.Tealium;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class DataSources {
    private final Random a = new SecureRandom();
    /* access modifiers changed from: private */
    public final Map<String, Object> b;
    /* access modifiers changed from: private */
    public final SharedPreferences c;
    private final TelephonyManager d;
    private final WindowManager e;
    private final ConnectivityManager f;
    private final SimpleDateFormat g;
    private final SimpleDateFormat h;
    private final String i;
    private final boolean j;

    public static class Key {
        public static final String APP_NAME = "app_name";
        public static final String APP_RDNS = "app_rdns";
        public static final String APP_VERSION = "app_version";
        public static final String ASSOCIATED_SCREEN_TITLE = "associated_screen_title";
        public static final String AUTOTRACKED = "autotracked";
        public static final String CALL_TYPE = "call_type";
        public static final String CARRIER = "carrier";
        public static final String CARRIER_ISO = "carrier_iso";
        public static final String CARRIER_MCC = "carrier_mcc";
        public static final String CARRIER_MNC = "carrier_mnc";
        public static final String CONNECTION_TYPE = "connection_type";
        public static final String DEVICE = "device";
        public static final String DEVICE_ARCHITECTURE = "device_architecture";
        public static final String DEVICE_BATTERY_PERCENT = "device_battery_percent";
        public static final String DEVICE_CPUTYPE = "device_cputype";
        public static final String DEVICE_ISCHARGING = "device_ischarging";
        public static final String DEVICE_LANGUAGE = "device_language";
        public static final String DEVICE_ORIENTATION = "device_orientation";
        public static final String DEVICE_OS_VERSION = "device_os_version";
        public static final String DEVICE_PUSH_TOKEN = "device_push_token";
        public static final String DEVICE_RESOLUTION = "device_resolution";
        public static final String EVENT_NAME = "event_name";
        public static final String EXCEPTION_NAME = "exception_name";
        public static final String EXCEPTION_REASON = "exception_reason";
        public static final String EXCEPTION_TOTALCRASHCOUNT = "exception_totalcrashcount";
        public static final String EXCEPTION_TRACE = "exception_trace";
        public static final String LIBRARY_VERSION = "library_version";
        public static final String LIFECYCLE_DAYOFWEEK_LOCAL = "lifecycle_dayofweek_local";
        public static final String LIFECYCLE_DAYSSINCELAUNCH = "lifecycle_dayssincelaunch";
        public static final String LIFECYCLE_DAYSSINCEUPDATE = "lifecycle_dayssinceupdate";
        public static final String LIFECYCLE_FIRSTLAUNCHDATE = "lifecycle_firstlaunchdate";
        public static final String LIFECYCLE_FIRSTLAUNCHDATE_MMDDYYYY = "lifecycle_firstlaunchdate_MMDDYYYY";
        public static final String LIFECYCLE_HOUROFDAY_LOCAL = "lifecycle_hourofday_local";
        public static final String LIFECYCLE_ISFIRSTLAUNCH = "lifecycle_isfirstlaunch";
        public static final String LIFECYCLE_ISFIRSTLAUNCHUPDATE = "lifecycle_isfirstlaunchupdate";
        public static final String LIFECYCLE_ISFIRSTWAKEMONTH = "lifecycle_isfirstwakemonth";
        public static final String LIFECYCLE_ISFIRSTWAKETODAY = "lifecycle_isfirstwaketoday";
        public static final String LIFECYCLE_LASTLAUNCHDATE = "lifecycle_lastlaunchdate";
        public static final String LIFECYCLE_LASTSLEEPDATE = "lifecycle_lastsleepdate";
        public static final String LIFECYCLE_LASTWAKEDATE = "lifecycle_lastwakedate";
        public static final String LIFECYCLE_LAUNCHCOUNT = "lifecycle_launchcount";
        public static final String LIFECYCLE_PRIORSECONDSAWAKE = "lifecycle_priorsecondsawake";
        public static final String LIFECYCLE_SECONDSAWAKE = "lifecycle_secondsawake";
        public static final String LIFECYCLE_SLEEPCOUNT = "lifecycle_sleepcount";
        public static final String LIFECYCLE_TOTALCRASHCOUNT = "lifecycle_totalcrashcount";
        public static final String LIFECYCLE_TOTALLAUNCHCOUNT = "lifecycle_totallaunchcount";
        public static final String LIFECYCLE_TOTALSECONDSAWAKE = "lifecycle_totalsecondsawake";
        public static final String LIFECYCLE_TOTALSLEEPCOUNT = "lifecycle_totalsleepcount";
        public static final String LIFECYCLE_TOTALWAKECOUNT = "lifecycle_totalwakecount";
        public static final String LIFECYCLE_TYPE = "lifecycle_type";
        public static final String LIFECYCLE_UPDATELAUNCHDATE = "lifecycle_updatelaunchdate";
        public static final String LIFECYCLE_WAKECOUNT = "lifecycle_wakecount";
        public static final String LINK_ID = "link_id";
        public static final String OBJECT_CLASS = "object_class";
        @Deprecated
        public static final String ORIENTATION = "orientation";
        public static final String ORIGIN = "origin";
        @Deprecated
        public static final String OS_VERSION = "os_version";
        public static final String PAGE_TYPE = "page_type";
        public static final String PLATFORM = "platform";
        public static final String SCREEN_TITLE = "screen_title";
        public static final String SELECTED_ROW = "selected_row";
        public static final String SELECTED_TITLE = "selected_title";
        public static final String SELECTED_VALUE = "selected_value";
        public static final String TEALIUM_ACCOUNT = "tealium_account";
        public static final String TEALIUM_ENVIRONMENT = "tealium_environment";
        public static final String TEALIUM_ID = "tealium_id";
        public static final String TEALIUM_LIBRARY_NAME = "tealium_library_name";
        public static final String TEALIUM_LIBRARY_VERSION = "tealium_library_version";
        public static final String TEALIUM_PROFILE = "tealium_profile";
        public static final String TEALIUM_RANDOM = "tealium_random";
        public static final String TEALIUM_SESSION_ID = "tealium_session_id";
        public static final String TEALIUM_TIMESTAMP_EPOCH = "tealium_timestamp_epoch";
        public static final String TEALIUM_VISITOR_ID = "tealium_visitor_id";
        public static final String TIMESTAMP = "timestamp";
        public static final String TIMESTAMP_LOCAL = "timestamp_local";
        public static final String TIMESTAMP_OFFSET = "timestamp_offset";
        public static final String TIMESTAMP_UNIX = "timestamp_unix";
        public static final String UUID = "uuid";
        public static final String VIEW_HEIGHT = "view_height";
        public static final String VIEW_WIDTH = "view_width";
        public static final String VISITOR_ID = "visitor_id";
        public static final String WAS_QUEUED = "was_queued";
        public static final String WEBVIEW_SERVICETYPE = "webview_servicetype";
        public static final String WEBVIEW_URL = "webview_url";

        private Key() {
        }
    }

    DataSources(Tealium.Config config) {
        Context applicationContext = config.getApplication().getApplicationContext();
        this.d = (TelephonyManager) applicationContext.getSystemService("phone");
        WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
        this.e = windowManager;
        this.f = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
        this.h = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.g = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        this.b = concurrentHashMap;
        a(applicationContext, (Map<String, Object>) concurrentHashMap);
        SharedPreferences a2 = e.b.a(config);
        this.c = a2;
        a(applicationContext, windowManager, a2);
        String string = a2.getString(Key.VISITOR_ID, (String) null);
        if (TextUtils.isEmpty(string) || !string.matches("^[0-9a-f]+$")) {
            string = a2.getString(Key.UUID, "").replace("-", "").toLowerCase(Locale.ROOT);
            string = !string.matches("^[0-9a-f]+$") ? UUID.randomUUID().toString().replace("-", "").toLowerCase(Locale.ROOT) : string;
            a2.edit().putString(Key.VISITOR_ID, string).putString(Key.TEALIUM_VISITOR_ID, string).apply();
        }
        this.i = string;
        this.j = e.b(applicationContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.net.ConnectivityManager r4) {
        /*
            android.net.NetworkInfo r0 = r4.getActiveNetworkInfo()
            r1 = 0
            if (r0 == 0) goto L_0x0026
            boolean r2 = r0.isConnectedOrConnecting()
            if (r2 == 0) goto L_0x0026
            int r2 = r0.getType()
            r3 = 1
            if (r2 != r3) goto L_0x0017
            java.lang.String r4 = "WIFI"
            return r4
        L_0x0017:
            int r0 = r0.getType()
            if (r0 != 0) goto L_0x0026
            android.net.NetworkInfo r4 = r4.getActiveNetworkInfo()
            java.lang.String r4 = r4.getSubtypeName()
            goto L_0x0027
        L_0x0026:
            r4 = r1
        L_0x0027:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = r4
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tealium.library.DataSources.a(android.net.ConnectivityManager):java.lang.String");
    }

    private static String a(WindowManager windowManager) {
        int rotation = windowManager.getDefaultDisplay().getRotation();
        return rotation != 1 ? rotation != 2 ? rotation != 3 ? "Portrait" : "Landscape Left" : "Portrait UpsideDown" : "Landscape Right";
    }

    private static String a(String str) {
        if (str == null || str.length() < 3) {
            return null;
        }
        return str.substring(0, 3);
    }

    private void a(Context context, WindowManager windowManager, SharedPreferences sharedPreferences) {
        String b2;
        String property;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (!sharedPreferences.contains(Key.DEVICE)) {
            String str = Build.MANUFACTURER;
            String str2 = Build.MODEL;
            edit.putString(Key.DEVICE, str2.startsWith(str) ? e.c.a(str2) : e.c.a(str) + " " + str2);
        }
        if (!sharedPreferences.contains(Key.DEVICE_ARCHITECTURE)) {
            edit.putString(Key.DEVICE_ARCHITECTURE, "32");
        }
        if (!sharedPreferences.contains(Key.DEVICE_CPUTYPE) && (property = System.getProperty("os.arch", (String) null)) != null) {
            edit.putString(Key.DEVICE_CPUTYPE, property);
        }
        if (!sharedPreferences.contains(Key.DEVICE_RESOLUTION) && (b2 = b(windowManager)) != null) {
            edit.putString(Key.DEVICE_RESOLUTION, b2);
        }
        if (!sharedPreferences.contains(Key.ORIGIN)) {
            edit.putString(Key.ORIGIN, e.b(context) ? "tv" : "mobile");
        }
        if (!sharedPreferences.contains(Key.PLATFORM)) {
            edit.putString(Key.PLATFORM, "android");
        }
        if (!sharedPreferences.contains(Key.UUID)) {
            edit.putString(Key.UUID, UUID.randomUUID().toString());
        }
        edit.apply();
    }

    private static void a(Context context, Map<String, Object> map) {
        String packageName = context.getPackageName();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo.labelRes != 0) {
            map.put(Key.APP_NAME, context.getString(applicationInfo.labelRes));
        }
        String a2 = e.a(context);
        if (a2 != null) {
            map.put(Key.APP_VERSION, a2);
        }
        map.put(Key.APP_RDNS, packageName);
        map.put(Key.DEVICE_OS_VERSION, Build.VERSION.RELEASE);
        map.put(Key.LIBRARY_VERSION, BuildConfig.VERSION_NAME);
        map.put(Key.OS_VERSION, Build.VERSION.RELEASE);
        map.put(Key.TEALIUM_LIBRARY_NAME, "android");
        map.put(Key.TEALIUM_LIBRARY_VERSION, BuildConfig.VERSION_NAME);
        map.put(Key.TEALIUM_SESSION_ID, Long.valueOf(System.currentTimeMillis()));
    }

    /* access modifiers changed from: private */
    public void a(Dispatch dispatch) {
        String a2 = a(this.f);
        String language = Locale.getDefault().getLanguage();
        Date date = new Date(dispatch.getCreationTime());
        if (!this.j) {
            String networkOperatorName = this.d.getNetworkOperatorName();
            String networkCountryIso = this.d.getNetworkCountryIso();
            String networkOperator = this.d.getNetworkOperator();
            String a3 = a(this.e);
            dispatch.putIfAbsent(Key.CARRIER, networkOperatorName);
            dispatch.putIfAbsent(Key.CARRIER_ISO, networkCountryIso);
            dispatch.putIfAbsent(Key.CARRIER_MCC, a(networkOperator));
            dispatch.putIfAbsent(Key.CARRIER_MNC, b(networkOperator));
            dispatch.putIfAbsent(Key.ORIENTATION, a3);
            dispatch.putIfAbsent(Key.DEVICE_ORIENTATION, a3);
        }
        dispatch.putIfAbsent(Key.CONNECTION_TYPE, a2);
        dispatch.putIfAbsent(Key.DEVICE_LANGUAGE, language);
        dispatch.putIfAbsent(Key.TIMESTAMP, this.h.format(date));
        dispatch.putIfAbsent(Key.TIMESTAMP_LOCAL, this.g.format(date));
        dispatch.putIfAbsent(Key.TIMESTAMP_OFFSET, String.format(Locale.ROOT, "%.0f", new Object[]{Float.valueOf(((float) TimeZone.getDefault().getOffset(dispatch.getCreationTime())) / 3600000.0f)}));
        dispatch.putIfAbsent(Key.TIMESTAMP_UNIX, Long.toString(dispatch.getCreationTime() / 1000));
        dispatch.putIfAbsent(Key.TEALIUM_TIMESTAMP_EPOCH, Long.toString(dispatch.getCreationTime() / 1000));
        dispatch.putIfAbsent(Key.TEALIUM_RANDOM, b());
    }

    private String b() {
        return String.format(Locale.ROOT, "%016d", new Object[]{Long.valueOf(Math.abs(this.a.nextLong() % 10000000000000000L))});
    }

    private static String b(WindowManager windowManager) {
        StringBuilder append;
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            if (point.x <= 0 || point.y <= 0) {
                return null;
            }
            append = new StringBuilder().append(point.x).append("x").append(point.y);
        } else {
            int width = defaultDisplay.getWidth();
            int height = defaultDisplay.getHeight();
            if (width <= 0 || height <= 0) {
                return null;
            }
            append = new StringBuilder().append(width).append("x").append(height);
        }
        return append.toString();
    }

    private static String b(String str) {
        if (str == null || str.length() <= 3) {
            return null;
        }
        return str.substring(3, str.length());
    }

    /* access modifiers changed from: package-private */
    public PopulateDispatchListener a() {
        return new PopulateDispatchListener() {
            public void onPopulateDispatch(Dispatch dispatch) {
                dispatch.putAllIfAbsent(DataSources.this.b);
                dispatch.putAllIfAbsent(DataSources.this.c.getAll());
                DataSources.this.a(dispatch);
            }
        };
    }

    public SharedPreferences getPersistentDataSources() {
        return this.c;
    }

    public String getVisitorId() {
        return this.i;
    }

    public Map<String, Object> getVolatileDataSources() {
        return this.b;
    }
}
