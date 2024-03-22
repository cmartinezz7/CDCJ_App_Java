package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.buscarExpedientes.BuscExpResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Response;

class FragmentConsultaExpNew$2 extends RetrofitCallbackInterface<BuscExpResponseEnvelope> {
   // $FF: synthetic field
   final FragmentConsultaExpNew this$0;

   FragmentConsultaExpNew$2(FragmentConsultaExpNew this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<BuscExpResponseEnvelope> call, Response<BuscExpResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0.getActivity(), response.body() != null && ((BuscExpResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((BuscExpResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            try {
               this.this$0.mItems = FragmentConsultaExpNew.access$000(this.this$0, (ArrayList)CommonUtils.removeDatosPaginacionInBuscarExp(((BuscExpResponseEnvelope)response.body()).getBody().getBuscExpResponseReturn().getDatosExpedienteResponses()));
            } catch (Exception var4) {
               Log.d("FragmentConsultaExpNew", "Error mItems");
            }

            if (this.this$0.mItems != null) {
               FragmentConsultaExpNew.access$100(this.this$0);
            }
         }
      } catch (IOException var5) {
         Log.e("getExpedients", "IOException", var5);
      }

      this.this$0.handleResultsVisibility();
   }
}
