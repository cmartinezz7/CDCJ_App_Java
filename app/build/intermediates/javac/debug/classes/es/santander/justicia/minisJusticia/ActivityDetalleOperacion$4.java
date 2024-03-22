package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.responses.anularOpPteCobro.AnularOpPteCobroResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityDetalleOperacion$4 extends RetrofitCallbackInterface<AnularOpPteCobroResponseEnvelope> {
   // $FF: synthetic field
   final ActivityDetalleOperacion this$0;

   ActivityDetalleOperacion$4(ActivityDetalleOperacion this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<AnularOpPteCobroResponseEnvelope> call, Response<AnularOpPteCobroResponseEnvelope> response) {
      super.onResponse(call, response);

      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((AnularOpPteCobroResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((AnularOpPteCobroResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : "", response.code() == 500 ? response.errorBody().string() : "")) {
            if (response.errorBody() == null) {
               ActivityDetalleOperacion.access$300(this.this$0, "", "", "", this.this$0.getIntent().getStringExtra("extra_operacion_seleccionada"), "", true);
               CommonUtils.showPopUpActionDone(this.this$0, ActivityDetalleOperacion.access$100(this.this$0), 2131886704, (PopUpActionDone)null);
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("getAnularOpPteCobro", "IOException", var4);
      }

   }
}
