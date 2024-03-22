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
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.InitConfigConstants;

public class ActivityBusquedaAuthExpedi extends ActivityAbstractBusqueda {
    private Spinner mSpinnerState;
    /* access modifiers changed from: private */
    public String mStateCode;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_auth_exp);
        getWindow().setSoftInputMode(2);
        initUi();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityBusquedaAuthExpedi] */
    /* access modifiers changed from: protected */
    public void defineSpinners() {
        this.mSpinnerState = (Spinner) findViewById(R.id.spn_state);
        ArrayAdapter<SpinnerValuesDTO> arrayAdapterSeleccion = new ArrayAdapter<>(this, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_ACCESS_REQUEST_STATUS));
        arrayAdapterSeleccion.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.mSpinnerState.setAdapter(arrayAdapterSeleccion);
        this.mSpinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = ActivityBusquedaAuthExpedi.this.mStateCode = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_ACCESS_REQUEST_STATUS).get(position).getCode();
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
            String str = this.mStateCode;
            if (str != null) {
                intent.putExtra(Constants.EXTRA_STATE, str);
            }
            setResult(-1, intent);
            finish();
        }
    }
}
