package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.consultaOrganosAsignados.ConsultaOrganosAsigRespEnvelope;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivitySelectTribunal$2 extends RetrofitCallbackInterface<ConsultaOrganosAsigRespEnvelope> {
   // $FF: synthetic field
   final ActivitySelectTribunal this$0;

   ActivitySelectTribunal$2(ActivitySelectTribunal this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<ConsultaOrganosAsigRespEnvelope> call, Response<ConsultaOrganosAsigRespEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((ConsultaOrganosAsigRespEnvelope)response.body()).getBinarySecurityToken() != null ? ((ConsultaOrganosAsigRespEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               ActivitySelectTribunal.access$002(this.this$0, ((ConsultaOrganosAsigRespEnvelope)response.body()).getBody().getConsultaOrganismoReturn().getConsultaOrganimosAsignadoCodUos());
               ActivitySelectTribunal.access$200(this.this$0).setAdapter(new AdapterSelectrTribunal(this.this$0, ActivitySelectTribunal.access$000(this.this$0)));
               ActivitySelectTribunal.access$300(this.this$0);
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("callConsultOrgAsig", "IOException", var4);
      }

   }
}
