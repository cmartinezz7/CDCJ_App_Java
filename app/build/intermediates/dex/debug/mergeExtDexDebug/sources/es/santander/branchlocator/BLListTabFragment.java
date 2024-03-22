package es.santander.branchlocator;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.branchlocator.common.AnalyticsComponentHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BLListTabFragment extends Fragment implements BLRecyclerViewOnClickListener {
    private BLMapsListener blMapsListener;
    private OnListItemClickCallback onListItemClickCallback;
    private RecyclerView recyclerView;
    private View rootView;

    public interface OnListItemClickCallback {
        void callOnItemClick(POIListItem pOIListItem);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.list_tab_fragment, container, false);
        this.rootView = inflate;
        return inflate;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        BLListTabFragment.super.onViewCreated(view, savedInstanceState);
        setupUI();
    }

    public void onResume() {
        BLListTabFragment.super.onResume();
        if (getUserVisibleHint()) {
            Map<String, String> viewDataLayer = new HashMap<>(1);
            viewDataLayer.put("ScreenName", "branch locator:listing");
            AnalyticsComponentHelper.trackView("branch locator:listing", viewDataLayer);
        }
        checkFilters();
    }

    private void setupUI() {
        this.recyclerView = this.rootView.findViewById(R.id.recycler_view);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DataRepository.getInstance().pointsOfInterestLiveData.observe(this, new Observer<List<BLPoi>>() {
            public void onChanged(List<BLPoi> poisList) {
                if (poisList != null) {
                    BLListTabFragment.this.updatePOIsList(poisList);
                }
            }
        });
    }

    private void updateListView(ArrayList<POIListItem> poisList) {
        this.recyclerView.setAdapter(new POIListAdapter(this, poisList));
    }

    /* access modifiers changed from: private */
    public void updatePOIsList(List<BLPoi> blPois) {
        ArrayList<POIListItem> poisList = new ArrayList<>();
        for (BLPoi pois : blPois) {
            if (pois.getLocation().getAddress() != null) {
                addPOIToList(poisList, pois);
            }
        }
        updateListView(poisList);
    }

    private void addPOIToList(ArrayList<POIListItem> poisList, BLPoi pois) {
        String title;
        String city = "";
        if (pois.getLocation() != null) {
            city = BLUtils.capitalizeString(pois.getLocation().getCity());
        }
        if (pois.getObjectType() != null) {
            title = buildItemListTitle(pois.getObjectType().getCode(), city);
        } else {
            title = city;
        }
        poisList.add(new POIListItem(pois.getId(), title, pois.getLocation().getAddress(), BLUtils.getDistanceWithUser(getActivity(), BLPreferencesManager.currentLocation, pois.getLatLng())));
    }

    private String buildItemListTitle(String code, String city) {
        String type = null;
        StringBuilder title = new StringBuilder();
        if (code != null && code.equals("corresponsales")) {
            type = getContext().getString(R.string.bl_partners);
        } else if (code != null) {
            type = getContext().getString(R.string.bl_santander);
        }
        if (type != null && !city.equals("")) {
            title.append(type);
            title.append(" - ");
        } else if (type != null) {
            title.append(type);
        }
        title.append(city);
        return title.toString();
    }

    private ArrayList<POIListItem> loadAllPOIs(List<BLPoi> blPois) {
        ArrayList<POIListItem> poisList = new ArrayList<>();
        for (BLPoi pois : blPois) {
            addPOIToList(poisList, pois);
        }
        return poisList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String formatDistance(double r5, double r7) {
        /*
            r4 = this;
            android.content.Context r0 = r4.getContext()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            java.util.Locale r0 = r0.locale
            java.lang.String r0 = r0.getCountry()
            int r1 = r0.hashCode()
            r2 = 2128(0x850, float:2.982E-42)
            if (r1 == r2) goto L_0x006f
            r2 = 2222(0x8ae, float:3.114E-42)
            if (r1 == r2) goto L_0x0065
            r2 = 2267(0x8db, float:3.177E-42)
            if (r1 == r2) goto L_0x005b
            r2 = 2475(0x9ab, float:3.468E-42)
            if (r1 == r2) goto L_0x0051
            r2 = 2556(0x9fc, float:3.582E-42)
            if (r1 == r2) goto L_0x0047
            r2 = 2562(0xa02, float:3.59E-42)
            if (r1 == r2) goto L_0x003d
            r2 = 2718(0xa9e, float:3.809E-42)
            if (r1 == r2) goto L_0x0033
        L_0x0032:
            goto L_0x0079
        L_0x0033:
            java.lang.String r1 = "US"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0032
            r1 = 1
            goto L_0x007a
        L_0x003d:
            java.lang.String r1 = "PR"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0032
            r1 = 6
            goto L_0x007a
        L_0x0047:
            java.lang.String r1 = "PL"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0032
            r1 = 4
            goto L_0x007a
        L_0x0051:
            java.lang.String r1 = "MX"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0032
            r1 = 3
            goto L_0x007a
        L_0x005b:
            java.lang.String r1 = "GB"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0032
            r1 = 0
            goto L_0x007a
        L_0x0065:
            java.lang.String r1 = "ES"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0032
            r1 = 2
            goto L_0x007a
        L_0x006f:
            java.lang.String r1 = "BR"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0032
            r1 = 5
            goto L_0x007a
        L_0x0079:
            r1 = -1
        L_0x007a:
            java.lang.String r2 = " "
            switch(r1) {
                case 0: goto L_0x00bf;
                case 1: goto L_0x00bf;
                case 2: goto L_0x009f;
                case 3: goto L_0x009f;
                case 4: goto L_0x009f;
                case 5: goto L_0x009f;
                case 6: goto L_0x009f;
                default: goto L_0x007f;
            }
        L_0x007f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = es.santander.branchlocator.BLUtils.formatOneDecimal(r5)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = es.santander.branchlocator.R.string.km
            java.lang.String r2 = r4.getString(r2)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x009f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = es.santander.branchlocator.BLUtils.formatOneDecimal(r5)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = es.santander.branchlocator.R.string.km
            java.lang.String r2 = r4.getString(r2)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x00bf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = es.santander.branchlocator.BLUtils.formatOneDecimal(r7)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = es.santander.branchlocator.R.string.milles
            java.lang.String r2 = r4.getString(r2)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.branchlocator.BLListTabFragment.formatDistance(double, double):java.lang.String");
    }

    public void onClick(POIListItem poiListItem) {
        this.onListItemClickCallback.callOnItemClick(poiListItem);
    }

    private List<BLFilter> getSavedFilters() {
        return BLPreferencesManager.getInstance(getActivity()).getFilterData();
    }

    private void checkFilters() {
        List<BLFilter> filters = getSavedFilters();
        if (filters != null) {
            this.blMapsListener.setupFilterList(filters);
        }
        if (filters != null) {
            filters.size();
        }
    }

    public void onAttach(Context context) {
        BLListTabFragment.super.onAttach(context);
        try {
            this.blMapsListener = (BLMapsListener) context;
            this.onListItemClickCallback = (OnListItemClickCallback) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement BLMapsListener or OnListItemClickCallback");
        }
    }
}
