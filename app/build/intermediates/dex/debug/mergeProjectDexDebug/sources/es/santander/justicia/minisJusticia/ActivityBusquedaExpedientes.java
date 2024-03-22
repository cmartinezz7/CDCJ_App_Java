package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.InitConfigConstants;

public class ActivityBusquedaExpedientes extends ActivityAbstractBusqueda {
    /* access modifiers changed from: private */
    public String mMoneda;
    /* access modifiers changed from: private */
    public String mSituacion;
    private Spinner mSpinenrMoneda;
    private Spinner mSpinenrSituacion;
    private Spinner mSpinenrTipoSeleccion;
    /* access modifiers changed from: private */
    public String mTipoSeleccion;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_expedientes);
        getWindow().setSoftInputMode(2);
        initUi();
    }

    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/busqueda_expediente");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityBusquedaExpedientes] */
    /* access modifiers changed from: protected */
    public void defineSpinners() {
        mTextDateTo.setClickable(false);
        mTextDateFrom.setClickable(false);
        findViewById(R.id.iv_calendar_date_to).setClickable(false);
        findViewById(R.id.iv_calendar_date_from).setClickable(false);
        this.mSpinenrTipoSeleccion = (Spinner) findViewById(R.id.spn_seleccion_type);
        this.mSpinenrSituacion = (Spinner) findViewById(R.id.spn_situation);
        this.mSpinenrMoneda = (Spinner) findViewById(R.id.spn_money);
        ArrayAdapter<SpinnerValuesDTO> arrayAdapterSeleccion = new ArrayAdapter<>(this, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_ACCESS_SELECTION_TYPE));
        arrayAdapterSeleccion.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.mSpinenrTipoSeleccion.setAdapter(arrayAdapterSeleccion);
        this.mSpinenrTipoSeleccion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                boolean z = true;
                ActivityAbstractBusqueda.mTextDateFrom.setClickable(position != 0);
                QTextView qTextView = ActivityAbstractBusqueda.mTextDateTo;
                if (position == 0) {
                    z = false;
                }
                qTextView.setClickable(z);
                String unused = ActivityBusquedaExpedientes.this.mTipoSeleccion = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_ACCESS_SELECTION_TYPE).get(position).getCode();
                if (position == 0) {
                    ActivityAbstractBusqueda.mTextDateFrom.setText("DD/MM/YYYY");
                    ActivityAbstractBusqueda.mTextDateTo.setText("DD/MM/YYYY");
                    ActivityAbstractBusqueda.mDateDesde = null;
                    ActivityAbstractBusqueda.mDateHasta = null;
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ArrayAdapter<SpinnerValuesDTO> arrayAdapterSituacion = new ArrayAdapter<>(this, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_CASE_FILE_STATUS));
        arrayAdapterSituacion.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.mSpinenrSituacion.setAdapter(arrayAdapterSituacion);
        this.mSpinenrSituacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = ActivityBusquedaExpedientes.this.mSituacion = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_CASE_FILE_STATUS).get(position).getCode();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_COINS));
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.mSpinenrMoneda.setAdapter(arrayAdapter);
        this.mSpinenrMoneda.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = ActivityBusquedaExpedientes.this.mMoneda = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_COINS).get(position).getCode();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void buscarClick() {
        if (!checkFields()) {
            Intent intent = new Intent();
            if (this.mTextJuzga.getText() != null && !this.mTextJuzga.getText().toString().isEmpty()) {
                intent.putExtra(Constants.EXTRA_JUZGA, this.mTextJuzga.getText().toString());
            }
            if (this.mEditJuzori.getText() != null && !this.mEditJuzori.getText().toString().isEmpty()) {
                intent.putExtra(Constants.EXTRA_JUZGORI, this.mEditJuzori.getText().toString());
            }
            if (this.mEditJproced.getText() != null && !this.mEditJproced.getText().toString().isEmpty()) {
                intent.putExtra(Constants.EXTRA_JPROCED, this.mEditJproced.getText().toString().toUpperCase());
            }
            if (this.mEditJnumexp.getText() != null && !this.mEditJnumexp.getText().toString().isEmpty()) {
                intent.putExtra(Constants.EXTRA_JNUMEXP, this.mEditJnumexp.getText().toString());
            }
            if (this.mEditJanoapex.getText() != null && !this.mEditJanoapex.getText().toString().isEmpty()) {
                intent.putExtra(Constants.EXTRA_JANOAPEX, this.mEditJanoapex.getText().toString());
            }
            String str = this.mTipoSeleccion;
            if (str != null) {
                intent.putExtra(Constants.EXTRA_TIPOS_SELECCION, str);
            }
            String str2 = this.mSituacion;
            if (str2 != null) {
                intent.putExtra(Constants.EXTRA_STATE, str2);
            }
            String str3 = this.mMoneda;
            if (str3 != null) {
                intent.putExtra(Constants.EXTRA_MONEDA, str3);
            }
            if (mDateDesde != null) {
                intent.putExtra(Constants.EXTRA_FECHA_DESDE, mDateDesde);
            }
            if (mDateHasta != null) {
                intent.putExtra(Constants.EXTRA_FECHA_HASTA, mDateHasta);
            }
            setResult(-1, intent);
            finish();
        }
    }
}
