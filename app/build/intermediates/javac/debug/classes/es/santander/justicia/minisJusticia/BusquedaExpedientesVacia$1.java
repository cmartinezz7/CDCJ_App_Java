package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class BusquedaExpedientesVacia$1 implements OnClickListener {
   // $FF: synthetic field
   final BusquedaExpedientesVacia this$0;

   BusquedaExpedientesVacia$1(BusquedaExpedientesVacia this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      this.this$0.finish();
      Intent intent = new Intent(this.this$0, BusquedaExpedientesActivity.class);
      this.this$0.startActivity(intent);
   }
}
