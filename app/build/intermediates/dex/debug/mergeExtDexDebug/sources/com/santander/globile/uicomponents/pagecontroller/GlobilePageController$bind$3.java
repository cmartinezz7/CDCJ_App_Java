package com.santander.globile.uicomponents.pagecontroller;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/santander/globile/uicomponents/pagecontroller/GlobilePageController$bind$3", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobilePageController.kt */
public final class GlobilePageController$bind$3 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GlobilePageController this$0;

    GlobilePageController$bind$3(GlobilePageController $outer) {
        this.this$0 = $outer;
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        this.this$0.handleVisibility();
    }

    public void onPageScrollStateChanged(int state) {
    }
}
