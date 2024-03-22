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
import com.bancosantander.securitylibrary.certificates.ConnectionCore;
import com.scottyab.rootbeer.RootBeer;
import es.santander.justicia.BuildConfig;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.BienvenidaViewPagerActivity;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.common.tasks.NewsTask;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.connections.RetrofitUtility;
import es.santander.justicia.minisJusticia.controllers.InitConfigurationController;
import es.santander.justicia.minisJusticia.interfaces.InitConfigurationInterface;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.NetworkUtils;
import es.santander.justicia.utils.safetynet.SafetyNetHelper;
import java.io.IOException;
import okhttp3.CertificatePinner;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity implements InitConfigurationInterface, ActivityCallBack {
    private static final String TAG = "SplashActivity";
    private boolean configuracionCheked;
    private boolean configuracionLoaded;
    private InitConfigurationController initConfiguration;
    private boolean integridadCheked;
    private boolean integridadLoaded = false;
    private boolean newsCheked;
    private boolean newsLoaded;
    NewsTask newsTask;
    private ProgressDialog progressDialog;
    private SafetyNetHelper safetyNetHelper;

    public void onCreate(Bundle savedInstanceState) {
        SplashActivity.super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        getWindow().setFlags(1024, 1024);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.interfaces.InitConfigurationInterface, es.santander.justicia.minisJusticia.common.activity.SplashActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onResume() {
        SplashActivity.super.onResume();
        RootBeer rootBeer = new RootBeer(this);
        if (!BuildConfig.BUILD_TYPE.equals("release") || !rootBeer.isRooted()) {
            InitConfigurationController initConfigurationController = new InitConfigurationController(getBaseContext());
            this.initConfiguration = initConfigurationController;
            initConfigurationController.setCallback(this);
            this.initConfiguration.getInitConfiguration();
            if (MainApplication.ENV_DEFAULT.equals(MainApplication.ENV_PROD)) {
                boolean canContinue = true;
                if (isStoreVersion(this)) {
                    Log.d("store", "I am from store");
                } else {
                    canContinue = false;
                    CommonUtils.showDeadlyMessage(this, "ESTA VERSION NO ES DE PLAY STORE");
                }
                if (checkEmulator(this)) {
                    canContinue = false;
                    CommonUtils.showDeadlyMessage(this, "APLICACIÓN NO DISPONIBLE PARA SIMULADORES");
                } else {
                    Log.d("emulator", "I am an emulator");
                }
                if (canContinue) {
                    configPinner();
                    return;
                }
                return;
            }
            checkVersion();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(R.string.text_root_detected);
        builder.create().show();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        SplashActivity.super.onDestroy();
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null) {
            progressDialog2.dismiss();
        }
        InitConfigurationController initConfigurationController = this.initConfiguration;
        if (initConfigurationController != null) {
            initConfigurationController.setCallback((InitConfigurationInterface) null);
        }
        NewsTask newsTask2 = this.newsTask;
        if (newsTask2 != null) {
            newsTask2.setActivityCallBack((ActivityCallBack) null);
        }
    }

    public void onFinishInitConfiguration(boolean isSuccess, String extraMessage) {
        this.configuracionCheked = true;
        if (isSuccess) {
            this.configuracionLoaded = true;
        }
        iniciarAplicacion();
    }

    public void onTaskFinished(String taskID, Object result) {
        if (NewsTask.TASK_ID.equals(taskID)) {
            this.newsCheked = true;
            this.newsLoaded = true;
        }
        iniciarAplicacion();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.common.activity.SplashActivity] */
    private void configPinner() {
        new ConnectionCore(this).getPinner("https://microsite.bancosantander.es/files/security/certs_justicia.json", new ConnectionCore.CertsPinDownloadListener() {
            public void certsDownloadedSuccessfully(Object o) {
                RetrofitUtility.certificatePinner = (CertificatePinner) o;
                Log.d("Pinning", "Pinning OK");
                SplashActivity.this.checkVersion();
            }

            public void certsDownloadFailed() {
                Log.d("Pinning", "Pinning ERROR");
            }
        });
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack, es.santander.justicia.minisJusticia.common.activity.SplashActivity, android.app.Activity] */
    /* access modifiers changed from: private */
    public void configureApp(String minVersionMessage) {
        if (minVersionMessage == null) {
            ProgressDialog progressDialog2 = new ProgressDialog(this);
            this.progressDialog = progressDialog2;
            progressDialog2.setCancelable(false);
            this.progressDialog.setMessage(getBaseContext().getResources().getString(R.string.please_wait_downloading_init_configuration));
            this.progressDialog.show();
            this.integridadLoaded = true;
            this.integridadCheked = true;
            NewsTask newsTask2 = new NewsTask(this);
            this.newsTask = newsTask2;
            newsTask2.execute(new Object[0]);
            return;
        }
        CommonUtils.showVersionAppDialog(this, minVersionMessage);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.common.activity.SplashActivity, android.app.Activity] */
    private synchronized void iniciarAplicacion() {
        if (this.newsCheked && this.configuracionCheked && this.integridadCheked) {
            ProgressDialog progressDialog2 = this.progressDialog;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
            if (this.newsLoaded && this.configuracionLoaded && this.integridadLoaded) {
                MainApplication.getAppContext().setIntegrity(Boolean.valueOf(this.integridadLoaded));
                String pls = KeyValueModel.getInstancePermanent().getValue(KeyValueModel.PROFESIONAL_LETRADO_SELECCION);
                if (pls != null) {
                    if (!pls.isEmpty()) {
                        startActivity(new Intent(this, NewsActivity.class));
                        finish();
                    }
                }
                startActivity(new Intent(this, BienvenidaViewPagerActivity.class));
                finish();
            } else if (!NetworkUtils.isDeviceOnline()) {
                NetworkUtils.showRequestInternetDialog(this, R.string.there_are_not_internet);
            } else {
                String textoDeError = "Error al iniciar la aplicación";
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

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.common.activity.SplashActivity] */
    /* access modifiers changed from: private */
    public void checkVersion() {
        ConnectionBuilder.onlineParameteres(this).enqueue(new RetrofitCallbackInterface<ResponseBody>(this, false, false) {
            /* JADX WARNING: type inference failed for: r0v6, types: [android.content.Context, es.santander.justicia.minisJusticia.common.activity.SplashActivity] */
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.body() == null || ((ResponseBody) response.body()).string() == null) {
                        SplashActivity.this.configureApp((String) null);
                        return;
                    }
                    ? r0 = SplashActivity.this;
                    r0.configureApp(CommonUtils.validAppVersion(r0, ((ResponseBody) response.body()).string()));
                } catch (IOException e) {
                    Log.d("IOException", e.getMessage());
                }
            }

            public void onFailure(Call<ResponseBody> call, Throwable t) {
                super.onFailure(call, t);
                SplashActivity.this.configureApp((String) null);
            }
        });
    }

    public static boolean isStoreVersion(Context context) {
        try {
            return !TextUtils.isEmpty(context.getPackageManager().getInstallerPackageName(context.getPackageName()));
        } catch (Throwable th) {
            return false;
        }
    }

    private boolean checkEmulator(Context context) {
        Class SystemProperties = null;
        try {
            SystemProperties = Class.forName("android.os.SystemProperties");
        } catch (ClassNotFoundException e) {
            Log.d("IOException", e.getMessage());
        }
        TelephonyManager localTelephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (!Build.PRODUCT.contains("sdk") && !Build.MODEL.contains("sdk") && !localTelephonyManager.getSimOperatorName().equals("Android") && !localTelephonyManager.getNetworkOperatorName().equals("Android") && !System.getProperty(String.valueOf(SystemProperties), "ro.secure").equalsIgnoreCase("0") && !System.getProperty(String.valueOf(SystemProperties), "ro.kernel.qemu").equalsIgnoreCase("1")) {
            return false;
        }
        return true;
    }
}
