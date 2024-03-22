package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.seizures.EmbargoResponseEnvelope;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivitySeizures$1 extends RetrofitCallbackInterface<EmbargoResponseEnvelope> {
   // $FF: synthetic field
   final ActivitySeizures this$0;

   ActivitySeizures$1(ActivitySeizures this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<EmbargoResponseEnvelope> call, Response<EmbargoResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((EmbargoResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((EmbargoResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            try {
               ActivitySeizures.access$002(this.this$0, ((EmbargoResponseEnvelope)response.body()).getBody().getEmbargoReturn().getEmbargos());
            } catch (Exception var4) {
               Log.d("ActivitySeizures", "error mListSeizures");
            }

            if (ActivitySeizures.access$000(this.this$0) != null && !ActivitySeizures.access$000(this.this$0).isEmpty()) {
               ActivitySeizures.access$100(this.this$0);
               ActivitySeizures.access$200(this.this$0).setVisibility(8);
               ActivitySeizures.access$300(this.this$0).setVisibility(0);
               ActivitySeizures.access$400(this.this$0).setVisibility(0);
            } else {
               ActivitySeizures.access$200(this.this$0).setVisibility(0);
               ActivitySeizures.access$300(this.this$0).setVisibility(8);
               ActivitySeizures.access$400(this.this$0).setVisibility(8);
            }
         }
      } catch (IOException var5) {
         Log.e("getEmbargos", "IOException", var5);
      }

   }
}
