package net.opacapp.multilinecollapsingtoolbar;

import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

class AnimationUtils {
    static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();

    AnimationUtils() {
    }

    static float lerp(float startValue, float endValue, float fraction) {
        return ((endValue - startValue) * fraction) + startValue;
    }

    static int lerp(int startValue, int endValue, float fraction) {
        return Math.round(((float) (endValue - startValue)) * fraction) + startValue;
    }

    static class AnimationListenerAdapter implements Animation.AnimationListener {
        AnimationListenerAdapter() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }
}
