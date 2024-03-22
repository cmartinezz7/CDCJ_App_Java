package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;

class BusquedaExpedientesActivity$5 implements OnClickListener {
   // $FF: synthetic field
   final BusquedaExpedientesActivity this$0;

   BusquedaExpedientesActivity$5(BusquedaExpedientesActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      SpinnerValuesDTO spnSelectionTypeItem = (SpinnerValuesDTO)this.this$0.spnSelectionType.getSelectedItem();
      SpinnerValuesDTO spnSituationItem = (SpinnerValuesDTO)this.this$0.spnSituation.getSelectedItem();
      SpinnerValuesDTO spnMoneyItem = (SpinnerValuesDTO)this.this$0.spnMoney.getSelectedItem();
      BusquedaExpedientesActivity.access$102(this.this$0, this.this$0.etJusga.getText().toString() + this.this$0.etJusgori.getText().toString() + this.this$0.etJproced.getText().toString() + this.this$0.etJnumexp.getText().toString() + this.this$0.etJanoapex.getText().toString());
      Intent intent = new Intent(this.this$0, HomeActivity.class);
      intent.putExtra("dateFrom", this.this$0.etDateFrom.getText().toString());
      intent.putExtra("dateTo", this.this$0.etDateTo.getText().toString());
      intent.putExtra("expedientNumber", BusquedaExpedientesActivity.access$100(this.this$0));
      intent.putExtra("juzga", this.this$0.etJusga.getText().toString());
      intent.putExtra("juzgori", this.this$0.etJusgori.getText().toString());
      intent.putExtra("jproced", this.this$0.etJproced.getText().toString());
      intent.putExtra("jnumexp", this.this$0.etJnumexp.getText().toString());
      intent.putExtra("janoapex", this.this$0.etJanoapex.getText().toString());
      intent.putExtra("selectionValue", spnSelectionTypeItem.getCode());
      intent.putExtra("situationValue", spnSituationItem.getCode());
      intent.putExtra("currencyValue", spnMoneyItem.getCode());
      intent.putExtra("busquedaExpedientes", true);
      this.this$0.startActivity(intent);
      this.this$0.finish();
   }
}
