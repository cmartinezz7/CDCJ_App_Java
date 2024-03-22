package com.santander.globile.uicomponents.alertbar;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.androidadvance.topsnackbar.TSnackbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p0", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 1, 15})
/* compiled from: GlobileAlertBar.kt */
final class GlobileAlertBarKt$setSnackBarView$1 implements View.OnTouchListener {
    final /* synthetic */ GlobileAlertBarListener $alertBarListener;
    final /* synthetic */ int $iconPadding;
    final /* synthetic */ TSnackbar $snackbar;
    final /* synthetic */ TextView $textView;

    GlobileAlertBarKt$setSnackBarView$1(TextView textView, int i, GlobileAlertBarListener globileAlertBarListener, TSnackbar tSnackbar) {
        this.$textView = textView;
        this.$iconPadding = i;
        this.$alertBarListener = globileAlertBarListener;
        this.$snackbar = tSnackbar;
    }

    public final boolean onTouch(View p0, MotionEvent event) {
        if (event != null && event.getAction() == 0) {
            float rawX = event.getRawX();
            int left = this.$textView.getLeft();
            Drawable drawable = this.$textView.getCompoundDrawables()[0];
            Intrinsics.checkExpressionValueIsNotNull(drawable, "textView.compoundDrawables[0]");
            if (rawX <= ((float) (left + drawable.getBounds().width() + this.$iconPadding))) {
                this.$alertBarListener.onDismissPressed();
                this.$snackbar.dismiss();
                return true;
            }
        }
        return false;
    }
}
