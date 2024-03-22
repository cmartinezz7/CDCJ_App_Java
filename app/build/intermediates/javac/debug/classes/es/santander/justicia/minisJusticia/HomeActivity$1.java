package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class HomeActivity$1 implements OnClickListener {
   // $FF: synthetic field
   final HomeActivity this$0;

   HomeActivity$1(HomeActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View view) {
      Intent intent = new Intent(this.this$0, BusquedaExpedientesActivity.class);
      this.this$0.startActivityForResult(intent, 1002);
   }
}
