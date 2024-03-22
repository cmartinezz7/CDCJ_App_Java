package es.santander.justicia.minisJusticia;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import es.santander.justicia.utils.CommonUtils;

class MovementsSearchActivity$6 implements OnTouchListener {
   // $FF: synthetic field
   final MovementsSearchActivity this$0;

   MovementsSearchActivity$6(MovementsSearchActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onTouch(View v, MotionEvent event) {
      CommonUtils.hideKeyboard(MovementsSearchActivity.access$000(this.this$0));
      return false;
   }
}
