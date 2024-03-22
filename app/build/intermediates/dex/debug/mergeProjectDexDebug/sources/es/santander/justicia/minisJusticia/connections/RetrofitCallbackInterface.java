package es.santander.justicia.minisJusticia.connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.R;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.io.StringReader;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCallbackInterface<T> implements Callback<T> {
    private Context mContext;
    private Boolean mDismissInicator = true;
    private ProgressDialog mProgressDialog;
    private Boolean mShowIndicator = true;

    public RetrofitCallbackInterface(Context context, Boolean show, Boolean dismiss) {
        this.mContext = context;
        this.mShowIndicator = show;
        this.mDismissInicator = dismiss;
        if (show.booleanValue()) {
            ProgressDialog progressDialog = new ProgressDialog(context);
            this.mProgressDialog = progressDialog;
            progressDialog.setMessage(context.getString(2131886514));
            this.mProgressDialog.setCancelable(false);
            this.mProgressDialog.show();
        }
    }

    public RetrofitCallbackInterface(Context context) {
        this.mContext = context;
        this.mShowIndicator = true;
        this.mDismissInicator = true;
        if (this.mShowIndicator.booleanValue()) {
            ProgressDialog progressDialog = new ProgressDialog(context);
            this.mProgressDialog = progressDialog;
            progressDialog.setMessage(context.getString(2131886514));
            this.mProgressDialog.setCancelable(false);
            this.mProgressDialog.show();
        }
    }

    public void onResponse(Call<T> call, Response<T> response) {
        finishConnection();
    }

    public void onFailure(Call<T> call, Throwable t) {
        Log.d("Silos", "connction fail " + t.getMessage());
        finishConnection(t.getMessage());
    }

    /* access modifiers changed from: protected */
    public boolean finishConnection(Context context, String token, String responsError) {
        if (token != null && !token.isEmpty()) {
            RetrofitUtility.updateToken = token;
            PreferencesHelper.newInstance(context).setString(Constants.PREFERECENCE_TOKEN_SSO, token);
        }
        if (responsError != null && !responsError.isEmpty()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                if (this.mDismissInicator.booleanValue()) {
                    dismissDialog();
                }
                try {
                    String text = factory.newDocumentBuilder().parse(new InputSource(new StringReader(responsError))).getDocumentElement().getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(1).getTextContent();
                    Log.d("Silos", text);
                    if (text.toUpperCase(Locale.US).contains("TOKEN")) {
                        CommonUtils.showPopUpEndSession(context);
                        dismissDialog();
                    } else {
                        Toast.makeText(context, text, 1).show();
                        dismissDialog();
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(context, context.getString(R.string.connection_error), 1).show();
                }
                return false;
            } catch (SAXException e2) {
                Log.e("RetrofitCallbackInterf", "SAXException", e2);
                dismissDialog();
            } catch (ParserConfigurationException e3) {
                Log.e("RetrofitCallbackInterf", "ParserConfigurationException", e3);
                dismissDialog();
            } catch (IOException e4) {
                Log.e("RetrofitCallbackInterf", "IOException", e4);
                dismissDialog();
            }
        }
        if (this.mDismissInicator.booleanValue()) {
            dismissDialog();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void finishConnection() {
        dismissDialog();
    }

    /* access modifiers changed from: protected */
    public void finishConnection(String message) {
        Toast.makeText(this.mContext, (message == null || message.contains("Certificate pinning failure!")) ? this.mContext.getString(R.string.connection_error) : message, 1).show();
        dismissDialog();
    }

    private void dismissDialog() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }
}
