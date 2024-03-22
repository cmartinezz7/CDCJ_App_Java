package es.santander.branchlocator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BLWifiBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        int extraWifiState = intent.getIntExtra("wifi_state", 4);
        if (extraWifiState == 1) {
            BLObservableObject.getInstance().updateValue(new BLConnectionObject("wifi", false, false));
        } else if (extraWifiState == 3) {
            BLObservableObject.getInstance().updateValue(new BLConnectionObject("wifi", true, true));
        }
    }
}
