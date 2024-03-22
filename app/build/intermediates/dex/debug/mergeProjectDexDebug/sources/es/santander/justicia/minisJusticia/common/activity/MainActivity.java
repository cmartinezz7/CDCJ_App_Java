package es.santander.justicia.minisJusticia.common.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.google.android.material.navigation.NavigationView;
import es.santander.branchlocator.BLUtils;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityContratos;
import es.santander.justicia.minisJusticia.ActivityHelp;
import es.santander.justicia.minisJusticia.BienvenidaViewPagerActivity;
import es.santander.justicia.minisJusticia.CourtSearcherActivityV2;
import es.santander.justicia.minisJusticia.HomeActivity;
import es.santander.justicia.minisJusticia.ListadoPeticionesActivity;
import es.santander.justicia.minisJusticia.MapsActivity;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.SolicitudAccesoActivity;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.MinJusticeDBHelper;
import es.santander.justicia.utils.PreferencesHelper;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Boolean Flag_ayuda = false;
    private MinJusticeDBHelper adminBB;
    private int navigationId;
    protected ProgressDialog progressDialog;
    private String tealiumName;

    /* JADX WARNING: type inference failed for: r2v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context, androidx.appcompat.app.AppCompatActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        MainActivity.super.onCreate(savedInstanceState);
        if (!MainApplication.getAppContext().getIntegrity().booleanValue()) {
            System.exit(0);
        }
        getWindow().setFlags(8192, 8192);
        this.adminBB = new MinJusticeDBHelper(this);
        Log.i("MainActivity", "Activity: " + getComponentName().getClassName());
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        MainActivity.super.onStart();
        if (getTealiumName() != null) {
            TealiumHelper.trackView(getTealiumName());
        }
        showContracts();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context] */
    public void forwardLogout() {
        Intent intent = new Intent(this, NewsActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    public void forward(Class<?> cls) {
        forward(cls, (Bundle) null);
    }

    public void forward(Class<?> cls, Bundle savedInstanceState) {
        forward(cls, (Bundle) null, -1);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context] */
    public void forward(Class<?> cls, Bundle savedInstanceState, int idTextoTransicion) {
        Intent intent;
        if (idTextoTransicion != -1) {
            showProgressDialog(idTextoTransicion);
        }
        if (LoginManager.getInstance().isUserLogged() || cls.getSimpleName().startsWith("Login")) {
            intent = new Intent(this, cls);
        } else {
            intent = new Intent(this, BienvenidaViewPagerActivity.class);
            intent.setFlags(268468224);
        }
        if (savedInstanceState == null) {
            startActivity(intent);
        } else {
            startActivity(intent, savedInstanceState);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        MainActivity.super.onDestroy();
        closeProgressDialog();
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context, android.app.Activity] */
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id != getNavigationId()) {
            if (id == 2131362713) {
                startActivity(new Intent(this, SolicitudAccesoActivity.class));
                finish();
                item.setChecked(true);
            } else if (id == 2131362421) {
                item.setChecked(true);
                startActivity(new Intent(this, ListadoPeticionesActivity.class));
                finish();
            } else if (id == 2131362040) {
                item.setChecked(true);
                startActivity(new Intent(this, HomeActivity.class));
                finish();
            } else if (id == 2131362445) {
                startActivity(new Intent(this, CourtSearcherActivityV2.class));
                finish();
            } else if (id == 2131362446) {
                if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    BLUtils.launchBranchLocator(this, false, true);
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, MapsActivity.LOCATION_REQUEST_PERMISSION);
                }
            } else if (id == 2131361913) {
                item.setChecked(true);
                Bundle bundle = new Bundle();
                bundle.putBoolean("flag_ayuda", this.Flag_ayuda.booleanValue());
                Intent intent = new Intent(this, ActivityHelp.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            } else if (id == 2131361994) {
                item.setChecked(true);
                logout();
            }
        }
        findViewById(R.id.drawer_layout).closeDrawer(8388611);
        return true;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context, androidx.appcompat.app.AppCompatActivity] */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        MainActivity.super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != MapsActivity.LOCATION_REQUEST_PERMISSION) {
            return;
        }
        if (grantResults.length == 1 && grantResults[0] == 0) {
            BLUtils.launchBranchLocator(this, false, true);
        } else {
            Toast.makeText(this, "No se realizó la busqueda por falta de permisos", 0).show();
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context] */
    private void showContracts() {
        ImageView imageContratos = (ImageView) findViewById(R.id.imageContratos);
        if (imageContratos == null) {
            return;
        }
        if (PreferencesHelper.newInstance(this).getBoolean(Constants.EXTRA_SHOW_CONTRACTS)) {
            imageContratos.setVisibility(0);
            imageContratos.setOnClickListener(new View.OnClickListener() {
                /* JADX WARNING: type inference failed for: r1v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context] */
                /* JADX WARNING: type inference failed for: r1v1, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context] */
                /* JADX WARNING: type inference failed for: r1v5, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context] */
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, ActivityContratos.class);
                    intent.putExtra(Constants.EXTRA_TOKEN_EMPRESAS, PreferencesHelper.newInstance(MainActivity.this).getString(Constants.PREFERECENCE_TOKEN_LOGIN_UNICO));
                    intent.putExtra(Constants.EXTRA_LISTA_REPOSICION, "L");
                    intent.putExtra(Constants.PREFERENCE_ALIAS, PreferencesHelper.newInstance(MainActivity.this).getString(Constants.PREFERENCE_ALIAS));
                    MainActivity.this.startActivity(intent);
                }
            });
            return;
        }
        imageContratos.setVisibility(8);
    }

    public int findIdByName(String name) {
        return getResources().getIdentifier(name, "id", getPackageName());
    }

    public String getStringResourceByName(String aString) {
        try {
            int resId = getResources().getIdentifier(aString, "string", getPackageName());
            if (resId > 0) {
                return getString(resId);
            }
            return null;
        } catch (Exception e) {
            Log.e("MainActivity", "Error al recueprar un recurso por su nombre", e);
            return null;
        }
    }

    public void showProgressDialog(int id) {
        showProgressDialog(getBaseContext().getResources().getString(id));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context] */
    public void showProgressDialog(String texto) {
        try {
            this.progressDialog = ProgressDialog.show(this, "", texto);
        } catch (Exception e) {
            Log.e("SplashActivity", "Error al mostrar la pantalla", e);
        }
    }

    public void closeProgressDialog() {
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null) {
            progressDialog2.dismiss();
        }
    }

    public String getTealiumName() {
        return this.tealiumName;
    }

    public void setTealiumName(String tealiumName2) {
        this.tealiumName = tealiumName2;
    }

    public int getNavigationId() {
        return this.navigationId;
    }

    public void setNavigationId(int navigationId2) {
        this.navigationId = navigationId2;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (!onFilterTouchEventForSecurity(ev)) {
            ((ViewGroup) ((ViewGroup) findViewById(16908290)).getChildAt(0)).setFilterTouchesWhenObscured(true);
        }
        return MainActivity.super.dispatchTouchEvent(ev);
    }

    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        if ((event.getFlags() & 1) == 1 || (event.getFlags() & 2) == 2) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context] */
    public void logout() {
        ConnectionBuilder.logout().enqueue(new RetrofitCallbackInterface<Void>(this) {
            public void onFailure(Call<Void> call, Throwable t) {
                super.onFailure(call, t);
                Log.d("Logout", t.getMessage());
                LoginManager.getInstance().logout();
                MainActivity.this.forwardLogout();
            }

            public void onResponse(Call<Void> call, Response<Void> response) {
                super.onResponse(call, response);
                Log.d("Logout", "success");
                TealiumHelper.trackEvent("/menu/logout", "logout");
                LoginManager.getInstance().logout();
                MainActivity.this.forwardLogout();
            }
        });
    }
}
