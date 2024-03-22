package es.santander.justicia.minisJusticia;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.model.LatLng;

class MapsActivity$5 implements OnMyLocationButtonClickListener {
   // $FF: synthetic field
   final MapsActivity this$0;

   MapsActivity$5(MapsActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onMyLocationButtonClick() {
      LatLng latLng = new LatLng(MapsActivity.access$000(this.this$0).getLatitude(), MapsActivity.access$000(this.this$0).getLongitude());
      MapsActivity.access$100(this.this$0).animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0F));
      return true;
   }
}
