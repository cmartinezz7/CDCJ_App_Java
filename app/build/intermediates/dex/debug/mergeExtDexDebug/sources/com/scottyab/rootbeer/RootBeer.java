package com.scottyab.rootbeer;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.scottyab.rootbeer.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class RootBeer {
    private boolean loggingEnabled = true;
    private final Context mContext;

    public RootBeer(Context context) {
        this.mContext = context;
    }

    public boolean isRooted() {
        return detectRootManagementApps() || detectPotentiallyDangerousApps() || checkForBinary("su") || checkForDangerousProps() || checkForRWPaths() || detectTestKeys() || checkSuExists() || checkForRootNative() || checkForMagiskBinary();
    }

    @Deprecated
    public boolean isRootedWithoutBusyBoxCheck() {
        return isRooted();
    }

    public boolean isRootedWithBusyBoxCheck() {
        return detectRootManagementApps() || detectPotentiallyDangerousApps() || checkForBinary("su") || checkForBinary("busybox") || checkForDangerousProps() || checkForRWPaths() || detectTestKeys() || checkSuExists() || checkForRootNative() || checkForMagiskBinary();
    }

    public boolean detectTestKeys() {
        String buildTags = Build.TAGS;
        return buildTags != null && buildTags.contains("test-keys");
    }

    public boolean detectRootManagementApps() {
        return detectRootManagementApps((String[]) null);
    }

    public boolean detectRootManagementApps(String[] additionalRootManagementApps) {
        ArrayList<String> packages = new ArrayList<>(Arrays.asList(Const.knownRootAppsPackages));
        if (additionalRootManagementApps != null && additionalRootManagementApps.length > 0) {
            packages.addAll(Arrays.asList(additionalRootManagementApps));
        }
        return isAnyPackageFromListInstalled(packages);
    }

    public boolean detectPotentiallyDangerousApps() {
        return detectPotentiallyDangerousApps((String[]) null);
    }

    public boolean detectPotentiallyDangerousApps(String[] additionalDangerousApps) {
        ArrayList<String> packages = new ArrayList<>();
        packages.addAll(Arrays.asList(Const.knownDangerousAppsPackages));
        if (additionalDangerousApps != null && additionalDangerousApps.length > 0) {
            packages.addAll(Arrays.asList(additionalDangerousApps));
        }
        return isAnyPackageFromListInstalled(packages);
    }

    public boolean detectRootCloakingApps() {
        return detectRootCloakingApps((String[]) null) || (canLoadNativeLibrary() && !checkForNativeLibraryReadAccess());
    }

    public boolean detectRootCloakingApps(String[] additionalRootCloakingApps) {
        ArrayList<String> packages = new ArrayList<>(Arrays.asList(Const.knownRootCloakingPackages));
        if (additionalRootCloakingApps != null && additionalRootCloakingApps.length > 0) {
            packages.addAll(Arrays.asList(additionalRootCloakingApps));
        }
        return isAnyPackageFromListInstalled(packages);
    }

    public boolean checkForSuBinary() {
        return checkForBinary("su");
    }

    public boolean checkForMagiskBinary() {
        return checkForBinary("magisk");
    }

    public boolean checkForBusyBoxBinary() {
        return checkForBinary("busybox");
    }

    public boolean checkForBinary(String filename) {
        boolean result = false;
        for (String path : Const.getPaths()) {
            String completePath = path + filename;
            if (new File(path, filename).exists()) {
                QLog.v(completePath + " binary detected!");
                result = true;
            }
        }
        return result;
    }

    public void setLogging(boolean logging) {
        this.loggingEnabled = logging;
        QLog.LOGGING_LEVEL = logging ? 5 : 0;
    }

    private String[] propsReader() {
        try {
            InputStream inputstream = Runtime.getRuntime().exec("getprop").getInputStream();
            if (inputstream == null) {
                return null;
            }
            return new Scanner(inputstream).useDelimiter("\\A").next().split("\n");
        } catch (IOException | NoSuchElementException e) {
            QLog.e(e);
            return null;
        }
    }

    private String[] mountReader() {
        try {
            InputStream inputstream = Runtime.getRuntime().exec("mount").getInputStream();
            if (inputstream == null) {
                return null;
            }
            return new Scanner(inputstream).useDelimiter("\\A").next().split("\n");
        } catch (IOException | NoSuchElementException e) {
            QLog.e(e);
            return null;
        }
    }

    private boolean isAnyPackageFromListInstalled(List<String> packages) {
        boolean result = false;
        PackageManager pm = this.mContext.getPackageManager();
        for (String packageName : packages) {
            try {
                pm.getPackageInfo(packageName, 0);
                QLog.e((Object) packageName + " ROOT management app detected!");
                result = true;
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
        return result;
    }

    public boolean checkForDangerousProps() {
        Map<String, String> dangerousProps = new HashMap<>();
        dangerousProps.put("ro.debuggable", "1");
        dangerousProps.put("ro.secure", "0");
        boolean result = false;
        String[] lines = propsReader();
        if (lines == null) {
            return false;
        }
        for (String line : lines) {
            for (String key : dangerousProps.keySet()) {
                if (line.contains(key)) {
                    String badValue = "[" + dangerousProps.get(key) + "]";
                    if (line.contains(badValue)) {
                        QLog.v(key + " = " + badValue + " detected!");
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    public boolean checkForRWPaths() {
        String mountOptions;
        String mountPoint;
        String[] lines;
        boolean result = false;
        String[] lines2 = mountReader();
        int i = 0;
        if (lines2 == null) {
            return false;
        }
        int sdkVersion = Build.VERSION.SDK_INT;
        int length = lines2.length;
        int i2 = 0;
        while (i2 < length) {
            String line = lines2[i2];
            String[] args = line.split(" ");
            int i3 = 23;
            if ((sdkVersion > 23 || args.length >= 4) && (sdkVersion <= 23 || args.length >= 6)) {
                if (sdkVersion > 23) {
                    mountPoint = args[2];
                    mountOptions = args[5];
                } else {
                    mountPoint = args[1];
                    mountOptions = args[3];
                }
                String[] strArr = Const.pathsThatShouldNotBeWritable;
                int length2 = strArr.length;
                int i4 = i;
                while (i4 < length2) {
                    String pathToCheck = strArr[i4];
                    if (mountPoint.equalsIgnoreCase(pathToCheck)) {
                        if (Build.VERSION.SDK_INT > i3) {
                            mountOptions = mountOptions.replace("(", "").replace(")", "");
                        }
                        String[] split = mountOptions.split(",");
                        int length3 = split.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length3) {
                                lines = lines2;
                                break;
                            }
                            boolean result2 = result;
                            lines = lines2;
                            if (split[i5].equalsIgnoreCase("rw")) {
                                QLog.v(pathToCheck + " path is mounted with rw permissions! " + line);
                                result = true;
                                break;
                            }
                            i5++;
                            result = result2;
                            lines2 = lines;
                        }
                    } else {
                        lines = lines2;
                    }
                    i4++;
                    lines2 = lines;
                    i3 = 23;
                }
                boolean z = result;
            } else {
                QLog.e((Object) "Error formatting mount line: " + line);
            }
            i2++;
            lines2 = lines2;
            i = 0;
        }
        return result;
    }

    public boolean checkSuExists() {
        Process process = null;
        boolean z = false;
        try {
            Process process2 = Runtime.getRuntime().exec(new String[]{"which", "su"});
            if (new BufferedReader(new InputStreamReader(process2.getInputStream())).readLine() != null) {
                z = true;
            }
            if (process2 != null) {
                process2.destroy();
            }
            return z;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }

    public boolean checkForNativeLibraryReadAccess() {
        try {
            new RootBeerNative().setLogDebugMessages(this.loggingEnabled);
            return true;
        } catch (UnsatisfiedLinkError e) {
            return false;
        }
    }

    public boolean canLoadNativeLibrary() {
        return new RootBeerNative().wasNativeLibraryLoaded();
    }

    public boolean checkForRootNative() {
        if (!canLoadNativeLibrary()) {
            QLog.e((Object) "We could not load the native library to test for root");
            return false;
        }
        String[] paths = Const.getPaths();
        String[] checkPaths = new String[paths.length];
        for (int i = 0; i < checkPaths.length; i++) {
            checkPaths[i] = paths[i] + "su";
        }
        RootBeerNative rootBeerNative = new RootBeerNative();
        try {
            rootBeerNative.setLogDebugMessages(this.loggingEnabled);
            if (rootBeerNative.checkForRoot(checkPaths) > 0) {
                return true;
            }
            return false;
        } catch (UnsatisfiedLinkError e) {
            return false;
        }
    }
}
