package com.google.maps.android.data.kml;

public class KmlBoolean {
    public static boolean parseBoolean(String text) {
        if ("1".equals(text) || "true".equals(text)) {
            return true;
        }
        return false;
    }
}
