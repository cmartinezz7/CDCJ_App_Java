package com.tealium.collect.listeners;

import com.tealium.collect.visitor.VisitorProfile;

public interface VisitorProfileUpdateListener extends CollectUpdateListener {
    void onVisitorProfileUpdated(VisitorProfile visitorProfile, VisitorProfile visitorProfile2);
}
