package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.minisJusticia.models.responses.detalleJuzgado.DetalleJuzgadosResponseEnvelope;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityDetalleAuthorizacion$4 extends RetrofitCallbackInterface<DetalleJuzgadosResponseEnvelope> {
   // $FF: synthetic field
   final ActivityDetalleAuthorizacion this$0;

   ActivityDetalleAuthorizacion$4(ActivityDetalleAuthorizacion this$0, Context context) {
      super(context);
      this.this$0 = this$0;
   }

   public void onResponse(Call<DetalleJuzgadosResponseEnvelope> call, Response<DetalleJuzgadosResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((DetalleJuzgadosResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((DetalleJuzgadosResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            ActivityDetalleAuthorizacion.access$300(this.this$0, (DatosJuzgado)((DetalleJuzgadosResponseEnvelope)response.body()).getBody().getConsultaJuzgadoReturn().getDatosJuzgados().get(0));
         }
      } catch (IOException var4) {
         Log.e("getDetalleJuzgado", "IOException", var4);
      }

   }
}
