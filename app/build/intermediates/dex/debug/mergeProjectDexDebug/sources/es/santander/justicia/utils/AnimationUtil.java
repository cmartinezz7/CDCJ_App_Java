package es.santander.justicia.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class AnimationUtil {
    public static final void verticalExpandTranformation(View viewValue) {
        if (viewValue.getVisibility() == 0) {
            verticalCollapse(viewValue);
        } else {
            verticalExpand(viewValue);
        }
    }

    public static void verticalExpand(final View viewValue) {
        if (viewValue.getVisibility() != 0) {
            viewValue.measure(-1, -2);
            final int targtetHeight = viewValue.getMeasuredHeight();
            viewValue.getLayoutParams().height = 0;
            viewValue.setVisibility(0);
            Animation animation = new Animation() {
                /* access modifiers changed from: protected */
                public void applyTransformation(float interpolatedTime, Transformation transformation) {
                    viewValue.getLayoutParams().height = interpolatedTime == 1.0f ? -2 : (int) (((float) targtetHeight) * interpolatedTime);
                    viewValue.requestLayout();
                }

                public boolean willChangeBounds() {
                    return true;
                }
            };
            animation.setDuration((long) ((int) (((float) targtetHeight) / viewValue.getContext().getResources().getDisplayMetrics().density)));
            viewValue.startAnimation(animation);
        }
    }

    public static void verticalCollapse(final View viewValue) {
        if (viewValue.getVisibility() != 8) {
            final int initialHeight = viewValue.getMeasuredHeight();
            Animation animation = new Animation() {
                /* access modifiers changed from: protected */
                public void applyTransformation(float interpolatedTime, Transformation transformation) {
                    if (interpolatedTime == 1.0f) {
                        viewValue.setVisibility(8);
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = viewValue.getLayoutParams();
                    int i = initialHeight;
                    layoutParams.height = i - ((int) (((float) i) * interpolatedTime));
                    viewValue.requestLayout();
                }

                public boolean willChangeBounds() {
                    return true;
                }
            };
            animation.setDuration((long) ((int) (((float) initialHeight) / viewValue.getContext().getResources().getDisplayMetrics().density)));
            viewValue.startAnimation(animation);
        }
    }

    public static final void horizontalExpandTranformation(View viewValue) {
        if (viewValue.getVisibility() == 0) {
            horizontalCollapse(viewValue);
        } else {
            horizontalExpand(viewValue);
        }
    }

    public static void horizontalExpand(final View viewValue) {
        if (viewValue.getVisibility() != 0) {
            viewValue.measure(-2, -2);
            final int targetWidth = viewValue.getMeasuredWidth();
            viewValue.getLayoutParams().width = 0;
            viewValue.setVisibility(0);
            Animation animation = new Animation() {
                /* access modifiers changed from: protected */
                public void applyTransformation(float interpolatedTime, Transformation transformation) {
                    viewValue.getLayoutParams().width = interpolatedTime == 1.0f ? -2 : (int) (((float) targetWidth) * interpolatedTime);
                    viewValue.requestLayout();
                }

                public boolean willChangeBounds() {
                    return true;
                }
            };
            animation.setDuration((long) ((int) (((float) targetWidth) / viewValue.getContext().getResources().getDisplayMetrics().density)));
            viewValue.startAnimation(animation);
        }
    }

    public static void horizontalCollapse(final View viewValue) {
        if (viewValue.getVisibility() != 8) {
            final int initialWidth = viewValue.getMeasuredWidth();
            Animation animation = new Animation() {
                /* access modifiers changed from: protected */
                public void applyTransformation(float interpolatedTime, Transformation transformation) {
                    if (interpolatedTime == 1.0f) {
                        viewValue.setVisibility(8);
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = viewValue.getLayoutParams();
                    int i = initialWidth;
                    layoutParams.width = i - ((int) (((float) i) * interpolatedTime));
                    viewValue.requestLayout();
                }

                public boolean willChangeBounds() {
                    return true;
                }
            };
            animation.setDuration((long) ((int) (((float) initialWidth) / viewValue.getContext().getResources().getDisplayMetrics().density)));
            viewValue.startAnimation(animation);
        }
    }
}
