package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;

class ActivityBusquedaEmbargos$2 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityBusquedaEmbargos this$0;

   ActivityBusquedaEmbargos$2(ActivityBusquedaEmbargos this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      ActivityBusquedaEmbargos.access$102(this.this$0, ((SpinnerValuesDTO)SpinnerContentModel.getSpinnerValues("spnEstadoEmbargo").get(position)).getCode());
   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
