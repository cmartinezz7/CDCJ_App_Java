package es.santander.justicia.minisJusticia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;

public class ActivityHelpLetrados extends ActivityAbstractLetrados {
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558443);
      this.findViewById(2131362055).setVisibility(0);
      this.initUi();
   }

   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/ayuda");
   }

   private void initUi() {
      String value = KeyValueModel.getInstance().getValue("aInfo.", "letrados.superlinea1");
      if (CommonUtils.isNotNullNotBlack(value)) {
         ((QTextView)this.findViewById(2131361805)).setText(value);
      }

      String value2 = KeyValueModel.getInstance().getValue("aInfo.", "letrados.superlinea2");
      if (CommonUtils.isNotNullNotBlack(value)) {
         ((QTextView)this.findViewById(2131361806)).setText(value2);
      }

   }

   public void onChangeProfileClick(View v) {
      ProgressDialog progressDialog = new ProgressDialog(this);
      progressDialog.setCancelable(false);
      progressDialog.setMessage(this.getString(2131886514));
      progressDialog.show();
      TealiumHelper.trackEvent("/ayuda", "ayuda (borrar datos)");
      PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(this.getBaseContext(), "loginPreferencesCrypt");
      preferencesHelper.setString("documentType", "");
      preferencesHelper.setString("documentNumber", "");
      preferencesHelper.setString("code", "");
      preferencesHelper.setString("authenticationTypeCode", "");
      preferencesHelper.setBoolean("companyMode", false);
      preferencesHelper.setBoolean("rememberMe", false);
      PreferencesHelper.newInstance(this).clear();
      KeyValueModel.getInstancePermanent().insertValue("pls", "", "");
      Intent intent = new Intent(this, BienvenidaViewPagerActivity.class);
      intent.setFlags(268468224);
      this.startActivity(intent);
      this.finish();
   }
}
