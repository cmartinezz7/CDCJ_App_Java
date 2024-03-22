package es.santander.justicia.minisJusticia.controllers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

public class MapsController$CustomInfoWindowAdapterCourt implements InfoWindowAdapter {
   // $FF: synthetic field
   final MapsController this$0;

   public MapsController$CustomInfoWindowAdapterCourt(MapsController this$0) {
      this.this$0 = this$0;
   }

   public View getInfoWindow(Marker marker) {
      return null;
   }

   public View getInfoContents(Marker marker) {
      View view = MapsController.access$400(this.this$0).inflate(2131558533, (ViewGroup)null);
      TextView markerTitle = (TextView)view.findViewById(2131363079);
      TextView markerEnvironment = (TextView)view.findViewById(2131363055);
      TextView markerStatus = (TextView)view.findViewById(2131363059);
      TextView markerPhoneNumber = (TextView)view.findViewById(2131363056);
      String[] snippetSplited = MapsController.access$300(this.this$0).getSnippet().split(":");
      markerTitle.setText(MapsController.access$300(this.this$0).getTitle());
      markerEnvironment.setText(snippetSplited[0].trim());
      markerStatus.setText(snippetSplited[1].trim());
      markerPhoneNumber.setText(snippetSplited[2].trim());
      return view;
   }
}
