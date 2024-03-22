package com.santander.globile.uicomponents.buttons.togglebutton;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.utils.IntExtensionsKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002¨\u0006\u000e"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/togglebutton/GlobileToggleButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "changeBackground", "", "drawable", "setGravity", "setViews", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileToggleButton.kt */
public final class GlobileToggleButton extends AppCompatButton {
    private HashMap _$_findViewCache;

    public GlobileToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.view.View, com.santander.globile.uicomponents.buttons.togglebutton.GlobileToggleButton] */
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
    public GlobileToggleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setViews();
        setGravity();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileToggleButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setViews() {
        setBackgroundResource(R.drawable.toggle_button);
        setPadding(IntExtensionsKt.getToDP(12), IntExtensionsKt.getToDP(8), IntExtensionsKt.getToDP(12), IntExtensionsKt.getToDP(8));
        if (Build.VERSION.SDK_INT < 23) {
            setTextAppearance(getContext(), R.style.GlobileToggleButtonStyleTextAppearance);
        } else {
            setTextAppearance(R.style.GlobileToggleButtonStyleTextAppearance);
        }
    }

    private final void setGravity() {
        setGravity(17);
    }

    public final void changeBackground(int drawable) {
        setBackgroundResource(drawable);
    }
}
