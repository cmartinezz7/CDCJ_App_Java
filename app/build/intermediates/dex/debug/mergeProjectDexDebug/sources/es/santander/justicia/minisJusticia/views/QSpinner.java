package es.santander.justicia.minisJusticia.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatSpinner;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Les/santander/justicia/minisJusticia/views/QSpinner;", "Landroidx/appcompat/widget/AppCompatSpinner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedListener", "Les/santander/justicia/minisJusticia/views/MySelectedListener;", "initSpinner", "", "setOnItemSelectedListener", "listener", "Landroid/widget/AdapterView$OnItemSelectedListener;", "app_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: QSpinner.kt */
public final class QSpinner extends AppCompatSpinner {
    private final MySelectedListener selectedListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QSpinner(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QSpinner(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.selectedListener = new MySelectedListener();
    }

    public final void initSpinner() {
        setOnItemSelectedListener(this.selectedListener);
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener listener) {
        if (listener != null) {
            AdapterView.OnItemSelectedListener it = listener;
            this.selectedListener.setLambdaFunctions(new QSpinner$setOnItemSelectedListener$1$1(it), new QSpinner$setOnItemSelectedListener$1$2(it));
        }
    }
}
