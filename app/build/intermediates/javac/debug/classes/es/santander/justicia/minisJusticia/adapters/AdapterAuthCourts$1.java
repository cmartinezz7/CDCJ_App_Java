package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.view.View.OnClickListener;

class AdapterAuthCourts$1 implements OnClickListener {
   // $FF: synthetic field
   final int val$position;
   // $FF: synthetic field
   final AdapterAuthCourts this$0;

   AdapterAuthCourts$1(AdapterAuthCourts this$0, int var2) {
      this.this$0 = this$0;
      this.val$position = var2;
   }

   public void onClick(View view) {
      this.this$0.mListener.onItemClickListener(this.val$position);
   }
}
