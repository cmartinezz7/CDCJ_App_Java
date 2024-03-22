package es.santander.justicia.utils;

import android.content.Context;

public class PreferencesHelper {
    private static final String PREFS_NAME = "preferences";
    private SecurePreferences mPrefs = null;

    private static native String getInfo1();

    public static PreferencesHelper newInstance(Context ctx, String name) {
        return new PreferencesHelper(ctx, name);
    }

    public static PreferencesHelper newInstance(Context ctx) {
        return new PreferencesHelper(ctx, PREFS_NAME);
    }

    private PreferencesHelper(Context ctx, String name) {
        this.mPrefs = new SecurePreferences(ctx, name, getInfo1(), true);
    }

    public String getString(String key) {
        SecurePreferences securePreferences = this.mPrefs;
        if (securePreferences != null) {
            return securePreferences.getString(key);
        }
        return "";
    }

    public void setString(String key, String value) {
        SecurePreferences securePreferences = this.mPrefs;
        if (securePreferences != null) {
            securePreferences.put(key, value);
        }
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        String value;
        SecurePreferences securePreferences = this.mPrefs;
        if (securePreferences == null || (value = securePreferences.getString(key)) == null || value.isEmpty()) {
            return defaultValue;
        }
        return Boolean.parseBoolean(value);
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public void setBoolean(String key, boolean value) {
        SecurePreferences securePreferences = this.mPrefs;
        if (securePreferences != null) {
            securePreferences.put(key, Boolean.toString(value));
        }
    }

    public void clear() {
        SecurePreferences securePreferences = this.mPrefs;
        if (securePreferences != null) {
            securePreferences.clear();
        }
    }
}
