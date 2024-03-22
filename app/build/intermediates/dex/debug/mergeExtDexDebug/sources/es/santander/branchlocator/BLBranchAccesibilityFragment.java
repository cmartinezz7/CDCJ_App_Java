package es.santander.branchlocator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BLBranchAccesibilityFragment extends BLBaseInfoFragment {
    private BLTextView txtAccesibility;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.branch_accessibility_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi(view);
        setupListeners();
        if (getParentFragment() instanceof BLBranchDetailedInformationFragment) {
            setData(getParentFragment().getBranch());
        }
    }

    private void setupUi(View view) {
        this.txtAccesibility = (BLTextView) view.findViewById(R.id.txt_branch_accessibility);
    }

    private void setupListeners() {
    }

    public void setData(BLPoi branch) {
        this.txtAccesibility.setText(branch.getBranchAccessibility(getActivity()));
    }
}
