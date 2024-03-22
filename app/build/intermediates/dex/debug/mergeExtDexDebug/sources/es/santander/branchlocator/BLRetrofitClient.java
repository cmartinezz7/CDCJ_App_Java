package es.santander.branchlocator;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class BLRetrofitClient {
    private static BLRetrofitClient BLRetrofitClient = new BLRetrofitClient();
    private static final String TAG = "RetrofitClient";
    private BLBranchService BLBranchService = null;
    private String baseURL = BuildConfig.BASE_URL_EU;

    BLRetrofitClient() {
    }

    public static BLRetrofitClient getInstance() {
        return BLRetrofitClient;
    }

    /* access modifiers changed from: package-private */
    public BLBranchService getBranchService(Context context) {
        if (this.BLBranchService == null && context != null) {
            try {
                this.BLBranchService = (BLBranchService) new Retrofit.Builder().baseUrl(this.baseURL).addConverterFactory(GsonConverterFactory.create(gson())).client(okHttpClient(cache(context.getCacheDir()))).build().create(BLBranchService.class);
            } catch (KeyManagementException e) {
                Log.e(TAG, e.toString());
            } catch (NoSuchAlgorithmException e2) {
                Log.e(TAG, e2.toString());
            }
        }
        return this.BLBranchService;
    }

    public void setBaseURL(String baseURL2) {
        this.baseURL = baseURL2;
    }

    private OkHttpClient okHttpClient(Cache cache) throws NoSuchAlgorithmException, KeyManagementException {
        return new OkHttpClient.Builder().cache(cache).addInterceptor(loggingInterceptor()).connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).sslSocketFactory(new BLRetrofitTLSSocketFactory(), getTrustManagerFactory()).build();
    }

    private X509TrustManager getTrustManagerFactory() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                if (trustManagers[0] instanceof X509TrustManager) {
                    X509TrustManager trustManager = (X509TrustManager) trustManagers[0];
                    SSLContext.getInstance("SSL").init((KeyManager[]) null, new TrustManager[]{trustManager}, (SecureRandom) null);
                    return trustManager;
                }
            }
            return null;
        } catch (KeyStoreException | NoSuchAlgorithmException e) {
            return null;
        } catch (KeyManagementException e2) {
            Log.e(TAG, e2.toString());
            return null;
        }
    }

    private Gson gson() {
        return new GsonBuilder().create();
    }

    private HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    private Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10000000);
    }
}
