package com.santander.globile.uicomponents.buttons.tertiarybutton;

import android.view.View;
import android.widget.TextView;
import com.santander.globile.uicomponents.R;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 15})
/* compiled from: GlobileTertiaryButton.kt */
final class GlobileTertiaryButton$setLinkOnClickListener$1 implements View.OnClickListener {
    final /* synthetic */ View.OnClickListener $listener;
    final /* synthetic */ GlobileTertiaryButton this$0;

    GlobileTertiaryButton$setLinkOnClickListener$1(GlobileTertiaryButton globileTertiaryButton, View.OnClickListener onClickListener) {
        this.this$0 = globileTertiaryButton;
        this.$listener = onClickListener;
    }

    public final void onClick(View it) {
        this.$listener.onClick((TextView) this.this$0._$_findCachedViewById(R.id.tertiary_button_textview));
    }
}
