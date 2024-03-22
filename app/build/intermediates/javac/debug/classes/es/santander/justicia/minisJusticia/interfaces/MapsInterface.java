package es.santander.justicia.minisJusticia.interfaces;

import com.google.android.gms.maps.model.LatLng;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import es.santander.justicia.minisJusticia.dto.MarkerDTO;
import java.util.ArrayList;

public interface MapsInterface {
   void onReceiveOfficesLocations(ArrayList<MarkerDTO> var1);

   void onFinishSetMarkers();

   void onFindAddress(CourtDataDto var1, LatLng var2, boolean var3);
}
