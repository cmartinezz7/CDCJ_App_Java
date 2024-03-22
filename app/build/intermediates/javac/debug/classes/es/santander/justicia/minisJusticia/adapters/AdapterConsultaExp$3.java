package es.santander.justicia.minisJusticia.adapters;

import com.alexandrius.accordionswipelayout.library.SwipeLayout.OnSwipeItemClickListener;

class AdapterConsultaExp$3 implements OnSwipeItemClickListener {
   // $FF: synthetic field
   final int val$position;
   // $FF: synthetic field
   final AdapterConsultaExp this$0;

   AdapterConsultaExp$3(AdapterConsultaExp this$0, int var2) {
      this.this$0 = this$0;
      this.val$position = var2;
   }

   public void onSwipeItemClick(boolean b, int i) {
      AdapterConsultaExp.access$200(this.this$0).onActivarClickListener(this.val$position);
   }
}
