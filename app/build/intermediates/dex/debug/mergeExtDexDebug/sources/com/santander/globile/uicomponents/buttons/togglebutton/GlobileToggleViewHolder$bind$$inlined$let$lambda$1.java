package com.santander.globile.uicomponents.buttons.togglebutton;

import android.view.View;
import com.santander.globile.uicomponents.buttons.togglebutton.data.GlobileToggleButtonData;
import com.santander.globile.uicomponents.list.common.listener.GlobileListListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/santander/globile/uicomponents/buttons/togglebutton/GlobileToggleViewHolder$bind$1$1"}, k = 3, mv = {1, 1, 15})
/* compiled from: GlobileToggleViewHolder.kt */
final class GlobileToggleViewHolder$bind$$inlined$let$lambda$1 implements View.OnClickListener {
    final /* synthetic */ GlobileToggleButtonData $data$inlined;
    final /* synthetic */ GlobileListListener $listener$inlined;
    final /* synthetic */ View $view;

    GlobileToggleViewHolder$bind$$inlined$let$lambda$1(View view, GlobileToggleButtonData globileToggleButtonData, GlobileListListener globileListListener) {
        this.$view = view;
        this.$data$inlined = globileToggleButtonData;
        this.$listener$inlined = globileListListener;
    }

    public final void onClick(View it) {
        GlobileListListener globileListListener = this.$listener$inlined;
        if (globileListListener != null) {
            GlobileToggleButtonData globileToggleButtonData = this.$data$inlined;
            View view = this.$view;
            Intrinsics.checkExpressionValueIsNotNull(view, "view");
            globileListListener.onClickListener(globileToggleButtonData, view, 0);
        }
        this.$data$inlined.setSelect(true);
    }
}
