package es.santander.justicia.minisJusticia;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class LoginProfesionalesActivity$10 implements OnCheckedChangeListener {
   // $FF: synthetic field
   final LoginProfesionalesActivity this$0;

   LoginProfesionalesActivity$10(LoginProfesionalesActivity this$0) {
      this.this$0 = this$0;
   }

   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
      if (!isChecked) {
         LoginProfesionalesActivity.access$800(this.this$0);
         LoginProfesionalesActivity.access$902(this.this$0, false);
      } else {
         LoginProfesionalesActivity.access$902(this.this$0, true);
      }

   }
}
