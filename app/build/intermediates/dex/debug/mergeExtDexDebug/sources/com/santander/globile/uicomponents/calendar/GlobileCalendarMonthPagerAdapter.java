package com.santander.globile.uicomponents.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.viewpager.widget.PagerAdapter;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.calendar.listeners.DateSelectListener;
import com.santander.globile.uicomponents.calendar.utils.CalendarUtilsKt;
import com.santander.globile.uicomponents.text.SantanderTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/santander/globile/uicomponents/calendar/GlobileCalendarMonthPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "globileCalendarData", "Lcom/santander/globile/uicomponents/calendar/GlobileCalendarConfig;", "listener", "Lcom/santander/globile/uicomponents/calendar/listeners/DateSelectListener;", "(Landroid/content/Context;Lcom/santander/globile/uicomponents/calendar/GlobileCalendarConfig;Lcom/santander/globile/uicomponents/calendar/listeners/DateSelectListener;)V", "TAG_PREFIX", "", "tags", "Ljava/util/ArrayList;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getDayOfTheWeek", "weekDays", "Ljava/util/Calendar;", "getItemPosition", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileCalendarMonthPagerAdapter.kt */
public final class GlobileCalendarMonthPagerAdapter extends PagerAdapter {
    /* access modifiers changed from: private */
    public final String TAG_PREFIX = "SLY_CAL_TAG";
    private final Context context;
    private final GlobileCalendarConfig globileCalendarData;
    private final DateSelectListener listener;
    /* access modifiers changed from: private */
    public final ArrayList<String> tags = new ArrayList<>();

    public GlobileCalendarMonthPagerAdapter(Context context2, GlobileCalendarConfig globileCalendarData2, DateSelectListener listener2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(globileCalendarData2, "globileCalendarData");
        Intrinsics.checkParameterIsNotNull(listener2, "listener");
        this.context = context2;
        this.globileCalendarData = globileCalendarData2;
        this.listener = listener2;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        Intrinsics.checkParameterIsNotNull(object, "object");
        this.tags.remove(((View) object).getTag().toString());
        container.removeView((View) object);
    }

