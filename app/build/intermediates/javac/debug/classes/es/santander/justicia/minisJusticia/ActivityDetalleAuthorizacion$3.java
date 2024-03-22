package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.detalleAutorizacion.DetalleAutorizacionEnvelope;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityDetalleAuthorizacion$3 extends RetrofitCallbackInterface<DetalleAutorizacionEnvelope> {
   // $FF: synthetic field
   final ActivityDetalleAuthorizacion this$0;

   ActivityDetalleAuthorizacion$3(ActivityDetalleAuthorizacion this$0, Context context) {
      super(context);
      this.this$0 = this$0;
   }

   public void onResponse(Call<DetalleAutorizacionEnvelope> call, Response<DetalleAutorizacionEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((DetalleAutorizacionEnvelope)response.body()).getBinarySecurityToken() != null ? ((DetalleAutorizacionEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            ActivityDetalleAuthorizacion.access$100(this.this$0, ((DetalleAutorizacionEnvelope)response.body()).getBody().getDetalleAutorizacionReturn().getDetalleAutorizacion());
            ActivityDetalleAuthorizacion.access$200(this.this$0, ((DetalleAutorizacionEnvelope)response.body()).getBody().getDetalleAutorizacionReturn().getDetalleAutorizacion().getDetalleAutorizacionJuzgado().getCodOrganismo());
         }
      } catch (IOException var4) {
         Log.e("getDetalleJuzgado", "IOException", var4);
      }

   }
}
