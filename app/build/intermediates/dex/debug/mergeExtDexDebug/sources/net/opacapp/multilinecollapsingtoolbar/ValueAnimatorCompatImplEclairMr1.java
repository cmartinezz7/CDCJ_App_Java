package net.opacapp.multilinecollapsingtoolbar;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import net.opacapp.multilinecollapsingtoolbar.ValueAnimatorCompat;

class ValueAnimatorCompatImplEclairMr1 extends ValueAnimatorCompat.Impl {
    private static final int DEFAULT_DURATION = 200;
    private static final int HANDLER_DELAY = 10;
    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    private float mAnimatedFraction;
    private long mDuration = 200;
    private final float[] mFloatValues = new float[2];
    private final int[] mIntValues = new int[2];
    private Interpolator mInterpolator;
    private boolean mIsRunning;
    private ValueAnimatorCompat.Impl.AnimatorListenerProxy mListener;
    private final Runnable mRunnable = new Runnable() {
        public void run() {
            ValueAnimatorCompatImplEclairMr1.this.update();
        }
    };
    private long mStartTime;
    private ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy mUpdateListener;

    ValueAnimatorCompatImplEclairMr1() {
    }

    public void start() {
        if (!this.mIsRunning) {
            if (this.mInterpolator == null) {
                this.mInterpolator = new AccelerateDecelerateInterpolator();
            }
            this.mStartTime = SystemClock.uptimeMillis();
            this.mIsRunning = true;
            this.mAnimatedFraction = 0.0f;
            ValueAnimatorCompat.Impl.AnimatorListenerProxy animatorListenerProxy = this.mListener;
            if (animatorListenerProxy != null) {
                animatorListenerProxy.onAnimationStart();
            }
            sHandler.postDelayed(this.mRunnable, 10);
        }
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setListener(ValueAnimatorCompat.Impl.AnimatorListenerProxy listener) {
        this.mListener = listener;
    }

    public void setUpdateListener(ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy updateListener) {
        this.mUpdateListener = updateListener;
    }

    public void setIntValues(int from, int to) {
        int[] iArr = this.mIntValues;
        iArr[0] = from;
        iArr[1] = to;
    }

    public int getAnimatedIntValue() {
        int[] iArr = this.mIntValues;
        return AnimationUtils.lerp(iArr[0], iArr[1], getAnimatedFraction());
    }

    public void setFloatValues(float from, float to) {
        float[] fArr = this.mFloatValues;
        fArr[0] = from;
        fArr[1] = to;
    }

    public float getAnimatedFloatValue() {
        float[] fArr = this.mFloatValues;
        return AnimationUtils.lerp(fArr[0], fArr[1], getAnimatedFraction());
    }

    public void setDuration(long duration) {
        this.mDuration = duration;
    }

    public void cancel() {
        this.mIsRunning = false;
        sHandler.removeCallbacks(this.mRunnable);
        ValueAnimatorCompat.Impl.AnimatorListenerProxy animatorListenerProxy = this.mListener;
        if (animatorListenerProxy != null) {
            animatorListenerProxy.onAnimationCancel();
            this.mListener.onAnimationEnd();
        }
    }

    public float getAnimatedFraction() {
        return this.mAnimatedFraction;
    }

    public void end() {
        if (this.mIsRunning) {
            this.mIsRunning = false;
            sHandler.removeCallbacks(this.mRunnable);
            this.mAnimatedFraction = 1.0f;
            ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy animatorUpdateListenerProxy = this.mUpdateListener;
            if (animatorUpdateListenerProxy != null) {
                animatorUpdateListenerProxy.onAnimationUpdate();
            }
            ValueAnimatorCompat.Impl.AnimatorListenerProxy animatorListenerProxy = this.mListener;
            if (animatorListenerProxy != null) {
                animatorListenerProxy.onAnimationEnd();
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    /* access modifiers changed from: private */
    public void update() {
        if (this.mIsRunning) {
            float linearFraction = MathUtils.constrain(((float) (SystemClock.uptimeMillis() - this.mStartTime)) / ((float) this.mDuration), 0.0f, 1.0f);
            Interpolator interpolator = this.mInterpolator;
            this.mAnimatedFraction = interpolator != null ? interpolator.getInterpolation(linearFraction) : linearFraction;
            ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy animatorUpdateListenerProxy = this.mUpdateListener;
            if (animatorUpdateListenerProxy != null) {
                animatorUpdateListenerProxy.onAnimationUpdate();
            }
            if (SystemClock.uptimeMillis() >= this.mStartTime + this.mDuration) {
                this.mIsRunning = false;
                ValueAnimatorCompat.Impl.AnimatorListenerProxy animatorListenerProxy = this.mListener;
                if (animatorListenerProxy != null) {
                    animatorListenerProxy.onAnimationEnd();
                }
            }
        }
        if (this.mIsRunning) {
            sHandler.postDelayed(this.mRunnable, 10);
        }
    }
}
