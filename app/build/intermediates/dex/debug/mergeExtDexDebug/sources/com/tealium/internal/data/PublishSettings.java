package com.tealium.internal.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class PublishSettings {
    public static final String KEY_BATTERY_SAVER = "battery_saver";
    public static final String KEY_COLLECT_ENABLED = "enable_collect";
    public static final String KEY_DISPATCH_EXPIRATION = "dispatch_expiration";
    public static final String KEY_EVENT_BATCH_SIZE = "event_batch_size";
    public static final String KEY_MINUTES_BETWEEN_REFRESH = "minutes_between_refresh";
    public static final String KEY_OFFLINE_DISPATCH_LIMIT = "offline_dispatch_limit";
    public static final String KEY_OVERRIDE_LOG = "override_log";
    public static final String KEY_S2S_LEGACY_ENABLED = "enable_s2s_legacy";
    public static final String KEY_TAG_MANAGEMENT_ENABLED = "enable_tag_management";
    public static final String KEY_WIFI_ONLY_SENDING = "wifi_only_sending";
    static final String a = null;
    private final String b;
    private final String c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final float i;
    private final float j;
    private final int k;
    private final int l;
    private volatile int m;

    public static class DisabledLibraryException extends Exception {
    }

    private PublishSettings() {
        this.j = -1.0f;
        this.k = 100;
        this.l = 1;
        this.g = false;
        this.h = true;
        this.i = 15.0f;
        this.d = false;
        this.e = false;
        this.f = false;
        this.b = a;
        this.c = null;
    }

    private PublishSettings(JSONObject jSONObject, String str) throws JSONException, DisabledLibraryException {
        if (jSONObject.optBoolean("_is_enabled", true)) {
            this.j = (float) jSONObject.optDouble(KEY_DISPATCH_EXPIRATION, -1.0d);
            this.k = jSONObject.optInt(KEY_OFFLINE_DISPATCH_LIMIT, 100);
            this.l = jSONObject.optInt(KEY_EVENT_BATCH_SIZE, 1);
            this.g = jSONObject.optBoolean(KEY_WIFI_ONLY_SENDING, false);
            this.h = jSONObject.optBoolean(KEY_BATTERY_SAVER, true);
            this.i = (float) jSONObject.optDouble(KEY_MINUTES_BETWEEN_REFRESH, 15.0d);
            this.d = jSONObject.optBoolean(KEY_TAG_MANAGEMENT_ENABLED, false);
            this.e = jSONObject.optBoolean(KEY_COLLECT_ENABLED, false);
            this.f = jSONObject.optBoolean(KEY_S2S_LEGACY_ENABLED, false);
            this.b = jSONObject.optString(KEY_OVERRIDE_LOG, a);
            this.c = str;
            return;
        }
        throw new DisabledLibraryException();
    }

    private static boolean a(float f2, float f3) {
        return Math.abs(f2 - f3) < 1.0E-6f;
    }

    public static PublishSettings from(String str) throws DisabledLibraryException {
        if (str == null) {
            return new PublishSettings();
        }
        try {
            return new PublishSettings(new JSONObject(str), str);
        } catch (JSONException e2) {
            return new PublishSettings();
        }
    }

    public static PublishSettings from(JSONObject jSONObject) throws DisabledLibraryException {
        if (jSONObject == null) {
            return new PublishSettings();
        }
        try {
            return new PublishSettings(jSONObject, jSONObject.toString());
        } catch (JSONException e2) {
            return new PublishSettings();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PublishSettings)) {
            return super.equals(obj);
        }
        PublishSettings publishSettings = (PublishSettings) obj;
        return a(this.j, publishSettings.j) && this.k == publishSettings.k && this.l == publishSettings.l && this.g == publishSettings.g && this.h == publishSettings.h && TextUtils.equals(this.b, publishSettings.b) && this.d == publishSettings.d && this.e == publishSettings.e && this.f == publishSettings.f && this.g == publishSettings.g && a(this.i, publishSettings.i);
    }

    public float getDispatchExpiration() {
        return this.j;
    }

    public int getEventBatchSize() {
        return this.l;
    }

    public float getMinutesBetweenRefresh() {
        return this.i;
    }

    public int getOfflineDispatchLimit() {
        return this.k;
    }

    public String getOverrideLog() {
        return this.b;
    }

    public String getSource() {
        return this.c;
    }

    public int hashCode() {
        int i2 = this.m;
        if (i2 != 0) {
            return i2;
        }
        String str = this.b;
        int hashCode = ((((((((((((((((((527 + (str == null ? 0 : str.hashCode())) * 31) + Float.floatToIntBits(this.i)) * 31) + Float.floatToIntBits(this.j)) * 31) + this.k) * 31) + this.l) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0);
        this.m = hashCode;
        return hashCode;
    }

    public boolean isBatterySaver() {
        return this.h;
    }

    public boolean isCollectEnabled() {
        return this.e;
    }

    public boolean isS2SLegacyEnabled() {
        return this.f;
    }

    public boolean isTagManagementEnabled() {
        return this.d;
    }

    public boolean isWifiOnlySending() {
        return this.g;
    }

    public String toString() {
        return toString((String) null);
    }

    public String toString(String str) {
        String property = System.getProperty("line.separator");
        if (str == null) {
            str = "";
        }
        String str2 = str.length() == 0 ? "    " : str + str;
        return '{' + property + str2 + KEY_BATTERY_SAVER + " : " + this.h + ',' + property + str2 + KEY_DISPATCH_EXPIRATION + " : " + this.j + ',' + property + str2 + KEY_COLLECT_ENABLED + " : " + this.e + ',' + property + str2 + KEY_S2S_LEGACY_ENABLED + " : " + this.f + ',' + property + str2 + KEY_TAG_MANAGEMENT_ENABLED + " : " + this.d + ',' + property + str2 + KEY_EVENT_BATCH_SIZE + " : " + this.l + ',' + property + str2 + KEY_MINUTES_BETWEEN_REFRESH + " : " + this.i + ',' + property + str2 + KEY_OFFLINE_DISPATCH_LIMIT + " : " + this.k + ',' + property + str2 + KEY_OVERRIDE_LOG + " : " + this.b + ',' + property + str2 + KEY_WIFI_ONLY_SENDING + " : " + this.g + property + str + '}';
    }
}
