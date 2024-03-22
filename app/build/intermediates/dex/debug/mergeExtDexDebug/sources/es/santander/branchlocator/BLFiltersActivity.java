package es.santander.branchlocator;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.branchlocator.common.AnalyticsComponentHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BLFiltersActivity extends BLBaseActivity {
    private ImageView btnBack;
    private RelativeLayout btnFilter;
    private List<BLFilter> cachedSelectedFilters = null;
    private BLFiltersAdapter mostPopularAdapter;
    private List<BLFilterItem> mostPopularData;
    private RecyclerView mostPopularList;
    /* access modifiers changed from: private */
    public boolean onSeeAll = false;
    private BLFiltersAdapter othersAdapter;
    private List<BLFilterItem> othersData;
    private RecyclerView othersList;
    /* access modifiers changed from: private */
    public NestedScrollView scrollView;
    private BLTextView txtDeleteAll;
    private BLTextView txtSeeAll;

    /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, es.santander.branchlocator.BLFiltersActivity, es.santander.branchlocator.BLBaseActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            BLMapsLogicActivity.recoverFilterIndexes(getApplicationContext());
        }
        setContentView(R.layout.activity_branch_filters);
        setupUi();
        setupListeners();
        BLUtils.getAnalytcsTag(this, "clicked_on_filters");
        generateData();
        setupMostPopularAdapter();
        setupOthersFiltersAdapter();
        checkMoreLessButtonVisibility();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Map<String, String> viewDataLayer = new HashMap<>(1);
        viewDataLayer.put("ScreenName", "branch locator:filters");
        AnalyticsComponentHelper.trackView("branch locator:filters", viewDataLayer);
    }

    private void checkMoreLessButtonVisibility() {
        BLFiltersAdapter bLFiltersAdapter = this.othersAdapter;
        if (bLFiltersAdapter == null || bLFiltersAdapter.getAllFilters() == null || this.othersAdapter.getAllFilters().size() <= 0) {
            this.txtSeeAll.setVisibility(8);
            return;
        }
        List<BLFilterItem> list = this.mostPopularData;
        if (list == null || list.size() == 0) {
            expandOtherList();
            this.txtSeeAll.setVisibility(8);
            return;
        }
        this.txtSeeAll.setVisibility(0);
    }

    private void setupUi() {
        this.btnBack = (ImageView) findViewById(R.id.btn_back);
        this.txtSeeAll = (BLTextView) findViewById(R.id.txt_see_all);
        this.txtDeleteAll = (BLTextView) findViewById(R.id.btn_delete_filters);
        this.scrollView = findViewById(R.id.filter_scroll_view);
        this.btnFilter = (RelativeLayout) findViewById(R.id.filter_btn_filter);
        this.mostPopularList = findViewById(R.id.mostPopularList);
        this.othersList = findViewById(R.id.othersList);
        new BLFontManager(getApplicationContext()).inserTypeFont(this.txtSeeAll, BLConstants.BOLD_FONT);
        SpannableString content = new SpannableString(getResources().getString(R.string.bl_show_more));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        this.txtSeeAll.setText(content);
    }

    private void setupListeners() {
        this.btnFilter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String filters = BLFiltersActivity.this.getFiltersString();
                Map<String, String> dataLayer = new HashMap<>(1);
                dataLayer.put("ScreenName", "branch locator:filters");
                dataLayer.put("FiltersSelected", filters);
                dataLayer.put("EventAction", "tap apply filters");
                AnalyticsComponentHelper.trackEvent("tap apply filters", dataLayer);
                BLFiltersActivity.this.selectFilters();
            }
        });
        this.txtDeleteAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Map<String, String> dataLayer = new HashMap<>(1);
                dataLayer.put("ScreenName", "branch locator:filters");
                dataLayer.put("EventAction", "tap clean filters");
                AnalyticsComponentHelper.trackEvent("tap clean filters", dataLayer);
                BLFiltersActivity.this.deselectAllFilters();
            }
        });
        this.txtSeeAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Map<String, String> dataLayer = new HashMap<>(1);
                dataLayer.put("ScreenName", "branch locator:filters");
                dataLayer.put("EventAction", "tap see more");
                AnalyticsComponentHelper.trackEvent("tap see more", dataLayer);
                if (!BLFiltersActivity.this.onSeeAll) {
                    BLFiltersActivity.this.expandOtherList();
                } else {
                    BLFiltersActivity.this.collapseOtherList();
                }
            }
        });
        this.btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BLFiltersActivity.this.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: private */
    public String getFiltersString() {
        ArrayList<String> selectedFilters = new ArrayList<>();
        for (BLFilter filter : getSelectedFilters()) {
            selectedFilters.add(filter.getName());
        }
        if (selectedFilters.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = selectedFilters.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /* access modifiers changed from: private */
    public void expandOtherList() {
        this.onSeeAll = true;
        SpannableString content = new SpannableString(getResources().getString(R.string.bl_show_less));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        this.txtSeeAll.setText(content);
        this.othersList.setVisibility(0);
        focusOnView(this.othersList);
    }

    /* access modifiers changed from: private */
    public void collapseOtherList() {
        this.onSeeAll = false;
        SpannableString content = new SpannableString(getResources().getString(R.string.bl_show_more));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        this.txtSeeAll.setText(content);
        this.othersList.setVisibility(8);
        focusOnView(this.scrollView);
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.branchlocator.BLFiltersActivity] */
    /* access modifiers changed from: private */
    public void selectFilters() {
        BLPreferencesManager.getInstance(this).saveFilterData(getSelectedFilters());
        setResult(-1);
        finish();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.branchlocator.BLFiltersActivity] */
    private void generateData() {
        List<BLFilter> selectedFilters = BLPreferencesManager.getInstance(this).getFilterData();
        this.mostPopularData = BLUtils.generateGeneralListFilters(getApplicationContext(), true);
        this.othersData = BLUtils.generateGeneralListFilters(getApplicationContext(), false);
        this.mostPopularData = redefinePopularFilters(this.mostPopularData);
        this.othersData = redefineOtherFilters(this.othersData);
        if (selectedFilters != null) {
            selectSavedFilters(selectedFilters);
        }
    }

    private void selectSavedFilters(List<BLFilter> selectedFilters) {
        for (BLFilter filter : selectedFilters) {
            for (BLFilterItem item : this.mostPopularData) {
                if (item.getBLFilterType() == BLFilterType.NORMAL && item.getFilter().getName().equals(filter.getName())) {
                    item.getFilter().setSelected(true);
                }
            }
        }
        for (BLFilter filter2 : selectedFilters) {
            for (BLFilterItem item2 : this.othersData) {
                if (item2.getBLFilterType() == BLFilterType.NORMAL && item2.getFilter().getName().equals(filter2.getName())) {
                    item2.getFilter().setSelected(true);
                }
            }
        }
    }

    private List<BLFilter> getSelectedFilters() {
        List<BLFilter> allSelectedFilters = new ArrayList<>();
        allSelectedFilters.addAll(this.mostPopularAdapter.getSelectedFilters());
        allSelectedFilters.addAll(this.othersAdapter.getSelectedFilters());
        return allSelectedFilters;
    }

    /* access modifiers changed from: private */
    public void deselectAllFilters() {
        this.cachedSelectedFilters = getSelectedFilters();
        this.mostPopularAdapter.deselectAll();
        this.othersAdapter.deselectAll();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.branchlocator.BLFiltersActivity] */
    private void setupMostPopularAdapter() {
        this.mostPopularList.setLayoutManager(BLUtils.getLayoutManager(this, false));
        this.mostPopularList.setNestedScrollingEnabled(false);
        BLFiltersAdapter bLFiltersAdapter = new BLFiltersAdapter(this, this.mostPopularData);
        this.mostPopularAdapter = bLFiltersAdapter;
        this.mostPopularList.setAdapter(bLFiltersAdapter);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.branchlocator.BLFiltersActivity] */
    private void setupOthersFiltersAdapter() {
        this.othersList.setLayoutManager(BLUtils.getLayoutManager(this, false));
        this.othersList.setNestedScrollingEnabled(false);
        BLFiltersAdapter bLFiltersAdapter = new BLFiltersAdapter(this, this.othersData);
        this.othersAdapter = bLFiltersAdapter;
        this.othersList.setAdapter(bLFiltersAdapter);
    }

    private void focusOnView(final View view) {
        this.scrollView.post(new Runnable() {
            public void run() {
                BLFiltersActivity.this.scrollView.smoothScrollTo(0, view.getTop());
            }
        });
    }

    private List<BLFilterItem> redefinePopularFilters(List<BLFilterItem> populars) {
        List<BLFilterItem> newPopulars = new ArrayList<>();
        if (!BLMapsLogicActivity.isCustomFilterPopular()) {
            newPopulars.addAll(BLUtils.generateDefaultPopularList(getApplicationContext(), true));
        } else {
            for (int i = 0; i < populars.size(); i++) {
                if (populars.get(i).getBLFilterCode() == -1) {
                    if (BLMapsLogicActivity.isThereAnyPopularFilterSelected()) {
                        newPopulars.add(populars.get(i));
                    }
                } else if (BLMapsLogicActivity.isPopularItemFilterVisible(populars.get(i).getBLFilterCode())) {
                    newPopulars.add(populars.get(i));
                }
            }
        }
        return newPopulars;
    }

    private List<BLFilterItem> redefineOtherFilters(List<BLFilterItem> others) {
        return getOthersListWithoutEmptyHeader(getOthersListWithoutDuplicatePopular(getOthersListWithCustoms(others)));
    }

    private List<BLFilterItem> getOthersListWithCustoms(List<BLFilterItem> others) {
        List<BLFilterItem> newOthers = new ArrayList<>();
        if (BLMapsLogicActivity.isCustomFilterOther()) {
            for (int i = 0; i < others.size(); i++) {
                BLFilterItem blFilterItem = others.get(i);
                if (blFilterItem.getFilter() == null) {
                    int titleId = blFilterItem.getTitleId();
                    if (titleId != 0) {
                        if (titleId != 1) {
                            if (titleId != 2) {
                                if (titleId == 3 && BLMapsLogicActivity.isThereAnyPointOfInterestSelected()) {
                                    newOthers.add(blFilterItem);
                                }
                            } else if (BLMapsLogicActivity.isThereAnyAcessibilitySelected()) {
                                newOthers.add(blFilterItem);
                            }
                        } else if (BLMapsLogicActivity.isThereAnyFacilitiesSelected()) {
                            newOthers.add(blFilterItem);
                        }
                    } else if (BLMapsLogicActivity.isThereAnyAditionalServicesSelected()) {
                        newOthers.add(blFilterItem);
                    }
                } else if (BLMapsLogicActivity.isOtherItemFilterVisible(blFilterItem.getBLFilterCode())) {
                    newOthers.add(blFilterItem);
                }
            }
        } else if (!BLMapsLogicActivity.isCustomFilterPopular()) {
            newOthers.addAll(BLUtils.generateDefaultOthersList(getApplicationContext(), false));
        } else {
            newOthers.addAll(BLUtils.generateGeneralListFilters(getApplicationContext(), false));
        }
        return newOthers;
    }

    private List<BLFilterItem> getOthersListWithoutDuplicatePopular(List<BLFilterItem> others) {
        List<BLFilterItem> newOthers = new ArrayList<>();
        for (BLFilterItem item : others) {
            if (item.getFilter() == null) {
                newOthers.add(item);
            } else if (!this.mostPopularData.contains(item)) {
                newOthers.add(item);
            }
        }
        return newOthers;
    }

    private List<BLFilterItem> getOthersListWithoutEmptyHeader(List<BLFilterItem> others) {
        List<BLFilterItem> newOthers = new ArrayList<>();
        if (others != null) {
            for (int i = 0; i < others.size(); i++) {
                BLFilterItem blFilterItem = others.get(i);
                if (blFilterItem.getFilter() == null) {
                    int titleId = blFilterItem.getTitleId();
                    if (titleId != 0) {
                        if (titleId != 1) {
                            if (titleId != 2) {
                                if (titleId == 3 && BLMapsLogicActivity.isThereAnyItem(others, BLMapsLogicActivity.getListPositionPOI())) {
                                    newOthers.add(blFilterItem);
                                }
                            } else if (BLMapsLogicActivity.isThereAnyItem(others, BLMapsLogicActivity.getListPositionAccesibility())) {
                                newOthers.add(blFilterItem);
                            }
                        } else if (BLMapsLogicActivity.isThereAnyItem(others, BLMapsLogicActivity.getListPositionFacilities())) {
                            newOthers.add(blFilterItem);
                        }
                    } else if (BLMapsLogicActivity.isThereAnyItem(others, BLMapsLogicActivity.getListPositionServices())) {
                        newOthers.add(blFilterItem);
                    }
                } else {
                    newOthers.add(blFilterItem);
                }
            }
        }
        return newOthers;
    }
}
