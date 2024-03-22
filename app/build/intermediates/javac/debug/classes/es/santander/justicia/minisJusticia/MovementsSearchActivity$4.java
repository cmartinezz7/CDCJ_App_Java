package es.santander.justicia.minisJusticia;

import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.utils.DateUtils;

class MovementsSearchActivity$4 implements OnClickListener {
   // $FF: synthetic field
   final MovementsSearchActivity this$0;

   MovementsSearchActivity$4(MovementsSearchActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      DateUtils.getDateFromPicker(MovementsSearchActivity.access$000(this.this$0), MovementsSearchActivity.access$100(this.this$0));
   }
}
