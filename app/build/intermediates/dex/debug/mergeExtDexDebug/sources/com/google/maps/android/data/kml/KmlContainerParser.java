package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.GroundOverlay;
import com.google.maps.android.data.Feature;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class KmlContainerParser {
    private static final String CONTAINER_REGEX = "Folder|Document";
    private static final String EXTENDED_DATA = "ExtendedData";
    private static final String GROUND_OVERLAY = "GroundOverlay";
    private static final String PLACEMARK = "Placemark";
    private static final String PROPERTY_REGEX = "name|description|visibility|open|address|phoneNumber";
    private static final String STYLE = "Style";
    private static final String STYLE_MAP = "StyleMap";
    private static final String UNSUPPORTED_REGEX = "altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when";

    KmlContainerParser() {
    }

    static KmlContainer createContainer(XmlPullParser parser) throws XmlPullParserException, IOException {
        return assignPropertiesToContainer(parser);
    }

    private static KmlContainer assignPropertiesToContainer(XmlPullParser parser) throws XmlPullParserException, IOException {
        HashMap<KmlGroundOverlay, GroundOverlay> containerGroundOverlays;
        String startTag;
        int eventType;
        HashMap<KmlGroundOverlay, GroundOverlay> containerGroundOverlays2;
        XmlPullParser xmlPullParser = parser;
        String startTag2 = parser.getName();
        String containerId = null;
        HashMap<String, String> containerProperties = new HashMap<>();
        HashMap<String, KmlStyle> containerStyles = new HashMap<>();
        HashMap<? extends Feature, Object> containerPlacemarks = new HashMap<>();
        ArrayList<KmlContainer> nestedContainers = new ArrayList<>();
        HashMap<String, String> containerStyleMaps = new HashMap<>();
        HashMap<KmlGroundOverlay, GroundOverlay> containerGroundOverlays3 = new HashMap<>();
        if (xmlPullParser.getAttributeValue((String) null, Name.MARK) != null) {
            containerId = xmlPullParser.getAttributeValue((String) null, Name.MARK);
        }
        parser.next();
        int eventType2 = parser.getEventType();
        while (true) {
            if (eventType2 != 3) {
                startTag = startTag2;
                eventType = eventType2;
                containerGroundOverlays = containerGroundOverlays3;
            } else if (!parser.getName().equals(startTag2)) {
                startTag = startTag2;
                eventType = eventType2;
                containerGroundOverlays = containerGroundOverlays3;
            } else {
                String str = startTag2;
                int i = eventType2;
                HashMap<KmlGroundOverlay, GroundOverlay> hashMap = containerGroundOverlays3;
                return new KmlContainer(containerProperties, containerStyles, containerPlacemarks, containerStyleMaps, nestedContainers, containerGroundOverlays3, containerId);
            }
            if (eventType != 2) {
                containerGroundOverlays2 = containerGroundOverlays;
            } else if (parser.getName().matches(UNSUPPORTED_REGEX)) {
                KmlParser.skip(parser);
                containerGroundOverlays2 = containerGroundOverlays;
            } else if (parser.getName().matches(CONTAINER_REGEX)) {
                nestedContainers.add(assignPropertiesToContainer(parser));
                containerGroundOverlays2 = containerGroundOverlays;
            } else if (parser.getName().matches(PROPERTY_REGEX)) {
                containerProperties.put(parser.getName(), parser.nextText());
                containerGroundOverlays2 = containerGroundOverlays;
            } else if (parser.getName().equals(STYLE_MAP)) {
                setContainerStyleMap(xmlPullParser, containerStyleMaps);
                containerGroundOverlays2 = containerGroundOverlays;
            } else if (parser.getName().equals(STYLE)) {
                setContainerStyle(xmlPullParser, containerStyles);
                containerGroundOverlays2 = containerGroundOverlays;
            } else if (parser.getName().equals(PLACEMARK)) {
                setContainerPlacemark(xmlPullParser, containerPlacemarks);
                containerGroundOverlays2 = containerGroundOverlays;
            } else if (parser.getName().equals(EXTENDED_DATA)) {
                setExtendedDataProperties(xmlPullParser, containerProperties);
                containerGroundOverlays2 = containerGroundOverlays;
            } else if (parser.getName().equals(GROUND_OVERLAY)) {
                containerGroundOverlays2 = containerGroundOverlays;
                containerGroundOverlays2.put(KmlFeatureParser.createGroundOverlay(parser), (Object) null);
            } else {
                containerGroundOverlays2 = containerGroundOverlays;
            }
            eventType2 = parser.next();
            containerGroundOverlays3 = containerGroundOverlays2;
            startTag2 = startTag;
        }
    }

    private static void setContainerStyleMap(XmlPullParser parser, HashMap<String, String> containerStyleMap) throws XmlPullParserException, IOException {
        containerStyleMap.putAll(KmlStyleParser.createStyleMap(parser));
    }

    private static void setExtendedDataProperties(XmlPullParser parser, HashMap<String, String> mContainerProperties) throws XmlPullParserException, IOException {
        String propertyKey = null;
        int eventType = parser.getEventType();
        while (true) {
            if (eventType != 3 || !parser.getName().equals(EXTENDED_DATA)) {
                if (eventType == 2) {
                    if (parser.getName().equals("Data")) {
                        propertyKey = parser.getAttributeValue((String) null, "name");
                    } else if (parser.getName().equals("value") && propertyKey != null) {
                        mContainerProperties.put(propertyKey, parser.nextText());
                        propertyKey = null;
                    }
                }
                eventType = parser.next();
            } else {
                return;
            }
        }
    }

    private static void setContainerStyle(XmlPullParser parser, HashMap<String, KmlStyle> containerStyles) throws XmlPullParserException, IOException {
        if (parser.getAttributeValue((String) null, Name.MARK) != null) {
            KmlStyle style = KmlStyleParser.createStyle(parser);
            containerStyles.put(style.getStyleId(), style);
        }
    }

    private static void setContainerPlacemark(XmlPullParser parser, HashMap<KmlPlacemark, Object> containerPlacemarks) throws XmlPullParserException, IOException {
        containerPlacemarks.put(KmlFeatureParser.createPlacemark(parser), (Object) null);
    }
}
