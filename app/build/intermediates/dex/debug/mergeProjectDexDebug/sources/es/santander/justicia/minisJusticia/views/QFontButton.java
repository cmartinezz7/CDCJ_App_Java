package es.santander.justicia.minisJusticia.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import es.santander.justicia.minisJusticia.views.font.QFont;
import es.santander.justicia.minisJusticia.views.font.QFontView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ7\u0010\n\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000fH\u0001¨\u0006\u0011"}, d2 = {"Les/santander/justicia/minisJusticia/views/QFontButton;", "Landroidx/appcompat/widget/AppCompatButton;", "Les/santander/justicia/minisJusticia/views/font/QFont;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initFont", "", "view", "Landroid/view/View;", "setTypeFaceLambda", "Lkotlin/Function1;", "Landroid/graphics/Typeface;", "app_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: QFontButton.kt */
public final class QFontButton extends AppCompatButton implements QFont {
    private final /* synthetic */ QFontView $$delegate_0;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QFontButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QFontButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void initFont(AttributeSet attributeSet, Context context, View view, Function1<? super Typeface, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function1, "setTypeFaceLambda");
        this.$$delegate_0.initFont(attributeSet, context, view, function1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QFontButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QFontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.$$delegate_0 = new QFontView();
        initFont(attrs, context, (View) this, new Function1<Typeface, Unit>(this) {
            {
                Class<QFontButton> cls = QFontButton.class;
                QFontButton qFontButton = r8;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Typeface) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Typeface p0) {
                ((QFontButton) this.receiver).setTypeface(p0);
            }
        });
    }
}
