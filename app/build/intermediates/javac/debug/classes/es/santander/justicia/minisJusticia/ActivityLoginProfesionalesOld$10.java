package es.santander.justicia.minisJusticia;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class ActivityLoginProfesionalesOld$10 implements OnCheckedChangeListener {
   // $FF: synthetic field
   final ActivityLoginProfesionalesOld this$0;

   ActivityLoginProfesionalesOld$10(ActivityLoginProfesionalesOld this$0) {
      this.this$0 = this$0;
   }

   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
      if (!isChecked) {
         ActivityLoginProfesionalesOld.access$800(this.this$0);
         ActivityLoginProfesionalesOld.access$902(this.this$0, false);
      } else {
         ActivityLoginProfesionalesOld.access$902(this.this$0, true);
      }

   }
}
