package es.santander.justicia.minisJusticia;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.navigation.NavigationView;
import es.santander.justicia.minisJusticia.MapsActivity.1;
import es.santander.justicia.minisJusticia.MapsActivity.2;
import es.santander.justicia.minisJusticia.MapsActivity.3;
import es.santander.justicia.minisJusticia.MapsActivity.4;
import es.santander.justicia.minisJusticia.MapsActivity.5;
import es.santander.justicia.minisJusticia.MapsActivity.6;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.controllers.MapsController;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import es.santander.justicia.minisJusticia.dto.MarkerDTO;
import es.santander.justicia.minisJusticia.interfaces.MapsInterface;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.utils.CommonUtils;
import java.util.ArrayList;

public class MapsActivity extends MainActivity implements OnMapReadyCallback, MapsInterface, ConnectionCallbacks, OnConnectionFailedListener, LocationListener {
   private GoogleMap mMap;
   private Context context;
   private ProgressDialog dialog;
   private MapsController mapsController;
   private ArrayList<MarkerDTO> mainMarkerList;
   private boolean inRequest = false;
   private GoogleApiClient mGoogleApiClient;
   private Location currentLocation;
   public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000L;
   public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000L;
   public static final int DEFAULT_ZOOM = 15;
   public static final int MIN_DISTANCE_TO_REFRESH = 50;
   public static int LOCATION_REQUEST_PERMISSION = 1000;
   protected LocationRequest mLocationRequest;
   private boolean officesMode = true;
   private String courtCode;
   private CourtDataDto courtData;
   private LatLng courtLatLng;
   private TextView tvUserName;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = this.getBaseContext();
      Bundle extras = this.getIntent().getExtras();
      if (extras != null) {
         this.officesMode = false;
         this.courtCode = extras.getString("courtCode");
      }

      if (this.officesMode) {
         this.setTealiumName("/oficinas_santander");
         this.setContentView(2131558451);
         this.setNavigationId(2131362446);
         Toolbar toolbar = (Toolbar)this.findViewById(2131362965);
         toolbar.setTitle(2131886522);
         DrawerLayout drawer = (DrawerLayout)this.findViewById(2131362106);
         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 2131886647, 2131886646);
         drawer.addDrawerListener(toggle);
         toggle.syncState();
         NavigationView navigationView = (NavigationView)this.findViewById(2131362529);
         navigationView.setNavigationItemSelectedListener(this);
         navigationView.getMenu().getItem(4).setChecked(true);
         String username = "";
         if (LoginManager.getInstance() != null && LoginManager.getInstance().getNombreUsuario() != null) {
            username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
         }

         this.tvUserName = (TextView)navigationView.getHeaderView(0).findViewById(2131363086);
         if (this.tvUserName != null) {
            this.tvUserName.setText(CommonUtils.wordCapitalize(username));
         }

