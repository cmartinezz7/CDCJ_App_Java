package es.santander.branchlocator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.santander.branchlocator.common.AnalyticsComponentHelper;
import java.util.HashMap;
import java.util.Map;

public class BLAtmPhoneFragment extends BLBaseInfoFragment {
    private static final String TAG = "AtmPhone";
    private final int PHONE_CALL_PERMISION = 1000;
    private BLPoi atm;
    private BLTextView btnCall;
    private BLTextView txtPhone;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.atm_phone_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi(view);
        setupListeners();
        if (getParentFragment() instanceof BLAtmDetailedInformationFragment) {
            BLPoi atm2 = getParentFragment().getAtm();
            this.atm = atm2;
            setData(atm2);
        }
    }

    private void setupUi(View view) {
        this.txtPhone = (BLTextView) view.findViewById(R.id.atm_info_txt_phone);
        this.btnCall = (BLTextView) view.findViewById(R.id.atm_info_btn_call);
    }

    private void setupListeners() {
        this.btnCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BLAtmPhoneFragment.this.makePhoneCall();
            }
        });
    }

    /* access modifiers changed from: private */
    public void makePhoneCall() {
        BLPoi bLPoi = this.atm;
        if (bLPoi != null && !TextUtils.isEmpty(bLPoi.getPhone())) {
            try {
                BLUtils.getAnalytcsTag(getContext(), "phone_call_atm");
                Map<String, String> dataLayer = new HashMap<>(1);
                dataLayer.put("ScreenName", "branch locator:branch detail");
                dataLayer.put("TabName", "atm");
                dataLayer.put("EventAction", "tap call button");
                AnalyticsComponentHelper.trackEvent("tap call button", dataLayer);
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:" + String.valueOf(this.atm.getPhone()).trim()));
                startActivity(intent);
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    public void setData(BLPoi atm2) {
        this.atm = atm2;
        this.txtPhone.setText(atm2.getPhone());
    }
}
