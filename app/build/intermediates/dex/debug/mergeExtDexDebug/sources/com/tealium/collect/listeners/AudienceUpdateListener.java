package com.tealium.collect.listeners;

import com.tealium.collect.attribute.AudienceAttribute;

public interface AudienceUpdateListener extends CollectUpdateListener {
    void onAudienceUpdate(AudienceAttribute audienceAttribute, AudienceAttribute audienceAttribute2);
}
