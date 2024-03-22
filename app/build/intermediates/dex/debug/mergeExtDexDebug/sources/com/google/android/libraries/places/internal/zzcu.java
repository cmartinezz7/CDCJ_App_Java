package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.pm.PackageManager;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzcu {
    private final String zza;
    private final String zzb;
    private final int zzc;

    public zzcu(Context context) {
        String packageName = context.getPackageName();
        this.zza = packageName;
        this.zzb = zzcs.zza(context.getPackageManager(), packageName);
        this.zzc = zza(context);
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzc;
    }

    private final int zza(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(this.zza, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }
}
