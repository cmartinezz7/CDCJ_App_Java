package es.santander.justicia.minisJusticia.controllers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.model.Marker;

public class MapsController$CustomInfoWindowAdapterOffices implements InfoWindowAdapter {
   // $FF: synthetic field
   final MapsController this$0;

   public MapsController$CustomInfoWindowAdapterOffices(MapsController this$0) {
      this.this$0 = this$0;
   }

   public View getInfoWindow(Marker marker) {
      return null;
   }

   public View getInfoContents(Marker marker) {
      View view = MapsController.access$400(this.this$0).inflate(2131558534, (ViewGroup)null);
      TextView markerTitle = (TextView)view.findViewById(2131363079);
      TextView markerAddress = (TextView)view.findViewById(2131363057);
      TextView markerZipCode = (TextView)view.findViewById(2131363058);
      String[] snippetSplited = MapsController.access$200(this.this$0).getSnippet().split(":");
      markerTitle.setText(MapsController.access$200(this.this$0).getTitle());
      markerAddress.setText(snippetSplited[0].trim());
      markerZipCode.setText(snippetSplited[1].trim());
      return view;
   }
}
