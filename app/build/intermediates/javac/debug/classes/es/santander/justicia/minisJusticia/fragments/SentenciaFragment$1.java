package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;

class SentenciaFragment$1 implements OnClickListener {
   // $FF: synthetic field
   final SentenciaFragment this$0;

   SentenciaFragment$1(SentenciaFragment this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      TealiumHelper.trackEvent("/sentencia_dia", "sentencia_dia(externo)");
      String url = SentenciaFragment.access$000(this.this$0).getLink();
      if (!url.startsWith("https://") && !url.startsWith("http://")) {
         url = "http://" + url;
      }

      Intent toEnc = new Intent("android.intent.action.VIEW");
      toEnc.setData(Uri.parse(url));
      this.this$0.startActivity(toEnc);
   }
}
