package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import androidx.constraintlayout.widget.ConstraintLayout;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QFontButton;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.DateUtils;
import es.santander.justicia.utils.InitConfigConstants;

public class BusquedaPeticionesActivity extends MainActivity {
    /* access modifiers changed from: private */
    public Activity activity;
    private Context context;
    public EditText etDateFrom;
    public EditText etDateTo;
    public EditText etJanoapex;
    public EditText etJnumexp;
    public EditText etJproced;
    public EditText etJuzga;
    public EditText etJuzgori;
    /* access modifiers changed from: private */
    public String expedientNumber;
    private ConstraintLayout parentLayout;
    private QFontButton searchButton;
    public Spinner spnStatus;

    /* JADX WARNING: type inference failed for: r10v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, es.santander.justicia.minisJusticia.BusquedaPeticionesActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTealiumName("/busqueda_solicitudes");
        setContentView(R.layout.activity_peticiones_con_busqueda);
        setNavigationId(R.id.listado_peticiones);
        this.activity = this;
        this.context = getBaseContext();
        this.parentLayout = findViewById(R.id.parent_layout);
        this.etJuzga = (EditText) findViewById(R.id.text_exp1);
        this.etJuzgori = (EditText) findViewById(R.id.et_exp2);
        this.etJproced = (EditText) findViewById(R.id.et_exp3);
        this.etJnumexp = (EditText) findViewById(R.id.et_exp4);
        this.etJanoapex = (EditText) findViewById(R.id.et_exp5);
        this.etJuzga.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(4)});
        this.etJuzgori.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(4)});
        this.etJproced.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC_CAPS), new InputFilter.LengthFilter(2)});
        this.etJnumexp.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(4)});
        this.etJanoapex.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(2)});
        this.etDateFrom = (EditText) findViewById(R.id.text_date_from);
        this.etDateTo = (EditText) findViewById(R.id.text_date_to);
        this.etDateFrom.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode mode) {
            }

            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }
        });
        this.etDateTo.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode mode) {
            }

            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }
        });
        this.etDateFrom.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_DATE), new InputFilter.LengthFilter(10)});
        this.etDateTo.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_DATE), new InputFilter.LengthFilter(10)});
        this.etDateFrom.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return true;
                }
                DateUtils.getDateFromPicker(BusquedaPeticionesActivity.this.activity, BusquedaPeticionesActivity.this.etDateFrom);
                return true;
            }
        });
        this.etDateTo.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return true;
                }
                DateUtils.getDateFromPicker(BusquedaPeticionesActivity.this.activity, BusquedaPeticionesActivity.this.etDateTo);
                return true;
            }
        });
        this.spnStatus = (Spinner) findViewById(R.id.spn_status);
        this.searchButton = (QFontButton) findViewById(R.id.text_btn_peticiones);
        ArrayAdapter<SpinnerValuesDTO> spnStatusAdapter = new ArrayAdapter<>(this.context, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_ACCESS_REQUEST_STATUS));
        spnStatusAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.spnStatus.setAdapter(spnStatusAdapter);
        ((ImageButton) findViewById(R.id.buttonBack)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BusquedaPeticionesActivity.this.finish();
            }
        });
        this.searchButton.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r2v7, types: [android.content.Context, es.santander.justicia.minisJusticia.BusquedaPeticionesActivity] */
            public void onClick(View v) {
                String unused = BusquedaPeticionesActivity.this.expedientNumber = BusquedaPeticionesActivity.this.etJuzga.getText().toString() + BusquedaPeticionesActivity.this.etJuzgori.getText().toString() + BusquedaPeticionesActivity.this.etJproced.getText().toString() + BusquedaPeticionesActivity.this.etJnumexp.getText().toString() + BusquedaPeticionesActivity.this.etJanoapex.getText().toString();
                Intent intent = new Intent(BusquedaPeticionesActivity.this, ListadoPeticionesActivity.class);
                intent.putExtra(Constants.DATE_FROM, BusquedaPeticionesActivity.this.etDateFrom.getText().toString());
                intent.putExtra(Constants.DATE_TO, BusquedaPeticionesActivity.this.etDateTo.getText().toString());
                intent.putExtra(Constants.EXPEDIENT_JUZGA, BusquedaPeticionesActivity.this.etJuzga.getText().toString());
                intent.putExtra(Constants.EXPEDIENT_JUZGORI, BusquedaPeticionesActivity.this.etJuzgori.getText().toString());
                intent.putExtra(Constants.EXPEDIENT_JPROCED, BusquedaPeticionesActivity.this.etJproced.getText().toString());
                intent.putExtra(Constants.EXPEDIENT_JNUMEXP, BusquedaPeticionesActivity.this.etJnumexp.getText().toString());
                intent.putExtra(Constants.EXPEDIENT_JANOAPEX, BusquedaPeticionesActivity.this.etJanoapex.getText().toString());
                intent.putExtra(Constants.STATE_VALUE, ((SpinnerValuesDTO) BusquedaPeticionesActivity.this.spnStatus.getSelectedItem()).getCode());
                intent.putExtra("busquedaPeticiones", true);
                BusquedaPeticionesActivity.this.startActivity(intent);
                BusquedaPeticionesActivity.this.finish();
            }
        });
        this.parentLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                CommonUtils.hideKeyboard(BusquedaPeticionesActivity.this.activity);
                return false;
            }
        });
    }
}
