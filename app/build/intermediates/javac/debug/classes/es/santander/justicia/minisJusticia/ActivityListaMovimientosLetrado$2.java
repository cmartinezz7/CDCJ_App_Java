package es.santander.justicia.minisJusticia;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpedienteDetail;
import es.santander.justicia.utils.CommonUtils;

class ActivityListaMovimientosLetrado$2 implements OnItemSelectedListener {
   // $FF: synthetic field
   final ActivityListaMovimientosLetrado this$0;

   ActivityListaMovimientosLetrado$2(ActivityListaMovimientosLetrado this$0) {
      this.this$0 = this$0;
   }

   public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      ActivityListaMovimientosLetrado.access$102(this.this$0, (DatosExpedienteDetail)ActivityListaMovimientosLetrado.access$200(this.this$0).get(position));
      ActivityListaMovimientosLetrado.access$300(this.this$0, ActivityListaMovimientosLetrado.access$100(this.this$0).getJanoapex(), ActivityListaMovimientosLetrado.access$100(this.this$0).getJnumexp(), ActivityListaMovimientosLetrado.access$100(this.this$0).getJproced(), ActivityListaMovimientosLetrado.access$100(this.this$0).getJuzga(), ActivityListaMovimientosLetrado.access$100(this.this$0).getJuzgori(), CommonUtils.getDateFromExpToSend(ActivityListaMovimientosLetrado.access$100(this.this$0).getPriMov()), CommonUtils.getDateFromExpToSend(ActivityListaMovimientosLetrado.access$100(this.this$0).getUltMov()), (String)null, (String)null, (String)null, (String)null);
      ActivityListaMovimientosLetrado.access$402(this.this$0, ((DatosExpedienteDetail)ActivityListaMovimientosLetrado.access$200(this.this$0).get(position)).getNumComplete());
   }

   public void onNothingSelected(AdapterView<?> parent) {
   }
}
