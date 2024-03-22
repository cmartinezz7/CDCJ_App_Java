package es.santander.branchlocator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BLAtmFeesFragment extends BLBaseInfoFragment {
    private BLTextView txtFees;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.atm_fees_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi(view);
        setupListeners();
        if (getParentFragment() instanceof BLAtmDetailedInformationFragment) {
            setData(getParentFragment().getAtm());
        }
    }

    private void setupUi(View view) {
        this.txtFees = (BLTextView) view.findViewById(R.id.txt_fees);
    }

    private void setupListeners() {
    }

    public void setData(BLPoi atm) {
        this.txtFees.setText(BLUtils.getDetailedInformationFees(atm, getContext()));
    }
}
