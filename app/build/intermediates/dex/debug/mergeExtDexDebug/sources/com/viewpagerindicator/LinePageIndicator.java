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
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import kotlin.KotlinVersion;

public class LinePageIndicator extends View implements PageIndicator {
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private boolean mCentered;
    private int mCurrentPage;
    private float mGapWidth;
    private boolean mIsDragging;
    private float mLastMotionX;
    private float mLineWidth;
    private ViewPager.OnPageChangeListener mListener;
    private final Paint mPaintSelected;
    private final Paint mPaintUnselected;
    private int mTouchSlop;
    private ViewPager mViewPager;

    public LinePageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinePageIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.vpiLinePageIndicatorStyle);
    }

    public LinePageIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Paint paint = new Paint(1);
        this.mPaintUnselected = paint;
        Paint paint2 = new Paint(1);
        this.mPaintSelected = paint2;
        this.mLastMotionX = -1.0f;
        this.mActivePointerId = -1;
        if (!isInEditMode()) {
            Resources res = getResources();
            int defaultSelectedColor = res.getColor(R.color.default_line_indicator_selected_color);
            int defaultUnselectedColor = res.getColor(R.color.default_line_indicator_unselected_color);
            float defaultLineWidth = res.getDimension(R.dimen.default_line_indicator_line_width);
            float defaultGapWidth = res.getDimension(R.dimen.default_line_indicator_gap_width);
            float defaultStrokeWidth = res.getDimension(R.dimen.default_line_indicator_stroke_width);
            boolean defaultCentered = res.getBoolean(R.bool.default_line_indicator_centered);
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LinePageIndicator, defStyle, 0);
            this.mCentered = a.getBoolean(1, defaultCentered);
            this.mLineWidth = a.getDimension(5, defaultLineWidth);
            this.mGapWidth = a.getDimension(6, defaultGapWidth);
            setStrokeWidth(a.getDimension(3, defaultStrokeWidth));
            paint.setColor(a.getColor(4, defaultUnselectedColor));
            paint2.setColor(a.getColor(2, defaultSelectedColor));
            Drawable background = a.getDrawable(0);
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

    public void setUnselectedColor(int unselectedColor) {
        this.mPaintUnselected.setColor(unselectedColor);
        invalidate();
    }

    public int getUnselectedColor() {
        return this.mPaintUnselected.getColor();
    }

    public void setSelectedColor(int selectedColor) {
        this.mPaintSelected.setColor(selectedColor);
        invalidate();
    }

    public int getSelectedColor() {
        return this.mPaintSelected.getColor();
    }

    public void setLineWidth(float lineWidth) {
        this.mLineWidth = lineWidth;
        invalidate();
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public void setStrokeWidth(float lineHeight) {
        this.mPaintSelected.setStrokeWidth(lineHeight);
        this.mPaintUnselected.setStrokeWidth(lineHeight);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.mPaintSelected.getStrokeWidth();
    }

    public void setGapWidth(float gapWidth) {
        this.mGapWidth = gapWidth;
        invalidate();
    }

    public float getGapWidth() {
        return this.mGapWidth;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int count;
        float horizontalOffset;
        super.onDraw(canvas);
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null && (count = viewPager.getAdapter().getCount()) != 0) {
            if (this.mCurrentPage >= count) {
                setCurrentItem(count - 1);
                return;
            }
            float f = this.mLineWidth;
            float f2 = this.mGapWidth;
            float lineWidthAndGap = f + f2;
            float indicatorWidth = (((float) count) * lineWidthAndGap) - f2;
            float paddingTop = (float) getPaddingTop();
            float paddingLeft = (float) getPaddingLeft();
            float paddingRight = (float) getPaddingRight();
            float verticalOffset = (((((float) getHeight()) - paddingTop) - ((float) getPaddingBottom())) / 2.0f) + paddingTop;
            float horizontalOffset2 = paddingLeft;
            if (this.mCentered) {
                horizontalOffset = horizontalOffset2 + ((((((float) getWidth()) - paddingLeft) - paddingRight) / 2.0f) - (indicatorWidth / 2.0f));
            } else {
                horizontalOffset = horizontalOffset2;
            }
            int i = 0;
            while (i < count) {
                float dx1 = horizontalOffset + (((float) i) * lineWidthAndGap);
                canvas.drawLine(dx1, verticalOffset, dx1 + this.mLineWidth, verticalOffset, i == this.mCurrentPage ? this.mPaintSelected : this.mPaintUnselected);
                i++;
            }
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

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener((ViewPager.OnPageChangeListener) null);
            }
            if (viewPager.getAdapter() != null) {
                this.mViewPager = viewPager;
                viewPager.setOnPageChangeListener(this);
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
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(state);
        }
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    public void onPageSelected(int position) {
        this.mCurrentPage = position;
        invalidate();
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
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        float result;
        ViewPager viewPager;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        if (specMode == 1073741824 || (viewPager = this.mViewPager) == null) {
            result = (float) specSize;
        } else {
            int count = viewPager.getAdapter().getCount();
            result = ((float) (getPaddingLeft() + getPaddingRight())) + (((float) count) * this.mLineWidth) + (((float) (count - 1)) * this.mGapWidth);
            if (specMode == Integer.MIN_VALUE) {
                result = Math.min(result, (float) specSize);
            }
        }
        return (int) FloatMath.ceil(result);
    }

    private int measureHeight(int measureSpec) {
        float result;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);
        if (specMode == 1073741824) {
            result = (float) specSize;
        } else {
            result = this.mPaintSelected.getStrokeWidth() + ((float) getPaddingTop()) + ((float) getPaddingBottom());
            if (specMode == Integer.MIN_VALUE) {
                result = Math.min(result, (float) specSize);
            }
        }
        return (int) FloatMath.ceil(result);
    }

    public void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mCurrentPage = savedState.currentPage;
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
