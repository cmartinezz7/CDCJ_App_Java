package com.tealium.internal.c;

import com.tealium.internal.listeners.RemoveRemoteCommandListener;
import com.tealium.internal.tagbridge.RemoteCommand;

public final class m extends j<RemoveRemoteCommandListener> {
    private final RemoteCommand a;

    public m(RemoteCommand remoteCommand) {
        super(RemoveRemoteCommandListener.class);
        this.a = remoteCommand;
        if (remoteCommand == null) {
            throw new IllegalArgumentException();
        }
    }

    public void a(RemoveRemoteCommandListener removeRemoteCommandListener) {
        removeRemoteCommandListener.onRemoveRemoteCommand(this.a);
    }
}
