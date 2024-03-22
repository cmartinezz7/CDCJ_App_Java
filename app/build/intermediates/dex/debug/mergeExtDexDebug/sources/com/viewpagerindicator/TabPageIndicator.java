package com.viewpagerindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;

public class TabPageIndicator extends HorizontalScrollView implements PageIndicator {
    private static final CharSequence EMPTY_TITLE = "";
    private ViewPager.OnPageChangeListener mListener;
    /* access modifiers changed from: private */
    public int mMaxTabWidth;
    private int mSelectedTabIndex;
    private final View.OnClickListener mTabClickListener;
    private final IcsLinearLayout mTabLayout;
    /* access modifiers changed from: private */
    public OnTabReselectedListener mTabReselectedListener;
    /* access modifiers changed from: private */
    public Runnable mTabSelector;
    /* access modifiers changed from: private */
    public ViewPager mViewPager;

    public interface OnTabReselectedListener {
        void onTabReselected(int i);
    }

    public TabPageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabPageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTabClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                int oldSelected = TabPageIndicator.this.mViewPager.getCurrentItem();
                int newSelected = ((TabView) view).getIndex();
                TabPageIndicator.this.mViewPager.setCurrentItem(newSelected);
                if (oldSelected == newSelected && TabPageIndicator.this.mTabReselectedListener != null) {
                    TabPageIndicator.this.mTabReselectedListener.onTabReselected(newSelected);
                }
            }
        };
        setHorizontalScrollBarEnabled(false);
        IcsLinearLayout icsLinearLayout = new IcsLinearLayout(context, R.attr.vpiTabPageIndicatorStyle);
        this.mTabLayout = icsLinearLayout;
        addView(icsLinearLayout, new ViewGroup.LayoutParams(-2, -1));
    }

    public void setOnTabReselectedListener(OnTabReselectedListener listener) {
        this.mTabReselectedListener = listener;
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        boolean lockedExpanded = widthMode == 1073741824;
        setFillViewport(lockedExpanded);
        int childCount = this.mTabLayout.getChildCount();
        if (childCount <= 1 || !(widthMode == 1073741824 || widthMode == Integer.MIN_VALUE)) {
            this.mMaxTabWidth = -1;
        } else if (childCount > 2) {
            this.mMaxTabWidth = (int) (((float) View.MeasureSpec.getSize(widthMeasureSpec)) * 0.4f);
        } else {
            this.mMaxTabWidth = View.MeasureSpec.getSize(widthMeasureSpec) / 2;
        }
        int oldWidth = getMeasuredWidth();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int newWidth = getMeasuredWidth();
        if (lockedExpanded && oldWidth != newWidth) {
            setCurrentItem(this.mSelectedTabIndex);
        }
    }

    private void animateToTab(int position) {
        final View tabView = this.mTabLayout.getChildAt(position);
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        AnonymousClass2 r1 = new Runnable() {
            public void run() {
                TabPageIndicator.this.smoothScrollTo(tabView.getLeft() - ((TabPageIndicator.this.getWidth() - tabView.getWidth()) / 2), 0);
                Runnable unused = TabPageIndicator.this.mTabSelector = null;
            }
        };
        this.mTabSelector = r1;
        post(r1);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.mTabSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    private void addTab(int index, CharSequence text, int iconResId) {
        TabView tabView = new TabView(getContext());
        int unused = tabView.mIndex = index;
        tabView.setFocusable(true);
        tabView.setOnClickListener(this.mTabClickListener);
        tabView.setText(text);
        if (iconResId != 0) {
            tabView.setCompoundDrawablesWithIntrinsicBounds(iconResId, 0, 0, 0);
        }
        this.mTabLayout.addView(tabView, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    public void onPageScrollStateChanged(int arg0) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(arg0);
        }
    }

    public void onPageScrolled(int arg0, float arg1, int arg2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(arg0, arg1, arg2);
        }
    }

    public void onPageSelected(int arg0) {
        setCurrentItem(arg0);
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(arg0);
        }
    }

    public void setViewPager(ViewPager view) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != view) {
            if (viewPager != null) {
                viewPager.setOnPageChangeListener((ViewPager.OnPageChangeListener) null);
            }
            if (view.getAdapter() != null) {
                this.mViewPager = view;
                view.setOnPageChangeListener(this);
                notifyDataSetChanged();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    public void notifyDataSetChanged() {
        this.mTabLayout.removeAllViews();
        IconPagerAdapter iconAdapter = this.mViewPager.getAdapter();
        IconPagerAdapter iconAdapter2 = null;
        if (iconAdapter instanceof IconPagerAdapter) {
            iconAdapter2 = iconAdapter;
        }
        int count = iconAdapter.getCount();
        for (int i = 0; i < count; i++) {
            CharSequence title = iconAdapter.getPageTitle(i);
            if (title == null) {
                title = EMPTY_TITLE;
            }
            int iconResId = 0;
            if (iconAdapter2 != null) {
                iconResId = iconAdapter2.getIconResId(i);
            }
            addTab(i, title, iconResId);
        }
        if (this.mSelectedTabIndex > count) {
            this.mSelectedTabIndex = count - 1;
        }
        setCurrentItem(this.mSelectedTabIndex);
        requestLayout();
    }

    public void setViewPager(ViewPager view, int initialPosition) {
        setViewPager(view);
        setCurrentItem(initialPosition);
    }

    public void setCurrentItem(int item) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            this.mSelectedTabIndex = item;
            viewPager.setCurrentItem(item);
            int tabCount = this.mTabLayout.getChildCount();
            int i = 0;
            while (i < tabCount) {
                View child = this.mTabLayout.getChildAt(i);
                boolean isSelected = i == item;
                child.setSelected(isSelected);
                if (isSelected) {
                    animateToTab(item);
                }
                i++;
            }
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        this.mListener = listener;
    }

    private class TabView extends TextView {
        /* access modifiers changed from: private */
        public int mIndex;

        public TabView(Context context) {
            super(context, (AttributeSet) null, R.attr.vpiTabPageIndicatorStyle);
        }

        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (TabPageIndicator.this.mMaxTabWidth > 0 && getMeasuredWidth() > TabPageIndicator.this.mMaxTabWidth) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(TabPageIndicator.this.mMaxTabWidth, 1073741824), heightMeasureSpec);
            }
        }

        public int getIndex() {
            return this.mIndex;
        }
    }
}
