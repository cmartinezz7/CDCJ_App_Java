package com.santander.globile.mobisec.securekeyboard.scrolling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;

class LockableScrollView extends NestedScrollView {
    private boolean enableScrolling = true;

    public LockableScrollView(Context context) {
        super(context);
    }

    public LockableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LockableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isEnableScrolling() {
        return this.enableScrolling;
    }

    public void setEnableScrolling(boolean enableScrolling2) {
        this.enableScrolling = enableScrolling2;
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isEnableScrolling()) {
            return LockableScrollView.super.onInterceptTouchEvent(ev);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (isEnableScrolling()) {
            return LockableScrollView.super.onTouchEvent(ev);
        }
        return false;
    }
}
