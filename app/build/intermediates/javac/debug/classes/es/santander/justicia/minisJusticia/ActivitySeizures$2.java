package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.bajaEmbargo.BajaEmbargoResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivitySeizures$2 extends RetrofitCallbackInterface<BajaEmbargoResponseEnvelope> {
   // $FF: synthetic field
   final ActivitySeizures this$0;

   ActivitySeizures$2(ActivitySeizures this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<BajaEmbargoResponseEnvelope> call, Response<BajaEmbargoResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((BajaEmbargoResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((BajaEmbargoResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               CommonUtils.showPopUpActionDone(this.this$0, ActivitySeizures.access$400(this.this$0), 2131886704, this.this$0);
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("getBajaEmbargoCall", "IOException", var4);
      }

   }
}
