package com.google.android.libraries.places.internal;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzw {
    static ApiException zza(VolleyError volleyError) {
        int i;
        if (volleyError instanceof NetworkError) {
            i = 7;
        } else if (volleyError instanceof TimeoutError) {
            i = 15;
        } else if ((volleyError instanceof ServerError) || (volleyError instanceof ParseError)) {
            i = 8;
        } else if (volleyError instanceof AuthFailureError) {
            i = 9011;
        } else {
            i = 13;
        }
        return new ApiException(new Status(i, String.format("Unexpected server error (HTTP Code: %s. Message: %s.)", new Object[]{volleyError.networkResponse == null ? "N/A" : String.valueOf(volleyError.networkResponse.statusCode), volleyError})));
    }
}
