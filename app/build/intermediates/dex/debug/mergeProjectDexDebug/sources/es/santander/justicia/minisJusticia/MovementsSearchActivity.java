package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.app.DatePickerDialog;
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
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MovementsSearchActivity extends MainActivity {
    /* access modifiers changed from: private */
    public Activity activity;
    private Button btnSearch;
    private Context context;
    private SimpleDateFormat dateFormatter;
    /* access modifiers changed from: private */
    public EditText etDateFrom;
    /* access modifiers changed from: private */
    public EditText etDateTo;
    /* access modifiers changed from: private */
    public EditText etImportFrom;
    /* access modifiers changed from: private */
    public EditText etImportTo;
    private DatePickerDialog fromDatePickerDialog;
    private ImageView ivCalendarFrom;
    private ImageView ivCalendarTo;
    private ConstraintLayout parentLayout;
    /* access modifiers changed from: private */
    public Spinner spnCurrencyType;
    /* access modifiers changed from: private */
    public Spinner spnMovementType;
    private DatePickerDialog toDatePickerDialog;

    /* JADX WARNING: type inference failed for: r12v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context, es.santander.justicia.minisJusticia.MovementsSearchActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTealiumName("/busqueda_movimiento");
        setContentView(R.layout.responsive_movement_search);
        this.context = getApplicationContext();
        this.activity = this;
        this.parentLayout = findViewById(R.id.parent_layout);
        ((TextView) findViewById(R.id.tv_toolbar_title)).setText(R.string.movement_search_toolbar_title);
        ((ImageButton) findViewById(R.id.buttonBack)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MovementsSearchActivity.this.finish();
            }
        });
        this.etDateFrom = (EditText) findViewById(R.id.text_date_from);
        this.etDateTo = (EditText) findViewById(R.id.text_date_to);
        this.etImportFrom = (EditText) findViewById(R.id.et_import_from);
        this.etImportTo = (EditText) findViewById(R.id.et_import_to);
        this.ivCalendarFrom = (ImageView) findViewById(R.id.iv_calendar_date_from);
        this.ivCalendarTo = (ImageView) findViewById(R.id.iv_calendar_date_to);
        this.spnMovementType = (Spinner) findViewById(R.id.spn_movement_type);
        this.spnCurrencyType = (Spinner) findViewById(R.id.spn_coin_type);
        this.btnSearch = (Button) findViewById(R.id.btn_search_movement);
        this.etDateFrom.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_DATE), new InputFilter.LengthFilter(10)});
        this.etDateTo.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_DATE), new InputFilter.LengthFilter(10)});
        this.etDateFrom.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return true;
                }
                DateUtils.getDateFromPicker(MovementsSearchActivity.this.activity, MovementsSearchActivity.this.etDateFrom);
                return true;
            }
        });
        this.etDateTo.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return true;
                }
                DateUtils.getDateFromPicker(MovementsSearchActivity.this.activity, MovementsSearchActivity.this.etDateTo);
                return true;
            }
        });
        ImageView imageView = this.ivCalendarFrom;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DateUtils.getDateFromPicker(MovementsSearchActivity.this.activity, MovementsSearchActivity.this.etDateFrom);
                }
            });
        }
        ImageView imageView2 = this.ivCalendarTo;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    DateUtils.getDateFromPicker(MovementsSearchActivity.this.activity, MovementsSearchActivity.this.etDateTo);
                }
            });
        }
        ArrayList<SpinnerValuesDTO> movementValues = new ArrayList<>(SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_MOTION_QUERY));
        SpinnerValuesDTO defaultValue = new SpinnerValuesDTO();
        defaultValue.setValueToShow(getString(R.string.movement_type));
        movementValues.add(0, defaultValue);
        ArrayAdapter<SpinnerValuesDTO> movementAdapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item, R.id.text_spinner, movementValues);
        movementAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.spnMovementType.setAdapter(movementAdapter);
        ArrayList<SpinnerValuesDTO> coinValues = new ArrayList<>(SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_COINS));
        SpinnerValuesDTO defaultCoinValue = new SpinnerValuesDTO();
        defaultCoinValue.setValueToShow(getString(R.string.coin));
        coinValues.add(0, defaultCoinValue);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_item, R.id.text_spinner, coinValues);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.spnCurrencyType.setAdapter(arrayAdapter);
        this.parentLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                CommonUtils.hideKeyboard(MovementsSearchActivity.this.activity);
                return false;
            }
        });
        this.btnSearch.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.MovementsSearchActivity] */
            public void onClick(View v) {
                Intent intent = new Intent(MovementsSearchActivity.this, ActivityListaMovimientos.class).addFlags(67108864);
                intent.putExtra("BuscarMovimientos", true);
                intent.putExtra(Constants.DATE_FROM, MovementsSearchActivity.this.etDateFrom.getText().toString());
                intent.putExtra(Constants.DATE_TO, MovementsSearchActivity.this.etDateTo.getText().toString());
                intent.putExtra(Constants.IMPORT_FROM, MovementsSearchActivity.this.etImportFrom.getText().toString());
                intent.putExtra(Constants.IMPORT_TO, MovementsSearchActivity.this.etImportTo.getText().toString());
                intent.putExtra(Constants.MOVEMENT_TYPE, ((SpinnerValuesDTO) MovementsSearchActivity.this.spnMovementType.getSelectedItem()).getCode());
                intent.putExtra(Constants.CURRENCY_TYPE, ((SpinnerValuesDTO) MovementsSearchActivity.this.spnCurrencyType.getSelectedItem()).getCode());
                intent.putExtra("flag_empty", true);
                MovementsSearchActivity.this.setResult(-1, intent);
                MovementsSearchActivity.this.startActivity(intent);
                MovementsSearchActivity.this.finish();
            }
        });
    }
}
