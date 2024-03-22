package com.tealium.internal.c;

import android.app.Activity;
import com.tealium.internal.listeners.ActivityPauseListener;

public class a extends j<ActivityPauseListener> {
    private final Activity a;

    public a(Activity activity) {
        super(ActivityPauseListener.class);
        this.a = activity;
        if (activity == null) {
            throw new IllegalArgumentException();
        }
    }

    public void a(ActivityPauseListener activityPauseListener) {
        activityPauseListener.onActivityPause(this.a);
    }
}
