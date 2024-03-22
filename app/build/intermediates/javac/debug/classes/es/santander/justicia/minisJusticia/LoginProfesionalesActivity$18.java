package es.santander.justicia.minisJusticia;

import android.content.Context;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.obtenerDatosLoginLA.ObtenerDatosLoginMethodResultDetail;
import es.santander.justicia.minisJusticia.models.responses.obtenerDatosLoginLA.ObtenerDatosLoginResponseEnvelope;
import es.santander.justicia.minisJusticia.tasks.MergeloginUnicoTask;
import es.santander.justicia.utils.PreferencesHelper;
import retrofit2.Call;
import retrofit2.Response;

class LoginProfesionalesActivity$18 extends RetrofitCallbackInterface<ObtenerDatosLoginResponseEnvelope> {
   // $FF: synthetic field
   final LoginProfesionalesActivity this$0;

   LoginProfesionalesActivity$18(LoginProfesionalesActivity this$0, Context context) {
      super(context);
      this.this$0 = this$0;
   }

   public void onResponse(Call<ObtenerDatosLoginResponseEnvelope> call, Response<ObtenerDatosLoginResponseEnvelope> response) {
      if (response.body() != null) {
         ObtenerDatosLoginMethodResultDetail result = ((ObtenerDatosLoginResponseEnvelope)response.body()).getObtenerDatosLoginResponseBody().getObtenerDatosLoginMethodResult().getMethodResult();
         if (super.finishConnection(this.this$0, result.getTokenEmpresas(), "")) {
            PreferencesHelper.newInstance(this.this$0).setString("preference_token_login_unico", result.getInfoDetail().getToken());
            UserDTO userDTO = new UserDTO();
            userDTO.setToken(PreferencesHelper.newInstance(this.this$0).getString("preference_token_sso"));
            userDTO.setApp("PROF");
            userDTO.setUserType("EMP");
            userDTO.setNombre(result.getNombreTitular());
            String tipoPersona = result.getCliente().getTipoPersona();
            String codigoPersona = result.getCliente().getCodigoPersona();
            userDTO.setCodCliente(tipoPersona + "-" + codigoPersona);
            MainApplication.getAppContext().setUser(userDTO);
            PreferencesHelper.newInstance(this.this$0).setBoolean("extra_show_contracts", false);
            MergeloginUnicoTask mergeloginUnicoTask = new MergeloginUnicoTask(this.this$0, PreferencesHelper.newInstance(this.this$0).getString("preference_token_login_unico"));
            mergeloginUnicoTask.execute(new Object[0]);
         }
      } else {
         this.finishConnection("");
      }

   }
}
