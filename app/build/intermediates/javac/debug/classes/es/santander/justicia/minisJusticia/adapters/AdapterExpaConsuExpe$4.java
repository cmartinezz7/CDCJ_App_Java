package es.santander.justicia.minisJusticia.adapters;

import com.alexandrius.accordionswipelayout.library.SwipeLayout.OnSwipeItemClickListener;

class AdapterExpaConsuExpe$4 implements OnSwipeItemClickListener {
   // $FF: synthetic field
   final int val$parentPosition;
   // $FF: synthetic field
   final AdapterExpaConsuExpe this$0;

   AdapterExpaConsuExpe$4(AdapterExpaConsuExpe this$0, int var2) {
      this.this$0 = this$0;
      this.val$parentPosition = var2;
   }

   public void onSwipeItemClick(boolean b, int i) {
      String var3 = AdapterExpaConsuExpe.access$200(this.this$0, this.val$parentPosition).getSitexp();
      byte var4 = -1;
      switch(var3.hashCode()) {
      case 2142:
         if (var3.equals("CA")) {
            var4 = 2;
         }
         break;
      case 2156:
         if (var3.equals("CO")) {
            var4 = 1;
         }
         break;
      case 2159:
         if (var3.equals("CR")) {
            var4 = 0;
         }
      }

      switch(var4) {
      case 0:
      case 1:
         AdapterExpaConsuExpe.access$400(this.this$0).onItemClickListener(AdapterExpaConsuExpe.access$300(this.this$0, i, "CR"), false);
         break;
      case 2:
         AdapterExpaConsuExpe.access$400(this.this$0).onItemClickListener(AdapterExpaConsuExpe.access$300(this.this$0, i, "CA"), false);
      }

   }
}