         LinearLayout closeLayout = (LinearLayout)this.findViewById(2131362033);
         closeLayout.setOnClickListener(new 1(this));
      } else {
         this.setTealiumName("/localizar_juzgado");
         this.setContentView(2131558452);
         TextView toolBarTitle = (TextView)this.findViewById(2131363082);
         toolBarTitle.setText(2131886361);
         ImageButton btnBack = (ImageButton)this.findViewById(2131361967);
         btnBack.setOnClickListener(new 2(this));
      }

      SupportMapFragment mapFragment = (SupportMapFragment)this.getSupportFragmentManager().findFragmentById(2131362460);
      mapFragment.getMapAsync(this);
      this.buildGoogleApiClient();
      if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
         ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, LOCATION_REQUEST_PERMISSION);
      } else {
         if (this.mainMarkerList != null && this.officesMode) {
            this.mapsController.setUpLocationClusters(this.mainMarkerList);
         } else if (!this.officesMode && this.courtData != null) {
            this.mapsController.setCourtMarker(this.courtData, this.courtLatLng);
         }

         this.showDialog();
      }

   }

   public void onMapReady(GoogleMap googleMap) {
      this.mMap = googleMap;
      this.mMap.getUiSettings().setZoomControlsEnabled(true);
      this.mMap.getUiSettings().setMapToolbarEnabled(false);
      this.mapsController = new MapsController(this.context, this.mMap, this, this.getLayoutInflater());
   }

   public void onReceiveOfficesLocations(ArrayList<MarkerDTO> markerList) {
      this.inRequest = false;
      this.mainMarkerList = markerList;
      if (this.currentLocation != null) {
         this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(this.currentLocation.getLatitude(), this.currentLocation.getLongitude()), 15.0F));
      }

      this.mapsController.setUpLocationClusters(markerList);
   }

   public void onFinishSetMarkers() {
      if (this.dialog != null && this.dialog.isShowing()) {
         this.dialog.dismiss();
      }

   }

   public void onFindAddress(CourtDataDto courtData, LatLng latLng, boolean success) {
      if (this.dialog != null && this.dialog.isShowing()) {
         this.dialog.dismiss();
      }

      if (success) {
         this.courtData = courtData;
         this.courtLatLng = latLng;
      } else {
         Toast.makeText(this.context, 2131886654, 0).show();
      }

   }

   private void showDialog() {
      if (this.checkLocationActive()) {
         this.dialog = new ProgressDialog(this);
         this.dialog.setCancelable(false);
         if (this.officesMode) {
            this.dialog.setMessage(this.getResources().getString(2131886520));
         } else {
            this.dialog.setMessage(this.getResources().getString(2131886743));
         }

         this.dialog.show();
      }

   }

   protected void onStart() {
      this.mGoogleApiClient.connect();
      super.onStart();
   }

   protected void onResume() {
      super.onResume();
      if (this.mGoogleApiClient.isConnected()) {
         this.startLocationUpdates();
      }

   }

   protected void onPause() {
      super.onPause();
   }

   protected void onStop() {
      if (this.mGoogleApiClient.isConnected()) {
         this.stopLocationUpdates();
      }

      if (this.mMap != null) {
         this.mMap.clear();
      }

      this.mGoogleApiClient.disconnect();
      super.onStop();
   }

   protected synchronized void buildGoogleApiClient() {
      this.mGoogleApiClient = (new Builder(this)).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
      this.createLocationRequest();
   }

   protected void createLocationRequest() {
      this.mLocationRequest = new LocationRequest();
      this.mLocationRequest.setInterval(10000L);
      this.mLocationRequest.setFastestInterval(5000L);
      this.mLocationRequest.setPriority(100);
   }

   private Boolean checkLocationActive() {
      LocationManager lm = (LocationManager)this.context.getSystemService("location");
      boolean gps_enabled = false;
      boolean network_enabled = false;

      try {
         gps_enabled = lm.isProviderEnabled("gps");
      } catch (Exception var6) {
      }

      try {
         network_enabled = lm.isProviderEnabled("network");
      } catch (Exception var5) {
      }

      if (!gps_enabled && !network_enabled) {
         android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(this);
         dialog.setMessage(this.getResources().getString(2131886445));
         dialog.setPositiveButton(this.getResources().getString(2131886658), new 3(this));
         dialog.setNegativeButton(this.getString(2131886300), new 4(this));
         dialog.show();
         return false;
      } else {
         return true;
      }
   }

   public void onConnected(@Nullable Bundle bundle) {
      if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
         if (this.currentLocation == null) {
            this.currentLocation = LocationServices.FusedLocationApi.getLastLocation(this.mGoogleApiClient);
         }

         if (this.currentLocation != null) {
            if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
               ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, LOCATION_REQUEST_PERMISSION);
            } else {
               this.mMap.setMyLocationEnabled(true);
               this.mMap.setOnMyLocationButtonClickListener(new 5(this));
            }
         }

         this.startLocationUpdates();
      }
   }

   protected void startLocationUpdates() {
      if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
         LocationServices.FusedLocationApi.requestLocationUpdates(this.mGoogleApiClient, this.mLocationRequest, this);
      }
   }

   protected void stopLocationUpdates() {
      LocationServices.FusedLocationApi.removeLocationUpdates(this.mGoogleApiClient, this);
   }

   public void onConnectionSuspended(int i) {
   }

   public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
   }

   public void onLocationChanged(Location location) {
      if (location != null && this.currentLocation != null) {
         float[] results = new float[1];
         Location.distanceBetween(location.getLatitude(), location.getLongitude(), this.currentLocation.getLatitude(), this.currentLocation.getLongitude(), results);
         float distance = results[0];
         if ((distance > 50.0F || this.mainMarkerList == null) && !this.inRequest) {
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

   public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
      if (requestCode == LOCATION_REQUEST_PERMISSION) {
         if (grantResults.length == 1 && grantResults[0] == 0) {
            if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
               return;
            }

            this.mMap.setMyLocationEnabled(true);
            this.mMap.setOnMyLocationButtonClickListener(new 6(this));
         } else {
            if (this.dialog != null && this.dialog.isShowing()) {
               this.dialog.dismiss();
            }

            Toast.makeText(this, "No se realizó la busqueda por falta de permisos", 0).show();
         }
      }

   }

   // $FF: synthetic method
   static Location access$000(MapsActivity x0) {
      return x0.currentLocation;
   }

   // $FF: synthetic method
   static GoogleMap access$100(MapsActivity x0) {
      return x0.mMap;
   }
}
