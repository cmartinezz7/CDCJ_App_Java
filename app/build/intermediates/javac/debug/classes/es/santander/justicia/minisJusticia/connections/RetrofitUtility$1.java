package es.santander.justicia.minisJusticia.connections;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class RetrofitUtility$1 implements X509TrustManager {
   public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
   }

   public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
   }

   public X509Certificate[] getAcceptedIssuers() {
      return new X509Certificate[0];
   }
}
