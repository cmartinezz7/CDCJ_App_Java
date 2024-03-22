package es.santander.justicia.minisJusticia.fragments;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter.ExpandCollapseListener;

class FragmentAuthExp$2 implements ExpandCollapseListener {
   // $FF: synthetic field
   final FragmentAuthExp this$0;

   FragmentAuthExp$2(FragmentAuthExp this$0) {
      this.this$0 = this$0;
   }

   public void onParentExpanded(int parentPosition) {
      this.this$0.mRecycler.scrollToPosition(parentPosition);
      FragmentAuthExp.access$000(this.this$0).notifyDataSetChanged();
   }

   public void onParentCollapsed(int parentPosition) {
   }
}
