package com.google.android.libraries.places.internal;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzct {
    public static ClearcutLogger zza(Context context) {
        return (ClearcutLogger) zzun.zza(ClearcutLogger.anonymousLogger(context, "LE"), "Cannot return null from a non-@Nullable @Provides method");
    }
}
