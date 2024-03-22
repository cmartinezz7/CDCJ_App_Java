package es.santander.justicia.minisJusticia.adapters;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterConsultaExp.ViewHolder;

class AdapterConsultaExp$2 implements OnClickListener {
   // $FF: synthetic field
   final ViewHolder val$holder;
   // $FF: synthetic field
   final AdapterConsultaExp this$0;

   AdapterConsultaExp$2(AdapterConsultaExp this$0, ViewHolder var2) {
      this.this$0 = this$0;
      this.val$holder = var2;
   }

   public void onClick(View view) {
      this.val$holder.mSwipeLayout.onTouch(this.val$holder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, view.getX(), view.getY(), 0));
      this.val$holder.mSwipeLayout.onTouch(this.val$holder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, this.val$holder.mSwipeLayout.isExpanded() ? view.getX() + 1000.0F : view.getX() - 1000.0F, view.getY(), 0));
   }
}
