package net.opacapp.multilinecollapsingtoolbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

class ViewUtilsLollipop {
    private static final int[] STATE_LIST_ANIM_ATTRS = {16843848};

    ViewUtilsLollipop() {
    }

    static void setBoundsViewOutlineProvider(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void setStateListAnimatorFromAttrs(View view, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        Context context = view.getContext();
        TypedArray a = context.obtainStyledAttributes(attrs, STATE_LIST_ANIM_ATTRS, defStyleAttr, defStyleRes);
        try {
            if (a.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, a.getResourceId(0, 0)));
            }
        } finally {
            a.recycle();
        }
    }

    static void setDefaultAppBarLayoutStateListAnimator(View view, float targetElevation) {
        StateListAnimator sla = new StateListAnimator();
        sla.addState(new int[]{16842766, 2130772008, 2130772007}, ObjectAnimator.ofFloat(view, "elevation", new float[]{targetElevation}));
        sla.addState(new int[]{16842766, 2130772008, -2130772007}, ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}));
        sla.addState(new int[]{16842766, -2130772008}, ObjectAnimator.ofFloat(view, "elevation", new float[]{targetElevation}));
        sla.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}));
        view.setStateListAnimator(sla);
    }
}
