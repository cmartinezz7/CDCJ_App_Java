package es.santander.justicia.minisJusticia;

import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.utils.CommonUtils;

class ActivityAbstractBusqueda$1 implements OnClickListener {
   // $FF: synthetic field
   final ActivityAbstractBusqueda this$0;

   ActivityAbstractBusqueda$1(ActivityAbstractBusqueda this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      CommonUtils.hideKeyboard(this.this$0);
   }
}
