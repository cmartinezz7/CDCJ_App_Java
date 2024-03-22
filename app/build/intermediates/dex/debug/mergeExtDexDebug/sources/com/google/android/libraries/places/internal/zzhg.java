package com.google.android.libraries.places.internal;

import java.util.Map;
import kotlin.UByte;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzhg<K, V> extends zzha<K, V> {
    private static final zzha<Object, Object> zza = new zzhg((Object) null, new Object[0], 0);
    private final transient Object zzb;
    private final transient Object[] zzc;
    private final transient int zzd;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: short[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: byte[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        r2[r6] = (byte) r3;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c8, code lost:
        r2[r6] = (short) r3;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0101, code lost:
        r2[r7] = r4;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <K, V> com.google.android.libraries.places.internal.zzhg<K, V> zza(int r10, java.lang.Object[] r11) {
        /*
            if (r10 != 0) goto L_0x0007
            com.google.android.libraries.places.internal.zzha<java.lang.Object, java.lang.Object> r10 = zza
            com.google.android.libraries.places.internal.zzhg r10 = (com.google.android.libraries.places.internal.zzhg) r10
            return r10
        L_0x0007:
            r0 = 0
            r1 = 0
            r2 = 1
            if (r10 != r2) goto L_0x0019
            r10 = r11[r1]
            r1 = r11[r2]
            com.google.android.libraries.places.internal.zzgn.zza(r10, r1)
            com.google.android.libraries.places.internal.zzhg r10 = new com.google.android.libraries.places.internal.zzhg
            r10.<init>(r0, r11, r2)
            return r10
        L_0x0019:
            int r3 = r11.length
            int r3 = r3 >> r2
            com.google.android.libraries.places.internal.zzgg.zzb((int) r10, (int) r3)
            r3 = 2
            int r3 = java.lang.Math.max(r10, r3)
            r4 = 751619276(0x2ccccccc, float:5.8207657E-12)
            r5 = 1073741824(0x40000000, float:2.0)
            if (r3 >= r4) goto L_0x0043
            int r4 = r3 + -1
            int r4 = java.lang.Integer.highestOneBit(r4)
            int r4 = r4 << r2
            r5 = r4
        L_0x0033:
            double r6 = (double) r5
            r8 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            double r6 = r6 * r8
            double r8 = (double) r3
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x0042
            int r5 = r5 << 1
            goto L_0x0033
        L_0x0042:
            goto L_0x004e
        L_0x0043:
            if (r3 >= r5) goto L_0x0047
            r3 = r2
            goto L_0x0048
        L_0x0047:
            r3 = r1
        L_0x0048:
            java.lang.String r4 = "collection too large"
            com.google.android.libraries.places.internal.zzgg.zza((boolean) r3, (java.lang.Object) r4)
        L_0x004e:
            if (r10 != r2) goto L_0x005b
            r1 = r11[r1]
            r2 = r11[r2]
            com.google.android.libraries.places.internal.zzgn.zza(r1, r2)
            goto L_0x0118
        L_0x005b:
            int r0 = r5 + -1
            r2 = 128(0x80, float:1.794E-43)
            r3 = -1
            if (r5 > r2) goto L_0x009f
            byte[] r2 = new byte[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x0068:
            if (r1 >= r10) goto L_0x009c
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.libraries.places.internal.zzgn.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.libraries.places.internal.zzgt.zza(r6)
        L_0x007d:
            r6 = r6 & r0
            byte r7 = r2[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x008c
            byte r3 = (byte) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x0068
        L_0x008c:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0097
            int r6 = r6 + 1
            goto L_0x007d
        L_0x0097:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x009c:
            r0 = r2
            goto L_0x0118
        L_0x009f:
            r2 = 32768(0x8000, float:4.5918E-41)
            if (r5 > r2) goto L_0x00e1
            short[] r2 = new short[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x00aa:
            if (r1 >= r10) goto L_0x00df
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.libraries.places.internal.zzgn.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.libraries.places.internal.zzgt.zza(r6)
        L_0x00bf:
            r6 = r6 & r0
            short r7 = r2[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x00cf
            short r3 = (short) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x00aa
        L_0x00cf:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00da
            int r6 = r6 + 1
            goto L_0x00bf
        L_0x00da:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x00df:
            r0 = r2
            goto L_0x0118
        L_0x00e1:
            int[] r2 = new int[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x00e7:
            if (r1 >= r10) goto L_0x0117
            int r4 = r1 * 2
            r5 = r11[r4]
            r6 = r4 ^ 1
            r6 = r11[r6]
            com.google.android.libraries.places.internal.zzgn.zza(r5, r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.libraries.places.internal.zzgt.zza(r7)
        L_0x00fc:
            r7 = r7 & r0
            r8 = r2[r7]
            if (r8 != r3) goto L_0x0107
            r2[r7] = r4
            int r1 = r1 + 1
            goto L_0x00e7
        L_0x0107:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x0112
            int r7 = r7 + 1
            goto L_0x00fc
        L_0x0112:
            java.lang.IllegalArgumentException r10 = zza(r5, r6, r11, r8)
            throw r10
        L_0x0117:
            r0 = r2
        L_0x0118:
            com.google.android.libraries.places.internal.zzhg r1 = new com.google.android.libraries.places.internal.zzhg
            r1.<init>(r0, r11, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzhg.zza(int, java.lang.Object[]):com.google.android.libraries.places.internal.zzhg");
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        return new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length()).append("Multiple entries with same key: ").append(valueOf).append("=").append(valueOf2).append(" and ").append(valueOf3).append("=").append(valueOf4).toString());
    }

    private zzhg(Object obj, Object[] objArr, int i) {
        this.zzb = obj;
        this.zzc = objArr;
        this.zzd = i;
    }

    public final int size() {
        return this.zzd;
    }

    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzb;
        V[] vArr = this.zzc;
        int i = this.zzd;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zza2 = zzgt.zza(obj.hashCode());
                while (true) {
                    int i2 = zza2 & length;
                    byte b = bArr[i2] & UByte.MAX_VALUE;
                    if (b == 255) {
                        return null;
                    }
                    if (vArr[b].equals(obj)) {
                        return vArr[b ^ 1];
                    }
                    zza2 = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zza3 = zzgt.zza(obj.hashCode());
                while (true) {
                    int i3 = zza3 & length2;
                    short s = sArr[i3] & UShort.MAX_VALUE;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    zza3 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zza4 = zzgt.zza(obj.hashCode());
                while (true) {
                    int i4 = zza4 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    zza4 = i4 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzhc<Map.Entry<K, V>> zza() {
        return new zzhf(this, this.zzc, 0, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzhc<K> zzb() {
        return new zzhh(this, new zzhk(this.zzc, 0, this.zzd));
    }

    /* access modifiers changed from: package-private */
    public final zzgw<V> zzc() {
        return new zzhk(this.zzc, 1, this.zzd);
    }
}
