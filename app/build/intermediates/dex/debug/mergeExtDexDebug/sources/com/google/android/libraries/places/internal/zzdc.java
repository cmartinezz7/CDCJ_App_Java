package com.google.android.libraries.places.internal;

import android.content.Context;
import android.os.DropBoxManager;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzdc {
    private static DropBoxManager zza;
    private static final LinkedHashMap<Long, Integer> zzb = new zzde(16, 0.75f, true);
    private static String zzc;

    public static synchronized void zza(Context context, boolean z) {
        synchronized (zzdc.class) {
            if (zza == null) {
                zza = (DropBoxManager) context.getApplicationContext().getSystemService("dropbox");
                zzc = "com.google.android.libraries.places";
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x008c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void zza(java.lang.Throwable r15) {
        /*
            java.lang.Class<com.google.android.libraries.places.internal.zzdc> r0 = com.google.android.libraries.places.internal.zzdc.class
            monitor-enter(r0)
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x008d }
            long r1 = r1.getId()     // Catch:{ all -> 0x008d }
            int r3 = r15.hashCode()     // Catch:{ all -> 0x008d }
            java.util.LinkedHashMap<java.lang.Long, java.lang.Integer> r4 = zzb     // Catch:{ all -> 0x008d }
            java.lang.Long r5 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x008d }
            java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x008d }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x008d }
            if (r5 == 0) goto L_0x0025
            int r5 = r5.intValue()     // Catch:{ all -> 0x008d }
            if (r5 != r3) goto L_0x0025
            monitor-exit(r0)
            return
        L_0x0025:
            android.os.DropBoxManager r5 = zza     // Catch:{ all -> 0x008d }
            if (r5 == 0) goto L_0x008b
            java.lang.String r6 = "system_app_crash"
            boolean r5 = r5.isTagEnabled(r6)     // Catch:{ all -> 0x008d }
            if (r5 == 0) goto L_0x008b
            android.os.DropBoxManager r5 = zza     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "system_app_crash"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r7.<init>()     // Catch:{ all -> 0x008d }
            java.lang.String r8 = "2.0.0"
            java.lang.String r9 = "Package: %s v%d (%s)\n"
            r10 = 3
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x008d }
            java.lang.String r11 = zzc     // Catch:{ all -> 0x008d }
            r12 = 0
            r10[r12] = r11     // Catch:{ all -> 0x008d }
            long r13 = zza((java.lang.String) r8)     // Catch:{ all -> 0x008d }
            java.lang.Long r11 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x008d }
            r13 = 1
            r10[r13] = r11     // Catch:{ all -> 0x008d }
            r11 = 2
            r10[r11] = r8     // Catch:{ all -> 0x008d }
            java.lang.String r8 = java.lang.String.format(r9, r10)     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r8 = r7.append(r8)     // Catch:{ all -> 0x008d }
            java.lang.String r9 = "Build: %s\n"
            java.lang.Object[] r10 = new java.lang.Object[r13]     // Catch:{ all -> 0x008d }
            java.lang.String r11 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x008d }
            r10[r12] = r11     // Catch:{ all -> 0x008d }
            java.lang.String r9 = java.lang.String.format(r9, r10)     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x008d }
            java.lang.String r9 = "\n"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x008d }
            java.lang.String r15 = android.util.Log.getStackTraceString(r15)     // Catch:{ all -> 0x008d }
            r8.append(r15)     // Catch:{ all -> 0x008d }
            java.lang.String r15 = r7.toString()     // Catch:{ all -> 0x008d }
            r5.addText(r6, r15)     // Catch:{ all -> 0x008d }
            java.lang.Long r15 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x008d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x008d }
            r4.put(r15, r1)     // Catch:{ all -> 0x008d }
        L_0x008b:
            monitor-exit(r0)
            return
        L_0x008d:
            r15 = move-exception
            monitor-exit(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzdc.zza(java.lang.Throwable):void");
    }

    private static long zza(String str) {
        List<String> zza2 = zzgi.zza(zzft.zza('.')).zza((CharSequence) str);
        if (zza2.size() != 3) {
            return -1;
        }
        long j = 0;
        int i = 0;
        while (i < zza2.size()) {
            try {
                j = (j * 100) + ((long) Integer.parseInt(zza2.get(i)));
                i++;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return j;
    }
}
