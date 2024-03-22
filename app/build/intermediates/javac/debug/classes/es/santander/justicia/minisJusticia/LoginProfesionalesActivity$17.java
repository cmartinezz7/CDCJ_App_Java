package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratosParaguasResponseEnvelope;
import retrofit2.Call;
import retrofit2.Response;

class LoginProfesionalesActivity$17 extends RetrofitCallbackInterface<ContratosParaguasResponseEnvelope> {
   // $FF: synthetic field
   final LoginProfesionalesActivity this$0;

   LoginProfesionalesActivity$17(LoginProfesionalesActivity this$0, Context context) {
      super(context);
      this.this$0 = this$0;
   }

   public void onResponse(Call<ContratosParaguasResponseEnvelope> call, Response<ContratosParaguasResponseEnvelope> response) {
      if (response.body() != null) {
         if (super.finishConnection(this.this$0, ((ContratosParaguasResponseEnvelope)response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail().getInfoDetail().getToken(), "")) {
            if (response.errorBody() == null) {
               LoginProfesionalesActivity.access$1400(this.this$0, ((ContratosParaguasResponseEnvelope)response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail());
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } else {
         this.finishConnection("");
      }

   }

   public void onFailure(Call<ContratosParaguasResponseEnvelope> call, Throwable t) {
      super.onFailure(call, t);
   }
}
