package es.santander.justicia.minisJusticia.connections;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import es.santander.justicia.BuildConfig;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.connections.RetrofitUtility.1;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.utils.NetworkUtils;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RetrofitUtility {
   public static String updateToken;
   public static CertificatePinner certificatePinner;

   public Retrofit getRetrofitInstance(boolean isLogin) {
      Strategy strategy = new AnnotationStrategy();
      Serializer serializer = new Persister(strategy);
      WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings(isLogin ? "wsJuzgadosMobileLogin" : "wsJuzgadosMobile", MainApplication.getAppContext().getEnvironment());
      OkHttpClient okHttpClient;
      String url;
      if (MainApplication.ENV_DEFAULT == "PROD" && BuildConfig.SSL_ACTIVE) {
         okHttpClient = getSafeOkHttpClient();
         url = wsSettings.getUrlCertificate();
         NetworkUtils.setUrlCertificate(url);
      } else {
         okHttpClient = getUnsafeOkHttpClient();
      }

      url = wsSettings.getUrl() + "/";
      Retrofit retrofit = (new Builder()).addConverterFactory(SimpleXmlConverterFactory.create(serializer)).baseUrl(url).client(okHttpClient).build();
      return retrofit;
   }

   public Retrofit getRetrofitInstance(String endpoint, Context context) {
      if (VERSION.SDK_INT < 21) {
         try {
            ProviderInstaller.installIfNeeded(context.getApplicationContext());
         } catch (GooglePlayServicesRepairableException var8) {
            Log.d("IOException", var8.getMessage());
         } catch (GooglePlayServicesNotAvailableException var9) {
            Log.d("GPSException", var9.getMessage());
         }
      }

      Strategy strategy = new AnnotationStrategy();
      Serializer serializer = new Persister(strategy);
      WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings(endpoint, MainApplication.getAppContext().getEnvironment());
      OkHttpClient okHttpClient;
      if (MainApplication.ENV_DEFAULT == "PROD" && BuildConfig.SSL_ACTIVE) {
         okHttpClient = getSafeOkHttpClient();
         String urlCertificate = wsSettings.getUrlCertificate();
         NetworkUtils.setUrlCertificate(urlCertificate);
      } else {
         okHttpClient = getUnsafeOkHttpClient();
      }

      Retrofit retrofit = (new Builder()).addConverterFactory(SimpleXmlConverterFactory.create(serializer)).baseUrl(wsSettings.getUrl()).client(okHttpClient).build();
      return retrofit;
   }

   public Retrofit getRetrofitInstanceJson(String endpoint, Context context) {
      if (VERSION.SDK_INT < 21) {
         try {
            ProviderInstaller.installIfNeeded(context.getApplicationContext());
         } catch (GooglePlayServicesRepairableException var6) {
            Log.d("IOException", var6.getMessage());
         } catch (GooglePlayServicesNotAvailableException var7) {
            Log.d("GPSException", var7.getMessage());
         }
      }

      WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings(endpoint, MainApplication.getAppContext().getEnvironment());
      OkHttpClient okHttpClient;
      if (MainApplication.ENV_DEFAULT == "PROD" && BuildConfig.SSL_ACTIVE) {
         okHttpClient = getSafeOkHttpClient();
         String urlCertificate = wsSettings.getUrlCertificate();
         NetworkUtils.setUrlCertificate(urlCertificate);
      } else {
         okHttpClient = getUnsafeOkHttpClient();
      }

      Retrofit retrofit = (new Builder()).baseUrl(wsSettings.getUrl()).client(okHttpClient).build();
      return retrofit;
   }

   private static OkHttpClient getUnsafeOkHttpClient() {
      try {
         X509TrustManager cert = new 1();
         TrustManager[] trustAllCerts = new TrustManager[]{cert};
         SSLContext sslContext = SSLContext.getInstance("SSL");
         sslContext.init((KeyManager[])null, trustAllCerts, new SecureRandom());
         SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
         okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
         builder.sslSocketFactory(sslSocketFactory, cert);
         HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
         interceptor.setLevel(MainApplication.ENV_DEFAULT == "PROD" ? Level.NONE : Level.BODY);
         builder.addInterceptor(interceptor).connectTimeout(2L, TimeUnit.MINUTES).writeTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).build();
         OkHttpClient okHttpClient = builder.build();
         return okHttpClient;
      } catch (Exception var7) {
         throw new RuntimeException(var7);
      }
   }

   private static OkHttpClient getSafeOkHttpClient() {
      okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
      if (BuildConfig.DEBUG) {
         HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
         interceptor.setLevel(MainApplication.ENV_DEFAULT == "PROD" ? Level.NONE : Level.BODY);
         builder.addInterceptor(interceptor);
      }

      builder.connectTimeout(2L, TimeUnit.MINUTES).writeTimeout(2L, TimeUnit.MINUTES).readTimeout(2L, TimeUnit.MINUTES).certificatePinner(certificatePinner).build();
      return builder.build();
   }
}
