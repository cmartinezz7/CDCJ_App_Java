package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.denegarSolicitud.DenegarSolicitudResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class FragmentAuthExp$5 extends RetrofitCallbackInterface<DenegarSolicitudResponseEnvelope> {
   // $FF: synthetic field
   final FragmentAuthExp this$0;

   FragmentAuthExp$5(FragmentAuthExp this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<DenegarSolicitudResponseEnvelope> call, Response<DenegarSolicitudResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0.getActivity(), response.body() != null && ((DenegarSolicitudResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((DenegarSolicitudResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               CommonUtils.showPopUpActionDone(this.this$0.getActivity(), this.this$0.getView(), 2131886704, this.this$0);
            } else {
               Toast.makeText(this.this$0.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("denegarSolicitud", "IOException", var4);
      }

   }
}
