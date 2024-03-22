package com.santander.globile.mobisec.logger;

import android.util.Log;

public class GlobileLog {
    private static boolean enabled;

    public GlobileLog() {
        throw new IllegalStateException("Static Logger class");
    }

    public static void enable() {
        enabled = true;
    }

    public static void v(String msg) {
        if (enabled) {
            Log.v(buildTag(), msg);
        }
    }

    public static void v(String tag, String msg) {
        if (enabled) {
            Log.v(tag, msg);
        }
    }

    public static void v(String tag, String msg, Throwable tr) {
        if (enabled) {
            Log.v(tag, msg, tr);
        }
    }

    public static void d(String msg) {
        if (enabled) {
            d(buildTag(), msg);
        }
    }

    public static void d(String tag, String msg) {
        if (enabled) {
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (enabled) {
            Log.d(tag, msg, tr);
        }
    }

    public static void i(String msg) {
        if (enabled) {
            i(buildTag(), msg);
        }
    }

    public static void i(String tag, String msg) {
        if (enabled) {
            Log.i(tag, msg);
        }
    }

    public static void i(String tag, String msg, Throwable tr) {
        if (enabled) {
            Log.i(tag, msg, tr);
        }
    }

    public static void e(Throwable tr) {
        if (enabled) {
            Log.e(buildTag(), "", tr);
        }
    }

    public static void e(String msg) {
        if (enabled) {
            Log.e(buildTag(), msg);
        }
    }

    public static void e(String tag, String msg) {
        if (enabled) {
            Log.e(tag, msg);
        }
    }

    public static void e(String msg, Throwable tr) {
        if (enabled) {
            Log.e(buildTag(), msg, tr);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (enabled) {
            Log.e(tag, msg, tr);
        }
    }

    private static String buildTag() {
        try {
            return Thread.currentThread().getStackTrace()[4].getFileName().split("\\.")[0] + "." + Thread.currentThread().getStackTrace()[4].getMethodName() + ":" + Thread.currentThread().getStackTrace()[4].getLineNumber();
        } catch (Throwable th) {
            return "GlobileLog";
        }
    }
}
