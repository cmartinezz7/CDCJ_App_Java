package es.santander.justicia.minisJusticia;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import es.santander.justicia.minisJusticia.ActivityMapJuzgados.1;
import es.santander.justicia.minisJusticia.ActivityMapJuzgados.2;
import es.santander.justicia.minisJusticia.ActivityMapJuzgados.3;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ActivityMapJuzgados extends ActivityAbstractLetrados implements OnMapReadyCallback, OnRequestPermissionsResultCallback {
   private final int RQ_PERMISSIONS = 1;
   private final int INITIAL_ZOOM = 16;
   private GoogleMap mMap;
   private SupportMapFragment mMapFragment;

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558450);
      this.initUi();
   }

   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/localizar_juzgado");
   }

   private void initUi() {
      this.mMapFragment = SupportMapFragment.newInstance();
      this.mMapFragment.getMapAsync(this);
      this.getSupportFragmentManager().beginTransaction().add(2131362461, this.mMapFragment).commit();
   }

   private void drawTribunals(LatLng latLng) {
      this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0F));
      CommonUtils.addMarker(this.mMap, latLng, "Oficina", BitmapDescriptorFactory.fromResource(2131231264));
   }

   private void createMapView() {
      this.mMap.setMapType(1);
      this.mMap.setOnInfoWindowClickListener(new 1(this));
      if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
         ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1);
      } else {
         this.mMap.setMyLocationEnabled(true);
         this.mMap.getUiSettings().setMyLocationButtonEnabled(false);
      }

      this.mMap.setInfoWindowAdapter(new 2(this));
   }

   private void getDetalleJuzgado(String juzga) {
      ConnectionBuilder.getDetalleJuzgados(juzga).enqueue(new 3(this, this, true, true));
   }

   public void onMapReady(GoogleMap googleMap) {
      this.mMap = googleMap;
      this.createMapView();
      this.getDetalleJuzgado(this.getIntent().getStringExtra("extra_juzga"));
   }

   public void getLocationFromAddress(String strAddress) throws IOException {
      Geocoder coder = new Geocoder(this);
      new Address(Locale.ENGLISH);
      LatLng p1 = null;
      List<Address> address = coder.getFromLocationName(strAddress, 5);
      if (address != null && address.size() > 0) {
         Address location = (Address)address.get(0);
         location.getLatitude();
         location.getLongitude();
         p1 = new LatLng(location.getLatitude(), location.getLongitude());
         this.drawTribunals(p1);
      }

   }

   public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      if (requestCode == 1 && grantResults[0] == 0) {
         if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return;
         }

         this.mMap.setMyLocationEnabled(true);
         this.mMap.getUiSettings().setMyLocationButtonEnabled(true);
      }

   }
}
