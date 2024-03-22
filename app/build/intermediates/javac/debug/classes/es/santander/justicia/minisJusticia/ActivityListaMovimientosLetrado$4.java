package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.listaMovimientos.ListaMovimientosResponseEnvelope;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityListaMovimientosLetrado$4 extends RetrofitCallbackInterface<ListaMovimientosResponseEnvelope> {
   // $FF: synthetic field
   final ActivityListaMovimientosLetrado this$0;

   ActivityListaMovimientosLetrado$4(ActivityListaMovimientosLetrado this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<ListaMovimientosResponseEnvelope> call, Response<ListaMovimientosResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((ListaMovimientosResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((ListaMovimientosResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               if (((ListaMovimientosResponseEnvelope)response.body()).getBody().getListaMovimientosReturn().getListaMovimientosReturnDetail().getDatosOperacions() != null && !((ListaMovimientosResponseEnvelope)response.body()).getBody().getListaMovimientosReturn().getListaMovimientosReturnDetail().getDatosOperacions().isEmpty()) {
                  ActivityListaMovimientosLetrado.access$1000(this.this$0, ((ListaMovimientosResponseEnvelope)response.body()).getBody().getListaMovimientosReturn().getListaMovimientosReturnDetail().getDatosOperacions());
                  ActivityListaMovimientosLetrado.access$1100(this.this$0).setVisibility(8);
                  ActivityListaMovimientosLetrado.access$1200(this.this$0).setVisibility(0);
                  ActivityListaMovimientosLetrado.access$000(this.this$0).setVisibility(0);
               } else {
                  ActivityListaMovimientosLetrado.access$1100(this.this$0).setVisibility(0);
                  ActivityListaMovimientosLetrado.access$1200(this.this$0).setVisibility(8);
                  ActivityListaMovimientosLetrado.access$000(this.this$0).setVisibility(8);
               }
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("getMovements", "IOException", var4);
      }

   }
}
