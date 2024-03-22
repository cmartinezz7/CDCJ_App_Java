package com.santander.globile.uicomponents.pagecontroller;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.santander.globile.uicomponents.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 15})
/* compiled from: GlobilePageController.kt */
final class GlobilePageController$bind$2 implements View.OnClickListener {
    final /* synthetic */ GlobilePageController this$0;

    GlobilePageController$bind$2(GlobilePageController globilePageController) {
        this.this$0 = globilePageController;
    }

    public final void onClick(View it) {
        ViewPager it2;
        if (!this.this$0.isLastPage() && (it2 = this.this$0.getMViewPager()) != null) {
            int nextPage = it2.getCurrentItem() + 1;
            it2.setCurrentItem(nextPage, true);
            GlobilePageController globilePageController = this.this$0;
            String string = globilePageController.getResources().getString(R.string.current_page_description, new Object[]{Integer.valueOf(nextPage + 1)});
            Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(\n   …            nextPage + 1)");
            globilePageController.readMessageToAccessibility(string);
        }
    }
}
