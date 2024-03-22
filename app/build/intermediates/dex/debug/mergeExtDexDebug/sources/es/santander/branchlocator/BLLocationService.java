package es.santander.branchlocator;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

class BLLocationService {
    private static final int MIN_DISTANCE = 1000;
    private static final int MIN_TIME = 300000;
    private static final String TAG = "LocationService";
    /* access modifiers changed from: private */
    public boolean gps_enabled = false;
    /* access modifiers changed from: private */
    public LocationManager lm;
    LocationListener locationListenerGps = new LocationListener() {
        public void onLocationChanged(Location location) {
            BLLocationService.this.timer1.cancel();
            BLLocationService.this.locationResult.gotLocation(location);
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    };
    /* access modifiers changed from: private */
    public LocationListener locationListenerNetwork = new LocationListener() {
        public void onLocationChanged(Location location) {
            BLLocationService.this.timer1.cancel();
            BLLocationService.this.locationResult.gotLocation(location);
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
    };
    /* access modifiers changed from: private */
    public LocationResult locationResult;
    /* access modifiers changed from: private */
    public boolean network_enabled = false;
    /* access modifiers changed from: private */
    public Timer timer1;

    public static abstract class LocationResult {
        public abstract void gotLocation(Location location);
    }

    BLLocationService() {
    }

    public boolean getLocation(Context context, LocationResult result) {
        this.locationResult = result;
        if (this.lm == null) {
            this.lm = (LocationManager) context.getSystemService("location");
        }
        try {
            this.gps_enabled = this.lm.isProviderEnabled("gps");
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        try {
            this.network_enabled = this.lm.isProviderEnabled("network");
        } catch (Exception e2) {
            Log.e(TAG, e2.toString());
        }
        boolean z = this.gps_enabled;
        if (!z && !this.network_enabled) {
            return false;
        }
        if (z) {
            this.lm.requestLocationUpdates("gps", 300000, 1000.0f, this.locationListenerGps);
        }
        if (this.network_enabled) {
            this.lm.requestLocationUpdates("network", 300000, 1000.0f, this.locationListenerNetwork);
        }
        Timer timer = new Timer();
        this.timer1 = timer;
        timer.schedule(new GetLastLocation(), 20000);
        return true;
    }

    private class GetLastLocation extends TimerTask {
        private GetLastLocation() {
        }

        public void run() {
            BLLocationService.this.lm.removeUpdates(BLLocationService.this.locationListenerGps);
            BLLocationService.this.lm.removeUpdates(BLLocationService.this.locationListenerNetwork);
            Location net_loc = null;
            Location gps_loc = null;
            if (BLLocationService.this.gps_enabled) {
                gps_loc = BLLocationService.this.lm.getLastKnownLocation("gps");
            }
            if (BLLocationService.this.network_enabled) {
                net_loc = BLLocationService.this.lm.getLastKnownLocation("network");
            }
            if (gps_loc == null || net_loc == null) {
                if (gps_loc != null) {
                    BLLocationService.this.locationResult.gotLocation(gps_loc);
                } else if (net_loc != null) {
                    BLLocationService.this.locationResult.gotLocation(net_loc);
                } else {
                    BLLocationService.this.locationResult.gotLocation((Location) null);
                }
            } else if (gps_loc.getTime() > net_loc.getTime()) {
                BLLocationService.this.locationResult.gotLocation(gps_loc);
            } else {
                BLLocationService.this.locationResult.gotLocation(net_loc);
            }
        }
    }
}
