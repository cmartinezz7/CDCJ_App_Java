package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados.1;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados.2;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados.3;
import es.santander.justicia.minisJusticia.adapters.AdapterDrawerLetrados;
import es.santander.justicia.minisJusticia.connections.RetrofitUtility;
import es.santander.justicia.minisJusticia.models.responses.detalleUsuario.DetalleUsuario;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.Locale;

public class ActivityHomeLetrados extends ActivityAbstractLetrados {
   public static final String USER_DETAIL_READY = "user-detail-ready";
   private Toolbar mToolbar;
   private DrawerLayout mDrawerLayout;
   private ImageView mEdit;
   private ActionBarDrawerToggle mDrawerToogle;
   private ListView mListDrawer;
   private QFontTextView mTextTitleToolbar;
   private QTextView mTextLogOut;
   public boolean mConnIsRunning;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558445);
      this.initComponents();
   }

   protected void onPostCreate(Bundle savedInstanceState) {
      super.onPostCreate(savedInstanceState);
      if (this.mDrawerToogle != null) {
         this.mDrawerToogle.syncState();
      }

   }

   public void onConfigurationChanged(Configuration newConfig) {
      super.onConfigurationChanged(newConfig);
      if (this.mDrawerToogle != null) {
         this.mDrawerToogle.onConfigurationChanged(newConfig);
      }

   }

   private void initComponents() {
      RetrofitUtility.updateToken = PreferencesHelper.newInstance(this).getString("preference_token_sso");
      this.mToolbar = (Toolbar)this.findViewById(2131362965);
      this.mDrawerLayout = (DrawerLayout)this.findViewById(2131362106);
      this.mListDrawer = (ListView)this.findViewById(2131362419);
      this.mTextLogOut = (QTextView)this.findViewById(2131362901);
      this.mEdit = (ImageView)this.findViewById(2131362308);
      this.mTextTitleToolbar = (QFontTextView)this.findViewById(2131362931);
      this.mTextLogOut.setOnClickListener(new 1(this));
      this.initDrawer();
      this.getCall();
      this.replaceFragment(2131886568, (Bundle)null);
   }

   private void initDrawer() {
      View header = this.getLayoutInflater().inflate(2131558602, (ViewGroup)null);
      this.mListDrawer.addHeaderView(header);
      this.mListDrawer.setAdapter(new AdapterDrawerLetrados(this));
      this.mDrawerToogle = new 2(this, this, this.mDrawerLayout, this.mToolbar, 2131886126, 2131886126);
      this.mDrawerLayout.addDrawerListener(this.mDrawerToogle);
      this.mListDrawer.setOnItemClickListener(new 3(this));
   }

   public void onSelectTribunalClick(View v) {
      Intent intent = new Intent(this.getBaseContext(), ActivitySelectTribunal.class);
      this.startActivity(intent);
   }

   public void simulateClick(int i) {
      this.mListDrawer.performItemClick(this.mListDrawer.getRootView(), i, 0L);
   }

   public void loadAuthFromAdvices() {
      ((AdapterDrawerLetrados)((HeaderViewListAdapter)this.mListDrawer.getAdapter()).getWrappedAdapter()).setmSelectedPosition(CommonUtils.findIdPosition(this.getResources().obtainTypedArray(2130903041), 2131886571));
      this.mTextLogOut.setSelected(false);
      Bundle bundle = new Bundle();
      bundle.putString("extra_filter", "PE");
      this.replaceFragment(2131886571, bundle);
   }

   public void loadOperationsFromAdvices() {
      ((AdapterDrawerLetrados)((HeaderViewListAdapter)this.mListDrawer.getAdapter()).getWrappedAdapter()).setmSelectedPosition(CommonUtils.findIdPosition(this.getResources().obtainTypedArray(2130903041), 2131886585));
      this.mTextLogOut.setSelected(false);
      this.replaceFragment(2131886585, (Bundle)null);
   }

   public void loadFromAuthJuz() {
      ((AdapterDrawerLetrados)((HeaderViewListAdapter)this.mListDrawer.getAdapter()).getWrappedAdapter()).setmSelectedPosition(CommonUtils.findIdPosition(this.getResources().obtainTypedArray(2130903041), 2131886570));
      this.mTextLogOut.setSelected(false);
      Bundle bundle = new Bundle();
      bundle.putString("extra_filter", "PE");
      this.replaceFragment(2131886570, bundle);
   }

   public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      Fragment fragment = this.getSupportFragmentManager().findFragmentByTag(this.getString(2131886573));
      if (fragment != null && fragment.isVisible()) {
         fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
      }

   }

   private void getCall() {
      Bundle extra = this.getIntent().getExtras();
      if (extra != null) {
         DetalleUsuario detalleUsuario = (DetalleUsuario)extra.getSerializable("user_detail");
         ((QTextView)this.mListDrawer.findViewById(2131362906)).setText(String.format("%s %s %s", this.capitalizeFirstLetter(detalleUsuario.getNombreUsuario()), this.capitalizeFirstLetter(detalleUsuario.getApellidoPrimero()), this.capitalizeFirstLetter(detalleUsuario.getApellidoSegundo())));
         Intent intent = new Intent("user-detail-ready");
         LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
      }

   }

   private String capitalizeFirstLetter(String name) {
      return name.isEmpty() ? name : name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1).toLowerCase(Locale.ROOT);
   }

   private void replaceFragment(int fragmentId, Bundle args) {
      if (fragmentId == -1) {
         fragmentId = 2131886568;
      }

      FragmentManager fragmentManger = this.getSupportFragmentManager();
      fragmentManger.beginTransaction().replace(2131362041, es.santander.justicia.minisJusticia.ActivityHomeLetrados.PlaceholderFragment.newInstance(fragmentId, args), this.getString(fragmentId)).commit();
      this.mDrawerLayout.closeDrawer(3);
   }

   public void onSectionAttached(int section) {
      if (section == 2131886584) {
         this.mTextTitleToolbar.setText(this.getString(2131886664));
      } else if (this.mTextTitleToolbar != null) {
         this.mTextTitleToolbar.setText(this.getString(section));
      }

      switch(section) {
      case 2131886568:
         if (this.mEdit != null) {
            this.mEdit.setVisibility(0);
         }
         break;
      default:
         if (this.mEdit != null) {
            this.mEdit.setVisibility(4);
         }
      }

   }

   // $FF: synthetic method
   static ListView access$000(ActivityHomeLetrados x0) {
      return x0.mListDrawer;
   }

   // $FF: synthetic method
   static QTextView access$100(ActivityHomeLetrados x0) {
      return x0.mTextLogOut;
   }

   // $FF: synthetic method
   static void access$200(ActivityHomeLetrados x0, int x1, Bundle x2) {
      x0.replaceFragment(x1, x2);
   }
}
