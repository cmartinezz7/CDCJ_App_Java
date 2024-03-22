package es.santander.justicia.minisJusticia;

import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;

class SolicitudAccesoActivity$12 implements OnClickListener {
   // $FF: synthetic field
   final SolicitudAccesoActivity this$0;

   SolicitudAccesoActivity$12(SolicitudAccesoActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      TealiumHelper.trackEvent("/solicitud_acceso", "solicitud_acceso (enviar)");
      SolicitudAccesoActivity.access$200(this.this$0);
      SpinnerValuesDTO spnMotiveItem = (SpinnerValuesDTO)SolicitudAccesoActivity.access$300(this.this$0).getSelectedItem();
      SolicitudAccesoActivity.access$1000(this.this$0).sendAccessRequest(SolicitudAccesoActivity.access$400(this.this$0).getText().toString(), SolicitudAccesoActivity.access$500(this.this$0).getText().toString(), SolicitudAccesoActivity.access$600(this.this$0).getText().toString(), SolicitudAccesoActivity.access$700(this.this$0).getText().toString(), SolicitudAccesoActivity.access$800(this.this$0).getText().toString(), spnMotiveItem.getCode(), SolicitudAccesoActivity.access$900(this.this$0));
   }
}
