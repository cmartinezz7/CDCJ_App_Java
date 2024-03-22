package com.google.maps.android.data;

import com.google.android.gms.maps.model.LatLng;

public class Point implements Geometry {
    private static final String GEOMETRY_TYPE = "Point";
    private final LatLng mCoordinates;

    public Point(LatLng coordinates) {
        if (coordinates != null) {
            this.mCoordinates = coordinates;
            return;
        }
        throw new IllegalArgumentException("Coordinates cannot be null");
    }

    public String getGeometryType() {
        return GEOMETRY_TYPE;
    }

    public LatLng getGeometryObject() {
        return this.mCoordinates;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(GEOMETRY_TYPE).append("{");
        sb.append("\n coordinates=").append(this.mCoordinates);
        sb.append("\n}\n");
        return sb.toString();
    }
}
