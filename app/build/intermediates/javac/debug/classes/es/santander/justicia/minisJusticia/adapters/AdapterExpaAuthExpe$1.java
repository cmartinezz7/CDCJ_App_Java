package es.santander.justicia.minisJusticia.adapters;

import com.alexandrius.accordionswipelayout.library.SwipeLayout.OnSwipeItemClickListener;

class AdapterExpaAuthExpe$1 implements OnSwipeItemClickListener {
   // $FF: synthetic field
   final ExpedienteAuthParentViewHolder val$parentViewHolder;
   // $FF: synthetic field
   final int val$parentPosition;
   // $FF: synthetic field
   final AdapterExpaAuthExpe this$0;

   AdapterExpaAuthExpe$1(AdapterExpaAuthExpe this$0, ExpedienteAuthParentViewHolder var2, int var3) {
      this.this$0 = this$0;
      this.val$parentViewHolder = var2;
      this.val$parentPosition = var3;
   }

   public void onSwipeItemClick(boolean b, int i) {
      AdapterExpaAuthExpe.access$000(this.this$0, this.val$parentViewHolder, this.val$parentViewHolder.mImageSwipe);
      AdapterExpaAuthExpe.access$300(this.this$0).onItemClickListener(AdapterExpaAuthExpe.access$200(this.this$0, i, AdapterExpaAuthExpe.access$100(this.this$0, this.val$parentPosition).getCodEstadoActualExp()), this.val$parentPosition);
   }
}
