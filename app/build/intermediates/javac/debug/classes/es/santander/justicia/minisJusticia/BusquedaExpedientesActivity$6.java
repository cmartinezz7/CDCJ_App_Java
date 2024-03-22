package es.santander.justicia.minisJusticia;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import es.santander.justicia.utils.CommonUtils;

class BusquedaExpedientesActivity$6 implements OnTouchListener {
   // $FF: synthetic field
   final BusquedaExpedientesActivity this$0;

   BusquedaExpedientesActivity$6(BusquedaExpedientesActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onTouch(View v, MotionEvent event) {
      CommonUtils.hideKeyboard(BusquedaExpedientesActivity.access$000(this.this$0));
      return false;
   }
}
