package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.minisJusticia.models.responses.detalleJuzgado.DetalleJuzgadosResponseEnvelope;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityMapJuzgados$3 extends RetrofitCallbackInterface<DetalleJuzgadosResponseEnvelope> {
   // $FF: synthetic field
   final ActivityMapJuzgados this$0;

   ActivityMapJuzgados$3(ActivityMapJuzgados this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<DetalleJuzgadosResponseEnvelope> call, Response<DetalleJuzgadosResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((DetalleJuzgadosResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((DetalleJuzgadosResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               DatosJuzgado datosJuzgado = (DatosJuzgado)((DetalleJuzgadosResponseEnvelope)response.body()).getBody().getConsultaJuzgadoReturn().getDatosJuzgados().get(0);
               String address = datosJuzgado.getTipoVia() + " " + datosJuzgado.getNombreVia() + " " + (datosJuzgado.getNumero() != null ? datosJuzgado.getNumero() : " ") + " " + datosJuzgado.getProvincia() + "  " + datosJuzgado.getCodpost();
               this.this$0.getLocationFromAddress(address);
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var5) {
         Log.e("getDetalleJuzgado", "IOException", var5);
      }

   }
}
