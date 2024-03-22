package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.loginunico.LoginUnicoResponseEnvelope;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class LoginProfesionalesActivity$16 extends RetrofitCallbackInterface<LoginUnicoResponseEnvelope> {
   // $FF: synthetic field
   final LoginProfesionalesActivity this$0;

   LoginProfesionalesActivity$16(LoginProfesionalesActivity this$0, Context context) {
      super(context);
      this.this$0 = this$0;
   }

   public void onResponse(Call<LoginUnicoResponseEnvelope> call, Response<LoginUnicoResponseEnvelope> response) {
      if (response.errorBody() != null) {
         try {
            this.finishConnection();
            LoginProfesionalesActivity.access$1200(this.this$0, response.errorBody().string());
         } catch (IOException var4) {
            Log.d("IOException", var4.getMessage());
         }
      } else if (response.body() != null) {
         if (super.finishConnection(this.this$0, ((LoginUnicoResponseEnvelope)response.body()).getLoginResponseBody().getMethodResult().getMethodResultDetail().getLoginUnicoInfoDetail().getToken(), "") && response.body() != null) {
            LoginProfesionalesActivity.access$1300(this.this$0, ((LoginUnicoResponseEnvelope)response.body()).getLoginResponseBody().getMethodResult().getMethodResultDetail());
         }
      } else {
         super.finishConnection("");
      }

   }

   public void onFailure(Call<LoginUnicoResponseEnvelope> call, Throwable t) {
      super.onFailure(call, t);
   }
}
