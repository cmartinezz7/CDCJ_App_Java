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

public class BLBranchPhoneFragment extends BLBaseInfoFragment {
    private static final String TAG = "BranchPhone";
    private final int PHONE_CALL_PERMISION = 1000;
    private BLPoi branch;
    private BLTextView btnCall;
    private BLTextView txtPhone;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.branch_phone_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi(view);
        setupListeners();
        if (getParentFragment() instanceof BLBranchDetailedInformationFragment) {
            BLPoi branch2 = getParentFragment().getBranch();
            this.branch = branch2;
            setData(branch2);
        }
    }

    private void setupUi(View view) {
        this.txtPhone = (BLTextView) view.findViewById(R.id.branch_info_txt_phone);
        this.btnCall = (BLTextView) view.findViewById(R.id.branch_info_btn_call);
    }

    private void setupListeners() {
        this.btnCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BLBranchPhoneFragment.this.makePhoneCall();
            }
        });
    }

    /* access modifiers changed from: private */
    public void makePhoneCall() {
        BLPoi bLPoi = this.branch;
        if (bLPoi != null && bLPoi.contactData() != null && !TextUtils.isEmpty(this.branch.contactData().getPhoneNumber())) {
            try {
                BLUtils.getAnalytcsTag(getContext(), "phone_call_branch");
                Map<String, String> dataLayer = new HashMap<>(1);
                dataLayer.put("ScreenName", "branch locator:branch detail");
                dataLayer.put("TabName", "branch");
                dataLayer.put("EventAction", "tap call button");
                AnalyticsComponentHelper.trackEvent("tap call button", dataLayer);
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:" + String.valueOf(this.branch.contactData().getPhoneNumber()).trim()));
                startActivity(intent);
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
    }

    public void setData(BLPoi branch2) {
        this.branch = branch2;
        this.txtPhone.setText(branch2.getPhone());
    }
}
