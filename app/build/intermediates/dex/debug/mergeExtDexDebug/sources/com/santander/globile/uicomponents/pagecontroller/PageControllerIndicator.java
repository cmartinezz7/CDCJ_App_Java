package com.santander.globile.uicomponents.pagecontroller;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.santander.globile.uicomponents.R;
import com.shuhart.bubblepagerindicator.BubblePageIndicator;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\""}, d2 = {"Lcom/santander/globile/uicomponents/pagecontroller/PageControllerIndicator;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mActiveColor", "Ljava/lang/Integer;", "mContext", "mFadingDots", "mInactiveColor", "mMarginBetweenDots", "", "Ljava/lang/Float;", "mMaxDots", "mRadius", "setActiveColor", "", "color", "setFadingDots", "fadingDots", "setInactiveColor", "setMarginBetweenDots", "margin", "setMaxNumberNormalDots", "numberDots", "setRadius", "radius", "setViewPager", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: PageControllerIndicator.kt */
public final class PageControllerIndicator extends FrameLayout {
    private HashMap _$_findViewCache;
    private Integer mActiveColor;
    private final Context mContext;
    private int mFadingDots;
    private Integer mInactiveColor;
    private Float mMarginBetweenDots;
    private int mMaxDots;
    private Float mRadius;

    public PageControllerIndicator(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public PageControllerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageControllerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        int activeColor;
        int inactiveColor;
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
        this.mMaxDots = 4;
        this.mFadingDots = 2;
        LayoutInflater.from(context).inflate(R.layout.page_controller_indicator, this, true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PageControllerIndicator);
        int i = typedArray.getInt(R.styleable.PageControllerIndicator_pageindicator_maxNormalSizeDots, 4);
        this.mMaxDots = i;
        setMaxNumberNormalDots(i);
        int i2 = typedArray.getInt(R.styleable.PageControllerIndicator_pageindicator_fadingDots, 2);
        this.mFadingDots = i2;
        setFadingDots(i2);
        if (Build.VERSION.SDK_INT >= 23) {
            activeColor = getResources().getColor(R.color.page_controller_active, (Resources.Theme) null);
        } else {
            activeColor = getResources().getColor(R.color.page_controller_active);
        }
        Integer valueOf = Integer.valueOf(typedArray.getInt(R.styleable.PageControllerIndicator_pageindicator_activeColor, activeColor));
        this.mActiveColor = valueOf;
        if (valueOf != null) {
            setActiveColor(valueOf.intValue());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            inactiveColor = getResources().getColor(R.color.page_controller_inactive, (Resources.Theme) null);
        } else {
            inactiveColor = getResources().getColor(R.color.page_controller_inactive);
        }
        Integer valueOf2 = Integer.valueOf(typedArray.getInt(R.styleable.PageControllerIndicator_pageindicator_inactiveColor, inactiveColor));
        this.mInactiveColor = valueOf2;
        if (valueOf2 != null) {
            setInactiveColor(valueOf2.intValue());
        }
        Float valueOf3 = Float.valueOf(typedArray.getDimension(R.styleable.PageControllerIndicator_pageindicator_radius, (float) getResources().getDimensionPixelSize(R.dimen.default_dot_radius)));
        this.mRadius = valueOf3;
        if (valueOf3 != null) {
            setRadius(valueOf3.floatValue());
        }
        Float valueOf4 = Float.valueOf(typedArray.getDimension(R.styleable.PageControllerIndicator_pageindicator_marginBetweenCircles, (float) getResources().getDimensionPixelSize(R.dimen.default_margin_between_dots)));
        this.mMarginBetweenDots = valueOf4;
        if (valueOf4 != null) {
            setMarginBetweenDots(valueOf4.floatValue());
        }
        typedArray.recycle();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PageControllerIndicator(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setViewPager(ViewPager viewPager) {
        Intrinsics.checkParameterIsNotNull(viewPager, "viewPager");
        ((BubblePageIndicator) _$_findCachedViewById(R.id.indicator)).setViewPager(viewPager);
    }

    public final void setActiveColor(int color) {
        BubblePageIndicator bubblePageIndicator = (BubblePageIndicator) _$_findCachedViewById(R.id.indicator);
        Intrinsics.checkExpressionValueIsNotNull(bubblePageIndicator, "indicator");
        bubblePageIndicator.setFillColor(color);
        this.mActiveColor = Integer.valueOf(color);
    }

    public final void setInactiveColor(int color) {
        BubblePageIndicator bubblePageIndicator = (BubblePageIndicator) _$_findCachedViewById(R.id.indicator);
        Intrinsics.checkExpressionValueIsNotNull(bubblePageIndicator, "indicator");
        bubblePageIndicator.setPageColor(color);
        this.mInactiveColor = Integer.valueOf(color);
    }

    public final void setRadius(float radius) {
        BubblePageIndicator bubblePageIndicator = (BubblePageIndicator) _$_findCachedViewById(R.id.indicator);
        Intrinsics.checkExpressionValueIsNotNull(bubblePageIndicator, "indicator");
        bubblePageIndicator.setRadius(radius);
        this.mRadius = Float.valueOf(radius);
    }

    public final void setMarginBetweenDots(float margin) {
        ((BubblePageIndicator) _$_findCachedViewById(R.id.indicator)).setMarginBetweenCircles(margin);
        this.mMarginBetweenDots = Float.valueOf(margin);
    }

    public final void setMaxNumberNormalDots(int numberDots) {
        ((BubblePageIndicator) _$_findCachedViewById(R.id.indicator)).setOnSurfaceCount(numberDots);
        this.mMaxDots = numberDots;
    }

    public final void setFadingDots(int fadingDots) {
        ((BubblePageIndicator) _$_findCachedViewById(R.id.indicator)).setRisingCount(fadingDots);
        this.mFadingDots = fadingDots;
    }
}
