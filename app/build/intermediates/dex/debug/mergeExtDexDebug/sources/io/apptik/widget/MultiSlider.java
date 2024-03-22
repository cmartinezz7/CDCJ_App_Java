package io.apptik.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import io.apptik.widget.mslider.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.io.ConstantsKt;

public class MultiSlider extends View {
    private static final int NO_ALPHA = 255;
    private final TypedArray a;
    private int defRangeColor;
    private Drawable defRangeDrawable;
    private int defThumbColor;
    private Drawable defThumbDrawable;
    LinkedList<Thumb> exactTouched;
    private AccessibilityNodeProvider mAccessibilityNodeProvider;
    private boolean mAttached;
    private float mDisabledAlpha;
    private List<Thumb> mDraggingThumbs;
    private boolean mDrawThumbsApart;
    private boolean mInDrawing;
    boolean mIsUserSeekable;
    private int mKeyProgressIncrement;
    int mMaxHeight;
    int mMaxWidth;
    int mMinHeight;
    int mMinWidth;
    boolean mMirrorForRtl;
    private boolean mNoInvalidate;
    private OnThumbValueChangeListener mOnThumbValueChangeListener;
    private OnTrackingChangeListener mOnTrackingChangeListener;
    private boolean mRefreshIsPosted;
    /* access modifiers changed from: private */
    public int mScaleMax;
    /* access modifiers changed from: private */
    public int mScaleMin;
    private int mScaledTouchSlop;
    private int mStep;
    /* access modifiers changed from: private */
    public int mStepsThumbsApart;
    /* access modifiers changed from: private */
    public LinkedList<Thumb> mThumbs;
    private float mTouchDownX;
    private Drawable mTrack;
    private long mUiThreadId;

    public interface OnThumbValueChangeListener {
        void onValueChanged(MultiSlider multiSlider, Thumb thumb, int i, int i2);
    }

    public interface OnTrackingChangeListener {
        void onStartTrackingTouch(MultiSlider multiSlider, Thumb thumb, int i);

        void onStopTrackingTouch(MultiSlider multiSlider, Thumb thumb, int i);
    }

    public class Thumb {
        private boolean isEnabled = true;
        private boolean isInvisible = false;
        int max;
        int min;
        Drawable range;
        String tag = "thumb";
        Drawable thumb;
        int thumbOffset;
        int value;

        public Thumb() {
            this.min = MultiSlider.this.mScaleMin;
            int access$100 = MultiSlider.this.mScaleMax;
            this.max = access$100;
            this.value = access$100;
        }

        public Drawable getRange() {
            return this.range;
        }

        public final Thumb setRange(Drawable range2) {
            this.range = range2;
            return this;
        }

        public boolean isEnabled() {
            return !isInvisibleThumb() && this.isEnabled;
        }

        public Thumb setEnabled(boolean enabled) {
            this.isEnabled = enabled;
            if (getThumb() != null) {
                if (isEnabled()) {
                    getThumb().setState(new int[]{16842910});
                } else {
                    getThumb().setState(new int[]{-16842910});
                }
            }
            return this;
        }

        public boolean isInvisibleThumb() {
            return this.isInvisible;
        }

        public void setInvisibleThumb(boolean invisibleThumb) {
            this.isInvisible = invisibleThumb;
        }

        public int getPossibleMin() {
            return this.min + (MultiSlider.this.mThumbs.indexOf(this) * MultiSlider.this.mStepsThumbsApart);
        }

        public int getPossibleMax() {
            return this.max - (((MultiSlider.this.mThumbs.size() - 1) - MultiSlider.this.mThumbs.indexOf(this)) * MultiSlider.this.mStepsThumbsApart);
        }

        public int getMin() {
            return this.min;
        }

        public Thumb setMin(int min2) {
            if (min2 > this.max) {
                min2 = this.max;
            }
            if (min2 < MultiSlider.this.mScaleMin) {
                min2 = MultiSlider.this.mScaleMin;
            }
            if (this.min != min2) {
                this.min = min2;
                if (this.value < min2) {
                    this.value = min2;
                    MultiSlider.this.invalidate();
                }
            }
            return this;
        }

        public int getMax() {
            return this.max;
        }

        public Thumb setMax(int max2) {
            if (max2 < this.min) {
                max2 = this.min;
            }
            if (max2 > MultiSlider.this.mScaleMax) {
                max2 = MultiSlider.this.mScaleMax;
            }
            if (this.max != max2) {
                this.max = max2;
                if (this.value > max2) {
                    this.value = max2;
                    MultiSlider.this.invalidate();
                }
            }
            return this;
        }

        public int getValue() {
            return this.value;
        }

        public Thumb setValue(int value2) {
            if (MultiSlider.this.mThumbs.contains(this)) {
                MultiSlider.this.setThumbValue(this, value2, false);
            } else {
                this.value = value2;
            }
            return this;
        }

        public String getTag() {
            return this.tag;
        }

        public Thumb setTag(String tag2) {
            this.tag = tag2;
            return this;
        }

        public Drawable getThumb() {
            return this.thumb;
        }

        public Thumb setThumb(Drawable mThumb) {
            this.thumb = mThumb;
            return this;
        }

        public int getThumbOffset() {
            return this.thumbOffset;
        }

        public Thumb setThumbOffset(int mThumbOffset) {
            this.thumbOffset = mThumbOffset;
            return this;
        }
    }

    public MultiSlider(Context context) {
        this(context, (AttributeSet) null);
    }

