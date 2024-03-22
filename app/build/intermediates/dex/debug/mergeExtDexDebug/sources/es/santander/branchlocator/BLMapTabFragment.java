package es.santander.branchlocator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.graphics.PorterDuff;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import es.santander.branchlocator.BLBottomSheetBehavior;
import es.santander.branchlocator.BLLocationService;
import es.santander.branchlocator.common.AnalyticsComponentHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class BLMapTabFragment extends BLBaseFragment implements OnMapReadyCallback, GoogleMap.OnCameraIdleListener, GoogleApiClient.OnConnectionFailedListener, Observer {
    private static final int GPS_REQUEST = 1000;
    private static final String TAG = "MapTab";
    private final int ACCESS_FINE_LOCATION_PERMISSION = GPS_REQUEST;
    private final int ACCESS_FINE_LOCATION_PERMISSION_BUTTON = 1001;
    private BLFontManager BLFontManager;
    /* access modifiers changed from: private */
    public ConstraintLayout basicInfoBox;
    private int basicInfoSize;
    /* access modifiers changed from: private */
    public BLMapsListener blMapsListener;
    private List<BLPoi> blPois;
    /* access modifiers changed from: private */
    public RelativeLayout btnGps;
    private ClusterManager clusterManager;
    private ConstraintLayout constraintLayout;
    /* access modifiers changed from: private */
    public long coolDownPressTime = 0;
    /* access modifiers changed from: private */
    public BLPoi currentBlPoi;
    public LatLng currentLocation = null;
    private AlertDialog enableAirplaneModeDialogInfo;
    private boolean firstTimeActivatedGPS = true;
    private boolean firstTimeMarker = true;
    private boolean firstTimeRequest = true;
    private View fragmentView;
    private ImageView imgGps;
    /* access modifiers changed from: private */
    public BLMapTabInfo info;
    private boolean isFirstSelection = true;
    /* access modifiers changed from: private */
    public boolean isGpsOn = false;
    private boolean isNetworkOn = false;
    /* access modifiers changed from: private */
    public ConstraintLayout llTest;
    private LatLng locationFromFilters = null;
    private LatLng locationFromSearch = null;
    private Marker mainMarker;
    /* access modifiers changed from: private */
    public GoogleMap map;
    private BLMapFragment mapFragment;
    /* access modifiers changed from: private */
    public int mapHeight;
    /* access modifiers changed from: private */
    public int mapWidth;
    private AlertDialog networkOfflineDialogInfo;
    /* access modifiers changed from: private */
    public LinearLayout peekBox;
    private PlacesClient placesClient;
    private boolean searchFromFilters = false;
    private boolean searchFromRefreshButton = false;
    private boolean searchFromSearch = false;
    /* access modifiers changed from: private */
    public BLBottomSheetBehavior sheetBehavior;
    private int sheetTopMargin;
    private boolean shouldCheckNetwork = false;
    /* access modifiers changed from: private */
    public BLTextView txtClosestResult;
    private LinearLayout viewPagerContainer;
    private BLMapsViewModel viewmodel;
    /* access modifiers changed from: private */
    public boolean wasExpanded = false;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map_tab_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.fragmentView = view;
        this.viewmodel = ViewModelProviders.of(this).get(BLMapsViewModel.class);
        this.viewmodel.setRepository(new BLRepository(BLRetrofitClient.getInstance().getBranchService(getContext())));
        this.viewmodel.getPointsOfInterestLiveData().observe(this, new androidx.lifecycle.Observer<List<BLPoi>>() {
            public void onChanged(List<BLPoi> blPois) {
                if (blPois != null) {
                    BLMapTabFragment.this.setupClusterer(blPois);
                    BLMapTabFragment.this.checkResponseLogic(blPois);
                    BLMapTabFragment.this.setBlPois(blPois);
                    BLMapTabFragment.this.blMapsListener.onLoadedPOIS(true);
                }
            }
        });
        setupUi();
        if (Build.VERSION.SDK_INT >= 23) {
            checkFirstLocationPermision();
        } else {
            startMapLogic();
        }
    }

    public void onResume() {
        super.onResume();
        BLBottomSheetBehavior bLBottomSheetBehavior = this.sheetBehavior;
        if (!(bLBottomSheetBehavior == null || bLBottomSheetBehavior.getState() == 4 || !getUserVisibleHint())) {
            Map<String, String> viewDataLayer = new HashMap<>(1);
            viewDataLayer.put("ScreenName", "branch locator:home");
            AnalyticsComponentHelper.trackView("branch locator:home", viewDataLayer);
        }
        BLBottomSheetBehavior bLBottomSheetBehavior2 = this.sheetBehavior;
        if (bLBottomSheetBehavior2 != null && bLBottomSheetBehavior2.getState() == 4 && getUserVisibleHint()) {
            Map<String, String> viewDataLayer2 = new HashMap<>(1);
            viewDataLayer2.put("ScreenName", "branch locator:branch detail");
            AnalyticsComponentHelper.trackView("branch locator:branch detail", viewDataLayer2);
        }
        this.shouldCheckNetwork = false;
        this.blMapsListener.toggleSearchAreaIcon(8);
        checkFilters();
        setupGooglePlaces();
    }

    public void onPause() {
        if (this.placesClient != null) {
            this.placesClient = null;
        }
        super.onPause();
    }

    private void checkFilters() {
        List<BLFilter> filters = getSavedFilters();
        if (filters != null) {
            this.blMapsListener.setupFilterList(filters);
        }
        if (filters != null && filters.size() > 0) {
            this.searchFromFilters = true;
        }
    }

    public void doActivityResult(int requestCode, int resultCode) {
        if (resultCode == -1 && requestCode == 2001) {
            this.searchFromFilters = true;
            this.blMapsListener.toggleSearchAreaIcon(8);
            LatLng latLng = this.locationFromSearch;
            if (latLng != null) {
                getAllPOI(latLng);
            } else {
                LatLng latLng2 = this.locationFromFilters;
                if (latLng2 != null) {
                    getAllPOI(latLng2);
                } else {
                    getAllPOI(this.currentLocation);
                }
            }
            deselectCurrentMarker();
        } else if (requestCode == GPS_REQUEST) {
            this.firstTimeActivatedGPS = true;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    BLMapTabFragment bLMapTabFragment = BLMapTabFragment.this;
                    boolean unused = bLMapTabFragment.isGpsOn = BLUtils.checkIfGpsIsOn(bLMapTabFragment.getContext());
                    if (!BLMapTabFragment.this.isGpsOn) {
                        Log.i("GPS", "Finish");
                        BLMapTabFragment.this.getActivity().finish();
                        return;
                    }
                    Log.i("GPS", "Start Map Logic");
                    BLMapTabFragment.this.startMapLogic();
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: private */
    public void setupClusterer(List<BLPoi> pointsOfInterest) {
        this.map.clear();
        this.clusterManager = new ClusterManager(getContext(), this.map);
        this.clusterManager.setRenderer(new BLClusterRenderer(getActivity(), this.map, this.clusterManager));
        this.clusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener() {
            public boolean onClusterItemClick(ClusterItem clusterItem) {
                BLPoi unused = BLMapTabFragment.this.currentBlPoi = (BLPoi) clusterItem;
                Map<String, String> dataLayer = new HashMap<>(1);
                dataLayer.put("ScreenName", "branch locator:home");
                dataLayer.put("BranchAtmName", BLUtils.capitalizeAllString(BLMapTabFragment.this.currentBlPoi.getLocation().getCity()));
                dataLayer.put("BranchAtmType", BLMapTabFragment.this.currentBlPoi.getObjectType().getCode().toLowerCase());
                dataLayer.put("EventAction", "tap branch icon");
                AnalyticsComponentHelper.trackEvent("tap branch icon", dataLayer);
                BLMapTabFragment.this.txtClosestResult.setVisibility(8);
                BLMapTabFragment.this.doShowBasicInfo((BLPoi) clusterItem);
                return false;
            }
        });
        this.map.setOnCameraIdleListener(this);
        this.map.setOnMarkerClickListener(this.clusterManager);
        this.clusterManager.addItems(pointsOfInterest);
        this.clusterManager.cluster();
    }

    /* access modifiers changed from: private */
    public void checkResponseLogic(List<BLPoi> pois) {
        if (pois.size() == 0) {
            if (this.searchFromFilters) {
                BLUtils.showCustomToast(getContext(), getString(R.string.bl_toast_filter_no_results));
            }
        } else if (this.firstTimeMarker) {
            selectNearestMarker(pois);
            this.firstTimeMarker = false;
        } else {
            if (!this.searchFromRefreshButton) {
                makeZoomLogic(pois);
            }
            if (!BLMapUtils.poisInVisibleMap(pois, this.map.getProjection())) {
                if (this.searchFromRefreshButton) {
                    BLUtils.showCustomToast(getContext(), getString(R.string.bl_toast_no_poi_area));
                }
                if (pois.size() > 0) {
                    if (this.searchFromFilters) {
                        BLUtils.showCustomToast(getContext(), getString(R.string.bl_toast_filter_results_nearest));
                    }
                    if (this.searchFromSearch) {
                        BLUtils.showCustomToast(getContext(), getString(R.string.bl_toast_closest_search));
                    }
                }
            } else if (this.searchFromFilters) {
                BLUtils.showCustomToast(getContext(), getString(R.string.bl_toast_filter_apply));
            }
        }
        this.searchFromSearch = false;
        this.searchFromFilters = false;
        this.searchFromRefreshButton = false;
    }

    private void makeZoomLogic(List<BLPoi> pointsOfInterest) {
        LatLng latLng = this.locationFromSearch;
        if (latLng != null) {
            makeZoomWithMarkers(pointsOfInterest, latLng, 3);
            this.mainMarker = this.map.addMarker(new MarkerOptions().position(this.locationFromSearch).icon(BitmapDescriptorFactory.fromResource(R.drawable.reference_point)));
            return;
        }
        LatLng latLng2 = this.locationFromFilters;
        if (latLng2 != null) {
            makeZoomWithMarkers(pointsOfInterest, latLng2, 3);
        } else {
            makeZoomWithMarkers(pointsOfInterest, this.currentLocation, 3);
        }
    }

    private void makeZoomWithMarkers(List<BLPoi> pois, LatLng location, int markersToZoom) {
        List<LatLng> locations = new ArrayList<>();
        if (markersToZoom > pois.size()) {
            markersToZoom = pois.size();
        }
        for (int i = 0; i < markersToZoom; i++) {
            if (pois.get(i) != null) {
                locations.add(pois.get(i).getPosition());
            }
        }
        if (location != null) {
            locations.add(location);
        }
        setupZoomWithBounds(locations);
    }

    private void setupZoomWithBounds(List<LatLng> locations) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng location : locations) {
            builder.include(location);
        }
        LatLngBounds bounds = builder.build();
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (((double) width) * 0.25d);
        int i = this.mapWidth;
        if (i <= 0) {
            i = width;
        }
        int i2 = this.mapHeight;
        if (i2 <= 0) {
            i2 = height;
        }
        this.map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, i, i2, padding));
    }

    public void selectNearestMarker(List<BLPoi> pois) {
        if (pois != null && pois.size() >= 1) {
            BLPoi nearestPOI = pois.get(0);
            nearestPOI.setToBeSelected(true);
            moveAndSelectPOI(nearestPOI);
            makeZoomWithMarkesAndBasicInfo(pois, nearestPOI.getLatLng(), 1);
        }
    }

    private void makeZoomWithMarkesAndBasicInfo(List<BLPoi> pois, LatLng location, int markersToZoom) {
        if (markersToZoom > pois.size()) {
            markersToZoom = pois.size();
        }
        List<LatLng> locations = new ArrayList<>();
        if (markersToZoom > pois.size()) {
            markersToZoom = pois.size();
        }
        for (int i = 0; i < markersToZoom; i++) {
            if (pois.get(i) != null) {
                locations.add(pois.get(i).getPosition());
            }
        }
        if (location != null) {
            locations.add(location);
        }
        setupZoomWithBoundsAndBasicInfo(locations);
    }

    private void setupZoomWithBoundsAndBasicInfo(List<LatLng> locations) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng location : locations) {
            builder.include(location);
        }
        LatLngBounds bounds = builder.build();
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        int padding = (int) (((double) width) * 0.15d);
        this.map.setPadding(padding, padding, padding, (int) (((double) this.basicInfoSize) * 0.75d));
        int i = this.mapWidth;
        if (i <= 0) {
            i = width;
        }
        int i2 = this.mapHeight;
        if (i2 <= 0) {
            i2 = height;
        }
        this.map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, i, i2, 0));
        this.map.setPadding(0, 0, 0, 0);
    }

    private void setupUi() {
        this.BLFontManager = new BLFontManager(this.fragmentView.getContext());
        BLTextView bLTextView = (BLTextView) this.fragmentView.findViewById(R.id.txt_closest_result);
        this.txtClosestResult = bLTextView;
        this.BLFontManager.inserTypeFont(bLTextView, BLConstants.BOLD_FONT);
        this.constraintLayout = this.fragmentView.findViewById(R.id.lyTest);
        this.basicInfoBox = this.fragmentView.findViewById(R.id.rlTest1);
        this.peekBox = (LinearLayout) this.fragmentView.findViewById(R.id.ll_peek);
        this.imgGps = (ImageView) this.fragmentView.findViewById(R.id.btn_gps_activt);
        RelativeLayout relativeLayout = (RelativeLayout) this.fragmentView.findViewById(R.id.btn_gps);
        this.btnGps = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BLUtils.hideSoftKeyboard(BLMapTabFragment.this.getActivity());
                if (SystemClock.elapsedRealtime() - BLMapTabFragment.this.coolDownPressTime >= 500) {
                    long unused = BLMapTabFragment.this.coolDownPressTime = SystemClock.elapsedRealtime();
                    if (BLMapTabFragment.this.isGpsOn && BLMapTabFragment.this.map != null) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            BLMapTabFragment.this.checkLocationButtonPermisions();
                        } else {
                            BLMapTabFragment.this.doMyLocation();
                        }
                    }
                }
            }
        });
        this.viewPagerContainer = (LinearLayout) this.fragmentView.findViewById(R.id.viewPagerContainer);
        this.llTest = this.fragmentView.findViewById(R.id.lyTest);
    }

    private void checkFirstLocationPermision() {
        if (!BLPermissionCheckHelper.hasPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
            startMapLogic();
            return;
        }
        getLocation();
        startMapLogic();
    }

    /* access modifiers changed from: private */
    public void startMapLogic() {
        this.isGpsOn = BLUtils.checkIfGpsIsOn(getContext());
        this.isNetworkOn = BLUtils.checkIfNetworkIsOn(getContext());
        displayLocationSettingsRequest(getActivity());
        BLObservableObject.getInstance().addObserver(this);
        setGPSButtonColor(this.isGpsOn);
        this.mapFragment = new BLMapFragment();
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.add(R.id.map, this.mapFragment);
        ft.commit();
        this.mapFragment.getMapAsync(this);
    }

    /* access modifiers changed from: private */
    public void checkLocationButtonPermisions() {
        if (!BLPermissionCheckHelper.hasPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
            BLPermissionCheckHelper.requestPermissions(getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
        } else {
            doMyLocation();
        }
    }

    /* access modifiers changed from: private */
    public void doMyLocation() {
        if (this.currentLocation != null) {
            this.locationFromSearch = null;
            this.locationFromFilters = null;
            this.blMapsListener.toggleSearchAreaIcon(8);
            this.blMapsListener.blAutoCompleteTextViewSetText("");
            BLUtils.getAnalytcsTag(getActivity(), "back_to_user_location");
            if (this.currentLocation != null) {
                if (this.map.getCameraPosition().zoom < 12.0f) {
                    this.map.animateCamera(CameraUpdateFactory.newLatLngZoom(this.currentLocation, 12.0f));
                } else {
                    this.map.animateCamera(CameraUpdateFactory.newLatLng(this.currentLocation));
                }
                deselectCurrentMarker();
                getAllPOI(this.currentLocation);
            }
        }
        getLocation();
    }

    public void deselectCurrentMarker() {
        hideBasicInfo();
        ClusterManager clusterManager2 = this.clusterManager;
        if (clusterManager2 != null && clusterManager2.getRenderer() != null) {
            ((BLClusterRenderer) this.clusterManager.getRenderer()).deselectMarker();
        }
    }

    private void hideBasicInfo() {
        BLBottomSheetBehavior bLBottomSheetBehavior = this.sheetBehavior;
        if (bLBottomSheetBehavior != null) {
            bLBottomSheetBehavior.setState(6);
        }
    }

    public void getAllPOI(LatLng location) {
        if (location != null) {
            this.firstTimeActivatedGPS = true;
            this.firstTimeRequest = false;
            this.viewmodel.onGetPOI(BLUtils.generateCoordsForRequest(location.latitude, location.longitude), BLConstants.ES_COUNTRY_CODE, "false", getSavedFilters());
        }
    }

    public void getLocation() {
        getExactLocation((BLOnGetLocation) null);
    }

    private void getExactLocation(final BLOnGetLocation BLOnGetLocation) {
        new BLLocationService().getLocation(getActivity(), new BLLocationService.LocationResult() {
            public void gotLocation(Location location) {
                if (location != null) {
                    BLMapTabFragment.this.currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                    BLMapTabFragment bLMapTabFragment = BLMapTabFragment.this;
                    bLMapTabFragment.setupEndpoint(bLMapTabFragment.currentLocation);
                    BLOnGetLocation bLOnGetLocation = BLOnGetLocation;
                    if (bLOnGetLocation != null) {
                        bLOnGetLocation.onGetLocation(new LatLng(location.getLatitude(), location.getLongitude()));
                        return;
                    }
                    return;
                }
                BLOnGetLocation bLOnGetLocation2 = BLOnGetLocation;
                if (bLOnGetLocation2 != null) {
                    bLOnGetLocation2.onGetLocation((LatLng) null);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void setupEndpoint(LatLng currentLocation2) {
        BLRetrofitClient retrofietClient = new BLRetrofitClient();
        if (BLMapUtils.distanceBetweenPoints(currentLocation2, BLConstants.LAT_LNG_EU) < BLMapUtils.distanceBetweenPoints(currentLocation2, BLConstants.LAT_LNG_NA)) {
            retrofietClient.setBaseURL(BuildConfig.BASE_URL_EU);
        } else {
            retrofietClient.setBaseURL(BuildConfig.BASE_URL_NA);
        }
        this.viewmodel.setRepository(new BLRepository(retrofietClient.getBranchService(getContext())));
    }

    public void getLocation(BLOnGetLocation BLOnGetLocation) {
        BLUtils.showCustomToast(getActivity(), getString(R.string.bl_toast_getting_position));
        getExactLocation(BLOnGetLocation);
    }

    private List<BLFilter> getSavedFilters() {
        return BLPreferencesManager.getInstance(getActivity()).getFilterData();
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public void onCameraIdle() {
        this.clusterManager.onCameraIdle();
    }

    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;
        DataRepository.getInstance().setMap(this.map);
        if (this.map != null) {
            this.blMapsListener.doSetupUi();
            setupMapSettings();
            setupGooglePlaces();
            setupFirstCall();
            setupBasicInformation();
            this.mapFragment.mTouchView.setAlpha(1.0f);
            final View view = this.mapFragment.getView();
            view.post(new Runnable() {
                public void run() {
                    int unused = BLMapTabFragment.this.mapWidth = view.getMeasuredWidth();
                    int unused2 = BLMapTabFragment.this.mapHeight = view.getMeasuredHeight();
                }
            });
        }
    }

    public void update(Observable observable, Object data) {
        List<BLPoi> list;
        BLConnectionObject blConnectionObject = (BLConnectionObject) data;
        if (blConnectionObject.getType().equals("gps") && isAdded()) {
            boolean enabled = blConnectionObject.getEnabled();
            this.isGpsOn = enabled;
            setGPSButtonColor(enabled);
            if (this.isGpsOn) {
                if (this.firstTimeRequest) {
                    setupFirstCall();
                } else {
                    selectNearestMarker(this.blPois);
                }
            } else if (this.firstTimeActivatedGPS) {
                displayLocationSettingsRequest(getActivity());
            }
        } else if (!blConnectionObject.getType().equals("internet") || !isAdded()) {
            blConnectionObject.getType().equals("wifi");
        } else {
            boolean enabled2 = blConnectionObject.getEnabled();
            this.isNetworkOn = enabled2;
            if (enabled2) {
                if (blConnectionObject.getStatus()) {
                    if (this.shouldCheckNetwork && (list = this.blPois) != null) {
                        selectNearestMarker(list);
                    }
                } else if (getContext() != null) {
                    BLUtils.showAlertDialog(getContext(), getContext().getString(R.string.bl_network_info), getContext().getString(R.string.bl_network_offline));
                }
            } else if (getContext() != null) {
                if (BLUtils.isAirplaneModeOn(getContext())) {
                    AlertDialog alertDialog = this.enableAirplaneModeDialogInfo;
                    if (alertDialog == null) {
                        setupNoConnectionForAirplaneModeOnDialogInfo();
                        this.enableAirplaneModeDialogInfo.show();
                    } else if (alertDialog != null && !alertDialog.isShowing()) {
                        this.enableAirplaneModeDialogInfo.show();
                    }
                } else if (this.isGpsOn) {
                    AlertDialog alertDialog2 = this.networkOfflineDialogInfo;
                    if (alertDialog2 == null) {
                        setupNetworkOfflineDialogInfo();
                        this.networkOfflineDialogInfo.show();
                    } else if (alertDialog2 != null && !alertDialog2.isShowing()) {
                        this.networkOfflineDialogInfo.show();
                    }
                }
            }
            this.shouldCheckNetwork = true;
        }
    }

    private void setupNoConnectionForAirplaneModeOnDialogInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getContext().getString(R.string.bl_network_info)).setMessage(getContext().getString(R.string.bl_network_offline)).setNeutralButton("OK", (DialogInterface.OnClickListener) null);
        this.enableAirplaneModeDialogInfo = builder.create();
    }

    private void setupNetworkOfflineDialogInfo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getContext().getString(R.string.bl_network_info)).setMessage(getContext().getString(R.string.bl_network_offline_try_again)).setNeutralButton("OK", (DialogInterface.OnClickListener) null);
        this.networkOfflineDialogInfo = builder.create();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == GPS_REQUEST) {
            if (grantResults.length <= 0 || grantResults[0] != 0) {
                this.btnGps.setVisibility(8);
                BLUtils.showNoLocationDialog(getContext());
                return;
            }
            getLocationAndDoRequest();
            this.map.setMyLocationEnabled(true);
            this.btnGps.setVisibility(0);
        } else if (requestCode != 1001) {
        } else {
            if (grantResults.length <= 0 || grantResults[0] != 0) {
                this.btnGps.setVisibility(8);
                BLUtils.showNoLocationDialog(getContext());
                return;
            }
            doMyLocation();
            this.map.setMyLocationEnabled(true);
            this.btnGps.setVisibility(0);
        }
    }

    public void displayLocationSettingsRequest(final Activity activity) {
        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(activity).addApi(LocationServices.API).build();
        googleApiClient.connect();
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(100);
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);
        this.firstTimeActivatedGPS = false;
        LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build()).setResultCallback(new ResultCallback<LocationSettingsResult>() {
            public void onResult(LocationSettingsResult result) {
                Status status = result.getStatus();
                if (status.getStatusCode() == 6) {
                    try {
                        status.startResolutionForResult(activity, BLMapTabFragment.GPS_REQUEST);
                    } catch (IntentSender.SendIntentException e) {
                    }
                }
            }
        });
    }

    private void setGPSButtonColor(boolean gps) {
        if (gps) {
            this.imgGps.setColorFilter(ContextCompat.getColor(getContext(), R.color.grey), PorterDuff.Mode.SRC_IN);
        } else {
            this.imgGps.setColorFilter(ContextCompat.getColor(getContext(), R.color.light_grey), PorterDuff.Mode.SRC_IN);
        }
    }

    private void setupMapSettings() {
        if (Build.VERSION.SDK_INT >= 23) {
            checkMapLocationPermision();
        } else {
            this.map.setMyLocationEnabled(true);
        }
        this.map.getUiSettings().setAllGesturesEnabled(true);
        this.map.getUiSettings().setMyLocationButtonEnabled(false);
        this.map.getUiSettings().setMapToolbarEnabled(false);
        this.map.getUiSettings().setZoomGesturesEnabled(true);
        this.map.getUiSettings().setCompassEnabled(true);
        this.map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            public void onMapClick(LatLng latLng) {
                BLMapTabFragment.this.deselectCurrentMarker();
            }
        });
    }

    private void checkMapLocationPermision() {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            this.map.setMyLocationEnabled(true);
        }
    }

    private void setupGooglePlaces() {
        if (this.placesClient == null || !Places.isInitialized()) {
            Places.initialize(getContext().getApplicationContext(), getContext().getString(R.string.maps_api_key));
            this.placesClient = Places.createClient(getContext());
        }
        this.blMapsListener.setupPlaceAutocompleteAdapter(this.placesClient);
    }

    private void setupFirstCall() {
        LatLng latLng = this.currentLocation;
        if (latLng != null) {
            getAllPOI(latLng);
        } else if (Build.VERSION.SDK_INT >= 23) {
            checkExcatLocationPermission();
        } else {
            getLocationAndDoRequest();
        }
    }

    private void checkExcatLocationPermission() {
        if (!BLPermissionCheckHelper.hasPermission(getActivity(), "android.permission.ACCESS_FINE_LOCATION")) {
            BLPermissionCheckHelper.requestPermissions(getActivity(), new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 3);
        } else {
            getLocationAndDoRequest();
        }
    }

    public void getLocationAndDoRequest() {
        getLocation(new BLOnGetLocation() {
            public void onGetLocation(LatLng location) {
                if (location == null) {
                    BLMapTabFragment.this.getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            BLMapTabFragment.this.btnGps.setVisibility(8);
                            BLUtils.showNoLocationDialog(BLMapTabFragment.this.getActivity());
                        }
                    });
                    return;
                }
                BLMapTabFragment.this.btnGps.setVisibility(0);
                BLMapTabFragment.this.getAllPOI(location);
                BLMapTabFragment.this.blMapsListener.setPlaceAutocompleteAdapterBounds(location);
                BLConstants.PLACES_LAT_LNG_BOUNDS = new LatLngBounds(location, location);
                try {
                    BLMapTabFragment.this.map.animateCamera(CameraUpdateFactory.newLatLngZoom(BLMapTabFragment.this.currentLocation, 12.0f));
                } catch (Exception e) {
                    Log.e(BLMapTabFragment.TAG, e.toString());
                }
            }
        });
    }

    public void doSearchArea() {
        this.searchFromRefreshButton = true;
        this.locationFromSearch = null;
        this.locationFromFilters = null;
        BLUtils.getAnalytcsTag(getActivity(), "search_this_area");
        deselectCurrentMarker();
        getAllPOI(this.map.getCameraPosition().target);
    }

    private void setupBasicInformation() {
        BLBottomSheetBehavior from = BLBottomSheetBehavior.from(this.basicInfoBox);
        this.sheetBehavior = from;
        from.setState(6);
        this.sheetBehavior.setPeekHeight(this.basicInfoSize);
        this.basicInfoBox.setVisibility(0);
        this.sheetBehavior.setTopMargin((float) this.sheetTopMargin);
        this.sheetBehavior.addBottomSheetCallback(new BLBottomSheetBehavior.BottomSheetCallback() {
            public void onStateChanged(View view, int i) {
                view.requestLayout();
                if (i == 3) {
                    BLMapTabFragment.this.deselectCurrentMarker();
                    if (BLMapTabFragment.this.info != null && BLMapTabFragment.this.wasExpanded) {
                        boolean unused = BLMapTabFragment.this.wasExpanded = false;
                        BLMapTabFragment.this.info.showBranchAndAtmSection();
                    }
                } else if (i == 4) {
                    if (BLMapTabFragment.this.info != null) {
                        boolean unused2 = BLMapTabFragment.this.wasExpanded = true;
                        BLMapTabFragment.this.info.hideBranchAndAtmSection();
                        Map<String, String> viewDataLayer = new HashMap<>(1);
                        viewDataLayer.put("ScreenName", "branch locator:branch detail");
                        AnalyticsComponentHelper.trackView("branch locator:branch detail", viewDataLayer);
                    }
                    BLUtils.hideSoftKeyboard(BLMapTabFragment.this.getActivity());
                } else if (i != 5) {
                    if (i == 6) {
                        BLMapTabFragment.this.deselectCurrentMarker();
                        if (BLMapTabFragment.this.info != null && BLMapTabFragment.this.wasExpanded) {
                            Map<String, String> viewDataLayer2 = new HashMap<>(1);
                            viewDataLayer2.put("ScreenName", "branch locator:home");
                            AnalyticsComponentHelper.trackView("branch locator:home", viewDataLayer2);
                            boolean unused3 = BLMapTabFragment.this.wasExpanded = false;
                            BLMapTabFragment.this.info.showBranchAndAtmSection();
                        }
                    }
                } else if (BLMapTabFragment.this.info != null && BLMapTabFragment.this.wasExpanded) {
                    boolean unused4 = BLMapTabFragment.this.wasExpanded = false;
                    BLMapTabFragment.this.info.showBranchAndAtmSection();
                }
            }

            public void onSlide(View view, float v) {
            }
        });
        this.constraintLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Map<String, String> dataLayer = new HashMap<>(1);
                if (BLMapTabFragment.this.sheetBehavior.getState() == 4) {
                    dataLayer.put("ScreenName", "branch locator:branch detail");
                } else {
                    dataLayer.put("ScreenName", "branch locator:home");
                }
                dataLayer.put("BranchAtmName", BLUtils.capitalizeAllString(BLMapTabFragment.this.currentBlPoi.getLocation().getCity()));
                dataLayer.put("BranchAtmType", BLMapTabFragment.this.currentBlPoi.getObjectType().getCode().toLowerCase());
                dataLayer.put("EventAction", "tap branch detail");
                AnalyticsComponentHelper.trackEvent("tap branch detail", dataLayer);
                BLMapTabFragment.this.expandOrCollapseInformation();
            }
        });
    }

    /* access modifiers changed from: private */
    public void expandOrCollapseInformation() {
        if (this.sheetBehavior.getState() != 4) {
            this.sheetBehavior.setState(4);
        } else {
            this.sheetBehavior.setState(5);
        }
    }

    public void doUpdateMapAfterUserInteraction() {
        BLUtils.hideSoftKeyboard(getActivity());
        deselectCurrentMarker();
        BLMapsListener bLMapsListener = this.blMapsListener;
        if (bLMapsListener != null) {
            bLMapsListener.blAutoCompleteTextViewClearFocus();
            this.blMapsListener.toggleSearchAreaIcon(0);
        }
    }

    public void doUpdateSizeInfo() {
        this.basicInfoSize = this.constraintLayout.getHeight();
    }

    public void doShowBasicInfo(BLPoi blPoi) {
        if (this.sheetBehavior != null) {
            this.currentBlPoi = blPoi;
            this.blMapsListener.blAutoCompleteTextViewClearFocus();
            BLPreferencesManager.selectedBLPOI = blPoi;
            BLPreferencesManager.currentLocation = this.currentLocation;
            if (this.info == null) {
                this.info = new BLMapTabInfo(this.fragmentView, this);
            }
            this.info.showData();
            this.basicInfoBox.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    BLMapTabFragment.this.basicInfoBox.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    BLMapTabFragment.this.sheetBehavior.setPeekHeight(BLMapTabFragment.this.llTest.getMeasuredHeight() + 100);
                    BLMapTabFragment.this.sheetBehavior.setState(5);
                    BLMapTabFragment.this.peekBox.requestLayout();
                }
            });
            BLUtils.getAnalytcsTag(getContext(), "basic_info_shown");
        }
    }

    public BLBottomSheetBehavior getSheetBehavior() {
        return this.sheetBehavior;
    }

    public void setBlPois(List<BLPoi> blPois2) {
        this.blPois = blPois2;
    }

    public void moveAndSelectPOIFromList(POIListItem poiListItem) {
        moveAndSelectPOI(findBLPoi(poiListItem));
    }

    public void moveAndSelectPOI(BLPoi blPoi) {
        if (blPoi != null) {
            if (!this.isFirstSelection) {
                this.txtClosestResult.setVisibility(8);
            } else {
                this.isFirstSelection = false;
            }
            this.map.animateCamera(CameraUpdateFactory.newLatLngZoom(blPoi.getPosition(), 15.0f));
            ((BLClusterRenderer) this.clusterManager.getRenderer()).selectMarker(blPoi);
            doShowBasicInfo(blPoi);
        }
    }

    public BLPoi findBLPoi(POIListItem poiListItem) {
        BLPoi blPoiResult = null;
        if (poiListItem.id != null) {
            for (BLPoi blPoi : this.blPois) {
                if (blPoi.getId().equals(poiListItem.id)) {
                    blPoiResult = blPoi;
                }
            }
        }
        return blPoiResult;
    }

    public void setSheetTopMargin(int sheetTopMargin2) {
        this.sheetTopMargin = sheetTopMargin2;
    }

    public Marker getMainMarker() {
        return this.mainMarker;
    }

    public void setLocationFromSearch(LatLng locationFromSearch2) {
        this.locationFromSearch = locationFromSearch2;
    }

    public void setSearchFromSearch(boolean searchFromSearch2) {
        this.searchFromSearch = searchFromSearch2;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.blMapsListener = (BLMapsListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement BLMapsListener");
        }
    }
}
