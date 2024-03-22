package es.santander.justicia.minisJusticia;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import es.santander.justicia.utils.CommonUtils;

class SolicitudAccesoActivity$13 implements OnTouchListener {
   // $FF: synthetic field
   final SolicitudAccesoActivity this$0;

   SolicitudAccesoActivity$13(SolicitudAccesoActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onTouch(View v, MotionEvent event) {
      CommonUtils.hideKeyboard(SolicitudAccesoActivity.access$000(this.this$0));
      return false;
   }
}
