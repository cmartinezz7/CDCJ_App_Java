package es.santander.justicia.utils.safetynet;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Utils {
    public static final int BUFFER_SIZE = 2048;
    private static final String TAG = Utils.class.getSimpleName();
    private static final String alg = "AES";
    private static final String cI = "AES/CBC/PKCS5Padding";

    public static byte[] hash(String input) {
        if (TextUtils.isEmpty(input)) {
            return null;
        }
        try {
            return hash(input.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "problem hashing \"" + input + "\" " + e.getMessage(), e);
            return null;
        }
    }

    public static byte[] hash(byte[] input) {
        if (input != null) {
            try {
                byte[] hashedBytes = input;
                MessageDigest.getInstance("SHA-256").update(hashedBytes, 0, hashedBytes.length);
                return hashedBytes;
            } catch (NoSuchAlgorithmException e) {
                Log.e(TAG, "problem hashing \"" + input + "\" " + e.getMessage(), e);
                return null;
            }
        } else {
            Log.w(TAG, "hash called with null input byte[]");
            return null;
        }
    }

    public static String getSigningKeyFingerprint(Context ctx) {
        try {
            return byte2HexFormatted(MessageDigest.getInstance("SHA256").digest(getSigningKeyCertificate(ctx)));
        } catch (Exception e) {
            Log.w(TAG, e);
            return null;
        }
    }

    private static byte[] getSigningKeyCertificate(Context ctx) {
        try {
            Signature[] signatures = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 64).signatures;
            if (signatures == null || signatures.length < 1) {
                return null;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signatures[0].toByteArray()))).getEncoded();
        } catch (Exception e) {
            Log.w(TAG, e);
            return null;
        }
    }

    private static String byte2HexFormatted(byte[] arr) {
        StringBuilder str = new StringBuilder(arr.length * 2);
        for (int i = 0; i < arr.length; i++) {
            String h = Integer.toHexString(arr[i]);
            int l = h.length();
            if (l == 1) {
                h = "0" + h;
            }
            if (l > 2) {
                h = h.substring(l - 2, l);
            }
            str.append(h.toUpperCase());
            if (i < arr.length - 1) {
                str.append(':');
            }
        }
        return str.toString();
    }

    public static List<String> calcApkCertificateDigests(Context context, String packageName) {
        List<String> encodedSignatures = new ArrayList<>();
        try {
            for (Signature signature : context.getPackageManager().getPackageInfo(packageName, 64).signatures) {
                try {
                    MessageDigest md = MessageDigest.getInstance("SHA-256");
                    md.update(signature.toByteArray());
                    encodedSignatures.add(Base64.encodeToString(md.digest(), 2));
                } catch (NoSuchAlgorithmException e) {
                    Log.e(TAG, "NoSuchAlgorithmException" + e.getMessage(), e);
                }
            }
            return encodedSignatures;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(TAG, "getPackageInfo \"64\" " + e2.getMessage(), e2);
            return encodedSignatures;
        }
    }

    public static String calcApkDigest(Context context) {
        return Base64.encodeToString(getApkFileDigest(context), 2);
    }

    private static long getApkFileChecksum(Context context) {
        String str;
        StringBuilder sb;
        Long chksum = null;
        FileInputStream fis = null;
        CheckedInputStream cis = null;
        try {
            FileInputStream fis2 = new FileInputStream(new File(context.getPackageCodePath()));
            CRC32 chk = new CRC32();
            CheckedInputStream cis2 = new CheckedInputStream(fis2, chk);
            while (cis2.read(new byte[80]) >= 0) {
            }
            chksum = Long.valueOf(chk.getValue());
            try {
                fis2.close();
                cis2.close();
            } catch (IOException e) {
                e = e;
                str = TAG;
                sb = new StringBuilder();
            }
        } catch (Exception e2) {
            Log.e(TAG, "getApkFileChecksum Exception" + e2.getMessage(), e2);
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e3) {
                    e = e3;
                    str = TAG;
                    sb = new StringBuilder();
                    Log.e(str, sb.append("getApkFileChecksum close streams").append(e.getMessage()).toString(), e);
                    return chksum.longValue();
                }
            }
            if (cis != null) {
                cis.close();
            }
        } catch (Throwable th) {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e4) {
                    Log.e(TAG, "getApkFileChecksum close streams" + e4.getMessage(), e4);
                    throw th;
                }
            }
            if (cis != null) {
                cis.close();
            }
            throw th;
        }
        return chksum.longValue();
    }

    private static byte[] getApkFileDigest(Context context) {
        FileInputStream fis = null;
        try {
            FileInputStream fis2 = new FileInputStream(context.getPackageCodePath());
            byte[] digest = getDigest(fis2, "SHA-256");
            try {
                fis2.close();
            } catch (IOException e) {
                Log.e(TAG, "getApkFileDigest close streams" + e.getMessage(), e);
            }
            return digest;
        } catch (Throwable th) {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e2) {
                    Log.e(TAG, "getApkFileDigest close streams" + e2.getMessage(), e2);
                }
            }
            throw th;
        }
    }

    public static byte[] getDigest(InputStream in, String algorithm) throws Throwable {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        try {
            DigestInputStream dis = new DigestInputStream(in, md);
            while (dis.read(new byte[BUFFER_SIZE]) != -1) {
            }
            dis.close();
            return md.digest();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    Log.e(TAG, "getDigest close streams" + e.getMessage(), e);
                }
            }
        }
    }

    public static String encrypt(String key, String iv, String cleartext) {
        try {
            Cipher cipher = Cipher.getInstance(cI);
            cipher.init(1, new SecretKeySpec(key.getBytes(), alg), new IvParameterSpec(iv.getBytes()));
            return new String(org.apache.commons.codec.binary.Base64.encodeBase64(cipher.doFinal(cleartext.getBytes())));
        } catch (Exception e) {
            Log.e("Utils", "Error encrypt", e);
            return null;
        }
    }

    public static String decrypt(String key, String iv, String encrypted) {
        try {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = org.apache.commons.codec.binary.Base64.decodeBase64(encrypted.getBytes());
            cipher.init(2, skeySpec, ivParameterSpec);
            return new String(cipher.doFinal(enc));
        } catch (Exception e) {
            Log.e("Utils", "Error decrypt", e);
            return null;
        }
    }
}
