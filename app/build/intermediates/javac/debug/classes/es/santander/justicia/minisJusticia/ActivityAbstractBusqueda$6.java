package es.santander.justicia.minisJusticia;

import android.text.Editable;
import android.text.TextWatcher;

class ActivityAbstractBusqueda$6 implements TextWatcher {
   // $FF: synthetic field
   final ActivityAbstractBusqueda this$0;

   ActivityAbstractBusqueda$6(ActivityAbstractBusqueda this$0) {
      this.this$0 = this$0;
   }

   public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
   }

   public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
   }

   public void afterTextChanged(Editable editable) {
      int chars = editable.length();
      if (chars > 1 && this.this$0.findViewById(16908290).getRootView() != null) {
         switch(this.this$0.findViewById(16908290).getRootView().getId()) {
         case 2131362149:
         case 2131362151:
         case 2131362887:
            if (chars == 4) {
               ActivityAbstractBusqueda.access$100(this.this$0, this.this$0.findViewById(16908290).getRootView().getId());
            }
            break;
         case 2131362150:
         case 2131362152:
            if (chars == 2) {
               ActivityAbstractBusqueda.access$100(this.this$0, this.this$0.findViewById(16908290).getRootView().getId());
            }
         }
      }

   }
}
