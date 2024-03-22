package es.santander.branchlocator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BLAtmAditionalServices extends BLBaseInfoFragment {
    private BLTextView txtAditionalServices;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.atm_aditional_services_fragment, container, false);
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
        this.txtAditionalServices = (BLTextView) view.findViewById(R.id.txt_atm_aditional_services);
    }

    private void setupListeners() {
    }

    public void setData(BLPoi branch) {
        this.txtAditionalServices.setText(branch.getAditionalServices(getActivity()));
    }
}
