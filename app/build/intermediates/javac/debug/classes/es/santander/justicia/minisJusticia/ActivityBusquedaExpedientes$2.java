package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;

class ActivityBusquedaExpedientes$2 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityBusquedaExpedientes this$0;

   ActivityBusquedaExpedientes$2(ActivityBusquedaExpedientes this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      ActivityBusquedaExpedientes.access$102(this.this$0, ((SpinnerValuesDTO)SpinnerContentModel.getSpinnerValues("spnCaseFileStatus").get(position)).getCode());
   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
