package es.santander.justicia.minisJusticia;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.dto.MarkerDTO;
import es.santander.justicia.minisJusticia.enums.MarkerType;

public class CustomIconRenderer extends DefaultClusterRenderer<MarkerDTO> {
    public CustomIconRenderer(Context context, GoogleMap map, ClusterManager<MarkerDTO> clusterManager) {
        super(context, map, clusterManager);
    }

    /* renamed from: es.santander.justicia.minisJusticia.CustomIconRenderer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$es$santander$justicia$minisJusticia$enums$MarkerType;

        static {
            int[] iArr = new int[MarkerType.values().length];
            $SwitchMap$es$santander$justicia$minisJusticia$enums$MarkerType = iArr;
            try {
                iArr[MarkerType.OFFICE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onBeforeClusterItemRendered(MarkerDTO item, MarkerOptions markerOptions) {
        if (AnonymousClass1.$SwitchMap$es$santander$justicia$minisJusticia$enums$MarkerType[item.getMarkerType().ordinal()] == 1) {
            BitmapDescriptorFactory.fromResource(R.drawable.poi_santander);
        }
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.poi_santander));
        markerOptions.title(item.getTitle());
        CustomIconRenderer.super.onBeforeClusterItemRendered(item, markerOptions);
    }
}
