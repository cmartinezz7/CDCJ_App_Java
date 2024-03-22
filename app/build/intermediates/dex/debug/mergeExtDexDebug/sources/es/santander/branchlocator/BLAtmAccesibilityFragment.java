package es.santander.branchlocator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BLAtmAccesibilityFragment extends BLBaseInfoFragment {
    private BLTextView txtAccessibility;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.atm_accessibility_fragment, container, false);
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
        this.txtAccessibility = (BLTextView) view.findViewById(R.id.txt_atm_accessibility);
    }

    private void setupListeners() {
    }

    public void setData(BLPoi branch) {
        this.txtAccessibility.setText(branch.getBranchAccessibility(getActivity()));
    }
}
