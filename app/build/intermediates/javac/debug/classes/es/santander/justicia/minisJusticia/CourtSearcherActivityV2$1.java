package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;

class CourtSearcherActivityV2$1 implements OnClickListener {
   // $FF: synthetic field
   final CourtSearcherActivityV2 this$0;

   CourtSearcherActivityV2$1(CourtSearcherActivityV2 this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      SpinnerValuesDTO province = (SpinnerValuesDTO)CourtSearcherActivityV2.access$000(this.this$0).getSelectedItem();
      SpinnerValuesDTO judEnv = (SpinnerValuesDTO)CourtSearcherActivityV2.access$100(this.this$0).getSelectedItem();
      Intent intent = new Intent(this.this$0, CourtListActivity.class);
      intent.putExtra("province", province.getCode());
      intent.putExtra("judicialEnvironment", judEnv.getCode());
      this.this$0.startActivity(intent);
   }
}
