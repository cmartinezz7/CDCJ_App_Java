package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.listaMovimientos.DatosOperacion;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityListaMovimientosLetrado$5 extends RetrofitCallbackInterface<DetalleMovimientoResponseEnvelope> {
   // $FF: synthetic field
   final int val$position;
   // $FF: synthetic field
   final ActivityListaMovimientosLetrado this$0;

   ActivityListaMovimientosLetrado$5(ActivityListaMovimientosLetrado this$0, Context context, Boolean show, Boolean dismiss, int var5) {
      super(context, show, dismiss);
      this.this$0 = this$0;
      this.val$position = var5;
   }

   public void onResponse(Call<DetalleMovimientoResponseEnvelope> call, Response<DetalleMovimientoResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((DetalleMovimientoResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((DetalleMovimientoResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               Intent intent = new Intent(this.this$0, ActivityDetalleMovimiento.class);
               Bundle bundle = new Bundle();
               bundle.putSerializable("movimiento", ActivityListaMovimientosLetrado.access$1400(this.this$0, (DatosOperacion)ActivityListaMovimientosLetrado.access$1300(this.this$0).get(this.val$position), ((DetalleMovimientoResponseEnvelope)response.body()).getBody().getDetalleMovimientoReturn().getDetalleMovimientoReturndetail().getDatosOperacion()));
               bundle.putString("expediente", ActivityListaMovimientosLetrado.access$400(this.this$0));
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
