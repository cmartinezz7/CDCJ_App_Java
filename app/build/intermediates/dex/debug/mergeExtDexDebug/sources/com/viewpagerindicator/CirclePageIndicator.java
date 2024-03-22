package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import kotlin.KotlinVersion;

public class CirclePageIndicator extends View implements PageIndicator {
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private boolean mCentered;
    private int mCurrentPage;
    private boolean mIsDragging;
    private float mLastMotionX;
    private ViewPager.OnPageChangeListener mListener;
    private int mOrientation;
    private float mPageOffset;
    private final Paint mPaintFill;
    private final Paint mPaintPageFill;
    private final Paint mPaintStroke;
    private float mRadius;
    private int mScrollState;
    private boolean mSnap;
    private int mSnapPage;
    private int mTouchSlop;
    private ViewPager mViewPager;

    public CirclePageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public CirclePageIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.vpiCirclePageIndicatorStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CirclePageIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Paint paint = new Paint(1);
        this.mPaintPageFill = paint;
        Paint paint2 = new Paint(1);
        this.mPaintStroke = paint2;
        Paint paint3 = new Paint(1);
        this.mPaintFill = paint3;
        this.mLastMotionX = -1.0f;
        this.mActivePointerId = -1;
        if (!isInEditMode()) {
            Resources res = getResources();
            int defaultPageColor = res.getColor(R.color.default_circle_indicator_page_color);
            int defaultFillColor = res.getColor(R.color.default_circle_indicator_fill_color);
            int defaultOrientation = res.getInteger(R.integer.default_circle_indicator_orientation);
            int defaultStrokeColor = res.getColor(R.color.default_circle_indicator_stroke_color);
            float defaultStrokeWidth = res.getDimension(R.dimen.default_circle_indicator_stroke_width);
            float defaultRadius = res.getDimension(R.dimen.default_circle_indicator_radius);
            boolean defaultCentered = res.getBoolean(R.bool.default_circle_indicator_centered);
            Resources resources = res;
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CirclePageIndicator, defStyle, 0);
            this.mCentered = a.getBoolean(2, defaultCentered);
            this.mOrientation = a.getInt(0, defaultOrientation);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(a.getColor(5, defaultPageColor));
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(a.getColor(8, defaultStrokeColor));
            paint2.setStrokeWidth(a.getDimension(3, defaultStrokeWidth));
            paint3.setStyle(Paint.Style.FILL);
            paint3.setColor(a.getColor(4, defaultFillColor));
            this.mRadius = a.getDimension(6, defaultRadius);
            this.mSnap = a.getBoolean(7, res.getBoolean(R.bool.default_circle_indicator_snap));
            Drawable background = a.getDrawable(1);
            if (background != null) {
                setBackgroundDrawable(background);
            }
            a.recycle();
            this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    public void setCentered(boolean centered) {
        this.mCentered = centered;
        invalidate();
    }

    public boolean isCentered() {
        return this.mCentered;
    }

    public void setPageColor(int pageColor) {
        this.mPaintPageFill.setColor(pageColor);
        invalidate();
    }

    public int getPageColor() {
        return this.mPaintPageFill.getColor();
    }

    public void setFillColor(int fillColor) {
        this.mPaintFill.setColor(fillColor);
        invalidate();
    }

    public int getFillColor() {
        return this.mPaintFill.getColor();
    }

