package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.consultaOperaciones.ConsultaOperaciones;
import es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityDetalleOperacion$3 extends RetrofitCallbackInterface<DetalleMovimientoResponseEnvelope> {
   // $FF: synthetic field
   final int val$position;
   // $FF: synthetic field
   final ActivityDetalleOperacion this$0;

   ActivityDetalleOperacion$3(ActivityDetalleOperacion this$0, Context context, Boolean show, Boolean dismiss, int var5) {
      super(context, show, dismiss);
      this.this$0 = this$0;
      this.val$position = var5;
   }

   public void onResponse(Call<DetalleMovimientoResponseEnvelope> call, Response<DetalleMovimientoResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((DetalleMovimientoResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((DetalleMovimientoResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : "", response.code() == 500 ? response.errorBody().string() : "")) {
            if (response.errorBody() == null) {
               Intent intent = new Intent(this.this$0, ActivityDetalleMovimiento.class);
               Bundle bundle = new Bundle();
               bundle.putSerializable("movimiento", CommonUtils.getMovmentItemDTO((ConsultaOperaciones)ActivityDetalleOperacion.access$000(this.this$0).get(this.val$position), ((DetalleMovimientoResponseEnvelope)response.body()).getBody().getDetalleMovimientoReturn().getDetalleMovimientoReturndetail().getDatosOperacion(), ((DetalleMovimientoResponseEnvelope)response.body()).getBody().getDetalleMovimientoReturn().getDetalleMovimientoReturndetail().getDatosOperacion().getDatosExpedienteDestino() != null ? ((DetalleMovimientoResponseEnvelope)response.body()).getBody().getDetalleMovimientoReturn().getDetalleMovimientoReturndetail().getDatosOperacion().getDatosExpedienteDestino().getCodExpediente() : null));
               bundle.putString("expediente", CommonUtils.formatExpedient(((ConsultaOperaciones)ActivityDetalleOperacion.access$000(this.this$0).get(this.val$position)).getJuzgadoDestino(), ((ConsultaOperaciones)ActivityDetalleOperacion.access$000(this.this$0).get(this.val$position)).getJuzgadoOrigen(), ((ConsultaOperaciones)ActivityDetalleOperacion.access$000(this.this$0).get(this.val$position)).getProcedimiento(), ((ConsultaOperaciones)ActivityDetalleOperacion.access$000(this.this$0).get(this.val$position)).getNumExpediente(), ((ConsultaOperaciones)ActivityDetalleOperacion.access$000(this.this$0).get(this.val$position)).getAnyoApertura()));
               intent.putExtras(bundle);
               this.this$0.startActivity(intent);
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var5) {
         Log.e("getMoveDetail", "IOException", var5);
      }

   }
}
