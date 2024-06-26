package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;

class FadeTabIndicatorInterpolator extends TabIndicatorInterpolator {
    private static final float FADE_THRESHOLD = 0.5f;

    FadeTabIndicatorInterpolator() {
    }

    /* access modifiers changed from: package-private */
    public void updateIndicatorForOffset(TabLayout tabLayout, View startTitle, View endTitle, float offset, Drawable indicator) {
        float alpha;
        RectF bounds = calculateIndicatorWidthForTab(tabLayout, offset < FADE_THRESHOLD ? startTitle : endTitle);
        if (offset < FADE_THRESHOLD) {
            alpha = AnimationUtils.lerp(1.0f, 0.0f, 0.0f, FADE_THRESHOLD, offset);
        } else {
            alpha = AnimationUtils.lerp(0.0f, 1.0f, FADE_THRESHOLD, 1.0f, offset);
        }
        indicator.setBounds((int) bounds.left, indicator.getBounds().top, (int) bounds.right, indicator.getBounds().bottom);
        indicator.setAlpha((int) (255.0f * alpha));
    }
}
