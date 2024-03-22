package com.tealium.internal.c;

import com.tealium.internal.data.PublishSettings;
import com.tealium.internal.listeners.PublishSettingsUpdateListener;

public class l extends j<PublishSettingsUpdateListener> {
    private final PublishSettings a;

    public l(PublishSettings publishSettings) {
        super(PublishSettingsUpdateListener.class);
        this.a = publishSettings;
        if (publishSettings == null) {
            throw new IllegalArgumentException();
        }
    }

    public void a(PublishSettingsUpdateListener publishSettingsUpdateListener) {
        publishSettingsUpdateListener.onPublishSettingsUpdate(this.a);
    }
}
