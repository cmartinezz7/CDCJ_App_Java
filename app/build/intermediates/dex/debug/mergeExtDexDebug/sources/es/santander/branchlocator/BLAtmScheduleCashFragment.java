package es.santander.branchlocator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Les/santander/branchlocator/BLAtmScheduleCashFragment;", "Les/santander/branchlocator/BLBaseInfoFragment;", "()V", "atm", "Les/santander/branchlocator/BLPoi;", "scheduleCashList", "", "", "tvScheduleCash", "Les/santander/branchlocator/BLTextView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setData", "setupBillPayments", "setupUi", "showSchedule", "BranchLocatorComponent_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: BLAtmScheduleCashFragment.kt */
public final class BLAtmScheduleCashFragment extends BLBaseInfoFragment {
    private HashMap _$_findViewCache;
    private BLPoi atm;
    private List<String> scheduleCashList = new ArrayList();
    private BLTextView tvScheduleCash;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.atm_schedule_cash_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupUi(view);
        if (getParentFragment() instanceof BLAtmDetailedInformationFragment) {
            BLAtmDetailedInformationFragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                BLPoi atm2 = parentFragment.getAtm();
                this.atm = atm2;
                Intrinsics.checkNotNull(atm2);
                setData(atm2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type es.santander.branchlocator.BLAtmDetailedInformationFragment");
        }
    }

    private final void setupUi(View view) {
        this.tvScheduleCash = (BLTextView) view.findViewById(R.id.tvScheduleCash);
    }

    public void setData(BLPoi atm2) {
        Intrinsics.checkNotNullParameter(atm2, "atm");
        this.atm = atm2;
        List<String> scheduleCash = atm2.getScheduleCash();
        Intrinsics.checkNotNullExpressionValue(scheduleCash, "atm.scheduleCash");
        if (!scheduleCash.isEmpty()) {
            List<String> scheduleCash2 = atm2.getScheduleCash();
            Intrinsics.checkNotNullExpressionValue(scheduleCash2, "atm.scheduleCash");
            this.scheduleCashList = scheduleCash2;
            showSchedule();
        }
    }

    private final void showSchedule() {
        String scheduleCashListText = this.scheduleCashList.get(0);
        for (int i = 1; i < this.scheduleCashList.size(); i++) {
            scheduleCashListText = scheduleCashListText + "\n" + this.scheduleCashList.get(i);
        }
        BLTextView bLTextView = this.tvScheduleCash;
        Intrinsics.checkNotNull(bLTextView);
        bLTextView.setText(scheduleCashListText);
        setupBillPayments();
    }

    private final void setupBillPayments() {
        BLTextView bLTextView = this.tvScheduleCash;
        Intrinsics.checkNotNull(bLTextView);
        bLTextView.setVisibility(0);
    }
}
