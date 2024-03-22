package com.viewpagerindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;

public class IconPageIndicator extends HorizontalScrollView implements PageIndicator {
    /* access modifiers changed from: private */
    public Runnable mIconSelector;
    private final IcsLinearLayout mIconsLayout;
    private ViewPager.OnPageChangeListener mListener;
    private int mSelectedIndex;
    private ViewPager mViewPager;

    public IconPageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public IconPageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        setHorizontalScrollBarEnabled(false);
        IcsLinearLayout icsLinearLayout = new IcsLinearLayout(context, R.attr.vpiIconPageIndicatorStyle);
        this.mIconsLayout = icsLinearLayout;
        addView(icsLinearLayout, new FrameLayout.LayoutParams(-2, -1, 17));
    }

    private void animateToIcon(int position) {
        final View iconView = this.mIconsLayout.getChildAt(position);
        Runnable runnable = this.mIconSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        AnonymousClass1 r1 = new Runnable() {
            public void run() {
                IconPageIndicator.this.smoothScrollTo(iconView.getLeft() - ((IconPageIndicator.this.getWidth() - iconView.getWidth()) / 2), 0);
                Runnable unused = IconPageIndicator.this.mIconSelector = null;
            }
        };
        this.mIconSelector = r1;
        post(r1);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.mIconSelector;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.mIconSelector;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
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
        this.mIconsLayout.removeAllViews();
        IconPagerAdapter iconAdapter = this.mViewPager.getAdapter();
        int count = iconAdapter.getCount();
        for (int i = 0; i < count; i++) {
            ImageView view = new ImageView(getContext(), (AttributeSet) null, R.attr.vpiIconPageIndicatorStyle);
            view.setImageResource(iconAdapter.getIconResId(i));
            this.mIconsLayout.addView(view);
        }
        if (this.mSelectedIndex > count) {
            this.mSelectedIndex = count - 1;
        }
        setCurrentItem(this.mSelectedIndex);
        requestLayout();
    }

    public void setViewPager(ViewPager view, int initialPosition) {
        setViewPager(view);
        setCurrentItem(initialPosition);
    }

    public void setCurrentItem(int item) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            this.mSelectedIndex = item;
            viewPager.setCurrentItem(item);
            int tabCount = this.mIconsLayout.getChildCount();
            int i = 0;
            while (i < tabCount) {
                View child = this.mIconsLayout.getChildAt(i);
                boolean isSelected = i == item;
                child.setSelected(isSelected);
                if (isSelected) {
                    animateToIcon(item);
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
}
