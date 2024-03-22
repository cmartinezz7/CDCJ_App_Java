package es.santander.justicia.minisJusticia.views;

import android.widget.AdapterView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: QSpinner.kt */
/* synthetic */ class QSpinner$setOnItemSelectedListener$1$2 extends FunctionReferenceImpl implements Function1<AdapterView<?>, Unit> {
    QSpinner$setOnItemSelectedListener$1$2(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super(1, onItemSelectedListener, AdapterView.OnItemSelectedListener.class, "onNothingSelected", "onNothingSelected(Landroid/widget/AdapterView;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((AdapterView<?>) (AdapterView) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(AdapterView<?> p0) {
        ((AdapterView.OnItemSelectedListener) this.receiver).onNothingSelected(p0);
    }
}
