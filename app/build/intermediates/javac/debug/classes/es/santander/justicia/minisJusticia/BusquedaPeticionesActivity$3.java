package es.santander.justicia.minisJusticia;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import es.santander.justicia.utils.DateUtils;

class BusquedaPeticionesActivity$3 implements OnTouchListener {
   // $FF: synthetic field
   final BusquedaPeticionesActivity this$0;

   BusquedaPeticionesActivity$3(BusquedaPeticionesActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onTouch(View v, MotionEvent event) {
      if (event.getAction() == 0) {
         DateUtils.getDateFromPicker(BusquedaPeticionesActivity.access$000(this.this$0), this.this$0.etDateFrom);
      }

      return true;
   }
}
