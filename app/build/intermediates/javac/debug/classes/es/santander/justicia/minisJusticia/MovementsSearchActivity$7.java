package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;

class MovementsSearchActivity$7 implements OnClickListener {
   // $FF: synthetic field
   final MovementsSearchActivity this$0;

   MovementsSearchActivity$7(MovementsSearchActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      SpinnerValuesDTO spnMovementItem = (SpinnerValuesDTO)MovementsSearchActivity.access$300(this.this$0).getSelectedItem();
      SpinnerValuesDTO spnCurrencyTypeItem = (SpinnerValuesDTO)MovementsSearchActivity.access$400(this.this$0).getSelectedItem();
      Intent intent = (new Intent(this.this$0, ActivityListaMovimientos.class)).addFlags(67108864);
      intent.putExtra("BuscarMovimientos", true);
      intent.putExtra("dateFrom", MovementsSearchActivity.access$100(this.this$0).getText().toString());
      intent.putExtra("dateTo", MovementsSearchActivity.access$200(this.this$0).getText().toString());
      intent.putExtra("importFrom", MovementsSearchActivity.access$500(this.this$0).getText().toString());
      intent.putExtra("importTo", MovementsSearchActivity.access$600(this.this$0).getText().toString());
      intent.putExtra("movementType", spnMovementItem.getCode());
      intent.putExtra("cointType", spnCurrencyTypeItem.getCode());
      intent.putExtra("flag_empty", true);
      this.this$0.setResult(-1, intent);
      this.this$0.startActivity(intent);
      this.this$0.finish();
   }
}
