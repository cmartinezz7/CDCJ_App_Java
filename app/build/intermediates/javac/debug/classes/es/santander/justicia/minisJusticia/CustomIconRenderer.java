package es.santander.justicia.minisJusticia;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import es.santander.justicia.minisJusticia.CustomIconRenderer.1;
import es.santander.justicia.minisJusticia.dto.MarkerDTO;

public class CustomIconRenderer extends DefaultClusterRenderer<MarkerDTO> {
   public CustomIconRenderer(Context context, GoogleMap map, ClusterManager<MarkerDTO> clusterManager) {
      super(context, map, clusterManager);
   }

   protected void onBeforeClusterItemRendered(MarkerDTO item, MarkerOptions markerOptions) {
      BitmapDescriptor icon;
      switch(1.$SwitchMap$es$santander$justicia$minisJusticia$enums$MarkerType[item.getMarkerType().ordinal()]) {
      case 1:
         icon = BitmapDescriptorFactory.fromResource(2131231265);
      default:
         icon = BitmapDescriptorFactory.fromResource(2131231265);
         markerOptions.icon(icon);
         markerOptions.title(item.getTitle());
         super.onBeforeClusterItemRendered(item, markerOptions);
      }
   }
}
