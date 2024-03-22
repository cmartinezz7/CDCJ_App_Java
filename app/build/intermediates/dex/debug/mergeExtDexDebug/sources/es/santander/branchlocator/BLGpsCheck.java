package es.santander.branchlocator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;

public class BLGpsCheck extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (((LocationManager) context.getSystemService("location")).isProviderEnabled("gps")) {
            BLObservableObject.getInstance().updateValue(new BLConnectionObject("gps", true, true));
        } else {
            BLObservableObject.getInstance().updateValue(new BLConnectionObject("gps", false, false));
        }
    }
}
