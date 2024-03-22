package com.tealium.internal.a;

import com.tealium.collect.attribute.AttributeGroup;
import com.tealium.collect.attribute.AudienceAttribute;
import com.tealium.collect.listeners.AudienceUpdateListener;

final class b extends a<AudienceUpdateListener, AudienceAttribute> {
    public b(AttributeGroup<AudienceAttribute> attributeGroup, AttributeGroup<AudienceAttribute> attributeGroup2) {
        super(AudienceUpdateListener.class, attributeGroup, attributeGroup2);
    }

    public void a(AudienceUpdateListener audienceUpdateListener) {
        if (c() != null) {
            for (AudienceAttribute onAudienceUpdate : c()) {
                audienceUpdateListener.onAudienceUpdate(onAudienceUpdate, (AudienceAttribute) null);
            }
        }
        if (e() != null) {
            for (AudienceAttribute audienceAttribute : e()) {
                audienceUpdateListener.onAudienceUpdate((AudienceAttribute) b().get(audienceAttribute.getId()), audienceAttribute);
            }
        }
        if (d() != null) {
            for (AudienceAttribute onAudienceUpdate2 : d()) {
                audienceUpdateListener.onAudienceUpdate((AudienceAttribute) null, onAudienceUpdate2);
            }
        }
    }
}
