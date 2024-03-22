package es.santander.branchlocator;

import android.app.Activity;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.maps.model.LatLng;
import es.santander.branchlocator.BLLocationService;

public class BLBaseActivity extends AppCompatActivity {
    private static final int ERROR_DIALOG_REQUEST = 9001;
    private static final int GPS_REQUEST = 1000;
    private static final String TAG = "BranchLocator";
    public LatLng currentLocation = null;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        BLBaseActivity.super.onCreate(savedInstanceState);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.branchlocator.BLBaseActivity] */
    private void getExactLocation(final BLOnGetLocation BLOnGetLocation) {
        new BLLocationService().getLocation(this, new BLLocationService.LocationResult() {
            public void gotLocation(Location location) {
                if (location != null) {
                    BLBaseActivity.this.currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                    BLOnGetLocation bLOnGetLocation = BLOnGetLocation;
                    if (bLOnGetLocation != null) {
                        bLOnGetLocation.onGetLocation(new LatLng(location.getLatitude(), location.getLongitude()));
                        return;
                    }
                    return;
                }
                BLOnGetLocation bLOnGetLocation2 = BLOnGetLocation;
                if (bLOnGetLocation2 != null) {
                    bLOnGetLocation2.onGetLocation((LatLng) null);
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, es.santander.branchlocator.BLBaseActivity] */
    public void getLocation(BLOnGetLocation BLOnGetLocation) {
        BLUtils.showCustomToast(this, getString(R.string.bl_toast_getting_position));
        getExactLocation(BLOnGetLocation);
    }

    public void getLocation() {
        getExactLocation((BLOnGetLocation) null);
    }

    public void displayLocationSettingsRequest(final Activity activity) {
        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(activity).addApi(LocationServices.API).build();
        googleApiClient.connect();
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(100);
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);
        LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build()).setResultCallback(new ResultCallback<LocationSettingsResult>() {
            public void onResult(LocationSettingsResult result) {
                Status status = result.getStatus();
                if (status.getStatusCode() == 6) {
                    try {
                        status.startResolutionForResult(activity, BLBaseActivity.GPS_REQUEST);
                    } catch (IntentSender.SendIntentException e) {
                    }
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.branchlocator.BLBaseActivity, android.app.Activity] */
    public boolean isServicesOK() {
        Log.d(TAG, "isServicesOK: checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);
        if (available == 0) {
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            GoogleApiAvailability.getInstance().getErrorDialog(this, available, ERROR_DIALOG_REQUEST).show();
        } else {
            Toast.makeText(this, "You can't make map requests", 0).show();
        }
        return false;
    }
}
