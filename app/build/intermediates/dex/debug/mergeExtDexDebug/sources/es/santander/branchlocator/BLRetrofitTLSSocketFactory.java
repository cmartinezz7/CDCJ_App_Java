package es.santander.branchlocator;

import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class BLRetrofitTLSSocketFactory extends SSLSocketFactory {
    private static final String TAG = "RetrofitTLSSocketFactor";
    private SSLSocketFactory delegate;

    public BLRetrofitTLSSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.delegate = context.getSocketFactory();
    }

    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public Socket createSocket() throws SSLException, IOException {
        try {
            return enableTLSOnSocket(this.delegate.createSocket());
        } catch (SSLException e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws SSLException, IOException {
        try {
            return enableTLSOnSocket(this.delegate.createSocket(s, host, port, autoClose));
        } catch (SSLException e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public Socket createSocket(String host, int port) throws SSLException, IOException, UnknownHostException {
        try {
            return enableTLSOnSocket(this.delegate.createSocket(host, port));
        } catch (SSLException e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws SSLException, IOException, UnknownHostException {
        try {
            return enableTLSOnSocket(this.delegate.createSocket(host, port, localHost, localPort));
        } catch (SSLException e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public Socket createSocket(InetAddress host, int port) throws SSLException, IOException {
        try {
            return enableTLSOnSocket(this.delegate.createSocket(host, port));
        } catch (SSLException e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws SSLException, IOException {
        try {
            return enableTLSOnSocket(this.delegate.createSocket(address, port, localAddress, localPort));
        } catch (SSLException e) {
            Log.e(TAG, e.toString());
            return null;
        }
    }

    private Socket enableTLSOnSocket(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
        }
        return socket;
    }
}
