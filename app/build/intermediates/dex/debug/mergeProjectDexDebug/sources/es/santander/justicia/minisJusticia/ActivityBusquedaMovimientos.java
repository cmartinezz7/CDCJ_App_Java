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
import es.santander.justicia.minisJusticia.views.QEditText;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.InitConfigConstants;

public class ActivityBusquedaMovimientos extends ActivityAbstractBusqueda {
    /* access modifiers changed from: private */
    public String mMoney;
    /* access modifiers changed from: private */
    public String mType;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda_movimientos);
        getWindow().setSoftInputMode(2);
        initUi();
    }

    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/busqueda_movimiento");
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityBusquedaMovimientos] */
    /* access modifiers changed from: protected */
    public void defineSpinners() {
        Spinner spinenrTipo = (Spinner) findViewById(R.id.spn_type);
        Spinner spinenrEstado = (Spinner) findViewById(R.id.spn_money);
        ArrayAdapter<SpinnerValuesDTO> arrayAdapterTipo = new ArrayAdapter<>(this, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_MOTION_QUERY));
        arrayAdapterTipo.setDropDownViewResource(R.layout.simple_spinner_item_down);
        spinenrTipo.setAdapter(arrayAdapterTipo);
        spinenrTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = ActivityBusquedaMovimientos.this.mType = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_MOTION_QUERY).get(position).getCode();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_COINS));
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        spinenrEstado.setAdapter(arrayAdapter);
        spinenrEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = ActivityBusquedaMovimientos.this.mMoney = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_COINS).get(position).getCode();
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
            if (mDateDesde != null && !mDateDesde.isEmpty()) {
                intent.putExtra(Constants.EXTRA_FECHA_DESDE, mDateDesde);
            }
            if (mDateHasta != null && !mDateHasta.isEmpty()) {
                intent.putExtra(Constants.EXTRA_FECHA_HASTA, mDateHasta);
            }
            if (mEditImporteDesde.getText() != null && !mEditImporteDesde.getText().toString().isEmpty()) {
                intent.putExtra(Constants.EXTRA_IMPORTE_DESDE, mEditImporteDesde.getText().toString());
            }
            if (mEditImporteHasta.getText() != null && !mEditImporteHasta.getText().toString().isEmpty()) {
                intent.putExtra(Constants.EXTRA_IMPORTE_HASTA, mEditImporteHasta.getText().toString());
            }
            String str = this.mType;
            if (str != null && !str.isEmpty()) {
                intent.putExtra(Constants.EXTRA_TIPO_MOVIMIENTO, this.mType);
            }
            String str2 = this.mMoney;
            if (str2 != null && !str2.isEmpty()) {
                intent.putExtra(Constants.EXTRA_MONEDA, this.mMoney);
            }
            setResult(-1, intent);
            finish();
        }
    }
}
