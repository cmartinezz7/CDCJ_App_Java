package com.santander.globile.uicomponents.list.simple.viewholder;

import android.view.View;
import com.santander.globile.uicomponents.list.common.listener.GlobileListListener;
import com.santander.globile.uicomponents.list.simple.data.SimpleData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/santander/globile/uicomponents/list/simple/viewholder/GlobileSimpleViewHolder$bind$1$1"}, k = 3, mv = {1, 1, 15})
/* compiled from: GlobileSimpleViewHolder.kt */
final class GlobileSimpleViewHolder$bind$$inlined$let$lambda$1 implements View.OnClickListener {
    final /* synthetic */ SimpleData $data$inlined;
    final /* synthetic */ GlobileListListener $listener$inlined;
    final /* synthetic */ View $view;

    GlobileSimpleViewHolder$bind$$inlined$let$lambda$1(View view, SimpleData simpleData, GlobileListListener globileListListener) {
        this.$view = view;
        this.$data$inlined = simpleData;
        this.$listener$inlined = globileListListener;
    }

    public final void onClick(View it) {
        GlobileListListener globileListListener = this.$listener$inlined;
        if (globileListListener != null) {
            SimpleData simpleData = this.$data$inlined;
            View view = this.$view;
            Intrinsics.checkExpressionValueIsNotNull(view, "view");
            globileListListener.onClickListener(simpleData, view, 0);
        }
    }
}
