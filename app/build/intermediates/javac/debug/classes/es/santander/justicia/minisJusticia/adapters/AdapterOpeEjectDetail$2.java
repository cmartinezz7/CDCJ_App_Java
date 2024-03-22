package es.santander.justicia.minisJusticia.adapters;

import com.alexandrius.accordionswipelayout.library.SwipeLayout.OnSwipeItemClickListener;

class AdapterOpeEjectDetail$2 implements OnSwipeItemClickListener {
   // $FF: synthetic field
   final int val$position;
   // $FF: synthetic field
   final AdapterOpeEjectDetail this$0;

   AdapterOpeEjectDetail$2(AdapterOpeEjectDetail this$0, int var2) {
      this.this$0 = this$0;
      this.val$position = var2;
   }

   public void onSwipeItemClick(boolean b, int i) {
      AdapterOpeEjectDetail.access$800(this.this$0).onOperativeClicked(i == 0 ? 1 : 2, this.val$position);
   }
}
