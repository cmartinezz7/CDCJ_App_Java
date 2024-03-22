package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class BusquedaMovimientosVaciaDesdeBuscador$2 implements OnClickListener {
   // $FF: synthetic field
   final BusquedaMovimientosVaciaDesdeBuscador this$0;

   BusquedaMovimientosVaciaDesdeBuscador$2(BusquedaMovimientosVaciaDesdeBuscador this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      this.this$0.finish();
      Intent intent = new Intent(this.this$0, MovementsSearchActivity.class);
      this.this$0.startActivity(intent);
   }
}
