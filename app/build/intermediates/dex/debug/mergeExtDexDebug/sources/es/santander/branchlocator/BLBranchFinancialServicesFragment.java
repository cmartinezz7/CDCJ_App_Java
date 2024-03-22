package es.santander.branchlocator;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class BLBranchFinancialServicesFragment extends BLBaseInfoFragment {
    private BLTextView financialServices;
    private BLTextView headerFinancialServices;
    private BLTextView headerNoFinancialServices;
    private boolean isAtm;
    private LinearLayout llFinancial;
    private LinearLayout llNoFinancial;
    private BLTextView nonFinancialServices;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.branch_financial_services_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi(view);
        setupListeners();
        BLPoi poi = null;
        if (getParentFragment() instanceof BLBranchDetailedInformationFragment) {
            poi = getParentFragment().getBranch();
        } else if (getParentFragment() instanceof BLAtmDetailedInformationFragment) {
            poi = getParentFragment().getAtm();
        }
        if (poi != null) {
            setData(poi);
        }
    }

    private void setupUi(View view) {
        this.financialServices = (BLTextView) view.findViewById(R.id.txt_financial_services);
        this.nonFinancialServices = (BLTextView) view.findViewById(R.id.txt_non_financial_services);
        this.headerFinancialServices = (BLTextView) view.findViewById(R.id.txt_header_financial);
        this.headerNoFinancialServices = (BLTextView) view.findViewById(R.id.txt_header_no_financial);
        this.llFinancial = (LinearLayout) view.findViewById(R.id.llFinancial);
        this.llNoFinancial = (LinearLayout) view.findViewById(R.id.llNoFinancial);
    }

    private void setupListeners() {
    }

    public void setData(BLPoi branch) {
        this.llFinancial.setVisibility(8);
        this.llNoFinancial.setVisibility(8);
        if (getParentFragment() instanceof BLBranchDetailedInformationFragment) {
            this.isAtm = false;
        } else if (getParentFragment() instanceof BLAtmDetailedInformationFragment) {
            this.isAtm = true;
        }
        String financialServicesStr = branch.getFinancialServices(getActivity(), this.isAtm);
        String notFinancialServicesStr = branch.getNonFinancialServices(getActivity());
        if (notFinancialServicesStr != null && !notFinancialServicesStr.equals("") && financialServicesStr != null && !financialServicesStr.equals("") && !financialServicesStr.endsWith("\n")) {
            financialServicesStr = financialServicesStr + "\n";
        }
        if (!TextUtils.isEmpty(financialServicesStr)) {
            this.financialServices.setText(financialServicesStr);
            this.llFinancial.setVisibility(0);
            this.headerFinancialServices.setVisibility(0);
            this.financialServices.setVisibility(0);
        } else {
            this.llFinancial.setVisibility(8);
            this.headerFinancialServices.setVisibility(8);
            this.financialServices.setVisibility(8);
        }
        if (!TextUtils.isEmpty(notFinancialServicesStr)) {
            this.nonFinancialServices.setText(notFinancialServicesStr);
            this.headerNoFinancialServices.setVisibility(0);
            this.llNoFinancial.setVisibility(0);
            return;
        }
        this.headerNoFinancialServices.setVisibility(8);
        this.llNoFinancial.setVisibility(8);
    }
}
