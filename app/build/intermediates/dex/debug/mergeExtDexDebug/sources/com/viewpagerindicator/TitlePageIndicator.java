package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
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
import java.util.ArrayList;
import kotlin.KotlinVersion;

public class TitlePageIndicator extends View implements PageIndicator {
    private static final float BOLD_FADE_PERCENTAGE = 0.05f;
    private static final String EMPTY_TITLE = "";
    private static final int INVALID_POINTER = -1;
    private static final float SELECTION_FADE_PERCENTAGE = 0.25f;
    private int mActivePointerId;
    private boolean mBoldText;
    private final Rect mBounds;
    private OnCenterItemClickListener mCenterItemClickListener;
    private float mClipPadding;
    private int mColorSelected;
    private int mColorText;
    private int mCurrentPage;
    private float mFooterIndicatorHeight;
    private IndicatorStyle mFooterIndicatorStyle;
    private float mFooterIndicatorUnderlinePadding;
    private float mFooterLineHeight;
    private float mFooterPadding;
    private boolean mIsDragging;
    private float mLastMotionX;
    private LinePosition mLinePosition;
    private ViewPager.OnPageChangeListener mListener;
    private float mPageOffset;
    private final Paint mPaintFooterIndicator;
    private final Paint mPaintFooterLine;
    private final Paint mPaintText;
    private Path mPath;
    private int mScrollState;
    private float mTitlePadding;
    private float mTopPadding;
    private int mTouchSlop;
    private ViewPager mViewPager;

    public interface OnCenterItemClickListener {
        void onCenterItemClick(int i);
    }

    public enum IndicatorStyle {
        None(0),
        Triangle(1),
        Underline(2);
        
        public final int value;

        private IndicatorStyle(int value2) {
            this.value = value2;
        }

        public static IndicatorStyle fromValue(int value2) {
            for (IndicatorStyle style : values()) {
                if (style.value == value2) {
                    return style;
                }
            }
            return null;
        }
    }

    public enum LinePosition {
        Bottom(0),
        Top(1);
        
        public final int value;

        private LinePosition(int value2) {
            this.value = value2;
        }

        public static LinePosition fromValue(int value2) {
            for (LinePosition position : values()) {
                if (position.value == value2) {
                    return position;
                }
            }
            return null;
        }
    }

