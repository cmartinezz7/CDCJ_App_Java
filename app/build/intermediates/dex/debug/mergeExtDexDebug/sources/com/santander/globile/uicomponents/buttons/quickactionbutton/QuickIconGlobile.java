package com.santander.globile.uicomponents.buttons.quickactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.widget.ImageViewCompat;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.image.icon.IconGlobile;
import com.santander.globile.uicomponents.image.icon.IconSize;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/quickactionbutton/QuickIconGlobile;", "Lcom/santander/globile/uicomponents/image/icon/IconGlobile;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setDisabledIcon", "", "icon", "iconColor", "Lcom/santander/globile/uicomponents/buttons/quickactionbutton/IconColorDisabled;", "size", "Lcom/santander/globile/uicomponents/image/icon/IconSize;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: QuickIconGlobile.kt */
public final class QuickIconGlobile extends IconGlobile {
    private HashMap _$_findViewCache;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[IconColorDisabled.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[IconColorDisabled.DISABLED.ordinal()] = 1;
            int[] iArr2 = new int[IconSize.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[IconSize.SMALL.ordinal()] = 1;
            iArr2[IconSize.MEDIUM.ordinal()] = 2;
            iArr2[IconSize.BIG.ordinal()] = 3;
        }
    }

    public QuickIconGlobile(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public QuickIconGlobile(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.santander.globile.uicomponents.buttons.quickactionbutton.QuickIconGlobile, android.view.View] */
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
    public QuickIconGlobile(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuickIconGlobile(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setDisabledIcon(int icon, IconColorDisabled iconColor, IconSize size) {
        int color;
        int dimensionInDp;
        Intrinsics.checkParameterIsNotNull(iconColor, "iconColor");
        Intrinsics.checkParameterIsNotNull(size, "size");
        if (WhenMappings.$EnumSwitchMapping$0[iconColor.ordinal()] == 1) {
            if (Build.VERSION.SDK_INT >= 23) {
                color = getResources().getColor(R.color.icon_disabled_quickActionButton, (Resources.Theme) null);
            } else {
                color = getResources().getColor(R.color.icon_disabled_quickActionButton);
            }
            ((ImageView) _$_findCachedViewById(R.id.icon_image)).setImageResource(icon);
            ImageViewCompat.setImageTintList((ImageView) _$_findCachedViewById(R.id.icon_image), ColorStateList.valueOf(color));
            int i = WhenMappings.$EnumSwitchMapping$1[size.ordinal()];
            if (i == 1) {
                dimensionInDp = (int) getResources().getDimension(R.dimen.icon_size_small);
            } else if (i == 2) {
                dimensionInDp = (int) getResources().getDimension(R.dimen.icon_size_medium);
            } else if (i == 3) {
                dimensionInDp = (int) getResources().getDimension(R.dimen.icon_size_big);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.icon_image);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "icon_image");
            imageView.getLayoutParams().height = dimensionInDp;
            ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.icon_image);
            Intrinsics.checkExpressionValueIsNotNull(imageView2, "icon_image");
            imageView2.getLayoutParams().width = dimensionInDp;
            ((ImageView) _$_findCachedViewById(R.id.icon_image)).requestLayout();
            return;
        }
        throw new NoWhenBranchMatchedException();
    }
}
