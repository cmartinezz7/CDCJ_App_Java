package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ListadoPeticionesActivity$1 implements OnClickListener {
   // $FF: synthetic field
   final ListadoPeticionesActivity this$0;

   ListadoPeticionesActivity$1(ListadoPeticionesActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View view) {
      Intent intent = new Intent(this.this$0, BusquedaPeticionesActivity.class);
      this.this$0.startActivityForResult(intent, 1001);
   }
}
