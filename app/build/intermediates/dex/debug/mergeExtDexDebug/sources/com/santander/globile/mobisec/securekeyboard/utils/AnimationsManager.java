package com.santander.globile.mobisec.securekeyboard.utils;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.santander.globile.mobisec.securekeyboard.R;
import com.santander.globile.mobisec.securekeyboard.SanKeyboardView;
import com.santander.globile.mobisec.securekeyboard.listeners.SanEventCallbacks;

public class AnimationsManager {
    /* access modifiers changed from: private */
    public final int contentExpandDelayMillis;
    /* access modifiers changed from: private */
    public ValueAnimator expandContentAnimator;
    /* access modifiers changed from: private */
    public int keyboardHeight;
    /* access modifiers changed from: private */
    public final int screenHeight;
    /* access modifiers changed from: private */
    public ValueAnimator shrinkContentAnimator;
    private Animation slideInAnimation;
    /* access modifiers changed from: private */
    public final int slideInDurationMillis;
    private Animation slideOutAnimation;
    /* access modifiers changed from: private */
    public final int slideOutDurationMillis;

    public AnimationsManager(SanKeyboardView keyboardView) {
        Resources resources = keyboardView.getResources();
        this.screenHeight = resources.getDisplayMetrics().heightPixels;
        this.slideInDurationMillis = resources.getInteger(17694720);
        this.slideOutDurationMillis = resources.getInteger(17694720);
        this.contentExpandDelayMillis = resources.getInteger(17694720);
        initKeyboardRelatedAnimations(keyboardView);
    }

    public Animation getSlideInAnimation() {
        return this.slideInAnimation;
    }

    public Animation getSlideOutAnimation() {
        return this.slideOutAnimation;
    }

    private void initKeyboardRelatedAnimations(final SanKeyboardView keyboardView) {
        ViewGroup keyboardParent = (ViewGroup) keyboardView.getParent();
        int keyboardIndexInParent = keyboardParent.indexOfChild(keyboardView);
        if (keyboardIndexInParent == 0) {
            keyboardIndexInParent++;
        }
        final View contentView = keyboardParent.getChildAt(keyboardIndexInParent - 1);
        final int originalContentHeight = contentView.getMeasuredHeight();
        final ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
                layoutParams.height = -1;
                contentView.setLayoutParams(layoutParams);
            }
        };
        Animation loadAnimation = AnimationUtils.loadAnimation(keyboardView.getContext(), R.anim.slide_in);
        this.slideInAnimation = loadAnimation;
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
                keyboardView.setVisibility(0);
                if (AnimationsManager.this.keyboardHeight == 0) {
                    keyboardView.measure(0, 0);
                    int unused = AnimationsManager.this.keyboardHeight = keyboardView.getMeasuredHeight();
                }
                if (originalContentHeight > AnimationsManager.this.screenHeight - AnimationsManager.this.keyboardHeight) {
                    if (AnimationsManager.this.shrinkContentAnimator == null) {
                        AnimationsManager animationsManager = AnimationsManager.this;
                        int i = originalContentHeight;
                        ValueAnimator unused2 = animationsManager.shrinkContentAnimator = ValueAnimator.ofInt(new int[]{i, i - animationsManager.keyboardHeight});
                        AnimationsManager.this.shrinkContentAnimator.setDuration((long) AnimationsManager.this.slideInDurationMillis);
                        AnimationsManager.this.shrinkContentAnimator.addUpdateListener(animatorUpdateListener);
                    }
                    AnimationsManager.this.shrinkContentAnimator.start();
                }
            }

            public void onAnimationEnd(Animation animation) {
                SanEventCallbacks eventListener = keyboardView.getEventListener();
                if (eventListener != null) {
                    eventListener.onSanKeyboardShown(keyboardView);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        Animation loadAnimation2 = AnimationUtils.loadAnimation(keyboardView.getContext(), R.anim.slide_out);
        this.slideOutAnimation = loadAnimation2;
        final SanKeyboardView sanKeyboardView = keyboardView;
        final int i = originalContentHeight;
        final View view = contentView;
        final ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = animatorUpdateListener;
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
                if (AnimationsManager.this.keyboardHeight == 0) {
                    int unused = AnimationsManager.this.keyboardHeight = sanKeyboardView.getMeasuredHeight();
                }
                if (i > AnimationsManager.this.screenHeight - AnimationsManager.this.keyboardHeight) {
                    if (AnimationsManager.this.expandContentAnimator == null) {
                        ValueAnimator unused2 = AnimationsManager.this.expandContentAnimator = ValueAnimator.ofInt(new int[]{view.getMeasuredHeight(), i});
                        AnimationsManager.this.expandContentAnimator.setDuration((long) (AnimationsManager.this.slideOutDurationMillis + AnimationsManager.this.contentExpandDelayMillis));
                        AnimationsManager.this.expandContentAnimator.addUpdateListener(animatorUpdateListener2);
                    }
                    AnimationsManager.this.expandContentAnimator.start();
                }
            }

            public void onAnimationEnd(Animation animation) {
                sanKeyboardView.setVisibility(8);
                SanEventCallbacks eventListener = sanKeyboardView.getEventListener();
                if (eventListener != null) {
                    eventListener.onSanKeyboardHidden(sanKeyboardView);
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}
