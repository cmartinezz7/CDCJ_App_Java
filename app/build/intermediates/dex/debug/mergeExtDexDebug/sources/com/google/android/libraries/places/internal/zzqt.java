package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzqt {
    private static final zzqr<?> zza = new zzqu();
    private static final zzqr<?> zzb = zzc();

    private static zzqr<?> zzc() {
        try {
            return (zzqr) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    static zzqr<?> zza() {
        return zza;
    }

    static zzqr<?> zzb() {
        zzqr<?> zzqr = zzb;
        if (zzqr != null) {
            return zzqr;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
