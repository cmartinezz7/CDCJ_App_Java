package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.cambiarOrganismo.CambiarOrganismoRespEnvelopment;
import es.santander.justicia.minisJusticia.models.responses.consultaOrganosAsignados.ConsultaOrganoAsignadoDetail;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivitySelectTribunal$1 extends RetrofitCallbackInterface<CambiarOrganismoRespEnvelopment> {
   // $FF: synthetic field
   final int val$position;
   // $FF: synthetic field
   final ActivitySelectTribunal this$0;

   ActivitySelectTribunal$1(ActivitySelectTribunal this$0, Context context, Boolean show, Boolean dismiss, int var5) {
      super(context, show, dismiss);
      this.this$0 = this$0;
      this.val$position = var5;
   }

   public void onResponse(Call<CambiarOrganismoRespEnvelopment> call, Response<CambiarOrganismoRespEnvelopment> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((CambiarOrganismoRespEnvelopment)response.body()).getBinarySecurityToken() != null ? ((CambiarOrganismoRespEnvelopment)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            ActivitySelectTribunal.access$100(this.this$0).setString("preference_cod_uo", ((ConsultaOrganoAsignadoDetail)ActivitySelectTribunal.access$000(this.this$0).get(this.val$position)).getCodUo());
            ConsultaOrganoAsignadoDetail consultaOrganoAsignadoDetail = (ConsultaOrganoAsignadoDetail)ActivitySelectTribunal.access$000(this.this$0).get(this.val$position);
            ActivitySelectTribunal.access$000(this.this$0).remove(this.val$position);
            ActivitySelectTribunal.access$000(this.this$0).add(0, consultaOrganoAsignadoDetail);
            ((AdapterSelectrTribunal)ActivitySelectTribunal.access$200(this.this$0).getAdapter()).setMakeAnimation(true);
            ActivitySelectTribunal.access$200(this.this$0).getAdapter().notifyDataSetChanged();
            this.this$0.updateHeader();
         }
      } catch (IOException var4) {
         Log.e("callSelectTribunal", "IOException", var4);
      }

   }
}
