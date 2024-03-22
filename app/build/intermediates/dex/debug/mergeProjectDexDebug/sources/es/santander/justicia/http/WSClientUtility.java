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
import java.util.List;

public class WSClientUtility extends AsyncTask<HttpClientSettings, Void, String> {
    private final String TAG = getClass().getName();
    private HttpURLConnection httpConnection;
    private int responseStatus;
    private final WsResponse wsStatusCallBack;

    public WSClientUtility(Context context, WsResponse wsStatusCallBack2) {
        this.wsStatusCallBack = wsStatusCallBack2;
    }

    /* Debug info: failed to restart local var, previous not found, register: 13 */
    /* access modifiers changed from: protected */
    public String doInBackground(HttpClientSettings... params) {
        BufferedReader bufferedReader;
        InputStreamReader isr;
        BufferedWriter br;
        OutputStream os;
        HttpClientSettings postParams = params[0];
        URL url = postParams.getUrl();
        List<Pair<String, String>> listParams = postParams.getParams();
        List<Pair<String, String>> listHeaders = postParams.getHeaders();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            this.httpConnection = httpURLConnection;
            httpURLConnection.setConnectTimeout(60000);
            this.httpConnection.setReadTimeout(60000);
            this.httpConnection.setRequestMethod(postParams.getRequestType());
            this.httpConnection.setDoInput(true);
            if (listHeaders != null && listHeaders.size() > 0) {
                addHeaders(listHeaders);
            }
            if (listParams != null) {
                if (listParams.size() > 0) {
                    br = null;
                    os = null;
                    this.httpConnection.setDoOutput(true);
                    os = this.httpConnection.getOutputStream();
                    br = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                    br.write(getParams(listParams));
                    br.flush();
                    br.close();
                    if (os != null) {
                        os.close();
                    }
                }
            }
            this.httpConnection.connect();
            int responseCode = this.httpConnection.getResponseCode();
            this.responseStatus = responseCode;
            switch (responseCode) {
                case 200:
                case 201:
                case 202:
                    bufferedReader = null;
                    isr = null;
                    InputStreamReader isr2 = new InputStreamReader(this.httpConnection.getInputStream(), "UTF-8");
                    BufferedReader bufferedReader2 = new BufferedReader(isr2);
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        String line = readLine;
                        if (readLine != null) {
                            stringBuilder.append(line).append(10);
                        } else {
                            String response = stringBuilder.toString();
                            isr2.close();
                            bufferedReader2.close();
                            if (response == null) {
                                response = "";
                            }
                            this.httpConnection.disconnect();
                            return response;
                        }
                    }
                default:
                    this.httpConnection.disconnect();
                    return null;
            }
        } catch (Exception e) {
            throw e;
        } catch (Exception e2) {
            Log.e("WSClientUtility", "Error al escribir la lista de parametros", e2);
            throw e2;
        } catch (IOException e3) {
            Log.e("WSClientUtility", "Error al invocar al servicio: " + e3.getMessage(), e3);
            return null;
        } catch (Throwable th) {
            if (br != null) {
                br.flush();
                br.close();
            }
            if (os != null) {
                os.close();
            }
            throw th;
        }
        try {
            Log.e("WSClientUtility", "Error al invocar al servicio: " + e3.getMessage(), e3);
            return null;
        } finally {
            this.httpConnection.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(String response) {
        super.onPostExecute(response);
        if (this.responseStatus == 200 || (response != null && !response.equals(""))) {
            this.wsStatusCallBack.onWsSuccess(this.responseStatus, response);
        } else {
            this.wsStatusCallBack.onWsError(this.responseStatus, response);
        }
    }

    private String getParams(List<Pair<String, String>> params) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Pair<String, String> pair : params) {
            if (!first) {
                result.append("&");
            }
            first = false;
            try {
                result.append(URLEncoder.encode((String) pair.first, "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode((String) pair.second, "UTF-8"));
            } catch (Exception e) {
                Log.e(this.TAG, "error parsing params: " + e.getMessage(), e);
            }
        }
        return result.toString();
    }

    private void addHeaders(List<Pair<String, String>> headers) {
        for (Pair<String, String> header : headers) {
            this.httpConnection.setRequestProperty((String) header.first, (String) header.second);
        }
    }
}
