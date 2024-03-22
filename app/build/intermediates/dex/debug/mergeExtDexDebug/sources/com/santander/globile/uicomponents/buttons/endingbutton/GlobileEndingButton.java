package com.santander.globile.uicomponents.buttons.endingbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.utils.IntExtensionsKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/endingbutton/GlobileEndingButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonType", "getButtonType", "()I", "setButtonType", "(I)V", "setDisabledButton", "", "setEnabled", "enabled", "", "setGravity", "setPrimaryButton", "setSecondaryButton", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileEndingButton.kt */
public final class GlobileEndingButton extends AppCompatButton {
    private HashMap _$_findViewCache;
    private int buttonType;

    public GlobileEndingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.view.View, com.santander.globile.uicomponents.buttons.endingbutton.GlobileEndingButton] */
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileEndingButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.GlobileEndingButton);
        int buttonType2 = typedArray.getInt(R.styleable.GlobileEndingButton_buttonType, 0);
        if (buttonType2 == 1) {
            this.buttonType = 1;
            setPrimaryButton();
        } else if (buttonType2 == 2) {
            this.buttonType = 2;
            setSecondaryButton();
        }
        typedArray.recycle();
        if (!isEnabled()) {
            setDisabledButton();
        }
        setPadding(IntExtensionsKt.getToDP(12), IntExtensionsKt.getToDP(8), IntExtensionsKt.getToDP(12), IntExtensionsKt.getToDP(8));
        setMinHeight(IntExtensionsKt.getToDP(32));
        setCompoundDrawablePadding(IntExtensionsKt.getToDP(15));
        setGravity();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileEndingButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getButtonType() {
        return this.buttonType;
    }

    public final void setButtonType(int i) {
        this.buttonType = i;
    }

    private final void setPrimaryButton() {
        if (Build.VERSION.SDK_INT < 23) {
            setTextAppearance(getContext(), R.style.GlobileEndingButtonPrimaryStyleTextAppearance);
        } else {
            setTextAppearance(R.style.GlobileEndingButtonPrimaryStyleTextAppearance);
        }
        setBackgroundResource(R.drawable.ending_button_primary);
    }

    private final void setSecondaryButton() {
        if (Build.VERSION.SDK_INT < 23) {
            setTextAppearance(getContext(), R.style.GlobileEndingButtonSecondaryStyleTextAppearance);
        } else {
            setTextAppearance(R.style.GlobileEndingButtonSecondaryStyleTextAppearance);
        }
        setBackgroundResource(R.drawable.ending_button_secondary);
    }

    private final void setDisabledButton() {
        if (this.buttonType == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            setTextAppearance(getContext(), R.style.GlobileEndingButtonDisabledStyleTextAppearance);
        } else {
            setTextAppearance(R.style.GlobileEndingButtonDisabledStyleTextAppearance);
        }
    }

    public void setEnabled(boolean enabled) {
        GlobileEndingButton.super.setEnabled(enabled);
        Log.d("Carlos", "He pulsado en setEnable " + enabled);
        if (enabled) {
            int i = this.buttonType;
            if (i == 1) {
                setPrimaryButton();
            } else if (i == 2) {
                setSecondaryButton();
            }
        } else {
            setDisabledButton();
        }
    }

    private final void setGravity() {
        setGravity(17);
    }
}
