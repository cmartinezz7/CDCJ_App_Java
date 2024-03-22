package com.santander.globile.uicomponents.errorhandling.dialog;

import android.view.View;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.errorhandling.dialog.GlobileErrorHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 15})
/* compiled from: GlobileErrorHandler.kt */
final class GlobileErrorHandler$showButton$1 implements View.OnClickListener {
    final /* synthetic */ int $code;
    final /* synthetic */ GlobileErrorHandler.OnClickListener $listener;
    final /* synthetic */ String $text;
    final /* synthetic */ GlobileErrorHandler this$0;

    GlobileErrorHandler$showButton$1(GlobileErrorHandler globileErrorHandler, GlobileErrorHandler.OnClickListener onClickListener, int i, String str) {
        this.this$0 = globileErrorHandler;
        this.$listener = onClickListener;
        this.$code = i;
        this.$text = str;
    }

    public final void onClick(View it) {
        this.this$0.dismiss();
        GlobileErrorHandler.OnClickListener onClickListener = this.$listener;
        if (onClickListener != null) {
            onClickListener.onButtonClick(this.$code, this.this$0);
        }
        GlobileErrorHandler globileErrorHandler = this.this$0;
        String string = globileErrorHandler.getString(R.string.ok_pressed_content_description, new Object[]{this.$text});
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string\n     …ontent_description, text)");
        globileErrorHandler.readMessageToAccessibility(string);
    }
}
