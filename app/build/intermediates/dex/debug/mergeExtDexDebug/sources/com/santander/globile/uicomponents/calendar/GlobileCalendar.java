package com.santander.globile.uicomponents.calendar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.widget.ImageViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.calendar.listeners.CalendarSelectedDayListener;
import com.santander.globile.uicomponents.calendar.listeners.DateSelectListener;
import com.santander.globile.uicomponents.calendar.utils.CalendarType;
import com.santander.globile.uicomponents.calendar.utils.CalendarUtilsKt;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/santander/globile/uicomponents/calendar/GlobileCalendar;", "Landroid/widget/FrameLayout;", "Lcom/santander/globile/uicomponents/calendar/listeners/DateSelectListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnMonthNext", "Landroid/widget/ImageView;", "btnMonthPrev", "globileCalendarData", "Lcom/santander/globile/uicomponents/calendar/GlobileCalendarConfig;", "listener", "Lcom/santander/globile/uicomponents/calendar/listeners/CalendarSelectedDayListener;", "mainFrameLayout", "Landroid/view/View;", "viewPager", "Lcom/santander/globile/uicomponents/calendar/CustomViewPager;", "dateSelect", "", "selectedDate", "Ljava/util/Date;", "init", "initCustomView", "paintCalendar", "retrieveDates", "showCalendar", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileCalendar.kt */
public final class GlobileCalendar extends FrameLayout implements DateSelectListener {
    private HashMap _$_findViewCache;
    private ImageView btnMonthNext;
    private ImageView btnMonthPrev;
    private GlobileCalendarConfig globileCalendarData;
    private CalendarSelectedDayListener listener;
    private View mainFrameLayout;
    /* access modifiers changed from: private */
    public CustomViewPager viewPager;

