package es.santander.justicia.http;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import es.santander.justicia.http.beans.HttpClientSettings;
import es.santander.justicia.http.interfaces.WsResponse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;   
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

public class WSClientUtility extends AsyncTask<HttpClientSettings, Void, String> {
   private final String TAG = this.getClass().getName();
   private HttpURLConnection httpConnection;
   private final WsResponse wsStatusCallBack;
   private int responseStatus;

   public WSClientUtility(Context context, WsResponse wsStatusCallBack) {
      this.wsStatusCallBack = wsStatusCallBack;
   }

   protected String doInBackground(HttpClientSettings... params) {
      HttpClientSettings postParams = params[0];
      URL url = postParams.getUrl();
      List<Pair<String, String>> listParams = postParams.getParams();
      List listHeaders = postParams.getHeaders();

      try {
         this.httpConnection = (HttpURLConnection)url.openConnection();
         this.httpConnection.setConnectTimeout(60000);
         this.httpConnection.setReadTimeout(60000);
         this.httpConnection.setRequestMethod(postParams.getRequestType());
         this.httpConnection.setDoInput(true);
         if (listHeaders != null && listHeaders.size() > 0) {
            this.addHeaders(listHeaders);
         }

         if (listParams != null && listParams.size() > 0) {
            BufferedWriter br = null;
            OutputStream os = null;

            try {
               this.httpConnection.setDoOutput(true);
               os = this.httpConnection.getOutputStream();
               br = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
               br.write(this.getParams(listParams));
            } catch (Exception var31) {
               Log.e("WSClientUtility", "Error al escribir la lista de parametros", var31);
               throw var31;
            } finally {
               if (br != null) {
                  br.flush();
                  br.close();
               }

               if (os != null) {
                  os.close();
               }

            }
         }

         this.httpConnection.connect();
         this.responseStatus = this.httpConnection.getResponseCode();
         String response;
         Exception e;
         switch(this.responseStatus) {
         case 200:
         case 201:
         case 202:
            BufferedReader bufferedReader = null;
            InputStreamReader isr = null;
            response = null;

            try {
               isr = new InputStreamReader(this.httpConnection.getInputStream(), "UTF-8");
               bufferedReader = new BufferedReader(isr);
               StringBuilder stringBuilder = new StringBuilder();

               String line;
               while((line = bufferedReader.readLine()) != null) {
                  stringBuilder.append(line).append('\n');
               }

               response = stringBuilder.toString();
               break;
            } catch (Exception var33) {
               e = var33;
               throw var33;
            } finally {
               if (isr != null) {
                  isr.close();
               }

               if (bufferedReader != null) {
                  bufferedReader.close();
               }

            }
         default:
            e = null;
            return e;
         }

         if (response == null) {
            response = "";
         }

         String var40 = response;
         return var40;
      } catch (IOException var35) {
         Log.e("WSClientUtility", "Error al invocar al servicio: " + var35.getMessage(), var35);
      } finally {
         this.httpConnection.disconnect();
      }

      return null;
   }

   protected void onPostExecute(String response) {
      super.onPostExecute(response);
      if (this.responseStatus != 200 && (response == null || response.equals(""))) {
         this.wsStatusCallBack.onWsError(this.responseStatus, response);
      } else {
         this.wsStatusCallBack.onWsSuccess(this.responseStatus, response);
      }

   }

   private String getParams(List<Pair<String, String>> params) {
      StringBuilder result = new StringBuilder();
      boolean first = true;
      Iterator var4 = params.iterator();

      while(var4.hasNext()) {
         Pair<String, String> pair = (Pair)var4.next();
         if (!first) {
            result.append("&");
         }

         first = false;

         try {
            result.append(URLEncoder.encode((String)pair.first, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode((String)pair.second, "UTF-8"));
         } catch (Exception var7) {
            Log.e(this.TAG, "error parsing params: " + var7.getMessage(), var7);
         }
      }

      return result.toString();
   }

   private void addHeaders(List<Pair<String, String>> headers) {
      Iterator var2 = headers.iterator();

      while(var2.hasNext()) {
         Pair<String, String> header = (Pair)var2.next();
         this.httpConnection.setRequestProperty((String)header.first, (String)header.second);
      }

   }
}
