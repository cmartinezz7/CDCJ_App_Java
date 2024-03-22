package es.santander.justicia.minisJusticia.fragments;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;

class FragmentAbstractListados$1 extends ItemDecoration {
   // $FF: synthetic field
   final FragmentAbstractListados this$0;

   FragmentAbstractListados$1(FragmentAbstractListados this$0) {
      this.this$0 = this$0;
   }

   public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
      super.getItemOffsets(outRect, view, parent, state);
      outRect.set(0, 0, 0, this.this$0.mFabSearch.getVisibility() == 0 && state.getItemCount() - 1 == parent.getChildAdapterPosition(view) ? this.this$0.mFabSearch.getHeight() + 50 : 0);
   }
}
