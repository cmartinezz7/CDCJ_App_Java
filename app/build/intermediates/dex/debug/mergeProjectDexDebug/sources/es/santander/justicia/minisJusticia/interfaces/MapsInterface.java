package es.santander.justicia.minisJusticia.interfaces;

import com.google.android.gms.maps.model.LatLng;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import es.santander.justicia.minisJusticia.dto.MarkerDTO;
import java.util.ArrayList;

public interface MapsInterface {
    void onFindAddress(CourtDataDto courtDataDto, LatLng latLng, boolean z);

    void onFinishSetMarkers();

    void onReceiveOfficesLocations(ArrayList<MarkerDTO> arrayList);
}
