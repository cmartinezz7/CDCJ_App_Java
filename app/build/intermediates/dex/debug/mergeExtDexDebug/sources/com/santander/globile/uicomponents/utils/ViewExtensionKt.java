package com.santander.globile.uicomponents.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"enable", "", "Landroid/view/View;", "", "uicomponentslib_debug"}, k = 2, mv = {1, 1, 15})
/* compiled from: ViewExtension.kt */
public final class ViewExtensionKt {
    public static final void enable(View $this$enable, boolean enable) {
        int i;
        Intrinsics.checkParameterIsNotNull($this$enable, "$this$enable");
        if (!enable) {
            i = 8;
        } else {
            i = 0;
        }
        $this$enable.setVisibility(i);
    }
}
