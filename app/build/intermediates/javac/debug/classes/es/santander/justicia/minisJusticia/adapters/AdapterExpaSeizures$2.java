package es.santander.justicia.minisJusticia.adapters;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures.2.1;

class AdapterExpaSeizures$2 implements OnClickListener {
   // $FF: synthetic field
   final SeizureParentViewHolder val$parentViewHolder;
   // $FF: synthetic field
   final AdapterExpaSeizures this$0;

   AdapterExpaSeizures$2(AdapterExpaSeizures this$0, SeizureParentViewHolder var2) {
      this.this$0 = this$0;
      this.val$parentViewHolder = var2;
   }

   public void onClick(View view) {
      this.val$parentViewHolder.mSwipeLayout.onTouch(this.val$parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, view.getX(), view.getY(), 0));
      this.val$parentViewHolder.mSwipeLayout.onTouch(this.val$parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, this.val$parentViewHolder.mSwipeLayout.isExpanded() ? view.getX() + 1000.0F : view.getX() - 1000.0F, view.getY(), 0));
      if (!this.val$parentViewHolder.mSwipeLayout.isExpanded()) {
         (new Handler()).postDelayed(new 1(this, view), 100L);
      }

   }
}
