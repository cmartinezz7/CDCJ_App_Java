package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class LoginProfesionalesActivity$4 implements OnClickListener {
   // $FF: synthetic field
   final LoginProfesionalesActivity this$0;

   LoginProfesionalesActivity$4(LoginProfesionalesActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      Bundle bundle = new Bundle();
      bundle.putBoolean("flag_ayuda", LoginProfesionalesActivity.access$000(this.this$0));
      Intent intent = new Intent(this.this$0, ActivityHelp.class);
      intent.putExtras(bundle);
      this.this$0.startActivity(intent);
   }
}
