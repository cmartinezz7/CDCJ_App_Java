package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import es.santander.justicia.minisJusticia.ActivityAbstractLetrados.1;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.PreferencesHelper;

public abstract class ActivityAbstractLetrados extends AppCompatActivity {
   protected QTextView mTextUser;
   protected QTextView mTextOrganism;

   public void onBackClick(View v) {
      this.onBackPressed();
   }

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      if (!MainApplication.getAppContext().getIntegrity()) {
         System.exit(0);
      }

      if (VERSION.SDK_INT >= 11) {
         this.getWindow().setFlags(8192, 8192);
      }

   }

   protected void onResume() {
      super.onResume();
      View edit = this.findViewById(2131362308);
      if (edit != null) {
         if (this instanceof ActivityHomeLetrados) {
            Fragment fragment = this.getSupportFragmentManager().findFragmentByTag(this.getString(2131886568));
            if (fragment != null && fragment.isVisible()) {
               edit.setVisibility(0);
            } else {
               edit.setVisibility(4);
            }
         } else {
            edit.setVisibility(4);
         }
      }

      this.updateHeader();
   }

   protected void updateHeader() {
      if (this.mTextUser == null) {
         this.mTextUser = (QTextView)this.findViewById(2131362948);
      }

      if (this.mTextOrganism == null) {
         this.mTextOrganism = (QTextView)this.findViewById(2131362910);
      }

      if (this.mTextUser != null) {
         this.mTextUser.setText(String.format(this.getString(2131886811), PreferencesHelper.newInstance(this).getString("preference_user")));
      }

      if (this.mTextOrganism != null) {
         this.mTextOrganism.setText(String.format(this.getString(2131886667), PreferencesHelper.newInstance(this).getString("preference_cod_uo")));
      }

   }

   protected Context getContext() {
      return this;
   }

   public boolean dispatchTouchEvent(MotionEvent ev) {
      if (!this.onFilterTouchEventForSecurity(ev)) {
         ViewGroup viewGroup = (ViewGroup)((ViewGroup)this.findViewById(16908290)).getChildAt(0);
         viewGroup.setFilterTouchesWhenObscured(true);
      }

      return super.dispatchTouchEvent(ev);
   }

   public boolean onFilterTouchEventForSecurity(MotionEvent event) {
      boolean touchEventDispatched = true;
      if ((event.getFlags() & 1) == 1 || (event.getFlags() & 2) == 2) {
         touchEventDispatched = false;
      }

      return touchEventDispatched;
   }

   public void logout() {
      ConnectionBuilder.logout().enqueue(new 1(this, this));
   }

   public void forwardLogout() {
      PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(this);
      if (preferencesHelper.getBoolean("preference_remember_data", false)) {
         String code = preferencesHelper.getString("preference_user_login");
         String document = preferencesHelper.getString("preference_user_document");
         String name = preferencesHelper.getString("preference_user_login_name");
         String type = preferencesHelper.getString("preference_user_type_document");
         preferencesHelper.clear();
         preferencesHelper.setBoolean("preference_remember_data", true);
         preferencesHelper.setString("preference_user_document", document);
         preferencesHelper.setString("preference_user_login", code);
         preferencesHelper.setString("preference_user_login_name", name);
         preferencesHelper.setString("preference_user_type_document", type);
      } else {
         preferencesHelper.clear();
      }

      Intent intent = new Intent(this, NewsActivity.class);
      intent.setFlags(268468224);
      this.startActivity(intent);
      this.finish();
   }
}
