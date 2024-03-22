package com.santander.globile.uicomponents.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.databinding.InverseBindingListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/santander/globile/uicomponents/textfield/GlobileTextFieldBinder$setListener$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "charSequence", "", "i", "", "i1", "i2", "onTextChanged", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileTextFieldBinder.kt */
public final class GlobileTextFieldBinder$setListener$1 implements TextWatcher {
    final /* synthetic */ InverseBindingListener $listener;

    GlobileTextFieldBinder$setListener$1(InverseBindingListener $captured_local_variable$0) {
        this.$listener = $captured_local_variable$0;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "charSequence");
    }

    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        Intrinsics.checkParameterIsNotNull(charSequence, "charSequence");
    }

    public void afterTextChanged(Editable editable) {
        Intrinsics.checkParameterIsNotNull(editable, "editable");
        this.$listener.onChange();
    }
}
