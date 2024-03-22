package es.santander.branchlocator;

import com.google.android.gms.maps.model.LatLng;

interface BLOnGetLocation {
    void onGetLocation(LatLng latLng);
}
