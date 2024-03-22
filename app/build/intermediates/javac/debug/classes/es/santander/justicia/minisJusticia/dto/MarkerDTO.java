package es.santander.justicia.minisJusticia.dto;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;
import es.santander.justicia.minisJusticia.enums.MarkerType;

public class MarkerDTO implements ClusterItem {
   private final LatLng mPosition;
   private String title;
   private String snippet;
   private MarkerType markerType;

   public MarkerDTO(double lat, double lng) {
      this.mPosition = new LatLng(lat, lng);
   }

   public LatLng getPosition() {
      return this.mPosition;
   }

   public String getTitle() {
      return this.title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public MarkerType getMarkerType() {
      return this.markerType;
   }

   public void setMarkerType(MarkerType markerType) {
      this.markerType = markerType;
   }

   public String getSnippet() {
      return this.snippet;
   }

   public void setSnippet(String snippet) {
      this.snippet = snippet;
   }
}
