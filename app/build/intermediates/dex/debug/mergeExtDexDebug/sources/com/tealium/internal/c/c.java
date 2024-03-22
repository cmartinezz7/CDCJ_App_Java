package com.tealium.internal.c;

import com.tealium.internal.listeners.AddRemoteCommandListener;
import com.tealium.internal.tagbridge.RemoteCommand;

public final class c extends j<AddRemoteCommandListener> {
    private final RemoteCommand a;

    public c(RemoteCommand remoteCommand) {
        super(AddRemoteCommandListener.class);
        this.a = remoteCommand;
        if (remoteCommand == null) {
            throw new IllegalArgumentException();
        }
    }

    public void a(AddRemoteCommandListener addRemoteCommandListener) {
        addRemoteCommandListener.onAddRemoteCommand(this.a);
    }
}
