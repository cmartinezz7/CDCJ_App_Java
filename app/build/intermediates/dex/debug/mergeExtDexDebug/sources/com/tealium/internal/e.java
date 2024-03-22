package com.tealium.internal;

import android.app.UiModeManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import com.tealium.library.Tealium;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class e {

    public static final class a {
        public static String a(File file) {
            if (!file.exists()) {
                return null;
            }
            String str = "";
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        bufferedReader.close();
                        return str;
                    }
                }
            } catch (IOException e) {
                return null;
            }
        }

        public static boolean a(File file, String str) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                return true;
            } catch (IOException e) {
                return false;
            }
        }
    }

    public static final class b {
        public static SharedPreferences a(Tealium.Config config) {
            return config.getApplication().getSharedPreferences("tealium.datasources." + Integer.toHexString(b(config)), 0);
        }

        private static int b(Tealium.Config config) {
            return (config.getAccountName() + '.' + config.getProfileName() + '.' + config.getEnvironmentName()).hashCode();
        }
    }

    public static final class c {
        public static String a(String str) {
            if (str == null || str.length() == 0) {
                return str;
            }
            char charAt = str.charAt(0);
            return Character.isUpperCase(charAt) ? str : Character.toUpperCase(charAt) + str.substring(1);
        }

        public static String a(Throwable th) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean b(Context context) {
        return Build.VERSION.SDK_INT >= 13 && ((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4;
    }
}
