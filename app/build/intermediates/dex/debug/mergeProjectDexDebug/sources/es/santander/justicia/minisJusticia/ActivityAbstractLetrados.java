package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.connections.ConnectionBuilder;
import es.santander.justicia.minisJusticia.connections.RetrofitCallbackInterface;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import retrofit2.Call;
import retrofit2.Response;

public abstract class ActivityAbstractLetrados extends AppCompatActivity {
    protected QTextView mTextOrganism;
    protected QTextView mTextUser;

    public void onBackClick(View v) {
        onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        ActivityAbstractLetrados.super.onCreate(savedInstanceState);
        if (!MainApplication.getAppContext().getIntegrity().booleanValue()) {
            System.exit(0);
        }
        if (Build.VERSION.SDK_INT >= 11) {
            getWindow().setFlags(8192, 8192);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ActivityAbstractLetrados.super.onResume();
        View edit = findViewById(R.id.img_edit);
        if (edit != null) {
            if (this instanceof ActivityHomeLetrados) {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag(getString(R.string.menu_advice));
                if (fragment == null || !fragment.isVisible()) {
                    edit.setVisibility(4);
                } else {
                    edit.setVisibility(0);
                }
            } else {
                edit.setVisibility(4);
            }
        }
        updateHeader();
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [es.santander.justicia.minisJusticia.ActivityAbstractLetrados, android.content.Context] */
    /* access modifiers changed from: protected */
    public void updateHeader() {
        if (this.mTextUser == null) {
            this.mTextUser = (QTextView) findViewById(R.id.text_user);
        }
        if (this.mTextOrganism == null) {
            this.mTextOrganism = (QTextView) findViewById(R.id.text_organism);
        }
        QTextView qTextView = this.mTextUser;
        if (qTextView != null) {
            qTextView.setText(String.format(getString(R.string.user_header), new Object[]{PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_USER)}));
        }
        QTextView qTextView2 = this.mTextOrganism;
        if (qTextView2 != null) {
            qTextView2.setText(String.format(getString(R.string.organism_header), new Object[]{PreferencesHelper.newInstance(this).getString(Constants.PREFERECENCE_COD_UO)}));
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [es.santander.justicia.minisJusticia.ActivityAbstractLetrados, android.content.Context] */
    /* access modifiers changed from: protected */
    public Context getContext() {
        return this;
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (!onFilterTouchEventForSecurity(ev)) {
            ((ViewGroup) ((ViewGroup) findViewById(16908290)).getChildAt(0)).setFilterTouchesWhenObscured(true);
        }
        return ActivityAbstractLetrados.super.dispatchTouchEvent(ev);
    }

    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        if ((event.getFlags() & 1) == 1 || (event.getFlags() & 2) == 2) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [es.santander.justicia.minisJusticia.ActivityAbstractLetrados, android.content.Context] */
    public void logout() {
        ConnectionBuilder.logout().enqueue(new RetrofitCallbackInterface<Void>(this) {
            public void onFailure(Call<Void> call, Throwable t) {
                super.onFailure(call, t);
                Log.d("Logout", t.getMessage());
                LoginManager.getInstance().logout();
                ActivityAbstractLetrados.this.forwardLogout();
            }

            public void onResponse(Call<Void> call, Response<Void> response) {
                super.onResponse(call, response);
                Log.d("Logout", "success");
                TealiumHelper.trackEvent("/menu/logout", "logout");
                LoginManager.getInstance().logout();
                ActivityAbstractLetrados.this.forwardLogout();
            }
        });
    }

    /* JADX WARNING: type inference failed for: r11v0, types: [es.santander.justicia.minisJusticia.ActivityAbstractLetrados, android.content.Context] */
    public void forwardLogout() {
        PreferencesHelper preferencesHelper = PreferencesHelper.newInstance(this);
        if (preferencesHelper.getBoolean(Constants.PREFERECENCE_REMEMBER_DATA, false)) {
            String code = preferencesHelper.getString(Constants.PREFERECENCE_LOGIN_USER);
            String document = preferencesHelper.getString(Constants.PREFERECENCE_LOGIN_DOCUMENT);
            String name = preferencesHelper.getString(Constants.PREFERECENCE_LOGIN_USER_NAME);
            String type = preferencesHelper.getString(Constants.PREFERECENCE_LOGIN_TYPE_DOCUMENT);
            preferencesHelper.clear();
            preferencesHelper.setBoolean(Constants.PREFERECENCE_REMEMBER_DATA, true);
            preferencesHelper.setString(Constants.PREFERECENCE_LOGIN_DOCUMENT, document);
            preferencesHelper.setString(Constants.PREFERECENCE_LOGIN_USER, code);
            preferencesHelper.setString(Constants.PREFERECENCE_LOGIN_USER_NAME, name);
            preferencesHelper.setString(Constants.PREFERECENCE_LOGIN_TYPE_DOCUMENT, type);
        } else {
            preferencesHelper.clear();
        }
        Intent intent = new Intent(this, NewsActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }
}