    public int getCount() {
        return Integer.MAX_VALUE;
    }

    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(object, "object");
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        ViewGroup viewGroup = container;
        int i = position;
        Intrinsics.checkParameterIsNotNull(viewGroup, "container");
        int indexShift = i - (getCount() / 2);
        View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout.calendar_calendar, viewGroup, false);
        if (inflate != null) {
            ViewGroup view = (ViewGroup) inflate;
            Context context2 = container.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "container.context");
            GlobileCalendarGridAdapter adapter = new GlobileCalendarGridAdapter(context2, this.globileCalendarData, indexShift, this.listener, new GlobileCalendarMonthPagerAdapter$instantiateItem$adapter$1(this, i));
            View findViewById = view.findViewById(R.id.calendarGrid);
            if (findViewById != null) {
                ((GridView) findViewById).setAdapter(adapter);
                view.findViewById(R.id.calendar_header).setBackgroundColor(CalendarUtilsKt.convertToDefaultColor(this.context, this.globileCalendarData.getHeaderColor().getValue()));
                Calendar currentDate = Calendar.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(currentDate, "currentDate");
                currentDate.setTime(this.globileCalendarData.getShowDate());
                currentDate.add(2, indexShift);
                SantanderTextView $this$apply = (SantanderTextView) view.findViewById(R.id.txtSelectedMonth);
                $this$apply.setText(new SimpleDateFormat("LLLL yyyy", Locale.getDefault()).format(currentDate.getTime()));
                Context context3 = $this$apply.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                $this$apply.setTextColor(CalendarUtilsKt.convertToDefaultColor(context3, this.globileCalendarData.getHeaderTextColor().getValue()));
                view.setTag(this.TAG_PREFIX + i);
                viewGroup.addView(view);
                Calendar weekDays = Calendar.getInstance();
                if (this.globileCalendarData.getFirstday().getValue() == 2) {
                    weekDays.set(7, 2);
                    SantanderTextView $this$apply2 = (SantanderTextView) view.findViewById(R.id.day1);
                    Intrinsics.checkExpressionValueIsNotNull(weekDays, "weekDays");
                    $this$apply2.setText(getDayOfTheWeek(weekDays));
                    Context context4 = $this$apply2.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context4, "context");
                    $this$apply2.setTextColor(CalendarUtilsKt.convertToDefaultColor(context4, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 3);
                    SantanderTextView $this$apply3 = (SantanderTextView) view.findViewById(R.id.day2);
                    $this$apply3.setText(getDayOfTheWeek(weekDays));
                    Context context5 = $this$apply3.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context5, "context");
                    $this$apply3.setTextColor(CalendarUtilsKt.convertToDefaultColor(context5, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 4);
                    SantanderTextView $this$apply4 = (SantanderTextView) view.findViewById(R.id.day3);
                    $this$apply4.setText(getDayOfTheWeek(weekDays));
                    Context context6 = $this$apply4.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context6, "context");
                    $this$apply4.setTextColor(CalendarUtilsKt.convertToDefaultColor(context6, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 5);
                    SantanderTextView $this$apply5 = (SantanderTextView) view.findViewById(R.id.day4);
                    $this$apply5.setText(getDayOfTheWeek(weekDays));
                    Context context7 = $this$apply5.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context7, "context");
                    $this$apply5.setTextColor(CalendarUtilsKt.convertToDefaultColor(context7, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 6);
                    SantanderTextView $this$apply6 = (SantanderTextView) view.findViewById(R.id.day5);
                    $this$apply6.setText(getDayOfTheWeek(weekDays));
                    Context context8 = $this$apply6.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context8, "context");
                    $this$apply6.setTextColor(CalendarUtilsKt.convertToDefaultColor(context8, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 7);
                    SantanderTextView $this$apply7 = (SantanderTextView) view.findViewById(R.id.day6);
                    $this$apply7.setText(getDayOfTheWeek(weekDays));
                    Context context9 = $this$apply7.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context9, "context");
                    $this$apply7.setTextColor(CalendarUtilsKt.convertToDefaultColor(context9, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 1);
                    SantanderTextView $this$apply8 = (SantanderTextView) view.findViewById(R.id.day7);
                    $this$apply8.setText(getDayOfTheWeek(weekDays));
                    Context context10 = $this$apply8.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context10, "context");
                    $this$apply8.setTextColor(CalendarUtilsKt.convertToDefaultColor(context10, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                } else {
                    weekDays.set(7, 1);
                    SantanderTextView $this$apply9 = (SantanderTextView) view.findViewById(R.id.day1);
                    Intrinsics.checkExpressionValueIsNotNull(weekDays, "weekDays");
                    $this$apply9.setText(getDayOfTheWeek(weekDays));
                    Context context11 = $this$apply9.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context11, "context");
                    $this$apply9.setTextColor(CalendarUtilsKt.convertToDefaultColor(context11, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 2);
                    SantanderTextView $this$apply10 = (SantanderTextView) view.findViewById(R.id.day2);
                    $this$apply10.setText(getDayOfTheWeek(weekDays));
                    Context context12 = $this$apply10.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context12, "context");
                    $this$apply10.setTextColor(CalendarUtilsKt.convertToDefaultColor(context12, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 3);
                    SantanderTextView $this$apply11 = (SantanderTextView) view.findViewById(R.id.day3);
                    $this$apply11.setText(getDayOfTheWeek(weekDays));
                    Context context13 = $this$apply11.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context13, "context");
                    $this$apply11.setTextColor(CalendarUtilsKt.convertToDefaultColor(context13, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 4);
                    SantanderTextView $this$apply12 = (SantanderTextView) view.findViewById(R.id.day4);
                    $this$apply12.setText(getDayOfTheWeek(weekDays));
                    Context context14 = $this$apply12.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context14, "context");
                    $this$apply12.setTextColor(CalendarUtilsKt.convertToDefaultColor(context14, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 5);
                    SantanderTextView $this$apply13 = (SantanderTextView) view.findViewById(R.id.day5);
                    $this$apply13.setText(getDayOfTheWeek(weekDays));
                    Context context15 = $this$apply13.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context15, "context");
                    $this$apply13.setTextColor(CalendarUtilsKt.convertToDefaultColor(context15, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 6);
                    SantanderTextView $this$apply14 = (SantanderTextView) view.findViewById(R.id.day6);
                    $this$apply14.setText(getDayOfTheWeek(weekDays));
                    Context context16 = $this$apply14.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context16, "context");
                    $this$apply14.setTextColor(CalendarUtilsKt.convertToDefaultColor(context16, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                    weekDays.set(7, 7);
                    SantanderTextView $this$apply15 = (SantanderTextView) view.findViewById(R.id.day7);
                    $this$apply15.setText(getDayOfTheWeek(weekDays));
                    Context context17 = $this$apply15.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context17, "context");
                    $this$apply15.setTextColor(CalendarUtilsKt.convertToDefaultColor(context17, this.globileCalendarData.getDayOfWeekTextColor().getValue()));
                }
                return view;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.GridView");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    private final String getDayOfTheWeek(Calendar weekDays) {
        StringBuilder sb = new StringBuilder();
        String format = new SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.getTime());
        Intrinsics.checkExpressionValueIsNotNull(format, "SimpleDateFormat(\"EE\", L…()).format(weekDays.time)");
        if (format != null) {
            String substring = format.substring(0, 1);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (substring != null) {
                String upperCase = substring.toUpperCase();
                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
                StringBuilder append = sb.append(upperCase);
                String format2 = new SimpleDateFormat("EE", Locale.getDefault()).format(weekDays.getTime());
                Intrinsics.checkExpressionValueIsNotNull(format2, "SimpleDateFormat(\n      …  ).format(weekDays.time)");
                if (format2 != null) {
                    String substring2 = format2.substring(1);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                    return append.append(substring2).toString();
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public int getItemPosition(Object object) {
        Intrinsics.checkParameterIsNotNull(object, "object");
        String tag = ((ViewGroup) object).getTag().toString();
        if (!this.tags.contains(tag)) {
            return -1;
        }
        this.tags.remove(tag);
        return -2;
    }
}
