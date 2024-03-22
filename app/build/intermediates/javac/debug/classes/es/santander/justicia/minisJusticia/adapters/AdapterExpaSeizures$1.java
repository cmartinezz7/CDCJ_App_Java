package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.view.View.OnClickListener;

class AdapterExpaSeizures$1 implements OnClickListener {
   // $FF: synthetic field
   final int val$parentPosition;
   // $FF: synthetic field
   final AdapterExpaSeizures this$0;

   AdapterExpaSeizures$1(AdapterExpaSeizures this$0, int var2) {
      this.this$0 = this$0;
      this.val$parentPosition = var2;
   }

   public void onClick(View view) {
      this.this$0.collapseAllParents();
      if (AdapterExpaSeizures.access$000(this.this$0) != this.val$parentPosition) {
         AdapterExpaSeizures.access$002(this.this$0, this.val$parentPosition);
         this.this$0.expandParent(this.val$parentPosition);
         this.this$0.notifyDataSetChanged();
      } else {
         AdapterExpaSeizures.access$002(this.this$0, -1);
         this.this$0.notifyDataSetChanged();
      }

   }
}
