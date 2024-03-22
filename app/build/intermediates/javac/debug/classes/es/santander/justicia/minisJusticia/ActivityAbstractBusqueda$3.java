package es.santander.justicia.minisJusticia;

import android.text.InputFilter;
import android.text.Spanned;

class ActivityAbstractBusqueda$3 implements InputFilter {
   // $FF: synthetic field
   final ActivityAbstractBusqueda this$0;

   ActivityAbstractBusqueda$3(ActivityAbstractBusqueda this$0) {
      this.this$0 = this$0;
   }

   public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) {
      for(int j = i; j < i1; ++j) {
         if (!Character.isLetterOrDigit(charSequence.charAt(j))) {
            return "";
         }
      }

      return null;
   }
}
