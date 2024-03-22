package es.santander.justicia.minisJusticia.adapters;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.ViewHolder;
import es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail.1.1;

class AdapterOpeEjectDetail$1 implements OnClickListener {
   // $FF: synthetic field
   final ViewHolder val$holder;
   // $FF: synthetic field
   final AdapterOpeEjectDetail this$0;

   AdapterOpeEjectDetail$1(AdapterOpeEjectDetail this$0, ViewHolder var2) {
      this.this$0 = this$0;
      this.val$holder = var2;
   }

   public void onClick(View view) {
      ViewHolder.access$600(this.val$holder).onTouch(ViewHolder.access$600(this.val$holder), MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, view.getX(), view.getY(), 0));
      ViewHolder.access$600(this.val$holder).onTouch(ViewHolder.access$600(this.val$holder), MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, ViewHolder.access$600(this.val$holder).isExpanded() ? view.getX() + 1000.0F : view.getX() - 1000.0F, view.getY(), 0));
      ViewHolder.access$600(this.val$holder).requestFocus();
      if (!ViewHolder.access$600(this.val$holder).isExpanded()) {
         (new Handler()).postDelayed(new 1(this, view), 100L);
      }

   }
}
