package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.filters.RegexInputFilter;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.models.responses.login.LoginResponseEnvelope;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.InitConfigConstants;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Response;

public class ActivityLoginLetrados extends ActivityAbstractLetrados {
    private ArrayList<SpinnerValuesDTO> documentTypes;
    private ArrayAdapter<SpinnerValuesDTO> documentTypesAdapter;
    /* access modifiers changed from: private */
    public EditText etCode;
    /* access modifiers changed from: private */
    public EditText etDocumentNumber;
    /* access modifiers changed from: private */
    public EditText etPass;
    private LinearLayout liAreNotYou;
    private CheckBox mCheckRemember;
    /* access modifiers changed from: private */
    public PreferencesHelper mPreferencesHelper;
    private LinearLayout rememberMeContainer;
    protected Spinner spnDocumentTypes;
    private TextView textInputPass;
    private TextView tvName;
    private TextView tvSaludo;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_letrados);
        initUi();
    }

    public void onStart() {
        super.onStart();
        Map<String, String> data = new HashMap<>();
        data.put(TealiumHelper.TEALIUM_PERFIL_APP, UserDTO.APP_LETRADOS);
        TealiumHelper.trackView("/login", data);
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityLoginLetrados] */
    private void initUi() {
        this.etCode = (EditText) findViewById(R.id.et_code);
        this.etDocumentNumber = (EditText) findViewById(R.id.et_documment);
        this.etPass = (EditText) findViewById(R.id.et_pass);
        this.liAreNotYou = (LinearLayout) findViewById(R.id.linear_no_you);
        this.textInputPass = (TextView) findViewById(R.id.text_pass);
        this.mCheckRemember = (CheckBox) findViewById(R.id.cb_remember_me);
        this.spnDocumentTypes = (Spinner) findViewById(R.id.spn_document_type_particulares);
        this.tvSaludo = (TextView) findViewById(R.id.tv_greeting);
        this.tvName = (TextView) findViewById(R.id.tv_name);
        this.rememberMeContainer = (LinearLayout) findViewById(R.id.cl_remember_me_container_letrados);
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
        this.mPreferencesHelper = PreferencesHelper.newInstance(this);
        this.documentTypes = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_DOCUMENT_TYPE_FOR_LETRADOS);
        ArrayAdapter<SpinnerValuesDTO> arrayAdapter = new ArrayAdapter<>(this, R.layout.simple_spinner_item, R.id.text_spinner, this.documentTypes);
        this.documentTypesAdapter = arrayAdapter;
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.spnDocumentTypes.setAdapter(this.documentTypesAdapter);
        this.mCheckRemember.setChecked(true);
        this.mCheckRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    ActivityLoginLetrados.this.mPreferencesHelper.clear();
                }
            }
        });
        final Button buttonEntrar = (Button) findViewById(R.id.bt_logProf_acceder);
        TextWatcher textWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                if (ActivityLoginLetrados.this.etCode.getText().toString().isEmpty() || ActivityLoginLetrados.this.etDocumentNumber.getText().toString().isEmpty() || ActivityLoginLetrados.this.etPass.getText().toString().isEmpty()) {
                    buttonEntrar.setEnabled(false);
                } else {
                    buttonEntrar.setEnabled(true);
                }
            }
        };
        this.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC), new InputFilter.LengthFilter(9)});
        this.etCode.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC), new InputFilter.LengthFilter(8)});
        this.etDocumentNumber.addTextChangedListener(textWatcher);
        this.etCode.addTextChangedListener(textWatcher);
        this.etPass.addTextChangedListener(textWatcher);
        this.spnDocumentTypes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    ActivityLoginLetrados.this.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC), new InputFilter.LengthFilter(14)});
                } else if (position == 1 || position == 2 || position == 3) {
                    ActivityLoginLetrados.this.etDocumentNumber.setFilters(new InputFilter[]{new RegexInputFilter((String) Constants.REGEX_ALPHANUMERIC), new InputFilter.LengthFilter(9)});
                }
                ActivityLoginLetrados.this.etDocumentNumber.setText("");
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        initFields(this.mPreferencesHelper.getBoolean(Constants.PREFERECENCE_REMEMBER_DATA, false));
        findViewById(R.id.relative_global).setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [es.santander.justicia.minisJusticia.ActivityLoginLetrados, android.app.Activity] */
            public void onClick(View view) {
                CommonUtils.hideKeyboard(ActivityLoginLetrados.this);
            }
        });
    }

    private void initFields(boolean remembering) {
        if (remembering) {
            this.etDocumentNumber.setText(this.mPreferencesHelper.getString(Constants.PREFERECENCE_LOGIN_DOCUMENT));
            this.etCode.setText(this.mPreferencesHelper.getString(Constants.PREFERECENCE_LOGIN_USER));
            this.etPass.setText(this.mPreferencesHelper.getString(Constants.PREFERECENCE_LOGIN_PASS));
            this.etDocumentNumber.setVisibility(8);
            this.etCode.setVisibility(8);
            this.spnDocumentTypes.setVisibility(8);
            this.rememberMeContainer.setVisibility(8);
            this.liAreNotYou.setVisibility(0);
            this.textInputPass.setVisibility(0);
            findViewById(R.id.relative_document_type).setVisibility(8);
            this.tvName.setVisibility(0);
            this.spnDocumentTypes.setSelection(findPositionType(this.mPreferencesHelper.getString(Constants.PREFERECENCE_LOGIN_TYPE_DOCUMENT)));
            this.tvName.setText(getFormattedName(this.mPreferencesHelper.getString(Constants.PREFERECENCE_LOGIN_USER_NAME)));
            return;
        }
        this.etDocumentNumber.setText("");
        this.etCode.setText("");
        this.etPass.setText("");
        this.spnDocumentTypes.setVisibility(0);
        this.spnDocumentTypes.setSelection(0);
        findViewById(R.id.relative_document_type).setVisibility(0);
        this.etDocumentNumber.setVisibility(0);
        this.etCode.setVisibility(0);
        this.rememberMeContainer.setVisibility(0);
        this.liAreNotYou.setVisibility(8);
        this.textInputPass.setVisibility(8);
        this.tvName.setVisibility(8);
    }

    private String getFormattedName(String name) {
        String[] splitName = name.split(" ");
        StringBuilder nameFormatted = new StringBuilder();
        for (int i = 0; i < splitName.length; i++) {
            nameFormatted.append(capitalizeFirstLetter(splitName[i]));
            if (i != splitName.length - 1) {
                nameFormatted.append(" ");
            }
        }
        return nameFormatted.toString();
    }

    private String capitalizeFirstLetter(String name) {
        if (name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1).toLowerCase(Locale.ROOT);
    }

    private int findPositionType(String code) {
        for (int i = 0; i < this.documentTypes.size(); i++) {
            if (this.documentTypes.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public void saveCredentials() {
        if (this.mCheckRemember.isChecked()) {
            this.mPreferencesHelper.setString(Constants.PREFERECENCE_LOGIN_DOCUMENT, this.etDocumentNumber.getText().toString());
            this.mPreferencesHelper.setString(Constants.PREFERECENCE_LOGIN_USER, this.etCode.getText().toString());
            this.mPreferencesHelper.setString(Constants.PREFERECENCE_LOGIN_TYPE_DOCUMENT, ((SpinnerValuesDTO) this.spnDocumentTypes.getSelectedItem()).getCode());
            this.mPreferencesHelper.setBoolean(Constants.PREFERECENCE_REMEMBER_DATA, true);
            return;
        }
        this.mPreferencesHelper.clear();
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityLoginLetrados] */
    public void onEntryClick(View v) {
        ConnectionBuilder.getLoginCall(this.etDocumentNumber.getText().toString().toUpperCase(Locale.US), this.etCode.getText().toString().toUpperCase(Locale.US), this.etPass.getText().toString(), this.spnDocumentTypes.getSelectedItem() != null ? ((SpinnerValuesDTO) this.spnDocumentTypes.getSelectedItem()).getCode() : this.mPreferencesHelper.getString(Constants.PREFERECENCE_LOGIN_TYPE_DOCUMENT)).enqueue(new RetrofitCallbackInterface<LoginResponseEnvelope>(this, true, false) {
            /* JADX WARNING: type inference failed for: r1v2, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityLoginLetrados] */
            public void onResponse(Call<LoginResponseEnvelope> call, Response<LoginResponseEnvelope> response) {
                ActivityLoginLetrados.this.saveCredentials();
                try {
                    ? r1 = ActivityLoginLetrados.this;
                    String str = null;
                    String tokenSSO = (response.body() == null || ((LoginResponseEnvelope) response.body()).getLoginResponseBody().getLoginResponseReturn() == null) ? null : ((LoginResponseEnvelope) response.body()).getLoginResponseBody().getLoginResponseReturn().getLogin().getTokenSSO();
                    if (response.code() == 500) {
                        str = response.errorBody().string();
                    }
                    if (super.finishConnection(r1, tokenSSO, str)) {
                        ActivityLoginLetrados.this.getDataUser(true);
                    } else {
                        ActivityLoginLetrados.this.getDataUser(false);
                    }
                } catch (IOException e) {
                    Log.e("ActivityLoginLetrados", "IOException", e);
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getDataUser(boolean r9) {
        /*
            r8 = this;
            retrofit2.Call r0 = es.santander.justicia.minisJusticia.connections.ConnectionBuilder.getDetalleUsuarioCall()
            es.santander.justicia.minisJusticia.ActivityLoginLetrados$9 r7 = new es.santander.justicia.minisJusticia.ActivityLoginLetrados$9
            r1 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            r1 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            r1 = r7
            r2 = r8
            r3 = r8
            r6 = r9
            r1.<init>(r3, r4, r5, r6)
            r0.enqueue(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityLoginLetrados.getDataUser(boolean):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityLoginLetrados] */
    public void onNoEntryClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("flag_ayuda", true);
        Intent intent = new Intent(this, ActivityHelpLetrados.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onNoYouClick(View v) {
        this.mPreferencesHelper.clear();
        initFields(false);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityLoginLetrados] */
    public void onBackPressed() {
        startActivity(new Intent(this, NewsActivity.class));
        finish();
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
            android.widget.TextView r6 = r0.tvSaludo
            java.lang.String r12 = "Buenos días"
            r6.setText(r12)
            goto L_0x018e
        L_0x0167:
            java.lang.String r6 = "tardes"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0177
            android.widget.TextView r6 = r0.tvSaludo
            java.lang.String r12 = "Buenas tardes"
            r6.setText(r12)
            goto L_0x018e
        L_0x0177:
            java.lang.String r6 = "noches"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0187
            android.widget.TextView r6 = r0.tvSaludo
            java.lang.String r12 = "Buenas noches"
            r6.setText(r12)
            goto L_0x018e
        L_0x0187:
            android.widget.TextView r6 = r0.tvSaludo
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
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.ActivityLoginLetrados.setVideo(android.widget.VideoView):void");
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
}
