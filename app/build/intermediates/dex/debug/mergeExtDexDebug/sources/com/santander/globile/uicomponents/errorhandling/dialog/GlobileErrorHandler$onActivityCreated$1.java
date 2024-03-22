package com.santander.globile.uicomponents.errorhandling.dialog;

import android.view.View;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.errorhandling.dialog.GlobileErrorHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 15})
/* compiled from: GlobileErrorHandler.kt */
final class GlobileErrorHandler$onActivityCreated$1 implements View.OnClickListener {
    final /* synthetic */ GlobileErrorHandler this$0;

    GlobileErrorHandler$onActivityCreated$1(GlobileErrorHandler globileErrorHandler) {
        this.this$0 = globileErrorHandler;
    }

    public final void onClick(View it) {
        this.this$0.dismiss();
        GlobileErrorHandler.OnDismissListener access$get_onDismissListener$p = this.this$0._onDismissListener;
        if (access$get_onDismissListener$p != null) {
            access$get_onDismissListener$p.onDismiss(this.this$0);
        }
        GlobileErrorHandler globileErrorHandler = this.this$0;
        String string = globileErrorHandler.getString(R.string.dialog_dismiss_content_description);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(\n             …miss_content_description)");
        globileErrorHandler.readMessageToAccessibility(string);
    }
}
