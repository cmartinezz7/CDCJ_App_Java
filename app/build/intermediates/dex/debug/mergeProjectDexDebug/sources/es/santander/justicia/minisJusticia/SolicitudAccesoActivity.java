package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.controllers.AccessRequestController;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.enums.PopupTypeEnum;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;
import es.santander.justicia.minisJusticia.interfaces.AccessRequestCallback;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.InitConfigConstants;

public class SolicitudAccesoActivity extends MainActivity implements AccessRequestCallback {
    /* access modifiers changed from: private */
    public AccessRequestController accessRequestController;
    /* access modifiers changed from: private */
    public Activity activity;
    private Context context;
    private ProgressDialog dialog;
    /* access modifiers changed from: private */
    public String environment;
    /* access modifiers changed from: private */
    public EditText etJanoapex;
    /* access modifiers changed from: private */
    public EditText etJnumexp;
    /* access modifiers changed from: private */
    public EditText etJproced;
    /* access modifiers changed from: private */
    public EditText etJuzga;
    /* access modifiers changed from: private */
    public EditText etJuzgori;
    private ConstraintLayout parentLayout;
    private Button sendButton;
    /* access modifiers changed from: private */
    public Spinner spnMotive;
    private TextView tvUserName;

    /* JADX WARNING: type inference failed for: r13v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context, com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener, es.santander.justicia.minisJusticia.interfaces.AccessRequestCallback, es.santander.justicia.minisJusticia.SolicitudAccesoActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTealiumName("/solicitud_acceso");
        setNavigationId(R.id.solicitud_acceso);
        this.context = getBaseContext();
        this.activity = this;
        this.accessRequestController = new AccessRequestController(this);
        this.environment = MainApplication.getAppContext().getEnvironment();
        setContentView(R.layout.activity_solicitudacceso);
        ((QFontTextView) findViewById(R.id.bar_title)).setText(R.string.title_activity_solicitudAcceso);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, findViewById(R.id.toolbar), 2131886647, 2131886646);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            public void onDrawerSlide(View drawerView, float slideOffset) {
                CommonUtils.hideKeyboard(SolicitudAccesoActivity.this.activity);
            }

            public void onDrawerOpened(View drawerView) {
            }

            public void onDrawerClosed(View drawerView) {
            }

            public void onDrawerStateChanged(int newState) {
            }
        });
        NavigationView navigationView = findViewById(2131362529);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(1).setChecked(true);
        navigationView.getMenu().getItem(4).getIcon().setColorFilter(ContextCompat.getColor(this, R.color.red), PorterDuff.Mode.SRC_IN);
        this.parentLayout = findViewById(R.id.parent_layout);
        this.etJuzga = (EditText) findViewById(R.id.et_field_1);
        this.etJuzgori = (EditText) findViewById(R.id.et_field_2);
        this.etJproced = (EditText) findViewById(R.id.et_field_3);
        this.etJnumexp = (EditText) findViewById(R.id.et_field_4);
        this.etJanoapex = (EditText) findViewById(R.id.et_field_5);
        this.etJuzga.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
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
        this.etJuzgori.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
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
        this.etJproced.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
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
        this.etJnumexp.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
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
        this.etJanoapex.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
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
        this.etJuzga.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(4)});
        this.etJuzgori.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(4)});
        this.etJproced.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC_CAPS), new InputFilter.LengthFilter(2)});
        this.etJnumexp.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(4)});
        this.etJanoapex.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(2)});
        this.spnMotive = (Spinner) findViewById(R.id.sp_motive);
        ArrayAdapter<SpinnerValuesDTO> spnAdapter = new ArrayAdapter<>(this.context, R.layout.simple_spinner_item, R.id.text_spinner, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_ACCESS_REQUEST_REASON));
        spnAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.spnMotive.setAdapter(spnAdapter);
        Button button = (Button) findViewById(R.id.btn_send);
        this.sendButton = button;
        button.setEnabled(false);
        this.etJuzga.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                SolicitudAccesoActivity.this.validateEnableSendButton();
            }
        });
        this.etJuzgori.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                SolicitudAccesoActivity.this.validateEnableSendButton();
            }
        });
        this.etJproced.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                SolicitudAccesoActivity.this.validateEnableSendButton();
            }
        });
        this.etJnumexp.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                SolicitudAccesoActivity.this.validateEnableSendButton();
            }
        });
        this.etJanoapex.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                SolicitudAccesoActivity.this.validateEnableSendButton();
            }
        });
        this.sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TealiumHelper.trackEvent("/solicitud_acceso", "solicitud_acceso (enviar)");
                SolicitudAccesoActivity.this.showDialog();
                SolicitudAccesoActivity.this.accessRequestController.sendAccessRequest(SolicitudAccesoActivity.this.etJuzga.getText().toString(), SolicitudAccesoActivity.this.etJuzgori.getText().toString(), SolicitudAccesoActivity.this.etJproced.getText().toString(), SolicitudAccesoActivity.this.etJnumexp.getText().toString(), SolicitudAccesoActivity.this.etJanoapex.getText().toString(), ((SpinnerValuesDTO) SolicitudAccesoActivity.this.spnMotive.getSelectedItem()).getCode(), SolicitudAccesoActivity.this.environment);
            }
        });
        this.parentLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                CommonUtils.hideKeyboard(SolicitudAccesoActivity.this.activity);
                return false;
            }
        });
        String username = "";
        if (!(LoginManager.getInstance() == null || LoginManager.getInstance().getNombreUsuario() == null)) {
            username = LoginManager.getInstance().getNombreUsuario().isEmpty() ? "" : LoginManager.getInstance().getNombreUsuario();
        }
        TextView textView = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tv_user_name);
        this.tvUserName = textView;
        if (textView != null) {
            textView.setText(CommonUtils.wordCapitalize(username));
        }
        ((LinearLayout) findViewById(R.id.close_session)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SolicitudAccesoActivity.this.logout();
            }
        });
    }

    public void onFinishRequest(String faultCode, String faultMessage, boolean success) {
        ProgressDialog progressDialog = this.dialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.dialog.dismiss();
        }
        if (success) {
            TealiumHelper.trackEvent("/solicitud_acceso", "solicitud_acceso (popup enviado)");
            Intent popup = new Intent(this.context, PopupActivity.class);
            popup.putExtra(Constants.POPUP_NAME, PopupTypeEnum.ACCESS_REQUEST_SENT_CORRECTLY.getId());
            startActivity(popup);
            return;
        }
        Toast.makeText(this.context, faultMessage, 0).show();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.accessRequestController = null;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.SolicitudAccesoActivity] */
    /* access modifiers changed from: private */
    public void showDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCancelable(false);
        this.dialog.setMessage(this.context.getResources().getString(R.string.sending_request));
        this.dialog.show();
    }

    /* access modifiers changed from: private */
    public void validateEnableSendButton() {
        if (this.etJuzga.getText().toString().trim().isEmpty() || this.etJuzga.getText().length() != 4 || this.etJuzgori.getText().toString().trim().isEmpty() || this.etJuzgori.getText().length() != 4 || this.etJproced.getText().toString().trim().isEmpty() || this.etJproced.getText().length() != 2 || this.etJnumexp.getText().toString().trim().isEmpty() || this.etJnumexp.getText().length() != 4 || this.etJanoapex.getText().toString().trim().isEmpty() || this.etJanoapex.getText().length() != 2) {
            this.sendButton.setEnabled(false);
        } else {
            this.sendButton.setEnabled(true);
        }
    }
}
