package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.bajaSolicitud.BajaSolicitudResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class FragmentAuthExp$6 extends RetrofitCallbackInterface<BajaSolicitudResponseEnvelope> {
   // $FF: synthetic field
   final FragmentAuthExp this$0;

   FragmentAuthExp$6(FragmentAuthExp this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<BajaSolicitudResponseEnvelope> call, Response<BajaSolicitudResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0.getActivity(), response.body() != null && ((BajaSolicitudResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((BajaSolicitudResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               CommonUtils.showPopUpActionDone(this.this$0.getActivity(), this.this$0.getView(), 2131886704, this.this$0);
            } else {
               Toast.makeText(this.this$0.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("bajaSolicitud", "IOException", var4);
      }

   }
}
