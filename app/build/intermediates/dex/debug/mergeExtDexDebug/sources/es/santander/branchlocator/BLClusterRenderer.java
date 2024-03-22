package es.santander.branchlocator;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

class BLClusterRenderer extends DefaultClusterRenderer {
    private static final float ACHOR_WINDOWS_U = -9999.0f;
    private static final float ACHOR_WINDOWS_V = -9999.0f;
    private static final String TAG = "ClusterRender";
    private static Activity activity;
    private ClusterItem lastItem = null;
    private Marker lastMarker = null;
    private ClusterItem nearestMarker = null;

    public BLClusterRenderer(Activity activity2, GoogleMap map, ClusterManager clusterManager) {
        super(activity2, map, clusterManager);
        activity = activity2;
    }

    private static Bitmap createBitmap(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    public static Bitmap checkPOIType(BLPoi pointOfInterest, boolean isSelected) {
        BLPoiType type = pointOfInterest.getObjectType();
        BLPoiType subtype = pointOfInterest.getSubType();
        if (type == null || type.getCode() == null) {
            return null;
        }
        String code = type.getCode();
        char c = 65535;
        int hashCode = code.hashCode();
        if (hashCode != -1630652553) {
            if (hashCode != -1381030494) {
                if (hashCode == 96922 && code.equals("atm")) {
                    c = 0;
                }
            } else if (code.equals("branch")) {
                c = 1;
            }
        } else if (code.equals("corresponsales")) {
            c = 2;
        }
        if (c == 0) {
            boolean popular = false;
            try {
                popular = pointOfInterest.getSpecialType().getCode().toLowerCase().contains("popular-euro");
            } catch (NullPointerException e) {
            }
            if (subtype != null && subtype.getCode().equals("non_santander_atm") && !popular) {
                return createBitmap(setupMarker(ResourcesCompat.getDrawable(activity.getResources(), R.drawable.bl_ic_atm_santander, (Resources.Theme) null), R.layout.custom_marker_selected, isSelected));
            }
            if (subtype == null || !subtype.getCode().equals("non_santander_atm") || !popular) {
                return createBitmap(setupMarker(ResourcesCompat.getDrawable(activity.getResources(), R.drawable.bl_ic_rojo, (Resources.Theme) null), R.layout.custom_marker_selected, isSelected));
            }
            return createBitmap(setupMarker(ResourcesCompat.getDrawable(activity.getResources(), R.drawable.bl_ic_euro_automatic_cash, (Resources.Theme) null), R.layout.custom_marker_selected_pastor, isSelected));
        } else if (c != 1) {
            if (c != 2) {
                return createBitmap(setupMarker(ResourcesCompat.getDrawable(activity.getResources(), R.drawable.bl_ic_rojo, (Resources.Theme) null), R.layout.custom_marker_selected, isSelected));
            }
            return createBitmap(setupMarker(ResourcesCompat.getDrawable(activity.getResources(), R.drawable.bl_ic_atm_partners, (Resources.Theme) null), R.layout.custom_marker_selected, isSelected));
        } else if (subtype != null && subtype.getCode().toLowerCase().equals("clientes_popular")) {
            return createBitmap(setupMarker(ResourcesCompat.getDrawable(activity.getResources(), R.drawable.bl_ic_euro_automatic_cash, (Resources.Theme) null), R.layout.custom_marker_selected_pastor, isSelected));
        } else {
            if (subtype == null || !subtype.getCode().equals("workcafe")) {
                return createBitmap(setupMarker(ResourcesCompat.getDrawable(activity.getResources(), R.drawable.bl_ic_rojo, (Resources.Theme) null), R.layout.custom_marker_selected, isSelected));
            }
            return createBitmap(setupMarker(ResourcesCompat.getDrawable(activity.getResources(), R.drawable.bl_ic_workcafe, (Resources.Theme) null), R.layout.custom_marker_selected_workcafe, isSelected));
        }
    }

    private static View setupMarker(Drawable icon, int layout, boolean isSelected) {
        LayoutInflater mInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        RelativeLayout view = new RelativeLayout(activity);
        if (isSelected) {
            mInflater.inflate(layout, view, true);
        } else {
            mInflater.inflate(R.layout.custom_marker, view, true);
        }
        ((ImageView) view.findViewById(R.id.marker_icon)).setImageDrawable(icon);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        return view;
    }

    /* access modifiers changed from: protected */
    public void onBeforeClusterRendered(Cluster cluster, MarkerOptions markerOptions) {
        super.onBeforeClusterRendered(cluster, markerOptions);
        Bitmap bitmap = createBitmap(setupCluster(cluster.getSize()));
        if (bitmap != null) {
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        }
    }

    /* access modifiers changed from: protected */
    public void onBeforeClusterItemRendered(ClusterItem item, MarkerOptions markerOptions) {
        Bitmap bitmap;
        super.onBeforeClusterItemRendered(item, markerOptions);
        if (((BLPoi) item).isToBeSelected()) {
            this.nearestMarker = item;
            ((BLPoi) item).setToBeSelected(false);
            bitmap = checkPOIType((BLPoi) item, true);
            Activity activity2 = activity;
            if (activity2 != null) {
                ((BLMapsLogicActivity) activity2).showBasicInfo((BLPoi) item);
            }
        } else {
            bitmap = checkPOIType((BLPoi) item, false);
        }
        if (bitmap != null) {
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        }
    }

    public void setOnClusterItemClickListener(final ClusterManager.OnClusterItemClickListener listener) {
        super.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener() {
            public boolean onClusterItemClick(ClusterItem clusterItem) {
                Log.d("POI_SELECTED", clusterItem.toString());
                BLClusterRenderer.this.selectMarker(clusterItem);
                listener.onClusterItemClick(clusterItem);
                return false;
            }
        });
    }

    public void selectMarker(ClusterItem item) throws IllegalArgumentException {
        deselectMarker();
        Marker marker = getMarker(item);
        if (marker != null) {
            marker.setInfoWindowAnchor(-9999.0f, -9999.0f);
            this.lastMarker = marker;
            this.lastItem = item;
            marker.setIcon(BitmapDescriptorFactory.fromBitmap(checkPOIType((BLPoi) item, true)));
        }
    }

    public void deselectMarker() {
        ClusterItem clusterItem;
        if (!(this.lastMarker == null || (clusterItem = this.lastItem) == null)) {
            try {
                this.lastMarker.setIcon(BitmapDescriptorFactory.fromBitmap(checkPOIType((BLPoi) clusterItem, false)));
            } catch (IllegalArgumentException e) {
                Log.e(TAG, e.toString());
            }
        }
        ClusterItem clusterItem2 = this.nearestMarker;
        if (clusterItem2 != null) {
            Bitmap lastBitmap = checkPOIType((BLPoi) clusterItem2, false);
            try {
                Marker marker = getMarker(this.nearestMarker);
                if (marker != null) {
                    marker.setIcon(BitmapDescriptorFactory.fromBitmap(lastBitmap));
                }
                this.nearestMarker = null;
            } catch (IllegalArgumentException e2) {
                Log.e(TAG, e2.toString());
            }
        }
    }

    private View setupCluster(int numCluster) {
        RelativeLayout view = new RelativeLayout(activity);
        ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.custom_cluster, view, true);
        ((BLTextView) view.findViewById(R.id.custom_cluster_num)).setText(String.valueOf(numCluster));
        view.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        return view;
    }
}
