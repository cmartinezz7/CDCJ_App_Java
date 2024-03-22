package com.google.maps.android.data;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.data.geojson.GeoJsonLineStringStyle;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.geojson.GeoJsonRenderer;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlGroundOverlay;
import com.google.maps.android.data.kml.KmlRenderer;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

public abstract class Layer {
    private Renderer mRenderer;

    public interface OnFeatureClickListener {
        void onFeatureClick(Feature feature);
    }

    /* access modifiers changed from: protected */
    public void addKMLToMap() throws IOException, XmlPullParserException {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof KmlRenderer) {
            ((KmlRenderer) renderer).addLayerToMap();
            return;
        }
        throw new UnsupportedOperationException("Stored renderer is not a KmlRenderer");
    }

    /* access modifiers changed from: protected */
    public void addGeoJsonToMap() {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof GeoJsonRenderer) {
            ((GeoJsonRenderer) renderer).addLayerToMap();
            return;
        }
        throw new UnsupportedOperationException("Stored renderer is not a GeoJsonRenderer");
    }

    public void removeLayerFromMap() {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof GeoJsonRenderer) {
            ((GeoJsonRenderer) renderer).removeLayerFromMap();
        } else if (renderer instanceof KmlRenderer) {
            ((KmlRenderer) renderer).removeLayerFromMap();
        }
    }

    public void setOnFeatureClickListener(final OnFeatureClickListener listener) {
        GoogleMap map = getMap();
        map.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            public void onPolygonClick(Polygon polygon) {
                if (Layer.this.getFeature(polygon) != null) {
                    listener.onFeatureClick(Layer.this.getFeature(polygon));
                } else if (Layer.this.getContainerFeature(polygon) != null) {
                    listener.onFeatureClick(Layer.this.getContainerFeature(polygon));
                } else {
                    OnFeatureClickListener onFeatureClickListener = listener;
                    Layer layer = Layer.this;
                    onFeatureClickListener.onFeatureClick(layer.getFeature(layer.multiObjectHandler(polygon)));
                }
            }
        });
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                if (Layer.this.getFeature(marker) != null) {
                    listener.onFeatureClick(Layer.this.getFeature(marker));
                    return false;
                } else if (Layer.this.getContainerFeature(marker) != null) {
                    listener.onFeatureClick(Layer.this.getContainerFeature(marker));
                    return false;
                } else {
                    OnFeatureClickListener onFeatureClickListener = listener;
                    Layer layer = Layer.this;
                    onFeatureClickListener.onFeatureClick(layer.getFeature(layer.multiObjectHandler(marker)));
                    return false;
                }
            }
        });
        map.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() {
            public void onPolylineClick(Polyline polyline) {
                if (Layer.this.getFeature(polyline) != null) {
                    listener.onFeatureClick(Layer.this.getFeature(polyline));
                } else if (Layer.this.getContainerFeature(polyline) != null) {
                    listener.onFeatureClick(Layer.this.getContainerFeature(polyline));
                } else {
                    OnFeatureClickListener onFeatureClickListener = listener;
                    Layer layer = Layer.this;
                    onFeatureClickListener.onFeatureClick(layer.getFeature(layer.multiObjectHandler(polyline)));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public ArrayList<?> multiObjectHandler(Object mapObject) {
        for (Object value : this.mRenderer.getValues()) {
            if (value.getClass().getSimpleName().equals("ArrayList")) {
                ArrayList<?> mapObjects = (ArrayList) value;
                if (mapObjects.contains(mapObject)) {
                    return mapObjects;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void storeRenderer(Renderer renderer) {
        this.mRenderer = renderer;
    }

    public Iterable<? extends Feature> getFeatures() {
        return this.mRenderer.getFeatures();
    }

    public Feature getFeature(Object mapObject) {
        return this.mRenderer.getFeature(mapObject);
    }

    public Feature getContainerFeature(Object mapObject) {
        return this.mRenderer.getContainerFeature(mapObject);
    }

    /* access modifiers changed from: protected */
    public boolean hasFeatures() {
        return this.mRenderer.hasFeatures();
    }

    /* access modifiers changed from: protected */
    public boolean hasContainers() {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof KmlRenderer) {
            return ((KmlRenderer) renderer).hasNestedContainers();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Iterable<KmlContainer> getContainers() {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof KmlRenderer) {
            return ((KmlRenderer) renderer).getNestedContainers();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof KmlRenderer) {
            return ((KmlRenderer) renderer).getGroundOverlays();
        }
        return null;
    }

    public GoogleMap getMap() {
        return this.mRenderer.getMap();
    }

    public void setMap(GoogleMap map) {
        this.mRenderer.setMap(map);
    }

    public boolean isLayerOnMap() {
        return this.mRenderer.isLayerOnMap();
    }

    /* access modifiers changed from: protected */
    public void addFeature(Feature feature) {
        this.mRenderer.addFeature(feature);
    }

    /* access modifiers changed from: protected */
    public void removeFeature(Feature feature) {
        this.mRenderer.removeFeature(feature);
    }

    public GeoJsonPointStyle getDefaultPointStyle() {
        return this.mRenderer.getDefaultPointStyle();
    }

    public GeoJsonLineStringStyle getDefaultLineStringStyle() {
        return this.mRenderer.getDefaultLineStringStyle();
    }

    public GeoJsonPolygonStyle getDefaultPolygonStyle() {
        return this.mRenderer.getDefaultPolygonStyle();
    }
}
