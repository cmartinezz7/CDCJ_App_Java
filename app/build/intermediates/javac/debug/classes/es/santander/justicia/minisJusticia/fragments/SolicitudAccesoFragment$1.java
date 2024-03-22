package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.PopupActivity;
import es.santander.justicia.minisJusticia.enums.PopupTypeEnum;

class SolicitudAccesoFragment$1 implements OnClickListener {
   // $FF: synthetic field
   final SolicitudAccesoFragment this$0;

   SolicitudAccesoFragment$1(SolicitudAccesoFragment this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      Intent popup = new Intent(SolicitudAccesoFragment.access$000(this.this$0), PopupActivity.class);
      popup.putExtra("popupName", PopupTypeEnum.ACCESS_REQUEST_SENT_CORRECTLY.getId());
      this.this$0.startActivity(popup);
   }
}
