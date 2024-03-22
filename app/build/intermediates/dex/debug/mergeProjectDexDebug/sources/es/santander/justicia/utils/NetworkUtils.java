package es.santander.justicia.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.util.Log;
import androidx.appcompat.app.AlertDialog;
import es.santander.justicia.BuildConfig;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.models.WebServiceSettingsModel;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.HttpsTransportSE;
import org.xmlpull.v1.XmlPullParserException;

public class NetworkUtils {
    public static final String[] CERTIFICATES = {"bancosantanderes", "juzgadosmobilesantanderprecorp", "micrositebancosantanderes", "movilidadseisantanderprecorp", "particulareswssantanderprecorp", "santanderempresasmobi", "santanderjusticiamobi", "wwwbsanmobi", "wolterskluweres", "diariolaleylaleyes", "tiqcdncom", "santanderprecorp"};
    private static KeyStore keyStore;
    private static SSLSocketFactory sslSocketFactory;

    public static void callSoapService(String urlString, String urlCertificate, String soapAction, SoapEnvelope envelope, int connectionTimeout) throws IOException, XmlPullParserException {
        String responseDump;
        String requestDump;
        try {
            if (urlString.startsWith("https")) {
                URL url = new URL(urlString);
                HttpsTransportSE androidHttpsTransport = new HttpsTransportSE(url.getHost(), url.getPort(), url.getFile(), connectionTimeout);
                androidHttpsTransport.debug = true;
                if (BuildConfig.DEBUG || !BuildConfig.SSL_ACTIVE.booleanValue()) {
                    androidHttpsTransport.getServiceConnection().setSSLSocketFactory(getSslSocketFactory());
                } else {
                    setUrlCertificate(urlCertificate);
                    androidHttpsTransport.getServiceConnection().setSSLSocketFactory(getSslSocketFactory());
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
                }
                androidHttpsTransport.call(soapAction, envelope);
                requestDump = androidHttpsTransport.requestDump;
                responseDump = androidHttpsTransport.responseDump;
            } else {
                HttpTransportSE androidHttpTransport = new HttpTransportSE(urlString, connectionTimeout);
                androidHttpTransport.debug = true;
                androidHttpTransport.call(soapAction, envelope);
                requestDump = androidHttpTransport.requestDump;
                responseDump = androidHttpTransport.responseDump;
            }
            Log.i("callSoapService", "Service: " + urlString);
            Log.i("callSoapService", "RequestMJ: " + requestDump);
            Log.i("callSoapService", "ResponseMJ: " + responseDump);
        } catch (SSLException e) {
            throw new IOException();
        } catch (Exception e2) {
            throw new IOException();
        }
    }

