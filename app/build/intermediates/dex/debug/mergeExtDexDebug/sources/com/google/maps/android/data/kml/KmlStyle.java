package com.google.maps.android.data.kml;

import android.graphics.Color;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.data.Style;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class KmlStyle extends Style {
    private static final int HSV_VALUES = 3;
    private static final int HUE_VALUE = 0;
    private static final int INITIAL_SCALE = 1;
    private final HashMap<String, String> mBalloonOptions = new HashMap<>();
    private boolean mFill = true;
    private boolean mIconRandomColorMode = false;
    private String mIconUrl;
    private boolean mLineRandomColorMode = false;
    private float mMarkerColor = 0.0f;
    private boolean mOutline = true;
    private boolean mPolyRandomColorMode = false;
    private double mScale = 1.0d;
    private String mStyleId = null;
    private final HashSet<String> mStylesSet = new HashSet<>();

    KmlStyle() {
    }

    /* access modifiers changed from: package-private */
    public void setInfoWindowText(String text) {
        this.mBalloonOptions.put("text", text);
    }

    /* access modifiers changed from: package-private */
    public String getStyleId() {
        return this.mStyleId;
    }

    /* access modifiers changed from: package-private */
    public void setStyleId(String styleId) {
        this.mStyleId = styleId;
    }

    public boolean isStyleSet(String style) {
        return this.mStylesSet.contains(style);
    }

    public boolean hasFill() {
        return this.mFill;
    }

    public void setFill(boolean fill) {
        this.mFill = fill;
    }

    /* access modifiers changed from: package-private */
    public double getIconScale() {
        return this.mScale;
    }

    /* access modifiers changed from: package-private */
    public void setIconScale(double scale) {
        this.mScale = scale;
        this.mStylesSet.add("iconScale");
    }

    public boolean hasOutline() {
        return this.mOutline;
    }

    public boolean hasBalloonStyle() {
        return this.mBalloonOptions.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public void setOutline(boolean outline) {
        this.mOutline = outline;
        this.mStylesSet.add("outline");
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    /* access modifiers changed from: package-private */
    public void setIconUrl(String iconUrl) {
        this.mIconUrl = iconUrl;
        this.mStylesSet.add("iconUrl");
    }

    /* access modifiers changed from: package-private */
    public void setFillColor(String color) {
        setPolygonFillColor(Color.parseColor("#" + convertColor(color)));
        this.mStylesSet.add("fillColor");
    }

    /* access modifiers changed from: package-private */
    public void setMarkerColor(String color) {
        this.mMarkerColor = getHueValue(Color.parseColor("#" + convertColor(color)));
        this.mMarkerOptions.icon(BitmapDescriptorFactory.defaultMarker(this.mMarkerColor));
        this.mStylesSet.add("markerColor");
    }

    private static float getHueValue(int integerColor) {
        float[] hsvValues = new float[3];
        Color.colorToHSV(integerColor, hsvValues);
        return hsvValues[0];
    }

    private static String convertColor(String color) {
        String newColor;
        if (color.length() > 6) {
            newColor = color.substring(0, 2) + color.substring(6, 8) + color.substring(4, 6) + color.substring(2, 4);
        } else {
            newColor = color.substring(4, 6) + color.substring(2, 4) + color.substring(0, 2);
        }
        if (newColor.substring(0, 1).equals(" ")) {
            return "0" + newColor.substring(1, newColor.length());
        }
        return newColor;
    }

    /* access modifiers changed from: package-private */
    public void setHeading(float heading) {
        setMarkerRotation(heading);
        this.mStylesSet.add("heading");
    }

    /* access modifiers changed from: package-private */
    public void setHotSpot(float x, float y, String xUnits, String yUnits) {
        setMarkerHotSpot(x, y, xUnits, yUnits);
        this.mStylesSet.add("hotSpot");
    }

    /* access modifiers changed from: package-private */
    public void setIconColorMode(String colorMode) {
        this.mIconRandomColorMode = colorMode.equals("random");
        this.mStylesSet.add("iconColorMode");
    }

    /* access modifiers changed from: package-private */
    public boolean isIconRandomColorMode() {
        return this.mIconRandomColorMode;
    }

    /* access modifiers changed from: package-private */
    public void setLineColorMode(String colorMode) {
        this.mLineRandomColorMode = colorMode.equals("random");
        this.mStylesSet.add("lineColorMode");
    }

    public boolean isLineRandomColorMode() {
        return this.mLineRandomColorMode;
    }

    /* access modifiers changed from: package-private */
    public void setPolyColorMode(String colorMode) {
        this.mPolyRandomColorMode = colorMode.equals("random");
        this.mStylesSet.add("polyColorMode");
    }

    public boolean isPolyRandomColorMode() {
        return this.mPolyRandomColorMode;
    }

    /* access modifiers changed from: package-private */
    public void setOutlineColor(String color) {
        this.mPolylineOptions.color(Color.parseColor("#" + convertColor(color)));
        this.mPolygonOptions.strokeColor(Color.parseColor("#" + color));
        this.mStylesSet.add("outlineColor");
    }

    /* access modifiers changed from: package-private */
    public void setWidth(Float width) {
        setLineStringWidth(width.floatValue());
        setPolygonStrokeWidth(width.floatValue());
        this.mStylesSet.add("width");
    }

    public HashMap<String, String> getBalloonOptions() {
        return this.mBalloonOptions;
    }

    private static MarkerOptions createMarkerOptions(MarkerOptions originalMarkerOption, boolean iconRandomColorMode, float markerColor) {
        MarkerOptions newMarkerOption = new MarkerOptions();
        newMarkerOption.rotation(originalMarkerOption.getRotation());
        newMarkerOption.anchor(originalMarkerOption.getAnchorU(), originalMarkerOption.getAnchorV());
        if (iconRandomColorMode) {
            originalMarkerOption.icon(BitmapDescriptorFactory.defaultMarker(getHueValue(computeRandomColor((int) markerColor))));
        }
        newMarkerOption.icon(originalMarkerOption.getIcon());
        return newMarkerOption;
    }

    private static PolylineOptions createPolylineOptions(PolylineOptions originalPolylineOption) {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(originalPolylineOption.getColor());
        polylineOptions.width(originalPolylineOption.getWidth());
        return polylineOptions;
    }

    private static PolygonOptions createPolygonOptions(PolygonOptions originalPolygonOption, boolean isFill, boolean isOutline) {
        PolygonOptions polygonOptions = new PolygonOptions();
        if (isFill) {
            polygonOptions.fillColor(originalPolygonOption.getFillColor());
        }
        if (isOutline) {
            polygonOptions.strokeColor(originalPolygonOption.getStrokeColor());
            polygonOptions.strokeWidth(originalPolygonOption.getStrokeWidth());
        }
        return polygonOptions;
    }

    public MarkerOptions getMarkerOptions() {
        return createMarkerOptions(this.mMarkerOptions, isIconRandomColorMode(), this.mMarkerColor);
    }

    public PolylineOptions getPolylineOptions() {
        return createPolylineOptions(this.mPolylineOptions);
    }

    public PolygonOptions getPolygonOptions() {
        return createPolygonOptions(this.mPolygonOptions, this.mFill, this.mOutline);
    }

    public static int computeRandomColor(int color) {
        Random random = new Random();
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        if (red != 0) {
            red = random.nextInt(red);
        }
        if (blue != 0) {
            blue = random.nextInt(blue);
        }
        if (green != 0) {
            green = random.nextInt(green);
        }
        return Color.rgb(red, green, blue);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Style").append("{");
        sb.append("\n balloon options=").append(this.mBalloonOptions);
        sb.append(",\n fill=").append(this.mFill);
        sb.append(",\n outline=").append(this.mOutline);
        sb.append(",\n icon url=").append(this.mIconUrl);
        sb.append(",\n scale=").append(this.mScale);
        sb.append(",\n style id=").append(this.mStyleId);
        sb.append("\n}\n");
        return sb.toString();
    }
}
