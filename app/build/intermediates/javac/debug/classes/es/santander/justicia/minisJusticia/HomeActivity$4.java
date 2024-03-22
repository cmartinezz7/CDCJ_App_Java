package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;

class HomeActivity$4 implements OnGroupClickListener {
   // $FF: synthetic field
   final HomeActivity this$0;

   HomeActivity$4(HomeActivity this$0) {
      this.this$0 = this$0;
   }

   public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
      HomeActivity.access$002(this.this$0, groupPosition);
      HomeActivity.access$102(this.this$0, (ExpedienteDTO)HomeActivity.access$200(this.this$0).getGroup(groupPosition));
      HomeActivity.access$100(this.this$0).setExpanded(parent.isGroupExpanded(groupPosition));
      if (!HomeActivity.access$100(this.this$0).isDetail()) {
         this.this$0.showProgressDialog(2131886516);
         HomeActivity.access$300(this.this$0).getExpedientDetail(HomeActivity.access$100(this.this$0));
         HomeActivity.access$200(this.this$0).notifyDataSetChanged();
         return true;
      } else if (HomeActivity.access$100(this.this$0).getSaldos() != null && !HomeActivity.access$100(this.this$0).getSaldos().isEmpty()) {
         HomeActivity.access$200(this.this$0).notifyDataSetChanged();
         return false;
      } else {
         HomeActivity.access$200(this.this$0).notifyDataSetChanged();
         return true;
      }
   }
}
