package es.santander.branchlocator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.viewpager.widget.ViewPager;

class BLViewPager extends ViewPager implements Animation.AnimationListener {
    private long animDuration = 100;
    private View currentView;
    private boolean isAnimStarted = false;
    private boolean isPagingEnabled = true;
    private PagerAnimation pagerAnimation;

    public BLViewPager(Context context) {
        super(context);
        PagerAnimation pagerAnimation2 = new PagerAnimation();
        this.pagerAnimation = pagerAnimation2;
        pagerAnimation2.setAnimationListener(this);
    }

    public BLViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        PagerAnimation pagerAnimation2 = new PagerAnimation();
        this.pagerAnimation = pagerAnimation2;
        pagerAnimation2.setAnimationListener(this);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view;
        BLViewPager.super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!this.isAnimStarted && (view = this.currentView) != null) {
            view.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
            int height = this.currentView.getMeasuredHeight();
            if (height < getMinimumHeight()) {
                height = getMinimumHeight();
            }
            int newHeight = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            if (getLayoutParams().height == 0 || heightMeasureSpec == newHeight) {
                heightMeasureSpec = newHeight;
            } else {
                this.pagerAnimation.setDimensions(height, getLayoutParams().height);
                this.pagerAnimation.setDuration(this.animDuration);
                startAnimation(this.pagerAnimation);
                this.isAnimStarted = true;
            }
        }
        BLViewPager.super.onMeasure(widthMeasureSpec, heightMeasureSpec + 300);
    }

    public void onPageChanged(View currentView2) {
        this.currentView = currentView2;
        requestLayout();
    }

    private class PagerAnimation extends Animation {
        private int currentHeight;
        private int heightChange;
        private int targetHeight;

        private PagerAnimation() {
        }

        /* access modifiers changed from: package-private */
        public void setDimensions(int targetHeight2, int currentHeight2) {
            this.targetHeight = targetHeight2;
            this.currentHeight = currentHeight2;
            this.heightChange = targetHeight2 - currentHeight2;
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float interpolatedTime, Transformation t) {
            if (interpolatedTime >= 1.0f) {
                BLViewPager.this.getLayoutParams().height = this.targetHeight;
            } else {
                BLViewPager.this.getLayoutParams().height = this.currentHeight + ((int) (((float) this.heightChange) * interpolatedTime));
            }
            BLViewPager.this.requestLayout();
        }

        public boolean willChangeBounds() {
            return true;
        }
    }

    public void onAnimationStart(Animation animation) {
        this.isAnimStarted = true;
    }

    public void onAnimationEnd(Animation animation) {
        this.isAnimStarted = false;
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && BLViewPager.super.onTouchEvent(event);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && BLViewPager.super.onInterceptTouchEvent(event);
    }

    public void setPagingEnabled(boolean b) {
        this.isPagingEnabled = b;
    }
}
