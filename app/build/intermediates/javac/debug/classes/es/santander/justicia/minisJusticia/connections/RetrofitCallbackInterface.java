package es.santander.justicia.minisJusticia.connections;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.io.IOException;
import java.io.StringReader;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCallbackInterface<T> implements Callback<T> {
   private ProgressDialog mProgressDialog;
   private Context mContext;
   private Boolean mShowIndicator = true;
   private Boolean mDismissInicator = true;

   public RetrofitCallbackInterface(Context context, Boolean show, Boolean dismiss) {
      this.mContext = context;
      this.mShowIndicator = show;
      this.mDismissInicator = dismiss;
      if (this.mShowIndicator) {
         this.mProgressDialog = new ProgressDialog(context);
         this.mProgressDialog.setMessage(context.getString(2131886514));
         this.mProgressDialog.setCancelable(false);
         this.mProgressDialog.show();
      }

   }

   public RetrofitCallbackInterface(Context context) {
      this.mContext = context;
      this.mShowIndicator = true;
      this.mDismissInicator = true;
      if (this.mShowIndicator) {
         this.mProgressDialog = new ProgressDialog(context);
         this.mProgressDialog.setMessage(context.getString(2131886514));
         this.mProgressDialog.setCancelable(false);
         this.mProgressDialog.show();
      }

   }

   public void onResponse(Call<T> call, Response<T> response) {
      this.finishConnection();
   }

   public void onFailure(Call<T> call, Throwable t) {
      Log.d("Silos", "connction fail " + t.getMessage());
      this.finishConnection(t.getMessage());
   }

   protected boolean finishConnection(Context context, String token, String responsError) {
      boolean retValue = true;
      if (token != null && !token.isEmpty()) {
         RetrofitUtility.updateToken = token;
         PreferencesHelper.newInstance(context).setString("preference_token_sso", token);
      }

      if (responsError != null && !responsError.isEmpty()) {
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

         try {
            if (this.mDismissInicator) {
               this.dismissDialog();
            }

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(responsError)));

            try {
               String text = document.getDocumentElement().getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(1).getTextContent();
               Log.d("Silos", text);
               if (text.toUpperCase(Locale.US).contains("TOKEN")) {
                  CommonUtils.showPopUpEndSession(context);
                  this.dismissDialog();
               } else {
                  Toast.makeText(context, text, 1).show();
                  this.dismissDialog();
               }
            } catch (NullPointerException var9) {
               Toast.makeText(context, context.getString(2131886346), 1).show();
            }

            return false;
         } catch (SAXException var10) {
            Log.e("RetrofitCallbackInterf", "SAXException", var10);
            this.dismissDialog();
         } catch (ParserConfigurationException var11) {
            Log.e("RetrofitCallbackInterf", "ParserConfigurationException", var11);
            this.dismissDialog();
         } catch (IOException var12) {
            Log.e("RetrofitCallbackInterf", "IOException", var12);
            this.dismissDialog();
         }
      }

      if (this.mDismissInicator) {
         this.dismissDialog();
      }

      return retValue;
   }

   protected void finishConnection() {
      this.dismissDialog();
   }

   protected void finishConnection(String message) {
      Toast.makeText(this.mContext, message != null && !message.contains("Certificate pinning failure!") ? message : this.mContext.getString(2131886346), 1).show();
      this.dismissDialog();
   }

   private void dismissDialog() {
      if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
         this.mProgressDialog.dismiss();
      }

   }
}
