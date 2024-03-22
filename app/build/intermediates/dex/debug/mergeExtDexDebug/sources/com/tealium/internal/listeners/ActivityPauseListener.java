package com.tealium.internal.listeners;

import android.app.Activity;

public interface ActivityPauseListener extends MainListener {
    void onActivityPause(Activity activity);
}
