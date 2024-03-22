package es.santander.justicia.minisJusticia.controllers;

import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.model.Marker;

class MapsController$3 implements OnMarkerClickListener {
   // $FF: synthetic field
   final MapsController this$0;

   MapsController$3(MapsController this$0) {
      this.this$0 = this$0;
   }

   public boolean onMarkerClick(Marker marker) {
      MapsController.access$302(this.this$0, marker);
      return false;
   }
}
