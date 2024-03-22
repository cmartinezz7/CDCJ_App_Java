package com.santander.globile.uicomponents.utils;

import android.view.animation.Animation;
import com.santander.globile.uicomponents.common.__AnimationListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\b¨\u0006\u0007"}, d2 = {"setAnimationListener", "", "Landroid/view/animation/Animation;", "func", "Lkotlin/Function1;", "Lcom/santander/globile/uicomponents/common/__AnimationListener;", "Lkotlin/ExtensionFunctionType;", "uicomponentslib_debug"}, k = 2, mv = {1, 1, 15})
/* compiled from: AnimationExtension.kt */
public final class AnimationExtensionKt {
    public static final void setAnimationListener(Animation $this$setAnimationListener, Function1<? super __AnimationListener, Unit> func) {
        Intrinsics.checkParameterIsNotNull($this$setAnimationListener, "$this$setAnimationListener");
        Intrinsics.checkParameterIsNotNull(func, "func");
        __AnimationListener listener = new __AnimationListener();
        func.invoke(listener);
        $this$setAnimationListener.setAnimationListener(listener);
    }
}