    public MultiSlider(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.multiSliderStyle);
    }

    public MultiSlider(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, 0);
    }

    public MultiSlider(Context context, AttributeSet attrs, int defStyle, int styleRes) {
        super(context, attrs, defStyle);
        this.mMirrorForRtl = true;
        this.mIsUserSeekable = true;
        this.mKeyProgressIncrement = 1;
        this.mDisabledAlpha = 0.5f;
        this.mDraggingThumbs = new LinkedList();
        this.exactTouched = null;
        this.defThumbColor = 0;
        this.defRangeColor = 0;
        if (Build.VERSION.SDK_INT >= 21 && getBackground() == null) {
            setBackgroundResource(R.drawable.control_background_multi_material);
        }
        this.mUiThreadId = Thread.currentThread().getId();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.MultiSlider, defStyle, styleRes);
        this.a = obtainStyledAttributes;
        this.mNoInvalidate = true;
        initMultiSlider(obtainStyledAttributes.getInt(R.styleable.MultiSlider_thumbNumber, 2));
        Drawable trackDrawable = obtainStyledAttributes.getDrawable(R.styleable.MultiSlider_android_track);
        setTrackDrawable(getTintedDrawable(trackDrawable == null ? ContextCompat.getDrawable(getContext(), R.drawable.multislider_track_material) : trackDrawable, obtainStyledAttributes.getColor(R.styleable.MultiSlider_trackColor, 0)));
        setStep(obtainStyledAttributes.getInt(R.styleable.MultiSlider_scaleStep, this.mStep));
        setStepsThumbsApart(obtainStyledAttributes.getInt(R.styleable.MultiSlider_stepsThumbsApart, this.mStepsThumbsApart));
        setDrawThumbsApart(obtainStyledAttributes.getBoolean(R.styleable.MultiSlider_drawThumbsApart, this.mDrawThumbsApart));
        setMax(obtainStyledAttributes.getInt(R.styleable.MultiSlider_scaleMax, this.mScaleMax), true);
        setMin(obtainStyledAttributes.getInt(R.styleable.MultiSlider_scaleMin, this.mScaleMin), true);
        this.mMirrorForRtl = obtainStyledAttributes.getBoolean(R.styleable.MultiSlider_mirrorForRTL, this.mMirrorForRtl);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.MultiSlider_android_thumb);
        this.defThumbDrawable = drawable;
        if (drawable == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.defThumbDrawable = ContextCompat.getDrawable(getContext(), R.drawable.multislider_thumb_material_anim);
            } else {
                this.defThumbDrawable = ContextCompat.getDrawable(getContext(), R.drawable.multislider_thumb_material);
            }
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.MultiSlider_range);
        this.defRangeDrawable = drawable2;
        if (drawable2 == null) {
            this.defRangeDrawable = ContextCompat.getDrawable(getContext(), R.drawable.multislider_range_material);
        }
        Drawable range1Drawable = obtainStyledAttributes.getDrawable(R.styleable.MultiSlider_range1);
        Drawable range2Drawable = obtainStyledAttributes.getDrawable(R.styleable.MultiSlider_range2);
        this.defRangeColor = obtainStyledAttributes.getColor(R.styleable.MultiSlider_rangeColor, 0);
        this.defThumbColor = obtainStyledAttributes.getColor(R.styleable.MultiSlider_thumbColor, 0);
        setThumbDrawables(this.defThumbDrawable, this.defRangeDrawable, range1Drawable, range2Drawable);
        setThumbOffset(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MultiSlider_android_thumbOffset, this.defThumbDrawable.getIntrinsicWidth() / 2));
        repositionThumbs();
        this.mScaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mNoInvalidate = false;
        obtainStyledAttributes.recycle();
    }

    public int getStepsThumbsApart() {
        return this.mStepsThumbsApart;
    }

    public void setStepsThumbsApart(int stepsThumbsApart) {
        if (stepsThumbsApart < 0) {
            stepsThumbsApart = 0;
        }
        this.mStepsThumbsApart = stepsThumbsApart;
    }

    public int getStep() {
        return this.mStep;
    }

    public void setStep(int mStep2) {
        this.mStep = mStep2;
    }

    public int getScaleSize() {
        return this.mScaleMax - this.mScaleMin;
    }

    public void repositionThumbs() {
        LinkedList<Thumb> linkedList = this.mThumbs;
        if (linkedList != null && !linkedList.isEmpty()) {
            if (this.mThumbs.size() > 0) {
                this.mThumbs.getFirst().setValue(this.mScaleMin);
            }
            if (this.mThumbs.size() > 1) {
                this.mThumbs.getLast().setValue(this.mScaleMax);
            }
            if (this.mThumbs.size() > 2) {
                int even = (this.mScaleMax - this.mScaleMin) / (this.mThumbs.size() - 1);
                int lastPos = this.mScaleMax - even;
                for (int i = this.mThumbs.size() - 2; i > 0; i--) {
                    this.mThumbs.get(i).setValue(lastPos);
                    lastPos -= even;
                }
            }
        }
    }

    public void setOnThumbValueChangeListener(OnThumbValueChangeListener l) {
        this.mOnThumbValueChangeListener = l;
    }

    public void setOnTrackingChangeListener(OnTrackingChangeListener l) {
        this.mOnTrackingChangeListener = l;
    }

    public boolean isDrawThumbsApart() {
        return this.mDrawThumbsApart;
    }

    public void setDrawThumbsApart(boolean drawThumbsApart) {
        this.mDrawThumbsApart = drawThumbsApart;
    }

    private void initMultiSlider(int numThumbs) {
        this.mStep = 1;
        this.mStepsThumbsApart = 0;
        this.mDrawThumbsApart = false;
        this.mScaleMin = 0;
        this.mScaleMax = 100;
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
        this.mThumbs = new LinkedList<>();
        for (int i = 0; i < numThumbs; i++) {
            this.mThumbs.add(new Thumb().setMin(this.mScaleMin).setMax(this.mScaleMax).setTag("thumb " + i));
        }
    }

    public MultiSlider setNumberOfThumbs(int numThumbs) {
        return setNumberOfThumbs(numThumbs, true);
    }

    public MultiSlider setNumberOfThumbs(int numThumbs, boolean repositon) {
        clearThumbs();
        for (int i = 0; i < numThumbs; i++) {
            addThumb(0);
        }
        if (repositon) {
            repositionThumbs();
        }
        return this;
    }

    public boolean addThumb(Thumb thumb) {
        return addThumbOnPos(thumb, this.mThumbs.size());
    }

    public boolean addThumbOnPos(Thumb thumb, int pos) {
        if (this.mThumbs.contains(thumb)) {
            return false;
        }
        if (thumb.getThumb() == null) {
            setThumbDrawable(thumb, this.defThumbDrawable, this.defThumbColor);
        }
        setPadding(Math.max(getPaddingLeft(), thumb.getThumbOffset()), getPaddingTop(), Math.max(getPaddingRight(), thumb.getThumbOffset()), getPaddingBottom());
        if (thumb.getRange() == null) {
            setRangeDrawable(thumb, this.defRangeDrawable, this.defRangeColor);
        }
        this.mThumbs.add(pos, thumb);
        setThumbValue(thumb, thumb.value, false);
        return true;
    }

    public Thumb addThumb(int value) {
        Thumb thumb = new Thumb();
        addThumb(thumb);
        thumb.setValue(value);
        return thumb;
    }

    public Thumb addThumb() {
        Thumb thumb = new Thumb();
        addThumb(thumb);
        return thumb;
    }

    public Thumb addThumbOnPos(int pos, int value) {
        Thumb thumb = new Thumb();
        addThumbOnPos(thumb, pos);
        thumb.setValue(value);
        return thumb;
    }

    public Thumb addThumbOnPos(int pos) {
        Thumb thumb = new Thumb();
        addThumbOnPos(thumb, pos);
        return thumb;
    }

    public boolean removeThumb(Thumb thumb) {
        this.mDraggingThumbs.remove(thumb);
        boolean res = this.mThumbs.remove(thumb);
        invalidate();
        return res;
    }

    public Thumb removeThumb(int thumbIndex) {
        this.mDraggingThumbs.remove(this.mThumbs.get(thumbIndex));
        invalidate();
        Thumb res = this.mThumbs.remove(thumbIndex);
        invalidate();
        return res;
    }

    public void clearThumbs() {
        this.mThumbs.clear();
        this.mDraggingThumbs.clear();
        invalidate();
    }

    public void setThumbOffset(int thumbOffset) {
        Iterator it = this.mThumbs.iterator();
        while (it.hasNext()) {
            ((Thumb) it.next()).setThumbOffset(thumbOffset);
        }
        invalidate();
    }

    public void setTrackDrawable(Drawable d) {
        boolean needUpdate;
        Drawable drawable = this.mTrack;
        if (drawable == null || d == drawable) {
            needUpdate = false;
        } else {
            drawable.setCallback((Drawable.Callback) null);
            needUpdate = true;
        }
        if (d != null) {
            d.setCallback(this);
            int drawableHeight = d.getMinimumHeight();
            if (this.mMaxHeight < drawableHeight) {
                this.mMaxHeight = drawableHeight;
                requestLayout();
            }
        }
        this.mTrack = d;
        if (needUpdate) {
            updateTrackBounds(getWidth(), getHeight());
            updateTrackState();
        }
    }

    private int optThumbValue(Thumb thumb, int value) {
        if (thumb == null || thumb.getThumb() == null) {
            return value;
        }
        int currIdx = this.mThumbs.indexOf(thumb);
        if (this.mThumbs.size() > currIdx + 1 && value > this.mThumbs.get(currIdx + 1).getValue() - (this.mStepsThumbsApart * this.mStep)) {
            value = this.mThumbs.get(currIdx + 1).getValue() - (this.mStepsThumbsApart * this.mStep);
        }
        if (currIdx > 0 && value < this.mThumbs.get(currIdx - 1).getValue() + (this.mStepsThumbsApart * this.mStep)) {
            value = this.mThumbs.get(currIdx - 1).getValue() + (this.mStepsThumbsApart * this.mStep);
        }
        int i = this.mScaleMin;
        int i2 = this.mStep;
        if ((value - i) % i2 != 0) {
            value += i2 - ((value - i) % i2);
        }
        if (value < thumb.getMin()) {
            value = thumb.getMin();
        }
        if (value > thumb.getMax()) {
            return thumb.getMax();
        }
        return value;
    }

    /* Debug info: failed to restart local var, previous not found, register: 3 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setThumbValue(io.apptik.widget.MultiSlider.Thumb r4, int r5, boolean r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 == 0) goto L_0x003c
            android.graphics.drawable.Drawable r0 = r4.getThumb()     // Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x000a
            goto L_0x003c
        L_0x000a:
            int r0 = r3.optThumbValue(r4, r5)     // Catch:{ all -> 0x0039 }
            r5 = r0
            int r0 = r4.getValue()     // Catch:{ all -> 0x0039 }
            if (r5 == r0) goto L_0x0017
            r4.value = r5     // Catch:{ all -> 0x0039 }
        L_0x0017:
            boolean r0 = r3.hasOnThumbValueChangeListener()     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x002c
            io.apptik.widget.MultiSlider$OnThumbValueChangeListener r0 = r3.mOnThumbValueChangeListener     // Catch:{ all -> 0x0039 }
            java.util.LinkedList<io.apptik.widget.MultiSlider$Thumb> r1 = r3.mThumbs     // Catch:{ all -> 0x0039 }
            int r1 = r1.indexOf(r4)     // Catch:{ all -> 0x0039 }
            int r2 = r4.getValue()     // Catch:{ all -> 0x0039 }
            r0.onValueChanged(r3, r4, r1, r2)     // Catch:{ all -> 0x0039 }
        L_0x002c:
            int r0 = r3.getWidth()     // Catch:{ all -> 0x0039 }
            int r1 = r3.getHeight()     // Catch:{ all -> 0x0039 }
            r3.updateThumb(r4, r0, r1)     // Catch:{ all -> 0x0039 }
            monitor-exit(r3)
            return
        L_0x0039:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x003c:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.apptik.widget.MultiSlider.setThumbValue(io.apptik.widget.MultiSlider$Thumb, int, boolean):void");
    }

    private synchronized void setThumbValue(int thumb, int value, boolean fromUser) {
        setThumbValue(this.mThumbs.get(thumb), value, fromUser);
    }

    private void updateTrackBounds(int w, int h) {
        int w2 = w - (getPaddingRight() + getPaddingLeft());
        int right = w2;
        int bottom = h - (getPaddingTop() + getPaddingBottom());
        Drawable drawable = this.mTrack;
        if (drawable != null) {
            drawable.setBounds(0, 0, right, bottom);
        }
    }

    private void updateTrackState() {
        int[] state = getDrawableState();
        Drawable drawable = this.mTrack;
        if (drawable != null && drawable.isStateful()) {
            this.mTrack.setState(state);
        }
    }

    private void setThumbDrawables(Drawable thumb, Drawable range, Drawable range1, Drawable range2) {
        Drawable rangeDrawable;
        int rCol;
        if (thumb != null) {
            int curr = 0;
            int padding = 0;
            Iterator it = this.mThumbs.iterator();
            while (it.hasNext()) {
                Thumb mThumb = (Thumb) it.next();
                curr++;
                if (!(mThumb.getThumb() == null || thumb == mThumb.getThumb())) {
                    mThumb.getThumb().setCallback((Drawable.Callback) null);
                }
                if (curr == 1 && range1 != null) {
                    rangeDrawable = range1;
                    rCol = this.a.getColor(R.styleable.MultiSlider_range1Color, 0);
                } else if (curr != 2 || range2 == null) {
                    rangeDrawable = range;
                    rCol = this.defRangeColor;
                } else {
                    rangeDrawable = range2;
                    rCol = this.a.getColor(R.styleable.MultiSlider_range2Color, 0);
                }
                setRangeDrawable(mThumb, rangeDrawable, rCol);
                setThumbDrawable(mThumb, thumb, this.defThumbColor);
                padding = Math.max(padding, mThumb.getThumbOffset());
            }
            setPadding(padding, getPaddingTop(), padding, getPaddingBottom());
        }
    }

    private void setThumbDrawable(Thumb thumb, Drawable thumbDrawable, int thumbColor) {
        Util.requireNonNull(thumbDrawable);
        Drawable nThumbDrawable = getTintedDrawable(thumbDrawable.getConstantState().newDrawable(), thumbColor);
        nThumbDrawable.setCallback(this);
        thumb.setThumbOffset(thumbDrawable.getIntrinsicWidth() / 2);
        if (!(thumb.getThumb() == null || (nThumbDrawable.getIntrinsicWidth() == thumb.getThumb().getIntrinsicWidth() && nThumbDrawable.getIntrinsicHeight() == thumb.getThumb().getIntrinsicHeight()))) {
            requestLayout();
        }
        thumb.setThumb(nThumbDrawable);
        invalidate();
        if (nThumbDrawable != null && nThumbDrawable.isStateful()) {
            nThumbDrawable.setState(getDrawableState());
        }
    }

    private void setRangeDrawable(Thumb thumb, Drawable rangeDrawable, int rangeColor) {
        Util.requireNonNull(rangeDrawable);
        thumb.setRange(getTintedDrawable(rangeDrawable, rangeColor));
    }

    public Thumb getThumb(int pos) {
        return this.mThumbs.get(pos);
    }

    public void setKeyProgressIncrement(int increment) {
        this.mKeyProgressIncrement = increment < 0 ? -increment : increment;
    }

    public int getKeyProgressIncrement() {
        return this.mKeyProgressIncrement;
    }

    public synchronized void setMax(int max) {
        setMax(max, true, false);
    }

    public synchronized void setMax(int max, boolean extendMaxForThumbs) {
        setMax(max, extendMaxForThumbs, false);
    }

    public synchronized void setMax(int max, boolean extendMaxForThumbs, boolean repositionThumbs) {
        int i = this.mScaleMin;
        if (max < i) {
            max = i;
        }
        if (max != this.mScaleMax) {
            this.mScaleMax = max;
            Iterator it = this.mThumbs.iterator();
            while (it.hasNext()) {
                Thumb thumb = (Thumb) it.next();
                if (extendMaxForThumbs) {
                    thumb.setMax(max);
                } else if (thumb.getMax() > max) {
                    thumb.setMax(max);
                }
                if (thumb.getValue() > max) {
                    setThumbValue(thumb, max, false);
                }
            }
            if (repositionThumbs) {
                repositionThumbs();
            }
            postInvalidate();
        }
        int i2 = this.mKeyProgressIncrement;
        if (i2 == 0 || this.mScaleMax / i2 > 20) {
            setKeyProgressIncrement(Math.max(1, Math.round(((float) this.mScaleMax) / 20.0f)));
        }
    }

    public int getMax() {
        return this.mScaleMax;
    }

    public synchronized void setMin(int min) {
        setMin(min, true, false);
    }

    public synchronized void setMin(int min, boolean extendMinForThumbs) {
        setMin(min, extendMinForThumbs, false);
    }

    public synchronized void setMin(int min, boolean extendMinForThumbs, boolean repositionThumbs) {
        int i = this.mScaleMax;
        if (min > i) {
            min = i;
        }
        if (min != this.mScaleMin) {
            this.mScaleMin = min;
            Iterator it = this.mThumbs.iterator();
            while (it.hasNext()) {
                Thumb thumb = (Thumb) it.next();
                if (extendMinForThumbs) {
                    thumb.setMin(min);
                } else if (thumb.getMin() < min) {
                    thumb.setMin(min);
                }
                if (thumb.getValue() < min) {
                    setThumbValue(thumb, min, false);
                }
            }
            if (repositionThumbs) {
                repositionThumbs();
            }
            postInvalidate();
        }
        int i2 = this.mKeyProgressIncrement;
        if (i2 == 0 || this.mScaleMax / i2 > 20) {
            setKeyProgressIncrement(Math.max(1, Math.round(((float) this.mScaleMax) / 20.0f)));
        }
    }

    public int getMin() {
        return this.mScaleMin;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        Iterator it = this.mThumbs.iterator();
        while (it.hasNext()) {
            Thumb thumb = (Thumb) it.next();
            if (thumb.getThumb() != null && who == thumb.getThumb()) {
                return true;
            }
        }
        if (who == this.mTrack || super.verifyDrawable(who)) {
            return true;
        }
        return false;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Iterator it = this.mThumbs.iterator();
        while (it.hasNext()) {
            Thumb thumb = (Thumb) it.next();
            if (thumb.getThumb() != null) {
                thumb.getThumb().jumpToCurrentState();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        List<Thumb> list = this.mDraggingThumbs;
        if (list == null || list.isEmpty()) {
            Iterator it = this.mThumbs.iterator();
            while (it.hasNext()) {
                Thumb thumb = (Thumb) it.next();
                if (thumb.getThumb() != null && thumb.getThumb().isStateful()) {
                    if (thumb.isEnabled()) {
                        thumb.getThumb().setState(new int[]{16842910});
                    } else {
                        thumb.getThumb().setState(new int[]{-16842910});
                    }
                }
            }
            return;
        }
        int[] state = getDrawableState();
        for (Thumb thumb2 : this.mDraggingThumbs) {
            if (thumb2.getThumb() != null) {
                thumb2.getThumb().setState(state);
            }
        }
        Iterator it2 = this.mThumbs.iterator();
        while (it2.hasNext()) {
            Thumb thumb3 = (Thumb) it2.next();
            if (!this.mDraggingThumbs.contains(thumb3) && thumb3.getThumb() != null && thumb3.getThumb().isStateful()) {
                if (thumb3.isEnabled()) {
                    thumb3.getThumb().setState(new int[]{16842910});
                } else {
                    thumb3.getThumb().setState(new int[]{-16842910});
                }
            }
        }
    }

    private void updateThumb(Thumb thumb, int w, int h) {
        Drawable prevThumb;
        int thumbHeight;
        int trackHeight;
        MultiSlider multiSlider;
        Thumb thumb2 = thumb;
        int thumbHeight2 = thumb2 == null ? 0 : thumb.getThumb().getIntrinsicHeight();
        int trackHeight2 = (h - getPaddingTop()) - getPaddingBottom();
        float scale = getScaleSize() > 0 ? ((float) thumb.getValue()) / ((float) getScaleSize()) : 0.0f;
        int currIdx = this.mThumbs.indexOf(thumb2);
        if (currIdx > 0) {
            prevThumb = this.mThumbs.get(currIdx - 1).getThumb();
        } else {
            prevThumb = null;
        }
        if (thumbHeight2 > trackHeight2) {
            if (thumb2 != null) {
                setThumbPos(w, h, thumb.getThumb(), prevThumb, thumb.getRange(), scale, 0, thumb.getThumbOffset(), getThumbOptOffset(thumb));
            }
            int gapForCenteringTrack = (thumbHeight2 - trackHeight2) / 2;
            Drawable drawable = this.mTrack;
            if (drawable != null) {
                drawable.setBounds(0, gapForCenteringTrack, (w - getPaddingRight()) - getPaddingLeft(), ((h - getPaddingBottom()) - gapForCenteringTrack) - getPaddingTop());
            }
            trackHeight = trackHeight2;
            thumbHeight = thumbHeight2;
            multiSlider = this;
        } else {
            Drawable drawable2 = this.mTrack;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, (w - getPaddingRight()) - getPaddingLeft(), (h - getPaddingBottom()) - getPaddingTop());
            }
            int gap = (trackHeight2 - thumbHeight2) / 2;
            if (thumb2 != null) {
                trackHeight = trackHeight2;
                thumbHeight = thumbHeight2;
                multiSlider = this;
                setThumbPos(w, h, thumb.getThumb(), prevThumb, thumb.getRange(), scale, gap, thumb.getThumbOffset(), getThumbOptOffset(thumb));
            } else {
                trackHeight = trackHeight2;
                thumbHeight = thumbHeight2;
                multiSlider = this;
            }
        }
        int i = currIdx + 1;
        while (i < multiSlider.mThumbs.size()) {
            setThumbPos(w, h, multiSlider.mThumbs.get(i).getThumb(), multiSlider.mThumbs.get(i - 1).getThumb(), multiSlider.mThumbs.get(i).getRange(), getScaleSize() > 0 ? ((float) multiSlider.mThumbs.get(i).getValue()) / ((float) getScaleSize()) : 0.0f, (trackHeight - thumbHeight) / 2, multiSlider.mThumbs.get(i).getThumbOffset(), multiSlider.getThumbOptOffset(multiSlider.mThumbs.get(i)));
            i++;
            multiSlider = this;
        }
    }

    private void setThumbPos(int w, int h, Drawable thumb, Drawable prevThumb, Drawable range, float scale, int gap, int thumbOffset, int optThumbOffset) {
        int topBound;
        int bottomBound;
        Drawable drawable = range;
        int i = gap;
        int available = getAvailable();
        int thumbWidth = thumb.getIntrinsicWidth();
        int thumbHeight = thumb.getIntrinsicHeight();
        int thumbPos = (int) (((((float) available) * scale) - (((float) available) * (getScaleSize() > 0 ? ((float) this.mScaleMin) / ((float) getScaleSize()) : 0.0f))) + 0.5f);
        if (i == Integer.MIN_VALUE) {
            Rect oldBounds = thumb.getBounds();
            topBound = oldBounds.top;
            bottomBound = oldBounds.bottom;
        } else {
            topBound = gap;
            bottomBound = i + thumbHeight;
        }
        int thumbStart = (!isLayoutRtl() || !this.mMirrorForRtl) ? thumbPos + optThumbOffset : (available - thumbPos) + optThumbOffset;
        thumb.setBounds(thumbStart, topBound, thumbStart + thumbWidth, bottomBound);
        int bottom = (h - getPaddingTop()) + getPaddingBottom();
        int rangeStart = 0;
        if (isLayoutRtl() && this.mMirrorForRtl) {
            rangeStart = available;
        }
        if (prevThumb != null) {
            rangeStart = prevThumb.getBounds().left;
        }
        if (drawable != null) {
            if (!isLayoutRtl() || !this.mMirrorForRtl) {
                drawable.setBounds(rangeStart, 0, thumbStart, bottom);
            } else {
                drawable.setBounds(thumbStart, 0, rangeStart + optThumbOffset, bottom);
            }
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        int paddingStart;
        super.onDraw(canvas);
        if (Build.VERSION.SDK_INT >= 17) {
            paddingStart = getPaddingStart();
        } else {
            paddingStart = getPaddingLeft();
        }
        if (this.mTrack != null) {
            canvas.save();
            canvas.translate((float) paddingStart, (float) getPaddingTop());
            this.mTrack.draw(canvas);
            canvas.restore();
        }
        Iterator it = this.mThumbs.iterator();
        while (it.hasNext()) {
            Thumb thumb = (Thumb) it.next();
            if (thumb.getRange() != null) {
                canvas.save();
                canvas.translate((float) paddingStart, (float) getPaddingTop());
                thumb.getRange().draw(canvas);
                canvas.restore();
            }
        }
        Iterator it2 = this.mThumbs.iterator();
        while (it2.hasNext()) {
            Thumb thumb2 = (Thumb) it2.next();
            if (thumb2.getThumb() != null && !thumb2.isInvisibleThumb()) {
                canvas.save();
                canvas.translate((float) (paddingStart - thumb2.getThumbOffset()), (float) getPaddingTop());
                thumb2.getThumb().draw(canvas);
                canvas.restore();
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int maxThumbHeight = 0;
        int maxRangeHeight = 0;
        Iterator it = this.mThumbs.iterator();
        while (it.hasNext()) {
            Thumb thumb = (Thumb) it.next();
            if (thumb.getThumb() != null) {
                maxThumbHeight = Math.max(thumb.getThumb().getIntrinsicHeight(), maxThumbHeight);
                maxRangeHeight = Math.max(thumb.getThumb().getIntrinsicHeight(), maxRangeHeight);
            }
        }
        int dw = 0;
        int dh = 0;
        Drawable drawable = this.mTrack;
        if (drawable != null) {
            dw = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, drawable.getIntrinsicWidth()));
            dh = Math.max(maxThumbHeight, Math.max(maxRangeHeight, Math.max(this.mMinHeight, Math.min(this.mMaxHeight, this.mTrack.getIntrinsicHeight()))));
        }
        setMeasuredDimension(resolveSizeAndState(dw + getPaddingLeft() + getPaddingRight(), widthMeasureSpec, 0), resolveSizeAndState(dh + getPaddingTop() + getPaddingBottom(), heightMeasureSpec, 0));
    }

    public boolean isInScrollingContainer() {
        ViewParent p = getParent();
        while (p != null && (p instanceof ViewGroup)) {
            if (((ViewGroup) p).shouldDelayChildPressedState()) {
                return true;
            }
            p = p.getParent();
        }
        return false;
    }

    private int getAvailable() {
        int available = (getWidth() - getPaddingLeft()) - getPaddingRight();
        LinkedList<Thumb> linkedList = this.mThumbs;
        if (linkedList == null || linkedList.size() <= 0) {
            return available;
        }
        if (!isLayoutRtl() || !this.mMirrorForRtl) {
            return available - getThumbOptOffset(this.mThumbs.getLast());
        }
        return available - getThumbOptOffset(this.mThumbs.getFirst());
    }

    private LinkedList<Thumb> getClosestThumb(int x) {
        LinkedList<Thumb> exact = new LinkedList<>();
        Thumb closest = null;
        int currDistance = getAvailable() + 1;
        Iterator it = this.mThumbs.iterator();
        while (it.hasNext()) {
            Thumb thumb = (Thumb) it.next();
            if (thumb.getThumb() != null && thumb.isEnabled() && !this.mDraggingThumbs.contains(thumb)) {
                int minV = x - thumb.getThumb().getIntrinsicWidth();
                int maxV = thumb.getThumb().getIntrinsicWidth() + x;
                if (thumb.getThumb().getBounds().centerX() >= minV && thumb.getThumb().getBounds().centerX() <= maxV) {
                    exact.add(thumb);
                } else if (Math.abs(thumb.getThumb().getBounds().centerX() - x) <= currDistance) {
                    if (Math.abs(thumb.getThumb().getBounds().centerX() - x) == currDistance) {
                        if (x > getWidth() / 2) {
                            closest = thumb;
                        }
                    } else if (thumb.getThumb() != null) {
                        currDistance = Math.abs(thumb.getThumb().getBounds().centerX() - x);
                        closest = thumb;
                    }
                }
            }
        }
        if (exact.isEmpty() && closest != null) {
            exact.add(closest);
        }
        return exact;
    }

    private Thumb getMostMovable(LinkedList<Thumb> thumbs, MotionEvent event) {
        Thumb res = null;
        int maxChange = 0;
        if (thumbs != null && !thumbs.isEmpty()) {
            if (thumbs.getFirst().getValue() == getValue(event, thumbs.getFirst())) {
                return null;
            }
            Iterator it = thumbs.iterator();
            while (it.hasNext()) {
                Thumb thumb = (Thumb) it.next();
                if (thumb.getThumb() != null && thumb.isEnabled() && !this.mDraggingThumbs.contains(thumb)) {
                    int currChange = Math.abs(thumb.getValue() - optThumbValue(thumb, getValue(event, thumbs.getFirst()) > thumb.getValue() ? this.mScaleMax : this.mScaleMin));
                    if (currChange > maxChange) {
                        maxChange = currChange;
                        res = thumb;
                    }
                }
            }
        }
        return res;
    }

    private Thumb getMostMovableThumb(MotionEvent event) {
        LinkedList<Thumb> linkedList = this.exactTouched;
        if (linkedList == null || linkedList.size() < 1) {
            return null;
        }
        if (this.exactTouched.size() == 1) {
            return this.exactTouched.getFirst();
        }
        return getMostMovable(this.exactTouched, event);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ed, code lost:
        if (r5 != 6) goto L_0x01cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            r12 = this;
            boolean r0 = r12.mIsUserSeekable
            r1 = 0
            if (r0 == 0) goto L_0x01ce
            boolean r0 = r12.isEnabled()
            if (r0 != 0) goto L_0x000d
            goto L_0x01ce
        L_0x000d:
            float r0 = r13.getX()
            int r0 = java.lang.Math.round(r0)
            float r2 = r13.getY()
            int r2 = java.lang.Math.round(r2)
            int r3 = r13.getActionIndex()
            r4 = 0
            int r5 = r13.getActionMasked()
            r6 = 6
            r7 = 2
            r8 = 5
            r9 = 0
            r10 = 1
            if (r5 == 0) goto L_0x008c
            int r5 = r13.getActionMasked()
            if (r5 != r8) goto L_0x0034
            goto L_0x008c
        L_0x0034:
            int r5 = r13.getActionMasked()
            if (r5 != r7) goto L_0x005d
            java.util.LinkedList<io.apptik.widget.MultiSlider$Thumb> r5 = r12.exactTouched
            if (r5 == 0) goto L_0x004a
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x004a
            io.apptik.widget.MultiSlider$Thumb r4 = r12.getMostMovableThumb(r13)
            goto L_0x00de
        L_0x004a:
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r5 = r12.mDraggingThumbs
            int r5 = r5.size()
            if (r5 <= r3) goto L_0x00de
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r5 = r12.mDraggingThumbs
            java.lang.Object r5 = r5.get(r3)
            r4 = r5
            io.apptik.widget.MultiSlider$Thumb r4 = (io.apptik.widget.MultiSlider.Thumb) r4
            goto L_0x00de
        L_0x005d:
            int r5 = r13.getActionMasked()
            if (r5 == r10) goto L_0x0069
            int r5 = r13.getActionMasked()
            if (r5 != r6) goto L_0x00de
        L_0x0069:
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r5 = r12.mDraggingThumbs
            int r5 = r5.size()
            if (r5 <= r3) goto L_0x007b
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r5 = r12.mDraggingThumbs
            java.lang.Object r5 = r5.get(r3)
            r4 = r5
            io.apptik.widget.MultiSlider$Thumb r4 = (io.apptik.widget.MultiSlider.Thumb) r4
            goto L_0x00de
        L_0x007b:
            java.util.LinkedList<io.apptik.widget.MultiSlider$Thumb> r5 = r12.exactTouched
            if (r5 == 0) goto L_0x00de
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x00de
            io.apptik.widget.MultiSlider$Thumb r4 = r12.getMostMovableThumb(r13)
            r12.exactTouched = r9
            goto L_0x00de
        L_0x008c:
            float r5 = r13.getX(r3)
            int r5 = (int) r5
            java.util.LinkedList r5 = r12.getClosestThumb(r5)
            boolean r11 = r12.isInScrollingContainer()
            if (r11 == 0) goto L_0x00b5
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r11 = r12.mDraggingThumbs
            int r11 = r11.size()
            if (r11 != 0) goto L_0x00b5
            java.util.LinkedList<io.apptik.widget.MultiSlider$Thumb> r11 = r12.exactTouched
            if (r11 == 0) goto L_0x00b5
            if (r3 <= 0) goto L_0x00b5
            java.lang.Object r11 = r11.getFirst()
            io.apptik.widget.MultiSlider$Thumb r11 = (io.apptik.widget.MultiSlider.Thumb) r11
            r12.onStartTrackingTouch(r11)
            r12.exactTouched = r9
        L_0x00b5:
            if (r5 == 0) goto L_0x00dd
            boolean r11 = r5.isEmpty()
            if (r11 != 0) goto L_0x00dd
            int r11 = r5.size()
            if (r11 != r10) goto L_0x00db
            java.lang.Object r11 = r5.getFirst()
            r4 = r11
            io.apptik.widget.MultiSlider$Thumb r4 = (io.apptik.widget.MultiSlider.Thumb) r4
            boolean r11 = r12.isInScrollingContainer()
            if (r11 == 0) goto L_0x00dd
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r11 = r12.mDraggingThumbs
            int r11 = r11.size()
            if (r11 != 0) goto L_0x00dd
            r12.exactTouched = r5
            goto L_0x00dd
        L_0x00db:
            r12.exactTouched = r5
        L_0x00dd:
        L_0x00de:
            int r5 = r13.getActionMasked()
            if (r5 == 0) goto L_0x01a8
            if (r5 == r10) goto L_0x0180
            if (r5 == r7) goto L_0x0100
            r7 = 3
            if (r5 == r7) goto L_0x00f1
            if (r5 == r8) goto L_0x01a8
            if (r5 == r6) goto L_0x0183
            goto L_0x01cd
        L_0x00f1:
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r5 = r12.mDraggingThumbs
            if (r5 == 0) goto L_0x00fb
            r12.onStopTrackingTouch()
            r12.setPressed(r1)
        L_0x00fb:
            r12.invalidate()
            goto L_0x01cd
        L_0x0100:
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r1 = r12.mDraggingThumbs
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L_0x015b
            r1 = 0
        L_0x0109:
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r5 = r12.mDraggingThumbs
            int r5 = r5.size()
            if (r1 >= r5) goto L_0x0154
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r5 = r12.mDraggingThumbs
            java.lang.Object r5 = r5.get(r1)
            if (r5 == 0) goto L_0x013a
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r5 = r12.mDraggingThumbs
            java.lang.Object r5 = r5.get(r1)
            io.apptik.widget.MultiSlider$Thumb r5 = (io.apptik.widget.MultiSlider.Thumb) r5
            android.graphics.drawable.Drawable r5 = r5.getThumb()
            if (r5 == 0) goto L_0x013a
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r5 = r12.mDraggingThumbs
            java.lang.Object r5 = r5.get(r1)
            io.apptik.widget.MultiSlider$Thumb r5 = (io.apptik.widget.MultiSlider.Thumb) r5
            android.graphics.drawable.Drawable r5 = r5.getThumb()
            android.graphics.Rect r5 = r5.getBounds()
            r12.invalidate(r5)
        L_0x013a:
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r5 = r12.mDraggingThumbs
            java.lang.Object r5 = r5.get(r1)
            io.apptik.widget.MultiSlider$Thumb r5 = (io.apptik.widget.MultiSlider.Thumb) r5
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r6 = r12.mDraggingThumbs
            java.lang.Object r6 = r6.get(r1)
            io.apptik.widget.MultiSlider$Thumb r6 = (io.apptik.widget.MultiSlider.Thumb) r6
            int r6 = r12.getValue(r13, r1, r6)
            r12.setThumbValue((io.apptik.widget.MultiSlider.Thumb) r5, (int) r6, (boolean) r10)
            int r1 = r1 + 1
            goto L_0x0109
        L_0x0154:
            float r1 = (float) r0
            float r5 = (float) r2
            r12.setHotspot(r1, r5, r4)
            goto L_0x01cd
        L_0x015b:
            float r1 = r13.getX(r3)
            float r5 = r12.mTouchDownX
            float r5 = r1 - r5
            float r5 = java.lang.Math.abs(r5)
            int r6 = r12.mScaledTouchSlop
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x017f
            r12.onStartTrackingTouch(r4)
            r12.exactTouched = r9
            int r5 = r12.getValue(r13, r4)
            r12.setThumbValue((io.apptik.widget.MultiSlider.Thumb) r4, (int) r5, (boolean) r10)
            float r5 = (float) r0
            float r6 = (float) r2
            r12.setHotspot(r5, r6, r4)
        L_0x017f:
            goto L_0x01cd
        L_0x0180:
            r12.setPressed(r1)
        L_0x0183:
            if (r4 == 0) goto L_0x01a4
            int r5 = r12.getValue(r13, r4)
            r12.setThumbValue((io.apptik.widget.MultiSlider.Thumb) r4, (int) r5, (boolean) r10)
            float r5 = (float) r0
            float r6 = (float) r2
            r12.setHotspot(r5, r6, r4)
            r5 = 0
            boolean r6 = r12.isPressed()
            if (r6 != 0) goto L_0x019c
            r12.setPressed(r10)
            r5 = 1
        L_0x019c:
            r12.onStopTrackingTouch(r4)
            if (r5 == 0) goto L_0x01a4
            r12.setPressed(r1)
        L_0x01a4:
            r12.invalidate()
            goto L_0x01cd
        L_0x01a8:
            boolean r1 = r12.isInScrollingContainer()
            if (r1 == 0) goto L_0x01bd
            java.util.List<io.apptik.widget.MultiSlider$Thumb> r1 = r12.mDraggingThumbs
            int r1 = r1.size()
            if (r1 != 0) goto L_0x01bd
            float r1 = r13.getX(r3)
            r12.mTouchDownX = r1
            goto L_0x01cd
        L_0x01bd:
            r12.onStartTrackingTouch(r4)
            int r1 = r12.getValue(r13, r4)
            r12.setThumbValue((io.apptik.widget.MultiSlider.Thumb) r4, (int) r1, (boolean) r10)
            float r1 = (float) r0
            float r5 = (float) r2
            r12.setHotspot(r1, r5, r4)
        L_0x01cd:
            return r10
        L_0x01ce:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.apptik.widget.MultiSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private int getValue(MotionEvent event, Thumb thumb) {
        return getValue(event, event.getActionIndex(), thumb);
    }

    private void setHotspot(float x, float y, Thumb thumb) {
        if (thumb != null && thumb.getThumb() != null) {
            Drawable background = getBackground();
            if (Build.VERSION.SDK_INT >= 21 && background != null) {
                background.setHotspot(x, y);
                Rect rect = thumb.getThumb().getBounds();
                int offsetY = getPaddingTop();
                background.setHotspotBounds(rect.left, rect.top + offsetY, rect.right, rect.bottom + offsetY);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getThumbOptOffset(Thumb thumb) {
        if (!this.mDrawThumbsApart || thumb == null || thumb.getThumb() == null) {
            return 0;
        }
        int thumbIdx = this.mThumbs.indexOf(thumb);
        if (!isLayoutRtl() || !this.mMirrorForRtl) {
            if (thumbIdx == 0) {
                return 0;
            }
            return getThumbOptOffset(this.mThumbs.get(thumbIdx - 1)) + thumb.getThumb().getIntrinsicWidth();
        } else if (thumbIdx == this.mThumbs.size() - 1) {
            return 0;
        } else {
            return getThumbOptOffset(this.mThumbs.get(thumbIdx + 1)) + thumb.getThumb().getIntrinsicWidth();
        }
    }

    private int getValue(MotionEvent event, int pointerIndex, Thumb thumb) {
        float scale;
        int width = getWidth();
        int available = getAvailable();
        int optThumbOffset = getThumbOptOffset(thumb);
        int x = (int) event.getX(pointerIndex);
        float progress = (float) this.mScaleMin;
        if (!isLayoutRtl() || !this.mMirrorForRtl) {
            if (x < getPaddingLeft()) {
                scale = 0.0f;
            } else if (x > width - getPaddingRight()) {
                scale = 1.0f;
            } else {
                scale = ((float) ((x - getPaddingLeft()) - optThumbOffset)) / ((float) available);
                progress = (float) this.mScaleMin;
            }
        } else if (x > width - getPaddingRight()) {
            scale = 0.0f;
        } else if (x < getPaddingLeft()) {
            scale = 1.0f;
        } else {
            scale = ((float) (((available - x) + getPaddingLeft()) + optThumbOffset)) / ((float) available);
            progress = (float) this.mScaleMin;
        }
        return Math.round(progress + (((float) getScaleSize()) * scale));
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void onStartTrackingTouch(Thumb thumb) {
        if (thumb != null) {
            setPressed(true);
            if (thumb.getThumb() != null) {
                invalidate(thumb.getThumb().getBounds());
            }
            this.mDraggingThumbs.add(thumb);
            drawableStateChanged();
            if (hasOnTrackingChangeListener()) {
                this.mOnTrackingChangeListener.onStartTrackingTouch(this, thumb, thumb.getValue());
            }
            attemptClaimDrag();
        }
    }

    /* access modifiers changed from: package-private */
    public void onStopTrackingTouch(Thumb thumb) {
        if (thumb != null) {
            this.mDraggingThumbs.remove(thumb);
            if (hasOnTrackingChangeListener()) {
                this.mOnTrackingChangeListener.onStopTrackingTouch(this, thumb, thumb.getValue());
            }
            drawableStateChanged();
        }
    }

    /* access modifiers changed from: package-private */
    public void onStopTrackingTouch() {
        this.mDraggingThumbs.clear();
    }

    private boolean hasOnThumbValueChangeListener() {
        return this.mOnThumbValueChangeListener != null;
    }

    private boolean hasOnTrackingChangeListener() {
        return this.mOnTrackingChangeListener != null;
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (this.mAccessibilityNodeProvider == null) {
            this.mAccessibilityNodeProvider = new VirtualTreeProvider();
        }
        return this.mAccessibilityNodeProvider;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(MultiSlider.class.getName());
    }

    public void onRtlPropertiesChanged(int layoutDirection) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(layoutDirection);
            invalidate();
        }
    }

    public boolean isLayoutRtl() {
        if (Build.VERSION.SDK_INT < 17 || getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }

    public void invalidateDrawable(Drawable dr) {
        if (this.mInDrawing) {
            return;
        }
        if (verifyDrawable(dr)) {
            Rect dirty = dr.getBounds();
            int scrollX = getScrollX() + getPaddingLeft();
            int scrollY = getScrollY() + getPaddingTop();
            invalidate(dirty.left + scrollX, dirty.top + scrollY, dirty.right + scrollX, dirty.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(dr);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        updateTrackBounds(w, h);
        Iterator it = this.mThumbs.iterator();
        while (it.hasNext()) {
            updateThumb((Thumb) it.next(), w, h);
        }
    }

    private Drawable getTintedDrawable(Drawable drawable, int tintColor) {
        if (drawable == null || tintColor == 0) {
            return drawable;
        }
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable.mutate());
        DrawableCompat.setTint(wrappedDrawable, tintColor);
        return wrappedDrawable;
    }

    public static class SimpleChangeListener implements OnThumbValueChangeListener, OnTrackingChangeListener {
        public void onValueChanged(MultiSlider multiSlider, Thumb thumb, int thumbIndex, int value) {
        }

        public void onStartTrackingTouch(MultiSlider multiSlider, Thumb thumb, int value) {
        }

        public void onStopTrackingTouch(MultiSlider multiSlider, Thumb thumb, int value) {
        }
    }

    class VirtualTreeProvider extends AccessibilityNodeProvider {
        static final int ACT_SET_PROGRESS = 16908349;
        final AccessibilityNodeInfo.AccessibilityAction ACTION_SET_PROGRESS;

        public VirtualTreeProvider() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.ACTION_SET_PROGRESS = new AccessibilityNodeInfo.AccessibilityAction(ACT_SET_PROGRESS, (CharSequence) null);
            } else {
                this.ACTION_SET_PROGRESS = null;
            }
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int thumbId) {
            AccessibilityNodeInfo info;
            if (thumbId == -1) {
                info = AccessibilityNodeInfo.obtain(MultiSlider.this);
                MultiSlider.this.onInitializeAccessibilityNodeInfo(info);
                int childCount = MultiSlider.this.mThumbs.size();
                for (int i = 0; i < childCount; i++) {
                    info.addChild(MultiSlider.this, i);
                }
                if (MultiSlider.this.mThumbs.size() == 1) {
                    info.setScrollable(true);
                    if (Build.VERSION.SDK_INT >= 21) {
                        info.addAction(this.ACTION_SET_PROGRESS);
                        info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                        info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                    } else {
                        info.addAction(ConstantsKt.DEFAULT_BUFFER_SIZE);
                        info.addAction(ConstantsKt.DEFAULT_BLOCK_SIZE);
                    }
                }
            } else {
                Thumb thumb = (Thumb) MultiSlider.this.mThumbs.get(thumbId);
                if (thumb == null) {
                    return null;
                }
                info = AccessibilityNodeInfo.obtain(MultiSlider.this, thumbId);
                info.setClassName(thumb.getClass().getName());
                info.setParent(MultiSlider.this);
                info.setSource(MultiSlider.this, thumbId);
                info.setContentDescription("Multi-Slider thumb no:" + thumbId);
                if (Build.VERSION.SDK_INT >= 21) {
                    info.addAction(this.ACTION_SET_PROGRESS);
                    if (thumb.getPossibleMax() > thumb.value) {
                        info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                    }
                    if (thumb.getPossibleMax() > thumb.value) {
                        info.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                    }
                } else {
                    if (thumb.getPossibleMin() > thumb.value) {
                        info.addAction(ConstantsKt.DEFAULT_BUFFER_SIZE);
                    }
                    if (thumb.getPossibleMax() > thumb.value) {
                        info.addAction(ConstantsKt.DEFAULT_BLOCK_SIZE);
                    }
                }
                if (thumb.getThumb() != null) {
                    int[] loc = new int[2];
                    MultiSlider.this.getLocationOnScreen(loc);
                    Rect rect = thumb.getThumb().copyBounds();
                    rect.top += loc[1];
                    rect.left += loc[0];
                    rect.right += loc[0];
                    rect.bottom += loc[1];
                    info.setBoundsInScreen(rect);
                }
                info.setText(thumb.tag + ": " + thumb.value);
                info.setEnabled(thumb.isEnabled());
                if (Build.VERSION.SDK_INT >= 24) {
                    info.setImportantForAccessibility(true);
                }
                info.setVisibleToUser(true);
                info.setScrollable(true);
            }
            return info;
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String searched, int virtualViewId) {
            if (TextUtils.isEmpty(searched)) {
                return Collections.emptyList();
            }
            String searchedLowerCase = searched.toLowerCase();
            List<AccessibilityNodeInfo> result = null;
            if (virtualViewId == -1) {
                int childCount = MultiSlider.this.mThumbs.size();
                for (int i = 0; i < childCount; i++) {
                    if (((Thumb) MultiSlider.this.mThumbs.get(i)).tag.toLowerCase().contains(searchedLowerCase)) {
                        if (result == null) {
                            result = new ArrayList<>();
                        }
                        result.add(createAccessibilityNodeInfo(i));
                    }
                }
            } else {
                Thumb virtualView = (Thumb) MultiSlider.this.mThumbs.get(virtualViewId);
                if (virtualView != null && virtualView.tag.toLowerCase().contains(searchedLowerCase)) {
                    result = new ArrayList<>();
                    result.add(createAccessibilityNodeInfo(virtualViewId));
                }
            }
            if (result == null) {
                return Collections.emptyList();
            }
            return result;
        }

        public AccessibilityNodeInfo findFocus(int focus) {
            return super.findFocus(focus);
        }

        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            Thumb thumb;
            if (virtualViewId == -1 || virtualViewId >= MultiSlider.this.mThumbs.size() || (thumb = (Thumb) MultiSlider.this.mThumbs.get(virtualViewId)) == null) {
                return false;
            }
            if (action == 4096) {
                thumb.setValue(thumb.value + MultiSlider.this.getStep());
                return true;
            } else if (action == 8192) {
                thumb.setValue(thumb.value - MultiSlider.this.getStep());
                return true;
            } else if (action != ACT_SET_PROGRESS) {
                return false;
            } else {
                thumb.setValue(arguments.getInt("value"));
                return true;
            }
        }
    }
}
