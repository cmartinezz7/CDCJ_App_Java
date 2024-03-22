package net.opacapp.multilinecollapsingtoolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.KotlinVersion;
import net.opacapp.multilinecollapsingtoolbar.ValueAnimatorCompat;

public class CollapsingToolbarLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    /* access modifiers changed from: private */
    public final CollapsingTextHelper mCollapsingTextHelper;
    private boolean mCollapsingTitleEnabled;
    private Drawable mContentScrim;
    /* access modifiers changed from: private */
    public int mCurrentOffset;
    private boolean mDrawCollapsingTitle;
    private View mDummyView;
    private int mExpandedMarginBottom;
    private int mExpandedMarginEnd;
    private int mExpandedMarginStart;
    private int mExpandedMarginTop;
    /* access modifiers changed from: private */
    public WindowInsetsCompat mLastInsets;
    private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
    private boolean mRefreshToolbar;
    private int mScrimAlpha;
    private long mScrimAnimationDuration;
    private ValueAnimatorCompat mScrimAnimator;
    private int mScrimVisibleHeightTrigger;
    private boolean mScrimsAreShown;
    /* access modifiers changed from: private */
    public Drawable mStatusBarScrim;
    private final Rect mTmpRect;
    private Toolbar mToolbar;
    private View mToolbarDirectChild;
    private int mToolbarId;

    public CollapsingToolbarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mRefreshToolbar = true;
        this.mTmpRect = new Rect();
        this.mScrimVisibleHeightTrigger = -1;
        ThemeUtils.checkAppCompatTheme(context);
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.mCollapsingTextHelper = collapsingTextHelper;
        collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CollapsingToolbarLayout, defStyleAttr, R.style.Widget_Design_MultilineCollapsingToolbar);
        collapsingTextHelper.setExpandedTextGravity(a.getInt(14, 8388691));
        collapsingTextHelper.setCollapsedTextGravity(a.getInt(13, 8388627));
        int dimensionPixelSize = a.getDimensionPixelSize(1, 0);
        this.mExpandedMarginBottom = dimensionPixelSize;
        this.mExpandedMarginEnd = dimensionPixelSize;
        this.mExpandedMarginTop = dimensionPixelSize;
        this.mExpandedMarginStart = dimensionPixelSize;
        if (a.hasValue(2)) {
            this.mExpandedMarginStart = a.getDimensionPixelSize(2, 0);
        }
        if (a.hasValue(4)) {
            this.mExpandedMarginEnd = a.getDimensionPixelSize(4, 0);
        }
        if (a.hasValue(3)) {
            this.mExpandedMarginTop = a.getDimensionPixelSize(3, 0);
        }
        if (a.hasValue(5)) {
            this.mExpandedMarginBottom = a.getDimensionPixelSize(5, 0);
        }
        this.mCollapsingTitleEnabled = a.getBoolean(15, true);
        setTitle(a.getText(0));
        collapsingTextHelper.setExpandedTextAppearance(2131165425);
        collapsingTextHelper.setCollapsedTextAppearance(R.style.ActionBar_Title);
        if (a.hasValue(6)) {
            collapsingTextHelper.setExpandedTextAppearance(a.getResourceId(6, 0));
        }
        if (a.hasValue(7)) {
            collapsingTextHelper.setCollapsedTextAppearance(a.getResourceId(7, 0));
        }
        this.mScrimVisibleHeightTrigger = a.getInt(11, -1);
        this.mScrimAnimationDuration = (long) a.getInt(12, DEFAULT_SCRIM_ANIMATION_DURATION);
        setContentScrim(a.getDrawable(8));
        setStatusBarScrim(a.getDrawable(9));
        this.mToolbarId = a.getResourceId(10, -1);
        a.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
                return CollapsingToolbarLayout.this.setWindowInsets(insets);
            }
        });
        collapsingTextHelper.setMaxLines(context.obtainStyledAttributes(attrs, R.styleable.CollapsingToolbarLayoutExtension, defStyleAttr, 0).getInteger(R.styleable.CollapsingToolbarLayoutExtension_maxLines, 3));
    }

    public void setMaxLines(int maxLines) {
        this.mCollapsingTextHelper.setMaxLines(maxLines);
    }

    public int getMaxLines() {
        return this.mCollapsingTextHelper.getMaxLines();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.mOnOffsetChangedListener == null) {
                this.mOnOffsetChangedListener = new OffsetUpdateListener();
            }
            ((AppBarLayout) parent).addOnOffsetChangedListener(this.mOnOffsetChangedListener);
        }
        ViewCompat.requestApplyInsets(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.mOnOffsetChangedListener;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: private */
    public WindowInsetsCompat setWindowInsets(WindowInsetsCompat insets) {
        if (this.mLastInsets != insets) {
            this.mLastInsets = insets;
            requestLayout();
        }
        return insets.consumeSystemWindowInsets();
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        ensureToolbar();
        if (this.mToolbar == null && (drawable = this.mContentScrim) != null && this.mScrimAlpha > 0) {
            drawable.mutate().setAlpha(this.mScrimAlpha);
            this.mContentScrim.draw(canvas);
        }
        if (this.mCollapsingTitleEnabled && this.mDrawCollapsingTitle) {
            this.mCollapsingTextHelper.draw(canvas);
        }
        if (this.mStatusBarScrim != null && this.mScrimAlpha > 0) {
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            int topInset = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            if (topInset > 0) {
                this.mStatusBarScrim.setBounds(0, -this.mCurrentOffset, getWidth(), topInset - this.mCurrentOffset);
                this.mStatusBarScrim.mutate().setAlpha(this.mScrimAlpha);
                this.mStatusBarScrim.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Drawable drawable;
        ensureToolbar();
        if (child == this.mToolbar && (drawable = this.mContentScrim) != null && this.mScrimAlpha > 0) {
            drawable.mutate().setAlpha(this.mScrimAlpha);
            this.mContentScrim.draw(canvas);
        }
        return super.drawChild(canvas, child, drawingTime);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Drawable drawable = this.mContentScrim;
        if (drawable != null) {
            drawable.setBounds(0, 0, w, h);
        }
    }

    private void ensureToolbar() {
        if (this.mRefreshToolbar) {
            this.mToolbar = null;
            this.mToolbarDirectChild = null;
            int i = this.mToolbarId;
            if (i != -1) {
                Toolbar findViewById = findViewById(i);
                this.mToolbar = findViewById;
                if (findViewById != null) {
                    this.mToolbarDirectChild = findDirectChild(findViewById);
                }
            }
            if (this.mToolbar == null) {
                Toolbar toolbar = null;
                int i2 = 0;
                int count = getChildCount();
                while (true) {
                    if (i2 >= count) {
                        break;
                    }
                    Toolbar toolbar2 = getChildAt(i2);
                    if (toolbar2 instanceof Toolbar) {
                        toolbar = toolbar2;
                        break;
                    }
                    i2++;
                }
                this.mToolbar = toolbar;
            }
            updateDummyView();
            this.mRefreshToolbar = false;
        }
    }

    private View findDirectChild(View descendant) {
        View directChild = descendant;
        ViewParent p = descendant.getParent();
        while (p != this && p != null) {
            if (p instanceof View) {
                directChild = (View) p;
            }
            p = p.getParent();
        }
        return directChild;
    }

    private void updateDummyView() {
        View view;
        if (!this.mCollapsingTitleEnabled && (view = this.mDummyView) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mDummyView);
            }
        }
        if (this.mCollapsingTitleEnabled && this.mToolbar != null) {
            if (this.mDummyView == null) {
                this.mDummyView = new View(getContext());
            }
            if (this.mDummyView.getParent() == null) {
                this.mToolbar.addView(this.mDummyView, -1, -1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ensureToolbar();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int insetTop;
        View view;
        int i;
        int i2;
        super.onLayout(changed, left, top, right, bottom);
        if (this.mCollapsingTitleEnabled && (view = this.mDummyView) != null) {
            boolean z = false;
            boolean z2 = ViewCompat.isAttachedToWindow(view) && this.mDummyView.getVisibility() == 0;
            this.mDrawCollapsingTitle = z2;
            if (z2) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    z = true;
                }
                boolean isRtl = z;
                int bottomOffset = 0;
                View view2 = this.mToolbarDirectChild;
                if (!(view2 == null || view2 == this)) {
                    bottomOffset = ((LayoutParams) view2.getLayoutParams()).bottomMargin;
                }
                ViewGroupUtils.getDescendantRect(this, this.mDummyView, this.mTmpRect);
                CollapsingTextHelper collapsingTextHelper = this.mCollapsingTextHelper;
                int i3 = this.mTmpRect.left;
                if (isRtl) {
                    i = this.mToolbar.getTitleMarginEnd();
                } else {
                    i = this.mToolbar.getTitleMarginStart();
                }
                int i4 = i3 + i;
                int titleMarginTop = ((this.mToolbar.getTitleMarginTop() + bottom) - this.mTmpRect.height()) - bottomOffset;
                int i5 = this.mTmpRect.right;
                if (isRtl) {
                    i2 = this.mToolbar.getTitleMarginStart();
                } else {
                    i2 = this.mToolbar.getTitleMarginEnd();
                }
                collapsingTextHelper.setCollapsedBounds(i4, titleMarginTop, i5 + i2, (bottom - bottomOffset) - this.mToolbar.getTitleMarginBottom());
                this.mCollapsingTextHelper.setExpandedBounds(isRtl ? this.mExpandedMarginEnd : this.mExpandedMarginStart, this.mTmpRect.bottom + this.mExpandedMarginTop, (right - left) - (isRtl ? this.mExpandedMarginStart : this.mExpandedMarginEnd), (bottom - top) - this.mExpandedMarginBottom);
                this.mCollapsingTextHelper.recalculate();
            }
        }
        int z3 = getChildCount();
        for (int i6 = 0; i6 < z3; i6++) {
            View child = getChildAt(i6);
            if (this.mLastInsets != null && !ViewCompat.getFitsSystemWindows(child) && child.getTop() < (insetTop = this.mLastInsets.getSystemWindowInsetTop())) {
                ViewCompat.offsetTopAndBottom(child, insetTop);
            }
            getViewOffsetHelper(child).onViewLayout();
        }
        if (this.mToolbar != null) {
            if (this.mCollapsingTitleEnabled && TextUtils.isEmpty(this.mCollapsingTextHelper.getText())) {
                this.mCollapsingTextHelper.setText(this.mToolbar.getTitle());
            }
            View view3 = this.mToolbarDirectChild;
            if (view3 == null || view3 == this) {
                setMinimumHeight(getHeightWithMargins(this.mToolbar));
            } else {
                setMinimumHeight(getHeightWithMargins(view3));
            }
        }
    }

    private static int getHeightWithMargins(View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (!(lp instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) lp;
        return view.getHeight() + mlp.topMargin + mlp.bottomMargin;
    }

    /* access modifiers changed from: private */
    public static ViewOffsetHelper getViewOffsetHelper(View view) {
        ViewOffsetHelper offsetHelper = (ViewOffsetHelper) view.getTag(2131427338);
        if (offsetHelper != null) {
            return offsetHelper;
        }
        ViewOffsetHelper offsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(2131427338, offsetHelper2);
        return offsetHelper2;
    }

    public void setTitle(CharSequence title) {
        this.mCollapsingTextHelper.setText(title);
    }

    public CharSequence getTitle() {
        if (this.mCollapsingTitleEnabled) {
            return this.mCollapsingTextHelper.getText();
        }
        return null;
    }

    public void setTitleEnabled(boolean enabled) {
        if (enabled != this.mCollapsingTitleEnabled) {
            this.mCollapsingTitleEnabled = enabled;
            updateDummyView();
            requestLayout();
        }
    }

    public boolean isTitleEnabled() {
        return this.mCollapsingTitleEnabled;
    }

    public void setScrimsShown(boolean shown) {
        setScrimsShown(shown, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setScrimsShown(boolean shown, boolean animate) {
        if (this.mScrimsAreShown != shown) {
            int i = KotlinVersion.MAX_COMPONENT_VALUE;
            if (animate) {
                if (!shown) {
                    i = 0;
                }
                animateScrim(i);
            } else {
                if (!shown) {
                    i = 0;
                }
                setScrimAlpha(i);
            }
            this.mScrimsAreShown = shown;
        }
    }

    private void animateScrim(int targetAlpha) {
        ensureToolbar();
        ValueAnimatorCompat valueAnimatorCompat = this.mScrimAnimator;
        if (valueAnimatorCompat == null) {
            ValueAnimatorCompat createAnimator = ViewUtils.createAnimator();
            this.mScrimAnimator = createAnimator;
            createAnimator.setDuration(this.mScrimAnimationDuration);
            this.mScrimAnimator.setInterpolator(targetAlpha > this.mScrimAlpha ? AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR : AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
            this.mScrimAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimatorCompat animator) {
                    CollapsingToolbarLayout.this.setScrimAlpha(animator.getAnimatedIntValue());
                }
            });
        } else if (valueAnimatorCompat.isRunning()) {
            this.mScrimAnimator.cancel();
        }
        this.mScrimAnimator.setIntValues(this.mScrimAlpha, targetAlpha);
        this.mScrimAnimator.start();
    }

    /* access modifiers changed from: private */
    public void setScrimAlpha(int alpha) {
        Toolbar toolbar;
        if (alpha != this.mScrimAlpha) {
            if (!(this.mContentScrim == null || (toolbar = this.mToolbar) == null)) {
                ViewCompat.postInvalidateOnAnimation(toolbar);
            }
            this.mScrimAlpha = alpha;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.mContentScrim;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mContentScrim = drawable3;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.mContentScrim.setCallback(this);
                this.mContentScrim.setAlpha(this.mScrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(int color) {
        setContentScrim(new ColorDrawable(color));
    }

    public void setContentScrimResource(int resId) {
        setContentScrim(ContextCompat.getDrawable(getContext(), resId));
    }

    public Drawable getContentScrim() {
        return this.mContentScrim;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarScrim;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarScrim = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarScrim.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.mStatusBarScrim, ViewCompat.getLayoutDirection(this));
                this.mStatusBarScrim.setVisible(getVisibility() == 0, false);
                this.mStatusBarScrim.setCallback(this);
                this.mStatusBarScrim.setAlpha(this.mScrimAlpha);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] state = getDrawableState();
        boolean changed = false;
        Drawable d = this.mStatusBarScrim;
        if (d != null && d.isStateful()) {
            changed = false | d.setState(state);
        }
        Drawable d2 = this.mContentScrim;
        if (d2 != null && d2.isStateful()) {
            changed |= d2.setState(state);
        }
        if (changed) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.mContentScrim || who == this.mStatusBarScrim;
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        boolean visible = visibility == 0;
        Drawable drawable = this.mStatusBarScrim;
        if (!(drawable == null || drawable.isVisible() == visible)) {
            this.mStatusBarScrim.setVisible(visible, false);
        }
        Drawable drawable2 = this.mContentScrim;
        if (drawable2 != null && drawable2.isVisible() != visible) {
            this.mContentScrim.setVisible(visible, false);
        }
    }

    public void setStatusBarScrimColor(int color) {
        setStatusBarScrim(new ColorDrawable(color));
    }

    public void setStatusBarScrimResource(int resId) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), resId));
    }

    public Drawable getStatusBarScrim() {
        return this.mStatusBarScrim;
    }

    public void setCollapsedTitleTextAppearance(int resId) {
        this.mCollapsingTextHelper.setCollapsedTextAppearance(resId);
    }

    public void setCollapsedTitleTextColor(int color) {
        this.mCollapsingTextHelper.setCollapsedTextColor(color);
    }

    public void setCollapsedTitleGravity(int gravity) {
        this.mCollapsingTextHelper.setCollapsedTextGravity(gravity);
    }

    public int getCollapsedTitleGravity() {
        return this.mCollapsingTextHelper.getCollapsedTextGravity();
    }

    public void setExpandedTitleTextAppearance(int resId) {
        this.mCollapsingTextHelper.setExpandedTextAppearance(resId);
    }

    public void setExpandedTitleColor(int color) {
        this.mCollapsingTextHelper.setExpandedTextColor(color);
    }

    public void setExpandedTitleGravity(int gravity) {
        this.mCollapsingTextHelper.setExpandedTextGravity(gravity);
    }

    public int getExpandedTitleGravity() {
        return this.mCollapsingTextHelper.getExpandedTextGravity();
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.mCollapsingTextHelper.setCollapsedTypeface(typeface);
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.mCollapsingTextHelper.getCollapsedTypeface();
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.mCollapsingTextHelper.setExpandedTypeface(typeface);
    }

    public Typeface getExpandedTitleTypeface() {
        return this.mCollapsingTextHelper.getExpandedTypeface();
    }

    public void setExpandedTitleMargin(int start, int top, int end, int bottom) {
        this.mExpandedMarginStart = start;
        this.mExpandedMarginTop = top;
        this.mExpandedMarginEnd = end;
        this.mExpandedMarginBottom = bottom;
        requestLayout();
    }

    public int getExpandedTitleMarginStart() {
        return this.mExpandedMarginStart;
    }

    public void setExpandedTitleMarginStart(int margin) {
        this.mExpandedMarginStart = margin;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.mExpandedMarginTop;
    }

    public void setExpandedTitleMarginTop(int margin) {
        this.mExpandedMarginTop = margin;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.mExpandedMarginEnd;
    }

    public void setExpandedTitleMarginEnd(int margin) {
        this.mExpandedMarginEnd = margin;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.mExpandedMarginBottom;
    }

    public void setExpandedTitleMarginBottom(int margin) {
        this.mExpandedMarginBottom = margin;
        requestLayout();
    }

    public void setScrimVisibleHeightTrigger(int height) {
        if (this.mScrimVisibleHeightTrigger != height) {
            this.mScrimVisibleHeightTrigger = height;
            updateScrimVisibility();
        }
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.mScrimVisibleHeightTrigger;
        if (i >= 0) {
            return i;
        }
        WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
        int insetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minHeight = ViewCompat.getMinimumHeight(this);
        if (minHeight > 0) {
            return Math.min((minHeight * 2) + insetTop, getHeight());
        }
        return getHeight() / 3;
    }

    public void setScrimAnimationDuration(long duration) {
        this.mScrimAnimationDuration = duration;
    }

    public long getScrimAnimationDuration() {
        return this.mScrimAnimationDuration;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int mCollapseMode = 0;
        float mParallaxMult = DEFAULT_PARALLAX_MULTIPLIER;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.CollapsingToolbarLayout_Layout);
            this.mCollapseMode = a.getInt(0, 0);
            setParallaxMultiplier(a.getFloat(1, DEFAULT_PARALLAX_MULTIPLIER));
            a.recycle();
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(int width, int height, int gravity) {
            super(width, height, gravity);
        }

        public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
        }

        public LayoutParams(FrameLayout.LayoutParams source) {
            super(source);
        }

        public void setCollapseMode(int collapseMode) {
            this.mCollapseMode = collapseMode;
        }

        public int getCollapseMode() {
            return this.mCollapseMode;
        }

        public void setParallaxMultiplier(float multiplier) {
            this.mParallaxMult = multiplier;
        }

        public float getParallaxMultiplier() {
            return this.mParallaxMult;
        }
    }

    /* access modifiers changed from: package-private */
    public final void updateScrimVisibility() {
        if (this.mContentScrim != null || this.mStatusBarScrim != null) {
            setScrimsShown(getHeight() + this.mCurrentOffset < getScrimVisibleHeightTrigger());
        }
    }

    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        private OffsetUpdateListener() {
        }

        public void onOffsetChanged(AppBarLayout layout, int verticalOffset) {
            int unused = CollapsingToolbarLayout.this.mCurrentOffset = verticalOffset;
            int insetTop = CollapsingToolbarLayout.this.mLastInsets != null ? CollapsingToolbarLayout.this.mLastInsets.getSystemWindowInsetTop() : 0;
            int z = CollapsingToolbarLayout.this.getChildCount();
            for (int i = 0; i < z; i++) {
                View child = CollapsingToolbarLayout.this.getChildAt(i);
                LayoutParams lp = (LayoutParams) child.getLayoutParams();
                ViewOffsetHelper offsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(child);
                int i2 = lp.mCollapseMode;
                if (i2 != 1) {
                    if (i2 == 2) {
                        offsetHelper.setTopAndBottomOffset(Math.round(((float) (-verticalOffset)) * lp.mParallaxMult));
                    }
                } else if ((CollapsingToolbarLayout.this.getHeight() - insetTop) + verticalOffset >= child.getHeight()) {
                    offsetHelper.setTopAndBottomOffset(-verticalOffset);
                }
            }
            CollapsingToolbarLayout.this.updateScrimVisibility();
            if (CollapsingToolbarLayout.this.mStatusBarScrim != null && insetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(CollapsingToolbarLayout.this);
            }
            CollapsingToolbarLayout.this.mCollapsingTextHelper.setExpansionFraction(((float) Math.abs(verticalOffset)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - insetTop)));
        }
    }
}
