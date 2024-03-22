package es.santander.justicia.minisJusticia.common.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;
import es.santander.branchlocator.BLUtils;
import es.santander.justicia.minisJusticia.ActivityHelp;
import es.santander.justicia.minisJusticia.BienvenidaViewPagerActivity;
import es.santander.justicia.minisJusticia.CourtSearcherActivityV2;
import es.santander.justicia.minisJusticia.HomeActivity;
import es.santander.justicia.minisJusticia.ListadoPeticionesActivity;
import es.santander.justicia.minisJusticia.MapsActivity;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.activity.MainActivity.1;
import es.santander.justicia.minisJusticia.common.activity.MainActivity.2;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.utils.MinJusticeDBHelper;
import es.santander.justicia.utils.PreferencesHelper;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {
   private String tealiumName;
   private int navigationId;
   protected ProgressDialog progressDialog;
   private Boolean Flag_ayuda = false;
   private MinJusticeDBHelper adminBB;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      if (!MainApplication.getAppContext().getIntegrity()) {
         System.exit(0);
      }

      this.getWindow().setFlags(8192, 8192);
      this.adminBB = new MinJusticeDBHelper(this);
      Log.i("MainActivity", "Activity: " + this.getComponentName().getClassName());
   }

   protected void onStart() {
      super.onStart();
      if (this.getTealiumName() != null) {
         TealiumHelper.trackView(this.getTealiumName());
      }

      this.showContracts();
   }

   public void forwardLogout() {
      Intent intent = new Intent(this, NewsActivity.class);
      intent.setFlags(268468224);
      this.startActivity(intent);
      this.finish();
   }

   public void forward(Class<?> cls) {
      this.forward(cls, (Bundle)null);
   }

   public void forward(Class<?> cls, Bundle savedInstanceState) {
      this.forward(cls, (Bundle)null, -1);
   }

   public void forward(Class<?> cls, Bundle savedInstanceState, int idTextoTransicion) {
      Intent intent = null;
      if (idTextoTransicion != -1) {
         this.showProgressDialog(idTextoTransicion);
      }

      if (!LoginManager.getInstance().isUserLogged() && !cls.getSimpleName().startsWith("Login")) {
         intent = new Intent(this, BienvenidaViewPagerActivity.class);
         intent.setFlags(268468224);
      } else {
         intent = new Intent(this, cls);
      }

      if (savedInstanceState == null) {
         this.startActivity(intent);
      } else {
         this.startActivity(intent, savedInstanceState);
      }

   }

   protected void onDestroy() {
      super.onDestroy();
      this.closeProgressDialog();
   }

   public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      int id = item.getItemId();
      if (id != this.getNavigationId()) {
         Intent intent;
         if (id == 2131362713) {
            intent = new Intent(this, SolicitudAccesoActivity.class);
            this.startActivity(intent);
            this.finish();
            item.setChecked(true);
         } else if (id == 2131362421) {
            item.setChecked(true);
            intent = new Intent(this, ListadoPeticionesActivity.class);
            this.startActivity(intent);
            this.finish();
         } else if (id == 2131362040) {
            item.setChecked(true);
            intent = new Intent(this, HomeActivity.class);
            this.startActivity(intent);
            this.finish();
         } else if (id == 2131362445) {
            intent = new Intent(this, CourtSearcherActivityV2.class);
            this.startActivity(intent);
            this.finish();
         } else if (id == 2131362446) {
            if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
               ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, MapsActivity.LOCATION_REQUEST_PERMISSION);
            } else {
               BLUtils.launchBranchLocator(this, false, true);
            }
         } else if (id == 2131361913) {
            item.setChecked(true);
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag_ayuda", this.Flag_ayuda);
            Intent intent = new Intent(this, ActivityHelp.class);
            intent.putExtras(bundle);
            this.startActivity(intent);
            this.finish();
         } else if (id == 2131361994) {
            item.setChecked(true);
            this.logout();
         }
      }

      DrawerLayout drawer = (DrawerLayout)this.findViewById(2131362106);
      drawer.closeDrawer(8388611);
      return true;
   }

   public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      super.onRequestPermissionsResult(requestCode, permissions, grantResults);
      if (requestCode == MapsActivity.LOCATION_REQUEST_PERMISSION) {
         if (grantResults.length == 1 && grantResults[0] == 0) {
            BLUtils.launchBranchLocator(this, false, true);
         } else {
            Toast.makeText(this, "No se realizó la busqueda por falta de permisos", 0).show();
         }
      }

   }

   private void showContracts() {
      ImageView imageContratos = (ImageView)this.findViewById(2131362288);
      if (imageContratos != null) {
         if (PreferencesHelper.newInstance(this).getBoolean("extra_show_contracts")) {
            imageContratos.setVisibility(0);
            imageContratos.setOnClickListener(new 1(this));
         } else {
            imageContratos.setVisibility(8);
         }
      }

   }

   public int findIdByName(String name) {
      return this.getResources().getIdentifier(name, "id", this.getPackageName());
   }

   public String getStringResourceByName(String aString) {
      try {
         int resId = this.getResources().getIdentifier(aString, "string", this.getPackageName());
         if (resId > 0) {
            return this.getString(resId);
         }
      } catch (Exception var3) {
         Log.e("MainActivity", "Error al recueprar un recurso por su nombre", var3);
      }

      return null;
   }

   public void showProgressDialog(int id) {
      this.showProgressDialog(this.getBaseContext().getResources().getString(id));
   }

   public void showProgressDialog(String texto) {
      try {
         this.progressDialog = ProgressDialog.show(this, "", texto);
      } catch (Exception var3) {
         Log.e("SplashActivity", "Error al mostrar la pantalla", var3);
      }

   }

   public void closeProgressDialog() {
      if (this.progressDialog != null) {
         this.progressDialog.dismiss();
      }

   }

   public String getTealiumName() {
      return this.tealiumName;
   }

   public void setTealiumName(String tealiumName) {
      this.tealiumName = tealiumName;
   }

   public int getNavigationId() {
      return this.navigationId;
   }

   public void setNavigationId(int navigationId) {
      this.navigationId = navigationId;
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
      ConnectionBuilder.logout().enqueue(new 2(this, this));
   }
}
