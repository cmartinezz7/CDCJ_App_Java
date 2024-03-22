package es.santander.justicia.minisJusticia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.utils.PreferencesHelper;

class ActivityHelp$2 implements OnClickListener {
   // $FF: synthetic field
   final ActivityHelp this$0;

   ActivityHelp$2(ActivityHelp this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      ProgressDialog progressDialog = new ProgressDialog(this.this$0);
      progressDialog.setCancelable(false);
      progressDialog.setMessage(this.this$0.getString(2131886514));
      progressDialog.show();
      PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(this.this$0.getBaseContext(), "loginPreferencesCrypt");
      preferencesHelper.setString("documentType", "");
      preferencesHelper.setString("documentNumber", "");
      preferencesHelper.setString("code", "");
      preferencesHelper.setString("authenticationTypeCode", "");
      preferencesHelper.setBoolean("companyMode", false);
      preferencesHelper.setBoolean("rememberMe", false);
      PreferencesHelper.newInstance(this.this$0).clear();
      KeyValueModel.getInstancePermanent().insertValue("pls", "", "");
      Intent intent = new Intent(this.this$0, BienvenidaViewPagerActivity.class);
      intent.setFlags(268468224);
      this.this$0.startActivity(intent);
      this.this$0.finish();
   }
}
