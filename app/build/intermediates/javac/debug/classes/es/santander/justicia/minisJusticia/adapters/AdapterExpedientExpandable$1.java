package es.santander.justicia.minisJusticia.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.ActivityListaMovimientos;

class AdapterExpedientExpandable$1 implements OnClickListener {
   // $FF: synthetic field
   final int val$groupPosition;
   // $FF: synthetic field
   final AdapterExpedientExpandable this$0;

   AdapterExpedientExpandable$1(AdapterExpedientExpandable this$0, int var2) {
      this.this$0 = this$0;
      this.val$groupPosition = var2;
   }

   public void onClick(View v) {
      Bundle bundle = new Bundle();
      Intent intent = new Intent(AdapterExpedientExpandable.access$1100(this.this$0), ActivityListaMovimientos.class);
      bundle.putStringArrayList("spinnerData", AdapterExpedientExpandable.access$1200(this.this$0));
      bundle.putInt("itemPositionSelected", this.val$groupPosition);
      bundle.putString("expedientNumber", AdapterExpedientExpandable.access$1300(this.this$0));
      bundle.putStringArrayList("spinnerData", AdapterExpedientExpandable.access$1200(this.this$0));
      intent.putExtras(bundle);
      AdapterExpedientExpandable.access$1100(this.this$0).startActivity(intent);
   }
}
