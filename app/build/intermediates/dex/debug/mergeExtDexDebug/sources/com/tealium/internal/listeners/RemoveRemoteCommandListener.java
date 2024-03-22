package com.tealium.internal.listeners;

import com.tealium.internal.tagbridge.RemoteCommand;

public interface RemoveRemoteCommandListener extends MainListener {
    void onRemoveRemoteCommand(RemoteCommand remoteCommand);
}
