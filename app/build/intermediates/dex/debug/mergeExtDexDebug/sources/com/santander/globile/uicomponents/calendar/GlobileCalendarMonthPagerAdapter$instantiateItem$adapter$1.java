package com.santander.globile.uicomponents.calendar;

import com.santander.globile.uicomponents.calendar.listeners.GridChangeListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/santander/globile/uicomponents/calendar/GlobileCalendarMonthPagerAdapter$instantiateItem$adapter$1", "Lcom/santander/globile/uicomponents/calendar/listeners/GridChangeListener;", "gridChanged", "", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileCalendarMonthPagerAdapter.kt */
public final class GlobileCalendarMonthPagerAdapter$instantiateItem$adapter$1 implements GridChangeListener {
    final /* synthetic */ int $position;
    final /* synthetic */ GlobileCalendarMonthPagerAdapter this$0;

    GlobileCalendarMonthPagerAdapter$instantiateItem$adapter$1(GlobileCalendarMonthPagerAdapter $outer, int $captured_local_variable$1) {
        this.this$0 = $outer;
        this.$position = $captured_local_variable$1;
    }

    public void gridChanged() {
        this.this$0.tags.add(this.this$0.TAG_PREFIX + (this.$position + 1));
        this.this$0.tags.add(this.this$0.TAG_PREFIX + (this.$position - 1));
        this.this$0.notifyDataSetChanged();
    }
}
