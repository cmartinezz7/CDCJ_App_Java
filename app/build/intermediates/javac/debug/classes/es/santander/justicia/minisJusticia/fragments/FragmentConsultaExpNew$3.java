package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.DatosExpedienteNew;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.detalleExpediente.DetalleExpDatosExpDetail.DetalleExpSaldos;
import es.santander.justicia.utils.CommonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import retrofit2.Call;
import retrofit2.Response;

class FragmentConsultaExpNew$3 extends RetrofitCallbackInterface<DetalleExpResponseEnvelope> {
   // $FF: synthetic field
   final int val$position;
   // $FF: synthetic field
   final FragmentConsultaExpNew this$0;

   FragmentConsultaExpNew$3(FragmentConsultaExpNew this$0, Context context, Boolean show, Boolean dismiss, int var5) {
      super(context, show, dismiss);
      this.this$0 = this$0;
      this.val$position = var5;
   }

   public void onResponse(Call<DetalleExpResponseEnvelope> call, Response<DetalleExpResponseEnvelope> response) {
      try {
         if (super.finishConnection(this.this$0.getActivity(), response.body() != null && ((DetalleExpResponseEnvelope)response.body()).getBinarySecurityToken() != null ? ((DetalleExpResponseEnvelope)response.body()).getBinarySecurityToken().getSecurityToken() : null, response.code() == 500 ? response.errorBody().string() : null)) {
            if (response.errorBody() == null) {
               ArrayList<DetalleExpSaldos> list = ((DetalleExpResponseEnvelope)response.body()).getBody().getDetalleMovimientoReturn().getDetalleExp().getDetalleExpDatosExpDetail().getSaldos();
               if (list != null && list.isEmpty()) {
                  if (this.this$0.getActivity() != null) {
                     CommonUtils.showAlertNoProceedingData(this.this$0.getActivity());
                  }
               } else {
                  int contChilds = 0;

                  for(Iterator var5 = ((DetalleExpResponseEnvelope)response.body()).getBody().getDetalleMovimientoReturn().getDetalleExp().getDetalleExpDatosExpDetail().getSaldos().iterator(); var5.hasNext(); ++contChilds) {
                     DetalleExpSaldos saldos = (DetalleExpSaldos)var5.next();
                     new DatosExpedienteNew(saldos);
                     ((DatosExpedienteNew)this.this$0.mItems.get(this.val$position)).setImpInterCostas(((DetalleExpResponseEnvelope)response.body()).getBody().getDetalleMovimientoReturn().getDetalleExp().getDetalleExpDatosExpDetail().getImpInterCostas());
                     this.this$0.mItems.add(this.val$position + contChilds + 1, new DatosExpedienteNew(saldos));
                  }

                  FragmentConsultaExpNew.access$200(this.this$0).setExpandedCard(this.val$position);
                  FragmentConsultaExpNew.access$200(this.this$0).notifyDataSetChanged();
               }

               this.this$0.mRecycler.scrollToPosition(this.val$position);
            } else {
               Toast.makeText(this.this$0.getActivity(), "Error al invocar al servicio, vuelva a intentarlo", 1).show();
            }
         }
      } catch (IOException var8) {
         Log.e("getDetailExpediente", "IOException", var8);
      }

   }
}
