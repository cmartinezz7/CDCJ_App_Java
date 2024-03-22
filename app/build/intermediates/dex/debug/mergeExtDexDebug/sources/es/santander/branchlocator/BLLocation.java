package es.santander.branchlocator;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

class BLLocation {
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("coordinates")
    private List<Double> coordinates;
    @SerializedName("country")
    private String country;
    @SerializedName("descriptionPhoto")
    private String descriptionPhoto;
    @SerializedName("geoCoords")
    private GeoCoordinate geoCoordinate;
    @SerializedName("parking")
    private String parking;
    @SerializedName("type")
    private String type;
    @SerializedName("urlPhoto")
    private String urlPhoto;
    @SerializedName("zipcode")
    private String zipcode;

    BLLocation() {
    }

    public String getType() {
        return this.type;
    }

    public List<Double> getCoordinates() {
        if (this.coordinates != null) {
            return new ArrayList(this.coordinates);
        }
        return null;
    }

    public String getAddress() {
        return this.address;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getParking() {
        return this.parking;
    }

    public GeoCoordinate getGeoCoordinate() {
        return this.geoCoordinate;
    }

    public String getUrlPhoto() {
        return this.urlPhoto;
    }

    public String getDescriptionPhoto() {
        return this.descriptionPhoto;
    }

    class GeoCoordinate {
        @SerializedName("latitude")
        private double latitude;
        @SerializedName("longitude")
        private double longitude;

        GeoCoordinate() {
        }

        public double getLatitude() {
            return this.latitude;
        }

        public double getLongitude() {
            return this.longitude;
        }
    }
}
