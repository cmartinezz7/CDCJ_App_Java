package es.santander.justicia.minisJusticia.common.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.ActivityContratos;
import es.santander.justicia.utils.PreferencesHelper;

class MainActivity$1 implements OnClickListener {
   // $FF: synthetic field
   final MainActivity this$0;

   MainActivity$1(MainActivity this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View view) {
      Intent intent = new Intent(this.this$0, ActivityContratos.class);
      intent.putExtra("extra_token_empresas", PreferencesHelper.newInstance(this.this$0).getString("preference_token_login_unico"));
      intent.putExtra("extra_lista_reposicion", "L");
      intent.putExtra("preference_alias", PreferencesHelper.newInstance(this.this$0).getString("preference_alias"));
      this.this$0.startActivity(intent);
   }
}
