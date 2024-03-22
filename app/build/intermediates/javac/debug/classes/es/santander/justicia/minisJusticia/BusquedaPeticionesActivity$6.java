package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;

class BusquedaPeticionesActivity$6 implements OnClickListener {
   // $FF: synthetic field
   final BusquedaPeticionesActivity this$0;

   BusquedaPeticionesActivity$6(BusquedaPeticionesActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      SpinnerValuesDTO spnStatusItem = (SpinnerValuesDTO)this.this$0.spnStatus.getSelectedItem();
      BusquedaPeticionesActivity.access$102(this.this$0, this.this$0.etJuzga.getText().toString() + this.this$0.etJuzgori.getText().toString() + this.this$0.etJproced.getText().toString() + this.this$0.etJnumexp.getText().toString() + this.this$0.etJanoapex.getText().toString());
      Intent intent = new Intent(this.this$0, ListadoPeticionesActivity.class);
      intent.putExtra("dateFrom", this.this$0.etDateFrom.getText().toString());
      intent.putExtra("dateTo", this.this$0.etDateTo.getText().toString());
      intent.putExtra("juzga", this.this$0.etJuzga.getText().toString());
      intent.putExtra("juzgori", this.this$0.etJuzgori.getText().toString());
      intent.putExtra("jproced", this.this$0.etJproced.getText().toString());
      intent.putExtra("jnumexp", this.this$0.etJnumexp.getText().toString());
      intent.putExtra("janoapex", this.this$0.etJanoapex.getText().toString());
      intent.putExtra("stateValue", spnStatusItem.getCode());
      intent.putExtra("busquedaPeticiones", true);
      this.this$0.startActivity(intent);
      this.this$0.finish();
   }
}
