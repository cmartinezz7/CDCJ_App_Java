package es.santander.justicia.minisJusticia;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.views.QEditText;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.DateUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.Calendar;
import java.util.regex.Pattern;

public abstract class ActivityAbstractBusqueda extends ActivityAbstractLetrados {
    protected static String mDateDesde;
    protected static String mDateHasta;
    protected static QTextView mTextDateFrom;
    protected static QTextView mTextDateTo;
    /* access modifiers changed from: private */
    public static int mViewIdSelected;
    private View.OnClickListener mDateListener;
    protected QEditText mEditJanoapex;
    protected QEditText mEditJnumexp;
    protected QEditText mEditJproced;
    protected QEditText mEditJuzori;
    protected LinearLayout mLinearLayoutGlobal;
    protected QTextView mTextJuzga;
    private TextWatcher mTextWhatcher;

    /* access modifiers changed from: protected */
    public abstract void buscarClick();

    /* access modifiers changed from: protected */
    public abstract void defineSpinners();

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityAbstractBusqueda] */
    /* access modifiers changed from: protected */
    public void initUi() {
        mDateDesde = null;
        mDateHasta = null;
        defineListeners();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_global);
        this.mLinearLayoutGlobal = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [es.santander.justicia.minisJusticia.ActivityAbstractBusqueda, android.app.Activity] */
            public void onClick(View v) {
                CommonUtils.hideKeyboard(ActivityAbstractBusqueda.this);
            }
        });
        findViewById(R.id.linear_buscador).setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r0v0, types: [es.santander.justicia.minisJusticia.ActivityAbstractBusqueda, android.app.Activity] */
            public void onClick(View v) {
                CommonUtils.hideKeyboard(ActivityAbstractBusqueda.this);
            }
        });
        this.mTextJuzga = (QTextView) findViewById(R.id.text_exp1);
        this.mEditJuzori = (QEditText) findViewById(R.id.et_exp2);
        this.mEditJproced = (QEditText) findViewById(R.id.et_exp3);
        this.mEditJnumexp = (QEditText) findViewById(R.id.et_exp4);
        this.mEditJanoapex = (QEditText) findViewById(R.id.et_exp5);
        InputFilter filter = new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) {
                for (int j = i; j < i1; j++) {
                    if (!Character.isLetterOrDigit(charSequence.charAt(j))) {
                        return "";
                    }
                }
                return null;
            }
        };
        QEditText qEditText = this.mEditJuzori;
        if (qEditText != null) {
            qEditText.setFilters(new InputFilter[]{filter});
            this.mEditJuzori.addTextChangedListener(this.mTextWhatcher);
        }
        QEditText qEditText2 = this.mEditJproced;
        if (qEditText2 != null) {
            qEditText2.setFilters(new InputFilter[]{filter});
            this.mEditJproced.addTextChangedListener(this.mTextWhatcher);
        }
        QEditText qEditText3 = this.mEditJnumexp;
        if (qEditText3 != null) {
            qEditText3.setFilters(new InputFilter[]{filter});
            this.mEditJnumexp.addTextChangedListener(this.mTextWhatcher);
        }
        QEditText qEditText4 = this.mEditJanoapex;
        if (qEditText4 != null) {
            qEditText4.setFilters(new InputFilter[]{filter});
            this.mEditJanoapex.addTextChangedListener(this.mTextWhatcher);
        }
        mTextDateFrom = (QTextView) findViewById(R.id.text_date_from);
        mTextDateTo = (QTextView) findViewById(R.id.text_date_to);
        mTextDateFrom.setOnClickListener(this.mDateListener);
        mTextDateTo.setOnClickListener(this.mDateListener);
        findViewById(R.id.text_btn_peticiones).setOnClickListener(new View.OnClickListener() {
            /* JADX WARNING: type inference failed for: r0v4, types: [es.santander.justicia.minisJusticia.ActivityAbstractBusqueda, android.app.Activity] */
            public void onClick(View view) {
                if (DateUtils.dateToHigherThanFrom(ActivityAbstractBusqueda.mTextDateFrom.getText().toString(), ActivityAbstractBusqueda.mTextDateTo.getText().toString())) {
                    ActivityAbstractBusqueda.this.buscarClick();
                    return;
                }
                ? r0 = ActivityAbstractBusqueda.this;
                CommonUtils.showAlertMessage(r0, r0.getString(R.string.invalid_dates));
            }
        });
        defineSpinners();
        QTextView qTextView = this.mTextJuzga;
        if (qTextView != null) {
            qTextView.setText(PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO));
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [es.santander.justicia.minisJusticia.ActivityAbstractBusqueda, android.app.Activity] */
    /* access modifiers changed from: private */
    public void nextFocus(int currentId) {
        switch (currentId) {
            case R.id.et_exp2:
                this.mEditJproced.requestFocus();
                return;
            case R.id.et_exp3:
                this.mEditJnumexp.requestFocus();
                return;
            case R.id.et_exp4:
                this.mEditJanoapex.requestFocus();
                return;
            case R.id.et_exp5:
                CommonUtils.hideKeyboard(this);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityAbstractBusqueda] */
    public boolean checkFields() {
        if (checkTextCorrect(this.mEditJanoapex) && checkTextCorrect(this.mEditJnumexp) && checkTextCorrect(this.mEditJproced) && checkTextCorrect(this.mEditJuzori)) {
            return false;
        }
        Toast.makeText(this, getString(R.string.toast_incorrect_chars), 1).show();
        return true;
    }

    public static boolean checkTextCorrect(QEditText text) {
        if (text == null || text.getText().toString().isEmpty()) {
            return true;
        }
        return Pattern.compile("[ª!\"·$%&/()=?¿*^Ç¨_:;><]").matcher(text.toString()).find();
    }

    private void defineListeners() {
        this.mDateListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (view.isClickable()) {
                    int unused = ActivityAbstractBusqueda.mViewIdSelected = view.getId();
                    ActivityAbstractBusqueda.this.showTimePickerDialog();
                }
            }
        };
        this.mTextWhatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            public void afterTextChanged(Editable editable) {
                int chars = editable.length();
                if (chars > 1 && ActivityAbstractBusqueda.this.findViewById(16908290).getRootView() != null) {
                    int id = ActivityAbstractBusqueda.this.findViewById(16908290).getRootView().getId();
                    if (id != 2131362887) {
                        switch (id) {
                            case R.id.et_exp2:
                            case R.id.et_exp4:
                                break;
                            case R.id.et_exp3:
                            case R.id.et_exp5:
                                if (chars == 2) {
                                    ActivityAbstractBusqueda activityAbstractBusqueda = ActivityAbstractBusqueda.this;
                                    activityAbstractBusqueda.nextFocus(activityAbstractBusqueda.findViewById(16908290).getRootView().getId());
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    if (chars == 4) {
                        ActivityAbstractBusqueda activityAbstractBusqueda2 = ActivityAbstractBusqueda.this;
                        activityAbstractBusqueda2.nextFocus(activityAbstractBusqueda2.findViewById(16908290).getRootView().getId());
                    }
                }
            }
        };
    }

    public void showTimePickerDialog() {
        new DatePickerFragment().show(getSupportFragmentManager(), "timePicker");
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar c;
            int access$000 = ActivityAbstractBusqueda.mViewIdSelected;
            if (access$000 != 2131362880) {
                if (access$000 != 2131362882) {
                    c = Calendar.getInstance();
                } else if (ActivityAbstractBusqueda.mTextDateTo == null || ActivityAbstractBusqueda.mTextDateTo.getText().toString().isEmpty()) {
                    c = Calendar.getInstance();
                } else {
                    c = DateUtils.calendarFromString(ActivityAbstractBusqueda.mTextDateTo.getText().toString());
                }
            } else if (ActivityAbstractBusqueda.mTextDateFrom == null || ActivityAbstractBusqueda.mTextDateFrom.getText().toString().isEmpty()) {
                c = Calendar.getInstance();
            } else {
                c = DateUtils.calendarFromString(ActivityAbstractBusqueda.mTextDateFrom.getText().toString());
            }
            return new DatePickerDialog(getActivity(), this, c.get(1), c.get(2), c.get(5));
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            int month2 = month + 1;
            String stringDay = day < 10 ? "0" + day : String.valueOf(day);
            String stringMonth = month2 < 10 ? "0" + month2 : String.valueOf(month2);
            int access$000 = ActivityAbstractBusqueda.mViewIdSelected;
            if (access$000 == 2131362880) {
                ActivityAbstractBusqueda.mTextDateFrom.setText(day + "/" + month2 + "/" + year);
                ActivityAbstractBusqueda.mDateDesde = year + "-" + stringMonth + "-" + stringDay;
            } else if (access$000 == 2131362882) {
                ActivityAbstractBusqueda.mTextDateTo.setText(day + "/" + month2 + "/" + year);
                ActivityAbstractBusqueda.mDateHasta = year + "-" + stringMonth + "-" + stringDay;
            }
        }
    }
}
