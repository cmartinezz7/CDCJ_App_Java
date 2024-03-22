package es.santander.justicia.minisJusticia.connections;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import es.santander.justicia.BuildConfig;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.utils.InitConfigConstants;
import es.santander.justicia.utils.NetworkUtils;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitUtility {
    public static CertificatePinner certificatePinner;
    public static String updateToken;

    public Retrofit getRetrofitInstance(boolean isLogin) {
        OkHttpClient okHttpClient;
        Serializer serializer = new Persister(new AnnotationStrategy());
        WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings(isLogin ? InitConfigConstants.WS_JUZGADOS_LOGIN : InitConfigConstants.WS_JUZGADOS, MainApplication.getAppContext().getEnvironment());
        if (MainApplication.ENV_DEFAULT != MainApplication.ENV_PROD || !BuildConfig.SSL_ACTIVE.booleanValue()) {
            okHttpClient = getUnsafeOkHttpClient();
        } else {
            okHttpClient = getSafeOkHttpClient();
            NetworkUtils.setUrlCertificate(wsSettings.getUrlCertificate());
        }
        return new Retrofit.Builder().addConverterFactory(SimpleXmlConverterFactory.create(serializer)).baseUrl(wsSettings.getUrl() + "/").client(okHttpClient).build();
    }

    public Retrofit getRetrofitInstance(String endpoint, Context context) {
        OkHttpClient okHttpClient;
        if (Build.VERSION.SDK_INT < 21) {
            try {
                ProviderInstaller.installIfNeeded(context.getApplicationContext());
            } catch (GooglePlayServicesRepairableException e) {
                Log.d("IOException", e.getMessage());
            } catch (GooglePlayServicesNotAvailableException e2) {
                Log.d("GPSException", e2.getMessage());
            }
        }
        Serializer serializer = new Persister(new AnnotationStrategy());
        WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings(endpoint, MainApplication.getAppContext().getEnvironment());
        if (MainApplication.ENV_DEFAULT != MainApplication.ENV_PROD || !BuildConfig.SSL_ACTIVE.booleanValue()) {
            okHttpClient = getUnsafeOkHttpClient();
        } else {
            okHttpClient = getSafeOkHttpClient();
            NetworkUtils.setUrlCertificate(wsSettings.getUrlCertificate());
        }
        return new Retrofit.Builder().addConverterFactory(SimpleXmlConverterFactory.create(serializer)).baseUrl(wsSettings.getUrl()).client(okHttpClient).build();
    }

    public Retrofit getRetrofitInstanceJson(String endpoint, Context context) {
        OkHttpClient okHttpClient;
        if (Build.VERSION.SDK_INT < 21) {
            try {
                ProviderInstaller.installIfNeeded(context.getApplicationContext());
            } catch (GooglePlayServicesRepairableException e) {
                Log.d("IOException", e.getMessage());
            } catch (GooglePlayServicesNotAvailableException e2) {
                Log.d("GPSException", e2.getMessage());
            }
        }
        WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings(endpoint, MainApplication.getAppContext().getEnvironment());
        if (MainApplication.ENV_DEFAULT != MainApplication.ENV_PROD || !BuildConfig.SSL_ACTIVE.booleanValue()) {
            okHttpClient = getUnsafeOkHttpClient();
        } else {
            okHttpClient = getSafeOkHttpClient();
            NetworkUtils.setUrlCertificate(wsSettings.getUrlCertificate());
        }
        return new Retrofit.Builder().baseUrl(wsSettings.getUrl()).client(okHttpClient).build();
    }

    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            X509TrustManager cert = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init((KeyManager[]) null, new TrustManager[]{cert}, new SecureRandom());
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, cert);
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(MainApplication.ENV_DEFAULT == MainApplication.ENV_PROD ? HttpLoggingInterceptor.Level.NONE : HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor).connectTimeout(2, TimeUnit.MINUTES).writeTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).build();
            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static OkHttpClient getSafeOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(MainApplication.ENV_DEFAULT == MainApplication.ENV_PROD ? HttpLoggingInterceptor.Level.NONE : HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        builder.connectTimeout(2, TimeUnit.MINUTES).writeTimeout(2, TimeUnit.MINUTES).readTimeout(2, TimeUnit.MINUTES).certificatePinner(certificatePinner).build();
        return builder.build();
    }
}
