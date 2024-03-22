package es.santander.justicia.minisJusticia.common.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog.Builder;
import com.bancosantander.securitylibrary.certificates.ConnectionCore;
import com.scottyab.rootbeer.RootBeer;
import es.santander.justicia.minisJusticia.BienvenidaViewPagerActivity;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.activity.SplashActivity.1;
import es.santander.justicia.minisJusticia.common.activity.SplashActivity.3;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.common.tasks.NewsTask;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.controllers.InitConfigurationController;
import es.santander.justicia.minisJusticia.interfaces.InitConfigurationInterface;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.NetworkUtils;
import es.santander.justicia.utils.safetynet.SafetyNetHelper;

public class SplashActivity extends AppCompatActivity implements InitConfigurationInterface, ActivityCallBack {
   private ProgressDialog progressDialog;
   private InitConfigurationController initConfiguration;
   NewsTask newsTask;
   private static final String TAG = "SplashActivity";
   private SafetyNetHelper safetyNetHelper;
   private boolean newsLoaded;
   private boolean newsCheked;
   private boolean configuracionLoaded;
   private boolean configuracionCheked;
   private boolean integridadLoaded = false;
   private boolean integridadCheked;

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558756);
      this.getWindow().setFlags(1024, 1024);
   }

   protected void onResume() {
      super.onResume();
      RootBeer rootBeer = new RootBeer(this);
      if ("debug".equals("release") && rootBeer.isRooted()) {
         Builder builder = new Builder(this);
         builder.setCancelable(false);
         builder.setMessage(2131886791);
         AlertDialog dialog = builder.create();
         dialog.show();
      } else {
         this.initConfiguration = new InitConfigurationController(this.getBaseContext());
         this.initConfiguration.setCallback(this);
         this.initConfiguration.getInitConfiguration();
         if (MainApplication.ENV_DEFAULT.equals("PROD")) {
            boolean canContinue = true;
            if (isStoreVersion(this)) {
               Log.d("store", "I am from store");
            } else {
               canContinue = false;
               CommonUtils.showDeadlyMessage(this, "ESTA VERSION NO ES DE PLAY STORE");
            }

            if (this.checkEmulator(this)) {
               canContinue = false;
               CommonUtils.showDeadlyMessage(this, "APLICACIÓN NO DISPONIBLE PARA SIMULADORES");
            } else {
               Log.d("emulator", "I am an emulator");
            }

            if (canContinue) {
               this.configPinner();
            }
         } else {
            this.checkVersion();
         }
      }

   }

   protected void onDestroy() {
      super.onDestroy();
      if (this.progressDialog != null) {
         this.progressDialog.dismiss();
      }

      if (this.initConfiguration != null) {
         this.initConfiguration.setCallback((InitConfigurationInterface)null);
      }

      if (this.newsTask != null) {
         this.newsTask.setActivityCallBack((ActivityCallBack)null);
      }

   }

   public void onFinishInitConfiguration(boolean isSuccess, String extraMessage) {
      this.configuracionCheked = true;
      if (isSuccess) {
         this.configuracionLoaded = true;
      }

      this.iniciarAplicacion();
   }

   public void onTaskFinished(String taskID, Object result) {
      if ("NEWS".equals(taskID)) {
         this.newsCheked = true;
         this.newsLoaded = true;
      }

      this.iniciarAplicacion();
   }

   private void configPinner() {
      ConnectionCore connectionCore = new ConnectionCore(this);
      connectionCore.getPinner("https://microsite.bancosantander.es/files/security/certs_justicia.json", new 1(this));
   }

   private void configureApp(String minVersionMessage) {
      if (minVersionMessage == null) {
         this.progressDialog = new ProgressDialog(this);
         this.progressDialog.setCancelable(false);
         this.progressDialog.setMessage(this.getBaseContext().getResources().getString(2131886695));
         this.progressDialog.show();
         this.integridadLoaded = true;
         this.integridadCheked = true;
         this.newsTask = new NewsTask(this);
         this.newsTask.execute(new Object[0]);
      } else {
         CommonUtils.showVersionAppDialog(this, minVersionMessage);
      }

   }

   private synchronized void iniciarAplicacion() {
      if (this.newsCheked && this.configuracionCheked && this.integridadCheked) {
         if (this.progressDialog != null) {
            this.progressDialog.dismiss();
         }

         String textoDeError;
         if (this.newsLoaded && this.configuracionLoaded && this.integridadLoaded) {
            MainApplication.getAppContext().setIntegrity(this.integridadLoaded);
            textoDeError = KeyValueModel.getInstancePermanent().getValue("pls");
            Intent intent;
            if (textoDeError != null && !textoDeError.isEmpty()) {
               intent = new Intent(this, NewsActivity.class);
               this.startActivity(intent);
               this.finish();
            } else {
               intent = new Intent(this, BienvenidaViewPagerActivity.class);
               this.startActivity(intent);
               this.finish();
            }
         } else if (!NetworkUtils.isDeviceOnline()) {
            NetworkUtils.showRequestInternetDialog(this, 2131886792);
         } else {
            textoDeError = "Error al iniciar la aplicación";
            if (!this.configuracionLoaded) {
               textoDeError = "Error al cargar la aplicación";
            }

            if (!this.integridadLoaded) {
               textoDeError = "Error al comprobar la integridad de la aplicación";
            }

            Toast.makeText(this, textoDeError, 0).show();
         }
      }

   }

   private void checkVersion() {
      ConnectionBuilder.onlineParameteres(this).enqueue(new 3(this, this, false, false));
   }

   public static boolean isStoreVersion(Context context) {
      boolean result = false;

      try {
         String installer = context.getPackageManager().getInstallerPackageName(context.getPackageName());
         result = !TextUtils.isEmpty(installer);
         return result;
      } catch (Throwable var3) {
         return result;
      }
   }

   private boolean checkEmulator(Context context) {
      boolean emulator = false;
      Class SystemProperties = null;

      try {
         SystemProperties = Class.forName("android.os.SystemProperties");
      } catch (ClassNotFoundException var5) {
         Log.d("IOException", var5.getMessage());
      }

      TelephonyManager localTelephonyManager = (TelephonyManager)context.getSystemService("phone");
      if (Build.PRODUCT.contains("sdk")) {
         emulator = true;
      } else if (Build.MODEL.contains("sdk")) {
         emulator = true;
      } else if (localTelephonyManager.getSimOperatorName().equals("Android")) {
         emulator = true;
      } else if (localTelephonyManager.getNetworkOperatorName().equals("Android")) {
         emulator = true;
      } else if (System.getProperty(String.valueOf(SystemProperties), "ro.secure").equalsIgnoreCase("0")) {
         emulator = true;
      } else if (System.getProperty(String.valueOf(SystemProperties), "ro.kernel.qemu").equalsIgnoreCase("1")) {
         emulator = true;
      }

      return emulator;
   }

   // $FF: synthetic method
   static void access$000(SplashActivity x0) {
      x0.checkVersion();
   }

   // $FF: synthetic method
   static void access$100(SplashActivity x0, String x1) {
      x0.configureApp(x1);
   }
}
