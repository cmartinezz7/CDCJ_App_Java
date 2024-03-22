package es.santander.justicia.minisJusticia.common.tealium;

import android.app.Application;
import android.os.Build;
import android.util.Log;
import android.webkit.WebView;
import com.tealium.library.Tealium;
import es.santander.justicia.BuildConfig;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import java.util.HashMap;
import java.util.Map;

public class TealiumHelper {
    public static final String TEALIUM_ACCOUNT_NAME = "santander";
    public static final String TEALIUM_COD_CLIENTE = "cod_cliente";
    public static final String TEALIUM_MAIN = "main";
    public static final String TEALIUM_PERFIL_APP = "perfil_app";
    public static final String TEALIUM_PERFIL_PROFESIONAL = "perfil_profesional";
    public static final String TEALIUM_PROFILE_NAME = "es-app-justicia";
    public static final String TEALIUM_SCREEN_TITLE = "screen_title";

    public static void initialize(Application application) {
        if (Tealium.getInstance(TEALIUM_MAIN) == null) {
            String accountName = TEALIUM_ACCOUNT_NAME;
            String profileName = TEALIUM_PROFILE_NAME;
            String environmentName = null;
            try {
                environmentName = KeyValueModel.getInstance().getValue(KeyValueModel.TEALIUM_ENVIRONMENT, MainApplication.getAppContext().getEnvironment());
                if (environmentName.indexOf(";;") != -1) {
                    String[] listaProp = environmentName.split(";;");
                    accountName = listaProp[0];
                    profileName = listaProp[1];
                    environmentName = listaProp[2];
                }
            } catch (Exception e) {
                Log.e("TealiumHelper", "Archivo de configuracion no cargado todavía", e);
            }
            if (environmentName != null) {
                if (Build.VERSION.SDK_INT >= 19 && BuildConfig.DEBUG) {
                    WebView.setWebContentsDebuggingEnabled(true);
                }
                Tealium.createInstance(TEALIUM_MAIN, Tealium.Config.create(application, accountName, profileName, environmentName));
            }
        }
    }

    public static void trackView(String viewName) {
        trackView(viewName, getGenericData());
    }

    public static void trackView(String viewName, Map<String, String> data) {
        Tealium instance = Tealium.getInstance(TEALIUM_MAIN);
        if (instance != null) {
            instance.trackView(viewName, data);
        }
        Log.i("TealiumHelper", "View -> " + viewName + ", app: " + data.get(TEALIUM_PERFIL_APP) + ", perfil: " + data.get(TEALIUM_PERFIL_PROFESIONAL) + ", cod_cliente: " + data.get(TEALIUM_COD_CLIENTE));
    }

    public static void trackEvent(String viewName, String eventName) {
        trackEvent(viewName, eventName, getGenericData());
    }

    public static void trackEvent(String viewName, String eventName, Map<String, String> data) {
        Tealium instance = Tealium.getInstance(TEALIUM_MAIN);
        data.put(TEALIUM_SCREEN_TITLE, viewName);
        if (instance != null) {
            instance.trackEvent(eventName, data);
        }
        Log.i("TealiumHelper", "Event -> " + eventName + ", viewName: " + viewName + ", app: " + data.get(TEALIUM_PERFIL_APP) + ", perfil: " + data.get(TEALIUM_PERFIL_PROFESIONAL) + ", cod_cliente: " + data.get(TEALIUM_COD_CLIENTE));
    }

    public static Map<String, String> getGenericData() {
        Map<String, String> data = new HashMap<>();
        UserDTO user = MainApplication.getAppContext().getUser();
        if (user != null) {
            if (user.getApp() != null) {
                data.put(TEALIUM_PERFIL_APP, user.getApp());
            }
            if (user.getUserType() != null) {
                data.put(TEALIUM_PERFIL_PROFESIONAL, user.getUserType());
            }
            if (user.getCodCliente() != null) {
                data.put(TEALIUM_COD_CLIENTE, user.getCodCliente());
            }
        }
        return data;
    }
}
