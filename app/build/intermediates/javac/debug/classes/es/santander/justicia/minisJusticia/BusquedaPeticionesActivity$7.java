package es.santander.justicia.minisJusticia;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import es.santander.justicia.utils.CommonUtils;

class BusquedaPeticionesActivity$7 implements OnTouchListener {
   // $FF: synthetic field
   final BusquedaPeticionesActivity this$0;

   BusquedaPeticionesActivity$7(BusquedaPeticionesActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onTouch(View v, MotionEvent event) {
      CommonUtils.hideKeyboard(BusquedaPeticionesActivity.access$000(this.this$0));
      return false;
   }
}
