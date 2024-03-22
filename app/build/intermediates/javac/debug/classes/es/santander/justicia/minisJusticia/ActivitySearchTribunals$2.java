package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.adapters.AdapterSearchTribunal;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.ConsultaJuzgadosResponseEnvelope;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivitySearchTribunals$2 extends RetrofitCallbackInterface<ConsultaJuzgadosResponseEnvelope> {
   // $FF: synthetic field
   final ActivitySearchTribunals this$0;

   ActivitySearchTribunals$2(ActivitySearchTribunals this$0, Context context, Boolean show, Boolean dismiss) {
      super(context, show, dismiss);
      this.this$0 = this$0;
   }

   public void onResponse(Call<ConsultaJuzgadosResponseEnvelope> call, Response<ConsultaJuzgadosResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((ConsultaJuzgadosResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((ConsultaJuzgadosResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            try {
               ActivitySearchTribunals.access$002(this.this$0, ActivitySearchTribunals.access$100(this.this$0, ((ConsultaJuzgadosResponseEnvelope)response.body()).getBody().getConsultaJuzgadoReturn().getDatosJuzgados()));
               if (ActivitySearchTribunals.access$000(this.this$0).isEmpty()) {
                  ActivitySearchTribunals.access$200(this.this$0).setVisibility(0);
                  ActivitySearchTribunals.access$300(this.this$0).setVisibility(8);
               } else {
                  ActivitySearchTribunals.access$200(this.this$0).setVisibility(8);
                  ActivitySearchTribunals.access$300(this.this$0).setVisibility(0);
               }

               ActivitySearchTribunals.access$300(this.this$0).setAdapter(new AdapterSearchTribunal(this.this$0, ActivitySearchTribunals.access$000(this.this$0)));
            } catch (Exception var4) {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         } else {
            ActivitySearchTribunals.access$200(this.this$0).setVisibility(0);
            ActivitySearchTribunals.access$300(this.this$0).setVisibility(8);
         }
      } catch (IOException var5) {
         Log.e("getJuzgados", "IOException", var5);
      }

   }
}
