package es.santander.justicia.minisJusticia;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import es.santander.justicia.utils.CommonUtils;

class ActivityLoginProfesionalesOld$14 implements OnTouchListener {
   // $FF: synthetic field
   final ActivityLoginProfesionalesOld this$0;

   ActivityLoginProfesionalesOld$14(ActivityLoginProfesionalesOld this$0) {
      this.this$0 = this$0;
   }

   public boolean onTouch(View v, MotionEvent event) {
      CommonUtils.hideKeyboard(ActivityLoginProfesionalesOld.access$1100(this.this$0));
      return false;
   }
}
