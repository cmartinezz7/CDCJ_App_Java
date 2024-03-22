package com.santander.globile.uicomponents.list.common.decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/santander/globile/uicomponents/list/common/decoration/GlobileSeparationDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "color", "", "heightDp", "", "(Landroid/content/Context;IF)V", "mPaint", "Landroid/graphics/Paint;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileSeparationDecorator.kt */
public final class GlobileSeparationDecorator extends RecyclerView.ItemDecoration {
    private final Paint mPaint;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r1 = r4.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GlobileSeparationDecorator(android.content.Context r4, int r5, float r6) {
        /*
            r3 = this;
            r3.<init>()
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r3.mPaint = r0
            r0.setColor(r5)
            if (r4 == 0) goto L_0x001d
            android.content.res.Resources r1 = r4.getResources()
            if (r1 == 0) goto L_0x001d
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            goto L_0x001e
        L_0x001d:
            r1 = 0
        L_0x001e:
            r2 = 1
            float r1 = android.util.TypedValue.applyDimension(r2, r6, r1)
            r0.setStrokeWidth(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.santander.globile.uicomponents.list.common.decoration.GlobileSeparationDecorator.<init>(android.content.Context, int, float):void");
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkParameterIsNotNull(outRect, "outRect");
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        Intrinsics.checkParameterIsNotNull(state, "state");
        RecyclerView.LayoutParams params = view.getLayoutParams();
        if (params == null) {
            throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        } else if (params.getViewAdapterPosition() < state.getItemCount()) {
            outRect.set(0, 0, 0, (int) this.mPaint.getStrokeWidth());
        } else {
            outRect.setEmpty();
        }
    }

    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        RecyclerView recyclerView = parent;
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(recyclerView, "parent");
        Intrinsics.checkParameterIsNotNull(state, "state");
        int offset = ((int) this.mPaint.getStrokeWidth()) / 2;
        int childCount = parent.getChildCount();
        int i = 0;
        while (i < childCount) {
            int i2 = i;
            View view = recyclerView.getChildAt(i2);
            Intrinsics.checkExpressionValueIsNotNull(view, "view");
            RecyclerView.LayoutParams params = view.getLayoutParams();
            if (params != null) {
                if (params.getViewAdapterPosition() < state.getItemCount()) {
                    c.drawLine((float) view.getLeft(), (float) (view.getBottom() + offset), (float) view.getRight(), (float) (view.getBottom() + offset), this.mPaint);
                }
                i = i2 + 1;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
        }
    }
}
