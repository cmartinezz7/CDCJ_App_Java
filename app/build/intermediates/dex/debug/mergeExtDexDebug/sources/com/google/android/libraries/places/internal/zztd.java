package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zztd extends zzte<FieldDescriptorType, Object> {
    zztd(int i) {
        super(i, (zztd) null);
    }

    public final void zza() {
        if (!zzb()) {
            for (int i = 0; i < zzc(); i++) {
                Map.Entry zzb = zzb(i);
                if (((zzqy) zzb.getKey()).zzd()) {
                    zzb.setValue(Collections.unmodifiableList((List) zzb.getValue()));
                }
            }
            for (Map.Entry entry : zzd()) {
                if (((zzqy) entry.getKey()).zzd()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
