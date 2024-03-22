package es.santander.justicia.http.interfaces;

import java.security.cert.Certificate;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Les/santander/justicia/http/interfaces/CertDownload;", "", "OnCertsDownloaded", "", "certificates", "", "Ljava/security/cert/Certificate;", "OnCertsFailed", "error", "", "app_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CertDownload.kt */
public interface CertDownload {
    void OnCertsDownloaded(List<? extends Certificate> list);

    void OnCertsFailed(String str);
}
