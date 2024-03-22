package es.santander.branchlocator;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BLAtmDetailedInformationFragment extends BLBaseFragment implements BLBaseFragmentDataUpdate {
    private static final String TAG = "AtmDetailedInfo";
    private BLPoi atm;
    private BLAtmAccesibilityFragment blAtmAccesibilityFragment;
    private BLAtmAditionalServices blAtmAditionalServices;
    private BLAtmBasicServicesFragment blAtmBasicServicesFragment;
    private BLAtmLocationFragment blAtmLocationFragment;
    private BLAtmPhoneFragment blAtmPhoneFragment;
    private BLAtmScheduleCashFragment blAtmScheduleCashFragment;
    private BLBranchFinancialServicesFragment blBranchFinancialServicesFragment;
    private BLBranchNewsAndWarningsFragment blBranchNewsAndWarningsFragment;
    private View circle;
    private ConstraintLayout clClosingIn;
    private String endSeparator = ":";
    private String endingScheduleDay = "";
    private FrameLayout flAccessibility;
    private FrameLayout flAditionalServices;
    private FrameLayout flBasicServices;
    private FrameLayout flFinancial;
    private FrameLayout flLocation;
    private FrameLayout flNews;
    private FrameLayout flPhone;
    private FrameLayout flSheduleCash;
    private BLSchedule schedule;
    private LinearLayout scheduleContainer;
    private LinearLayout scheduleContainerAux = null;
    private String separator = " - ";
    private LinkedList<LinearLayout> singleScheduleList;
    private String startingScheduleDay;
    private BLTextView tvMinutes;
    private BLTextView txtCloseInX;

    public static BLAtmDetailedInformationFragment newInstance() {
        return new BLAtmDetailedInformationFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.atm_information_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUI(view);
        setBaseFragmentDataUpdate(this);
        loadAtmData(this.atm);
    }

    public void loadAtmData(BLPoi atm2) {
        if (atm2 != null) {
            this.atm = atm2;
            if (this.flPhone != null && isAdded()) {
                setupFragmentData(atm2);
                getSchedule(atm2);
                try {
                    setupClosingText();
                } catch (ParseException e) {
                    Log.e(TAG, e.toString());
                }
            }
        }
    }

    private void setupFragmentData(BLPoi atm2) {
        if (!TextUtils.isEmpty(atm2.getPhone())) {
            this.flPhone.setVisibility(0);
            showPhoneFragment();
        } else {
            this.flPhone.setVisibility(8);
        }
        if (!TextUtils.isEmpty(atm2.getLocationServices(getActivity()))) {
            this.flLocation.setVisibility(0);
            showLocationFragment();
        } else {
            this.flLocation.setVisibility(8);
        }
        if (atm2.getScheduleCash() == null || atm2.getScheduleCash().size() <= 0 || atm2.getScheduleCash().get(0) == null) {
            this.flSheduleCash.setVisibility(8);
        } else {
            this.flSheduleCash.setVisibility(0);
            showScheduleCashFragment();
        }
        if (atm2.getRichTexts() == null || atm2.getRichTexts().size() <= 0) {
            this.flNews.setVisibility(8);
        } else {
            this.flNews.setVisibility(0);
            showNewsAndWarningsFragment();
        }
        if (atm2.getComercialProducts() == null || atm2.getComercialProducts().size() <= 0) {
            this.flBasicServices.setVisibility(8);
        } else {
            this.flBasicServices.setVisibility(0);
            showBasicServices();
        }
        if (!TextUtils.isEmpty(atm2.getBranchAccessibility(getActivity()))) {
            this.flAccessibility.setVisibility(0);
            showAccessibility();
        } else {
            this.flAccessibility.setVisibility(8);
        }
        if (!TextUtils.isEmpty(atm2.getFinancialServices(getActivity(), true)) || !TextUtils.isEmpty(atm2.getNonFinancialServices(getActivity()))) {
            this.flFinancial.setVisibility(0);
            showFinancialServices();
            return;
        }
        this.flFinancial.setVisibility(8);
    }

    private void setupUI(View view) {
        this.clClosingIn = view.findViewById(R.id.cl_closing_in);
        this.txtCloseInX = (BLTextView) view.findViewById(R.id.txt_close_in_x);
        this.tvMinutes = (BLTextView) view.findViewById(R.id.bl_tv_minutes);
        this.circle = view.findViewById(R.id.bl_circle_view);
        this.scheduleContainer = (LinearLayout) view.findViewById(R.id.txt_opening_hours);
        this.flPhone = (FrameLayout) view.findViewById(R.id.atm_phone_fragment);
        this.flSheduleCash = (FrameLayout) view.findViewById(R.id.atm_schedule_cash_fragment);
        this.flLocation = (FrameLayout) view.findViewById(R.id.atm_loction_fragment);
        this.flNews = (FrameLayout) view.findViewById(R.id.atm_news_fragment);
        this.flBasicServices = (FrameLayout) view.findViewById(R.id.atm_basic_services_fragment);
        this.flAditionalServices = (FrameLayout) view.findViewById(R.id.atm_aditional_services);
        this.flAccessibility = (FrameLayout) view.findViewById(R.id.atm_accessibility);
        this.flFinancial = (FrameLayout) view.findViewById(R.id.branch_financial_services);
        this.singleScheduleList = new LinkedList<>();
    }

    public void setAtmData(BLPoi BLPOI) {
        this.atm = BLPOI;
    }

    private void showPhoneFragment() {
        if (this.blAtmPhoneFragment == null) {
            this.blAtmPhoneFragment = new BLAtmPhoneFragment();
        }
        switchFragment(getChildFragmentManager(), this.blAtmPhoneFragment, (Fragment) null, R.id.atm_phone_fragment);
    }

    private void showScheduleCashFragment() {
        if (this.blAtmScheduleCashFragment == null) {
            this.blAtmScheduleCashFragment = new BLAtmScheduleCashFragment();
        }
        switchFragment(getChildFragmentManager(), this.blAtmScheduleCashFragment, (Fragment) null, R.id.atm_schedule_cash_fragment);
    }

    private void showLocationFragment() {
        if (this.blAtmLocationFragment == null) {
            this.blAtmLocationFragment = new BLAtmLocationFragment();
        }
        switchFragment(getChildFragmentManager(), this.blAtmLocationFragment, (Fragment) null, R.id.atm_loction_fragment);
    }

    private void showNewsAndWarningsFragment() {
        if (this.blBranchNewsAndWarningsFragment == null) {
            this.blBranchNewsAndWarningsFragment = new BLBranchNewsAndWarningsFragment();
        }
        switchFragment(getChildFragmentManager(), this.blBranchNewsAndWarningsFragment, (Fragment) null, R.id.atm_news_fragment);
    }

    private void showBasicServices() {
        if (this.blAtmBasicServicesFragment == null) {
            this.blAtmBasicServicesFragment = new BLAtmBasicServicesFragment();
        }
        switchFragment(getChildFragmentManager(), this.blAtmBasicServicesFragment, (Fragment) null, R.id.atm_basic_services_fragment);
    }

    private void showAditionalServices() {
        if (this.blAtmAditionalServices == null) {
            this.blAtmAditionalServices = new BLAtmAditionalServices();
        }
        switchFragment(getChildFragmentManager(), this.blAtmAditionalServices, (Fragment) null, R.id.atm_aditional_services);
    }

    private void showFinancialServices() {
        if (this.blBranchFinancialServicesFragment == null) {
            this.blBranchFinancialServicesFragment = new BLBranchFinancialServicesFragment();
        }
        switchFragment(getChildFragmentManager(), this.blBranchFinancialServicesFragment, (Fragment) null, R.id.branch_financial_services);
    }

    private void showAccessibility() {
        if (this.blAtmAccesibilityFragment == null) {
            this.blAtmAccesibilityFragment = new BLAtmAccesibilityFragment();
        }
        switchFragment(getChildFragmentManager(), this.blAtmAccesibilityFragment, (Fragment) null, R.id.atm_accessibility);
    }

    public BLPoi getAtm() {
        return this.atm;
    }

    private void setupClosingText() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentSdf = new SimpleDateFormat("HH:mm", getResources().getConfiguration().locale);
        Date currentTime = currentSdf.parse(currentSdf.format(new Date()));
        int currentDay = calendar.get(7);
        if (this.atm.getSchedule() != null) {
            List timeSchedule = new ArrayList();
            switch (currentDay) {
                case 1:
                    timeSchedule = this.atm.getSchedule().getWorkingDay().getSunday();
                    break;
                case 2:
                    timeSchedule = this.atm.getSchedule().getWorkingDay().getMonday();
                    break;
                case 3:
                    timeSchedule = this.atm.getSchedule().getWorkingDay().getTuesday();
                    break;
                case 4:
                    timeSchedule = this.atm.getSchedule().getWorkingDay().getWednesday();
                    break;
                case 5:
                    timeSchedule = this.atm.getSchedule().getWorkingDay().getThursday();
                    break;
                case 6:
                    timeSchedule = this.atm.getSchedule().getWorkingDay().getFriday();
                    break;
                case 7:
                    timeSchedule = this.atm.getSchedule().getWorkingDay().getSaturday();
                    break;
            }
            Calendar calendar2 = calendar;
            if (timeSchedule.size() == 1) {
                String firstTimeString = (String) timeSchedule.get(0);
                if (firstTimeString.equals("00:00-23:59")) {
                    if (this.atm.getSubType().getCode().equals(BLConstants.OTHERS_ATM_REQUEST) || this.atm.getSubType().getCode().equals("OTHER_NON_SANTANDER_ATM") || this.atm.getSubType().getCode().equals(BLConstants.SANTANDER_ATM_REQUEST) || this.atm.getSubType().getCode().equals("non_santander_atm") || this.atm.getSubType().getCode().equals("other_non_santander_atm") || this.atm.getSubType().getCode().equals("santander_atm")) {
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
            } else if (timeSchedule.size() == 0) {
                setClosingTextClosed();
            }
        } else {
            if (this.atm.getSubType() == null) {
                hideView();
            } else if (this.atm.getSubType().getCode().equals(BLConstants.OTHERS_ATM_REQUEST) || this.atm.getSubType().getCode().equals("OTHER_NON_SANTANDER_ATM") || this.atm.getSubType().getCode().equals(BLConstants.SANTANDER_ATM_REQUEST) || this.atm.getSubType().getCode().equals("non_santander_atm") || this.atm.getSubType().getCode().equals("other_non_santander_atm") || this.atm.getSubType().getCode().equals("santander_atm")) {
                setClosingTextOpen();
            } else {
                hideView();
            }
        }
    }

    public void loadData(Fragment fragment) {
        if (fragment instanceof BLBaseInfoFragment) {
            ((BLBaseInfoFragment) fragment).setData(this.atm);
        }
    }

    private void setClosingTextSoon(long diff) {
        this.clClosingIn.setVisibility(0);
        this.tvMinutes.setVisibility(0);
        this.txtCloseInX.setText(getResources().getString(R.string.bl_closing_in));
        this.tvMinutes.setText(diff + getResources().getString(R.string.bl_min));
        this.circle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bl_circle_orange));
    }

    private void setClosingTextOpen() {
        this.clClosingIn.setVisibility(0);
        this.txtCloseInX.setText(getResources().getString(R.string.bl_closing_in_open));
        this.tvMinutes.setVisibility(8);
        this.circle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bl_circle_green));
    }

    private void setClosingTextClosed() {
        this.clClosingIn.setVisibility(0);
        this.txtCloseInX.setText(getResources().getString(R.string.bl_closing_in_closed));
        this.tvMinutes.setVisibility(8);
        this.circle.setBackgroundDrawable(getResources().getDrawable(R.drawable.bl_circle_red));
    }

    private void hideView() {
        this.clClosingIn.setVisibility(8);
    }

    public void getSchedule(BLPoi atm2) {
        if (atm2.getSchedule() != null) {
            this.atm = atm2;
            if (!atm2.getSchedule().getWorkingDay().getMonday().isEmpty()) {
                showSchedule();
            } else if (!atm2.getSchedule().getWorkingDay().getTuesday().isEmpty()) {
                showSchedule();
            } else if (!atm2.getSchedule().getWorkingDay().getWednesday().isEmpty()) {
                showSchedule();
            } else if (!atm2.getSchedule().getWorkingDay().getThursday().isEmpty()) {
                showSchedule();
            } else if (!atm2.getSchedule().getWorkingDay().getFriday().isEmpty()) {
                showSchedule();
            } else if (!atm2.getSchedule().getWorkingDay().getSaturday().isEmpty()) {
                showSchedule();
            } else if (!atm2.getSchedule().getWorkingDay().getSunday().isEmpty()) {
                showSchedule();
            } else {
                set24hSchedule();
            }
        }
    }

    private void showSchedule() {
        if (getContext() != null) {
            this.schedule = BLUtils.hoursSchedule3(this.atm, getContext());
            if (this.atm.getSchedule().getWorkingDay().getMonday().get(0).equals("00:00-23:59")) {
                set24hSchedule();
            } else {
                buildSchedule();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [es.santander.branchlocator.BLTextView, android.view.View] */
    private void set24hSchedule() {
        this.scheduleContainer.removeAllViews();
        try {
            ? r0 = (BLTextView) getLayoutInflater().inflate(R.layout.custom_textview, (ViewGroup) null, false);
            if (r0.getParent() != null) {
                ((ViewGroup) r0.getParent()).removeView(r0);
            }
            r0.setText(getString(R.string.bl_24_hours));
            this.scheduleContainer.addView(r0);
        } catch (Exception e) {
            Log.e(TAG, e.getLocalizedMessage());
        }
    }

    private void buildSchedule() {
        this.singleScheduleList.clear();
        this.scheduleContainer.removeAllViews();
        if (this.schedule.monday != null) {
            if (isSingleDay(this.schedule.monday)) {
                createJoinSchedule(this.schedule.monday);
            } else {
                createSingleSchedule(this.schedule.monday);
            }
        }
        if (this.schedule.tuesday != null) {
            if (isSingleDay(this.schedule.tuesday)) {
                createJoinSchedule(this.schedule.tuesday);
            } else {
                createSingleSchedule(this.schedule.tuesday);
            }
        }
        if (this.schedule.wednesday != null) {
            if (isSingleDay(this.schedule.wednesday)) {
                createJoinSchedule(this.schedule.wednesday);
            } else {
                createSingleSchedule(this.schedule.wednesday);
            }
        }
        if (this.schedule.thursday != null) {
            if (isSingleDay(this.schedule.thursday)) {
                createJoinSchedule(this.schedule.thursday);
            } else {
                createSingleSchedule(this.schedule.thursday);
            }
        }
        if (this.schedule.friday != null) {
            if (isSingleDay(this.schedule.friday)) {
                createJoinSchedule(this.schedule.friday);
            } else {
                createSingleSchedule(this.schedule.friday);
            }
        }
        if (this.schedule.saturday != null) {
            if (isSingleDay(this.schedule.saturday)) {
                createJoinSchedule(this.schedule.saturday);
            } else {
                createSingleSchedule(this.schedule.saturday);
            }
        }
        if (this.schedule.sunday != null) {
            if (isSingleDay(this.schedule.sunday)) {
                createJoinSchedule(this.schedule.sunday);
            } else {
                createSingleSchedule(this.schedule.sunday);
            }
        }
        LinearLayout linearLayout = this.scheduleContainerAux;
        if (linearLayout != null) {
            this.scheduleContainer.addView(linearLayout);
        }
        LinkedList<LinearLayout> linkedList = this.singleScheduleList;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                this.scheduleContainer.addView((LinearLayout) it.next());
            }
        }
    }

    private void createSingleSchedule(BLDay day) {
        LinearLayout container = new LinearLayout(getContext());
        container.setWeightSum(1.0f);
        container.setOrientation(0);
        container.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        container.addView(buildKeyTextView(day.day + this.endSeparator));
        container.addView(buildValueTextView(day.value));
        this.singleScheduleList.add(container);
    }

    private void createJoinSchedule(BLDay day) {
        if (this.startingScheduleDay == null) {
            this.startingScheduleDay = day.day;
        } else {
            this.endingScheduleDay = day.day;
        }
        LinearLayout container = new LinearLayout(getContext());
        container.setOrientation(0);
        container.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        container.addView(buildKeyTextView(this.startingScheduleDay + this.separator + this.endingScheduleDay + this.endSeparator));
        container.addView(buildValueTextView(day.value));
        this.scheduleContainerAux = container;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [android.widget.TextView, es.santander.branchlocator.BLTextView] */
    private TextView buildKeyTextView(String title) {
        ? bLTextView = new BLTextView(getContext());
        bLTextView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.santander_text_bold));
        bLTextView.setTextSize(14.0f);
        bLTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.grey));
        bLTextView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.5f));
        bLTextView.setText(title);
        return bLTextView;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [android.widget.TextView, es.santander.branchlocator.BLTextView] */
    private TextView buildValueTextView(String value) {
        ? bLTextView = new BLTextView(getContext());
        bLTextView.setTypeface(ResourcesCompat.getFont(getContext(), R.font.santander_text_regular));
        bLTextView.setTextSize(14.0f);
        bLTextView.setTextColor(ContextCompat.getColor(getContext(), R.color.grey));
        bLTextView.setText(value);
        bLTextView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.5f));
        return bLTextView;
    }

    private boolean isSingleDay(BLDay day) {
        int sumEqualDays = 0;
        if (day != null) {
            if (this.schedule.monday != null && day.value.equals(this.schedule.monday.value)) {
                sumEqualDays = 0 + 1;
            }
            if (this.schedule.tuesday != null && day.value.equals(this.schedule.tuesday.value)) {
                sumEqualDays++;
            }
            if (this.schedule.wednesday != null && day.value.equals(this.schedule.wednesday.value)) {
                sumEqualDays++;
            }
            if (this.schedule.thursday != null && day.value.equals(this.schedule.thursday.value)) {
                sumEqualDays++;
            }
            if (this.schedule.friday != null && day.value.equals(this.schedule.friday.value)) {
                sumEqualDays++;
            }
            if (this.schedule.saturday != null && day.value.equals(this.schedule.saturday.value)) {
                sumEqualDays++;
            }
            if (this.schedule.sunday != null && day.value.equals(this.schedule.sunday.value)) {
                sumEqualDays++;
            }
        }
        if (sumEqualDays > 1) {
            return true;
        }
        return false;
    }
}
