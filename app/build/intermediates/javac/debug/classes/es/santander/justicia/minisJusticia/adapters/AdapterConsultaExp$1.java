package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.view.View.OnClickListener;

class AdapterConsultaExp$1 implements OnClickListener {
   // $FF: synthetic field
   final int val$position;
   // $FF: synthetic field
   final AdapterConsultaExp this$0;

   AdapterConsultaExp$1(AdapterConsultaExp this$0, int var2) {
      this.this$0 = this$0;
      this.val$position = var2;
   }

   public void onClick(View v) {
      if (AdapterConsultaExp.access$000(this.this$0) == -1) {
         AdapterConsultaExp.access$100(this.this$0).onItemClickListener(this.val$position, -1);
      } else {
         AdapterConsultaExp.access$100(this.this$0).onItemClickListener(this.val$position, AdapterConsultaExp.access$000(this.this$0) + 1);
      }

   }
}
