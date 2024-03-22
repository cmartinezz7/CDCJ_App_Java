package es.santander.justicia.utils.safetynet;

import android.util.Log;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SafetyNetResponse {
    private static final String TAG = SafetyNetResponse.class.getSimpleName();
    private String[] apkCertificateDigestSha256;
    private String apkDigestSha256;
    private String apkPackageName;
    private boolean basicIntegrity;
    private boolean ctsProfileMatch;
    private String nonce;
    private long timestampMs;

    private SafetyNetResponse() {
    }

    public String getNonce() {
        return this.nonce;
    }

    public long getTimestampMs() {
        return this.timestampMs;
    }

    public String getApkPackageName() {
        return this.apkPackageName;
    }

    public String[] getApkCertificateDigestSha256() {
        return this.apkCertificateDigestSha256;
    }

    public String getApkDigestSha256() {
        return this.apkDigestSha256;
    }

    public boolean isCtsProfileMatch() {
        return this.ctsProfileMatch;
    }

    public boolean isBasicIntegrity() {
        return this.basicIntegrity;
    }

    public static SafetyNetResponse parse(String decodedJWTPayload) {
        JSONArray jsonArray;
        Log.d(TAG, "decodedJWTPayload json:" + decodedJWTPayload);
        SafetyNetResponse response = new SafetyNetResponse();
        try {
            JSONObject root = new JSONObject(decodedJWTPayload);
            if (root.has("nonce")) {
                response.nonce = root.getString("nonce");
            }
            if (root.has("apkCertificateDigestSha256") && (jsonArray = root.getJSONArray("apkCertificateDigestSha256")) != null) {
                String[] certDigests = new String[jsonArray.length()];
                for (int i = 0; i < jsonArray.length(); i++) {
                    certDigests[i] = jsonArray.getString(i);
                }
                response.apkCertificateDigestSha256 = certDigests;
            }
            if (root.has("apkDigestSha256")) {
                response.apkDigestSha256 = root.getString("apkDigestSha256");
            }
            if (root.has("apkPackageName")) {
                response.apkPackageName = root.getString("apkPackageName");
            }
            if (root.has("basicIntegrity")) {
                response.basicIntegrity = root.getBoolean("basicIntegrity");
            }
            if (root.has("ctsProfileMatch")) {
                response.ctsProfileMatch = root.getBoolean("ctsProfileMatch");
            }
            if (root.has("timestampMs")) {
                response.timestampMs = root.getLong("timestampMs");
            }
            return response;
        } catch (JSONException e) {
            Log.e(TAG, "problem parsing decodedJWTPayload:" + e.getMessage(), e);
            return null;
        }
    }

    public String toString() {
        return "SafetyNetResponse{nonce='" + this.nonce + '\'' + ", timestampMs=" + this.timestampMs + ", apkPackageName='" + this.apkPackageName + '\'' + ", apkCertificateDigestSha256=" + Arrays.toString(this.apkCertificateDigestSha256) + ", apkDigestSha256='" + this.apkDigestSha256 + '\'' + ", ctsProfileMatch=" + this.ctsProfileMatch + ", basicIntegrity=" + this.basicIntegrity + '}';
    }
}
