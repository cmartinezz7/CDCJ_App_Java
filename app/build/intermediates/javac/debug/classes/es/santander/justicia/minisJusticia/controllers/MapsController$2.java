package es.santander.justicia.minisJusticia.controllers;

import com.google.maps.android.clustering.ClusterManager.OnClusterItemClickListener;
import es.santander.justicia.minisJusticia.dto.MarkerDTO;

class MapsController$2 implements OnClusterItemClickListener<MarkerDTO> {
   // $FF: synthetic field
   final MapsController this$0;

   MapsController$2(MapsController this$0) {
      this.this$0 = this$0;
   }

   public boolean onClusterItemClick(MarkerDTO markerDTO) {
      MapsController.access$202(this.this$0, markerDTO);
      return false;
   }
}
