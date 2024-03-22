package com.tealium.internal.a;

import com.tealium.collect.attribute.AttributeGroup;
import com.tealium.collect.attribute.FlagAttribute;
import com.tealium.collect.listeners.FlagUpdateListener;

final class e extends a<FlagUpdateListener, FlagAttribute> {
    public e(AttributeGroup<FlagAttribute> attributeGroup, AttributeGroup<FlagAttribute> attributeGroup2) {
        super(FlagUpdateListener.class, attributeGroup, attributeGroup2);
    }

    public void a(FlagUpdateListener flagUpdateListener) {
        if (c() != null) {
            for (FlagAttribute onFlagUpdate : c()) {
                flagUpdateListener.onFlagUpdate(onFlagUpdate, (FlagAttribute) null);
            }
        }
        if (e() != null) {
            for (FlagAttribute flagAttribute : e()) {
                flagUpdateListener.onFlagUpdate((FlagAttribute) b().get(flagAttribute.getId()), flagAttribute);
            }
        }
        if (d() != null) {
            for (FlagAttribute onFlagUpdate2 : d()) {
                flagUpdateListener.onFlagUpdate((FlagAttribute) null, onFlagUpdate2);
            }
        }
    }
}
