package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import androidx.constraintlayout.widget.ConstraintLayout;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.DateUtils;
import es.santander.justicia.utils.InitConfigConstants;
import java.util.ArrayList;

public class BusquedaExpedientesActivity extends MainActivity {
    /* access modifiers changed from: private */
    public Activity activity;
    private Context context;
    public EditText etDateFrom;
    public EditText etDateTo;
    public EditText etJanoapex;
    public EditText etJnumexp;
    public EditText etJproced;
    public EditText etJusga;
    public EditText etJusgori;
    /* access modifiers changed from: private */
    public String expedientNumber;
    private ConstraintLayout parentLayout;
    private Button searchButton;
    public Spinner spnMoney;
    public Spinner spnSelectionType;
    public Spinner spnSituation;
    public String typeEstate;

    /* JADX WARNING: type inference failed for: r14v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, es.santander.justicia.minisJusticia.BusquedaExpedientesActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTealiumName("/busqueda_expediente");
        setContentView(R.layout.responsive_busqueda_expedientes);
        this.activity = this;
        this.context = getBaseContext();
        this.parentLayout = findViewById(R.id.cl_parent);
        this.etJusga = (EditText) findViewById(R.id.et_exp1);
        this.etJusgori = (EditText) findViewById(R.id.et_exp2);
        this.etJproced = (EditText) findViewById(R.id.et_exp3);
        this.etJnumexp = (EditText) findViewById(R.id.et_exp4);
        this.etJanoapex = (EditText) findViewById(R.id.et_exp5);
        this.etJusga.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(4)});
        this.etJusgori.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(4)});
        this.etJproced.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC_CAPS), new InputFilter.LengthFilter(2)});
        this.etJnumexp.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(4)});
        this.etJanoapex.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(2)});
        this.etDateFrom = (EditText) findViewById(R.id.et_date_from);
        this.etDateTo = (EditText) findViewById(R.id.et_date_to);
        this.etDateFrom.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_DATE), new InputFilter.LengthFilter(10)});
        this.etDateTo.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_DATE), new InputFilter.LengthFilter(10)});
        this.etDateFrom.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return true;
                }
                DateUtils.getDateFromPicker(BusquedaExpedientesActivity.this.activity, BusquedaExpedientesActivity.this.etDateFrom);
                return true;
            }
        });
        this.etDateTo.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return true;
                }
                DateUtils.getDateFromPicker(BusquedaExpedientesActivity.this.activity, BusquedaExpedientesActivity.this.etDateTo);
                return true;
            }
        });
        this.spnSelectionType = (Spinner) findViewById(R.id.spn_seleccion_type);
        this.spnSituation = (Spinner) findViewById(R.id.spn_situation);
        this.spnMoney = (Spinner) findViewById(R.id.spn_money);
        this.searchButton = (Button) findViewById(R.id.btn_peticiones);
        ArrayList<SpinnerValuesDTO> spnSectionTypeValues = new ArrayList<>(SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_ACCESS_SELECTION_TYPE));
        SpinnerValuesDTO defaultTypeValue = new SpinnerValuesDTO();
        defaultTypeValue.setValueToShow(getString(R.string.type));
        spnSectionTypeValues.add(0, defaultTypeValue);
        ArrayList<SpinnerValuesDTO> spnSituationValues = new ArrayList<>(SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_CASE_FILE_STATUS));
        SpinnerValuesDTO defaultSituationValue = new SpinnerValuesDTO();
        defaultSituationValue.setValueToShow(getString(R.string.situation_empty));
        spnSituationValues.add(0, defaultSituationValue);
        ArrayList<SpinnerValuesDTO> spnMoneyValues = new ArrayList<>(SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_COINS));
        SpinnerValuesDTO defaultCoinValue = new SpinnerValuesDTO();
        defaultCoinValue.setValueToShow(getString(R.string.coin));
        spnMoneyValues.add(0, defaultCoinValue);
        ArrayAdapter<SpinnerValuesDTO> spnSectionTypeAdapter = new ArrayAdapter<>(this.context, R.layout.simple_spinner_item, R.id.text_spinner, spnSectionTypeValues);
        spnSectionTypeAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.spnSelectionType.setAdapter(spnSectionTypeAdapter);
        ArrayAdapter<SpinnerValuesDTO> spnSituationAdapter = new ArrayAdapter<>(this.context, R.layout.simple_spinner_item, R.id.text_spinner, spnSituationValues);
        spnSituationAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.spnSituation.setAdapter(spnSituationAdapter);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.context, R.layout.simple_spinner_item, R.id.text_spinner, spnMoneyValues);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.spnMoney.setAdapter(arrayAdapter);
        findViewById(R.id.iv_red_arrow33).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BusquedaExpedientesActivity.this.spnSelectionType.performClick();
            }
        });
        ((ImageButton) findViewById(R.id.buttonBack)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BusquedaExpedientesActivity.this.finish();
            }
        });
        this.searchButton.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r4v7, types: [android.content.Context, es.santander.justicia.minisJusticia.BusquedaExpedientesActivity] */
            public void onClick(View v) {
                String unused = BusquedaExpedientesActivity.this.expedientNumber = BusquedaExpedientesActivity.this.etJusga.getText().toString() + BusquedaExpedientesActivity.this.etJusgori.getText().toString() + BusquedaExpedientesActivity.this.etJproced.getText().toString() + BusquedaExpedientesActivity.this.etJnumexp.getText().toString() + BusquedaExpedientesActivity.this.etJanoapex.getText().toString();
                Intent intent = new Intent(BusquedaExpedientesActivity.this, HomeActivity.class);
                intent.putExtra(Constants.DATE_FROM, BusquedaExpedientesActivity.this.etDateFrom.getText().toString());
                intent.putExtra(Constants.DATE_TO, BusquedaExpedientesActivity.this.etDateTo.getText().toString());
                intent.putExtra(Constants.EXPEDIENT_NUMBER, BusquedaExpedientesActivity.this.expedientNumber);
                intent.putExtra(Constants.EXPEDIENT_JUZGA, BusquedaExpedientesActivity.this.etJusga.getText().toString());
                intent.putExtra(Constants.EXPEDIENT_JUZGORI, BusquedaExpedientesActivity.this.etJusgori.getText().toString());
                intent.putExtra(Constants.EXPEDIENT_JPROCED, BusquedaExpedientesActivity.this.etJproced.getText().toString());
                intent.putExtra(Constants.EXPEDIENT_JNUMEXP, BusquedaExpedientesActivity.this.etJnumexp.getText().toString());
                intent.putExtra(Constants.EXPEDIENT_JANOAPEX, BusquedaExpedientesActivity.this.etJanoapex.getText().toString());
                intent.putExtra(Constants.SELECTION_VALUE, ((SpinnerValuesDTO) BusquedaExpedientesActivity.this.spnSelectionType.getSelectedItem()).getCode());
                intent.putExtra(Constants.SITUATION_VALUE, ((SpinnerValuesDTO) BusquedaExpedientesActivity.this.spnSituation.getSelectedItem()).getCode());
                intent.putExtra(Constants.CURRENCY_VALUE, ((SpinnerValuesDTO) BusquedaExpedientesActivity.this.spnMoney.getSelectedItem()).getCode());
                intent.putExtra("busquedaExpedientes", true);
                BusquedaExpedientesActivity.this.startActivity(intent);
                BusquedaExpedientesActivity.this.finish();
            }
        });
        this.parentLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                CommonUtils.hideKeyboard(BusquedaExpedientesActivity.this.activity);
                return false;
            }
        });
    }
}
