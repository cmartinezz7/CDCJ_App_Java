package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.adapters.AdapterAdvices;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.avisos.AvisosResponseEnvelop;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class FragmentAdvices$2 extends RetrofitCallbackInterface<AvisosResponseEnvelop> {
   // $FF: synthetic field
   final FragmentAdvices this$0;

   FragmentAdvices$2(FragmentAdvices this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<AvisosResponseEnvelop> call, Response<AvisosResponseEnvelop> response) {
      try {
         if (super.finishConnection(this.this$0.getActivity(), response.body() != null && ((AvisosResponseEnvelop)response.body()).getBinarySecurityToken() != null ? ((AvisosResponseEnvelop)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            try {
               FragmentAdvices.access$002(this.this$0, ((AvisosResponseEnvelop)response.body()).getBody().getAvisosReturnResponse().getAvisos());
            } catch (Exception var4) {
               Log.d("FragmentAdvices", "error mAvisosList");
            }

            if (FragmentAdvices.access$000(this.this$0) != null && !FragmentAdvices.access$000(this.this$0).isEmpty()) {
               FragmentAdvices.access$200(this.this$0).setVisibility(8);
               FragmentAdvices.access$300(this.this$0).setVisibility(0);
               FragmentAdvices.access$300(this.this$0).setAdapter(new AdapterAdvices(this.this$0.getActivity(), this.this$0, FragmentAdvices.access$000(this.this$0)));
            } else {
               FragmentAdvices.access$200(this.this$0).setVisibility(0);
               FragmentAdvices.access$300(this.this$0).setVisibility(8);
            }
         } else {
            FragmentAdvices.access$200(this.this$0).setVisibility(0);
            FragmentAdvices.access$300(this.this$0).setVisibility(8);
         }
      } catch (IOException var5) {
         Log.e("FragmentAdvices", "IOException", var5);
      }

   }
}
