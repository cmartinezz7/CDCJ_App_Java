package es.santander.justicia.minisJusticia;

import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.models.requests.authJuzgados.AuthJuzgadosArg0Detail;

class ActivityAltaAutorizacion$2 implements OnClickListener {
   // $FF: synthetic field
   final ActivityAltaAutorizacion this$0;

   ActivityAltaAutorizacion$2(ActivityAltaAutorizacion this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View view) {
      AuthJuzgadosArg0Detail authJuzgadosArg0Detail = new AuthJuzgadosArg0Detail();
      authJuzgadosArg0Detail.setIndCaducadas("1");
      ActivityAltaAutorizacion.access$100(this.this$0, authJuzgadosArg0Detail);
   }
}
