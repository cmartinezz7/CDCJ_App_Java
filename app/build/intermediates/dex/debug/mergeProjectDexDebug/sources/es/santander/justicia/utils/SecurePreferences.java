package es.santander.justicia.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SecurePreferences {
    private static final String CHARSET = "UTF-8";
    private static final String SECRET_KEY_HASH_TRANSFORMATION = "SHA-256";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private final boolean encryptKeys;
    private final SharedPreferences preferences;
    private final Cipher reader;
    private final Cipher writer;

    private native String getString();

    public SecurePreferences(Context context, String preferenceName, String secureKey, boolean encryptKeys2) throws NullPointerException {
        try {
            this.writer = Cipher.getInstance(TRANSFORMATION);
            this.reader = Cipher.getInstance(TRANSFORMATION);
            initCiphers(secureKey);
            this.preferences = context.getSharedPreferences(preferenceName, 0);
            this.encryptKeys = encryptKeys2;
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    static {
        System.loadLibrary("strings_module");
    }

    /* access modifiers changed from: protected */
    public void initCiphers(String secureKey) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        IvParameterSpec ivSpec = getIv();
        SecretKeySpec secretKey = getSecretKey(secureKey);
        this.writer.init(1, secretKey, ivSpec);
        this.reader.init(2, secretKey, ivSpec);
    }

    /* access modifiers changed from: protected */
    public IvParameterSpec getIv() {
        byte[] iv = new byte[this.writer.getBlockSize()];
        System.arraycopy(getString().getBytes(), 0, iv, 0, this.writer.getBlockSize());
        return new IvParameterSpec(iv);
    }

    /* access modifiers changed from: protected */
    public SecretKeySpec getSecretKey(String key) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return new SecretKeySpec(createKeyBytes(key), TRANSFORMATION);
    }

    /* access modifiers changed from: protected */
    public byte[] createKeyBytes(String key) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(SECRET_KEY_HASH_TRANSFORMATION);
        md.reset();
        return md.digest(key.getBytes(CHARSET));
    }

    public void put(String key, String value) {
        if (value == null) {
            this.preferences.edit().remove(toKey(key)).commit();
        } else {
            putValue(toKey(key), value);
        }
    }

    public boolean containsKey(String key) {
        return this.preferences.contains(toKey(key));
    }

    public void removeValue(String key) {
        this.preferences.edit().remove(toKey(key)).commit();
    }

    public String getString(String key) throws NullPointerException {
        if (this.preferences.contains(toKey(key))) {
            return decrypt(this.preferences.getString(toKey(key), ""));
        }
        return null;
    }

    public void clear() {
        this.preferences.edit().clear().commit();
    }

    private String toKey(String key) {
        if (this.encryptKeys) {
            return encrypt(key, this.writer);
        }
        return key;
    }

    private void putValue(String key, String value) throws NullPointerException {
        this.preferences.edit().putString(key, encrypt(value, this.writer)).commit();
    }

    /* access modifiers changed from: protected */
    public String encrypt(String value, Cipher writer2) throws NullPointerException {
        try {
            return Base64.encodeToString(convert(writer2, value.getBytes(CHARSET)), 2);
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    /* access modifiers changed from: protected */
    public String decrypt(String securedEncodedValue) {
        try {
            return new String(convert(this.reader, Base64.decode(securedEncodedValue, 2)), CHARSET);
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    private static byte[] convert(Cipher cipher, byte[] bs) throws NullPointerException {
        try {
            return cipher.doFinal(bs);
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }
}
