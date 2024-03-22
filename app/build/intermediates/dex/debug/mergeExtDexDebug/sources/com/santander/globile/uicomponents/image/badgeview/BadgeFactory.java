package com.santander.globile.uicomponents.image.badgeview;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Lcom/santander/globile/uicomponents/image/badgeview/BadgeFactory;", "", "()V", "create", "Lcom/santander/globile/uicomponents/image/badgeview/GlobileBadgeNumber;", "context", "Landroid/content/Context;", "createCircle", "createDot", "createOval", "createRectangle", "createRoundRect", "createSquare", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: BadgeFactory.kt */
public final class BadgeFactory {
    public static final BadgeFactory INSTANCE = new BadgeFactory();

    private BadgeFactory() {
    }

    public final GlobileBadgeNumber createDot(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new GlobileBadgeNumber(context).setWidthAndHeight(10, 10).setTextSize(0).setBadgeGravity(53).setShape(1);
    }

    public final GlobileBadgeNumber createCircle(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new GlobileBadgeNumber(context).setWidthAndHeight(20, 20).setTextSize(12).setBadgeGravity(53).setShape(1);
    }

    public final GlobileBadgeNumber createRectangle(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new GlobileBadgeNumber(context).setWidthAndHeight(25, 20).setTextSize(12).setBadgeGravity(53).setShape(2);
    }

    public final GlobileBadgeNumber createOval(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new GlobileBadgeNumber(context).setWidthAndHeight(25, 20).setTextSize(12).setBadgeGravity(53).setShape(3);
    }

    public final GlobileBadgeNumber createSquare(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new GlobileBadgeNumber(context).setWidthAndHeight(20, 20).setTextSize(12).setBadgeGravity(53).setShape(5);
    }

    public final GlobileBadgeNumber createRoundRect(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new GlobileBadgeNumber(context).setWidthAndHeight(25, 20).setTextSize(12).setBadgeGravity(53).setShape(4);
    }

    public final GlobileBadgeNumber create(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new GlobileBadgeNumber(context);
    }
}
