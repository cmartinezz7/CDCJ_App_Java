package es.santander.branchlocator;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.net.PlacesClient;
import java.util.List;

public interface BLMapsListener {
    void blAutoCompleteTextViewClearFocus();

    void blAutoCompleteTextViewSetText(String str);

    void doSetupUi();

    void onLoadedPOIS(boolean z);

    void setPlaceAutocompleteAdapterBounds(LatLng latLng);

    void setupFilterList(List<BLFilter> list);

    void setupPlaceAutocompleteAdapter(PlacesClient placesClient);

    void toggleSearchAreaIcon(int i);
}
