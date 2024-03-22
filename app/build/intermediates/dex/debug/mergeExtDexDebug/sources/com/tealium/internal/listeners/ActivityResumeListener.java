package com.tealium.internal.listeners;

import android.app.Activity;

public interface ActivityResumeListener extends MainListener {
    void onActivityResume(Activity activity);
}
