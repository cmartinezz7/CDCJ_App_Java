package com.google.android.libraries.places.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzq {
    private final String zza;
    private final int zzb;
    private final zzp zzc;
    private final boolean zzd;
    private final int zze;

    public zzq(WifiInfo wifiInfo, ScanResult scanResult) {
        this(wifiInfo, scanResult.BSSID, scanResult.capabilities, scanResult.level, scanResult.frequency);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzq(android.net.wifi.WifiInfo r7, java.lang.String r8, java.lang.String r9, int r10, int r11) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x0039
            java.lang.String r9 = r9.toUpperCase()
            java.lang.String r0 = "[ESS]"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0035
            java.lang.String r0 = "[IBSS]"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x001d
            goto L_0x0035
        L_0x001d:
            java.lang.String r0 = ".*WPA[0-9]*-PSK.*"
            boolean r0 = r9.matches(r0)
            if (r0 == 0) goto L_0x0029
            com.google.android.libraries.places.internal.zzp r9 = com.google.android.libraries.places.internal.zzp.PSK
            r3 = r9
            goto L_0x003c
        L_0x0029:
            java.lang.String r0 = ".*WPA[0-9]*-EAP.*"
            boolean r9 = r9.matches(r0)
            if (r9 == 0) goto L_0x0039
            com.google.android.libraries.places.internal.zzp r9 = com.google.android.libraries.places.internal.zzp.EAP
            r3 = r9
            goto L_0x003c
        L_0x0035:
            com.google.android.libraries.places.internal.zzp r9 = com.google.android.libraries.places.internal.zzp.NONE
            r3 = r9
            goto L_0x003c
        L_0x0039:
            com.google.android.libraries.places.internal.zzp r9 = com.google.android.libraries.places.internal.zzp.OTHER
            r3 = r9
        L_0x003c:
            if (r7 == 0) goto L_0x0052
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x0052
            java.lang.String r7 = r7.getBSSID()
            boolean r7 = r8.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0052
            r7 = 1
            goto L_0x0053
        L_0x0052:
            r7 = 0
        L_0x0053:
            r4 = r7
            r0 = r6
            r1 = r8
            r2 = r10
            r5 = r11
            r0.<init>((java.lang.String) r1, (int) r2, (com.google.android.libraries.places.internal.zzp) r3, (boolean) r4, (int) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzq.<init>(android.net.wifi.WifiInfo, java.lang.String, java.lang.String, int, int):void");
    }

    private zzq(String str, int i, zzp zzp, boolean z, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = zzp;
        this.zzd = z;
        this.zze = i2;
    }

    public final String zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzp zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzd;
    }

    public final int zze() {
        return this.zze;
    }
}
