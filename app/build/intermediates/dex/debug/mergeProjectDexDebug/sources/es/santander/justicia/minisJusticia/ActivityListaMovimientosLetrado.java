package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.adapters.AdapterListaMovimientos;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.enums.MovementStatusEnum;
import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpedienteDetail;
import es.santander.justicia.minisJusticia.models.responses.listaMovimientos.DatosOperacion;
import es.santander.justicia.minisJusticia.models.responses.listaMovimientos.ListaMovimientosResponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.listaMovimientos.TotalMovimiento;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.DateUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;

public class ActivityListaMovimientosLetrado extends ActivityAbstractLetrados implements AdapterAbstractRecycler.OnRecyclerClickListener {
    private final int RQ_SEARCH = 13;
    private String codMon;
    /* access modifiers changed from: private */
    public DatosExpedienteDetail expedienteSelected;
    private String janoapex;
    private String jfechareDe;
    private String jfechareHasta;
    private String jimpnomiDe;
    private String jimpnomiHasta;
    private String jnumexp;
    private String jproced;
    private String juzga;
    private String juzgori;
    /* access modifiers changed from: private */
    public String mCurrentExpediente;
    /* access modifiers changed from: private */
    public FloatingActionButton mFabButton;
    /* access modifiers changed from: private */
    public ArrayList<DatosOperacion> mItemsOperations;
    /* access modifiers changed from: private */
    public ArrayList<TotalMovimiento> mItemsTotal;
    /* access modifiers changed from: private */
    public LinearLayout mLinearGlobalMovements;
    private LinearLayout mLinerContainer;
    /* access modifiers changed from: private */
    public ArrayList<DatosExpedienteDetail> mListExpedientes;
    /* access modifiers changed from: private */
    public List<View> mListaLayouts;
    /* access modifiers changed from: private */
    public List<QFontTextView> mListaTextTotales;
    /* access modifiers changed from: private */
    public RecyclerView mRecycler;
    /* access modifiers changed from: private */
    public RelativeLayout mRelativeNoResults;
    /* access modifiers changed from: private */
    public int mScrollTotal;
    private Spinner mSpinerExpedientes;
    private String tipoMov;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_movimientos_letrado);
        initUi();
    }

    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/lista_movimientos");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent intent = data;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            getMovements(this.expedienteSelected.getJanoapex(), this.expedienteSelected.getJnumexp(), this.expedienteSelected.getJproced(), this.expedienteSelected.getJuzga(), this.expedienteSelected.getJuzgori(), intent.getStringExtra(Constants.EXTRA_FECHA_DESDE), intent.getStringExtra(Constants.EXTRA_FECHA_HASTA), intent.getStringExtra(Constants.EXTRA_IMPORTE_DESDE), intent.getStringExtra(Constants.EXTRA_IMPORTE_HASTA), intent.getStringExtra(Constants.EXTRA_MONEDA), intent.getStringExtra(Constants.EXTRA_TIPO_MOVIMIENTO));
        }
    }

    private void initUi() {
        this.mSpinerExpedientes = (Spinner) findViewById(R.id.spinner_expedientes);
        this.mRecycler = findViewById(2131362622);
        this.mLinerContainer = (LinearLayout) findViewById(R.id.linear_container);
        this.mLinearGlobalMovements = (LinearLayout) findViewById(R.id.linear_movements);
        this.mRelativeNoResults = (RelativeLayout) findViewById(R.id.layout_no_result);
        this.mFabButton = findViewById(R.id.fab_button);
        findViewById(R.id.button_nueva_busqueda).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ActivityListaMovimientosLetrado.this.mFabButton.performClick();
            }
        });
        getIntent().setExtrasClassLoader(DatosExpedienteDetail.class.getClassLoader());
        this.mListExpedientes = getIntent().getParcelableArrayListExtra(Constants.EXTRA_LISTADO_EXPEDIENTES);
        this.mListaTextTotales = new ArrayList();
        this.mListaLayouts = new ArrayList();
        setRecycler();
        setSpinner();
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado] */
    private void setSpinner() {
        ArrayList<String> values = getNumExpedientes();
        ArrayList<String> valuesFormatted = new ArrayList<>();
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            valuesFormatted.add(CommonUtils.getProceedingFormatted(it.next()));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item, R.id.text_spinner, valuesFormatted);
        adapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.mSpinerExpedientes.setAdapter(adapter);
        this.mSpinerExpedientes.setSelection(getIntent().getIntExtra(Constants.EXTRA_SPINNER_POSITION, 0));
        this.mSpinerExpedientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                int i = position;
                ActivityListaMovimientosLetrado activityListaMovimientosLetrado = ActivityListaMovimientosLetrado.this;
                DatosExpedienteDetail unused = activityListaMovimientosLetrado.expedienteSelected = (DatosExpedienteDetail) activityListaMovimientosLetrado.mListExpedientes.get(i);
                ActivityListaMovimientosLetrado activityListaMovimientosLetrado2 = ActivityListaMovimientosLetrado.this;
                activityListaMovimientosLetrado2.getMovements(activityListaMovimientosLetrado2.expedienteSelected.getJanoapex(), ActivityListaMovimientosLetrado.this.expedienteSelected.getJnumexp(), ActivityListaMovimientosLetrado.this.expedienteSelected.getJproced(), ActivityListaMovimientosLetrado.this.expedienteSelected.getJuzga(), ActivityListaMovimientosLetrado.this.expedienteSelected.getJuzgori(), CommonUtils.getDateFromExpToSend(ActivityListaMovimientosLetrado.this.expedienteSelected.getPriMov()), CommonUtils.getDateFromExpToSend(ActivityListaMovimientosLetrado.this.expedienteSelected.getUltMov()), (String) null, (String) null, (String) null, (String) null);
                ActivityListaMovimientosLetrado activityListaMovimientosLetrado3 = ActivityListaMovimientosLetrado.this;
                String unused2 = activityListaMovimientosLetrado3.mCurrentExpediente = ((DatosExpedienteDetail) activityListaMovimientosLetrado3.mListExpedientes.get(i)).getNumComplete();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado] */
    private void setRecycler() {
        this.mRecycler.setHasFixedSize(true);
        this.mRecycler.setLayoutManager(new LinearLayoutManager(this));
        this.mRecycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                ActivityListaMovimientosLetrado.super.onScrolled(recyclerView, dx, dy);
                Log.d("Silos", "scrollBar " + ActivityListaMovimientosLetrado.this.mRecycler.computeVerticalScrollOffset());
                ActivityListaMovimientosLetrado activityListaMovimientosLetrado = ActivityListaMovimientosLetrado.this;
                int unused = activityListaMovimientosLetrado.mScrollTotal = activityListaMovimientosLetrado.mRecycler.computeVerticalScrollOffset();
                float rango = ((float) (ActivityListaMovimientosLetrado.this.mItemsTotal.size() + 1)) * 150.0f;
                float scrollInverso = rango - (((float) ActivityListaMovimientosLetrado.this.mScrollTotal) > rango ? rango : (float) ActivityListaMovimientosLetrado.this.mScrollTotal);
                float newTextSice = (scrollInverso / rango) * 16.0f;
                float alpha = scrollInverso / rango;
                if (alpha < 0.2f) {
                    alpha = 0.0f;
                }
                if (ActivityListaMovimientosLetrado.this.mItemsTotal != null) {
                    for (QFontTextView tv : ActivityListaMovimientosLetrado.this.mListaTextTotales) {
                        tv.setTextSize(newTextSice);
                        tv.setAlpha(alpha);
                    }
                }
                for (View v : ActivityListaMovimientosLetrado.this.mListaLayouts) {
                    LinearLayout.LayoutParams relativeParams = (LinearLayout.LayoutParams) v.getLayoutParams();
                    relativeParams.topMargin = (int) ((scrollInverso / rango) * 5.0f);
                    v.setLayoutParams(relativeParams);
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado] */
    public void onFabClick(View v) {
        startActivityForResult(new Intent(this, ActivityBusquedaMovimientos.class), 13);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado] */
    /* access modifiers changed from: private */
    public void getMovements(String janoapex2, String jnumexp2, String jproced2, String juzga2, String juzgori2, String jfechareDe2, String jfechareHasta2, String jimpnomiDe2, String jimpnomiHasta2, String codMon2, String tipoMov2) {
        ConnectionBuilder.getListaMovimientos(janoapex2, jnumexp2, jproced2, juzga2, juzgori2, jfechareDe2, jfechareHasta2, jimpnomiDe2, jimpnomiHasta2, codMon2, tipoMov2).enqueue(new RetrofitCallbackInterface<ListaMovimientosResponseEnvelope>(this, true, true) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado] */
            public void onResponse(Call<ListaMovimientosResponseEnvelope> call, Response<ListaMovimientosResponseEnvelope> response) {
                try {
                    ? r0 = ActivityListaMovimientosLetrado.this;
                    String str = null;
                    String securityToken = (response.body() == null || ((ListaMovimientosResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((ListaMovimientosResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (!super.finishConnection(r0, securityToken, str)) {
                        return;
                    }
                    if (response.errorBody() != null) {
                        Toast.makeText(ActivityListaMovimientosLetrado.this.getApplicationContext(), "Se ha producido un error al conectar con el servidor", 1).show();
                    } else if (((ListaMovimientosResponseEnvelope) response.body()).getBody().getListaMovimientosReturn().getListaMovimientosReturnDetail().getDatosOperacions() == null || ((ListaMovimientosResponseEnvelope) response.body()).getBody().getListaMovimientosReturn().getListaMovimientosReturnDetail().getDatosOperacions().isEmpty()) {
                        ActivityListaMovimientosLetrado.this.mRelativeNoResults.setVisibility(0);
                        ActivityListaMovimientosLetrado.this.mLinearGlobalMovements.setVisibility(8);
                        ActivityListaMovimientosLetrado.this.mFabButton.setVisibility(8);
                    } else {
                        ActivityListaMovimientosLetrado.this.extractInfo(((ListaMovimientosResponseEnvelope) response.body()).getBody().getListaMovimientosReturn().getListaMovimientosReturnDetail().getDatosOperacions());
                        ActivityListaMovimientosLetrado.this.mRelativeNoResults.setVisibility(8);
                        ActivityListaMovimientosLetrado.this.mLinearGlobalMovements.setVisibility(0);
                        ActivityListaMovimientosLetrado.this.mFabButton.setVisibility(0);
                    }
                } catch (IOException e) {
                    Log.e("getMovements", "IOException", e);
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void getMoveDetail(java.lang.String r9, java.lang.String r10, int r11) {
        /*
            r8 = this;
            retrofit2.Call r0 = es.santander.justicia.minisJusticia.connections.ConnectionBuilder.getDetalleMovimientoCall(r9, r10)
            es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado$5 r7 = new es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado$5
            r1 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            r1 = r7
            r2 = r8
            r3 = r8
            r4 = r5
            r6 = r11
            r1.<init>(r3, r4, r5, r6)
            r0.enqueue(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado.getMoveDetail(java.lang.String, java.lang.String, int):void");
    }

    private void addTotalMovements() {
        this.mLinerContainer.removeAllViews();
        int countIds = 0;
        Iterator<TotalMovimiento> it = this.mItemsTotal.iterator();
        while (it.hasNext()) {
            TotalMovimiento totalMovimiento = it.next();
            View layoutTotalMovimiento = getLayoutInflater().inflate(R.layout.linear_desc_movimientos, (ViewGroup) null, false);
            this.mLinerContainer.addView(layoutTotalMovimiento);
            layoutTotalMovimiento.setId(countIds);
            this.mListaLayouts.add(layoutTotalMovimiento);
            int countIds2 = countIds + 1;
            LinearLayout linearTotalMovGlobal = (LinearLayout) layoutTotalMovimiento.findViewById(R.id.linear_desc_movimientos_global);
            linearTotalMovGlobal.setId(countIds2);
            this.mListaLayouts.add(linearTotalMovGlobal);
            int countIds3 = countIds2 + 1;
            LinearLayout linearAbonos = (LinearLayout) layoutTotalMovimiento.findViewById(R.id.linear_abonos);
            linearAbonos.setId(countIds3);
            this.mListaLayouts.add(linearAbonos);
            int countIds4 = countIds3 + 1;
            LinearLayout linearCargos = (LinearLayout) layoutTotalMovimiento.findViewById(R.id.linear_cargos);
            linearCargos.setId(countIds4);
            this.mListaLayouts.add(linearCargos);
            int countIds5 = countIds4 + 1;
            LinearLayout linearPendientes = (LinearLayout) layoutTotalMovimiento.findViewById(R.id.linear_pendientes);
            linearPendientes.setId(countIds5);
            this.mListaLayouts.add(linearPendientes);
            int countIds6 = countIds5 + 1;
            QFontTextView textTabonos = (QFontTextView) layoutTotalMovimiento.findViewById(R.id.text_abonos);
            textTabonos.setText(CommonUtils.formatImport(totalMovimiento.getJimpabono()) + " " + totalMovimiento.getCodmon());
            textTabonos.setId(countIds6);
            this.mListaTextTotales.add(textTabonos);
            int countIds7 = countIds6 + 1;
            QFontTextView textCargos = (QFontTextView) layoutTotalMovimiento.findViewById(R.id.text_cargos);
            textCargos.setText(CommonUtils.formatImport(totalMovimiento.getJimpcargo()) + " " + totalMovimiento.getCodmon());
            textCargos.setId(countIds7);
            this.mListaTextTotales.add(textCargos);
            int countIds8 = countIds7 + 1;
            QFontTextView textPdt = (QFontTextView) layoutTotalMovimiento.findViewById(R.id.text_pdte);
            textPdt.setText(CommonUtils.formatImport(totalMovimiento.getJimppend()) + " " + totalMovimiento.getCodmon());
            textPdt.setId(countIds8);
            this.mListaTextTotales.add(textPdt);
            int countIds9 = countIds8 + 1;
            QFontTextView textAbonosTilte = (QFontTextView) findViewById(R.id.text_abonos_title);
            textAbonosTilte.setId(countIds9);
            this.mListaTextTotales.add(textAbonosTilte);
            int countIds10 = countIds9 + 1;
            QFontTextView textCargosTitle = (QFontTextView) findViewById(R.id.text_cargos_title);
            textCargosTitle.setId(countIds10);
            this.mListaTextTotales.add(textCargosTitle);
            int countIds11 = countIds10 + 1;
            QFontTextView textPendienteTitle = (QFontTextView) findViewById(R.id.text_pendiente_title);
            textPendienteTitle.setId(countIds11);
            this.mListaTextTotales.add(textPendienteTitle);
            countIds = countIds11 + 1;
        }
        this.mLinerContainer.setVisibility(0);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado] */
    private void showOperations() {
        this.mRecycler.setAdapter(new AdapterListaMovimientos(this, this.mItemsOperations));
    }

    private ArrayList<String> getNumExpedientes() {
        ArrayList<String> retValue = new ArrayList<>();
        Iterator<DatosExpedienteDetail> it = this.mListExpedientes.iterator();
        while (it.hasNext()) {
            DatosExpedienteDetail datosExpedienteDetail = it.next();
            retValue.add(CommonUtils.formatExpedient(datosExpedienteDetail.getJuzga(), datosExpedienteDetail.getJuzgori(), datosExpedienteDetail.getJproced(), datosExpedienteDetail.getJnumexp(), datosExpedienteDetail.getJanoapex()));
        }
        return retValue;
    }

    /* access modifiers changed from: private */
    public void extractInfo(ArrayList<Object> datosOperacions) {
        this.mItemsOperations = new ArrayList<>();
        this.mItemsTotal = new ArrayList<>();
        Iterator<Object> it = datosOperacions.iterator();
        while (it.hasNext()) {
            Object object = it.next();
            if (object instanceof DatosOperacion) {
                this.mItemsOperations.add((DatosOperacion) object);
            } else {
                this.mItemsTotal.add((TotalMovimiento) object);
            }
        }
        addTotalMovements();
        showOperations();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityListaMovimientosLetrado] */
    public void onItemClickListener(int position) {
        getMoveDetail(this.mItemsOperations.get(position).getJnuoper(), PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO), position);
    }

    /* access modifiers changed from: private */
    public MovementItemDTO getMovmentItemDTO(DatosOperacion datosOperacion, es.santander.justicia.minisJusticia.models.responses.detalleMovimiento.DatosOperacion movementObject) {
        MovementItemDTO movement = new MovementItemDTO();
        movement.setDetail(true);
        movement.setEsLetrado(true);
        if (movementObject.getDatosExpedienteDestino() != null) {
            movement.setExpedienteDestino(movementObject.getDatosExpedienteDestino().getCodExpediente());
        }
        movement.setRepresentado(movementObject.getJnors());
        movement.setDocumento(movementObject.getCoddocum());
        if (movementObject.getDatosExpediente().getSaldos() != null) {
            movement.setImporteSaldo(movementObject.getDatosExpediente().getSaldos().getImpsald());
        }
        if (!(movementObject.getDatosRepresentante() == null || movementObject.getDatosRepresentante().getGenombre() == null)) {
            movement.setRepresentante(movementObject.getDatosRepresentante().getGenombre());
        }
        if (movementObject.getCodmon() != null) {
            movement.setCodmon(movementObject.getCodmon());
        }
        if (movementObject.getDesctipomod() != null) {
            movement.setDesctipomod(movementObject.getDesctipomod());
        }
        if (movementObject.getJimpnomi() != null) {
            movement.setImporteDetalle(movementObject.getJimpnomi());
            movement.setMovementStatus(MovementStatusEnum.EXECUTED);
        } else if (movementObject.getJimppend() != null) {
            movement.setImporteDetalle(movementObject.getJimppend());
            movement.setMovementStatus(MovementStatusEnum.PENDING);
        } else if (datosOperacion.getJimpcaduca() != null) {
            movement.setImporteDetalle(datosOperacion.getJimpcaduca());
            movement.setMovementStatus(MovementStatusEnum.EXPIRED);
        }
        if (datosOperacion.getJnors() != null) {
            movement.setJnors(datosOperacion.getJnors());
        }
        if (movementObject.getJnuoper() != null) {
            movement.setJnuoper(movementObject.getJnuoper());
        }
        if (datosOperacion.getJtipomod() != null) {
            movement.setJtipomod(datosOperacion.getJtipomod());
        }
        if (datosOperacion.getMoneda() != null) {
            movement.setMoneda(datosOperacion.getMoneda());
        }
        if (movementObject.getNumerosr() != null) {
            movement.setNumerosr(movementObject.getNumerosr());
        }
        if (movementObject.getSeralfab() != null) {
            movement.setSeralfab(movementObject.getSeralfab());
        }
        if (movementObject.getSerieYMandamiento() != null) {
            movement.setSerieYMandamiento(movementObject.getSerieYMandamiento());
        }
        if (movementObject.getJusrhare() != null) {
            movement.setjResponsableAlta(movementObject.getJusrhare());
        }
        if (movementObject.getJusrfirma() != null) {
            movement.setjResponsableFirma(movementObject.getJusrfirma());
        }
        if (movementObject.getJusrfirmeza() != null) {
            movement.setjResponsableFirmeza(movementObject.getJusrfirmeza());
        }
        if (movementObject.getJusrautoriza() != null) {
            movement.setjResponsableAutorizacion(movementObject.getJusrautoriza());
        }
        if (movementObject.getJusrconf() != null) {
            movement.setjResponsableConfirmacion(movementObject.getJusrconf());
        }
        if (movementObject.getJfechare() != null) {
            movement.setJfechare(DateUtils.formatDate(movementObject.getJfechare()));
        }
        if (movementObject.getJfecfirma() != null) {
            movement.setjFechaFirma(DateUtils.formatDate(movementObject.getJfecfirma()));
        }
        if (movementObject.getJfecfirmeza() != null) {
            movement.setjFechaFirmeza(DateUtils.formatDate(movementObject.getJfecfirmeza()));
        }
        if (movementObject.getJfecautoriza() != null) {
            movement.setjFechaAutorizacion(DateUtils.formatDate(movementObject.getJfecautoriza()));
        }
        if (movementObject.getJfecconf() != null) {
            movement.setjFechaConfirmacion(DateUtils.formatDate(movementObject.getJfecconf()));
        }
        if (movementObject.getJfeccaduc() != null) {
            movement.setjFechaCaducidad(DateUtils.formatDate(movementObject.getJfeccaduc()));
        }
        if (movementObject.getConc30() != null) {
            movement.setConcepto(movementObject.getConc30());
        }
        movement.setFecha(CommonUtils.getCurrentDateToShow());
        return movement;
    }
}
