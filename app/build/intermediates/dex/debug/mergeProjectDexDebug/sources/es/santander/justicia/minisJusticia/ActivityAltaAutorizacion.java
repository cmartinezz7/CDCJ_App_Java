package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.interfaces.DialogSolicitudCalback;
import es.santander.justicia.minisJusticia.interfaces.PopUpActionDone;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.models.requests.altaAutorizacion.AltaAutorizationArg0Detail;
import es.santander.justicia.minisJusticia.models.requests.altaAutorizacion.DatosAutorizacion;
import es.santander.justicia.minisJusticia.models.requests.authJuzgados.AuthJuzgadosArg0Detail;
import es.santander.justicia.minisJusticia.models.responses.GlobalReponseEnvelope;
import es.santander.justicia.minisJusticia.models.responses.consultaJuzgados.DatosJuzgado;
import es.santander.justicia.minisJusticia.models.responses.detalleJuzgado.DetalleJuzgadosResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.DateUtils;
import es.santander.justicia.utils.InitConfigConstants;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

public class ActivityAltaAutorizacion extends ActivityAbstractBusqueda implements DialogSolicitudCalback, PopUpActionDone {
    private String caducadas = "0";
    /* access modifiers changed from: private */
    public String docType;
    private Spinner mSpinnerDocType;
    private TextView textViewDateFrom;
    private TextView textViewDateTo;

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityAbstractBusqueda, es.santander.justicia.minisJusticia.ActivityAltaAutorizacion] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_auth_court);
        getWindow().setSoftInputMode(2);
        this.textViewDateFrom = (TextView) findViewById(R.id.text_date_from);
        this.textViewDateTo = (TextView) findViewById(R.id.text_date_to);
        this.textViewDateFrom.setText(CommonUtils.getCurrentDateToShow());
        this.textViewDateTo.setText(CommonUtils.getDateNextMonthToShow());
        if (getIntent().getExtras() == null || getIntent().getExtras().getString(Constants.EXTRA_SEARCH) == null) {
            ((TextView) findViewById(R.id.textTitle)).setText(getString(R.string.auth_alta));
            ((TextView) findViewById(R.id.text_btn_peticiones)).setText(getString(R.string.new_auth));
        } else {
            findViewById(R.id.linearCaducadas).setVisibility(0);
            ((TextView) findViewById(R.id.text_btn_peticiones)).setText(getString(R.string.search));
            ((TextView) findViewById(R.id.textTitle)).setText(getString(R.string.auth_court));
        }
        defineListeners();
        initUi();
        getDetalleJuzgado(PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO));
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityAltaAutorizacion] */
    /* access modifiers changed from: protected */
    public void defineSpinners() {
        this.mSpinnerDocType = (Spinner) findViewById(R.id.spn_type);
        ArrayAdapter<SpinnerValuesDTO> arrayAdapterSeleccion = new ArrayAdapter<>(this, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_DOCUMENT_TYPE_FOR_LETRADOS));
        arrayAdapterSeleccion.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.mSpinnerDocType.setAdapter(arrayAdapterSeleccion);
        this.mSpinnerDocType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = ActivityAltaAutorizacion.this.docType = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_DOCUMENT_TYPE_FOR_LETRADOS).get(position).getCode();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void defineListeners() {
        findViewById(R.id.text_btn_auth).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AuthJuzgadosArg0Detail authJuzgadosArg0Detail = new AuthJuzgadosArg0Detail();
                authJuzgadosArg0Detail.setIndCaducadas("1");
                ActivityAltaAutorizacion.this.returnResult(authJuzgadosArg0Detail);
            }
        });
    }

    /* access modifiers changed from: private */
    public void returnResult(AuthJuzgadosArg0Detail authJuzgadosArg0Detail) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.EXTRA_AUTORIZATION, authJuzgadosArg0Detail);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [es.santander.justicia.minisJusticia.ActivityAltaAutorizacion, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void buscarClick() {
        if (!CommonUtils.validateDocumentNumber(this, this.docType, (EditText) findViewById(R.id.editDocument))) {
            return;
        }
        if (((TextView) findViewById(R.id.text_btn_peticiones)).getText().toString().equals(getString(R.string.search))) {
            AuthJuzgadosArg0Detail authJuzgadosArg0Detail = new AuthJuzgadosArg0Detail();
            authJuzgadosArg0Detail.setIndCaducadas(this.caducadas);
            if (CommonUtils.isNotNullNotBlackNotStringNull(this.textViewDateTo.getText().toString())) {
                authJuzgadosArg0Detail.setFechaFinal(DateUtils.formatDateToRequest(this.textViewDateTo.getText().toString()));
            }
            if (CommonUtils.isNotNullNotBlackNotStringNull(this.textViewDateFrom.getText().toString())) {
                authJuzgadosArg0Detail.setFechaInicial(DateUtils.formatDateToRequest(this.textViewDateFrom.getText().toString()));
            }
            if (CommonUtils.isNotNullNotBlackNotStringNull(((EditText) findViewById(R.id.editDocument)).getText().toString())) {
                authJuzgadosArg0Detail.setCodNumDocumento(((EditText) findViewById(R.id.editDocument)).getText().toString().toUpperCase());
            }
            authJuzgadosArg0Detail.setCodTipoDocumento(this.docType);
            returnResult(authJuzgadosArg0Detail);
        } else if (CommonUtils.isNotNullNotBlackNotStringNull(this.textViewDateFrom.getText().toString()) && CommonUtils.isNotNullNotBlackNotStringNull(this.textViewDateTo.getText().toString())) {
            CommonUtils.showOperativaPopUp(this, findViewById(16908290), this, false, R.string.confirmar_swype, 0);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityAltaAutorizacion] */
    /* access modifiers changed from: private */
    public void showInfo(DatosJuzgado datosJuzgado) {
        String str;
        ((TextView) findViewById(R.id.textViewCuenta)).setText(PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO));
        ((TextView) findViewById(R.id.textViewNombre)).setText(datosJuzgado.getEntornoJudicial());
        ((TextView) findViewById(R.id.textViewTelefono)).setText(datosJuzgado.getTelefono1());
        StringBuilder append = new StringBuilder().append(datosJuzgado.getTipoVia()).append(" ").append(datosJuzgado.getNombreVia()).append(" ");
        if (datosJuzgado.getNumero() != null) {
            str = datosJuzgado.getNumero();
        } else {
            str = " ";
        }
        ((TextView) findViewById(R.id.textViewDireccion)).setText(append.append(str).append(" ").append(datosJuzgado.getProvincia()).append("  ").append(datosJuzgado.getCodpost()).toString());
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityAltaAutorizacion] */
    private void buildAltaRequest(String firma, String fechaIni, String fechaFin) {
        AltaAutorizationArg0Detail altaAutorizationArg0Detail = new AltaAutorizationArg0Detail();
        altaAutorizationArg0Detail.setFirma(firma);
        String str = fechaIni;
        String str2 = fechaFin;
        altaAutorizationArg0Detail.setDatosAutorizacion(new DatosAutorizacion(((EditText) findViewById(R.id.editDocument)).getText().toString().toUpperCase(), PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO), str, str2, this.docType));
        makeAlta(altaAutorizationArg0Detail);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityAltaAutorizacion] */
    private void getDetalleJuzgado(String juzga) {
        ConnectionBuilder.getDetalleJuzgados(juzga).enqueue(new RetrofitCallbackInterface<DetalleJuzgadosResponseEnvelope>(this) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityAltaAutorizacion] */
            public void onResponse(Call<DetalleJuzgadosResponseEnvelope> call, Response<DetalleJuzgadosResponseEnvelope> response) {
                try {
                    ? r0 = ActivityAltaAutorizacion.this;
                    String str = null;
                    String securityToken = (response.body() == null || ((DetalleJuzgadosResponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((DetalleJuzgadosResponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(r0, securityToken, str)) {
                        ActivityAltaAutorizacion.this.showInfo(((DetalleJuzgadosResponseEnvelope) response.body()).getBody().getConsultaJuzgadoReturn().getDatosJuzgados().get(0));
                    }
                } catch (IOException e) {
                    Log.e("getDetalleJuzgado", "IOException", e);
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityAltaAutorizacion] */
    public void makeAlta(AltaAutorizationArg0Detail altaAutorizationArg0Detail) {
        ConnectionBuilder.altaAutorizacion(altaAutorizationArg0Detail).enqueue(new RetrofitCallbackInterface<GlobalReponseEnvelope>(this) {
            /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityAltaAutorizacion] */
            public void onResponse(Call<GlobalReponseEnvelope> call, Response<GlobalReponseEnvelope> response) {
                try {
                    ? r0 = ActivityAltaAutorizacion.this;
                    String str = null;
                    String securityToken = (response.body() == null || ((GlobalReponseEnvelope) response.body()).getBinarySecurityToken() == null) ? null : ((GlobalReponseEnvelope) response.body()).getBinarySecurityToken().getSecurityToken();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(r0, securityToken, str)) {
                        ActivityAltaAutorizacion.this.onBackPressed();
                    }
                } catch (IOException e) {
                    Log.e("getDetalleJuzgado", "IOException", e);
                }
            }
        });
    }

    public void onOperativaClicked(String motive, String pass, int textResource, int position) {
        buildAltaRequest(pass, DateUtils.formatDateToRequest(this.textViewDateFrom.getText().toString()), DateUtils.formatDateToRequest(this.textViewDateTo.getText().toString()));
    }

    public void onPopUpClosed() {
    }
}
