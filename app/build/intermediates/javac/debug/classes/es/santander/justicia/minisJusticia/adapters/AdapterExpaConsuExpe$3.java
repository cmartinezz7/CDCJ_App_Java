package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.view.View.OnClickListener;

class AdapterExpaConsuExpe$3 implements OnClickListener {
   // $FF: synthetic field
   final int val$parentPosition;
   // $FF: synthetic field
   final AdapterExpaConsuExpe this$0;

   AdapterExpaConsuExpe$3(AdapterExpaConsuExpe this$0, int var2) {
      this.this$0 = this$0;
      this.val$parentPosition = var2;
   }

   public void onClick(View view) {
      this.this$0.collapseAllParents();
      if (AdapterExpaConsuExpe.access$000(this.this$0) != this.val$parentPosition) {
         AdapterExpaConsuExpe.access$002(this.this$0, this.val$parentPosition);
         AdapterExpaConsuExpe.access$100(this.this$0).onItemClick(this.val$parentPosition);
      } else {
         AdapterExpaConsuExpe.access$002(this.this$0, -1);
         this.this$0.notifyDataSetChanged();
      }

   }
}
