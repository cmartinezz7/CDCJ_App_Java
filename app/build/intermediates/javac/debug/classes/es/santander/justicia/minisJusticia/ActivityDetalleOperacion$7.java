package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.responses.confirmarOpPteConfirmacion.ConfirmarOpPteConfResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityDetalleOperacion$7 extends RetrofitCallbackInterface<ConfirmarOpPteConfResponseEnvelope> {
   // $FF: synthetic field
   final ActivityDetalleOperacion this$0;

   ActivityDetalleOperacion$7(ActivityDetalleOperacion this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<ConfirmarOpPteConfResponseEnvelope> call, Response<ConfirmarOpPteConfResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((ConfirmarOpPteConfResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((ConfirmarOpPteConfResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : "", response.code() == 500 ? response.errorBody().string() : "")) {
            if (response.errorBody() == null) {
               ActivityDetalleOperacion.access$300(this.this$0, "", "", "", this.this$0.getIntent().getStringExtra("extra_operacion_seleccionada"), "", true);
               CommonUtils.showPopUpActionDone(this.this$0, ActivityDetalleOperacion.access$100(this.this$0), 2131886704, (PopUpActionDone)null);
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("getConfOpPteConf", "IOException", var4);
      }

   }
}
