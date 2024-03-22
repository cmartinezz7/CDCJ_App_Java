package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;

class ActivityAltaAutorizacion$1 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityAltaAutorizacion this$0;

   ActivityAltaAutorizacion$1(ActivityAltaAutorizacion this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      ActivityAltaAutorizacion.access$002(this.this$0, ((SpinnerValuesDTO)SpinnerContentModel.getSpinnerValues("spnDocumentTypeForLetrados").get(position)).getCode());
   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
