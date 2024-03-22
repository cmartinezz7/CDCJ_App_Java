package es.santander.branchlocator;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.branchlocator.common.AnalyticsComponentHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FilterTagsView extends RelativeLayout {
    private AttributeSet attrs;
    private LinearLayout btnScrollTags;
    private Context context;
    private View dividerView;
    private BLTextView filterBadge;
    private AppCompatImageView filterIcon;
    private RecyclerView filterTags;
    private ImageView imgArrowFilters;
    private LinearLayout lineFiltersLeft;
    private BLTextView txtFilterTitle;
    private View view;

    public FilterTagsView(Context context2) {
        super(context2);
        this.context = context2;
        init();
    }

    public FilterTagsView(Context context2, AttributeSet attrs2) {
        super(context2, attrs2);
        this.attrs = attrs2;
        this.context = context2;
        init();
    }

    public FilterTagsView(Context context2, AttributeSet attrs2, int defStyleAttr) {
        super(context2, attrs2, defStyleAttr);
        this.attrs = attrs2;
        this.context = context2;
        init();
    }

    private void init() {
        View inflate = inflate(getContext(), R.layout.branch_locator_filter_tags, this);
        this.view = inflate;
        setupUI(inflate);
        setAttributes();
        setupListeners(this.view);
    }

    private void setupListeners(View v) {
        this.btnScrollTags.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FilterTagsView.this.scrollToFirstItem();
                FilterTagsView.this.noScrolling();
            }
        });
    }

    private void setupUI(View v) {
        this.filterTags = v.findViewById(R.id.filter_tags_recycler_view);
        this.filterBadge = (BLTextView) v.findViewById(R.id.filter_badge);
        this.btnScrollTags = (LinearLayout) v.findViewById(R.id.filter_tags_btn_scroll);
        this.imgArrowFilters = (ImageView) v.findViewById(R.id.img_arrow_filters);
        this.lineFiltersLeft = (LinearLayout) v.findViewById(R.id.line_filters_left);
        this.filterIcon = v.findViewById(R.id.ic_filter);
        this.dividerView = v.findViewById(R.id.divider);
        this.txtFilterTitle = (BLTextView) v.findViewById(R.id.filter_tags_btn_filter);
    }

    private void setAttributes() {
        Context context2;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AttributeSet attributeSet = this.attrs;
        if (attributeSet != null && (context2 = this.context) != null) {
            TypedArray attributes = context2.obtainStyledAttributes(attributeSet, R.styleable.CustomFilterTagsView);
            Drawable drawableSrc = attributes.getDrawable(R.styleable.CustomFilterTagsView_icon_filter_src);
            if (!(drawableSrc == null || (appCompatImageView2 = this.filterIcon) == null)) {
                appCompatImageView2.setImageDrawable(drawableSrc);
            }
            Drawable drawableBackground = attributes.getDrawable(R.styleable.CustomFilterTagsView_icon_filter_background);
            if (!(drawableBackground == null || (appCompatImageView = this.filterIcon) == null)) {
                appCompatImageView.setBackground(drawableBackground);
            }
            int i = 0;
            this.dividerView.setVisibility(attributes.getBoolean(R.styleable.CustomFilterTagsView_show_divider, true) ? 0 : 4);
            boolean isShowFilterText = attributes.getBoolean(R.styleable.CustomFilterTagsView_show_filter_text, true);
            BLTextView bLTextView = this.txtFilterTitle;
            if (!isShowFilterText) {
                i = 4;
            }
            bLTextView.setVisibility(i);
        }
    }

    /* access modifiers changed from: private */
    public boolean startFiltersActivity(BLMapsLogicActivity activity) {
        if (BLMapsLogicActivity.isBothFilterAreEmpty()) {
            BLUtils.showCustomToast(getContext(), getContext().getString(R.string.bl_toast_no_filters));
            return false;
        }
        Map<String, String> dataLayer = new HashMap<>(1);
        if (activity.viewPager.getCurrentItem() == 0) {
            dataLayer.put("ScreenName", "branch locator:home");
        } else {
            dataLayer.put("ScreenName", "branch locator:listing");
        }
        dataLayer.put("EventAction", "tap filters");
        AnalyticsComponentHelper.trackEvent("tap filters", dataLayer);
        activity.startActivityForResult(new Intent(getContext(), BLFiltersActivity.class), 2001);
        return true;
    }

    public void setupFilterActivityIntent(final BLMapsLogicActivity activity) {
        this.view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                view.setEnabled(false);
                if (!FilterTagsView.this.startFiltersActivity(activity)) {
                    view.setEnabled(true);
                }
            }
        });
    }

    public void setupFilterList(List<BLFilter> filters, BLMapsLogicActivity activity) {
        BLFilterTagsAdapter BLFilterTagsAdapter = new BLFilterTagsAdapter(getContext(), filters);
        this.filterTags.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.filterTags.setAdapter(BLFilterTagsAdapter);
        if (filters.isEmpty()) {
            this.lineFiltersLeft.setVisibility(4);
            this.filterBadge.setVisibility(4);
            this.filterIcon.setVisibility(0);
        } else {
            this.lineFiltersLeft.setVisibility(0);
            this.filterBadge.setVisibility(0);
            this.filterBadge.setText(String.valueOf(filters.size()));
            this.filterIcon.setVisibility(4);
        }
        this.filterTags.addOnScrollListener(new BLRecyclerViewScroll(new BLOnHorizontalScroll() {
            public void onNoScroll() {
                FilterTagsView.this.noScrolling();
            }

            public void onScrolling() {
                FilterTagsView.this.isScrolling();
            }
        }));
        setupFilterActivityIntent(activity);
    }

    /* access modifiers changed from: private */
    public void noScrolling() {
        this.imgArrowFilters.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void isScrolling() {
        this.imgArrowFilters.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void scrollToFirstItem() {
        this.filterTags.scrollToPosition(0);
    }
}
