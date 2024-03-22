package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.adapters.AdapterOpeEjectDetail;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.consultaOperaciones.ConsuOperResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Response;

class ActivityDetalleOperacion$2 extends RetrofitCallbackInterface<ConsuOperResponseEnvelope> {
   // $FF: synthetic field
   final String val$operSelacionada;
   // $FF: synthetic field
   final ActivityDetalleOperacion this$0;

   ActivityDetalleOperacion$2(ActivityDetalleOperacion this$0, Context context, Boolean show, Boolean dismiss, String var5) {
      super(context, show, dismiss);
      this.this$0 = this$0;
      this.val$operSelacionada = var5;
   }

   public void onResponse(Call<ConsuOperResponseEnvelope> call, Response<ConsuOperResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((ConsuOperResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((ConsuOperResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               ActivityDetalleOperacion.access$002(this.this$0, (ArrayList)CommonUtils.removeDatosPaginacionInOperaciones(((ConsuOperResponseEnvelope)response.body()).getBody().getConsuOperResponseReturn().getConsultaOperaciones()));
               if (ActivityDetalleOperacion.access$000(this.this$0) != null) {
                  ActivityDetalleOperacion.access$100(this.this$0).setAdapter(new AdapterOpeEjectDetail(this.this$0, ActivityDetalleOperacion.access$000(this.this$0), this.val$operSelacionada == null ? 2 : 1));
               }
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("getOperacion", "IOException", var4);
      }

      ActivityDetalleOperacion.access$200(this.this$0);
   }
}
