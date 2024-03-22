package com.tealium.internal.a;

import com.tealium.collect.attribute.AttributeGroup;
import com.tealium.collect.attribute.BadgeAttribute;
import com.tealium.collect.listeners.BadgeUpdateListener;

final class c extends a<BadgeUpdateListener, BadgeAttribute> {
    public c(AttributeGroup<BadgeAttribute> attributeGroup, AttributeGroup<BadgeAttribute> attributeGroup2) {
        super(BadgeUpdateListener.class, attributeGroup, attributeGroup2);
    }

    public void a(BadgeUpdateListener badgeUpdateListener) {
        if (c() != null) {
            for (BadgeAttribute onBadgeUpdate : c()) {
                badgeUpdateListener.onBadgeUpdate(onBadgeUpdate, (BadgeAttribute) null);
            }
        }
        if (e() != null) {
            for (BadgeAttribute badgeAttribute : e()) {
                badgeUpdateListener.onBadgeUpdate((BadgeAttribute) b().get(badgeAttribute.getId()), badgeAttribute);
            }
        }
        if (d() != null) {
            for (BadgeAttribute onBadgeUpdate2 : d()) {
                badgeUpdateListener.onBadgeUpdate((BadgeAttribute) null, onBadgeUpdate2);
            }
        }
    }
}
