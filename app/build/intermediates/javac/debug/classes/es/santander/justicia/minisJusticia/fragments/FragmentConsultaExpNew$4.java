package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.responses.activarExpediente.ActivarExpedienteResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class FragmentConsultaExpNew$4 extends RetrofitCallbackInterface<ActivarExpedienteResponseEnvelope> {
   // $FF: synthetic field
   final FragmentConsultaExpNew this$0;

   FragmentConsultaExpNew$4(FragmentConsultaExpNew this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<ActivarExpedienteResponseEnvelope> call, Response<ActivarExpedienteResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0.getActivity(), response.body() != null && ((ActivarExpedienteResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((ActivarExpedienteResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               FragmentConsultaExpNew.access$300(this.this$0, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, true);
               CommonUtils.showPopUpActionDone(this.this$0.getActivity(), this.this$0.getView(), 2131886704, (PopUpActionDone)null);
            } else {
               Toast.makeText(this.this$0.getActivity(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("activarExpediente", "IOException", var4);
      }

   }
}
