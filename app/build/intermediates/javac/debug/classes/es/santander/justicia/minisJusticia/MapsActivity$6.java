package es.santander.justicia.minisJusticia;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.model.LatLng;

class MapsActivity$6 implements OnMyLocationButtonClickListener {
   // $FF: synthetic field
   final MapsActivity this$0;

   MapsActivity$6(MapsActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onMyLocationButtonClick() {
      if (MapsActivity.access$000(this.this$0) != null) {
         MapsActivity.access$100(this.this$0).animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(MapsActivity.access$000(this.this$0).getLatitude(), MapsActivity.access$000(this.this$0).getLongitude()), 10.0F));
      }

      return true;
   }
}
