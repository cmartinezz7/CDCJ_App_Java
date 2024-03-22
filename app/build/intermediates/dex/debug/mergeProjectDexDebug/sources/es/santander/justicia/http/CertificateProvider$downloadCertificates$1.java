package es.santander.justicia.http;

import com.bancosantander.securitylibrary.certificates.ConnectionCore;
import es.santander.justicia.http.interfaces.CertDownload;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J$\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\t"}, d2 = {"es/santander/justicia/http/CertificateProvider$downloadCertificates$1", "Lcom/bancosantander/securitylibrary/certificates/ConnectionCore$CertsDownloadListener;", "certsDownloadFailed", "", "certsDownloadedSuccessfully", "certificates", "", "", "notCertificates", "app_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CertificateProvider.kt */
public final class CertificateProvider$downloadCertificates$1 implements ConnectionCore.CertsDownloadListener {
    final /* synthetic */ CertDownload $certDownloadListener;

    CertificateProvider$downloadCertificates$1(CertDownload $certDownloadListener2) {
        this.$certDownloadListener = $certDownloadListener2;
    }

    public void certsDownloadedSuccessfully(List<? extends Object> certificates, List<? extends Object> notCertificates) {
        Intrinsics.checkNotNullParameter(certificates, "certificates");
        Intrinsics.checkNotNullParameter(notCertificates, "notCertificates");
        List mCertificates = new ArrayList();
        Iterator<? extends Object> it = certificates.iterator();
        while (it.hasNext()) {
            mCertificates.add((Certificate) it.next());
        }
        this.$certDownloadListener.OnCertsDownloaded(mCertificates);
    }

    public void certsDownloadFailed() {
        this.$certDownloadListener.OnCertsFailed("Error descargando certificados");
    }
}
