package com.santander.globile.uicomponents.optionselection.dropdown;

import android.view.View;
import android.widget.AdapterView;
import com.santander.globile.uicomponents.optionselection.dropdown.data.DropDownData;
import com.santander.globile.uicomponents.optionselection.dropdown.listener.OnItemSelectedListener;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\r"}, d2 = {"com/santander/globile/uicomponents/optionselection/dropdown/GlobileDropdown$setGlobileDropdown$onItemSelectedListener$1", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "p0", "Landroid/widget/AdapterView;", "p1", "Landroid/view/View;", "p2", "", "p3", "", "onNothingSelected", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileDropdown.kt */
public final class GlobileDropdown$setGlobileDropdown$onItemSelectedListener$1 implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ int $initialSelectedValue;
    final /* synthetic */ List $itemsList;
    final /* synthetic */ List $list;
    final /* synthetic */ OnItemSelectedListener $selectListener;
    final /* synthetic */ GlobileDropdown this$0;

    GlobileDropdown$setGlobileDropdown$onItemSelectedListener$1(GlobileDropdown $outer, int $captured_local_variable$1, List $captured_local_variable$2, OnItemSelectedListener $captured_local_variable$3, List $captured_local_variable$4) {
        this.this$0 = $outer;
        this.$initialSelectedValue = $captured_local_variable$1;
        this.$itemsList = $captured_local_variable$2;
        this.$selectListener = $captured_local_variable$3;
        this.$list = $captured_local_variable$4;
    }

    public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        this.this$0.hideError();
        if (!this.this$0.loading || this.$initialSelectedValue > -1) {
            int selected = p2 + 1;
            GlobileDropdown.access$getMSpinnerAdapter$p(this.this$0).setSelected(selected);
            if (p2 <= this.$itemsList.size()) {
                this.$selectListener.onItemSelected((DropDownData) this.$list.get(selected));
            }
        }
        this.this$0.loading = false;
    }

    public void onNothingSelected(AdapterView<?> p0) {
        this.$selectListener.onNothingSelected();
    }
}
