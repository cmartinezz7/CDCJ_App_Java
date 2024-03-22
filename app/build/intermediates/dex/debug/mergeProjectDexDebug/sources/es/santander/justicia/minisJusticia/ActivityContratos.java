package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.adapters.AdapterContratos;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.requests.contratos.ContratoEntradaDetail;
import es.santander.justicia.minisJusticia.models.requests.obtenerDatosLoginLA.ObtenerDatosLoginEntradaDetail;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratoDetail;
import es.santander.justicia.minisJusticia.models.responses.contratos.ContratosConexionResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.obtenerDatosLoginLA.ObtenerDatosLoginMethodResultDetail;
import es.santander.justicia.minisJusticia.models.responses.obtenerDatosLoginLA.ObtenerDatosLoginResponseEnvelope;
import es.santander.justicia.minisJusticia.tasks.MergeloginUnicoTask;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import retrofit2.Call;
import retrofit2.Response;

public class ActivityContratos extends AppCompatActivity implements AdapterAbstractRecycler.OnRecyclerClickListener, ActivityCallBack {
    /* access modifiers changed from: private */
    public String auxToken;
    /* access modifiers changed from: private */
    public String usuarioRaf;

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityContratos, androidx.appcompat.app.AppCompatActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        ActivityContratos.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contratos);
        ((TextView) findViewById(R.id.text_desc)).setText(String.format(getString(R.string.contracts_desc), new Object[]{PreferencesHelper.newInstance(this).getString(Constants.PREFERENCE_ALIAS)}));
        String string = getIntent().getExtras().getString(Constants.EXTRA_USER_RAF);
        this.usuarioRaf = string;
        if (string == null || string.equals("")) {
            getContratosConexion();
            return;
        }
        findViewById(R.id.imageBack).setVisibility(4);
        findViewById(R.id.imageBack).setClickable(false);
        findViewById(R.id.recycler).setAdapter(new AdapterContratos(this, getIntent().getParcelableArrayListExtra(Constants.EXTRA_CONTRATCTS_LIST)));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityContratos] */
    private void getContratosConexion() {
        ContratoEntradaDetail contratoEntradaDetail = new ContratoEntradaDetail();
        contratoEntradaDetail.setToken(getIntent().getStringExtra(Constants.EXTRA_TOKEN_EMPRESAS));
        contratoEntradaDetail.setIndApoderadoDelegado(PreferencesHelper.newInstance(this).getString(Constants.PREFERENCE_APODERADO));
        contratoEntradaDetail.setIndListaRepos(getIntent().getStringExtra(Constants.EXTRA_LISTA_REPOSICION));
        contratoEntradaDetail.setAliasUsuConexion(PreferencesHelper.newInstance(this).getString(Constants.PREFERENCE_ALIAS));
        ConnectionBuilder.getContratosConexion(contratoEntradaDetail, this).enqueue(new RetrofitCallbackInterface<ContratosConexionResponseEnvelope>(this) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityContratos] */
            /* JADX WARNING: type inference failed for: r0v7, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityContratos] */
            public void onResponse(Call<ContratosConexionResponseEnvelope> call, Response<ContratosConexionResponseEnvelope> response) {
                if (response.body() == null) {
                    finishConnection("");
                } else if (!super.finishConnection(ActivityContratos.this, ((ContratosConexionResponseEnvelope) response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail().getInfoDetail().getToken(), "")) {
                } else {
                    if (response.errorBody() == null) {
                        PreferencesHelper.newInstance(ActivityContratos.this).setString(Constants.PREFERENCE_ALIAS, ((ContratosConexionResponseEnvelope) response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail().getAliasUsuConexion().trim());
                        String unused = ActivityContratos.this.auxToken = ((ContratosConexionResponseEnvelope) response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail().getToken();
                        String unused2 = ActivityContratos.this.usuarioRaf = ((ContratosConexionResponseEnvelope) response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail().getDatosRepo().getUsuarioRacfRepos();
                        ActivityContratos.this.findViewById(R.id.recycler).setAdapter(new AdapterContratos(ActivityContratos.this, ((ContratosConexionResponseEnvelope) response.body()).getLoginUnicoBody().getContratosMethodResult().getContratosMedhodResultDetail().getContratoDetails()));
                        return;
                    }
                    Toast.makeText(ActivityContratos.this.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
                }
            }

            public void onFailure(Call<ContratosConexionResponseEnvelope> call, Throwable t) {
                super.onFailure(call, t);
            }
        });
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityContratos] */
    private void obtenerDatosLogin(ContratoDetail contratoDetail) {
        String alias = contratoDetail.getAlias();
        String str = this.auxToken;
        if (str == null) {
            str = PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_TOKEN_LOGIN_UNICO);
        }
        ConnectionBuilder.obtenerDatosLogin(new ObtenerDatosLoginEntradaDetail(alias, str, this.usuarioRaf, ""), this).enqueue(new RetrofitCallbackInterface<ObtenerDatosLoginResponseEnvelope>(this) {
            /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityContratos] */
            /* JADX WARNING: type inference failed for: r2v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityContratos] */
            public void onResponse(Call<ObtenerDatosLoginResponseEnvelope> call, Response<ObtenerDatosLoginResponseEnvelope> response) {
                if (response.body() != null) {
                    ObtenerDatosLoginMethodResultDetail result = ((ObtenerDatosLoginResponseEnvelope) response.body()).getObtenerDatosLoginResponseBody().getObtenerDatosLoginMethodResult().getMethodResult();
                    if (super.finishConnection(ActivityContratos.this, result.getTokenEmpresas(), "")) {
                        UserDTO userDTO = new UserDTO();
                        userDTO.setToken(PreferencesHelper.newInstance(ActivityContratos.this).getString(Constants.PREFERECENCE_TOKEN_SSO));
                        userDTO.setApp(UserDTO.APP_PROFESIONALES);
                        userDTO.setUserType(UserDTO.USERTYPE_EMPRESAS);
                        userDTO.setNombre(result.getNombreTitular());
                        String tipoPersona = result.getCliente().getTipoPersona();
                        userDTO.setCodCliente(tipoPersona + "-" + result.getCliente().getCodigoPersona());
                        MainApplication.getAppContext().setUser(userDTO);
                        ActivityContratos.this.mergeLogin(result.getInfoDetail().getToken());
                        return;
                    }
                    return;
                }
                finishConnection("");
            }
        });
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityContratos, es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack] */
    /* access modifiers changed from: private */
    public void mergeLogin(String token) {
        PreferencesHelper.newInstance(this).setString(Constants.PREFERECENCE_TOKEN_LOGIN_UNICO, token);
        new MergeloginUnicoTask(this, token).execute(new Object[0]);
    }

    public void onBackClick(View view) {
        onBackPressed();
    }

    public void onItemClickListener(int position) {
        obtenerDatosLogin((ContratoDetail) findViewById(R.id.recycler).getAdapter().getAllItems().get(position));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityContratos] */
    public void onTaskFinished(String taskID, Object result) {
        Log.d("asd", "asd");
        startActivity(new Intent(this, HomeActivity.class));
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (!onFilterTouchEventForSecurity(ev)) {
            ((ViewGroup) ((ViewGroup) findViewById(16908290)).getChildAt(0)).setFilterTouchesWhenObscured(true);
        }
        return ActivityContratos.super.dispatchTouchEvent(ev);
    }

    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        if ((event.getFlags() & 1) == 1 || (event.getFlags() & 2) == 2) {
            return false;
        }
        return true;
    }
}
