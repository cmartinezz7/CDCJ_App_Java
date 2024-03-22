package com.shuhart.bubblepagerindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import kotlin.KotlinVersion;

abstract class MotionIndicator extends View {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;
    protected int currentPage;
    private boolean isDragging;
    private float lastMotionX;
    private int touchSlop;
    protected ViewPager viewPager;

    /* access modifiers changed from: protected */
    public abstract int getCount();

    public MotionIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public MotionIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MotionIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.lastMotionX = -1.0f;
        this.activePointerId = -1;
        this.touchSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (super.onTouchEvent(ev)) {
            return true;
        }
        int newPointerIndex = 0;
        if (this.viewPager == null || getCount() == 0) {
            return false;
        }
        int action = ev.getAction() & KotlinVersion.MAX_COMPONENT_VALUE;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = (float) ev.findPointerIndex(ev.findPointerIndex(this.activePointerId));
                    float deltaX = x - this.lastMotionX;
                    if (!this.isDragging && Math.abs(deltaX) > ((float) this.touchSlop)) {
                        this.isDragging = true;
                    }
                    if (this.isDragging) {
                        this.lastMotionX = x;
                        if (this.viewPager.isFakeDragging() || this.viewPager.beginFakeDrag()) {
                            this.viewPager.fakeDragBy(deltaX);
                        }
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int index = ev.getActionIndex();
                        this.lastMotionX = ev.getX(index);
                        this.activePointerId = ev.getPointerId(index);
                    } else if (action == 6) {
                        int pointerIndex = ev.getActionIndex();
                        if (ev.getPointerId(pointerIndex) == this.activePointerId) {
                            if (pointerIndex == 0) {
                                newPointerIndex = 1;
                            }
                            this.activePointerId = ev.getPointerId(newPointerIndex);
                        }
                        this.lastMotionX = ev.getX(ev.findPointerIndex(this.activePointerId));
                    }
                }
            }
            if (!this.isDragging) {
                int count = getCount();
                int width = getWidth();
                float halfWidth = ((float) width) / 2.0f;
                float sixthWidth = ((float) width) / 6.0f;
                if (this.currentPage > 0 && ev.getX() < halfWidth - sixthWidth) {
                    if (action != 3) {
                        this.viewPager.setCurrentItem(this.currentPage - 1);
                    }
                    return true;
                } else if (this.currentPage < count - 1 && ev.getX() > halfWidth + sixthWidth) {
                    if (action != 3) {
                        this.viewPager.setCurrentItem(this.currentPage + 1);
                    }
                    return true;
                }
            }
            this.isDragging = false;
            this.activePointerId = -1;
            if (this.viewPager.isFakeDragging()) {
                this.viewPager.endFakeDrag();
            }
        } else {
            this.activePointerId = ev.getPointerId(0);
            this.lastMotionX = ev.getX();
        }
        return true;
    }
}
