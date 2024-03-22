package com.shuhart.bubblepagerindicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class BubblePageIndicator extends MotionIndicator implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {
    private static final float ADD_RADIUS_DEFAULT = 1.0f;
    private static final int ANIMATE_IDLE = 2002;
    private static final int ANIMATE_SHIFT_LEFT = 2000;
    private static final int ANIMATE_SHIFT_RIGHT = 2001;
    private static final long ANIMATION_TIME = 300;
    private static final int SWIPE_LEFT = 1001;
    private static final int SWIPE_RIGHT = 1000;
    /* access modifiers changed from: private */
    public int animationState;
    private DataSetObserver dataSetObserver;
    private float marginBetweenCircles;
    /* access modifiers changed from: private */
    public float offset;
    private int onSurfaceCount;
    private final Paint paintFill;
    private final Paint paintPageFill;
    private float radius;
    private int risingCount;
    private float scaleRadiusCorrection;
    private int scrollState;
    /* access modifiers changed from: private */
    public int startX;
    private int surfaceEnd;
    private int surfaceStart;
    private int swipeDirection;
    private ValueAnimator translationAnim;

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    public void ensureState() {
        correctSurfaceIfDataSetChanges();
        if (this.currentPage >= getCount() && getCount() != 0) {
            this.currentPage = getCount() - 1;
        }
        correctStartXOnDataSetChanges();
    }

    private void correctSurfaceIfDataSetChanges() {
        if (this.onSurfaceCount != (this.surfaceEnd - this.surfaceStart) + 1) {
            int i = this.currentPage;
            this.surfaceStart = i;
            this.surfaceEnd = (i + this.onSurfaceCount) - 1;
        }
        if (getCount() != 0 && this.surfaceEnd > getCount() - 1) {
            int count = getCount();
            int i2 = this.onSurfaceCount;
            if (count > i2) {
                int count2 = getCount() - 1;
                this.surfaceEnd = count2;
                this.surfaceStart = count2 - (this.onSurfaceCount - 1);
                return;
            }
            this.surfaceEnd = i2 - 1;
            this.surfaceStart = 0;
        }
    }

    private void correctStartXOnDataSetChanges() {
        int initial;
        if (this.startX != Integer.MIN_VALUE && this.startX != (initial = getInitialStartX())) {
            int i = this.surfaceEnd;
            int i2 = this.onSurfaceCount;
            if (i > i2 - 1) {
                initial = (int) (((float) initial) - (((float) (i - (i2 - 1))) * (this.marginBetweenCircles + (this.radius * 2.0f))));
                if (getCount() - this.onSurfaceCount <= 1) {
                    initial = (int) (((float) initial) - (this.marginBetweenCircles + (this.radius * 2.0f)));
                }
            }
            this.startX = initial;
        }
    }

    public BubblePageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public BubblePageIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.bpi_indicatorStyle);
    }

    public BubblePageIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Paint paint = new Paint(1);
        this.paintPageFill = paint;
        Paint paint2 = new Paint(1);
        this.paintFill = paint2;
        this.scaleRadiusCorrection = 1.0f;
        this.startX = Integer.MIN_VALUE;
        this.animationState = ANIMATE_IDLE;
        this.dataSetObserver = new DataSetObserver() {
            public void onChanged() {
                BubblePageIndicator.this.ensureState();
                BubblePageIndicator.this.forceLayoutChanges();
            }
        };
        if (!isInEditMode()) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BubblePageIndicator, defStyle, 0);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(a.getColor(R.styleable.BubblePageIndicator_bpi_pageColor, 0));
            paint2.setStyle(Paint.Style.FILL);
            paint2.setColor(a.getColor(R.styleable.BubblePageIndicator_bpi_fillColor, 0));
            this.radius = (float) a.getDimensionPixelSize(R.styleable.BubblePageIndicator_bpi_radius, 0);
            this.marginBetweenCircles = (float) a.getDimensionPixelSize(R.styleable.BubblePageIndicator_bpi_marginBetweenCircles, 0);
            this.onSurfaceCount = a.getInteger(R.styleable.BubblePageIndicator_bpi_onSurfaceCount, 0);
            this.risingCount = a.getInteger(R.styleable.BubblePageIndicator_bpi_risingCount, 0);
            a.recycle();
            this.surfaceStart = 0;
            this.surfaceEnd = this.onSurfaceCount - 1;
        }
    }

    public void setScaleRadiusCorrection(float value) {
        this.scaleRadiusCorrection = value;
        forceLayoutChanges();
    }

    public void setOnSurfaceCount(int onSurfaceCount2) {
        this.onSurfaceCount = onSurfaceCount2;
        ensureState();
        forceLayoutChanges();
    }

    public void setRisingCount(int risingCount2) {
        this.risingCount = risingCount2;
        forceLayoutChanges();
    }

    public void setPageColor(int pageColor) {
        this.paintPageFill.setColor(pageColor);
        invalidate();
    }

    public int getPageColor() {
        return this.paintPageFill.getColor();
    }

    public void setFillColor(int fillColor) {
        this.paintFill.setColor(fillColor);
        invalidate();
    }

    public int getFillColor() {
        return this.paintFill.getColor();
    }

    public void setRadius(float radius2) {
        this.radius = radius2;
        forceLayoutChanges();
    }

    public void setMarginBetweenCircles(float margin) {
        this.marginBetweenCircles = margin;
        forceLayoutChanges();
    }

    public float getRadius() {
        return this.radius;
    }

    /* access modifiers changed from: protected */
    public int getCount() {
        if (this.viewPager == null || this.viewPager.getAdapter() == null) {
            return 0;
        }
        return this.viewPager.getAdapter().getCount();
    }

    public int getPaddingLeft() {
        return (int) Math.max((float) super.getPaddingLeft(), this.marginBetweenCircles);
    }

    public int getPaddingRight() {
        return (int) Math.max((float) super.getPaddingRight(), this.marginBetweenCircles);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int count;
        super.onDraw(canvas);
        if (this.viewPager != null && (count = getCount()) != 0 && count != 1) {
            float shortOffset = ((float) getPaddingTop()) + this.radius + 1.0f;
            drawStrokedCircles(canvas, count, shortOffset, (float) this.startX);
            drawFilledCircle(canvas, shortOffset, (float) this.startX);
        }
    }

    private void drawStrokedCircles(Canvas canvas, int count, float shortOffset, float startX2) {
        if (this.paintPageFill.getAlpha() != 0) {
            for (int iLoop = 0; iLoop < count; iLoop++) {
                int i = this.surfaceStart;
                int i2 = this.risingCount;
                if (iLoop >= i - i2) {
                    if (iLoop <= this.surfaceEnd + i2) {
                        float dX = (((float) iLoop) * ((this.radius * 2.0f) + this.marginBetweenCircles)) + startX2;
                        if (dX >= 0.0f && dX <= ((float) getWidth())) {
                            canvas.drawCircle(dX, shortOffset, getScaledRadius(this.radius, iLoop), this.paintPageFill);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private float getScaledRadius(float radius2, int position) {
        int i = this.surfaceStart;
        float add = 0.0f;
        int i2 = 1;
        if (position < i) {
            if (i - position == 1) {
                add = this.scaleRadiusCorrection;
            }
            int i3 = this.swipeDirection;
            if (i3 == SWIPE_LEFT && this.animationState == ANIMATE_SHIFT_LEFT) {
                float finalRadius = (radius2 / ((float) (2 << ((i - position) - 1)))) + add;
                float f = (radius2 / ((float) (2 << ((i - position) - 1)))) * 2.0f;
                if ((i - position) - 1 != 1) {
                    i2 = 0;
                }
                float currentRadius = f + ((float) i2);
                return currentRadius - ((1.0f - this.offset) * (currentRadius - finalRadius));
            } else if (i3 != SWIPE_RIGHT || this.animationState != ANIMATE_SHIFT_RIGHT) {
                return (radius2 / ((float) (2 << ((i - position) - 1)))) + add;
            } else {
                float currentRadius2 = radius2 / ((float) (2 << (i - position)));
                return ((1.0f - this.offset) * (((radius2 / ((float) (2 << ((i - position) - 1)))) + add) - currentRadius2)) + currentRadius2;
            }
        } else {
            int i4 = this.surfaceEnd;
            if (position > i4) {
                if (position - i4 == 1) {
                    add = this.scaleRadiusCorrection;
                }
                int i5 = this.swipeDirection;
                if (i5 == SWIPE_LEFT && this.animationState == ANIMATE_SHIFT_LEFT) {
                    float currentRadius3 = radius2 / ((float) (2 << (position - i4)));
                    return ((1.0f - this.offset) * ((((radius2 / ((float) (2 << (position - i4)))) * 2.0f) + add) - currentRadius3)) + currentRadius3;
                } else if (i5 != SWIPE_RIGHT || this.animationState != ANIMATE_SHIFT_RIGHT) {
                    return (radius2 / ((float) (2 << ((position - i4) - 1)))) + add;
                } else {
                    float finalRadius2 = (radius2 / ((float) (2 << ((position - i4) - 1)))) + add;
                    return (this.offset * finalRadius2) + finalRadius2;
                }
            } else if (position != this.currentPage) {
                return radius2;
            } else {
                int i6 = this.swipeDirection;
                if (i6 == SWIPE_LEFT && this.animationState == ANIMATE_SHIFT_LEFT) {
                    float f2 = this.scaleRadiusCorrection;
                    float currentRadius4 = (radius2 / 2.0f) + f2;
                    return ((1.0f - this.offset) * ((radius2 + f2) - currentRadius4)) + currentRadius4;
                } else if (i6 != SWIPE_RIGHT || this.animationState != ANIMATE_SHIFT_RIGHT) {
                    return this.scaleRadiusCorrection + radius2;
                } else {
                    float f3 = this.scaleRadiusCorrection;
                    float currentRadius5 = (radius2 / 2.0f) + f3;
                    return ((1.0f - this.offset) * ((radius2 + f3) - currentRadius5)) + currentRadius5;
                }
            }
        }
    }

    private void drawFilledCircle(Canvas canvas, float shortOffset, float startX2) {
        float f = this.radius;
        canvas.drawCircle(startX2 + (((float) this.currentPage) * ((2.0f * f) + this.marginBetweenCircles)), shortOffset, getScaledRadius(f, this.currentPage), this.paintFill);
    }

    public void setViewPager(ViewPager view) {
        if (this.viewPager != null) {
            this.viewPager.removeOnPageChangeListener(this);
            this.viewPager.removeOnAdapterChangeListener(this);
            try {
                this.viewPager.getAdapter().unregisterDataSetObserver(this.dataSetObserver);
            } catch (Exception e) {
            }
        }
        if (view.getAdapter() != null) {
            this.viewPager = view;
            this.viewPager.getAdapter().registerDataSetObserver(this.dataSetObserver);
            this.viewPager.addOnAdapterChangeListener(this);
            this.viewPager.addOnPageChangeListener(this);
            forceLayoutChanges();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public void onAdapterChanged(ViewPager viewPager, PagerAdapter oldAdapter, PagerAdapter newAdapter) {
        this.startX = Integer.MIN_VALUE;
        forceLayoutChanges();
    }

    /* access modifiers changed from: private */
    public void forceLayoutChanges() {
        requestLayout();
        invalidate();
    }

    public void setViewPager(ViewPager view, int initialPosition) {
        setViewPager(view);
        setCurrentItem(initialPosition);
    }

    public void setCurrentItem(int item) {
        if (this.viewPager == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        } else if (item >= 0 && item <= getCount()) {
            this.viewPager.setCurrentItem(item);
        }
    }

    public void notifyDataSetChanged() {
        ensureState();
        forceLayoutChanges();
    }

    public void onPageScrollStateChanged(int state) {
        this.scrollState = state;
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (Math.abs(this.viewPager.getCurrentItem() - position) > 1) {
            onPageManuallyChanged(this.viewPager.getCurrentItem());
        } else if (position == this.currentPage) {
            if (((double) positionOffset) >= 0.5d && this.currentPage + 1 < getCount()) {
                this.swipeDirection = SWIPE_LEFT;
                this.currentPage++;
                if (this.currentPage > this.surfaceEnd) {
                    this.animationState = ANIMATE_SHIFT_LEFT;
                    correctSurface();
                    invalidate();
                    int i = this.startX;
                    animateShifting(i, (int) (((float) i) - (this.marginBetweenCircles + (this.radius * 2.0f))));
                    return;
                }
                this.animationState = ANIMATE_IDLE;
                invalidate();
            }
        } else if (position < this.currentPage && ((double) positionOffset) <= 0.5d) {
            this.swipeDirection = SWIPE_RIGHT;
            this.currentPage = position;
            if (this.currentPage < this.surfaceStart) {
                this.animationState = ANIMATE_SHIFT_RIGHT;
                correctSurface();
                invalidate();
                int i2 = this.startX;
                animateShifting(i2, (int) (((float) i2) + this.marginBetweenCircles + (this.radius * 2.0f)));
                return;
            }
            this.animationState = ANIMATE_IDLE;
            invalidate();
        }
    }

    private void animateShifting(final int from, final int to) {
        ValueAnimator valueAnimator = this.translationAnim;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.translationAnim.end();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{from, to});
        this.translationAnim = ofInt;
        ofInt.setDuration(ANIMATION_TIME);
        this.translationAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        this.translationAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BubblePageIndicator bubblePageIndicator = BubblePageIndicator.this;
                int i = to;
                float unused = bubblePageIndicator.offset = (((float) (val - i)) * 1.0f) / ((float) (from - i));
                int unused2 = BubblePageIndicator.this.startX = val;
                BubblePageIndicator.this.invalidate();
            }
        });
        this.translationAnim.addListener(new AnimatorListener() {
            public void onAnimationEnd(Animator animator) {
                int unused = BubblePageIndicator.this.animationState = BubblePageIndicator.ANIMATE_IDLE;
                int unused2 = BubblePageIndicator.this.startX = to;
                float unused3 = BubblePageIndicator.this.offset = 0.0f;
                BubblePageIndicator.this.invalidate();
            }
        });
        this.translationAnim.start();
    }

    private void correctSurface() {
        if (this.currentPage > this.surfaceEnd) {
            int i = this.currentPage;
            this.surfaceEnd = i;
            this.surfaceStart = i - (this.onSurfaceCount - 1);
        } else if (this.currentPage < this.surfaceStart) {
            int i2 = this.currentPage;
            this.surfaceStart = i2;
            this.surfaceEnd = i2 + (this.onSurfaceCount - 1);
        }
    }

    public void onPageSelected(final int position) {
        if (this.scrollState != 0) {
            return;
        }
        if (this.startX == Integer.MIN_VALUE) {
            post(new Runnable() {
                public void run() {
                    BubblePageIndicator.this.onPageManuallyChanged(position);
                }
            });
        } else {
            onPageManuallyChanged(position);
        }
    }

    /* access modifiers changed from: private */
    public void onPageManuallyChanged(int position) {
        this.currentPage = position;
        int oldSurfaceStart = this.surfaceStart;
        int oldSurfaceEnd = this.surfaceEnd;
        correctSurface();
        correctStartXOnPageManuallyChanged(oldSurfaceStart, oldSurfaceEnd);
        invalidate();
    }

    private void correctStartXOnPageManuallyChanged(int oldSurfaceStart, int oldSurfaceEnd) {
        int corrected;
        if (this.currentPage < oldSurfaceStart || this.currentPage > oldSurfaceEnd) {
            int corrected2 = this.startX;
            if (this.currentPage < oldSurfaceStart) {
                corrected = (int) (((float) corrected2) + (((float) (oldSurfaceStart - this.currentPage)) * (this.marginBetweenCircles + (this.radius * 2.0f))));
            } else {
                corrected = (int) (((float) corrected2) - (((float) (this.currentPage - oldSurfaceEnd)) * (this.marginBetweenCircles + (this.radius * 2.0f))));
            }
            this.startX = corrected;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
        measureStartX();
    }

    private void measureStartX() {
        if (this.startX == Integer.MIN_VALUE) {
            this.startX = getInitialStartX();
        }
    }

    private int getInitialStartX() {
        int risingCount2;
        int result = getInternalPaddingLeft();
        if (getCount() > this.onSurfaceCount && (risingCount2 = getInternalRisingCount()) != 0) {
            return (int) (((float) result) + (((float) risingCount2) * this.radius * 2.0f) + (((float) (risingCount2 - 1)) * this.marginBetweenCircles));
        }
        return result;
    }

    private int getInternalRisingCount() {
        if (getCount() < this.onSurfaceCount + this.risingCount) {
            return getCount() - this.onSurfaceCount;
        }
        return this.risingCount;
    }

    private int getInternalPaddingLeft() {
        return (int) (((float) getPaddingLeft()) + this.radius);
    }

    private int measureWidth(int measureSpec) {
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        if (specMode == 1073741824 || this.viewPager == null) {
            return specSize;
        }
        int result = calculateExactWidth();
        if (specMode == Integer.MIN_VALUE) {
            return Math.min(result, specSize);
        }
        return result;
    }

    private int calculateExactWidth() {
        int maxSurfaceCount = Math.min(getCount(), this.onSurfaceCount);
        int risingCount2 = getInternalRisingCount();
        float f = this.radius;
        float f2 = this.marginBetweenCircles;
        int result = (int) (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (maxSurfaceCount * 2)) * f) + (((float) (maxSurfaceCount - 1)) * f2));
        if (risingCount2 > 0) {
            return (int) (((float) result) + (((((((float) risingCount2) * f) * 2.0f) + (((float) (risingCount2 - 1)) * f2)) + ((float) getInitialStartX())) - ((float) getInternalPaddingLeft())));
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        if (specMode == 1073741824) {
            return specSize;
        }
        int result = (int) (((this.radius + this.scaleRadiusCorrection) * 2.0f) + ((float) getPaddingTop()) + ((float) getPaddingBottom()));
        if (specMode == Integer.MIN_VALUE) {
            return Math.min(result, specSize);
        }
        return result;
    }
}
