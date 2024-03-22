package es.santander.justicia.minisJusticia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;

public class ActivityHelpLetrados extends ActivityAbstractLetrados {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_letrados);
        findViewById(R.id.contraint).setVisibility(0);
        initUi();
    }

    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/ayuda");
    }

    private void initUi() {
        String value = KeyValueModel.getInstance().getValue(KeyValueModel.AYUDA_INFO, "letrados.superlinea1");
        if (CommonUtils.isNotNullNotBlack(value)) {
            ((QTextView) findViewById(R.id.QTextView2)).setText(value);
        }
        String value2 = KeyValueModel.getInstance().getValue(KeyValueModel.AYUDA_INFO, "letrados.superlinea2");
        if (CommonUtils.isNotNullNotBlack(value)) {
            ((QTextView) findViewById(R.id.QTextView3)).setText(value2);
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, es.santander.justicia.minisJusticia.ActivityHelpLetrados] */
    public void onChangeProfileClick(View v) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getString(2131886514));
        progressDialog.show();
        TealiumHelper.trackEvent("/ayuda", "ayuda (borrar datos)");
        PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(getBaseContext(), Constants.SHARED_PREFERENCES_LOGIN);
        preferencesHelper.setString(Constants.KEY_DOCUMENT_TYPE, "");
        preferencesHelper.setString(Constants.KEY_DOCUMENT_NUMBER, "");
        preferencesHelper.setString("code", "");
        preferencesHelper.setString(Constants.KEY_AUTHENTICATION_TYPE_CODE, "");
        preferencesHelper.setBoolean(Constants.KEY_COMPANY_MODE, false);
        preferencesHelper.setBoolean(Constants.KEY_CHECKBOX_REMEMBER_ME, false);
        PreferencesHelper.newInstance(this).clear();
        KeyValueModel.getInstancePermanent().insertValue(KeyValueModel.PROFESIONAL_LETRADO_SELECCION, "", "");
        Intent intent = new Intent(this, BienvenidaViewPagerActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }
}