    public static KeyStore getKeyStore() {
        if (keyStore == null) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore = instance;
                instance.load((InputStream) null, (char[]) null);
                for (String certificate : CERTIFICATES) {
                    if (getCertificate(certificate) != null) {
                        keyStore.setCertificateEntry(certificate, getCertificate(certificate));
                    }
                }
            } catch (KeyStoreException e) {
                Log.e("NetworkUtils", "Error al cargar los certificados KeyStoreException", e);
            } catch (CertificateException e2) {
                Log.e("NetworkUtils", "Error al cargar los certificados CertificateException", e2);
            } catch (NoSuchAlgorithmException e3) {
                Log.e("NetworkUtils", "Error al cargar los certificados NoSuchAlgorithmException", e3);
            } catch (IOException e4) {
                Log.e("NetworkUtils", "Error al cargar los certificados IOException", e4);
            }
        }
        return keyStore;
    }

    public static Certificate getCertificate(String certificatePath) {
        Certificate ca = null;
        if (certificatePath != null) {
            InputStream caInput = null;
            if (certificatePath.startsWith("http")) {
                try {
                    caInput = new URL(certificatePath).openStream();
                    ca = CertificateFactory.getInstance("X.509").generateCertificate(caInput);
                    Log.i("NetworkUtils", "ca=" + ((X509Certificate) ca).getSubjectDN());
                    if (caInput != null) {
                        try {
                            caInput.close();
                        } catch (IOException e) {
                            Log.e("NetworkUtils", "Error al cerrar caInput", e);
                        }
                    }
                } catch (IOException e2) {
                    Log.e("NetworkUtils", "Error al recuperar el certificado de URL: " + certificatePath, e2);
                    if (caInput != null) {
                        caInput.close();
                    }
                } catch (CertificateException e3) {
                    Log.e("NetworkUtils", "Error al cargar los certificados", e3);
                    if (caInput != null) {
                        caInput.close();
                    }
                } catch (Throwable th) {
                    if (caInput != null) {
                        try {
                            caInput.close();
                        } catch (IOException e4) {
                            Log.e("NetworkUtils", "Error al cerrar caInput", e4);
                        }
                    }
                    throw th;
                }
            } else {
                try {
                    caInput = MainApplication.getAppContext().getAssets().open("certificados/" + certificatePath + ".der");
                    ca = CertificateFactory.getInstance("X.509").generateCertificate(caInput);
                    Log.i("NetworkUtils", "ca=" + ((X509Certificate) ca).getSubjectDN());
                    if (caInput != null) {
                        try {
                            caInput.close();
                        } catch (IOException e5) {
                            Log.e("NetworkUtils", "Error al cerrar caInput", e5);
                        }
                    }
                } catch (IOException e6) {
                    Log.e("NetworkUtils", "Error al recuperar el certificado de Assets: " + certificatePath, e6);
                    if (caInput != null) {
                        caInput.close();
                    }
                } catch (CertificateException e7) {
                    Log.e("NetworkUtils", "Error al cargar los certificados", e7);
                    if (caInput != null) {
                        caInput.close();
                    }
                } catch (Throwable th2) {
                    if (caInput != null) {
                        try {
                            caInput.close();
                        } catch (IOException e8) {
                            Log.e("NetworkUtils", "Error al cerrar caInput", e8);
                        }
                    }
                    throw th2;
                }
            }
        }
        return ca;
    }

    public static void cargarCertificadosDeConfianza() {
        try {
            if (!MainApplication.ENV_DEFAULT.equals(MainApplication.ENV_PROD) || !BuildConfig.SSL_ACTIVE.booleanValue()) {
                sslSocketFactory = getUnsafeSSL().getSocketFactory();
                return;
            }
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(getKeyStore());
            SSLContext context = SSLContext.getInstance("SSL");
            context.init((KeyManager[]) null, tmf.getTrustManagers(), (SecureRandom) null);
            sslSocketFactory = context.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            Log.e("NetworkUtils", "Error al cargar los certificados NoSuchAlgorithmException", e);
        } catch (KeyStoreException e2) {
            Log.e("NetworkUtils", "Error al cargar los certificados KeyStoreException", e2);
        } catch (KeyManagementException e3) {
            Log.e("NetworkUtils", "Error al cargar los certificados KeyManagementException", e3);
        }
    }

    static SSLContext getUnsafeSSL() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = {new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init((KeyManager[]) null, trustAllCerts, new SecureRandom());
        return sslContext;
    }

    public static boolean isDeviceOnline() {
        try {
            if (Runtime.getRuntime().exec("/system/bin/ping -c 1 8.8.8.8").waitFor() == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            Log.e("isDeviceOnline", "Exception", e);
            return false;
        }
    }

    public static void showRequestInternetDialog(final Activity activity, int message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(false);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.go_configuration, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                activity.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
            }
        });
        builder.create().show();
    }

    public static void setUrlCertificate(String urlCertificate) {
        if (urlCertificate != null && !urlCertificate.isEmpty()) {
            try {
                getKeyStore().setCertificateEntry(WebServiceSettingsModel.URL_CERTIFICATE_COLUMN, getCertificate(urlCertificate));
            } catch (KeyStoreException e) {
                Log.e("NetworkUtils", "Error al cargar los certificados KeyStoreException", e);
            }
            cargarCertificadosDeConfianza();
        }
    }

    public static void setCertificates(ArrayList<Certificate> urlCertificates) {
        if (urlCertificates != null && !urlCertificates.isEmpty()) {
            KeyStore keyStore2 = getKeyStore();
            int counter = 0;
            Iterator<Certificate> it = urlCertificates.iterator();
            while (it.hasNext()) {
                try {
                    keyStore2.setCertificateEntry(WebServiceSettingsModel.URL_CERTIFICATE_COLUMN + counter, it.next());
                    counter++;
                } catch (KeyStoreException e) {
                    Log.e("NetworkUtils", "Error al cargar los certificados KeyStoreException", e);
                }
            }
            cargarCertificadosDeConfianza();
        }
    }

    public static SSLSocketFactory getSslSocketFactory() {
        if (sslSocketFactory == null) {
            cargarCertificadosDeConfianza();
        }
        return sslSocketFactory;
    }
}
