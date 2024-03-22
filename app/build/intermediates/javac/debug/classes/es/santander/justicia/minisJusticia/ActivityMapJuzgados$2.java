package es.santander.justicia.minisJusticia;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

class ActivityMapJuzgados$2 implements InfoWindowAdapter {
   // $FF: synthetic field
   final ActivityMapJuzgados this$0;

   ActivityMapJuzgados$2(ActivityMapJuzgados this$0) {
      this.this$0 = this$0;
   }

   public View getInfoWindow(Marker marker) {
      View contents = this.this$0.getLayoutInflater().inflate(2131558610, (ViewGroup)null);
      return contents;
   }

   public View getInfoContents(Marker marker) {
      return null;
   }
}
