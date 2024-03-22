package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class ActivityListaMovimientos$1 implements OnClickListener {
   // $FF: synthetic field
   final ActivityListaMovimientos this$0;

   ActivityListaMovimientos$1(ActivityListaMovimientos this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View view) {
      Intent intent = new Intent(this.this$0, MovementsSearchActivity.class);
      this.this$0.startActivityForResult(intent, 1000);
   }
}
