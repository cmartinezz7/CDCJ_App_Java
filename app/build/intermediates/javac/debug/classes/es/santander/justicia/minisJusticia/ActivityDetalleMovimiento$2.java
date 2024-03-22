package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.2.1;
import es.santander.justicia.minisJusticia.ActivityDetalleMovimiento.2.2;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DatosOperacion;
import es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DetalleMovimientoResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

class ActivityDetalleMovimiento$2 extends RetrofitCallbackInterface<DetalleMovimientoResponseEnvelope> {
   // $FF: synthetic field
   final String val$juzga;
   // $FF: synthetic field
   final ActivityDetalleMovimiento this$0;

   ActivityDetalleMovimiento$2(ActivityDetalleMovimiento this$0, Context context, String var3) {
      super(context);
      this.this$0 = this$0;
      this.val$juzga = var3;
   }

   public void onResponse(Call<DetalleMovimientoResponseEnvelope> call, Response<DetalleMovimientoResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0, response.body() != null && ((DetalleMovimientoResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((DetalleMovimientoResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : "", response.code() == 500 ? response.errorBody().string() : "")) {
            if (response.errorBody() == null) {
               DatosOperacion datosOperacion = ((DetalleMovimientoResponseEnvelope)response.body()).getBody().getDetalleMovimientoReturn().getDetalleMovimientoReturndetail().getDatosOperacion();
               ActivityDetalleMovimiento.access$402(this.this$0, CommonUtils.getMovmentItemDTO(datosOperacion, this.val$juzga));
               if (this.this$0.getIntent().getExtras() != null) {
                  ActivityDetalleMovimiento.access$500(this.this$0, datosOperacion.getDatosExpediente().getCodExpediente(), this.this$0.getIntent().getExtras().getString("extra_motive_anulation"));
               }

               ((TextView)this.this$0.findViewById(2131362808)).setText(datosOperacion.getMotivoSolicitud());
               this.this$0.findViewById(2131362394).setVisibility(0);
               this.this$0.findViewById(2131362395).setVisibility(0);
               this.this$0.findViewById(2131361965).setOnClickListener(new 1(this));
               this.this$0.findViewById(2131361968).setOnClickListener(new 2(this));
            } else {
               Toast.makeText(this.this$0.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
            }
         }
      } catch (IOException var4) {
         Log.e("getMoveDetail", "IOException", var4);
      }

   }
}
