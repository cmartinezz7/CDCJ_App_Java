package es.santander.justicia.minisJusticia.views;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: QSpinner.kt */
/* synthetic */ class QSpinner$setOnItemSelectedListener$1$1 extends FunctionReferenceImpl implements Function4<AdapterView<?>, View, Integer, Long, Unit> {
    QSpinner$setOnItemSelectedListener$1$1(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super(4, onItemSelectedListener, AdapterView.OnItemSelectedListener.class, "onItemSelected", "onItemSelected(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
        invoke((AdapterView<?>) (AdapterView) p1, (View) p2, ((Number) p3).intValue(), ((Number) p4).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AdapterView<?> p0, View p1, int p2, long p3) {
        ((AdapterView.OnItemSelectedListener) this.receiver).onItemSelected(p0, p1, p2, p3);
    }
}
