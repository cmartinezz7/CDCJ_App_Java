package es.santander.justicia.utils.safetynet;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class GoogleApisTrustManager implements X509TrustManager {
    private static final String[] GOOGLEAPIS_COM_PINS = {"sha1/f2QjSla9GtnwpqhqreDLIkQNFu8=", "sha1/Q9rWMO5T+KmAym79hfRqo3mQ4Oo=", "sha1/wHqYaI2J+6sFZAwRfap9ZbjKzE4="};

    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        int length = chain.length;
        int i = 0;
        while (i < length) {
            if (validateCertificatePin(chain[i])) {
                i++;
            } else {
                throw new CertificateException("could not find a valid SSL public key pin for www.googleapis.com");
            }
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    private boolean validateCertificatePin(X509Certificate certificate) throws CertificateException {
        try {
            String pinAsBase64 = "sha1/" + Base64.encodeToString(MessageDigest.getInstance("SHA256").digest(certificate.getPublicKey().getEncoded()), 0);
            for (String validPin : GOOGLEAPIS_COM_PINS) {
                if (validPin.equalsIgnoreCase(pinAsBase64)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }
}
