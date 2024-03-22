package com.santander.globile.uicomponents.utils;

import android.graphics.PorterDuff;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"tintDrawable", "", "Landroid/widget/ImageView;", "color", "", "uicomponentslib_debug"}, k = 2, mv = {1, 1, 15})
/* compiled from: ImageViewExtension.kt */
public final class ImageViewExtensionKt {
    public static final void tintDrawable(ImageView $this$tintDrawable, int color) {
        Intrinsics.checkParameterIsNotNull($this$tintDrawable, "$this$tintDrawable");
        $this$tintDrawable.setColorFilter(ContextCompat.getColor($this$tintDrawable.getContext(), color), PorterDuff.Mode.SRC_IN);
    }
}
