package es.santander.justicia.utils.safetynet;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import es.santander.justicia.utils.safetynet.AndroidDeviceVerifier;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class SafetyNetHelper implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static int MAX_TIMESTAMP_DURATION = 120000;
    public static final int RESPONSE_ERROR_VALIDATING_SIGNATURE = 1000;
    public static final int RESPONSE_FAILED_SIGNATURE_VALIDATION = 1002;
    public static final int RESPONSE_FAILED_SIGNATURE_VALIDATION_NO_API_KEY = 1003;
    public static final int RESPONSE_VALIDATION_FAILED = 1001;
    public static final int SAFETY_NET_API_REQUEST_UNSUCCESSFUL = 999;
    /* access modifiers changed from: private */
    public static final String TAG = SafetyNetHelper.class.getSimpleName();
    private List<String> apkCertificateDigests;
    private String apkDigest;
    /* access modifiers changed from: private */
    public SafetyNetWrapperCallback callback;
    private GoogleApiClient googleApiClient;
    /* access modifiers changed from: private */
    public String googleDeviceVerificationApiKey;
    /* access modifiers changed from: private */
    public SafetyNetResponse lastResponse;
    private String packageName;
    private byte[] requestNonce;
    private long requestTimestamp;
    private final SecureRandom secureRandom = new SecureRandom();

    public interface SafetyNetWrapperCallback {
        void error(int i, String str);

        void success(boolean z, boolean z2);
    }

    public SafetyNetHelper(String googleDeviceVerificationApiKey2) {
        if (TextUtils.isEmpty(googleDeviceVerificationApiKey2)) {
            Log.w(TAG, "Google Device Verification Api Key not defined, cannot properly validate safety net response without it. See https://developer.android.com/google/play/safetynet/start.html#verify-compat-check");
        }
        this.googleDeviceVerificationApiKey = googleDeviceVerificationApiKey2;
    }

    private synchronized void buildGoogleApiClient(Context context) {
        this.googleApiClient = new GoogleApiClient.Builder(context).addApi(SafetyNet.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
    }

    public void requestTest(Context context, SafetyNetWrapperCallback safetyNetWrapperCallback) {
        buildGoogleApiClient(context);
        this.googleApiClient.connect();
        String packageName2 = context.getPackageName();
        this.packageName = packageName2;
        this.callback = safetyNetWrapperCallback;
        this.apkCertificateDigests = Utils.calcApkCertificateDigests(context, packageName2);
        String str = TAG;
        Log.d(str, "apkCertificateDigests:" + this.apkCertificateDigests);
        this.apkDigest = Utils.calcApkDigest(context);
        Log.d(str, "apkDigest:" + this.apkDigest);
    }

    public void onConnected(Bundle bundle) {
        Log.v(TAG, "Google play services connected");
        runSaftyNetTest();
    }

    private void runSaftyNetTest() {
        Log.v(TAG, "running SafetyNet.API Test");
        this.requestNonce = generateOneTimeRequestNonce();
        this.requestTimestamp = System.currentTimeMillis();
        SafetyNet.SafetyNetApi.attest(this.googleApiClient, this.requestNonce).setResultCallback(new ResultCallback<SafetyNetApi.AttestationResult>() {
            public void onResult(SafetyNetApi.AttestationResult result) {
                if (SafetyNetHelper.this.validateResultStatus(result)) {
                    String jwsResult = result.getJwsResult();
                    final SafetyNetResponse response = SafetyNetHelper.this.parseJsonWebSignature(jwsResult);
                    SafetyNetResponse unused = SafetyNetHelper.this.lastResponse = response;
                    if (!response.isCtsProfileMatch() || !response.isBasicIntegrity()) {
                        SafetyNetHelper.this.callback.success(response.isCtsProfileMatch(), response.isBasicIntegrity());
                    } else if (!SafetyNetHelper.this.validateSafetyNetResponsePayload(response)) {
                        SafetyNetHelper.this.callback.error(1001, "Response payload validation failed");
                    } else if (!TextUtils.isEmpty(SafetyNetHelper.this.googleDeviceVerificationApiKey)) {
                        new AndroidDeviceVerifier(SafetyNetHelper.this.googleDeviceVerificationApiKey, jwsResult).verify(new AndroidDeviceVerifier.AndroidDeviceVerifierCallback() {
                            public void error(String errorMsg) {
                                SafetyNetHelper.this.callback.error(1000, "Response signature validation error: " + errorMsg);
                            }

                            public void success(boolean isValidSignature) {
                                if (isValidSignature) {
                                    SafetyNetHelper.this.callback.success(response.isCtsProfileMatch(), response.isBasicIntegrity());
                                } else {
                                    SafetyNetHelper.this.callback.error(1002, "Response signature invalid");
                                }
                            }
                        });
                    } else {
                        Log.w(SafetyNetHelper.TAG, "No google Device Verification ApiKey defined");
                        SafetyNetHelper.this.callback.error(SafetyNetHelper.RESPONSE_FAILED_SIGNATURE_VALIDATION_NO_API_KEY, "No Google Device Verification ApiKey defined. Marking as failed. SafetyNet CtsProfileMatch: " + response.isCtsProfileMatch());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean validateResultStatus(SafetyNetApi.AttestationResult result) {
        boolean isSuccess = result.getStatus().isSuccess();
        if (!isSuccess) {
            this.callback.error(SAFETY_NET_API_REQUEST_UNSUCCESSFUL, "Call to SafetyNetApi.attest was not successful");
        }
        return isSuccess;
    }

    public SafetyNetResponse getLastResponse() {
        return this.lastResponse;
    }

    /* access modifiers changed from: private */
    public boolean validateSafetyNetResponsePayload(SafetyNetResponse response) {
        if (response == null) {
            Log.e(TAG, "SafetyNetResponse is null.");
            return false;
        }
        String requestNonceBase64 = Base64.encodeToString(this.requestNonce, 0).trim();
        if (!requestNonceBase64.equals(response.getNonce())) {
            String str = TAG;
            Log.e(str, "invalid nonce, expected = \"" + requestNonceBase64 + "\"");
            Log.e(str, "invalid nonce, response   = \"" + response.getNonce() + "\"");
            return false;
        } else if (!this.packageName.equalsIgnoreCase(response.getApkPackageName())) {
            String str2 = TAG;
            Log.e(str2, "invalid packageName, expected = \"" + this.packageName + "\"");
            Log.e(str2, "invalid packageName, response = \"" + response.getApkPackageName() + "\"");
            return false;
        } else {
            long durationOfReq = response.getTimestampMs() - this.requestTimestamp;
            if (durationOfReq > ((long) MAX_TIMESTAMP_DURATION)) {
                Log.e(TAG, "Duration calculated from the timestamp of response \"" + durationOfReq + " \" exceeds permitted duration of \"" + MAX_TIMESTAMP_DURATION + "\"");
                return false;
            } else if (!Arrays.equals(this.apkCertificateDigests.toArray(), response.getApkCertificateDigestSha256())) {
                String str3 = TAG;
                Log.e(str3, "invalid apkCertificateDigest, local/expected = " + Arrays.asList(new List[]{this.apkCertificateDigests}));
                Log.e(str3, "invalid apkCertificateDigest, response = " + Arrays.asList(response.getApkCertificateDigestSha256()));
                return false;
            } else if (this.apkDigest.equals(response.getApkDigestSha256())) {
                return true;
            } else {
                String str4 = TAG;
                Log.e(str4, "invalid ApkDigest, local/expected = \"" + this.apkDigest + "\"");
                Log.e(str4, "invalid ApkDigest, response = \"" + response.getApkDigestSha256() + "\"");
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    public SafetyNetResponse parseJsonWebSignature(String jwsResult) {
        if (jwsResult == null) {
            return null;
        }
        String[] jwtParts = jwsResult.split("\\.");
        if (jwtParts.length == 3) {
            return SafetyNetResponse.parse(new String(Base64.decode(jwtParts[1], 0)));
        }
        return null;
    }

    private byte[] generateOneTimeRequestNonce() {
        byte[] nonce = new byte[32];
        this.secureRandom.nextBytes(nonce);
        return nonce;
    }

    public void onConnectionSuspended(int i) {
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.callback.error(connectionResult.getErrorCode(), "Google Play services connection failed");
    }
}
