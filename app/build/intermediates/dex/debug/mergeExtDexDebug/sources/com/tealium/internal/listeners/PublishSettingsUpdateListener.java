package com.tealium.internal.listeners;

import com.tealium.internal.data.PublishSettings;

public interface PublishSettingsUpdateListener extends BackgroundListener {
    void onPublishSettingsUpdate(PublishSettings publishSettings);
}
