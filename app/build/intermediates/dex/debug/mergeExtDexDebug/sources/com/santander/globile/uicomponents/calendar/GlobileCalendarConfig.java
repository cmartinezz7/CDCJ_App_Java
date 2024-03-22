package com.santander.globile.uicomponents.calendar;

import com.santander.globile.uicomponents.calendar.utils.CalendarType;
import com.santander.globile.uicomponents.calendar.utils.DefaultColors;
import com.santander.globile.uicomponents.calendar.utils.FIRSTDAY;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001c\u00103\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\u001c\u00106\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R\u001a\u00109\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001e\u0010<\u001a\u0004\u0018\u00010\"8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010$\"\u0004\b>\u0010&R\u001a\u0010?\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\b¨\u0006B"}, d2 = {"Lcom/santander/globile/uicomponents/calendar/GlobileCalendarConfig;", "", "()V", "backgroundColor", "Lcom/santander/globile/uicomponents/calendar/utils/DefaultColors;", "getBackgroundColor", "()Lcom/santander/globile/uicomponents/calendar/utils/DefaultColors;", "setBackgroundColor", "(Lcom/santander/globile/uicomponents/calendar/utils/DefaultColors;)V", "calendarType", "Lcom/santander/globile/uicomponents/calendar/utils/CalendarType;", "getCalendarType", "()Lcom/santander/globile/uicomponents/calendar/utils/CalendarType;", "setCalendarType", "(Lcom/santander/globile/uicomponents/calendar/utils/CalendarType;)V", "dayOfWeekTextColor", "getDayOfWeekTextColor", "setDayOfWeekTextColor", "firstday", "Lcom/santander/globile/uicomponents/calendar/utils/FIRSTDAY;", "getFirstday", "()Lcom/santander/globile/uicomponents/calendar/utils/FIRSTDAY;", "setFirstday", "(Lcom/santander/globile/uicomponents/calendar/utils/FIRSTDAY;)V", "headerArrowsColor", "getHeaderArrowsColor", "setHeaderArrowsColor", "headerColor", "getHeaderColor", "setHeaderColor", "headerTextColor", "getHeaderTextColor", "setHeaderTextColor", "maxDate", "Ljava/util/Date;", "getMaxDate", "()Ljava/util/Date;", "setMaxDate", "(Ljava/util/Date;)V", "minDate", "getMinDate", "setMinDate", "rangeSelectedColor", "getRangeSelectedColor", "setRangeSelectedColor", "rangedSelectedTextColor", "getRangedSelectedTextColor", "setRangedSelectedTextColor", "selectedColor", "getSelectedColor", "setSelectedColor", "selectedEndDate", "getSelectedEndDate", "setSelectedEndDate", "selectedStartDate", "getSelectedStartDate", "setSelectedStartDate", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "showDate", "getShowDate", "setShowDate", "textColor", "getTextColor", "setTextColor", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileCalendarConfig.kt */
public final class GlobileCalendarConfig {
    private DefaultColors backgroundColor = DefaultColors.WHITE;
    private CalendarType calendarType = CalendarType.SINGLE_DAY;
    private DefaultColors dayOfWeekTextColor = DefaultColors.BOSTON_RED;
    private FIRSTDAY firstday = FIRSTDAY.MONDAY;
    private DefaultColors headerArrowsColor = DefaultColors.WHITE;
    private DefaultColors headerColor = DefaultColors.BOSTON_RED;
    private DefaultColors headerTextColor = DefaultColors.WHITE;
    private Date maxDate;
    private Date minDate;
    private DefaultColors rangeSelectedColor = DefaultColors.DARK_GREY;
    private DefaultColors rangedSelectedTextColor = DefaultColors.DARK_GREY;
    private DefaultColors selectedColor = DefaultColors.BOSTON_RED;
    private Date selectedEndDate;
    private Date selectedStartDate;
    private DefaultColors selectedTextColor = DefaultColors.WHITE;
    private Date showDate;
    private DefaultColors textColor = DefaultColors.DARK_GREY;

    public final void setShowDate(Date date) {
        this.showDate = date;
    }

    public final Date getShowDate() {
        if (this.showDate == null) {
            Date date = this.selectedStartDate;
            if (date != null) {
                if (date == null) {
                    Intrinsics.throwNpe();
                }
                Object clone = date.clone();
                if (clone != null) {
                    this.showDate = (Date) clone;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.util.Date");
                }
            } else {
                Calendar instance = Calendar.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
                this.showDate = instance.getTime();
            }
        }
        return this.showDate;
    }

    public final Date getSelectedStartDate() {
        return this.selectedStartDate;
    }

    public final void setSelectedStartDate(Date date) {
        this.selectedStartDate = date;
    }

    public final Date getSelectedEndDate() {
        return this.selectedEndDate;
    }

    public final void setSelectedEndDate(Date date) {
        this.selectedEndDate = date;
    }

    public final Date getMinDate() {
        return this.minDate;
    }

    public final void setMinDate(Date date) {
        this.minDate = date;
    }

    public final Date getMaxDate() {
        return this.maxDate;
    }

    public final void setMaxDate(Date date) {
        this.maxDate = date;
    }

    public final FIRSTDAY getFirstday() {
        return this.firstday;
    }

    public final void setFirstday(FIRSTDAY firstday2) {
        Intrinsics.checkParameterIsNotNull(firstday2, "<set-?>");
        this.firstday = firstday2;
    }

    public final CalendarType getCalendarType() {
        return this.calendarType;
    }

    public final void setCalendarType(CalendarType calendarType2) {
        Intrinsics.checkParameterIsNotNull(calendarType2, "<set-?>");
        this.calendarType = calendarType2;
    }

    public final DefaultColors getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(DefaultColors defaultColors) {
        Intrinsics.checkParameterIsNotNull(defaultColors, "<set-?>");
        this.backgroundColor = defaultColors;
    }

    public final DefaultColors getHeaderColor() {
        return this.headerColor;
    }

    public final void setHeaderColor(DefaultColors defaultColors) {
        Intrinsics.checkParameterIsNotNull(defaultColors, "<set-?>");
        this.headerColor = defaultColors;
    }

    public final DefaultColors getHeaderTextColor() {
        return this.headerTextColor;
    }

    public final void setHeaderTextColor(DefaultColors defaultColors) {
        Intrinsics.checkParameterIsNotNull(defaultColors, "<set-?>");
        this.headerTextColor = defaultColors;
    }

    public final DefaultColors getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(DefaultColors defaultColors) {
        Intrinsics.checkParameterIsNotNull(defaultColors, "<set-?>");
        this.textColor = defaultColors;
    }

    public final DefaultColors getSelectedColor() {
        return this.selectedColor;
    }

    public final void setSelectedColor(DefaultColors defaultColors) {
        Intrinsics.checkParameterIsNotNull(defaultColors, "<set-?>");
        this.selectedColor = defaultColors;
    }

    public final DefaultColors getDayOfWeekTextColor() {
        return this.dayOfWeekTextColor;
    }

    public final void setDayOfWeekTextColor(DefaultColors defaultColors) {
        Intrinsics.checkParameterIsNotNull(defaultColors, "<set-?>");
        this.dayOfWeekTextColor = defaultColors;
    }

    public final DefaultColors getSelectedTextColor() {
        return this.selectedTextColor;
    }

    public final void setSelectedTextColor(DefaultColors defaultColors) {
        Intrinsics.checkParameterIsNotNull(defaultColors, "<set-?>");
        this.selectedTextColor = defaultColors;
    }

    public final DefaultColors getHeaderArrowsColor() {
        return this.headerArrowsColor;
    }

    public final void setHeaderArrowsColor(DefaultColors defaultColors) {
        Intrinsics.checkParameterIsNotNull(defaultColors, "<set-?>");
        this.headerArrowsColor = defaultColors;
    }

    public final DefaultColors getRangeSelectedColor() {
        return this.rangeSelectedColor;
    }

    public final void setRangeSelectedColor(DefaultColors defaultColors) {
        Intrinsics.checkParameterIsNotNull(defaultColors, "<set-?>");
        this.rangeSelectedColor = defaultColors;
    }

    public final DefaultColors getRangedSelectedTextColor() {
        return this.rangedSelectedTextColor;
    }

    public final void setRangedSelectedTextColor(DefaultColors defaultColors) {
        Intrinsics.checkParameterIsNotNull(defaultColors, "<set-?>");
        this.rangedSelectedTextColor = defaultColors;
    }
}