    public TitlePageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public TitlePageIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.vpiTitlePageIndicatorStyle);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitlePageIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mCurrentPage = -1;
        Paint paint = new Paint();
        this.mPaintText = paint;
        this.mPath = new Path();
        this.mBounds = new Rect();
        Paint paint2 = new Paint();
        this.mPaintFooterLine = paint2;
        Paint paint3 = new Paint();
        this.mPaintFooterIndicator = paint3;
        this.mLastMotionX = -1.0f;
        this.mActivePointerId = -1;
        if (!isInEditMode()) {
            Resources res = getResources();
            int defaultFooterColor = res.getColor(R.color.default_title_indicator_footer_color);
            float defaultFooterLineHeight = res.getDimension(R.dimen.default_title_indicator_footer_line_height);
            int defaultFooterIndicatorStyle = res.getInteger(R.integer.default_title_indicator_footer_indicator_style);
            float defaultFooterIndicatorHeight = res.getDimension(R.dimen.default_title_indicator_footer_indicator_height);
            float defaultFooterIndicatorUnderlinePadding = res.getDimension(R.dimen.default_title_indicator_footer_indicator_underline_padding);
            float defaultFooterPadding = res.getDimension(R.dimen.default_title_indicator_footer_padding);
            int defaultLinePosition = res.getInteger(R.integer.default_title_indicator_line_position);
            int defaultSelectedColor = res.getColor(R.color.default_title_indicator_selected_color);
            boolean defaultSelectedBold = res.getBoolean(R.bool.default_title_indicator_selected_bold);
            int defaultTextColor = res.getColor(R.color.default_title_indicator_text_color);
            float defaultTextSize = res.getDimension(R.dimen.default_title_indicator_text_size);
            Paint paint4 = paint3;
            float defaultTitlePadding = res.getDimension(R.dimen.default_title_indicator_title_padding);
            Paint paint5 = paint2;
            float defaultClipPadding = res.getDimension(R.dimen.default_title_indicator_clip_padding);
            Paint paint6 = paint;
            float defaultTopPadding = res.getDimension(R.dimen.default_title_indicator_top_padding);
            Resources resources = res;
            boolean defaultSelectedBold2 = defaultSelectedBold;
            float defaultTextSize2 = defaultTextSize;
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitlePageIndicator, defStyle, 0);
            this.mFooterLineHeight = a.getDimension(6, defaultFooterLineHeight);
            this.mFooterIndicatorStyle = IndicatorStyle.fromValue(a.getInteger(7, defaultFooterIndicatorStyle));
            this.mFooterIndicatorHeight = a.getDimension(8, defaultFooterIndicatorHeight);
            this.mFooterIndicatorUnderlinePadding = a.getDimension(9, defaultFooterIndicatorUnderlinePadding);
            this.mFooterPadding = a.getDimension(10, defaultFooterPadding);
            this.mLinePosition = LinePosition.fromValue(a.getInteger(11, defaultLinePosition));
            this.mTopPadding = a.getDimension(14, defaultTopPadding);
            this.mTitlePadding = a.getDimension(13, defaultTitlePadding);
            this.mClipPadding = a.getDimension(4, defaultClipPadding);
            this.mColorSelected = a.getColor(3, defaultSelectedColor);
            float f = defaultTopPadding;
            int defaultTextColor2 = defaultTextColor;
            float f2 = defaultClipPadding;
            this.mColorText = a.getColor(1, defaultTextColor2);
            this.mBoldText = a.getBoolean(12, defaultSelectedBold2);
            float defaultTextSize3 = defaultTextSize2;
            float defaultTextSize4 = defaultTextColor2;
            float textSize = a.getDimension(0, defaultTextSize3);
            float f3 = defaultTextSize3;
            float f4 = defaultTitlePadding;
            int footerColor = a.getColor(5, defaultFooterColor);
            Paint paint7 = paint6;
            paint7.setTextSize(textSize);
            float f5 = textSize;
            paint7.setAntiAlias(true);
            Paint paint8 = paint5;
            paint8.setStyle(Paint.Style.FILL_AND_STROKE);
            paint8.setStrokeWidth(this.mFooterLineHeight);
            paint8.setColor(footerColor);
            Paint paint9 = paint4;
            paint9.setStyle(Paint.Style.FILL_AND_STROKE);
            paint9.setColor(footerColor);
            Drawable background = a.getDrawable(2);
            if (background != null) {
                setBackgroundDrawable(background);
            }
            a.recycle();
            TypedArray typedArray = a;
            this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    public int getFooterColor() {
        return this.mPaintFooterLine.getColor();
    }

    public void setFooterColor(int footerColor) {
        this.mPaintFooterLine.setColor(footerColor);
        this.mPaintFooterIndicator.setColor(footerColor);
        invalidate();
    }

    public float getFooterLineHeight() {
        return this.mFooterLineHeight;
    }

    public void setFooterLineHeight(float footerLineHeight) {
        this.mFooterLineHeight = footerLineHeight;
        this.mPaintFooterLine.setStrokeWidth(footerLineHeight);
        invalidate();
    }

    public float getFooterIndicatorHeight() {
        return this.mFooterIndicatorHeight;
    }

    public void setFooterIndicatorHeight(float footerTriangleHeight) {
        this.mFooterIndicatorHeight = footerTriangleHeight;
        invalidate();
    }

    public float getFooterIndicatorPadding() {
        return this.mFooterPadding;
    }

    public void setFooterIndicatorPadding(float footerIndicatorPadding) {
        this.mFooterPadding = footerIndicatorPadding;
        invalidate();
    }

    public IndicatorStyle getFooterIndicatorStyle() {
        return this.mFooterIndicatorStyle;
    }

    public void setFooterIndicatorStyle(IndicatorStyle indicatorStyle) {
        this.mFooterIndicatorStyle = indicatorStyle;
        invalidate();
    }

    public LinePosition getLinePosition() {
        return this.mLinePosition;
    }

    public void setLinePosition(LinePosition linePosition) {
        this.mLinePosition = linePosition;
        invalidate();
    }

    public int getSelectedColor() {
        return this.mColorSelected;
    }

    public void setSelectedColor(int selectedColor) {
        this.mColorSelected = selectedColor;
        invalidate();
    }

    public boolean isSelectedBold() {
        return this.mBoldText;
    }

    public void setSelectedBold(boolean selectedBold) {
        this.mBoldText = selectedBold;
        invalidate();
    }

    public int getTextColor() {
        return this.mColorText;
    }

    public void setTextColor(int textColor) {
        this.mPaintText.setColor(textColor);
        this.mColorText = textColor;
        invalidate();
    }

    public float getTextSize() {
        return this.mPaintText.getTextSize();
    }

    public void setTextSize(float textSize) {
        this.mPaintText.setTextSize(textSize);
        invalidate();
    }

    public float getTitlePadding() {
        return this.mTitlePadding;
    }

    public void setTitlePadding(float titlePadding) {
        this.mTitlePadding = titlePadding;
        invalidate();
    }

    public float getTopPadding() {
        return this.mTopPadding;
    }

    public void setTopPadding(float topPadding) {
        this.mTopPadding = topPadding;
        invalidate();
    }

    public float getClipPadding() {
        return this.mClipPadding;
    }

    public void setClipPadding(float clipPadding) {
        this.mClipPadding = clipPadding;
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        this.mPaintText.setTypeface(typeface);
        invalidate();
    }

    public Typeface getTypeface() {
        return this.mPaintText.getTypeface();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int width;
        float offsetPercent;
        int page;
        int width2;
        int height;
        int page2;
        int count;
        int width3;
        int right;
        int count2;
        int width4;
        Rect curPageBound;
        float curPageWidth;
        ViewPager viewPager;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null && (width = viewPager2.getAdapter().getCount()) != 0) {
            if (this.mCurrentPage == -1 && (viewPager = this.mViewPager) != null) {
                this.mCurrentPage = viewPager.getCurrentItem();
            }
            ArrayList<Rect> bounds = calculateAllBounds(this.mPaintText);
            int boundsSize = bounds.size();
            if (this.mCurrentPage >= boundsSize) {
                setCurrentItem(boundsSize - 1);
                return;
            }
            int countMinusOne = width - 1;
            float halfWidth = ((float) getWidth()) / 2.0f;
            int left = getLeft();
            float leftClip = ((float) left) + this.mClipPadding;
            int width5 = getWidth();
            int height2 = getHeight();
            int right2 = left + width5;
            float rightClip = ((float) right2) - this.mClipPadding;
            int page3 = this.mCurrentPage;
            float f = this.mPageOffset;
            if (((double) f) <= 0.5d) {
                page = page3;
                offsetPercent = this.mPageOffset;
            } else {
                page = page3 + 1;
                offsetPercent = 1.0f - f;
            }
            boolean currentSelected = offsetPercent <= SELECTION_FADE_PERCENTAGE;
            boolean currentBold = offsetPercent <= BOLD_FADE_PERCENTAGE;
            float selectedPercent = (SELECTION_FADE_PERCENTAGE - offsetPercent) / SELECTION_FADE_PERCENTAGE;
            Rect curPageBound2 = bounds.get(this.mCurrentPage);
            float curPageWidth2 = (float) (curPageBound2.right - curPageBound2.left);
            if (((float) curPageBound2.left) < leftClip) {
                clipViewOnTheLeft(curPageBound2, curPageWidth2, left);
            }
            if (((float) curPageBound2.right) > rightClip) {
                clipViewOnTheRight(curPageBound2, curPageWidth2, right2);
            }
            int i = this.mCurrentPage;
            if (i > 0) {
                int i2 = i - 1;
                while (i2 >= 0) {
                    Rect bound = bounds.get(i2);
                    if (((float) bound.left) < leftClip) {
                        curPageWidth = curPageWidth2;
                        int w = bound.right - bound.left;
                        clipViewOnTheLeft(bound, (float) w, left);
                        Rect rightBound = bounds.get(i2 + 1);
                        curPageBound = curPageBound2;
                        width4 = width5;
                        if (((float) bound.right) + this.mTitlePadding > ((float) rightBound.left)) {
                            bound.left = (int) (((float) (rightBound.left - w)) - this.mTitlePadding);
                            bound.right = bound.left + w;
                        }
                    } else {
                        curPageWidth = curPageWidth2;
                        curPageBound = curPageBound2;
                        width4 = width5;
                    }
                    i2--;
                    curPageWidth2 = curPageWidth;
                    curPageBound2 = curPageBound;
                    width5 = width4;
                }
                Rect rect = curPageBound2;
                width2 = width5;
            } else {
                Rect rect2 = curPageBound2;
                width2 = width5;
            }
            int i3 = this.mCurrentPage;
            if (i3 < countMinusOne) {
                for (int i4 = i3 + 1; i4 < width; i4++) {
                    Rect bound2 = bounds.get(i4);
                    if (((float) bound2.right) > rightClip) {
                        int w2 = bound2.right - bound2.left;
                        clipViewOnTheRight(bound2, (float) w2, right2);
                        Rect leftBound = bounds.get(i4 - 1);
                        if (((float) bound2.left) - this.mTitlePadding < ((float) leftBound.right)) {
                            bound2.left = (int) (((float) leftBound.right) + this.mTitlePadding);
                            bound2.right = bound2.left + w2;
                        }
                    }
                }
            }
            int colorTextAlpha = this.mColorText >>> 24;
            int i5 = 0;
            while (i5 < width) {
                Rect bound3 = bounds.get(i5);
                if ((bound3.left <= left || bound3.left >= right2) && (bound3.right <= left || bound3.right >= right2)) {
                    page2 = page;
                    right = right2;
                    count = width;
                    count2 = width2;
                    width3 = i5;
                } else {
                    boolean currentPage = i5 == page;
                    CharSequence pageTitle = getTitle(i5);
                    this.mPaintText.setFakeBoldText(currentPage && currentBold && this.mBoldText);
                    this.mPaintText.setColor(this.mColorText);
                    if (currentPage && currentSelected) {
                        this.mPaintText.setAlpha(colorTextAlpha - ((int) (((float) colorTextAlpha) * selectedPercent)));
                    }
                    if (i5 < boundsSize - 1) {
                        Rect rightBound2 = bounds.get(i5 + 1);
                        if (((float) bound3.right) + this.mTitlePadding > ((float) rightBound2.left)) {
                            int w3 = bound3.right - bound3.left;
                            Rect rect3 = rightBound2;
                            bound3.left = (int) (((float) (rightBound2.left - w3)) - this.mTitlePadding);
                            bound3.right = bound3.left + w3;
                        }
                    }
                    Rect bound4 = bound3;
                    page2 = page;
                    right = right2;
                    count = width;
                    count2 = width2;
                    width3 = i5;
                    canvas.drawText(pageTitle, 0, pageTitle.length(), (float) bound3.left, ((float) bound3.bottom) + this.mTopPadding, this.mPaintText);
                    if (!currentPage || !currentSelected) {
                    } else {
                        this.mPaintText.setColor(this.mColorSelected);
                        this.mPaintText.setAlpha((int) (((float) (this.mColorSelected >>> 24)) * selectedPercent));
                        Rect bound5 = bound4;
                        Rect rect4 = bound5;
                        canvas.drawText(pageTitle, 0, pageTitle.length(), (float) bound5.left, ((float) bound5.bottom) + this.mTopPadding, this.mPaintText);
                    }
                }
                i5 = width3 + 1;
                width2 = count2;
                right2 = right;
                width = count;
                page = page2;
            }
            int page4 = page;
            int i6 = right2;
            int i7 = width;
            int width6 = width2;
            int width7 = i5;
            float footerLineHeight = this.mFooterLineHeight;
            float footerIndicatorLineHeight = this.mFooterIndicatorHeight;
            if (this.mLinePosition == LinePosition.Top) {
                footerLineHeight = -footerLineHeight;
                footerIndicatorLineHeight = -footerIndicatorLineHeight;
                height = 0;
            } else {
                height = height2;
            }
            this.mPath.reset();
            this.mPath.moveTo(0.0f, ((float) height) - (footerLineHeight / 2.0f));
            this.mPath.lineTo((float) width6, ((float) height) - (footerLineHeight / 2.0f));
            this.mPath.close();
            canvas2.drawPath(this.mPath, this.mPaintFooterLine);
            float heightMinusLine = ((float) height) - footerLineHeight;
            int i8 = AnonymousClass1.$SwitchMap$com$viewpagerindicator$TitlePageIndicator$IndicatorStyle[this.mFooterIndicatorStyle.ordinal()];
            if (i8 == 1) {
                int i9 = height;
                this.mPath.reset();
                this.mPath.moveTo(halfWidth, heightMinusLine - footerIndicatorLineHeight);
                this.mPath.lineTo(halfWidth + footerIndicatorLineHeight, heightMinusLine);
                this.mPath.lineTo(halfWidth - footerIndicatorLineHeight, heightMinusLine);
                this.mPath.close();
                canvas2.drawPath(this.mPath, this.mPaintFooterIndicator);
            } else if (i8 != 2) {
                float f2 = footerLineHeight;
                int i10 = height;
            } else if (currentSelected) {
                int page5 = page4;
                if (page5 >= boundsSize) {
                    float f3 = footerLineHeight;
                    int i11 = height;
                    int i12 = page5;
                    return;
                }
                Rect underlineBounds = bounds.get(page5);
                float f4 = footerLineHeight;
                float rightPlusPadding = ((float) underlineBounds.right) + this.mFooterIndicatorUnderlinePadding;
                int i13 = height;
                float leftMinusPadding = ((float) underlineBounds.left) - this.mFooterIndicatorUnderlinePadding;
                float heightMinusLineMinusIndicator = heightMinusLine - footerIndicatorLineHeight;
                int i14 = page5;
                this.mPath.reset();
                this.mPath.moveTo(leftMinusPadding, heightMinusLine);
                this.mPath.lineTo(rightPlusPadding, heightMinusLine);
                this.mPath.lineTo(rightPlusPadding, heightMinusLineMinusIndicator);
                this.mPath.lineTo(leftMinusPadding, heightMinusLineMinusIndicator);
                this.mPath.close();
                float f5 = leftMinusPadding;
                this.mPaintFooterIndicator.setAlpha((int) (selectedPercent * 255.0f));
                canvas2.drawPath(this.mPath, this.mPaintFooterIndicator);
                this.mPaintFooterIndicator.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
            } else {
                int i15 = height;
            }
        }
    }

    /* renamed from: com.viewpagerindicator.TitlePageIndicator$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$viewpagerindicator$TitlePageIndicator$IndicatorStyle;

        static {
            int[] iArr = new int[IndicatorStyle.values().length];
            $SwitchMap$com$viewpagerindicator$TitlePageIndicator$IndicatorStyle = iArr;
            try {
                iArr[IndicatorStyle.Triangle.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$viewpagerindicator$TitlePageIndicator$IndicatorStyle[IndicatorStyle.Underline.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
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
                float rightThird = halfWidth + sixthWidth;
                float eventX = ev.getX();
                if (eventX < halfWidth - sixthWidth) {
                    int i = this.mCurrentPage;
                    if (i > 0) {
                        if (action != 3) {
                            this.mViewPager.setCurrentItem(i - 1);
                        }
                        return true;
                    }
                } else if (eventX > rightThird) {
                    int i2 = this.mCurrentPage;
                    if (i2 < count - 1) {
                        if (action != 3) {
                            this.mViewPager.setCurrentItem(i2 + 1);
                        }
                        return true;
                    }
                } else {
                    OnCenterItemClickListener onCenterItemClickListener = this.mCenterItemClickListener;
                    if (!(onCenterItemClickListener == null || action == 3)) {
                        onCenterItemClickListener.onCenterItemClick(this.mCurrentPage);
                    }
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

    private void clipViewOnTheRight(Rect curViewBound, float curViewWidth, int right) {
        curViewBound.right = (int) (((float) right) - this.mClipPadding);
        curViewBound.left = (int) (((float) curViewBound.right) - curViewWidth);
    }

    private void clipViewOnTheLeft(Rect curViewBound, float curViewWidth, int left) {
        curViewBound.left = (int) (((float) left) + this.mClipPadding);
        curViewBound.right = (int) (this.mClipPadding + curViewWidth);
    }

    private ArrayList<Rect> calculateAllBounds(Paint paint) {
        ArrayList<Rect> list = new ArrayList<>();
        int count = this.mViewPager.getAdapter().getCount();
        int width = getWidth();
        int halfWidth = width / 2;
        for (int i = 0; i < count; i++) {
            Rect bounds = calcBounds(i, paint);
            int w = bounds.right - bounds.left;
            int h = bounds.bottom - bounds.top;
            bounds.left = (int) ((((float) halfWidth) - (((float) w) / 2.0f)) + ((((float) (i - this.mCurrentPage)) - this.mPageOffset) * ((float) width)));
            bounds.right = bounds.left + w;
            bounds.top = 0;
            bounds.bottom = h;
            list.add(bounds);
        }
        return list;
    }

    private Rect calcBounds(int index, Paint paint) {
        Rect bounds = new Rect();
        CharSequence title = getTitle(index);
        bounds.right = (int) paint.measureText(title, 0, title.length());
        bounds.bottom = (int) (paint.descent() - paint.ascent());
        return bounds;
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

    public void notifyDataSetChanged() {
        invalidate();
    }

    public void setOnCenterItemClickListener(OnCenterItemClickListener listener) {
        this.mCenterItemClickListener = listener;
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
        if (this.mScrollState == 0) {
            this.mCurrentPage = position;
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
        float height;
        int measuredWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        if (View.MeasureSpec.getMode(heightMeasureSpec) == 1073741824) {
            height = (float) View.MeasureSpec.getSize(heightMeasureSpec);
        } else {
            this.mBounds.setEmpty();
            this.mBounds.bottom = (int) (this.mPaintText.descent() - this.mPaintText.ascent());
            height = ((float) (this.mBounds.bottom - this.mBounds.top)) + this.mFooterLineHeight + this.mFooterPadding + this.mTopPadding;
            if (this.mFooterIndicatorStyle != IndicatorStyle.None) {
                height += this.mFooterIndicatorHeight;
            }
        }
        setMeasuredDimension(measuredWidth, (int) height);
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
                return new SavedState(in, (AnonymousClass1) null);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int currentPage;

        /* synthetic */ SavedState(Parcel x0, AnonymousClass1 x1) {
            this(x0);
        }

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

    private CharSequence getTitle(int i) {
        CharSequence title = this.mViewPager.getAdapter().getPageTitle(i);
        if (title == null) {
            return "";
        }
        return title;
    }
}
