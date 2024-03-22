package es.santander.justicia.minisJusticia;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.navigation.NavigationView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.controllers.MapsController;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import es.santander.justicia.minisJusticia.dto.MarkerDTO;
import es.santander.justicia.minisJusticia.interfaces.MapsInterface;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import java.util.ArrayList;

public class MapsActivity extends MainActivity implements OnMapReadyCallback, MapsInterface, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    public static final int DEFAULT_ZOOM = 15;
    public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000;
    public static int LOCATION_REQUEST_PERMISSION = 1000;
    public static final int MIN_DISTANCE_TO_REFRESH = 50;
    public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;
    private Context context;
    private String courtCode;
    private CourtDataDto courtData;
    private LatLng courtLatLng;
    /* access modifiers changed from: private */
    public Location currentLocation;
    private ProgressDialog dialog;
    private boolean inRequest = false;
    private GoogleApiClient mGoogleApiClient;
    protected LocationRequest mLocationRequest;
    /* access modifiers changed from: private */
    public GoogleMap mMap;
    private ArrayList<MarkerDTO> mainMarkerList;
    private MapsController mapsController;
    private boolean officesMode = true;
    private TextView tvUserName;

    /* JADX WARNING: type inference failed for: r11v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context, com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener, com.google.android.gms.maps.OnMapReadyCallback, es.santander.justicia.minisJusticia.MapsActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        CourtDataDto courtDataDto;
        super.onCreate(savedInstanceState);
        this.context = getBaseContext();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.officesMode = false;
            this.courtCode = extras.getString(Constants.COURT_CODE);
        }
        if (this.officesMode) {
            setTealiumName("/oficinas_santander");
            setContentView(R.layout.activity_maps);
            setNavigationId(R.id.localizar_oficinas);
            Toolbar toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle(R.string.locate_offices_title);
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 2131886647, 2131886646);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            NavigationView navigationView = findViewById(2131362529);
            navigationView.setNavigationItemSelectedListener(this);
            navigationView.getMenu().getItem(4).setChecked(true);
            String username = "";
            if (!(LoginManager.getInstance() == null || LoginManager.getInstance().getNombreUsuario() == null)) {
                username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
            }
            TextView textView = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_user_name);
            this.tvUserName = textView;
            if (textView != null) {
                textView.setText(CommonUtils.wordCapitalize(username));
            }
            ((LinearLayout) findViewById(R.id.close_session)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MapsActivity.this.logout();
                }
            });
        } else {
            setTealiumName("/localizar_juzgado");
            setContentView(R.layout.activity_maps_back_button);
            ((TextView) findViewById(R.id.tv_toolbar_title)).setText(R.string.courts);
            ((ImageButton) findViewById(R.id.buttonBack)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MapsActivity.this.finish();
                }
            });
        }
        getSupportFragmentManager().findFragmentById(2131362460).getMapAsync(this);
        buildGoogleApiClient();
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            ArrayList<MarkerDTO> arrayList = this.mainMarkerList;
            if (arrayList != null && this.officesMode) {
                this.mapsController.setUpLocationClusters(arrayList);
            } else if (!this.officesMode && (courtDataDto = this.courtData) != null) {
                this.mapsController.setCourtMarker(courtDataDto, this.courtLatLng);
            }
            showDialog();
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, LOCATION_REQUEST_PERMISSION);
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        this.mMap.getUiSettings().setMapToolbarEnabled(false);
        this.mapsController = new MapsController(this.context, this.mMap, this, getLayoutInflater());
    }

    public void onReceiveOfficesLocations(ArrayList<MarkerDTO> markerList) {
        this.inRequest = false;
        this.mainMarkerList = markerList;
        if (this.currentLocation != null) {
            this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(this.currentLocation.getLatitude(), this.currentLocation.getLongitude()), 15.0f));
        }
        this.mapsController.setUpLocationClusters(markerList);
    }

    public void onFinishSetMarkers() {
        ProgressDialog progressDialog = this.dialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.dialog.dismiss();
        }
    }

    public void onFindAddress(CourtDataDto courtData2, LatLng latLng, boolean success) {
        ProgressDialog progressDialog = this.dialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.dialog.dismiss();
        }
        if (success) {
            this.courtData = courtData2;
            this.courtLatLng = latLng;
            return;
        }
        Toast.makeText(this.context, R.string.not_address_found_message, 0).show();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.MapsActivity] */
    private void showDialog() {
        if (checkLocationActive().booleanValue()) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.dialog = progressDialog;
            progressDialog.setCancelable(false);
            if (this.officesMode) {
                this.dialog.setMessage(getResources().getString(R.string.loading_offices));
            } else {
                this.dialog.setMessage(getResources().getString(R.string.searching_address));
            }
            this.dialog.show();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.mGoogleApiClient.connect();
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.mGoogleApiClient.isConnected()) {
            startLocationUpdates();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (this.mGoogleApiClient.isConnected()) {
            stopLocationUpdates();
        }
        GoogleMap googleMap = this.mMap;
        if (googleMap != null) {
            googleMap.clear();
        }
        this.mGoogleApiClient.disconnect();
        super.onStop();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.MapsActivity, com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener, com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks] */
    /* access modifiers changed from: protected */
    public synchronized void buildGoogleApiClient() {
        this.mGoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        createLocationRequest();
    }

    /* access modifiers changed from: protected */
    public void createLocationRequest() {
        LocationRequest locationRequest = new LocationRequest();
        this.mLocationRequest = locationRequest;
        locationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        this.mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        this.mLocationRequest.setPriority(100);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.content.Context, es.santander.justicia.minisJusticia.MapsActivity] */
    private Boolean checkLocationActive() {
        LocationManager lm = (LocationManager) this.context.getSystemService("location");
        boolean gps_enabled = false;
        boolean network_enabled = false;
        try {
            gps_enabled = lm.isProviderEnabled("gps");
        } catch (Exception e) {
        }
        try {
            network_enabled = lm.isProviderEnabled("network");
        } catch (Exception e2) {
        }
        if (gps_enabled || network_enabled) {
            return true;
        }
        AlertDialog.Builder dialog2 = new AlertDialog.Builder(this);
        dialog2.setMessage(getResources().getString(R.string.gps_network_not_enabled));
        dialog2.setPositiveButton(getResources().getString(R.string.open_location_settings), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                MapsActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        });
        dialog2.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
            }
        });
        dialog2.show();
        return false;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.MapsActivity, android.app.Activity] */
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            if (this.currentLocation == null) {
                this.currentLocation = LocationServices.FusedLocationApi.getLastLocation(this.mGoogleApiClient);
            }
            if (this.currentLocation != null) {
                if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    this.mMap.setMyLocationEnabled(true);
                    this.mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                        public boolean onMyLocationButtonClick() {
                            MapsActivity.this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(MapsActivity.this.currentLocation.getLatitude(), MapsActivity.this.currentLocation.getLongitude()), 15.0f));
                            return true;
                        }
                    });
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, LOCATION_REQUEST_PERMISSION);
                }
            }
            startLocationUpdates();
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.MapsActivity, com.google.android.gms.location.LocationListener] */
    /* access modifiers changed from: protected */
    public void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            LocationServices.FusedLocationApi.requestLocationUpdates(this.mGoogleApiClient, this.mLocationRequest, this);
        }
    }

    /* access modifiers changed from: protected */
    public void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(this.mGoogleApiClient, this);
    }

    public void onConnectionSuspended(int i) {
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public void onLocationChanged(Location location) {
        if (!(location == null || this.currentLocation == null)) {
            float[] results = new float[1];
            Location.distanceBetween(location.getLatitude(), location.getLongitude(), this.currentLocation.getLatitude(), this.currentLocation.getLongitude(), results);
            if ((results[0] > 50.0f || this.mainMarkerList == null) && !this.inRequest) {
                this.mMap.clear();
                this.inRequest = true;
                if (this.officesMode) {
                    this.mapsController.getOfficesLocations(location.getLatitude(), location.getLongitude());
                } else {
                    this.mapsController.getCourtLocationByCode(this.courtCode);
                }
            }
        }
        this.currentLocation = location;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context, es.santander.justicia.minisJusticia.MapsActivity] */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != LOCATION_REQUEST_PERMISSION) {
            return;
        }
        if (grantResults.length != 1 || grantResults[0] != 0) {
            ProgressDialog progressDialog = this.dialog;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.dialog.dismiss();
            }
            Toast.makeText(this, "No se realizó la busqueda por falta de permisos", 0).show();
        } else if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.mMap.setMyLocationEnabled(true);
            this.mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                public boolean onMyLocationButtonClick() {
                    if (MapsActivity.this.currentLocation == null) {
                        return true;
                    }
                    MapsActivity.this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(MapsActivity.this.currentLocation.getLatitude(), MapsActivity.this.currentLocation.getLongitude()), 10.0f));
                    return true;
                }
            });
        }
    }
}
