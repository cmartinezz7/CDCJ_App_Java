package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class ClickActionDelegate extends AccessibilityDelegateCompat {
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat clickAction;

    public ClickActionDelegate(Context context, int resId) {
        this.clickAction = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, context.getString(resId));
    }

    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        ClickActionDelegate.super.onInitializeAccessibilityNodeInfo(host, info);
        info.addAction(this.clickAction);
    }
}
