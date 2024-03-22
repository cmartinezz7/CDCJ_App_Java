package es.santander.branchlocator;

import android.app.Activity;
import android.os.Build;
import androidx.core.app.ActivityCompat;

class BLPermissionCheckHelper {
    BLPermissionCheckHelper() {
    }

    private static boolean useRunTimePermissions() {
        return Build.VERSION.SDK_INT >= 23;
    }

    static boolean hasPermission(Activity activity, String permission) {
        if (!useRunTimePermissions() || activity.checkSelfPermission(permission) == 0) {
            return true;
        }
        return false;
    }

    static void requestPermissions(Activity activity, String[] permission, int requestCode) {
        if (useRunTimePermissions()) {
            ActivityCompat.requestPermissions(activity, permission, requestCode);
        }
    }
}
