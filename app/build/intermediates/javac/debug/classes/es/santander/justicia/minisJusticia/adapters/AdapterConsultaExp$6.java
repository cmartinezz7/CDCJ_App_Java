package es.santander.justicia.minisJusticia.adapters;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado;
import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew;

class AdapterConsultaExp$6 implements OnClickListener {
   // $FF: synthetic field
   final int val$position;
   // $FF: synthetic field
   final AdapterConsultaExp this$0;

   AdapterConsultaExp$6(AdapterConsultaExp this$0, int var2) {
      this.this$0 = this$0;
      this.val$position = var2;
   }

   public void onClick(View v) {
      int numChilds;
      for(numChilds = 1; ((DatosExpedienteNew)this.this$0.getItem(this.val$position - numChilds)).isChild(); ++numChilds) {
      }

      Intent intent = new Intent(this.this$0.mContext, ActivityListaMovimientosLetrado.class);
      intent.putParcelableArrayListExtra("extra_listado_expedientes", this.this$0.getListMovements());
      intent.putExtra("extra_janoapex", ((DatosExpedienteNew)this.this$0.getItem(this.val$position - numChilds)).getJanoapex());
      intent.putExtra("extra_jnumexp", ((DatosExpedienteNew)this.this$0.getItem(this.val$position - numChilds)).getJnumexp());
      intent.putExtra("extra_jproced", ((DatosExpedienteNew)this.this$0.getItem(this.val$position - numChilds)).getJproced());
      intent.putExtra("extra_juzga", ((DatosExpedienteNew)this.this$0.getItem(this.val$position - numChilds)).getJuzga());
      intent.putExtra("extra_juzgori", ((DatosExpedienteNew)this.this$0.getItem(this.val$position - numChilds)).getJuzgori());
      intent.putExtra("extra_juzgori", ((DatosExpedienteNew)this.this$0.getItem(this.val$position - numChilds)).getJuzgori());
      intent.putExtra("extra_spinner_position", this.val$position - numChilds);
      this.this$0.mContext.startActivity(intent);
   }
}
