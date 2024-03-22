package es.santander.branchlocator;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import es.santander.branchlocator.BLPoi;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BLBranchScheduleFragment extends BLBaseInfoFragment {
    private static final String TAG = "BranchSchedule";
    private BLTextView billPaymentsLbl;
    private BLPoi branch;
    private String endSeparator = ":";
    private String endingScheduleDay = "";
    private LinearLayout llBillPayments = null;
    private ConstraintLayout mainContainer;
    private BLSchedule schedule;
    private LinearLayout scheduleContainer;
    private LinearLayout scheduleContainerAux = null;
    private String separator = " - ";
    private LinkedList<LinearLayout> singleScheduleList;
    private String startingScheduleDay;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.branch_schedule_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi(view);
        if (getParentFragment() instanceof BLBranchDetailedInformationFragment) {
            BLPoi branch2 = getParentFragment().getBranch();
            this.branch = branch2;
            setData(branch2);
        }
    }

    private void setupUi(View view) {
        this.billPaymentsLbl = (BLTextView) view.findViewById(R.id.lbl_bill_payments);
        this.llBillPayments = (LinearLayout) view.findViewById(R.id.ll_bill_payments);
        this.mainContainer = view.findViewById(R.id.main_container);
        this.scheduleContainer = (LinearLayout) view.findViewById(R.id.schedule);
        this.singleScheduleList = new LinkedList<>();
    }

    public void setData(BLPoi branch2) {
        if (branch2.getSchedule() != null) {
            this.branch = branch2;
            if (!branch2.getSchedule().getWorkingDay().getMonday().isEmpty()) {
                showSchedule();
            } else if (!branch2.getSchedule().getWorkingDay().getTuesday().isEmpty()) {
                showSchedule();
            } else if (!branch2.getSchedule().getWorkingDay().getWednesday().isEmpty()) {
                showSchedule();
            } else if (!branch2.getSchedule().getWorkingDay().getThursday().isEmpty()) {
                showSchedule();
            } else if (!branch2.getSchedule().getWorkingDay().getFriday().isEmpty()) {
                showSchedule();
            } else if (!branch2.getSchedule().getWorkingDay().getSaturday().isEmpty()) {
                showSchedule();
            } else if (!branch2.getSchedule().getWorkingDay().getSunday().isEmpty()) {
                showSchedule();
            } else {
                hideSchedule();
            }
        }
    }

    private void showSchedule() {
        if (getContext() != null) {
            this.mainContainer.setVisibility(0);
            this.schedule = BLUtils.hoursSchedule3(this.branch, getContext());
            buildSchedule();
            setupBillPayments();
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

    private void hideSchedule() {
        this.mainContainer.setVisibility(8);
    }

    private void setupBillPayments() {
        if (this.branch.getSchedule().getSpecialDay() == null || this.branch.getSchedule().getSpecialDay().isEmpty()) {
            this.billPaymentsLbl.setVisibility(8);
            this.llBillPayments.setVisibility(8);
            return;
        }
        this.billPaymentsLbl.setVisibility(0);
        this.llBillPayments.setVisibility(0);
        buildSpecialSchedule(this.branch.getSchedule().getSpecialDay());
    }

    private void buildSpecialSchedule(List<BLPoi.Schedule.SpecialDay> specialDays) {
        this.llBillPayments.removeAllViews();
        for (BLPoi.Schedule.SpecialDay specialDay : specialDays) {
            if (checkSpecialDayPassed(specialDay).booleanValue()) {
                this.llBillPayments.addView(createSingleSpecialSchedule(specialDay));
            }
        }
    }

    private Boolean checkSpecialDayPassed(BLPoi.Schedule.SpecialDay specialDay) {
        Date currentDate = Calendar.getInstance().getTime();
        String currentYear = String.valueOf(Calendar.getInstance().get(1));
        StringBuilder specialDayDate = new StringBuilder();
        specialDayDate.append(specialDay.getDate()).append("-").append(currentYear);
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            dateFormat.setLenient(false);
            if (dateFormat.parse(specialDayDate.toString()).after(currentDate)) {
                return 1;
            }
            return false;
        } catch (ParseException e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    private View createSingleSpecialSchedule(BLPoi.Schedule.SpecialDay specialDay) {
        String title = specialDay.getDate() + this.endSeparator;
        StringBuilder value = new StringBuilder();
        if (!specialDay.getTime().isEmpty()) {
            for (int i = 0; i < specialDay.getTime().size(); i++) {
                value.append(specialDay.getTime().get(i));
                if (i != specialDay.getTime().size() - 1) {
                    value.append("\n");
                }
            }
        } else {
            value.append(getContext().getResources().getString(R.string.bl_closed));
        }
        LinearLayout container = new LinearLayout(getContext());
        container.setWeightSum(1.0f);
        container.setOrientation(0);
        container.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        container.addView(buildKeyTextView(title));
        container.addView(buildValueTextView(value.toString()));
        return container;
    }
}
