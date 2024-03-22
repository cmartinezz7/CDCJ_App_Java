package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.view.View.OnClickListener;

class AdapterAdvices$1 implements OnClickListener {
   // $FF: synthetic field
   final int val$position;
   // $FF: synthetic field
   final AdapterAdvices this$0;

   AdapterAdvices$1(AdapterAdvices this$0, int var2) {
      this.this$0 = this$0;
      this.val$position = var2;
   }

   public void onClick(View view) {
      this.this$0.mListener.onItemClickListener(this.val$position);
   }
}
