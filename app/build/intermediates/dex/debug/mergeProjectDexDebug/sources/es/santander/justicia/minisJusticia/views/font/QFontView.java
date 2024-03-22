package es.santander.justicia.minisJusticia.views.font;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.views.TypeFaceCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\fH\u0016¨\u0006\u000e"}, d2 = {"Les/santander/justicia/minisJusticia/views/font/QFontView;", "Les/santander/justicia/minisJusticia/views/font/QFont;", "()V", "initFont", "", "attrs", "Landroid/util/AttributeSet;", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "setTypeFaceLambda", "Lkotlin/Function1;", "Landroid/graphics/Typeface;", "app_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: QFontView.kt */
public final class QFontView implements QFont {
    public void initFont(AttributeSet attrs, Context context, View view, Function1<? super Typeface, Unit> setTypeFaceLambda) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(setTypeFaceLambda, "setTypeFaceLambda");
        if (!view.isInEditMode()) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.QFontView);
            Intrinsics.checkNotNullExpressionValue(ta, "context.obtainStyledAttributes(attrs, R.styleable.QFontView)");
            Font font = Font.Companion.getFromId(ta.getInt(0, 0));
            Typeface tf = TypeFaceCache.instance.getTypeFace(font == null ? null : font.getPath(), context);
            Intrinsics.checkNotNullExpressionValue(tf, "tf");
            setTypeFaceLambda.invoke(tf);
            ta.recycle();
        }
    }
}
