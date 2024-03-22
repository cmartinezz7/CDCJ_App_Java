package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.operacionesEjecutadas.OpeEjectResponseEnvelop;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class FragmentOperations$1 extends RetrofitCallbackInterface<OpeEjectResponseEnvelop> {
   // $FF: synthetic field
   final FragmentOperations this$0;

   FragmentOperations$1(FragmentOperations this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<OpeEjectResponseEnvelop> call, Response<OpeEjectResponseEnvelop> response) {
      try {
         if (super.finishConnection(this.this$0.getActivity(), response.body() != null && ((OpeEjectResponseEnvelop)response.body()).getBinarySecurityToken() != null ? ((OpeEjectResponseEnvelop)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               FragmentOperations.access$000(this.this$0, ((OpeEjectResponseEnvelop)response.body()).getBody().getOperacionesResponseGlobal().getOperacionGlobals(), 2);
            } else {
               Toast.makeText(this.this$0.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("getOpeEjectConsultCall", "IOException", var4);
      }

   }
}
