package net.opacapp.multilinecollapsingtoolbar;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

class ViewGroupUtilsHoneycomb {
    private static final Matrix IDENTITY = new Matrix();
    private static final ThreadLocal<Matrix> sMatrix = new ThreadLocal<>();
    private static final ThreadLocal<RectF> sRectF = new ThreadLocal<>();

    ViewGroupUtilsHoneycomb() {
    }

    public static void offsetDescendantRect(ViewGroup group, View child, Rect rect) {
        ThreadLocal<Matrix> threadLocal = sMatrix;
        Matrix m = threadLocal.get();
        if (m == null) {
            m = new Matrix();
            threadLocal.set(m);
        } else {
            m.set(IDENTITY);
        }
        offsetDescendantMatrix(group, child, m);
        RectF rectF = sRectF.get();
        if (rectF == null) {
            rectF = new RectF();
        }
        rectF.set(rect);
        m.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    static void offsetDescendantMatrix(ViewParent target, View view, Matrix m) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != target) {
            View vp = (View) parent;
            offsetDescendantMatrix(target, vp, m);
            m.preTranslate((float) (-vp.getScrollX()), (float) (-vp.getScrollY()));
        }
        m.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            m.preConcat(view.getMatrix());
        }
    }
}
