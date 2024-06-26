package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.zzpt;
import com.google.android.libraries.places.internal.zzpu;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public abstract class zzpt<MessageType extends zzpu<MessageType, BuilderType>, BuilderType extends zzpt<MessageType, BuilderType>> implements zzsl {
    /* renamed from: zza */
    public abstract BuilderType clone();

    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public final /* synthetic */ zzsl zza(zzsm zzsm) {
        if (zzm().getClass().isInstance(zzsm)) {
            return zza((zzpu) zzsm);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
