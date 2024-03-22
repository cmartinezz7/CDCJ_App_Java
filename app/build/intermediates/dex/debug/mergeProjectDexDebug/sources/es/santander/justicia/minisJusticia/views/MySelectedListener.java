package es.santander.justicia.minisJusticia.views;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016JN\u0010\u0012\u001a\u00020\t2,\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00042\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t0\u000bR6\u0010\u0003\u001a*\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Les/santander/justicia/minisJusticia/views/MySelectedListener;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "()V", "onItemSelectedLambda", "Lkotlin/Function4;", "Landroid/widget/AdapterView;", "Landroid/view/View;", "", "", "", "onNothingSelectedLambda", "Lkotlin/Function1;", "onItemSelected", "parent", "view", "position", "id", "onNothingSelected", "setLambdaFunctions", "app_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: QSpinner.kt */
final class MySelectedListener implements AdapterView.OnItemSelectedListener {
    private Function4<? super AdapterView<?>, ? super View, ? super Integer, ? super Long, Unit> onItemSelectedLambda;
    private Function1<? super AdapterView<?>, Unit> onNothingSelectedLambda;

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Function4<? super AdapterView<?>, ? super View, ? super Integer, ? super Long, Unit> function4 = this.onItemSelectedLambda;
        if (function4 != null) {
            function4.invoke(parent, view, Integer.valueOf(position), Long.valueOf(id));
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
        Function1<? super AdapterView<?>, Unit> function1 = this.onNothingSelectedLambda;
        if (function1 != null) {
            function1.invoke(parent);
        }
    }

    public final void setLambdaFunctions(Function4<? super AdapterView<?>, ? super View, ? super Integer, ? super Long, Unit> onItemSelectedLambda2, Function1<? super AdapterView<?>, Unit> onNothingSelectedLambda2) {
        Intrinsics.checkNotNullParameter(onItemSelectedLambda2, "onItemSelectedLambda");
        Intrinsics.checkNotNullParameter(onNothingSelectedLambda2, "onNothingSelectedLambda");
        this.onItemSelectedLambda = onItemSelectedLambda2;
        this.onNothingSelectedLambda = onNothingSelectedLambda2;
    }
}
