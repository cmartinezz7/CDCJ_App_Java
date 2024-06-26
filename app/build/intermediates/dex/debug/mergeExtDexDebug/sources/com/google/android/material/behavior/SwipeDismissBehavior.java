package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float alphaEndSwipeDistance = 0.5f;
    float alphaStartSwipeDistance = DEFAULT_ALPHA_START_DISTANCE;
    private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        private static final int INVALID_POINTER_ID = -1;
        private int activePointerId = -1;
        private int originalCapturedViewLeft;

        public boolean tryCaptureView(View child, int pointerId) {
            int i = this.activePointerId;
            return (i == -1 || i == pointerId) && SwipeDismissBehavior.this.canSwipeDismissView(child);
        }

        public void onViewCaptured(View capturedChild, int activePointerId2) {
            this.activePointerId = activePointerId2;
            this.originalCapturedViewLeft = capturedChild.getLeft();
            ViewParent parent = capturedChild.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void onViewDragStateChanged(int state) {
            if (SwipeDismissBehavior.this.listener != null) {
                SwipeDismissBehavior.this.listener.onDragStateChanged(state);
            }
        }

        public void onViewReleased(View child, float xvel, float yvel) {
            int targetLeft;
            int i;
            this.activePointerId = -1;
            int childWidth = child.getWidth();
            boolean dismiss = false;
            if (shouldDismiss(child, xvel)) {
                int left = child.getLeft();
                int i2 = this.originalCapturedViewLeft;
                if (left < i2) {
                    i = i2 - childWidth;
                } else {
                    i = i2 + childWidth;
                }
                targetLeft = i;
                dismiss = true;
            } else {
                targetLeft = this.originalCapturedViewLeft;
            }
            if (SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(targetLeft, child.getTop())) {
                ViewCompat.postOnAnimation(child, new SettleRunnable(child, dismiss));
            } else if (dismiss && SwipeDismissBehavior.this.listener != null) {
                SwipeDismissBehavior.this.listener.onDismiss(child);
            }
        }

        private boolean shouldDismiss(View child, float xvel) {
            if (xvel != SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                boolean isRtl = ViewCompat.getLayoutDirection(child) == 1;
                if (SwipeDismissBehavior.this.swipeDirection == 2) {
                    return true;
                }
                if (SwipeDismissBehavior.this.swipeDirection == 0) {
                    if (isRtl) {
                        if (xvel >= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                            return false;
                        }
                    } else if (xvel <= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                        return false;
                    }
                    return true;
                } else if (SwipeDismissBehavior.this.swipeDirection != 1) {
                    return false;
                } else {
                    if (isRtl) {
                        if (xvel <= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                            return false;
                        }
                    } else if (xvel >= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                        return false;
                    }
                    return true;
                }
            } else {
                if (Math.abs(child.getLeft() - this.originalCapturedViewLeft) >= Math.round(((float) child.getWidth()) * SwipeDismissBehavior.this.dragDismissThreshold)) {
                    return true;
                }
                return false;
            }
        }

        public int getViewHorizontalDragRange(View child) {
            return child.getWidth();
        }

        public int clampViewPositionHorizontal(View child, int left, int dx) {
            int max;
            int min;
            boolean isRtl = ViewCompat.getLayoutDirection(child) == 1;
            if (SwipeDismissBehavior.this.swipeDirection == 0) {
                if (isRtl) {
                    min = this.originalCapturedViewLeft - child.getWidth();
                    max = this.originalCapturedViewLeft;
                } else {
                    min = this.originalCapturedViewLeft;
                    max = this.originalCapturedViewLeft + child.getWidth();
                }
            } else if (SwipeDismissBehavior.this.swipeDirection != 1) {
                min = this.originalCapturedViewLeft - child.getWidth();
                max = this.originalCapturedViewLeft + child.getWidth();
            } else if (isRtl) {
                min = this.originalCapturedViewLeft;
                max = this.originalCapturedViewLeft + child.getWidth();
            } else {
                min = this.originalCapturedViewLeft - child.getWidth();
                max = this.originalCapturedViewLeft;
            }
            return SwipeDismissBehavior.clamp(min, left, max);
        }

        public int clampViewPositionVertical(View child, int top, int dy) {
            return child.getTop();
        }

        public void onViewPositionChanged(View child, int left, int top, int dx, int dy) {
            float startAlphaDistance = ((float) this.originalCapturedViewLeft) + (((float) child.getWidth()) * SwipeDismissBehavior.this.alphaStartSwipeDistance);
            float endAlphaDistance = ((float) this.originalCapturedViewLeft) + (((float) child.getWidth()) * SwipeDismissBehavior.this.alphaEndSwipeDistance);
            if (((float) left) <= startAlphaDistance) {
                child.setAlpha(1.0f);
            } else if (((float) left) >= endAlphaDistance) {
                child.setAlpha(SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE);
            } else {
                child.setAlpha(SwipeDismissBehavior.clamp((float) SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE, 1.0f - SwipeDismissBehavior.fraction(startAlphaDistance, endAlphaDistance, (float) left), 1.0f));
            }
        }
    };
    float dragDismissThreshold = 0.5f;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private float sensitivity = DEFAULT_ALPHA_START_DISTANCE;
    private boolean sensitivitySet;
    int swipeDirection = 2;
    ViewDragHelper viewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i);
    }

    public void setListener(OnDismissListener listener2) {
        this.listener = listener2;
    }

    public OnDismissListener getListener() {
        return this.listener;
    }

    public void setSwipeDirection(int direction) {
        this.swipeDirection = direction;
    }

    public void setDragDismissDistance(float distance) {
        this.dragDismissThreshold = clamp((float) DEFAULT_ALPHA_START_DISTANCE, distance, 1.0f);
    }

    public void setStartAlphaSwipeDistance(float fraction) {
        this.alphaStartSwipeDistance = clamp((float) DEFAULT_ALPHA_START_DISTANCE, fraction, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float fraction) {
        this.alphaEndSwipeDistance = clamp((float) DEFAULT_ALPHA_START_DISTANCE, fraction, 1.0f);
    }

    public void setSensitivity(float sensitivity2) {
        this.sensitivity = sensitivity2;
        this.sensitivitySet = true;
    }

    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        boolean handled = SwipeDismissBehavior.super.onLayoutChild(parent, child, layoutDirection);
        if (ViewCompat.getImportantForAccessibility(child) == 0) {
            ViewCompat.setImportantForAccessibility(child, 1);
            updateAccessibilityActions(child);
        }
        return handled;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent event) {
        boolean dispatchEventToHelper = this.interceptingEvents;
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.interceptingEvents = parent.isPointInChildBounds(child, (int) event.getX(), (int) event.getY());
            dispatchEventToHelper = this.interceptingEvents;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!dispatchEventToHelper) {
            return false;
        }
        ensureViewDragHelper(parent);
        return this.viewDragHelper.shouldInterceptTouchEvent(event);
    }

    public boolean onTouchEvent(CoordinatorLayout parent, V v, MotionEvent event) {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 == null) {
            return false;
        }
        viewDragHelper2.processTouchEvent(event);
        return true;
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    private void ensureViewDragHelper(ViewGroup parent) {
        ViewDragHelper viewDragHelper2;
        if (this.viewDragHelper == null) {
            if (this.sensitivitySet) {
                viewDragHelper2 = ViewDragHelper.create(parent, this.sensitivity, this.dragCallback);
            } else {
                viewDragHelper2 = ViewDragHelper.create(parent, this.dragCallback);
            }
            this.viewDragHelper = viewDragHelper2;
        }
    }

    private class SettleRunnable implements Runnable {
        private final boolean dismiss;
        private final View view;

        SettleRunnable(View view2, boolean dismiss2) {
            this.view = view2;
            this.dismiss = dismiss2;
        }

        public void run() {
            if (SwipeDismissBehavior.this.viewDragHelper != null && SwipeDismissBehavior.this.viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.view, this);
            } else if (this.dismiss && SwipeDismissBehavior.this.listener != null) {
                SwipeDismissBehavior.this.listener.onDismiss(this.view);
            }
        }
    }

    private void updateAccessibilityActions(View child) {
        ViewCompat.removeAccessibilityAction(child, 1048576);
        if (canSwipeDismissView(child)) {
            ViewCompat.replaceAccessibilityAction(child, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, (CharSequence) null, new AccessibilityViewCommand() {
                public boolean perform(View view, AccessibilityViewCommand.CommandArguments arguments) {
                    boolean dismissToLeft = false;
                    if (!SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                        return false;
                    }
                    boolean isRtl = ViewCompat.getLayoutDirection(view) == 1;
                    if ((SwipeDismissBehavior.this.swipeDirection == 0 && isRtl) || (SwipeDismissBehavior.this.swipeDirection == 1 && !isRtl)) {
                        dismissToLeft = true;
                    }
                    int offset = view.getWidth();
                    if (dismissToLeft) {
                        offset = -offset;
                    }
                    ViewCompat.offsetLeftAndRight(view, offset);
                    view.setAlpha(SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE);
                    if (SwipeDismissBehavior.this.listener != null) {
                        SwipeDismissBehavior.this.listener.onDismiss(view);
                    }
                    return true;
                }
            });
        }
    }

    static float clamp(float min, float value, float max) {
        return Math.min(Math.max(min, value), max);
    }

    static int clamp(int min, int value, int max) {
        return Math.min(Math.max(min, value), max);
    }

    public int getDragState() {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 != null) {
            return viewDragHelper2.getViewDragState();
        }
        return 0;
    }

    static float fraction(float startValue, float endValue, float value) {
        return (value - startValue) / (endValue - startValue);
    }
}
