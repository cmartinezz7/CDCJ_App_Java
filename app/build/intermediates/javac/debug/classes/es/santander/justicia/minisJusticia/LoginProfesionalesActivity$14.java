package es.santander.justicia.minisJusticia;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import es.santander.justicia.utils.CommonUtils;

class LoginProfesionalesActivity$14 implements OnTouchListener {
   // $FF: synthetic field
   final LoginProfesionalesActivity this$0;

   LoginProfesionalesActivity$14(LoginProfesionalesActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onTouch(View v, MotionEvent event) {
      CommonUtils.hideKeyboard(LoginProfesionalesActivity.access$1100(this.this$0));
      return false;
   }
}
