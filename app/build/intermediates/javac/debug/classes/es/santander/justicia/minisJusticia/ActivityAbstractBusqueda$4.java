package es.santander.justicia.minisJusticia;

import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.DateUtils;

class ActivityAbstractBusqueda$4 implements OnClickListener {
   // $FF: synthetic field
   final ActivityAbstractBusqueda this$0;

   ActivityAbstractBusqueda$4(ActivityAbstractBusqueda this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View view) {
      if (DateUtils.dateToHigherThanFrom(ActivityAbstractBusqueda.mTextDateFrom.getText().toString(), ActivityAbstractBusqueda.mTextDateTo.getText().toString())) {
         this.this$0.buscarClick();
      } else {
         CommonUtils.showAlertMessage(this.this$0, this.this$0.getString(2131886460));
      }

   }
}
