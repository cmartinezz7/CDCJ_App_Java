package es.santander.justicia.minisJusticia;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.AdapterView.OnItemClickListener;
import es.santander.branchlocator.BLUtils;
import es.santander.justicia.minisJusticia.adapters.AdapterDrawerLetrados;

class ActivityHomeLetrados$3 implements OnItemClickListener {
   // $FF: synthetic field
   final ActivityHomeLetrados this$0;

   ActivityHomeLetrados$3(ActivityHomeLetrados this$0) {
      this.this$0 = this$0;
   }

   public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
      ((AdapterDrawerLetrados)((HeaderViewListAdapter)ActivityHomeLetrados.access$000(this.this$0).getAdapter()).getWrappedAdapter()).setmSelectedPosition(i - 1);
      ActivityHomeLetrados.access$100(this.this$0).setSelected(false);
      if (ActivityHomeLetrados.access$000(this.this$0).getAdapter().getItemId(i) == 2131886573L) {
         BLUtils.launchBranchLocator(this.this$0.getContext(), false, true);
         this.this$0.simulateClick(0);
      } else {
         ActivityHomeLetrados.access$200(this.this$0, (int)ActivityHomeLetrados.access$000(this.this$0).getAdapter().getItemId(i), (Bundle)null);
      }

   }
}
