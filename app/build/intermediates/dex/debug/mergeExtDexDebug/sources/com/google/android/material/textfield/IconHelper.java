package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;

class IconHelper {
    private IconHelper() {
    }

    static void setIconOnClickListener(CheckableImageButton iconView, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        iconView.setOnClickListener(onClickListener);
        setIconClickable(iconView, onLongClickListener);
    }

    static void setIconOnLongClickListener(CheckableImageButton iconView, View.OnLongClickListener onLongClickListener) {
        iconView.setOnLongClickListener(onLongClickListener);
        setIconClickable(iconView, onLongClickListener);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.material.internal.CheckableImageButton, android.view.View] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void setIconClickable(com.google.android.material.internal.CheckableImageButton r4, android.view.View.OnLongClickListener r5) {
        /*
            boolean r0 = androidx.core.view.ViewCompat.hasOnClickListeners(r4)
            r1 = 0
            r2 = 1
            if (r5 == 0) goto L_0x000a
            r3 = r2
            goto L_0x000b
        L_0x000a:
            r3 = r1
        L_0x000b:
            if (r0 != 0) goto L_0x000f
            if (r3 == 0) goto L_0x0010
        L_0x000f:
            r1 = r2
        L_0x0010:
            r4.setFocusable(r1)
            r4.setClickable(r0)
            r4.setPressable(r0)
            r4.setLongClickable(r3)
            if (r1 == 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r2 = 2
        L_0x0021:
            androidx.core.view.ViewCompat.setImportantForAccessibility(r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.IconHelper.setIconClickable(com.google.android.material.internal.CheckableImageButton, android.view.View$OnLongClickListener):void");
    }

    static void applyIconTint(TextInputLayout textInputLayout, CheckableImageButton iconView, ColorStateList iconTintList, PorterDuff.Mode iconTintMode) {
        Drawable icon = iconView.getDrawable();
        if (icon != null) {
            icon = DrawableCompat.wrap(icon).mutate();
            if (iconTintList == null || !iconTintList.isStateful()) {
                DrawableCompat.setTintList(icon, iconTintList);
            } else {
                DrawableCompat.setTintList(icon, ColorStateList.valueOf(iconTintList.getColorForState(mergeIconState(textInputLayout, iconView), iconTintList.getDefaultColor())));
            }
            if (iconTintMode != null) {
                DrawableCompat.setTintMode(icon, iconTintMode);
            }
        }
        if (iconView.getDrawable() != icon) {
            iconView.setImageDrawable(icon);
        }
    }

    static void refreshIconDrawableState(TextInputLayout textInputLayout, CheckableImageButton iconView, ColorStateList colorStateList) {
        Drawable icon = iconView.getDrawable();
        if (iconView.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int color = colorStateList.getColorForState(mergeIconState(textInputLayout, iconView), colorStateList.getDefaultColor());
            Drawable icon2 = DrawableCompat.wrap(icon).mutate();
            DrawableCompat.setTintList(icon2, ColorStateList.valueOf(color));
            iconView.setImageDrawable(icon2);
        }
    }

    private static int[] mergeIconState(TextInputLayout textInputLayout, CheckableImageButton iconView) {
        int[] textInputStates = textInputLayout.getDrawableState();
        int[] iconStates = iconView.getDrawableState();
        int index = textInputStates.length;
        int[] states = Arrays.copyOf(textInputStates, textInputStates.length + iconStates.length);
        System.arraycopy(iconStates, 0, states, index, iconStates.length);
        return states;
    }
}
