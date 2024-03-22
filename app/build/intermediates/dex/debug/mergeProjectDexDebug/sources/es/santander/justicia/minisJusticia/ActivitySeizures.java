package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterExpaSeizures;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.responses.bajaEmbargo.BajaEmbargoResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.seizures.Embargo;
import es.santander.justicia.minisJusticia.models.responses.seizures.EmbargoDetail;
import es.santander.justicia.minisJusticia.models.responses.seizures.EmbargoResponseEnvelope;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import retrofit2.Call;
import retrofit2.Response;

public class ActivitySeizures extends ActivityAbstractLetrados implements AdapterExpaSeizures.OnBajaClickListener, DialogSolicitudCalback, PopUpActionDone {
    private final int RQ_BUSQUEDA = 11;
    private Call<EmbargoResponseEnvelope> mCallEmbargos;
    /* access modifiers changed from: private */
    public FloatingActionButton mFabButton;
    /* access modifiers changed from: private */
    public ArrayList<Embargo> mListSeizures;
    /* access modifiers changed from: private */
    public RecyclerView mRecycler;
    /* access modifiers changed from: private */
    public RelativeLayout mRelativeNoresults;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_recycler);
        initUi();
    }

    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/embargos");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent intent = data;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            getEmbargos(intent.getStringExtra(Constants.EXTRA_JUZGORI), intent.getStringExtra(Constants.EXTRA_JPROCED), intent.getStringExtra(Constants.EXTRA_JANOAPEX), intent.getStringExtra(Constants.EXTRA_JNUMEXP), intent.getStringExtra(Constants.EXTRA_IMPORTE_DESDE), intent.getStringExtra(Constants.EXTRA_IMPORTE_HASTA), intent.getStringExtra(Constants.EXTRA_FECHA_DESDE), intent.getStringExtra(Constants.EXTRA_FECHA_HASTA), intent.getStringExtra(Constants.EXTRA_TIPO_EMBARGO), intent.getStringExtra(Constants.EXTRA_ESTADO_EMBARGO), false);
        }
    }

    /* JADX WARNING: type inference failed for: r14v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySeizures] */
    private void initUi() {
        ((QTextView) findViewById(R.id.text_title_state)).setText(getString(R.string.seizures));
        RecyclerView findViewById = findViewById(2131362622);
        this.mRecycler = findViewById;
        findViewById.setHasFixedSize(false);
        this.mRecycler.setLayoutManager(new LinearLayoutManager(this));
        this.mRelativeNoresults = (RelativeLayout) findViewById(R.id.layout_no_result);
        this.mFabButton = findViewById(R.id.fab_button);
        getEmbargos("", "", "", "", "", "", "", "", "", getIntent().getStringExtra(Constants.EXTRA_ESTADO_EMBARGO), false);
    }

    /* JADX WARNING: type inference failed for: r14v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySeizures] */
    private void getEmbargos(String juzgadoOrigenExp, String procedimientoExp, String anoAperturaExpediente, String numeroExp, String importeEmbargadoDesde, String importeEmbargadoHasta, String fechaDesde, String fechaHasta, String codigoTipoEmbargo, String codigoEstado, boolean repeatCall) {
        if (!repeatCall) {
            this.mCallEmbargos = ConnectionBuilder.getEmbargos(PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO), juzgadoOrigenExp, procedimientoExp, anoAperturaExpediente, numeroExp, importeEmbargadoDesde, importeEmbargadoHasta, fechaDesde, fechaHasta, codigoTipoEmbargo, codigoEstado);
        }
        this.mCallEmbargos.clone().enqueue(new RetrofitCallbackInterface<EmbargoResponseEnvelope>(this, true, true) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySeizures] */
            public void onResponse(Call<EmbargoResponseEnvelope> call, Response<EmbargoResponseEnvelope> response) {
                try {
                    ? r0 = ActivitySeizures.this;
                    String str = null;
                    String securityToken = (response.body() == null || ((EmbargoResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((EmbargoResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(r0, securityToken, str)) {
                        try {
                            ArrayList unused = ActivitySeizures.this.mListSeizures = ((EmbargoResponseEnvelope) response.body()).getBody().getEmbargoReturn().getEmbargos();
                        } catch (Exception e) {
                            Log.d("ActivitySeizures", "error mListSeizures");
                        }
                        if (ActivitySeizures.this.mListSeizures == null || ActivitySeizures.this.mListSeizures.isEmpty()) {
                            ActivitySeizures.this.mRelativeNoresults.setVisibility(0);
                            ActivitySeizures.this.mFabButton.setVisibility(8);
                            ActivitySeizures.this.mRecycler.setVisibility(8);
                            return;
                        }
                        ActivitySeizures.this.buildMebargosDetail();
                        ActivitySeizures.this.mRelativeNoresults.setVisibility(8);
                        ActivitySeizures.this.mFabButton.setVisibility(0);
                        ActivitySeizures.this.mRecycler.setVisibility(0);
                    }
                } catch (IOException e2) {
                    Log.e("getEmbargos", "IOException", e2);
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySeizures] */
    private void bajaEmbargo(String codUniOrg, String numEmbargo, String firma, String observ) {
        ConnectionBuilder.getBajaEmbargoCall(codUniOrg, numEmbargo, firma, observ).enqueue(new RetrofitCallbackInterface<BajaEmbargoResponseEnvelope>(this, true, true) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySeizures] */
            /* JADX WARNING: type inference failed for: r0v7, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySeizures] */
            public void onResponse(Call<BajaEmbargoResponseEnvelope> call, Response<BajaEmbargoResponseEnvelope> response) {
                try {
                    ? r0 = ActivitySeizures.this;
                    String str = null;
                    String securityToken = (response.body() == null || ((BajaEmbargoResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((BajaEmbargoResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (!super.finishConnection(r0, securityToken, str)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        ? r02 = ActivitySeizures.this;
                        CommonUtils.showPopUpActionDone(r02, r02.mRecycler, R.string.pop_up_finish_operation, ActivitySeizures.this);
                        return;
                    }
                    Toast.makeText(ActivitySeizures.this.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
                } catch (IOException e) {
                    Log.e("getBajaEmbargoCall", "IOException", e);
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySeizures] */
    /* access modifiers changed from: private */
    public void buildMebargosDetail() {
        int datosPaginacinIndex = -1;
        int count = 0;
        Iterator<Embargo> it = this.mListSeizures.iterator();
        while (it.hasNext()) {
            Embargo embargo = it.next();
            if (embargo.getNumeroEmbargo() == null) {
                datosPaginacinIndex = count;
            }
            count++;
            String str = "";
            StringBuilder append = new StringBuilder().append(embargo.getNombrePersonaEmbargo()).append(" ").append(CommonUtils.isNotNullNotBlackNotStringNull(embargo.getApellido1PersonaEmbargo()) ? embargo.getApellido1PersonaEmbargo() : str).append(" ");
            if (CommonUtils.isNotNullNotBlackNotStringNull(embargo.getApellido2PersonaEmbargo())) {
                str = embargo.getApellido2PersonaEmbargo();
            }
            embargo.addEmbargoDetails(new EmbargoDetail(append.append(str).toString(), embargo.getImporteTotalEmbargo(), embargo.getCodigoDocumentoIdentidad()));
        }
        if (datosPaginacinIndex != -1) {
            this.mListSeizures.remove(datosPaginacinIndex);
        }
        this.mRecycler.setAdapter(new AdapterExpaSeizures(this, this.mListSeizures));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySeizures] */
    public void onFabClick(View v) {
        startActivityForResult(new Intent(this, ActivityBusquedaEmbargos.class), 11);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBajaClick(int r7) {
        /*
            r6 = this;
            androidx.recyclerview.widget.RecyclerView r1 = r6.mRecycler
            r3 = 0
            r4 = 2131886711(0x7f120277, float:1.9408009E38)
            r0 = r6
            r2 = r6
            r5 = r7
            es.santander.justicia.utils.CommonUtils.showOperativaPopUp(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivitySeizures.onBajaClick(int):void");
    }

    public void onOperativaClicked(String motive, String pass, int textResource, int position) {
        bajaEmbargo(this.mListSeizures.get(position).getCodigoJuzgadoDestino(), this.mListSeizures.get(position).getNumeroEmbargo(), pass, (String) null);
    }

    public void onPopUpClosed() {
        getEmbargos((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, true);
    }
}
