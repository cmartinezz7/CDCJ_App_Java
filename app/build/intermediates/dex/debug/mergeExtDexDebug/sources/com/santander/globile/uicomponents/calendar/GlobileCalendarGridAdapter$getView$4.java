package com.santander.globile.uicomponents.calendar;

import android.view.View;
import com.santander.globile.uicomponents.calendar.listeners.DateSelectListener;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 15})
/* compiled from: GlobileCalendarGridAdapter.kt */
final class GlobileCalendarGridAdapter$getView$4 implements View.OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ GlobileCalendarGridAdapter this$0;

    GlobileCalendarGridAdapter$getView$4(GlobileCalendarGridAdapter globileCalendarGridAdapter, int i) {
        this.this$0 = globileCalendarGridAdapter;
        this.$position = i;
    }

    public final void onClick(View it) {
        Calendar selectedDate = this.this$0.getDefaultCalendar();
        selectedDate.setTime((Date) this.this$0.monthlyDates.get(this.$position));
        DateSelectListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            Date time = selectedDate.getTime();
            Intrinsics.checkExpressionValueIsNotNull(time, "selectedDate.time");
            access$getListener$p.dateSelect(time);
        }
        this.this$0.notifyDataSetChanged();
        this.this$0.gridListener.gridChanged();
    }
}
