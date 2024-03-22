package com.santander.globile.uicomponents.calendar.utils;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"convertToDefaultColor", "", "context", "Landroid/content/Context;", "colorRes", "uicomponentslib_debug"}, k = 2, mv = {1, 1, 15})
/* compiled from: CalendarUtils.kt */
public final class CalendarUtilsKt {
    public static final int convertToDefaultColor(Context context, int colorRes) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return ContextCompat.getColor(context, colorRes);
    }
}
