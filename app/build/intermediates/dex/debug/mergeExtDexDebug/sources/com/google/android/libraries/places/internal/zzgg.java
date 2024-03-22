package com.google.android.libraries.places.internal;

import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzgg {
    public static void zza(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zza(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void zza(boolean z, @NullableDecl String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(zzgl.zza(str, Character.valueOf(c)));
        }
    }

    public static void zzb(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void zza(boolean z, @NullableDecl String str, int i) {
        if (!z) {
            throw new IllegalStateException(zzgl.zza(str, Integer.valueOf(i)));
        }
    }

    public static void zza(boolean z, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3) {
        if (!z) {
            throw new IllegalStateException(zzgl.zza(str, obj, obj2, obj3));
        }
    }

    @NonNullDecl
    public static <T> T zza(@NonNullDecl T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    @NonNullDecl
    public static <T> T zza(@NonNullDecl T t, @NullableDecl Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int zza(int i, int i2) {
        String str;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            str = zzgl.zza("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else if (i2 < 0) {
            throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(i2).toString());
        } else {
            str = zzgl.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(str);
    }

    public static int zzb(int i, int i2) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(zzb(i, i2, "index"));
    }

    public static int zza(int i, int i2, @NullableDecl String str) {
        if (i >= 0 && i <= i2) {
            return i;
        }
        throw new IndexOutOfBoundsException(zzb(i, i2, str));
    }

    private static String zzb(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return zzgl.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        } else if (i2 >= 0) {
            return zzgl.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(i2).toString());
        }
    }

    public static void zza(int i, int i2, int i3) {
        String str;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                str = zzb(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                str = zzb(i2, i3, "end index");
            } else {
                str = zzgl.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }
}
