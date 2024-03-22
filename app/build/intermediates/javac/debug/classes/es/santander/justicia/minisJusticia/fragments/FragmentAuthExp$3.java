package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp.3.1;
import es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscPetAccResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import retrofit2.Call;
import retrofit2.Response;

class FragmentAuthExp$3 extends RetrofitCallbackInterface<BuscPetAccResponseEnvelope> {
   // $FF: synthetic field
   final FragmentAuthExp this$0;

   FragmentAuthExp$3(FragmentAuthExp this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<BuscPetAccResponseEnvelope> call, Response<BuscPetAccResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0.getActivity(), response.body() != null && ((BuscPetAccResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((BuscPetAccResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            try {
               this.this$0.mItems = (ArrayList)CommonUtils.removeDatosPaginacionInBusqueda(((BuscPetAccResponseEnvelope)response.body()).getBody().getBuscPetAccResponseReturn().getBuscarPeticionesAccesos());
            } catch (Exception var4) {
               Log.d("FragmentAuthExp", "error mItems");
            }

            if (this.this$0.mItems != null) {
               Collections.sort(this.this$0.mItems, new 1(this));
               FragmentAuthExp.access$100(this.this$0);
            }
         }
      } catch (IOException var5) {
         Log.e("getExpedients", "IOException", var5);
      }

      this.this$0.handleResultsVisibility();
   }
}
