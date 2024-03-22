package com.tealium.collect.listeners;

import com.tealium.collect.attribute.BadgeAttribute;

public interface BadgeUpdateListener extends CollectUpdateListener {
    void onBadgeUpdate(BadgeAttribute badgeAttribute, BadgeAttribute badgeAttribute2);
}
