package com.santander.globile.uicomponents.calendar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.calendar.listeners.DateSelectListener;
import com.santander.globile.uicomponents.calendar.listeners.GridChangeListener;
import com.santander.globile.uicomponents.calendar.utils.CalendarUtilsKt;
import com.santander.globile.uicomponents.text.SantanderTextView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\u0002H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\u0010\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020\bH\u0016J\"\u0010*\u001a\u00020+2\u0006\u0010)\u001a\u00020\b2\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010-\u001a\u00020.H\u0016J\u001c\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u00010\u00132\b\u00101\u001a\u0004\u0018\u00010\u0013H\u0002J$\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\u00132\b\u00100\u001a\u0004\u0018\u00010\u00132\b\u00101\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/santander/globile/uicomponents/calendar/GlobileCalendarGridAdapter;", "Landroid/widget/ArrayAdapter;", "Ljava/util/Date;", "context", "Landroid/content/Context;", "calendarData", "Lcom/santander/globile/uicomponents/calendar/GlobileCalendarConfig;", "shiftMonth", "", "listener", "Lcom/santander/globile/uicomponents/calendar/listeners/DateSelectListener;", "gridListener", "Lcom/santander/globile/uicomponents/calendar/listeners/GridChangeListener;", "(Landroid/content/Context;Lcom/santander/globile/uicomponents/calendar/GlobileCalendarConfig;ILcom/santander/globile/uicomponents/calendar/listeners/DateSelectListener;Lcom/santander/globile/uicomponents/calendar/listeners/GridChangeListener;)V", "backgroundSelectedCircle", "Landroid/widget/FrameLayout;", "cellView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "dateCal", "Ljava/util/Calendar;", "inflater", "Landroid/view/LayoutInflater;", "mainCalendar", "maxCal", "minCal", "monthlyDates", "Ljava/util/ArrayList;", "shape_background_black_end", "shape_background_black_start", "textDate", "Lcom/santander/globile/uicomponents/text/SantanderTextView;", "enableCell", "", "enable", "", "getCount", "getCurrentDate", "getDefaultCalendar", "getFirstDayVisitble", "dayOfWeek", "getItem", "position", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "printBackgroundDatesSelected", "calendarStart", "calendarEnd", "printSelectedDate", "currentDate", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileCalendarGridAdapter.kt */
public final class GlobileCalendarGridAdapter extends ArrayAdapter<Date> {
    private FrameLayout backgroundSelectedCircle;
    private final GlobileCalendarConfig calendarData;
    private ConstraintLayout cellView;
    private final Calendar dateCal;
    /* access modifiers changed from: private */
    public final GridChangeListener gridListener;
    private final LayoutInflater inflater;
    /* access modifiers changed from: private */
    public final DateSelectListener listener;
    private final Calendar mainCalendar;
    private Calendar maxCal;
    private Calendar minCal;
    /* access modifiers changed from: private */
    public ArrayList<Date> monthlyDates = new ArrayList<>();
    private FrameLayout shape_background_black_end;
    private FrameLayout shape_background_black_start;
    private final int shiftMonth;
    private SantanderTextView textDate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileCalendarGridAdapter(Context context, GlobileCalendarConfig calendarData2, int shiftMonth2, DateSelectListener listener2, GridChangeListener gridListener2) {
        super(context, R.layout.calendar_single_cell);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(calendarData2, "calendarData");
        Intrinsics.checkParameterIsNotNull(gridListener2, "gridListener");
        this.calendarData = calendarData2;
        this.shiftMonth = shiftMonth2;
        this.listener = listener2;
        this.gridListener = gridListener2;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkExpressionValueIsNotNull(from, "LayoutInflater.from(context)");
        this.inflater = from;
        this.dateCal = getDefaultCalendar();
        Calendar defaultCalendar = getDefaultCalendar();
        this.mainCalendar = defaultCalendar;
        this.minCal = getDefaultCalendar();
        this.maxCal = getDefaultCalendar();
        this.monthlyDates = new ArrayList<>();
        if (calendarData2.getMinDate() == null) {
            this.minCal = null;
        } else {
            Calendar calendar = this.minCal;
            if (calendar != null) {
                calendar.setTime(calendarData2.getMinDate());
            }
        }
        if (calendarData2.getMaxDate() == null) {
            this.maxCal = null;
        } else {
            Calendar calendar2 = this.maxCal;
            if (calendar2 != null) {
                calendar2.setTime(calendarData2.getMaxDate());
            }
        }
        Date showDate = calendarData2.getShowDate();
        if (showDate == null) {
            Intrinsics.throwNpe();
        }
        defaultCalendar.setTime(showDate);
        defaultCalendar.add(2, shiftMonth2);
        defaultCalendar.set(5, 1);
        defaultCalendar.add(5, getFirstDayVisitble(defaultCalendar.get(7)));
        while (this.monthlyDates.size() < 42) {
            this.monthlyDates.add(this.mainCalendar.getTime());
            this.mainCalendar.add(5, 1);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        int i = position;
        ViewGroup viewGroup = parent;
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        this.dateCal.setTime(this.monthlyDates.get(i));
        View view = convertView;
        if (convertView == null) {
            view = this.inflater.inflate(R.layout.calendar_single_cell, viewGroup, false);
        }
        SantanderTextView santanderTextView = null;
        Calendar calendarStart = null;
        if (this.calendarData.getSelectedStartDate() != null) {
            calendarStart = Calendar.getInstance(Locale.getDefault());
            Intrinsics.checkExpressionValueIsNotNull(calendarStart, "calendarStart");
            Date selectedStartDate = this.calendarData.getSelectedStartDate();
            if (selectedStartDate == null) {
                Intrinsics.throwNpe();
            }
            calendarStart.setTime(selectedStartDate);
            Calendar $this$apply = calendarStart;
            $this$apply.set(10, 0);
            $this$apply.set(12, 0);
            $this$apply.set(13, 0);
            $this$apply.set(14, 0);
        }
        Calendar calendarEnd = null;
        if (this.calendarData.getSelectedEndDate() != null) {
            calendarEnd = Calendar.getInstance(Locale.getDefault());
            Intrinsics.checkExpressionValueIsNotNull(calendarEnd, "calendarEnd");
            Date selectedEndDate = this.calendarData.getSelectedEndDate();
            if (selectedEndDate == null) {
                Intrinsics.throwNpe();
            }
            calendarEnd.setTime(selectedEndDate);
            Calendar $this$apply2 = calendarEnd;
            $this$apply2.set(10, 0);
            $this$apply2.set(12, 0);
            $this$apply2.set(13, 0);
            $this$apply2.set(14, 0);
        }
        Calendar calendar = this.dateCal;
        Calendar $this$apply3 = calendar;
        $this$apply3.set(10, 0);
        $this$apply3.set(12, 0);
        $this$apply3.set(13, 0);
        $this$apply3.set(14, 0);
        Date positionDate = calendar.getTime();
        Date today = getCurrentDate();
        String day_of_month = String.valueOf(this.dateCal.get(5));
        if (view != null) {
            santanderTextView = (SantanderTextView) view.findViewById(R.id.txtDate);
        }
        if (santanderTextView != null) {
            SantanderTextView $this$apply4 = santanderTextView;
            $this$apply4.setText(day_of_month);
            Context context = $this$apply4.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            $this$apply4.setTextColor(CalendarUtilsKt.convertToDefaultColor(context, this.calendarData.getTextColor().getValue()));
            this.textDate = santanderTextView;
            ConstraintLayout findViewById = view.findViewById(R.id.cellView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view.findViewById(R.id.cellView)");
            ConstraintLayout constraintLayout = findViewById;
            this.cellView = constraintLayout;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cellView");
            }
            constraintLayout.setOnClickListener(new GlobileCalendarGridAdapter$getView$4(this, i));
            ConstraintLayout constraintLayout2 = this.cellView;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cellView");
            }
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            constraintLayout2.setBackgroundColor(CalendarUtilsKt.convertToDefaultColor(context2, this.calendarData.getBackgroundColor().getValue()));
            View findViewById2 = view.findViewById(R.id.shape_background_black_start);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "view.findViewById(R.id.s…e_background_black_start)");
            FrameLayout frameLayout = (FrameLayout) findViewById2;
            this.shape_background_black_start = frameLayout;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shape_background_black_start");
            }
            frameLayout.setBackgroundResource(0);
            View findViewById3 = view.findViewById(R.id.shape_background_black_end);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "view.findViewById(R.id.shape_background_black_end)");
            FrameLayout frameLayout2 = (FrameLayout) findViewById3;
            this.shape_background_black_end = frameLayout2;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shape_background_black_end");
            }
            frameLayout2.setBackgroundResource(0);
            View findViewById4 = view.findViewById(R.id.backgroundSelectedCircle);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "view.findViewById(R.id.backgroundSelectedCircle)");
            this.backgroundSelectedCircle = (FrameLayout) findViewById4;
            printBackgroundDatesSelected(calendarStart, calendarEnd);
            Calendar currentDate = getDefaultCalendar();
            Date showDate = this.calendarData.getShowDate();
            if (showDate == null) {
                Intrinsics.throwNpe();
            }
            currentDate.setTime(showDate);
            currentDate.add(2, this.shiftMonth);
            FrameLayout frameLayout3 = this.backgroundSelectedCircle;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSelectedCircle");
            }
            frameLayout3.setBackgroundResource(0);
            if (positionDate.compareTo(today) == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    FrameLayout frameLayout4 = this.backgroundSelectedCircle;
                    if (frameLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backgroundSelectedCircle");
                    }
                    frameLayout4.setBackground(getContext().getDrawable(R.drawable.calendar_current_day_background));
                } else {
                    FrameLayout frameLayout5 = this.backgroundSelectedCircle;
                    if (frameLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backgroundSelectedCircle");
                    }
                    Context context3 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                    frameLayout5.setBackground(context3.getResources().getDrawable(R.drawable.calendar_current_day_background));
                }
            }
            SantanderTextView santanderTextView2 = this.textDate;
            if (santanderTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textDate");
            }
            Context context4 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context4, "context");
            santanderTextView2.setTextColor(CalendarUtilsKt.convertToDefaultColor(context4, this.calendarData.getTextColor().getValue()));
            printSelectedDate(currentDate, calendarStart, calendarEnd);
            if (currentDate.get(2) == this.dateCal.get(2)) {
                Calendar calendar2 = this.minCal;
                if (calendar2 == null && this.maxCal == null) {
                    enableCell(true);
                } else if (calendar2 == null || this.maxCal == null || this.dateCal.compareTo(calendar2) >= 0 || this.dateCal.compareTo(this.maxCal) <= 0) {
                    Calendar calendar3 = this.minCal;
                    if (calendar3 == null || this.dateCal.compareTo(calendar3) >= 0) {
                        Calendar calendar4 = this.maxCal;
                        if (calendar4 == null || this.dateCal.compareTo(calendar4) <= 0) {
                            enableCell(true);
                        } else {
                            enableCell(false);
                        }
                    } else {
                        enableCell(false);
                    }
                } else {
                    enableCell(false);
                }
            } else {
                SantanderTextView santanderTextView3 = this.textDate;
                if (santanderTextView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textDate");
                }
                santanderTextView3.setText("");
                ConstraintLayout constraintLayout3 = this.cellView;
                if (constraintLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cellView");
                }
                constraintLayout3.setBackgroundResource(0);
                FrameLayout frameLayout6 = this.backgroundSelectedCircle;
                if (frameLayout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backgroundSelectedCircle");
                }
                frameLayout6.setBackgroundResource(0);
                enableCell(false);
            }
            return view;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.santander.globile.uicomponents.text.SantanderTextView");
    }

    public int getCount() {
        return this.monthlyDates.size();
    }

    public Date getItem(int position) {
        return this.monthlyDates.get(position);
    }

    private final void enableCell(boolean enable) {
        if (enable) {
            SantanderTextView santanderTextView = this.textDate;
            if (santanderTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textDate");
            }
            santanderTextView.setAlpha(1.0f);
            ConstraintLayout constraintLayout = this.cellView;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cellView");
            }
            constraintLayout.setEnabled(true);
            return;
        }
        SantanderTextView santanderTextView2 = this.textDate;
        if (santanderTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textDate");
        }
        santanderTextView2.setAlpha(0.4f);
        ConstraintLayout constraintLayout2 = this.cellView;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cellView");
        }
        constraintLayout2.setEnabled(false);
    }

    private final int getFirstDayVisitble(int dayOfWeek) {
        if (this.calendarData.getFirstday().getValue() == 2) {
            switch (dayOfWeek) {
                case 1:
                    return -6;
                case 3:
                    return -1;
                case 4:
                    return -2;
                case 5:
                    return -3;
                case 6:
                    return -4;
                case 7:
                    return -5;
                default:
                    return 1;
            }
        } else {
            switch (dayOfWeek) {
                case 1:
                    return 0;
                case 2:
                    return -1;
                case 3:
                    return -2;
                case 4:
                    return -3;
                case 5:
                    return -4;
                case 6:
                    return -5;
                case 7:
                    return -6;
                default:
                    return 0;
            }
        }
    }

    private final Date getCurrentDate() {
        Date time = getDefaultCalendar().getTime();
        Intrinsics.checkExpressionValueIsNotNull(time, "cal.time");
        return time;
    }

    private final void printBackgroundDatesSelected(Calendar calendarStart, Calendar calendarEnd) {
        if (calendarStart != null && calendarEnd != null) {
            if (this.dateCal.get(6) == calendarStart.get(6) && this.dateCal.get(1) == calendarStart.get(1)) {
                LayerDrawable shape = (LayerDrawable) ContextCompat.getDrawable(getContext(), R.drawable.calendar_start_day_shape);
                if (shape == null) {
                    Intrinsics.throwNpe();
                }
                Drawable findDrawableByLayerId = shape.findDrawableByLayerId(R.id.dateShapeItem);
                Intrinsics.checkExpressionValueIsNotNull(findDrawableByLayerId, "shape.findDrawableByLayerId(R.id.dateShapeItem)");
                findDrawableByLayerId.setAlpha(100);
                Drawable findDrawableByLayerId2 = shape.findDrawableByLayerId(R.id.dateShapeItem);
                if (findDrawableByLayerId2 != null) {
                    Context context = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    ((GradientDrawable) findDrawableByLayerId2).setColor(CalendarUtilsKt.convertToDefaultColor(context, this.calendarData.getRangeSelectedColor().getValue()));
                    if (calendarStart.get(2) + 1 == this.mainCalendar.get(2)) {
                        FrameLayout frameLayout = this.shape_background_black_start;
                        if (frameLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("shape_background_black_start");
                        }
                        frameLayout.setBackground(shape);
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            } else if (this.dateCal.getTimeInMillis() > calendarStart.getTimeInMillis() && this.dateCal.getTimeInMillis() < calendarEnd.getTimeInMillis()) {
                LayerDrawable shape2 = (LayerDrawable) ContextCompat.getDrawable(getContext(), R.drawable.calendar_middle_day_shape);
                if (shape2 == null) {
                    Intrinsics.throwNpe();
                }
                Drawable findDrawableByLayerId3 = shape2.findDrawableByLayerId(R.id.dateShapeItem);
                Intrinsics.checkExpressionValueIsNotNull(findDrawableByLayerId3, "shape.findDrawableByLayerId(R.id.dateShapeItem)");
                findDrawableByLayerId3.setAlpha(100);
                Drawable findDrawableByLayerId4 = shape2.findDrawableByLayerId(R.id.dateShapeItem);
                if (findDrawableByLayerId4 != null) {
                    Context context2 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                    ((GradientDrawable) findDrawableByLayerId4).setColor(CalendarUtilsKt.convertToDefaultColor(context2, this.calendarData.getRangeSelectedColor().getValue()));
                    SantanderTextView santanderTextView = this.textDate;
                    if (santanderTextView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("textDate");
                    }
                    Context context3 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                    santanderTextView.setTextColor(CalendarUtilsKt.convertToDefaultColor(context3, this.calendarData.getRangedSelectedTextColor().getValue()));
                    if (calendarStart.get(2) + 1 == this.mainCalendar.get(2) || calendarEnd.get(2) + 1 == this.mainCalendar.get(2)) {
                        ConstraintLayout constraintLayout = this.cellView;
                        if (constraintLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("cellView");
                        }
                        constraintLayout.setBackground(shape2);
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            } else if (this.dateCal.get(6) == calendarEnd.get(6) && this.dateCal.get(1) == calendarEnd.get(1)) {
                LayerDrawable shape3 = (LayerDrawable) ContextCompat.getDrawable(getContext(), R.drawable.calendar_end_day_shape);
                if (shape3 == null) {
                    Intrinsics.throwNpe();
                }
                Drawable findDrawableByLayerId5 = shape3.findDrawableByLayerId(R.id.dateShapeItem);
                Intrinsics.checkExpressionValueIsNotNull(findDrawableByLayerId5, "shape.findDrawableByLayerId(R.id.dateShapeItem)");
                findDrawableByLayerId5.setAlpha(100);
                Drawable findDrawableByLayerId6 = shape3.findDrawableByLayerId(R.id.dateShapeItem);
                if (findDrawableByLayerId6 != null) {
                    Context context4 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context4, "context");
                    ((GradientDrawable) findDrawableByLayerId6).setColor(CalendarUtilsKt.convertToDefaultColor(context4, this.calendarData.getRangeSelectedColor().getValue()));
                    if (calendarEnd.get(2) + 1 == this.mainCalendar.get(2)) {
                        FrameLayout frameLayout2 = this.shape_background_black_end;
                        if (frameLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("shape_background_black_end");
                        }
                        frameLayout2.setBackground(shape3);
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
        }
    }

    private final void printSelectedDate(Calendar currentDate, Calendar calendarStart, Calendar calendarEnd) {
        if (calendarStart != null && this.dateCal.get(6) == calendarStart.get(6) && currentDate.get(2) == this.dateCal.get(2) && this.dateCal.get(1) == calendarStart.get(1)) {
            LayerDrawable shape = (LayerDrawable) ContextCompat.getDrawable(getContext(), R.drawable.calendar_selected_day_shape);
            if (shape == null) {
                Intrinsics.throwNpe();
            }
            Drawable findDrawableByLayerId = shape.findDrawableByLayerId(R.id.selectedDateShapeItem);
            if (findDrawableByLayerId != null) {
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                ((GradientDrawable) findDrawableByLayerId).setColor(CalendarUtilsKt.convertToDefaultColor(context, this.calendarData.getSelectedColor().getValue()));
                FrameLayout frameLayout = this.backgroundSelectedCircle;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backgroundSelectedCircle");
                }
                frameLayout.setBackground(shape);
                SantanderTextView santanderTextView = this.textDate;
                if (santanderTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textDate");
                }
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                santanderTextView.setTextColor(CalendarUtilsKt.convertToDefaultColor(context2, this.calendarData.getSelectedTextColor().getValue()));
                SantanderTextView santanderTextView2 = this.textDate;
                if (santanderTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textDate");
                }
                ViewCompat.setElevation((View) santanderTextView2, 5.0f);
                FrameLayout frameLayout2 = this.backgroundSelectedCircle;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backgroundSelectedCircle");
                }
                ViewCompat.setElevation(frameLayout2, 4.0f);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
        }
        if (calendarEnd != null && this.dateCal.get(6) == calendarEnd.get(6) && currentDate.get(2) == this.dateCal.get(2) && this.dateCal.get(1) == calendarEnd.get(1)) {
            LayerDrawable shape2 = (LayerDrawable) ContextCompat.getDrawable(getContext(), R.drawable.calendar_selected_day_shape);
            if (shape2 == null) {
                Intrinsics.throwNpe();
            }
            FrameLayout frameLayout3 = this.backgroundSelectedCircle;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backgroundSelectedCircle");
            }
            frameLayout3.setBackground(shape2);
            Drawable findDrawableByLayerId2 = shape2.findDrawableByLayerId(R.id.selectedDateShapeItem);
            if (findDrawableByLayerId2 != null) {
                Context context3 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                ((GradientDrawable) findDrawableByLayerId2).setColor(CalendarUtilsKt.convertToDefaultColor(context3, this.calendarData.getSelectedColor().getValue()));
                SantanderTextView santanderTextView3 = this.textDate;
                if (santanderTextView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textDate");
                }
                Context context4 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context4, "context");
                santanderTextView3.setTextColor(CalendarUtilsKt.convertToDefaultColor(context4, this.calendarData.getSelectedTextColor().getValue()));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
    }

    /* access modifiers changed from: private */
    public final Calendar getDefaultCalendar() {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        Calendar $this$apply = instance;
        $this$apply.set(10, 0);
        $this$apply.set(12, 0);
        $this$apply.set(13, 0);
        $this$apply.set(14, 0);
        Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance(Loc…MILLISECOND, 0)\n        }");
        return instance;
    }
}