    public GlobileCalendar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileCalendar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileCalendar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.globileCalendarData = new GlobileCalendarConfig();
    }

    public static final /* synthetic */ CustomViewPager access$getViewPager$p(GlobileCalendar $this) {
        CustomViewPager customViewPager = $this.viewPager;
        if (customViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return customViewPager;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileCalendar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void init(GlobileCalendarConfig globileCalendarData2, CalendarSelectedDayListener listener2) {
        Intrinsics.checkParameterIsNotNull(globileCalendarData2, "globileCalendarData");
        Intrinsics.checkParameterIsNotNull(listener2, "listener");
        this.globileCalendarData = globileCalendarData2;
        this.listener = listener2;
        initCustomView();
        showCalendar();
    }

    private final void initCustomView() {
        View.inflate(getContext(), R.layout.calendar_frame, this);
        View findViewById = findViewById(R.id.mainFrame);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.mainFrame)");
        this.mainFrameLayout = findViewById;
        View findViewById2 = findViewById(R.id.btnMonthPrev);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById<ImageView>(R.id.btnMonthPrev)");
        this.btnMonthPrev = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.btnMonthNext);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById<ImageView>(R.id.btnMonthNext)");
        this.btnMonthNext = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.content);
        Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.content)");
        this.viewPager = (CustomViewPager) findViewById4;
        ImageView imageView = this.btnMonthPrev;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMonthPrev");
        }
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(CalendarUtilsKt.convertToDefaultColor(context, this.globileCalendarData.getHeaderArrowsColor().getValue())));
        ImageView imageView2 = this.btnMonthNext;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMonthNext");
        }
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        ImageViewCompat.setImageTintList(imageView2, ColorStateList.valueOf(CalendarUtilsKt.convertToDefaultColor(context2, this.globileCalendarData.getHeaderArrowsColor().getValue())));
        CustomViewPager vpager = (CustomViewPager) findViewById(R.id.content);
        Intrinsics.checkExpressionValueIsNotNull(vpager, "vpager");
        Context context3 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context3, "context");
        vpager.setAdapter(new GlobileCalendarMonthPagerAdapter(context3, this.globileCalendarData, this));
        PagerAdapter adapter = vpager.getAdapter();
        if (adapter == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(adapter, "vpager.adapter!!");
        vpager.setCurrentItem(adapter.getCount() / 2);
        showCalendar();
    }

    private final void showCalendar() {
        paintCalendar();
        Calendar calendarStart = Calendar.getInstance();
        if (this.globileCalendarData.getSelectedStartDate() != null) {
            Intrinsics.checkExpressionValueIsNotNull(calendarStart, "calendarStart");
            Date selectedStartDate = this.globileCalendarData.getSelectedStartDate();
            if (selectedStartDate == null) {
                Intrinsics.throwNpe();
            }
            calendarStart.setTime(selectedStartDate);
        } else {
            Intrinsics.checkExpressionValueIsNotNull(calendarStart, "calendarStart");
            Date showDate = this.globileCalendarData.getShowDate();
            if (showDate == null) {
                Intrinsics.throwNpe();
            }
            calendarStart.setTime(showDate);
        }
        if (this.globileCalendarData.getSelectedEndDate() != null) {
            Calendar calendarEnd = Calendar.getInstance();
            if (calendarEnd == null) {
                Intrinsics.throwNpe();
            }
            Date selectedEndDate = this.globileCalendarData.getSelectedEndDate();
            if (selectedEndDate == null) {
                Intrinsics.throwNpe();
            }
            calendarEnd.setTime(selectedEndDate);
        }
        ImageView imageView = this.btnMonthPrev;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMonthPrev");
        }
        imageView.setOnClickListener(new GlobileCalendar$showCalendar$1(this));
        ImageView imageView2 = this.btnMonthNext;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnMonthNext");
        }
        imageView2.setOnClickListener(new GlobileCalendar$showCalendar$2(this));
        CustomViewPager customViewPager = this.viewPager;
        if (customViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        PagerAdapter adapter = customViewPager.getAdapter();
        if (adapter == null) {
            Intrinsics.throwNpe();
        }
        adapter.notifyDataSetChanged();
        CustomViewPager customViewPager2 = this.viewPager;
        if (customViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        customViewPager2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        CustomViewPager customViewPager3 = this.viewPager;
        if (customViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        customViewPager3.invalidate();
    }

    public void dateSelect(Date selectedDate) {
        Intrinsics.checkParameterIsNotNull(selectedDate, "selectedDate");
        if (this.globileCalendarData.getSelectedStartDate() == null || this.globileCalendarData.getCalendarType() == CalendarType.SINGLE_DAY) {
            this.globileCalendarData.setSelectedStartDate(selectedDate);
            showCalendar();
            retrieveDates();
            return;
        }
        if (this.globileCalendarData.getSelectedEndDate() == null) {
            long time = selectedDate.getTime();
            Date selectedStartDate = this.globileCalendarData.getSelectedStartDate();
            if (selectedStartDate == null) {
                Intrinsics.throwNpe();
            }
            if (time < selectedStartDate.getTime()) {
                GlobileCalendarConfig globileCalendarConfig = this.globileCalendarData;
                globileCalendarConfig.setSelectedEndDate(globileCalendarConfig.getSelectedStartDate());
                this.globileCalendarData.setSelectedStartDate(selectedDate);
                showCalendar();
                retrieveDates();
                return;
            }
            long time2 = selectedDate.getTime();
            Date selectedStartDate2 = this.globileCalendarData.getSelectedStartDate();
            if (selectedStartDate2 == null) {
                Intrinsics.throwNpe();
            }
            if (time2 == selectedStartDate2.getTime()) {
                this.globileCalendarData.setSelectedEndDate((Date) null);
                this.globileCalendarData.setSelectedStartDate(selectedDate);
                showCalendar();
                retrieveDates();
                return;
            }
            long time3 = selectedDate.getTime();
            Date selectedStartDate3 = this.globileCalendarData.getSelectedStartDate();
            if (selectedStartDate3 == null) {
                Intrinsics.throwNpe();
            }
            if (time3 > selectedStartDate3.getTime()) {
                this.globileCalendarData.setSelectedEndDate(selectedDate);
                showCalendar();
                retrieveDates();
                return;
            }
        }
        if (this.globileCalendarData.getSelectedEndDate() != null) {
            this.globileCalendarData.setSelectedEndDate((Date) null);
            this.globileCalendarData.setSelectedStartDate(selectedDate);
            showCalendar();
        }
    }

    private final void retrieveDates() {
        if (this.globileCalendarData.getCalendarType() == CalendarType.SINGLE_DAY) {
            if (this.globileCalendarData.getSelectedStartDate() != null) {
                CalendarSelectedDayListener calendarSelectedDayListener = this.listener;
                if (calendarSelectedDayListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listener");
                }
                calendarSelectedDayListener.onDaysSelected(this.globileCalendarData.getSelectedStartDate(), (Date) null);
            }
        } else if (this.globileCalendarData.getSelectedStartDate() != null && this.globileCalendarData.getSelectedEndDate() != null) {
            CalendarSelectedDayListener calendarSelectedDayListener2 = this.listener;
            if (calendarSelectedDayListener2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listener");
            }
            calendarSelectedDayListener2.onDaysSelected(this.globileCalendarData.getSelectedStartDate(), this.globileCalendarData.getSelectedEndDate());
        }
    }

    private final void paintCalendar() {
        View view = this.mainFrameLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainFrameLayout");
        }
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        view.setBackgroundColor(CalendarUtilsKt.convertToDefaultColor(context, this.globileCalendarData.getBackgroundColor().getValue()));
    }
}
