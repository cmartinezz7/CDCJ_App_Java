package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.login.LoginResponseEnvelope;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityLoginLetrados$8 extends RetrofitCallbackInterface<LoginResponseEnvelope> {
   // $FF: synthetic field
   final ActivityLoginLetrados this$0;

   ActivityLoginLetrados$8(ActivityLoginLetrados this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<LoginResponseEnvelope> call, Response<LoginResponseEnvelope> response) {
      boolean loginOk = false;
      ActivityLoginLetrados.access$400(this.this$0);

      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((LoginResponseEnvelope)response.body()).getLoginResponseBody().getLoginResponseReturn() != null ? ((LoginResponseEnvelope)response.body()).getLoginResponseBody().getLoginResponseReturn().getLogin().getTokenSSO() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            loginOk = true;
            ActivityLoginLetrados.access$500(this.this$0, loginOk);
         } else {
            ActivityLoginLetrados.access$500(this.this$0, loginOk);
         }
      } catch (IOException var5) {
         Log.e("ActivityLoginLetrados", "IOException", var5);
      }

   }
}
