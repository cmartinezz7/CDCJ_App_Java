package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.utils.CommonUtils;

class NewsActivity$3 implements OnClickListener {
   // $FF: synthetic field
   final NewsActivity this$0;

   NewsActivity$3(NewsActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      String pls = KeyValueModel.getInstancePermanent().getValue("pls");
      Intent intent = null;
      if (pls != null && "P".equals(pls)) {
         intent = new Intent(this.this$0, CommonUtils.getLoginProfesionalesClass(this.this$0));
      } else if (pls != null && "L".equals(pls)) {
         intent = new Intent(this.this$0, ActivityLoginLetrados.class);
      } else {
         intent = new Intent(this.this$0, BienvenidaViewPagerActivity.class);
      }

      this.this$0.startActivity(intent);
      this.this$0.finish();
   }
}
