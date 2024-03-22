package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.GlobalReponseEnvelope;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityDetalleAuthorizacion$5 extends RetrofitCallbackInterface<GlobalReponseEnvelope> {
   // $FF: synthetic field
   final ActivityDetalleAuthorizacion this$0;

   ActivityDetalleAuthorizacion$5(ActivityDetalleAuthorizacion this$0, Context context) {
      super(context);
      this.this$0 = this$0;
   }

   public void onResponse(Call<GlobalReponseEnvelope> call, Response<GlobalReponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((GlobalReponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((GlobalReponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            Intent intent = new Intent();
            this.this$0.setResult(-1, intent);
            this.this$0.finish();
         }
      } catch (IOException var4) {
         Log.e("getDetalleJuzgado", "IOException", var4);
      }

   }
}
