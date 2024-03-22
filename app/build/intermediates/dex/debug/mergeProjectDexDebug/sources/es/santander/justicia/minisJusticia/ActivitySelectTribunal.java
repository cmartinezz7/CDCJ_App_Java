package es.santander.justicia.minisJusticia;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.consultaOrganosAsignados.ConsultaOrganoAsignadoDetail;
import es.santander.justicia.minisJusticia.models.responses.consultaOrganosAsignados.ConsultaOrganosAsigRespEnvelope;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Response;

public class ActivitySelectTribunal extends ActivityAbstractLetrados implements AdapterAbstractRecycler.OnRecyclerClickListener {
    /* access modifiers changed from: private */
    public ArrayList<ConsultaOrganoAsignadoDetail> mListTribunal;
    /* access modifiers changed from: private */
    public PreferencesHelper mPreferenceHelper;
    /* access modifiers changed from: private */
    public RecyclerView mRecycler;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_recycler);
        iniUi();
    }

    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/lista_juzgados");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySelectTribunal] */
    private void iniUi() {
        ((QTextView) findViewById(R.id.text_title_state)).setText(getString(R.string.select_tribunal));
        this.mPreferenceHelper = PreferencesHelper.newInstance(this);
        RecyclerView findViewById = findViewById(2131362622);
        this.mRecycler = findViewById;
        findViewById.setHasFixedSize(true);
        this.mRecycler.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.fab_button).setVisibility(8);
        callConsultaOrganosAsignados();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void callSelectTribunal(java.lang.String r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "/lista_juzgados"
            java.lang.String r1 = "lista_juzgados (selección de juzgado)"
            es.santander.justicia.minisJusticia.common.tealium.TealiumHelper.trackEvent(r0, r1)
            retrofit2.Call r0 = es.santander.justicia.minisJusticia.connections.ConnectionBuilder.getCambiarOrganismoCall(r9)
            es.santander.justicia.minisJusticia.ActivitySelectTribunal$1 r7 = new es.santander.justicia.minisJusticia.ActivitySelectTribunal$1
            r1 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            r1 = r7
            r2 = r8
            r3 = r8
            r4 = r5
            r6 = r10
            r1.<init>(r3, r4, r5, r6)
            r0.enqueue(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivitySelectTribunal.callSelectTribunal(java.lang.String, int):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySelectTribunal] */
    private void callConsultaOrganosAsignados() {
        ConnectionBuilder.getConsultaOrganosAsigandosCall().enqueue(new RetrofitCallbackInterface<ConsultaOrganosAsigRespEnvelope>(this, true, true) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySelectTribunal] */
            /* JADX WARNING: type inference failed for: r2v4, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySelectTribunal] */
            public void onResponse(Call<ConsultaOrganosAsigRespEnvelope> call, Response<ConsultaOrganosAsigRespEnvelope> response) {
                try {
                    ? r0 = ActivitySelectTribunal.this;
                    String str = null;
                    String securityToken = (response.body() == null || ((ConsultaOrganosAsigRespEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((ConsultaOrganosAsigRespEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (!super.finishConnection(r0, securityToken, str)) {
                        return;
                    }
                    if (response.errorBody() == null) {
                        ArrayList unused = ActivitySelectTribunal.this.mListTribunal = ((ConsultaOrganosAsigRespEnvelope) response.body()).getBody().getConsultaOrganismoReturn().getConsultaOrganimosAsignadoCodUos();
                        RecyclerView access$200 = ActivitySelectTribunal.this.mRecycler;
                        ? r2 = ActivitySelectTribunal.this;
                        access$200.setAdapter(new AdapterSelectrTribunal(r2, r2.mListTribunal));
                        ActivitySelectTribunal.this.orderTribunals();
                        return;
                    }
                    Toast.makeText(ActivitySelectTribunal.this.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
                } catch (IOException e) {
                    Log.e("callConsultOrgAsig", "IOException", e);
                }
            }
        });
    }

    public void onItemClickListener(int position) {
        callSelectTribunal(this.mListTribunal.get(position).getCodUo(), position);
    }

    /* access modifiers changed from: private */
    public void orderTribunals() {
        int indexTribunal = -1;
        int i = 0;
        while (true) {
            if (i >= this.mListTribunal.size()) {
                break;
            } else if (this.mListTribunal.get(i).getCodUo().equals(this.mPreferenceHelper.getString(Constants.PREFERECENCE_COD_UO))) {
                indexTribunal = i;
                break;
            } else {
                i++;
            }
        }
        if (indexTribunal != -1) {
            this.mListTribunal.remove(indexTribunal);
            this.mListTribunal.add(0, this.mListTribunal.get(indexTribunal));
        }
    }
}
