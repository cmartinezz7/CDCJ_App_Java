package es.santander.justicia.minisJusticia;

import android.content.Context;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.obtenerDatosLoginLA.ObtenerDatosLoginMethodResultDetail;
import es.santander.justicia.minisJusticia.models.responses.obtenerDatosLoginLA.ObtenerDatosLoginResponseEnvelope;
import es.santander.justicia.utils.PreferencesHelper;
import retrofit2.Call;
import retrofit2.Response;

class ActivityContratos$2 extends RetrofitCallbackInterface<ObtenerDatosLoginResponseEnvelope> {
   // $FF: synthetic field
   final ActivityContratos this$0;

   ActivityContratos$2(ActivityContratos this$0, Context context) {
      super(context);
      this.this$0 = this$0;
   }

   public void onResponse(Call<ObtenerDatosLoginResponseEnvelope> call, Response<ObtenerDatosLoginResponseEnvelope> response) {
      if (response.body() != null) {
         ObtenerDatosLoginMethodResultDetail result = ((ObtenerDatosLoginResponseEnvelope)response.body()).getObtenerDatosLoginResponseBody().getObtenerDatosLoginMethodResult().getMethodResult();
         if (super.finishConnection(this.this$0, result.getTokenEmpresas(), "")) {
            UserDTO userDTO = new UserDTO();
            userDTO.setToken(PreferencesHelper.newInstance(this.this$0).getString("preference_token_sso"));
            userDTO.setApp("PROF");
            userDTO.setUserType("EMP");
            userDTO.setNombre(result.getNombreTitular());
            String tipoPersona = result.getCliente().getTipoPersona();
            String codigoPersona = result.getCliente().getCodigoPersona();
            userDTO.setCodCliente(tipoPersona + "-" + codigoPersona);
            MainApplication.getAppContext().setUser(userDTO);
            ActivityContratos.access$200(this.this$0, result.getInfoDetail().getToken());
         }
      } else {
         this.finishConnection("");
      }

   }
}
