package es.santander.justicia.minisJusticia.adapters;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.1;
import es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder;

class AdapterOpeEjectDetail$1$1 implements Runnable {
   // $FF: synthetic field
   final View val$view;
   // $FF: synthetic field
   final 1 this$1;

   AdapterOpeEjectDetail$1$1(1 this$1, View var2) {
      this.this$1 = this$1;
      this.val$view = var2;
   }

   public void run() {
      ViewHolder.access$600(this.this$1.val$holder).onTouch(ViewHolder.access$600(this.this$1.val$holder), MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, this.val$view.getX() + 1000.0F, this.val$view.getY(), 0));
      ViewHolder.access$600(this.this$1.val$holder).onTouch(ViewHolder.access$600(this.this$1.val$holder), MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, this.val$view.getX() + 1000.0F, this.val$view.getY(), 0));
   }
}
