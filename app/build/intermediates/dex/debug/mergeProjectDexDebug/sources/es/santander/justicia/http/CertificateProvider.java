package es.santander.justicia.http;

import android.content.Context;
import com.bancosantander.securitylibrary.certificates.ConnectionCore;
import es.santander.justicia.http.interfaces.CertDownload;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\r"}, d2 = {"Les/santander/justicia/http/CertificateProvider;", "", "()V", "downloadCertificates", "", "context", "Landroid/content/Context;", "certDownloadListener", "Les/santander/justicia/http/interfaces/CertDownload;", "certificatesUrl", "", "provideCertificates", "globalEntorno", "app_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CertificateProvider.kt */
public final class CertificateProvider {
    public static final CertificateProvider INSTANCE = new CertificateProvider();

    private CertificateProvider() {
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:146)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:71)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final void provideCertificates(android.content.Context r5, java.lang.String r6, es.santander.justicia.http.interfaces.CertDownload r7) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "globalEntorno"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "certDownloadListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            int r1 = r6.hashCode()
            r2 = 78081(0x13101, float:1.09415E-40)
            r3 = 0
            if (r1 == r2) goto L_0x0043
            r2 = 79491(0x13683, float:1.1139E-40)
            if (r1 == r2) goto L_0x0036
            r2 = 79501(0x1368d, float:1.11405E-40)
            if (r1 == r2) goto L_0x0025
        L_0x0024:
            goto L_0x004f
        L_0x0025:
            java.lang.String r1 = "PRO"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x002e
            goto L_0x0024
        L_0x002e:
            java.lang.String r1 = "https://microsite.bancosantander.es/files/security/certs_justicia.json"
            r0 = r1
            r4.downloadCertificates(r5, r7, r0)
            goto L_0x004f
        L_0x0036:
            java.lang.String r1 = "PRE"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x003f
            goto L_0x0024
        L_0x003f:
            r7.OnCertsDownloaded(r3)
            goto L_0x004f
        L_0x0043:
            java.lang.String r1 = "OCU"
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L_0x004c
            goto L_0x0024
        L_0x004c:
            r7.OnCertsDownloaded(r3)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.http.CertificateProvider.provideCertificates(android.content.Context, java.lang.String, es.santander.justicia.http.interfaces.CertDownload):void");
    }

    private final void downloadCertificates(Context context, CertDownload certDownloadListener, String certificatesUrl) {
        new ConnectionCore(context).getCertificates(certificatesUrl, new CertificateProvider$downloadCertificates$1(certDownloadListener));
    }
}
