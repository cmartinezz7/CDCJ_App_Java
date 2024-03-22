package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.expedientes.task.LoginExpedientesTask;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.login.tasks.LoginProfesionalesTask;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.InitConfigConstants;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ActivityLoginProfesionalesOld extends MainActivity implements View.OnClickListener, ActivityCallBack {
    /* access modifiers changed from: private */
    public Boolean FlagAyuda = true;
    /* access modifiers changed from: private */
    public Activity activity;
    private TextView areNotYou;
    private ImageButton backRow;
    private Button btnAcceder;
    private CheckBox checkRememberMe;
    /* access modifiers changed from: private */
    public boolean companyMode = false;
    private ArrayList<SpinnerValuesDTO> documentTypes;
    private ArrayAdapter<SpinnerValuesDTO> documentTypesAdapter;
    protected EditText etCode;
    protected EditText etDocumentNumber;
    protected EditText etPass;
    protected RelativeLayout firstSpinnerContainer;
    public String lastValueDocument;
    public String lastValuePass;
    public String lastVaueCode;
    protected LinearLayout linealAreNotYouLink;
    /* access modifiers changed from: private */
    public int posDefaultSpDocument = 0;
    /* access modifiers changed from: private */
    public int posDefaultSpPrivate = 0;
    /* access modifiers changed from: private */
    public boolean privateDocumentSelected = false;
    private ProgressDialog progressDialog;
    protected ConstraintLayout radioButtonsContainer;
    protected RadioButton rbCompany;
    protected RadioButton rbParticular;
    /* access modifiers changed from: private */
    public boolean rememberMeChecked = false;
    protected LinearLayout rememberMeContainer;
    protected RelativeLayout secondSpinnerContainer;
    protected LinearLayout spinnerContainer;
    protected Spinner spnDocumentTypes;
    protected Spinner spnPrivateType;
    private TextView tvUserName;
    private TextView tv_problemas_entrar;
    private TextView tv_saludo;
    public String typeDocu;
    private boolean wasCompanyModeChecked = false;

    /* JADX WARNING: type inference failed for: r6v0, types: [es.santander.justicia.minisJusticia.ActivityLoginProfesionalesOld, es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context, android.view.View$OnClickListener, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.responsive_login);
        Map<String, String> data = new HashMap<>();
        data.put(TealiumHelper.TEALIUM_PERFIL_APP, UserDTO.APP_PROFESIONALES);
        TealiumHelper.trackView("/login", data);
        this.activity = this;
        this.spnDocumentTypes = (Spinner) findViewById(R.id.spn_document_type);
        this.spnPrivateType = (Spinner) findViewById(R.id.spn_document_type_particulares);
        this.etDocumentNumber = (EditText) findViewById(R.id.et_logProf_numeroDocumento);
        this.etCode = (EditText) findViewById(R.id.et_logProf_codigo);
        this.etPass = (EditText) findViewById(R.id.et_logProf_password);
        this.btnAcceder = (Button) findViewById(R.id.bt_logProf_acceder);
        this.backRow = (ImageButton) findViewById(R.id.iv_back_row);
        this.firstSpinnerContainer = (RelativeLayout) findViewById(R.id.cl_first_spinner_container);
        this.secondSpinnerContainer = (RelativeLayout) findViewById(R.id.cl_second_spinner_container);
        this.radioButtonsContainer = findViewById(R.id.cl_radio_buttons_container);
        this.spinnerContainer = (LinearLayout) findViewById(R.id.spinners_document_type);
        this.rememberMeContainer = (LinearLayout) findViewById(R.id.cl_remember_me_container);
        this.linealAreNotYouLink = (LinearLayout) findViewById(R.id.lineal_are_not_you_link);
        this.etPass.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
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
        this.etDocumentNumber.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
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
        this.etCode.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
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
        this.rbParticular = (RadioButton) findViewById(R.id.rb_particular);
        this.rbCompany = (RadioButton) findViewById(R.id.rb_empresa);
        this.tv_saludo = (TextView) findViewById(R.id.tv_greeting);
        this.tvUserName = (TextView) findViewById(R.id.tv_user_login);
        this.areNotYou = (TextView) findViewById(R.id.tv_are_not_you_link);
        this.tv_problemas_entrar = (TextView) findViewById(R.id.clickHere);
        this.checkRememberMe = (CheckBox) findViewById(R.id.cb_remember_me);
        this.btnAcceder.setOnClickListener(this);
        this.btnAcceder.setEnabled(false);
        Paint p = new Paint();
        p.setColor(ContextCompat.getColor(this.checkRememberMe.getContext(), R.color.colorPrimary));
        this.checkRememberMe.setPaintFlags(p.getColor());
        this.checkRememberMe.setPaintFlags(8);
        this.tv_problemas_entrar.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r2v1, types: [es.santander.justicia.minisJusticia.ActivityLoginProfesionalesOld, android.content.Context] */
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("flag_ayuda", ActivityLoginProfesionalesOld.this.FlagAyuda.booleanValue());
                Intent intent = new Intent(ActivityLoginProfesionalesOld.this, ActivityHelp.class);
                intent.putExtras(bundle);
                ActivityLoginProfesionalesOld.this.startActivity(intent);
            }
        });
        this.spnPrivateType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                boolean resetData = false;
                if (ActivityLoginProfesionalesOld.this.posDefaultSpPrivate != position) {
                    resetData = true;
                    int unused = ActivityLoginProfesionalesOld.this.posDefaultSpPrivate = position;
                }
                if (position == 0) {
                    ActivityLoginProfesionalesOld.this.secondSpinnerContainer.setVisibility(0);
                    if (resetData) {
                        ActivityLoginProfesionalesOld.this.resetFields();
                    }
                    ActivityLoginProfesionalesOld.this.spnDocumentTypes.setSelection(0);
                    ActivityLoginProfesionalesOld.this.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC), new InputFilter.LengthFilter(9)});
                    boolean unused2 = ActivityLoginProfesionalesOld.this.privateDocumentSelected = true;
                } else if (position == 1) {
                    ActivityLoginProfesionalesOld.this.secondSpinnerContainer.setVisibility(8);
                    if (resetData) {
                        ActivityLoginProfesionalesOld.this.resetFields();
                    }
                    ActivityLoginProfesionalesOld.this.etDocumentNumber.setHint(R.string.label_alias);
                    ActivityLoginProfesionalesOld.this.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC), new InputFilter.LengthFilter(20)});
                    boolean unused3 = ActivityLoginProfesionalesOld.this.privateDocumentSelected = false;
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.spnDocumentTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
                boolean resetData = false;
                if (ActivityLoginProfesionalesOld.this.posDefaultSpDocument != i) {
                    resetData = true;
                    int unused = ActivityLoginProfesionalesOld.this.posDefaultSpDocument = i;
                }
                if (!ActivityLoginProfesionalesOld.this.companyMode) {
                    String valueCode = ((ArrayAdapter) parent.getAdapter()).getItem(i).getCode();
                    if (resetData) {
                        ActivityLoginProfesionalesOld.this.resetFields();
                    }
                    char c = 65535;
                    int hashCode = valueCode.hashCode();
                    if (hashCode != 67) {
                        if (hashCode != 78) {
                            if (hashCode != 80) {
                                if (hashCode == 83 && valueCode.equals("S")) {
                                    c = 0;
                                }
                            } else if (valueCode.equals(ActivityDetalleOperacion.CODIGO_ESTADO_P)) {
                                c = 3;
                            }
                        } else if (valueCode.equals("N")) {
                            c = 1;
                        }
                    } else if (valueCode.equals("C")) {
                        c = 2;
                    }
                    if (c == 0 || c == 1) {
                        ActivityLoginProfesionalesOld.this.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC), new InputFilter.LengthFilter(9)});
                    } else if (c == 2 || c == 3) {
                        ActivityLoginProfesionalesOld.this.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC), new InputFilter.LengthFilter(14)});
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.backRow.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [es.santander.justicia.minisJusticia.ActivityLoginProfesionalesOld, android.content.Context] */
            public void onClick(View v) {
                ActivityLoginProfesionalesOld.this.startActivity(new Intent(ActivityLoginProfesionalesOld.this, NewsActivity.class));
                ActivityLoginProfesionalesOld.this.finish();
            }
        });
        this.rbParticular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ActivityLoginProfesionalesOld.this.resetFields();
                ActivityLoginProfesionalesOld.this.changeToPrivateMode();
            }
        });
        this.rbCompany.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ActivityLoginProfesionalesOld.this.resetFields();
                ActivityLoginProfesionalesOld.this.changeToCompanyMode();
            }
        });
        this.checkRememberMe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    ActivityLoginProfesionalesOld.this.clearLoginPreferences();
                    boolean unused = ActivityLoginProfesionalesOld.this.rememberMeChecked = false;
                    return;
                }
                boolean unused2 = ActivityLoginProfesionalesOld.this.rememberMeChecked = true;
            }
        });
        this.etDocumentNumber.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                ActivityLoginProfesionalesOld.this.validateEnableSubmitButton();
            }
        });
        this.etCode.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                ActivityLoginProfesionalesOld.this.validateEnableSubmitButton();
            }
        });
        this.etPass.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                ActivityLoginProfesionalesOld.this.validateEnableSubmitButton();
            }
        });
        ((RelativeLayout) findViewById(R.id.parent_layout)).setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                CommonUtils.hideKeyboard(ActivityLoginProfesionalesOld.this.activity);
                return false;
            }
        });
        this.areNotYou.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ActivityLoginProfesionalesOld.this.returnToLoginPage();
            }
        });
        PreferencesHelper.newInstance(this).setBoolean(Constants.EXTRA_SHOW_CONTRACTS, false);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(getBaseContext(), Constants.SHARED_PREFERENCES_LOGIN);
        boolean z = preferencesHelper.getBoolean(Constants.KEY_CHECKBOX_REMEMBER_ME, false);
        this.rememberMeChecked = z;
        if (z) {
            this.tvUserName.setVisibility(0);
            this.tvUserName.setText(preferencesHelper.getString(Constants.USER_NAME));
            this.wasCompanyModeChecked = preferencesHelper.getBoolean(Constants.KEY_COMPANY_MODE, false);
            changeToRememberMeScreenMode();
            if (this.wasCompanyModeChecked) {
                changeToCompanyMode();
            } else {
                changeToPrivateMode();
            }
            reestablishValues();
            return;
        }
        this.tvUserName.setVisibility(8);
        if (this.companyMode) {
            changeToCompanyMode();
        } else {
            changeToPrivateMode();
        }
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [es.santander.justicia.minisJusticia.ActivityLoginProfesionalesOld, android.content.Context, es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack] */
    public void onClick(View v) {
        if (this.btnAcceder.getId() == v.getId()) {
            ProgressDialog progressDialog2 = new ProgressDialog(this);
            this.progressDialog = progressDialog2;
            progressDialog2.setCancelable(false);
            this.progressDialog.setMessage(getString(R.string.progress_conectando));
            this.typeDocu = ((SpinnerValuesDTO) this.spnDocumentTypes.getSelectedItem()).getCode();
            if (this.companyMode && isFormValid()) {
                saveCredentials();
                this.progressDialog.show();
                new LoginProfesionalesTask(this).execute(new Object[]{this.typeDocu, this.etDocumentNumber.getText().toString().toUpperCase(), this.etCode.getText().toString().toUpperCase(), this.etPass.getText().toString().toUpperCase()});
            } else if (!this.companyMode && isFormValid()) {
                saveCredentials();
                int privateType = this.spnPrivateType.getSelectedItemPosition();
                if (privateType == 0) {
                    this.progressDialog.show();
                    new LoginProfesionalesTask(this).execute(new Object[]{this.typeDocu, this.etDocumentNumber.getText().toString().toUpperCase(), null, this.etPass.getText().toString().toUpperCase()});
                } else if (privateType == 1) {
                    this.progressDialog.show();
                    new LoginProfesionalesTask(this).execute(new Object[]{null, this.etDocumentNumber.getText().toString().toUpperCase(), null, this.etPass.getText().toString().toUpperCase()});
                }
            }
        }
    }

    private boolean isFormValid() {
        if (!this.companyMode) {
            if (this.privateDocumentSelected) {
                String documentType = ((SpinnerValuesDTO) this.spnDocumentTypes.getSelectedItem()).getCode();
                char c = 65535;
                int hashCode = documentType.hashCode();
                if (hashCode != 67) {
                    if (hashCode != 78) {
                        if (hashCode != 80) {
                            if (hashCode == 83 && documentType.equals("S")) {
                                c = 0;
                            }
                        } else if (documentType.equals(ActivityDetalleOperacion.CODIGO_ESTADO_P)) {
                            c = 3;
                        }
                    } else if (documentType.equals("N")) {
                        c = 1;
                    }
                } else if (documentType.equals("C")) {
                    c = 2;
                }
                if (c == 0 || c == 1) {
                    if (!validField(this.etDocumentNumber.getText().toString(), true, false, 1, 9)) {
                        this.etDocumentNumber.setError(getString(R.string.error_message_not_min_characters_required));
                        return false;
                    }
                } else if (c == 2 || c == 3) {
                    if (!validField(this.etDocumentNumber.getText().toString(), true, false, 1, 14)) {
                        this.etDocumentNumber.setError(getString(R.string.error_message_not_min_characters_required));
                        return false;
                    }
                }
            } else if (this.etDocumentNumber.getText().toString().trim().isEmpty()) {
                this.etDocumentNumber.setError(getString(R.string.toast_campo_obligatorio));
                return false;
            } else {
                if (!validField(this.etDocumentNumber.getText().toString(), true, false, 1, 20)) {
                    this.etDocumentNumber.setError(getString(R.string.error_message_not_min_characters_required));
                    return false;
                }
            }
            if (this.etPass.getText().toString().trim().isEmpty()) {
                this.etPass.setError(getString(R.string.toast_campo_obligatorio));
                return false;
            }
            if (validField(this.etPass.getText().toString(), false, false, 4, 8)) {
                return true;
            }
            this.etPass.setError(getString(R.string.error_message_not_min_characters_required));
            return false;
        } else if (this.etDocumentNumber.getText().toString().trim().isEmpty()) {
            this.etDocumentNumber.setError(getString(R.string.toast_campo_obligatorio));
            return false;
        } else {
            if (!validField(this.etDocumentNumber.getText().toString(), true, false, 1, 9)) {
                this.etDocumentNumber.setError(getString(R.string.error_message_not_min_characters_required));
                return false;
            } else if (this.etCode.getText().toString().trim().isEmpty()) {
                this.etCode.setError(getString(R.string.toast_campo_obligatorio));
                return false;
            } else {
                if (!validField(this.etCode.getText().toString(), true, false, 6, 13)) {
                    this.etCode.setError(getString(R.string.error_message_not_min_characters_required));
                    return false;
                } else if (this.etPass.getText().toString().trim().isEmpty()) {
                    this.etPass.setError(getString(R.string.toast_campo_obligatorio));
                    return false;
                } else {
                    if (validField(this.etPass.getText().toString(), true, true, 5, 8)) {
                        return true;
                    }
                    this.etPass.setError(getString(R.string.error_message_not_min_characters_required));
                    return false;
                }
            }
        }
    }

    private boolean validField(String text, boolean isAlphanumeric, boolean allCaps, int min, int max) {
        String patternString;
        if (isAlphanumeric && allCaps) {
            patternString = "[A-Z0-9]{" + min + "," + max + "}";
        } else if (!isAlphanumeric || allCaps) {
            patternString = "[\\d]{" + min + "," + max + "}";
        } else {
            patternString = "[a-zA-Z0-9]{" + min + "," + max + "}";
        }
        return Pattern.compile(patternString).matcher(text).matches();
    }

    public int compararFechas(String d1, String d2) {
        String[] dd1 = d1.split("_");
        String[] dd2 = d2.split("_");
        if (Integer.parseInt(dd1[1]) > Integer.parseInt(dd2[1])) {
            return 1;
        }
        if (Integer.parseInt(dd1[1]) < Integer.parseInt(dd2[1])) {
            return -1;
        }
        if (Integer.parseInt(dd1[0]) > Integer.parseInt(dd2[0])) {
            return 1;
        }
        if (Integer.parseInt(dd1[0]) < Integer.parseInt(dd2[0])) {
            return -1;
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: java.lang.String} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0228, code lost:
        if (r6.equals("primavera_noches") != false) goto L_0x022c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setVideo(android.widget.VideoView r30) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            r3 = 2
            int r4 = r2.get(r3)
            r5 = 1
            int r4 = r4 + r5
            r6 = 5
            int r7 = r2.get(r6)
            r8 = 11
            int r9 = r2.get(r8)
            es.santander.justicia.utils.MinJusticeDBHelper.getInstance()
            net.sqlcipher.database.SQLiteDatabase r10 = es.santander.justicia.utils.MinJusticeDBHelper.getReadableDatabase()
            es.santander.justicia.minisJusticia.models.KeyValueModel r11 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()
            java.lang.String r12 = "horarioSaludo."
            java.util.Map r11 = r11.getValueMap(r10, r12)
            es.santander.justicia.minisJusticia.models.KeyValueModel r13 = es.santander.justicia.minisJusticia.models.KeyValueModel.getInstance()
            java.lang.String r14 = "estacionesVideo."
            java.util.Map r13 = r13.getValueMap(r10, r14)
            r10.close()
            java.lang.String r15 = ""
            java.util.Set r16 = r11.entrySet()
            java.util.Iterator r17 = r16.iterator()
        L_0x0042:
            boolean r18 = r17.hasNext()
            java.lang.String r3 = "-"
            java.lang.String r6 = ";"
            r19 = 0
            if (r18 == 0) goto L_0x0094
            java.lang.Object r18 = r17.next()
            java.util.Map$Entry r18 = (java.util.Map.Entry) r18
            java.lang.Object r20 = r18.getValue()
            r8 = r20
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String[] r6 = r8.split(r6)
            int r8 = r6.length
            r5 = r19
        L_0x0063:
            if (r5 >= r8) goto L_0x008c
            r21 = r2
            r2 = r6[r5]
            java.lang.String[] r22 = r2.split(r3)
            r23 = r22[r19]
            r24 = r2
            int r2 = java.lang.Integer.parseInt(r23)
            if (r9 < r2) goto L_0x0087
            r2 = 1
            r23 = r22[r2]
            int r2 = java.lang.Integer.parseInt(r23)
            if (r9 > r2) goto L_0x0087
            java.lang.Object r2 = r18.getKey()
            r15 = r2
            java.lang.String r15 = (java.lang.String) r15
        L_0x0087:
            int r5 = r5 + 1
            r2 = r21
            goto L_0x0063
        L_0x008c:
            r21 = r2
            r3 = 2
            r5 = 1
            r6 = 5
            r8 = 11
            goto L_0x0042
        L_0x0094:
            r21 = r2
            java.lang.String r2 = ""
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r8 = "_"
            java.lang.StringBuilder r5 = r5.append(r8)
            java.lang.StringBuilder r5 = r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.util.Set r16 = r13.entrySet()
            java.util.Iterator r17 = r16.iterator()
        L_0x00b7:
            boolean r18 = r17.hasNext()
            if (r18 == 0) goto L_0x014a
            java.lang.Object r18 = r17.next()
            java.util.Map$Entry r18 = (java.util.Map.Entry) r18
            java.lang.Object r22 = r18.getValue()
            r23 = r4
            r4 = r22
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String[] r4 = r4.split(r6)
            r22 = r6
            int r6 = r4.length
            r24 = r2
            r2 = r19
        L_0x00d8:
            if (r2 >= r6) goto L_0x013b
            r25 = r6
            r6 = r4[r2]
            java.lang.String[] r26 = r6.split(r3)
            r27 = r3
            r3 = r26[r19]
            r28 = r4
            r20 = 1
            r4 = r26[r20]
            int r3 = r0.compararFechas(r3, r4)
            if (r3 < 0) goto L_0x010c
            r3 = r26[r19]
            int r3 = r0.compararFechas(r5, r3)
            if (r3 >= 0) goto L_0x0102
            r3 = r26[r20]
            int r3 = r0.compararFechas(r3, r5)
            if (r3 < 0) goto L_0x010c
        L_0x0102:
            java.lang.Object r3 = r18.getKey()
            java.lang.String r3 = (java.lang.String) r3
            r24 = r3
            r3 = 1
            goto L_0x0132
        L_0x010c:
            r3 = 1
            r4 = r26[r3]
            r3 = r26[r19]
            int r3 = r0.compararFechas(r4, r3)
            if (r3 < 0) goto L_0x0131
            r3 = r26[r19]
            int r3 = r0.compararFechas(r5, r3)
            if (r3 < 0) goto L_0x0131
            r3 = 1
            r4 = r26[r3]
            int r4 = r0.compararFechas(r4, r5)
            if (r4 < 0) goto L_0x0132
            java.lang.Object r4 = r18.getKey()
            java.lang.String r4 = (java.lang.String) r4
            r24 = r4
            goto L_0x0132
        L_0x0131:
            r3 = 1
        L_0x0132:
            int r2 = r2 + 1
            r6 = r25
            r3 = r27
            r4 = r28
            goto L_0x00d8
        L_0x013b:
            r27 = r3
            r28 = r4
            r3 = 1
            r6 = r22
            r4 = r23
            r2 = r24
            r3 = r27
            goto L_0x00b7
        L_0x014a:
            r23 = r4
            r3 = 1
            java.lang.String r4 = ""
            java.lang.String r2 = r2.replace(r14, r4)
            java.lang.String r4 = r15.replace(r12, r4)
            java.lang.String r6 = "dias"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0167
            android.widget.TextView r6 = r0.tv_saludo
            java.lang.String r12 = "Buenos días"
            r6.setText(r12)
            goto L_0x018e
        L_0x0167:
            java.lang.String r6 = "tardes"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0177
            android.widget.TextView r6 = r0.tv_saludo
            java.lang.String r12 = "Buenas tardes"
            r6.setText(r12)
            goto L_0x018e
        L_0x0177:
            java.lang.String r6 = "noches"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0187
            android.widget.TextView r6 = r0.tv_saludo
            java.lang.String r12 = "Buenas noches"
            r6.setText(r12)
            goto L_0x018e
        L_0x0187:
            android.widget.TextView r6 = r0.tv_saludo
            java.lang.String r12 = "Hola"
            r6.setText(r12)
        L_0x018e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r6 = r6.append(r2)
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.StringBuilder r6 = r6.append(r4)
            java.lang.String r6 = r6.toString()
            r8 = -1
            int r12 = r6.hashCode()
            switch(r12) {
                case -1741238790: goto L_0x0222;
                case -1581950157: goto L_0x0218;
                case -1556220725: goto L_0x020e;
                case -1426723411: goto L_0x0203;
                case -1320549923: goto L_0x01f8;
                case -1267434778: goto L_0x01ed;
                case -587612824: goto L_0x01e3;
                case -487547817: goto L_0x01d9;
                case -428324191: goto L_0x01ce;
                case -90131980: goto L_0x01c4;
                case 69156653: goto L_0x01b9;
                case 883126864: goto L_0x01ad;
                default: goto L_0x01ab;
            }
        L_0x01ab:
            goto L_0x022b
        L_0x01ad:
            java.lang.String r3 = "invierno_dias"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01ab
            r3 = 9
            goto L_0x022c
        L_0x01b9:
            java.lang.String r3 = "verano_tardes"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01ab
            r3 = 5
            goto L_0x022c
        L_0x01c4:
            java.lang.String r3 = "verano_noches"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01ab
            r3 = 4
            goto L_0x022c
        L_0x01ce:
            java.lang.String r3 = "otono_tardes"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01ab
            r3 = 8
            goto L_0x022c
        L_0x01d9:
            java.lang.String r3 = "verano_dias"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01ab
            r3 = 3
            goto L_0x022c
        L_0x01e3:
            java.lang.String r3 = "otono_noches"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01ab
            r3 = 7
            goto L_0x022c
        L_0x01ed:
            java.lang.String r3 = "invierno_tardes"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01ab
            r3 = 11
            goto L_0x022c
        L_0x01f8:
            java.lang.String r3 = "primavera_dias"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01ab
            r3 = r19
            goto L_0x022c
        L_0x0203:
            java.lang.String r3 = "invierno_noches"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01ab
            r3 = 10
            goto L_0x022c
        L_0x020e:
            java.lang.String r3 = "otono_dias"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01ab
            r3 = 6
            goto L_0x022c
        L_0x0218:
            java.lang.String r3 = "primavera_tardes"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x01ab
            r3 = 2
            goto L_0x022c
        L_0x0222:
            java.lang.String r12 = "primavera_noches"
            boolean r12 = r6.equals(r12)
            if (r12 == 0) goto L_0x01ab
            goto L_0x022c
        L_0x022b:
            r3 = r8
        L_0x022c:
            r8 = 2131820567(0x7f110017, float:1.9273853E38)
            java.lang.String r12 = "/"
            java.lang.String r14 = "android.resource://"
            switch(r3) {
                case 0: goto L_0x0419;
                case 1: goto L_0x03f1;
                case 2: goto L_0x03cc;
                case 3: goto L_0x03a4;
                case 4: goto L_0x037b;
                case 5: goto L_0x0352;
                case 6: goto L_0x0329;
                case 7: goto L_0x0300;
                case 8: goto L_0x02d7;
                case 9: goto L_0x02ae;
                case 10: goto L_0x0285;
                case 11: goto L_0x025c;
                default: goto L_0x0236;
            }
        L_0x0236:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r14 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.StringBuilder r3 = r3.append(r12)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x025c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r8 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r12)
            r8 = 2131820579(0x7f110023, float:1.9273877E38)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x0285:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r8 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r12)
            r8 = 2131820566(0x7f110016, float:1.927385E38)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x02ae:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r8 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r12)
            r8 = 2131820576(0x7f110020, float:1.927387E38)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x02d7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r8 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r12)
            r8 = 2131820565(0x7f110015, float:1.9273849E38)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x0300:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r8 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r12)
            r8 = 2131820573(0x7f11001d, float:1.9273865E38)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x0329:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r8 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r12)
            r8 = 2131820564(0x7f110014, float:1.9273847E38)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x0352:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r8 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r12)
            r8 = 2131820577(0x7f110021, float:1.9273873E38)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x037b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r8 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r12)
            r8 = 2131820572(0x7f11001c, float:1.9273863E38)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x03a4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r8 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r12)
            r8 = 2131820578(0x7f110022, float:1.9273875E38)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x03cc:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r14 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.StringBuilder r3 = r3.append(r12)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x03f1:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r8 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r12)
            r8 = 2131820571(0x7f11001b, float:1.927386E38)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
            goto L_0x0441
        L_0x0419:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r14)
            java.lang.String r8 = r29.getPackageName()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r12)
            r8 = 2131820575(0x7f11001f, float:1.9273869E38)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.net.Uri r3 = android.net.Uri.parse(r3)
            r1.setVideoURI(r3)
        L_0x0441:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityLoginProfesionalesOld.setVideo(android.widget.VideoView):void");
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [es.santander.justicia.minisJusticia.ActivityLoginProfesionalesOld, android.content.Context] */
    /* access modifiers changed from: private */
    public void changeToCompanyMode() {
        this.documentTypes = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_DOCUMENT_TYPE_FOR_COMPANIES);
        ArrayAdapter<SpinnerValuesDTO> arrayAdapter = new ArrayAdapter<>(this, 17367048, this.documentTypes);
        this.documentTypesAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(17367049);
        this.spnDocumentTypes.setAdapter(this.documentTypesAdapter);
        this.rbParticular.setChecked(false);
        this.rbCompany.setChecked(true);
        this.companyMode = true;
        this.firstSpinnerContainer.setVisibility(8);
        this.secondSpinnerContainer.setVisibility(0);
        if (!this.rememberMeChecked) {
            this.etCode.setVisibility(0);
        }
        this.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC), new InputFilter.LengthFilter(9)});
        this.etCode.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC), new InputFilter.LengthFilter(13)});
        this.etPass.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC), new InputFilter.LengthFilter(8)});
        this.etPass.setInputType(16513);
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [es.santander.justicia.minisJusticia.ActivityLoginProfesionalesOld, android.content.Context] */
    /* access modifiers changed from: private */
    public void changeToPrivateMode() {
        this.documentTypes = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_DOCUMENT_TYPE_FOR_PRIVATES);
        ArrayAdapter<SpinnerValuesDTO> arrayAdapter = new ArrayAdapter<>(this, 17367048, this.documentTypes);
        this.documentTypesAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(17367049);
        this.spnDocumentTypes.setAdapter(this.documentTypesAdapter);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, 17367048, SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_AUTHENTICATION_TYPE_FOR_PRIVATES));
        arrayAdapter2.setDropDownViewResource(17367049);
        this.spnPrivateType.setAdapter(arrayAdapter2);
        this.rbParticular.setChecked(true);
        this.rbCompany.setChecked(false);
        this.companyMode = false;
        this.firstSpinnerContainer.setVisibility(0);
        this.etCode.setVisibility(8);
        this.spnPrivateType.setSelection(0);
        this.etPass.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new RegexInputFilter((String) Constants.REGEX_NUMERIC), new InputFilter.LengthFilter(8)});
        this.etPass.setInputType(18);
    }

    /* access modifiers changed from: private */
    public void resetFields() {
        this.etDocumentNumber.setText("");
        this.etCode.setText("");
        this.etPass.setText("");
        this.etDocumentNumber.setHint(R.string.label_numero_documento);
        reestablishValues();
    }

    private void saveCredentials() {
        PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(getBaseContext(), Constants.SHARED_PREFERENCES_LOGIN);
        if (this.checkRememberMe.isChecked()) {
            preferencesHelper.setBoolean(Constants.KEY_COMPANY_MODE, this.companyMode);
            preferencesHelper.setString(Constants.KEY_DOCUMENT_TYPE, ((SpinnerValuesDTO) this.spnDocumentTypes.getSelectedItem()).getCode());
            preferencesHelper.setString(Constants.KEY_DOCUMENT_NUMBER, this.etDocumentNumber.getText().toString());
            if (this.companyMode) {
                preferencesHelper.setString("code", this.etCode.getText().toString());
                preferencesHelper.setString(Constants.KEY_AUTHENTICATION_TYPE_CODE, "");
            } else {
                preferencesHelper.setString(Constants.KEY_AUTHENTICATION_TYPE_CODE, ((SpinnerValuesDTO) this.spnPrivateType.getSelectedItem()).getCode());
                preferencesHelper.setString("code", "");
            }
            preferencesHelper.setBoolean(Constants.KEY_CHECKBOX_REMEMBER_ME, true);
            return;
        }
        clearLoginPreferences();
    }

    /* access modifiers changed from: private */
    public void clearLoginPreferences() {
        PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(getBaseContext(), Constants.SHARED_PREFERENCES_LOGIN);
        preferencesHelper.setString(Constants.KEY_DOCUMENT_TYPE, "");
        preferencesHelper.setString(Constants.KEY_DOCUMENT_NUMBER, "");
        preferencesHelper.setString("code", "");
        preferencesHelper.setString(Constants.KEY_AUTHENTICATION_TYPE_CODE, "");
        preferencesHelper.setBoolean(Constants.KEY_COMPANY_MODE, false);
        preferencesHelper.setBoolean(Constants.KEY_CHECKBOX_REMEMBER_ME, false);
        preferencesHelper.setString(Constants.USER_NAME, "");
    }

    private void reestablishValues() {
        if (this.rememberMeChecked) {
            this.checkRememberMe.setChecked(true);
            PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(getBaseContext(), Constants.SHARED_PREFERENCES_LOGIN);
            int documentTypePosition = getLastSpinnerPosition(this.spnDocumentTypes, preferencesHelper.getString(Constants.KEY_DOCUMENT_TYPE));
            boolean z = preferencesHelper.getBoolean(Constants.KEY_COMPANY_MODE, true);
            this.wasCompanyModeChecked = z;
            if (z && this.companyMode) {
                this.spnDocumentTypes.setSelection(documentTypePosition);
                this.etDocumentNumber.setText(preferencesHelper.getString(Constants.KEY_DOCUMENT_NUMBER));
                this.etCode.setText(preferencesHelper.getString("code"));
            } else if (!z && !this.companyMode) {
                this.spnPrivateType.setSelection(getLastSpinnerPosition(this.spnPrivateType, preferencesHelper.getString(Constants.KEY_AUTHENTICATION_TYPE_CODE)));
                this.etDocumentNumber.setText(preferencesHelper.getString(Constants.KEY_DOCUMENT_NUMBER));
                Spinner spinner = this.spnDocumentTypes;
                if (spinner == null || !spinner.isShown()) {
                    Spinner spinner2 = this.spnDocumentTypes;
                    if (spinner2 != null && !spinner2.isShown()) {
                        this.secondSpinnerContainer.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.spnDocumentTypes.setSelection(documentTypePosition);
            }
        }
    }

    private int getLastSpinnerPosition(Spinner spn, String spnValueCode) {
        ArrayAdapter<SpinnerValuesDTO> arrayAdapter = (ArrayAdapter) spn.getAdapter();
        if (arrayAdapter == null) {
            return 0;
        }
        int arrayAdapterLength = arrayAdapter.getCount();
        for (int i = 0; i < arrayAdapterLength; i++) {
            if (arrayAdapter.getItem(i).getCode().equals(spnValueCode)) {
                return i;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void validateEnableSubmitButton() {
        if (this.companyMode && !this.etDocumentNumber.getText().toString().trim().isEmpty() && !this.etCode.getText().toString().trim().isEmpty() && !this.etPass.getText().toString().trim().isEmpty() && this.etPass.getText().length() >= 5) {
            this.btnAcceder.setEnabled(true);
        } else if (this.etDocumentNumber.getText().toString().trim().isEmpty() || this.etPass.getText().toString().trim().isEmpty() || this.etPass.getText().length() < 4) {
            this.btnAcceder.setEnabled(false);
        } else {
            this.btnAcceder.setEnabled(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog2 = this.progressDialog;
        if (progressDialog2 != null) {
            progressDialog2.dismiss();
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [es.santander.justicia.minisJusticia.ActivityLoginProfesionalesOld, android.content.Context, es.santander.justicia.minisJusticia.common.tasks.ActivityCallBack] */
    public void onTaskFinished(String taskID, Object result) {
        String error_message;
        if ("LOGIN_PROFESIONALES".equals(taskID)) {
            if (result != null || LoginManager.getInstance().getUser() == null) {
                this.progressDialog.dismiss();
                String error = (String) result;
                if (error == null) {
                    error = "error";
                }
                if (error.startsWith("ERROR_PROFESIONAL_EMPRESA")) {
                    error_message = error.replaceAll("ERROR_PROFESIONAL_EMPRESA", "");
                } else {
                    String error_message2 = getStringResourceByName("error_" + error.replaceAll("\\s+", "_") + "_message");
                    if (error_message2 == null) {
                        error_message = getString(R.string.error_LOGIN_DEFAULT_message);
                    } else {
                        error_message = error_message2;
                    }
                }
                Toast.makeText(getApplicationContext(), error_message, 1).show();
                return;
            }
            PreferencesHelper.newInstance(getBaseContext(), Constants.SHARED_PREFERENCES_LOGIN).setString(Constants.USER_NAME, LoginManager.getInstance().getNombreUsuario());
            new LoginExpedientesTask(this).execute(new Object[0]);
        } else if (LoginExpedientesTask.TASK_ID.equals(taskID)) {
            ProgressDialog progressDialog2 = this.progressDialog;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
            ArrayList<ExpedienteDTO> misExpedientes = (ArrayList) result;
            if (misExpedientes == null) {
                Toast.makeText(this.activity.getApplicationContext(), getString(R.string.error_LOGIN_DEFAULT_message), 1).show();
            } else if (misExpedientes.size() == 0) {
                startActivity(new Intent(this, SolicitudAccesoActivity.class));
                finish();
            } else {
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("expedientes", misExpedientes);
                startActivity(intent);
                finish();
            }
        }
    }

    private void changeToRememberMeScreenMode() {
        this.radioButtonsContainer.setVisibility(8);
        this.spinnerContainer.setVisibility(8);
        this.etDocumentNumber.setVisibility(8);
        this.etCode.setVisibility(8);
        this.rememberMeContainer.setVisibility(8);
        this.tvUserName.setVisibility(0);
        this.linealAreNotYouLink.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void returnToLoginPage() {
        this.tvUserName.setVisibility(8);
        this.linealAreNotYouLink.setVisibility(8);
        this.radioButtonsContainer.setVisibility(0);
        this.spinnerContainer.setVisibility(0);
        this.etDocumentNumber.setVisibility(0);
        this.etCode.setVisibility(0);
        this.rememberMeContainer.setVisibility(0);
        this.checkRememberMe.setChecked(true);
        clearLoginPreferences();
        this.rememberMeChecked = false;
        resetFields();
    }
}
