package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

class ActivityLoginProfesionalesOld$4 implements OnClickListener {
   // $FF: synthetic field
   final ActivityLoginProfesionalesOld this$0;

   ActivityLoginProfesionalesOld$4(ActivityLoginProfesionalesOld this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      Bundle bundle = new Bundle();
      bundle.putBoolean("flag_ayuda", ActivityLoginProfesionalesOld.access$000(this.this$0));
      Intent intent = new Intent(this.this$0, ActivityHelp.class);
      intent.putExtras(bundle);
      this.this$0.startActivity(intent);
   }
}
