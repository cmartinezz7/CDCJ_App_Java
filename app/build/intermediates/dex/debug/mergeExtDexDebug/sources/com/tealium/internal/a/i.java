package com.tealium.internal.a;

import com.tealium.collect.listeners.VisitorProfileUpdateListener;
import com.tealium.collect.visitor.VisitorProfile;
import com.tealium.internal.c.j;

final class i extends j<VisitorProfileUpdateListener> {
    private final VisitorProfile a;
    private final VisitorProfile b;

    public i(VisitorProfile visitorProfile, VisitorProfile visitorProfile2) {
        super(VisitorProfileUpdateListener.class);
        this.a = visitorProfile;
        this.b = visitorProfile2;
    }

    public void a(VisitorProfileUpdateListener visitorProfileUpdateListener) {
        visitorProfileUpdateListener.onVisitorProfileUpdated(this.a, this.b);
    }
}
