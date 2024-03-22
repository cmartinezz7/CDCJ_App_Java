package es.santander.justicia.minisJusticia.dto;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;
import es.santander.justicia.minisJusticia.enums.MarkerType;

public class MarkerDTO implements ClusterItem {
    private final LatLng mPosition;
    private MarkerType markerType;
    private String snippet;
    private String title;

    public MarkerDTO(double lat, double lng) {
        this.mPosition = new LatLng(lat, lng);
    }

    public LatLng getPosition() {
        return this.mPosition;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public MarkerType getMarkerType() {
        return this.markerType;
    }

    public void setMarkerType(MarkerType markerType2) {
        this.markerType = markerType2;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public void setSnippet(String snippet2) {
        this.snippet = snippet2;
    }
}
