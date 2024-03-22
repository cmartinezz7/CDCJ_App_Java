package es.santander.justicia.minisJusticia;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import es.santander.justicia.utils.DateUtils;

class MovementsSearchActivity$2 implements OnTouchListener {
   // $FF: synthetic field
   final MovementsSearchActivity this$0;

   MovementsSearchActivity$2(MovementsSearchActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onTouch(View v, MotionEvent event) {
      if (event.getAction() == 0) {
         DateUtils.getDateFromPicker(MovementsSearchActivity.access$000(this.this$0), MovementsSearchActivity.access$100(this.this$0));
      }

      return true;
   }
}
