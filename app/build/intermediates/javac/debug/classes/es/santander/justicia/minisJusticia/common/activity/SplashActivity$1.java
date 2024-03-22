package es.santander.justicia.minisJusticia.common.activity;

import android.util.Log;
import com.bancosantander.securitylibrary.certificates.ConnectionCore.CertsPinDownloadListener;
import es.santander.justicia.minisJusticia.connections.RetrofitUtility;
import okhttp3.CertificatePinner;

class SplashActivity$1 implements CertsPinDownloadListener {
   // $FF: synthetic field
   final SplashActivity this$0;

   SplashActivity$1(SplashActivity this$0) {
      this.this$0 = this$0;
   }

   public void certsDownloadedSuccessfully(Object o) {
      RetrofitUtility.certificatePinner = (CertificatePinner)o;
      Log.d("Pinning", "Pinning OK");
      SplashActivity.access$000(this.this$0);
   }

   public void certsDownloadFailed() {
      Log.d("Pinning", "Pinning ERROR");
   }
}
