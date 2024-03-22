package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QEditText;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.InitConfigConstants;

public class ActivityBusquedaEmbargos extends ActivityAbstractBusqueda {
    /* access modifiers changed from: private */
    public String mEstadoEmbargo;
    /* access modifiers changed from: private */
    public String mTipoEmbargo;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_embargos);
        getWindow().setSoftInputMode(2);
        initUi();
        this.mEditJuzori.requestFocus();
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityBusquedaEmbargos] */
    /* access modifiers changed from: protected */
    public void defineSpinners() {
        Spinner spinenrTipo = (Spinner) findViewById(R.id.spn_type);
        Spinner spinenrEstado = (Spinner) findViewById(R.id.spn_state);
        ArrayAdapter<SpinnerValuesDTO> arrayAdapterTipo = new ArrayAdapter<>(this, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_TIPO_EMBARGO));
        arrayAdapterTipo.setDropDownViewResource(R.layout.simple_spinner_item_down);
        spinenrTipo.setAdapter(arrayAdapterTipo);
        spinenrTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = ActivityBusquedaEmbargos.this.mTipoEmbargo = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_TIPO_EMBARGO).get(position).getCode();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_ESTADO_EMBARGO));
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        spinenrEstado.setAdapter(arrayAdapter);
        spinenrEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = ActivityBusquedaEmbargos.this.mEstadoEmbargo = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_ESTADO_EMBARGO).get(position).getCode();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void buscarClick() {
        if (!checkFields()) {
            QEditText mEditImporteDesde = (QEditText) findViewById(R.id.edit_importe_desde);
            QEditText mEditImporteHasta = (QEditText) findViewById(R.id.edit_importe_hasta);
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
            String str = this.mTipoEmbargo;
            if (str != null) {
                intent.putExtra(Constants.EXTRA_TIPO_EMBARGO, str);
            }
            String str2 = this.mEstadoEmbargo;
            if (str2 != null) {
                intent.putExtra(Constants.EXTRA_ESTADO_EMBARGO, str2);
            }
            if (mEditImporteDesde.getText() != null && !mEditImporteDesde.getText().toString().isEmpty()) {
                intent.putExtra(Constants.EXTRA_IMPORTE_DESDE, mEditImporteDesde.getText().toString());
            }
            if (mEditImporteHasta.getText() != null && !mEditImporteHasta.getText().toString().isEmpty()) {
                intent.putExtra(Constants.EXTRA_IMPORTE_HASTA, mEditImporteHasta.getText().toString());
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
