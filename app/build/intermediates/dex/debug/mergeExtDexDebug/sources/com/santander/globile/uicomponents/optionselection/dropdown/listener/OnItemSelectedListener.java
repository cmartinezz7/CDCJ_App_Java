package com.santander.globile.uicomponents.optionselection.dropdown.listener;

import com.santander.globile.uicomponents.optionselection.dropdown.data.DropDownData;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H&J\b\u0010\u0007\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lcom/santander/globile/uicomponents/optionselection/dropdown/listener/OnItemSelectedListener;", "T", "", "onItemSelected", "", "item", "Lcom/santander/globile/uicomponents/optionselection/dropdown/data/DropDownData;", "onNothingSelected", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: OnItemSelectedListener.kt */
public interface OnItemSelectedListener<T> {
    void onItemSelected(DropDownData<T> dropDownData);

    void onNothingSelected();
}
