package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;

class ActivityBusquedaAuthExpedi$1 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityBusquedaAuthExpedi this$0;

   ActivityBusquedaAuthExpedi$1(ActivityBusquedaAuthExpedi this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      ActivityBusquedaAuthExpedi.access$002(this.this$0, ((SpinnerValuesDTO)SpinnerContentModel.getSpinnerValues("spnAccessRequestStatus").get(position)).getCode());
   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
