package es.santander.branchlocator;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.material.tabs.TabLayout;
import com.santander.globile.uicomponents.tabs.GlobileBaseFragmentTabsAdapter;
import com.santander.globile.uicomponents.tabs.data.GlobileTab;
import com.santander.globile.uicomponents.tabs.data.GlobileTabsAdapterData;
import es.santander.branchlocator.BLListTabFragment;
import es.santander.branchlocator.BLTouchableWrapper;
import es.santander.branchlocator.common.AnalyticsComponentHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BLMapsLogicActivity extends BLBaseActivity implements BLTouchableWrapper.UpdateMapAfterUserInterection, BLMapsListener, BLListTabFragment.OnListItemClickCallback, ActivityCompat.OnRequestPermissionsResultCallback {
    private static final int AUTOCOMPLETE_REQUEST_CODE = 66;
    public static String otherFilterIndexes = null;
    public static String popularFilterIndexes = null;
    private static SharedPreferences pref;
    /* access modifiers changed from: private */
    public BLMapTabFragment BLMapTabFragment;
    /* access modifiers changed from: private */
    public BLAutoCompleteTextView blAutoCompleteTextView;
    /* access modifiers changed from: private */
    public ConstraintLayout blMapsConstraintLayout;
    private BLPlaceAutocompleteAdapter blPlaceAutocompleteAdapter;
    /* access modifiers changed from: private */
    public AppCompatImageView blSearchArea;
    private ImageView btnBack;
    private BLConnectivityBroadcastReceiver connectivityChangeReceiver;
    private FilterTagsView filterTagsList;
    private BLGpsCheck gpsReceiver;
    private boolean isPOISLoaded = false;
    private boolean isPermissionOK;
    private boolean onBackFromArrow = false;
    private TabLayout tabLayout;
    protected ViewPager viewPager;
    private BLMapsViewModel viewmodel;

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.branchlocator.BLBaseActivity, es.santander.branchlocator.BLMapsLogicActivity, androidx.fragment.app.FragmentActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setPreferences(savedInstanceState);
        setContentView(R.layout.branch_locator_maps);
        this.viewmodel = ViewModelProviders.of(this).get(BLMapsViewModel.class);
        this.viewmodel.setRepository(new BLRepository(BLRetrofitClient.getInstance().getBranchService(this)));
        setupViewPager();
        setupUi();
        setupListeners();
        initPermissionCheck();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initReceiver();
    }

    private void setupUi() {
        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        if (BLUtils.getBtnBackIsEnable()) {
            this.btnBack.setVisibility(0);
        } else {
            this.btnBack.setVisibility(8);
        }
    }

    private void setupListeners() {
        this.btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BLMapsLogicActivity.this.finish();
            }
        });
    }

    private void initReceiver() {
        if (this.isPermissionOK) {
            IntentFilter connectivityFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            BLConnectivityBroadcastReceiver bLConnectivityBroadcastReceiver = new BLConnectivityBroadcastReceiver();
            this.connectivityChangeReceiver = bLConnectivityBroadcastReceiver;
            registerReceiver(bLConnectivityBroadcastReceiver, connectivityFilter);
            IntentFilter gpsFilter = new IntentFilter("android.location.PROVIDERS_CHANGED");
            BLGpsCheck bLGpsCheck = new BLGpsCheck();
            this.gpsReceiver = bLGpsCheck;
            registerReceiver(bLGpsCheck, gpsFilter);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        unregisterReceiver();
    }

    private void unregisterReceiver() {
        BLConnectivityBroadcastReceiver bLConnectivityBroadcastReceiver = this.connectivityChangeReceiver;
        if (bLConnectivityBroadcastReceiver != null) {
            unregisterReceiver(bLConnectivityBroadcastReceiver);
        }
        BLGpsCheck bLGpsCheck = this.gpsReceiver;
        if (bLGpsCheck != null) {
            unregisterReceiver(bLGpsCheck);
        }
    }

    private void setPreferences(Bundle savedInstanceState) {
        pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            popularFilterIndexes = intent.getStringExtra("popularFilterIndexes");
            otherFilterIndexes = intent.getStringExtra("otherFilterIndexes");
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("popularFilterIndexes", popularFilterIndexes);
            editor.putString("otherFilterIndexes", otherFilterIndexes);
            editor.apply();
        }
    }

    public static void recoverFilterIndexes(Context ctx) {
        SharedPreferences sharedPreferences = ctx.getApplicationContext().getSharedPreferences("MyPref", 0);
        pref = sharedPreferences;
        popularFilterIndexes = sharedPreferences.getString("popularFilterIndexes", (String) null);
        otherFilterIndexes = pref.getString("otherFilterIndexes", (String) null);
    }

    public static boolean isCustomFilterPopular() {
        if (popularFilterIndexes == null) {
            return false;
        }
        return true;
    }

    public static boolean isCustomFilterOther() {
        if (otherFilterIndexes == null) {
            return false;
        }
        return true;
    }

    public static boolean isBothFilterAreEmpty() {
        String str = popularFilterIndexes;
        if (str == null || otherFilterIndexes == null || !str.equals("") || !otherFilterIndexes.equals("")) {
            return false;
        }
        return true;
    }

    public static boolean isPopularItemFilterVisible(int code) {
        String str = popularFilterIndexes;
        if (str == null) {
            return true;
        }
        if (str.equals("")) {
            return false;
        }
        try {
            String[] indexes = popularFilterIndexes.split(",");
            for (String trim : indexes) {
                if (Integer.valueOf(trim.trim()).intValue() == code) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Log.i("Darwincio", "An exception occurred: " + e.getMessage());
            return true;
        }
    }

    public static boolean isOtherItemFilterVisible(int code) {
        String str = otherFilterIndexes;
        if (str == null) {
            return true;
        }
        if (str.equals("")) {
            return false;
        }
        try {
            String[] indexes = otherFilterIndexes.split(",");
            for (String trim : indexes) {
                if (Integer.valueOf(trim.trim()).intValue() == code) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Log.i("Darwincio", "An exception occurred: " + e.getMessage());
            return true;
        }
    }

    public static boolean isThereAnyPopularFilterSelected() {
        String str = popularFilterIndexes;
        if (str == null) {
            return true;
        }
        return !str.equals("");
    }

    public static boolean isThereAnyItem(List<BLFilterItem> listOfElement, List<Integer> listType) {
        if (!(listOfElement == null || listType == null)) {
            for (BLFilterItem item : listOfElement) {
                if (listType.contains(Integer.valueOf(item.getBLFilterCode()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Integer> getListCodeFromFilterItem(List<BLFilterItem> listFilterItem) {
        List<Integer> listType = new ArrayList<>();
        if (listFilterItem != null) {
            for (BLFilterItem blFilterItem : listFilterItem) {
                listType.add(Integer.valueOf(blFilterItem.getBLFilterCode()));
            }
        }
        return listType;
    }

    public static List<Integer> getListPositionServices() {
        List<BLFilterItem> listFilterItem = BLUtils.generateDefaultServicesFilter((Context) null);
        listFilterItem.addAll(BLUtils.generateDefaultPopularList((Context) null, false));
        return getListCodeFromFilterItem(listFilterItem);
    }

    public static List<Integer> getListPositionFacilities() {
        return getListCodeFromFilterItem(BLUtils.generateDefaultFacilitiesFilter((Context) null));
    }

    public static List<Integer> getListPositionAccesibility() {
        return getListCodeFromFilterItem(BLUtils.generateDefaultAccesibilityFilter((Context) null));
    }

    public static List<Integer> getListPositionPOI() {
        return getListCodeFromFilterItem(BLUtils.generateDefaultPOIFilter((Context) null));
    }

    public static boolean isThereAnyAditionalServicesSelected() {
        String str = otherFilterIndexes;
        if (str == null) {
            return true;
        }
        if (str.equals("")) {
            return false;
        }
        try {
            String[] indexes = otherFilterIndexes.split(",");
            for (String trim : indexes) {
                if (getListPositionServices().contains(Integer.valueOf(Integer.valueOf(trim.trim()).intValue()))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Log.i("Darwincio", "An exception occurred: " + e.getMessage());
            return true;
        }
    }

    public static boolean isThereAnyFacilitiesSelected() {
        String str = otherFilterIndexes;
        if (str == null) {
            return true;
        }
        if (str.equals("")) {
            return false;
        }
        try {
            String[] indexes = otherFilterIndexes.split(",");
            for (String trim : indexes) {
                if (getListPositionFacilities().contains(Integer.valueOf(Integer.valueOf(trim.trim()).intValue()))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Log.i("Darwincio", "An exception occurred: " + e.getMessage());
            return true;
        }
    }

    public static boolean isThereAnyAcessibilitySelected() {
        String str = otherFilterIndexes;
        if (str == null) {
            return true;
        }
        if (str.equals("")) {
            return false;
        }
        try {
            String[] indexes = otherFilterIndexes.split(",");
            for (String trim : indexes) {
                if (getListPositionAccesibility().contains(Integer.valueOf(Integer.valueOf(trim.trim()).intValue()))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Log.i("Darwincio", "An exception occurred: " + e.getMessage());
            return true;
        }
    }

    public static boolean isThereAnyPointOfInterestSelected() {
        String str = otherFilterIndexes;
        if (str == null) {
            return true;
        }
        if (str.equals("")) {
            return false;
        }
        try {
            String[] indexes = otherFilterIndexes.split(",");
            for (String trim : indexes) {
                if (getListPositionPOI().contains(Integer.valueOf(Integer.valueOf(trim.trim()).intValue()))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Log.i("Darwincio", "An exception occurred: " + e.getMessage());
            return true;
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [android.content.Context, es.santander.branchlocator.BLMapsLogicActivity] */
    private void setupViewPager() {
        this.viewPager = findViewById(R.id.viewpager);
        this.tabLayout = (TabLayout) findViewById(R.id.view_pager_tab);
        GlobileTab tab1 = new GlobileTab(getString(R.string.bl_map_tab_title), (Integer) null, new BLMapTabFragment());
        GlobileTab tab2 = new GlobileTab(getString(R.string.bl_list_tab_title), (Integer) null, new BLListTabFragment());
        ArrayList<GlobileTab> tabList = new ArrayList<>();
        tabList.add(tab1);
        tabList.add(tab2);
        GlobileBaseFragmentTabsAdapter adapterTabs = new GlobileBaseFragmentTabsAdapter(getSupportFragmentManager(), this, new GlobileTabsAdapterData(tabList));
        this.viewPager.setAdapter(adapterTabs);
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.BLMapTabFragment = adapterTabs.getItem(0);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        updateSizeInfo();
    }

    private void updateSizeInfo() {
        BLMapTabFragment bLMapTabFragment = this.BLMapTabFragment;
        if (bLMapTabFragment != null) {
            bLMapTabFragment.doUpdateSizeInfo();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 2001) {
            this.filterTagsList.setEnabled(true);
            this.BLMapTabFragment.doActivityResult(requestCode, resultCode);
        } else if (resultCode == 0 && requestCode == 2001) {
            this.filterTagsList.setEnabled(true);
        } else if (requestCode != 66) {
        } else {
            if (resultCode == -1) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                Log.i("GPS", "Place: " + place.getName() + ", " + place.getId());
            } else if (resultCode == 2) {
                Log.i("GPS", Autocomplete.getStatusFromIntent(data).getStatusMessage());
            }
        }
    }

    public void showBasicInfo(BLPoi BLPoi) {
        this.BLMapTabFragment.doShowBasicInfo(BLPoi);
    }

    public void onUpdateMapAfterUserInterection() {
        this.BLMapTabFragment.doUpdateMapAfterUserInteraction();
    }

    public void onBackPressed() {
        if (this.BLMapTabFragment.getSheetBehavior() == null || this.BLMapTabFragment.getSheetBehavior().getState() != 4 || this.onBackFromArrow) {
            this.onBackFromArrow = false;
            super.onBackPressed();
            return;
        }
        this.BLMapTabFragment.deselectCurrentMarker();
    }

    private void setupSearchAutoCompleteTextView() {
        BLAutoCompleteTextView bLAutoCompleteTextView = (BLAutoCompleteTextView) findViewById(R.id.input_search_autocomplete);
        this.blAutoCompleteTextView = bLAutoCompleteTextView;
        bLAutoCompleteTextView.clearText();
        this.blAutoCompleteTextView.setupListener(new BLOnGetStringFromAutoComplete() {
            /* JADX WARNING: type inference failed for: r0v2, types: [es.santander.branchlocator.BLMapsLogicActivity, android.app.Activity] */
            /* JADX WARNING: type inference failed for: r0v5, types: [android.content.Context, es.santander.branchlocator.BLMapsLogicActivity] */
            public void onSearch(String address) {
                BLMapsLogicActivity.this.blAutoCompleteTextView.clearFocus();
                BLUtils.hideSoftKeyboard(BLMapsLogicActivity.this);
                if (TextUtils.isEmpty(address)) {
                    ? r0 = BLMapsLogicActivity.this;
                    BLUtils.showCustomToast(r0, r0.getString(R.string.bl_toast_search_empty));
                    return;
                }
                BLMapsLogicActivity.this.searchFromAutocomplete(address);
            }

            public void onDelete() {
                if (BLMapsLogicActivity.this.BLMapTabFragment.getMainMarker() != null) {
                    BLMapsLogicActivity.this.BLMapTabFragment.getMainMarker().remove();
                }
                BLMapsLogicActivity.this.BLMapTabFragment.setSearchFromSearch(false);
                BLMapsLogicActivity.this.BLMapTabFragment.setLocationFromSearch((LatLng) null);
            }
        }, new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    BLMapsLogicActivity.this.BLMapTabFragment.deselectCurrentMarker();
                    Map<String, String> dataLayer = new HashMap<>(1);
                    dataLayer.put("ScreenName", "branch locator:home");
                    dataLayer.put("EventAction", "tap search bar");
                    AnalyticsComponentHelper.trackEvent("tap search bar", dataLayer);
                }
            }
        });
    }

    public void doSetupUi() {
        setupSearchAutoCompleteTextView();
        setupSearchArea();
        setupViewPagerListener();
        setupFilterTagListView();
        setupSheetMargin();
    }

    private void setupViewPagerListener() {
        this.blMapsConstraintLayout = findViewById(R.id.bl_maps_cl);
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int i, float v, int i1) {
                if (i == 0) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        BLMapsLogicActivity.this.blMapsConstraintLayout.setElevation(3.0f);
                    }
                    BLMapsLogicActivity.this.blSearchArea.setVisibility(0);
                } else if (i == 1) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        BLMapsLogicActivity.this.blMapsConstraintLayout.setElevation(2.0f);
                    }
                    BLMapsLogicActivity.this.blSearchArea.setVisibility(8);
                }
            }

            public void onPageSelected(int i) {
                if (i == 0) {
                    Map<String, String> viewDataLayer = new HashMap<>(1);
                    viewDataLayer.put("ScreenName", "branch locator:home");
                    AnalyticsComponentHelper.trackView("branch locator:home", viewDataLayer);
                }
                if (i == 1) {
                    Map<String, String> viewDataLayer2 = new HashMap<>(1);
                    viewDataLayer2.put("ScreenName", "branch locator:listing");
                    AnalyticsComponentHelper.trackView("branch locator:listing", viewDataLayer2);
                }
            }

            public void onPageScrollStateChanged(int i) {
            }
        });
    }

    private void setupSearchArea() {
        AppCompatImageView findViewById = findViewById(R.id.ic_search_area);
        this.blSearchArea = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BLMapsLogicActivity.this.blSearchArea.setVisibility(8);
                BLMapsLogicActivity.this.BLMapTabFragment.doSearchArea();
            }
        });
    }

    private void setupFilterTagListView() {
        this.filterTagsList = (FilterTagsView) findViewById(R.id.filter_tags_list);
        if (BLUtils.isFiltersEnabled()) {
            this.filterTagsList.setupFilterActivityIntent(this);
            this.filterTagsList.setVisibility(0);
            return;
        }
        this.filterTagsList.setVisibility(8);
    }

    private void setupSheetMargin() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) this.blMapsConstraintLayout.getLayoutParams();
        this.BLMapTabFragment.setSheetTopMargin(this.blMapsConstraintLayout.getMeasuredHeight() + layoutParams.bottomMargin + layoutParams.topMargin);
    }

    public void setPlaceAutocompleteAdapterBounds(LatLng location) {
        this.blPlaceAutocompleteAdapter.setBounds(new LatLngBounds(location, location));
    }

    public void setupFilterList(List<BLFilter> filters) {
        if (this.filterTagsList == null) {
            setupFilterTagListView();
        }
        this.filterTagsList.setupFilterList(filters, this);
    }

    public void blAutoCompleteTextViewClearFocus() {
        BLAutoCompleteTextView bLAutoCompleteTextView = this.blAutoCompleteTextView;
        if (bLAutoCompleteTextView != null) {
            bLAutoCompleteTextView.clearFocus();
        }
    }

    public void blAutoCompleteTextViewSetText(String s) {
        BLAutoCompleteTextView bLAutoCompleteTextView = this.blAutoCompleteTextView;
        if (bLAutoCompleteTextView != null) {
            bLAutoCompleteTextView.setText(s);
        }
    }

    public void toggleSearchAreaIcon(int visibility) {
        AppCompatImageView appCompatImageView = this.blSearchArea;
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(visibility);
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.branchlocator.BLMapsLogicActivity] */
    public void setupPlaceAutocompleteAdapter(PlacesClient placesClient) {
        this.blPlaceAutocompleteAdapter = new BLPlaceAutocompleteAdapter(this, placesClient, BLConstants.PLACES_LAT_LNG_BOUNDS);
        if (this.blAutoCompleteTextView == null) {
            return;
        }
        if (BLUtils.isUseGooglePlaces()) {
            this.blAutoCompleteTextView.setupAutoCompleteAdapter(this.blPlaceAutocompleteAdapter);
        } else {
            this.blAutoCompleteTextView.setupAutocompleteAdapter(new BLGeocoderAutocompleteAdapter(this));
        }
    }

    public void onLoadedPOIS(boolean success) {
        this.isPOISLoaded = success;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.branchlocator.BLMapsLogicActivity] */
    public void callOnItemClick(POIListItem poiListItem) {
        if (this.isPOISLoaded) {
            this.viewPager.setCurrentItem(0);
            BLPoi blPoi = this.BLMapTabFragment.findBLPoi(poiListItem);
            List<BLPoi> listPois = new ArrayList<>();
            listPois.add(blPoi);
            this.BLMapTabFragment.selectNearestMarker(listPois);
            return;
        }
        Toast.makeText(this, R.string.loading, 1).show();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.branchlocator.BLMapsLogicActivity] */
    /* access modifiers changed from: private */
    public void searchFromAutocomplete(String address) {
        this.BLMapTabFragment.deselectCurrentMarker();
        LatLng newLocation = BLMapUtils.searchLocationFromString((Context) this, address);
        if (newLocation != null) {
            this.BLMapTabFragment.setSearchFromSearch(true);
            this.BLMapTabFragment.setLocationFromSearch(newLocation);
            this.blSearchArea.setVisibility(8);
            BLUtils.getAnalytcsTag(this, "searched_in_search_bar");
            this.BLMapTabFragment.getAllPOI(newLocation);
            return;
        }
        BLUtils.showCustomToast(this, getString(R.string.bl_toast_no_results) + "\"" + address + "\"");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [es.santander.branchlocator.BLMapsLogicActivity, android.app.Activity] */
    private void initPermissionCheck() {
        try {
            if (!BLPermissionCheckHelper.hasPermission(this, "android.permission.ACCESS_FINE_LOCATION")) {
                BLPermissionCheckHelper.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
            } else {
                setPermissionOK();
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [es.santander.branchlocator.BLMapsLogicActivity, android.app.Activity] */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (BLPermissionCheckHelper.hasPermission(this, "android.permission.ACCESS_FINE_LOCATION")) {
            setPermissionOK();
        } else {
            Log.i("GPS", "finish aquí se cierra");
        }
    }

    private void setPermissionOK() {
        this.isPermissionOK = true;
        this.BLMapTabFragment.getLocationAndDoRequest();
    }
}
