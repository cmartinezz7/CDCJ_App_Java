package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzst {
    private static final zzsr zza = zzc();
    private static final zzsr zzb = new zzsu();

    static zzsr zza() {
        return zza;
    }

    static zzsr zzb() {
        return zzb;
    }

    private static zzsr zzc() {
        try {
            return (zzsr) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
