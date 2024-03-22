package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.minisJusticia.adapters.AdapterContratos;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratosConexionResponseEnvelope;
import es.santander.justicia.utils.PreferencesHelper;
import retrofit2.Call;
import retrofit2.Response;

class ActivityContratos$1 extends RetrofitCallbackInterface<ContratosConexionResponseEnvelope> {
   // $FF: synthetic field
   final ActivityContratos this$0;

   ActivityContratos$1(ActivityContratos this$0, Context context) {
      super(context);
      this.this$0 = this$0;
   }

   public void onResponse(Call<ContratosConexionResponseEnvelope> call, Response<ContratosConexionResponseEnvelope> response) {
      if (response.body() != null) {
         if (super.finishConnection(this.this$0, ((ContratosConexionResponseEnvelope)response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail().getInfoDetail().getToken(), "")) {
            if (response.errorBody() == null) {
               PreferencesHelper.newInstance(this.this$0).setString("preference_alias", ((ContratosConexionResponseEnvelope)response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail().getAliasUsuConexion().trim());
               ActivityContratos.access$002(this.this$0, ((ContratosConexionResponseEnvelope)response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail().getToken());
               ActivityContratos.access$102(this.this$0, ((ContratosConexionResponseEnvelope)response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail().getDatosRepo().getUsuarioRacfRepos());
               ((RecyclerView)this.this$0.findViewById(2131362620)).setAdapter(new AdapterContratos(this.this$0, ((ContratosConexionResponseEnvelope)response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail().getContratoDetails()));
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } else {
         this.finishConnection("");
      }

   }

   public void onFailure(Call<ContratosConexionResponseEnvelope> call, Throwable t) {
      super.onFailure(call, t);
   }
}
