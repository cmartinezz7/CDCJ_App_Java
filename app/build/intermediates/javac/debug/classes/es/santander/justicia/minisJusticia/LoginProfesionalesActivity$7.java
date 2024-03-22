package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class LoginProfesionalesActivity$7 implements OnClickListener {
   // $FF: synthetic field
   final LoginProfesionalesActivity this$0;

   LoginProfesionalesActivity$7(LoginProfesionalesActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      Intent intent = new Intent(this.this$0, NewsActivity.class);
      this.this$0.startActivity(intent);
      this.this$0.finish();
   }
}
