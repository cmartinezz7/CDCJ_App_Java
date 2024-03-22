package es.santander.justicia.minisJusticia;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class ActivityLoginLetrados$4 implements OnCheckedChangeListener {
   // $FF: synthetic field
   final ActivityLoginLetrados this$0;

   ActivityLoginLetrados$4(ActivityLoginLetrados this$0) {
      this.this$0 = this$0;
   }

   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
      if (!isChecked) {
         ActivityLoginLetrados.access$000(this.this$0).clear();
      }

   }
}
