package es.santander.branchlocator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import java.net.URL;
import java.net.URLConnection;

public class BLConnectivityBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(final Context context, Intent intent) {
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            BLObservableObject.getInstance().updateValue(new BLConnectionObject("internet", false, false));
        } else {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    BLConnectivityBroadcastReceiver.this.checkConnectivity(context);
                }
            }, 5000);
        }
    }

    /* access modifiers changed from: private */
    public void checkConnectivity(Context context) {
        if (!isNetworkConnected(context)) {
            BLObservableObject.getInstance().updateValue(new BLConnectionObject("internet", false, false));
            return;
        }
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            public void run() {
                final boolean isConnected = BLConnectivityBroadcastReceiver.this.isAbleToConnect("http://www.google.com", 1000);
                handler.post(new Runnable() {
                    public void run() {
                        if (isConnected) {
                            BLObservableObject.getInstance().updateValue(new BLConnectionObject("internet", true, true));
                        } else {
                            BLObservableObject.getInstance().updateValue(new BLConnectionObject("internet", true, false));
                        }
                    }
                });
            }
        }).start();
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService("connectivity");
        if (cm != null) {
            if (Build.VERSION.SDK_INT <= 23) {
                NetworkInfo networkInfo = cm.getActiveNetworkInfo();
                if (networkInfo == null || !networkInfo.isConnected()) {
                    return false;
                }
                if (networkInfo.getType() == 1 || networkInfo.getType() == 0) {
                    return true;
                }
                return false;
            }
            Network network = cm.getActiveNetwork();
            if (network != null) {
                NetworkCapabilities networkCapabilities = cm.getNetworkCapabilities(network);
                if (networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean isAbleToConnect(String url, int timeout) {
        try {
            URLConnection connection = new URL(url).openConnection();
            connection.setConnectTimeout(timeout);
            connection.connect();
            return true;
        } catch (Exception e) {
            Log.i("exception", "" + e.getMessage());
            return false;
        }
    }
}
