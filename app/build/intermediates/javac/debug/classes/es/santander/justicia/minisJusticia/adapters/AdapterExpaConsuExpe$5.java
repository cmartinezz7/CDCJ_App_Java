package es.santander.justicia.minisJusticia.adapters;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;

class AdapterExpaConsuExpe$5 implements OnClickListener {
   // $FF: synthetic field
   final ExpedienteConsultaParenViewHolder val$parentViewHolder;
   // $FF: synthetic field
   final AdapterExpaConsuExpe this$0;

   AdapterExpaConsuExpe$5(AdapterExpaConsuExpe this$0, ExpedienteConsultaParenViewHolder var2) {
      this.this$0 = this$0;
      this.val$parentViewHolder = var2;
   }

   public void onClick(View view) {
      this.val$parentViewHolder.mSwipeLayout.onTouch(this.val$parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, view.getX(), view.getY(), 0));
      this.val$parentViewHolder.mSwipeLayout.onTouch(this.val$parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, this.val$parentViewHolder.mSwipeLayout.isExpanded() ? view.getX() + 1000.0F : view.getX() - 1000.0F, view.getY(), 0));
   }
}
