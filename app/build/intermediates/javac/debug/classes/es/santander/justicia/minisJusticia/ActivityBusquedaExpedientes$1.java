package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;

class ActivityBusquedaExpedientes$1 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityBusquedaExpedientes this$0;

   ActivityBusquedaExpedientes$1(ActivityBusquedaExpedientes this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      ActivityAbstractBusqueda.mTextDateFrom.setClickable(position != 0);
      ActivityAbstractBusqueda.mTextDateTo.setClickable(position != 0);
      ActivityBusquedaExpedientes.access$002(this.this$0, ((SpinnerValuesDTO)SpinnerContentModel.getSpinnerValues("spnSelectionTypeExpedient").get(position)).getCode());
      if (position == 0) {
         ActivityAbstractBusqueda.mTextDateFrom.setText("DD/MM/YYYY");
         ActivityAbstractBusqueda.mTextDateTo.setText("DD/MM/YYYY");
         ActivityAbstractBusqueda.mDateDesde = null;
         ActivityAbstractBusqueda.mDateHasta = null;
      }

   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
