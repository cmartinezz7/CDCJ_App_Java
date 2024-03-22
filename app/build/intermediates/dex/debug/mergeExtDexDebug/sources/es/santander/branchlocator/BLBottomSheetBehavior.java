package es.santander.branchlocator;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Vector;

public class BLBottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int DEFAULT_ANCHOR_POINT = 400;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int STATE_ANCHOR_POINT = 3;
    public static final int STATE_COLLAPSED = 5;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 4;
    public static final int STATE_HIDDEN = 6;
    public static final int STATE_SETTLING = 2;
    /* access modifiers changed from: private */
    public int mActivePointerId;
    /* access modifiers changed from: private */
    public int mAnchorPoint;
    private Vector<BottomSheetCallback> mCallback;
    /* access modifiers changed from: private */
    public boolean mCollapsible;
    private final ViewDragHelper.Callback mDragCallback = new ViewDragHelper.Callback() {
        public boolean tryCaptureView(View child, int pointerId) {
            View scroll;
            if (BLBottomSheetBehavior.this.mState == 1 || BLBottomSheetBehavior.this.mTouchingScrollingChild) {
                return false;
            }
            if (BLBottomSheetBehavior.this.mState == 4 && BLBottomSheetBehavior.this.mActivePointerId == pointerId && (scroll = (View) BLBottomSheetBehavior.this.mNestedScrollingChildRef.get()) != null && scroll.canScrollVertically(-1)) {
                return false;
            }
            if (BLBottomSheetBehavior.this.mViewRef == null || BLBottomSheetBehavior.this.mViewRef.get() != child) {
                return false;
            }
            return true;
        }

        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            BLBottomSheetBehavior.this.dispatchOnSlide(top);
        }

        public void onViewDragStateChanged(int state) {
            if (state == 1) {
                BLBottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            int targetState;
            int top;
            if (yvel < 0.0f) {
                top = BLBottomSheetBehavior.this.mMinOffset;
                targetState = 4;
            } else if (BLBottomSheetBehavior.this.mHideable && BLBottomSheetBehavior.this.shouldHide(releasedChild, yvel)) {
                top = BLBottomSheetBehavior.this.mParentHeight;
                targetState = 6;
            } else if (yvel == 0.0f) {
                int currentTop = releasedChild.getTop();
                if (Math.abs(currentTop - BLBottomSheetBehavior.this.mMinOffset) < Math.abs(currentTop - BLBottomSheetBehavior.this.mMaxOffset)) {
                    top = BLBottomSheetBehavior.this.mMinOffset;
                    targetState = 4;
                } else {
                    top = BLBottomSheetBehavior.this.mMaxOffset;
                    targetState = 5;
                }
            } else if (yvel > 2500.0f) {
                top = BLBottomSheetBehavior.this.mParentHeight;
                targetState = 6;
            } else {
                top = BLBottomSheetBehavior.this.mMaxOffset;
                targetState = 5;
            }
            if (!BLBottomSheetBehavior.this.mCollapsible && targetState == 5) {
                top = BLBottomSheetBehavior.this.mAnchorPoint;
                targetState = 3;
            }
            if (BLBottomSheetBehavior.this.mViewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), top)) {
                BLBottomSheetBehavior.this.setStateInternal(2);
                ViewCompat.postOnAnimation(releasedChild, new SettleRunnable(releasedChild, targetState));
                return;
            }
            BLBottomSheetBehavior.this.setStateInternal(targetState);
        }

        public int clampViewPositionVertical(View child, int top, int dy) {
            return constrain(top, BLBottomSheetBehavior.this.mMinOffset, BLBottomSheetBehavior.this.mHideable ? BLBottomSheetBehavior.this.mParentHeight : BLBottomSheetBehavior.this.mMaxOffset);
        }

        /* access modifiers changed from: package-private */
        public int constrain(int amount, int low, int high) {
            if (amount < low) {
                return low;
            }
            return amount > high ? high : amount;
        }

        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return child.getLeft();
        }

        public int getViewVerticalDragRange(View child) {
            if (BLBottomSheetBehavior.this.mHideable) {
                return BLBottomSheetBehavior.this.mParentHeight - BLBottomSheetBehavior.this.mMinOffset;
            }
            return BLBottomSheetBehavior.this.mMaxOffset - BLBottomSheetBehavior.this.mMinOffset;
        }
    };
    /* access modifiers changed from: private */
    public boolean mHideable;
    private boolean mIgnoreEvents;
    private int mInitialY;
    private int mLastStableState = 3;
    /* access modifiers changed from: private */
    public int mMaxOffset;
    /* access modifiers changed from: private */
    public int mMinOffset;
    private float mMinimumVelocity;
    private boolean mNestedScrolled;
    /* access modifiers changed from: private */
    public WeakReference<View> mNestedScrollingChildRef;
    /* access modifiers changed from: private */
    public int mParentHeight;
    private int mPeekHeight;
    private BLBottomSheetBehavior<V>.ScrollVelocityTracker mScrollVelocityTracker = new ScrollVelocityTracker();
    /* access modifiers changed from: private */
    public int mState = 3;
    /* access modifiers changed from: private */
    public boolean mTouchingScrollingChild;
    /* access modifiers changed from: private */
    public ViewDragHelper mViewDragHelper;
    /* access modifiers changed from: private */
    public WeakReference<V> mViewRef;
    private int topMargin = 0;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public BLBottomSheetBehavior() {
    }

    public BLBottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BottomSheetBehavior_Layout);
        setPeekHeight(a.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, 0));
        setHideable(a.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        a.recycle();
        this.mAnchorPoint = 400;
        this.mCollapsible = true;
        TypedArray a2 = context.obtainStyledAttributes(attrs, R.styleable.CustomSheetBehavior);
        if (attrs != null) {
            this.mAnchorPoint = (int) a2.getDimension(R.styleable.CustomSheetBehavior_anchorPoint, 0.0f);
            this.mState = a2.getInt(R.styleable.CustomSheetBehavior_blDefaultState, 3);
        }
        a2.recycle();
        this.mMinimumVelocity = (float) ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout parent, V child) {
        return new SavedState(BLBottomSheetBehavior.super.onSaveInstanceState(parent, child), this.mState);
    }

    public void onRestoreInstanceState(CoordinatorLayout parent, V child, Parcelable state) {
        SavedState ss = (SavedState) state;
        BLBottomSheetBehavior.super.onRestoreInstanceState(parent, child, ss.getSuperState());
        if (ss.state == 1 || ss.state == 2) {
            this.mState = 5;
        } else {
            this.mState = ss.state;
        }
        this.mLastStableState = this.mState;
    }

    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        int i = this.mState;
        if (!(i == 1 || i == 2)) {
            if (parent.getFitsSystemWindows() && !child.getFitsSystemWindows()) {
                child.setFitsSystemWindows(true);
            }
            parent.onLayoutChild(child, layoutDirection);
        }
        int height = parent.getHeight();
        this.mParentHeight = height;
        int max = Math.max(this.topMargin, height - child.getHeight());
        this.mMinOffset = max;
        int max2 = Math.max(this.mParentHeight - this.mPeekHeight, max);
        this.mMaxOffset = max2;
        int i2 = this.mState;
        if (i2 == 3) {
            ViewCompat.offsetTopAndBottom(child, this.mAnchorPoint);
        } else if (i2 == 4) {
            ViewCompat.offsetTopAndBottom(child, this.mMinOffset);
        } else if (this.mHideable && i2 == 6) {
            ViewCompat.offsetTopAndBottom(child, this.mParentHeight);
        } else if (i2 == 5) {
            ViewCompat.offsetTopAndBottom(child, max2);
        }
        if (this.mViewDragHelper == null) {
            this.mViewDragHelper = ViewDragHelper.create(parent, this.mDragCallback);
        }
        this.mViewRef = new WeakReference<>(child);
        this.mNestedScrollingChildRef = new WeakReference<>(findScrollingChild(child));
        return true;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!child.isShown()) {
            this.mIgnoreEvents = true;
            return false;
        }
        int action = event.getActionMasked();
        if (action == 0) {
            reset();
        }
        if (action == 0) {
            this.mScrollVelocityTracker.clear();
            int initialX = (int) event.getX();
            this.mInitialY = (int) event.getY();
            if (this.mState == 3) {
                this.mActivePointerId = event.getPointerId(event.getActionIndex());
                this.mTouchingScrollingChild = true;
            } else {
                View scroll = (View) this.mNestedScrollingChildRef.get();
                if (scroll != null && parent.isPointInChildBounds(scroll, initialX, this.mInitialY)) {
                    this.mActivePointerId = event.getPointerId(event.getActionIndex());
                    this.mTouchingScrollingChild = true;
                }
            }
            this.mIgnoreEvents = this.mActivePointerId == -1 && !parent.isPointInChildBounds(child, initialX, this.mInitialY);
        } else if (action == 1 || action == 3) {
            this.mTouchingScrollingChild = false;
            this.mActivePointerId = -1;
            if (this.mIgnoreEvents) {
                this.mIgnoreEvents = false;
                return false;
            }
        }
        if (!this.mIgnoreEvents && this.mViewDragHelper.shouldInterceptTouchEvent(event)) {
            return true;
        }
        View scroll2 = (View) this.mNestedScrollingChildRef.get();
        if (action != 2 || scroll2 == null || this.mIgnoreEvents || this.mState == 1 || parent.isPointInChildBounds(scroll2, (int) event.getX(), (int) event.getY()) || Math.abs(((float) this.mInitialY) - event.getY()) <= ((float) this.mViewDragHelper.getTouchSlop())) {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        if (!child.isShown()) {
            return false;
        }
        int action = event.getActionMasked();
        if (this.mState == 1 && action == 0) {
            return true;
        }
        if (this.mLastStableState != 3 || action != 2 || event.getY() <= ((float) this.mInitialY) || this.mCollapsible) {
            if (this.mViewDragHelper == null) {
                this.mViewDragHelper = ViewDragHelper.create(parent, this.mDragCallback);
            }
            this.mViewDragHelper.processTouchEvent(event);
            if (action == 0) {
                reset();
            }
            if (action == 2 && !this.mIgnoreEvents && Math.abs(((float) this.mInitialY) - event.getY()) > ((float) this.mViewDragHelper.getTouchSlop())) {
                this.mViewDragHelper.captureChildView(child, event.getPointerId(event.getActionIndex()));
            }
            return !this.mIgnoreEvents;
        }
        reset();
        return false;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View directTargetChild, View target, int nestedScrollAxes, int type) {
        this.mNestedScrolled = false;
        if ((nestedScrollAxes & 2) != 0) {
            return true;
        }
        return false;
    }

    private class ScrollVelocityTracker {
        private long mPreviousScrollTime;
        private float mScrollVelocity;

        private ScrollVelocityTracker() {
            this.mPreviousScrollTime = 0;
            this.mScrollVelocity = 0.0f;
        }

        public void recordScroll(int dy) {
            long now = System.currentTimeMillis();
            long j = this.mPreviousScrollTime;
            if (j != 0) {
                this.mScrollVelocity = (((float) dy) / ((float) (now - j))) * 1000.0f;
            }
            this.mPreviousScrollTime = now;
        }

        public void clear() {
            this.mPreviousScrollTime = 0;
            this.mScrollVelocity = 0.0f;
        }

        public float getScrollVelocity() {
            return this.mScrollVelocity;
        }
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V child, View target, int dx, int dy, int[] consumed, int type) {
        if (target == ((View) this.mNestedScrollingChildRef.get())) {
            this.mScrollVelocityTracker.recordScroll(dy);
            int currentTop = child.getTop();
            int newTop = currentTop - dy;
            int i = this.mLastStableState;
            if ((i != 5 || newTop >= this.mAnchorPoint) && (i != 4 || newTop <= this.mAnchorPoint)) {
                if (dy > 0) {
                    int i2 = this.mMinOffset;
                    if (newTop < i2) {
                        consumed[1] = currentTop - i2;
                        ViewCompat.offsetTopAndBottom(child, -consumed[1]);
                        setStateInternal(4);
                    } else {
                        consumed[1] = dy;
                        ViewCompat.offsetTopAndBottom(child, -dy);
                        setStateInternal(1);
                    }
                } else if (dy < 0 && !ViewCompat.canScrollVertically(target, -1)) {
                    int i3 = this.mMaxOffset;
                    if (newTop <= i3 || this.mHideable) {
                        boolean z = this.mCollapsible;
                        if (z || (!z && this.mAnchorPoint - newTop >= 0)) {
                            consumed[1] = dy;
                            ViewCompat.offsetTopAndBottom(child, -dy);
                            setStateInternal(1);
                        }
                    } else {
                        consumed[1] = currentTop - i3;
                        ViewCompat.offsetTopAndBottom(child, -consumed[1]);
                        setStateInternal(5);
                    }
                }
                dispatchOnSlide(child.getTop());
                this.mNestedScrolled = true;
                return;
            }
            dispatchOnSlide(child.getTop());
            this.mNestedScrolled = true;
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target, int type) {
        int top;
        int currentTop;
        if (child.getTop() == this.mMinOffset) {
            setStateInternal(4);
            this.mLastStableState = 4;
        } else if (target == this.mNestedScrollingChildRef.get() && this.mNestedScrolled) {
            float scrollVelocity = this.mScrollVelocityTracker.getScrollVelocity();
            float f = this.mMinimumVelocity;
            if (scrollVelocity > f) {
                int top2 = this.mLastStableState;
                if (top2 == 5) {
                    currentTop = this.mAnchorPoint;
                    top = 3;
                } else if (top2 == 3) {
                    currentTop = this.mMinOffset;
                    top = 4;
                } else {
                    currentTop = this.mMinOffset;
                    top = 4;
                }
            } else if (scrollVelocity < (-f)) {
                int i = this.mLastStableState;
                if (i == 4) {
                    currentTop = this.mAnchorPoint;
                    top = 3;
                } else if (this.mCollapsible != 1) {
                    currentTop = this.mAnchorPoint;
                    top = 3;
                } else if (i == 3) {
                    currentTop = this.mMaxOffset;
                    top = 5;
                } else {
                    currentTop = this.mMaxOffset;
                    top = 5;
                }
            } else {
                int top3 = child.getTop();
                int i2 = this.mAnchorPoint;
                if (((double) top3) > ((double) i2) * 1.25d && this.mCollapsible) {
                    currentTop = this.mMaxOffset;
                    top = 5;
                } else if (((double) top3) < ((double) i2) * 0.5d) {
                    currentTop = this.mMinOffset;
                    top = 4;
                } else {
                    currentTop = this.mAnchorPoint;
                    top = 3;
                }
            }
            this.mLastStableState = top;
            if (this.mViewDragHelper.smoothSlideViewTo(child, child.getLeft(), currentTop)) {
                setStateInternal(2);
                ViewCompat.postOnAnimation(child, new SettleRunnable(child, top));
            } else {
                setStateInternal(top);
            }
            this.mNestedScrolled = false;
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V child, View target, float velocityX, float velocityY) {
        return target == this.mNestedScrollingChildRef.get() && (this.mState != 4 || BLBottomSheetBehavior.super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY));
    }

    public final void setPeekHeight(int peekHeight) {
        this.mPeekHeight = Math.max(0, peekHeight);
        this.mMaxOffset = this.mParentHeight - peekHeight;
    }

    public final int getPeekHeight() {
        return this.mPeekHeight;
    }

    public void setAnchorPoint(int anchorPoint) {
        this.mAnchorPoint = anchorPoint;
    }

    public int getAnchorPoint() {
        return this.mAnchorPoint;
    }

    public void setHideable(boolean hideable) {
        this.mHideable = hideable;
    }

    public boolean isHideable() {
        return this.mHideable;
    }

    public void setCollapsible(boolean collapsible) {
        this.mCollapsible = collapsible;
    }

    public boolean isCollapsible() {
        return this.mCollapsible;
    }

    public void addBottomSheetCallback(BottomSheetCallback callback) {
        if (this.mCallback == null) {
            this.mCallback = new Vector<>();
        }
        this.mCallback.add(callback);
    }

    public final void setState(int state) {
        int top;
        if (state != this.mState) {
            if (state == 5 || state == 4 || state == 3 || (this.mHideable && state == 6)) {
                this.mState = state;
                this.mLastStableState = state;
            }
            WeakReference<V> weakReference = this.mViewRef;
            V child = weakReference == null ? null : (View) weakReference.get();
            if (child != null) {
                if (state == 5) {
                    top = this.mMaxOffset;
                } else if (state == 3) {
                    top = this.mAnchorPoint;
                } else if (state == 4) {
                    top = this.mMinOffset;
                } else if (!this.mHideable || state != 6) {
                    throw new IllegalArgumentException("Illegal state argument: " + state);
                } else {
                    top = this.mParentHeight;
                }
                setStateInternal(2);
                if (this.mViewDragHelper.smoothSlideViewTo(child, child.getLeft(), top)) {
                    ViewCompat.postOnAnimation(child, new SettleRunnable(child, state));
                }
            }
        }
    }

    public final int getState() {
        return this.mState;
    }

    /* access modifiers changed from: private */
    public void setStateInternal(int state) {
        if (this.mState != state) {
            this.mState = state;
            View bottomSheet = (View) this.mViewRef.get();
            if (bottomSheet != null && this.mCallback != null) {
                notifyStateChangedToListeners(bottomSheet, state);
            }
        }
    }

    private void notifyStateChangedToListeners(View bottomSheet, int newState) {
        Iterator<BottomSheetCallback> it = this.mCallback.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(bottomSheet, newState);
        }
    }

    private void notifyOnSlideToListeners(View bottomSheet, float slideOffset) {
        Iterator<BottomSheetCallback> it = this.mCallback.iterator();
        while (it.hasNext()) {
            it.next().onSlide(bottomSheet, slideOffset);
        }
    }

    private void reset() {
        this.mActivePointerId = -1;
    }

    /* access modifiers changed from: private */
    public boolean shouldHide(View child, float yvel) {
        if (child.getTop() >= this.mMaxOffset && Math.abs((((float) child.getTop()) + (HIDE_FRICTION * yvel)) - ((float) this.mMaxOffset)) / ((float) this.mPeekHeight) > HIDE_THRESHOLD) {
            return true;
        }
        return false;
    }

    private View findScrollingChild(View view) {
        if (view instanceof NestedScrollingChild) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup group = (ViewGroup) view;
        int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            View scrollingChild = findScrollingChild(group.getChildAt(i));
            if (scrollingChild != null) {
                return scrollingChild;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void dispatchOnSlide(int top) {
        View bottomSheet = (View) this.mViewRef.get();
        if (bottomSheet != null && this.mCallback != null) {
            int i = this.mMaxOffset;
            if (top > i) {
                notifyOnSlideToListeners(bottomSheet, ((float) (i - top)) / ((float) this.mPeekHeight));
            } else {
                notifyOnSlideToListeners(bottomSheet, ((float) (i - top)) / ((float) (i - this.mMinOffset)));
            }
        }
    }

    private class SettleRunnable implements Runnable {
        private final int mTargetState;
        private final View mView;

        SettleRunnable(View view, int targetState) {
            this.mView = view;
            this.mTargetState = targetState;
        }

        public void run() {
            if (BLBottomSheetBehavior.this.mViewDragHelper == null || !BLBottomSheetBehavior.this.mViewDragHelper.continueSettling(true)) {
                BLBottomSheetBehavior.this.setStateInternal(this.mTargetState);
            } else {
                ViewCompat.postOnAnimation(this.mView, this);
            }
        }
    }

    protected static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        final int state;

        public SavedState(Parcel source) {
            super(source);
            this.state = source.readInt();
        }

        public SavedState(Parcelable superState, int state2) {
            super(superState);
            this.state = state2;
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.state);
        }
    }

    public static <V extends View> BLBottomSheetBehavior<V> from(V view) {
        CoordinatorLayout.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            BLBottomSheetBehavior<V> behavior = layoutParams.getBehavior();
            if (behavior instanceof BLBottomSheetBehavior) {
                return behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BLBottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public void setTopMargin(float i) {
        this.topMargin = (int) i;
    }
}
