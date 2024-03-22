package com.santander.globile.uicomponents.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"tintDrawable", "", "Landroidx/appcompat/widget/AppCompatTextView;", "color", "", "uicomponentslib_debug"}, k = 2, mv = {1, 1, 15})
/* compiled from: TextViewExtension.kt */
public final class TextViewExtensionKt {
    public static final void tintDrawable(AppCompatTextView $this$tintDrawable, int color) {
        Intrinsics.checkParameterIsNotNull($this$tintDrawable, "$this$tintDrawable");
        for (Drawable drawable : $this$tintDrawable.getCompoundDrawables()) {
            if (Build.VERSION.SDK_INT >= 23) {
                Context context = $this$tintDrawable.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                drawable.setColorFilter(new PorterDuffColorFilter(context.getResources().getColor(color, (Resources.Theme) null), PorterDuff.Mode.SRC_IN));
            } else {
                Context context2 = $this$tintDrawable.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                drawable.setColorFilter(new PorterDuffColorFilter(context2.getResources().getColor(color), PorterDuff.Mode.SRC_IN));
            }
        }
    }
}
