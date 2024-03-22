package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;

class ActivityBusquedaMovimientos$1 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityBusquedaMovimientos this$0;

   ActivityBusquedaMovimientos$1(ActivityBusquedaMovimientos this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      ActivityBusquedaMovimientos.access$002(this.this$0, ((SpinnerValuesDTO)SpinnerContentModel.getSpinnerValues("spnMotionQuery").get(position)).getCode());
   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
