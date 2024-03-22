package com.santander.globile.uicomponents.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\b\u001a\u00020\t\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003¨\u0006\n"}, d2 = {"toDP", "", "getToDP", "(I)I", "toPx", "getToPx", "toDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "uicomponentslib_debug"}, k = 2, mv = {1, 1, 15})
/* compiled from: IntExtensions.kt */
public final class IntExtensionsKt {
    public static final int getToPx(int $this$toPx) {
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        return (int) (((float) $this$toPx) / system.getDisplayMetrics().density);
    }

    public static final int getToDP(int $this$toDP) {
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        return (int) (((float) $this$toDP) * system.getDisplayMetrics().density);
    }

    public static final Drawable toDrawable(int $this$toDrawable, Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if ($this$toDrawable <= 0) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getResources().getDrawable($this$toDrawable, (Resources.Theme) null);
        }
        return ResourcesCompat.getDrawable(context.getResources(), $this$toDrawable, context.getTheme());
    }
}
