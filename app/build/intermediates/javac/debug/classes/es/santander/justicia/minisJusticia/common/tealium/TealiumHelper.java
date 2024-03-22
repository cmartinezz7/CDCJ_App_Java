package es.santander.justicia.minisJusticia.common.tealium;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build.VERSION;
import android.util.Log;
import android.webkit.WebView;
import com.tealium.library.Tealium;
import com.tealium.library.Tealium.Config;
import es.santander.justicia.BuildConfig;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import java.util.HashMap;
import java.util.Map;

public class TealiumHelper {
   public static final String TEALIUM_MAIN = "main";
   public static final String TEALIUM_ACCOUNT_NAME = "santander";
   public static final String TEALIUM_PROFILE_NAME = "es-app-justicia";
   public static final String TEALIUM_SCREEN_TITLE = "screen_title";
   public static final String TEALIUM_PERFIL_APP = "perfil_app";
   public static final String TEALIUM_PERFIL_PROFESIONAL = "perfil_profesional";
   public static final String TEALIUM_COD_CLIENTE = "cod_cliente";

   @SuppressLint({"NewApi"})
   public static void initialize(Application application) {
      if (Tealium.getInstance("main") == null) {
         String accountName = "santander";
         String profileName = "es-app-justicia";
         String environmentName = null;

         try {
            environmentName = KeyValueModel.getInstance().getValue("tealiumProp.environment.", MainApplication.getAppContext().getEnvironment());
            if (environmentName.indexOf(";;") != -1) {
               String[] listaProp = environmentName.split(";;");
               accountName = listaProp[0];
               profileName = listaProp[1];
               environmentName = listaProp[2];
            }
         } catch (Exception var5) {
            Log.e("TealiumHelper", "Archivo de configuracion no cargado todavía", var5);
         }

         if (environmentName != null) {
            if (VERSION.SDK_INT >= 19 && BuildConfig.DEBUG) {
               WebView.setWebContentsDebuggingEnabled(true);
            }

            Config config = Config.create(application, accountName, profileName, environmentName);
            Tealium.createInstance("main", config);
         }
      }

   }

   public static void trackView(String viewName) {
      trackView(viewName, getGenericData());
   }

   public static void trackView(String viewName, Map<String, String> data) {
      Tealium instance = Tealium.getInstance("main");
      if (instance != null) {
         instance.trackView(viewName, data);
      }

      Log.i("TealiumHelper", "View -> " + viewName + ", app: " + (String)data.get("perfil_app") + ", perfil: " + (String)data.get("perfil_profesional") + ", cod_cliente: " + (String)data.get("cod_cliente"));
   }

   public static void trackEvent(String viewName, String eventName) {
      trackEvent(viewName, eventName, getGenericData());
   }

   public static void trackEvent(String viewName, String eventName, Map<String, String> data) {
      Tealium instance = Tealium.getInstance("main");
      data.put("screen_title", viewName);
      if (instance != null) {
         instance.trackEvent(eventName, data);
      }

      Log.i("TealiumHelper", "Event -> " + eventName + ", viewName: " + viewName + ", app: " + (String)data.get("perfil_app") + ", perfil: " + (String)data.get("perfil_profesional") + ", cod_cliente: " + (String)data.get("cod_cliente"));
   }

   public static Map<String, String> getGenericData() {
      Map<String, String> data = new HashMap();
      UserDTO user = MainApplication.getAppContext().getUser();
      if (user != null) {
         if (user.getApp() != null) {
            data.put("perfil_app", user.getApp());
         }

         if (user.getUserType() != null) {
            data.put("perfil_profesional", user.getUserType());
         }

         if (user.getCodCliente() != null) {
            data.put("cod_cliente", user.getCodCliente());
         }
      }

      return data;
   }
}
