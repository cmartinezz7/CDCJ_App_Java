package com.google.android.libraries.places.internal;

import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.santander.globile.mobisec.securekeyboard.keyboard.SanKeyboard;
import com.santander.globile.uicomponents.calendar.utils.CalendarConstantsKt;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import net.sqlcipher.IBulkCursor;
import org.kxml2.wap.Wbxml;
import sun.misc.Unsafe;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzsq<T> implements zzsz<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zztx.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzsm zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzsr zzo;
    private final zzrv zzp;
    private final zztr<?, ?> zzq;
    private final zzqr<?> zzr;
    private final zzsf zzs;

    private zzsq(int[] iArr, Object[] objArr, int i, int i2, zzsm zzsm, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzsr zzsr, zzrv zzrv, zztr<?, ?> zztr, zzqr<?> zzqr, zzsf zzsf) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzsm instanceof zzrb;
        this.zzj = z;
        this.zzh = zzqr != null && zzqr.zza(zzsm);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzsr;
        this.zzp = zzrv;
        this.zzq = zztr;
        this.zzr = zzqr;
        this.zzg = zzsm;
        this.zzs = zzsf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.libraries.places.internal.zzsq<T> zza(java.lang.Class<T> r36, com.google.android.libraries.places.internal.zzsk r37, com.google.android.libraries.places.internal.zzsr r38, com.google.android.libraries.places.internal.zzrv r39, com.google.android.libraries.places.internal.zztr<?, ?> r40, com.google.android.libraries.places.internal.zzqr<?> r41, com.google.android.libraries.places.internal.zzsf r42) {
        /*
            r0 = r37
            boolean r1 = r0 instanceof com.google.android.libraries.places.internal.zzta
            if (r1 == 0) goto L_0x0460
            com.google.android.libraries.places.internal.zzta r0 = (com.google.android.libraries.places.internal.zzta) r0
            int r1 = r0.zza()
            int r2 = com.google.android.libraries.places.internal.zzrb.zzc.zzi
            r3 = 0
            if (r1 != r2) goto L_0x0013
            r11 = 1
            goto L_0x0014
        L_0x0013:
            r11 = r3
        L_0x0014:
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r7) goto L_0x003e
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r8 = 1
            r9 = 13
        L_0x002b:
            int r10 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x003b
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r5 = r5 | r8
            int r9 = r9 + 13
            r8 = r10
            goto L_0x002b
        L_0x003b:
            int r8 = r8 << r9
            r5 = r5 | r8
            goto L_0x003f
        L_0x003e:
            r10 = 1
        L_0x003f:
            int r8 = r10 + 1
            char r9 = r1.charAt(r10)
            if (r9 < r7) goto L_0x005f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x004c:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x005c
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x004c
        L_0x005c:
            int r8 = r8 << r10
            r9 = r9 | r8
            r8 = r12
        L_0x005f:
            if (r9 != 0) goto L_0x0073
            int[] r9 = zza
            r6 = r3
            r10 = r6
            r12 = r10
            r13 = r12
            r15 = r13
            r14 = r9
            r9 = r15
            goto L_0x019b
        L_0x0073:
            int r9 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x007f:
            int r12 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r7) goto L_0x008f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r8 = r8 | r9
            int r10 = r10 + 13
            r9 = r12
            goto L_0x007f
        L_0x008f:
            int r9 = r9 << r10
            r8 = r8 | r9
            r9 = r12
        L_0x0092:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r7) goto L_0x00b2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x009f:
            int r13 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r7) goto L_0x00af
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r12
            r9 = r9 | r10
            int r12 = r12 + 13
            r10 = r13
            goto L_0x009f
        L_0x00af:
            int r10 = r10 << r12
            r9 = r9 | r10
            r10 = r13
        L_0x00b2:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r7) goto L_0x00d2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00bf:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r7) goto L_0x00cf
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r10 = r10 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00bf
        L_0x00cf:
            int r12 = r12 << r13
            r10 = r10 | r12
            r12 = r14
        L_0x00d2:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r7) goto L_0x00f2
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00df:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r7) goto L_0x00ef
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00df
        L_0x00ef:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00f2:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r7) goto L_0x0114
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x00ff:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r7) goto L_0x0110
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x00ff
        L_0x0110:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0114:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r7) goto L_0x0138
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0121:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0133
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0121
        L_0x0133:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0138:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x015f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r3 = r16
            r16 = 13
        L_0x0147:
            int r17 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x0159
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r16
            r15 = r15 | r3
            int r16 = r16 + 13
            r3 = r17
            goto L_0x0147
        L_0x0159:
            int r3 = r3 << r16
            r15 = r15 | r3
            r3 = r17
            goto L_0x0161
        L_0x015f:
            r3 = r16
        L_0x0161:
            int r16 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x0187
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r6 = r16
            r16 = 13
        L_0x0170:
            int r17 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 < r7) goto L_0x0182
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r16
            r3 = r3 | r6
            int r16 = r16 + 13
            r6 = r17
            goto L_0x0170
        L_0x0182:
            int r6 = r6 << r16
            r3 = r3 | r6
            r16 = r17
        L_0x0187:
            int r6 = r3 + r14
            int r6 = r6 + r15
            int[] r6 = new int[r6]
            int r15 = r8 << 1
            int r15 = r15 + r9
            r9 = r12
            r12 = r15
            r15 = r3
            r3 = r8
            r8 = r16
            r35 = r14
            r14 = r6
            r6 = r35
        L_0x019b:
            sun.misc.Unsafe r7 = zzb
            java.lang.Object[] r17 = r0.zze()
            com.google.android.libraries.places.internal.zzsm r18 = r0.zzc()
            java.lang.Class r4 = r18.getClass()
            r18 = r8
            int r8 = r13 * 3
            int[] r8 = new int[r8]
            r19 = 1
            int r13 = r13 << 1
            java.lang.Object[] r13 = new java.lang.Object[r13]
            int r20 = r15 + r6
            r22 = r15
            r6 = r18
            r23 = r20
            r18 = 0
            r21 = 0
        L_0x01c3:
            if (r6 >= r2) goto L_0x0437
            int r24 = r6 + 1
            char r6 = r1.charAt(r6)
            r25 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r2) goto L_0x01f7
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r2 = r24
            r24 = 13
        L_0x01d8:
            int r26 = r2 + 1
            char r2 = r1.charAt(r2)
            r27 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r15) goto L_0x01f1
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r24
            r6 = r6 | r2
            int r24 = r24 + 13
            r2 = r26
            r15 = r27
            goto L_0x01d8
        L_0x01f1:
            int r2 = r2 << r24
            r6 = r6 | r2
            r2 = r26
            goto L_0x01fb
        L_0x01f7:
            r27 = r15
            r2 = r24
        L_0x01fb:
            int r15 = r2 + 1
            char r2 = r1.charAt(r2)
            r24 = r15
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r15) goto L_0x022e
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r15 = r24
            r24 = 13
        L_0x020f:
            int r26 = r15 + 1
            char r15 = r1.charAt(r15)
            r28 = r11
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r11) goto L_0x0228
            r11 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r24
            r2 = r2 | r11
            int r24 = r24 + 13
            r15 = r26
            r11 = r28
            goto L_0x020f
        L_0x0228:
            int r11 = r15 << r24
            r2 = r2 | r11
            r15 = r26
            goto L_0x0232
        L_0x022e:
            r28 = r11
            r15 = r24
        L_0x0232:
            r11 = r2 & 255(0xff, float:3.57E-43)
            r24 = r9
            r9 = r2 & 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x0241
            int r9 = r18 + 1
            r14[r18] = r21
            r18 = r9
        L_0x0241:
            r9 = 51
            r30 = r10
            if (r11 < r9) goto L_0x02eb
            int r9 = r15 + 1
            char r15 = r1.charAt(r15)
            r10 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r10) goto L_0x0270
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r32 = 13
        L_0x0256:
            int r33 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r10) goto L_0x026b
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r32
            r15 = r15 | r9
            int r32 = r32 + 13
            r9 = r33
            r10 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0256
        L_0x026b:
            int r9 = r9 << r32
            r15 = r15 | r9
            r9 = r33
        L_0x0270:
            int r10 = r11 + -51
            r32 = r9
            r9 = 9
            if (r10 == r9) goto L_0x0296
            r9 = 17
            if (r10 != r9) goto L_0x027e
            goto L_0x0296
        L_0x027e:
            r9 = 12
            if (r10 != r9) goto L_0x0294
            r9 = r5 & 1
            r10 = 1
            if (r9 != r10) goto L_0x0294
            int r9 = r21 / 3
            int r9 = r9 << r10
            int r9 = r9 + r10
            int r10 = r12 + 1
            r12 = r17[r12]
            r13[r9] = r12
            r12 = r10
            r10 = 1
            goto L_0x02a3
        L_0x0294:
            r10 = 1
            goto L_0x02a3
        L_0x0296:
            int r9 = r21 / 3
            r10 = 1
            int r9 = r9 << r10
            int r9 = r9 + r10
            int r19 = r12 + 1
            r12 = r17[r12]
            r13[r9] = r12
            r12 = r19
        L_0x02a3:
            int r9 = r15 << 1
            r10 = r17[r9]
            boolean r15 = r10 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x02ae
            java.lang.reflect.Field r10 = (java.lang.reflect.Field) r10
            goto L_0x02b6
        L_0x02ae:
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = zza((java.lang.Class<?>) r4, (java.lang.String) r10)
            r17[r9] = r10
        L_0x02b6:
            r33 = r0
            r34 = r1
            long r0 = r7.objectFieldOffset(r10)
            int r0 = (int) r0
            int r9 = r9 + 1
            r1 = r17[r9]
            boolean r10 = r1 instanceof java.lang.reflect.Field
            if (r10 == 0) goto L_0x02ca
            java.lang.reflect.Field r1 = (java.lang.reflect.Field) r1
            goto L_0x02d2
        L_0x02ca:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.reflect.Field r1 = zza((java.lang.Class<?>) r4, (java.lang.String) r1)
            r17[r9] = r1
        L_0x02d2:
            long r9 = r7.objectFieldOffset(r1)
            int r1 = (int) r9
            r19 = r4
            r31 = r12
            r15 = r32
            r10 = r34
            r12 = 0
            r16 = 1
            r4 = r1
            r1 = r0
            r0 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x03fe
        L_0x02eb:
            r33 = r0
            r34 = r1
            int r0 = r12 + 1
            r1 = r17[r12]
            java.lang.String r1 = (java.lang.String) r1
            java.lang.reflect.Field r1 = zza((java.lang.Class<?>) r4, (java.lang.String) r1)
            r9 = 49
            r10 = 9
            if (r11 == r10) goto L_0x0368
            r10 = 17
            if (r11 != r10) goto L_0x0306
            r12 = 1
            goto L_0x0369
        L_0x0306:
            r10 = 27
            if (r11 == r10) goto L_0x035a
            if (r11 != r9) goto L_0x030d
            goto L_0x035a
        L_0x030d:
            r10 = 12
            if (r11 == r10) goto L_0x0346
            r10 = 30
            if (r11 == r10) goto L_0x0346
            r10 = 44
            if (r11 != r10) goto L_0x031a
            goto L_0x0346
        L_0x031a:
            r10 = 50
            if (r11 != r10) goto L_0x0344
            int r10 = r22 + 1
            r14[r22] = r21
            int r12 = r21 / 3
            r19 = 1
            int r12 = r12 << 1
            int r22 = r0 + 1
            r0 = r17[r0]
            r13[r12] = r0
            r0 = r2 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x033e
            int r12 = r12 + 1
            int r0 = r22 + 1
            r22 = r17[r22]
            r13[r12] = r22
            r22 = r10
            r12 = 1
            goto L_0x0373
        L_0x033e:
            r0 = r22
            r12 = 1
            r22 = r10
            goto L_0x0373
        L_0x0344:
            r12 = 1
            goto L_0x0373
        L_0x0346:
            r10 = r5 & 1
            r12 = 1
            if (r10 != r12) goto L_0x0358
            int r10 = r21 / 3
            int r10 = r10 << r12
            int r10 = r10 + r12
            int r12 = r0 + 1
            r0 = r17[r0]
            r13[r10] = r0
            r0 = r12
            r12 = 1
            goto L_0x0373
        L_0x0358:
            r12 = 1
            goto L_0x0373
        L_0x035a:
            int r10 = r21 / 3
            r12 = 1
            int r10 = r10 << r12
            int r10 = r10 + r12
            int r19 = r0 + 1
            r0 = r17[r0]
            r13[r10] = r0
            r0 = r19
            goto L_0x0373
        L_0x0368:
            r12 = 1
        L_0x0369:
            int r10 = r21 / 3
            int r10 = r10 << r12
            int r10 = r10 + r12
            java.lang.Class r19 = r1.getType()
            r13[r10] = r19
        L_0x0373:
            long r9 = r7.objectFieldOffset(r1)
            int r1 = (int) r9
            r9 = r5 & 1
            if (r9 != r12) goto L_0x03e1
            r9 = 17
            if (r11 > r9) goto L_0x03d4
            int r9 = r15 + 1
            r10 = r34
            char r12 = r10.charAt(r15)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r12 < r15) goto L_0x03a8
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0391:
            int r29 = r9 + 1
            char r9 = r10.charAt(r9)
            if (r9 < r15) goto L_0x03a3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r16
            r12 = r12 | r9
            int r16 = r16 + 13
            r9 = r29
            goto L_0x0391
        L_0x03a3:
            int r9 = r9 << r16
            r12 = r12 | r9
            r9 = r29
        L_0x03a8:
            r16 = 1
            int r19 = r3 << 1
            int r29 = r12 / 32
            int r19 = r19 + r29
            r15 = r17[r19]
            r31 = r0
            boolean r0 = r15 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x03bc
            java.lang.reflect.Field r15 = (java.lang.reflect.Field) r15
            goto L_0x03c4
        L_0x03bc:
            java.lang.String r15 = (java.lang.String) r15
            java.lang.reflect.Field r15 = zza((java.lang.Class<?>) r4, (java.lang.String) r15)
            r17[r19] = r15
        L_0x03c4:
            r0 = r3
            r19 = r4
            long r3 = r7.objectFieldOffset(r15)
            int r3 = (int) r3
            int r12 = r12 % 32
            r4 = r3
            r15 = r9
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x03f0
        L_0x03d4:
            r31 = r0
            r0 = r3
            r19 = r4
            r10 = r34
            r3 = 55296(0xd800, float:7.7486E-41)
            r16 = 1
            goto L_0x03ed
        L_0x03e1:
            r31 = r0
            r0 = r3
            r19 = r4
            r16 = r12
            r10 = r34
            r3 = 55296(0xd800, float:7.7486E-41)
        L_0x03ed:
            r4 = 0
            r12 = 0
        L_0x03f0:
            r9 = 18
            if (r11 < r9) goto L_0x03fe
            r9 = 49
            if (r11 > r9) goto L_0x03fe
            int r9 = r23 + 1
            r14[r23] = r1
            r23 = r9
        L_0x03fe:
            int r9 = r21 + 1
            r8[r21] = r6
            int r6 = r9 + 1
            r3 = r2 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x040b
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x040c
        L_0x040b:
            r3 = 0
        L_0x040c:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0413
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0414
        L_0x0413:
            r2 = 0
        L_0x0414:
            r2 = r2 | r3
            int r3 = r11 << 20
            r2 = r2 | r3
            r1 = r1 | r2
            r8[r9] = r1
            int r21 = r6 + 1
            int r1 = r12 << 20
            r1 = r1 | r4
            r8[r6] = r1
            r3 = r0
            r1 = r10
            r6 = r15
            r4 = r19
            r9 = r24
            r2 = r25
            r15 = r27
            r11 = r28
            r10 = r30
            r12 = r31
            r0 = r33
            goto L_0x01c3
        L_0x0437:
            r33 = r0
            r24 = r9
            r30 = r10
            r28 = r11
            r27 = r15
            com.google.android.libraries.places.internal.zzsq r0 = new com.google.android.libraries.places.internal.zzsq
            com.google.android.libraries.places.internal.zzsm r10 = r33.zzc()
            r12 = 0
            r5 = r0
            r6 = r8
            r7 = r13
            r8 = r30
            r13 = r14
            r14 = r27
            r15 = r20
            r16 = r38
            r17 = r39
            r18 = r40
            r19 = r41
            r20 = r42
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x0460:
            com.google.android.libraries.places.internal.zzto r0 = (com.google.android.libraries.places.internal.zzto) r0
            int r0 = r0.zza()
            int r1 = com.google.android.libraries.places.internal.zzrb.zzc.zzi
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzsq.zza(java.lang.Class, com.google.android.libraries.places.internal.zzsk, com.google.android.libraries.places.internal.zzsr, com.google.android.libraries.places.internal.zzrv, com.google.android.libraries.places.internal.zztr, com.google.android.libraries.places.internal.zzqr, com.google.android.libraries.places.internal.zzsf):com.google.android.libraries.places.internal.zzsq");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            throw new RuntimeException(new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length()).append("Field ").append(str).append(" for ").append(name).append(" not found. Known fields are ").append(arrays).toString());
        }
    }

    public final boolean zza(T t, T t2) {
        int length = this.zzc.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzc2 = zzc(i);
                long j = (long) (zzc2 & 1048575);
                switch ((zzc2 & 267386880) >>> 20) {
                    case 0:
                        if (!zzc(t, t2, i) || Double.doubleToLongBits(zztx.zze(t, j)) != Double.doubleToLongBits(zztx.zze(t2, j))) {
                            z = false;
                            break;
                        }
                    case 1:
                        if (!zzc(t, t2, i) || Float.floatToIntBits(zztx.zzd(t, j)) != Float.floatToIntBits(zztx.zzd(t2, j))) {
                            z = false;
                            break;
                        }
                    case 2:
                        if (!zzc(t, t2, i) || zztx.zzb(t, j) != zztx.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 3:
                        if (!zzc(t, t2, i) || zztx.zzb(t, j) != zztx.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 4:
                        if (!zzc(t, t2, i) || zztx.zza((Object) t, j) != zztx.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 5:
                        if (!zzc(t, t2, i) || zztx.zzb(t, j) != zztx.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 6:
                        if (!zzc(t, t2, i) || zztx.zza((Object) t, j) != zztx.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 7:
                        if (!zzc(t, t2, i) || zztx.zzc(t, j) != zztx.zzc(t2, j)) {
                            z = false;
                            break;
                        }
                    case 8:
                        if (!zzc(t, t2, i) || !zztb.zza(zztx.zzf(t, j), zztx.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 9:
                        if (!zzc(t, t2, i) || !zztb.zza(zztx.zzf(t, j), zztx.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 10:
                        if (!zzc(t, t2, i) || !zztb.zza(zztx.zzf(t, j), zztx.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case IBulkCursor.RESPOND_TRANSACTION /*11*/:
                        if (!zzc(t, t2, i) || zztx.zza((Object) t, j) != zztx.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case IBulkCursor.CLOSE_TRANSACTION /*12*/:
                        if (!zzc(t, t2, i) || zztx.zza((Object) t, j) != zztx.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 13:
                        if (!zzc(t, t2, i) || zztx.zza((Object) t, j) != zztx.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 14:
                        if (!zzc(t, t2, i) || zztx.zzb(t, j) != zztx.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 15:
                        if (!zzc(t, t2, i) || zztx.zza((Object) t, j) != zztx.zza((Object) t2, j)) {
                            z = false;
                            break;
                        }
                    case 16:
                        if (!zzc(t, t2, i) || zztx.zzb(t, j) != zztx.zzb(t2, j)) {
                            z = false;
                            break;
                        }
                    case 17:
                        if (!zzc(t, t2, i) || !zztb.zza(zztx.zzf(t, j), zztx.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                    case 18:
                    case 19:
                    case HeatmapTileProvider.DEFAULT_RADIUS /*20*/:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case CalendarConstantsKt.MAX_CALENDAR_COLUMN /*42*/:
                    case 43:
                    case SanKeyboard.KEYCODE_DECIMAL_COMMA /*44*/:
                    case 45:
                    case SanKeyboard.KEYCODE_DECIMAL_POINT /*46*/:
                    case 47:
                    case 48:
                    case 49:
                        z = zztb.zza(zztx.zzf(t, j), zztx.zzf(t2, j));
                        break;
                    case 50:
                        z = zztb.zza(zztx.zzf(t, j), zztx.zzf(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /*60*/:
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case Wbxml.EXT_I_2 /*66*/:
                    case Wbxml.PI /*67*/:
                    case Wbxml.LITERAL_C /*68*/:
                        long zzd2 = (long) (zzd(i) & 1048575);
                        if (zztx.zza((Object) t, zzd2) != zztx.zza((Object) t2, zzd2) || !zztb.zza(zztx.zzf(t, j), zztx.zzf(t2, j))) {
                            z = false;
                            break;
                        }
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzq.zza(t).equals(this.zzq.zza(t2))) {
                return false;
            } else {
                if (this.zzh) {
                    return this.zzr.zza((Object) t).equals(this.zzr.zza((Object) t2));
                }
                return true;
            }
        }
    }

    public final int zza(T t) {
        int length = this.zzc.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzc2 = zzc(i2);
            int i3 = this.zzc[i2];
            long j = (long) (1048575 & zzc2);
            int i4 = 37;
            switch ((zzc2 & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzrd.zza(Double.doubleToLongBits(zztx.zze(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zztx.zzd(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzrd.zza(zztx.zzb(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzrd.zza(zztx.zzb(t, j));
                    break;
                case 4:
                    i = (i * 53) + zztx.zza((Object) t, j);
                    break;
                case 5:
                    i = (i * 53) + zzrd.zza(zztx.zzb(t, j));
                    break;
                case 6:
                    i = (i * 53) + zztx.zza((Object) t, j);
                    break;
                case 7:
                    i = (i * 53) + zzrd.zza(zztx.zzc(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zztx.zzf(t, j)).hashCode();
                    break;
                case 9:
                    Object zzf2 = zztx.zzf(t, j);
                    if (zzf2 != null) {
                        i4 = zzf2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zztx.zzf(t, j).hashCode();
                    break;
                case IBulkCursor.RESPOND_TRANSACTION /*11*/:
                    i = (i * 53) + zztx.zza((Object) t, j);
                    break;
                case IBulkCursor.CLOSE_TRANSACTION /*12*/:
                    i = (i * 53) + zztx.zza((Object) t, j);
                    break;
                case 13:
                    i = (i * 53) + zztx.zza((Object) t, j);
                    break;
                case 14:
                    i = (i * 53) + zzrd.zza(zztx.zzb(t, j));
                    break;
                case 15:
                    i = (i * 53) + zztx.zza((Object) t, j);
                    break;
                case 16:
                    i = (i * 53) + zzrd.zza(zztx.zzb(t, j));
                    break;
                case 17:
                    Object zzf3 = zztx.zzf(t, j);
                    if (zzf3 != null) {
                        i4 = zzf3.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case HeatmapTileProvider.DEFAULT_RADIUS /*20*/:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case CalendarConstantsKt.MAX_CALENDAR_COLUMN /*42*/:
                case 43:
                case SanKeyboard.KEYCODE_DECIMAL_COMMA /*44*/:
                case 45:
                case SanKeyboard.KEYCODE_DECIMAL_POINT /*46*/:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + zztx.zzf(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zztx.zzf(t, j).hashCode();
                    break;
                case 51:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzrd.zza(Double.doubleToLongBits(zzb(t, j)));
                        break;
                    }
                case 52:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + Float.floatToIntBits(zzc(t, j));
                        break;
                    }
                case 53:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzrd.zza(zze(t, j));
                        break;
                    }
                case 54:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzrd.zza(zze(t, j));
                        break;
                    }
                case 55:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 56:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzrd.zza(zze(t, j));
                        break;
                    }
                case 57:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 58:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzrd.zza(zzf(t, j));
                        break;
                    }
                case 59:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) zztx.zzf(t, j)).hashCode();
                        break;
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /*60*/:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zztx.zzf(t, j).hashCode();
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zztx.zzf(t, j).hashCode();
                        break;
                    }
                case 62:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 63:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 64:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case 65:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzrd.zza(zze(t, j));
                        break;
                    }
                case Wbxml.EXT_I_2 /*66*/:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzd(t, j);
                        break;
                    }
                case Wbxml.PI /*67*/:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzrd.zza(zze(t, j));
                        break;
                    }
                case Wbxml.LITERAL_C /*68*/:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zztx.zzf(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzq.zza(t).hashCode();
        if (this.zzh) {
            return (hashCode * 53) + this.zzr.zza((Object) t).hashCode();
        }
        return hashCode;
    }

    public final void zzb(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzc2 = zzc(i);
                long j = (long) (1048575 & zzc2);
                int i2 = this.zzc[i];
                switch ((zzc2 & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zze(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zzd(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zzc(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case IBulkCursor.RESPOND_TRANSACTION /*11*/:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case IBulkCursor.CLOSE_TRANSACTION /*12*/:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case HeatmapTileProvider.DEFAULT_RADIUS /*20*/:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case CalendarConstantsKt.MAX_CALENDAR_COLUMN /*42*/:
                    case 43:
                    case SanKeyboard.KEYCODE_DECIMAL_COMMA /*44*/:
                    case 45:
                    case SanKeyboard.KEYCODE_DECIMAL_POINT /*46*/:
                    case 47:
                    case 48:
                    case 49:
                        this.zzp.zza(t, t2, j);
                        break;
                    case 50:
                        zztb.zza(this.zzs, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /*60*/:
                        zzb(t, t2, i);
                        break;
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case Wbxml.EXT_I_2 /*66*/:
                    case Wbxml.PI /*67*/:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zztx.zza((Object) t, j, zztx.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case Wbxml.LITERAL_C /*68*/:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzj) {
                zztb.zza(this.zzq, t, t2);
                if (this.zzh) {
                    zztb.zza(this.zzr, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzc2 = (long) (zzc(i) & 1048575);
        if (zza(t2, i)) {
            Object zzf2 = zztx.zzf(t, zzc2);
            Object zzf3 = zztx.zzf(t2, zzc2);
            if (zzf2 != null && zzf3 != null) {
                zztx.zza((Object) t, zzc2, zzrd.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zztx.zza((Object) t, zzc2, zzf3);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzc2 = zzc(i);
        int i2 = this.zzc[i];
        long j = (long) (zzc2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zztx.zzf(t, j);
            Object zzf3 = zztx.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zztx.zza((Object) t, j, zzrd.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zztx.zza((Object) t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    public final int zzd(T t) {
        int i;
        int i2;
        long j;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        T t2 = t;
        int i5 = 267386880;
        boolean z3 = true;
        int i6 = 0;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i7 = 0;
            int i8 = 0;
            while (i7 < this.zzc.length) {
                int zzc2 = zzc(i7);
                int i9 = (zzc2 & i5) >>> 20;
                int i10 = this.zzc[i7];
                long j2 = (long) (zzc2 & 1048575);
                if (i9 < zzqx.DOUBLE_LIST_PACKED.zza() || i9 > zzqx.SINT64_LIST_PACKED.zza()) {
                    i4 = 0;
                } else {
                    i4 = this.zzc[i7 + 2] & 1048575;
                }
                switch (i9) {
                    case 0:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzb(i10, 0.0d);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzb(i10, 0.0f);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzd(i10, zztx.zzb(t2, j2));
                            break;
                        }
                    case 3:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zze(i10, zztx.zzb(t2, j2));
                            break;
                        }
                    case 4:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzf(i10, zztx.zza((Object) t2, j2));
                            break;
                        }
                    case 5:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzg(i10, 0);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzi(i10, 0);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzb(i10, true);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            Object zzf2 = zztx.zzf(t2, j2);
                            if (!(zzf2 instanceof zzqa)) {
                                i8 += zzqn.zzb(i10, (String) zzf2);
                                break;
                            } else {
                                i8 += zzqn.zzc(i10, (zzqa) zzf2);
                                break;
                            }
                        }
                    case 9:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zztb.zza(i10, zztx.zzf(t2, j2), zza(i7));
                            break;
                        }
                    case 10:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzc(i10, (zzqa) zztx.zzf(t2, j2));
                            break;
                        }
                    case IBulkCursor.RESPOND_TRANSACTION /*11*/:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzg(i10, zztx.zza((Object) t2, j2));
                            break;
                        }
                    case IBulkCursor.CLOSE_TRANSACTION /*12*/:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzk(i10, zztx.zza((Object) t2, j2));
                            break;
                        }
                    case 13:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzj(i10, 0);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzh(i10, 0);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzh(i10, zztx.zza((Object) t2, j2));
                            break;
                        }
                    case 16:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzf(i10, zztx.zzb(t2, j2));
                            break;
                        }
                    case 17:
                        if (!zza(t2, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzc(i10, (zzsm) zztx.zzf(t2, j2), zza(i7));
                            break;
                        }
                    case 18:
                        i8 += zztb.zzi(i10, zza((Object) t2, j2), false);
                        break;
                    case 19:
                        i8 += zztb.zzh(i10, zza((Object) t2, j2), false);
                        break;
                    case HeatmapTileProvider.DEFAULT_RADIUS /*20*/:
                        i8 += zztb.zza(i10, (List<Long>) zza((Object) t2, j2), false);
                        break;
                    case 21:
                        i8 += zztb.zzb(i10, (List<Long>) zza((Object) t2, j2), false);
                        break;
                    case 22:
                        i8 += zztb.zze(i10, zza((Object) t2, j2), false);
                        break;
                    case 23:
                        i8 += zztb.zzi(i10, zza((Object) t2, j2), false);
                        break;
                    case 24:
                        i8 += zztb.zzh(i10, zza((Object) t2, j2), false);
                        break;
                    case 25:
                        i8 += zztb.zzj(i10, zza((Object) t2, j2), false);
                        break;
                    case 26:
                        i8 += zztb.zza(i10, zza((Object) t2, j2));
                        break;
                    case 27:
                        i8 += zztb.zza(i10, zza((Object) t2, j2), zza(i7));
                        break;
                    case 28:
                        i8 += zztb.zzb(i10, zza((Object) t2, j2));
                        break;
                    case 29:
                        i8 += zztb.zzf(i10, zza((Object) t2, j2), false);
                        break;
                    case 30:
                        i8 += zztb.zzd(i10, zza((Object) t2, j2), false);
                        break;
                    case 31:
                        i8 += zztb.zzh(i10, zza((Object) t2, j2), false);
                        break;
                    case 32:
                        i8 += zztb.zzi(i10, zza((Object) t2, j2), false);
                        break;
                    case 33:
                        i8 += zztb.zzg(i10, zza((Object) t2, j2), false);
                        break;
                    case 34:
                        i8 += zztb.zzc(i10, zza((Object) t2, j2), false);
                        break;
                    case 35:
                        int zzi2 = zztb.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzi2);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzi2) + zzi2;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        int zzh2 = zztb.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzh2);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzh2) + zzh2;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        int zza2 = zztb.zza((List<Long>) (List) unsafe.getObject(t2, j2));
                        if (zza2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zza2);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zza2) + zza2;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        int zzb2 = zztb.zzb((List) unsafe.getObject(t2, j2));
                        if (zzb2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzb2);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzb2) + zzb2;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        int zze2 = zztb.zze((List) unsafe.getObject(t2, j2));
                        if (zze2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zze2);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zze2) + zze2;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        int zzi3 = zztb.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzi3);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzi3) + zzi3;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        int zzh3 = zztb.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzh3);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzh3) + zzh3;
                            break;
                        } else {
                            break;
                        }
                    case CalendarConstantsKt.MAX_CALENDAR_COLUMN /*42*/:
                        int zzj2 = zztb.zzj((List) unsafe.getObject(t2, j2));
                        if (zzj2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzj2);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzj2) + zzj2;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        int zzf3 = zztb.zzf((List) unsafe.getObject(t2, j2));
                        if (zzf3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzf3);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzf3) + zzf3;
                            break;
                        } else {
                            break;
                        }
                    case SanKeyboard.KEYCODE_DECIMAL_COMMA /*44*/:
                        int zzd2 = zztb.zzd((List) unsafe.getObject(t2, j2));
                        if (zzd2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzd2);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzd2) + zzd2;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        int zzh4 = zztb.zzh((List) unsafe.getObject(t2, j2));
                        if (zzh4 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzh4);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzh4) + zzh4;
                            break;
                        } else {
                            break;
                        }
                    case SanKeyboard.KEYCODE_DECIMAL_POINT /*46*/:
                        int zzi4 = zztb.zzi((List) unsafe.getObject(t2, j2));
                        if (zzi4 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzi4);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzi4) + zzi4;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        int zzg2 = zztb.zzg((List) unsafe.getObject(t2, j2));
                        if (zzg2 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzg2);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzg2) + zzg2;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int zzc3 = zztb.zzc((List) unsafe.getObject(t2, j2));
                        if (zzc3 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t2, (long) i4, zzc3);
                            }
                            i8 += zzqn.zze(i10) + zzqn.zzg(zzc3) + zzc3;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i8 += zztb.zzb(i10, (List<zzsm>) zza((Object) t2, j2), zza(i7));
                        break;
                    case 50:
                        i8 += this.zzs.zza(i10, zztx.zzf(t2, j2), zzb(i7));
                        break;
                    case 51:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzb(i10, 0.0d);
                            break;
                        }
                    case 52:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzb(i10, 0.0f);
                            break;
                        }
                    case 53:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzd(i10, zze(t2, j2));
                            break;
                        }
                    case 54:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zze(i10, zze(t2, j2));
                            break;
                        }
                    case 55:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzf(i10, zzd(t2, j2));
                            break;
                        }
                    case 56:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzg(i10, 0);
                            break;
                        }
                    case 57:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzi(i10, 0);
                            break;
                        }
                    case 58:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzb(i10, true);
                            break;
                        }
                    case 59:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            Object zzf4 = zztx.zzf(t2, j2);
                            if (!(zzf4 instanceof zzqa)) {
                                i8 += zzqn.zzb(i10, (String) zzf4);
                                break;
                            } else {
                                i8 += zzqn.zzc(i10, (zzqa) zzf4);
                                break;
                            }
                        }
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /*60*/:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zztb.zza(i10, zztx.zzf(t2, j2), zza(i7));
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzc(i10, (zzqa) zztx.zzf(t2, j2));
                            break;
                        }
                    case 62:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzg(i10, zzd(t2, j2));
                            break;
                        }
                    case 63:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzk(i10, zzd(t2, j2));
                            break;
                        }
                    case 64:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzj(i10, 0);
                            break;
                        }
                    case 65:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzh(i10, 0);
                            break;
                        }
                    case Wbxml.EXT_I_2 /*66*/:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzh(i10, zzd(t2, j2));
                            break;
                        }
                    case Wbxml.PI /*67*/:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzf(i10, zze(t2, j2));
                            break;
                        }
                    case Wbxml.LITERAL_C /*68*/:
                        if (!zza(t2, i10, i7)) {
                            break;
                        } else {
                            i8 += zzqn.zzc(i10, (zzsm) zztx.zzf(t2, j2), zza(i7));
                            break;
                        }
                }
                i7 += 3;
                i5 = 267386880;
            }
            return i8 + zza(this.zzq, t2);
        }
        Unsafe unsafe2 = zzb;
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < this.zzc.length) {
            int zzc4 = zzc(i12);
            int[] iArr = this.zzc;
            int i15 = iArr[i12];
            int i16 = (zzc4 & 267386880) >>> 20;
            if (i16 <= 17) {
                int i17 = iArr[i12 + 2];
                int i18 = i17 & 1048575;
                i = (z3 ? 1 : 0) << (i17 >>> 20);
                if (i18 != i11) {
                    i14 = unsafe2.getInt(t2, (long) i18);
                    i11 = i18;
                }
                i2 = i17;
            } else if (!this.zzk || i16 < zzqx.DOUBLE_LIST_PACKED.zza() || i16 > zzqx.SINT64_LIST_PACKED.zza()) {
                i2 = 0;
                i = 0;
            } else {
                i2 = this.zzc[i12 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzc4 & 1048575);
            switch (i16) {
                case 0:
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    if ((i14 & i) == 0) {
                        break;
                    } else {
                        i13 += zzqn.zzb(i15, 0.0d);
                        break;
                    }
                case 1:
                    z2 = true;
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        z = false;
                        i13 += zzqn.zzb(i15, 0.0f);
                        break;
                    }
                case 2:
                    z2 = true;
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        i13 += zzqn.zzd(i15, unsafe2.getLong(t2, j3));
                        z = false;
                        break;
                    }
                case 3:
                    z2 = true;
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        i13 += zzqn.zze(i15, unsafe2.getLong(t2, j3));
                        z = false;
                        break;
                    }
                case 4:
                    z2 = true;
                    i3 = 0;
                    j = 0;
                    if ((i14 & i) == 0) {
                        z = false;
                        break;
                    } else {
                        i13 += zzqn.zzf(i15, unsafe2.getInt(t2, j3));
                        z = false;
                        break;
                    }
                case 5:
                    z2 = true;
                    i3 = 0;
                    if ((i14 & i) == 0) {
                        j = 0;
                        z = false;
                        break;
                    } else {
                        j = 0;
                        i13 += zzqn.zzg(i15, 0);
                        z = false;
                        break;
                    }
                case 6:
                    z2 = true;
                    if ((i14 & i) == 0) {
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i3 = 0;
                        i13 += zzqn.zzi(i15, 0);
                        z = false;
                        j = 0;
                        break;
                    }
                case 7:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        z2 = true;
                        i13 += zzqn.zzb(i15, true);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 8:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        Object object = unsafe2.getObject(t2, j3);
                        if (!(object instanceof zzqa)) {
                            i13 += zzqn.zzb(i15, (String) object);
                            z2 = true;
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        } else {
                            i13 += zzqn.zzc(i15, (zzqa) object);
                            z2 = true;
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        }
                    }
                case 9:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zztb.zza(i15, unsafe2.getObject(t2, j3), zza(i12));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 10:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzc(i15, (zzqa) unsafe2.getObject(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case IBulkCursor.RESPOND_TRANSACTION /*11*/:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzg(i15, unsafe2.getInt(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case IBulkCursor.CLOSE_TRANSACTION /*12*/:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzk(i15, unsafe2.getInt(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 13:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzj(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 14:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzh(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 15:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzh(i15, unsafe2.getInt(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 16:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzf(i15, unsafe2.getLong(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 17:
                    if ((i14 & i) == 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzc(i15, (zzsm) unsafe2.getObject(t2, j3), zza(i12));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 18:
                    i13 += zztb.zzi(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 19:
                    i3 = 0;
                    i13 += zztb.zzh(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case HeatmapTileProvider.DEFAULT_RADIUS /*20*/:
                    i3 = 0;
                    i13 += zztb.zza(i15, (List<Long>) (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    i3 = 0;
                    i13 += zztb.zzb(i15, (List<Long>) (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    i3 = 0;
                    i13 += zztb.zze(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 23:
                    i3 = 0;
                    i13 += zztb.zzi(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 24:
                    i3 = 0;
                    i13 += zztb.zzh(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    i3 = 0;
                    i13 += zztb.zzj(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    i13 += zztb.zza(i15, (List<?>) (List) unsafe2.getObject(t2, j3));
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 27:
                    i13 += zztb.zza(i15, (List<?>) (List) unsafe2.getObject(t2, j3), zza(i12));
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 28:
                    i13 += zztb.zzb(i15, (List) unsafe2.getObject(t2, j3));
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 29:
                    i13 += zztb.zzf(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 30:
                    i3 = 0;
                    i13 += zztb.zzd(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 31:
                    i3 = 0;
                    i13 += zztb.zzh(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 32:
                    i3 = 0;
                    i13 += zztb.zzi(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    i3 = 0;
                    i13 += zztb.zzg(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    i3 = 0;
                    i13 += zztb.zzc(i15, (List) unsafe2.getObject(t2, j3), false);
                    z2 = true;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    int zzi5 = zztb.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi5 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi5);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzi5) + zzi5;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 36:
                    int zzh5 = zztb.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh5 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh5);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzh5) + zzh5;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 37:
                    int zza3 = zztb.zza((List<Long>) (List) unsafe2.getObject(t2, j3));
                    if (zza3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zza3);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zza3) + zza3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 38:
                    int zzb3 = zztb.zzb((List) unsafe2.getObject(t2, j3));
                    if (zzb3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzb3);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzb3) + zzb3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 39:
                    int zze3 = zztb.zze((List) unsafe2.getObject(t2, j3));
                    if (zze3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zze3);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zze3) + zze3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 40:
                    int zzi6 = zztb.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi6 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi6);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzi6) + zzi6;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 41:
                    int zzh6 = zztb.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh6 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh6);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzh6) + zzh6;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case CalendarConstantsKt.MAX_CALENDAR_COLUMN /*42*/:
                    int zzj3 = zztb.zzj((List) unsafe2.getObject(t2, j3));
                    if (zzj3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzj3);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzj3) + zzj3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 43:
                    int zzf5 = zztb.zzf((List) unsafe2.getObject(t2, j3));
                    if (zzf5 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzf5);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzf5) + zzf5;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case SanKeyboard.KEYCODE_DECIMAL_COMMA /*44*/:
                    int zzd3 = zztb.zzd((List) unsafe2.getObject(t2, j3));
                    if (zzd3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzd3);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzd3) + zzd3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 45:
                    int zzh7 = zztb.zzh((List) unsafe2.getObject(t2, j3));
                    if (zzh7 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzh7);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzh7) + zzh7;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case SanKeyboard.KEYCODE_DECIMAL_POINT /*46*/:
                    int zzi7 = zztb.zzi((List) unsafe2.getObject(t2, j3));
                    if (zzi7 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzi7);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzi7) + zzi7;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 47:
                    int zzg3 = zztb.zzg((List) unsafe2.getObject(t2, j3));
                    if (zzg3 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzg3);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzg3) + zzg3;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 48:
                    int zzc5 = zztb.zzc((List) unsafe2.getObject(t2, j3));
                    if (zzc5 <= 0) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        if (this.zzk) {
                            unsafe2.putInt(t2, (long) i2, zzc5);
                        }
                        i13 += zzqn.zze(i15) + zzqn.zzg(zzc5) + zzc5;
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 49:
                    i13 += zztb.zzb(i15, (List<zzsm>) (List) unsafe2.getObject(t2, j3), zza(i12));
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 50:
                    i13 += this.zzs.zza(i15, unsafe2.getObject(t2, j3), zzb(i12));
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 51:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzb(i15, 0.0d);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 52:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzb(i15, 0.0f);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 53:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzd(i15, zze(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 54:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zze(i15, zze(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 55:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzf(i15, zzd(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 56:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzg(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 57:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzi(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 58:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzb(i15, true);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 59:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        Object object2 = unsafe2.getObject(t2, j3);
                        if (!(object2 instanceof zzqa)) {
                            i13 += zzqn.zzb(i15, (String) object2);
                            z2 = true;
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        } else {
                            i13 += zzqn.zzc(i15, (zzqa) object2);
                            z2 = true;
                            i3 = 0;
                            z = false;
                            j = 0;
                            break;
                        }
                    }
                case LockFreeTaskQueueCore.FROZEN_SHIFT /*60*/:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zztb.zza(i15, unsafe2.getObject(t2, j3), zza(i12));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzc(i15, (zzqa) unsafe2.getObject(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 62:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzg(i15, zzd(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 63:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzk(i15, zzd(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 64:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzj(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case 65:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzh(i15, 0);
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case Wbxml.EXT_I_2 /*66*/:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzh(i15, zzd(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case Wbxml.PI /*67*/:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzf(i15, zze(t2, j3));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                case Wbxml.LITERAL_C /*68*/:
                    if (!zza(t2, i15, i12)) {
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    } else {
                        i13 += zzqn.zzc(i15, (zzsm) unsafe2.getObject(t2, j3), zza(i12));
                        z2 = true;
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                default:
                    z2 = true;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
            }
            i12 += 3;
            i6 = i3;
            z3 = z2;
            boolean z4 = z;
            long j4 = j;
        }
        int i19 = i6;
        int zza4 = i13 + zza(this.zzq, t2);
        if (!this.zzh) {
            return zza4;
        }
        zzqw<?> zza5 = this.zzr.zza((Object) t2);
        for (int i20 = i19; i20 < zza5.zza.zzc(); i20++) {
            Map.Entry<T, Object> zzb4 = zza5.zza.zzb(i20);
            i19 += zzqw.zza((zzqy<?>) (zzqy) zzb4.getKey(), zzb4.getValue());
        }
        for (Map.Entry next : zza5.zza.zzd()) {
            i19 += zzqw.zza((zzqy<?>) (zzqy) next.getKey(), next.getValue());
        }
        return zza4 + i19;
    }

    private static <UT, UB> int zza(zztr<UT, UB> zztr, T t) {
        return zztr.zzd(zztr.zza(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zztx.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05ad  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05f0  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0b5e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.libraries.places.internal.zzul r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.libraries.places.internal.zzrb.zzc.zzk
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x05c3
            com.google.android.libraries.places.internal.zztr<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.libraries.places.internal.zzul) r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0036
            com.google.android.libraries.places.internal.zzqr<?> r0 = r13.zzr
            com.google.android.libraries.places.internal.zzqw r0 = r0.zza((java.lang.Object) r14)
            com.google.android.libraries.places.internal.zzte<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0036
            java.util.Iterator r0 = r0.zze()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0038
        L_0x0036:
            r0 = r3
            r1 = r0
        L_0x0038:
            int[] r7 = r13.zzc
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x003d:
            if (r7 < 0) goto L_0x05ab
            int r8 = r13.zzc((int) r7)
            int[] r9 = r13.zzc
            r9 = r9[r7]
        L_0x0049:
            if (r1 == 0) goto L_0x0067
            com.google.android.libraries.places.internal.zzqr<?> r10 = r13.zzr
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0067
            com.google.android.libraries.places.internal.zzqr<?> r10 = r13.zzr
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0065
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0049
        L_0x0065:
            r1 = r3
            goto L_0x0049
        L_0x0067:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x0596;
                case 1: goto L_0x0584;
                case 2: goto L_0x0572;
                case 3: goto L_0x0560;
                case 4: goto L_0x054e;
                case 5: goto L_0x053c;
                case 6: goto L_0x052a;
                case 7: goto L_0x0517;
                case 8: goto L_0x0505;
                case 9: goto L_0x04ef;
                case 10: goto L_0x04db;
                case 11: goto L_0x04c8;
                case 12: goto L_0x04b5;
                case 13: goto L_0x04a2;
                case 14: goto L_0x048f;
                case 15: goto L_0x047c;
                case 16: goto L_0x0469;
                case 17: goto L_0x0453;
                case 18: goto L_0x043f;
                case 19: goto L_0x042b;
                case 20: goto L_0x0417;
                case 21: goto L_0x0403;
                case 22: goto L_0x03ef;
                case 23: goto L_0x03db;
                case 24: goto L_0x03c7;
                case 25: goto L_0x03b3;
                case 26: goto L_0x039f;
                case 27: goto L_0x0387;
                case 28: goto L_0x0373;
                case 29: goto L_0x035f;
                case 30: goto L_0x034b;
                case 31: goto L_0x0337;
                case 32: goto L_0x0323;
                case 33: goto L_0x030f;
                case 34: goto L_0x02fb;
                case 35: goto L_0x02e7;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02bf;
                case 38: goto L_0x02ab;
                case 39: goto L_0x0297;
                case 40: goto L_0x0283;
                case 41: goto L_0x026f;
                case 42: goto L_0x025b;
                case 43: goto L_0x0247;
                case 44: goto L_0x0233;
                case 45: goto L_0x021f;
                case 46: goto L_0x020b;
                case 47: goto L_0x01f7;
                case 48: goto L_0x01e3;
                case 49: goto L_0x01cb;
                case 50: goto L_0x01bf;
                case 51: goto L_0x01ad;
                case 52: goto L_0x019b;
                case 53: goto L_0x0189;
                case 54: goto L_0x0177;
                case 55: goto L_0x0165;
                case 56: goto L_0x0153;
                case 57: goto L_0x0141;
                case 58: goto L_0x012f;
                case 59: goto L_0x011d;
                case 60: goto L_0x0107;
                case 61: goto L_0x00f3;
                case 62: goto L_0x00e1;
                case 63: goto L_0x00cf;
                case 64: goto L_0x00bd;
                case 65: goto L_0x00ab;
                case 66: goto L_0x0099;
                case 67: goto L_0x0087;
                case 68: goto L_0x0071;
                default: goto L_0x006f;
            }
        L_0x006f:
            goto L_0x05a7
        L_0x0071:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            com.google.android.libraries.places.internal.zzsz r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.zzsz) r10)
            goto L_0x05a7
        L_0x0087:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0099:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x05a7
        L_0x00ab:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x05a7
        L_0x00bd:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x05a7
        L_0x00cf:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x05a7
        L_0x00e1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x05a7
        L_0x00f3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            com.google.android.libraries.places.internal.zzqa r8 = (com.google.android.libraries.places.internal.zzqa) r8
            r15.zza((int) r9, (com.google.android.libraries.places.internal.zzqa) r8)
            goto L_0x05a7
        L_0x0107:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            com.google.android.libraries.places.internal.zzsz r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.zzsz) r10)
            goto L_0x05a7
        L_0x011d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.zzul) r15)
            goto L_0x05a7
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzf(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x05a7
        L_0x0141:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x05a7
        L_0x0153:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0165:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x05a7
        L_0x0177:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0189:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x05a7
        L_0x019b:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzc(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x05a7
        L_0x01ad:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzb(r14, (long) r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x05a7
        L_0x01bf:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            r13.zza((com.google.android.libraries.places.internal.zzul) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x05a7
        L_0x01cb:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zzsz r10 = r13.zza((int) r7)
            com.google.android.libraries.places.internal.zztb.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.libraries.places.internal.zzul) r15, (com.google.android.libraries.places.internal.zzsz) r10)
            goto L_0x05a7
        L_0x01e3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zze(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x01f7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzj(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x020b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzg(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x021f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzl(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0233:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzm(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0247:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzi(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x025b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzn(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x026f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzk(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0283:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzf(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x0297:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzh(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02ab:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzd(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02bf:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzc(r9, r8, r15, r4)
            goto L_0x05a7
        L_0x02d3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.libraries.places.internal.zzul) r15, (boolean) r4)
            goto L_0x05a7
        L_0x02e7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.libraries.places.internal.zzul) r15, (boolean) r4)
            goto L_0x05a7
        L_0x02fb:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zze(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x030f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzj(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0323:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzg(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0337:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzl(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x034b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzm(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x035f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzi(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0373:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzb((int) r9, (java.util.List<com.google.android.libraries.places.internal.zzqa>) r8, (com.google.android.libraries.places.internal.zzul) r15)
            goto L_0x05a7
        L_0x0387:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zzsz r10 = r13.zza((int) r7)
            com.google.android.libraries.places.internal.zztb.zza((int) r9, (java.util.List<?>) r8, (com.google.android.libraries.places.internal.zzul) r15, (com.google.android.libraries.places.internal.zzsz) r10)
            goto L_0x05a7
        L_0x039f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.libraries.places.internal.zzul) r15)
            goto L_0x05a7
        L_0x03b3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzn(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03c7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzk(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03db:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzf(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x03ef:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzh(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0403:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzd(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x0417:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzc(r9, r8, r15, r5)
            goto L_0x05a7
        L_0x042b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.libraries.places.internal.zzul) r15, (boolean) r5)
            goto L_0x05a7
        L_0x043f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.libraries.places.internal.zztb.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.libraries.places.internal.zzul) r15, (boolean) r5)
            goto L_0x05a7
        L_0x0453:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            com.google.android.libraries.places.internal.zzsz r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.zzsz) r10)
            goto L_0x05a7
        L_0x0469:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.libraries.places.internal.zztx.zzb(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x05a7
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r10)
            r15.zzf(r9, r8)
            goto L_0x05a7
        L_0x048f:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.libraries.places.internal.zztx.zzb(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x05a7
        L_0x04a2:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04b5:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04c8:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x05a7
        L_0x04db:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            com.google.android.libraries.places.internal.zzqa r8 = (com.google.android.libraries.places.internal.zzqa) r8
            r15.zza((int) r9, (com.google.android.libraries.places.internal.zzqa) r8)
            goto L_0x05a7
        L_0x04ef:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            com.google.android.libraries.places.internal.zzsz r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.zzsz) r10)
            goto L_0x05a7
        L_0x0505:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.libraries.places.internal.zztx.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.libraries.places.internal.zzul) r15)
            goto L_0x05a7
        L_0x0517:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.libraries.places.internal.zztx.zzc(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x05a7
        L_0x052a:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x05a7
        L_0x053c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.libraries.places.internal.zztx.zzb(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x05a7
        L_0x054e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x05a7
        L_0x0560:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.libraries.places.internal.zztx.zzb(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0572:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.libraries.places.internal.zztx.zzb(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x05a7
        L_0x0584:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.libraries.places.internal.zztx.zzd(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x05a7
        L_0x0596:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a7
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.libraries.places.internal.zztx.zze(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x05a7:
            int r7 = r7 + -3
            goto L_0x003d
        L_0x05ab:
            if (r1 == 0) goto L_0x05c2
            com.google.android.libraries.places.internal.zzqr<?> r14 = r13.zzr
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x05c0
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x05ab
        L_0x05c0:
            r1 = r3
            goto L_0x05ab
        L_0x05c2:
            return
        L_0x05c3:
            boolean r0 = r13.zzj
            if (r0 == 0) goto L_0x0b78
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x05e8
            com.google.android.libraries.places.internal.zzqr<?> r0 = r13.zzr
            com.google.android.libraries.places.internal.zzqw r0 = r0.zza((java.lang.Object) r14)
            com.google.android.libraries.places.internal.zzte<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x05e8
            java.util.Iterator r0 = r0.zzd()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x05ea
        L_0x05e8:
            r0 = r3
            r1 = r0
        L_0x05ea:
            int[] r7 = r13.zzc
            int r7 = r7.length
            r8 = r5
        L_0x05ee:
            if (r8 >= r7) goto L_0x0b5c
            int r9 = r13.zzc((int) r8)
            int[] r10 = r13.zzc
            r10 = r10[r8]
        L_0x05fa:
            if (r1 == 0) goto L_0x0618
            com.google.android.libraries.places.internal.zzqr<?> r11 = r13.zzr
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r1)
            if (r11 > r10) goto L_0x0618
            com.google.android.libraries.places.internal.zzqr<?> r11 = r13.zzr
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0616
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x05fa
        L_0x0616:
            r1 = r3
            goto L_0x05fa
        L_0x0618:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0b47;
                case 1: goto L_0x0b35;
                case 2: goto L_0x0b23;
                case 3: goto L_0x0b11;
                case 4: goto L_0x0aff;
                case 5: goto L_0x0aed;
                case 6: goto L_0x0adb;
                case 7: goto L_0x0ac8;
                case 8: goto L_0x0ab6;
                case 9: goto L_0x0aa0;
                case 10: goto L_0x0a8c;
                case 11: goto L_0x0a79;
                case 12: goto L_0x0a66;
                case 13: goto L_0x0a53;
                case 14: goto L_0x0a40;
                case 15: goto L_0x0a2d;
                case 16: goto L_0x0a1a;
                case 17: goto L_0x0a04;
                case 18: goto L_0x09f0;
                case 19: goto L_0x09dc;
                case 20: goto L_0x09c8;
                case 21: goto L_0x09b4;
                case 22: goto L_0x09a0;
                case 23: goto L_0x098c;
                case 24: goto L_0x0978;
                case 25: goto L_0x0964;
                case 26: goto L_0x0950;
                case 27: goto L_0x0938;
                case 28: goto L_0x0924;
                case 29: goto L_0x0910;
                case 30: goto L_0x08fc;
                case 31: goto L_0x08e8;
                case 32: goto L_0x08d4;
                case 33: goto L_0x08c0;
                case 34: goto L_0x08ac;
                case 35: goto L_0x0898;
                case 36: goto L_0x0884;
                case 37: goto L_0x0870;
                case 38: goto L_0x085c;
                case 39: goto L_0x0848;
                case 40: goto L_0x0834;
                case 41: goto L_0x0820;
                case 42: goto L_0x080c;
                case 43: goto L_0x07f8;
                case 44: goto L_0x07e4;
                case 45: goto L_0x07d0;
                case 46: goto L_0x07bc;
                case 47: goto L_0x07a8;
                case 48: goto L_0x0794;
                case 49: goto L_0x077c;
                case 50: goto L_0x0770;
                case 51: goto L_0x075e;
                case 52: goto L_0x074c;
                case 53: goto L_0x073a;
                case 54: goto L_0x0728;
                case 55: goto L_0x0716;
                case 56: goto L_0x0704;
                case 57: goto L_0x06f2;
                case 58: goto L_0x06e0;
                case 59: goto L_0x06ce;
                case 60: goto L_0x06b8;
                case 61: goto L_0x06a4;
                case 62: goto L_0x0692;
                case 63: goto L_0x0680;
                case 64: goto L_0x066e;
                case 65: goto L_0x065c;
                case 66: goto L_0x064a;
                case 67: goto L_0x0638;
                case 68: goto L_0x0622;
                default: goto L_0x0620;
            }
        L_0x0620:
            goto L_0x0b58
        L_0x0622:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            com.google.android.libraries.places.internal.zzsz r11 = r13.zza((int) r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.zzsz) r11)
            goto L_0x0b58
        L_0x0638:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0b58
        L_0x064a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0b58
        L_0x065c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0b58
        L_0x066e:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0680:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0692:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0b58
        L_0x06a4:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            com.google.android.libraries.places.internal.zzqa r9 = (com.google.android.libraries.places.internal.zzqa) r9
            r15.zza((int) r10, (com.google.android.libraries.places.internal.zzqa) r9)
            goto L_0x0b58
        L_0x06b8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            com.google.android.libraries.places.internal.zzsz r11 = r13.zza((int) r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.zzsz) r11)
            goto L_0x0b58
        L_0x06ce:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.zzul) r15)
            goto L_0x0b58
        L_0x06e0:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzf(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0b58
        L_0x06f2:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0704:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0716:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0728:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0b58
        L_0x073a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0b58
        L_0x074c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzc(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0b58
        L_0x075e:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzb(r14, (long) r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0b58
        L_0x0770:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            r13.zza((com.google.android.libraries.places.internal.zzul) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0b58
        L_0x077c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zzsz r11 = r13.zza((int) r8)
            com.google.android.libraries.places.internal.zztb.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.libraries.places.internal.zzul) r15, (com.google.android.libraries.places.internal.zzsz) r11)
            goto L_0x0b58
        L_0x0794:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zze(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07a8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzj(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07bc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzg(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07d0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzl(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07e4:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzm(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x07f8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzi(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x080c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzn(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0820:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzk(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0834:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzf(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0848:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzh(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x085c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzd(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0870:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzc(r10, r9, r15, r4)
            goto L_0x0b58
        L_0x0884:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.libraries.places.internal.zzul) r15, (boolean) r4)
            goto L_0x0b58
        L_0x0898:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.libraries.places.internal.zzul) r15, (boolean) r4)
            goto L_0x0b58
        L_0x08ac:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zze(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08c0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzj(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08d4:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzg(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08e8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzl(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x08fc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzm(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x0910:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzi(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x0924:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzb((int) r10, (java.util.List<com.google.android.libraries.places.internal.zzqa>) r9, (com.google.android.libraries.places.internal.zzul) r15)
            goto L_0x0b58
        L_0x0938:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zzsz r11 = r13.zza((int) r8)
            com.google.android.libraries.places.internal.zztb.zza((int) r10, (java.util.List<?>) r9, (com.google.android.libraries.places.internal.zzul) r15, (com.google.android.libraries.places.internal.zzsz) r11)
            goto L_0x0b58
        L_0x0950:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.libraries.places.internal.zzul) r15)
            goto L_0x0b58
        L_0x0964:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzn(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x0978:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzk(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x098c:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzf(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09a0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzh(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09b4:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzd(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09c8:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzc(r10, r9, r15, r5)
            goto L_0x0b58
        L_0x09dc:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.libraries.places.internal.zzul) r15, (boolean) r5)
            goto L_0x0b58
        L_0x09f0:
            int[] r10 = r13.zzc
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.libraries.places.internal.zzul) r15, (boolean) r5)
            goto L_0x0b58
        L_0x0a04:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            com.google.android.libraries.places.internal.zzsz r11 = r13.zza((int) r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.zzsz) r11)
            goto L_0x0b58
        L_0x0a1a:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.libraries.places.internal.zztx.zzb(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0a2d:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r11)
            r15.zzf(r10, r9)
            goto L_0x0b58
        L_0x0a40:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.libraries.places.internal.zztx.zzb(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0a53:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0a66:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0a79:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0a8c:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            com.google.android.libraries.places.internal.zzqa r9 = (com.google.android.libraries.places.internal.zzqa) r9
            r15.zza((int) r10, (com.google.android.libraries.places.internal.zzqa) r9)
            goto L_0x0b58
        L_0x0aa0:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            com.google.android.libraries.places.internal.zzsz r11 = r13.zza((int) r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.zzsz) r11)
            goto L_0x0b58
        L_0x0ab6:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.libraries.places.internal.zztx.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.libraries.places.internal.zzul) r15)
            goto L_0x0b58
        L_0x0ac8:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.libraries.places.internal.zztx.zzc(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0b58
        L_0x0adb:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0aed:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.libraries.places.internal.zztx.zzb(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0aff:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.libraries.places.internal.zztx.zza((java.lang.Object) r14, (long) r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0b58
        L_0x0b11:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.libraries.places.internal.zztx.zzb(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0b23:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.libraries.places.internal.zztx.zzb(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0b58
        L_0x0b35:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.libraries.places.internal.zztx.zzd(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0b58
        L_0x0b47:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0b58
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.libraries.places.internal.zztx.zze(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0b58:
            int r8 = r8 + 3
            goto L_0x05ee
        L_0x0b5c:
            if (r1 == 0) goto L_0x0b72
            com.google.android.libraries.places.internal.zzqr<?> r2 = r13.zzr
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0b70
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0b5c
        L_0x0b70:
            r1 = r3
            goto L_0x0b5c
        L_0x0b72:
            com.google.android.libraries.places.internal.zztr<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.libraries.places.internal.zzul) r15)
            return
        L_0x0b78:
            r13.zzb(r14, (com.google.android.libraries.places.internal.zzul) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzsq.zza(java.lang.Object, com.google.android.libraries.places.internal.zzul):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:189:0x05c7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.libraries.places.internal.zzul r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0025
            com.google.android.libraries.places.internal.zzqr<?> r3 = r0.zzr
            com.google.android.libraries.places.internal.zzqw r3 = r3.zza((java.lang.Object) r1)
            com.google.android.libraries.places.internal.zzte<T, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0025
            java.util.Iterator r3 = r3.zzd()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0027
        L_0x0025:
            r3 = 0
            r5 = 0
        L_0x0027:
            r6 = -1
            int[] r7 = r0.zzc
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzb
            r10 = 0
            r11 = 0
        L_0x0030:
            if (r10 >= r7) goto L_0x05c5
            int r12 = r0.zzc((int) r10)
            int[] r13 = r0.zzc
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzj
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x0069
            r4 = 17
            if (r15 > r4) goto L_0x0069
            int r4 = r10 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            if (r13 == r6) goto L_0x0061
            r17 = r10
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            r6 = r13
            goto L_0x0063
        L_0x0061:
            r17 = r10
        L_0x0063:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x006c
        L_0x0069:
            r17 = r10
            r4 = 0
        L_0x006c:
            if (r5 == 0) goto L_0x008a
            com.google.android.libraries.places.internal.zzqr<?> r9 = r0.zzr
            int r9 = r9.zza((java.util.Map.Entry<?, ?>) r5)
            if (r9 > r14) goto L_0x008a
            com.google.android.libraries.places.internal.zzqr<?> r9 = r0.zzr
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0088
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x006c
        L_0x0088:
            r5 = 0
            goto L_0x006c
        L_0x008a:
            r9 = r12 & r16
            long r9 = (long) r9
            switch(r15) {
                case 0: goto L_0x05b3;
                case 1: goto L_0x05a4;
                case 2: goto L_0x0596;
                case 3: goto L_0x0588;
                case 4: goto L_0x057a;
                case 5: goto L_0x056c;
                case 6: goto L_0x055e;
                case 7: goto L_0x054e;
                case 8: goto L_0x053f;
                case 9: goto L_0x052c;
                case 10: goto L_0x051b;
                case 11: goto L_0x050c;
                case 12: goto L_0x04fd;
                case 13: goto L_0x04ee;
                case 14: goto L_0x04df;
                case 15: goto L_0x04d0;
                case 16: goto L_0x04c1;
                case 17: goto L_0x04ad;
                case 18: goto L_0x049a;
                case 19: goto L_0x0486;
                case 20: goto L_0x0472;
                case 21: goto L_0x045e;
                case 22: goto L_0x044a;
                case 23: goto L_0x0436;
                case 24: goto L_0x0422;
                case 25: goto L_0x040e;
                case 26: goto L_0x03fb;
                case 27: goto L_0x03e3;
                case 28: goto L_0x03d0;
                case 29: goto L_0x03bc;
                case 30: goto L_0x03a8;
                case 31: goto L_0x0394;
                case 32: goto L_0x0380;
                case 33: goto L_0x036c;
                case 34: goto L_0x0358;
                case 35: goto L_0x0344;
                case 36: goto L_0x0330;
                case 37: goto L_0x031c;
                case 38: goto L_0x0308;
                case 39: goto L_0x02f4;
                case 40: goto L_0x02e0;
                case 41: goto L_0x02cc;
                case 42: goto L_0x02b8;
                case 43: goto L_0x02a4;
                case 44: goto L_0x0290;
                case 45: goto L_0x027c;
                case 46: goto L_0x0268;
                case 47: goto L_0x0254;
                case 48: goto L_0x0240;
                case 49: goto L_0x0228;
                case 50: goto L_0x021c;
                case 51: goto L_0x0207;
                case 52: goto L_0x01f2;
                case 53: goto L_0x01dd;
                case 54: goto L_0x01c8;
                case 55: goto L_0x01b3;
                case 56: goto L_0x019e;
                case 57: goto L_0x0189;
                case 58: goto L_0x0174;
                case 59: goto L_0x015f;
                case 60: goto L_0x0146;
                case 61: goto L_0x012f;
                case 62: goto L_0x011a;
                case 63: goto L_0x0105;
                case 64: goto L_0x00f0;
                case 65: goto L_0x00db;
                case 66: goto L_0x00c6;
                case 67: goto L_0x00b1;
                case 68: goto L_0x0097;
                default: goto L_0x0092;
            }
        L_0x0092:
            r12 = r17
            r13 = 0
            goto L_0x05c1
        L_0x0097:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x00ae
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.libraries.places.internal.zzsz r9 = r0.zza((int) r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.zzsz) r9)
            r13 = 0
            goto L_0x05c1
        L_0x00ae:
            r13 = 0
            goto L_0x05c1
        L_0x00b1:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x00c3
            long r9 = zze(r1, r9)
            r2.zze((int) r14, (long) r9)
            r13 = 0
            goto L_0x05c1
        L_0x00c3:
            r13 = 0
            goto L_0x05c1
        L_0x00c6:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x00d8
            int r4 = zzd(r1, r9)
            r2.zzf(r14, r4)
            r13 = 0
            goto L_0x05c1
        L_0x00d8:
            r13 = 0
            goto L_0x05c1
        L_0x00db:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x00ed
            long r9 = zze(r1, r9)
            r2.zzb((int) r14, (long) r9)
            r13 = 0
            goto L_0x05c1
        L_0x00ed:
            r13 = 0
            goto L_0x05c1
        L_0x00f0:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0102
            int r4 = zzd(r1, r9)
            r2.zza((int) r14, (int) r4)
            r13 = 0
            goto L_0x05c1
        L_0x0102:
            r13 = 0
            goto L_0x05c1
        L_0x0105:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0117
            int r4 = zzd(r1, r9)
            r2.zzb((int) r14, (int) r4)
            r13 = 0
            goto L_0x05c1
        L_0x0117:
            r13 = 0
            goto L_0x05c1
        L_0x011a:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x012c
            int r4 = zzd(r1, r9)
            r2.zze((int) r14, (int) r4)
            r13 = 0
            goto L_0x05c1
        L_0x012c:
            r13 = 0
            goto L_0x05c1
        L_0x012f:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0143
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.libraries.places.internal.zzqa r4 = (com.google.android.libraries.places.internal.zzqa) r4
            r2.zza((int) r14, (com.google.android.libraries.places.internal.zzqa) r4)
            r13 = 0
            goto L_0x05c1
        L_0x0143:
            r13 = 0
            goto L_0x05c1
        L_0x0146:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x015c
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.libraries.places.internal.zzsz r9 = r0.zza((int) r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.zzsz) r9)
            r13 = 0
            goto L_0x05c1
        L_0x015c:
            r13 = 0
            goto L_0x05c1
        L_0x015f:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0171
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.zzul) r2)
            r13 = 0
            goto L_0x05c1
        L_0x0171:
            r13 = 0
            goto L_0x05c1
        L_0x0174:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0186
            boolean r4 = zzf(r1, r9)
            r2.zza((int) r14, (boolean) r4)
            r13 = 0
            goto L_0x05c1
        L_0x0186:
            r13 = 0
            goto L_0x05c1
        L_0x0189:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x019b
            int r4 = zzd(r1, r9)
            r2.zzd((int) r14, (int) r4)
            r13 = 0
            goto L_0x05c1
        L_0x019b:
            r13 = 0
            goto L_0x05c1
        L_0x019e:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x01b0
            long r9 = zze(r1, r9)
            r2.zzd((int) r14, (long) r9)
            r13 = 0
            goto L_0x05c1
        L_0x01b0:
            r13 = 0
            goto L_0x05c1
        L_0x01b3:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x01c5
            int r4 = zzd(r1, r9)
            r2.zzc((int) r14, (int) r4)
            r13 = 0
            goto L_0x05c1
        L_0x01c5:
            r13 = 0
            goto L_0x05c1
        L_0x01c8:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x01da
            long r9 = zze(r1, r9)
            r2.zzc((int) r14, (long) r9)
            r13 = 0
            goto L_0x05c1
        L_0x01da:
            r13 = 0
            goto L_0x05c1
        L_0x01dd:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x01ef
            long r9 = zze(r1, r9)
            r2.zza((int) r14, (long) r9)
            r13 = 0
            goto L_0x05c1
        L_0x01ef:
            r13 = 0
            goto L_0x05c1
        L_0x01f2:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0204
            float r4 = zzc(r1, r9)
            r2.zza((int) r14, (float) r4)
            r13 = 0
            goto L_0x05c1
        L_0x0204:
            r13 = 0
            goto L_0x05c1
        L_0x0207:
            r12 = r17
            boolean r4 = r0.zza(r1, (int) r14, (int) r12)
            if (r4 == 0) goto L_0x0219
            double r9 = zzb(r1, (long) r9)
            r2.zza((int) r14, (double) r9)
            r13 = 0
            goto L_0x05c1
        L_0x0219:
            r13 = 0
            goto L_0x05c1
        L_0x021c:
            r12 = r17
            java.lang.Object r4 = r8.getObject(r1, r9)
            r0.zza((com.google.android.libraries.places.internal.zzul) r2, (int) r14, (java.lang.Object) r4, (int) r12)
            r13 = 0
            goto L_0x05c1
        L_0x0228:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zzsz r10 = r0.zza((int) r12)
            com.google.android.libraries.places.internal.zztb.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.libraries.places.internal.zzul) r2, (com.google.android.libraries.places.internal.zzsz) r10)
            r13 = 0
            goto L_0x05c1
        L_0x0240:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zze(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0254:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzj(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0268:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzg(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x027c:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzl(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0290:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzm(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02a4:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzi(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02b8:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzn(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02cc:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzk(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02e0:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzf(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x02f4:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzh(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0308:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzd(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x031c:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzc(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0330:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.libraries.places.internal.zzul) r2, (boolean) r10)
            r13 = 0
            goto L_0x05c1
        L_0x0344:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 1
            com.google.android.libraries.places.internal.zztb.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.libraries.places.internal.zzul) r2, (boolean) r10)
            r13 = 0
            goto L_0x05c1
        L_0x0358:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zze(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x036c:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzj(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0380:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzg(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0394:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzl(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x03a8:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzm(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x03bc:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzi(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x03d0:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zzb((int) r4, (java.util.List<com.google.android.libraries.places.internal.zzqa>) r9, (com.google.android.libraries.places.internal.zzul) r2)
            r13 = 0
            goto L_0x05c1
        L_0x03e3:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zzsz r10 = r0.zza((int) r12)
            com.google.android.libraries.places.internal.zztb.zza((int) r4, (java.util.List<?>) r9, (com.google.android.libraries.places.internal.zzul) r2, (com.google.android.libraries.places.internal.zzsz) r10)
            r13 = 0
            goto L_0x05c1
        L_0x03fb:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.libraries.places.internal.zztb.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.libraries.places.internal.zzul) r2)
            r13 = 0
            goto L_0x05c1
        L_0x040e:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzn(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0422:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzk(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0436:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzf(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x044a:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzh(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x045e:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzd(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0472:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzc(r4, r9, r2, r10)
            r13 = 0
            goto L_0x05c1
        L_0x0486:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r10 = 0
            com.google.android.libraries.places.internal.zztb.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.libraries.places.internal.zzul) r2, (boolean) r10)
            r13 = 0
            goto L_0x05c1
        L_0x049a:
            r12 = r17
            int[] r4 = r0.zzc
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.libraries.places.internal.zztb.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.libraries.places.internal.zzul) r2, (boolean) r13)
            goto L_0x05c1
        L_0x04ad:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.libraries.places.internal.zzsz r9 = r0.zza((int) r12)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.zzsz) r9)
            goto L_0x05c1
        L_0x04c1:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            long r9 = r8.getLong(r1, r9)
            r2.zze((int) r14, (long) r9)
            goto L_0x05c1
        L_0x04d0:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zzf(r14, r4)
            goto L_0x05c1
        L_0x04df:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            long r9 = r8.getLong(r1, r9)
            r2.zzb((int) r14, (long) r9)
            goto L_0x05c1
        L_0x04ee:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zza((int) r14, (int) r4)
            goto L_0x05c1
        L_0x04fd:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zzb((int) r14, (int) r4)
            goto L_0x05c1
        L_0x050c:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zze((int) r14, (int) r4)
            goto L_0x05c1
        L_0x051b:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.libraries.places.internal.zzqa r4 = (com.google.android.libraries.places.internal.zzqa) r4
            r2.zza((int) r14, (com.google.android.libraries.places.internal.zzqa) r4)
            goto L_0x05c1
        L_0x052c:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.libraries.places.internal.zzsz r9 = r0.zza((int) r12)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.zzsz) r9)
            goto L_0x05c1
        L_0x053f:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.libraries.places.internal.zzul) r2)
            goto L_0x05c1
        L_0x054e:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            boolean r4 = com.google.android.libraries.places.internal.zztx.zzc(r1, r9)
            r2.zza((int) r14, (boolean) r4)
            goto L_0x05c1
        L_0x055e:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zzd((int) r14, (int) r4)
            goto L_0x05c1
        L_0x056c:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            long r9 = r8.getLong(r1, r9)
            r2.zzd((int) r14, (long) r9)
            goto L_0x05c1
        L_0x057a:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            int r4 = r8.getInt(r1, r9)
            r2.zzc((int) r14, (int) r4)
            goto L_0x05c1
        L_0x0588:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            long r9 = r8.getLong(r1, r9)
            r2.zzc((int) r14, (long) r9)
            goto L_0x05c1
        L_0x0596:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            long r9 = r8.getLong(r1, r9)
            r2.zza((int) r14, (long) r9)
            goto L_0x05c1
        L_0x05a4:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            float r4 = com.google.android.libraries.places.internal.zztx.zzd(r1, r9)
            r2.zza((int) r14, (float) r4)
            goto L_0x05c1
        L_0x05b3:
            r12 = r17
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x05c1
            double r9 = com.google.android.libraries.places.internal.zztx.zze(r1, r9)
            r2.zza((int) r14, (double) r9)
        L_0x05c1:
            int r10 = r12 + 3
            goto L_0x0030
        L_0x05c5:
            if (r5 == 0) goto L_0x05dc
            com.google.android.libraries.places.internal.zzqr<?> r4 = r0.zzr
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x05da
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x05c5
        L_0x05da:
            r5 = 0
            goto L_0x05c5
        L_0x05dc:
            com.google.android.libraries.places.internal.zztr<?, ?> r0 = r0.zzq
            zza(r0, r1, (com.google.android.libraries.places.internal.zzul) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzsq.zzb(java.lang.Object, com.google.android.libraries.places.internal.zzul):void");
    }

    private final <K, V> void zza(zzul zzul, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzul.zza(i, this.zzs.zzc(zzb(i2)), this.zzs.zza(obj));
        }
    }

    private static <UT, UB> void zza(zztr<UT, UB> zztr, T t, zzul zzul) throws IOException {
        zztr.zza(zztr.zza(t), zzul);
    }

    private final zzsz zza(int i) {
        int i2 = (i / 3) << 1;
        zzsz zzsz = (zzsz) this.zzd[i2];
        if (zzsz != null) {
            return zzsz;
        }
        zzsz zza2 = zzsy.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    public final void zzb(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzc2 = (long) (zzc(this.zzl[i2]) & 1048575);
            Object zzf2 = zztx.zzf(t, zzc2);
            if (zzf2 != null) {
                zztx.zza((Object) t, zzc2, this.zzs.zzb(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zza(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzb(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    public final boolean zzc(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzm) {
                return !this.zzh || this.zzr.zza((Object) t).zzf();
            }
            int i5 = this.zzl[i3];
            int i6 = this.zzc[i5];
            int zzc2 = zzc(i5);
            if (!this.zzj) {
                int i7 = this.zzc[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzb.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzc2) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzc2) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzc2, zza(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zza2 = this.zzs.zza(zztx.zzf(t, (long) (zzc2 & 1048575)));
                            if (!zza2.isEmpty()) {
                                if (this.zzs.zzc(zzb(i5)).zzb.zza() == zzum.MESSAGE) {
                                    zzsz<?> zzsz = null;
                                    Iterator<?> it = zza2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzsz == null) {
                                            zzsz = zzsy.zza().zza(next.getClass());
                                        }
                                        if (!zzsz.zzc(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zztx.zzf(t, (long) (zzc2 & 1048575));
                if (!list.isEmpty()) {
                    zzsz zza3 = zza(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zza3.zzc(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzc2, zza(i5))) {
                return false;
            }
            i3++;
        }
    }

    private static boolean zza(Object obj, int i, zzsz zzsz) {
        return zzsz.zzc(zztx.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzul zzul) throws IOException {
        if (obj instanceof String) {
            zzul.zza(i, (String) obj);
        } else {
            zzul.zza(i, (zzqa) obj);
        }
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private final int zzd(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zztx.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zztx.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zztx.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zztx.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zztx.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzj) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzj) {
            int zzc2 = zzc(i);
            long j = (long) (zzc2 & 1048575);
            switch ((zzc2 & 267386880) >>> 20) {
                case 0:
                    return zztx.zze(t, j) != 0.0d;
                case 1:
                    return zztx.zzd(t, j) != 0.0f;
                case 2:
                    return zztx.zzb(t, j) != 0;
                case 3:
                    return zztx.zzb(t, j) != 0;
                case 4:
                    return zztx.zza((Object) t, j) != 0;
                case 5:
                    return zztx.zzb(t, j) != 0;
                case 6:
                    return zztx.zza((Object) t, j) != 0;
                case 7:
                    return zztx.zzc(t, j);
                case 8:
                    Object zzf2 = zztx.zzf(t, j);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzqa) {
                        return !zzqa.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zztx.zzf(t, j) != null;
                case 10:
                    return !zzqa.zza.equals(zztx.zzf(t, j));
                case IBulkCursor.RESPOND_TRANSACTION /*11*/:
                    return zztx.zza((Object) t, j) != 0;
                case IBulkCursor.CLOSE_TRANSACTION /*12*/:
                    return zztx.zza((Object) t, j) != 0;
                case 13:
                    return zztx.zza((Object) t, j) != 0;
                case 14:
                    return zztx.zzb(t, j) != 0;
                case 15:
                    return zztx.zza((Object) t, j) != 0;
                case 16:
                    return zztx.zzb(t, j) != 0;
                case 17:
                    return zztx.zzf(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzd2 = zzd(i);
            return (zztx.zza((Object) t, (long) (zzd2 & 1048575)) & (1 << (zzd2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzj) {
            int zzd2 = zzd(i);
            long j = (long) (zzd2 & 1048575);
            zztx.zza((Object) t, j, zztx.zza((Object) t, j) | (1 << (zzd2 >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zztx.zza((Object) t, (long) (zzd(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zztx.zza((Object) t, (long) (zzd(i2) & 1048575), i);
    }
}
