package es.santander.justicia.minisJusticia.adapters;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures.2;

class AdapterExpaSeizures$2$1 implements Runnable {
   // $FF: synthetic field
   final View val$view;
   // $FF: synthetic field
   final 2 this$1;

   AdapterExpaSeizures$2$1(2 this$1, View var2) {
      this.this$1 = this$1;
      this.val$view = var2;
   }

   public void run() {
      this.this$1.val$parentViewHolder.mSwipeLayout.onTouch(this.this$1.val$parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, this.val$view.getX() + 1000.0F, this.val$view.getY(), 0));
      this.this$1.val$parentViewHolder.mSwipeLayout.onTouch(this.this$1.val$parentViewHolder.mSwipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, this.val$view.getX() + 1000.0F, this.val$view.getY(), 0));
   }
}
