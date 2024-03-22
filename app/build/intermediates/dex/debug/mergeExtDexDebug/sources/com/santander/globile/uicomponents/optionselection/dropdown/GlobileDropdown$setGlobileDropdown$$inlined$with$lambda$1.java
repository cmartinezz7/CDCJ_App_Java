package com.santander.globile.uicomponents.optionselection.dropdown;

import com.santander.globile.uicomponents.optionselection.dropdown.spinner.GlobileSpinner;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005¸\u0006\u0000"}, d2 = {"com/santander/globile/uicomponents/optionselection/dropdown/GlobileDropdown$setGlobileDropdown$3$1", "Lcom/santander/globile/uicomponents/optionselection/dropdown/spinner/GlobileSpinner$OnSpinnerEventsListener;", "onSpinnerClosed", "", "onSpinnerOpened", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileDropdown.kt */
public final class GlobileDropdown$setGlobileDropdown$$inlined$with$lambda$1 implements GlobileSpinner.OnSpinnerEventsListener {
    final /* synthetic */ int $initialSelectedValue$inlined;
    final /* synthetic */ List $itemsList$inlined;
    final /* synthetic */ GlobileDropdown$setGlobileDropdown$onItemSelectedListener$1 $onItemSelectedListener$inlined;
    final /* synthetic */ GlobileDropdown this$0;

    GlobileDropdown$setGlobileDropdown$$inlined$with$lambda$1(GlobileDropdown globileDropdown, GlobileDropdown$setGlobileDropdown$onItemSelectedListener$1 globileDropdown$setGlobileDropdown$onItemSelectedListener$1, List list, int i) {
        this.this$0 = globileDropdown;
        this.$onItemSelectedListener$inlined = globileDropdown$setGlobileDropdown$onItemSelectedListener$1;
        this.$itemsList$inlined = list;
        this.$initialSelectedValue$inlined = i;
    }

    public void onSpinnerOpened() {
        this.this$0.rotateArrow(0.0f, 180.0f);
    }

    public void onSpinnerClosed() {
        this.this$0.rotateArrow(180.0f, 360.0f);
    }
}
