package es.santander.justicia.minisJusticia;

import android.view.View;
import android.view.View.OnClickListener;

class ActivityAbstractBusqueda$5 implements OnClickListener {
   // $FF: synthetic field
   final ActivityAbstractBusqueda this$0;

   ActivityAbstractBusqueda$5(ActivityAbstractBusqueda this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View view) {
      if (view.isClickable()) {
         ActivityAbstractBusqueda.access$002(view.getId());
         this.this$0.showTimePickerDialog();
      }

   }
}
