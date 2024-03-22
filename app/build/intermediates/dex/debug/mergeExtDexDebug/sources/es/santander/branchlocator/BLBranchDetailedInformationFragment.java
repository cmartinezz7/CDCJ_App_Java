package es.santander.branchlocator;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BLBranchDetailedInformationFragment extends BLBaseFragment implements BLBaseFragmentDataUpdate {
    private static final String TAG = "BranchDetailedInfo";
    private BLBranchAccesibilityFragment blBranchAccesibilityFragment;
    private BLBranchFinancialServicesFragment blBranchFinancialServicesFragment;
    private BLBranchNewsAndWarningsFragment blBranchNewsAndWarningsFragment;
    private BLBranchPhoneFragment blBranchPhoneFragment;
    private BLBranchScheduleCashFragment blBranchScheduleCashFragment;
    private BLBranchScheduleFragment blBranchScheduleFragment;
    private BLPoi branch;
    private View circle;
    private ConstraintLayout clClosingIn;
    private FrameLayout flAccessibility;
    private FrameLayout flFinancial;
    private FrameLayout flNews;
    private FrameLayout flPhone;
    private FrameLayout flShedule;
    private FrameLayout flSheduleCash;
    private BLTextView tvMinutes;
    private BLTextView txtCloseInX;

    public static BLBranchDetailedInformationFragment newInstance() {
        return new BLBranchDetailedInformationFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.branch_information_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUI(view);
        setBaseFragmentDataUpdate(this);
        loadBranchData(this.branch);
    }

    private void setupUI(View view) {
        this.clClosingIn = view.findViewById(R.id.cl_closing_in);
        this.txtCloseInX = (BLTextView) view.findViewById(R.id.txt_close_in_x);
        this.tvMinutes = (BLTextView) view.findViewById(R.id.bl_tv_minutes);
        this.circle = view.findViewById(R.id.bl_circle_view);
        this.flPhone = (FrameLayout) view.findViewById(R.id.branch_phone_fragment);
        this.flShedule = (FrameLayout) view.findViewById(R.id.branch_schedule_fragment);
        this.flSheduleCash = (FrameLayout) view.findViewById(R.id.branch_schedule_cash_fragment);
        this.flNews = (FrameLayout) view.findViewById(R.id.branch_news_and_warnings_fragment);
        this.flFinancial = (FrameLayout) view.findViewById(R.id.branch_financial_services);
        this.flAccessibility = (FrameLayout) view.findViewById(R.id.branch_accessibility_fragment);
    }

    public void loadBranchData(BLPoi branch2) {
        if (branch2 != null && this.flPhone != null) {
            setupFragmentData(branch2);
            try {
                setupClosingText();
            } catch (ParseException e) {
                Log.e(TAG, e.toString());
                setClosingTextInvalid();
            }
        }
    }

    private void setupFragmentData(BLPoi branch2) {
        if (!TextUtils.isEmpty(branch2.getPhone())) {
            this.flPhone.setVisibility(0);
            showPhoneFragment();
        } else {
            this.flPhone.setVisibility(8);
        }
        if (branch2.getSchedule() != null) {
            this.flShedule.setVisibility(0);
            showScheduleFragment();
        } else {
            this.flShedule.setVisibility(8);
        }
        if (branch2.getScheduleCash() != null) {
            this.flSheduleCash.setVisibility(0);
            showScheduleCashFragment();
        } else {
            this.flSheduleCash.setVisibility(8);
        }
        if (branch2.getRichTexts() == null || branch2.getRichTexts().size() <= 0) {
            this.flNews.setVisibility(8);
        } else {
            this.flNews.setVisibility(0);
            showNewsAndWarningsFragment();
        }
        if (!TextUtils.isEmpty(branch2.getFinancialServices(getActivity(), false)) || !TextUtils.isEmpty(branch2.getNonFinancialServices(getActivity()))) {
            this.flFinancial.setVisibility(0);
            showFinancialServices();
        } else {
            this.flFinancial.setVisibility(8);
        }
        if (!TextUtils.isEmpty(branch2.getBranchAccessibility(getActivity()))) {
            this.flAccessibility.setVisibility(0);
            showAccessibilityFragment();
            return;
        }
        this.flAccessibility.setVisibility(8);
    }

    private void setupClosingText() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentSdf = new SimpleDateFormat("HH:mm", getResources().getConfiguration().locale);
        Date currentTime = currentSdf.parse(currentSdf.format(new Date()));
        int currentDay = calendar.get(7);
        if (this.branch.getSchedule() != null) {
            List timeSchedule = new ArrayList();
            switch (currentDay) {
                case 1:
                    timeSchedule = this.branch.getSchedule().getWorkingDay().getSunday();
                    break;
                case 2:
                    timeSchedule = this.branch.getSchedule().getWorkingDay().getMonday();
                    break;
                case 3:
                    timeSchedule = this.branch.getSchedule().getWorkingDay().getTuesday();
                    break;
                case 4:
                    timeSchedule = this.branch.getSchedule().getWorkingDay().getWednesday();
                    break;
                case 5:
                    timeSchedule = this.branch.getSchedule().getWorkingDay().getThursday();
                    break;
                case 6:
                    timeSchedule = this.branch.getSchedule().getWorkingDay().getFriday();
                    break;
                case 7:
                    timeSchedule = this.branch.getSchedule().getWorkingDay().getSaturday();
                    break;
            }
            Calendar calendar2 = calendar;
            SimpleDateFormat simpleDateFormat = currentSdf;
            if (timeSchedule.size() == 1) {
                String firstTimeString = (String) timeSchedule.get(0);
                if (firstTimeString.equals("00:00-23:59")) {
                    if (this.branch.getSubType().getCode().equals(BLConstants.OTHERS_ATM_REQUEST) || this.branch.getSubType().getCode().equals("OTHER_NON_SANTANDER_ATM") || this.branch.getSubType().getCode().equals(BLConstants.SANTANDER_ATM_REQUEST) || this.branch.getSubType().getCode().equals("non_santander_atm") || this.branch.getSubType().getCode().equals("other_non_santander_atm") || this.branch.getSubType().getCode().equals("santander_atm")) {
                        setClosingTextOpen();
                    } else {
                        hideView();
                    }
                } else if (firstTimeString.length() > 5) {
                    String[] parts = firstTimeString.split("-");
                    Date morningOpeningTime = new SimpleDateFormat("HH:mm").parse(parts[0]);
                    Date morningClosingTime = new SimpleDateFormat("HH:mm").parse(parts[1]);
                    if (!currentTime.after(morningOpeningTime) || !currentTime.before(morningClosingTime)) {
                        setClosingTextClosed();
                        return;
                    }
                    long diffMinutes = (morningClosingTime.getTime() - currentTime.getTime()) / 60000;
                    if (diffMinutes < 60) {
                        setClosingTextSoon(diffMinutes);
                    } else {
                        setClosingTextOpen();
                    }
                }
            } else if (timeSchedule.size() == 2) {
                String firstTimeString2 = (String) timeSchedule.get(0);
                if (firstTimeString2.length() > 5) {
                    String[] firstParts = firstTimeString2.split("-");
                    Date morningOpeningTime2 = new SimpleDateFormat("HH:mm").parse(firstParts[0]);
                    Date morningClosingTime2 = new SimpleDateFormat("HH:mm").parse(firstParts[1]);
                    if (!currentTime.after(morningOpeningTime2) || !currentTime.before(morningClosingTime2)) {
                        String secondTimeString = (String) timeSchedule.get(1);
                        if (secondTimeString.length() > 5) {
                            String[] secondParts = secondTimeString.split("-");
                            Date eveningOpeningTime = new SimpleDateFormat("HH:mm").parse(secondParts[0]);
                            Date eveningClosingTime = new SimpleDateFormat("HH:mm").parse(secondParts[1]);
                            if (!currentTime.after(eveningOpeningTime) || !currentTime.before(eveningClosingTime)) {
                                String str = secondTimeString;
                                setClosingTextClosed();
                                return;
                            }
                            String[] strArr = secondParts;
                            String str2 = secondTimeString;
                            long diffMinutes2 = (eveningClosingTime.getTime() - currentTime.getTime()) / 60000;
                            if (diffMinutes2 < 60) {
                                setClosingTextSoon(diffMinutes2);
                            } else {
                                setClosingTextOpen();
                            }
                        }
                    } else {
                        Date date = morningOpeningTime2;
                        long diffMinutes3 = (morningClosingTime2.getTime() - currentTime.getTime()) / 60000;
                        if (diffMinutes3 < 60) {
                            setClosingTextSoon(diffMinutes3);
                        } else {
                            setClosingTextOpen();
                        }
                    }
                }
            } else if (timeSchedule.size() == 0) {
                setClosingTextClosed();
            }
        } else {
            SimpleDateFormat simpleDateFormat2 = currentSdf;
            if (this.branch.getSubType() == null) {
                hideView();
            } else if (this.branch.getSubType().getCode().equals(BLConstants.OTHERS_ATM_REQUEST) || this.branch.getSubType().getCode().equals("OTHER_NON_SANTANDER_ATM") || this.branch.getSubType().getCode().equals(BLConstants.SANTANDER_ATM_REQUEST) || this.branch.getSubType().getCode().equals("non_santander_atm") || this.branch.getSubType().getCode().equals("other_non_santander_atm") || this.branch.getSubType().getCode().equals("santander_atm")) {
                setClosingTextOpen();
            } else {
                hideView();
            }
        }
    }

    private void setClosingTextSoon(long diff) {
        this.clClosingIn.setVisibility(0);
        this.tvMinutes.setVisibility(0);
        this.txtCloseInX.setText(getResources().getString(R.string.bl_closing_in));
        this.tvMinutes.setText(diff + getResources().getString(R.string.bl_min));
        this.circle.setVisibility(0);
        this.circle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bl_circle_orange));
    }

    private void setClosingTextOpen() {
        this.clClosingIn.setVisibility(0);
        this.txtCloseInX.setText(getResources().getString(R.string.bl_closing_in_open));
        this.tvMinutes.setVisibility(8);
        this.circle.setVisibility(0);
        this.circle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bl_circle_green));
    }

    private void setClosingTextClosed() {
        this.clClosingIn.setVisibility(0);
        this.txtCloseInX.setText(getResources().getString(R.string.bl_closing_in_closed));
        this.tvMinutes.setVisibility(8);
        this.circle.setVisibility(0);
        this.circle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bl_circle_red));
    }

    private void setClosingTextInvalid() {
        this.clClosingIn.setVisibility(0);
        this.txtCloseInX.setText(getResources().getString(R.string.bl_invalid_data));
        this.tvMinutes.setVisibility(8);
        this.circle.setVisibility(8);
    }

    private void hideView() {
        this.clClosingIn.setVisibility(8);
    }

    public void setBranchData(BLPoi BLPOI) {
        this.branch = BLPOI;
    }

    private void showPhoneFragment() {
        if (this.blBranchPhoneFragment == null) {
            this.blBranchPhoneFragment = new BLBranchPhoneFragment();
        }
        switchFragment(getChildFragmentManager(), this.blBranchPhoneFragment, (Fragment) null, R.id.branch_phone_fragment);
    }

    private void showScheduleFragment() {
        if (this.blBranchScheduleFragment == null) {
            this.blBranchScheduleFragment = new BLBranchScheduleFragment();
        }
        switchFragment(getChildFragmentManager(), this.blBranchScheduleFragment, (Fragment) null, R.id.branch_schedule_fragment);
    }

    private void showScheduleCashFragment() {
        if (this.blBranchScheduleCashFragment == null) {
            this.blBranchScheduleCashFragment = new BLBranchScheduleCashFragment();
        }
        switchFragment(getChildFragmentManager(), this.blBranchScheduleCashFragment, (Fragment) null, R.id.branch_schedule_cash_fragment);
    }

    private void showNewsAndWarningsFragment() {
        if (this.blBranchNewsAndWarningsFragment == null) {
            this.blBranchNewsAndWarningsFragment = new BLBranchNewsAndWarningsFragment();
        }
        switchFragment(getChildFragmentManager(), this.blBranchNewsAndWarningsFragment, (Fragment) null, R.id.branch_news_and_warnings_fragment);
    }

    private void showFinancialServices() {
        if (this.blBranchFinancialServicesFragment == null) {
            this.blBranchFinancialServicesFragment = new BLBranchFinancialServicesFragment();
        }
        switchFragment(getChildFragmentManager(), this.blBranchFinancialServicesFragment, (Fragment) null, R.id.branch_financial_services);
    }

    private void showAccessibilityFragment() {
        if (this.blBranchAccesibilityFragment == null) {
            this.blBranchAccesibilityFragment = new BLBranchAccesibilityFragment();
        }
        switchFragment(getChildFragmentManager(), this.blBranchAccesibilityFragment, (Fragment) null, R.id.branch_accessibility_fragment);
    }

    public BLPoi getBranch() {
        return this.branch;
    }

    public void loadData(Fragment fragment) {
        if (fragment instanceof BLBaseInfoFragment) {
            ((BLBaseInfoFragment) fragment).setData(this.branch);
        }
    }
}
