package com.google.android.libraries.places.internal;

import java.lang.reflect.Type;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public enum zzqx {
    DOUBLE(0, zzqz.SCALAR, zzrn.DOUBLE),
    FLOAT(1, zzqz.SCALAR, zzrn.FLOAT),
    INT64(2, zzqz.SCALAR, zzrn.LONG),
    UINT64(3, zzqz.SCALAR, zzrn.LONG),
    INT32(4, zzqz.SCALAR, zzrn.INT),
    FIXED64(5, zzqz.SCALAR, zzrn.LONG),
    FIXED32(6, zzqz.SCALAR, zzrn.INT),
    BOOL(7, zzqz.SCALAR, zzrn.BOOLEAN),
    STRING(8, zzqz.SCALAR, zzrn.STRING),
    MESSAGE(9, zzqz.SCALAR, zzrn.MESSAGE),
    BYTES(10, zzqz.SCALAR, zzrn.BYTE_STRING),
    UINT32(11, zzqz.SCALAR, zzrn.INT),
    ENUM(12, zzqz.SCALAR, zzrn.ENUM),
    SFIXED32(13, zzqz.SCALAR, zzrn.INT),
    SFIXED64(14, zzqz.SCALAR, zzrn.LONG),
    SINT32(15, zzqz.SCALAR, zzrn.INT),
    SINT64(16, zzqz.SCALAR, zzrn.LONG),
    GROUP(17, zzqz.SCALAR, zzrn.MESSAGE),
    DOUBLE_LIST(18, zzqz.VECTOR, zzrn.DOUBLE),
    FLOAT_LIST(19, zzqz.VECTOR, zzrn.FLOAT),
    INT64_LIST(20, zzqz.VECTOR, zzrn.LONG),
    UINT64_LIST(21, zzqz.VECTOR, zzrn.LONG),
    INT32_LIST(22, zzqz.VECTOR, zzrn.INT),
    FIXED64_LIST(23, zzqz.VECTOR, zzrn.LONG),
    FIXED32_LIST(24, zzqz.VECTOR, zzrn.INT),
    BOOL_LIST(25, zzqz.VECTOR, zzrn.BOOLEAN),
    STRING_LIST(26, zzqz.VECTOR, zzrn.STRING),
    MESSAGE_LIST(27, zzqz.VECTOR, zzrn.MESSAGE),
    BYTES_LIST(28, zzqz.VECTOR, zzrn.BYTE_STRING),
    UINT32_LIST(29, zzqz.VECTOR, zzrn.INT),
    ENUM_LIST(30, zzqz.VECTOR, zzrn.ENUM),
    SFIXED32_LIST(31, zzqz.VECTOR, zzrn.INT),
    SFIXED64_LIST(32, zzqz.VECTOR, zzrn.LONG),
    SINT32_LIST(33, zzqz.VECTOR, zzrn.INT),
    SINT64_LIST(34, zzqz.VECTOR, zzrn.LONG),
    DOUBLE_LIST_PACKED(35, zzqz.PACKED_VECTOR, zzrn.DOUBLE),
    FLOAT_LIST_PACKED(36, zzqz.PACKED_VECTOR, zzrn.FLOAT),
    INT64_LIST_PACKED(37, zzqz.PACKED_VECTOR, zzrn.LONG),
    UINT64_LIST_PACKED(38, zzqz.PACKED_VECTOR, zzrn.LONG),
    INT32_LIST_PACKED(39, zzqz.PACKED_VECTOR, zzrn.INT),
    FIXED64_LIST_PACKED(40, zzqz.PACKED_VECTOR, zzrn.LONG),
    FIXED32_LIST_PACKED(41, zzqz.PACKED_VECTOR, zzrn.INT),
    BOOL_LIST_PACKED(42, zzqz.PACKED_VECTOR, zzrn.BOOLEAN),
    UINT32_LIST_PACKED(43, zzqz.PACKED_VECTOR, zzrn.INT),
    ENUM_LIST_PACKED(44, zzqz.PACKED_VECTOR, zzrn.ENUM),
    SFIXED32_LIST_PACKED(45, zzqz.PACKED_VECTOR, zzrn.INT),
    SFIXED64_LIST_PACKED(46, zzqz.PACKED_VECTOR, zzrn.LONG),
    SINT32_LIST_PACKED(47, zzqz.PACKED_VECTOR, zzrn.INT),
    SINT64_LIST_PACKED(48, zzqz.PACKED_VECTOR, zzrn.LONG),
    GROUP_LIST(49, zzqz.VECTOR, zzrn.MESSAGE),
    MAP(50, zzqz.MAP, zzrn.VOID);
    
    private static final zzqx[] zzbe = null;
    private static final Type[] zzbf = null;
    private final zzrn zzaz;
    private final int zzba;
    private final zzqz zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r5 = com.google.android.libraries.places.internal.zzra.zzb[r6.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzqx(int r4, com.google.android.libraries.places.internal.zzqz r5, com.google.android.libraries.places.internal.zzrn r6) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r1.zzba = r4
            r1.zzbb = r5
            r1.zzaz = r6
            int[] r2 = com.google.android.libraries.places.internal.zzra.zza
            int r3 = r5.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x0022
            if (r2 == r3) goto L_0x001b
            r2 = 0
            r1.zzbc = r2
            goto L_0x0029
        L_0x001b:
            java.lang.Class r2 = r6.zza()
            r1.zzbc = r2
            goto L_0x0029
        L_0x0022:
            java.lang.Class r2 = r6.zza()
            r1.zzbc = r2
        L_0x0029:
            r2 = 0
            com.google.android.libraries.places.internal.zzqz r0 = com.google.android.libraries.places.internal.zzqz.SCALAR
            if (r5 != r0) goto L_0x003e
            int[] r5 = com.google.android.libraries.places.internal.zzra.zzb
            int r6 = r6.ordinal()
            r5 = r5[r6]
            if (r5 == r4) goto L_0x003e
            if (r5 == r3) goto L_0x003e
            r3 = 3
            if (r5 == r3) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r4 = r2
        L_0x003f:
            r1.zzbd = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzqx.<init>(java.lang.String, int, int, com.google.android.libraries.places.internal.zzqz, com.google.android.libraries.places.internal.zzrn):void");
    }

    public final int zza() {
        return this.zzba;
    }

    static {
        int i;
        zzbf = new Type[0];
        zzqx[] values = values();
        zzbe = new zzqx[values.length];
        for (zzqx zzqx : values) {
            zzbe[zzqx.zzba] = zzqx;
        }
    }
}
