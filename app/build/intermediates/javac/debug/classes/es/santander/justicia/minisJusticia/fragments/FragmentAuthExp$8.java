package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.requests.operativas.OperativasGlobalArg0Detail;
import es.santander.justicia.minisJusticia.models.responses.detallePetAcceRespose.DetallePetAccReponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class FragmentAuthExp$8 extends RetrofitCallbackInterface<DetallePetAccReponseEnvelope> {
   // $FF: synthetic field
   final String val$motivo;
   // $FF: synthetic field
   final String val$pass;
   // $FF: synthetic field
   final int val$nexOperation;
   // $FF: synthetic field
   final FragmentAuthExp this$0;

   FragmentAuthExp$8(FragmentAuthExp this$0, Context context, Boolean show, Boolean dismiss, String var5, String var6, int var7) {
      super(context, show, dismiss);
      this.this$0 = this$0;
      this.val$motivo = var5;
      this.val$pass = var6;
      this.val$nexOperation = var7;
   }

   public void onResponse(Call<DetallePetAccReponseEnvelope> call, Response<DetallePetAccReponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0.getActivity(), response.body() != null && ((DetallePetAccReponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((DetallePetAccReponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               OperativasGlobalArg0Detail detail = ((DetallePetAccReponseEnvelope)response.body()).getBody().getDetallePetAccesReturn().getOperativasGlobalArg0Detail();
               if (this.val$motivo != null) {
                  detail.setComentariosSecretario(this.val$motivo);
               }

               detail.setFirma(this.val$pass);
               detail.setFecDeLaPeticion(CommonUtils.getCurrentDateToOperations());
               switch(this.val$nexOperation) {
               case 1:
                  FragmentAuthExp.access$200(this.this$0, detail);
                  break;
               case 2:
                  FragmentAuthExp.access$400(this.this$0, detail);
                  break;
               case 3:
                  FragmentAuthExp.access$300(this.this$0, detail);
                  break;
               case 4:
                  FragmentAuthExp.access$500(this.this$0, detail);
               }
            } else {
               Toast.makeText(this.this$0.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("getDetailSolicitud", "IOException", var4);
      }

   }
}
