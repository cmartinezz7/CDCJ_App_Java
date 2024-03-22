package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.GroundOverlay;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class KmlParser {
    private static final String CONTAINER_REGEX = "Folder|Document";
    private static final String GROUND_OVERLAY = "GroundOverlay";
    private static final String PLACEMARK = "Placemark";
    private static final String STYLE = "Style";
    private static final String STYLE_MAP = "StyleMap";
    private static final String UNSUPPORTED_REGEX = "altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|NetworkLink|NetworkLinkControl|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when";
    private final ArrayList<KmlContainer> mContainers = new ArrayList<>();
    private final HashMap<KmlGroundOverlay, GroundOverlay> mGroundOverlays = new HashMap<>();
    private final XmlPullParser mParser;
    private final HashMap<KmlPlacemark, Object> mPlacemarks = new HashMap<>();
    private final HashMap<String, String> mStyleMaps = new HashMap<>();
    private final HashMap<String, KmlStyle> mStyles = new HashMap<>();

    KmlParser(XmlPullParser parser) {
        this.mParser = parser;
    }

    /* access modifiers changed from: package-private */
    public void parseKml() throws XmlPullParserException, IOException {
        int eventType = this.mParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                if (this.mParser.getName().matches(UNSUPPORTED_REGEX)) {
                    skip(this.mParser);
                }
                if (this.mParser.getName().matches(CONTAINER_REGEX)) {
                    this.mContainers.add(KmlContainerParser.createContainer(this.mParser));
                }
                if (this.mParser.getName().equals(STYLE)) {
                    KmlStyle style = KmlStyleParser.createStyle(this.mParser);
                    this.mStyles.put(style.getStyleId(), style);
                }
                if (this.mParser.getName().equals(STYLE_MAP)) {
                    this.mStyleMaps.putAll(KmlStyleParser.createStyleMap(this.mParser));
                }
                if (this.mParser.getName().equals(PLACEMARK)) {
                    this.mPlacemarks.put(KmlFeatureParser.createPlacemark(this.mParser), (Object) null);
                }
                if (this.mParser.getName().equals(GROUND_OVERLAY)) {
                    this.mGroundOverlays.put(KmlFeatureParser.createGroundOverlay(this.mParser), (Object) null);
                }
            }
            eventType = this.mParser.next();
        }
        this.mStyles.put((Object) null, new KmlStyle());
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, KmlStyle> getStyles() {
        return this.mStyles;
    }

    /* access modifiers changed from: package-private */
    public HashMap<KmlPlacemark, Object> getPlacemarks() {
        return this.mPlacemarks;
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, String> getStyleMaps() {
        return this.mStyleMaps;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<KmlContainer> getContainers() {
        return this.mContainers;
    }

    /* access modifiers changed from: package-private */
    public HashMap<KmlGroundOverlay, GroundOverlay> getGroundOverlays() {
        return this.mGroundOverlays;
    }

    static void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() == 2) {
            int depth = 1;
            while (depth != 0) {
                int next = parser.next();
                if (next == 2) {
                    depth++;
                } else if (next == 3) {
                    depth--;
                }
            }
            return;
        }
        throw new IllegalStateException();
    }
}