    public void setOrientation(int orientation) {
        if (orientation == 0 || orientation == 1) {
            this.mOrientation = orientation;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setStrokeColor(int strokeColor) {
        this.mPaintStroke.setColor(strokeColor);
        invalidate();
    }

    public int getStrokeColor() {
        return this.mPaintStroke.getColor();
    }

    public void setStrokeWidth(float strokeWidth) {
        this.mPaintStroke.setStrokeWidth(strokeWidth);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.mPaintStroke.getStrokeWidth();
    }

    public void setRadius(float radius) {
        this.mRadius = radius;
        invalidate();
    }

    public float getRadius() {
        return this.mRadius;
    }

    public void setSnap(boolean snap) {
        this.mSnap = snap;
        invalidate();
    }

    public boolean isSnap() {
        return this.mSnap;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int count;
        int shortPaddingBefore;
        int longPaddingAfter;
        int longPaddingBefore;
        int longSize;
        float dY;
        float dX;
        float dY2;
        float dX2;
        int count2;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null && (count = viewPager.getAdapter().getCount()) != 0) {
            if (this.mCurrentPage >= count) {
                setCurrentItem(count - 1);
                return;
            }
            if (this.mOrientation == 0) {
                longSize = getWidth();
                longPaddingBefore = getPaddingLeft();
                longPaddingAfter = getPaddingRight();
                shortPaddingBefore = getPaddingTop();
            } else {
                longSize = getHeight();
                longPaddingBefore = getPaddingTop();
                longPaddingAfter = getPaddingBottom();
                shortPaddingBefore = getPaddingLeft();
            }
            float f = this.mRadius;
            float threeRadius = 3.0f * f;
            float shortOffset = ((float) shortPaddingBefore) + f;
            float longOffset = ((float) longPaddingBefore) + f;
            if (this.mCentered) {
                longOffset += (((float) ((longSize - longPaddingBefore) - longPaddingAfter)) / 2.0f) - ((((float) count) * threeRadius) / 2.0f);
            }
            float pageFillRadius = this.mRadius;
            if (this.mPaintStroke.getStrokeWidth() > 0.0f) {
                pageFillRadius -= this.mPaintStroke.getStrokeWidth() / 2.0f;
            }
            int iLoop = 0;
            while (iLoop < count) {
                float drawLong = (((float) iLoop) * threeRadius) + longOffset;
                if (this.mOrientation == 0) {
                    dX2 = drawLong;
                    dY2 = shortOffset;
                } else {
                    dX2 = shortOffset;
                    dY2 = drawLong;
                }
                if (this.mPaintPageFill.getAlpha() > 0) {
                    canvas2.drawCircle(dX2, dY2, pageFillRadius, this.mPaintPageFill);
                }
                float f2 = this.mRadius;
                if (pageFillRadius != f2) {
                    count2 = count;
                    canvas2.drawCircle(dX2, dY2, f2, this.mPaintStroke);
                } else {
                    count2 = count;
                }
                iLoop++;
                count = count2;
            }
            int count3 = this.mSnap;
            float cx = ((float) (count3 != 0 ? this.mSnapPage : this.mCurrentPage)) * threeRadius;
            if (count3 == 0) {
                cx += this.mPageOffset * threeRadius;
            }
            if (this.mOrientation == 0) {
                dX = longOffset + cx;
                dY = shortOffset;
            } else {
                dX = shortOffset;
                dY = longOffset + cx;
            }
            canvas2.drawCircle(dX, dY, this.mRadius, this.mPaintFill);
        }
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (super.onTouchEvent(ev)) {
            return true;
        }
        ViewPager viewPager = this.mViewPager;
        int newPointerIndex = 0;
        if (viewPager == null || viewPager.getAdapter().getCount() == 0) {
            return false;
        }
        int action = ev.getAction() & KotlinVersion.MAX_COMPONENT_VALUE;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = MotionEventCompat.getX(ev, MotionEventCompat.findPointerIndex(ev, this.mActivePointerId));
                    float deltaX = x - this.mLastMotionX;
                    if (!this.mIsDragging && Math.abs(deltaX) > ((float) this.mTouchSlop)) {
                        this.mIsDragging = true;
                    }
                    if (this.mIsDragging) {
                        this.mLastMotionX = x;
                        if (this.mViewPager.isFakeDragging() || this.mViewPager.beginFakeDrag()) {
                            this.mViewPager.fakeDragBy(deltaX);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int index = MotionEventCompat.getActionIndex(ev);
                        this.mLastMotionX = MotionEventCompat.getX(ev, index);
                        this.mActivePointerId = MotionEventCompat.getPointerId(ev, index);
                    } else if (action == 6) {
                        int pointerIndex = MotionEventCompat.getActionIndex(ev);
                        if (MotionEventCompat.getPointerId(ev, pointerIndex) == this.mActivePointerId) {
                            if (pointerIndex == 0) {
                                newPointerIndex = 1;
                            }
                            this.mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
                        }
                        this.mLastMotionX = MotionEventCompat.getX(ev, MotionEventCompat.findPointerIndex(ev, this.mActivePointerId));
                    }
                }
            }
            if (!this.mIsDragging) {
                int count = this.mViewPager.getAdapter().getCount();
                int width = getWidth();
                float halfWidth = ((float) width) / 2.0f;
                float sixthWidth = ((float) width) / 6.0f;
                if (this.mCurrentPage > 0 && ev.getX() < halfWidth - sixthWidth) {
                    if (action != 3) {
                        this.mViewPager.setCurrentItem(this.mCurrentPage - 1);
                    }
                    return true;
                } else if (this.mCurrentPage < count - 1 && ev.getX() > halfWidth + sixthWidth) {
                    if (action != 3) {
                        this.mViewPager.setCurrentItem(this.mCurrentPage + 1);
                    }
                    return true;
                }
            }
            this.mIsDragging = false;
            this.mActivePointerId = -1;
            if (this.mViewPager.isFakeDragging()) {
                this.mViewPager.endFakeDrag();
            }
        } else {
            this.mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
            this.mLastMotionX = ev.getX();
        }
        return true;
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
                invalidate();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }

    public void setViewPager(ViewPager view, int initialPosition) {
        setViewPager(view);
        setCurrentItem(initialPosition);
    }

    public void setCurrentItem(int item) {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(item);
            this.mCurrentPage = item;
            invalidate();
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void notifyDataSetChanged() {
        invalidate();
    }

    public void onPageScrollStateChanged(int state) {
        this.mScrollState = state;
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(state);
        }
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        this.mCurrentPage = position;
        this.mPageOffset = positionOffset;
        invalidate();
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    public void onPageSelected(int position) {
        if (this.mSnap || this.mScrollState == 0) {
            this.mCurrentPage = position;
            this.mSnapPage = position;
            invalidate();
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(position);
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        this.mListener = listener;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mOrientation == 0) {
            setMeasuredDimension(measureLong(widthMeasureSpec), measureShort(heightMeasureSpec));
        } else {
            setMeasuredDimension(measureShort(widthMeasureSpec), measureLong(heightMeasureSpec));
        }
    }

    private int measureLong(int measureSpec) {
        ViewPager viewPager;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        if (specMode == 1073741824 || (viewPager = this.mViewPager) == null) {
            return specSize;
        }
        int count = viewPager.getAdapter().getCount();
        float f = this.mRadius;
        int result = (int) (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (count * 2)) * f) + (((float) (count - 1)) * f) + 1.0f);
        if (specMode == Integer.MIN_VALUE) {
            return Math.min(result, specSize);
        }
        return result;
    }

    private int measureShort(int measureSpec) {
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        if (specMode == 1073741824) {
            return specSize;
        }
        int result = (int) ((this.mRadius * 2.0f) + ((float) getPaddingTop()) + ((float) getPaddingBottom()) + 1.0f);
        if (specMode == Integer.MIN_VALUE) {
            return Math.min(result, specSize);
        }
        return result;
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentPage = savedState.currentPage;
        this.mSnapPage = savedState.currentPage;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPage = this.mCurrentPage;
        return savedState;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int currentPage;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.currentPage = in.readInt();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.currentPage);
        }
    }
}
