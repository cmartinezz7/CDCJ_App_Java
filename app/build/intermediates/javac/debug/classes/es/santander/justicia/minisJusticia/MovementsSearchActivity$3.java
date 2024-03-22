package es.santander.justicia.minisJusticia;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import es.santander.justicia.utils.DateUtils;

class MovementsSearchActivity$3 implements OnTouchListener {
   // $FF: synthetic field
   final MovementsSearchActivity this$0;

   MovementsSearchActivity$3(MovementsSearchActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onTouch(View v, MotionEvent event) {
      if (event.getAction() == 0) {
         DateUtils.getDateFromPicker(MovementsSearchActivity.access$000(this.this$0), MovementsSearchActivity.access$200(this.this$0));
      }

      return true;
   }
}
