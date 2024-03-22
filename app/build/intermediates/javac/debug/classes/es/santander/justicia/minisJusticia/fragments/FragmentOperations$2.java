package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.operacionesPendientes.OpePenResponseEnvelop;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class FragmentOperations$2 extends RetrofitCallbackInterface<OpePenResponseEnvelop> {
   // $FF: synthetic field
   final FragmentOperations this$0;

   FragmentOperations$2(FragmentOperations this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<OpePenResponseEnvelop> call, Response<OpePenResponseEnvelop> response) {
      try {
         if (super.finishConnection(this.this$0.getActivity(), response.body() != null && ((OpePenResponseEnvelop)response.body()).getBinarySecurityToken() != null ? ((OpePenResponseEnvelop)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               FragmentOperations.access$000(this.this$0, ((OpePenResponseEnvelop)response.body()).getBody().getOperacionesResponseGlobal().getOperacionGlobals(), 1);
            } else {
               Toast.makeText(this.this$0.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("getOpePendConsultaCall", "IOException", var4);
      }

   }
}
