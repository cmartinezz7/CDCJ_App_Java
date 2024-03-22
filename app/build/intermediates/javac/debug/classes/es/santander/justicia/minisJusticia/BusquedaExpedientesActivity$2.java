package es.santander.justicia.minisJusticia;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import es.santander.justicia.utils.DateUtils;

class BusquedaExpedientesActivity$2 implements OnTouchListener {
   // $FF: synthetic field
   final BusquedaExpedientesActivity this$0;

   BusquedaExpedientesActivity$2(BusquedaExpedientesActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onTouch(View v, MotionEvent event) {
      if (event.getAction() == 0) {
         DateUtils.getDateFromPicker(BusquedaExpedientesActivity.access$000(this.this$0), this.this$0.etDateTo);
      }

      return true;
   }
}
