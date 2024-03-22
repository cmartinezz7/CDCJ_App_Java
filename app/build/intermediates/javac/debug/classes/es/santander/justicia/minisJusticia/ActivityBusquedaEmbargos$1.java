package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;

class ActivityBusquedaEmbargos$1 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityBusquedaEmbargos this$0;

   ActivityBusquedaEmbargos$1(ActivityBusquedaEmbargos this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      ActivityBusquedaEmbargos.access$002(this.this$0, ((SpinnerValuesDTO)SpinnerContentModel.getSpinnerValues("spnTipoEmbargo").get(position)).getCode());
   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
