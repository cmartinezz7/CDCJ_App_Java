package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

class ActivityListaMovimientos$3 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityListaMovimientos this$0;

   ActivityListaMovimientos$3(ActivityListaMovimientos this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      ActivityListaMovimientos.access$002(ActivityListaMovimientos.access$100(this.this$0).getSelectedItem().toString().replace(" ", ""));
      ActivityListaMovimientos.access$202(ActivityListaMovimientos.access$100(this.this$0).getSelectedItemPosition());
      ActivityListaMovimientos.access$300(this.this$0);
   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
