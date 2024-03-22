package es.santander.branchlocator;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import es.santander.branchlocator.common.AnalyticsComponentHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BLMapTabInfo {
    private static final String TAG = "MapTabInfo";
    private BLAtmDetailedInformationFragment BLAtmDetailedInformationFragment;
    private BLBranchDetailedInformationFragment BLBranchDetailedInformationFragment;
    private boolean blockLyWhenBranch;
    /* access modifiers changed from: private */
    public BLTextView btnMakeAppointment;
    private ConstraintLayout btnOpenMaps;
    /* access modifiers changed from: private */
    public Context context;
    private Fragment fragment;
    /* access modifiers changed from: private */
    public boolean isSheetExpanded = false;
    private LinearLayout lyWhenBranch;
    private NestedScrollView nestedScrollView;
    /* access modifiers changed from: private */
    public BLPoi poi;
    private View separatorView;
    /* access modifiers changed from: private */
    public TabLayout tabLayout;
    private List timeSchedule;
    private BLTextView txtAtm;
    private BLTextView txtBasicInfoAddressText;
    private BLTextView txtBasicInfoDistance;
    private BLTextView txtBranch;
    private BLTextView txtNameOffice;
    private BLTextView txtSubtype;
    private BLTextView txtWorkingAtm;
    private BLTextView txtWorkingBranch;
    private View view;
    private BLViewPager vpPager;

    BLMapTabInfo(View view2, Fragment fragment2) {
        this.view = view2;
        this.fragment = fragment2;
        if (fragment2 != null) {
            this.context = fragment2.getContext();
        }
        setupUi();
        setupViewPager();
    }

    /* access modifiers changed from: package-private */
    public void showData() {
        setupListeners();
        BLPoi bLPoi = BLPreferencesManager.selectedBLPOI;
        this.poi = bLPoi;
        setupBasicInfoUi(bLPoi);
        this.txtBasicInfoDistance.setText(BLUtils.getDistanceWithUser(this.context, BLPreferencesManager.currentLocation, this.poi.getLatLng()));
        checkBranch(this.poi);
        poiState(this.poi);
    }

    private void setupUi() {
        this.txtNameOffice = (BLTextView) this.view.findViewById(R.id.txt_name_office);
        this.txtSubtype = (BLTextView) this.view.findViewById(R.id.txt_subtype_office);
        this.txtBasicInfoAddressText = (BLTextView) this.view.findViewById(R.id.basic_info_address_text);
        this.txtBasicInfoDistance = (BLTextView) this.view.findViewById(R.id.basic_info_distance);
        this.btnOpenMaps = this.view.findViewById(R.id.btn_open_maps);
        this.vpPager = (BLViewPager) this.view.findViewById(R.id.viewpager);
        this.tabLayout = (TabLayout) this.view.findViewById(R.id.view_pager_tab);
        this.txtBranch = (BLTextView) this.view.findViewById(R.id.txt_office);
        this.txtAtm = (BLTextView) this.view.findViewById(R.id.txt_atm);
        this.txtWorkingBranch = (BLTextView) this.view.findViewById(R.id.txt_working_branch);
        this.txtWorkingAtm = (BLTextView) this.view.findViewById(R.id.txt_working_atm);
        this.lyWhenBranch = (LinearLayout) this.view.findViewById(R.id.ly_when_branch);
        this.nestedScrollView = this.view.findViewById(R.id.ns_info_popup);
        this.btnMakeAppointment = (BLTextView) this.view.findViewById(R.id.bl_bt_appointment);
        this.separatorView = this.view.findViewById(R.id.separator);
    }

    private void setupListeners() {
        this.btnOpenMaps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Map<String, String> dataLayer = new HashMap<>(1);
                if (BLMapTabInfo.this.isSheetExpanded) {
                    dataLayer.put("OpenMapOrigin", "branch detail");
                    dataLayer.put("ScreenName", "branch locator:branch detail");
                } else {
                    dataLayer.put("OpenMapOrigin", "home");
                    dataLayer.put("ScreenName", "branch locator:home");
                }
                dataLayer.put("BranchAtmName", BLUtils.capitalizeAllString(BLMapTabInfo.this.poi.getLocation().getCity()));
                dataLayer.put("BranchAtmType", BLMapTabInfo.this.poi.getObjectType().getCode().toLowerCase());
                dataLayer.put("EventAction", "tap open map");
                AnalyticsComponentHelper.trackEvent("tap open map", dataLayer);
                BLUtils.openGoogleMaps(BLMapTabInfo.this.poi.getLatLng(), BLMapTabInfo.this.context);
            }
        });
        this.btnMakeAppointment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (BLMapTabInfo.this.poi.appointment().getBranchAppointment() != null) {
                    BLUtils.getAnalytcsTag(BLMapTabInfo.this.context, "make_appointment");
                    BLMapTabInfo.this.btnMakeAppointment.setVisibility(0);
                    BLMapTabInfo.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BLMapTabInfo.this.poi.appointment().getBranchAppointment())));
                    return;
                }
                BLMapTabInfo.this.btnMakeAppointment.setVisibility(8);
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e9 A[Catch:{ Exception -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ef A[Catch:{ Exception -> 0x00f5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setupBasicInfoUi(es.santander.branchlocator.BLPoi r10) {
        /*
            r9 = this;
            es.santander.branchlocator.BLPoiType r0 = r10.getObjectType()
            es.santander.branchlocator.BLPoiType r1 = r10.getSubType()
            es.santander.branchlocator.BLPoiType r2 = r10.getSpecialType()
            es.santander.branchlocator.BLTextView r3 = r9.txtSubtype
            r4 = 0
            r3.setVisibility(r4)
            java.lang.String r3 = r0.getCode()
            java.lang.String r3 = r3.toLowerCase()
            int r5 = r3.hashCode()
            r6 = -1381030494(0xffffffffadaf25a2, float:-1.9911909E-11)
            r7 = 1
            if (r5 == r6) goto L_0x0034
            r6 = 96922(0x17a9a, float:1.35817E-40)
            if (r5 == r6) goto L_0x002a
        L_0x0029:
            goto L_0x003e
        L_0x002a:
            java.lang.String r5 = "atm"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0029
            r3 = r4
            goto L_0x003f
        L_0x0034:
            java.lang.String r5 = "branch"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0029
            r3 = r7
            goto L_0x003f
        L_0x003e:
            r3 = -1
        L_0x003f:
            r5 = 8
            if (r3 == 0) goto L_0x004b
            if (r3 == r7) goto L_0x004b
            android.widget.LinearLayout r3 = r9.lyWhenBranch
            r3.setVisibility(r5)
            goto L_0x006f
        L_0x004b:
            android.widget.LinearLayout r3 = r9.lyWhenBranch
            r3.setVisibility(r4)
            if (r1 == 0) goto L_0x0062
            es.santander.branchlocator.BLTextView r3 = r9.txtSubtype
            android.content.Context r6 = r9.context
            java.lang.String r6 = r1.getTranslationString(r6)
            java.lang.String r6 = es.santander.branchlocator.BLUtils.capitalizeAllString(r6)
            r3.setText(r6)
            goto L_0x006f
        L_0x0062:
            es.santander.branchlocator.BLTextView r3 = r9.txtSubtype
            java.lang.String r6 = ""
            r3.setText(r6)
            es.santander.branchlocator.BLTextView r3 = r9.txtSubtype
            r3.setVisibility(r5)
        L_0x006f:
            es.santander.branchlocator.BLPoiType r3 = r10.getObjectType()
            java.lang.String r3 = r3.getCode()
            es.santander.branchlocator.BLLocation r6 = r10.getLocation()
            java.lang.String r6 = r6.getCity()
            java.lang.String r3 = r9.buildItemListTitle(r3, r6)
            es.santander.branchlocator.BLTextView r6 = r9.txtNameOffice
            java.lang.String r7 = es.santander.branchlocator.BLUtils.capitalizeAllString(r3)
            r6.setText(r7)
            es.santander.branchlocator.BLLocation r6 = r10.getLocation()
            if (r6 == 0) goto L_0x00df
            es.santander.branchlocator.BLLocation r6 = r10.getLocation()
            java.lang.String r6 = r6.getAddress()
            if (r6 == 0) goto L_0x00df
            es.santander.branchlocator.BLLocation r6 = r10.getLocation()
            java.lang.String r6 = r6.getAddress()
            es.santander.branchlocator.BLTextView r7 = r9.txtBasicInfoAddressText
            java.lang.String r8 = es.santander.branchlocator.BLUtils.capitalizeAllString(r6)
            r7.setText(r8)
            es.santander.branchlocator.BLLocation r7 = r10.getLocation()
            java.lang.String r7 = r7.getCity()
            if (r7 == 0) goto L_0x00df
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r7 = r7.append(r6)
            java.lang.String r8 = ", "
            java.lang.StringBuilder r7 = r7.append(r8)
            es.santander.branchlocator.BLLocation r8 = r10.getLocation()
            java.lang.String r8 = r8.getCity()
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r6 = r7.toString()
            es.santander.branchlocator.BLTextView r7 = r9.txtBasicInfoAddressText
            java.lang.String r8 = es.santander.branchlocator.BLUtils.capitalizeAllString(r6)
            r7.setText(r8)
        L_0x00df:
            es.santander.branchlocator.BLPoi$Appointment r6 = r10.appointment()     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r6 = r6.getBranchAppointment()     // Catch:{ Exception -> 0x00f5 }
            if (r6 != 0) goto L_0x00ef
            es.santander.branchlocator.BLTextView r4 = r9.btnMakeAppointment     // Catch:{ Exception -> 0x00f5 }
            r4.setVisibility(r5)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x00f4
        L_0x00ef:
            es.santander.branchlocator.BLTextView r6 = r9.btnMakeAppointment     // Catch:{ Exception -> 0x00f5 }
            r6.setVisibility(r4)     // Catch:{ Exception -> 0x00f5 }
        L_0x00f4:
            goto L_0x0104
        L_0x00f5:
            r4 = move-exception
            java.lang.String r6 = r4.toString()
            java.lang.String r7 = "MapTabInfo"
            android.util.Log.e(r7, r6)
            es.santander.branchlocator.BLTextView r6 = r9.btnMakeAppointment
            r6.setVisibility(r5)
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.branchlocator.BLMapTabInfo.setupBasicInfoUi(es.santander.branchlocator.BLPoi):void");
    }

    private void setupViewPager() {
        if (this.BLBranchDetailedInformationFragment == null) {
            this.BLBranchDetailedInformationFragment = BLBranchDetailedInformationFragment.newInstance();
        }
        if (this.BLAtmDetailedInformationFragment == null) {
            this.BLAtmDetailedInformationFragment = BLAtmDetailedInformationFragment.newInstance();
        }
        final BLViewPagerAdapterCustom adapterCustom = new BLViewPagerAdapterCustom(this.fragment.getChildFragmentManager());
        adapterCustom.addFragment(this.BLBranchDetailedInformationFragment, this.context.getString(R.string.bl_branch));
        adapterCustom.addFragment(this.BLAtmDetailedInformationFragment, this.context.getString(R.string.bl_atm));
        this.vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int i, float v, int i1) {
            }

            public void onPageSelected(int i) {
                Map<String, String> dataLayer = new HashMap<>(1);
                dataLayer.put("ScreenName", "branch locator:branch detail");
                dataLayer.put("BranchAtmName", BLUtils.capitalizeAllString(BLMapTabInfo.this.poi.getLocation().getCity()));
                dataLayer.put("BranchAtmType", BLMapTabInfo.this.poi.getObjectType().getCode().toLowerCase());
                if (adapterCustom.getItem(i) instanceof BLAtmDetailedInformationFragment) {
                    dataLayer.put("TabName", "atm");
                } else {
                    dataLayer.put("TabName", "branch");
                }
                dataLayer.put("EventAction", "tap branch picker");
                AnalyticsComponentHelper.trackEvent("tap branch picker", dataLayer);
            }

            public void onPageScrollStateChanged(int i) {
            }
        });
        this.vpPager.setAdapter(adapterCustom);
        setupTabLayout();
    }

    private void updateDataViewPager(boolean branch, boolean atm, BLPoi BLPOI) {
        this.nestedScrollView.scrollTo(0, 0);
        int currentItem = 0;
        if (branch) {
            this.BLBranchDetailedInformationFragment.setBranchData(BLPOI);
            this.BLBranchDetailedInformationFragment.loadBranchData(BLPOI);
        }
        if (atm) {
            if (hasAtmSchedule(BLPOI)) {
                BLPoi blPoiMix = mixAtmInfo(BLPOI);
                this.BLAtmDetailedInformationFragment.setAtmData(blPoiMix);
                this.BLAtmDetailedInformationFragment.loadAtmData(blPoiMix);
            } else {
                this.BLAtmDetailedInformationFragment.setAtmData(BLPOI);
                this.BLAtmDetailedInformationFragment.loadAtmData(BLPOI);
            }
            currentItem = 1;
        }
        if (!branch || !atm) {
            this.tabLayout.setVisibility(8);
            this.vpPager.setPagingEnabled(false);
            hideSeparatorView();
        } else {
            this.tabLayout.setVisibility(0);
            currentItem = 0;
            this.vpPager.setPagingEnabled(true);
            showSeparatorView();
        }
        this.vpPager.setCurrentItem(currentItem);
    }

    private void hideSeparatorView() {
        this.separatorView.setVisibility(4);
    }

    private void showSeparatorView() {
        this.separatorView.setVisibility(0);
    }

    private BLPoi mixAtmInfo(BLPoi blpoi) {
        List<String> listStepAccessibility;
        List<String> listStepNoFinancial;
        List<String> listStepFinancial;
        BLPoi blPoiMix = blpoi.getAtms().get(0);
        blPoiMix.cleanExtrasMix();
        for (int i = 1; i < blpoi.getAtms().size(); i++) {
            BLPoi blPoiStep = blpoi.getAtms().get(i);
            if (blPoiStep.getComercialProducts() != null && blPoiStep.getComercialProducts().size() > 0) {
                for (Map<String, String> value : blPoiStep.getComercialProducts()) {
                    if (!isExistValue(blPoiMix.getComercialProducts(), value)) {
                        blPoiMix.addExtraCommercialProducts(value);
                    }
                }
            }
            String financialServices = blPoiStep.getFinancialServices(this.context, true);
            if (financialServices != null && !financialServices.equals("") && (listStepFinancial = Arrays.asList(financialServices.split("\\n"))) != null && listStepFinancial.size() > 0) {
                for (String value2 : listStepFinancial) {
                    if (!blPoiMix.getFinancialServices(this.context, true).contains(value2.replaceAll("\n", ""))) {
                        blPoiMix.addExtraFinancialServices(value2);
                    }
                }
            }
            String noFinancialServices = blPoiStep.getNonFinancialServices(this.context);
            if (noFinancialServices != null && !noFinancialServices.equals("") && (listStepNoFinancial = Arrays.asList(noFinancialServices.split("\\n"))) != null && listStepNoFinancial.size() > 0) {
                for (String value3 : listStepNoFinancial) {
                    if (!blPoiMix.getNonFinancialServices(this.context).contains(value3.replaceAll("\n", ""))) {
                        blPoiMix.addExtraNonFinancialServices(value3);
                    }
                }
            }
            String accesibility = blPoiStep.getBranchAccessibility(this.context);
            if (accesibility != null && !accesibility.equals("") && (listStepAccessibility = Arrays.asList(accesibility.split("\\n"))) != null && listStepAccessibility.size() > 0) {
                for (String value4 : listStepAccessibility) {
                    if (!blPoiMix.getBranchAccessibility(this.context).contains(value4)) {
                        blPoiMix.addExtraAccesibility(value4);
                    }
                }
            }
        }
        return blPoiMix;
    }

    private boolean isExistValue(List<Map<String, String>> list, Map<String, String> value) {
        if (list != null && list.size() > 0) {
            for (Map<String, String> valueMap : list) {
                if (valueMap.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void setupTabLayout() {
        this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {
                ViewGroup vgTab = (ViewGroup) ((ViewGroup) BLMapTabInfo.this.tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
                int tabChildsCount = vgTab.getChildCount();
                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        ((TextView) tabViewChild).setTypeface(ResourcesCompat.getFont(BLMapTabInfo.this.context, BLConstants.BOLD_FONT.intValue()));
                        ((TextView) tabViewChild).setAllCaps(false);
                    }
                    tab.getPosition();
                }
            }

            public void onTabUnselected(TabLayout.Tab tab) {
                ViewGroup vgTab = (ViewGroup) ((ViewGroup) BLMapTabInfo.this.tabLayout.getChildAt(0)).getChildAt(tab.getPosition());
                int tabChildsCount = vgTab.getChildCount();
                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        ((TextView) tabViewChild).setTypeface(ResourcesCompat.getFont(BLMapTabInfo.this.context, BLConstants.DEFAULT_FONT.intValue()));
                        ((TextView) tabViewChild).setAllCaps(false);
                    }
                    tab.getPosition();
                }
            }

            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        addDivider();
    }

    private void addDivider() {
        View root = ((TabLayout) this.view.findViewById(R.id.view_pager_tab)).getChildAt(0);
        if (root instanceof LinearLayout) {
            ((LinearLayout) root).setShowDividers(2);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(this.context.getResources().getColor(R.color.medium_sky));
            drawable.setSize(2, 1);
            ((LinearLayout) root).setDividerPadding(25);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }
    }

    private void checkBranch(BLPoi BLPOI) {
        if (BLPOI.getObjectType() != null && BLPOI.getObjectType().getCode() != null) {
            this.vpPager.setVisibility(0);
            String lowerCase = BLPOI.getObjectType().getCode().toLowerCase();
            char c = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != -1630652553) {
                if (hashCode == -1381030494 && lowerCase.equals("branch")) {
                    c = 0;
                }
            } else if (lowerCase.equals("corresponsales")) {
                c = 1;
            }
            if (c != 0) {
                if (c != 1) {
                    updateDataViewPager(false, true, BLPOI);
                } else {
                    updateDataViewPager(true, false, BLPOI);
                }
            } else if (hasAtmSchedule(BLPOI)) {
                updateDataViewPager(true, true, BLPOI);
            } else {
                updateDataViewPager(true, false, BLPOI);
            }
        }
    }

    private void poiState(BLPoi poi2) {
        int day = Calendar.getInstance().get(7);
        this.timeSchedule = new ArrayList();
        BLPoiType type = poi2.getObjectType();
        if (type.getCode().toLowerCase().equals("branch") || type.getCode().toLowerCase().equals("atm") || type.getCode().toLowerCase().equals("corresponsales")) {
            this.timeSchedule = getTimeSchedule(poi2, day, this.timeSchedule);
            this.blockLyWhenBranch = false;
            if (type.getCode().toLowerCase().equals("atm")) {
                this.lyWhenBranch.setVisibility(0);
                this.txtBranch.setVisibility(8);
                this.txtWorkingBranch.setVisibility(8);
                this.txtAtm.setVisibility(0);
                this.txtWorkingAtm.setVisibility(0);
                getAndSetAtmSchedule(poi2);
            } else if (type.getCode().toLowerCase().equals("corresponsales")) {
                this.lyWhenBranch.setVisibility(0);
                this.txtAtm.setVisibility(8);
                this.txtWorkingAtm.setVisibility(8);
                this.txtBranch.setText(this.context.getText(R.string.bl_partners));
                this.txtBranch.setVisibility(0);
                this.txtWorkingBranch.setVisibility(0);
                getAndSetAtmSchedule(poi2);
            } else if (!this.timeSchedule.isEmpty() || hasAtmSchedule(poi2)) {
                this.lyWhenBranch.setVisibility(0);
                this.txtBranch.setVisibility(0);
                this.txtBranch.setText(this.context.getResources().getString(R.string.bl_branch));
                this.txtWorkingBranch.setVisibility(0);
                if (hasAtmSchedule(poi2)) {
                    this.txtAtm.setVisibility(0);
                    this.txtWorkingAtm.setVisibility(0);
                    getAndSetAtmSchedule(poi2.getAtms().get(0));
                } else {
                    this.txtAtm.setVisibility(8);
                    this.txtWorkingAtm.setVisibility(8);
                }
            } else {
                this.lyWhenBranch.setVisibility(0);
                this.txtBranch.setVisibility(0);
                this.txtBranch.setText(this.context.getResources().getString(R.string.bl_branch));
                this.txtWorkingBranch.setVisibility(0);
                this.txtAtm.setVisibility(8);
                this.txtWorkingAtm.setVisibility(8);
            }
            int sizeSchedule = this.timeSchedule.size();
            if (sizeSchedule == 1) {
                try {
                    this.txtWorkingBranch.setText(this.context.getString(R.string.bl_today) + " " + ((String) this.timeSchedule.get(0)) + "h");
                } catch (Exception e) {
                    Log.e(TAG, e.toString());
                    this.txtWorkingBranch.setText(this.context.getResources().getString(R.string.bl_invalid_data));
                }
            } else if (sizeSchedule == 2) {
                this.txtWorkingBranch.setText(this.timeSchedule.get(0) + "h\n" + this.timeSchedule.get(1) + "h");
            } else if (type.getCode().toLowerCase().equals("corresponsales")) {
                this.txtWorkingBranch.setText(this.context.getResources().getString(R.string.bl_24_hours));
            } else {
                this.txtWorkingBranch.setText(this.context.getString(R.string.bl_today) + " " + this.context.getResources().getString(R.string.bl_closed));
            }
        }
    }

    private boolean hasAtmSchedule(BLPoi poi2) {
        return poi2.getAtms() != null && poi2.getAtms().size() > 0;
    }

    private void getAndSetAtmSchedule(BLPoi poi2) {
        String hourThisDay;
        int day = Calendar.getInstance().get(7);
        List timeSchedule2 = new ArrayList();
        BLPoiType type = poi2.getObjectType();
        if (type != null && type.getCode() != null && type.getCode().toLowerCase().equals("atm")) {
            List timeSchedule3 = getTimeSchedule(poi2, day, timeSchedule2);
            int sizeSchedule = timeSchedule3.size();
            if (sizeSchedule == 1) {
                hourThisDay = (String) timeSchedule3.get(0);
                this.txtWorkingAtm.setText(hourThisDay + "h");
            } else if (sizeSchedule == 2) {
                hourThisDay = timeSchedule3.get(0) + "h\n" + timeSchedule3.get(1);
                this.txtWorkingAtm.setText(hourThisDay + "h");
            } else {
                hourThisDay = "";
            }
            if (hourThisDay.isEmpty()) {
                this.txtWorkingAtm.setText(this.context.getResources().getString(R.string.bl_24_hours));
            }
        }
    }

    private List getTimeSchedule(BLPoi poi2, int day, List timeSchedule2) {
        if (poi2.getSchedule() == null) {
            return timeSchedule2;
        }
        switch (day) {
            case 1:
                return poi2.getSchedule().getWorkingDay().getSunday();
            case 2:
                return poi2.getSchedule().getWorkingDay().getMonday();
            case 3:
                return poi2.getSchedule().getWorkingDay().getTuesday();
            case 4:
                return poi2.getSchedule().getWorkingDay().getWednesday();
            case 5:
                return poi2.getSchedule().getWorkingDay().getThursday();
            case 6:
                return poi2.getSchedule().getWorkingDay().getFriday();
            case 7:
                return poi2.getSchedule().getWorkingDay().getSaturday();
            default:
                return timeSchedule2;
        }
    }

    public void showBranchAndAtmSection() {
        if (!this.blockLyWhenBranch) {
            expand(this.lyWhenBranch);
        }
        this.isSheetExpanded = false;
    }

    public void hideBranchAndAtmSection() {
        if (!this.blockLyWhenBranch) {
            collapse(this.lyWhenBranch);
        }
        this.isSheetExpanded = true;
    }

    public static void expand(final View v) {
        v.measure(View.MeasureSpec.makeMeasureSpec(((View) v.getParent()).getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        final int targetHeight = v.getMeasuredHeight();
        v.getLayoutParams().height = 1;
        v.setVisibility(0);
        Animation a = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1.0f ? -2 : (int) (((float) targetHeight) * interpolatedTime);
                v.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration((long) ((int) (((float) targetHeight) / v.getContext().getResources().getDisplayMetrics().density)));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();
        Animation a = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1.0f) {
                    v.setVisibility(8);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                int i = initialHeight;
                layoutParams.height = i - ((int) (((float) i) * interpolatedTime));
                v.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration((long) ((int) (((float) initialHeight) / v.getContext().getResources().getDisplayMetrics().density)));
        v.startAnimation(a);
    }

    private String buildItemListTitle(String code, String city) {
        String type = null;
        StringBuilder title = new StringBuilder();
        if (code != null && code.equals("corresponsales")) {
            type = this.context.getString(R.string.bl_partners);
        } else if (code != null) {
            type = this.context.getString(R.string.bl_santander);
        }
        if (type != null && city != null && !city.equals("")) {
            title.append(type);
            title.append(" - ");
        } else if (type != null) {
            title.append(type);
        }
        if (city != null) {
            title.append(city);
        }
        return title.toString();
    }
}
