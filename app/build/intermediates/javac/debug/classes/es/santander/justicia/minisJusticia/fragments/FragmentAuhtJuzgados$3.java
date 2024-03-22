package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.adapters.AdapterAuthCourts;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.authjuzados.AutorizacionesUsuarioEnvelope;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.safetynet.ComparadorAutorizacionesUsuario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import retrofit2.Call;
import retrofit2.Response;

class FragmentAuhtJuzgados$3 extends RetrofitCallbackInterface<AutorizacionesUsuarioEnvelope> {
   // $FF: synthetic field
   final FragmentAuhtJuzgados this$0;

   FragmentAuhtJuzgados$3(FragmentAuhtJuzgados this$0, Context context) {
      super(context);
      this.this$0 = this$0;
   }

   public void onResponse(Call<AutorizacionesUsuarioEnvelope> call, Response<AutorizacionesUsuarioEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0.getActivity(), response.body() != null && ((AutorizacionesUsuarioEnvelope)response.body()).getBinarySecurityToken() != null ? ((AutorizacionesUsuarioEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            this.this$0.mItems = (ArrayList)CommonUtils.removeDatosPaginacionInAutorizacionUsuario(((AutorizacionesUsuarioEnvelope)response.body()).getBody().getAutorizacionesUsuarioReturn().autorizacionesUsuarios());
            if (this.this$0.mItems.size() == 0) {
               this.this$0.mButtonNew.setVisibility(8);
            } else {
               this.this$0.mButtonNew.setVisibility(0);
            }

            Collections.sort(this.this$0.mItems, new ComparadorAutorizacionesUsuario());
            this.this$0.mRecycler.setAdapter(new AdapterAuthCourts(this.this$0.getActivity(), this.this$0, this.this$0.mItems));
         }
      } catch (IOException var4) {
         Log.e("getExpedients", "IOException", var4);
      }

      this.this$0.handleResultsVisibility();
   }

   public void onFailure(Call<AutorizacionesUsuarioEnvelope> call, Throwable t) {
      super.onFailure(call, t);
      this.this$0.mButtonNew.setVisibility(8);
   }
}
