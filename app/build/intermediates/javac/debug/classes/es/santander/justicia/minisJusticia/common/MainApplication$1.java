package es.santander.justicia.minisJusticia.common;

import es.santander.justicia.http.interfaces.CertDownload;
import es.santander.justicia.utils.NetworkUtils;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.Nullable;

class MainApplication$1 implements CertDownload {
   // $FF: synthetic field
   final MainApplication this$0;

   MainApplication$1(MainApplication this$0) {
      this.this$0 = this$0;
   }

   public void OnCertsDownloaded(@Nullable List<? extends Certificate> certificates) {
      if (certificates != null) {
         NetworkUtils.setCertificates((ArrayList)certificates);
      }

   }

   public void OnCertsFailed(@Nullable String error) {
   }
}
