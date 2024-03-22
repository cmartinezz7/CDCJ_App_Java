package es.santander.justicia.minisJusticia.common;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import androidx.multidex.MultiDex;
import es.santander.justicia.BuildConfig;
import es.santander.justicia.http.CertificateProvider;
import es.santander.justicia.http.interfaces.CertDownload;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.NetworkUtils;
import es.santander.justicia.utils.PreferencesHelper;
import es.santander.justicia.utils.safetynet.Utils;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

public class MainApplication extends Application {
    public static final boolean COMPROBAR_INTEGRIDAD = false;
    public static final int DEFAULT_WS_CONNECT_TIMEOUT = 60000;
    public static final int DEFAULT_WS_READ_TIMEOUT = 60000;
    public static final String ENV_CERT = "CERT";
    public static String ENV_DEFAULT = ENV_PRE;
    public static final String ENV_MOCK = "MOCK";
    public static final String ENV_PRE = "PRE";
    public static final String ENV_PROD = "PROD";
    public static final String OFFICES_LOCATIONSe = "aFgFbvJfV0XVJdD4uclHi438KQz8q//wK+naG9yAxj1oeVd0bZqQbe/84f/cqvwikvwZQ1xMyvp9mvQlQRrgow==";
    public static final String PACKAGE_APP_EMPRESASe = "WpfrVFv/3blDuOOefCmz3fdsCFxrb05/scNk5XnCD5c=";
    public static final String PACKAGE_APP_LETRADOSe = "1MEhWjmlX0M0SNjfePQGqejhi1DO3cIu5KHXWVq8r/cX2X5DSLw+H1N94gBEmrjH";
    public static final String PACKAGE_APP_PARTICULARe = "WpfrVFv/3blDuOOefCmz3ULKXjrg0Yf2YEluVZ7OTAU=";
    public static final String SAFETYNET_API_KEYe = getString();
    public static final String URL_BANNERe = "0ZoS6CmDmUgyX5ZO3fQVTeea46YyotCNzmL7BTxeFVAu9OjbgLItlPUfEApykFJj52XHJt6/kndq51frnpo1cXTvSJy1hS9sHvjhAN3KhhM=";
    public static final String URL_CONFIG_INIT_DEFAULT = "LrVMkDw7vt7+iDkX9q6zPQ==";
    public static final String URL_CONFIG_INIT_LOCALe = "LrVMkDw7vt7+iDkX9q6zPQ==";
    public static final String URL_CONFIG_INIT_PRODUCCIONe = "NGgLaFo3m2Q6Vh5iJBUt1VEeB6bHjkIrK9588OXIstdS9RC29WyHLelROrWETKnmyGmVCN7CzRNuyKDZQwjCH0M8j9pRzvZaxLmtMfw98VRmj/PKLQbAaXeMRQUK0/X3";
    public static final String URL_ECYCLOPEDIAe = "TmFz7DplvKiFGGH0vDIwx0T8IgJULGZJF0UNDy40SLA7dgaFORVI/LGEWyBz+PNxMwgeN12fp3imUyqLASJUMQ==";
    public static final String URL_NEWSe = "DLULAZoaAELsD6ewvCTOad+izzZOSAtVspwrYrjYTc03LIx0pJXRKsJhGdYZJACpS0aIphezhn5IQESTwNZpyA==";
    public static final String URL_OFFERS_SANTANDERe = "aFgFbvJfV0XVJdD4uclHi2difGMGtAZocvUo5XUrCMdOPe6afVJAXqXJnheDE7nXJcbiEJ4eeo4oAiXYp3YwnmfsCe/axkDGrx48FIqyHz4=";
    private static MainApplication context;
    private String environment;
    private Boolean integrity;
    private String urlConfigInit;
    private UserDTO user;

    private static native String getInfo2();

    private static native String getInfo3();

    private static native String getString();

    static {
        System.loadLibrary("strings_module");
    }

    public static MainApplication getAppContext() {
        if (context == null) {
            context = new MainApplication();
        }
        return context;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String environment2) {
        this.environment = environment2;
    }

    public Boolean getIntegrity() {
        return this.integrity;
    }

    public void setIntegrity(Boolean integrity2) {
        this.integrity = integrity2;
    }

    public String getUrlConfigInit() {
        return this.urlConfigInit;
    }

    public void setUrlConfigInit(String urlConfigInit2) {
        this.urlConfigInit = urlConfigInit2;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context2) {
        super.attachBaseContext(context2);
        if (Build.VERSION.SDK_INT <= 21) {
            MultiDex.install(this);
        }
    }

    public void onCreate() {
        super.onCreate();
        context = this;
        if (!BuildConfig.SSL_ACTIVE.booleanValue()) {
            String environment2 = PreferencesHelper.newInstance(this).getString(Constants.PREFERENCE_ENVIRONMENT);
            if (environment2 == null) {
                environment2 = ENV_DEFAULT;
            }
            getAppContext().setEnvironment(environment2);
        } else {
            ENV_DEFAULT = ENV_PROD;
            getAppContext().setEnvironment(ENV_PROD);
            CertificateProvider.INSTANCE.provideCertificates(context, "PRO", new CertDownload() {
                public void OnCertsDownloaded(List<? extends Certificate> certificates) {
                    if (certificates != null) {
                        NetworkUtils.setCertificates((ArrayList) certificates);
                    }
                }

                public void OnCertsFailed(String error) {
                }
            });
        }
        setUrlConfigInit(getInfo("LrVMkDw7vt7+iDkX9q6zPQ=="));
        SQLiteDatabase.loadLibs(this);
        TealiumHelper.initialize(this);
    }

    public UserDTO getUser() {
        return this.user;
    }

    public void setUser(UserDTO user2) {
        this.user = user2;
    }

    public static String getInfo(String varInfo) {
        return Utils.decrypt(getInfo2(), getInfo3(), varInfo);
    }
}
