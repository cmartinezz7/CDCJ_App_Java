package com.santander.globile.uicomponents.textfield;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import com.santander.globile.uicomponents.edittext.SantanderAppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\n\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\r"}, d2 = {"Lcom/santander/globile/uicomponents/textfield/GlobileTextFieldBinder;", "", "()V", "getDataText", "", "globalInput", "Lcom/santander/globile/uicomponents/textfield/GlobileTextField;", "setDataText", "", "value", "setListener", "listener", "Landroidx/databinding/InverseBindingListener;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileTextFieldBinder.kt */
public final class GlobileTextFieldBinder {
    public static final GlobileTextFieldBinder INSTANCE = new GlobileTextFieldBinder();

    private GlobileTextFieldBinder() {
    }

    @JvmStatic
    @BindingAdapter({"textAttrChanged"})
    public static final void setListener(GlobileTextField globalInput, InverseBindingListener listener) {
        SantanderAppCompatEditText globileEditTextView;
        if (listener != null && globalInput != null && (globileEditTextView = globalInput.getGlobileEditTextView()) != null) {
            globileEditTextView.addTextChangedListener(new GlobileTextFieldBinder$setListener$1(listener));
        }
    }

    @JvmStatic
    @BindingAdapter({"text"})
    public static final void setDataText(GlobileTextField globalInput, String value) {
        if ((!Intrinsics.areEqual((Object) globalInput != null ? globalInput.getText() : null, (Object) value)) && globalInput != null) {
            globalInput.setText(value);
        }
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "text")
    public static final String getDataText(GlobileTextField globalInput) {
        return String.valueOf(globalInput != null ? globalInput.getText() : null);
    }
}
