package com.google.android.material.timepicker;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;

class TimePickerView extends ConstraintLayout implements TimePickerControls {
    static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    /* access modifiers changed from: private */
    public OnDoubleTapListener onDoubleTapListener;
    /* access modifiers changed from: private */
    public OnPeriodChangeListener onPeriodChangeListener;
    /* access modifiers changed from: private */
    public OnSelectionChange onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    interface OnDoubleTapListener {
        void onDoubleTap();
    }

    interface OnPeriodChangeListener {
        void onPeriodChange(int i);
    }

    interface OnSelectionChange {
        void onSelectionChanged(int i);
    }

    public TimePickerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TimePickerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.material.timepicker.TimePickerView, android.view.ViewGroup] */
    public TimePickerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.selectionListener = new View.OnClickListener() {
            public void onClick(View v) {
                if (TimePickerView.this.onSelectionChangeListener != null) {
                    TimePickerView.this.onSelectionChangeListener.onSelectionChanged(((Integer) v.getTag(R.id.selection_type)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                int period = checkedId == R.id.material_clock_period_pm_button ? 1 : 0;
                if (TimePickerView.this.onPeriodChangeListener != null && isChecked) {
                    TimePickerView.this.onPeriodChangeListener.onPeriodChange(period);
                }
            }
        });
        this.minuteView = (Chip) findViewById(R.id.material_minute_tv);
        this.hourView = (Chip) findViewById(R.id.material_hour_tv);
        this.clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        setupDoubleTap();
        setUpDisplay();
    }

    private void setupDoubleTap() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent e) {
                OnDoubleTapListener listener = TimePickerView.this.onDoubleTapListener;
                if (listener == null) {
                    return false;
                }
                listener.onDoubleTap();
                return true;
            }
        });
        View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (((Checkable) v).isChecked()) {
                    return gestureDetector.onTouchEvent(event);
                }
                return false;
            }
        };
        this.minuteView.setOnTouchListener(onTouchListener);
        this.hourView.setOnTouchListener(onTouchListener);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.material.chip.Chip, android.view.View] */
    public void setMinuteHourDelegate(AccessibilityDelegateCompat clickActionDelegate) {
        ViewCompat.setAccessibilityDelegate(this.hourView, clickActionDelegate);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.material.chip.Chip, android.view.View] */
    public void setHourClickDelegate(AccessibilityDelegateCompat clickActionDelegate) {
        ViewCompat.setAccessibilityDelegate(this.minuteView, clickActionDelegate);
    }

    private void setUpDisplay() {
        this.minuteView.setTag(R.id.selection_type, 12);
        this.hourView.setTag(R.id.selection_type, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
        this.minuteView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
        this.hourView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
    }

    public void setValues(String[] values, int contentDescription) {
        this.clockFace.setValues(values, contentDescription);
    }

    public void setHandRotation(float rotation) {
        this.clockHandView.setHandRotation(rotation);
    }

    public void setHandRotation(float rotation, boolean animate) {
        this.clockHandView.setHandRotation(rotation, animate);
    }

    public void setAnimateOnTouchUp(boolean animating) {
        this.clockHandView.setAnimateOnTouchUp(animating);
    }

    public void updateTime(int period, int hourOfDay, int minute) {
        int checkedId;
        if (period == 1) {
            checkedId = R.id.material_clock_period_pm_button;
        } else {
            checkedId = R.id.material_clock_period_am_button;
        }
        this.toggle.check(checkedId);
        Locale current = getResources().getConfiguration().locale;
        String minuteFormatted = String.format(current, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(minute)});
        String hourFormatted = String.format(current, TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(hourOfDay)});
        if (!TextUtils.equals(this.minuteView.getText(), minuteFormatted)) {
            this.minuteView.setText(minuteFormatted);
        }
        if (!TextUtils.equals(this.hourView.getText(), hourFormatted)) {
            this.hourView.setText(hourFormatted);
        }
    }

    public void setActiveSelection(int selection) {
        boolean z = true;
        updateSelection(this.minuteView, selection == 12);
        Chip chip = this.hourView;
        if (selection != 10) {
            z = false;
        }
        updateSelection(chip, z);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.material.chip.Chip, android.view.View] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateSelection(com.google.android.material.chip.Chip r2, boolean r3) {
        /*
            r1 = this;
            r2.setChecked(r3)
            if (r3 == 0) goto L_0x0008
            r0 = 2
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            androidx.core.view.ViewCompat.setAccessibilityLiveRegion(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.timepicker.TimePickerView.updateSelection(com.google.android.material.chip.Chip, boolean):void");
    }

    public void addOnRotateListener(ClockHandView.OnRotateListener onRotateListener) {
        this.clockHandView.addOnRotateListener(onRotateListener);
    }

    public void setOnActionUpListener(ClockHandView.OnActionUpListener onActionUpListener) {
        this.clockHandView.setOnActionUpListener(onActionUpListener);
    }

    /* access modifiers changed from: package-private */
    public void setOnPeriodChangeListener(OnPeriodChangeListener onPeriodChangeListener2) {
        this.onPeriodChangeListener = onPeriodChangeListener2;
    }

    /* access modifiers changed from: package-private */
    public void setOnSelectionChangeListener(OnSelectionChange onSelectionChangeListener2) {
        this.onSelectionChangeListener = onSelectionChangeListener2;
    }

    /* access modifiers changed from: package-private */
    public void setOnDoubleTapListener(OnDoubleTapListener listener) {
        this.onDoubleTapListener = listener;
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View changedView, int visibility) {
        TimePickerView.super.onVisibilityChanged(changedView, visibility);
        if (changedView == this && visibility == 0) {
            updateToggleConstraints();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        TimePickerView.super.onAttachedToWindow();
        updateToggleConstraints();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [androidx.constraintlayout.widget.ConstraintLayout, com.google.android.material.timepicker.TimePickerView, android.view.View] */
    private void updateToggleConstraints() {
        if (this.toggle.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            int sideToClear = 1;
            if (ViewCompat.getLayoutDirection(this) == 0) {
                sideToClear = 2;
            }
            constraintSet.clear(R.id.material_clock_display, sideToClear);
            constraintSet.applyTo(this);
        }
    }
}
