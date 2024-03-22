package com.tealium.internal.listeners;

import com.tealium.internal.tagbridge.RemoteCommand;

public interface AddRemoteCommandListener extends MainListener {
    void onAddRemoteCommand(RemoteCommand remoteCommand);
}
