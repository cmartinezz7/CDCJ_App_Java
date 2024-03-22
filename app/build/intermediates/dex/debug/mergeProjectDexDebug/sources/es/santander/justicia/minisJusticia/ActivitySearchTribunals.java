package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.adapters.AdapterSearchTribunal;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.ConsultaJuzgadosResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.Constants;
import java.io.IOException;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Response;

public class ActivitySearchTribunals extends ActivityAbstractLetrados implements AdapterAbstractRecycler.OnRecyclerClickListener {
    /* access modifiers changed from: private */
    public RelativeLayout mLayoutNoResults;
    /* access modifiers changed from: private */
    public ArrayList<DatosJuzgado> mListTribunal;
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

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySearchTribunals] */
    private void iniUi() {
        ((QTextView) findViewById(R.id.text_title_state)).setText(getString(R.string.tribunals_lists));
        RecyclerView findViewById = findViewById(2131362622);
        this.mRecycler = findViewById;
        findViewById.setHasFixedSize(true);
        this.mRecycler.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.fab_button).setVisibility(8);
        this.mLayoutNoResults = (RelativeLayout) findViewById(R.id.layout_no_result);
        findViewById(R.id.button_nueva_busqueda).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivitySearchTribunals.this.onBackPressed();
            }
        });
        getJuzgados();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySearchTribunals] */
    private void getJuzgados() {
        ConnectionBuilder.getConsultaJuzgados(getIntent().getStringExtra(Constants.EXTRA_COD_PROVINCIA), getIntent().getStringExtra(Constants.EXTRA_COD_ENTORNO_JUDICIAL)).enqueue(new RetrofitCallbackInterface<ConsultaJuzgadosResponseEnvelope>(this, true, true) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySearchTribunals] */
            /* JADX WARNING: type inference failed for: r2v5, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySearchTribunals] */
            public void onResponse(Call<ConsultaJuzgadosResponseEnvelope> call, Response<ConsultaJuzgadosResponseEnvelope> response) {
                try {
                    ? r0 = ActivitySearchTribunals.this;
                    String str = null;
                    String securityToken = (response.body() == null || ((ConsultaJuzgadosResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((ConsultaJuzgadosResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(r0, securityToken, str)) {
                        try {
                            ActivitySearchTribunals activitySearchTribunals = ActivitySearchTribunals.this;
                            ArrayList unused = activitySearchTribunals.mListTribunal = activitySearchTribunals.removeDatosPaginacion(((ConsultaJuzgadosResponseEnvelope) response.body()).getBody().getConsultaJuzgadoReturn().getDatosJuzgados());
                            if (ActivitySearchTribunals.this.mListTribunal.isEmpty()) {
                                ActivitySearchTribunals.this.mLayoutNoResults.setVisibility(0);
                                ActivitySearchTribunals.this.mRecycler.setVisibility(8);
                            } else {
                                ActivitySearchTribunals.this.mLayoutNoResults.setVisibility(8);
                                ActivitySearchTribunals.this.mRecycler.setVisibility(0);
                            }
                            RecyclerView access$300 = ActivitySearchTribunals.this.mRecycler;
                            ? r2 = ActivitySearchTribunals.this;
                            access$300.setAdapter(new AdapterSearchTribunal(r2, r2.mListTribunal));
                        } catch (Exception e) {
                            Toast.makeText(ActivitySearchTribunals.this.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
                        }
                        return;
                    }
                    ActivitySearchTribunals.this.mLayoutNoResults.setVisibility(0);
                    ActivitySearchTribunals.this.mRecycler.setVisibility(8);
                } catch (IOException e2) {
                    Log.e("getJuzgados", "IOException", e2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public ArrayList<DatosJuzgado> removeDatosPaginacion(ArrayList<DatosJuzgado> datosJuzgados) {
        int count = 0;
        while (datosJuzgados.get(count).getEntornoJudicial() != null) {
            count++;
        }
        datosJuzgados.remove(count);
        return datosJuzgados;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivitySearchTribunals] */
    public void onItemClickListener(int position) {
        TealiumHelper.trackEvent("/lista_juzgados", "lista_juzgados (selección de juzgado)");
        Intent intent = new Intent(this, ActivityMapJuzgados.class);
        intent.putExtra(Constants.EXTRA_JUZGA, this.mListTribunal.get(position).getJuzga());
        startActivity(intent);
    }
}
