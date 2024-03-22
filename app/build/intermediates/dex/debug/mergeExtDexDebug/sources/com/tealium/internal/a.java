package com.tealium.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;

public abstract class a {
    public static a a(Context context) {
        final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return new a() {
            public boolean a() {
                if (Build.VERSION.SDK_INT < 23) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    return networkInfo != null && networkInfo.isConnected();
                }
                Network[] allNetworks = connectivityManager.getAllNetworks();
                for (Network networkInfo2 : allNetworks) {
                    if (connectivityManager.getNetworkInfo(networkInfo2).getType() == 1) {
                        return true;
                    }
                }
                return false;
            }

            public boolean b() {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
        };
    }

    public abstract boolean a();

    public abstract boolean b();
}
