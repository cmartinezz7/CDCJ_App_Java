package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.resolverAutorizacion.ResolverAutorizacionEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityDetalleMovimiento$3 extends RetrofitCallbackInterface<ResolverAutorizacionEnvelope> {
   // $FF: synthetic field
   final ActivityDetalleMovimiento this$0;

   ActivityDetalleMovimiento$3(ActivityDetalleMovimiento this$0, Context context) {
      super(context);
      this.this$0 = this$0;
   }

   public void onResponse(Call<ResolverAutorizacionEnvelope> call, Response<ResolverAutorizacionEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((ResolverAutorizacionEnvelope)response.body()).getBinarySecurityToken() != null ? ((ResolverAutorizacionEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : "", response.code() == 500 ? response.errorBody().string() : "")) {
            if (response.errorBody() == null) {
               CommonUtils.showPopUpActionDone(this.this$0, this.this$0.findViewById(16908290), 2131886704, this.this$0);
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("getConfOpPteConf", "IOException", var4);
      }

   }
}
