package es.santander.justicia.utils.safetynet;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONObject;

public class AndroidDeviceVerifier {
    private static final String GOOGLE_VERIFICATION_URL = "https://www.googleapis.com/androidcheck/v1/attestations/verify?key=";
    /* access modifiers changed from: private */
    public static final String TAG = AndroidDeviceVerifier.class.getSimpleName();
    /* access modifiers changed from: private */
    public final String apiKey;
    /* access modifiers changed from: private */
    public AndroidDeviceVerifierCallback callback;
    /* access modifiers changed from: private */
    public final String signatureToVerify;

    public interface AndroidDeviceVerifierCallback {
        void error(String str);

        void success(boolean z);
    }

    public AndroidDeviceVerifier(String apiKey2, String signatureToVerify2) {
        this.apiKey = apiKey2;
        this.signatureToVerify = signatureToVerify2;
    }

    public void verify(AndroidDeviceVerifierCallback androidDeviceVerifierCallback) {
        this.callback = androidDeviceVerifierCallback;
        new AndroidDeviceVerifierTask().execute(new Void[0]);
    }

    /* access modifiers changed from: protected */
    public TrustManager[] getTrustManagers() throws KeyStoreException, NoSuchAlgorithmException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] defaultTrustManagers = trustManagerFactory.getTrustManagers();
        TrustManager[] trustManagers = (TrustManager[]) Arrays.copyOf(defaultTrustManagers, defaultTrustManagers.length + 1);
        trustManagers[defaultTrustManagers.length] = new GoogleApisTrustManager();
        return trustManagers;
    }

    private class AndroidDeviceVerifierTask extends AsyncTask<Void, Void, Boolean> {
        private Exception error;

        private AndroidDeviceVerifierTask() {
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(Void... params) {
            InputStream is = null;
            BufferedReader rd = null;
            OutputStream os = null;
            try {
                URL verifyApiUrl = new URL(AndroidDeviceVerifier.GOOGLE_VERIFICATION_URL + AndroidDeviceVerifier.this.apiKey);
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init((KeyManager[]) null, AndroidDeviceVerifier.this.getTrustManagers(), (SecureRandom) null);
                HttpsURLConnection urlConnection = (HttpsURLConnection) verifyApiUrl.openConnection();
                urlConnection.setSSLSocketFactory(sslContext.getSocketFactory());
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                byte[] outputInBytes = ("{ \"signedAttestation\": \"" + AndroidDeviceVerifier.this.signatureToVerify + "\"}").getBytes("UTF-8");
                OutputStream os2 = urlConnection.getOutputStream();
                os2.write(outputInBytes);
                os2.close();
                urlConnection.connect();
                InputStream is2 = urlConnection.getInputStream();
                BufferedReader rd2 = new BufferedReader(new InputStreamReader(is2));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = rd2.readLine();
                    String line = readLine;
                    if (readLine == null) {
                        break;
                    }
                    sb.append(line);
                }
                JSONObject responseRoot = new JSONObject(sb.toString());
                if (responseRoot.has("isValidSignature")) {
                    Boolean valueOf = Boolean.valueOf(responseRoot.getBoolean("isValidSignature"));
                    if (is2 != null) {
                        try {
                            is2.close();
                        } catch (IOException e) {
                            URL url = verifyApiUrl;
                            Log.d("IOException", e.getMessage());
                        }
                    }
                    rd2.close();
                    if (os2 != null) {
                        os2.close();
                    }
                    URL url2 = verifyApiUrl;
                    return valueOf;
                }
                if (is2 != null) {
                    try {
                        is2.close();
                    } catch (IOException e2) {
                        Log.d("IOException", e2.getMessage());
                    }
                }
                rd2.close();
                if (os2 != null) {
                    os2.close();
                }
                return false;
            } catch (Exception e3) {
                Exception e4 = e3;
                this.error = e4;
                Log.e(AndroidDeviceVerifier.TAG, "problem validating JWS Message :" + e4.getMessage(), e4);
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e5) {
                        Log.d("IOException", e5.getMessage());
                        return false;
                    }
                }
                if (rd != null) {
                    rd.close();
                }
                if (os != null) {
                    os.close();
                }
                return false;
            } catch (Throwable th) {
                Throwable th2 = th;
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e6) {
                        Log.d("IOException", e6.getMessage());
                        throw th2;
                    }
                }
                if (rd != null) {
                    rd.close();
                }
                if (os != null) {
                    os.close();
                }
                throw th2;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean aBoolean) {
            if (this.error != null) {
                AndroidDeviceVerifier.this.callback.error(this.error.getMessage());
            } else {
                AndroidDeviceVerifier.this.callback.success(aBoolean.booleanValue());
            }
        }
    }
}
